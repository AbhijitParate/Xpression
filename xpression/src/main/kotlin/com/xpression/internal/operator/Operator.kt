package com.xpression.internal.operator

import com.xpression.internal.component.Component
import com.xpression.internal.DataType

abstract class Operator(private val operator: String, operandCount: Int = 0) : Component {

    override val name: String = operator

    override val argumentCount: Int = operandCount

    /**
     *
     */
    fun evaluate(left: com.xpression.XpressionElement.Result, right: com.xpression.XpressionElement.Result): com.xpression.XpressionElement.Result {
        validate(left, right)?.let {
            return it
        }
        return execute(left, right)
    }

    /**
     * Validated argument
     *  - Check for errors
     *  - Validate number of arguments
     *  - Validate type of arguments
     */
    protected open fun validate(left: com.xpression.XpressionElement.Result, right: com.xpression.XpressionElement.Result): com.xpression.XpressionElement.Result? {
        if (!validateArgumentCount(2)) {
            return com.xpression.XpressionElement.Result.Error("Too many or less arguments for operator : $operator.")
        }
        return validateArguments(left, right)
    }

    /**
     *
     */
    protected open fun execute(left: com.xpression.XpressionElement.Result, right: com.xpression.XpressionElement.Result): com.xpression.XpressionElement.Result {
        return unhandledExpression("x $operator y")
    }

    companion object {

        const val INVALID_OPERAND_COUNT = -1
        const val UNARY_OPERAND_COUNT = 1
        const val BINARY_OPERAND_COUNT = 2
        const val TERNARY_OPERAND_COUNT = 3
        private const val INCORRECT_PARAMS_FOR_OPERATOR = "Incorrect parameter type for operator '%s'. "
        private const val EXPECTED_RECEIVED = "Expected - %s, received - %s."

        fun unhandledExpression(expression: String): com.xpression.XpressionElement.Result {
            return com.xpression.XpressionElement.Result.Error("Unhandled expression : $expression")
        }

        fun incorrectParams(
            operator: String,
            received: com.xpression.XpressionElement.Result.Value,
            expected: com.xpression.XpressionElement.Result.Value
        ): com.xpression.XpressionElement {
            return com.xpression.XpressionElement.Result.Error(
                toErrorMessage(
                    operator = operator,
                    received = received.type,
                    expected = arrayOf(expected.type)
                )
            )
        }

        fun incorrectParameters(
            operator: String,
            received: com.xpression.XpressionElement.Result.Value,
            vararg expected: DataType
        ): com.xpression.XpressionElement {
            return com.xpression.XpressionElement.Result.Error(
                toErrorMessage(
                    operator = operator,
                    received = received.type,
                    expected = expected
                )
            )
        }

        private fun toErrorMessage(
            operator: String,
            received: DataType,
            vararg expected: DataType
        ): String {
            return INCORRECT_PARAMS_FOR_OPERATOR.format(operator) +
                    EXPECTED_RECEIVED.format(expected.joinToString(), received.name)
        }
    }
}