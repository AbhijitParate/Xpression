package com.xpression.test

import com.xpression.Xpression.*
import com.xpression.Xpression
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach

open class BaseXpressionTest {

    protected lateinit var context: TestXpressionContext

    @BeforeEach
    protected fun setup() {
        context = TestXpressionContext()
    }

    protected fun evaluateError(expression: String) {
        val r = evaluate(expression)
        assert(r is Result.Error) {
            "Expected: Error, Received: Value(${r.value?.javaClass?.simpleName.orEmpty()})"
        }
        println(r.message)
    }

    protected fun evaluate(expression: String, result: Any?) {
        val r = evaluate(expression)
        assert(r is Result.Value) { r.toString() }
        r as Result.Value
        Assertions.assertEquals(result, r.value)
    }

    protected fun evaluate(xpression: Xpression) : Result {
        return xpression.evaluate(context)
    }

    protected fun evaluate(expression: String) : Result {
        val xpression = Xpression(expression)
        return xpression.evaluate(context)
    }

}