package com.xpression.test

import org.junit.jupiter.api.Test

class LiteralsTests : BaseXpressionTest() {

    @Test
    fun testNumberParsing() {
        evaluate("123", 123.0)
        evaluate("-123", -123.0)
        evaluate("0.0001", .0001)
    }

    @Test
    fun testTextParsing() {
        evaluate("\"This is a string.\"", "This is a string.")
        evaluate("'This is a string.'", "This is a string.")
        evaluate("\"This is a \\\"quoted\\\" string.\"", "This is a \"quoted\" string.")
        evaluate("\"This is a 'quoted' string.\"", "This is a 'quoted' string.")
        evaluate("\"\"", "")
        evaluate("\"\\\\\"", "\\")
    }

    @Test
    fun testBooleanParsing() {
        evaluate("True", true)
        evaluate("true", true)
        evaluate("TRUE", true)
        evaluate("False", false)
        evaluate("false", false)
        evaluate("FALSE", false)
    }

    @Test
    fun testNullParsing() {
        evaluate("Null", null)
        evaluate("null", null)
        evaluate("NULL", null)
    }
}