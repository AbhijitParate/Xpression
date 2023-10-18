package com.xpression

import com.xpression.internal.ExpressionLexer
import com.xpression.internal.ExpressionParser
import com.xpression.internal.XpressionVisitor
import com.xpression.internal.Provider
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

    private val parser: ExpressionParser by lazy {
        expression.toExpressionParser().apply {
            addErrorListener(errorListener)
        }
    }

    private val parseTree by lazy { parser.root() }

    private val errorListener by lazy { ExpressionErrorListener() }

    fun evaluate(context: XpressionContext): XpressionElement {
        return createVisitor(context).visit(parseTree)
    }

    private fun createVisitor(context: XpressionContext): XpressionVisitor {
        return XpressionVisitor(context, COMPONENTS_PROVIDER.build())
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

            private val errorMessages: MutableList<String> = mutableListOf()

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

        private val COMPONENTS_PROVIDER by lazy {
            Provider.Builder()
                .addOperator(*standardOperatorList.toTypedArray())
                .addFunction(*standardFunctionsList.toTypedArray())
                .addFunction(*customFunctionList.toTypedArray())
        }

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
    }
}