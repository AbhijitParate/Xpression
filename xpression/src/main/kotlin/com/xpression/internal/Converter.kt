package com.xpression.internal

import com.xpression.XpressionContext

object Converter {
    fun String.toPositiveNumber(context: XpressionContext) : Number {
        // TODO: Add config and parse other numbers
        return this.toDouble()
    }

    fun String.toNegativeNumber(context: XpressionContext) : Number {
        // TODO: Add config and parse other numbers
        return this.toDouble().times(-1)
    }
}