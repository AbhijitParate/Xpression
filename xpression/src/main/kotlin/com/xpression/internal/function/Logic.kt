package com.xpression.internal.function

import com.xpression.XpressionContext
import com.xpression.XpressionElement
import com.xpression.internal.DataType

object Logic {

    val NOT: Function by lazy {
        object : Function(NOT, 1) {

            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> XpressionElement.Result
            ): XpressionElement.Result {
                val argument = arguments.fetch(0)
                return validate(argument) ?: run {
                    argument as XpressionElement.Result.Value
                    if (argument.type == DataType.Boolean) {
                        val value = argument.value
                        if (value is Boolean) {
                            return@run XpressionElement.Result.Value(value.not())
                        }
                        return@run XpressionElement.Result.Error(
                            incorrectClass(
                                function = name,
                                expected = listOf(Boolean::class.java.simpleName),
                                received = listOf(value!!.javaClass.simpleName)
                            )
                        )
                    }
                    return@run XpressionElement.Result.Error(
                        incorrectDataTypes(
                            function = name,
                            expected = listOf(DataType.Boolean),
                            received = listOf(argument.type)
                        )
                    )
                }
            }
        }
    }

    val AND: Function by lazy {
        object : Function(AND, VARIABLE_ARGUMENT_COUNT) {

            override fun validateArgumentCount(count: Int): Boolean {
                return count > 1 // 2 or more args
            }

            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> XpressionElement.Result
            ): XpressionElement.Result {
                var result = true
                for (index in 0 until argumentCount) {
                    val argument = arguments.fetch(index)
                    // validate arguments lazily and return early
                    validate(argument)?.let { error -> return error }
                    argument as XpressionElement.Result.Value
                    if (argument.type == DataType.Boolean) {
                        val value = argument.value
                        if (value is Boolean) {
                            result = value and result
                            continue
                        }
                        return XpressionElement.Result.Error(
                            incorrectClass(
                                function = name,
                                expected = listOf(
                                    Boolean::class.java.simpleName,
                                    Boolean::class.java.simpleName,
                                    "..."
                                ),
                                received = listOf(value!!.javaClass.simpleName)
                            )
                        )
                    }
                    return XpressionElement.Result.Error(
                        incorrectDataTypes(
                            function = name,
                            expected = listOf(DataType.Boolean),
                            received = listOf(argument.type)
                        )
                    )
                }
                return XpressionElement.Result.Value(result!!)
            }
        }
    }

    val OR: Function by lazy {
        object : Function(OR, VARIABLE_ARGUMENT_COUNT) {

            override fun validateArgumentCount(count: Int): Boolean {
                return count > 1 // 2 or more args
            }

            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> XpressionElement.Result
            ): XpressionElement.Result {
                var result = false
                for (index in 0 until argumentCount) {
                    val argument = arguments.fetch(index)
                    // validate arguments lazily and return early
                    validate(argument)?.let { error -> return error }
                    argument as XpressionElement.Result.Value
                    if (argument.type == DataType.Boolean) {
                        val value = argument.value
                        if (value is Boolean) {
                            result = result or value
                            continue
                        }
                        return XpressionElement.Result.Error(
                            incorrectClass(
                                function = name,
                                expected = listOf(
                                    Boolean::class.java.simpleName,
                                    Boolean::class.java.simpleName,
                                    "..."
                                ),
                                received = listOf(value!!.javaClass.simpleName)
                            )
                        )
                    }
                    return XpressionElement.Result.Error(
                        incorrectDataTypes(
                            function = name,
                            expected = listOf(DataType.Boolean),
                            received = listOf(argument.type)
                        )
                    )
                }
                return XpressionElement.Result.Value(result)
            }
        }
    }
}