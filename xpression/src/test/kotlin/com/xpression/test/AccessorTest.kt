package com.xpression.test

import org.junit.jupiter.api.Test

class AccessorTest : BaseXpressionTest() {

    @Test
    fun testVariable() {
        context.setValue("ABC", 1)
        test("ABC", 1)
        context.setValue("PQR", 123)
        test("PQR", 123)
        context.setValue("XYZ", "Z")
        test("XYZ", "Z")
        test("unknown", null)
    }

}