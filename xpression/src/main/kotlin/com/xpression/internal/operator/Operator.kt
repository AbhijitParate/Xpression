package com.xpression.internal.operator

import com.xpression.internal.Component
import com.xpression.internal.DataType
import com.xpression.Result as XpressionResult

abstract class Operator(operator: String, operandCount: Int = 0) : Component {

    override val name: String = operator

    override val argumentCount: Int = operandCount

    /**
     *
     */
    fun evaluate(left: XpressionResult, right: XpressionResult): XpressionResult {
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
    protected open fun validate(left: XpressionResult, right: XpressionResult): XpressionResult? {
        if (!validateArgumentCount(2)) {
            return XpressionResult.Error("Too many or less arguments for operator : $name.")
        }
        return validateArguments(left, right)
    }

    /**
     *
     */
    protected open fun execute(left: XpressionResult, right: XpressionResult): XpressionResult {
        return unhandledExpression("${left.value.toString()} $name ${right.value.toString()}")
    }

    companion object {

        const val INVALID_OPERAND_COUNT = -1
        const val UNARY_OPERAND_COUNT = 1
        const val BINARY_OPERAND_COUNT = 2
        const val TERNARY_OPERAND_COUNT = 3
        private const val INCORRECT_PARAMS_FOR_OPERATOR = "Incorrect parameter type for operator '%s'. "
        private const val EXPECTED_RECEIVED = "Expected - %s, received - %s."

        fun unhandledExpression(expression: String): XpressionResult {
            return XpressionResult.Error("Unhandled expression : $expression")
        }

        fun incorrectParams(
            operator: String,
            received: XpressionResult,
            expected: XpressionResult
        ): XpressionResult {
            return XpressionResult.Error(
                toErrorMessage(
                    operator = operator,
                    received = received.type,
                    expected = arrayOf(expected.type)
                )
            )
        }

        fun incorrectParameters(
            operator: String,
            received: XpressionResult,
            vararg expected: DataType
        ): XpressionResult {
            return XpressionResult.Error(
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