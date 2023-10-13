package com.xpression.internal

import com.xpression.ExpressionBaseVisitor
import com.xpression.Result
import com.xpression.XpressionContext
import org.antlr.v4.runtime.tree.ParseTree

class ExpressionVisitor(
    private val context: XpressionContext
) : ExpressionBaseVisitor<Result>() {

    override fun visit(tree: ParseTree?): Result {
        return super.visit(tree)
    }

}