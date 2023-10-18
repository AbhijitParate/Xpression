package com.xpression.internal.operator

import com.xpression.XpressionElement.Result
import com.xpression.internal.DataType

object Logical {

    internal val AND: Operator by lazy {
        object : Operator("&&", BINARY_OPERAND_COUNT) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null && X | X && Null
                    leftArgument.isNull || rightArgument.isNull -> {
                        return Result.nullValue()
                    }
                    // Boolean && Boolean
                    leftArgument.type == DataType.Boolean && rightArgument.type == DataType.Boolean -> {
                        if (leftArgument.value is Boolean && rightArgument.value is Boolean) {
                            val lvalue = leftArgument.value
                            val rvalue = rightArgument.value
                            return Result.Value(lvalue and rvalue)
                        }
                        return Result.Error(
                            incorrectClass(
                                operator = name,
                                expected = listOf(
                                    Boolean::class.java.simpleName,
                                    Boolean::class.java.simpleName
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
                                expected = listOf(DataType.Boolean, DataType.Boolean),
                                received = listOf(leftArgument.type, rightArgument.type)
                            )
                        )
                    }
                }
            }
        }
    }

    internal val OR: Operator by lazy {
        object : Operator("||", BINARY_OPERAND_COUNT) {
            override fun execute(leftArgument: Result.Value, rightArgument: Result.Value): Result {
                when {
                    // Null || X | X || Null
                    leftArgument.isNull || rightArgument.isNull -> {
                        return Result.nullValue()
                    }
                    // Boolean || Boolean
                    leftArgument.type == DataType.Boolean && rightArgument.type == DataType.Boolean -> {
                        if (leftArgument.value is Boolean && rightArgument.value is Boolean) {
                            val lvalue = leftArgument.value
                            val rvalue = rightArgument.value
                            return Result.Value(lvalue or rvalue)
                        }
                        return Result.Error(
                            incorrectClass(
                                operator = name,
                                expected = listOf(
                                    Boolean::class.java.simpleName,
                                    Boolean::class.java.simpleName
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
                                expected = listOf(DataType.Boolean, DataType.Boolean),
                                received = listOf(leftArgument.type, rightArgument.type)
                            )
                        )
                    }
                }
            }
        }
    }

    internal val NOT: Operator by lazy {
        object : Operator("!", UNARY_OPERAND_COUNT) {
            override fun execute(argument: Result.Value): Result {
                when {
                    // ! Null
                    argument.isNull -> {
                        return Result.nullValue()
                    }
                    // ! Boolean
                    argument.type == DataType.Boolean -> {
                        if (argument.value is Boolean) {
                            return Result.Value(argument.value.not())
                        }
                        return Result.Error(
                            incorrectClass(
                                operator = name,
                                expected = listOf(
                                    Boolean::class.java.simpleName
                                ),
                                received = listOf(
                                    argument.value?.javaClass?.simpleName.toString()
                                )
                            )
                        )
                    }
                    // Fallback
                    else -> {
                        return Result.Error(
                            incorrectDataTypes(
                                operator = name,
                                expected = listOf(DataType.Boolean),
                                received = listOf(argument.type)
                            )
                        )
                    }
                }
            }
        }
    }

    internal val TERNARY: Operator by lazy {
        object : Operator(TERNARY_OPERATOR, TERNARY_OPERAND_COUNT) {
            override fun execute(argument: Result.Value): Result {
                when {
                    // ! Null
                    argument.isNull -> {
                        return Result.nullValue()
                    }
                    // ! Boolean
                    argument.type == DataType.Boolean -> {
                        if (argument.value is Boolean) {
                            return Result.Value(argument.value.not())
                        }
                        return Result.Error(
                            incorrectClass(
                                operator = name,
                                expected = listOf(
                                    Boolean::class.java.simpleName
                                ),
                                received = listOf(
                                    argument.value?.javaClass?.simpleName.toString()
                                )
                            )
                        )
                    }
                    // Fallback
                    else -> {
                        return Result.Error(
                            incorrectDataTypes(
                                operator = name,
                                expected = listOf(DataType.Boolean),
                                received = listOf(argument.type)
                            )
                        )
                    }
                }
            }
        }
    }

}