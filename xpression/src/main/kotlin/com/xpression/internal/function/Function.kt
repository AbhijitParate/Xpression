package com.xpression.internal.function

import com.xpression.XpressionContext
import com.xpression.XpressionElement.Result
import com.xpression.internal.Component
import com.xpression.internal.DataType
import com.xpression.internal.ExpressionParser.FunctionContext
import com.xpression.internal.XpressionVisitor

abstract class Function(
    final override val name: String,
    final override val argumentCount: Int = 0
) : Component {

    /**
     * Evaluate Function Expressions
     */
    internal fun evaluate(
        xpressionVisitor: XpressionVisitor,
        functionContext: FunctionContext,
        xpressionContext: XpressionContext
    ): Result {
        val argumentCount = functionContext.expression().size
        return validate(xpressionContext, argumentCount) ?: execute(xpressionContext, argumentCount) { index ->
            if (index in 0 until argumentCount) {
                return@execute xpressionVisitor.visit(functionContext.expression(index)) as Result
            }
            // index out of arguments bound
            return@execute Result.Error(
                incorrectArgumentIndex(
                    function = name,
                    expected = 0 until argumentCount,
                    received = index
                )
            )
        }
    }

    /**
     * Validate argument for errors
     *
     *  > Returns Result.Error on failure
     */
    protected open fun validate(argument: Result): Result? {
        if (argument.hasError) return argument as Result.Error
        return null
    }

    /**
     * Validate number of arguments
     *
     *  > Returns Result.Error on failure
     */
    protected open fun validate(xpressionContext: XpressionContext, count: Int): Result? {
        // we don't validate arguments to improve performance
        // by skipping unwanted sub-expressions evaluation
        return validateCount(count)
    }

    /**
     * Validate argument count
     */
    private fun validateCount(count: Int): Result? {
        if (validateArgumentCount(count)) return null
        return Result.Error(incorrectArguments(name, argumentCount, count))
    }

    /**
     *
     */
    override fun validateArgumentCount(count: Int): Boolean {
        return when {
            count == this.argumentCount -> true
            this.argumentCount == VARIABLE_ARGUMENT_COUNT -> true
            this.argumentCount == EVEN_ARGUMENT_COUNT && count % 2 == 0 -> true
            this.argumentCount == ODD_ARGUMENT_COUNT && count % 2 == 1 -> true
            else -> false
        }
    }

    /**
     * Execute with context and arguments
     */
    open fun execute(xpressionContext: XpressionContext, argumentCount: Int, arguments: (Int) -> Result): Result {
        return execute(xpressionContext)
    }

    /**
     * Execute with context
     */
    open fun execute(xpressionContext: XpressionContext): Result = execute()

    /**
     * Execute
     */
    open fun execute(): Result = Result.Error("Function not implemented : $name")

    protected fun ((Int) -> Result).fetch(index: Int) = this.invoke(index)

    companion object {

        fun incorrectArgumentIndex(function: String, expected: IntRange, received: Int): String {
            return ("Error: Invalid arguments access for Function('$function'). " +
                    "Expected - [%s], Received - [%s]").format(
                expected.joinToString(".."),
                received
            )
        }

        fun incorrectClass(function: String, expected: List<String>, received: List<String>): String {
            return toErrorMessage(function = function, received = received, expected = expected)
        }

        fun incorrectDataTypes(function: String, received: List<DataType>, expected: List<DataType>): String {
            return toErrorMessage(function = function, expected.map { it.type }, received.map { it.type })
        }

        fun incorrectArguments(function: String, expected: Int, received: Int): String {
            return toErrorMessage(function, expected, received)
        }

        private fun toErrorMessage(function: String, expected: List<String>, received: List<String>): String {
            return ("Error: Invalid arguments for function $function(). " +
                    "Expected - [%s], Received - [%s]").format(
                expected.joinToString(),
                received.joinToString()
            )
        }

        private fun toErrorMessage(function: String, expected: Int, received: Int): String {
            return ("Error: Invalid number of arguments for function $function(). " +
                    "Expected - [%d], Received - [%d]").format(expected, received)
        }

        const val VARIABLE_ARGUMENT_COUNT = -1
        const val EVEN_ARGUMENT_COUNT = -2
        const val ODD_ARGUMENT_COUNT = -3

        // Math
        internal const val ABSOLUTE = "Absolute"
        internal const val FLOOR = "Floor"
        internal const val CEILING = "Ceiling"
        // TODO: SUM(0...n)

        // Conditional
        internal const val IF = "IF"

        // Data
        internal const val IS_NULL = "IsNull"
        internal const val IS_BLANK = "IsBlank"
        internal const val IS_NUMBER = "IsNumber"
        internal const val IS_BOOLEAN = "IsBoolean"
        internal const val IS_TEXT = "IsText"

        // Logic
        internal const val NOT = "Not"
        internal const val AND = "And"
        internal const val OR = "Or"

        // Text
        internal const val LEN = "Len"
        internal const val CONTAINS = "Contains"
        internal const val TEXT = "Text"

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
    }
}