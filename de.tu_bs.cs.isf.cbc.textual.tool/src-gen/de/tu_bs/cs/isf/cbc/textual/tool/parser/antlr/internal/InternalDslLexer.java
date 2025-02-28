package de.tu_bs.cs.isf.cbc.textual.tool.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDslLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int T__72=72;
	public static final int T__73=73;
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int T__80=80;
	public static final int T__81=81;
	public static final int T__82=82;
	public static final int T__83=83;
	public static final int T__84=84;
	public static final int T__85=85;
	public static final int T__86=86;
	public static final int T__87=87;
	public static final int T__88=88;
	public static final int T__89=89;
	public static final int T__90=90;
	public static final int T__91=91;
	public static final int T__92=92;
	public static final int T__93=93;
	public static final int T__94=94;
	public static final int T__95=95;
	public static final int T__96=96;
	public static final int T__97=97;
	public static final int T__98=98;
	public static final int T__99=99;
	public static final int T__100=100;
	public static final int T__101=101;
	public static final int T__102=102;
	public static final int T__103=103;
	public static final int T__104=104;
	public static final int T__105=105;
	public static final int T__106=106;
	public static final int T__107=107;
	public static final int T__108=108;
	public static final int T__109=109;
	public static final int T__110=110;
	public static final int T__111=111;
	public static final int T__112=112;
	public static final int T__113=113;
	public static final int T__114=114;
	public static final int T__115=115;
	public static final int T__116=116;
	public static final int T__117=117;
	public static final int T__118=118;
	public static final int T__119=119;
	public static final int T__120=120;
	public static final int RULE_ANY_OTHER=4;
	public static final int RULE_CHARACTER=5;
	public static final int RULE_DECIMAL=6;
	public static final int RULE_HEX=7;
	public static final int RULE_ID=8;
	public static final int RULE_INT=9;
	public static final int RULE_ML_COMMENT=10;
	public static final int RULE_SL_COMMENT=11;
	public static final int RULE_STRING=12;
	public static final int RULE_WS=13;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public InternalDslLexer() {} 
	public InternalDslLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalDslLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "InternalDsl.g"; }

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:10:7: ( '!' )
			// InternalDsl.g:10:9: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:11:7: ( '!=' )
			// InternalDsl.g:11:9: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:12:7: ( '#' )
			// InternalDsl.g:12:9: '#'
			{
			match('#'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:13:7: ( '%' )
			// InternalDsl.g:13:9: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:14:7: ( '%=' )
			// InternalDsl.g:14:9: '%='
			{
			match("%="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:15:7: ( '&&' )
			// InternalDsl.g:15:9: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:16:7: ( '&' )
			// InternalDsl.g:16:9: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:17:7: ( '&=' )
			// InternalDsl.g:17:9: '&='
			{
			match("&="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:18:7: ( '(' )
			// InternalDsl.g:18:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:19:7: ( '(\\\\exists' )
			// InternalDsl.g:19:9: '(\\\\exists'
			{
			match("(\\exists"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:20:7: ( '(\\\\forall' )
			// InternalDsl.g:20:9: '(\\\\forall'
			{
			match("(\\forall"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:21:7: ( ')' )
			// InternalDsl.g:21:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:22:7: ( '*' )
			// InternalDsl.g:22:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:23:7: ( '*/' )
			// InternalDsl.g:23:9: '*/'
			{
			match("*/"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:24:7: ( '*=' )
			// InternalDsl.g:24:9: '*='
			{
			match("*="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:25:7: ( '+' )
			// InternalDsl.g:25:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:26:7: ( '++' )
			// InternalDsl.g:26:9: '++'
			{
			match("++"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:27:7: ( '+=' )
			// InternalDsl.g:27:9: '+='
			{
			match("+="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:28:7: ( ',' )
			// InternalDsl.g:28:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:29:7: ( '-' )
			// InternalDsl.g:29:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:30:7: ( '--' )
			// InternalDsl.g:30:9: '--'
			{
			match("--"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:31:7: ( '-=' )
			// InternalDsl.g:31:9: '-='
			{
			match("-="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:32:7: ( '->' )
			// InternalDsl.g:32:9: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:33:7: ( '.' )
			// InternalDsl.g:33:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:34:7: ( '...' )
			// InternalDsl.g:34:9: '...'
			{
			match("..."); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__38"

	// $ANTLR start "T__39"
	public final void mT__39() throws RecognitionException {
		try {
			int _type = T__39;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:35:7: ( '/' )
			// InternalDsl.g:35:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__39"

	// $ANTLR start "T__40"
	public final void mT__40() throws RecognitionException {
		try {
			int _type = T__40;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:36:7: ( '/*' )
			// InternalDsl.g:36:9: '/*'
			{
			match("/*"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__40"

	// $ANTLR start "T__41"
	public final void mT__41() throws RecognitionException {
		try {
			int _type = T__41;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:37:7: ( '/=' )
			// InternalDsl.g:37:9: '/='
			{
			match("/="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__41"

	// $ANTLR start "T__42"
	public final void mT__42() throws RecognitionException {
		try {
			int _type = T__42;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:38:7: ( ':' )
			// InternalDsl.g:38:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__42"

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:39:7: ( ';' )
			// InternalDsl.g:39:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__43"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:40:7: ( '<' )
			// InternalDsl.g:40:9: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:41:7: ( '<<' )
			// InternalDsl.g:41:9: '<<'
			{
			match("<<"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:42:7: ( '<=' )
			// InternalDsl.g:42:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:43:7: ( '=' )
			// InternalDsl.g:43:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:44:7: ( '==' )
			// InternalDsl.g:44:9: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:45:7: ( '=>' )
			// InternalDsl.g:45:9: '=>'
			{
			match("=>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:46:7: ( '>' )
			// InternalDsl.g:46:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:47:7: ( '>=' )
			// InternalDsl.g:47:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:48:7: ( '?' )
			// InternalDsl.g:48:9: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:49:7: ( '@' )
			// InternalDsl.g:49:9: '@'
			{
			match('@'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:50:7: ( 'Block' )
			// InternalDsl.g:50:9: 'Block'
			{
			match("Block"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:51:7: ( 'Conditions' )
			// InternalDsl.g:51:9: 'Conditions'
			{
			match("Conditions"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:52:7: ( 'Do' )
			// InternalDsl.g:52:9: 'Do'
			{
			match("Do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:53:7: ( 'Elseif' )
			// InternalDsl.g:53:9: 'Elseif'
			{
			match("Elseif"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:54:7: ( 'Fi' )
			// InternalDsl.g:54:9: 'Fi'
			{
			match("Fi"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:55:7: ( 'Formula' )
			// InternalDsl.g:55:9: 'Formula'
			{
			match("Formula"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:56:7: ( 'Function' )
			// InternalDsl.g:56:9: 'Function'
			{
			match("Function"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:57:7: ( 'GlobalConditions' )
			// InternalDsl.g:57:9: 'GlobalConditions'
			{
			match("GlobalConditions"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:58:7: ( 'If' )
			// InternalDsl.g:58:9: 'If'
			{
			match("If"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:59:7: ( 'Intm:' )
			// InternalDsl.g:59:9: 'Intm:'
			{
			match("Intm:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:60:7: ( 'Inv:' )
			// InternalDsl.g:60:9: 'Inv:'
			{
			match("Inv:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:61:7: ( 'JavaVariables' )
			// InternalDsl.g:61:9: 'JavaVariables'
			{
			match("JavaVariables"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__65"

	// $ANTLR start "T__66"
	public final void mT__66() throws RecognitionException {
		try {
			int _type = T__66;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:62:7: ( 'NewName' )
			// InternalDsl.g:62:9: 'NewName'
			{
			match("NewName"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__66"

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:63:7: ( 'Od' )
			// InternalDsl.g:63:9: 'Od'
			{
			match("Od"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:64:7: ( 'Post:' )
			// InternalDsl.g:64:9: 'Post:'
			{
			match("Post:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:65:7: ( 'Pre:' )
			// InternalDsl.g:65:9: 'Pre:'
			{
			match("Pre:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:66:7: ( 'Renames' )
			// InternalDsl.g:66:9: 'Renames'
			{
			match("Renames"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__70"

	// $ANTLR start "T__71"
	public final void mT__71() throws RecognitionException {
		try {
			int _type = T__71;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:67:7: ( 'Renaming' )
			// InternalDsl.g:67:9: 'Renaming'
			{
			match("Renaming"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__71"

	// $ANTLR start "T__72"
	public final void mT__72() throws RecognitionException {
		try {
			int _type = T__72;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:68:7: ( 'Return' )
			// InternalDsl.g:68:9: 'Return'
			{
			match("Return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__72"

	// $ANTLR start "T__73"
	public final void mT__73() throws RecognitionException {
		try {
			int _type = T__73;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:69:7: ( 'Then' )
			// InternalDsl.g:69:9: 'Then'
			{
			match("Then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__73"

	// $ANTLR start "T__74"
	public final void mT__74() throws RecognitionException {
		try {
			int _type = T__74;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:70:7: ( 'Type' )
			// InternalDsl.g:70:9: 'Type'
			{
			match("Type"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__74"

	// $ANTLR start "T__75"
	public final void mT__75() throws RecognitionException {
		try {
			int _type = T__75;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:71:7: ( 'Var:' )
			// InternalDsl.g:71:9: 'Var:'
			{
			match("Var:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__75"

	// $ANTLR start "T__76"
	public final void mT__76() throws RecognitionException {
		try {
			int _type = T__76;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:72:7: ( 'Variables' )
			// InternalDsl.g:72:9: 'Variables'
			{
			match("Variables"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__76"

	// $ANTLR start "T__77"
	public final void mT__77() throws RecognitionException {
		try {
			int _type = T__77;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:73:7: ( 'While' )
			// InternalDsl.g:73:9: 'While'
			{
			match("While"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__77"

	// $ANTLR start "T__78"
	public final void mT__78() throws RecognitionException {
		try {
			int _type = T__78;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:74:7: ( '[' )
			// InternalDsl.g:74:9: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__78"

	// $ANTLR start "T__79"
	public final void mT__79() throws RecognitionException {
		try {
			int _type = T__79;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:75:7: ( ']' )
			// InternalDsl.g:75:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__79"

	// $ANTLR start "T__80"
	public final void mT__80() throws RecognitionException {
		try {
			int _type = T__80;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:76:7: ( '^' )
			// InternalDsl.g:76:9: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__80"

	// $ANTLR start "T__81"
	public final void mT__81() throws RecognitionException {
		try {
			int _type = T__81;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:77:7: ( '^=' )
			// InternalDsl.g:77:9: '^='
			{
			match("^="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__81"

	// $ANTLR start "T__82"
	public final void mT__82() throws RecognitionException {
		try {
			int _type = T__82;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:78:7: ( 'assignable' )
			// InternalDsl.g:78:9: 'assignable'
			{
			match("assignable"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__82"

	// $ANTLR start "T__83"
	public final void mT__83() throws RecognitionException {
		try {
			int _type = T__83;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:79:7: ( 'break' )
			// InternalDsl.g:79:9: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__83"

	// $ANTLR start "T__84"
	public final void mT__84() throws RecognitionException {
		try {
			int _type = T__84;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:80:7: ( 'case' )
			// InternalDsl.g:80:9: 'case'
			{
			match("case"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__84"

	// $ANTLR start "T__85"
	public final void mT__85() throws RecognitionException {
		try {
			int _type = T__85;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:81:7: ( 'catch' )
			// InternalDsl.g:81:9: 'catch'
			{
			match("catch"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__85"

	// $ANTLR start "T__86"
	public final void mT__86() throws RecognitionException {
		try {
			int _type = T__86;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:82:7: ( 'class' )
			// InternalDsl.g:82:9: 'class'
			{
			match("class"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__86"

	// $ANTLR start "T__87"
	public final void mT__87() throws RecognitionException {
		try {
			int _type = T__87;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:83:7: ( 'continue' )
			// InternalDsl.g:83:9: 'continue'
			{
			match("continue"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__87"

	// $ANTLR start "T__88"
	public final void mT__88() throws RecognitionException {
		try {
			int _type = T__88;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:84:7: ( 'decreases' )
			// InternalDsl.g:84:9: 'decreases'
			{
			match("decreases"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__88"

	// $ANTLR start "T__89"
	public final void mT__89() throws RecognitionException {
		try {
			int _type = T__89;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:85:7: ( 'default' )
			// InternalDsl.g:85:9: 'default'
			{
			match("default"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__89"

	// $ANTLR start "T__90"
	public final void mT__90() throws RecognitionException {
		try {
			int _type = T__90;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:86:7: ( 'do' )
			// InternalDsl.g:86:9: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__90"

	// $ANTLR start "T__91"
	public final void mT__91() throws RecognitionException {
		try {
			int _type = T__91;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:87:7: ( 'else' )
			// InternalDsl.g:87:9: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__91"

	// $ANTLR start "T__92"
	public final void mT__92() throws RecognitionException {
		try {
			int _type = T__92;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:88:7: ( 'ensures' )
			// InternalDsl.g:88:9: 'ensures'
			{
			match("ensures"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__92"

	// $ANTLR start "T__93"
	public final void mT__93() throws RecognitionException {
		try {
			int _type = T__93;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:89:7: ( 'extends' )
			// InternalDsl.g:89:9: 'extends'
			{
			match("extends"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__93"

	// $ANTLR start "T__94"
	public final void mT__94() throws RecognitionException {
		try {
			int _type = T__94;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:90:7: ( 'extension' )
			// InternalDsl.g:90:9: 'extension'
			{
			match("extension"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__94"

	// $ANTLR start "T__95"
	public final void mT__95() throws RecognitionException {
		try {
			int _type = T__95;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:91:7: ( 'false' )
			// InternalDsl.g:91:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__95"

	// $ANTLR start "T__96"
	public final void mT__96() throws RecognitionException {
		try {
			int _type = T__96;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:92:7: ( 'final' )
			// InternalDsl.g:92:9: 'final'
			{
			match("final"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__96"

	// $ANTLR start "T__97"
	public final void mT__97() throws RecognitionException {
		try {
			int _type = T__97;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:93:7: ( 'finally' )
			// InternalDsl.g:93:9: 'finally'
			{
			match("finally"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__97"

	// $ANTLR start "T__98"
	public final void mT__98() throws RecognitionException {
		try {
			int _type = T__98;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:94:7: ( 'for' )
			// InternalDsl.g:94:9: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__98"

	// $ANTLR start "T__99"
	public final void mT__99() throws RecognitionException {
		try {
			int _type = T__99;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:95:7: ( 'if' )
			// InternalDsl.g:95:9: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__99"

	// $ANTLR start "T__100"
	public final void mT__100() throws RecognitionException {
		try {
			int _type = T__100;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:96:8: ( 'import' )
			// InternalDsl.g:96:10: 'import'
			{
			match("import"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__100"

	// $ANTLR start "T__101"
	public final void mT__101() throws RecognitionException {
		try {
			int _type = T__101;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:97:8: ( 'instanceof' )
			// InternalDsl.g:97:10: 'instanceof'
			{
			match("instanceof"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__101"

	// $ANTLR start "T__102"
	public final void mT__102() throws RecognitionException {
		try {
			int _type = T__102;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:98:8: ( 'loop_invariant' )
			// InternalDsl.g:98:10: 'loop_invariant'
			{
			match("loop_invariant"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__102"

	// $ANTLR start "T__103"
	public final void mT__103() throws RecognitionException {
		try {
			int _type = T__103;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:99:8: ( 'new' )
			// InternalDsl.g:99:10: 'new'
			{
			match("new"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__103"

	// $ANTLR start "T__104"
	public final void mT__104() throws RecognitionException {
		try {
			int _type = T__104;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:100:8: ( 'null' )
			// InternalDsl.g:100:10: 'null'
			{
			match("null"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__104"

	// $ANTLR start "T__105"
	public final void mT__105() throws RecognitionException {
		try {
			int _type = T__105;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:101:8: ( 'requires' )
			// InternalDsl.g:101:10: 'requires'
			{
			match("requires"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__105"

	// $ANTLR start "T__106"
	public final void mT__106() throws RecognitionException {
		try {
			int _type = T__106;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:102:8: ( 'return' )
			// InternalDsl.g:102:10: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__106"

	// $ANTLR start "T__107"
	public final void mT__107() throws RecognitionException {
		try {
			int _type = T__107;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:103:8: ( 'static' )
			// InternalDsl.g:103:10: 'static'
			{
			match("static"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__107"

	// $ANTLR start "T__108"
	public final void mT__108() throws RecognitionException {
		try {
			int _type = T__108;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:104:8: ( 'super' )
			// InternalDsl.g:104:10: 'super'
			{
			match("super"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__108"

	// $ANTLR start "T__109"
	public final void mT__109() throws RecognitionException {
		try {
			int _type = T__109;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:105:8: ( 'switch' )
			// InternalDsl.g:105:10: 'switch'
			{
			match("switch"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__109"

	// $ANTLR start "T__110"
	public final void mT__110() throws RecognitionException {
		try {
			int _type = T__110;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:106:8: ( 'synchronized' )
			// InternalDsl.g:106:10: 'synchronized'
			{
			match("synchronized"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__110"

	// $ANTLR start "T__111"
	public final void mT__111() throws RecognitionException {
		try {
			int _type = T__111;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:107:8: ( 'throw' )
			// InternalDsl.g:107:10: 'throw'
			{
			match("throw"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__111"

	// $ANTLR start "T__112"
	public final void mT__112() throws RecognitionException {
		try {
			int _type = T__112;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:108:8: ( 'true' )
			// InternalDsl.g:108:10: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__112"

	// $ANTLR start "T__113"
	public final void mT__113() throws RecognitionException {
		try {
			int _type = T__113;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:109:8: ( 'try' )
			// InternalDsl.g:109:10: 'try'
			{
			match("try"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__113"

	// $ANTLR start "T__114"
	public final void mT__114() throws RecognitionException {
		try {
			int _type = T__114;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:110:8: ( 'while' )
			// InternalDsl.g:110:10: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__114"

	// $ANTLR start "T__115"
	public final void mT__115() throws RecognitionException {
		try {
			int _type = T__115;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:111:8: ( '{' )
			// InternalDsl.g:111:10: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__115"

	// $ANTLR start "T__116"
	public final void mT__116() throws RecognitionException {
		try {
			int _type = T__116;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:112:8: ( '|' )
			// InternalDsl.g:112:10: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__116"

	// $ANTLR start "T__117"
	public final void mT__117() throws RecognitionException {
		try {
			int _type = T__117;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:113:8: ( '|=' )
			// InternalDsl.g:113:10: '|='
			{
			match("|="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__117"

	// $ANTLR start "T__118"
	public final void mT__118() throws RecognitionException {
		try {
			int _type = T__118;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:114:8: ( '||' )
			// InternalDsl.g:114:10: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__118"

	// $ANTLR start "T__119"
	public final void mT__119() throws RecognitionException {
		try {
			int _type = T__119;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:115:8: ( '}' )
			// InternalDsl.g:115:10: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__119"

	// $ANTLR start "T__120"
	public final void mT__120() throws RecognitionException {
		try {
			int _type = T__120;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:116:8: ( '~' )
			// InternalDsl.g:116:10: '~'
			{
			match('~'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__120"

	// $ANTLR start "RULE_ML_COMMENT"
	public final void mRULE_ML_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:12419:17: ( 'MyVeryOwnComment!' )
			// InternalDsl.g:12419:19: 'MyVeryOwnComment!'
			{
			match("MyVeryOwnComment!"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ML_COMMENT"

	// $ANTLR start "RULE_STRING"
	public final void mRULE_STRING() throws RecognitionException {
		try {
			int _type = RULE_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:12421:13: ( '\"' ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? )
			// InternalDsl.g:12421:15: '\"' ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )?
			{
			match('\"'); 
			// InternalDsl.g:12421:19: ( '\\\\' . |~ ( ( '\\\\' | '\"' ) ) )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='\\') ) {
					alt1=1;
				}
				else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '[')||(LA1_0 >= ']' && LA1_0 <= '\uFFFF')) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// InternalDsl.g:12421:20: '\\\\' .
					{
					match('\\'); 
					matchAny(); 
					}
					break;
				case 2 :
					// InternalDsl.g:12421:27: ~ ( ( '\\\\' | '\"' ) )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			// InternalDsl.g:12421:43: ( '\"' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\"') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// InternalDsl.g:12421:43: '\"'
					{
					match('\"'); 
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_STRING"

	// $ANTLR start "RULE_CHARACTER"
	public final void mRULE_CHARACTER() throws RecognitionException {
		try {
			int _type = RULE_CHARACTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:12423:16: ( '\\'' ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? )
			// InternalDsl.g:12423:18: '\\'' ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )?
			{
			match('\''); 
			// InternalDsl.g:12423:23: ( '\\\\' . |~ ( ( '\\\\' | '\\'' ) ) )*
			loop3:
			while (true) {
				int alt3=3;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\\') ) {
					alt3=1;
				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '&')||(LA3_0 >= '(' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
					alt3=2;
				}

				switch (alt3) {
				case 1 :
					// InternalDsl.g:12423:24: '\\\\' .
					{
					match('\\'); 
					matchAny(); 
					}
					break;
				case 2 :
					// InternalDsl.g:12423:31: ~ ( ( '\\\\' | '\\'' ) )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			// InternalDsl.g:12423:48: ( '\\'' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\'') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// InternalDsl.g:12423:48: '\\''
					{
					match('\''); 
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_CHARACTER"

	// $ANTLR start "RULE_HEX"
	public final void mRULE_HEX() throws RecognitionException {
		try {
			int _type = RULE_HEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:12425:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )? )
			// InternalDsl.g:12425:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
			{
			// InternalDsl.g:12425:12: ( '0x' | '0X' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='0') ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1=='x') ) {
					alt5=1;
				}
				else if ( (LA5_1=='X') ) {
					alt5=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// InternalDsl.g:12425:13: '0x'
					{
					match("0x"); 

					}
					break;
				case 2 :
					// InternalDsl.g:12425:18: '0X'
					{
					match("0X"); 

					}
					break;

			}

			// InternalDsl.g:12425:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'F')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'f')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// InternalDsl.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			// InternalDsl.g:12425:58: ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='#') ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// InternalDsl.g:12425:59: '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
					{
					match('#'); 
					// InternalDsl.g:12425:63: ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0=='B'||LA7_0=='b') ) {
						alt7=1;
					}
					else if ( (LA7_0=='L'||LA7_0=='l') ) {
						alt7=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 7, 0, input);
						throw nvae;
					}

					switch (alt7) {
						case 1 :
							// InternalDsl.g:12425:64: ( 'b' | 'B' ) ( 'i' | 'I' )
							{
							if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;
						case 2 :
							// InternalDsl.g:12425:84: ( 'l' | 'L' )
							{
							if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_HEX"

	// $ANTLR start "RULE_INT"
	public final void mRULE_INT() throws RecognitionException {
		try {
			int _type = RULE_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:12427:10: ( '0' .. '9' ( '0' .. '9' | '_' )* )
			// InternalDsl.g:12427:12: '0' .. '9' ( '0' .. '9' | '_' )*
			{
			matchRange('0','9'); 
			// InternalDsl.g:12427:21: ( '0' .. '9' | '_' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')||LA9_0=='_') ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// InternalDsl.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||input.LA(1)=='_' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop9;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_INT"

	// $ANTLR start "RULE_DECIMAL"
	public final void mRULE_DECIMAL() throws RecognitionException {
		try {
			int _type = RULE_DECIMAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:12429:14: ( RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )? )
			// InternalDsl.g:12429:16: RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
			{
			mRULE_INT(); 

			// InternalDsl.g:12429:25: ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='E'||LA11_0=='e') ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// InternalDsl.g:12429:26: ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT
					{
					if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// InternalDsl.g:12429:36: ( '+' | '-' )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0=='+'||LA10_0=='-') ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// InternalDsl.g:
							{
							if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					mRULE_INT(); 

					}
					break;

			}

			// InternalDsl.g:12429:58: ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
			int alt12=3;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='B'||LA12_0=='b') ) {
				alt12=1;
			}
			else if ( (LA12_0=='D'||LA12_0=='F'||LA12_0=='L'||LA12_0=='d'||LA12_0=='f'||LA12_0=='l') ) {
				alt12=2;
			}
			switch (alt12) {
				case 1 :
					// InternalDsl.g:12429:59: ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' )
					{
					if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( input.LA(1)=='D'||input.LA(1)=='I'||input.LA(1)=='d'||input.LA(1)=='i' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// InternalDsl.g:12429:87: ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' )
					{
					if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='L'||input.LA(1)=='d'||input.LA(1)=='f'||input.LA(1)=='l' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_DECIMAL"

	// $ANTLR start "RULE_ID"
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:12431:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )* )
			// InternalDsl.g:12431:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
			{
			// InternalDsl.g:12431:11: ( '^' )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0=='^') ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// InternalDsl.g:12431:11: '^'
					{
					match('^'); 
					}
					break;

			}

			if ( input.LA(1)=='$'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// InternalDsl.g:12431:44: ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0=='$'||(LA14_0 >= '0' && LA14_0 <= '9')||(LA14_0 >= 'A' && LA14_0 <= 'Z')||LA14_0=='_'||(LA14_0 >= 'a' && LA14_0 <= 'z')) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// InternalDsl.g:
					{
					if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop14;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ID"

	// $ANTLR start "RULE_SL_COMMENT"
	public final void mRULE_SL_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:12433:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
			// InternalDsl.g:12433:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
			{
			match("//"); 

			// InternalDsl.g:12433:24: (~ ( ( '\\n' | '\\r' ) ) )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= '\u0000' && LA15_0 <= '\t')||(LA15_0 >= '\u000B' && LA15_0 <= '\f')||(LA15_0 >= '\u000E' && LA15_0 <= '\uFFFF')) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// InternalDsl.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop15;
				}
			}

			// InternalDsl.g:12433:40: ( ( '\\r' )? '\\n' )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0=='\n'||LA17_0=='\r') ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// InternalDsl.g:12433:41: ( '\\r' )? '\\n'
					{
					// InternalDsl.g:12433:41: ( '\\r' )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0=='\r') ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// InternalDsl.g:12433:41: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_SL_COMMENT"

	// $ANTLR start "RULE_WS"
	public final void mRULE_WS() throws RecognitionException {
		try {
			int _type = RULE_WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:12435:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// InternalDsl.g:12435:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// InternalDsl.g:12435:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( ((LA18_0 >= '\t' && LA18_0 <= '\n')||LA18_0=='\r'||LA18_0==' ') ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// InternalDsl.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt18 >= 1 ) break loop18;
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_WS"

	// $ANTLR start "RULE_ANY_OTHER"
	public final void mRULE_ANY_OTHER() throws RecognitionException {
		try {
			int _type = RULE_ANY_OTHER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// InternalDsl.g:12437:16: ( . )
			// InternalDsl.g:12437:18: .
			{
			matchAny(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RULE_ANY_OTHER"

	@Override
	public void mTokens() throws RecognitionException {
		// InternalDsl.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | RULE_ML_COMMENT | RULE_STRING | RULE_CHARACTER | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
		int alt19=117;
		alt19 = dfa19.predict(input);
		switch (alt19) {
			case 1 :
				// InternalDsl.g:1:10: T__14
				{
				mT__14(); 

				}
				break;
			case 2 :
				// InternalDsl.g:1:16: T__15
				{
				mT__15(); 

				}
				break;
			case 3 :
				// InternalDsl.g:1:22: T__16
				{
				mT__16(); 

				}
				break;
			case 4 :
				// InternalDsl.g:1:28: T__17
				{
				mT__17(); 

				}
				break;
			case 5 :
				// InternalDsl.g:1:34: T__18
				{
				mT__18(); 

				}
				break;
			case 6 :
				// InternalDsl.g:1:40: T__19
				{
				mT__19(); 

				}
				break;
			case 7 :
				// InternalDsl.g:1:46: T__20
				{
				mT__20(); 

				}
				break;
			case 8 :
				// InternalDsl.g:1:52: T__21
				{
				mT__21(); 

				}
				break;
			case 9 :
				// InternalDsl.g:1:58: T__22
				{
				mT__22(); 

				}
				break;
			case 10 :
				// InternalDsl.g:1:64: T__23
				{
				mT__23(); 

				}
				break;
			case 11 :
				// InternalDsl.g:1:70: T__24
				{
				mT__24(); 

				}
				break;
			case 12 :
				// InternalDsl.g:1:76: T__25
				{
				mT__25(); 

				}
				break;
			case 13 :
				// InternalDsl.g:1:82: T__26
				{
				mT__26(); 

				}
				break;
			case 14 :
				// InternalDsl.g:1:88: T__27
				{
				mT__27(); 

				}
				break;
			case 15 :
				// InternalDsl.g:1:94: T__28
				{
				mT__28(); 

				}
				break;
			case 16 :
				// InternalDsl.g:1:100: T__29
				{
				mT__29(); 

				}
				break;
			case 17 :
				// InternalDsl.g:1:106: T__30
				{
				mT__30(); 

				}
				break;
			case 18 :
				// InternalDsl.g:1:112: T__31
				{
				mT__31(); 

				}
				break;
			case 19 :
				// InternalDsl.g:1:118: T__32
				{
				mT__32(); 

				}
				break;
			case 20 :
				// InternalDsl.g:1:124: T__33
				{
				mT__33(); 

				}
				break;
			case 21 :
				// InternalDsl.g:1:130: T__34
				{
				mT__34(); 

				}
				break;
			case 22 :
				// InternalDsl.g:1:136: T__35
				{
				mT__35(); 

				}
				break;
			case 23 :
				// InternalDsl.g:1:142: T__36
				{
				mT__36(); 

				}
				break;
			case 24 :
				// InternalDsl.g:1:148: T__37
				{
				mT__37(); 

				}
				break;
			case 25 :
				// InternalDsl.g:1:154: T__38
				{
				mT__38(); 

				}
				break;
			case 26 :
				// InternalDsl.g:1:160: T__39
				{
				mT__39(); 

				}
				break;
			case 27 :
				// InternalDsl.g:1:166: T__40
				{
				mT__40(); 

				}
				break;
			case 28 :
				// InternalDsl.g:1:172: T__41
				{
				mT__41(); 

				}
				break;
			case 29 :
				// InternalDsl.g:1:178: T__42
				{
				mT__42(); 

				}
				break;
			case 30 :
				// InternalDsl.g:1:184: T__43
				{
				mT__43(); 

				}
				break;
			case 31 :
				// InternalDsl.g:1:190: T__44
				{
				mT__44(); 

				}
				break;
			case 32 :
				// InternalDsl.g:1:196: T__45
				{
				mT__45(); 

				}
				break;
			case 33 :
				// InternalDsl.g:1:202: T__46
				{
				mT__46(); 

				}
				break;
			case 34 :
				// InternalDsl.g:1:208: T__47
				{
				mT__47(); 

				}
				break;
			case 35 :
				// InternalDsl.g:1:214: T__48
				{
				mT__48(); 

				}
				break;
			case 36 :
				// InternalDsl.g:1:220: T__49
				{
				mT__49(); 

				}
				break;
			case 37 :
				// InternalDsl.g:1:226: T__50
				{
				mT__50(); 

				}
				break;
			case 38 :
				// InternalDsl.g:1:232: T__51
				{
				mT__51(); 

				}
				break;
			case 39 :
				// InternalDsl.g:1:238: T__52
				{
				mT__52(); 

				}
				break;
			case 40 :
				// InternalDsl.g:1:244: T__53
				{
				mT__53(); 

				}
				break;
			case 41 :
				// InternalDsl.g:1:250: T__54
				{
				mT__54(); 

				}
				break;
			case 42 :
				// InternalDsl.g:1:256: T__55
				{
				mT__55(); 

				}
				break;
			case 43 :
				// InternalDsl.g:1:262: T__56
				{
				mT__56(); 

				}
				break;
			case 44 :
				// InternalDsl.g:1:268: T__57
				{
				mT__57(); 

				}
				break;
			case 45 :
				// InternalDsl.g:1:274: T__58
				{
				mT__58(); 

				}
				break;
			case 46 :
				// InternalDsl.g:1:280: T__59
				{
				mT__59(); 

				}
				break;
			case 47 :
				// InternalDsl.g:1:286: T__60
				{
				mT__60(); 

				}
				break;
			case 48 :
				// InternalDsl.g:1:292: T__61
				{
				mT__61(); 

				}
				break;
			case 49 :
				// InternalDsl.g:1:298: T__62
				{
				mT__62(); 

				}
				break;
			case 50 :
				// InternalDsl.g:1:304: T__63
				{
				mT__63(); 

				}
				break;
			case 51 :
				// InternalDsl.g:1:310: T__64
				{
				mT__64(); 

				}
				break;
			case 52 :
				// InternalDsl.g:1:316: T__65
				{
				mT__65(); 

				}
				break;
			case 53 :
				// InternalDsl.g:1:322: T__66
				{
				mT__66(); 

				}
				break;
			case 54 :
				// InternalDsl.g:1:328: T__67
				{
				mT__67(); 

				}
				break;
			case 55 :
				// InternalDsl.g:1:334: T__68
				{
				mT__68(); 

				}
				break;
			case 56 :
				// InternalDsl.g:1:340: T__69
				{
				mT__69(); 

				}
				break;
			case 57 :
				// InternalDsl.g:1:346: T__70
				{
				mT__70(); 

				}
				break;
			case 58 :
				// InternalDsl.g:1:352: T__71
				{
				mT__71(); 

				}
				break;
			case 59 :
				// InternalDsl.g:1:358: T__72
				{
				mT__72(); 

				}
				break;
			case 60 :
				// InternalDsl.g:1:364: T__73
				{
				mT__73(); 

				}
				break;
			case 61 :
				// InternalDsl.g:1:370: T__74
				{
				mT__74(); 

				}
				break;
			case 62 :
				// InternalDsl.g:1:376: T__75
				{
				mT__75(); 

				}
				break;
			case 63 :
				// InternalDsl.g:1:382: T__76
				{
				mT__76(); 

				}
				break;
			case 64 :
				// InternalDsl.g:1:388: T__77
				{
				mT__77(); 

				}
				break;
			case 65 :
				// InternalDsl.g:1:394: T__78
				{
				mT__78(); 

				}
				break;
			case 66 :
				// InternalDsl.g:1:400: T__79
				{
				mT__79(); 

				}
				break;
			case 67 :
				// InternalDsl.g:1:406: T__80
				{
				mT__80(); 

				}
				break;
			case 68 :
				// InternalDsl.g:1:412: T__81
				{
				mT__81(); 

				}
				break;
			case 69 :
				// InternalDsl.g:1:418: T__82
				{
				mT__82(); 

				}
				break;
			case 70 :
				// InternalDsl.g:1:424: T__83
				{
				mT__83(); 

				}
				break;
			case 71 :
				// InternalDsl.g:1:430: T__84
				{
				mT__84(); 

				}
				break;
			case 72 :
				// InternalDsl.g:1:436: T__85
				{
				mT__85(); 

				}
				break;
			case 73 :
				// InternalDsl.g:1:442: T__86
				{
				mT__86(); 

				}
				break;
			case 74 :
				// InternalDsl.g:1:448: T__87
				{
				mT__87(); 

				}
				break;
			case 75 :
				// InternalDsl.g:1:454: T__88
				{
				mT__88(); 

				}
				break;
			case 76 :
				// InternalDsl.g:1:460: T__89
				{
				mT__89(); 

				}
				break;
			case 77 :
				// InternalDsl.g:1:466: T__90
				{
				mT__90(); 

				}
				break;
			case 78 :
				// InternalDsl.g:1:472: T__91
				{
				mT__91(); 

				}
				break;
			case 79 :
				// InternalDsl.g:1:478: T__92
				{
				mT__92(); 

				}
				break;
			case 80 :
				// InternalDsl.g:1:484: T__93
				{
				mT__93(); 

				}
				break;
			case 81 :
				// InternalDsl.g:1:490: T__94
				{
				mT__94(); 

				}
				break;
			case 82 :
				// InternalDsl.g:1:496: T__95
				{
				mT__95(); 

				}
				break;
			case 83 :
				// InternalDsl.g:1:502: T__96
				{
				mT__96(); 

				}
				break;
			case 84 :
				// InternalDsl.g:1:508: T__97
				{
				mT__97(); 

				}
				break;
			case 85 :
				// InternalDsl.g:1:514: T__98
				{
				mT__98(); 

				}
				break;
			case 86 :
				// InternalDsl.g:1:520: T__99
				{
				mT__99(); 

				}
				break;
			case 87 :
				// InternalDsl.g:1:526: T__100
				{
				mT__100(); 

				}
				break;
			case 88 :
				// InternalDsl.g:1:533: T__101
				{
				mT__101(); 

				}
				break;
			case 89 :
				// InternalDsl.g:1:540: T__102
				{
				mT__102(); 

				}
				break;
			case 90 :
				// InternalDsl.g:1:547: T__103
				{
				mT__103(); 

				}
				break;
			case 91 :
				// InternalDsl.g:1:554: T__104
				{
				mT__104(); 

				}
				break;
			case 92 :
				// InternalDsl.g:1:561: T__105
				{
				mT__105(); 

				}
				break;
			case 93 :
				// InternalDsl.g:1:568: T__106
				{
				mT__106(); 

				}
				break;
			case 94 :
				// InternalDsl.g:1:575: T__107
				{
				mT__107(); 

				}
				break;
			case 95 :
				// InternalDsl.g:1:582: T__108
				{
				mT__108(); 

				}
				break;
			case 96 :
				// InternalDsl.g:1:589: T__109
				{
				mT__109(); 

				}
				break;
			case 97 :
				// InternalDsl.g:1:596: T__110
				{
				mT__110(); 

				}
				break;
			case 98 :
				// InternalDsl.g:1:603: T__111
				{
				mT__111(); 

				}
				break;
			case 99 :
				// InternalDsl.g:1:610: T__112
				{
				mT__112(); 

				}
				break;
			case 100 :
				// InternalDsl.g:1:617: T__113
				{
				mT__113(); 

				}
				break;
			case 101 :
				// InternalDsl.g:1:624: T__114
				{
				mT__114(); 

				}
				break;
			case 102 :
				// InternalDsl.g:1:631: T__115
				{
				mT__115(); 

				}
				break;
			case 103 :
				// InternalDsl.g:1:638: T__116
				{
				mT__116(); 

				}
				break;
			case 104 :
				// InternalDsl.g:1:645: T__117
				{
				mT__117(); 

				}
				break;
			case 105 :
				// InternalDsl.g:1:652: T__118
				{
				mT__118(); 

				}
				break;
			case 106 :
				// InternalDsl.g:1:659: T__119
				{
				mT__119(); 

				}
				break;
			case 107 :
				// InternalDsl.g:1:666: T__120
				{
				mT__120(); 

				}
				break;
			case 108 :
				// InternalDsl.g:1:673: RULE_ML_COMMENT
				{
				mRULE_ML_COMMENT(); 

				}
				break;
			case 109 :
				// InternalDsl.g:1:689: RULE_STRING
				{
				mRULE_STRING(); 

				}
				break;
			case 110 :
				// InternalDsl.g:1:701: RULE_CHARACTER
				{
				mRULE_CHARACTER(); 

				}
				break;
			case 111 :
				// InternalDsl.g:1:716: RULE_HEX
				{
				mRULE_HEX(); 

				}
				break;
			case 112 :
				// InternalDsl.g:1:725: RULE_INT
				{
				mRULE_INT(); 

				}
				break;
			case 113 :
				// InternalDsl.g:1:734: RULE_DECIMAL
				{
				mRULE_DECIMAL(); 

				}
				break;
			case 114 :
				// InternalDsl.g:1:747: RULE_ID
				{
				mRULE_ID(); 

				}
				break;
			case 115 :
				// InternalDsl.g:1:755: RULE_SL_COMMENT
				{
				mRULE_SL_COMMENT(); 

				}
				break;
			case 116 :
				// InternalDsl.g:1:771: RULE_WS
				{
				mRULE_WS(); 

				}
				break;
			case 117 :
				// InternalDsl.g:1:779: RULE_ANY_OTHER
				{
				mRULE_ANY_OTHER(); 

				}
				break;

		}
	}


	protected DFA19 dfa19 = new DFA19(this);
	static final String DFA19_eotS =
		"\1\uffff\1\100\1\uffff\1\103\1\106\1\110\1\uffff\1\114\1\117\1\uffff\1\124\1\126\1\132\2\uffff\1\137\1\142\1\144\2\uffff\17\150\2\uffff\1\177\15\150\1\uffff\1\u009e\2\uffff\1\150\2\uffff\2\u00a6\53\uffff\1\150\1\uffff\1\150\1\u00ad\1\150\1\u00af\3\150\1\u00b3\3\150\1\u00b8\7\150\4\uffff\6\150\1\u00c9\6\150\1\u00d0\15\150\6\uffff\1\150\3\uffff\1\u00a6\5\uffff\2\150\1\uffff\1\150\1\uffff\3\150\1\uffff\4\150\1\uffff\20\150\1\uffff\5\150\1\u0101\1\uffff\3\150\1\u0105\11\150\1\u010f\11\150\1\uffff\3\150\1\uffff\2\150\1\u011e\1\u011f\1\uffff\4\150\1\u0124\5\150\1\u012a\4\150\1\uffff\3\150\1\uffff\1\u0132\7\150\1\u013a\1\uffff\2\150\1\u013d\5\150\1\uffff\2\150\1\uffff\2\150\2\uffff\1\150\1\u0149\1\150\1\u014b\1\uffff\1\u014c\1\u014d\3\150\1\uffff\2\150\1\u0154\1\u0156\3\150\1\uffff\3\150\1\u015d\2\150\1\u0160\1\uffff\1\u0161\1\150\1\uffff\1\150\1\u0164\7\150\1\u016c\1\150\1\uffff\1\150\3\uffff\6\150\1\uffff\1\150\1\uffff\1\u0176\3\150\1\u017a\1\u017b\1\uffff\1\u017c\1\150\2\uffff\2\150\1\uffff\1\u0180\3\150\1\u0184\1\u0185\1\150\1\uffff\4\150\1\u018b\1\u018c\1\u018d\1\150\1\u018f\1\uffff\3\150\3\uffff\3\150\1\uffff\1\u0196\2\150\2\uffff\1\u0199\2\150\1\u019c\1\150\3\uffff\1\150\1\uffff\2\150\1\u01a1\3\150\1\uffff\2\150\1\uffff\1\u01a7\1\150\1\uffff\1\u01a9\1\u01aa\2\150\1\uffff\2\150\1\u01af\2\150\1\uffff\1\u01b2\2\uffff\1\u01b3\3\150\1\uffff\2\150\2\uffff\6\150\1\u01bf\2\150\1\u01c2\1\150\1\uffff\2\150\1\uffff\1\u01c6\2\150\1\uffff\1\150\1\u01ca\1\150\2\uffff";
	static final String DFA19_eofS =
		"\u01cc\uffff";
	static final String DFA19_minS =
		"\1\0\1\75\1\uffff\1\75\1\46\1\134\1\uffff\1\57\1\53\1\uffff\1\55\1\56\1\52\2\uffff\1\74\2\75\2\uffff\1\154\2\157\1\154\1\151\1\154\1\146\1\141\1\145\1\144\1\157\1\145\1\150\1\141\1\150\2\uffff\1\44\1\163\1\162\1\141\1\145\1\154\1\141\1\146\1\157\2\145\1\164\2\150\1\uffff\1\75\2\uffff\1\171\2\uffff\2\60\13\uffff\1\145\37\uffff\1\157\1\uffff\1\156\1\44\1\163\1\44\1\162\1\156\1\157\1\44\1\164\1\166\1\167\1\44\1\163\1\145\1\156\1\145\1\160\1\162\1\151\4\uffff\1\163\1\145\1\163\1\141\1\156\1\143\1\44\2\163\1\164\1\154\1\156\1\162\1\44\1\160\1\163\1\157\1\167\1\154\1\161\1\141\1\160\1\151\1\156\1\162\1\165\1\151\6\uffff\1\126\3\uffff\1\60\5\uffff\1\143\1\144\1\uffff\1\145\1\uffff\1\155\1\143\1\142\1\uffff\1\155\1\72\1\141\1\116\1\uffff\1\164\1\72\1\141\1\165\1\156\1\145\1\72\1\154\1\151\1\141\1\145\1\143\1\163\1\164\1\162\1\141\1\uffff\1\145\1\165\1\145\1\163\1\141\1\44\1\uffff\1\157\1\164\1\160\1\44\1\154\2\165\1\164\1\145\1\164\1\143\1\157\1\145\1\44\1\154\1\145\1\153\2\151\1\165\1\164\1\141\1\72\1\uffff\1\126\1\141\1\72\1\uffff\1\155\1\162\2\44\1\uffff\1\141\1\145\1\147\1\153\1\44\1\150\1\163\1\151\1\145\1\165\1\44\1\162\1\156\1\145\1\154\1\uffff\1\162\1\141\1\137\1\uffff\1\44\1\151\1\162\1\151\1\162\1\143\1\150\1\167\1\44\1\uffff\1\145\1\162\1\44\1\164\1\146\1\154\1\151\1\154\1\uffff\1\141\1\155\1\uffff\1\145\1\156\2\uffff\1\142\1\44\1\156\1\44\1\uffff\2\44\1\156\1\141\1\154\1\uffff\1\145\1\144\2\44\1\164\1\156\1\151\1\uffff\1\162\1\156\1\143\1\44\1\150\1\162\1\44\1\uffff\1\44\1\171\1\uffff\1\151\1\44\1\141\1\157\1\103\1\162\1\145\1\163\1\156\1\44\1\154\1\uffff\1\141\3\uffff\1\165\1\163\1\164\2\163\1\151\1\uffff\1\171\1\uffff\1\44\1\143\1\156\1\145\2\44\1\uffff\1\44\1\157\2\uffff\1\117\1\157\1\uffff\1\44\1\156\1\157\1\151\2\44\1\147\1\uffff\1\145\1\142\2\145\3\44\1\157\1\44\1\uffff\1\145\1\166\1\163\3\uffff\1\156\1\167\1\156\1\uffff\1\44\1\156\1\141\2\uffff\1\44\1\163\1\154\1\44\1\163\3\uffff\1\156\1\uffff\1\157\1\141\1\44\1\151\1\156\1\163\1\uffff\1\144\1\142\1\uffff\1\44\1\145\1\uffff\2\44\1\146\1\162\1\uffff\1\172\1\103\1\44\1\151\1\154\1\uffff\1\44\2\uffff\1\44\1\151\1\145\1\157\1\uffff\1\164\1\145\2\uffff\1\141\1\144\1\155\1\151\1\163\1\156\1\44\1\155\1\157\1\44\1\164\1\uffff\1\145\1\156\1\uffff\1\44\1\156\1\163\1\uffff\1\164\1\44\1\41\2\uffff";
	static final String DFA19_maxS =
		"\1\uffff\1\75\1\uffff\2\75\1\134\1\uffff\2\75\1\uffff\1\76\1\56\1\75\2\uffff\1\75\1\76\1\75\2\uffff\1\154\2\157\1\154\1\165\1\154\1\156\1\141\1\145\1\144\1\162\1\145\1\171\1\141\1\150\2\uffff\1\172\1\163\1\162\2\157\1\170\1\157\1\156\1\157\1\165\1\145\1\171\1\162\1\150\1\uffff\1\174\2\uffff\1\171\2\uffff\1\170\1\154\13\uffff\1\146\37\uffff\1\157\1\uffff\1\156\1\172\1\163\1\172\1\162\1\156\1\157\1\172\2\166\1\167\1\172\1\163\1\145\1\164\1\145\1\160\1\162\1\151\4\uffff\1\163\1\145\1\164\1\141\1\156\1\146\1\172\2\163\1\164\1\154\1\156\1\162\1\172\1\160\1\163\1\157\1\167\1\154\1\164\1\141\1\160\1\151\1\156\1\162\1\171\1\151\6\uffff\1\126\3\uffff\1\154\5\uffff\1\143\1\144\1\uffff\1\145\1\uffff\1\155\1\143\1\142\1\uffff\1\155\1\72\1\141\1\116\1\uffff\1\164\1\72\1\141\1\165\1\156\1\145\1\151\1\154\1\151\1\141\1\145\1\143\1\163\1\164\1\162\1\141\1\uffff\1\145\1\165\1\145\1\163\1\141\1\172\1\uffff\1\157\1\164\1\160\1\172\1\154\2\165\1\164\1\145\1\164\1\143\1\157\1\145\1\172\1\154\1\145\1\153\2\151\1\165\1\164\1\141\1\72\1\uffff\1\126\1\141\1\72\1\uffff\1\155\1\162\2\172\1\uffff\1\141\1\145\1\147\1\153\1\172\1\150\1\163\1\151\1\145\1\165\1\172\1\162\1\156\1\145\1\154\1\uffff\1\162\1\141\1\137\1\uffff\1\172\1\151\1\162\1\151\1\162\1\143\1\150\1\167\1\172\1\uffff\1\145\1\162\1\172\1\164\1\146\1\154\1\151\1\154\1\uffff\1\141\1\155\1\uffff\1\151\1\156\2\uffff\1\142\1\172\1\156\1\172\1\uffff\2\172\1\156\1\141\1\154\1\uffff\1\145\1\163\2\172\1\164\1\156\1\151\1\uffff\1\162\1\156\1\143\1\172\1\150\1\162\1\172\1\uffff\1\172\1\171\1\uffff\1\151\1\172\1\141\1\157\1\103\1\162\1\145\1\163\1\156\1\172\1\154\1\uffff\1\141\3\uffff\1\165\1\163\1\164\2\163\1\151\1\uffff\1\171\1\uffff\1\172\1\143\1\156\1\145\2\172\1\uffff\1\172\1\157\2\uffff\1\117\1\157\1\uffff\1\172\1\156\1\157\1\151\2\172\1\147\1\uffff\1\145\1\142\2\145\3\172\1\157\1\172\1\uffff\1\145\1\166\1\163\3\uffff\1\156\1\167\1\156\1\uffff\1\172\1\156\1\141\2\uffff\1\172\1\163\1\154\1\172\1\163\3\uffff\1\156\1\uffff\1\157\1\141\1\172\1\151\1\156\1\163\1\uffff\1\144\1\142\1\uffff\1\172\1\145\1\uffff\2\172\1\146\1\162\1\uffff\1\172\1\103\1\172\1\151\1\154\1\uffff\1\172\2\uffff\1\172\1\151\1\145\1\157\1\uffff\1\164\1\145\2\uffff\1\141\1\144\1\155\1\151\1\163\1\156\1\172\1\155\1\157\1\172\1\164\1\uffff\1\145\1\156\1\uffff\1\172\1\156\1\163\1\uffff\1\164\1\172\1\41\2\uffff";
	static final String DFA19_acceptS =
		"\2\uffff\1\3\3\uffff\1\14\2\uffff\1\23\3\uffff\1\35\1\36\3\uffff\1\47\1\50\17\uffff\1\101\1\102\16\uffff\1\146\1\uffff\1\152\1\153\1\uffff\1\155\1\156\2\uffff\1\162\1\164\1\165\1\2\1\1\1\3\1\5\1\4\1\6\1\10\1\7\1\uffff\1\11\1\14\1\16\1\17\1\15\1\21\1\22\1\20\1\23\1\25\1\26\1\27\1\24\1\31\1\30\1\33\1\34\1\163\1\32\1\35\1\36\1\40\1\41\1\37\1\43\1\44\1\42\1\46\1\45\1\47\1\50\1\uffff\1\162\23\uffff\1\101\1\102\1\104\1\103\33\uffff\1\146\1\150\1\151\1\147\1\152\1\153\1\uffff\1\155\1\156\1\157\1\uffff\1\160\1\161\1\164\1\12\1\13\2\uffff\1\53\1\uffff\1\55\3\uffff\1\61\4\uffff\1\66\20\uffff\1\115\6\uffff\1\126\27\uffff\1\63\3\uffff\1\70\4\uffff\1\76\17\uffff\1\125\3\uffff\1\132\11\uffff\1\144\10\uffff\1\62\2\uffff\1\67\2\uffff\1\74\1\75\4\uffff\1\107\5\uffff\1\116\7\uffff\1\133\7\uffff\1\143\2\uffff\1\51\13\uffff\1\100\1\uffff\1\106\1\110\1\111\6\uffff\1\122\1\uffff\1\123\6\uffff\1\137\2\uffff\1\142\1\145\2\uffff\1\54\7\uffff\1\73\11\uffff\1\127\3\uffff\1\135\1\136\1\140\3\uffff\1\56\3\uffff\1\65\1\71\5\uffff\1\114\1\117\1\120\1\uffff\1\124\6\uffff\1\57\2\uffff\1\72\2\uffff\1\112\4\uffff\1\134\5\uffff\1\77\1\uffff\1\113\1\121\4\uffff\1\52\2\uffff\1\105\1\130\13\uffff\1\141\2\uffff\1\64\3\uffff\1\131\3\uffff\1\60\1\154";
	static final String DFA19_specialS =
		"\1\0\u01cb\uffff}>";
	static final String[] DFA19_transitionS = {
			"\11\76\2\75\2\76\1\75\22\76\1\75\1\1\1\70\1\2\1\74\1\3\1\4\1\71\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\72\11\73\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\74\1\24\1\25\1\26\1\27\1\30\1\31\1\74\1\32\1\33\2\74\1\67\1\34\1\35\1\36\1\74\1\37\1\74\1\40\1\74\1\41\1\42\3\74\1\43\1\76\1\44\1\45\1\74\1\76\1\46\1\47\1\50\1\51\1\52\1\53\2\74\1\54\2\74\1\55\1\74\1\56\3\74\1\57\1\60\1\61\2\74\1\62\3\74\1\63\1\64\1\65\1\66\uff81\76",
			"\1\77",
			"",
			"\1\102",
			"\1\104\26\uffff\1\105",
			"\1\107",
			"",
			"\1\112\15\uffff\1\113",
			"\1\115\21\uffff\1\116",
			"",
			"\1\121\17\uffff\1\122\1\123",
			"\1\125",
			"\1\127\4\uffff\1\131\15\uffff\1\130",
			"",
			"",
			"\1\135\1\136",
			"\1\140\1\141",
			"\1\143",
			"",
			"",
			"\1\147",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154\5\uffff\1\155\5\uffff\1\156",
			"\1\157",
			"\1\160\7\uffff\1\161",
			"\1\162",
			"\1\163",
			"\1\164",
			"\1\165\2\uffff\1\166",
			"\1\167",
			"\1\170\20\uffff\1\171",
			"\1\172",
			"\1\173",
			"",
			"",
			"\1\150\30\uffff\1\176\3\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u0080",
			"\1\u0081",
			"\1\u0082\12\uffff\1\u0083\2\uffff\1\u0084",
			"\1\u0085\11\uffff\1\u0086",
			"\1\u0087\1\uffff\1\u0088\11\uffff\1\u0089",
			"\1\u008a\7\uffff\1\u008b\5\uffff\1\u008c",
			"\1\u008d\6\uffff\1\u008e\1\u008f",
			"\1\u0090",
			"\1\u0091\17\uffff\1\u0092",
			"\1\u0093",
			"\1\u0094\1\u0095\1\uffff\1\u0096\1\uffff\1\u0097",
			"\1\u0098\11\uffff\1\u0099",
			"\1\u009a",
			"",
			"\1\u009c\76\uffff\1\u009d",
			"",
			"",
			"\1\u00a1",
			"",
			"",
			"\12\u00a5\10\uffff\1\u00a7\1\uffff\3\u00a7\5\uffff\1\u00a7\13\uffff\1\u00a4\6\uffff\1\u00a5\2\uffff\1\u00a7\1\uffff\3\u00a7\5\uffff\1\u00a7\13\uffff\1\u00a4",
			"\12\u00a5\10\uffff\1\u00a7\1\uffff\3\u00a7\5\uffff\1\u00a7\22\uffff\1\u00a5\2\uffff\1\u00a7\1\uffff\3\u00a7\5\uffff\1\u00a7",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00a9\1\u00aa",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00ab",
			"",
			"\1\u00ac",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u00ae",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u00b0",
			"\1\u00b1",
			"\1\u00b2",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u00b4\1\uffff\1\u00b5",
			"\1\u00b6",
			"\1\u00b7",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u00b9",
			"\1\u00ba",
			"\1\u00bb\5\uffff\1\u00bc",
			"\1\u00bd",
			"\1\u00be",
			"\1\u00bf",
			"\1\u00c0",
			"",
			"",
			"",
			"",
			"\1\u00c1",
			"\1\u00c2",
			"\1\u00c3\1\u00c4",
			"\1\u00c5",
			"\1\u00c6",
			"\1\u00c7\2\uffff\1\u00c8",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u00ca",
			"\1\u00cb",
			"\1\u00cc",
			"\1\u00cd",
			"\1\u00ce",
			"\1\u00cf",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u00d1",
			"\1\u00d2",
			"\1\u00d3",
			"\1\u00d4",
			"\1\u00d5",
			"\1\u00d6\2\uffff\1\u00d7",
			"\1\u00d8",
			"\1\u00d9",
			"\1\u00da",
			"\1\u00db",
			"\1\u00dc",
			"\1\u00dd\3\uffff\1\u00de",
			"\1\u00df",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00e0",
			"",
			"",
			"",
			"\12\u00a5\10\uffff\1\u00a7\1\uffff\3\u00a7\5\uffff\1\u00a7\22\uffff\1\u00a5\2\uffff\1\u00a7\1\uffff\3\u00a7\5\uffff\1\u00a7",
			"",
			"",
			"",
			"",
			"",
			"\1\u00e1",
			"\1\u00e2",
			"",
			"\1\u00e3",
			"",
			"\1\u00e4",
			"\1\u00e5",
			"\1\u00e6",
			"",
			"\1\u00e7",
			"\1\u00e8",
			"\1\u00e9",
			"\1\u00ea",
			"",
			"\1\u00eb",
			"\1\u00ec",
			"\1\u00ed",
			"\1\u00ee",
			"\1\u00ef",
			"\1\u00f0",
			"\1\u00f1\56\uffff\1\u00f2",
			"\1\u00f3",
			"\1\u00f4",
			"\1\u00f5",
			"\1\u00f6",
			"\1\u00f7",
			"\1\u00f8",
			"\1\u00f9",
			"\1\u00fa",
			"\1\u00fb",
			"",
			"\1\u00fc",
			"\1\u00fd",
			"\1\u00fe",
			"\1\u00ff",
			"\1\u0100",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"",
			"\1\u0102",
			"\1\u0103",
			"\1\u0104",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u0106",
			"\1\u0107",
			"\1\u0108",
			"\1\u0109",
			"\1\u010a",
			"\1\u010b",
			"\1\u010c",
			"\1\u010d",
			"\1\u010e",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u0110",
			"\1\u0111",
			"\1\u0112",
			"\1\u0113",
			"\1\u0114",
			"\1\u0115",
			"\1\u0116",
			"\1\u0117",
			"\1\u0118",
			"",
			"\1\u0119",
			"\1\u011a",
			"\1\u011b",
			"",
			"\1\u011c",
			"\1\u011d",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"",
			"\1\u0120",
			"\1\u0121",
			"\1\u0122",
			"\1\u0123",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u0125",
			"\1\u0126",
			"\1\u0127",
			"\1\u0128",
			"\1\u0129",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u012b",
			"\1\u012c",
			"\1\u012d",
			"\1\u012e",
			"",
			"\1\u012f",
			"\1\u0130",
			"\1\u0131",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u0133",
			"\1\u0134",
			"\1\u0135",
			"\1\u0136",
			"\1\u0137",
			"\1\u0138",
			"\1\u0139",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"",
			"\1\u013b",
			"\1\u013c",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u013e",
			"\1\u013f",
			"\1\u0140",
			"\1\u0141",
			"\1\u0142",
			"",
			"\1\u0143",
			"\1\u0144",
			"",
			"\1\u0145\3\uffff\1\u0146",
			"\1\u0147",
			"",
			"",
			"\1\u0148",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u014a",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u014e",
			"\1\u014f",
			"\1\u0150",
			"",
			"\1\u0151",
			"\1\u0152\16\uffff\1\u0153",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\13\150\1\u0155\16\150",
			"\1\u0157",
			"\1\u0158",
			"\1\u0159",
			"",
			"\1\u015a",
			"\1\u015b",
			"\1\u015c",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u015e",
			"\1\u015f",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u0162",
			"",
			"\1\u0163",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u0165",
			"\1\u0166",
			"\1\u0167",
			"\1\u0168",
			"\1\u0169",
			"\1\u016a",
			"\1\u016b",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u016d",
			"",
			"\1\u016e",
			"",
			"",
			"",
			"\1\u016f",
			"\1\u0170",
			"\1\u0171",
			"\1\u0172",
			"\1\u0173",
			"\1\u0174",
			"",
			"\1\u0175",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u0177",
			"\1\u0178",
			"\1\u0179",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u017d",
			"",
			"",
			"\1\u017e",
			"\1\u017f",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u0181",
			"\1\u0182",
			"\1\u0183",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u0186",
			"",
			"\1\u0187",
			"\1\u0188",
			"\1\u0189",
			"\1\u018a",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u018e",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"",
			"\1\u0190",
			"\1\u0191",
			"\1\u0192",
			"",
			"",
			"",
			"\1\u0193",
			"\1\u0194",
			"\1\u0195",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u0197",
			"\1\u0198",
			"",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u019a",
			"\1\u019b",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u019d",
			"",
			"",
			"",
			"\1\u019e",
			"",
			"\1\u019f",
			"\1\u01a0",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u01a2",
			"\1\u01a3",
			"\1\u01a4",
			"",
			"\1\u01a5",
			"\1\u01a6",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u01a8",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u01ab",
			"\1\u01ac",
			"",
			"\1\u01ad",
			"\1\u01ae",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u01b0",
			"\1\u01b1",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u01b4",
			"\1\u01b5",
			"\1\u01b6",
			"",
			"\1\u01b7",
			"\1\u01b8",
			"",
			"",
			"\1\u01b9",
			"\1\u01ba",
			"\1\u01bb",
			"\1\u01bc",
			"\1\u01bd",
			"\1\u01be",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u01c0",
			"\1\u01c1",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u01c3",
			"",
			"\1\u01c4",
			"\1\u01c5",
			"",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u01c7",
			"\1\u01c8",
			"",
			"\1\u01c9",
			"\1\150\13\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff\32\150",
			"\1\u01cb",
			"",
			""
	};

	static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
	static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
	static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
	static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
	static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
	static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
	static final short[][] DFA19_transition;

	static {
		int numStates = DFA19_transitionS.length;
		DFA19_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
		}
	}

	protected class DFA19 extends DFA {

		public DFA19(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 19;
			this.eot = DFA19_eot;
			this.eof = DFA19_eof;
			this.min = DFA19_min;
			this.max = DFA19_max;
			this.accept = DFA19_accept;
			this.special = DFA19_special;
			this.transition = DFA19_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | RULE_ML_COMMENT | RULE_STRING | RULE_CHARACTER | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA19_0 = input.LA(1);
						s = -1;
						if ( (LA19_0=='!') ) {s = 1;}
						else if ( (LA19_0=='#') ) {s = 2;}
						else if ( (LA19_0=='%') ) {s = 3;}
						else if ( (LA19_0=='&') ) {s = 4;}
						else if ( (LA19_0=='(') ) {s = 5;}
						else if ( (LA19_0==')') ) {s = 6;}
						else if ( (LA19_0=='*') ) {s = 7;}
						else if ( (LA19_0=='+') ) {s = 8;}
						else if ( (LA19_0==',') ) {s = 9;}
						else if ( (LA19_0=='-') ) {s = 10;}
						else if ( (LA19_0=='.') ) {s = 11;}
						else if ( (LA19_0=='/') ) {s = 12;}
						else if ( (LA19_0==':') ) {s = 13;}
						else if ( (LA19_0==';') ) {s = 14;}
						else if ( (LA19_0=='<') ) {s = 15;}
						else if ( (LA19_0=='=') ) {s = 16;}
						else if ( (LA19_0=='>') ) {s = 17;}
						else if ( (LA19_0=='?') ) {s = 18;}
						else if ( (LA19_0=='@') ) {s = 19;}
						else if ( (LA19_0=='B') ) {s = 20;}
						else if ( (LA19_0=='C') ) {s = 21;}
						else if ( (LA19_0=='D') ) {s = 22;}
						else if ( (LA19_0=='E') ) {s = 23;}
						else if ( (LA19_0=='F') ) {s = 24;}
						else if ( (LA19_0=='G') ) {s = 25;}
						else if ( (LA19_0=='I') ) {s = 26;}
						else if ( (LA19_0=='J') ) {s = 27;}
						else if ( (LA19_0=='N') ) {s = 28;}
						else if ( (LA19_0=='O') ) {s = 29;}
						else if ( (LA19_0=='P') ) {s = 30;}
						else if ( (LA19_0=='R') ) {s = 31;}
						else if ( (LA19_0=='T') ) {s = 32;}
						else if ( (LA19_0=='V') ) {s = 33;}
						else if ( (LA19_0=='W') ) {s = 34;}
						else if ( (LA19_0=='[') ) {s = 35;}
						else if ( (LA19_0==']') ) {s = 36;}
						else if ( (LA19_0=='^') ) {s = 37;}
						else if ( (LA19_0=='a') ) {s = 38;}
						else if ( (LA19_0=='b') ) {s = 39;}
						else if ( (LA19_0=='c') ) {s = 40;}
						else if ( (LA19_0=='d') ) {s = 41;}
						else if ( (LA19_0=='e') ) {s = 42;}
						else if ( (LA19_0=='f') ) {s = 43;}
						else if ( (LA19_0=='i') ) {s = 44;}
						else if ( (LA19_0=='l') ) {s = 45;}
						else if ( (LA19_0=='n') ) {s = 46;}
						else if ( (LA19_0=='r') ) {s = 47;}
						else if ( (LA19_0=='s') ) {s = 48;}
						else if ( (LA19_0=='t') ) {s = 49;}
						else if ( (LA19_0=='w') ) {s = 50;}
						else if ( (LA19_0=='{') ) {s = 51;}
						else if ( (LA19_0=='|') ) {s = 52;}
						else if ( (LA19_0=='}') ) {s = 53;}
						else if ( (LA19_0=='~') ) {s = 54;}
						else if ( (LA19_0=='M') ) {s = 55;}
						else if ( (LA19_0=='\"') ) {s = 56;}
						else if ( (LA19_0=='\'') ) {s = 57;}
						else if ( (LA19_0=='0') ) {s = 58;}
						else if ( ((LA19_0 >= '1' && LA19_0 <= '9')) ) {s = 59;}
						else if ( (LA19_0=='$'||LA19_0=='A'||LA19_0=='H'||(LA19_0 >= 'K' && LA19_0 <= 'L')||LA19_0=='Q'||LA19_0=='S'||LA19_0=='U'||(LA19_0 >= 'X' && LA19_0 <= 'Z')||LA19_0=='_'||(LA19_0 >= 'g' && LA19_0 <= 'h')||(LA19_0 >= 'j' && LA19_0 <= 'k')||LA19_0=='m'||(LA19_0 >= 'o' && LA19_0 <= 'q')||(LA19_0 >= 'u' && LA19_0 <= 'v')||(LA19_0 >= 'x' && LA19_0 <= 'z')) ) {s = 60;}
						else if ( ((LA19_0 >= '\t' && LA19_0 <= '\n')||LA19_0=='\r'||LA19_0==' ') ) {s = 61;}
						else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '\b')||(LA19_0 >= '\u000B' && LA19_0 <= '\f')||(LA19_0 >= '\u000E' && LA19_0 <= '\u001F')||LA19_0=='\\'||LA19_0=='`'||(LA19_0 >= '\u007F' && LA19_0 <= '\uFFFF')) ) {s = 62;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 19, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
