// Generated from src/main/java/edu/sjsu/facetedJS/interpreter/parser/FacetedJavaScript.g4 by ANTLR 4.5.1

    package edu.sjsu.facetedJS.interpreter.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FacetedJavaScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		IF=10, ELSE=11, DO=12, WHILE=13, FOR=14, LABEL=15, WRTCHL=16, SECURE=17, 
		CREATECHL=18, ALERT=19, WINOPEN=20, FUNCTION=21, VAR=22, PRINT=23, RETURN=24, 
		NEW=25, DEFACET=26, PUSH=27, LENGTH=28, MD5=29, INT=30, BOOL=31, STRING=32, 
		NULL=33, UNDEFINED=34, INC=35, DEC=36, MUL=37, DIV=38, ADD=39, SUB=40, 
		MOD=41, GT=42, GE=43, LT=44, LE=45, EQ=46, NEQ=47, S_EQ=48, S_NEQ=49, 
		ASSIGN_REG=50, ASSIGN_ADD=51, ASSIGN_SUB=52, ASSIGN_MUL=53, ASSIGN_DIV=54, 
		SEPARATOR=55, AND=56, OR=57, ID=58, NEWLINE=59, BLOCK_COMMENT=60, LINE_COMMENT=61, 
		WS=62;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_expr = 2, RULE_perms = 3, RULE_block = 4, 
		RULE_params = 5, RULE_args = 6, RULE_array = 7, RULE_object = 8, RULE_pair = 9;
	public static final String[] ruleNames = {
		"prog", "stat", "expr", "perms", "block", "params", "args", "array", "object", 
		"pair"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "','", "'['", "']'", "'.'", "':'", "'iff'", 
		"'else'", "'do'", "'while'", "'for'", "'Label'", "'writeToChannel'", "'setSecurity'", 
		"'createChannel'", "'alert'", "'window.open'", "'function'", "'var'", 
		"'system.log'", "'return'", "'new'", "'defacet'", "'push'", "'length'", 
		"'md5'", null, null, null, "'null'", "'undefined'", "'++'", "'--'", "'*'", 
		"'/'", "'+'", "'-'", "'%'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", 
		"'==='", "'!=='", "'='", "'+='", "'-='", "'*='", "'/='", "';'", "'&&'", 
		"'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "IF", "ELSE", 
		"DO", "WHILE", "FOR", "LABEL", "WRTCHL", "SECURE", "CREATECHL", "ALERT", 
		"WINOPEN", "FUNCTION", "VAR", "PRINT", "RETURN", "NEW", "DEFACET", "PUSH", 
		"LENGTH", "MD5", "INT", "BOOL", "STRING", "NULL", "UNDEFINED", "INC", 
		"DEC", "MUL", "DIV", "ADD", "SUB", "MOD", "GT", "GE", "LT", "LE", "EQ", 
		"NEQ", "S_EQ", "S_NEQ", "ASSIGN_REG", "ASSIGN_ADD", "ASSIGN_SUB", "ASSIGN_MUL", 
		"ASSIGN_DIV", "SEPARATOR", "AND", "OR", "ID", "NEWLINE", "BLOCK_COMMENT", 
		"LINE_COMMENT", "WS"
	};
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
	public String getGrammarFileName() { return "FacetedJavaScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FacetedJavaScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				stat();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << IF) | (1L << DO) | (1L << WHILE) | (1L << FOR) | (1L << WRTCHL) | (1L << SECURE) | (1L << ALERT) | (1L << WINOPEN) | (1L << FUNCTION) | (1L << VAR) | (1L << PRINT) | (1L << RETURN) | (1L << NEW) | (1L << DEFACET) | (1L << MD5) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << NULL) | (1L << UNDEFINED) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << SEPARATOR) | (1L << ID))) != 0) );
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WinOpenContext extends StatContext {
		public TerminalNode WINOPEN() { return getToken(FacetedJavaScriptParser.WINOPEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(FacetedJavaScriptParser.SEPARATOR, 0); }
		public WinOpenContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterWinOpen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitWinOpen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitWinOpen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlankContext extends StatContext {
		public TerminalNode SEPARATOR() { return getToken(FacetedJavaScriptParser.SEPARATOR, 0); }
		public BlankContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterBlank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitBlank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitBlank(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenElseContext extends StatContext {
		public TerminalNode IF() { return getToken(FacetedJavaScriptParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(FacetedJavaScriptParser.ELSE, 0); }
		public IfThenElseContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterIfThenElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitIfThenElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitIfThenElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForContext extends StatContext {
		public TerminalNode FOR() { return getToken(FacetedJavaScriptParser.FOR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnExprContext extends StatContext {
		public TerminalNode RETURN() { return getToken(FacetedJavaScriptParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(FacetedJavaScriptParser.SEPARATOR, 0); }
		public ReturnExprContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterReturnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitReturnExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitReturnExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NamedFunctionContext extends StatContext {
		public TerminalNode FUNCTION() { return getToken(FacetedJavaScriptParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(FacetedJavaScriptParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public NamedFunctionContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterNamedFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitNamedFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitNamedFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenContext extends StatContext {
		public TerminalNode IF() { return getToken(FacetedJavaScriptParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfThenContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterIfThen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitIfThen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitIfThen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends StatContext {
		public TerminalNode WHILE() { return getToken(FacetedJavaScriptParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BareExprContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(FacetedJavaScriptParser.SEPARATOR, 0); }
		public BareExprContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterBareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitBareExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitBareExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoWhileContext extends StatContext {
		public TerminalNode DO() { return getToken(FacetedJavaScriptParser.DO, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(FacetedJavaScriptParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DoWhileContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitDoWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlertContext extends StatContext {
		public TerminalNode ALERT() { return getToken(FacetedJavaScriptParser.ALERT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(FacetedJavaScriptParser.SEPARATOR, 0); }
		public AlertContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterAlert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitAlert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitAlert(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WriteChlContext extends StatContext {
		public TerminalNode WRTCHL() { return getToken(FacetedJavaScriptParser.WRTCHL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEPARATOR() { return getToken(FacetedJavaScriptParser.SEPARATOR, 0); }
		public WriteChlContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterWriteChl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitWriteChl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitWriteChl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintExprContext extends StatContext {
		public TerminalNode PRINT() { return getToken(FacetedJavaScriptParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(FacetedJavaScriptParser.SEPARATOR, 0); }
		public PrintExprContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterPrintExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitPrintExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitPrintExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(108);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new BareExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				expr(0);
				setState(26);
				match(SEPARATOR);
				}
				break;
			case 2:
				_localctx = new NamedFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(FUNCTION);
				setState(29);
				match(ID);
				setState(30);
				params();
				setState(31);
				match(T__0);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << IF) | (1L << DO) | (1L << WHILE) | (1L << FOR) | (1L << WRTCHL) | (1L << SECURE) | (1L << ALERT) | (1L << WINOPEN) | (1L << FUNCTION) | (1L << VAR) | (1L << PRINT) | (1L << RETURN) | (1L << NEW) | (1L << DEFACET) | (1L << MD5) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << NULL) | (1L << UNDEFINED) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << SEPARATOR) | (1L << ID))) != 0)) {
					{
					{
					setState(32);
					stat();
					}
					}
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(38);
				match(T__1);
				}
				break;
			case 3:
				_localctx = new IfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				match(IF);
				setState(41);
				match(T__2);
				setState(42);
				expr(0);
				setState(43);
				match(T__3);
				setState(44);
				block();
				setState(45);
				match(ELSE);
				setState(46);
				block();
				}
				break;
			case 4:
				_localctx = new IfThenContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
				match(IF);
				setState(49);
				match(T__2);
				setState(50);
				expr(0);
				setState(51);
				match(T__3);
				setState(52);
				block();
				}
				break;
			case 5:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(54);
				match(WHILE);
				setState(55);
				match(T__2);
				setState(56);
				expr(0);
				setState(57);
				match(T__3);
				setState(58);
				block();
				}
				break;
			case 6:
				_localctx = new DoWhileContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(60);
				match(DO);
				setState(61);
				block();
				setState(62);
				match(WHILE);
				setState(63);
				match(T__2);
				setState(64);
				expr(0);
				setState(65);
				match(T__3);
				}
				break;
			case 7:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(67);
				match(FOR);
				setState(68);
				match(T__2);
				setState(69);
				expr(0);
				setState(70);
				match(SEPARATOR);
				setState(71);
				expr(0);
				setState(72);
				match(SEPARATOR);
				setState(73);
				expr(0);
				setState(74);
				match(T__3);
				setState(75);
				block();
				}
				break;
			case 8:
				_localctx = new WriteChlContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(77);
				match(WRTCHL);
				setState(78);
				match(T__2);
				setState(79);
				expr(0);
				setState(80);
				match(T__4);
				setState(81);
				expr(0);
				setState(82);
				match(T__3);
				setState(83);
				match(SEPARATOR);
				}
				break;
			case 9:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(85);
				match(PRINT);
				setState(86);
				match(T__2);
				setState(87);
				expr(0);
				setState(88);
				match(T__3);
				setState(89);
				match(SEPARATOR);
				}
				break;
			case 10:
				_localctx = new AlertContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(91);
				match(ALERT);
				setState(92);
				match(T__2);
				setState(93);
				expr(0);
				setState(94);
				match(T__3);
				setState(95);
				match(SEPARATOR);
				}
				break;
			case 11:
				_localctx = new WinOpenContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(97);
				match(WINOPEN);
				setState(98);
				match(T__2);
				setState(99);
				expr(0);
				setState(100);
				match(T__3);
				setState(101);
				match(SEPARATOR);
				}
				break;
			case 12:
				_localctx = new ReturnExprContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(103);
				match(RETURN);
				setState(104);
				expr(0);
				setState(105);
				match(SEPARATOR);
				}
				break;
			case 13:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(107);
				match(SEPARATOR);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostIncDecContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode INC() { return getToken(FacetedJavaScriptParser.INC, 0); }
		public TerminalNode DEC() { return getToken(FacetedJavaScriptParser.DEC, 0); }
		public PostIncDecContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterPostIncDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitPostIncDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitPostIncDec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(FacetedJavaScriptParser.BOOL, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(FacetedJavaScriptParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LocalAssignContext extends ExprContext {
		public Token op;
		public TerminalNode VAR() { return getToken(FacetedJavaScriptParser.VAR, 0); }
		public TerminalNode ID() { return getToken(FacetedJavaScriptParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LocalAssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterLocalAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitLocalAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitLocalAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MD5ExprContext extends ExprContext {
		public TerminalNode MD5() { return getToken(FacetedJavaScriptParser.MD5, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MD5ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterMD5Expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitMD5Expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitMD5Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UndefinedContext extends ExprContext {
		public TerminalNode UNDEFINED() { return getToken(FacetedJavaScriptParser.UNDEFINED, 0); }
		public UndefinedContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterUndefined(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitUndefined(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitUndefined(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateLabelContext extends ExprContext {
		public TerminalNode NEW() { return getToken(FacetedJavaScriptParser.NEW, 0); }
		public TerminalNode LABEL() { return getToken(FacetedJavaScriptParser.LABEL, 0); }
		public CreateLabelContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterCreateLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitCreateLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitCreateLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterMulDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitMulDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjectExprContext extends ExprContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ObjectExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterObjectExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitObjectExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitObjectExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ComparisonContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetLengthExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LENGTH() { return getToken(FacetedJavaScriptParser.LENGTH, 0); }
		public GetLengthExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterGetLengthExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitGetLengthExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitGetLengthExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusMinusSignContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PlusMinusSignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterPlusMinusSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitPlusMinusSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitPlusMinusSign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(FacetedJavaScriptParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PushExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PUSH() { return getToken(FacetedJavaScriptParser.PUSH, 0); }
		public PushExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterPushExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitPushExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitPushExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GlobalAssignContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GlobalAssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterGlobalAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitGlobalAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitGlobalAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DotExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(FacetedJavaScriptParser.ID, 0); }
		public DotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterDotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitDotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitDotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreIncDecContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode INC() { return getToken(FacetedJavaScriptParser.INC, 0); }
		public TerminalNode DEC() { return getToken(FacetedJavaScriptParser.DEC, 0); }
		public PreIncDecContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterPreIncDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitPreIncDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitPreIncDec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetSecurityContext extends ExprContext {
		public TerminalNode SECURE() { return getToken(FacetedJavaScriptParser.SECURE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SetSecurityContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterSetSecurity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitSetSecurity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitSetSecurity(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionAppContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FunctionAppContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterFunctionApp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitFunctionApp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitFunctionApp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(FacetedJavaScriptParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefcExprContext extends ExprContext {
		public TerminalNode DEFACET() { return getToken(FacetedJavaScriptParser.DEFACET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DefcExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterDefcExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitDefcExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitDefcExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullContext extends ExprContext {
		public TerminalNode NULL() { return getToken(FacetedJavaScriptParser.NULL, 0); }
		public NullContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjInstantContext extends ExprContext {
		public TerminalNode NEW() { return getToken(FacetedJavaScriptParser.NEW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ObjInstantContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterObjInstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitObjInstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitObjInstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BktExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BktExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterBktExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitBktExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitBktExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicComparisonContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogicComparisonContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterLogicComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitLogicComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitLogicComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AnonFunctionContext extends ExprContext {
		public TerminalNode FUNCTION() { return getToken(FacetedJavaScriptParser.FUNCTION, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public AnonFunctionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterAnonFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitAnonFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitAnonFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new PlusMinusSignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(111);
				((PlusMinusSignContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((PlusMinusSignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(112);
				expr(20);
				}
				break;
			case 2:
				{
				_localctx = new PreIncDecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113);
				((PreIncDecContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((PreIncDecContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(114);
				expr(19);
				}
				break;
			case 3:
				{
				_localctx = new ObjInstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(NEW);
				setState(116);
				expr(17);
				}
				break;
			case 4:
				{
				_localctx = new LocalAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(VAR);
				setState(118);
				match(ID);
				setState(119);
				((LocalAssignContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN_REG) | (1L << ASSIGN_ADD) | (1L << ASSIGN_SUB) | (1L << ASSIGN_MUL) | (1L << ASSIGN_DIV))) != 0)) ) {
					((LocalAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(120);
				expr(11);
				}
				break;
			case 5:
				{
				_localctx = new DefcExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(DEFACET);
				setState(122);
				match(T__2);
				setState(123);
				expr(0);
				setState(124);
				match(T__4);
				setState(125);
				expr(0);
				setState(126);
				match(T__3);
				}
				break;
			case 6:
				{
				_localctx = new SetSecurityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				match(SECURE);
				setState(129);
				match(T__2);
				setState(130);
				expr(0);
				setState(131);
				match(T__4);
				setState(132);
				expr(0);
				setState(135);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(133);
					match(T__4);
					setState(134);
					expr(0);
					}
				}

				setState(137);
				match(T__3);
				}
				break;
			case 7:
				{
				_localctx = new MD5ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(MD5);
				setState(140);
				match(T__2);
				setState(141);
				expr(0);
				setState(142);
				match(T__3);
				}
				break;
			case 8:
				{
				_localctx = new AnonFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(FUNCTION);
				setState(145);
				params();
				setState(146);
				match(T__0);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << IF) | (1L << DO) | (1L << WHILE) | (1L << FOR) | (1L << WRTCHL) | (1L << SECURE) | (1L << ALERT) | (1L << WINOPEN) | (1L << FUNCTION) | (1L << VAR) | (1L << PRINT) | (1L << RETURN) | (1L << NEW) | (1L << DEFACET) | (1L << MD5) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << NULL) | (1L << UNDEFINED) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << SEPARATOR) | (1L << ID))) != 0)) {
					{
					{
					setState(147);
					stat();
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(153);
				match(T__1);
				}
				break;
			case 9:
				{
				_localctx = new CreateLabelContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				match(NEW);
				setState(156);
				match(LABEL);
				setState(157);
				match(T__2);
				setState(158);
				match(T__3);
				}
				break;
			case 10:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				array();
				}
				break;
			case 11:
				{
				_localctx = new ObjectExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				object();
				}
				break;
			case 12:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(INT);
				}
				break;
			case 13:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(BOOL);
				}
				break;
			case 14:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(STRING);
				}
				break;
			case 15:
				{
				_localctx = new NullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				match(NULL);
				}
				break;
			case 16:
				{
				_localctx = new UndefinedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165);
				match(UNDEFINED);
				}
				break;
			case 17:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				match(ID);
				}
				break;
			case 18:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(T__2);
				setState(168);
				expr(0);
				setState(169);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(210);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(174);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(175);
						expr(16);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(177);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(178);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new ComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(180);
						((ComparisonContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NEQ) | (1L << S_EQ) | (1L << S_NEQ))) != 0)) ) {
							((ComparisonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(181);
						expr(14);
						}
						break;
					case 4:
						{
						_localctx = new LogicComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(183);
						((LogicComparisonContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((LogicComparisonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(184);
						expr(13);
						}
						break;
					case 5:
						{
						_localctx = new GlobalAssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(186);
						((GlobalAssignContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN_REG) | (1L << ASSIGN_ADD) | (1L << ASSIGN_SUB) | (1L << ASSIGN_MUL) | (1L << ASSIGN_DIV))) != 0)) ) {
							((GlobalAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(187);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new FunctionAppContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(189);
						args();
						}
						break;
					case 7:
						{
						_localctx = new BktExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(190);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(191);
						match(T__5);
						setState(192);
						expr(0);
						setState(193);
						match(T__6);
						}
						break;
					case 8:
						{
						_localctx = new DotExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(195);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(196);
						match(T__7);
						setState(197);
						match(ID);
						}
						break;
					case 9:
						{
						_localctx = new PushExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(199);
						match(T__7);
						setState(200);
						match(PUSH);
						setState(201);
						match(T__2);
						setState(202);
						expr(0);
						setState(203);
						match(T__3);
						}
						break;
					case 10:
						{
						_localctx = new GetLengthExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(205);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(206);
						match(T__7);
						setState(207);
						match(LENGTH);
						}
						break;
					case 11:
						{
						_localctx = new PostIncDecContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(209);
						((PostIncDecContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
							((PostIncDecContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(214);
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

	public static class PermsContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(FacetedJavaScriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FacetedJavaScriptParser.STRING, i);
		}
		public PermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_perms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterPerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitPerms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitPerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PermsContext perms() throws RecognitionException {
		PermsContext _localctx = new PermsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_perms);
		int _la;
		try {
			setState(227);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(T__2);
				setState(216);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				match(T__2);
				setState(218);
				match(STRING);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(219);
					match(T__4);
					setState(220);
					match(STRING);
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(226);
				match(T__3);
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

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FullBlockContext extends BlockContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public FullBlockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterFullBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitFullBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitFullBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpBlockContext extends BlockContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public SimpBlockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterSimpBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitSimpBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitSimpBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			setState(238);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new FullBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(T__0);
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << IF) | (1L << DO) | (1L << WHILE) | (1L << FOR) | (1L << WRTCHL) | (1L << SECURE) | (1L << ALERT) | (1L << WINOPEN) | (1L << FUNCTION) | (1L << VAR) | (1L << PRINT) | (1L << RETURN) | (1L << NEW) | (1L << DEFACET) | (1L << MD5) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << NULL) | (1L << UNDEFINED) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << SEPARATOR) | (1L << ID))) != 0)) {
					{
					{
					setState(230);
					stat();
					}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(236);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new SimpBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				stat();
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

	public static class ParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(FacetedJavaScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FacetedJavaScriptParser.ID, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			setState(252);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				match(T__2);
				setState(241);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(T__2);
				setState(243);
				match(ID);
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(244);
					match(T__4);
					setState(245);
					match(ID);
					}
					}
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(251);
				match(T__3);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_args);
		int _la;
		try {
			setState(267);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(T__2);
				setState(255);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				match(T__2);
				setState(257);
				expr(0);
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(258);
					match(T__4);
					setState(259);
					expr(0);
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(265);
				match(T__3);
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

	public static class ArrayContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_array);
		int _la;
		try {
			setState(282);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				match(T__5);
				setState(270);
				expr(0);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(271);
					match(T__4);
					setState(272);
					expr(0);
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(278);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				match(T__5);
				setState(281);
				match(T__6);
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

	public static class ObjectContext extends ParserRuleContext {
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
	 
		public ObjectContext() { }
		public void copyFrom(ObjectContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FullObjContext extends ObjectContext {
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public FullObjContext(ObjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterFullObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitFullObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitFullObj(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptObjContext extends ObjectContext {
		public EmptObjContext(ObjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterEmptObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitEmptObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitEmptObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_object);
		int _la;
		try {
			setState(297);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new FullObjContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(T__0);
				setState(285);
				pair();
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(286);
					match(T__4);
					setState(287);
					pair();
					}
					}
					setState(292);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(293);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new EmptObjContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				match(T__0);
				setState(296);
				match(T__1);
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

	public static class PairContext extends ParserRuleContext {
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
	 
		public PairContext() { }
		public void copyFrom(PairContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class KeyPairContext extends PairContext {
		public TerminalNode ID() { return getToken(FacetedJavaScriptParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public KeyPairContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).enterKeyPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FacetedJavaScriptListener ) ((FacetedJavaScriptListener)listener).exitKeyPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FacetedJavaScriptVisitor ) return ((FacetedJavaScriptVisitor<? extends T>)visitor).visitKeyPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pair);
		try {
			_localctx = new KeyPairContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(ID);
			setState(300);
			match(T__8);
			setState(301);
			expr(0);
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
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 29);
		case 6:
			return precpred(_ctx, 24);
		case 7:
			return precpred(_ctx, 23);
		case 8:
			return precpred(_ctx, 22);
		case 9:
			return precpred(_ctx, 21);
		case 10:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u0132\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\6\2\30\n\2\r\2\16\2\31\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3$\n"+
		"\3\f\3\16\3\'\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3o\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u008a\n"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0097\n\4\f\4\16\4"+
		"\u009a\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4\u00ae\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u00d5\n\4\f\4\16\4\u00d8\13\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00e0\n\5\f\5\16\5\u00e3\13\5\3\5\5\5\u00e6"+
		"\n\5\3\6\3\6\7\6\u00ea\n\6\f\6\16\6\u00ed\13\6\3\6\3\6\5\6\u00f1\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\7\7\u00f9\n\7\f\7\16\7\u00fc\13\7\3\7\5\7\u00ff"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0107\n\b\f\b\16\b\u010a\13\b\3\b\3\b"+
		"\5\b\u010e\n\b\3\t\3\t\3\t\3\t\7\t\u0114\n\t\f\t\16\t\u0117\13\t\3\t\3"+
		"\t\3\t\3\t\5\t\u011d\n\t\3\n\3\n\3\n\3\n\7\n\u0123\n\n\f\n\16\n\u0126"+
		"\13\n\3\n\3\n\3\n\3\n\5\n\u012c\n\n\3\13\3\13\3\13\3\13\3\13\2\3\6\f\2"+
		"\4\6\b\n\f\16\20\22\24\2\b\3\2)*\3\2%&\3\2\648\4\2\'(++\3\2,\63\3\2:;"+
		"\u015f\2\27\3\2\2\2\4n\3\2\2\2\6\u00ad\3\2\2\2\b\u00e5\3\2\2\2\n\u00f0"+
		"\3\2\2\2\f\u00fe\3\2\2\2\16\u010d\3\2\2\2\20\u011c\3\2\2\2\22\u012b\3"+
		"\2\2\2\24\u012d\3\2\2\2\26\30\5\4\3\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27"+
		"\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33\34\5\6\4\2\34\35\79\2\2\35o\3\2"+
		"\2\2\36\37\7\27\2\2\37 \7<\2\2 !\5\f\7\2!%\7\3\2\2\"$\5\4\3\2#\"\3\2\2"+
		"\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2()\7\4\2\2)o\3\2"+
		"\2\2*+\7\f\2\2+,\7\5\2\2,-\5\6\4\2-.\7\6\2\2./\5\n\6\2/\60\7\r\2\2\60"+
		"\61\5\n\6\2\61o\3\2\2\2\62\63\7\f\2\2\63\64\7\5\2\2\64\65\5\6\4\2\65\66"+
		"\7\6\2\2\66\67\5\n\6\2\67o\3\2\2\289\7\17\2\29:\7\5\2\2:;\5\6\4\2;<\7"+
		"\6\2\2<=\5\n\6\2=o\3\2\2\2>?\7\16\2\2?@\5\n\6\2@A\7\17\2\2AB\7\5\2\2B"+
		"C\5\6\4\2CD\7\6\2\2Do\3\2\2\2EF\7\20\2\2FG\7\5\2\2GH\5\6\4\2HI\79\2\2"+
		"IJ\5\6\4\2JK\79\2\2KL\5\6\4\2LM\7\6\2\2MN\5\n\6\2No\3\2\2\2OP\7\22\2\2"+
		"PQ\7\5\2\2QR\5\6\4\2RS\7\7\2\2ST\5\6\4\2TU\7\6\2\2UV\79\2\2Vo\3\2\2\2"+
		"WX\7\31\2\2XY\7\5\2\2YZ\5\6\4\2Z[\7\6\2\2[\\\79\2\2\\o\3\2\2\2]^\7\25"+
		"\2\2^_\7\5\2\2_`\5\6\4\2`a\7\6\2\2ab\79\2\2bo\3\2\2\2cd\7\26\2\2de\7\5"+
		"\2\2ef\5\6\4\2fg\7\6\2\2gh\79\2\2ho\3\2\2\2ij\7\32\2\2jk\5\6\4\2kl\79"+
		"\2\2lo\3\2\2\2mo\79\2\2n\33\3\2\2\2n\36\3\2\2\2n*\3\2\2\2n\62\3\2\2\2"+
		"n8\3\2\2\2n>\3\2\2\2nE\3\2\2\2nO\3\2\2\2nW\3\2\2\2n]\3\2\2\2nc\3\2\2\2"+
		"ni\3\2\2\2nm\3\2\2\2o\5\3\2\2\2pq\b\4\1\2qr\t\2\2\2r\u00ae\5\6\4\26st"+
		"\t\3\2\2t\u00ae\5\6\4\25uv\7\33\2\2v\u00ae\5\6\4\23wx\7\30\2\2xy\7<\2"+
		"\2yz\t\4\2\2z\u00ae\5\6\4\r{|\7\34\2\2|}\7\5\2\2}~\5\6\4\2~\177\7\7\2"+
		"\2\177\u0080\5\6\4\2\u0080\u0081\7\6\2\2\u0081\u00ae\3\2\2\2\u0082\u0083"+
		"\7\23\2\2\u0083\u0084\7\5\2\2\u0084\u0085\5\6\4\2\u0085\u0086\7\7\2\2"+
		"\u0086\u0089\5\6\4\2\u0087\u0088\7\7\2\2\u0088\u008a\5\6\4\2\u0089\u0087"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\7\6\2\2\u008c"+
		"\u00ae\3\2\2\2\u008d\u008e\7\37\2\2\u008e\u008f\7\5\2\2\u008f\u0090\5"+
		"\6\4\2\u0090\u0091\7\6\2\2\u0091\u00ae\3\2\2\2\u0092\u0093\7\27\2\2\u0093"+
		"\u0094\5\f\7\2\u0094\u0098\7\3\2\2\u0095\u0097\5\4\3\2\u0096\u0095\3\2"+
		"\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\4\2\2\u009c\u00ae\3\2"+
		"\2\2\u009d\u009e\7\33\2\2\u009e\u009f\7\21\2\2\u009f\u00a0\7\5\2\2\u00a0"+
		"\u00ae\7\6\2\2\u00a1\u00ae\5\20\t\2\u00a2\u00ae\5\22\n\2\u00a3\u00ae\7"+
		" \2\2\u00a4\u00ae\7!\2\2\u00a5\u00ae\7\"\2\2\u00a6\u00ae\7#\2\2\u00a7"+
		"\u00ae\7$\2\2\u00a8\u00ae\7<\2\2\u00a9\u00aa\7\5\2\2\u00aa\u00ab\5\6\4"+
		"\2\u00ab\u00ac\7\6\2\2\u00ac\u00ae\3\2\2\2\u00adp\3\2\2\2\u00ads\3\2\2"+
		"\2\u00adu\3\2\2\2\u00adw\3\2\2\2\u00ad{\3\2\2\2\u00ad\u0082\3\2\2\2\u00ad"+
		"\u008d\3\2\2\2\u00ad\u0092\3\2\2\2\u00ad\u009d\3\2\2\2\u00ad\u00a1\3\2"+
		"\2\2\u00ad\u00a2\3\2\2\2\u00ad\u00a3\3\2\2\2\u00ad\u00a4\3\2\2\2\u00ad"+
		"\u00a5\3\2\2\2\u00ad\u00a6\3\2\2\2\u00ad\u00a7\3\2\2\2\u00ad\u00a8\3\2"+
		"\2\2\u00ad\u00a9\3\2\2\2\u00ae\u00d6\3\2\2\2\u00af\u00b0\f\21\2\2\u00b0"+
		"\u00b1\t\5\2\2\u00b1\u00d5\5\6\4\22\u00b2\u00b3\f\20\2\2\u00b3\u00b4\t"+
		"\2\2\2\u00b4\u00d5\5\6\4\21\u00b5\u00b6\f\17\2\2\u00b6\u00b7\t\6\2\2\u00b7"+
		"\u00d5\5\6\4\20\u00b8\u00b9\f\16\2\2\u00b9\u00ba\t\7\2\2\u00ba\u00d5\5"+
		"\6\4\17\u00bb\u00bc\f\f\2\2\u00bc\u00bd\t\4\2\2\u00bd\u00d5\5\6\4\r\u00be"+
		"\u00bf\f\37\2\2\u00bf\u00d5\5\16\b\2\u00c0\u00c1\f\32\2\2\u00c1\u00c2"+
		"\7\b\2\2\u00c2\u00c3\5\6\4\2\u00c3\u00c4\7\t\2\2\u00c4\u00d5\3\2\2\2\u00c5"+
		"\u00c6\f\31\2\2\u00c6\u00c7\7\n\2\2\u00c7\u00d5\7<\2\2\u00c8\u00c9\f\30"+
		"\2\2\u00c9\u00ca\7\n\2\2\u00ca\u00cb\7\35\2\2\u00cb\u00cc\7\5\2\2\u00cc"+
		"\u00cd\5\6\4\2\u00cd\u00ce\7\6\2\2\u00ce\u00d5\3\2\2\2\u00cf\u00d0\f\27"+
		"\2\2\u00d0\u00d1\7\n\2\2\u00d1\u00d5\7\36\2\2\u00d2\u00d3\f\24\2\2\u00d3"+
		"\u00d5\t\3\2\2\u00d4\u00af\3\2\2\2\u00d4\u00b2\3\2\2\2\u00d4\u00b5\3\2"+
		"\2\2\u00d4\u00b8\3\2\2\2\u00d4\u00bb\3\2\2\2\u00d4\u00be\3\2\2\2\u00d4"+
		"\u00c0\3\2\2\2\u00d4\u00c5\3\2\2\2\u00d4\u00c8\3\2\2\2\u00d4\u00cf\3\2"+
		"\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\7\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7\5\2\2"+
		"\u00da\u00e6\7\6\2\2\u00db\u00dc\7\5\2\2\u00dc\u00e1\7\"\2\2\u00dd\u00de"+
		"\7\7\2\2\u00de\u00e0\7\"\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e4\u00e6\7\6\2\2\u00e5\u00d9\3\2\2\2\u00e5\u00db\3\2\2\2\u00e6"+
		"\t\3\2\2\2\u00e7\u00eb\7\3\2\2\u00e8\u00ea\5\4\3\2\u00e9\u00e8\3\2\2\2"+
		"\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee"+
		"\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f1\7\4\2\2\u00ef\u00f1\5\4\3\2\u00f0"+
		"\u00e7\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\13\3\2\2\2\u00f2\u00f3\7\5\2"+
		"\2\u00f3\u00ff\7\6\2\2\u00f4\u00f5\7\5\2\2\u00f5\u00fa\7<\2\2\u00f6\u00f7"+
		"\7\7\2\2\u00f7\u00f9\7<\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2"+
		"\2\2\u00fd\u00ff\7\6\2\2\u00fe\u00f2\3\2\2\2\u00fe\u00f4\3\2\2\2\u00ff"+
		"\r\3\2\2\2\u0100\u0101\7\5\2\2\u0101\u010e\7\6\2\2\u0102\u0103\7\5\2\2"+
		"\u0103\u0108\5\6\4\2\u0104\u0105\7\7\2\2\u0105\u0107\5\6\4\2\u0106\u0104"+
		"\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\7\6\2\2\u010c\u010e\3\2"+
		"\2\2\u010d\u0100\3\2\2\2\u010d\u0102\3\2\2\2\u010e\17\3\2\2\2\u010f\u0110"+
		"\7\b\2\2\u0110\u0115\5\6\4\2\u0111\u0112\7\7\2\2\u0112\u0114\5\6\4\2\u0113"+
		"\u0111\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119\7\t\2\2\u0119"+
		"\u011d\3\2\2\2\u011a\u011b\7\b\2\2\u011b\u011d\7\t\2\2\u011c\u010f\3\2"+
		"\2\2\u011c\u011a\3\2\2\2\u011d\21\3\2\2\2\u011e\u011f\7\3\2\2\u011f\u0124"+
		"\5\24\13\2\u0120\u0121\7\7\2\2\u0121\u0123\5\24\13\2\u0122\u0120\3\2\2"+
		"\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127"+
		"\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128\7\4\2\2\u0128\u012c\3\2\2\2\u0129"+
		"\u012a\7\3\2\2\u012a\u012c\7\4\2\2\u012b\u011e\3\2\2\2\u012b\u0129\3\2"+
		"\2\2\u012c\23\3\2\2\2\u012d\u012e\7<\2\2\u012e\u012f\7\13\2\2\u012f\u0130"+
		"\5\6\4\2\u0130\25\3\2\2\2\26\31%n\u0089\u0098\u00ad\u00d4\u00d6\u00e1"+
		"\u00e5\u00eb\u00f0\u00fa\u00fe\u0108\u010d\u0115\u011c\u0124\u012b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}