package com.xpression.internal.function

import com.xpression.XpressionContext
import com.xpression.XpressionElement.Result
import com.xpression.internal.DataType

object Data {

    val IS_NULL: Function by lazy {
        object : Function(IS_NULL, 1) {
            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> Result
            ): Result {
                val argument = arguments.fetch(0)
                return validate(argument) ?: Result.Value(argument.isNull)
            }
        }
    }

    val IS_BLANK: Function by lazy {
        object : Function(IS_BLANK, 1) {
            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> Result
            ): Result {
                val argument = arguments.fetch(0)
                return validate(argument) ?: run {
                    argument as Result.Value
                    when {
                        argument.type == DataType.Text -> {
                            if (argument.value is String) {
                                return@run Result.Value(argument.value.isBlank())
                            }
                            return@run Result.Error(
                                incorrectClass(
                                    function = name,
                                    expected = listOf(String.Companion::class.java.simpleName),
                                    received = listOf(argument.javaClass.simpleName)
                                )
                            )
                        }
                        else -> {
                            return@run Result.Error(
                                incorrectDataTypes(
                                    function = name,
                                    expected = listOf(DataType.Text),
                                    received = listOf(argument.type)
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    val IS_TEXT: Function by lazy {
        object : Function(IS_TEXT, 1) {
            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> Result
            ): Result {
                val argument = arguments.fetch(0)
                return validate(argument) ?: run {
                    argument as Result.Value
                    if (argument.type == DataType.Text) {
                        return@run Result.Value(true)
                    }
                    return@run Result.Value(false)
                }
            }
        }
    }

    val IS_NUMBER: Function by lazy {
        object : Function(IS_NUMBER, 1) {
            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> Result
            ): Result {
                val argument = arguments.fetch(0)
                return validate(argument) ?: run {
                    argument as Result.Value
                    if (argument.type == DataType.Number) {
                        return@run Result.Value(true)
                    }
                    return@run Result.Value(false)
                }
            }
        }
    }

    val IS_BOOLEAN: Function by lazy {
        object : Function(IS_BOOLEAN, 1) {
            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> Result
            ): Result {
                val argument = arguments.fetch(0)
                return validate(argument) ?: run {
                    argument as Result.Value
                    if (argument.type == DataType.Boolean) {
                        return@run Result.Value(true)
                    }
                    return@run Result.Value(false)
                }
            }
        }
    }

}