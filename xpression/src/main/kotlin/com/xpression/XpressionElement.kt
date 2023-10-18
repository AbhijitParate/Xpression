package com.xpression

import com.xpression.internal.DataType

sealed class XpressionElement {

    class Accessor(val symbol: String = "", vararg properties: Property) : XpressionElement() {
        val isSpecial: Boolean by lazy { symbol.isNotBlank() }
        val properties by lazy { properties }
    }

    class Property(name: String) : Identifier(name) {
        // TODO: Add special properties like @, :, etc
        // val isSpecial: Boolean
    }

    open class Identifier(val name: String) : XpressionElement()

    sealed class Result : XpressionElement() {

        class Value(val value: Any?, val type: DataType) : Result() {
            constructor(number: Number) : this(value = number, DataType.Number)
            constructor(string: String) : this(value = string, DataType.Text)
            constructor(boolean: Boolean) : this(value = boolean, DataType.Boolean)
        }

        class Error(val error: String) : Result()

        val hasError: Boolean by lazy { this is Error }

        val hasValue: Boolean by lazy { this is Value }

        val isNull: Boolean by lazy { this is Value && this.type == DataType.None }

        override fun toString(): String {
            if (this is Error) return error
            this as Value
            return "$type($value)"
        }

        companion object {
            fun anyErrors(vararg results: Result): Result? = results.firstOrNull { it.hasError }
            fun nullValue() = Value(null, DataType.None)
        }
    }
}