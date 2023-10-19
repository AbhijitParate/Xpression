// Generated from Expression.g4 by ANTLR 4.13.1
package com.xpression.internal;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code evaluateExpression}
	 * labeled alternative in {@link ExpressionParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluateExpression(ExpressionParser.EvaluateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code infixExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixExpression_Ignored(ExpressionParser.InfixExpression_IgnoredContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scopedExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopedExpression_Ignored(ExpressionParser.ScopedExpression_IgnoredContext ctx);
	/**
	 * Visit a parse tree produced by the {@code roundBracketExpression}
	 * labeled alternative in {@link ExpressionParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoundBracketExpression(ExpressionParser.RoundBracketExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code squareBracketExpression}
	 * labeled alternative in {@link ExpressionParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareBracketExpression(ExpressionParser.SquareBracketExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code curlyBracketExpression}
	 * labeled alternative in {@link ExpressionParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurlyBracketExpression(ExpressionParser.CurlyBracketExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#infixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression_Ignored(ExpressionParser.LogicalExpression_IgnoredContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#infixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression_Ignored(ExpressionParser.TernaryExpression_IgnoredContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link ExpressionParser#ternary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(ExpressionParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpressionOr}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionOr(ExpressionParser.LogicalExpressionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression_Ignored(ExpressionParser.EqualityExpression_IgnoredContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpressionNot}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionNot(ExpressionParser.LogicalExpressionNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpressionAnd}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionAnd(ExpressionParser.LogicalExpressionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression_Ignored(ExpressionParser.ComparisonExpression_IgnoredContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpressionEqualTo}
	 * labeled alternative in {@link ExpressionParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpressionEqualTo(ExpressionParser.EqualityExpressionEqualToContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpressionNotEqualTo}
	 * labeled alternative in {@link ExpressionParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpressionNotEqualTo(ExpressionParser.EqualityExpressionNotEqualToContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additionExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpression_Ignored(ExpressionParser.AdditionExpression_IgnoredContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpressionLessThan}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpressionLessThan(ExpressionParser.ComparisonExpressionLessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpressionLessThanOrEqual}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpressionLessThanOrEqual(ExpressionParser.ComparisonExpressionLessThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpressionGreaterThan}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpressionGreaterThan(ExpressionParser.ComparisonExpressionGreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpressionGreaterThanOrEqual}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpressionGreaterThanOrEqual(ExpressionParser.ComparisonExpressionGreaterThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additionExpression}
	 * labeled alternative in {@link ExpressionParser#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpression(ExpressionParser.AdditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicationExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression_Ignored(ExpressionParser.MultiplicationExpression_IgnoredContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subtractionExpression}
	 * labeled alternative in {@link ExpressionParser#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtractionExpression(ExpressionParser.SubtractionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicationExpression}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(ExpressionParser.MultiplicationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modulousExpression}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulousExpression(ExpressionParser.ModulousExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exponentiationExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentiationExpression_Ignored(ExpressionParser.ExponentiationExpression_IgnoredContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divisionExpression}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivisionExpression(ExpressionParser.DivisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code operationExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#exponentiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationExpression_Ignored(ExpressionParser.OperationExpression_IgnoredContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exponentiationExpression}
	 * labeled alternative in {@link ExpressionParser#exponentiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentiationExpression(ExpressionParser.ExponentiationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(ExpressionParser.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accessorExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessorExpression(ExpressionParser.AccessorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(ExpressionParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scopedExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopedExpression(ExpressionParser.ScopedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectAccessor}
	 * labeled alternative in {@link ExpressionParser#accessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectAccessor(ExpressionParser.ObjectAccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(ExpressionParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ExpressionParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ExpressionParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(ExpressionParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullExpression(ExpressionParser.NullExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(ExpressionParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextExpression(ExpressionParser.TextExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code positiveNumber}
	 * labeled alternative in {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveNumber(ExpressionParser.PositiveNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negativeNumber}
	 * labeled alternative in {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeNumber(ExpressionParser.NegativeNumberContext ctx);
}