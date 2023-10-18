package com.xpression.internal

import com.xpression.internal.function.Function
import com.xpression.internal.operator.Operator
import com.xpression.XpressionContext
import com.xpression.XpressionElement.Result

internal class Provider(
    private val operatorMap: Map<String, Operator>,
    private val functionMap: Map<String, Function>
) {

    fun getOperator(operator: String): Operator =
        operatorMap[operator] ?: unsupportedOperator(operator)

    fun getFunction(functionName: String): Function =
        functionMap[functionName.lowercase()] ?: unsupportedFunction(functionName)

    class Builder {

        private val functionMap = mutableMapOf<String, Function>()
        private val operatorMap = mutableMapOf<String, Operator>()

        fun addFunction(vararg functions: Function): Builder {
            functions.forEach { functionMap[it.name.lowercase()] = it }
            return this
        }

        fun addOperator(vararg operators: Operator): Builder {
            operators.forEach { operatorMap[it.name] = it }
            return this
        }

        fun build(): Provider = Provider(operatorMap.toMap(), functionMap.toMap())
    }

    private fun unsupportedFunction(name: String): Function {
        return object : Function(name) {
            // TODO: Refactor this. Do not expose anything.
            override fun execute(
                xpressionVisitor: XpressionVisitor,
                xpressionContext: XpressionContext,
                vararg arguments: Result
            ): Result {
                return Result.Error("Function not supported : $name")
            }
        }
    }

    private fun unsupportedOperator(operator: String): Operator {
        return object : Operator(operator, 0) {
            override fun validate(vararg arguments: Result): Result {
                return Result.Error("Operator not supported : $operator")
            }
        }
    }
}