// Generated from Expression.g4 by ANTLR 4.13.1
package com.xpression.internal;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code evaluateExpression}
	 * labeled alternative in {@link ExpressionParser#root}.
	 * @param ctx the parse tree
	 */
	void enterEvaluateExpression(ExpressionParser.EvaluateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code evaluateExpression}
	 * labeled alternative in {@link ExpressionParser#root}.
	 * @param ctx the parse tree
	 */
	void exitEvaluateExpression(ExpressionParser.EvaluateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpression_Ignored(ExpressionParser.InfixExpression_IgnoredContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpression_Ignored(ExpressionParser.InfixExpression_IgnoredContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scopedExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterScopedExpression_Ignored(ExpressionParser.ScopedExpression_IgnoredContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scopedExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitScopedExpression_Ignored(ExpressionParser.ScopedExpression_IgnoredContext ctx);
	/**
	 * Enter a parse tree produced by the {@code roundBracketExpression}
	 * labeled alternative in {@link ExpressionParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterRoundBracketExpression(ExpressionParser.RoundBracketExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code roundBracketExpression}
	 * labeled alternative in {@link ExpressionParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitRoundBracketExpression(ExpressionParser.RoundBracketExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code squareBracketExpression}
	 * labeled alternative in {@link ExpressionParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterSquareBracketExpression(ExpressionParser.SquareBracketExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code squareBracketExpression}
	 * labeled alternative in {@link ExpressionParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitSquareBracketExpression(ExpressionParser.SquareBracketExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code curlyBracketExpression}
	 * labeled alternative in {@link ExpressionParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterCurlyBracketExpression(ExpressionParser.CurlyBracketExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code curlyBracketExpression}
	 * labeled alternative in {@link ExpressionParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitCurlyBracketExpression(ExpressionParser.CurlyBracketExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#infixExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression_Ignored(ExpressionParser.LogicalExpression_IgnoredContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#infixExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression_Ignored(ExpressionParser.LogicalExpression_IgnoredContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#infixExpression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression_Ignored(ExpressionParser.TernaryExpression_IgnoredContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#infixExpression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression_Ignored(ExpressionParser.TernaryExpression_IgnoredContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link ExpressionParser#ternary}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(ExpressionParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link ExpressionParser#ternary}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(ExpressionParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpressionOr}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionOr(ExpressionParser.LogicalExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpressionOr}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionOr(ExpressionParser.LogicalExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression_Ignored(ExpressionParser.EqualityExpression_IgnoredContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression_Ignored(ExpressionParser.EqualityExpression_IgnoredContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpressionNot}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionNot(ExpressionParser.LogicalExpressionNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpressionNot}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionNot(ExpressionParser.LogicalExpressionNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpressionAnd}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionAnd(ExpressionParser.LogicalExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpressionAnd}
	 * labeled alternative in {@link ExpressionParser#logical}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionAnd(ExpressionParser.LogicalExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression_Ignored(ExpressionParser.ComparisonExpression_IgnoredContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression_Ignored(ExpressionParser.ComparisonExpression_IgnoredContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpressionEqualTo}
	 * labeled alternative in {@link ExpressionParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpressionEqualTo(ExpressionParser.EqualityExpressionEqualToContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpressionEqualTo}
	 * labeled alternative in {@link ExpressionParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpressionEqualTo(ExpressionParser.EqualityExpressionEqualToContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpressionNotEqualTo}
	 * labeled alternative in {@link ExpressionParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpressionNotEqualTo(ExpressionParser.EqualityExpressionNotEqualToContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpressionNotEqualTo}
	 * labeled alternative in {@link ExpressionParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpressionNotEqualTo(ExpressionParser.EqualityExpressionNotEqualToContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additionExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpression_Ignored(ExpressionParser.AdditionExpression_IgnoredContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additionExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpression_Ignored(ExpressionParser.AdditionExpression_IgnoredContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpressionLessThan}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpressionLessThan(ExpressionParser.ComparisonExpressionLessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpressionLessThan}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpressionLessThan(ExpressionParser.ComparisonExpressionLessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpressionLessThanOrEqual}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpressionLessThanOrEqual(ExpressionParser.ComparisonExpressionLessThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpressionLessThanOrEqual}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpressionLessThanOrEqual(ExpressionParser.ComparisonExpressionLessThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpressionGreaterThan}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpressionGreaterThan(ExpressionParser.ComparisonExpressionGreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpressionGreaterThan}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpressionGreaterThan(ExpressionParser.ComparisonExpressionGreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpressionGreaterThanOrEqual}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpressionGreaterThanOrEqual(ExpressionParser.ComparisonExpressionGreaterThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpressionGreaterThanOrEqual}
	 * labeled alternative in {@link ExpressionParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpressionGreaterThanOrEqual(ExpressionParser.ComparisonExpressionGreaterThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additionExpression}
	 * labeled alternative in {@link ExpressionParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpression(ExpressionParser.AdditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additionExpression}
	 * labeled alternative in {@link ExpressionParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpression(ExpressionParser.AdditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicationExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression_Ignored(ExpressionParser.MultiplicationExpression_IgnoredContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicationExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression_Ignored(ExpressionParser.MultiplicationExpression_IgnoredContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subtractionExpression}
	 * labeled alternative in {@link ExpressionParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterSubtractionExpression(ExpressionParser.SubtractionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subtractionExpression}
	 * labeled alternative in {@link ExpressionParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitSubtractionExpression(ExpressionParser.SubtractionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicationExpression}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression(ExpressionParser.MultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicationExpression}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression(ExpressionParser.MultiplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulousExpression}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void enterModulousExpression(ExpressionParser.ModulousExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulousExpression}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void exitModulousExpression(ExpressionParser.ModulousExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exponentiationExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void enterExponentiationExpression_Ignored(ExpressionParser.ExponentiationExpression_IgnoredContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exponentiationExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void exitExponentiationExpression_Ignored(ExpressionParser.ExponentiationExpression_IgnoredContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divisionExpression}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void enterDivisionExpression(ExpressionParser.DivisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divisionExpression}
	 * labeled alternative in {@link ExpressionParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void exitDivisionExpression(ExpressionParser.DivisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code operationExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#exponentiation}.
	 * @param ctx the parse tree
	 */
	void enterOperationExpression_Ignored(ExpressionParser.OperationExpression_IgnoredContext ctx);
	/**
	 * Exit a parse tree produced by the {@code operationExpression_Ignored}
	 * labeled alternative in {@link ExpressionParser#exponentiation}.
	 * @param ctx the parse tree
	 */
	void exitOperationExpression_Ignored(ExpressionParser.OperationExpression_IgnoredContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exponentiationExpression}
	 * labeled alternative in {@link ExpressionParser#exponentiation}.
	 * @param ctx the parse tree
	 */
	void enterExponentiationExpression(ExpressionParser.ExponentiationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exponentiationExpression}
	 * labeled alternative in {@link ExpressionParser#exponentiation}.
	 * @param ctx the parse tree
	 */
	void exitExponentiationExpression(ExpressionParser.ExponentiationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(ExpressionParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(ExpressionParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accessorExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterAccessorExpression(ExpressionParser.AccessorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accessorExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitAccessorExpression(ExpressionParser.AccessorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(ExpressionParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(ExpressionParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scopedExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterScopedExpression(ExpressionParser.ScopedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scopedExpression}
	 * labeled alternative in {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitScopedExpression(ExpressionParser.ScopedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objectAccessor}
	 * labeled alternative in {@link ExpressionParser#accessor}.
	 * @param ctx the parse tree
	 */
	void enterObjectAccessor(ExpressionParser.ObjectAccessorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objectAccessor}
	 * labeled alternative in {@link ExpressionParser#accessor}.
	 * @param ctx the parse tree
	 */
	void exitObjectAccessor(ExpressionParser.ObjectAccessorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(ExpressionParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(ExpressionParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ExpressionParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ExpressionParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ExpressionParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ExpressionParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(ExpressionParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(ExpressionParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullExpression(ExpressionParser.NullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullExpression(ExpressionParser.NullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(ExpressionParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(ExpressionParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code textExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterTextExpression(ExpressionParser.TextExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code textExpression}
	 * labeled alternative in {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitTextExpression(ExpressionParser.TextExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code positiveNumber}
	 * labeled alternative in {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void enterPositiveNumber(ExpressionParser.PositiveNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code positiveNumber}
	 * labeled alternative in {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void exitPositiveNumber(ExpressionParser.PositiveNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negativeNumber}
	 * labeled alternative in {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNegativeNumber(ExpressionParser.NegativeNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negativeNumber}
	 * labeled alternative in {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNegativeNumber(ExpressionParser.NegativeNumberContext ctx);
}