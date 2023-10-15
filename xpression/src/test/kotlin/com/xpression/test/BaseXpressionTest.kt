package com.xpression.test

import com.xpression.Result
import com.xpression.Xpression
import com.xpression.XpressionContext
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

open class BaseXpressionTest {

    private lateinit var context: XpressionContext

    @BeforeEach
    protected fun setup() {
        context = TestContext()
    }

    protected fun evaluate(xpression: Xpression) : Result {
        return xpression.evaluate(context)
    }

    protected fun evaluate(expression: String) : Result {
        val xpression = Xpression(expression)
        return xpression.evaluate(context)
    }

}