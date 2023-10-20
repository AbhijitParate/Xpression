package com.xpression

import com.xpression.ResettableLazyManager.Companion.resettableLazy
import com.xpression.internal.*
import com.xpression.internal.function.*
import com.xpression.internal.function.Function
import com.xpression.internal.operator.Arithmetic
import com.xpression.internal.operator.Comparison
import com.xpression.internal.operator.Logical
import com.xpression.internal.operator.Operator
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets
import java.util.*

class Xpression(private val expression: String) {

    private val parser by lazy {
        expression.toExpressionParser().apply {
            removeErrorListeners()
            addErrorListener(errorListener)
            errorHandler = object : DefaultErrorStrategy() {
                override fun recover(recognizer: Parser, e: RecognitionException) = throw e
                override fun recoverInline(recognizer: Parser) = throw RuntimeException(
                    "Error: Invalid character '${recognizer.currentToken.text}'" +
                            " at [${recognizer.currentToken.line}:${recognizer.currentToken.charPositionInLine}]"
                )
            }
        }
    }

    private val parseTree by lazy { parser.root() }

    private val errorListener by lazy { ExpressionErrorListener() }

    fun evaluate(context: XpressionContext = XpressionContext.DEFAULT): XpressionElement {
        return try {
            createVisitor(context).visit(parseTree)
        } catch (e: Exception) {
            Result.Error(e.localizedMessage)
        }
    }

    private fun createVisitor(context: XpressionContext): Visitor {
        return Visitor(context, COMPONENTS_PROVIDER.build())
    }

    companion object {

        private var ERROR_LOGGING = false

        fun enableErrorLogging() {
            ERROR_LOGGING = true
        }

        fun disableErrorLogging() {
            ERROR_LOGGING = false
        }

        private fun String.toExpressionParser(): ExpressionParser {
            val inputStream = ByteArrayInputStream(toByteArray(StandardCharsets.UTF_8))
            val charStream = CharStreams.fromStream(inputStream, StandardCharsets.UTF_8)
            val lexer = ExpressionLexer(charStream).apply {
                if (!ERROR_LOGGING) removeErrorListener(ConsoleErrorListener.INSTANCE)
            }
            val tokens = CommonTokenStream(lexer)
            return ExpressionParser(tokens)
        }

        private class ExpressionErrorListener : ANTLRErrorListener {

            val errorMessages: MutableList<String> = mutableListOf()

            override fun syntaxError(
                recognizer: Recognizer<*, *>,
                offendingSymbol: Any,
                line: Int,
                charPositionInLine: Int,
                msg: String?,
                e: RecognitionException?
            ) {
                errorMessages.add(msg.orEmpty())
            }

            override fun reportAmbiguity(
                recognizer: Parser?,
                dfa: DFA?,
                startIndex: Int,
                stopIndex: Int,
                exact: Boolean,
                ambigAlts: BitSet?,
                configs: ATNConfigSet?
            ) = Unit

            override fun reportAttemptingFullContext(
                recognizer: Parser?,
                dfa: DFA?,
                startIndex: Int,
                stopIndex: Int,
                conflictingAlts: BitSet?,
                configs: ATNConfigSet?
            ) = Unit

            override fun reportContextSensitivity(
                recognizer: Parser?,
                dfa: DFA?,
                startIndex: Int,
                stopIndex: Int,
                prediction: Int,
                configs: ATNConfigSet?
            ) = Unit

            fun hasErrors(): Boolean = errorMessages.any()


        }

        private val lazyManager: ResettableLazyManager by lazy { ResettableLazyManager() }

        private val standardOperatorList: List<Operator> by lazy {
            listOf(
                Arithmetic.ADDITION,                // +
                Arithmetic.SUBTRACTION,             // -
                Arithmetic.PRODUCT,                 // *
                Arithmetic.DIVISION,                // /
                Arithmetic.MODULO,                  // %
                Arithmetic.EXPONENTIATION,          // ^
                Comparison.LESS_THAN,               // <
                Comparison.LESS_THAN_OR_EQUAL,      // <=
                Comparison.GREATER_THAN,            // >
                Comparison.GREATER_THAN_OR_EQUAL,   // >=
                Comparison.EQUAL,                   // ==
                Comparison.UNEQUAL,                 // !=
                Logical.AND,                        // &&
                Logical.OR,                         // ||
                Logical.NOT,                        // ||
                Logical.TERNARY,                    // ?:
            )
        }

        private val standardFunctionsList: List<Function> by lazy {
            listOf(
//                // logic
                Logic.AND,
                Logic.OR,
                Logic.NOT,
//                // maths
                Math.ABSOLUTE,
                Math.SQRT,
                Math.FLOOR,
                Math.CEILING,
//                // conditional
//                Conditional.IF,
//                // data
                Data.IS_BLANK,
                Data.IS_NULL,
                Data.IS_NUMBER,
                Data.IS_TEXT,
                Data.IS_BOOLEAN,
//                // date
//                Date.DATE,
//                Date.DATE_VALUE,
//                Date.DATE_TIME_VALUE,
//                Date.TODAY,
//                Date.NOW,
//                Date.DAY,
//                Date.MONTH,
//                Date.YEAR,
//                // text
                Text.LEN,
                Text.CONTAINS,
                Text.TEXT,
//                Text.BEGINS,
//                Text.REGEX
            )
        }

        private val customFunctionList = mutableListOf<Function>()

        private val COMPONENTS_PROVIDER by resettableLazy(lazyManager) {
            Provider.Builder()
                .addOperator(*standardOperatorList.toTypedArray())
                .addFunction(*standardFunctionsList.toTypedArray())
                .addFunction(*customFunctionList.toTypedArray())
        }

        /**
         * Removes all custom function implementations
         */
        @Synchronized fun reset() {
            customFunctionList.clear()
            lazyManager.reset()
        }

        /**
         * Adds custom function implementations
         */
        fun addFunction(vararg function: Function): Boolean {
            return customFunctionList.addAll(function)
        }

        /**
         * Return default implementation for function
         */
        fun getDefaultFunction(functionName: String): Function? {
            return standardFunctionsList.find { it.name == functionName }
        }
    }

    sealed class XpressionElement {

        class Accessor(val symbol: String = "", vararg properties: Property) : XpressionElement() {
            val isSpecial: Boolean by lazy { symbol.isNotBlank() }
            val properties by lazy { properties }
        }

        class Property(name: String, val subscript: Result? = null) : Identifier(name) {
            // TODO: Add special properties like @, :, etc
            // val isSpecial: Boolean
        }

        open class Identifier(val name: String) : XpressionElement()
    }

    sealed class Result : XpressionElement() {

        class Value(val value: Any?, val type: DataType) : Result() {
            constructor(number: Number) : this(value = number, DataType.Number)
            constructor(string: String) : this(value = string, DataType.Text)
            constructor(boolean: Boolean) : this(value = boolean, DataType.Boolean)
        }

        class Error(val error: String) : Result()

        val hasError: Boolean by lazy { this is Error }

        val hasValue: Boolean by lazy { this is Value }

        val isNull: Boolean by lazy { this is Value && this.type == DataType.None }

        override fun toString(): String {
            if (this is Error) return error
            this as Value
            return "$type($value)"
        }

        companion object {
            fun anyErrors(vararg results: Result): Result? = results.firstOrNull { it.hasError }
            fun nullValue() = Value(null, DataType.None)
        }
    }
}