package com.xpression.test

import org.junit.jupiter.api.Test

class LogicalExpressionsTests : BaseXpressionTest() {

    @Test
    fun testComparisonOperators() {
        evaluate("1 > 2", false)
        evaluate("1 >= 2", false)
        evaluate("1 < 2", true)
        evaluate("1 <= 2", true)
        evaluate("1 == 2", false)
        evaluate("1 != 2", true)
        evaluate("true == true", true)
        evaluate("true != true", false)
        evaluate("false == false", true)
        evaluate("false != false", false)
    }

    @Test
    fun testComplexExpressions() {
        evaluate("(1 + 2) > 3", false)
        evaluate("(1 + 2) >= 3", true)
        evaluate("(1 + 2) < 3", false)
        evaluate("(1 + 2) <= 3", true)
        evaluate("(1 + 2) == 3", true)
        evaluate("(1 + 2) != 3", false)
    }

    @Test
    fun testExpressionsWithMultipleComparisonOperators() {
        evaluate("(1 + 2) > 3 && (4 + 5) > 9", false)
        evaluate("(1 + 2) > 3 || (4 + 5) > 9", false)
    }

    @Test
    fun testComparisonOperatorsWithStrings() {
        evaluate("\"a\" == \"b\"", false)
        evaluate("\"a\" != \"b\"", true)
    }
}
