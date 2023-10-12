package com.xpression.test

import org.junit.jupiter.api.Test

class TernaryExpressionsTests : BaseXpressionTest() {

  @Test
  fun testTernaryOperator() {
    evaluate("1 > 2 ? 10 : 20", 20.0)
    evaluate("1 <= 2 ? 10 : 20", 10.0)
    evaluate("true ? 10 : 20", 10.0)
    evaluate("false ? 10 : 20", 20.0)
  }

  @Test
  fun testTernaryOperatorWithMultipleOperators() {
    evaluate("(1 + 2) > 3 ? 10 : 20", 20.0)
    evaluate("(1 + 2) <= 3 ? 10 : 20", 10.0)
    evaluate("(1 + 2) > 3 && (4 + 5) > 9 ? 10 : 20", 20.0)
    evaluate("(1 + 2) > 3 || (4 + 5) > 9 ? 10 : 20", 20.0)
  }

  @Test
  fun testTernaryOperatorWithStrings() {
    evaluateError("\"a\" > \"b\" ? \"first\" : \"second\"")
    evaluateError("\"a\" <= \"b\" ? \"first\" : \"second\"")
    evaluate("true ? \"first\" : \"second\"", "first")
    evaluate("false ? \"first\" : \"second\"", "second")
  }

  @Test
  fun testTernaryOperatorWithMultipleStrings() {
    evaluateError("(\"a\" + \"b\") <= \"c\" ? \"first\" : \"second\"")
    evaluateError("(\"a\" + \"b\") > \"c\" && (\"d\" + \"e\") > \"f\" ? \"first\" : \"second\"")
    evaluateError("(\"a\" + \"b\") > \"c\" || (\"d\" + \"e\") > \"f\" ? \"first\" : \"second\"")
    evaluateError("(\"a\" + \"b\") > \"c\" ? \"first\" : \"second\"")
  }
}
