package com.xpression.internal.operator

import com.xpression.Xpression.*
import com.xpression.internal.Component
import com.xpression.internal.DataType

abstract class Operator(final override val name: String, final override val argumentCount: Int) : Component {

    private val operator: String
        get() = name

    /**
     * Evaluate Expression
     */
    fun evaluate(vararg operands: Result): Result {
        return validate(arguments = operands) ?: when (operands.size) {
            // Unary Operators
            1 -> execute(argument = operands.first() as Result.Value)
            // Binary Operators
            2 -> execute(
                leftArgument = operands.first() as Result.Value,
                rightArgument = operands.last() as Result.Value
            )
            // Ternary Operators
            else -> {
                execute(arguments = operands.map { it as Result.Value }.toTypedArray())
            }
        }
    }

    /**
     * Validated arguments of binary expression
     *  - Check for errors
     *  - Validate number of arguments
     *  - Validate type of arguments (override)
     *
     *  > Returns Result.Error on failure
     */
    protected open fun validate(vararg arguments: Result): Result? {
        return validateCount(arguments = arguments) ?: validateArguments(arguments = arguments)
    }

    private fun validateCount(vararg arguments: Result): Result? {
        if (validateArgumentCount(arguments.size)) return null
        return Result.Error(incorrectArguments(operator, argumentCount, arguments.size))
    }

    override fun validateArgumentCount(count: Int): Boolean {
        return super.validateArgumentCount(count)
    }

    override fun validateArguments(vararg arguments: Result): Result? {
        return arguments.firstOrNull { it.hasError }
    }

    /**
     * Holds the actual logic to evaluate the expression
     */
    protected open fun execute(argument: Result.Value): Result {
        return unhandledExpression("Error: Unhandled operator ($operator).")
    }

    /**
     * Holds the actual logic to evaluate the expression
     */
    protected open fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
        return unhandledExpression("Error: Unhandled operator ($operator).")
    }

    /**
     * Holds the actual logic to evaluate the expression
     */
    protected open fun execute(vararg arguments: Result.Value): Result {
        return unhandledExpression("Error: Unhandled operator ($operator).")
    }

    companion object {

        const val INVALID_OPERAND_COUNT = -1
        const val UNARY_OPERAND_COUNT = 1
        const val BINARY_OPERAND_COUNT = 2
        const val TERNARY_OPERAND_COUNT = 3
        const val TERNARY_OPERATOR = "?:"
        private const val INCORRECT_PARAMS_FOR_OPERATOR = "Incorrect parameter type for operator '%s'. "

        fun unhandledExpression(expression: String): Result {
            return Result.Error("Unhandled expression : $expression")
        }

        fun incorrectArguments(operator: String, expected: Int, received: Int): String {
            return toErrorMessage(operator, expected, received)
        }

        fun incorrectClass(operator: String, expected: List<String>, received: List<String>): String {
            return toErrorMessage(operator, expected, received)
        }

        fun incorrectDataTypes(operator: String, expected: List<DataType>, received: List<DataType>): String {
            return toErrorMessage(operator, expected.map { it.type }, received.map { it.type })
        }

        private fun toErrorMessage(operator: String, expected: List<String>, received: List<String>): String {
            return ("Error: Invalid arguments for Operator('$operator'). " +
                    "Expected - [%s], Received - [%s]").format(
                expected.joinToString(),
                received.joinToString()
            )
        }

        private fun toErrorMessage(operator: String, expected: Int, received: Int): String {
            return ("Error: Invalid number of arguments for Operator('$operator'). " +
                    "Expected - [%d], Received - [%d]").format(expected, received)
        }
    }
}