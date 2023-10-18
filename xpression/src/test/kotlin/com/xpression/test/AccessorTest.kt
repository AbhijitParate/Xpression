package com.xpression.test

import org.junit.jupiter.api.Test

class AccessorTest : BaseXpressionTest() {

    @Test
    fun testVariable() {
        context.setValue("ABC", 1)
        evaluate("ABC", 1)
        context.setValue("PQR", 123)
        evaluate("PQR", 123)
        context.setValue("XYZ", "Z")
        evaluate("XYZ", "Z")
        evaluate("unknown", null)
    }

}