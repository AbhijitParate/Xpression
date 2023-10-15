package com.xpression.internal

import com.xpression.XpressionElement
import com.xpression.XpressionContext
import com.xpression.XpressionElement.Result
import com.xpression.internal.Converter.toNegativeNumber
import com.xpression.internal.Converter.toPositiveNumber
import com.xpression.internal.ExpressionParser.*
import com.xpression.internal.component.ComponentProvider
import org.antlr.v4.runtime.tree.ParseTree
import org.apache.commons.text.StringEscapeUtils

class XpressionVisitor(
    private val context: XpressionContext,
    private val provider: ComponentProvider
) : ExpressionBaseVisitor<XpressionElement>() {

    override fun visit(tree: ParseTree?): XpressionElement {
        return super.visit(tree)
    }

    override fun visitLiteralExpression(ctx: LiteralExpressionContext?): XpressionElement {
        return super.visitLiteralExpression(ctx)
    }

    override fun visitAccessorExpression(ctx: AccessorExpressionContext?): XpressionElement {
        return super.visitAccessorExpression(ctx)
    }

    override fun visitFunctionExpression(ctx: FunctionExpressionContext?): XpressionElement {
        return super.visitFunctionExpression(ctx)
    }

    override fun visitScopedExpression(ctx: ScopedExpressionContext): XpressionElement {
        return visit(ctx.scope())
    }

    override fun visitObjectAccessor(ctx: ObjectAccessorContext): Result {
        val symbol = ctx.special?.text.orEmpty()
        val properties = ctx.property().map { visit(it) as XpressionElement.Property }
        val accessor = XpressionElement.Accessor(symbol = symbol, properties = properties.toTypedArray())
        return context.resolve(accessor)
    }

    override fun visitProperty(ctx: PropertyContext): XpressionElement.Property {
        val identifier = super.visit(ctx.identifier()) as XpressionElement.Identifier
        return XpressionElement.Property(identifier.name)
    }

    override fun visitFunction(ctx: FunctionContext): Result {
        val functionIdentifier = visit(ctx.identifier()) as XpressionElement.Identifier
        val function = provider.getFunction(functionIdentifier.name)
        return function.evaluate(this, ctx, context)
    }

    override fun visitIdentifier(ctx: IdentifierContext): XpressionElement.Identifier {
        val identifier = ctx.IDENTIFIER().text
        return XpressionElement.Identifier(identifier)
    }

    override fun visitBooleanExpression(ctx: BooleanExpressionContext): Result {
        val bool = ctx.BOOLEAN().text.lowercase().toBoolean()
        return Result.Value(bool)
    }

    override fun visitNullExpression(ctx: NullExpressionContext?): Result {
        return Result.nullValue()
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