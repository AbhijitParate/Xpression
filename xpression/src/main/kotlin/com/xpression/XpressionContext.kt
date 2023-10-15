package com.xpression

import com.xpression.XpressionElement.*

abstract class XpressionContext {
    abstract fun resolve(accessor: Accessor): Result
}