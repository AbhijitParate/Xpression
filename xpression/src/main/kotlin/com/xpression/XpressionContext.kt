package com.xpression

import com.xpression.Xpression.*

abstract class XpressionContext {
    abstract fun resolve(accessor: XpressionElement.Accessor): Result
}