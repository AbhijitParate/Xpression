package com.xpression.test

import com.xpression.XpressionElement
import com.xpression.Xpression
import com.xpression.XpressionContext
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach

open class BaseXpressionTest {

    protected lateinit var context: TestXpressionContext

    @BeforeEach
    protected fun setup() {
        context = TestXpressionContext()
    }

    protected fun test(expression: String, result: Any?) {
        val r = evaluate(expression)
        assert(r is XpressionElement.Result.Value)
        r as XpressionElement.Result.Value
        Assertions.assertEquals(result, r.value)
    }

    protected fun evaluate(xpression: Xpression) : XpressionElement {
        return xpression.evaluate(context)
    }

    protected fun evaluate(expression: String) : XpressionElement {
        val xpression = Xpression(expression)
        return xpression.evaluate(context)
    }

}