package com.xpression.internal

import com.xpression.Xpression.*
import com.xpression.XpressionContext
import com.xpression.internal.Converter.toNegativeNumber
import com.xpression.internal.Converter.toPositiveNumber
import com.xpression.internal.ExpressionParser.*
import com.xpression.internal.operator.Operator.Companion.TERNARY_OPERATOR
import org.antlr.v4.runtime.tree.ParseTree
import org.apache.commons.text.StringEscapeUtils

internal class Visitor(
    private val context: XpressionContext,
    private val provider: Provider
) : ExpressionBaseVisitor<XpressionElement>() {

    override fun visit(tree: ParseTree?): XpressionElement = super.visit(tree)

    override fun visitEvaluateExpression(ctx: EvaluateExpressionContext): XpressionElement {
        return visit(ctx.expression())
    }

    override fun visitScopedExpression(ctx: ScopedExpressionContext): XpressionElement {
        return visit(ctx.scope())
    }

    override fun visitRoundBracketExpression(ctx: RoundBracketExpressionContext): XpressionElement {
        return visit(ctx.infixExpression())
    }

    override fun visitSquareBracketExpression(ctx: SquareBracketExpressionContext): XpressionElement {
        return visit(ctx.infixExpression())
    }

    override fun visitCurlyBracketExpression(ctx: CurlyBracketExpressionContext): XpressionElement {
        return visit(ctx.infixExpression())
    }

    override fun visitTernaryExpression(ctx: TernaryExpressionContext): XpressionElement {
        return evaluate(
            TERNARY_OPERATOR,
            visit(ctx.logical(0)) as Result,
            visit(ctx.logical(1)) as Result,
            visit(ctx.logical(2)) as Result,
        )
    }

    override fun visitLogicalExpressionNot(ctx: LogicalExpressionNotContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result)
    }

    override fun visitLogicalExpressionAnd(ctx: LogicalExpressionAndContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitLogicalExpressionOr(ctx: LogicalExpressionOrContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitEqualityExpressionEqualTo(ctx: EqualityExpressionEqualToContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitEqualityExpressionNotEqualTo(ctx: EqualityExpressionNotEqualToContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitComparisonExpressionLessThan(ctx: ComparisonExpressionLessThanContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitComparisonExpressionLessThanOrEqual(ctx: ComparisonExpressionLessThanOrEqualContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitComparisonExpressionGreaterThan(ctx: ComparisonExpressionGreaterThanContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitComparisonExpressionGreaterThanOrEqual(ctx: ComparisonExpressionGreaterThanOrEqualContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitAdditionExpression(ctx: AdditionExpressionContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitSubtractionExpression(ctx: SubtractionExpressionContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitMultiplicationExpression(ctx: MultiplicationExpressionContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitDivisionExpression(ctx: DivisionExpressionContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitModulousExpression(ctx: ModulousExpressionContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    override fun visitExponentiationExpression(ctx: ExponentiationExpressionContext): XpressionElement {
        return evaluate(ctx.operator.text, visit(ctx.left) as Result, visit(ctx.right) as Result)
    }

    private fun evaluate(operator: String, vararg operands: Result): Result {
        val function = provider.getOperator(operator)
        return function.evaluate(operands = operands)
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
        return function.evaluate(this, functionContext = ctx, xpressionContext = context)
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