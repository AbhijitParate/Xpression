package com.xpression.test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LiteralParserTests : BaseXpressionTest() {

    @Test
    fun testNumberParsing() {
        test("123", 123.0)
        test("-123", -123.0)
        test("0.0001", .0001)
    }

    private fun test(expression: String, result: Any) {
        val r = evaluate(expression)
        assertEquals(result, r.value)
    }
}