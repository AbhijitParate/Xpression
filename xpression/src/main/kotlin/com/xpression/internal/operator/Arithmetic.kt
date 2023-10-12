package com.xpression.internal.operator

import com.xpression.Xpression.*
import com.xpression.internal.DataType
import kotlin.math.pow

object Arithmetic {

    internal val ADDITION: Operator by lazy {
        object : Operator("+", 2) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null + X | X + Null
                    leftArgument.isNull || rightArgument.isNull -> {
                        return Result.nullValue()
                    }
                    // Number + Number
                    leftArgument.type == DataType.Number && rightArgument.type == DataType.Number -> {
                        if (leftArgument.value is Double && rightArgument.value is Double) {
                            val lvalue = leftArgument.value
                            val rvalue = rightArgument.value
                            return Result.Value(lvalue.plus(rvalue))
                        }
                        return Result.Error(
                            incorrectClass(
                                operator = name,
                                expected = listOf(
                                    Double::class.java.simpleName,
                                    Double::class.java.simpleName
                                ),
                                received = listOf(
                                    leftArgument.value?.javaClass?.simpleName.toString(),
                                    rightArgument.value?.javaClass?.simpleName.toString()
                                )
                            )
                        )
                    }
                    // Text + Text
                    leftArgument.type == DataType.Text && rightArgument.type == DataType.Text -> {
                        if (leftArgument.value is String && rightArgument.value is String) {
                            val lvalue = leftArgument.value
                            val rvalue = rightArgument.value
                            return Result.Value(lvalue + rvalue)
                        }
                        return Result.Error(
                            incorrectClass(
                                operator = name,
                                expected = listOf(
                                    Double::class.java.simpleName,
                                    Double::class.java.simpleName
                                ),
                                received = listOf(
                                    leftArgument.value?.javaClass?.simpleName.toString(),
                                    rightArgument.value?.javaClass?.simpleName.toString()
                                )
                            )
                        )
                    }
                    // Fallback
                    else -> {
                        return Result.Error(
                            incorrectDataTypes(
                                operator = name,
                                expected = listOf(DataType.Number, DataType.Number),
                                received = listOf(leftArgument.type, rightArgument.type)
                            )
                        )
                    }
                }
            }
        }
    }

    internal val SUBTRACTION: Operator by lazy {
        object : Operator("-", 2) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null - X | X - Null
                    leftArgument.isNull || rightArgument.isNull -> {
                        return Result.nullValue()
                    }
                    // Number - Number
                    leftArgument.type == DataType.Number && rightArgument.type == DataType.Number -> {
                        if (leftArgument.value is Double && rightArgument.value is Double) {
                            val lvalue = leftArgument.value
                            val rvalue = rightArgument.value
                            return Result.Value(lvalue.minus(rvalue))
                        }
                        return Result.Error(
                            incorrectClass(
                                operator = name,
                                expected = listOf(
                                    Double::class.java.simpleName,
                                    Double::class.java.simpleName
                                ),
                                received = listOf(
                                    leftArgument.value?.javaClass?.simpleName.toString(),
                                    rightArgument.value?.javaClass?.simpleName.toString()
                                )
                            )
                        )
                    }
                    // Fallback
                    else -> {
                        return Result.Error(
                            incorrectDataTypes(
                                operator = name,
                                expected = listOf(DataType.Number, DataType.Number),
                                received = listOf(leftArgument.type, rightArgument.type)
                            )
                        )
                    }
                }
            }
        }
    }

    internal val PRODUCT: Operator by lazy {
        object : Operator("*", 2) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null * X | X * Null
                    leftArgument.isNull || rightArgument.isNull -> {
                        return Result.nullValue()
                    }
                    // Number * Number
                    leftArgument.value is Double && rightArgument.value is Double -> {
                        val lvalue = leftArgument.value
                        val rvalue = rightArgument.value
                        return Result.Value(lvalue.times(rvalue))
                    }
                    // Fallback
                    else -> {
                        return Result.Error(
                            incorrectDataTypes(
                                operator = name,
                                expected = listOf(DataType.Number, DataType.Number),
                                received = listOf(leftArgument.type, rightArgument.type)
                            )
                        )
                    }
                }
            }
        }
    }

    internal val MODULO: Operator by lazy {
        object : Operator("%", 2) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null % X | X % Null
                    leftArgument.isNull || rightArgument.isNull -> {
                        return Result.nullValue()
                    }
                    // Number % Number
                    leftArgument.value is Double && rightArgument.value is Double -> {
                        val lvalue = leftArgument.value
                        val rvalue = rightArgument.value
                        return Result.Value(lvalue.mod(rvalue))
                    }
                    // Fallback
                    else -> {
                        return Result.Error(
                            incorrectDataTypes(
                                operator = name,
                                expected = listOf(DataType.Number, DataType.Number),
                                received = listOf(leftArgument.type, rightArgument.type)
                            )
                        )
                    }
                }
            }
        }
    }

    internal val DIVISION: Operator by lazy {
        object : Operator("/", 2) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null / X | X / Null
                    leftArgument.isNull || rightArgument.isNull -> {
                        return Result.nullValue()
                    }
                    // Number / Number
                    leftArgument.value is Double && rightArgument.value is Double -> {
                        val lvalue = leftArgument.value
                        val rvalue = rightArgument.value
                        return if (rvalue == "0".toDouble()) {
                            Result.Error("MathError : Divide by zero error.")
                        } else {
                            Result.Value(lvalue.div(rvalue))
                        }
                    }
                    // Fallback
                    else -> {
                        return Result.Error(
                            incorrectDataTypes(
                                operator = name,
                                expected = listOf(DataType.Number, DataType.Number),
                                received = listOf(leftArgument.type, rightArgument.type)
                            )
                        )
                    }
                }
            }
        }
    }

    internal val EXPONENTIATION: Operator by lazy {
        object : Operator("^", 2) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null ^ X | X ^ Null
                    leftArgument.isNull || rightArgument.isNull -> {
                        return Result.nullValue()
                    }
                    // Number ^ Number
                    leftArgument.value is Double && rightArgument.value is Double -> {
                        return Result.Value(leftArgument.value.pow(rightArgument.value))
                    }
                    // Fallback
                    else -> {
                        return Result.Error(
                            incorrectDataTypes(
                                operator = name,
                                expected = listOf(DataType.Number, DataType.Number),
                                received = listOf(leftArgument.type, rightArgument.type)
                            )
                        )
                    }
                }
            }
        }
    }

}