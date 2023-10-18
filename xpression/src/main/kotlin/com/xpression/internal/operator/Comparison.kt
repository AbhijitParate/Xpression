package com.xpression.internal.operator

import com.xpression.XpressionElement.Result
import com.xpression.internal.DataType

object Comparison {

    internal val EQUAL: Operator by lazy {
        object : Operator("==", BINARY_OPERAND_COUNT) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null == X | X == Null
                    leftArgument.isNull && rightArgument.isNull && leftArgument.type == rightArgument.type -> {
                        return Result.Value(true)
                    }
                    // Number == Number || Boolean == Boolean || Text == Text
                    (leftArgument.type == DataType.Number && rightArgument.type == DataType.Number) or
                            (leftArgument.type == DataType.Boolean && rightArgument.type == DataType.Boolean) or
                            (leftArgument.type == DataType.Text && rightArgument.type == DataType.Text) -> {
                        when {
                            // Number == Number
                            leftArgument.value is Double && rightArgument.value is Double -> {
                                val lvalue = leftArgument.value
                                val rvalue = rightArgument.value
                                return Result.Value(lvalue == rvalue)
                            }
                            // Boolean == Boolean
                            leftArgument.value is Boolean && rightArgument.value is Boolean -> {
                                val lvalue = leftArgument.value
                                val rvalue = rightArgument.value
                                return Result.Value(lvalue == rvalue)
                            }
                            // Text == Text
                            leftArgument.value is String && rightArgument.value is String -> {
                                val lvalue = leftArgument.value
                                val rvalue = rightArgument.value
                                return Result.Value(lvalue == rvalue)
                            }
                            // X == X
                            else -> return Result.Error(
                                incorrectClass(
                                    operator = name,
                                    expected = listOf(
                                        "(${Double::class.java.simpleName} or ${Boolean::class.java.simpleName} or ${String::class.java.simpleName})",
                                        "(${Double::class.java.simpleName} or ${Boolean::class.java.simpleName} or ${String::class.java.simpleName})"
                                    ),
                                    received = listOf(
                                        leftArgument.value?.javaClass?.simpleName.toString(),
                                        rightArgument.value?.javaClass?.simpleName.toString()
                                    )
                                )
                            )
                        }
                    }
                    // Fallback
                    else -> {
                        return Result.Error(
                            incorrectDataTypes(
                                operator = name,
                                expected = listOf(DataType.Boolean, DataType.Boolean),
                                received = listOf(leftArgument.type, rightArgument.type)
                            )
                        )
                    }
                }
            }
        }
    }

    internal val UNEQUAL: Operator by lazy {
        object : Operator("!=", BINARY_OPERAND_COUNT) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null != X | X != Null
                    leftArgument.isNull && rightArgument.isNull && leftArgument.type == rightArgument.type -> {
                        return Result.Value(false)
                    }
                    // Number != Number || Boolean != Boolean || Text != Text
                    (leftArgument.type == DataType.Number && rightArgument.type == DataType.Number) or
                            (leftArgument.type == DataType.Boolean && rightArgument.type == DataType.Boolean) or
                            (leftArgument.type == DataType.Text && rightArgument.type == DataType.Text) -> {
                        when {
                            // Number != Number
                            leftArgument.value is Double && rightArgument.value is Double -> {
                                val lvalue = leftArgument.value
                                val rvalue = rightArgument.value
                                return Result.Value(lvalue != rvalue)
                            }
                            // Boolean != Boolean
                            leftArgument.value is Boolean && rightArgument.value is Boolean -> {
                                val lvalue = leftArgument.value
                                val rvalue = rightArgument.value
                                return Result.Value(lvalue != rvalue)
                            }
                            // Text != Text
                            leftArgument.value is String && rightArgument.value is String -> {
                                val lvalue = leftArgument.value
                                val rvalue = rightArgument.value
                                return Result.Value(lvalue != rvalue)
                            }
                            // X != X
                            else -> return Result.Error(
                                incorrectClass(
                                    operator = name,
                                    expected = listOf(
                                        "(${Double::class.java.simpleName} or ${Boolean::class.java.simpleName} or ${String::class.java.simpleName})",
                                        "(${Double::class.java.simpleName} or ${Boolean::class.java.simpleName} or ${String::class.java.simpleName})"
                                    ),
                                    received = listOf(
                                        leftArgument.value?.javaClass?.simpleName.toString(),
                                        rightArgument.value?.javaClass?.simpleName.toString()
                                    )
                                )
                            )
                        }
                    }
                    // Fallback
                    else -> {
                        return Result.Error(
                            incorrectDataTypes(
                                operator = name,
                                expected = listOf(DataType.Boolean, DataType.Boolean),
                                received = listOf(leftArgument.type, rightArgument.type)
                            )
                        )
                    }
                }
            }
        }
    }

    internal val LESS_THAN: Operator by lazy {
        object : Operator("<", BINARY_OPERAND_COUNT) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null < X | X < Null
                    leftArgument.isNull && rightArgument.isNull && leftArgument.type == rightArgument.type -> {
                        return Result.Value(false)
                    }
                    // Number < Number
                    (leftArgument.type == DataType.Number && rightArgument.type == DataType.Number) -> {
                        // Number != Number
                        if (leftArgument.value is Double && rightArgument.value is Double) {
                            val lvalue = leftArgument.value
                            val rvalue = rightArgument.value
                            return Result.Value(lvalue < rvalue)
                        }
                        else return Result.Error(
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

    internal val LESS_THAN_OR_EQUAL: Operator by lazy {
        object : Operator("<=", BINARY_OPERAND_COUNT) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null <= X | X <= Null
                    leftArgument.isNull && rightArgument.isNull && leftArgument.type == rightArgument.type -> {
                        return Result.Value(false)
                    }
                    // Number <= Number
                    (leftArgument.type == DataType.Number && rightArgument.type == DataType.Number) -> {
                        // Number <= Number
                        if (leftArgument.value is Double && rightArgument.value is Double) {
                            val lvalue = leftArgument.value
                            val rvalue = rightArgument.value
                            return Result.Value(lvalue <= rvalue)
                        }
                        else return Result.Error(
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

    internal val GREATER_THAN: Operator by lazy {
        object : Operator(">", BINARY_OPERAND_COUNT) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null > X | X > Null
                    leftArgument.isNull && rightArgument.isNull && leftArgument.type == rightArgument.type -> {
                        return Result.Value(false)
                    }
                    // Number > Number
                    (leftArgument.type == DataType.Number && rightArgument.type == DataType.Number) -> {
                        // Number != Number
                        if (leftArgument.value is Double && rightArgument.value is Double) {
                            val lvalue = leftArgument.value
                            val rvalue = rightArgument.value
                            return Result.Value(lvalue > rvalue)
                        }
                        else return Result.Error(
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

    internal val GREATER_THAN_OR_EQUAL: Operator by lazy {
        object : Operator(">=", BINARY_OPERAND_COUNT) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null >= X | X >= Null
                    leftArgument.isNull && rightArgument.isNull && leftArgument.type == rightArgument.type -> {
                        return Result.Value(false)
                    }
                    // Number >= Number
                    (leftArgument.type == DataType.Number && rightArgument.type == DataType.Number) -> {
                        // Number >= Number
                        if (leftArgument.value is Double && rightArgument.value is Double) {
                            val lvalue = leftArgument.value
                            val rvalue = rightArgument.value
                            return Result.Value(lvalue >= rvalue)
                        }
                        else return Result.Error(
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

}