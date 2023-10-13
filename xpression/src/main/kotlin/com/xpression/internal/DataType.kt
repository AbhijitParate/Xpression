package com.xpression.internal

enum class DataType(val type: String) {
    None(Primitive.NONE),

    Text(Primitive.TEXT),
    Number(Primitive.NUMBER),
    Boolean(Primitive.BOOLEAN),
    Date(Primitive.DATE),
    Time(Primitive.TIME),
    DateTime(Primitive.DATETIME),

    Array(Abstract.ARRAY),
    List(Abstract.LIST),
    Set(Abstract.SET),
    Object(Abstract.OBJECT)
    ;

    companion object {
        object Primitive {
            const val NONE = "none"
            const val TEXT = "text"
            const val NUMBER = "number"
            const val BOOLEAN = "boolean"
            const val DATE = "date"
            const val TIME = "time"
            const val DATETIME = "datetime"
        }

        object Abstract {
            const val OBJECT = "object"
            const val ARRAY = "array"
            const val LIST = "list"
            const val SET = "set"
        }

        fun DataType?.orNone(): DataType {
            return this ?: DataType.None
        }
    }
}