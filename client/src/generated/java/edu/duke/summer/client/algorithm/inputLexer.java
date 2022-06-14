// Generated from edu\duke\summer\client\algorithm\input.g4 by ANTLR 4.5
package edu.duke.summer.client.algorithm;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class inputLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, EQ=4, NEQ=5, ADD=6, SUB=7, MUL=8, DIV=9, MOD=10, 
		AND=11, OR=12, ASSIGN=13, COLON=14, COMMA=15, LPAREN=16, RPAREN=17, LBRACK=18, 
		RBRACK=19, LBRACE=20, RBRACE=21, SEMICOLON=22, DOT=23, NEW=24, ROLL=25, 
		SINGLEROLL=26, INT=27, ROLLKEY=28, IF=29, THEN=30, ELSE=31, WHILE=32, 
		RETURN=33, DO=34, FOR=35, TO=36, DEFTYPEKEY=37, DEFFUNKEY=38, DEFVARKEY=39, 
		ID=40, WS=41;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "EQ", "NEQ", "ADD", "SUB", "MUL", "DIV", "MOD", 
		"AND", "OR", "ASSIGN", "COLON", "COMMA", "LPAREN", "RPAREN", "LBRACK", 
		"RBRACK", "LBRACE", "RBRACE", "SEMICOLON", "DOT", "NEW", "ROLL", "SINGLEROLL", 
		"INT", "ROLLKEY", "IF", "THEN", "ELSE", "WHILE", "RETURN", "DO", "FOR", 
		"TO", "DEFTYPEKEY", "DEFFUNKEY", "DEFVARKEY", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'array of'", "'option of'", "'=='", "'!='", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'&&'", "'||'", "'='", "':'", "','", "'('", "')'", 
		"'['", "']'", "'{'", "'}'", "';'", "'.'", "'new'", null, null, null, null, 
		"'if'", "'then'", "'else'", "'while'", "'return'", "'do'", "'for'", "'to'", 
		"'type'", "'fun'", "'var'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "EQ", "NEQ", "ADD", "SUB", "MUL", "DIV", "MOD", 
		"AND", "OR", "ASSIGN", "COLON", "COMMA", "LPAREN", "RPAREN", "LBRACK", 
		"RBRACK", "LBRACE", "RBRACE", "SEMICOLON", "DOT", "NEW", "ROLL", "SINGLEROLL", 
		"INT", "ROLLKEY", "IF", "THEN", "ELSE", "WHILE", "RETURN", "DO", "FOR", 
		"TO", "DEFTYPEKEY", "DEFFUNKEY", "DEFVARKEY", "ID", "WS"
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


	public inputLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "input.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2+\u00e7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\6\34\u00a3"+
		"\n\34\r\34\16\34\u00a4\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		"\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3"+
		")\3)\7)\u00dc\n)\f)\16)\u00df\13)\3*\6*\u00e2\n*\r*\16*\u00e3\3*\3*\2"+
		"\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+\3\2\7\3\2\62;\5\2FFff~~\4\2C\\c|\5\2\62"+
		";C\\c|\5\2\13\f\17\17\"\"\u00e9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5W\3\2\2\2\7`\3\2\2\2\tj\3\2"+
		"\2\2\13m\3\2\2\2\rp\3\2\2\2\17r\3\2\2\2\21t\3\2\2\2\23v\3\2\2\2\25x\3"+
		"\2\2\2\27z\3\2\2\2\31}\3\2\2\2\33\u0080\3\2\2\2\35\u0082\3\2\2\2\37\u0084"+
		"\3\2\2\2!\u0086\3\2\2\2#\u0088\3\2\2\2%\u008a\3\2\2\2\'\u008c\3\2\2\2"+
		")\u008e\3\2\2\2+\u0090\3\2\2\2-\u0092\3\2\2\2/\u0094\3\2\2\2\61\u0096"+
		"\3\2\2\2\63\u009a\3\2\2\2\65\u009e\3\2\2\2\67\u00a2\3\2\2\29\u00a6\3\2"+
		"\2\2;\u00a8\3\2\2\2=\u00ab\3\2\2\2?\u00b0\3\2\2\2A\u00b5\3\2\2\2C\u00bb"+
		"\3\2\2\2E\u00c2\3\2\2\2G\u00c5\3\2\2\2I\u00c9\3\2\2\2K\u00cc\3\2\2\2M"+
		"\u00d1\3\2\2\2O\u00d5\3\2\2\2Q\u00d9\3\2\2\2S\u00e1\3\2\2\2UV\7A\2\2V"+
		"\4\3\2\2\2WX\7c\2\2XY\7t\2\2YZ\7t\2\2Z[\7c\2\2[\\\7{\2\2\\]\7\"\2\2]^"+
		"\7q\2\2^_\7h\2\2_\6\3\2\2\2`a\7q\2\2ab\7r\2\2bc\7v\2\2cd\7k\2\2de\7q\2"+
		"\2ef\7p\2\2fg\7\"\2\2gh\7q\2\2hi\7h\2\2i\b\3\2\2\2jk\7?\2\2kl\7?\2\2l"+
		"\n\3\2\2\2mn\7#\2\2no\7?\2\2o\f\3\2\2\2pq\7-\2\2q\16\3\2\2\2rs\7/\2\2"+
		"s\20\3\2\2\2tu\7,\2\2u\22\3\2\2\2vw\7\61\2\2w\24\3\2\2\2xy\7\'\2\2y\26"+
		"\3\2\2\2z{\7(\2\2{|\7(\2\2|\30\3\2\2\2}~\7~\2\2~\177\7~\2\2\177\32\3\2"+
		"\2\2\u0080\u0081\7?\2\2\u0081\34\3\2\2\2\u0082\u0083\7<\2\2\u0083\36\3"+
		"\2\2\2\u0084\u0085\7.\2\2\u0085 \3\2\2\2\u0086\u0087\7*\2\2\u0087\"\3"+
		"\2\2\2\u0088\u0089\7+\2\2\u0089$\3\2\2\2\u008a\u008b\7]\2\2\u008b&\3\2"+
		"\2\2\u008c\u008d\7_\2\2\u008d(\3\2\2\2\u008e\u008f\7}\2\2\u008f*\3\2\2"+
		"\2\u0090\u0091\7\177\2\2\u0091,\3\2\2\2\u0092\u0093\7=\2\2\u0093.\3\2"+
		"\2\2\u0094\u0095\7\60\2\2\u0095\60\3\2\2\2\u0096\u0097\7p\2\2\u0097\u0098"+
		"\7g\2\2\u0098\u0099\7y\2\2\u0099\62\3\2\2\2\u009a\u009b\5\67\34\2\u009b"+
		"\u009c\59\35\2\u009c\u009d\5\67\34\2\u009d\64\3\2\2\2\u009e\u009f\59\35"+
		"\2\u009f\u00a0\5\67\34\2\u00a0\66\3\2\2\2\u00a1\u00a3\t\2\2\2\u00a2\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"8\3\2\2\2\u00a6\u00a7\t\3\2\2\u00a7:\3\2\2\2\u00a8\u00a9\7k\2\2\u00a9"+
		"\u00aa\7h\2\2\u00aa<\3\2\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7j\2\2\u00ad"+
		"\u00ae\7g\2\2\u00ae\u00af\7p\2\2\u00af>\3\2\2\2\u00b0\u00b1\7g\2\2\u00b1"+
		"\u00b2\7n\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4\7g\2\2\u00b4@\3\2\2\2\u00b5"+
		"\u00b6\7y\2\2\u00b6\u00b7\7j\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7n\2\2"+
		"\u00b9\u00ba\7g\2\2\u00baB\3\2\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7g\2"+
		"\2\u00bd\u00be\7v\2\2\u00be\u00bf\7w\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1"+
		"\7p\2\2\u00c1D\3\2\2\2\u00c2\u00c3\7f\2\2\u00c3\u00c4\7q\2\2\u00c4F\3"+
		"\2\2\2\u00c5\u00c6\7h\2\2\u00c6\u00c7\7q\2\2\u00c7\u00c8\7t\2\2\u00c8"+
		"H\3\2\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7q\2\2\u00cbJ\3\2\2\2\u00cc\u00cd"+
		"\7v\2\2\u00cd\u00ce\7{\2\2\u00ce\u00cf\7r\2\2\u00cf\u00d0\7g\2\2\u00d0"+
		"L\3\2\2\2\u00d1\u00d2\7h\2\2\u00d2\u00d3\7w\2\2\u00d3\u00d4\7p\2\2\u00d4"+
		"N\3\2\2\2\u00d5\u00d6\7x\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7t\2\2\u00d8"+
		"P\3\2\2\2\u00d9\u00dd\t\4\2\2\u00da\u00dc\t\5\2\2\u00db\u00da\3\2\2\2"+
		"\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00deR\3"+
		"\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e2\t\6\2\2\u00e1\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e6\b*\2\2\u00e6T\3\2\2\2\6\2\u00a4\u00dd\u00e3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}