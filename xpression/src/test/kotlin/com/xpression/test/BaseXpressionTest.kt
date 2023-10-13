package com.xpression.test

import com.xpression.Result
import com.xpression.Xpression
import com.xpression.XpressionContext

class BaseXpressionTest {

    lateinit var context: XpressionContext

    protected fun evaluate(xpression: Xpression) : Result {
        return xpression.evaluate(context)
    }

    protected fun evaluate(expression: String) : Result {
        val xpression = Xpression(expression)
        return xpression.evaluate(context)
    }

}