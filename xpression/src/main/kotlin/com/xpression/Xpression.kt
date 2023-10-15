package com.xpression

import com.xpression.internal.ExpressionLexer
import com.xpression.internal.ExpressionParser
import com.xpression.internal.XpressionVisitor
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
        return XpressionVisitor(context).visit(parseTree)
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
    }
}