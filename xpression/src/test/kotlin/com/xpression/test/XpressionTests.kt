package com.xpression.test

import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite
import org.junit.platform.suite.api.SuiteDisplayName

@Suite
@SuiteDisplayName("Xpression Tests")
@SelectClasses(
    AccessorTest::class,
    ArithmeticExpressionsTests::class,
    ComparisonExpressionsTests::class,
    FunctionTests::class,
    LiteralsTests::class,
    LogicalExpressionsTests::class,
    TernaryExpressionsTests::class
)
class XpressionTests