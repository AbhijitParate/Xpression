package com.xpression.test

import kotlin.test.Test

class TernaryExpressionsTests : BaseXpressionTest() {

  @Test
  fun testTernaryOperator() {
    evaluate("1 > 2 ? 10 : 20", 20)
    evaluate("1 <= 2 ? 10 : 20", 10)
    evaluate("true ? 10 : 20", 10)
    evaluate("false ? 10 : 20", 20)
  }

  @Test
  fun testTernaryOperatorWithMultipleOperators() {
    evaluate("(1 + 2) > 3 ? 10 : 20", 20)
    evaluate("(1 + 2) <= 3 ? 10 : 20", 10)
    evaluate("(1 + 2) > 3 && (4 + 5) > 9 ? 10 : 20", 20)
    evaluate("(1 + 2) > 3 || (4 + 5) > 9 ? 10 : 20", 10)
  }

  @Test
  fun testTernaryOperatorWithStrings() {
    evaluate("\"a\" > \"b\" ? \"first\" : \"second\"", "second")
    evaluate("\"a\" <= \"b\" ? \"first\" : \"second\"", "first")
    evaluate("true ? \"first\" : \"second\"", "first")
    evaluate("false ? \"first\" : \"second\"", "second")
  }

  @Test
  fun testTernaryOperatorWithMultipleStrings() {
    evaluate("(\"a\" + \"b\") > \"c\" ? \"first\" : \"second\"", "second")
    evaluate("(\"a\" + \"b\") <= \"c\" ? \"first\" : \"second\"", "first")
    evaluate("(\"a\" + \"b\") > \"c\" && (\"d\" + \"e\") > \"f\" ? \"first\" : \"second\"", "second")
    evaluate("(\"a\" + \"b\") > \"c\" || (\"d\" + \"e\") > \"f\" ? \"first\" : \"second\"", "first")
  }
}
