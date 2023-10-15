package com.xpression.internal

import com.xpression.Result
import com.xpression.XpressionContext
import com.xpression.internal.Converter.toNegativeNumber
import com.xpression.internal.Converter.toPositiveNumber
import com.xpression.internal.ExpressionParser.*
import org.antlr.v4.runtime.tree.ParseTree
import org.apache.commons.text.StringEscapeUtils

class XpressionVisitor(
    private val context: XpressionContext
) : ExpressionBaseVisitor<Result>() {

    override fun visit(tree: ParseTree?): Result {
        return super.visit(tree)
    }

    override fun visitBooleanExpression(ctx: BooleanExpressionContext): Result {
        val bool = ctx.BOOLEAN().text.lowercase().toBoolean()
        return Result.Value(bool)
    }

    override fun visitNullExpression(ctx: NullExpressionContext?): Result {
        return Result.Null()
    }

    override fun visitTextExpression(ctx: TextExpressionContext): Result {
        var text = StringEscapeUtils.unescapeJava(ctx.TEXT().text)
        text = text.subSequence(1 until text.lastIndex).toString()
        return Result.Value(text)
    }

    override fun visitPositiveNumber(ctx: PositiveNumberContext): Result {
        val number = ctx.NUMBER().text.toPositiveNumber(context)
        return Result.Value(number)
    }

    override fun visitNegativeNumber(ctx: NegativeNumberContext): Result {
        val number = ctx.NUMBER().text.toNegativeNumber(context)
        return Result.Value(number)
    }
}