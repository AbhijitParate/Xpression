package com.xpression

import com.xpression.Xpression.Result
import com.xpression.Xpression.XpressionElement

open class XpressionContext(val parentContext: XpressionContext? = null) {

    open fun resolve(accessor: XpressionElement.Accessor): Result {
        return Result.nullValue()
    }

    companion object {
        internal val DEFAULT = XpressionContext()
    }
}