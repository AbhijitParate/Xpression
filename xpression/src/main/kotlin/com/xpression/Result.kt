package com.xpression

import com.xpression.internal.DataType

sealed class Result(val value: Any?, val type: DataType, val error: kotlin.Error?) {
    class Value(value: Number) : Result(value, DataType.Number, null)
    class Error(error: kotlin.Error) : Result(null, DataType.None, error)
}