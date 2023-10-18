package com.xpression.test

import kotlin.test.Test

class ComparisonExpressionsTests : BaseXpressionTest() {

  @Test
  fun testExpressionWithBrackets() {
    evaluate("[1 + 2] * 3", 9.0)
  }

  @Test
  fun testExpressionWithNestedBrackets() {
    evaluate("([1 + 2] * 3) + 4", 13.0)
  }

  @Test
  fun testExpressionWithMixedOperators() {
    evaluate("[1 + 2] * 3 - 4 / 5", 8.2)
  }
}
