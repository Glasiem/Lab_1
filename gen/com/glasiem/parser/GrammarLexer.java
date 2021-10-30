// Generated from F:/IdeaProjects/Lab1/src/main/java/com/glasiem/parser\Grammar.g4 by ANTLR 4.9.1
package com.glasiem.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, INT=2, INC=3, DEC=4, MAX=5, MIN=6, COMA=7, EXPONENT=8, MULTIPLY=9, 
		DIVIDE=10, SUBTRACT=11, ADD=12, LPAREN=13, RPAREN=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NUMBER", "INT", "INC", "DEC", "MAX", "MIN", "COMA", "EXPONENT", "MULTIPLY", 
			"DIVIDE", "SUBTRACT", "ADD", "LPAREN", "RPAREN", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'inc'", "'dec'", "'max'", "'min'", "','", "'^'", "'*'", 
			"'/'", "'-'", "'+'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBER", "INT", "INC", "DEC", "MAX", "MIN", "COMA", "EXPONENT", 
			"MULTIPLY", "DIVIDE", "SUBTRACT", "ADD", "LPAREN", "RPAREN", "WS"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21O\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\5\2%\n\2"+
		"\3\3\6\3(\n\3\r\3\16\3)\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21\3\2\3\5\2\13\f\17\17"+
		"\"\"\2P\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2"+
		"\5\'\3\2\2\2\7+\3\2\2\2\t/\3\2\2\2\13\63\3\2\2\2\r\67\3\2\2\2\17;\3\2"+
		"\2\2\21=\3\2\2\2\23?\3\2\2\2\25A\3\2\2\2\27C\3\2\2\2\31E\3\2\2\2\33G\3"+
		"\2\2\2\35I\3\2\2\2\37K\3\2\2\2!$\5\5\3\2\"#\7\60\2\2#%\5\5\3\2$\"\3\2"+
		"\2\2$%\3\2\2\2%\4\3\2\2\2&(\4\62;\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*"+
		"\3\2\2\2*\6\3\2\2\2+,\7k\2\2,-\7p\2\2-.\7e\2\2.\b\3\2\2\2/\60\7f\2\2\60"+
		"\61\7g\2\2\61\62\7e\2\2\62\n\3\2\2\2\63\64\7o\2\2\64\65\7c\2\2\65\66\7"+
		"z\2\2\66\f\3\2\2\2\678\7o\2\289\7k\2\29:\7p\2\2:\16\3\2\2\2;<\7.\2\2<"+
		"\20\3\2\2\2=>\7`\2\2>\22\3\2\2\2?@\7,\2\2@\24\3\2\2\2AB\7\61\2\2B\26\3"+
		"\2\2\2CD\7/\2\2D\30\3\2\2\2EF\7-\2\2F\32\3\2\2\2GH\7*\2\2H\34\3\2\2\2"+
		"IJ\7+\2\2J\36\3\2\2\2KL\t\2\2\2LM\3\2\2\2MN\b\20\2\2N \3\2\2\2\5\2$)\3"+
		"\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}