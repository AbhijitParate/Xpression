package com.xpression

import com.xpression.internal.DataType

sealed class Result(val value: Any?, val type: DataType, private val error: kotlin.Error?) {

    class Null : Result(null, DataType.None, null)

    class Value internal constructor(value: Any?, dataType: DataType) : Result(value, dataType, null) {
        constructor(value: Number) : this(value, DataType.Number)
        constructor(value: String) : this(value, DataType.Text)
        constructor(value: Boolean) : this(value, DataType.Boolean)
    }
    class Error(error: kotlin.Error) : Result(null, DataType.None, error) {
        constructor(errorString: String) : this(kotlin.Error(errorString))
    }

    val hasError: Boolean
        get() = error != null

    companion object {
        fun anyErrors(vararg results: Result): Result? = results.firstOrNull { it.hasError }
    }
}