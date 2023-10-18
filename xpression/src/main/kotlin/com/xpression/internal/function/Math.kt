package com.xpression.internal.function

import com.xpression.XpressionContext
import com.xpression.XpressionElement
import com.xpression.XpressionElement.Result
import com.xpression.internal.DataType
import kotlin.math.absoluteValue
import kotlin.math.ceil
import kotlin.math.floor

object Math {

    val ABSOLUTE: Function by lazy {
        object : Function(ABSOLUTE, 1) {
            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> Result
            ): Result {
                val argument = arguments.fetch(0)
                return validate(argument) ?: run {
                    argument as Result.Value
                    when {
                        argument.isNull -> {
                            return@run XpressionElement.Result.nullValue()
                        }
                        argument.type == DataType.Number -> {
                            val value = argument.value
                            if (value is Double) {
                                return@run Result.Value(value.absoluteValue)
                            }
                            return@run Result.Error(
                                incorrectClass(
                                    function = name,
                                    expected = listOf(Double::class.java.simpleName),
                                    received = listOf(value!!.javaClass.simpleName)
                                )
                            )
                        }
                        else -> {
                            return@run Result.Error(
                                incorrectDataTypes(
                                    function = name,
                                    expected = listOf(DataType.Number),
                                    received = listOf(argument.type)
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    val FLOOR: Function by lazy {
        object : Function(FLOOR, 1) {
            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> Result
            ): Result {
                val argument = arguments.fetch(0)
                return validate(argument) ?: run {
                    argument as Result.Value
                    when {
                        argument.isNull -> {
                            return@run XpressionElement.Result.nullValue()
                        }
                        argument.type == DataType.Number -> {
                            val value = argument.value
                            if (value is Double) {
                                return@run Result.Value(floor(value))
                            }
                            return@run Result.Error(
                                incorrectClass(
                                    function = name,
                                    expected = listOf(Double::class.java.simpleName),
                                    received = listOf(value!!.javaClass.simpleName)
                                )
                            )
                        }
                        else -> {
                            return@run Result.Error(
                                incorrectDataTypes(
                                    function = name,
                                    expected = listOf(DataType.Number),
                                    received = listOf(argument.type)
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    val CEILING: Function by lazy {
        object : Function(CEILING, 1) {
            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> Result
            ): Result {
                val argument = arguments.fetch(0)
                return validate(argument) ?: run {
                    argument as Result.Value
                    when {
                        argument.isNull -> {
                            return@run XpressionElement.Result.nullValue()
                        }
                        argument.type == DataType.Number -> {
                            val value = argument.value
                            if (value is Double) {
                                return@run Result.Value(ceil(value))
                            }
                            return@run Result.Error(
                                incorrectClass(
                                    function = name,
                                    expected = listOf(Double::class.java.simpleName),
                                    received = listOf(value!!.javaClass.simpleName)
                                )
                            )
                        }
                        else -> {
                            return@run Result.Error(
                                incorrectDataTypes(
                                    function = name,
                                    expected = listOf(DataType.Number),
                                    received = listOf(argument.type)
                                )
                            )
                        }
                    }
                }
            }
        }
    }

}
