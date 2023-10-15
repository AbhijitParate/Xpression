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
            constructor(value: Number) : this(value, DataType.Number)
            constructor(value: String) : this(value, DataType.Text)
            constructor(value: Boolean) : this(value, DataType.Boolean)
        }

        class Error(val error: kotlin.Error) : Result() {
            constructor(errorString: String) : this(kotlin.Error(errorString))
        }

        val hasError: Boolean by lazy { this is Error }

        val hasValue: Boolean by lazy { this is Value }

        companion object {
            fun anyErrors(vararg results: Result): Result? = results.firstOrNull { it.hasError }
            fun nullValue() = Value(null, DataType.None)
        }
    }
}