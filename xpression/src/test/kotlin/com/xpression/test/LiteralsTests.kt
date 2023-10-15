package com.xpression.test

import org.junit.jupiter.api.Test

class LiteralsTests : BaseXpressionTest() {

    @Test
    fun testNumberParsing() {
        test("123", 123.0)
        test("-123", -123.0)
        test("0.0001", .0001)
    }

    @Test
    fun testTextParsing() {
        test("\"This is a string.\"", "This is a string.")
        test("'This is a string.'", "This is a string.")
        test("\"This is a \\\"quoted\\\" string.\"", "This is a \"quoted\" string.")
        test("\"This is a 'quoted' string.\"", "This is a 'quoted' string.")
        test("\"\"", "")
        test("\"\\\\\"", "\\")
    }

    @Test
    fun testBooleanParsing() {
        test("True", true)
        test("true", true)
        test("TRUE", true)
        test("False", false)
        test("false", false)
        test("FALSE", false)
    }

    @Test
    fun testNullParsing() {
        test("Null", null)
        test("null", null)
        test("NULL", null)
    }
}