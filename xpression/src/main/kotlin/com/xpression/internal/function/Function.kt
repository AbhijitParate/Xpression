package com.xpression.internal.function

import com.xpression.XpressionElement
import com.xpression.XpressionContext
import com.xpression.XpressionElement.Result
import com.xpression.internal.*
import com.xpression.internal.ExpressionParser.ExpressionContext

abstract class Function(
    override val name: String,
    override val argumentCount: Int = 0
) : Component {

    open fun execute(
        xpressionVisitor: XpressionVisitor,
        xpressionContext: XpressionContext,
        vararg arguments: Result
    ): Result = execute(xpressionContext, *arguments)

    open fun execute(xpressionContext: XpressionContext, vararg arguments: XpressionElement): Result =
        execute(xpressionContext)

    open fun execute(formulaContext: XpressionContext): Result = execute()

    open fun execute(): Result = Result.Error("Function not implemented : $name")

    open fun evaluate(
        xpressionVisitor: XpressionVisitor,
        context: ExpressionParser.FunctionContext,
        xpressionContext: XpressionContext
    ): XpressionElement {
        validateMode(xpressionContext)?.let {
            return it
        }
        validateExpression(xpressionContext)?.let {
            return it
        }
        val expressions = context.expression()
        validateArgumentCount(expressions)?.let {
            return it
        }
        val xpressionElements: Array<Result>
        processArguments(expressions, xpressionVisitor, xpressionContext).let {
            xpressionElements = it
        }
        validateArguments(*xpressionElements)?.let {
            return it
        }
        execute(xpressionVisitor, xpressionContext, *xpressionElements).let {
            return it
        }
    }

    open fun validateMode(context: XpressionContext): Result? = null

    open fun validateExpression(context: XpressionContext): Result? = null

    protected open fun validateArgumentCount(expressions: List<ExpressionContext>): Result? {
        if (!validateArgumentCount(expressions.size)) {
            return Result.Error("Too many or less arguments for $name function")
        }
        return null
    }

    override fun validateArgumentCount(argumentCount: Int): Boolean {
        return when {
            argumentCount == this.argumentCount -> true
            this.argumentCount == VARIABLE_ARGUMENT_COUNT -> true
            this.argumentCount == EVEN_ARGUMENT_COUNT && argumentCount % 2 == 0 -> true
            this.argumentCount == ODD_ARGUMENT_COUNT && argumentCount % 2 == 1 -> true
            else -> false
        }
    }

    open fun processArguments(
        expressions: List<ExpressionContext>,
        visitor: XpressionVisitor,
        formulaContext: XpressionContext
    ) = expressions.map { visitor.visit(it) as Result }.toTypedArray()

    override fun validateArguments(vararg arguments: Result): Result? = super.validateArguments(*arguments)

    companion object {

        private const val INCORRECT_PARAMS_FOR_FUNCTION =
            "Incorrect parameter type for function '%s'. "
        private const val EXPECTED_RECEIVED = "Expected - %s, received - %s."

        fun invalidArguments(function: String): XpressionElement {
            return Result.Error("Incorrect argument type for function $function().")
        }

        fun incorrectParameters(
            function: String,
            received: Result.Value,
            expected: Result.Value
        ): XpressionElement {
            return Result.Error(
                toErrorMessage(function = function, received = received.type, expected = arrayOf(expected.type))
            )
        }

        fun incorrectParameters(
            function: String,
            received: Result.Value,
            vararg expected: DataType
        ): XpressionElement {
            return Result.Error(
                toErrorMessage(function = function, received = received.type, expected = expected)
            )
        }

        private fun toErrorMessage(function: String, received: DataType, vararg expected: DataType): String {
            return INCORRECT_PARAMS_FOR_FUNCTION.format(function) +
                    EXPECTED_RECEIVED.format(expected.joinToString(), received.name)
        }

        const val VARIABLE_ARGUMENT_COUNT = -1
        const val EVEN_ARGUMENT_COUNT = -2
        const val ODD_ARGUMENT_COUNT = -3

        // Conditional
        internal const val FUNCTION_IF = "IF"
        internal const val FUNCTION_CASE = "CASE"

        // Math
        internal const val FUNCTION_ABS = "ABS"
        internal const val FUNCTION_FLOOR = "FLOOR"
        internal const val FUNCTION_CEILING = "CEILING"
        internal const val FUNCTION_MOD = "MOD"

        // Logic
        internal const val FUNCTION_IS_BLANK = "ISBLANK"
        internal const val FUNCTION_BLANK_VALUE = "BLANKVALUE"
        internal const val FUNCTION_IS_NULL = "ISNULL"
        internal const val FUNCTION_NULL_VALUE = "NULLVALUE"
        internal const val FUNCTION_IS_NUMBER = "ISNUMBER"
        internal const val FUNCTION_IS_CHANGED = "ISCHANGED"
        internal const val FUNCTION_IS_NEW = "ISNEW"
        internal const val FUNCTION_PRIOR_VALUE = "PRIORVALUE"
        internal const val FUNCTION_NOT = "NOT"
        internal const val FUNCTION_AND = "AND"
        internal const val FUNCTION_OR = "OR"

        // Date and Time
        internal const val FUNCTION_DATE = "DATE"
        internal const val FUNCTION_DATE_VALUE = "DATEVALUE"
        internal const val FUNCTION_DATE_TIME_VALUE = "DATETIMEVALUE"
        internal const val FUNCTION_TODAY = "TODAY"
        internal const val FUNCTION_NOW = "NOW"
        internal const val FUNCTION_YEAR = "YEAR"
        internal const val FUNCTION_MONTH = "MONTH"
        internal const val FUNCTION_DAY = "DAY"
        internal const val FUNCTION_HOUR = "HOUR"
        internal const val FUNCTION_MINUTE = "MINUTE"
        internal const val FUNCTION_SECOND = "SECOND"
        internal const val FUNCTION_MILLISECOND = "MILLISECOND"

        // Text
        internal const val FUNCTION_TEXT = "TEXT"
        internal const val FUNCTION_BEGINS = "BEGINS"
        internal const val FUNCTION_CONTAINS = "CONTAINS"
        internal const val FUNCTION_REGEX = "REGEX"
        internal const val FUNCTION_LEN = "LEN"
        internal const val FUNCTION_IS_PICKVAL = "ISPICKVAL"
    }
}