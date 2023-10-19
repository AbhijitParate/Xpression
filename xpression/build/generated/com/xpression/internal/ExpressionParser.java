// Generated from Expression.g4 by ANTLR 4.13.1
package com.xpression.internal;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, TEXT=13, NUMBER=14, NULL=15, BOOLEAN=16, 
		IDENTIFIER=17, SQUOTE=18, DQUOTE=19, ACCESSOR=20, CONCATINATOR=21, ADD=22, 
		SUB=23, MUL=24, DIV=25, MOD=26, POW=27, AND=28, OR=29, NOT=30, GT=31, 
		GE=32, LT=33, LE=34, EQ=35, NEQ=36, WS=37;
	public static final int
		RULE_root = 0, RULE_expression = 1, RULE_scope = 2, RULE_infixExpression = 3, 
		RULE_ternary = 4, RULE_logical = 5, RULE_equality = 6, RULE_comparison = 7, 
		RULE_addition = 8, RULE_multiplication = 9, RULE_exponentiation = 10, 
		RULE_operation = 11, RULE_accessor = 12, RULE_property = 13, RULE_function = 14, 
		RULE_identifier = 15, RULE_literal = 16, RULE_number = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "expression", "scope", "infixExpression", "ternary", "logical", 
			"equality", "comparison", "addition", "multiplication", "exponentiation", 
			"operation", "accessor", "property", "function", "identifier", "literal", 
			"number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'?'", "':'", "'$'", 
			"'#'", "'@'", "','", null, null, null, null, null, "'''", "'\"'", "'.'", 
			"'&'", "'+'", "'-'", "'*'", "'/'", "'%'", "'^'", "'&&'", "'||'", "'!'", 
			"'>'", "'>='", "'<'", "'<='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TEXT", "NUMBER", "NULL", "BOOLEAN", "IDENTIFIER", "SQUOTE", "DQUOTE", 
			"ACCESSOR", "CONCATINATOR", "ADD", "SUB", "MUL", "DIV", "MOD", "POW", 
			"AND", "OR", "NOT", "GT", "GE", "LT", "LE", "EQ", "NEQ", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
	 
		public RootContext() { }
		public void copyFrom(RootContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EvaluateExpressionContext extends RootContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExpressionParser.EOF, 0); }
		public EvaluateExpressionContext(RootContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterEvaluateExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitEvaluateExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitEvaluateExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			_localctx = new EvaluateExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			expression();
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScopedExpression_IgnoredContext extends ExpressionContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public ScopedExpression_IgnoredContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterScopedExpression_Ignored(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitScopedExpression_Ignored(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitScopedExpression_Ignored(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InfixExpression_IgnoredContext extends ExpressionContext {
		public InfixExpressionContext infixExpression() {
			return getRuleContext(InfixExpressionContext.class,0);
		}
		public InfixExpression_IgnoredContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterInfixExpression_Ignored(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitInfixExpression_Ignored(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitInfixExpression_Ignored(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new InfixExpression_IgnoredContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				infixExpression();
				}
				break;
			case 2:
				_localctx = new ScopedExpression_IgnoredContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				scope();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScopeContext extends ParserRuleContext {
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
	 
		public ScopeContext() { }
		public void copyFrom(ScopeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CurlyBracketExpressionContext extends ScopeContext {
		public InfixExpressionContext infixExpression() {
			return getRuleContext(InfixExpressionContext.class,0);
		}
		public CurlyBracketExpressionContext(ScopeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterCurlyBracketExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitCurlyBracketExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitCurlyBracketExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RoundBracketExpressionContext extends ScopeContext {
		public InfixExpressionContext infixExpression() {
			return getRuleContext(InfixExpressionContext.class,0);
		}
		public RoundBracketExpressionContext(ScopeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterRoundBracketExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitRoundBracketExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitRoundBracketExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SquareBracketExpressionContext extends ScopeContext {
		public InfixExpressionContext infixExpression() {
			return getRuleContext(InfixExpressionContext.class,0);
		}
		public SquareBracketExpressionContext(ScopeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterSquareBracketExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitSquareBracketExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitSquareBracketExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_scope);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new RoundBracketExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(T__0);
				setState(44);
				infixExpression();
				setState(45);
				match(T__1);
				}
				break;
			case T__2:
				_localctx = new SquareBracketExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(T__2);
				setState(48);
				infixExpression();
				setState(49);
				match(T__3);
				}
				break;
			case T__4:
				_localctx = new CurlyBracketExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				match(T__4);
				setState(52);
				infixExpression();
				setState(53);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InfixExpressionContext extends ParserRuleContext {
		public InfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixExpression; }
	 
		public InfixExpressionContext() { }
		public void copyFrom(InfixExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TernaryExpression_IgnoredContext extends InfixExpressionContext {
		public TernaryContext ternary() {
			return getRuleContext(TernaryContext.class,0);
		}
		public TernaryExpression_IgnoredContext(InfixExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterTernaryExpression_Ignored(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitTernaryExpression_Ignored(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitTernaryExpression_Ignored(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExpression_IgnoredContext extends InfixExpressionContext {
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public LogicalExpression_IgnoredContext(InfixExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLogicalExpression_Ignored(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLogicalExpression_Ignored(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitLogicalExpression_Ignored(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfixExpressionContext infixExpression() throws RecognitionException {
		InfixExpressionContext _localctx = new InfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_infixExpression);
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new LogicalExpression_IgnoredContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				logical(0);
				}
				break;
			case 2:
				_localctx = new TernaryExpression_IgnoredContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				ternary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TernaryContext extends ParserRuleContext {
		public TernaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary; }
	 
		public TernaryContext() { }
		public void copyFrom(TernaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TernaryExpressionContext extends TernaryContext {
		public List<LogicalContext> logical() {
			return getRuleContexts(LogicalContext.class);
		}
		public LogicalContext logical(int i) {
			return getRuleContext(LogicalContext.class,i);
		}
		public TernaryExpressionContext(TernaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterTernaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitTernaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernaryContext ternary() throws RecognitionException {
		TernaryContext _localctx = new TernaryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ternary);
		try {
			_localctx = new TernaryExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			logical(0);
			setState(62);
			match(T__6);
			setState(63);
			logical(0);
			setState(64);
			match(T__7);
			setState(65);
			logical(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalContext extends ParserRuleContext {
		public LogicalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical; }
	 
		public LogicalContext() { }
		public void copyFrom(LogicalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExpressionOrContext extends LogicalContext {
		public LogicalContext left;
		public Token operator;
		public EqualityContext right;
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public TerminalNode OR() { return getToken(ExpressionParser.OR, 0); }
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public LogicalExpressionOrContext(LogicalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLogicalExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLogicalExpressionOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitLogicalExpressionOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpression_IgnoredContext extends LogicalContext {
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public EqualityExpression_IgnoredContext(LogicalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterEqualityExpression_Ignored(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitEqualityExpression_Ignored(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitEqualityExpression_Ignored(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExpressionNotContext extends LogicalContext {
		public Token operator;
		public LogicalContext left;
		public TerminalNode NOT() { return getToken(ExpressionParser.NOT, 0); }
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public LogicalExpressionNotContext(LogicalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLogicalExpressionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLogicalExpressionNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitLogicalExpressionNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExpressionAndContext extends LogicalContext {
		public LogicalContext left;
		public Token operator;
		public EqualityContext right;
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public TerminalNode AND() { return getToken(ExpressionParser.AND, 0); }
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public LogicalExpressionAndContext(LogicalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLogicalExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLogicalExpressionAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitLogicalExpressionAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalContext logical() throws RecognitionException {
		return logical(0);
	}

	private LogicalContext logical(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalContext _localctx = new LogicalContext(_ctx, _parentState);
		LogicalContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_logical, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__2:
			case T__4:
			case T__8:
			case T__9:
			case T__10:
			case TEXT:
			case NUMBER:
			case NULL:
			case BOOLEAN:
			case IDENTIFIER:
			case SUB:
				{
				_localctx = new EqualityExpression_IgnoredContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(68);
				equality(0);
				}
				break;
			case NOT:
				{
				_localctx = new LogicalExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				((LogicalExpressionNotContext)_localctx).operator = match(NOT);
				setState(70);
				((LogicalExpressionNotContext)_localctx).left = logical(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(79);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new LogicalContext(_parentctx, _parentState));
						((LogicalExpressionAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logical);
						setState(73);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(74);
						((LogicalExpressionAndContext)_localctx).operator = match(AND);
						setState(75);
						((LogicalExpressionAndContext)_localctx).right = equality(0);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new LogicalContext(_parentctx, _parentState));
						((LogicalExpressionOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logical);
						setState(76);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(77);
						((LogicalExpressionOrContext)_localctx).operator = match(OR);
						setState(78);
						((LogicalExpressionOrContext)_localctx).right = equality(0);
						}
						break;
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityContext extends ParserRuleContext {
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
	 
		public EqualityContext() { }
		public void copyFrom(EqualityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpression_IgnoredContext extends EqualityContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public ComparisonExpression_IgnoredContext(EqualityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterComparisonExpression_Ignored(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitComparisonExpression_Ignored(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitComparisonExpression_Ignored(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionEqualToContext extends EqualityContext {
		public EqualityContext left;
		public Token operator;
		public ComparisonContext right;
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ExpressionParser.EQ, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public EqualityExpressionEqualToContext(EqualityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterEqualityExpressionEqualTo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitEqualityExpressionEqualTo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitEqualityExpressionEqualTo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionNotEqualToContext extends EqualityContext {
		public EqualityContext left;
		public Token operator;
		public ComparisonContext right;
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public TerminalNode NEQ() { return getToken(ExpressionParser.NEQ, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public EqualityExpressionNotEqualToContext(EqualityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterEqualityExpressionNotEqualTo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitEqualityExpressionNotEqualTo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitEqualityExpressionNotEqualTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		return equality(0);
	}

	private EqualityContext equality(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityContext _localctx = new EqualityContext(_ctx, _parentState);
		EqualityContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_equality, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ComparisonExpression_IgnoredContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(85);
			comparison();
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(93);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityExpressionEqualToContext(new EqualityContext(_parentctx, _parentState));
						((EqualityExpressionEqualToContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_equality);
						setState(87);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(88);
						((EqualityExpressionEqualToContext)_localctx).operator = match(EQ);
						setState(89);
						((EqualityExpressionEqualToContext)_localctx).right = comparison();
						}
						break;
					case 2:
						{
						_localctx = new EqualityExpressionNotEqualToContext(new EqualityContext(_parentctx, _parentState));
						((EqualityExpressionNotEqualToContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_equality);
						setState(90);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(91);
						((EqualityExpressionNotEqualToContext)_localctx).operator = match(NEQ);
						setState(92);
						((EqualityExpressionNotEqualToContext)_localctx).right = comparison();
						}
						break;
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ParserRuleContext {
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
	 
		public ComparisonContext() { }
		public void copyFrom(ComparisonContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionGreaterThanOrEqualContext extends ComparisonContext {
		public AdditionContext left;
		public Token operator;
		public AdditionContext right;
		public List<AdditionContext> addition() {
			return getRuleContexts(AdditionContext.class);
		}
		public AdditionContext addition(int i) {
			return getRuleContext(AdditionContext.class,i);
		}
		public TerminalNode GE() { return getToken(ExpressionParser.GE, 0); }
		public ComparisonExpressionGreaterThanOrEqualContext(ComparisonContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterComparisonExpressionGreaterThanOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitComparisonExpressionGreaterThanOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitComparisonExpressionGreaterThanOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionLessThanContext extends ComparisonContext {
		public AdditionContext left;
		public Token operator;
		public AdditionContext right;
		public List<AdditionContext> addition() {
			return getRuleContexts(AdditionContext.class);
		}
		public AdditionContext addition(int i) {
			return getRuleContext(AdditionContext.class,i);
		}
		public TerminalNode LT() { return getToken(ExpressionParser.LT, 0); }
		public ComparisonExpressionLessThanContext(ComparisonContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterComparisonExpressionLessThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitComparisonExpressionLessThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitComparisonExpressionLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionLessThanOrEqualContext extends ComparisonContext {
		public AdditionContext left;
		public Token operator;
		public AdditionContext right;
		public List<AdditionContext> addition() {
			return getRuleContexts(AdditionContext.class);
		}
		public AdditionContext addition(int i) {
			return getRuleContext(AdditionContext.class,i);
		}
		public TerminalNode LE() { return getToken(ExpressionParser.LE, 0); }
		public ComparisonExpressionLessThanOrEqualContext(ComparisonContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterComparisonExpressionLessThanOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitComparisonExpressionLessThanOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitComparisonExpressionLessThanOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionGreaterThanContext extends ComparisonContext {
		public AdditionContext left;
		public Token operator;
		public AdditionContext right;
		public List<AdditionContext> addition() {
			return getRuleContexts(AdditionContext.class);
		}
		public AdditionContext addition(int i) {
			return getRuleContext(AdditionContext.class,i);
		}
		public TerminalNode GT() { return getToken(ExpressionParser.GT, 0); }
		public ComparisonExpressionGreaterThanContext(ComparisonContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterComparisonExpressionGreaterThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitComparisonExpressionGreaterThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitComparisonExpressionGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditionExpression_IgnoredContext extends ComparisonContext {
		public AdditionContext addition() {
			return getRuleContext(AdditionContext.class,0);
		}
		public AdditionExpression_IgnoredContext(ComparisonContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAdditionExpression_Ignored(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAdditionExpression_Ignored(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAdditionExpression_Ignored(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comparison);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new AdditionExpression_IgnoredContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				addition(0);
				}
				break;
			case 2:
				_localctx = new ComparisonExpressionLessThanContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				((ComparisonExpressionLessThanContext)_localctx).left = addition(0);
				setState(100);
				((ComparisonExpressionLessThanContext)_localctx).operator = match(LT);
				setState(101);
				((ComparisonExpressionLessThanContext)_localctx).right = addition(0);
				}
				break;
			case 3:
				_localctx = new ComparisonExpressionLessThanOrEqualContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				((ComparisonExpressionLessThanOrEqualContext)_localctx).left = addition(0);
				setState(104);
				((ComparisonExpressionLessThanOrEqualContext)_localctx).operator = match(LE);
				setState(105);
				((ComparisonExpressionLessThanOrEqualContext)_localctx).right = addition(0);
				}
				break;
			case 4:
				_localctx = new ComparisonExpressionGreaterThanContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				((ComparisonExpressionGreaterThanContext)_localctx).left = addition(0);
				setState(108);
				((ComparisonExpressionGreaterThanContext)_localctx).operator = match(GT);
				setState(109);
				((ComparisonExpressionGreaterThanContext)_localctx).right = addition(0);
				}
				break;
			case 5:
				_localctx = new ComparisonExpressionGreaterThanOrEqualContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				((ComparisonExpressionGreaterThanOrEqualContext)_localctx).left = addition(0);
				setState(112);
				((ComparisonExpressionGreaterThanOrEqualContext)_localctx).operator = match(GE);
				setState(113);
				((ComparisonExpressionGreaterThanOrEqualContext)_localctx).right = addition(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditionContext extends ParserRuleContext {
		public AdditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addition; }
	 
		public AdditionContext() { }
		public void copyFrom(AdditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditionExpressionContext extends AdditionContext {
		public AdditionContext left;
		public Token operator;
		public MultiplicationContext right;
		public AdditionContext addition() {
			return getRuleContext(AdditionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(ExpressionParser.ADD, 0); }
		public MultiplicationContext multiplication() {
			return getRuleContext(MultiplicationContext.class,0);
		}
		public AdditionExpressionContext(AdditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAdditionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAdditionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAdditionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationExpression_IgnoredContext extends AdditionContext {
		public MultiplicationContext multiplication() {
			return getRuleContext(MultiplicationContext.class,0);
		}
		public MultiplicationExpression_IgnoredContext(AdditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterMultiplicationExpression_Ignored(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitMultiplicationExpression_Ignored(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitMultiplicationExpression_Ignored(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubtractionExpressionContext extends AdditionContext {
		public AdditionContext left;
		public Token operator;
		public MultiplicationContext right;
		public AdditionContext addition() {
			return getRuleContext(AdditionContext.class,0);
		}
		public TerminalNode SUB() { return getToken(ExpressionParser.SUB, 0); }
		public MultiplicationContext multiplication() {
			return getRuleContext(MultiplicationContext.class,0);
		}
		public SubtractionExpressionContext(AdditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterSubtractionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitSubtractionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitSubtractionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionContext addition() throws RecognitionException {
		return addition(0);
	}

	private AdditionContext addition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditionContext _localctx = new AdditionContext(_ctx, _parentState);
		AdditionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_addition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new MultiplicationExpression_IgnoredContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(118);
			multiplication(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(126);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new AdditionExpressionContext(new AdditionContext(_parentctx, _parentState));
						((AdditionExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_addition);
						setState(120);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(121);
						((AdditionExpressionContext)_localctx).operator = match(ADD);
						setState(122);
						((AdditionExpressionContext)_localctx).right = multiplication(0);
						}
						break;
					case 2:
						{
						_localctx = new SubtractionExpressionContext(new AdditionContext(_parentctx, _parentState));
						((SubtractionExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_addition);
						setState(123);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(124);
						((SubtractionExpressionContext)_localctx).operator = match(SUB);
						setState(125);
						((SubtractionExpressionContext)_localctx).right = multiplication(0);
						}
						break;
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationContext extends ParserRuleContext {
		public MultiplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplication; }
	 
		public MultiplicationContext() { }
		public void copyFrom(MultiplicationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationExpressionContext extends MultiplicationContext {
		public MultiplicationContext left;
		public Token operator;
		public ExponentiationContext right;
		public MultiplicationContext multiplication() {
			return getRuleContext(MultiplicationContext.class,0);
		}
		public TerminalNode MUL() { return getToken(ExpressionParser.MUL, 0); }
		public ExponentiationContext exponentiation() {
			return getRuleContext(ExponentiationContext.class,0);
		}
		public MultiplicationExpressionContext(MultiplicationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterMultiplicationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitMultiplicationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitMultiplicationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModulousExpressionContext extends MultiplicationContext {
		public MultiplicationContext left;
		public Token operator;
		public ExponentiationContext right;
		public MultiplicationContext multiplication() {
			return getRuleContext(MultiplicationContext.class,0);
		}
		public TerminalNode MOD() { return getToken(ExpressionParser.MOD, 0); }
		public ExponentiationContext exponentiation() {
			return getRuleContext(ExponentiationContext.class,0);
		}
		public ModulousExpressionContext(MultiplicationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterModulousExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitModulousExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitModulousExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExponentiationExpression_IgnoredContext extends MultiplicationContext {
		public ExponentiationContext exponentiation() {
			return getRuleContext(ExponentiationContext.class,0);
		}
		public ExponentiationExpression_IgnoredContext(MultiplicationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExponentiationExpression_Ignored(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExponentiationExpression_Ignored(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitExponentiationExpression_Ignored(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivisionExpressionContext extends MultiplicationContext {
		public MultiplicationContext left;
		public Token operator;
		public ExponentiationContext right;
		public MultiplicationContext multiplication() {
			return getRuleContext(MultiplicationContext.class,0);
		}
		public TerminalNode DIV() { return getToken(ExpressionParser.DIV, 0); }
		public ExponentiationContext exponentiation() {
			return getRuleContext(ExponentiationContext.class,0);
		}
		public DivisionExpressionContext(MultiplicationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterDivisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitDivisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitDivisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicationContext multiplication() throws RecognitionException {
		return multiplication(0);
	}

	private MultiplicationContext multiplication(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicationContext _localctx = new MultiplicationContext(_ctx, _parentState);
		MultiplicationContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_multiplication, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExponentiationExpression_IgnoredContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(132);
			exponentiation(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(143);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExpressionContext(new MultiplicationContext(_parentctx, _parentState));
						((MultiplicationExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_multiplication);
						setState(134);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(135);
						((MultiplicationExpressionContext)_localctx).operator = match(MUL);
						setState(136);
						((MultiplicationExpressionContext)_localctx).right = exponentiation(0);
						}
						break;
					case 2:
						{
						_localctx = new DivisionExpressionContext(new MultiplicationContext(_parentctx, _parentState));
						((DivisionExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_multiplication);
						setState(137);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(138);
						((DivisionExpressionContext)_localctx).operator = match(DIV);
						setState(139);
						((DivisionExpressionContext)_localctx).right = exponentiation(0);
						}
						break;
					case 3:
						{
						_localctx = new ModulousExpressionContext(new MultiplicationContext(_parentctx, _parentState));
						((ModulousExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_multiplication);
						setState(140);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(141);
						((ModulousExpressionContext)_localctx).operator = match(MOD);
						setState(142);
						((ModulousExpressionContext)_localctx).right = exponentiation(0);
						}
						break;
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExponentiationContext extends ParserRuleContext {
		public ExponentiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exponentiation; }
	 
		public ExponentiationContext() { }
		public void copyFrom(ExponentiationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperationExpression_IgnoredContext extends ExponentiationContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public OperationExpression_IgnoredContext(ExponentiationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterOperationExpression_Ignored(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitOperationExpression_Ignored(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitOperationExpression_Ignored(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExponentiationExpressionContext extends ExponentiationContext {
		public ExponentiationContext left;
		public Token operator;
		public OperationContext right;
		public ExponentiationContext exponentiation() {
			return getRuleContext(ExponentiationContext.class,0);
		}
		public TerminalNode POW() { return getToken(ExpressionParser.POW, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public ExponentiationExpressionContext(ExponentiationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExponentiationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExponentiationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitExponentiationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExponentiationContext exponentiation() throws RecognitionException {
		return exponentiation(0);
	}

	private ExponentiationContext exponentiation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExponentiationContext _localctx = new ExponentiationContext(_ctx, _parentState);
		ExponentiationContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_exponentiation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new OperationExpression_IgnoredContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(149);
			operation();
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExponentiationExpressionContext(new ExponentiationContext(_parentctx, _parentState));
					((ExponentiationExpressionContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exponentiation);
					setState(151);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(152);
					((ExponentiationExpressionContext)_localctx).operator = match(POW);
					setState(153);
					((ExponentiationExpressionContext)_localctx).right = operation();
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperationContext extends ParserRuleContext {
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
	 
		public OperationContext() { }
		public void copyFrom(OperationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccessorExpressionContext extends OperationContext {
		public AccessorContext accessor() {
			return getRuleContext(AccessorContext.class,0);
		}
		public AccessorExpressionContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAccessorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAccessorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAccessorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExpressionContext extends OperationContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExpressionContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionExpressionContext extends OperationContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionExpressionContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScopedExpressionContext extends OperationContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public ScopedExpressionContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterScopedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitScopedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitScopedExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operation);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new LiteralExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				literal();
				}
				break;
			case 2:
				_localctx = new AccessorExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				accessor();
				}
				break;
			case 3:
				_localctx = new FunctionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				function();
				}
				break;
			case 4:
				_localctx = new ScopedExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(162);
				scope();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccessorContext extends ParserRuleContext {
		public AccessorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessor; }
	 
		public AccessorContext() { }
		public void copyFrom(AccessorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectAccessorContext extends AccessorContext {
		public Token special;
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<TerminalNode> ACCESSOR() { return getTokens(ExpressionParser.ACCESSOR); }
		public TerminalNode ACCESSOR(int i) {
			return getToken(ExpressionParser.ACCESSOR, i);
		}
		public ObjectAccessorContext(AccessorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterObjectAccessor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitObjectAccessor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitObjectAccessor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessorContext accessor() throws RecognitionException {
		AccessorContext _localctx = new AccessorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_accessor);
		int _la;
		try {
			int _alt;
			_localctx = new ObjectAccessorContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) {
				{
				setState(165);
				((ObjectAccessorContext)_localctx).special = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
					((ObjectAccessorContext)_localctx).special = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(168);
			property();
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(169);
					match(ACCESSOR);
					setState(170);
					property();
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public IdentifierContext functionName;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			((FunctionContext)_localctx).functionName = identifier();
			setState(179);
			match(T__0);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1082388010L) != 0)) {
				{
				setState(180);
				expression();
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(181);
					match(T__11);
					setState(182);
					expression();
					}
					}
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(190);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ExpressionParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextExpressionContext extends LiteralContext {
		public TerminalNode TEXT() { return getToken(ExpressionParser.TEXT, 0); }
		public TextExpressionContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterTextExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitTextExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitTextExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullExpressionContext extends LiteralContext {
		public TerminalNode NULL() { return getToken(ExpressionParser.NULL, 0); }
		public NullExpressionContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNullExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNullExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitNullExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberExpressionContext extends LiteralContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumberExpressionContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNumberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNumberExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitNumberExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanExpressionContext extends LiteralContext {
		public TerminalNode BOOLEAN() { return getToken(ExpressionParser.BOOLEAN, 0); }
		public BooleanExpressionContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_literal);
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				_localctx = new BooleanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(BOOLEAN);
				}
				break;
			case NULL:
				_localctx = new NullExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(NULL);
				}
				break;
			case NUMBER:
			case SUB:
				_localctx = new NumberExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				number();
				}
				break;
			case TEXT:
				_localctx = new TextExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				match(TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegativeNumberContext extends NumberContext {
		public TerminalNode SUB() { return getToken(ExpressionParser.SUB, 0); }
		public TerminalNode NUMBER() { return getToken(ExpressionParser.NUMBER, 0); }
		public NegativeNumberContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNegativeNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNegativeNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitNegativeNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PositiveNumberContext extends NumberContext {
		public TerminalNode NUMBER() { return getToken(ExpressionParser.NUMBER, 0); }
		public PositiveNumberContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterPositiveNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitPositiveNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitPositiveNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_number);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new PositiveNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(NUMBER);
				}
				break;
			case SUB:
				_localctx = new NegativeNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(SUB);
				setState(202);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return logical_sempred((LogicalContext)_localctx, predIndex);
		case 6:
			return equality_sempred((EqualityContext)_localctx, predIndex);
		case 8:
			return addition_sempred((AdditionContext)_localctx, predIndex);
		case 9:
			return multiplication_sempred((MultiplicationContext)_localctx, predIndex);
		case 10:
			return exponentiation_sempred((ExponentiationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logical_sempred(LogicalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equality_sempred(EqualityContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean addition_sempred(AdditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplication_sempred(MultiplicationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exponentiation_sempred(ExponentiationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u00ce\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001*\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"8\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003<\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005H\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005P\b"+
		"\u0005\n\u0005\f\u0005S\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006^\b\u0006\n\u0006\f\u0006a\t\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007t\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u007f\b\b\n"+
		"\b\f\b\u0082\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0090\b\t\n\t\f\t\u0093"+
		"\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u009b\b\n"+
		"\n\n\f\n\u009e\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00a4\b\u000b\u0001\f\u0003\f\u00a7\b\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u00ac\b\f\n\f\f\f\u00af\t\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00b8\b\u000e\n"+
		"\u000e\f\u000e\u00bb\t\u000e\u0003\u000e\u00bd\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00c7\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u00cc\b\u0011\u0001\u0011\u0000\u0005\n\f\u0010\u0012\u0014\u0012"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"\u0000\u0001\u0001\u0000\t\u000b\u00d9\u0000$\u0001\u0000"+
		"\u0000\u0000\u0002)\u0001\u0000\u0000\u0000\u00047\u0001\u0000\u0000\u0000"+
		"\u0006;\u0001\u0000\u0000\u0000\b=\u0001\u0000\u0000\u0000\nG\u0001\u0000"+
		"\u0000\u0000\fT\u0001\u0000\u0000\u0000\u000es\u0001\u0000\u0000\u0000"+
		"\u0010u\u0001\u0000\u0000\u0000\u0012\u0083\u0001\u0000\u0000\u0000\u0014"+
		"\u0094\u0001\u0000\u0000\u0000\u0016\u00a3\u0001\u0000\u0000\u0000\u0018"+
		"\u00a6\u0001\u0000\u0000\u0000\u001a\u00b0\u0001\u0000\u0000\u0000\u001c"+
		"\u00b2\u0001\u0000\u0000\u0000\u001e\u00c0\u0001\u0000\u0000\u0000 \u00c6"+
		"\u0001\u0000\u0000\u0000\"\u00cb\u0001\u0000\u0000\u0000$%\u0003\u0002"+
		"\u0001\u0000%&\u0005\u0000\u0000\u0001&\u0001\u0001\u0000\u0000\u0000"+
		"\'*\u0003\u0006\u0003\u0000(*\u0003\u0004\u0002\u0000)\'\u0001\u0000\u0000"+
		"\u0000)(\u0001\u0000\u0000\u0000*\u0003\u0001\u0000\u0000\u0000+,\u0005"+
		"\u0001\u0000\u0000,-\u0003\u0006\u0003\u0000-.\u0005\u0002\u0000\u0000"+
		".8\u0001\u0000\u0000\u0000/0\u0005\u0003\u0000\u000001\u0003\u0006\u0003"+
		"\u000012\u0005\u0004\u0000\u000028\u0001\u0000\u0000\u000034\u0005\u0005"+
		"\u0000\u000045\u0003\u0006\u0003\u000056\u0005\u0006\u0000\u000068\u0001"+
		"\u0000\u0000\u00007+\u0001\u0000\u0000\u00007/\u0001\u0000\u0000\u0000"+
		"73\u0001\u0000\u0000\u00008\u0005\u0001\u0000\u0000\u00009<\u0003\n\u0005"+
		"\u0000:<\u0003\b\u0004\u0000;9\u0001\u0000\u0000\u0000;:\u0001\u0000\u0000"+
		"\u0000<\u0007\u0001\u0000\u0000\u0000=>\u0003\n\u0005\u0000>?\u0005\u0007"+
		"\u0000\u0000?@\u0003\n\u0005\u0000@A\u0005\b\u0000\u0000AB\u0003\n\u0005"+
		"\u0000B\t\u0001\u0000\u0000\u0000CD\u0006\u0005\uffff\uffff\u0000DH\u0003"+
		"\f\u0006\u0000EF\u0005\u001e\u0000\u0000FH\u0003\n\u0005\u0003GC\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HQ\u0001\u0000\u0000\u0000"+
		"IJ\n\u0002\u0000\u0000JK\u0005\u001c\u0000\u0000KP\u0003\f\u0006\u0000"+
		"LM\n\u0001\u0000\u0000MN\u0005\u001d\u0000\u0000NP\u0003\f\u0006\u0000"+
		"OI\u0001\u0000\u0000\u0000OL\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000R\u000b\u0001"+
		"\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000TU\u0006\u0006\uffff\uffff"+
		"\u0000UV\u0003\u000e\u0007\u0000V_\u0001\u0000\u0000\u0000WX\n\u0002\u0000"+
		"\u0000XY\u0005#\u0000\u0000Y^\u0003\u000e\u0007\u0000Z[\n\u0001\u0000"+
		"\u0000[\\\u0005$\u0000\u0000\\^\u0003\u000e\u0007\u0000]W\u0001\u0000"+
		"\u0000\u0000]Z\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\r\u0001\u0000\u0000\u0000"+
		"a_\u0001\u0000\u0000\u0000bt\u0003\u0010\b\u0000cd\u0003\u0010\b\u0000"+
		"de\u0005!\u0000\u0000ef\u0003\u0010\b\u0000ft\u0001\u0000\u0000\u0000"+
		"gh\u0003\u0010\b\u0000hi\u0005\"\u0000\u0000ij\u0003\u0010\b\u0000jt\u0001"+
		"\u0000\u0000\u0000kl\u0003\u0010\b\u0000lm\u0005\u001f\u0000\u0000mn\u0003"+
		"\u0010\b\u0000nt\u0001\u0000\u0000\u0000op\u0003\u0010\b\u0000pq\u0005"+
		" \u0000\u0000qr\u0003\u0010\b\u0000rt\u0001\u0000\u0000\u0000sb\u0001"+
		"\u0000\u0000\u0000sc\u0001\u0000\u0000\u0000sg\u0001\u0000\u0000\u0000"+
		"sk\u0001\u0000\u0000\u0000so\u0001\u0000\u0000\u0000t\u000f\u0001\u0000"+
		"\u0000\u0000uv\u0006\b\uffff\uffff\u0000vw\u0003\u0012\t\u0000w\u0080"+
		"\u0001\u0000\u0000\u0000xy\n\u0002\u0000\u0000yz\u0005\u0016\u0000\u0000"+
		"z\u007f\u0003\u0012\t\u0000{|\n\u0001\u0000\u0000|}\u0005\u0017\u0000"+
		"\u0000}\u007f\u0003\u0012\t\u0000~x\u0001\u0000\u0000\u0000~{\u0001\u0000"+
		"\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0011\u0001\u0000\u0000"+
		"\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0084\u0006\t\uffff\uffff"+
		"\u0000\u0084\u0085\u0003\u0014\n\u0000\u0085\u0091\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\n\u0003\u0000\u0000\u0087\u0088\u0005\u0018\u0000\u0000\u0088"+
		"\u0090\u0003\u0014\n\u0000\u0089\u008a\n\u0002\u0000\u0000\u008a\u008b"+
		"\u0005\u0019\u0000\u0000\u008b\u0090\u0003\u0014\n\u0000\u008c\u008d\n"+
		"\u0001\u0000\u0000\u008d\u008e\u0005\u001a\u0000\u0000\u008e\u0090\u0003"+
		"\u0014\n\u0000\u008f\u0086\u0001\u0000\u0000\u0000\u008f\u0089\u0001\u0000"+
		"\u0000\u0000\u008f\u008c\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000"+
		"\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000"+
		"\u0000\u0000\u0092\u0013\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0006\n\uffff\uffff\u0000\u0095\u0096\u0003\u0016"+
		"\u000b\u0000\u0096\u009c\u0001\u0000\u0000\u0000\u0097\u0098\n\u0001\u0000"+
		"\u0000\u0098\u0099\u0005\u001b\u0000\u0000\u0099\u009b\u0003\u0016\u000b"+
		"\u0000\u009a\u0097\u0001\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000"+
		"\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000"+
		"\u0000\u009d\u0015\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000"+
		"\u0000\u009f\u00a4\u0003 \u0010\u0000\u00a0\u00a4\u0003\u0018\f\u0000"+
		"\u00a1\u00a4\u0003\u001c\u000e\u0000\u00a2\u00a4\u0003\u0004\u0002\u0000"+
		"\u00a3\u009f\u0001\u0000\u0000\u0000\u00a3\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a4\u0017\u0001\u0000\u0000\u0000\u00a5\u00a7\u0007\u0000\u0000\u0000"+
		"\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00ad\u0003\u001a\r\u0000\u00a9"+
		"\u00aa\u0005\u0014\u0000\u0000\u00aa\u00ac\u0003\u001a\r\u0000\u00ab\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u0019"+
		"\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0003\u001e\u000f\u0000\u00b1\u001b\u0001\u0000\u0000\u0000\u00b2\u00b3"+
		"\u0003\u001e\u000f\u0000\u00b3\u00bc\u0005\u0001\u0000\u0000\u00b4\u00b9"+
		"\u0003\u0002\u0001\u0000\u00b5\u00b6\u0005\f\u0000\u0000\u00b6\u00b8\u0003"+
		"\u0002\u0001\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001"+
		"\u0000\u0000\u0000\u00bc\u00b4\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bf\u0005"+
		"\u0002\u0000\u0000\u00bf\u001d\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005"+
		"\u0011\u0000\u0000\u00c1\u001f\u0001\u0000\u0000\u0000\u00c2\u00c7\u0005"+
		"\u0010\u0000\u0000\u00c3\u00c7\u0005\u000f\u0000\u0000\u00c4\u00c7\u0003"+
		"\"\u0011\u0000\u00c5\u00c7\u0005\r\u0000\u0000\u00c6\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c7!\u0001\u0000\u0000"+
		"\u0000\u00c8\u00cc\u0005\u000e\u0000\u0000\u00c9\u00ca\u0005\u0017\u0000"+
		"\u0000\u00ca\u00cc\u0005\u000e\u0000\u0000\u00cb\u00c8\u0001\u0000\u0000"+
		"\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc#\u0001\u0000\u0000\u0000"+
		"\u0015)7;GOQ]_s~\u0080\u008f\u0091\u009c\u00a3\u00a6\u00ad\u00b9\u00bc"+
		"\u00c6\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}