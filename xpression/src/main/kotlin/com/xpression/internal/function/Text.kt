package com.xpression.internal.function

import com.xpression.Xpression.*
import com.xpression.XpressionContext
import com.xpression.internal.DataType

object Text {

    /**
     * Len(text:[DataType.Text]) -> [DataType.Number]
     */
    val LEN: Function by lazy {
        object : Function(LEN, 1) {
            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> Result
            ): Result {
                val argument = arguments.fetch(0)
                return validate(argument) ?: run {
                    argument as Result.Value
                    if (argument.type == DataType.Text) {
                        val value = argument.value
                        if (value is String) {
                            return@run Result.Value(value.length.toDouble())
                        }
                        return@run Result.Error(
                            incorrectClass(
                                function = name,
                                expected = listOf(String::class.java.simpleName),
                                received = listOf(value!!.javaClass.simpleName)
                            )
                        )
                    }
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

    /**
     * Contains(text:[DataType.Text], subText:[DataType.Text]) -> [DataType.Boolean]
     */
    val CONTAINS: Function by lazy {
        object : Function(CONTAINS, 2) {
            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> Result
            ): Result {
                val text = arguments.fetch(0)
                val subText = arguments.fetch(1)
                validate(text)?.let { return it }
                validate(subText)?.let { return it }
                text as Result.Value
                subText as Result.Value
                if (text.type == DataType.Text && subText.type ==  DataType.Text) {
                    if (text.value is String && subText.value is String) {
                        return Result.Value(text.value.contains(subText.value))
                    }
                    return Result.Error(
                        incorrectClass(
                            function = name,
                            expected = listOf(String::class.java.simpleName, String::class.java.simpleName),
                            received = listOf(text.value!!.javaClass.simpleName, subText.value!!.javaClass.simpleName)
                        )
                    )
                }
                return Result.Error(
                    incorrectDataTypes(
                        function = name,
                        expected = listOf(DataType.Text, DataType.Text),
                        received = listOf(text.type, subText.type)
                    )
                )
            }
        }
    }

    /**
     * Format(value:[DataType.Number], formatSpecifier:[DataType.Text]) -> [DataType.Text]
     */
    val TEXT: Function by lazy {
        object : Function(TEXT, 1) {
            override fun execute(
                xpressionContext: XpressionContext,
                argumentCount: Int,
                arguments: (Int) -> Result
            ): Result {
                val value = arguments.fetch(0)
                validate(value)?.let { return it }
                value as Result.Value
                if (value.isNull) {
                    return Result.Value("")
                } else if (value.type == DataType.Number) {
                    if (value.value is Double) {
                        return Result.Value(value.value.toString())
                    }
                    return Result.Error(
                        incorrectClass(
                            function = name,
                            expected = listOf(Double::class.java.simpleName),
                            received = listOf(value.value!!.javaClass.simpleName)
                        )
                    )
                } else if (value.type == DataType.Boolean) {
                    if (value.value is Boolean) {
                        return Result.Value(value.value.toString())
                    }
                    return Result.Error(
                        incorrectClass(
                            function = name,
                            expected = listOf(Boolean::class.java.simpleName),
                            received = listOf(value.value!!.javaClass.simpleName)
                        )
                    )
                }
                return Result.Error(
                    incorrectDataTypes(
                        function = name,
                        expected = listOf(DataType.Boolean),
                        received = listOf(value.type)
                    )
                )
            }
        }
    }

}