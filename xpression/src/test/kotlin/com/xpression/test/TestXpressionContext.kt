package com.xpression.test

import com.xpression.XpressionElement
import com.xpression.XpressionContext
import com.xpression.XpressionElement.Accessor
import com.xpression.XpressionElement.Result
import com.xpression.internal.DataType

class TestXpressionContext : XpressionContext() {

    private val map = mutableMapOf<String, Any?>()

    fun setValue(key: String, value: Any?) {
        map[key] = value
    }

    override fun resolve(accessor: Accessor): Result {
        val property = accessor.properties.first()
        val value = map[property.name] ?: run {
            return Result.nullValue()
        }
        return Result.Value(value, value.type())
    }

    private fun Any?.type(): DataType {
        return when (this) {
            is Double, is Int -> DataType.Number
            is String -> DataType.Text
            else -> DataType.None
        }
    }
}