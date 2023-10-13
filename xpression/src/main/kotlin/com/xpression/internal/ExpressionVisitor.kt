package com.xpression.internal

import com.xpression.ExpressionBaseVisitor
import com.xpression.ExpressionParser
import com.xpression.Result
import com.xpression.XpressionContext
import com.xpression.internal.Converter.toNegativeNumber
import com.xpression.internal.Converter.toPositiveNumber
import org.antlr.v4.runtime.tree.ParseTree

class ExpressionVisitor(
    private val context: XpressionContext
) : ExpressionBaseVisitor<Result>() {

    override fun visit(tree: ParseTree?): Result {
        return super.visit(tree)
    }

    override fun visitPositiveNumber(ctx: ExpressionParser.PositiveNumberContext): Result {
        val number = ctx.NUMBER().text.toPositiveNumber(context)
        return Result.Value(number)
    }

    override fun visitNegativeNumber(ctx: ExpressionParser.NegativeNumberContext): Result {
        val number = ctx.NUMBER().text.toNegativeNumber(context)
        return Result.Value(number)
    }
}