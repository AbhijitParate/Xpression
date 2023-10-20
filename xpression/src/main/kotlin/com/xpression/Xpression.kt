package com.xpression

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

    private val config: Config by lazy { Config() }

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

    private val defaultContext: XpressionContext by lazy { XpressionContext.DEFAULT }

    fun evaluate(context: XpressionContext = defaultContext): Result {
        return try {
            createVisitor(context).visit(parseTree) as Result
        } catch (e: Exception) {
            Result.Error(e.localizedMessage.orEmpty(), e)
        }
    }

    private fun createVisitor(context: XpressionContext): Visitor {
        return Visitor(context, config.componentsProvider)
    }

    class Config {

        private val standardOperatorList: MutableList<Operator> by lazy {
            mutableListOf(
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

        private val standardFunctionsList: MutableList<Function> by lazy {
            mutableListOf(
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

        internal val componentsProvider by lazy {
            Provider.Builder()
                .addOperator(*standardOperatorList.toTypedArray())
                .addFunction(*standardFunctionsList.toTypedArray())
                .addFunction(*customFunctionList.toTypedArray())
                .build()
        }

        internal var errorLogging: Boolean = false

        fun enableErrorLogging() {
            errorLogging = true
        }

        fun disableErrorLogging() {
            errorLogging = false
        }

        /**
         * Removes all custom function implementations
         */
        fun reset() {
            customFunctionList.clear()
        }

        /**
         * Adds custom function implementations
         */
        fun addFunction(vararg function: Function): Boolean {
            return customFunctionList.addAll(function)
        }

        /**
         * Overrides default implementation for function
         */
        fun overrideFunction(vararg function: Function) {
            function.forEach { newFunction ->
                standardFunctionsList.removeAll { it.name == newFunction.name }
                standardFunctionsList.add(newFunction)
            }
        }

        /**
         * Overrides default implementation for operator
         */
        fun overrideOperator(vararg operator: Operator) {
            operator.forEach { new ->
                standardOperatorList.removeAll { it.name == new.name }
                standardOperatorList.add(new)
            }
        }
    }

    private fun String.toExpressionParser(): XpressionParser {
        val inputStream = ByteArrayInputStream(toByteArray(StandardCharsets.UTF_8))
        val charStream = CharStreams.fromStream(inputStream, StandardCharsets.UTF_8)
        val lexer = XpressionLexer(charStream).apply {
            if (!config.errorLogging) removeErrorListener(ConsoleErrorListener.INSTANCE)
        }
        val tokens = CommonTokenStream(lexer)
        return XpressionParser(tokens)
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

    sealed class Result(val value: Any?) : XpressionElement() {

        class Value(val type: DataType, value: Any?) : Result(value = value) {
            constructor(number: Number) : this(DataType.Number, number)
            constructor(string: String) : this(DataType.Text, string)
            constructor(boolean: Boolean) : this(DataType.Boolean, boolean)
        }

        class Error(val error: String, throwable: Throwable? = null) : Result(throwable)

        val isError: Boolean by lazy { this is Error }
        val message: String? by lazy { (this as? Error)?.error }

        val isNumber: Boolean by lazy { if (isError) false else (this as Value).value is Number }
        val asNumber: Number by lazy { (this as Value).value as Number }

        val isString: Boolean by lazy { if (isError) false else (this as Value).value is String }
        val asString: String by lazy { (this as Value).value as String }

        val isBoolean: Boolean by lazy { if (isError) false else (this as Value).value is Boolean }
        val asBoolean: Boolean by lazy { (this as Value).value as Boolean }

        val isNull: Boolean by lazy { this is Value && type == DataType.None }

        override fun toString(): String {
            if (isError) return value.toString()
            this as Value
            return "$type($value)"
        }

        companion object {
            fun anyErrors(vararg results: Result): Result? = results.firstOrNull { it.isError }
            fun nullValue() = Value(DataType.None, null)
        }
    }
}