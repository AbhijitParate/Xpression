package com.xpression.test

import kotlin.test.Test

class ArithmeticExpressionTests : BaseXpressionTest() {

  @Test
  fun testExpressionWithBrackets() {
    test("[1 + 2] * 3", 9.0)
  }

  @Test
  fun testExpressionWithNestedBrackets() {
    test("([1 + 2] * 3) + 4", 13.0)
  }

  @Test
  fun testExpressionWithMixedOperators() {
    test("[1 + 2] * 3 - 4 / 5", 8.2)
  }
}
