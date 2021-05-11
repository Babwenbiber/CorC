package de.tu_bs.cs.isf.cbc.textual.tool.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import de.tu_bs.cs.isf.cbc.textual.tool.services.DslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDslParser extends AbstractInternalContentAssistParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ANY_OTHER", "RULE_ID", "RULE_INT", 
		"RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_STRING", "RULE_WS", "'$1'", 
		"'$2'", "'$3'", "'%'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", 
		"'/'", "':'", "';'", "'='", "'@1'", "'@2'", "'@3'", "'Block'", "'Formula'", 
		"'GlobalConditions'", "'JavaVariables'", "'Renaming'", "'['", "']'", "'conditions'", 
		"'do'", "'elseif'", "'fi'", "'function'", "'if'", "'intm:'", "'inv:'", 
		"'newName'", "'od'", "'post:'", "'pre:'", "'renames'", "'return'", "'then'", 
		"'type'", "'var:'", "'variables'", "'while'", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
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
	public static final int RULE_ANY_OTHER=4;
	public static final int RULE_ID=5;
	public static final int RULE_INT=6;
	public static final int RULE_ML_COMMENT=7;
	public static final int RULE_SL_COMMENT=8;
	public static final int RULE_STRING=9;
	public static final int RULE_WS=10;

	// delegates
	public AbstractInternalContentAssistParser[] getDelegates() {
		return new AbstractInternalContentAssistParser[] {};
	}

	// delegators


	public InternalDslParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalDslParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return InternalDslParser.tokenNames; }
	@Override public String getGrammarFileName() { return "InternalDsl.g"; }


		private DslGrammarAccess grammarAccess;

		public void setGrammarAccess(DslGrammarAccess grammarAccess) {
			this.grammarAccess = grammarAccess;
		}

		@Override
		protected Grammar getGrammar() {
			return grammarAccess.getGrammar();
		}

		@Override
		protected String getValueForTokenName(String tokenName) {
			return tokenName;
		}



	// $ANTLR start "entryRuleCbCProblem"
	// InternalDsl.g:53:1: entryRuleCbCProblem : ruleCbCProblem EOF ;
	public final void entryRuleCbCProblem() throws RecognitionException {
		try {
			// InternalDsl.g:54:1: ( ruleCbCProblem EOF )
			// InternalDsl.g:55:1: ruleCbCProblem EOF
			{
			 before(grammarAccess.getCbCProblemRule()); 
			pushFollow(FOLLOW_1);
			ruleCbCProblem();
			state._fsp--;

			 after(grammarAccess.getCbCProblemRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleCbCProblem"



	// $ANTLR start "ruleCbCProblem"
	// InternalDsl.g:62:1: ruleCbCProblem : ( ( rule__CbCProblem__UnorderedGroup ) ) ;
	public final void ruleCbCProblem() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:66:2: ( ( ( rule__CbCProblem__UnorderedGroup ) ) )
			// InternalDsl.g:67:2: ( ( rule__CbCProblem__UnorderedGroup ) )
			{
			// InternalDsl.g:67:2: ( ( rule__CbCProblem__UnorderedGroup ) )
			// InternalDsl.g:68:3: ( rule__CbCProblem__UnorderedGroup )
			{
			 before(grammarAccess.getCbCProblemAccess().getUnorderedGroup()); 
			// InternalDsl.g:69:3: ( rule__CbCProblem__UnorderedGroup )
			// InternalDsl.g:69:4: rule__CbCProblem__UnorderedGroup
			{
			pushFollow(FOLLOW_2);
			rule__CbCProblem__UnorderedGroup();
			state._fsp--;

			}

			 after(grammarAccess.getCbCProblemAccess().getUnorderedGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleCbCProblem"



	// $ANTLR start "entryRuleCbCFormula"
	// InternalDsl.g:78:1: entryRuleCbCFormula : ruleCbCFormula EOF ;
	public final void entryRuleCbCFormula() throws RecognitionException {
		try {
			// InternalDsl.g:79:1: ( ruleCbCFormula EOF )
			// InternalDsl.g:80:1: ruleCbCFormula EOF
			{
			 before(grammarAccess.getCbCFormulaRule()); 
			pushFollow(FOLLOW_1);
			ruleCbCFormula();
			state._fsp--;

			 after(grammarAccess.getCbCFormulaRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleCbCFormula"



	// $ANTLR start "ruleCbCFormula"
	// InternalDsl.g:87:1: ruleCbCFormula : ( ( rule__CbCFormula__Group__0 ) ) ;
	public final void ruleCbCFormula() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:91:2: ( ( ( rule__CbCFormula__Group__0 ) ) )
			// InternalDsl.g:92:2: ( ( rule__CbCFormula__Group__0 ) )
			{
			// InternalDsl.g:92:2: ( ( rule__CbCFormula__Group__0 ) )
			// InternalDsl.g:93:3: ( rule__CbCFormula__Group__0 )
			{
			 before(grammarAccess.getCbCFormulaAccess().getGroup()); 
			// InternalDsl.g:94:3: ( rule__CbCFormula__Group__0 )
			// InternalDsl.g:94:4: rule__CbCFormula__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getCbCFormulaAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleCbCFormula"



	// $ANTLR start "entryRuleAbstractStatement"
	// InternalDsl.g:103:1: entryRuleAbstractStatement : ruleAbstractStatement EOF ;
	public final void entryRuleAbstractStatement() throws RecognitionException {
		try {
			// InternalDsl.g:104:1: ( ruleAbstractStatement EOF )
			// InternalDsl.g:105:1: ruleAbstractStatement EOF
			{
			 before(grammarAccess.getAbstractStatementRule()); 
			pushFollow(FOLLOW_1);
			ruleAbstractStatement();
			state._fsp--;

			 after(grammarAccess.getAbstractStatementRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleAbstractStatement"



	// $ANTLR start "ruleAbstractStatement"
	// InternalDsl.g:112:1: ruleAbstractStatement : ( ( rule__AbstractStatement__Alternatives ) ) ;
	public final void ruleAbstractStatement() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:116:2: ( ( ( rule__AbstractStatement__Alternatives ) ) )
			// InternalDsl.g:117:2: ( ( rule__AbstractStatement__Alternatives ) )
			{
			// InternalDsl.g:117:2: ( ( rule__AbstractStatement__Alternatives ) )
			// InternalDsl.g:118:3: ( rule__AbstractStatement__Alternatives )
			{
			 before(grammarAccess.getAbstractStatementAccess().getAlternatives()); 
			// InternalDsl.g:119:3: ( rule__AbstractStatement__Alternatives )
			// InternalDsl.g:119:4: rule__AbstractStatement__Alternatives
			{
			pushFollow(FOLLOW_2);
			rule__AbstractStatement__Alternatives();
			state._fsp--;

			}

			 after(grammarAccess.getAbstractStatementAccess().getAlternatives()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleAbstractStatement"



	// $ANTLR start "entryRuleEString"
	// InternalDsl.g:128:1: entryRuleEString : ruleEString EOF ;
	public final void entryRuleEString() throws RecognitionException {
		try {
			// InternalDsl.g:129:1: ( ruleEString EOF )
			// InternalDsl.g:130:1: ruleEString EOF
			{
			 before(grammarAccess.getEStringRule()); 
			pushFollow(FOLLOW_1);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getEStringRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleEString"



	// $ANTLR start "ruleEString"
	// InternalDsl.g:137:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
	public final void ruleEString() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:141:2: ( ( ( rule__EString__Alternatives ) ) )
			// InternalDsl.g:142:2: ( ( rule__EString__Alternatives ) )
			{
			// InternalDsl.g:142:2: ( ( rule__EString__Alternatives ) )
			// InternalDsl.g:143:3: ( rule__EString__Alternatives )
			{
			 before(grammarAccess.getEStringAccess().getAlternatives()); 
			// InternalDsl.g:144:3: ( rule__EString__Alternatives )
			// InternalDsl.g:144:4: rule__EString__Alternatives
			{
			pushFollow(FOLLOW_2);
			rule__EString__Alternatives();
			state._fsp--;

			}

			 after(grammarAccess.getEStringAccess().getAlternatives()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleEString"



	// $ANTLR start "entryRuleCodeString"
	// InternalDsl.g:153:1: entryRuleCodeString : ruleCodeString EOF ;
	public final void entryRuleCodeString() throws RecognitionException {
		try {
			// InternalDsl.g:154:1: ( ruleCodeString EOF )
			// InternalDsl.g:155:1: ruleCodeString EOF
			{
			 before(grammarAccess.getCodeStringRule()); 
			pushFollow(FOLLOW_1);
			ruleCodeString();
			state._fsp--;

			 after(grammarAccess.getCodeStringRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleCodeString"



	// $ANTLR start "ruleCodeString"
	// InternalDsl.g:162:1: ruleCodeString : ( ( ( rule__CodeString__Group__0 ) ) ( ( rule__CodeString__Group__0 )* ) ) ;
	public final void ruleCodeString() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:166:2: ( ( ( ( rule__CodeString__Group__0 ) ) ( ( rule__CodeString__Group__0 )* ) ) )
			// InternalDsl.g:167:2: ( ( ( rule__CodeString__Group__0 ) ) ( ( rule__CodeString__Group__0 )* ) )
			{
			// InternalDsl.g:167:2: ( ( ( rule__CodeString__Group__0 ) ) ( ( rule__CodeString__Group__0 )* ) )
			// InternalDsl.g:168:3: ( ( rule__CodeString__Group__0 ) ) ( ( rule__CodeString__Group__0 )* )
			{
			// InternalDsl.g:168:3: ( ( rule__CodeString__Group__0 ) )
			// InternalDsl.g:169:4: ( rule__CodeString__Group__0 )
			{
			 before(grammarAccess.getCodeStringAccess().getGroup()); 
			// InternalDsl.g:170:4: ( rule__CodeString__Group__0 )
			// InternalDsl.g:170:5: rule__CodeString__Group__0
			{
			pushFollow(FOLLOW_3);
			rule__CodeString__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getCodeStringAccess().getGroup()); 
			}

			// InternalDsl.g:173:3: ( ( rule__CodeString__Group__0 )* )
			// InternalDsl.g:174:4: ( rule__CodeString__Group__0 )*
			{
			 before(grammarAccess.getCodeStringAccess().getGroup()); 
			// InternalDsl.g:175:4: ( rule__CodeString__Group__0 )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==RULE_ID) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// InternalDsl.g:175:5: rule__CodeString__Group__0
					{
					pushFollow(FOLLOW_3);
					rule__CodeString__Group__0();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			 after(grammarAccess.getCodeStringAccess().getGroup()); 
			}

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleCodeString"



	// $ANTLR start "entryRuleVariableString"
	// InternalDsl.g:185:1: entryRuleVariableString : ruleVariableString EOF ;
	public final void entryRuleVariableString() throws RecognitionException {
		try {
			// InternalDsl.g:186:1: ( ruleVariableString EOF )
			// InternalDsl.g:187:1: ruleVariableString EOF
			{
			 before(grammarAccess.getVariableStringRule()); 
			pushFollow(FOLLOW_1);
			ruleVariableString();
			state._fsp--;

			 after(grammarAccess.getVariableStringRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleVariableString"



	// $ANTLR start "ruleVariableString"
	// InternalDsl.g:194:1: ruleVariableString : ( ( rule__VariableString__Group__0 ) ) ;
	public final void ruleVariableString() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:198:2: ( ( ( rule__VariableString__Group__0 ) ) )
			// InternalDsl.g:199:2: ( ( rule__VariableString__Group__0 ) )
			{
			// InternalDsl.g:199:2: ( ( rule__VariableString__Group__0 ) )
			// InternalDsl.g:200:3: ( rule__VariableString__Group__0 )
			{
			 before(grammarAccess.getVariableStringAccess().getGroup()); 
			// InternalDsl.g:201:3: ( rule__VariableString__Group__0 )
			// InternalDsl.g:201:4: rule__VariableString__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getVariableStringAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleVariableString"



	// $ANTLR start "entryRuleOperation"
	// InternalDsl.g:210:1: entryRuleOperation : ruleOperation EOF ;
	public final void entryRuleOperation() throws RecognitionException {
		try {
			// InternalDsl.g:211:1: ( ruleOperation EOF )
			// InternalDsl.g:212:1: ruleOperation EOF
			{
			 before(grammarAccess.getOperationRule()); 
			pushFollow(FOLLOW_1);
			ruleOperation();
			state._fsp--;

			 after(grammarAccess.getOperationRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleOperation"



	// $ANTLR start "ruleOperation"
	// InternalDsl.g:219:1: ruleOperation : ( ( rule__Operation__Alternatives ) ) ;
	public final void ruleOperation() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:223:2: ( ( ( rule__Operation__Alternatives ) ) )
			// InternalDsl.g:224:2: ( ( rule__Operation__Alternatives ) )
			{
			// InternalDsl.g:224:2: ( ( rule__Operation__Alternatives ) )
			// InternalDsl.g:225:3: ( rule__Operation__Alternatives )
			{
			 before(grammarAccess.getOperationAccess().getAlternatives()); 
			// InternalDsl.g:226:3: ( rule__Operation__Alternatives )
			// InternalDsl.g:226:4: rule__Operation__Alternatives
			{
			pushFollow(FOLLOW_2);
			rule__Operation__Alternatives();
			state._fsp--;

			}

			 after(grammarAccess.getOperationAccess().getAlternatives()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleOperation"



	// $ANTLR start "entryRuleAbstractStatement_Impl"
	// InternalDsl.g:235:1: entryRuleAbstractStatement_Impl : ruleAbstractStatement_Impl EOF ;
	public final void entryRuleAbstractStatement_Impl() throws RecognitionException {
		try {
			// InternalDsl.g:236:1: ( ruleAbstractStatement_Impl EOF )
			// InternalDsl.g:237:1: ruleAbstractStatement_Impl EOF
			{
			 before(grammarAccess.getAbstractStatement_ImplRule()); 
			pushFollow(FOLLOW_1);
			ruleAbstractStatement_Impl();
			state._fsp--;

			 after(grammarAccess.getAbstractStatement_ImplRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleAbstractStatement_Impl"



	// $ANTLR start "ruleAbstractStatement_Impl"
	// InternalDsl.g:244:1: ruleAbstractStatement_Impl : ( ( rule__AbstractStatement_Impl__Group__0 ) ) ;
	public final void ruleAbstractStatement_Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:248:2: ( ( ( rule__AbstractStatement_Impl__Group__0 ) ) )
			// InternalDsl.g:249:2: ( ( rule__AbstractStatement_Impl__Group__0 ) )
			{
			// InternalDsl.g:249:2: ( ( rule__AbstractStatement_Impl__Group__0 ) )
			// InternalDsl.g:250:3: ( rule__AbstractStatement_Impl__Group__0 )
			{
			 before(grammarAccess.getAbstractStatement_ImplAccess().getGroup()); 
			// InternalDsl.g:251:3: ( rule__AbstractStatement_Impl__Group__0 )
			// InternalDsl.g:251:4: rule__AbstractStatement_Impl__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__AbstractStatement_Impl__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getAbstractStatement_ImplAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleAbstractStatement_Impl"



	// $ANTLR start "entryRuleMethodStatement"
	// InternalDsl.g:260:1: entryRuleMethodStatement : ruleMethodStatement EOF ;
	public final void entryRuleMethodStatement() throws RecognitionException {
		try {
			// InternalDsl.g:261:1: ( ruleMethodStatement EOF )
			// InternalDsl.g:262:1: ruleMethodStatement EOF
			{
			 before(grammarAccess.getMethodStatementRule()); 
			pushFollow(FOLLOW_1);
			ruleMethodStatement();
			state._fsp--;

			 after(grammarAccess.getMethodStatementRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleMethodStatement"



	// $ANTLR start "ruleMethodStatement"
	// InternalDsl.g:269:1: ruleMethodStatement : ( ( rule__MethodStatement__Group__0 ) ) ;
	public final void ruleMethodStatement() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:273:2: ( ( ( rule__MethodStatement__Group__0 ) ) )
			// InternalDsl.g:274:2: ( ( rule__MethodStatement__Group__0 ) )
			{
			// InternalDsl.g:274:2: ( ( rule__MethodStatement__Group__0 ) )
			// InternalDsl.g:275:3: ( rule__MethodStatement__Group__0 )
			{
			 before(grammarAccess.getMethodStatementAccess().getGroup()); 
			// InternalDsl.g:276:3: ( rule__MethodStatement__Group__0 )
			// InternalDsl.g:276:4: rule__MethodStatement__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__MethodStatement__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getMethodStatementAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleMethodStatement"



	// $ANTLR start "entryRuleReturnStatement"
	// InternalDsl.g:285:1: entryRuleReturnStatement : ruleReturnStatement EOF ;
	public final void entryRuleReturnStatement() throws RecognitionException {
		try {
			// InternalDsl.g:286:1: ( ruleReturnStatement EOF )
			// InternalDsl.g:287:1: ruleReturnStatement EOF
			{
			 before(grammarAccess.getReturnStatementRule()); 
			pushFollow(FOLLOW_1);
			ruleReturnStatement();
			state._fsp--;

			 after(grammarAccess.getReturnStatementRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleReturnStatement"



	// $ANTLR start "ruleReturnStatement"
	// InternalDsl.g:294:1: ruleReturnStatement : ( ( rule__ReturnStatement__Group__0 ) ) ;
	public final void ruleReturnStatement() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:298:2: ( ( ( rule__ReturnStatement__Group__0 ) ) )
			// InternalDsl.g:299:2: ( ( rule__ReturnStatement__Group__0 ) )
			{
			// InternalDsl.g:299:2: ( ( rule__ReturnStatement__Group__0 ) )
			// InternalDsl.g:300:3: ( rule__ReturnStatement__Group__0 )
			{
			 before(grammarAccess.getReturnStatementAccess().getGroup()); 
			// InternalDsl.g:301:3: ( rule__ReturnStatement__Group__0 )
			// InternalDsl.g:301:4: rule__ReturnStatement__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__ReturnStatement__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getReturnStatementAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleReturnStatement"



	// $ANTLR start "entryRuleStrengthWeakStatement"
	// InternalDsl.g:310:1: entryRuleStrengthWeakStatement : ruleStrengthWeakStatement EOF ;
	public final void entryRuleStrengthWeakStatement() throws RecognitionException {
		try {
			// InternalDsl.g:311:1: ( ruleStrengthWeakStatement EOF )
			// InternalDsl.g:312:1: ruleStrengthWeakStatement EOF
			{
			 before(grammarAccess.getStrengthWeakStatementRule()); 
			pushFollow(FOLLOW_1);
			ruleStrengthWeakStatement();
			state._fsp--;

			 after(grammarAccess.getStrengthWeakStatementRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleStrengthWeakStatement"



	// $ANTLR start "ruleStrengthWeakStatement"
	// InternalDsl.g:319:1: ruleStrengthWeakStatement : ( ( rule__StrengthWeakStatement__Group__0 ) ) ;
	public final void ruleStrengthWeakStatement() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:323:2: ( ( ( rule__StrengthWeakStatement__Group__0 ) ) )
			// InternalDsl.g:324:2: ( ( rule__StrengthWeakStatement__Group__0 ) )
			{
			// InternalDsl.g:324:2: ( ( rule__StrengthWeakStatement__Group__0 ) )
			// InternalDsl.g:325:3: ( rule__StrengthWeakStatement__Group__0 )
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getGroup()); 
			// InternalDsl.g:326:3: ( rule__StrengthWeakStatement__Group__0 )
			// InternalDsl.g:326:4: rule__StrengthWeakStatement__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getStrengthWeakStatementAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleStrengthWeakStatement"



	// $ANTLR start "entryRuleCondition"
	// InternalDsl.g:335:1: entryRuleCondition : ruleCondition EOF ;
	public final void entryRuleCondition() throws RecognitionException {
		try {
			// InternalDsl.g:336:1: ( ruleCondition EOF )
			// InternalDsl.g:337:1: ruleCondition EOF
			{
			 before(grammarAccess.getConditionRule()); 
			pushFollow(FOLLOW_1);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getConditionRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleCondition"



	// $ANTLR start "ruleCondition"
	// InternalDsl.g:344:1: ruleCondition : ( ( rule__Condition__Group__0 ) ) ;
	public final void ruleCondition() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:348:2: ( ( ( rule__Condition__Group__0 ) ) )
			// InternalDsl.g:349:2: ( ( rule__Condition__Group__0 ) )
			{
			// InternalDsl.g:349:2: ( ( rule__Condition__Group__0 ) )
			// InternalDsl.g:350:3: ( rule__Condition__Group__0 )
			{
			 before(grammarAccess.getConditionAccess().getGroup()); 
			// InternalDsl.g:351:3: ( rule__Condition__Group__0 )
			// InternalDsl.g:351:4: rule__Condition__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__Condition__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getConditionAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleCondition"



	// $ANTLR start "entryRuleSkipStatement"
	// InternalDsl.g:360:1: entryRuleSkipStatement : ruleSkipStatement EOF ;
	public final void entryRuleSkipStatement() throws RecognitionException {
		try {
			// InternalDsl.g:361:1: ( ruleSkipStatement EOF )
			// InternalDsl.g:362:1: ruleSkipStatement EOF
			{
			 before(grammarAccess.getSkipStatementRule()); 
			pushFollow(FOLLOW_1);
			ruleSkipStatement();
			state._fsp--;

			 after(grammarAccess.getSkipStatementRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleSkipStatement"



	// $ANTLR start "ruleSkipStatement"
	// InternalDsl.g:369:1: ruleSkipStatement : ( ( rule__SkipStatement__NameAssignment ) ) ;
	public final void ruleSkipStatement() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:373:2: ( ( ( rule__SkipStatement__NameAssignment ) ) )
			// InternalDsl.g:374:2: ( ( rule__SkipStatement__NameAssignment ) )
			{
			// InternalDsl.g:374:2: ( ( rule__SkipStatement__NameAssignment ) )
			// InternalDsl.g:375:3: ( rule__SkipStatement__NameAssignment )
			{
			 before(grammarAccess.getSkipStatementAccess().getNameAssignment()); 
			// InternalDsl.g:376:3: ( rule__SkipStatement__NameAssignment )
			// InternalDsl.g:376:4: rule__SkipStatement__NameAssignment
			{
			pushFollow(FOLLOW_2);
			rule__SkipStatement__NameAssignment();
			state._fsp--;

			}

			 after(grammarAccess.getSkipStatementAccess().getNameAssignment()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleSkipStatement"



	// $ANTLR start "entryRuleCompositionStatement"
	// InternalDsl.g:385:1: entryRuleCompositionStatement : ruleCompositionStatement EOF ;
	public final void entryRuleCompositionStatement() throws RecognitionException {
		try {
			// InternalDsl.g:386:1: ( ruleCompositionStatement EOF )
			// InternalDsl.g:387:1: ruleCompositionStatement EOF
			{
			 before(grammarAccess.getCompositionStatementRule()); 
			pushFollow(FOLLOW_1);
			ruleCompositionStatement();
			state._fsp--;

			 after(grammarAccess.getCompositionStatementRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleCompositionStatement"



	// $ANTLR start "ruleCompositionStatement"
	// InternalDsl.g:394:1: ruleCompositionStatement : ( ( rule__CompositionStatement__Group__0 ) ) ;
	public final void ruleCompositionStatement() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:398:2: ( ( ( rule__CompositionStatement__Group__0 ) ) )
			// InternalDsl.g:399:2: ( ( rule__CompositionStatement__Group__0 ) )
			{
			// InternalDsl.g:399:2: ( ( rule__CompositionStatement__Group__0 ) )
			// InternalDsl.g:400:3: ( rule__CompositionStatement__Group__0 )
			{
			 before(grammarAccess.getCompositionStatementAccess().getGroup()); 
			// InternalDsl.g:401:3: ( rule__CompositionStatement__Group__0 )
			// InternalDsl.g:401:4: rule__CompositionStatement__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getCompositionStatementAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleCompositionStatement"



	// $ANTLR start "entryRuleJavaStatement"
	// InternalDsl.g:410:1: entryRuleJavaStatement : ruleJavaStatement EOF ;
	public final void entryRuleJavaStatement() throws RecognitionException {
		try {
			// InternalDsl.g:411:1: ( ruleJavaStatement EOF )
			// InternalDsl.g:412:1: ruleJavaStatement EOF
			{
			 before(grammarAccess.getJavaStatementRule()); 
			pushFollow(FOLLOW_1);
			ruleJavaStatement();
			state._fsp--;

			 after(grammarAccess.getJavaStatementRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleJavaStatement"



	// $ANTLR start "ruleJavaStatement"
	// InternalDsl.g:419:1: ruleJavaStatement : ( ( rule__JavaStatement__NameAssignment ) ) ;
	public final void ruleJavaStatement() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:423:2: ( ( ( rule__JavaStatement__NameAssignment ) ) )
			// InternalDsl.g:424:2: ( ( rule__JavaStatement__NameAssignment ) )
			{
			// InternalDsl.g:424:2: ( ( rule__JavaStatement__NameAssignment ) )
			// InternalDsl.g:425:3: ( rule__JavaStatement__NameAssignment )
			{
			 before(grammarAccess.getJavaStatementAccess().getNameAssignment()); 
			// InternalDsl.g:426:3: ( rule__JavaStatement__NameAssignment )
			// InternalDsl.g:426:4: rule__JavaStatement__NameAssignment
			{
			pushFollow(FOLLOW_2);
			rule__JavaStatement__NameAssignment();
			state._fsp--;

			}

			 after(grammarAccess.getJavaStatementAccess().getNameAssignment()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleJavaStatement"



	// $ANTLR start "entryRuleJMLAnnotation"
	// InternalDsl.g:435:1: entryRuleJMLAnnotation : ruleJMLAnnotation EOF ;
	public final void entryRuleJMLAnnotation() throws RecognitionException {
		try {
			// InternalDsl.g:436:1: ( ruleJMLAnnotation EOF )
			// InternalDsl.g:437:1: ruleJMLAnnotation EOF
			{
			 before(grammarAccess.getJMLAnnotationRule()); 
			pushFollow(FOLLOW_1);
			ruleJMLAnnotation();
			state._fsp--;

			 after(grammarAccess.getJMLAnnotationRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleJMLAnnotation"



	// $ANTLR start "ruleJMLAnnotation"
	// InternalDsl.g:444:1: ruleJMLAnnotation : ( ( rule__JMLAnnotation__Group__0 ) ) ;
	public final void ruleJMLAnnotation() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:448:2: ( ( ( rule__JMLAnnotation__Group__0 ) ) )
			// InternalDsl.g:449:2: ( ( rule__JMLAnnotation__Group__0 ) )
			{
			// InternalDsl.g:449:2: ( ( rule__JMLAnnotation__Group__0 ) )
			// InternalDsl.g:450:3: ( rule__JMLAnnotation__Group__0 )
			{
			 before(grammarAccess.getJMLAnnotationAccess().getGroup()); 
			// InternalDsl.g:451:3: ( rule__JMLAnnotation__Group__0 )
			// InternalDsl.g:451:4: rule__JMLAnnotation__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getJMLAnnotationAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleJMLAnnotation"



	// $ANTLR start "entryRuleBlockStatement"
	// InternalDsl.g:460:1: entryRuleBlockStatement : ruleBlockStatement EOF ;
	public final void entryRuleBlockStatement() throws RecognitionException {
		try {
			// InternalDsl.g:461:1: ( ruleBlockStatement EOF )
			// InternalDsl.g:462:1: ruleBlockStatement EOF
			{
			 before(grammarAccess.getBlockStatementRule()); 
			pushFollow(FOLLOW_1);
			ruleBlockStatement();
			state._fsp--;

			 after(grammarAccess.getBlockStatementRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleBlockStatement"



	// $ANTLR start "ruleBlockStatement"
	// InternalDsl.g:469:1: ruleBlockStatement : ( ( rule__BlockStatement__Group__0 ) ) ;
	public final void ruleBlockStatement() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:473:2: ( ( ( rule__BlockStatement__Group__0 ) ) )
			// InternalDsl.g:474:2: ( ( rule__BlockStatement__Group__0 ) )
			{
			// InternalDsl.g:474:2: ( ( rule__BlockStatement__Group__0 ) )
			// InternalDsl.g:475:3: ( rule__BlockStatement__Group__0 )
			{
			 before(grammarAccess.getBlockStatementAccess().getGroup()); 
			// InternalDsl.g:476:3: ( rule__BlockStatement__Group__0 )
			// InternalDsl.g:476:4: rule__BlockStatement__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__BlockStatement__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getBlockStatementAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleBlockStatement"



	// $ANTLR start "entryRuleSelectionStatement"
	// InternalDsl.g:485:1: entryRuleSelectionStatement : ruleSelectionStatement EOF ;
	public final void entryRuleSelectionStatement() throws RecognitionException {
		try {
			// InternalDsl.g:486:1: ( ruleSelectionStatement EOF )
			// InternalDsl.g:487:1: ruleSelectionStatement EOF
			{
			 before(grammarAccess.getSelectionStatementRule()); 
			pushFollow(FOLLOW_1);
			ruleSelectionStatement();
			state._fsp--;

			 after(grammarAccess.getSelectionStatementRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleSelectionStatement"



	// $ANTLR start "ruleSelectionStatement"
	// InternalDsl.g:494:1: ruleSelectionStatement : ( ( rule__SelectionStatement__Group__0 ) ) ;
	public final void ruleSelectionStatement() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:498:2: ( ( ( rule__SelectionStatement__Group__0 ) ) )
			// InternalDsl.g:499:2: ( ( rule__SelectionStatement__Group__0 ) )
			{
			// InternalDsl.g:499:2: ( ( rule__SelectionStatement__Group__0 ) )
			// InternalDsl.g:500:3: ( rule__SelectionStatement__Group__0 )
			{
			 before(grammarAccess.getSelectionStatementAccess().getGroup()); 
			// InternalDsl.g:501:3: ( rule__SelectionStatement__Group__0 )
			// InternalDsl.g:501:4: rule__SelectionStatement__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getSelectionStatementAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleSelectionStatement"



	// $ANTLR start "entryRuleSmallRepetitionStatement"
	// InternalDsl.g:510:1: entryRuleSmallRepetitionStatement : ruleSmallRepetitionStatement EOF ;
	public final void entryRuleSmallRepetitionStatement() throws RecognitionException {
		try {
			// InternalDsl.g:511:1: ( ruleSmallRepetitionStatement EOF )
			// InternalDsl.g:512:1: ruleSmallRepetitionStatement EOF
			{
			 before(grammarAccess.getSmallRepetitionStatementRule()); 
			pushFollow(FOLLOW_1);
			ruleSmallRepetitionStatement();
			state._fsp--;

			 after(grammarAccess.getSmallRepetitionStatementRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleSmallRepetitionStatement"



	// $ANTLR start "ruleSmallRepetitionStatement"
	// InternalDsl.g:519:1: ruleSmallRepetitionStatement : ( ( rule__SmallRepetitionStatement__Group__0 ) ) ;
	public final void ruleSmallRepetitionStatement() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:523:2: ( ( ( rule__SmallRepetitionStatement__Group__0 ) ) )
			// InternalDsl.g:524:2: ( ( rule__SmallRepetitionStatement__Group__0 ) )
			{
			// InternalDsl.g:524:2: ( ( rule__SmallRepetitionStatement__Group__0 ) )
			// InternalDsl.g:525:3: ( rule__SmallRepetitionStatement__Group__0 )
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getGroup()); 
			// InternalDsl.g:526:3: ( rule__SmallRepetitionStatement__Group__0 )
			// InternalDsl.g:526:4: rule__SmallRepetitionStatement__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getSmallRepetitionStatementAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleSmallRepetitionStatement"



	// $ANTLR start "entryRuleVariant"
	// InternalDsl.g:535:1: entryRuleVariant : ruleVariant EOF ;
	public final void entryRuleVariant() throws RecognitionException {
		try {
			// InternalDsl.g:536:1: ( ruleVariant EOF )
			// InternalDsl.g:537:1: ruleVariant EOF
			{
			 before(grammarAccess.getVariantRule()); 
			pushFollow(FOLLOW_1);
			ruleVariant();
			state._fsp--;

			 after(grammarAccess.getVariantRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleVariant"



	// $ANTLR start "ruleVariant"
	// InternalDsl.g:544:1: ruleVariant : ( ( rule__Variant__Group__0 ) ) ;
	public final void ruleVariant() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:548:2: ( ( ( rule__Variant__Group__0 ) ) )
			// InternalDsl.g:549:2: ( ( rule__Variant__Group__0 ) )
			{
			// InternalDsl.g:549:2: ( ( rule__Variant__Group__0 ) )
			// InternalDsl.g:550:3: ( rule__Variant__Group__0 )
			{
			 before(grammarAccess.getVariantAccess().getGroup()); 
			// InternalDsl.g:551:3: ( rule__Variant__Group__0 )
			// InternalDsl.g:551:4: rule__Variant__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__Variant__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getVariantAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleVariant"



	// $ANTLR start "entryRuleJavaVariables"
	// InternalDsl.g:560:1: entryRuleJavaVariables : ruleJavaVariables EOF ;
	public final void entryRuleJavaVariables() throws RecognitionException {
		try {
			// InternalDsl.g:561:1: ( ruleJavaVariables EOF )
			// InternalDsl.g:562:1: ruleJavaVariables EOF
			{
			 before(grammarAccess.getJavaVariablesRule()); 
			pushFollow(FOLLOW_1);
			ruleJavaVariables();
			state._fsp--;

			 after(grammarAccess.getJavaVariablesRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleJavaVariables"



	// $ANTLR start "ruleJavaVariables"
	// InternalDsl.g:569:1: ruleJavaVariables : ( ( rule__JavaVariables__Group__0 ) ) ;
	public final void ruleJavaVariables() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:573:2: ( ( ( rule__JavaVariables__Group__0 ) ) )
			// InternalDsl.g:574:2: ( ( rule__JavaVariables__Group__0 ) )
			{
			// InternalDsl.g:574:2: ( ( rule__JavaVariables__Group__0 ) )
			// InternalDsl.g:575:3: ( rule__JavaVariables__Group__0 )
			{
			 before(grammarAccess.getJavaVariablesAccess().getGroup()); 
			// InternalDsl.g:576:3: ( rule__JavaVariables__Group__0 )
			// InternalDsl.g:576:4: rule__JavaVariables__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__JavaVariables__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getJavaVariablesAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleJavaVariables"



	// $ANTLR start "entryRuleJavaVariable"
	// InternalDsl.g:585:1: entryRuleJavaVariable : ruleJavaVariable EOF ;
	public final void entryRuleJavaVariable() throws RecognitionException {
		try {
			// InternalDsl.g:586:1: ( ruleJavaVariable EOF )
			// InternalDsl.g:587:1: ruleJavaVariable EOF
			{
			 before(grammarAccess.getJavaVariableRule()); 
			pushFollow(FOLLOW_1);
			ruleJavaVariable();
			state._fsp--;

			 after(grammarAccess.getJavaVariableRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleJavaVariable"



	// $ANTLR start "ruleJavaVariable"
	// InternalDsl.g:594:1: ruleJavaVariable : ( ( rule__JavaVariable__Group__0 ) ) ;
	public final void ruleJavaVariable() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:598:2: ( ( ( rule__JavaVariable__Group__0 ) ) )
			// InternalDsl.g:599:2: ( ( rule__JavaVariable__Group__0 ) )
			{
			// InternalDsl.g:599:2: ( ( rule__JavaVariable__Group__0 ) )
			// InternalDsl.g:600:3: ( rule__JavaVariable__Group__0 )
			{
			 before(grammarAccess.getJavaVariableAccess().getGroup()); 
			// InternalDsl.g:601:3: ( rule__JavaVariable__Group__0 )
			// InternalDsl.g:601:4: rule__JavaVariable__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__JavaVariable__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getJavaVariableAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleJavaVariable"



	// $ANTLR start "entryRuleGlobalConditions"
	// InternalDsl.g:610:1: entryRuleGlobalConditions : ruleGlobalConditions EOF ;
	public final void entryRuleGlobalConditions() throws RecognitionException {
		try {
			// InternalDsl.g:611:1: ( ruleGlobalConditions EOF )
			// InternalDsl.g:612:1: ruleGlobalConditions EOF
			{
			 before(grammarAccess.getGlobalConditionsRule()); 
			pushFollow(FOLLOW_1);
			ruleGlobalConditions();
			state._fsp--;

			 after(grammarAccess.getGlobalConditionsRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleGlobalConditions"



	// $ANTLR start "ruleGlobalConditions"
	// InternalDsl.g:619:1: ruleGlobalConditions : ( ( rule__GlobalConditions__Group__0 ) ) ;
	public final void ruleGlobalConditions() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:623:2: ( ( ( rule__GlobalConditions__Group__0 ) ) )
			// InternalDsl.g:624:2: ( ( rule__GlobalConditions__Group__0 ) )
			{
			// InternalDsl.g:624:2: ( ( rule__GlobalConditions__Group__0 ) )
			// InternalDsl.g:625:3: ( rule__GlobalConditions__Group__0 )
			{
			 before(grammarAccess.getGlobalConditionsAccess().getGroup()); 
			// InternalDsl.g:626:3: ( rule__GlobalConditions__Group__0 )
			// InternalDsl.g:626:4: rule__GlobalConditions__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__GlobalConditions__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getGlobalConditionsAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleGlobalConditions"



	// $ANTLR start "entryRuleRenaming"
	// InternalDsl.g:635:1: entryRuleRenaming : ruleRenaming EOF ;
	public final void entryRuleRenaming() throws RecognitionException {
		try {
			// InternalDsl.g:636:1: ( ruleRenaming EOF )
			// InternalDsl.g:637:1: ruleRenaming EOF
			{
			 before(grammarAccess.getRenamingRule()); 
			pushFollow(FOLLOW_1);
			ruleRenaming();
			state._fsp--;

			 after(grammarAccess.getRenamingRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleRenaming"



	// $ANTLR start "ruleRenaming"
	// InternalDsl.g:644:1: ruleRenaming : ( ( rule__Renaming__Group__0 ) ) ;
	public final void ruleRenaming() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:648:2: ( ( ( rule__Renaming__Group__0 ) ) )
			// InternalDsl.g:649:2: ( ( rule__Renaming__Group__0 ) )
			{
			// InternalDsl.g:649:2: ( ( rule__Renaming__Group__0 ) )
			// InternalDsl.g:650:3: ( rule__Renaming__Group__0 )
			{
			 before(grammarAccess.getRenamingAccess().getGroup()); 
			// InternalDsl.g:651:3: ( rule__Renaming__Group__0 )
			// InternalDsl.g:651:4: rule__Renaming__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__Renaming__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getRenamingAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleRenaming"



	// $ANTLR start "entryRuleRename"
	// InternalDsl.g:660:1: entryRuleRename : ruleRename EOF ;
	public final void entryRuleRename() throws RecognitionException {
		try {
			// InternalDsl.g:661:1: ( ruleRename EOF )
			// InternalDsl.g:662:1: ruleRename EOF
			{
			 before(grammarAccess.getRenameRule()); 
			pushFollow(FOLLOW_1);
			ruleRename();
			state._fsp--;

			 after(grammarAccess.getRenameRule()); 
			match(input,EOF,FOLLOW_2); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "entryRuleRename"



	// $ANTLR start "ruleRename"
	// InternalDsl.g:669:1: ruleRename : ( ( rule__Rename__Group__0 ) ) ;
	public final void ruleRename() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:673:2: ( ( ( rule__Rename__Group__0 ) ) )
			// InternalDsl.g:674:2: ( ( rule__Rename__Group__0 ) )
			{
			// InternalDsl.g:674:2: ( ( rule__Rename__Group__0 ) )
			// InternalDsl.g:675:3: ( rule__Rename__Group__0 )
			{
			 before(grammarAccess.getRenameAccess().getGroup()); 
			// InternalDsl.g:676:3: ( rule__Rename__Group__0 )
			// InternalDsl.g:676:4: rule__Rename__Group__0
			{
			pushFollow(FOLLOW_2);
			rule__Rename__Group__0();
			state._fsp--;

			}

			 after(grammarAccess.getRenameAccess().getGroup()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "ruleRename"



	// $ANTLR start "rule__AbstractStatement__Alternatives"
	// InternalDsl.g:684:1: rule__AbstractStatement__Alternatives : ( ( ruleAbstractStatement_Impl ) | ( ruleBlockStatement ) | ( ruleCompositionStatement ) | ( ruleSkipStatement ) | ( ruleSelectionStatement ) | ( ruleSmallRepetitionStatement ) | ( ruleMethodStatement ) | ( ruleReturnStatement ) | ( ruleStrengthWeakStatement ) );
	public final void rule__AbstractStatement__Alternatives() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:688:2: ( ( ruleAbstractStatement_Impl ) | ( ruleBlockStatement ) | ( ruleCompositionStatement ) | ( ruleSkipStatement ) | ( ruleSelectionStatement ) | ( ruleSmallRepetitionStatement ) | ( ruleMethodStatement ) | ( ruleReturnStatement ) | ( ruleStrengthWeakStatement ) )
			int alt2=9;
			switch ( input.LA(1) ) {
			case RULE_ID:
				{
				int LA2_1 = input.LA(2);
				if ( (LA2_1==25||LA2_1==34) ) {
					alt2=1;
				}
				else if ( (LA2_1==EOF||LA2_1==56) ) {
					alt2=7;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 29:
				{
				alt2=2;
				}
				break;
			case 55:
				{
				alt2=3;
				}
				break;
			case 24:
				{
				alt2=4;
				}
				break;
			case 41:
				{
				alt2=5;
				}
				break;
			case 54:
				{
				alt2=6;
				}
				break;
			case RULE_STRING:
				{
				alt2=7;
				}
				break;
			case 49:
				{
				alt2=8;
				}
				break;
			case 47:
				{
				alt2=9;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// InternalDsl.g:689:2: ( ruleAbstractStatement_Impl )
					{
					// InternalDsl.g:689:2: ( ruleAbstractStatement_Impl )
					// InternalDsl.g:690:3: ruleAbstractStatement_Impl
					{
					 before(grammarAccess.getAbstractStatementAccess().getAbstractStatement_ImplParserRuleCall_0()); 
					pushFollow(FOLLOW_2);
					ruleAbstractStatement_Impl();
					state._fsp--;

					 after(grammarAccess.getAbstractStatementAccess().getAbstractStatement_ImplParserRuleCall_0()); 
					}

					}
					break;
				case 2 :
					// InternalDsl.g:695:2: ( ruleBlockStatement )
					{
					// InternalDsl.g:695:2: ( ruleBlockStatement )
					// InternalDsl.g:696:3: ruleBlockStatement
					{
					 before(grammarAccess.getAbstractStatementAccess().getBlockStatementParserRuleCall_1()); 
					pushFollow(FOLLOW_2);
					ruleBlockStatement();
					state._fsp--;

					 after(grammarAccess.getAbstractStatementAccess().getBlockStatementParserRuleCall_1()); 
					}

					}
					break;
				case 3 :
					// InternalDsl.g:701:2: ( ruleCompositionStatement )
					{
					// InternalDsl.g:701:2: ( ruleCompositionStatement )
					// InternalDsl.g:702:3: ruleCompositionStatement
					{
					 before(grammarAccess.getAbstractStatementAccess().getCompositionStatementParserRuleCall_2()); 
					pushFollow(FOLLOW_2);
					ruleCompositionStatement();
					state._fsp--;

					 after(grammarAccess.getAbstractStatementAccess().getCompositionStatementParserRuleCall_2()); 
					}

					}
					break;
				case 4 :
					// InternalDsl.g:707:2: ( ruleSkipStatement )
					{
					// InternalDsl.g:707:2: ( ruleSkipStatement )
					// InternalDsl.g:708:3: ruleSkipStatement
					{
					 before(grammarAccess.getAbstractStatementAccess().getSkipStatementParserRuleCall_3()); 
					pushFollow(FOLLOW_2);
					ruleSkipStatement();
					state._fsp--;

					 after(grammarAccess.getAbstractStatementAccess().getSkipStatementParserRuleCall_3()); 
					}

					}
					break;
				case 5 :
					// InternalDsl.g:713:2: ( ruleSelectionStatement )
					{
					// InternalDsl.g:713:2: ( ruleSelectionStatement )
					// InternalDsl.g:714:3: ruleSelectionStatement
					{
					 before(grammarAccess.getAbstractStatementAccess().getSelectionStatementParserRuleCall_4()); 
					pushFollow(FOLLOW_2);
					ruleSelectionStatement();
					state._fsp--;

					 after(grammarAccess.getAbstractStatementAccess().getSelectionStatementParserRuleCall_4()); 
					}

					}
					break;
				case 6 :
					// InternalDsl.g:719:2: ( ruleSmallRepetitionStatement )
					{
					// InternalDsl.g:719:2: ( ruleSmallRepetitionStatement )
					// InternalDsl.g:720:3: ruleSmallRepetitionStatement
					{
					 before(grammarAccess.getAbstractStatementAccess().getSmallRepetitionStatementParserRuleCall_5()); 
					pushFollow(FOLLOW_2);
					ruleSmallRepetitionStatement();
					state._fsp--;

					 after(grammarAccess.getAbstractStatementAccess().getSmallRepetitionStatementParserRuleCall_5()); 
					}

					}
					break;
				case 7 :
					// InternalDsl.g:725:2: ( ruleMethodStatement )
					{
					// InternalDsl.g:725:2: ( ruleMethodStatement )
					// InternalDsl.g:726:3: ruleMethodStatement
					{
					 before(grammarAccess.getAbstractStatementAccess().getMethodStatementParserRuleCall_6()); 
					pushFollow(FOLLOW_2);
					ruleMethodStatement();
					state._fsp--;

					 after(grammarAccess.getAbstractStatementAccess().getMethodStatementParserRuleCall_6()); 
					}

					}
					break;
				case 8 :
					// InternalDsl.g:731:2: ( ruleReturnStatement )
					{
					// InternalDsl.g:731:2: ( ruleReturnStatement )
					// InternalDsl.g:732:3: ruleReturnStatement
					{
					 before(grammarAccess.getAbstractStatementAccess().getReturnStatementParserRuleCall_7()); 
					pushFollow(FOLLOW_2);
					ruleReturnStatement();
					state._fsp--;

					 after(grammarAccess.getAbstractStatementAccess().getReturnStatementParserRuleCall_7()); 
					}

					}
					break;
				case 9 :
					// InternalDsl.g:737:2: ( ruleStrengthWeakStatement )
					{
					// InternalDsl.g:737:2: ( ruleStrengthWeakStatement )
					// InternalDsl.g:738:3: ruleStrengthWeakStatement
					{
					 before(grammarAccess.getAbstractStatementAccess().getStrengthWeakStatementParserRuleCall_8()); 
					pushFollow(FOLLOW_2);
					ruleStrengthWeakStatement();
					state._fsp--;

					 after(grammarAccess.getAbstractStatementAccess().getStrengthWeakStatementParserRuleCall_8()); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__AbstractStatement__Alternatives"



	// $ANTLR start "rule__EString__Alternatives"
	// InternalDsl.g:747:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
	public final void rule__EString__Alternatives() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:751:2: ( ( RULE_STRING ) | ( RULE_ID ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==RULE_STRING) ) {
				alt3=1;
			}
			else if ( (LA3_0==RULE_ID) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// InternalDsl.g:752:2: ( RULE_STRING )
					{
					// InternalDsl.g:752:2: ( RULE_STRING )
					// InternalDsl.g:753:3: RULE_STRING
					{
					 before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
					match(input,RULE_STRING,FOLLOW_2); 
					 after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
					}

					}
					break;
				case 2 :
					// InternalDsl.g:758:2: ( RULE_ID )
					{
					// InternalDsl.g:758:2: ( RULE_ID )
					// InternalDsl.g:759:3: RULE_ID
					{
					 before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
					match(input,RULE_ID,FOLLOW_2); 
					 after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__EString__Alternatives"



	// $ANTLR start "rule__CodeString__Alternatives_1_1"
	// InternalDsl.g:768:1: rule__CodeString__Alternatives_1_1 : ( ( RULE_ID ) | ( RULE_INT ) );
	public final void rule__CodeString__Alternatives_1_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:772:2: ( ( RULE_ID ) | ( RULE_INT ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==RULE_ID) ) {
				alt4=1;
			}
			else if ( (LA4_0==RULE_INT) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// InternalDsl.g:773:2: ( RULE_ID )
					{
					// InternalDsl.g:773:2: ( RULE_ID )
					// InternalDsl.g:774:3: RULE_ID
					{
					 before(grammarAccess.getCodeStringAccess().getIDTerminalRuleCall_1_1_0()); 
					match(input,RULE_ID,FOLLOW_2); 
					 after(grammarAccess.getCodeStringAccess().getIDTerminalRuleCall_1_1_0()); 
					}

					}
					break;
				case 2 :
					// InternalDsl.g:779:2: ( RULE_INT )
					{
					// InternalDsl.g:779:2: ( RULE_INT )
					// InternalDsl.g:780:3: RULE_INT
					{
					 before(grammarAccess.getCodeStringAccess().getINTTerminalRuleCall_1_1_1()); 
					match(input,RULE_INT,FOLLOW_2); 
					 after(grammarAccess.getCodeStringAccess().getINTTerminalRuleCall_1_1_1()); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Alternatives_1_1"



	// $ANTLR start "rule__CodeString__Alternatives_4"
	// InternalDsl.g:789:1: rule__CodeString__Alternatives_4 : ( ( ruleVariableString ) | ( ( rule__CodeString__Group_4_1__0 ) ) );
	public final void rule__CodeString__Alternatives_4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:793:2: ( ( ruleVariableString ) | ( ( rule__CodeString__Group_4_1__0 ) ) )
			int alt5=2;
			switch ( input.LA(1) ) {
			case 20:
				{
				int LA5_1 = input.LA(2);
				if ( (LA5_1==RULE_ID) ) {
					alt5=1;
				}
				else if ( (LA5_1==RULE_INT) ) {
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
				break;
			case RULE_ID:
				{
				alt5=1;
				}
				break;
			case RULE_INT:
				{
				alt5=2;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// InternalDsl.g:794:2: ( ruleVariableString )
					{
					// InternalDsl.g:794:2: ( ruleVariableString )
					// InternalDsl.g:795:3: ruleVariableString
					{
					 before(grammarAccess.getCodeStringAccess().getVariableStringParserRuleCall_4_0()); 
					pushFollow(FOLLOW_2);
					ruleVariableString();
					state._fsp--;

					 after(grammarAccess.getCodeStringAccess().getVariableStringParserRuleCall_4_0()); 
					}

					}
					break;
				case 2 :
					// InternalDsl.g:800:2: ( ( rule__CodeString__Group_4_1__0 ) )
					{
					// InternalDsl.g:800:2: ( ( rule__CodeString__Group_4_1__0 ) )
					// InternalDsl.g:801:3: ( rule__CodeString__Group_4_1__0 )
					{
					 before(grammarAccess.getCodeStringAccess().getGroup_4_1()); 
					// InternalDsl.g:802:3: ( rule__CodeString__Group_4_1__0 )
					// InternalDsl.g:802:4: rule__CodeString__Group_4_1__0
					{
					pushFollow(FOLLOW_2);
					rule__CodeString__Group_4_1__0();
					state._fsp--;

					}

					 after(grammarAccess.getCodeStringAccess().getGroup_4_1()); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Alternatives_4"



	// $ANTLR start "rule__CodeString__Alternatives_5_2"
	// InternalDsl.g:810:1: rule__CodeString__Alternatives_5_2 : ( ( ruleVariableString ) | ( ( rule__CodeString__Group_5_2_1__0 ) ) );
	public final void rule__CodeString__Alternatives_5_2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:814:2: ( ( ruleVariableString ) | ( ( rule__CodeString__Group_5_2_1__0 ) ) )
			int alt6=2;
			switch ( input.LA(1) ) {
			case 20:
				{
				int LA6_1 = input.LA(2);
				if ( (LA6_1==RULE_ID) ) {
					alt6=1;
				}
				else if ( (LA6_1==RULE_INT) ) {
					alt6=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RULE_ID:
				{
				alt6=1;
				}
				break;
			case RULE_INT:
				{
				alt6=2;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// InternalDsl.g:815:2: ( ruleVariableString )
					{
					// InternalDsl.g:815:2: ( ruleVariableString )
					// InternalDsl.g:816:3: ruleVariableString
					{
					 before(grammarAccess.getCodeStringAccess().getVariableStringParserRuleCall_5_2_0()); 
					pushFollow(FOLLOW_2);
					ruleVariableString();
					state._fsp--;

					 after(grammarAccess.getCodeStringAccess().getVariableStringParserRuleCall_5_2_0()); 
					}

					}
					break;
				case 2 :
					// InternalDsl.g:821:2: ( ( rule__CodeString__Group_5_2_1__0 ) )
					{
					// InternalDsl.g:821:2: ( ( rule__CodeString__Group_5_2_1__0 ) )
					// InternalDsl.g:822:3: ( rule__CodeString__Group_5_2_1__0 )
					{
					 before(grammarAccess.getCodeStringAccess().getGroup_5_2_1()); 
					// InternalDsl.g:823:3: ( rule__CodeString__Group_5_2_1__0 )
					// InternalDsl.g:823:4: rule__CodeString__Group_5_2_1__0
					{
					pushFollow(FOLLOW_2);
					rule__CodeString__Group_5_2_1__0();
					state._fsp--;

					}

					 after(grammarAccess.getCodeStringAccess().getGroup_5_2_1()); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Alternatives_5_2"



	// $ANTLR start "rule__VariableString__Alternatives_2"
	// InternalDsl.g:831:1: rule__VariableString__Alternatives_2 : ( ( ( rule__VariableString__Group_2_0__0 ) ) | ( ( rule__VariableString__Group_2_1__0 ) ) | ( ( rule__VariableString__Group_2_2__0 ) ) );
	public final void rule__VariableString__Alternatives_2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:835:2: ( ( ( rule__VariableString__Group_2_0__0 ) ) | ( ( rule__VariableString__Group_2_1__0 ) ) | ( ( rule__VariableString__Group_2_2__0 ) ) )
			int alt7=3;
			switch ( input.LA(1) ) {
			case 15:
				{
				alt7=1;
				}
				break;
			case 34:
				{
				alt7=2;
				}
				break;
			case 21:
				{
				alt7=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// InternalDsl.g:836:2: ( ( rule__VariableString__Group_2_0__0 ) )
					{
					// InternalDsl.g:836:2: ( ( rule__VariableString__Group_2_0__0 ) )
					// InternalDsl.g:837:3: ( rule__VariableString__Group_2_0__0 )
					{
					 before(grammarAccess.getVariableStringAccess().getGroup_2_0()); 
					// InternalDsl.g:838:3: ( rule__VariableString__Group_2_0__0 )
					// InternalDsl.g:838:4: rule__VariableString__Group_2_0__0
					{
					pushFollow(FOLLOW_2);
					rule__VariableString__Group_2_0__0();
					state._fsp--;

					}

					 after(grammarAccess.getVariableStringAccess().getGroup_2_0()); 
					}

					}
					break;
				case 2 :
					// InternalDsl.g:842:2: ( ( rule__VariableString__Group_2_1__0 ) )
					{
					// InternalDsl.g:842:2: ( ( rule__VariableString__Group_2_1__0 ) )
					// InternalDsl.g:843:3: ( rule__VariableString__Group_2_1__0 )
					{
					 before(grammarAccess.getVariableStringAccess().getGroup_2_1()); 
					// InternalDsl.g:844:3: ( rule__VariableString__Group_2_1__0 )
					// InternalDsl.g:844:4: rule__VariableString__Group_2_1__0
					{
					pushFollow(FOLLOW_2);
					rule__VariableString__Group_2_1__0();
					state._fsp--;

					}

					 after(grammarAccess.getVariableStringAccess().getGroup_2_1()); 
					}

					}
					break;
				case 3 :
					// InternalDsl.g:848:2: ( ( rule__VariableString__Group_2_2__0 ) )
					{
					// InternalDsl.g:848:2: ( ( rule__VariableString__Group_2_2__0 ) )
					// InternalDsl.g:849:3: ( rule__VariableString__Group_2_2__0 )
					{
					 before(grammarAccess.getVariableStringAccess().getGroup_2_2()); 
					// InternalDsl.g:850:3: ( rule__VariableString__Group_2_2__0 )
					// InternalDsl.g:850:4: rule__VariableString__Group_2_2__0
					{
					pushFollow(FOLLOW_2);
					rule__VariableString__Group_2_2__0();
					state._fsp--;

					}

					 after(grammarAccess.getVariableStringAccess().getGroup_2_2()); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Alternatives_2"



	// $ANTLR start "rule__VariableString__Alternatives_2_0_0_1_0"
	// InternalDsl.g:858:1: rule__VariableString__Alternatives_2_0_0_1_0 : ( ( ruleVariableString ) | ( ( rule__VariableString__Group_2_0_0_1_0_1__0 ) ) );
	public final void rule__VariableString__Alternatives_2_0_0_1_0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:862:2: ( ( ruleVariableString ) | ( ( rule__VariableString__Group_2_0_0_1_0_1__0 ) ) )
			int alt8=2;
			switch ( input.LA(1) ) {
			case 20:
				{
				int LA8_1 = input.LA(2);
				if ( (LA8_1==RULE_ID) ) {
					alt8=1;
				}
				else if ( (LA8_1==RULE_INT) ) {
					alt8=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RULE_ID:
				{
				alt8=1;
				}
				break;
			case RULE_INT:
				{
				alt8=2;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// InternalDsl.g:863:2: ( ruleVariableString )
					{
					// InternalDsl.g:863:2: ( ruleVariableString )
					// InternalDsl.g:864:3: ruleVariableString
					{
					 before(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_0_0_1_0_0()); 
					pushFollow(FOLLOW_2);
					ruleVariableString();
					state._fsp--;

					 after(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_0_0_1_0_0()); 
					}

					}
					break;
				case 2 :
					// InternalDsl.g:869:2: ( ( rule__VariableString__Group_2_0_0_1_0_1__0 ) )
					{
					// InternalDsl.g:869:2: ( ( rule__VariableString__Group_2_0_0_1_0_1__0 ) )
					// InternalDsl.g:870:3: ( rule__VariableString__Group_2_0_0_1_0_1__0 )
					{
					 before(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1_0_1()); 
					// InternalDsl.g:871:3: ( rule__VariableString__Group_2_0_0_1_0_1__0 )
					// InternalDsl.g:871:4: rule__VariableString__Group_2_0_0_1_0_1__0
					{
					pushFollow(FOLLOW_2);
					rule__VariableString__Group_2_0_0_1_0_1__0();
					state._fsp--;

					}

					 after(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1_0_1()); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Alternatives_2_0_0_1_0"



	// $ANTLR start "rule__VariableString__Alternatives_2_0_0_1_1_1"
	// InternalDsl.g:879:1: rule__VariableString__Alternatives_2_0_0_1_1_1 : ( ( ruleVariableString ) | ( ( rule__VariableString__Group_2_0_0_1_1_1_1__0 ) ) );
	public final void rule__VariableString__Alternatives_2_0_0_1_1_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:883:2: ( ( ruleVariableString ) | ( ( rule__VariableString__Group_2_0_0_1_1_1_1__0 ) ) )
			int alt9=2;
			switch ( input.LA(1) ) {
			case 20:
				{
				int LA9_1 = input.LA(2);
				if ( (LA9_1==RULE_ID) ) {
					alt9=1;
				}
				else if ( (LA9_1==RULE_INT) ) {
					alt9=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RULE_ID:
				{
				alt9=1;
				}
				break;
			case RULE_INT:
				{
				alt9=2;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// InternalDsl.g:884:2: ( ruleVariableString )
					{
					// InternalDsl.g:884:2: ( ruleVariableString )
					// InternalDsl.g:885:3: ruleVariableString
					{
					 before(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_0_0_1_1_1_0()); 
					pushFollow(FOLLOW_2);
					ruleVariableString();
					state._fsp--;

					 after(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_0_0_1_1_1_0()); 
					}

					}
					break;
				case 2 :
					// InternalDsl.g:890:2: ( ( rule__VariableString__Group_2_0_0_1_1_1_1__0 ) )
					{
					// InternalDsl.g:890:2: ( ( rule__VariableString__Group_2_0_0_1_1_1_1__0 ) )
					// InternalDsl.g:891:3: ( rule__VariableString__Group_2_0_0_1_1_1_1__0 )
					{
					 before(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1_1_1_1()); 
					// InternalDsl.g:892:3: ( rule__VariableString__Group_2_0_0_1_1_1_1__0 )
					// InternalDsl.g:892:4: rule__VariableString__Group_2_0_0_1_1_1_1__0
					{
					pushFollow(FOLLOW_2);
					rule__VariableString__Group_2_0_0_1_1_1_1__0();
					state._fsp--;

					}

					 after(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1_1_1_1()); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Alternatives_2_0_0_1_1_1"



	// $ANTLR start "rule__VariableString__Alternatives_2_1_0_1"
	// InternalDsl.g:900:1: rule__VariableString__Alternatives_2_1_0_1 : ( ( ruleVariableString ) | ( ( rule__VariableString__Group_2_1_0_1_1__0 ) ) );
	public final void rule__VariableString__Alternatives_2_1_0_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:904:2: ( ( ruleVariableString ) | ( ( rule__VariableString__Group_2_1_0_1_1__0 ) ) )
			int alt10=2;
			switch ( input.LA(1) ) {
			case 20:
				{
				int LA10_1 = input.LA(2);
				if ( (LA10_1==RULE_ID) ) {
					alt10=1;
				}
				else if ( (LA10_1==RULE_INT) ) {
					alt10=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RULE_ID:
				{
				alt10=1;
				}
				break;
			case RULE_INT:
				{
				alt10=2;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// InternalDsl.g:905:2: ( ruleVariableString )
					{
					// InternalDsl.g:905:2: ( ruleVariableString )
					// InternalDsl.g:906:3: ruleVariableString
					{
					 before(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_1_0_1_0()); 
					pushFollow(FOLLOW_2);
					ruleVariableString();
					state._fsp--;

					 after(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_1_0_1_0()); 
					}

					}
					break;
				case 2 :
					// InternalDsl.g:911:2: ( ( rule__VariableString__Group_2_1_0_1_1__0 ) )
					{
					// InternalDsl.g:911:2: ( ( rule__VariableString__Group_2_1_0_1_1__0 ) )
					// InternalDsl.g:912:3: ( rule__VariableString__Group_2_1_0_1_1__0 )
					{
					 before(grammarAccess.getVariableStringAccess().getGroup_2_1_0_1_1()); 
					// InternalDsl.g:913:3: ( rule__VariableString__Group_2_1_0_1_1__0 )
					// InternalDsl.g:913:4: rule__VariableString__Group_2_1_0_1_1__0
					{
					pushFollow(FOLLOW_2);
					rule__VariableString__Group_2_1_0_1_1__0();
					state._fsp--;

					}

					 after(grammarAccess.getVariableStringAccess().getGroup_2_1_0_1_1()); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Alternatives_2_1_0_1"



	// $ANTLR start "rule__Operation__Alternatives"
	// InternalDsl.g:921:1: rule__Operation__Alternatives : ( ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) );
	public final void rule__Operation__Alternatives() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:925:2: ( ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) )
			int alt11=5;
			switch ( input.LA(1) ) {
			case 18:
				{
				alt11=1;
				}
				break;
			case 20:
				{
				alt11=2;
				}
				break;
			case 17:
				{
				alt11=3;
				}
				break;
			case 22:
				{
				alt11=4;
				}
				break;
			case 14:
				{
				alt11=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// InternalDsl.g:926:2: ( '+' )
					{
					// InternalDsl.g:926:2: ( '+' )
					// InternalDsl.g:927:3: '+'
					{
					 before(grammarAccess.getOperationAccess().getPlusSignKeyword_0()); 
					match(input,18,FOLLOW_2); 
					 after(grammarAccess.getOperationAccess().getPlusSignKeyword_0()); 
					}

					}
					break;
				case 2 :
					// InternalDsl.g:932:2: ( '-' )
					{
					// InternalDsl.g:932:2: ( '-' )
					// InternalDsl.g:933:3: '-'
					{
					 before(grammarAccess.getOperationAccess().getHyphenMinusKeyword_1()); 
					match(input,20,FOLLOW_2); 
					 after(grammarAccess.getOperationAccess().getHyphenMinusKeyword_1()); 
					}

					}
					break;
				case 3 :
					// InternalDsl.g:938:2: ( '*' )
					{
					// InternalDsl.g:938:2: ( '*' )
					// InternalDsl.g:939:3: '*'
					{
					 before(grammarAccess.getOperationAccess().getAsteriskKeyword_2()); 
					match(input,17,FOLLOW_2); 
					 after(grammarAccess.getOperationAccess().getAsteriskKeyword_2()); 
					}

					}
					break;
				case 4 :
					// InternalDsl.g:944:2: ( '/' )
					{
					// InternalDsl.g:944:2: ( '/' )
					// InternalDsl.g:945:3: '/'
					{
					 before(grammarAccess.getOperationAccess().getSolidusKeyword_3()); 
					match(input,22,FOLLOW_2); 
					 after(grammarAccess.getOperationAccess().getSolidusKeyword_3()); 
					}

					}
					break;
				case 5 :
					// InternalDsl.g:950:2: ( '%' )
					{
					// InternalDsl.g:950:2: ( '%' )
					// InternalDsl.g:951:3: '%'
					{
					 before(grammarAccess.getOperationAccess().getPercentSignKeyword_4()); 
					match(input,14,FOLLOW_2); 
					 after(grammarAccess.getOperationAccess().getPercentSignKeyword_4()); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Operation__Alternatives"



	// $ANTLR start "rule__CbCFormula__Group__0"
	// InternalDsl.g:960:1: rule__CbCFormula__Group__0 : rule__CbCFormula__Group__0__Impl rule__CbCFormula__Group__1 ;
	public final void rule__CbCFormula__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:964:2: ( rule__CbCFormula__Group__0__Impl rule__CbCFormula__Group__1 )
			// InternalDsl.g:965:2: rule__CbCFormula__Group__0__Impl rule__CbCFormula__Group__1
			{
			pushFollow(FOLLOW_4);
			rule__CbCFormula__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__0"



	// $ANTLR start "rule__CbCFormula__Group__0__Impl"
	// InternalDsl.g:972:1: rule__CbCFormula__Group__0__Impl : ( 'Formula' ) ;
	public final void rule__CbCFormula__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:976:2: ( ( 'Formula' ) )
			// InternalDsl.g:977:2: ( 'Formula' )
			{
			// InternalDsl.g:977:2: ( 'Formula' )
			// InternalDsl.g:978:2: 'Formula'
			{
			 before(grammarAccess.getCbCFormulaAccess().getFormulaKeyword_0()); 
			match(input,30,FOLLOW_2); 
			 after(grammarAccess.getCbCFormulaAccess().getFormulaKeyword_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__0__Impl"



	// $ANTLR start "rule__CbCFormula__Group__1"
	// InternalDsl.g:987:1: rule__CbCFormula__Group__1 : rule__CbCFormula__Group__1__Impl rule__CbCFormula__Group__2 ;
	public final void rule__CbCFormula__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:991:2: ( rule__CbCFormula__Group__1__Impl rule__CbCFormula__Group__2 )
			// InternalDsl.g:992:2: rule__CbCFormula__Group__1__Impl rule__CbCFormula__Group__2
			{
			pushFollow(FOLLOW_5);
			rule__CbCFormula__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__1"



	// $ANTLR start "rule__CbCFormula__Group__1__Impl"
	// InternalDsl.g:999:1: rule__CbCFormula__Group__1__Impl : ( ( rule__CbCFormula__NameAssignment_1 ) ) ;
	public final void rule__CbCFormula__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1003:2: ( ( ( rule__CbCFormula__NameAssignment_1 ) ) )
			// InternalDsl.g:1004:2: ( ( rule__CbCFormula__NameAssignment_1 ) )
			{
			// InternalDsl.g:1004:2: ( ( rule__CbCFormula__NameAssignment_1 ) )
			// InternalDsl.g:1005:2: ( rule__CbCFormula__NameAssignment_1 )
			{
			 before(grammarAccess.getCbCFormulaAccess().getNameAssignment_1()); 
			// InternalDsl.g:1006:2: ( rule__CbCFormula__NameAssignment_1 )
			// InternalDsl.g:1006:3: rule__CbCFormula__NameAssignment_1
			{
			pushFollow(FOLLOW_2);
			rule__CbCFormula__NameAssignment_1();
			state._fsp--;

			}

			 after(grammarAccess.getCbCFormulaAccess().getNameAssignment_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__1__Impl"



	// $ANTLR start "rule__CbCFormula__Group__2"
	// InternalDsl.g:1014:1: rule__CbCFormula__Group__2 : rule__CbCFormula__Group__2__Impl rule__CbCFormula__Group__3 ;
	public final void rule__CbCFormula__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1018:2: ( rule__CbCFormula__Group__2__Impl rule__CbCFormula__Group__3 )
			// InternalDsl.g:1019:2: rule__CbCFormula__Group__2__Impl rule__CbCFormula__Group__3
			{
			pushFollow(FOLLOW_6);
			rule__CbCFormula__Group__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__2"



	// $ANTLR start "rule__CbCFormula__Group__2__Impl"
	// InternalDsl.g:1026:1: rule__CbCFormula__Group__2__Impl : ( 'pre:' ) ;
	public final void rule__CbCFormula__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1030:2: ( ( 'pre:' ) )
			// InternalDsl.g:1031:2: ( 'pre:' )
			{
			// InternalDsl.g:1031:2: ( 'pre:' )
			// InternalDsl.g:1032:2: 'pre:'
			{
			 before(grammarAccess.getCbCFormulaAccess().getPreKeyword_2()); 
			match(input,47,FOLLOW_2); 
			 after(grammarAccess.getCbCFormulaAccess().getPreKeyword_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__2__Impl"



	// $ANTLR start "rule__CbCFormula__Group__3"
	// InternalDsl.g:1041:1: rule__CbCFormula__Group__3 : rule__CbCFormula__Group__3__Impl rule__CbCFormula__Group__4 ;
	public final void rule__CbCFormula__Group__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1045:2: ( rule__CbCFormula__Group__3__Impl rule__CbCFormula__Group__4 )
			// InternalDsl.g:1046:2: rule__CbCFormula__Group__3__Impl rule__CbCFormula__Group__4
			{
			pushFollow(FOLLOW_4);
			rule__CbCFormula__Group__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__3"



	// $ANTLR start "rule__CbCFormula__Group__3__Impl"
	// InternalDsl.g:1053:1: rule__CbCFormula__Group__3__Impl : ( '{' ) ;
	public final void rule__CbCFormula__Group__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1057:2: ( ( '{' ) )
			// InternalDsl.g:1058:2: ( '{' )
			{
			// InternalDsl.g:1058:2: ( '{' )
			// InternalDsl.g:1059:2: '{'
			{
			 before(grammarAccess.getCbCFormulaAccess().getLeftCurlyBracketKeyword_3()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getCbCFormulaAccess().getLeftCurlyBracketKeyword_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__3__Impl"



	// $ANTLR start "rule__CbCFormula__Group__4"
	// InternalDsl.g:1068:1: rule__CbCFormula__Group__4 : rule__CbCFormula__Group__4__Impl rule__CbCFormula__Group__5 ;
	public final void rule__CbCFormula__Group__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1072:2: ( rule__CbCFormula__Group__4__Impl rule__CbCFormula__Group__5 )
			// InternalDsl.g:1073:2: rule__CbCFormula__Group__4__Impl rule__CbCFormula__Group__5
			{
			pushFollow(FOLLOW_7);
			rule__CbCFormula__Group__4__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__5();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__4"



	// $ANTLR start "rule__CbCFormula__Group__4__Impl"
	// InternalDsl.g:1080:1: rule__CbCFormula__Group__4__Impl : ( ( rule__CbCFormula__PreConditionAssignment_4 ) ) ;
	public final void rule__CbCFormula__Group__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1084:2: ( ( ( rule__CbCFormula__PreConditionAssignment_4 ) ) )
			// InternalDsl.g:1085:2: ( ( rule__CbCFormula__PreConditionAssignment_4 ) )
			{
			// InternalDsl.g:1085:2: ( ( rule__CbCFormula__PreConditionAssignment_4 ) )
			// InternalDsl.g:1086:2: ( rule__CbCFormula__PreConditionAssignment_4 )
			{
			 before(grammarAccess.getCbCFormulaAccess().getPreConditionAssignment_4()); 
			// InternalDsl.g:1087:2: ( rule__CbCFormula__PreConditionAssignment_4 )
			// InternalDsl.g:1087:3: rule__CbCFormula__PreConditionAssignment_4
			{
			pushFollow(FOLLOW_2);
			rule__CbCFormula__PreConditionAssignment_4();
			state._fsp--;

			}

			 after(grammarAccess.getCbCFormulaAccess().getPreConditionAssignment_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__4__Impl"



	// $ANTLR start "rule__CbCFormula__Group__5"
	// InternalDsl.g:1095:1: rule__CbCFormula__Group__5 : rule__CbCFormula__Group__5__Impl rule__CbCFormula__Group__6 ;
	public final void rule__CbCFormula__Group__5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1099:2: ( rule__CbCFormula__Group__5__Impl rule__CbCFormula__Group__6 )
			// InternalDsl.g:1100:2: rule__CbCFormula__Group__5__Impl rule__CbCFormula__Group__6
			{
			pushFollow(FOLLOW_6);
			rule__CbCFormula__Group__5__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__6();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__5"



	// $ANTLR start "rule__CbCFormula__Group__5__Impl"
	// InternalDsl.g:1107:1: rule__CbCFormula__Group__5__Impl : ( '}' ) ;
	public final void rule__CbCFormula__Group__5__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1111:2: ( ( '}' ) )
			// InternalDsl.g:1112:2: ( '}' )
			{
			// InternalDsl.g:1112:2: ( '}' )
			// InternalDsl.g:1113:2: '}'
			{
			 before(grammarAccess.getCbCFormulaAccess().getRightCurlyBracketKeyword_5()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getCbCFormulaAccess().getRightCurlyBracketKeyword_5()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__5__Impl"



	// $ANTLR start "rule__CbCFormula__Group__6"
	// InternalDsl.g:1122:1: rule__CbCFormula__Group__6 : rule__CbCFormula__Group__6__Impl rule__CbCFormula__Group__7 ;
	public final void rule__CbCFormula__Group__6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1126:2: ( rule__CbCFormula__Group__6__Impl rule__CbCFormula__Group__7 )
			// InternalDsl.g:1127:2: rule__CbCFormula__Group__6__Impl rule__CbCFormula__Group__7
			{
			pushFollow(FOLLOW_8);
			rule__CbCFormula__Group__6__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__7();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__6"



	// $ANTLR start "rule__CbCFormula__Group__6__Impl"
	// InternalDsl.g:1134:1: rule__CbCFormula__Group__6__Impl : ( '{' ) ;
	public final void rule__CbCFormula__Group__6__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1138:2: ( ( '{' ) )
			// InternalDsl.g:1139:2: ( '{' )
			{
			// InternalDsl.g:1139:2: ( '{' )
			// InternalDsl.g:1140:2: '{'
			{
			 before(grammarAccess.getCbCFormulaAccess().getLeftCurlyBracketKeyword_6()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getCbCFormulaAccess().getLeftCurlyBracketKeyword_6()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__6__Impl"



	// $ANTLR start "rule__CbCFormula__Group__7"
	// InternalDsl.g:1149:1: rule__CbCFormula__Group__7 : rule__CbCFormula__Group__7__Impl rule__CbCFormula__Group__8 ;
	public final void rule__CbCFormula__Group__7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1153:2: ( rule__CbCFormula__Group__7__Impl rule__CbCFormula__Group__8 )
			// InternalDsl.g:1154:2: rule__CbCFormula__Group__7__Impl rule__CbCFormula__Group__8
			{
			pushFollow(FOLLOW_7);
			rule__CbCFormula__Group__7__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__8();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__7"



	// $ANTLR start "rule__CbCFormula__Group__7__Impl"
	// InternalDsl.g:1161:1: rule__CbCFormula__Group__7__Impl : ( ( rule__CbCFormula__StatementAssignment_7 ) ) ;
	public final void rule__CbCFormula__Group__7__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1165:2: ( ( ( rule__CbCFormula__StatementAssignment_7 ) ) )
			// InternalDsl.g:1166:2: ( ( rule__CbCFormula__StatementAssignment_7 ) )
			{
			// InternalDsl.g:1166:2: ( ( rule__CbCFormula__StatementAssignment_7 ) )
			// InternalDsl.g:1167:2: ( rule__CbCFormula__StatementAssignment_7 )
			{
			 before(grammarAccess.getCbCFormulaAccess().getStatementAssignment_7()); 
			// InternalDsl.g:1168:2: ( rule__CbCFormula__StatementAssignment_7 )
			// InternalDsl.g:1168:3: rule__CbCFormula__StatementAssignment_7
			{
			pushFollow(FOLLOW_2);
			rule__CbCFormula__StatementAssignment_7();
			state._fsp--;

			}

			 after(grammarAccess.getCbCFormulaAccess().getStatementAssignment_7()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__7__Impl"



	// $ANTLR start "rule__CbCFormula__Group__8"
	// InternalDsl.g:1176:1: rule__CbCFormula__Group__8 : rule__CbCFormula__Group__8__Impl rule__CbCFormula__Group__9 ;
	public final void rule__CbCFormula__Group__8() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1180:2: ( rule__CbCFormula__Group__8__Impl rule__CbCFormula__Group__9 )
			// InternalDsl.g:1181:2: rule__CbCFormula__Group__8__Impl rule__CbCFormula__Group__9
			{
			pushFollow(FOLLOW_9);
			rule__CbCFormula__Group__8__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__9();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__8"



	// $ANTLR start "rule__CbCFormula__Group__8__Impl"
	// InternalDsl.g:1188:1: rule__CbCFormula__Group__8__Impl : ( '}' ) ;
	public final void rule__CbCFormula__Group__8__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1192:2: ( ( '}' ) )
			// InternalDsl.g:1193:2: ( '}' )
			{
			// InternalDsl.g:1193:2: ( '}' )
			// InternalDsl.g:1194:2: '}'
			{
			 before(grammarAccess.getCbCFormulaAccess().getRightCurlyBracketKeyword_8()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getCbCFormulaAccess().getRightCurlyBracketKeyword_8()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__8__Impl"



	// $ANTLR start "rule__CbCFormula__Group__9"
	// InternalDsl.g:1203:1: rule__CbCFormula__Group__9 : rule__CbCFormula__Group__9__Impl rule__CbCFormula__Group__10 ;
	public final void rule__CbCFormula__Group__9() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1207:2: ( rule__CbCFormula__Group__9__Impl rule__CbCFormula__Group__10 )
			// InternalDsl.g:1208:2: rule__CbCFormula__Group__9__Impl rule__CbCFormula__Group__10
			{
			pushFollow(FOLLOW_6);
			rule__CbCFormula__Group__9__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__10();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__9"



	// $ANTLR start "rule__CbCFormula__Group__9__Impl"
	// InternalDsl.g:1215:1: rule__CbCFormula__Group__9__Impl : ( 'post:' ) ;
	public final void rule__CbCFormula__Group__9__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1219:2: ( ( 'post:' ) )
			// InternalDsl.g:1220:2: ( 'post:' )
			{
			// InternalDsl.g:1220:2: ( 'post:' )
			// InternalDsl.g:1221:2: 'post:'
			{
			 before(grammarAccess.getCbCFormulaAccess().getPostKeyword_9()); 
			match(input,46,FOLLOW_2); 
			 after(grammarAccess.getCbCFormulaAccess().getPostKeyword_9()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__9__Impl"



	// $ANTLR start "rule__CbCFormula__Group__10"
	// InternalDsl.g:1230:1: rule__CbCFormula__Group__10 : rule__CbCFormula__Group__10__Impl rule__CbCFormula__Group__11 ;
	public final void rule__CbCFormula__Group__10() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1234:2: ( rule__CbCFormula__Group__10__Impl rule__CbCFormula__Group__11 )
			// InternalDsl.g:1235:2: rule__CbCFormula__Group__10__Impl rule__CbCFormula__Group__11
			{
			pushFollow(FOLLOW_4);
			rule__CbCFormula__Group__10__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__11();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__10"



	// $ANTLR start "rule__CbCFormula__Group__10__Impl"
	// InternalDsl.g:1242:1: rule__CbCFormula__Group__10__Impl : ( '{' ) ;
	public final void rule__CbCFormula__Group__10__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1246:2: ( ( '{' ) )
			// InternalDsl.g:1247:2: ( '{' )
			{
			// InternalDsl.g:1247:2: ( '{' )
			// InternalDsl.g:1248:2: '{'
			{
			 before(grammarAccess.getCbCFormulaAccess().getLeftCurlyBracketKeyword_10()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getCbCFormulaAccess().getLeftCurlyBracketKeyword_10()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__10__Impl"



	// $ANTLR start "rule__CbCFormula__Group__11"
	// InternalDsl.g:1257:1: rule__CbCFormula__Group__11 : rule__CbCFormula__Group__11__Impl rule__CbCFormula__Group__12 ;
	public final void rule__CbCFormula__Group__11() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1261:2: ( rule__CbCFormula__Group__11__Impl rule__CbCFormula__Group__12 )
			// InternalDsl.g:1262:2: rule__CbCFormula__Group__11__Impl rule__CbCFormula__Group__12
			{
			pushFollow(FOLLOW_7);
			rule__CbCFormula__Group__11__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__12();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__11"



	// $ANTLR start "rule__CbCFormula__Group__11__Impl"
	// InternalDsl.g:1269:1: rule__CbCFormula__Group__11__Impl : ( ( rule__CbCFormula__PostConditionAssignment_11 ) ) ;
	public final void rule__CbCFormula__Group__11__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1273:2: ( ( ( rule__CbCFormula__PostConditionAssignment_11 ) ) )
			// InternalDsl.g:1274:2: ( ( rule__CbCFormula__PostConditionAssignment_11 ) )
			{
			// InternalDsl.g:1274:2: ( ( rule__CbCFormula__PostConditionAssignment_11 ) )
			// InternalDsl.g:1275:2: ( rule__CbCFormula__PostConditionAssignment_11 )
			{
			 before(grammarAccess.getCbCFormulaAccess().getPostConditionAssignment_11()); 
			// InternalDsl.g:1276:2: ( rule__CbCFormula__PostConditionAssignment_11 )
			// InternalDsl.g:1276:3: rule__CbCFormula__PostConditionAssignment_11
			{
			pushFollow(FOLLOW_2);
			rule__CbCFormula__PostConditionAssignment_11();
			state._fsp--;

			}

			 after(grammarAccess.getCbCFormulaAccess().getPostConditionAssignment_11()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__11__Impl"



	// $ANTLR start "rule__CbCFormula__Group__12"
	// InternalDsl.g:1284:1: rule__CbCFormula__Group__12 : rule__CbCFormula__Group__12__Impl ;
	public final void rule__CbCFormula__Group__12() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1288:2: ( rule__CbCFormula__Group__12__Impl )
			// InternalDsl.g:1289:2: rule__CbCFormula__Group__12__Impl
			{
			pushFollow(FOLLOW_2);
			rule__CbCFormula__Group__12__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__12"



	// $ANTLR start "rule__CbCFormula__Group__12__Impl"
	// InternalDsl.g:1295:1: rule__CbCFormula__Group__12__Impl : ( '}' ) ;
	public final void rule__CbCFormula__Group__12__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1299:2: ( ( '}' ) )
			// InternalDsl.g:1300:2: ( '}' )
			{
			// InternalDsl.g:1300:2: ( '}' )
			// InternalDsl.g:1301:2: '}'
			{
			 before(grammarAccess.getCbCFormulaAccess().getRightCurlyBracketKeyword_12()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getCbCFormulaAccess().getRightCurlyBracketKeyword_12()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__Group__12__Impl"



	// $ANTLR start "rule__CodeString__Group__0"
	// InternalDsl.g:1311:1: rule__CodeString__Group__0 : rule__CodeString__Group__0__Impl rule__CodeString__Group__1 ;
	public final void rule__CodeString__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1315:2: ( rule__CodeString__Group__0__Impl rule__CodeString__Group__1 )
			// InternalDsl.g:1316:2: rule__CodeString__Group__0__Impl rule__CodeString__Group__1
			{
			pushFollow(FOLLOW_10);
			rule__CodeString__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__0"



	// $ANTLR start "rule__CodeString__Group__0__Impl"
	// InternalDsl.g:1323:1: rule__CodeString__Group__0__Impl : ( RULE_ID ) ;
	public final void rule__CodeString__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1327:2: ( ( RULE_ID ) )
			// InternalDsl.g:1328:2: ( RULE_ID )
			{
			// InternalDsl.g:1328:2: ( RULE_ID )
			// InternalDsl.g:1329:2: RULE_ID
			{
			 before(grammarAccess.getCodeStringAccess().getIDTerminalRuleCall_0()); 
			match(input,RULE_ID,FOLLOW_2); 
			 after(grammarAccess.getCodeStringAccess().getIDTerminalRuleCall_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__0__Impl"



	// $ANTLR start "rule__CodeString__Group__1"
	// InternalDsl.g:1338:1: rule__CodeString__Group__1 : rule__CodeString__Group__1__Impl rule__CodeString__Group__2 ;
	public final void rule__CodeString__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1342:2: ( rule__CodeString__Group__1__Impl rule__CodeString__Group__2 )
			// InternalDsl.g:1343:2: rule__CodeString__Group__1__Impl rule__CodeString__Group__2
			{
			pushFollow(FOLLOW_11);
			rule__CodeString__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__1"



	// $ANTLR start "rule__CodeString__Group__1__Impl"
	// InternalDsl.g:1350:1: rule__CodeString__Group__1__Impl : ( ( rule__CodeString__Group_1__0 )? ) ;
	public final void rule__CodeString__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1354:2: ( ( ( rule__CodeString__Group_1__0 )? ) )
			// InternalDsl.g:1355:2: ( ( rule__CodeString__Group_1__0 )? )
			{
			// InternalDsl.g:1355:2: ( ( rule__CodeString__Group_1__0 )? )
			// InternalDsl.g:1356:2: ( rule__CodeString__Group_1__0 )?
			{
			 before(grammarAccess.getCodeStringAccess().getGroup_1()); 
			// InternalDsl.g:1357:2: ( rule__CodeString__Group_1__0 )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==34) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// InternalDsl.g:1357:3: rule__CodeString__Group_1__0
					{
					pushFollow(FOLLOW_2);
					rule__CodeString__Group_1__0();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getCodeStringAccess().getGroup_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__1__Impl"



	// $ANTLR start "rule__CodeString__Group__2"
	// InternalDsl.g:1365:1: rule__CodeString__Group__2 : rule__CodeString__Group__2__Impl rule__CodeString__Group__3 ;
	public final void rule__CodeString__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1369:2: ( rule__CodeString__Group__2__Impl rule__CodeString__Group__3 )
			// InternalDsl.g:1370:2: rule__CodeString__Group__2__Impl rule__CodeString__Group__3
			{
			pushFollow(FOLLOW_12);
			rule__CodeString__Group__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__2"



	// $ANTLR start "rule__CodeString__Group__2__Impl"
	// InternalDsl.g:1377:1: rule__CodeString__Group__2__Impl : ( '=' ) ;
	public final void rule__CodeString__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1381:2: ( ( '=' ) )
			// InternalDsl.g:1382:2: ( '=' )
			{
			// InternalDsl.g:1382:2: ( '=' )
			// InternalDsl.g:1383:2: '='
			{
			 before(grammarAccess.getCodeStringAccess().getEqualsSignKeyword_2()); 
			match(input,25,FOLLOW_2); 
			 after(grammarAccess.getCodeStringAccess().getEqualsSignKeyword_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__2__Impl"



	// $ANTLR start "rule__CodeString__Group__3"
	// InternalDsl.g:1392:1: rule__CodeString__Group__3 : rule__CodeString__Group__3__Impl rule__CodeString__Group__4 ;
	public final void rule__CodeString__Group__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1396:2: ( rule__CodeString__Group__3__Impl rule__CodeString__Group__4 )
			// InternalDsl.g:1397:2: rule__CodeString__Group__3__Impl rule__CodeString__Group__4
			{
			pushFollow(FOLLOW_13);
			rule__CodeString__Group__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__3"



	// $ANTLR start "rule__CodeString__Group__3__Impl"
	// InternalDsl.g:1404:1: rule__CodeString__Group__3__Impl : ( ( '(' )? ) ;
	public final void rule__CodeString__Group__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1408:2: ( ( ( '(' )? ) )
			// InternalDsl.g:1409:2: ( ( '(' )? )
			{
			// InternalDsl.g:1409:2: ( ( '(' )? )
			// InternalDsl.g:1410:2: ( '(' )?
			{
			 before(grammarAccess.getCodeStringAccess().getLeftParenthesisKeyword_3()); 
			// InternalDsl.g:1411:2: ( '(' )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==15) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// InternalDsl.g:1411:3: '('
					{
					match(input,15,FOLLOW_2); 
					}
					break;

			}

			 after(grammarAccess.getCodeStringAccess().getLeftParenthesisKeyword_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__3__Impl"



	// $ANTLR start "rule__CodeString__Group__4"
	// InternalDsl.g:1419:1: rule__CodeString__Group__4 : rule__CodeString__Group__4__Impl rule__CodeString__Group__5 ;
	public final void rule__CodeString__Group__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1423:2: ( rule__CodeString__Group__4__Impl rule__CodeString__Group__5 )
			// InternalDsl.g:1424:2: rule__CodeString__Group__4__Impl rule__CodeString__Group__5
			{
			pushFollow(FOLLOW_14);
			rule__CodeString__Group__4__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group__5();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__4"



	// $ANTLR start "rule__CodeString__Group__4__Impl"
	// InternalDsl.g:1431:1: rule__CodeString__Group__4__Impl : ( ( rule__CodeString__Alternatives_4 ) ) ;
	public final void rule__CodeString__Group__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1435:2: ( ( ( rule__CodeString__Alternatives_4 ) ) )
			// InternalDsl.g:1436:2: ( ( rule__CodeString__Alternatives_4 ) )
			{
			// InternalDsl.g:1436:2: ( ( rule__CodeString__Alternatives_4 ) )
			// InternalDsl.g:1437:2: ( rule__CodeString__Alternatives_4 )
			{
			 before(grammarAccess.getCodeStringAccess().getAlternatives_4()); 
			// InternalDsl.g:1438:2: ( rule__CodeString__Alternatives_4 )
			// InternalDsl.g:1438:3: rule__CodeString__Alternatives_4
			{
			pushFollow(FOLLOW_2);
			rule__CodeString__Alternatives_4();
			state._fsp--;

			}

			 after(grammarAccess.getCodeStringAccess().getAlternatives_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__4__Impl"



	// $ANTLR start "rule__CodeString__Group__5"
	// InternalDsl.g:1446:1: rule__CodeString__Group__5 : rule__CodeString__Group__5__Impl rule__CodeString__Group__6 ;
	public final void rule__CodeString__Group__5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1450:2: ( rule__CodeString__Group__5__Impl rule__CodeString__Group__6 )
			// InternalDsl.g:1451:2: rule__CodeString__Group__5__Impl rule__CodeString__Group__6
			{
			pushFollow(FOLLOW_15);
			rule__CodeString__Group__5__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group__6();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__5"



	// $ANTLR start "rule__CodeString__Group__5__Impl"
	// InternalDsl.g:1458:1: rule__CodeString__Group__5__Impl : ( ( rule__CodeString__Group_5__0 )* ) ;
	public final void rule__CodeString__Group__5__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1462:2: ( ( ( rule__CodeString__Group_5__0 )* ) )
			// InternalDsl.g:1463:2: ( ( rule__CodeString__Group_5__0 )* )
			{
			// InternalDsl.g:1463:2: ( ( rule__CodeString__Group_5__0 )* )
			// InternalDsl.g:1464:2: ( rule__CodeString__Group_5__0 )*
			{
			 before(grammarAccess.getCodeStringAccess().getGroup_5()); 
			// InternalDsl.g:1465:2: ( rule__CodeString__Group_5__0 )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==14||(LA14_0 >= 17 && LA14_0 <= 18)||LA14_0==20||LA14_0==22) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// InternalDsl.g:1465:3: rule__CodeString__Group_5__0
					{
					pushFollow(FOLLOW_16);
					rule__CodeString__Group_5__0();
					state._fsp--;

					}
					break;

				default :
					break loop14;
				}
			}

			 after(grammarAccess.getCodeStringAccess().getGroup_5()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__5__Impl"



	// $ANTLR start "rule__CodeString__Group__6"
	// InternalDsl.g:1473:1: rule__CodeString__Group__6 : rule__CodeString__Group__6__Impl ;
	public final void rule__CodeString__Group__6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1477:2: ( rule__CodeString__Group__6__Impl )
			// InternalDsl.g:1478:2: rule__CodeString__Group__6__Impl
			{
			pushFollow(FOLLOW_2);
			rule__CodeString__Group__6__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__6"



	// $ANTLR start "rule__CodeString__Group__6__Impl"
	// InternalDsl.g:1484:1: rule__CodeString__Group__6__Impl : ( ';' ) ;
	public final void rule__CodeString__Group__6__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1488:2: ( ( ';' ) )
			// InternalDsl.g:1489:2: ( ';' )
			{
			// InternalDsl.g:1489:2: ( ';' )
			// InternalDsl.g:1490:2: ';'
			{
			 before(grammarAccess.getCodeStringAccess().getSemicolonKeyword_6()); 
			match(input,24,FOLLOW_2); 
			 after(grammarAccess.getCodeStringAccess().getSemicolonKeyword_6()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group__6__Impl"



	// $ANTLR start "rule__CodeString__Group_1__0"
	// InternalDsl.g:1500:1: rule__CodeString__Group_1__0 : rule__CodeString__Group_1__0__Impl rule__CodeString__Group_1__1 ;
	public final void rule__CodeString__Group_1__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1504:2: ( rule__CodeString__Group_1__0__Impl rule__CodeString__Group_1__1 )
			// InternalDsl.g:1505:2: rule__CodeString__Group_1__0__Impl rule__CodeString__Group_1__1
			{
			pushFollow(FOLLOW_17);
			rule__CodeString__Group_1__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group_1__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_1__0"



	// $ANTLR start "rule__CodeString__Group_1__0__Impl"
	// InternalDsl.g:1512:1: rule__CodeString__Group_1__0__Impl : ( '[' ) ;
	public final void rule__CodeString__Group_1__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1516:2: ( ( '[' ) )
			// InternalDsl.g:1517:2: ( '[' )
			{
			// InternalDsl.g:1517:2: ( '[' )
			// InternalDsl.g:1518:2: '['
			{
			 before(grammarAccess.getCodeStringAccess().getLeftSquareBracketKeyword_1_0()); 
			match(input,34,FOLLOW_2); 
			 after(grammarAccess.getCodeStringAccess().getLeftSquareBracketKeyword_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_1__0__Impl"



	// $ANTLR start "rule__CodeString__Group_1__1"
	// InternalDsl.g:1527:1: rule__CodeString__Group_1__1 : rule__CodeString__Group_1__1__Impl rule__CodeString__Group_1__2 ;
	public final void rule__CodeString__Group_1__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1531:2: ( rule__CodeString__Group_1__1__Impl rule__CodeString__Group_1__2 )
			// InternalDsl.g:1532:2: rule__CodeString__Group_1__1__Impl rule__CodeString__Group_1__2
			{
			pushFollow(FOLLOW_18);
			rule__CodeString__Group_1__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group_1__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_1__1"



	// $ANTLR start "rule__CodeString__Group_1__1__Impl"
	// InternalDsl.g:1539:1: rule__CodeString__Group_1__1__Impl : ( ( rule__CodeString__Alternatives_1_1 ) ) ;
	public final void rule__CodeString__Group_1__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1543:2: ( ( ( rule__CodeString__Alternatives_1_1 ) ) )
			// InternalDsl.g:1544:2: ( ( rule__CodeString__Alternatives_1_1 ) )
			{
			// InternalDsl.g:1544:2: ( ( rule__CodeString__Alternatives_1_1 ) )
			// InternalDsl.g:1545:2: ( rule__CodeString__Alternatives_1_1 )
			{
			 before(grammarAccess.getCodeStringAccess().getAlternatives_1_1()); 
			// InternalDsl.g:1546:2: ( rule__CodeString__Alternatives_1_1 )
			// InternalDsl.g:1546:3: rule__CodeString__Alternatives_1_1
			{
			pushFollow(FOLLOW_2);
			rule__CodeString__Alternatives_1_1();
			state._fsp--;

			}

			 after(grammarAccess.getCodeStringAccess().getAlternatives_1_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_1__1__Impl"



	// $ANTLR start "rule__CodeString__Group_1__2"
	// InternalDsl.g:1554:1: rule__CodeString__Group_1__2 : rule__CodeString__Group_1__2__Impl ;
	public final void rule__CodeString__Group_1__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1558:2: ( rule__CodeString__Group_1__2__Impl )
			// InternalDsl.g:1559:2: rule__CodeString__Group_1__2__Impl
			{
			pushFollow(FOLLOW_2);
			rule__CodeString__Group_1__2__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_1__2"



	// $ANTLR start "rule__CodeString__Group_1__2__Impl"
	// InternalDsl.g:1565:1: rule__CodeString__Group_1__2__Impl : ( ']' ) ;
	public final void rule__CodeString__Group_1__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1569:2: ( ( ']' ) )
			// InternalDsl.g:1570:2: ( ']' )
			{
			// InternalDsl.g:1570:2: ( ']' )
			// InternalDsl.g:1571:2: ']'
			{
			 before(grammarAccess.getCodeStringAccess().getRightSquareBracketKeyword_1_2()); 
			match(input,35,FOLLOW_2); 
			 after(grammarAccess.getCodeStringAccess().getRightSquareBracketKeyword_1_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_1__2__Impl"



	// $ANTLR start "rule__CodeString__Group_4_1__0"
	// InternalDsl.g:1581:1: rule__CodeString__Group_4_1__0 : rule__CodeString__Group_4_1__0__Impl rule__CodeString__Group_4_1__1 ;
	public final void rule__CodeString__Group_4_1__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1585:2: ( rule__CodeString__Group_4_1__0__Impl rule__CodeString__Group_4_1__1 )
			// InternalDsl.g:1586:2: rule__CodeString__Group_4_1__0__Impl rule__CodeString__Group_4_1__1
			{
			pushFollow(FOLLOW_19);
			rule__CodeString__Group_4_1__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group_4_1__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_4_1__0"



	// $ANTLR start "rule__CodeString__Group_4_1__0__Impl"
	// InternalDsl.g:1593:1: rule__CodeString__Group_4_1__0__Impl : ( ( '-' )? ) ;
	public final void rule__CodeString__Group_4_1__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1597:2: ( ( ( '-' )? ) )
			// InternalDsl.g:1598:2: ( ( '-' )? )
			{
			// InternalDsl.g:1598:2: ( ( '-' )? )
			// InternalDsl.g:1599:2: ( '-' )?
			{
			 before(grammarAccess.getCodeStringAccess().getHyphenMinusKeyword_4_1_0()); 
			// InternalDsl.g:1600:2: ( '-' )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==20) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// InternalDsl.g:1600:3: '-'
					{
					match(input,20,FOLLOW_2); 
					}
					break;

			}

			 after(grammarAccess.getCodeStringAccess().getHyphenMinusKeyword_4_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_4_1__0__Impl"



	// $ANTLR start "rule__CodeString__Group_4_1__1"
	// InternalDsl.g:1608:1: rule__CodeString__Group_4_1__1 : rule__CodeString__Group_4_1__1__Impl ;
	public final void rule__CodeString__Group_4_1__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1612:2: ( rule__CodeString__Group_4_1__1__Impl )
			// InternalDsl.g:1613:2: rule__CodeString__Group_4_1__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__CodeString__Group_4_1__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_4_1__1"



	// $ANTLR start "rule__CodeString__Group_4_1__1__Impl"
	// InternalDsl.g:1619:1: rule__CodeString__Group_4_1__1__Impl : ( RULE_INT ) ;
	public final void rule__CodeString__Group_4_1__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1623:2: ( ( RULE_INT ) )
			// InternalDsl.g:1624:2: ( RULE_INT )
			{
			// InternalDsl.g:1624:2: ( RULE_INT )
			// InternalDsl.g:1625:2: RULE_INT
			{
			 before(grammarAccess.getCodeStringAccess().getINTTerminalRuleCall_4_1_1()); 
			match(input,RULE_INT,FOLLOW_2); 
			 after(grammarAccess.getCodeStringAccess().getINTTerminalRuleCall_4_1_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_4_1__1__Impl"



	// $ANTLR start "rule__CodeString__Group_5__0"
	// InternalDsl.g:1635:1: rule__CodeString__Group_5__0 : rule__CodeString__Group_5__0__Impl rule__CodeString__Group_5__1 ;
	public final void rule__CodeString__Group_5__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1639:2: ( rule__CodeString__Group_5__0__Impl rule__CodeString__Group_5__1 )
			// InternalDsl.g:1640:2: rule__CodeString__Group_5__0__Impl rule__CodeString__Group_5__1
			{
			pushFollow(FOLLOW_12);
			rule__CodeString__Group_5__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group_5__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5__0"



	// $ANTLR start "rule__CodeString__Group_5__0__Impl"
	// InternalDsl.g:1647:1: rule__CodeString__Group_5__0__Impl : ( ruleOperation ) ;
	public final void rule__CodeString__Group_5__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1651:2: ( ( ruleOperation ) )
			// InternalDsl.g:1652:2: ( ruleOperation )
			{
			// InternalDsl.g:1652:2: ( ruleOperation )
			// InternalDsl.g:1653:2: ruleOperation
			{
			 before(grammarAccess.getCodeStringAccess().getOperationParserRuleCall_5_0()); 
			pushFollow(FOLLOW_2);
			ruleOperation();
			state._fsp--;

			 after(grammarAccess.getCodeStringAccess().getOperationParserRuleCall_5_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5__0__Impl"



	// $ANTLR start "rule__CodeString__Group_5__1"
	// InternalDsl.g:1662:1: rule__CodeString__Group_5__1 : rule__CodeString__Group_5__1__Impl rule__CodeString__Group_5__2 ;
	public final void rule__CodeString__Group_5__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1666:2: ( rule__CodeString__Group_5__1__Impl rule__CodeString__Group_5__2 )
			// InternalDsl.g:1667:2: rule__CodeString__Group_5__1__Impl rule__CodeString__Group_5__2
			{
			pushFollow(FOLLOW_13);
			rule__CodeString__Group_5__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group_5__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5__1"



	// $ANTLR start "rule__CodeString__Group_5__1__Impl"
	// InternalDsl.g:1674:1: rule__CodeString__Group_5__1__Impl : ( ( '(' )* ) ;
	public final void rule__CodeString__Group_5__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1678:2: ( ( ( '(' )* ) )
			// InternalDsl.g:1679:2: ( ( '(' )* )
			{
			// InternalDsl.g:1679:2: ( ( '(' )* )
			// InternalDsl.g:1680:2: ( '(' )*
			{
			 before(grammarAccess.getCodeStringAccess().getLeftParenthesisKeyword_5_1()); 
			// InternalDsl.g:1681:2: ( '(' )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==15) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// InternalDsl.g:1681:3: '('
					{
					match(input,15,FOLLOW_20); 
					}
					break;

				default :
					break loop16;
				}
			}

			 after(grammarAccess.getCodeStringAccess().getLeftParenthesisKeyword_5_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5__1__Impl"



	// $ANTLR start "rule__CodeString__Group_5__2"
	// InternalDsl.g:1689:1: rule__CodeString__Group_5__2 : rule__CodeString__Group_5__2__Impl rule__CodeString__Group_5__3 ;
	public final void rule__CodeString__Group_5__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1693:2: ( rule__CodeString__Group_5__2__Impl rule__CodeString__Group_5__3 )
			// InternalDsl.g:1694:2: rule__CodeString__Group_5__2__Impl rule__CodeString__Group_5__3
			{
			pushFollow(FOLLOW_21);
			rule__CodeString__Group_5__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group_5__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5__2"



	// $ANTLR start "rule__CodeString__Group_5__2__Impl"
	// InternalDsl.g:1701:1: rule__CodeString__Group_5__2__Impl : ( ( rule__CodeString__Alternatives_5_2 ) ) ;
	public final void rule__CodeString__Group_5__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1705:2: ( ( ( rule__CodeString__Alternatives_5_2 ) ) )
			// InternalDsl.g:1706:2: ( ( rule__CodeString__Alternatives_5_2 ) )
			{
			// InternalDsl.g:1706:2: ( ( rule__CodeString__Alternatives_5_2 ) )
			// InternalDsl.g:1707:2: ( rule__CodeString__Alternatives_5_2 )
			{
			 before(grammarAccess.getCodeStringAccess().getAlternatives_5_2()); 
			// InternalDsl.g:1708:2: ( rule__CodeString__Alternatives_5_2 )
			// InternalDsl.g:1708:3: rule__CodeString__Alternatives_5_2
			{
			pushFollow(FOLLOW_2);
			rule__CodeString__Alternatives_5_2();
			state._fsp--;

			}

			 after(grammarAccess.getCodeStringAccess().getAlternatives_5_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5__2__Impl"



	// $ANTLR start "rule__CodeString__Group_5__3"
	// InternalDsl.g:1716:1: rule__CodeString__Group_5__3 : rule__CodeString__Group_5__3__Impl ;
	public final void rule__CodeString__Group_5__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1720:2: ( rule__CodeString__Group_5__3__Impl )
			// InternalDsl.g:1721:2: rule__CodeString__Group_5__3__Impl
			{
			pushFollow(FOLLOW_2);
			rule__CodeString__Group_5__3__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5__3"



	// $ANTLR start "rule__CodeString__Group_5__3__Impl"
	// InternalDsl.g:1727:1: rule__CodeString__Group_5__3__Impl : ( ( ')' )* ) ;
	public final void rule__CodeString__Group_5__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1731:2: ( ( ( ')' )* ) )
			// InternalDsl.g:1732:2: ( ( ')' )* )
			{
			// InternalDsl.g:1732:2: ( ( ')' )* )
			// InternalDsl.g:1733:2: ( ')' )*
			{
			 before(grammarAccess.getCodeStringAccess().getRightParenthesisKeyword_5_3()); 
			// InternalDsl.g:1734:2: ( ')' )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==16) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// InternalDsl.g:1734:3: ')'
					{
					match(input,16,FOLLOW_22); 
					}
					break;

				default :
					break loop17;
				}
			}

			 after(grammarAccess.getCodeStringAccess().getRightParenthesisKeyword_5_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5__3__Impl"



	// $ANTLR start "rule__CodeString__Group_5_2_1__0"
	// InternalDsl.g:1743:1: rule__CodeString__Group_5_2_1__0 : rule__CodeString__Group_5_2_1__0__Impl rule__CodeString__Group_5_2_1__1 ;
	public final void rule__CodeString__Group_5_2_1__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1747:2: ( rule__CodeString__Group_5_2_1__0__Impl rule__CodeString__Group_5_2_1__1 )
			// InternalDsl.g:1748:2: rule__CodeString__Group_5_2_1__0__Impl rule__CodeString__Group_5_2_1__1
			{
			pushFollow(FOLLOW_19);
			rule__CodeString__Group_5_2_1__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CodeString__Group_5_2_1__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5_2_1__0"



	// $ANTLR start "rule__CodeString__Group_5_2_1__0__Impl"
	// InternalDsl.g:1755:1: rule__CodeString__Group_5_2_1__0__Impl : ( ( '-' )? ) ;
	public final void rule__CodeString__Group_5_2_1__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1759:2: ( ( ( '-' )? ) )
			// InternalDsl.g:1760:2: ( ( '-' )? )
			{
			// InternalDsl.g:1760:2: ( ( '-' )? )
			// InternalDsl.g:1761:2: ( '-' )?
			{
			 before(grammarAccess.getCodeStringAccess().getHyphenMinusKeyword_5_2_1_0()); 
			// InternalDsl.g:1762:2: ( '-' )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==20) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// InternalDsl.g:1762:3: '-'
					{
					match(input,20,FOLLOW_2); 
					}
					break;

			}

			 after(grammarAccess.getCodeStringAccess().getHyphenMinusKeyword_5_2_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5_2_1__0__Impl"



	// $ANTLR start "rule__CodeString__Group_5_2_1__1"
	// InternalDsl.g:1770:1: rule__CodeString__Group_5_2_1__1 : rule__CodeString__Group_5_2_1__1__Impl ;
	public final void rule__CodeString__Group_5_2_1__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1774:2: ( rule__CodeString__Group_5_2_1__1__Impl )
			// InternalDsl.g:1775:2: rule__CodeString__Group_5_2_1__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__CodeString__Group_5_2_1__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5_2_1__1"



	// $ANTLR start "rule__CodeString__Group_5_2_1__1__Impl"
	// InternalDsl.g:1781:1: rule__CodeString__Group_5_2_1__1__Impl : ( RULE_INT ) ;
	public final void rule__CodeString__Group_5_2_1__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1785:2: ( ( RULE_INT ) )
			// InternalDsl.g:1786:2: ( RULE_INT )
			{
			// InternalDsl.g:1786:2: ( RULE_INT )
			// InternalDsl.g:1787:2: RULE_INT
			{
			 before(grammarAccess.getCodeStringAccess().getINTTerminalRuleCall_5_2_1_1()); 
			match(input,RULE_INT,FOLLOW_2); 
			 after(grammarAccess.getCodeStringAccess().getINTTerminalRuleCall_5_2_1_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CodeString__Group_5_2_1__1__Impl"



	// $ANTLR start "rule__VariableString__Group__0"
	// InternalDsl.g:1797:1: rule__VariableString__Group__0 : rule__VariableString__Group__0__Impl rule__VariableString__Group__1 ;
	public final void rule__VariableString__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1801:2: ( rule__VariableString__Group__0__Impl rule__VariableString__Group__1 )
			// InternalDsl.g:1802:2: rule__VariableString__Group__0__Impl rule__VariableString__Group__1
			{
			pushFollow(FOLLOW_23);
			rule__VariableString__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group__0"



	// $ANTLR start "rule__VariableString__Group__0__Impl"
	// InternalDsl.g:1809:1: rule__VariableString__Group__0__Impl : ( ( '-' )? ) ;
	public final void rule__VariableString__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1813:2: ( ( ( '-' )? ) )
			// InternalDsl.g:1814:2: ( ( '-' )? )
			{
			// InternalDsl.g:1814:2: ( ( '-' )? )
			// InternalDsl.g:1815:2: ( '-' )?
			{
			 before(grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_0()); 
			// InternalDsl.g:1816:2: ( '-' )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==20) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// InternalDsl.g:1816:3: '-'
					{
					match(input,20,FOLLOW_2); 
					}
					break;

			}

			 after(grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group__0__Impl"



	// $ANTLR start "rule__VariableString__Group__1"
	// InternalDsl.g:1824:1: rule__VariableString__Group__1 : rule__VariableString__Group__1__Impl rule__VariableString__Group__2 ;
	public final void rule__VariableString__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1828:2: ( rule__VariableString__Group__1__Impl rule__VariableString__Group__2 )
			// InternalDsl.g:1829:2: rule__VariableString__Group__1__Impl rule__VariableString__Group__2
			{
			pushFollow(FOLLOW_24);
			rule__VariableString__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group__1"



	// $ANTLR start "rule__VariableString__Group__1__Impl"
	// InternalDsl.g:1836:1: rule__VariableString__Group__1__Impl : ( RULE_ID ) ;
	public final void rule__VariableString__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1840:2: ( ( RULE_ID ) )
			// InternalDsl.g:1841:2: ( RULE_ID )
			{
			// InternalDsl.g:1841:2: ( RULE_ID )
			// InternalDsl.g:1842:2: RULE_ID
			{
			 before(grammarAccess.getVariableStringAccess().getIDTerminalRuleCall_1()); 
			match(input,RULE_ID,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getIDTerminalRuleCall_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group__1__Impl"



	// $ANTLR start "rule__VariableString__Group__2"
	// InternalDsl.g:1851:1: rule__VariableString__Group__2 : rule__VariableString__Group__2__Impl ;
	public final void rule__VariableString__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1855:2: ( rule__VariableString__Group__2__Impl )
			// InternalDsl.g:1856:2: rule__VariableString__Group__2__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group__2__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group__2"



	// $ANTLR start "rule__VariableString__Group__2__Impl"
	// InternalDsl.g:1862:1: rule__VariableString__Group__2__Impl : ( ( rule__VariableString__Alternatives_2 )? ) ;
	public final void rule__VariableString__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1866:2: ( ( ( rule__VariableString__Alternatives_2 )? ) )
			// InternalDsl.g:1867:2: ( ( rule__VariableString__Alternatives_2 )? )
			{
			// InternalDsl.g:1867:2: ( ( rule__VariableString__Alternatives_2 )? )
			// InternalDsl.g:1868:2: ( rule__VariableString__Alternatives_2 )?
			{
			 before(grammarAccess.getVariableStringAccess().getAlternatives_2()); 
			// InternalDsl.g:1869:2: ( rule__VariableString__Alternatives_2 )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==15||LA20_0==21||LA20_0==34) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// InternalDsl.g:1869:3: rule__VariableString__Alternatives_2
					{
					pushFollow(FOLLOW_2);
					rule__VariableString__Alternatives_2();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getVariableStringAccess().getAlternatives_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group__2__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0__0"
	// InternalDsl.g:1878:1: rule__VariableString__Group_2_0__0 : rule__VariableString__Group_2_0__0__Impl rule__VariableString__Group_2_0__1 ;
	public final void rule__VariableString__Group_2_0__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1882:2: ( rule__VariableString__Group_2_0__0__Impl rule__VariableString__Group_2_0__1 )
			// InternalDsl.g:1883:2: rule__VariableString__Group_2_0__0__Impl rule__VariableString__Group_2_0__1
			{
			pushFollow(FOLLOW_25);
			rule__VariableString__Group_2_0__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0__0"



	// $ANTLR start "rule__VariableString__Group_2_0__0__Impl"
	// InternalDsl.g:1890:1: rule__VariableString__Group_2_0__0__Impl : ( ( rule__VariableString__Group_2_0_0__0 ) ) ;
	public final void rule__VariableString__Group_2_0__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1894:2: ( ( ( rule__VariableString__Group_2_0_0__0 ) ) )
			// InternalDsl.g:1895:2: ( ( rule__VariableString__Group_2_0_0__0 ) )
			{
			// InternalDsl.g:1895:2: ( ( rule__VariableString__Group_2_0_0__0 ) )
			// InternalDsl.g:1896:2: ( rule__VariableString__Group_2_0_0__0 )
			{
			 before(grammarAccess.getVariableStringAccess().getGroup_2_0_0()); 
			// InternalDsl.g:1897:2: ( rule__VariableString__Group_2_0_0__0 )
			// InternalDsl.g:1897:3: rule__VariableString__Group_2_0_0__0
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0__0();
			state._fsp--;

			}

			 after(grammarAccess.getVariableStringAccess().getGroup_2_0_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0__1"
	// InternalDsl.g:1905:1: rule__VariableString__Group_2_0__1 : rule__VariableString__Group_2_0__1__Impl ;
	public final void rule__VariableString__Group_2_0__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1909:2: ( rule__VariableString__Group_2_0__1__Impl )
			// InternalDsl.g:1910:2: rule__VariableString__Group_2_0__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0__1"



	// $ANTLR start "rule__VariableString__Group_2_0__1__Impl"
	// InternalDsl.g:1916:1: rule__VariableString__Group_2_0__1__Impl : ( ( rule__VariableString__Group_2_0_1__0 )? ) ;
	public final void rule__VariableString__Group_2_0__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1920:2: ( ( ( rule__VariableString__Group_2_0_1__0 )? ) )
			// InternalDsl.g:1921:2: ( ( rule__VariableString__Group_2_0_1__0 )? )
			{
			// InternalDsl.g:1921:2: ( ( rule__VariableString__Group_2_0_1__0 )? )
			// InternalDsl.g:1922:2: ( rule__VariableString__Group_2_0_1__0 )?
			{
			 before(grammarAccess.getVariableStringAccess().getGroup_2_0_1()); 
			// InternalDsl.g:1923:2: ( rule__VariableString__Group_2_0_1__0 )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==21) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// InternalDsl.g:1923:3: rule__VariableString__Group_2_0_1__0
					{
					pushFollow(FOLLOW_2);
					rule__VariableString__Group_2_0_1__0();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getVariableStringAccess().getGroup_2_0_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0__1__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_0__0"
	// InternalDsl.g:1932:1: rule__VariableString__Group_2_0_0__0 : rule__VariableString__Group_2_0_0__0__Impl rule__VariableString__Group_2_0_0__1 ;
	public final void rule__VariableString__Group_2_0_0__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1936:2: ( rule__VariableString__Group_2_0_0__0__Impl rule__VariableString__Group_2_0_0__1 )
			// InternalDsl.g:1937:2: rule__VariableString__Group_2_0_0__0__Impl rule__VariableString__Group_2_0_0__1
			{
			pushFollow(FOLLOW_26);
			rule__VariableString__Group_2_0_0__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0__0"



	// $ANTLR start "rule__VariableString__Group_2_0_0__0__Impl"
	// InternalDsl.g:1944:1: rule__VariableString__Group_2_0_0__0__Impl : ( '(' ) ;
	public final void rule__VariableString__Group_2_0_0__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1948:2: ( ( '(' ) )
			// InternalDsl.g:1949:2: ( '(' )
			{
			// InternalDsl.g:1949:2: ( '(' )
			// InternalDsl.g:1950:2: '('
			{
			 before(grammarAccess.getVariableStringAccess().getLeftParenthesisKeyword_2_0_0_0()); 
			match(input,15,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getLeftParenthesisKeyword_2_0_0_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_0__1"
	// InternalDsl.g:1959:1: rule__VariableString__Group_2_0_0__1 : rule__VariableString__Group_2_0_0__1__Impl rule__VariableString__Group_2_0_0__2 ;
	public final void rule__VariableString__Group_2_0_0__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1963:2: ( rule__VariableString__Group_2_0_0__1__Impl rule__VariableString__Group_2_0_0__2 )
			// InternalDsl.g:1964:2: rule__VariableString__Group_2_0_0__1__Impl rule__VariableString__Group_2_0_0__2
			{
			pushFollow(FOLLOW_21);
			rule__VariableString__Group_2_0_0__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0__1"



	// $ANTLR start "rule__VariableString__Group_2_0_0__1__Impl"
	// InternalDsl.g:1971:1: rule__VariableString__Group_2_0_0__1__Impl : ( ( rule__VariableString__Group_2_0_0_1__0 )? ) ;
	public final void rule__VariableString__Group_2_0_0__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1975:2: ( ( ( rule__VariableString__Group_2_0_0_1__0 )? ) )
			// InternalDsl.g:1976:2: ( ( rule__VariableString__Group_2_0_0_1__0 )? )
			{
			// InternalDsl.g:1976:2: ( ( rule__VariableString__Group_2_0_0_1__0 )? )
			// InternalDsl.g:1977:2: ( rule__VariableString__Group_2_0_0_1__0 )?
			{
			 before(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1()); 
			// InternalDsl.g:1978:2: ( rule__VariableString__Group_2_0_0_1__0 )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( ((LA22_0 >= RULE_ID && LA22_0 <= RULE_INT)||LA22_0==20) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// InternalDsl.g:1978:3: rule__VariableString__Group_2_0_0_1__0
					{
					pushFollow(FOLLOW_2);
					rule__VariableString__Group_2_0_0_1__0();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0__1__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_0__2"
	// InternalDsl.g:1986:1: rule__VariableString__Group_2_0_0__2 : rule__VariableString__Group_2_0_0__2__Impl ;
	public final void rule__VariableString__Group_2_0_0__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:1990:2: ( rule__VariableString__Group_2_0_0__2__Impl )
			// InternalDsl.g:1991:2: rule__VariableString__Group_2_0_0__2__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0__2__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0__2"



	// $ANTLR start "rule__VariableString__Group_2_0_0__2__Impl"
	// InternalDsl.g:1997:1: rule__VariableString__Group_2_0_0__2__Impl : ( ')' ) ;
	public final void rule__VariableString__Group_2_0_0__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2001:2: ( ( ')' ) )
			// InternalDsl.g:2002:2: ( ')' )
			{
			// InternalDsl.g:2002:2: ( ')' )
			// InternalDsl.g:2003:2: ')'
			{
			 before(grammarAccess.getVariableStringAccess().getRightParenthesisKeyword_2_0_0_2()); 
			match(input,16,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getRightParenthesisKeyword_2_0_0_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0__2__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1__0"
	// InternalDsl.g:2013:1: rule__VariableString__Group_2_0_0_1__0 : rule__VariableString__Group_2_0_0_1__0__Impl rule__VariableString__Group_2_0_0_1__1 ;
	public final void rule__VariableString__Group_2_0_0_1__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2017:2: ( rule__VariableString__Group_2_0_0_1__0__Impl rule__VariableString__Group_2_0_0_1__1 )
			// InternalDsl.g:2018:2: rule__VariableString__Group_2_0_0_1__0__Impl rule__VariableString__Group_2_0_0_1__1
			{
			pushFollow(FOLLOW_27);
			rule__VariableString__Group_2_0_0_1__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0_1__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1__0"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1__0__Impl"
	// InternalDsl.g:2025:1: rule__VariableString__Group_2_0_0_1__0__Impl : ( ( rule__VariableString__Alternatives_2_0_0_1_0 ) ) ;
	public final void rule__VariableString__Group_2_0_0_1__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2029:2: ( ( ( rule__VariableString__Alternatives_2_0_0_1_0 ) ) )
			// InternalDsl.g:2030:2: ( ( rule__VariableString__Alternatives_2_0_0_1_0 ) )
			{
			// InternalDsl.g:2030:2: ( ( rule__VariableString__Alternatives_2_0_0_1_0 ) )
			// InternalDsl.g:2031:2: ( rule__VariableString__Alternatives_2_0_0_1_0 )
			{
			 before(grammarAccess.getVariableStringAccess().getAlternatives_2_0_0_1_0()); 
			// InternalDsl.g:2032:2: ( rule__VariableString__Alternatives_2_0_0_1_0 )
			// InternalDsl.g:2032:3: rule__VariableString__Alternatives_2_0_0_1_0
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Alternatives_2_0_0_1_0();
			state._fsp--;

			}

			 after(grammarAccess.getVariableStringAccess().getAlternatives_2_0_0_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1__1"
	// InternalDsl.g:2040:1: rule__VariableString__Group_2_0_0_1__1 : rule__VariableString__Group_2_0_0_1__1__Impl ;
	public final void rule__VariableString__Group_2_0_0_1__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2044:2: ( rule__VariableString__Group_2_0_0_1__1__Impl )
			// InternalDsl.g:2045:2: rule__VariableString__Group_2_0_0_1__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0_1__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1__1"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1__1__Impl"
	// InternalDsl.g:2051:1: rule__VariableString__Group_2_0_0_1__1__Impl : ( ( rule__VariableString__Group_2_0_0_1_1__0 )* ) ;
	public final void rule__VariableString__Group_2_0_0_1__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2055:2: ( ( ( rule__VariableString__Group_2_0_0_1_1__0 )* ) )
			// InternalDsl.g:2056:2: ( ( rule__VariableString__Group_2_0_0_1_1__0 )* )
			{
			// InternalDsl.g:2056:2: ( ( rule__VariableString__Group_2_0_0_1_1__0 )* )
			// InternalDsl.g:2057:2: ( rule__VariableString__Group_2_0_0_1_1__0 )*
			{
			 before(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1_1()); 
			// InternalDsl.g:2058:2: ( rule__VariableString__Group_2_0_0_1_1__0 )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==19) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// InternalDsl.g:2058:3: rule__VariableString__Group_2_0_0_1_1__0
					{
					pushFollow(FOLLOW_28);
					rule__VariableString__Group_2_0_0_1_1__0();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			 after(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1__1__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_0_1__0"
	// InternalDsl.g:2067:1: rule__VariableString__Group_2_0_0_1_0_1__0 : rule__VariableString__Group_2_0_0_1_0_1__0__Impl rule__VariableString__Group_2_0_0_1_0_1__1 ;
	public final void rule__VariableString__Group_2_0_0_1_0_1__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2071:2: ( rule__VariableString__Group_2_0_0_1_0_1__0__Impl rule__VariableString__Group_2_0_0_1_0_1__1 )
			// InternalDsl.g:2072:2: rule__VariableString__Group_2_0_0_1_0_1__0__Impl rule__VariableString__Group_2_0_0_1_0_1__1
			{
			pushFollow(FOLLOW_19);
			rule__VariableString__Group_2_0_0_1_0_1__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0_1_0_1__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_0_1__0"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_0_1__0__Impl"
	// InternalDsl.g:2079:1: rule__VariableString__Group_2_0_0_1_0_1__0__Impl : ( ( '-' )? ) ;
	public final void rule__VariableString__Group_2_0_0_1_0_1__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2083:2: ( ( ( '-' )? ) )
			// InternalDsl.g:2084:2: ( ( '-' )? )
			{
			// InternalDsl.g:2084:2: ( ( '-' )? )
			// InternalDsl.g:2085:2: ( '-' )?
			{
			 before(grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_2_0_0_1_0_1_0()); 
			// InternalDsl.g:2086:2: ( '-' )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==20) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// InternalDsl.g:2086:3: '-'
					{
					match(input,20,FOLLOW_2); 
					}
					break;

			}

			 after(grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_2_0_0_1_0_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_0_1__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_0_1__1"
	// InternalDsl.g:2094:1: rule__VariableString__Group_2_0_0_1_0_1__1 : rule__VariableString__Group_2_0_0_1_0_1__1__Impl ;
	public final void rule__VariableString__Group_2_0_0_1_0_1__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2098:2: ( rule__VariableString__Group_2_0_0_1_0_1__1__Impl )
			// InternalDsl.g:2099:2: rule__VariableString__Group_2_0_0_1_0_1__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0_1_0_1__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_0_1__1"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_0_1__1__Impl"
	// InternalDsl.g:2105:1: rule__VariableString__Group_2_0_0_1_0_1__1__Impl : ( RULE_INT ) ;
	public final void rule__VariableString__Group_2_0_0_1_0_1__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2109:2: ( ( RULE_INT ) )
			// InternalDsl.g:2110:2: ( RULE_INT )
			{
			// InternalDsl.g:2110:2: ( RULE_INT )
			// InternalDsl.g:2111:2: RULE_INT
			{
			 before(grammarAccess.getVariableStringAccess().getINTTerminalRuleCall_2_0_0_1_0_1_1()); 
			match(input,RULE_INT,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getINTTerminalRuleCall_2_0_0_1_0_1_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_0_1__1__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_1__0"
	// InternalDsl.g:2121:1: rule__VariableString__Group_2_0_0_1_1__0 : rule__VariableString__Group_2_0_0_1_1__0__Impl rule__VariableString__Group_2_0_0_1_1__1 ;
	public final void rule__VariableString__Group_2_0_0_1_1__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2125:2: ( rule__VariableString__Group_2_0_0_1_1__0__Impl rule__VariableString__Group_2_0_0_1_1__1 )
			// InternalDsl.g:2126:2: rule__VariableString__Group_2_0_0_1_1__0__Impl rule__VariableString__Group_2_0_0_1_1__1
			{
			pushFollow(FOLLOW_13);
			rule__VariableString__Group_2_0_0_1_1__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0_1_1__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_1__0"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_1__0__Impl"
	// InternalDsl.g:2133:1: rule__VariableString__Group_2_0_0_1_1__0__Impl : ( ',' ) ;
	public final void rule__VariableString__Group_2_0_0_1_1__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2137:2: ( ( ',' ) )
			// InternalDsl.g:2138:2: ( ',' )
			{
			// InternalDsl.g:2138:2: ( ',' )
			// InternalDsl.g:2139:2: ','
			{
			 before(grammarAccess.getVariableStringAccess().getCommaKeyword_2_0_0_1_1_0()); 
			match(input,19,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getCommaKeyword_2_0_0_1_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_1__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_1__1"
	// InternalDsl.g:2148:1: rule__VariableString__Group_2_0_0_1_1__1 : rule__VariableString__Group_2_0_0_1_1__1__Impl ;
	public final void rule__VariableString__Group_2_0_0_1_1__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2152:2: ( rule__VariableString__Group_2_0_0_1_1__1__Impl )
			// InternalDsl.g:2153:2: rule__VariableString__Group_2_0_0_1_1__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0_1_1__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_1__1"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_1__1__Impl"
	// InternalDsl.g:2159:1: rule__VariableString__Group_2_0_0_1_1__1__Impl : ( ( rule__VariableString__Alternatives_2_0_0_1_1_1 ) ) ;
	public final void rule__VariableString__Group_2_0_0_1_1__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2163:2: ( ( ( rule__VariableString__Alternatives_2_0_0_1_1_1 ) ) )
			// InternalDsl.g:2164:2: ( ( rule__VariableString__Alternatives_2_0_0_1_1_1 ) )
			{
			// InternalDsl.g:2164:2: ( ( rule__VariableString__Alternatives_2_0_0_1_1_1 ) )
			// InternalDsl.g:2165:2: ( rule__VariableString__Alternatives_2_0_0_1_1_1 )
			{
			 before(grammarAccess.getVariableStringAccess().getAlternatives_2_0_0_1_1_1()); 
			// InternalDsl.g:2166:2: ( rule__VariableString__Alternatives_2_0_0_1_1_1 )
			// InternalDsl.g:2166:3: rule__VariableString__Alternatives_2_0_0_1_1_1
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Alternatives_2_0_0_1_1_1();
			state._fsp--;

			}

			 after(grammarAccess.getVariableStringAccess().getAlternatives_2_0_0_1_1_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_1__1__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_1_1_1__0"
	// InternalDsl.g:2175:1: rule__VariableString__Group_2_0_0_1_1_1_1__0 : rule__VariableString__Group_2_0_0_1_1_1_1__0__Impl rule__VariableString__Group_2_0_0_1_1_1_1__1 ;
	public final void rule__VariableString__Group_2_0_0_1_1_1_1__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2179:2: ( rule__VariableString__Group_2_0_0_1_1_1_1__0__Impl rule__VariableString__Group_2_0_0_1_1_1_1__1 )
			// InternalDsl.g:2180:2: rule__VariableString__Group_2_0_0_1_1_1_1__0__Impl rule__VariableString__Group_2_0_0_1_1_1_1__1
			{
			pushFollow(FOLLOW_19);
			rule__VariableString__Group_2_0_0_1_1_1_1__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0_1_1_1_1__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_1_1_1__0"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_1_1_1__0__Impl"
	// InternalDsl.g:2187:1: rule__VariableString__Group_2_0_0_1_1_1_1__0__Impl : ( ( '-' )? ) ;
	public final void rule__VariableString__Group_2_0_0_1_1_1_1__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2191:2: ( ( ( '-' )? ) )
			// InternalDsl.g:2192:2: ( ( '-' )? )
			{
			// InternalDsl.g:2192:2: ( ( '-' )? )
			// InternalDsl.g:2193:2: ( '-' )?
			{
			 before(grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_2_0_0_1_1_1_1_0()); 
			// InternalDsl.g:2194:2: ( '-' )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==20) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// InternalDsl.g:2194:3: '-'
					{
					match(input,20,FOLLOW_2); 
					}
					break;

			}

			 after(grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_2_0_0_1_1_1_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_1_1_1__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_1_1_1__1"
	// InternalDsl.g:2202:1: rule__VariableString__Group_2_0_0_1_1_1_1__1 : rule__VariableString__Group_2_0_0_1_1_1_1__1__Impl ;
	public final void rule__VariableString__Group_2_0_0_1_1_1_1__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2206:2: ( rule__VariableString__Group_2_0_0_1_1_1_1__1__Impl )
			// InternalDsl.g:2207:2: rule__VariableString__Group_2_0_0_1_1_1_1__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_0_1_1_1_1__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_1_1_1__1"



	// $ANTLR start "rule__VariableString__Group_2_0_0_1_1_1_1__1__Impl"
	// InternalDsl.g:2213:1: rule__VariableString__Group_2_0_0_1_1_1_1__1__Impl : ( RULE_INT ) ;
	public final void rule__VariableString__Group_2_0_0_1_1_1_1__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2217:2: ( ( RULE_INT ) )
			// InternalDsl.g:2218:2: ( RULE_INT )
			{
			// InternalDsl.g:2218:2: ( RULE_INT )
			// InternalDsl.g:2219:2: RULE_INT
			{
			 before(grammarAccess.getVariableStringAccess().getINTTerminalRuleCall_2_0_0_1_1_1_1_1()); 
			match(input,RULE_INT,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getINTTerminalRuleCall_2_0_0_1_1_1_1_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_0_1_1_1_1__1__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_1__0"
	// InternalDsl.g:2229:1: rule__VariableString__Group_2_0_1__0 : rule__VariableString__Group_2_0_1__0__Impl rule__VariableString__Group_2_0_1__1 ;
	public final void rule__VariableString__Group_2_0_1__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2233:2: ( rule__VariableString__Group_2_0_1__0__Impl rule__VariableString__Group_2_0_1__1 )
			// InternalDsl.g:2234:2: rule__VariableString__Group_2_0_1__0__Impl rule__VariableString__Group_2_0_1__1
			{
			pushFollow(FOLLOW_29);
			rule__VariableString__Group_2_0_1__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_1__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_1__0"



	// $ANTLR start "rule__VariableString__Group_2_0_1__0__Impl"
	// InternalDsl.g:2241:1: rule__VariableString__Group_2_0_1__0__Impl : ( '.' ) ;
	public final void rule__VariableString__Group_2_0_1__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2245:2: ( ( '.' ) )
			// InternalDsl.g:2246:2: ( '.' )
			{
			// InternalDsl.g:2246:2: ( '.' )
			// InternalDsl.g:2247:2: '.'
			{
			 before(grammarAccess.getVariableStringAccess().getFullStopKeyword_2_0_1_0()); 
			match(input,21,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getFullStopKeyword_2_0_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_1__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_0_1__1"
	// InternalDsl.g:2256:1: rule__VariableString__Group_2_0_1__1 : rule__VariableString__Group_2_0_1__1__Impl ;
	public final void rule__VariableString__Group_2_0_1__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2260:2: ( rule__VariableString__Group_2_0_1__1__Impl )
			// InternalDsl.g:2261:2: rule__VariableString__Group_2_0_1__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_0_1__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_1__1"



	// $ANTLR start "rule__VariableString__Group_2_0_1__1__Impl"
	// InternalDsl.g:2267:1: rule__VariableString__Group_2_0_1__1__Impl : ( ruleVariableString ) ;
	public final void rule__VariableString__Group_2_0_1__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2271:2: ( ( ruleVariableString ) )
			// InternalDsl.g:2272:2: ( ruleVariableString )
			{
			// InternalDsl.g:2272:2: ( ruleVariableString )
			// InternalDsl.g:2273:2: ruleVariableString
			{
			 before(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_0_1_1()); 
			pushFollow(FOLLOW_2);
			ruleVariableString();
			state._fsp--;

			 after(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_0_1_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_0_1__1__Impl"



	// $ANTLR start "rule__VariableString__Group_2_1__0"
	// InternalDsl.g:2283:1: rule__VariableString__Group_2_1__0 : rule__VariableString__Group_2_1__0__Impl rule__VariableString__Group_2_1__1 ;
	public final void rule__VariableString__Group_2_1__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2287:2: ( rule__VariableString__Group_2_1__0__Impl rule__VariableString__Group_2_1__1 )
			// InternalDsl.g:2288:2: rule__VariableString__Group_2_1__0__Impl rule__VariableString__Group_2_1__1
			{
			pushFollow(FOLLOW_25);
			rule__VariableString__Group_2_1__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_1__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1__0"



	// $ANTLR start "rule__VariableString__Group_2_1__0__Impl"
	// InternalDsl.g:2295:1: rule__VariableString__Group_2_1__0__Impl : ( ( rule__VariableString__Group_2_1_0__0 ) ) ;
	public final void rule__VariableString__Group_2_1__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2299:2: ( ( ( rule__VariableString__Group_2_1_0__0 ) ) )
			// InternalDsl.g:2300:2: ( ( rule__VariableString__Group_2_1_0__0 ) )
			{
			// InternalDsl.g:2300:2: ( ( rule__VariableString__Group_2_1_0__0 ) )
			// InternalDsl.g:2301:2: ( rule__VariableString__Group_2_1_0__0 )
			{
			 before(grammarAccess.getVariableStringAccess().getGroup_2_1_0()); 
			// InternalDsl.g:2302:2: ( rule__VariableString__Group_2_1_0__0 )
			// InternalDsl.g:2302:3: rule__VariableString__Group_2_1_0__0
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_1_0__0();
			state._fsp--;

			}

			 after(grammarAccess.getVariableStringAccess().getGroup_2_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_1__1"
	// InternalDsl.g:2310:1: rule__VariableString__Group_2_1__1 : rule__VariableString__Group_2_1__1__Impl ;
	public final void rule__VariableString__Group_2_1__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2314:2: ( rule__VariableString__Group_2_1__1__Impl )
			// InternalDsl.g:2315:2: rule__VariableString__Group_2_1__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_1__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1__1"



	// $ANTLR start "rule__VariableString__Group_2_1__1__Impl"
	// InternalDsl.g:2321:1: rule__VariableString__Group_2_1__1__Impl : ( ( rule__VariableString__Group_2_1_1__0 )? ) ;
	public final void rule__VariableString__Group_2_1__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2325:2: ( ( ( rule__VariableString__Group_2_1_1__0 )? ) )
			// InternalDsl.g:2326:2: ( ( rule__VariableString__Group_2_1_1__0 )? )
			{
			// InternalDsl.g:2326:2: ( ( rule__VariableString__Group_2_1_1__0 )? )
			// InternalDsl.g:2327:2: ( rule__VariableString__Group_2_1_1__0 )?
			{
			 before(grammarAccess.getVariableStringAccess().getGroup_2_1_1()); 
			// InternalDsl.g:2328:2: ( rule__VariableString__Group_2_1_1__0 )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==21) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// InternalDsl.g:2328:3: rule__VariableString__Group_2_1_1__0
					{
					pushFollow(FOLLOW_2);
					rule__VariableString__Group_2_1_1__0();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getVariableStringAccess().getGroup_2_1_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1__1__Impl"



	// $ANTLR start "rule__VariableString__Group_2_1_0__0"
	// InternalDsl.g:2337:1: rule__VariableString__Group_2_1_0__0 : rule__VariableString__Group_2_1_0__0__Impl rule__VariableString__Group_2_1_0__1 ;
	public final void rule__VariableString__Group_2_1_0__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2341:2: ( rule__VariableString__Group_2_1_0__0__Impl rule__VariableString__Group_2_1_0__1 )
			// InternalDsl.g:2342:2: rule__VariableString__Group_2_1_0__0__Impl rule__VariableString__Group_2_1_0__1
			{
			pushFollow(FOLLOW_30);
			rule__VariableString__Group_2_1_0__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_1_0__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_0__0"



	// $ANTLR start "rule__VariableString__Group_2_1_0__0__Impl"
	// InternalDsl.g:2349:1: rule__VariableString__Group_2_1_0__0__Impl : ( '[' ) ;
	public final void rule__VariableString__Group_2_1_0__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2353:2: ( ( '[' ) )
			// InternalDsl.g:2354:2: ( '[' )
			{
			// InternalDsl.g:2354:2: ( '[' )
			// InternalDsl.g:2355:2: '['
			{
			 before(grammarAccess.getVariableStringAccess().getLeftSquareBracketKeyword_2_1_0_0()); 
			match(input,34,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getLeftSquareBracketKeyword_2_1_0_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_0__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_1_0__1"
	// InternalDsl.g:2364:1: rule__VariableString__Group_2_1_0__1 : rule__VariableString__Group_2_1_0__1__Impl rule__VariableString__Group_2_1_0__2 ;
	public final void rule__VariableString__Group_2_1_0__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2368:2: ( rule__VariableString__Group_2_1_0__1__Impl rule__VariableString__Group_2_1_0__2 )
			// InternalDsl.g:2369:2: rule__VariableString__Group_2_1_0__1__Impl rule__VariableString__Group_2_1_0__2
			{
			pushFollow(FOLLOW_18);
			rule__VariableString__Group_2_1_0__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_1_0__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_0__1"



	// $ANTLR start "rule__VariableString__Group_2_1_0__1__Impl"
	// InternalDsl.g:2376:1: rule__VariableString__Group_2_1_0__1__Impl : ( ( rule__VariableString__Alternatives_2_1_0_1 )? ) ;
	public final void rule__VariableString__Group_2_1_0__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2380:2: ( ( ( rule__VariableString__Alternatives_2_1_0_1 )? ) )
			// InternalDsl.g:2381:2: ( ( rule__VariableString__Alternatives_2_1_0_1 )? )
			{
			// InternalDsl.g:2381:2: ( ( rule__VariableString__Alternatives_2_1_0_1 )? )
			// InternalDsl.g:2382:2: ( rule__VariableString__Alternatives_2_1_0_1 )?
			{
			 before(grammarAccess.getVariableStringAccess().getAlternatives_2_1_0_1()); 
			// InternalDsl.g:2383:2: ( rule__VariableString__Alternatives_2_1_0_1 )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( ((LA27_0 >= RULE_ID && LA27_0 <= RULE_INT)||LA27_0==20) ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// InternalDsl.g:2383:3: rule__VariableString__Alternatives_2_1_0_1
					{
					pushFollow(FOLLOW_2);
					rule__VariableString__Alternatives_2_1_0_1();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getVariableStringAccess().getAlternatives_2_1_0_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_0__1__Impl"



	// $ANTLR start "rule__VariableString__Group_2_1_0__2"
	// InternalDsl.g:2391:1: rule__VariableString__Group_2_1_0__2 : rule__VariableString__Group_2_1_0__2__Impl ;
	public final void rule__VariableString__Group_2_1_0__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2395:2: ( rule__VariableString__Group_2_1_0__2__Impl )
			// InternalDsl.g:2396:2: rule__VariableString__Group_2_1_0__2__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_1_0__2__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_0__2"



	// $ANTLR start "rule__VariableString__Group_2_1_0__2__Impl"
	// InternalDsl.g:2402:1: rule__VariableString__Group_2_1_0__2__Impl : ( ']' ) ;
	public final void rule__VariableString__Group_2_1_0__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2406:2: ( ( ']' ) )
			// InternalDsl.g:2407:2: ( ']' )
			{
			// InternalDsl.g:2407:2: ( ']' )
			// InternalDsl.g:2408:2: ']'
			{
			 before(grammarAccess.getVariableStringAccess().getRightSquareBracketKeyword_2_1_0_2()); 
			match(input,35,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getRightSquareBracketKeyword_2_1_0_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_0__2__Impl"



	// $ANTLR start "rule__VariableString__Group_2_1_0_1_1__0"
	// InternalDsl.g:2418:1: rule__VariableString__Group_2_1_0_1_1__0 : rule__VariableString__Group_2_1_0_1_1__0__Impl rule__VariableString__Group_2_1_0_1_1__1 ;
	public final void rule__VariableString__Group_2_1_0_1_1__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2422:2: ( rule__VariableString__Group_2_1_0_1_1__0__Impl rule__VariableString__Group_2_1_0_1_1__1 )
			// InternalDsl.g:2423:2: rule__VariableString__Group_2_1_0_1_1__0__Impl rule__VariableString__Group_2_1_0_1_1__1
			{
			pushFollow(FOLLOW_19);
			rule__VariableString__Group_2_1_0_1_1__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_1_0_1_1__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_0_1_1__0"



	// $ANTLR start "rule__VariableString__Group_2_1_0_1_1__0__Impl"
	// InternalDsl.g:2430:1: rule__VariableString__Group_2_1_0_1_1__0__Impl : ( ( '-' )? ) ;
	public final void rule__VariableString__Group_2_1_0_1_1__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2434:2: ( ( ( '-' )? ) )
			// InternalDsl.g:2435:2: ( ( '-' )? )
			{
			// InternalDsl.g:2435:2: ( ( '-' )? )
			// InternalDsl.g:2436:2: ( '-' )?
			{
			 before(grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_2_1_0_1_1_0()); 
			// InternalDsl.g:2437:2: ( '-' )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==20) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// InternalDsl.g:2437:3: '-'
					{
					match(input,20,FOLLOW_2); 
					}
					break;

			}

			 after(grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_2_1_0_1_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_0_1_1__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_1_0_1_1__1"
	// InternalDsl.g:2445:1: rule__VariableString__Group_2_1_0_1_1__1 : rule__VariableString__Group_2_1_0_1_1__1__Impl ;
	public final void rule__VariableString__Group_2_1_0_1_1__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2449:2: ( rule__VariableString__Group_2_1_0_1_1__1__Impl )
			// InternalDsl.g:2450:2: rule__VariableString__Group_2_1_0_1_1__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_1_0_1_1__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_0_1_1__1"



	// $ANTLR start "rule__VariableString__Group_2_1_0_1_1__1__Impl"
	// InternalDsl.g:2456:1: rule__VariableString__Group_2_1_0_1_1__1__Impl : ( RULE_INT ) ;
	public final void rule__VariableString__Group_2_1_0_1_1__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2460:2: ( ( RULE_INT ) )
			// InternalDsl.g:2461:2: ( RULE_INT )
			{
			// InternalDsl.g:2461:2: ( RULE_INT )
			// InternalDsl.g:2462:2: RULE_INT
			{
			 before(grammarAccess.getVariableStringAccess().getINTTerminalRuleCall_2_1_0_1_1_1()); 
			match(input,RULE_INT,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getINTTerminalRuleCall_2_1_0_1_1_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_0_1_1__1__Impl"



	// $ANTLR start "rule__VariableString__Group_2_1_1__0"
	// InternalDsl.g:2472:1: rule__VariableString__Group_2_1_1__0 : rule__VariableString__Group_2_1_1__0__Impl rule__VariableString__Group_2_1_1__1 ;
	public final void rule__VariableString__Group_2_1_1__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2476:2: ( rule__VariableString__Group_2_1_1__0__Impl rule__VariableString__Group_2_1_1__1 )
			// InternalDsl.g:2477:2: rule__VariableString__Group_2_1_1__0__Impl rule__VariableString__Group_2_1_1__1
			{
			pushFollow(FOLLOW_29);
			rule__VariableString__Group_2_1_1__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_1_1__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_1__0"



	// $ANTLR start "rule__VariableString__Group_2_1_1__0__Impl"
	// InternalDsl.g:2484:1: rule__VariableString__Group_2_1_1__0__Impl : ( '.' ) ;
	public final void rule__VariableString__Group_2_1_1__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2488:2: ( ( '.' ) )
			// InternalDsl.g:2489:2: ( '.' )
			{
			// InternalDsl.g:2489:2: ( '.' )
			// InternalDsl.g:2490:2: '.'
			{
			 before(grammarAccess.getVariableStringAccess().getFullStopKeyword_2_1_1_0()); 
			match(input,21,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getFullStopKeyword_2_1_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_1__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_1_1__1"
	// InternalDsl.g:2499:1: rule__VariableString__Group_2_1_1__1 : rule__VariableString__Group_2_1_1__1__Impl ;
	public final void rule__VariableString__Group_2_1_1__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2503:2: ( rule__VariableString__Group_2_1_1__1__Impl )
			// InternalDsl.g:2504:2: rule__VariableString__Group_2_1_1__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_1_1__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_1__1"



	// $ANTLR start "rule__VariableString__Group_2_1_1__1__Impl"
	// InternalDsl.g:2510:1: rule__VariableString__Group_2_1_1__1__Impl : ( ruleVariableString ) ;
	public final void rule__VariableString__Group_2_1_1__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2514:2: ( ( ruleVariableString ) )
			// InternalDsl.g:2515:2: ( ruleVariableString )
			{
			// InternalDsl.g:2515:2: ( ruleVariableString )
			// InternalDsl.g:2516:2: ruleVariableString
			{
			 before(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_1_1_1()); 
			pushFollow(FOLLOW_2);
			ruleVariableString();
			state._fsp--;

			 after(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_1_1_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_1_1__1__Impl"



	// $ANTLR start "rule__VariableString__Group_2_2__0"
	// InternalDsl.g:2526:1: rule__VariableString__Group_2_2__0 : rule__VariableString__Group_2_2__0__Impl rule__VariableString__Group_2_2__1 ;
	public final void rule__VariableString__Group_2_2__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2530:2: ( rule__VariableString__Group_2_2__0__Impl rule__VariableString__Group_2_2__1 )
			// InternalDsl.g:2531:2: rule__VariableString__Group_2_2__0__Impl rule__VariableString__Group_2_2__1
			{
			pushFollow(FOLLOW_29);
			rule__VariableString__Group_2_2__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_2__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_2__0"



	// $ANTLR start "rule__VariableString__Group_2_2__0__Impl"
	// InternalDsl.g:2538:1: rule__VariableString__Group_2_2__0__Impl : ( '.' ) ;
	public final void rule__VariableString__Group_2_2__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2542:2: ( ( '.' ) )
			// InternalDsl.g:2543:2: ( '.' )
			{
			// InternalDsl.g:2543:2: ( '.' )
			// InternalDsl.g:2544:2: '.'
			{
			 before(grammarAccess.getVariableStringAccess().getFullStopKeyword_2_2_0()); 
			match(input,21,FOLLOW_2); 
			 after(grammarAccess.getVariableStringAccess().getFullStopKeyword_2_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_2__0__Impl"



	// $ANTLR start "rule__VariableString__Group_2_2__1"
	// InternalDsl.g:2553:1: rule__VariableString__Group_2_2__1 : rule__VariableString__Group_2_2__1__Impl ;
	public final void rule__VariableString__Group_2_2__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2557:2: ( rule__VariableString__Group_2_2__1__Impl )
			// InternalDsl.g:2558:2: rule__VariableString__Group_2_2__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__VariableString__Group_2_2__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_2__1"



	// $ANTLR start "rule__VariableString__Group_2_2__1__Impl"
	// InternalDsl.g:2564:1: rule__VariableString__Group_2_2__1__Impl : ( ruleVariableString ) ;
	public final void rule__VariableString__Group_2_2__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2568:2: ( ( ruleVariableString ) )
			// InternalDsl.g:2569:2: ( ruleVariableString )
			{
			// InternalDsl.g:2569:2: ( ruleVariableString )
			// InternalDsl.g:2570:2: ruleVariableString
			{
			 before(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_2_1()); 
			pushFollow(FOLLOW_2);
			ruleVariableString();
			state._fsp--;

			 after(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_2_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__VariableString__Group_2_2__1__Impl"



	// $ANTLR start "rule__AbstractStatement_Impl__Group__0"
	// InternalDsl.g:2580:1: rule__AbstractStatement_Impl__Group__0 : rule__AbstractStatement_Impl__Group__0__Impl rule__AbstractStatement_Impl__Group__1 ;
	public final void rule__AbstractStatement_Impl__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2584:2: ( rule__AbstractStatement_Impl__Group__0__Impl rule__AbstractStatement_Impl__Group__1 )
			// InternalDsl.g:2585:2: rule__AbstractStatement_Impl__Group__0__Impl rule__AbstractStatement_Impl__Group__1
			{
			pushFollow(FOLLOW_23);
			rule__AbstractStatement_Impl__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__AbstractStatement_Impl__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__AbstractStatement_Impl__Group__0"



	// $ANTLR start "rule__AbstractStatement_Impl__Group__0__Impl"
	// InternalDsl.g:2592:1: rule__AbstractStatement_Impl__Group__0__Impl : ( () ) ;
	public final void rule__AbstractStatement_Impl__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2596:2: ( ( () ) )
			// InternalDsl.g:2597:2: ( () )
			{
			// InternalDsl.g:2597:2: ( () )
			// InternalDsl.g:2598:2: ()
			{
			 before(grammarAccess.getAbstractStatement_ImplAccess().getAbstractStatementAction_0()); 
			// InternalDsl.g:2599:2: ()
			// InternalDsl.g:2599:3: 
			{
			}

			 after(grammarAccess.getAbstractStatement_ImplAccess().getAbstractStatementAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__AbstractStatement_Impl__Group__0__Impl"



	// $ANTLR start "rule__AbstractStatement_Impl__Group__1"
	// InternalDsl.g:2607:1: rule__AbstractStatement_Impl__Group__1 : rule__AbstractStatement_Impl__Group__1__Impl ;
	public final void rule__AbstractStatement_Impl__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2611:2: ( rule__AbstractStatement_Impl__Group__1__Impl )
			// InternalDsl.g:2612:2: rule__AbstractStatement_Impl__Group__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__AbstractStatement_Impl__Group__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__AbstractStatement_Impl__Group__1"



	// $ANTLR start "rule__AbstractStatement_Impl__Group__1__Impl"
	// InternalDsl.g:2618:1: rule__AbstractStatement_Impl__Group__1__Impl : ( ( rule__AbstractStatement_Impl__NameAssignment_1 ) ) ;
	public final void rule__AbstractStatement_Impl__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2622:2: ( ( ( rule__AbstractStatement_Impl__NameAssignment_1 ) ) )
			// InternalDsl.g:2623:2: ( ( rule__AbstractStatement_Impl__NameAssignment_1 ) )
			{
			// InternalDsl.g:2623:2: ( ( rule__AbstractStatement_Impl__NameAssignment_1 ) )
			// InternalDsl.g:2624:2: ( rule__AbstractStatement_Impl__NameAssignment_1 )
			{
			 before(grammarAccess.getAbstractStatement_ImplAccess().getNameAssignment_1()); 
			// InternalDsl.g:2625:2: ( rule__AbstractStatement_Impl__NameAssignment_1 )
			// InternalDsl.g:2625:3: rule__AbstractStatement_Impl__NameAssignment_1
			{
			pushFollow(FOLLOW_2);
			rule__AbstractStatement_Impl__NameAssignment_1();
			state._fsp--;

			}

			 after(grammarAccess.getAbstractStatement_ImplAccess().getNameAssignment_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__AbstractStatement_Impl__Group__1__Impl"



	// $ANTLR start "rule__MethodStatement__Group__0"
	// InternalDsl.g:2634:1: rule__MethodStatement__Group__0 : rule__MethodStatement__Group__0__Impl rule__MethodStatement__Group__1 ;
	public final void rule__MethodStatement__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2638:2: ( rule__MethodStatement__Group__0__Impl rule__MethodStatement__Group__1 )
			// InternalDsl.g:2639:2: rule__MethodStatement__Group__0__Impl rule__MethodStatement__Group__1
			{
			pushFollow(FOLLOW_4);
			rule__MethodStatement__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__MethodStatement__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__MethodStatement__Group__0"



	// $ANTLR start "rule__MethodStatement__Group__0__Impl"
	// InternalDsl.g:2646:1: rule__MethodStatement__Group__0__Impl : ( () ) ;
	public final void rule__MethodStatement__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2650:2: ( ( () ) )
			// InternalDsl.g:2651:2: ( () )
			{
			// InternalDsl.g:2651:2: ( () )
			// InternalDsl.g:2652:2: ()
			{
			 before(grammarAccess.getMethodStatementAccess().getMethodStatementAction_0()); 
			// InternalDsl.g:2653:2: ()
			// InternalDsl.g:2653:3: 
			{
			}

			 after(grammarAccess.getMethodStatementAccess().getMethodStatementAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__MethodStatement__Group__0__Impl"



	// $ANTLR start "rule__MethodStatement__Group__1"
	// InternalDsl.g:2661:1: rule__MethodStatement__Group__1 : rule__MethodStatement__Group__1__Impl ;
	public final void rule__MethodStatement__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2665:2: ( rule__MethodStatement__Group__1__Impl )
			// InternalDsl.g:2666:2: rule__MethodStatement__Group__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__MethodStatement__Group__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__MethodStatement__Group__1"



	// $ANTLR start "rule__MethodStatement__Group__1__Impl"
	// InternalDsl.g:2672:1: rule__MethodStatement__Group__1__Impl : ( ( rule__MethodStatement__NameAssignment_1 ) ) ;
	public final void rule__MethodStatement__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2676:2: ( ( ( rule__MethodStatement__NameAssignment_1 ) ) )
			// InternalDsl.g:2677:2: ( ( rule__MethodStatement__NameAssignment_1 ) )
			{
			// InternalDsl.g:2677:2: ( ( rule__MethodStatement__NameAssignment_1 ) )
			// InternalDsl.g:2678:2: ( rule__MethodStatement__NameAssignment_1 )
			{
			 before(grammarAccess.getMethodStatementAccess().getNameAssignment_1()); 
			// InternalDsl.g:2679:2: ( rule__MethodStatement__NameAssignment_1 )
			// InternalDsl.g:2679:3: rule__MethodStatement__NameAssignment_1
			{
			pushFollow(FOLLOW_2);
			rule__MethodStatement__NameAssignment_1();
			state._fsp--;

			}

			 after(grammarAccess.getMethodStatementAccess().getNameAssignment_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__MethodStatement__Group__1__Impl"



	// $ANTLR start "rule__ReturnStatement__Group__0"
	// InternalDsl.g:2688:1: rule__ReturnStatement__Group__0 : rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1 ;
	public final void rule__ReturnStatement__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2692:2: ( rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1 )
			// InternalDsl.g:2693:2: rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1
			{
			pushFollow(FOLLOW_31);
			rule__ReturnStatement__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__ReturnStatement__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__ReturnStatement__Group__0"



	// $ANTLR start "rule__ReturnStatement__Group__0__Impl"
	// InternalDsl.g:2700:1: rule__ReturnStatement__Group__0__Impl : ( () ) ;
	public final void rule__ReturnStatement__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2704:2: ( ( () ) )
			// InternalDsl.g:2705:2: ( () )
			{
			// InternalDsl.g:2705:2: ( () )
			// InternalDsl.g:2706:2: ()
			{
			 before(grammarAccess.getReturnStatementAccess().getReturnStatementAction_0()); 
			// InternalDsl.g:2707:2: ()
			// InternalDsl.g:2707:3: 
			{
			}

			 after(grammarAccess.getReturnStatementAccess().getReturnStatementAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__ReturnStatement__Group__0__Impl"



	// $ANTLR start "rule__ReturnStatement__Group__1"
	// InternalDsl.g:2715:1: rule__ReturnStatement__Group__1 : rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2 ;
	public final void rule__ReturnStatement__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2719:2: ( rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2 )
			// InternalDsl.g:2720:2: rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2
			{
			pushFollow(FOLLOW_23);
			rule__ReturnStatement__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__ReturnStatement__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__ReturnStatement__Group__1"



	// $ANTLR start "rule__ReturnStatement__Group__1__Impl"
	// InternalDsl.g:2727:1: rule__ReturnStatement__Group__1__Impl : ( 'return' ) ;
	public final void rule__ReturnStatement__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2731:2: ( ( 'return' ) )
			// InternalDsl.g:2732:2: ( 'return' )
			{
			// InternalDsl.g:2732:2: ( 'return' )
			// InternalDsl.g:2733:2: 'return'
			{
			 before(grammarAccess.getReturnStatementAccess().getReturnKeyword_1()); 
			match(input,49,FOLLOW_2); 
			 after(grammarAccess.getReturnStatementAccess().getReturnKeyword_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__ReturnStatement__Group__1__Impl"



	// $ANTLR start "rule__ReturnStatement__Group__2"
	// InternalDsl.g:2742:1: rule__ReturnStatement__Group__2 : rule__ReturnStatement__Group__2__Impl ;
	public final void rule__ReturnStatement__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2746:2: ( rule__ReturnStatement__Group__2__Impl )
			// InternalDsl.g:2747:2: rule__ReturnStatement__Group__2__Impl
			{
			pushFollow(FOLLOW_2);
			rule__ReturnStatement__Group__2__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__ReturnStatement__Group__2"



	// $ANTLR start "rule__ReturnStatement__Group__2__Impl"
	// InternalDsl.g:2753:1: rule__ReturnStatement__Group__2__Impl : ( ( rule__ReturnStatement__NameAssignment_2 ) ) ;
	public final void rule__ReturnStatement__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2757:2: ( ( ( rule__ReturnStatement__NameAssignment_2 ) ) )
			// InternalDsl.g:2758:2: ( ( rule__ReturnStatement__NameAssignment_2 ) )
			{
			// InternalDsl.g:2758:2: ( ( rule__ReturnStatement__NameAssignment_2 ) )
			// InternalDsl.g:2759:2: ( rule__ReturnStatement__NameAssignment_2 )
			{
			 before(grammarAccess.getReturnStatementAccess().getNameAssignment_2()); 
			// InternalDsl.g:2760:2: ( rule__ReturnStatement__NameAssignment_2 )
			// InternalDsl.g:2760:3: rule__ReturnStatement__NameAssignment_2
			{
			pushFollow(FOLLOW_2);
			rule__ReturnStatement__NameAssignment_2();
			state._fsp--;

			}

			 after(grammarAccess.getReturnStatementAccess().getNameAssignment_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__ReturnStatement__Group__2__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__0"
	// InternalDsl.g:2769:1: rule__StrengthWeakStatement__Group__0 : rule__StrengthWeakStatement__Group__0__Impl rule__StrengthWeakStatement__Group__1 ;
	public final void rule__StrengthWeakStatement__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2773:2: ( rule__StrengthWeakStatement__Group__0__Impl rule__StrengthWeakStatement__Group__1 )
			// InternalDsl.g:2774:2: rule__StrengthWeakStatement__Group__0__Impl rule__StrengthWeakStatement__Group__1
			{
			pushFollow(FOLLOW_5);
			rule__StrengthWeakStatement__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__0"



	// $ANTLR start "rule__StrengthWeakStatement__Group__0__Impl"
	// InternalDsl.g:2781:1: rule__StrengthWeakStatement__Group__0__Impl : ( () ) ;
	public final void rule__StrengthWeakStatement__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2785:2: ( ( () ) )
			// InternalDsl.g:2786:2: ( () )
			{
			// InternalDsl.g:2786:2: ( () )
			// InternalDsl.g:2787:2: ()
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getStrengthWeakStatementAction_0()); 
			// InternalDsl.g:2788:2: ()
			// InternalDsl.g:2788:3: 
			{
			}

			 after(grammarAccess.getStrengthWeakStatementAccess().getStrengthWeakStatementAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__0__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__1"
	// InternalDsl.g:2796:1: rule__StrengthWeakStatement__Group__1 : rule__StrengthWeakStatement__Group__1__Impl rule__StrengthWeakStatement__Group__2 ;
	public final void rule__StrengthWeakStatement__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2800:2: ( rule__StrengthWeakStatement__Group__1__Impl rule__StrengthWeakStatement__Group__2 )
			// InternalDsl.g:2801:2: rule__StrengthWeakStatement__Group__1__Impl rule__StrengthWeakStatement__Group__2
			{
			pushFollow(FOLLOW_6);
			rule__StrengthWeakStatement__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__1"



	// $ANTLR start "rule__StrengthWeakStatement__Group__1__Impl"
	// InternalDsl.g:2808:1: rule__StrengthWeakStatement__Group__1__Impl : ( 'pre:' ) ;
	public final void rule__StrengthWeakStatement__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2812:2: ( ( 'pre:' ) )
			// InternalDsl.g:2813:2: ( 'pre:' )
			{
			// InternalDsl.g:2813:2: ( 'pre:' )
			// InternalDsl.g:2814:2: 'pre:'
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getPreKeyword_1()); 
			match(input,47,FOLLOW_2); 
			 after(grammarAccess.getStrengthWeakStatementAccess().getPreKeyword_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__1__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__2"
	// InternalDsl.g:2823:1: rule__StrengthWeakStatement__Group__2 : rule__StrengthWeakStatement__Group__2__Impl rule__StrengthWeakStatement__Group__3 ;
	public final void rule__StrengthWeakStatement__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2827:2: ( rule__StrengthWeakStatement__Group__2__Impl rule__StrengthWeakStatement__Group__3 )
			// InternalDsl.g:2828:2: rule__StrengthWeakStatement__Group__2__Impl rule__StrengthWeakStatement__Group__3
			{
			pushFollow(FOLLOW_4);
			rule__StrengthWeakStatement__Group__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__2"



	// $ANTLR start "rule__StrengthWeakStatement__Group__2__Impl"
	// InternalDsl.g:2835:1: rule__StrengthWeakStatement__Group__2__Impl : ( '{' ) ;
	public final void rule__StrengthWeakStatement__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2839:2: ( ( '{' ) )
			// InternalDsl.g:2840:2: ( '{' )
			{
			// InternalDsl.g:2840:2: ( '{' )
			// InternalDsl.g:2841:2: '{'
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getLeftCurlyBracketKeyword_2()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getStrengthWeakStatementAccess().getLeftCurlyBracketKeyword_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__2__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__3"
	// InternalDsl.g:2850:1: rule__StrengthWeakStatement__Group__3 : rule__StrengthWeakStatement__Group__3__Impl rule__StrengthWeakStatement__Group__4 ;
	public final void rule__StrengthWeakStatement__Group__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2854:2: ( rule__StrengthWeakStatement__Group__3__Impl rule__StrengthWeakStatement__Group__4 )
			// InternalDsl.g:2855:2: rule__StrengthWeakStatement__Group__3__Impl rule__StrengthWeakStatement__Group__4
			{
			pushFollow(FOLLOW_7);
			rule__StrengthWeakStatement__Group__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__3"



	// $ANTLR start "rule__StrengthWeakStatement__Group__3__Impl"
	// InternalDsl.g:2862:1: rule__StrengthWeakStatement__Group__3__Impl : ( ( rule__StrengthWeakStatement__WeakPreConditionAssignment_3 ) ) ;
	public final void rule__StrengthWeakStatement__Group__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2866:2: ( ( ( rule__StrengthWeakStatement__WeakPreConditionAssignment_3 ) ) )
			// InternalDsl.g:2867:2: ( ( rule__StrengthWeakStatement__WeakPreConditionAssignment_3 ) )
			{
			// InternalDsl.g:2867:2: ( ( rule__StrengthWeakStatement__WeakPreConditionAssignment_3 ) )
			// InternalDsl.g:2868:2: ( rule__StrengthWeakStatement__WeakPreConditionAssignment_3 )
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getWeakPreConditionAssignment_3()); 
			// InternalDsl.g:2869:2: ( rule__StrengthWeakStatement__WeakPreConditionAssignment_3 )
			// InternalDsl.g:2869:3: rule__StrengthWeakStatement__WeakPreConditionAssignment_3
			{
			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__WeakPreConditionAssignment_3();
			state._fsp--;

			}

			 after(grammarAccess.getStrengthWeakStatementAccess().getWeakPreConditionAssignment_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__3__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__4"
	// InternalDsl.g:2877:1: rule__StrengthWeakStatement__Group__4 : rule__StrengthWeakStatement__Group__4__Impl rule__StrengthWeakStatement__Group__5 ;
	public final void rule__StrengthWeakStatement__Group__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2881:2: ( rule__StrengthWeakStatement__Group__4__Impl rule__StrengthWeakStatement__Group__5 )
			// InternalDsl.g:2882:2: rule__StrengthWeakStatement__Group__4__Impl rule__StrengthWeakStatement__Group__5
			{
			pushFollow(FOLLOW_6);
			rule__StrengthWeakStatement__Group__4__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__5();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__4"



	// $ANTLR start "rule__StrengthWeakStatement__Group__4__Impl"
	// InternalDsl.g:2889:1: rule__StrengthWeakStatement__Group__4__Impl : ( '}' ) ;
	public final void rule__StrengthWeakStatement__Group__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2893:2: ( ( '}' ) )
			// InternalDsl.g:2894:2: ( '}' )
			{
			// InternalDsl.g:2894:2: ( '}' )
			// InternalDsl.g:2895:2: '}'
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getRightCurlyBracketKeyword_4()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getStrengthWeakStatementAccess().getRightCurlyBracketKeyword_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__4__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__5"
	// InternalDsl.g:2904:1: rule__StrengthWeakStatement__Group__5 : rule__StrengthWeakStatement__Group__5__Impl rule__StrengthWeakStatement__Group__6 ;
	public final void rule__StrengthWeakStatement__Group__5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2908:2: ( rule__StrengthWeakStatement__Group__5__Impl rule__StrengthWeakStatement__Group__6 )
			// InternalDsl.g:2909:2: rule__StrengthWeakStatement__Group__5__Impl rule__StrengthWeakStatement__Group__6
			{
			pushFollow(FOLLOW_23);
			rule__StrengthWeakStatement__Group__5__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__6();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__5"



	// $ANTLR start "rule__StrengthWeakStatement__Group__5__Impl"
	// InternalDsl.g:2916:1: rule__StrengthWeakStatement__Group__5__Impl : ( '{' ) ;
	public final void rule__StrengthWeakStatement__Group__5__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2920:2: ( ( '{' ) )
			// InternalDsl.g:2921:2: ( '{' )
			{
			// InternalDsl.g:2921:2: ( '{' )
			// InternalDsl.g:2922:2: '{'
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getLeftCurlyBracketKeyword_5()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getStrengthWeakStatementAccess().getLeftCurlyBracketKeyword_5()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__5__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__6"
	// InternalDsl.g:2931:1: rule__StrengthWeakStatement__Group__6 : rule__StrengthWeakStatement__Group__6__Impl rule__StrengthWeakStatement__Group__7 ;
	public final void rule__StrengthWeakStatement__Group__6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2935:2: ( rule__StrengthWeakStatement__Group__6__Impl rule__StrengthWeakStatement__Group__7 )
			// InternalDsl.g:2936:2: rule__StrengthWeakStatement__Group__6__Impl rule__StrengthWeakStatement__Group__7
			{
			pushFollow(FOLLOW_7);
			rule__StrengthWeakStatement__Group__6__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__7();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__6"



	// $ANTLR start "rule__StrengthWeakStatement__Group__6__Impl"
	// InternalDsl.g:2943:1: rule__StrengthWeakStatement__Group__6__Impl : ( ( rule__StrengthWeakStatement__NameAssignment_6 ) ) ;
	public final void rule__StrengthWeakStatement__Group__6__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2947:2: ( ( ( rule__StrengthWeakStatement__NameAssignment_6 ) ) )
			// InternalDsl.g:2948:2: ( ( rule__StrengthWeakStatement__NameAssignment_6 ) )
			{
			// InternalDsl.g:2948:2: ( ( rule__StrengthWeakStatement__NameAssignment_6 ) )
			// InternalDsl.g:2949:2: ( rule__StrengthWeakStatement__NameAssignment_6 )
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getNameAssignment_6()); 
			// InternalDsl.g:2950:2: ( rule__StrengthWeakStatement__NameAssignment_6 )
			// InternalDsl.g:2950:3: rule__StrengthWeakStatement__NameAssignment_6
			{
			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__NameAssignment_6();
			state._fsp--;

			}

			 after(grammarAccess.getStrengthWeakStatementAccess().getNameAssignment_6()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__6__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__7"
	// InternalDsl.g:2958:1: rule__StrengthWeakStatement__Group__7 : rule__StrengthWeakStatement__Group__7__Impl rule__StrengthWeakStatement__Group__8 ;
	public final void rule__StrengthWeakStatement__Group__7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2962:2: ( rule__StrengthWeakStatement__Group__7__Impl rule__StrengthWeakStatement__Group__8 )
			// InternalDsl.g:2963:2: rule__StrengthWeakStatement__Group__7__Impl rule__StrengthWeakStatement__Group__8
			{
			pushFollow(FOLLOW_9);
			rule__StrengthWeakStatement__Group__7__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__8();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__7"



	// $ANTLR start "rule__StrengthWeakStatement__Group__7__Impl"
	// InternalDsl.g:2970:1: rule__StrengthWeakStatement__Group__7__Impl : ( '}' ) ;
	public final void rule__StrengthWeakStatement__Group__7__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2974:2: ( ( '}' ) )
			// InternalDsl.g:2975:2: ( '}' )
			{
			// InternalDsl.g:2975:2: ( '}' )
			// InternalDsl.g:2976:2: '}'
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getRightCurlyBracketKeyword_7()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getStrengthWeakStatementAccess().getRightCurlyBracketKeyword_7()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__7__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__8"
	// InternalDsl.g:2985:1: rule__StrengthWeakStatement__Group__8 : rule__StrengthWeakStatement__Group__8__Impl rule__StrengthWeakStatement__Group__9 ;
	public final void rule__StrengthWeakStatement__Group__8() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:2989:2: ( rule__StrengthWeakStatement__Group__8__Impl rule__StrengthWeakStatement__Group__9 )
			// InternalDsl.g:2990:2: rule__StrengthWeakStatement__Group__8__Impl rule__StrengthWeakStatement__Group__9
			{
			pushFollow(FOLLOW_6);
			rule__StrengthWeakStatement__Group__8__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__9();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__8"



	// $ANTLR start "rule__StrengthWeakStatement__Group__8__Impl"
	// InternalDsl.g:2997:1: rule__StrengthWeakStatement__Group__8__Impl : ( 'post:' ) ;
	public final void rule__StrengthWeakStatement__Group__8__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3001:2: ( ( 'post:' ) )
			// InternalDsl.g:3002:2: ( 'post:' )
			{
			// InternalDsl.g:3002:2: ( 'post:' )
			// InternalDsl.g:3003:2: 'post:'
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getPostKeyword_8()); 
			match(input,46,FOLLOW_2); 
			 after(grammarAccess.getStrengthWeakStatementAccess().getPostKeyword_8()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__8__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__9"
	// InternalDsl.g:3012:1: rule__StrengthWeakStatement__Group__9 : rule__StrengthWeakStatement__Group__9__Impl rule__StrengthWeakStatement__Group__10 ;
	public final void rule__StrengthWeakStatement__Group__9() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3016:2: ( rule__StrengthWeakStatement__Group__9__Impl rule__StrengthWeakStatement__Group__10 )
			// InternalDsl.g:3017:2: rule__StrengthWeakStatement__Group__9__Impl rule__StrengthWeakStatement__Group__10
			{
			pushFollow(FOLLOW_4);
			rule__StrengthWeakStatement__Group__9__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__10();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__9"



	// $ANTLR start "rule__StrengthWeakStatement__Group__9__Impl"
	// InternalDsl.g:3024:1: rule__StrengthWeakStatement__Group__9__Impl : ( '{' ) ;
	public final void rule__StrengthWeakStatement__Group__9__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3028:2: ( ( '{' ) )
			// InternalDsl.g:3029:2: ( '{' )
			{
			// InternalDsl.g:3029:2: ( '{' )
			// InternalDsl.g:3030:2: '{'
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getLeftCurlyBracketKeyword_9()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getStrengthWeakStatementAccess().getLeftCurlyBracketKeyword_9()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__9__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__10"
	// InternalDsl.g:3039:1: rule__StrengthWeakStatement__Group__10 : rule__StrengthWeakStatement__Group__10__Impl rule__StrengthWeakStatement__Group__11 ;
	public final void rule__StrengthWeakStatement__Group__10() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3043:2: ( rule__StrengthWeakStatement__Group__10__Impl rule__StrengthWeakStatement__Group__11 )
			// InternalDsl.g:3044:2: rule__StrengthWeakStatement__Group__10__Impl rule__StrengthWeakStatement__Group__11
			{
			pushFollow(FOLLOW_7);
			rule__StrengthWeakStatement__Group__10__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__11();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__10"



	// $ANTLR start "rule__StrengthWeakStatement__Group__10__Impl"
	// InternalDsl.g:3051:1: rule__StrengthWeakStatement__Group__10__Impl : ( ( rule__StrengthWeakStatement__StrongPostConditionAssignment_10 ) ) ;
	public final void rule__StrengthWeakStatement__Group__10__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3055:2: ( ( ( rule__StrengthWeakStatement__StrongPostConditionAssignment_10 ) ) )
			// InternalDsl.g:3056:2: ( ( rule__StrengthWeakStatement__StrongPostConditionAssignment_10 ) )
			{
			// InternalDsl.g:3056:2: ( ( rule__StrengthWeakStatement__StrongPostConditionAssignment_10 ) )
			// InternalDsl.g:3057:2: ( rule__StrengthWeakStatement__StrongPostConditionAssignment_10 )
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getStrongPostConditionAssignment_10()); 
			// InternalDsl.g:3058:2: ( rule__StrengthWeakStatement__StrongPostConditionAssignment_10 )
			// InternalDsl.g:3058:3: rule__StrengthWeakStatement__StrongPostConditionAssignment_10
			{
			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__StrongPostConditionAssignment_10();
			state._fsp--;

			}

			 after(grammarAccess.getStrengthWeakStatementAccess().getStrongPostConditionAssignment_10()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__10__Impl"



	// $ANTLR start "rule__StrengthWeakStatement__Group__11"
	// InternalDsl.g:3066:1: rule__StrengthWeakStatement__Group__11 : rule__StrengthWeakStatement__Group__11__Impl ;
	public final void rule__StrengthWeakStatement__Group__11() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3070:2: ( rule__StrengthWeakStatement__Group__11__Impl )
			// InternalDsl.g:3071:2: rule__StrengthWeakStatement__Group__11__Impl
			{
			pushFollow(FOLLOW_2);
			rule__StrengthWeakStatement__Group__11__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__11"



	// $ANTLR start "rule__StrengthWeakStatement__Group__11__Impl"
	// InternalDsl.g:3077:1: rule__StrengthWeakStatement__Group__11__Impl : ( '}' ) ;
	public final void rule__StrengthWeakStatement__Group__11__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3081:2: ( ( '}' ) )
			// InternalDsl.g:3082:2: ( '}' )
			{
			// InternalDsl.g:3082:2: ( '}' )
			// InternalDsl.g:3083:2: '}'
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getRightCurlyBracketKeyword_11()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getStrengthWeakStatementAccess().getRightCurlyBracketKeyword_11()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__Group__11__Impl"



	// $ANTLR start "rule__Condition__Group__0"
	// InternalDsl.g:3093:1: rule__Condition__Group__0 : rule__Condition__Group__0__Impl rule__Condition__Group__1 ;
	public final void rule__Condition__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3097:2: ( rule__Condition__Group__0__Impl rule__Condition__Group__1 )
			// InternalDsl.g:3098:2: rule__Condition__Group__0__Impl rule__Condition__Group__1
			{
			pushFollow(FOLLOW_4);
			rule__Condition__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Condition__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Condition__Group__0"



	// $ANTLR start "rule__Condition__Group__0__Impl"
	// InternalDsl.g:3105:1: rule__Condition__Group__0__Impl : ( () ) ;
	public final void rule__Condition__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3109:2: ( ( () ) )
			// InternalDsl.g:3110:2: ( () )
			{
			// InternalDsl.g:3110:2: ( () )
			// InternalDsl.g:3111:2: ()
			{
			 before(grammarAccess.getConditionAccess().getConditionAction_0()); 
			// InternalDsl.g:3112:2: ()
			// InternalDsl.g:3112:3: 
			{
			}

			 after(grammarAccess.getConditionAccess().getConditionAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Condition__Group__0__Impl"



	// $ANTLR start "rule__Condition__Group__1"
	// InternalDsl.g:3120:1: rule__Condition__Group__1 : rule__Condition__Group__1__Impl ;
	public final void rule__Condition__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3124:2: ( rule__Condition__Group__1__Impl )
			// InternalDsl.g:3125:2: rule__Condition__Group__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__Condition__Group__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Condition__Group__1"



	// $ANTLR start "rule__Condition__Group__1__Impl"
	// InternalDsl.g:3131:1: rule__Condition__Group__1__Impl : ( ( rule__Condition__NameAssignment_1 ) ) ;
	public final void rule__Condition__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3135:2: ( ( ( rule__Condition__NameAssignment_1 ) ) )
			// InternalDsl.g:3136:2: ( ( rule__Condition__NameAssignment_1 ) )
			{
			// InternalDsl.g:3136:2: ( ( rule__Condition__NameAssignment_1 ) )
			// InternalDsl.g:3137:2: ( rule__Condition__NameAssignment_1 )
			{
			 before(grammarAccess.getConditionAccess().getNameAssignment_1()); 
			// InternalDsl.g:3138:2: ( rule__Condition__NameAssignment_1 )
			// InternalDsl.g:3138:3: rule__Condition__NameAssignment_1
			{
			pushFollow(FOLLOW_2);
			rule__Condition__NameAssignment_1();
			state._fsp--;

			}

			 after(grammarAccess.getConditionAccess().getNameAssignment_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Condition__Group__1__Impl"



	// $ANTLR start "rule__CompositionStatement__Group__0"
	// InternalDsl.g:3147:1: rule__CompositionStatement__Group__0 : rule__CompositionStatement__Group__0__Impl rule__CompositionStatement__Group__1 ;
	public final void rule__CompositionStatement__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3151:2: ( rule__CompositionStatement__Group__0__Impl rule__CompositionStatement__Group__1 )
			// InternalDsl.g:3152:2: rule__CompositionStatement__Group__0__Impl rule__CompositionStatement__Group__1
			{
			pushFollow(FOLLOW_6);
			rule__CompositionStatement__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__0"



	// $ANTLR start "rule__CompositionStatement__Group__0__Impl"
	// InternalDsl.g:3159:1: rule__CompositionStatement__Group__0__Impl : ( () ) ;
	public final void rule__CompositionStatement__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3163:2: ( ( () ) )
			// InternalDsl.g:3164:2: ( () )
			{
			// InternalDsl.g:3164:2: ( () )
			// InternalDsl.g:3165:2: ()
			{
			 before(grammarAccess.getCompositionStatementAccess().getCompositionStatementAction_0()); 
			// InternalDsl.g:3166:2: ()
			// InternalDsl.g:3166:3: 
			{
			}

			 after(grammarAccess.getCompositionStatementAccess().getCompositionStatementAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__0__Impl"



	// $ANTLR start "rule__CompositionStatement__Group__1"
	// InternalDsl.g:3174:1: rule__CompositionStatement__Group__1 : rule__CompositionStatement__Group__1__Impl rule__CompositionStatement__Group__2 ;
	public final void rule__CompositionStatement__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3178:2: ( rule__CompositionStatement__Group__1__Impl rule__CompositionStatement__Group__2 )
			// InternalDsl.g:3179:2: rule__CompositionStatement__Group__1__Impl rule__CompositionStatement__Group__2
			{
			pushFollow(FOLLOW_8);
			rule__CompositionStatement__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__1"



	// $ANTLR start "rule__CompositionStatement__Group__1__Impl"
	// InternalDsl.g:3186:1: rule__CompositionStatement__Group__1__Impl : ( '{' ) ;
	public final void rule__CompositionStatement__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3190:2: ( ( '{' ) )
			// InternalDsl.g:3191:2: ( '{' )
			{
			// InternalDsl.g:3191:2: ( '{' )
			// InternalDsl.g:3192:2: '{'
			{
			 before(grammarAccess.getCompositionStatementAccess().getLeftCurlyBracketKeyword_1()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getCompositionStatementAccess().getLeftCurlyBracketKeyword_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__1__Impl"



	// $ANTLR start "rule__CompositionStatement__Group__2"
	// InternalDsl.g:3201:1: rule__CompositionStatement__Group__2 : rule__CompositionStatement__Group__2__Impl rule__CompositionStatement__Group__3 ;
	public final void rule__CompositionStatement__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3205:2: ( rule__CompositionStatement__Group__2__Impl rule__CompositionStatement__Group__3 )
			// InternalDsl.g:3206:2: rule__CompositionStatement__Group__2__Impl rule__CompositionStatement__Group__3
			{
			pushFollow(FOLLOW_7);
			rule__CompositionStatement__Group__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__2"



	// $ANTLR start "rule__CompositionStatement__Group__2__Impl"
	// InternalDsl.g:3213:1: rule__CompositionStatement__Group__2__Impl : ( ( rule__CompositionStatement__FirstStatementAssignment_2 ) ) ;
	public final void rule__CompositionStatement__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3217:2: ( ( ( rule__CompositionStatement__FirstStatementAssignment_2 ) ) )
			// InternalDsl.g:3218:2: ( ( rule__CompositionStatement__FirstStatementAssignment_2 ) )
			{
			// InternalDsl.g:3218:2: ( ( rule__CompositionStatement__FirstStatementAssignment_2 ) )
			// InternalDsl.g:3219:2: ( rule__CompositionStatement__FirstStatementAssignment_2 )
			{
			 before(grammarAccess.getCompositionStatementAccess().getFirstStatementAssignment_2()); 
			// InternalDsl.g:3220:2: ( rule__CompositionStatement__FirstStatementAssignment_2 )
			// InternalDsl.g:3220:3: rule__CompositionStatement__FirstStatementAssignment_2
			{
			pushFollow(FOLLOW_2);
			rule__CompositionStatement__FirstStatementAssignment_2();
			state._fsp--;

			}

			 after(grammarAccess.getCompositionStatementAccess().getFirstStatementAssignment_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__2__Impl"



	// $ANTLR start "rule__CompositionStatement__Group__3"
	// InternalDsl.g:3228:1: rule__CompositionStatement__Group__3 : rule__CompositionStatement__Group__3__Impl rule__CompositionStatement__Group__4 ;
	public final void rule__CompositionStatement__Group__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3232:2: ( rule__CompositionStatement__Group__3__Impl rule__CompositionStatement__Group__4 )
			// InternalDsl.g:3233:2: rule__CompositionStatement__Group__3__Impl rule__CompositionStatement__Group__4
			{
			pushFollow(FOLLOW_32);
			rule__CompositionStatement__Group__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__3"



	// $ANTLR start "rule__CompositionStatement__Group__3__Impl"
	// InternalDsl.g:3240:1: rule__CompositionStatement__Group__3__Impl : ( '}' ) ;
	public final void rule__CompositionStatement__Group__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3244:2: ( ( '}' ) )
			// InternalDsl.g:3245:2: ( '}' )
			{
			// InternalDsl.g:3245:2: ( '}' )
			// InternalDsl.g:3246:2: '}'
			{
			 before(grammarAccess.getCompositionStatementAccess().getRightCurlyBracketKeyword_3()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getCompositionStatementAccess().getRightCurlyBracketKeyword_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__3__Impl"



	// $ANTLR start "rule__CompositionStatement__Group__4"
	// InternalDsl.g:3255:1: rule__CompositionStatement__Group__4 : rule__CompositionStatement__Group__4__Impl rule__CompositionStatement__Group__5 ;
	public final void rule__CompositionStatement__Group__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3259:2: ( rule__CompositionStatement__Group__4__Impl rule__CompositionStatement__Group__5 )
			// InternalDsl.g:3260:2: rule__CompositionStatement__Group__4__Impl rule__CompositionStatement__Group__5
			{
			pushFollow(FOLLOW_33);
			rule__CompositionStatement__Group__4__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__5();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__4"



	// $ANTLR start "rule__CompositionStatement__Group__4__Impl"
	// InternalDsl.g:3267:1: rule__CompositionStatement__Group__4__Impl : ( 'intm:' ) ;
	public final void rule__CompositionStatement__Group__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3271:2: ( ( 'intm:' ) )
			// InternalDsl.g:3272:2: ( 'intm:' )
			{
			// InternalDsl.g:3272:2: ( 'intm:' )
			// InternalDsl.g:3273:2: 'intm:'
			{
			 before(grammarAccess.getCompositionStatementAccess().getIntmKeyword_4()); 
			match(input,42,FOLLOW_2); 
			 after(grammarAccess.getCompositionStatementAccess().getIntmKeyword_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__4__Impl"



	// $ANTLR start "rule__CompositionStatement__Group__5"
	// InternalDsl.g:3282:1: rule__CompositionStatement__Group__5 : rule__CompositionStatement__Group__5__Impl rule__CompositionStatement__Group__6 ;
	public final void rule__CompositionStatement__Group__5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3286:2: ( rule__CompositionStatement__Group__5__Impl rule__CompositionStatement__Group__6 )
			// InternalDsl.g:3287:2: rule__CompositionStatement__Group__5__Impl rule__CompositionStatement__Group__6
			{
			pushFollow(FOLLOW_4);
			rule__CompositionStatement__Group__5__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__6();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__5"



	// $ANTLR start "rule__CompositionStatement__Group__5__Impl"
	// InternalDsl.g:3294:1: rule__CompositionStatement__Group__5__Impl : ( '[' ) ;
	public final void rule__CompositionStatement__Group__5__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3298:2: ( ( '[' ) )
			// InternalDsl.g:3299:2: ( '[' )
			{
			// InternalDsl.g:3299:2: ( '[' )
			// InternalDsl.g:3300:2: '['
			{
			 before(grammarAccess.getCompositionStatementAccess().getLeftSquareBracketKeyword_5()); 
			match(input,34,FOLLOW_2); 
			 after(grammarAccess.getCompositionStatementAccess().getLeftSquareBracketKeyword_5()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__5__Impl"



	// $ANTLR start "rule__CompositionStatement__Group__6"
	// InternalDsl.g:3309:1: rule__CompositionStatement__Group__6 : rule__CompositionStatement__Group__6__Impl rule__CompositionStatement__Group__7 ;
	public final void rule__CompositionStatement__Group__6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3313:2: ( rule__CompositionStatement__Group__6__Impl rule__CompositionStatement__Group__7 )
			// InternalDsl.g:3314:2: rule__CompositionStatement__Group__6__Impl rule__CompositionStatement__Group__7
			{
			pushFollow(FOLLOW_18);
			rule__CompositionStatement__Group__6__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__7();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__6"



	// $ANTLR start "rule__CompositionStatement__Group__6__Impl"
	// InternalDsl.g:3321:1: rule__CompositionStatement__Group__6__Impl : ( ( rule__CompositionStatement__IntermediateConditionAssignment_6 ) ) ;
	public final void rule__CompositionStatement__Group__6__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3325:2: ( ( ( rule__CompositionStatement__IntermediateConditionAssignment_6 ) ) )
			// InternalDsl.g:3326:2: ( ( rule__CompositionStatement__IntermediateConditionAssignment_6 ) )
			{
			// InternalDsl.g:3326:2: ( ( rule__CompositionStatement__IntermediateConditionAssignment_6 ) )
			// InternalDsl.g:3327:2: ( rule__CompositionStatement__IntermediateConditionAssignment_6 )
			{
			 before(grammarAccess.getCompositionStatementAccess().getIntermediateConditionAssignment_6()); 
			// InternalDsl.g:3328:2: ( rule__CompositionStatement__IntermediateConditionAssignment_6 )
			// InternalDsl.g:3328:3: rule__CompositionStatement__IntermediateConditionAssignment_6
			{
			pushFollow(FOLLOW_2);
			rule__CompositionStatement__IntermediateConditionAssignment_6();
			state._fsp--;

			}

			 after(grammarAccess.getCompositionStatementAccess().getIntermediateConditionAssignment_6()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__6__Impl"



	// $ANTLR start "rule__CompositionStatement__Group__7"
	// InternalDsl.g:3336:1: rule__CompositionStatement__Group__7 : rule__CompositionStatement__Group__7__Impl rule__CompositionStatement__Group__8 ;
	public final void rule__CompositionStatement__Group__7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3340:2: ( rule__CompositionStatement__Group__7__Impl rule__CompositionStatement__Group__8 )
			// InternalDsl.g:3341:2: rule__CompositionStatement__Group__7__Impl rule__CompositionStatement__Group__8
			{
			pushFollow(FOLLOW_6);
			rule__CompositionStatement__Group__7__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__8();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__7"



	// $ANTLR start "rule__CompositionStatement__Group__7__Impl"
	// InternalDsl.g:3348:1: rule__CompositionStatement__Group__7__Impl : ( ']' ) ;
	public final void rule__CompositionStatement__Group__7__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3352:2: ( ( ']' ) )
			// InternalDsl.g:3353:2: ( ']' )
			{
			// InternalDsl.g:3353:2: ( ']' )
			// InternalDsl.g:3354:2: ']'
			{
			 before(grammarAccess.getCompositionStatementAccess().getRightSquareBracketKeyword_7()); 
			match(input,35,FOLLOW_2); 
			 after(grammarAccess.getCompositionStatementAccess().getRightSquareBracketKeyword_7()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__7__Impl"



	// $ANTLR start "rule__CompositionStatement__Group__8"
	// InternalDsl.g:3363:1: rule__CompositionStatement__Group__8 : rule__CompositionStatement__Group__8__Impl rule__CompositionStatement__Group__9 ;
	public final void rule__CompositionStatement__Group__8() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3367:2: ( rule__CompositionStatement__Group__8__Impl rule__CompositionStatement__Group__9 )
			// InternalDsl.g:3368:2: rule__CompositionStatement__Group__8__Impl rule__CompositionStatement__Group__9
			{
			pushFollow(FOLLOW_8);
			rule__CompositionStatement__Group__8__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__9();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__8"



	// $ANTLR start "rule__CompositionStatement__Group__8__Impl"
	// InternalDsl.g:3375:1: rule__CompositionStatement__Group__8__Impl : ( '{' ) ;
	public final void rule__CompositionStatement__Group__8__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3379:2: ( ( '{' ) )
			// InternalDsl.g:3380:2: ( '{' )
			{
			// InternalDsl.g:3380:2: ( '{' )
			// InternalDsl.g:3381:2: '{'
			{
			 before(grammarAccess.getCompositionStatementAccess().getLeftCurlyBracketKeyword_8()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getCompositionStatementAccess().getLeftCurlyBracketKeyword_8()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__8__Impl"



	// $ANTLR start "rule__CompositionStatement__Group__9"
	// InternalDsl.g:3390:1: rule__CompositionStatement__Group__9 : rule__CompositionStatement__Group__9__Impl rule__CompositionStatement__Group__10 ;
	public final void rule__CompositionStatement__Group__9() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3394:2: ( rule__CompositionStatement__Group__9__Impl rule__CompositionStatement__Group__10 )
			// InternalDsl.g:3395:2: rule__CompositionStatement__Group__9__Impl rule__CompositionStatement__Group__10
			{
			pushFollow(FOLLOW_7);
			rule__CompositionStatement__Group__9__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__10();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__9"



	// $ANTLR start "rule__CompositionStatement__Group__9__Impl"
	// InternalDsl.g:3402:1: rule__CompositionStatement__Group__9__Impl : ( ( rule__CompositionStatement__SecondStatementAssignment_9 ) ) ;
	public final void rule__CompositionStatement__Group__9__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3406:2: ( ( ( rule__CompositionStatement__SecondStatementAssignment_9 ) ) )
			// InternalDsl.g:3407:2: ( ( rule__CompositionStatement__SecondStatementAssignment_9 ) )
			{
			// InternalDsl.g:3407:2: ( ( rule__CompositionStatement__SecondStatementAssignment_9 ) )
			// InternalDsl.g:3408:2: ( rule__CompositionStatement__SecondStatementAssignment_9 )
			{
			 before(grammarAccess.getCompositionStatementAccess().getSecondStatementAssignment_9()); 
			// InternalDsl.g:3409:2: ( rule__CompositionStatement__SecondStatementAssignment_9 )
			// InternalDsl.g:3409:3: rule__CompositionStatement__SecondStatementAssignment_9
			{
			pushFollow(FOLLOW_2);
			rule__CompositionStatement__SecondStatementAssignment_9();
			state._fsp--;

			}

			 after(grammarAccess.getCompositionStatementAccess().getSecondStatementAssignment_9()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__9__Impl"



	// $ANTLR start "rule__CompositionStatement__Group__10"
	// InternalDsl.g:3417:1: rule__CompositionStatement__Group__10 : rule__CompositionStatement__Group__10__Impl ;
	public final void rule__CompositionStatement__Group__10() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3421:2: ( rule__CompositionStatement__Group__10__Impl )
			// InternalDsl.g:3422:2: rule__CompositionStatement__Group__10__Impl
			{
			pushFollow(FOLLOW_2);
			rule__CompositionStatement__Group__10__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__10"



	// $ANTLR start "rule__CompositionStatement__Group__10__Impl"
	// InternalDsl.g:3428:1: rule__CompositionStatement__Group__10__Impl : ( '}' ) ;
	public final void rule__CompositionStatement__Group__10__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3432:2: ( ( '}' ) )
			// InternalDsl.g:3433:2: ( '}' )
			{
			// InternalDsl.g:3433:2: ( '}' )
			// InternalDsl.g:3434:2: '}'
			{
			 before(grammarAccess.getCompositionStatementAccess().getRightCurlyBracketKeyword_10()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getCompositionStatementAccess().getRightCurlyBracketKeyword_10()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__Group__10__Impl"



	// $ANTLR start "rule__JMLAnnotation__Group__0"
	// InternalDsl.g:3444:1: rule__JMLAnnotation__Group__0 : rule__JMLAnnotation__Group__0__Impl rule__JMLAnnotation__Group__1 ;
	public final void rule__JMLAnnotation__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3448:2: ( rule__JMLAnnotation__Group__0__Impl rule__JMLAnnotation__Group__1 )
			// InternalDsl.g:3449:2: rule__JMLAnnotation__Group__0__Impl rule__JMLAnnotation__Group__1
			{
			pushFollow(FOLLOW_4);
			rule__JMLAnnotation__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__0"



	// $ANTLR start "rule__JMLAnnotation__Group__0__Impl"
	// InternalDsl.g:3456:1: rule__JMLAnnotation__Group__0__Impl : ( '@1' ) ;
	public final void rule__JMLAnnotation__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3460:2: ( ( '@1' ) )
			// InternalDsl.g:3461:2: ( '@1' )
			{
			// InternalDsl.g:3461:2: ( '@1' )
			// InternalDsl.g:3462:2: '@1'
			{
			 before(grammarAccess.getJMLAnnotationAccess().getCommercialAtDigitOneKeyword_0()); 
			match(input,26,FOLLOW_2); 
			 after(grammarAccess.getJMLAnnotationAccess().getCommercialAtDigitOneKeyword_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__0__Impl"



	// $ANTLR start "rule__JMLAnnotation__Group__1"
	// InternalDsl.g:3471:1: rule__JMLAnnotation__Group__1 : rule__JMLAnnotation__Group__1__Impl rule__JMLAnnotation__Group__2 ;
	public final void rule__JMLAnnotation__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3475:2: ( rule__JMLAnnotation__Group__1__Impl rule__JMLAnnotation__Group__2 )
			// InternalDsl.g:3476:2: rule__JMLAnnotation__Group__1__Impl rule__JMLAnnotation__Group__2
			{
			pushFollow(FOLLOW_34);
			rule__JMLAnnotation__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__1"



	// $ANTLR start "rule__JMLAnnotation__Group__1__Impl"
	// InternalDsl.g:3483:1: rule__JMLAnnotation__Group__1__Impl : ( ( rule__JMLAnnotation__RequiresAssignment_1 ) ) ;
	public final void rule__JMLAnnotation__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3487:2: ( ( ( rule__JMLAnnotation__RequiresAssignment_1 ) ) )
			// InternalDsl.g:3488:2: ( ( rule__JMLAnnotation__RequiresAssignment_1 ) )
			{
			// InternalDsl.g:3488:2: ( ( rule__JMLAnnotation__RequiresAssignment_1 ) )
			// InternalDsl.g:3489:2: ( rule__JMLAnnotation__RequiresAssignment_1 )
			{
			 before(grammarAccess.getJMLAnnotationAccess().getRequiresAssignment_1()); 
			// InternalDsl.g:3490:2: ( rule__JMLAnnotation__RequiresAssignment_1 )
			// InternalDsl.g:3490:3: rule__JMLAnnotation__RequiresAssignment_1
			{
			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__RequiresAssignment_1();
			state._fsp--;

			}

			 after(grammarAccess.getJMLAnnotationAccess().getRequiresAssignment_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__1__Impl"



	// $ANTLR start "rule__JMLAnnotation__Group__2"
	// InternalDsl.g:3498:1: rule__JMLAnnotation__Group__2 : rule__JMLAnnotation__Group__2__Impl rule__JMLAnnotation__Group__3 ;
	public final void rule__JMLAnnotation__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3502:2: ( rule__JMLAnnotation__Group__2__Impl rule__JMLAnnotation__Group__3 )
			// InternalDsl.g:3503:2: rule__JMLAnnotation__Group__2__Impl rule__JMLAnnotation__Group__3
			{
			pushFollow(FOLLOW_35);
			rule__JMLAnnotation__Group__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__Group__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__2"



	// $ANTLR start "rule__JMLAnnotation__Group__2__Impl"
	// InternalDsl.g:3510:1: rule__JMLAnnotation__Group__2__Impl : ( '$1' ) ;
	public final void rule__JMLAnnotation__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3514:2: ( ( '$1' ) )
			// InternalDsl.g:3515:2: ( '$1' )
			{
			// InternalDsl.g:3515:2: ( '$1' )
			// InternalDsl.g:3516:2: '$1'
			{
			 before(grammarAccess.getJMLAnnotationAccess().getDollarSignDigitOneKeyword_2()); 
			match(input,11,FOLLOW_2); 
			 after(grammarAccess.getJMLAnnotationAccess().getDollarSignDigitOneKeyword_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__2__Impl"



	// $ANTLR start "rule__JMLAnnotation__Group__3"
	// InternalDsl.g:3525:1: rule__JMLAnnotation__Group__3 : rule__JMLAnnotation__Group__3__Impl rule__JMLAnnotation__Group__4 ;
	public final void rule__JMLAnnotation__Group__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3529:2: ( rule__JMLAnnotation__Group__3__Impl rule__JMLAnnotation__Group__4 )
			// InternalDsl.g:3530:2: rule__JMLAnnotation__Group__3__Impl rule__JMLAnnotation__Group__4
			{
			pushFollow(FOLLOW_4);
			rule__JMLAnnotation__Group__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__Group__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__3"



	// $ANTLR start "rule__JMLAnnotation__Group__3__Impl"
	// InternalDsl.g:3537:1: rule__JMLAnnotation__Group__3__Impl : ( '@2' ) ;
	public final void rule__JMLAnnotation__Group__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3541:2: ( ( '@2' ) )
			// InternalDsl.g:3542:2: ( '@2' )
			{
			// InternalDsl.g:3542:2: ( '@2' )
			// InternalDsl.g:3543:2: '@2'
			{
			 before(grammarAccess.getJMLAnnotationAccess().getCommercialAtDigitTwoKeyword_3()); 
			match(input,27,FOLLOW_2); 
			 after(grammarAccess.getJMLAnnotationAccess().getCommercialAtDigitTwoKeyword_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__3__Impl"



	// $ANTLR start "rule__JMLAnnotation__Group__4"
	// InternalDsl.g:3552:1: rule__JMLAnnotation__Group__4 : rule__JMLAnnotation__Group__4__Impl rule__JMLAnnotation__Group__5 ;
	public final void rule__JMLAnnotation__Group__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3556:2: ( rule__JMLAnnotation__Group__4__Impl rule__JMLAnnotation__Group__5 )
			// InternalDsl.g:3557:2: rule__JMLAnnotation__Group__4__Impl rule__JMLAnnotation__Group__5
			{
			pushFollow(FOLLOW_36);
			rule__JMLAnnotation__Group__4__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__Group__5();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__4"



	// $ANTLR start "rule__JMLAnnotation__Group__4__Impl"
	// InternalDsl.g:3564:1: rule__JMLAnnotation__Group__4__Impl : ( ( rule__JMLAnnotation__AssignableAssignment_4 ) ) ;
	public final void rule__JMLAnnotation__Group__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3568:2: ( ( ( rule__JMLAnnotation__AssignableAssignment_4 ) ) )
			// InternalDsl.g:3569:2: ( ( rule__JMLAnnotation__AssignableAssignment_4 ) )
			{
			// InternalDsl.g:3569:2: ( ( rule__JMLAnnotation__AssignableAssignment_4 ) )
			// InternalDsl.g:3570:2: ( rule__JMLAnnotation__AssignableAssignment_4 )
			{
			 before(grammarAccess.getJMLAnnotationAccess().getAssignableAssignment_4()); 
			// InternalDsl.g:3571:2: ( rule__JMLAnnotation__AssignableAssignment_4 )
			// InternalDsl.g:3571:3: rule__JMLAnnotation__AssignableAssignment_4
			{
			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__AssignableAssignment_4();
			state._fsp--;

			}

			 after(grammarAccess.getJMLAnnotationAccess().getAssignableAssignment_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__4__Impl"



	// $ANTLR start "rule__JMLAnnotation__Group__5"
	// InternalDsl.g:3579:1: rule__JMLAnnotation__Group__5 : rule__JMLAnnotation__Group__5__Impl rule__JMLAnnotation__Group__6 ;
	public final void rule__JMLAnnotation__Group__5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3583:2: ( rule__JMLAnnotation__Group__5__Impl rule__JMLAnnotation__Group__6 )
			// InternalDsl.g:3584:2: rule__JMLAnnotation__Group__5__Impl rule__JMLAnnotation__Group__6
			{
			pushFollow(FOLLOW_37);
			rule__JMLAnnotation__Group__5__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__Group__6();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__5"



	// $ANTLR start "rule__JMLAnnotation__Group__5__Impl"
	// InternalDsl.g:3591:1: rule__JMLAnnotation__Group__5__Impl : ( '$2' ) ;
	public final void rule__JMLAnnotation__Group__5__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3595:2: ( ( '$2' ) )
			// InternalDsl.g:3596:2: ( '$2' )
			{
			// InternalDsl.g:3596:2: ( '$2' )
			// InternalDsl.g:3597:2: '$2'
			{
			 before(grammarAccess.getJMLAnnotationAccess().getDollarSignDigitTwoKeyword_5()); 
			match(input,12,FOLLOW_2); 
			 after(grammarAccess.getJMLAnnotationAccess().getDollarSignDigitTwoKeyword_5()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__5__Impl"



	// $ANTLR start "rule__JMLAnnotation__Group__6"
	// InternalDsl.g:3606:1: rule__JMLAnnotation__Group__6 : rule__JMLAnnotation__Group__6__Impl rule__JMLAnnotation__Group__7 ;
	public final void rule__JMLAnnotation__Group__6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3610:2: ( rule__JMLAnnotation__Group__6__Impl rule__JMLAnnotation__Group__7 )
			// InternalDsl.g:3611:2: rule__JMLAnnotation__Group__6__Impl rule__JMLAnnotation__Group__7
			{
			pushFollow(FOLLOW_4);
			rule__JMLAnnotation__Group__6__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__Group__7();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__6"



	// $ANTLR start "rule__JMLAnnotation__Group__6__Impl"
	// InternalDsl.g:3618:1: rule__JMLAnnotation__Group__6__Impl : ( '@3' ) ;
	public final void rule__JMLAnnotation__Group__6__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3622:2: ( ( '@3' ) )
			// InternalDsl.g:3623:2: ( '@3' )
			{
			// InternalDsl.g:3623:2: ( '@3' )
			// InternalDsl.g:3624:2: '@3'
			{
			 before(grammarAccess.getJMLAnnotationAccess().getCommercialAtDigitThreeKeyword_6()); 
			match(input,28,FOLLOW_2); 
			 after(grammarAccess.getJMLAnnotationAccess().getCommercialAtDigitThreeKeyword_6()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__6__Impl"



	// $ANTLR start "rule__JMLAnnotation__Group__7"
	// InternalDsl.g:3633:1: rule__JMLAnnotation__Group__7 : rule__JMLAnnotation__Group__7__Impl rule__JMLAnnotation__Group__8 ;
	public final void rule__JMLAnnotation__Group__7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3637:2: ( rule__JMLAnnotation__Group__7__Impl rule__JMLAnnotation__Group__8 )
			// InternalDsl.g:3638:2: rule__JMLAnnotation__Group__7__Impl rule__JMLAnnotation__Group__8
			{
			pushFollow(FOLLOW_38);
			rule__JMLAnnotation__Group__7__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__Group__8();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__7"



	// $ANTLR start "rule__JMLAnnotation__Group__7__Impl"
	// InternalDsl.g:3645:1: rule__JMLAnnotation__Group__7__Impl : ( ( rule__JMLAnnotation__EnsuresAssignment_7 ) ) ;
	public final void rule__JMLAnnotation__Group__7__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3649:2: ( ( ( rule__JMLAnnotation__EnsuresAssignment_7 ) ) )
			// InternalDsl.g:3650:2: ( ( rule__JMLAnnotation__EnsuresAssignment_7 ) )
			{
			// InternalDsl.g:3650:2: ( ( rule__JMLAnnotation__EnsuresAssignment_7 ) )
			// InternalDsl.g:3651:2: ( rule__JMLAnnotation__EnsuresAssignment_7 )
			{
			 before(grammarAccess.getJMLAnnotationAccess().getEnsuresAssignment_7()); 
			// InternalDsl.g:3652:2: ( rule__JMLAnnotation__EnsuresAssignment_7 )
			// InternalDsl.g:3652:3: rule__JMLAnnotation__EnsuresAssignment_7
			{
			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__EnsuresAssignment_7();
			state._fsp--;

			}

			 after(grammarAccess.getJMLAnnotationAccess().getEnsuresAssignment_7()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__7__Impl"



	// $ANTLR start "rule__JMLAnnotation__Group__8"
	// InternalDsl.g:3660:1: rule__JMLAnnotation__Group__8 : rule__JMLAnnotation__Group__8__Impl ;
	public final void rule__JMLAnnotation__Group__8() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3664:2: ( rule__JMLAnnotation__Group__8__Impl )
			// InternalDsl.g:3665:2: rule__JMLAnnotation__Group__8__Impl
			{
			pushFollow(FOLLOW_2);
			rule__JMLAnnotation__Group__8__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__8"



	// $ANTLR start "rule__JMLAnnotation__Group__8__Impl"
	// InternalDsl.g:3671:1: rule__JMLAnnotation__Group__8__Impl : ( '$3' ) ;
	public final void rule__JMLAnnotation__Group__8__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3675:2: ( ( '$3' ) )
			// InternalDsl.g:3676:2: ( '$3' )
			{
			// InternalDsl.g:3676:2: ( '$3' )
			// InternalDsl.g:3677:2: '$3'
			{
			 before(grammarAccess.getJMLAnnotationAccess().getDollarSignDigitThreeKeyword_8()); 
			match(input,13,FOLLOW_2); 
			 after(grammarAccess.getJMLAnnotationAccess().getDollarSignDigitThreeKeyword_8()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__Group__8__Impl"



	// $ANTLR start "rule__BlockStatement__Group__0"
	// InternalDsl.g:3687:1: rule__BlockStatement__Group__0 : rule__BlockStatement__Group__0__Impl rule__BlockStatement__Group__1 ;
	public final void rule__BlockStatement__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3691:2: ( rule__BlockStatement__Group__0__Impl rule__BlockStatement__Group__1 )
			// InternalDsl.g:3692:2: rule__BlockStatement__Group__0__Impl rule__BlockStatement__Group__1
			{
			pushFollow(FOLLOW_4);
			rule__BlockStatement__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__BlockStatement__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__0"



	// $ANTLR start "rule__BlockStatement__Group__0__Impl"
	// InternalDsl.g:3699:1: rule__BlockStatement__Group__0__Impl : ( 'Block' ) ;
	public final void rule__BlockStatement__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3703:2: ( ( 'Block' ) )
			// InternalDsl.g:3704:2: ( 'Block' )
			{
			// InternalDsl.g:3704:2: ( 'Block' )
			// InternalDsl.g:3705:2: 'Block'
			{
			 before(grammarAccess.getBlockStatementAccess().getBlockKeyword_0()); 
			match(input,29,FOLLOW_2); 
			 after(grammarAccess.getBlockStatementAccess().getBlockKeyword_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__0__Impl"



	// $ANTLR start "rule__BlockStatement__Group__1"
	// InternalDsl.g:3714:1: rule__BlockStatement__Group__1 : rule__BlockStatement__Group__1__Impl rule__BlockStatement__Group__2 ;
	public final void rule__BlockStatement__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3718:2: ( rule__BlockStatement__Group__1__Impl rule__BlockStatement__Group__2 )
			// InternalDsl.g:3719:2: rule__BlockStatement__Group__1__Impl rule__BlockStatement__Group__2
			{
			pushFollow(FOLLOW_39);
			rule__BlockStatement__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__BlockStatement__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__1"



	// $ANTLR start "rule__BlockStatement__Group__1__Impl"
	// InternalDsl.g:3726:1: rule__BlockStatement__Group__1__Impl : ( ( rule__BlockStatement__NameAssignment_1 ) ) ;
	public final void rule__BlockStatement__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3730:2: ( ( ( rule__BlockStatement__NameAssignment_1 ) ) )
			// InternalDsl.g:3731:2: ( ( rule__BlockStatement__NameAssignment_1 ) )
			{
			// InternalDsl.g:3731:2: ( ( rule__BlockStatement__NameAssignment_1 ) )
			// InternalDsl.g:3732:2: ( rule__BlockStatement__NameAssignment_1 )
			{
			 before(grammarAccess.getBlockStatementAccess().getNameAssignment_1()); 
			// InternalDsl.g:3733:2: ( rule__BlockStatement__NameAssignment_1 )
			// InternalDsl.g:3733:3: rule__BlockStatement__NameAssignment_1
			{
			pushFollow(FOLLOW_2);
			rule__BlockStatement__NameAssignment_1();
			state._fsp--;

			}

			 after(grammarAccess.getBlockStatementAccess().getNameAssignment_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__1__Impl"



	// $ANTLR start "rule__BlockStatement__Group__2"
	// InternalDsl.g:3741:1: rule__BlockStatement__Group__2 : rule__BlockStatement__Group__2__Impl rule__BlockStatement__Group__3 ;
	public final void rule__BlockStatement__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3745:2: ( rule__BlockStatement__Group__2__Impl rule__BlockStatement__Group__3 )
			// InternalDsl.g:3746:2: rule__BlockStatement__Group__2__Impl rule__BlockStatement__Group__3
			{
			pushFollow(FOLLOW_40);
			rule__BlockStatement__Group__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__BlockStatement__Group__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__2"



	// $ANTLR start "rule__BlockStatement__Group__2__Impl"
	// InternalDsl.g:3753:1: rule__BlockStatement__Group__2__Impl : ( ':' ) ;
	public final void rule__BlockStatement__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3757:2: ( ( ':' ) )
			// InternalDsl.g:3758:2: ( ':' )
			{
			// InternalDsl.g:3758:2: ( ':' )
			// InternalDsl.g:3759:2: ':'
			{
			 before(grammarAccess.getBlockStatementAccess().getColonKeyword_2()); 
			match(input,23,FOLLOW_2); 
			 after(grammarAccess.getBlockStatementAccess().getColonKeyword_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__2__Impl"



	// $ANTLR start "rule__BlockStatement__Group__3"
	// InternalDsl.g:3768:1: rule__BlockStatement__Group__3 : rule__BlockStatement__Group__3__Impl rule__BlockStatement__Group__4 ;
	public final void rule__BlockStatement__Group__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3772:2: ( rule__BlockStatement__Group__3__Impl rule__BlockStatement__Group__4 )
			// InternalDsl.g:3773:2: rule__BlockStatement__Group__3__Impl rule__BlockStatement__Group__4
			{
			pushFollow(FOLLOW_6);
			rule__BlockStatement__Group__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__BlockStatement__Group__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__3"



	// $ANTLR start "rule__BlockStatement__Group__3__Impl"
	// InternalDsl.g:3780:1: rule__BlockStatement__Group__3__Impl : ( ( rule__BlockStatement__JmlAnnotationAssignment_3 )? ) ;
	public final void rule__BlockStatement__Group__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3784:2: ( ( ( rule__BlockStatement__JmlAnnotationAssignment_3 )? ) )
			// InternalDsl.g:3785:2: ( ( rule__BlockStatement__JmlAnnotationAssignment_3 )? )
			{
			// InternalDsl.g:3785:2: ( ( rule__BlockStatement__JmlAnnotationAssignment_3 )? )
			// InternalDsl.g:3786:2: ( rule__BlockStatement__JmlAnnotationAssignment_3 )?
			{
			 before(grammarAccess.getBlockStatementAccess().getJmlAnnotationAssignment_3()); 
			// InternalDsl.g:3787:2: ( rule__BlockStatement__JmlAnnotationAssignment_3 )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==26) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// InternalDsl.g:3787:3: rule__BlockStatement__JmlAnnotationAssignment_3
					{
					pushFollow(FOLLOW_2);
					rule__BlockStatement__JmlAnnotationAssignment_3();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getBlockStatementAccess().getJmlAnnotationAssignment_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__3__Impl"



	// $ANTLR start "rule__BlockStatement__Group__4"
	// InternalDsl.g:3795:1: rule__BlockStatement__Group__4 : rule__BlockStatement__Group__4__Impl rule__BlockStatement__Group__5 ;
	public final void rule__BlockStatement__Group__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3799:2: ( rule__BlockStatement__Group__4__Impl rule__BlockStatement__Group__5 )
			// InternalDsl.g:3800:2: rule__BlockStatement__Group__4__Impl rule__BlockStatement__Group__5
			{
			pushFollow(FOLLOW_4);
			rule__BlockStatement__Group__4__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__BlockStatement__Group__5();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__4"



	// $ANTLR start "rule__BlockStatement__Group__4__Impl"
	// InternalDsl.g:3807:1: rule__BlockStatement__Group__4__Impl : ( '{' ) ;
	public final void rule__BlockStatement__Group__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3811:2: ( ( '{' ) )
			// InternalDsl.g:3812:2: ( '{' )
			{
			// InternalDsl.g:3812:2: ( '{' )
			// InternalDsl.g:3813:2: '{'
			{
			 before(grammarAccess.getBlockStatementAccess().getLeftCurlyBracketKeyword_4()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getBlockStatementAccess().getLeftCurlyBracketKeyword_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__4__Impl"



	// $ANTLR start "rule__BlockStatement__Group__5"
	// InternalDsl.g:3822:1: rule__BlockStatement__Group__5 : rule__BlockStatement__Group__5__Impl rule__BlockStatement__Group__6 ;
	public final void rule__BlockStatement__Group__5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3826:2: ( rule__BlockStatement__Group__5__Impl rule__BlockStatement__Group__6 )
			// InternalDsl.g:3827:2: rule__BlockStatement__Group__5__Impl rule__BlockStatement__Group__6
			{
			pushFollow(FOLLOW_7);
			rule__BlockStatement__Group__5__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__BlockStatement__Group__6();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__5"



	// $ANTLR start "rule__BlockStatement__Group__5__Impl"
	// InternalDsl.g:3834:1: rule__BlockStatement__Group__5__Impl : ( ( rule__BlockStatement__JavaStatementAssignment_5 ) ) ;
	public final void rule__BlockStatement__Group__5__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3838:2: ( ( ( rule__BlockStatement__JavaStatementAssignment_5 ) ) )
			// InternalDsl.g:3839:2: ( ( rule__BlockStatement__JavaStatementAssignment_5 ) )
			{
			// InternalDsl.g:3839:2: ( ( rule__BlockStatement__JavaStatementAssignment_5 ) )
			// InternalDsl.g:3840:2: ( rule__BlockStatement__JavaStatementAssignment_5 )
			{
			 before(grammarAccess.getBlockStatementAccess().getJavaStatementAssignment_5()); 
			// InternalDsl.g:3841:2: ( rule__BlockStatement__JavaStatementAssignment_5 )
			// InternalDsl.g:3841:3: rule__BlockStatement__JavaStatementAssignment_5
			{
			pushFollow(FOLLOW_2);
			rule__BlockStatement__JavaStatementAssignment_5();
			state._fsp--;

			}

			 after(grammarAccess.getBlockStatementAccess().getJavaStatementAssignment_5()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__5__Impl"



	// $ANTLR start "rule__BlockStatement__Group__6"
	// InternalDsl.g:3849:1: rule__BlockStatement__Group__6 : rule__BlockStatement__Group__6__Impl ;
	public final void rule__BlockStatement__Group__6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3853:2: ( rule__BlockStatement__Group__6__Impl )
			// InternalDsl.g:3854:2: rule__BlockStatement__Group__6__Impl
			{
			pushFollow(FOLLOW_2);
			rule__BlockStatement__Group__6__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__6"



	// $ANTLR start "rule__BlockStatement__Group__6__Impl"
	// InternalDsl.g:3860:1: rule__BlockStatement__Group__6__Impl : ( '}' ) ;
	public final void rule__BlockStatement__Group__6__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3864:2: ( ( '}' ) )
			// InternalDsl.g:3865:2: ( '}' )
			{
			// InternalDsl.g:3865:2: ( '}' )
			// InternalDsl.g:3866:2: '}'
			{
			 before(grammarAccess.getBlockStatementAccess().getRightCurlyBracketKeyword_6()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getBlockStatementAccess().getRightCurlyBracketKeyword_6()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__Group__6__Impl"



	// $ANTLR start "rule__SelectionStatement__Group__0"
	// InternalDsl.g:3876:1: rule__SelectionStatement__Group__0 : rule__SelectionStatement__Group__0__Impl rule__SelectionStatement__Group__1 ;
	public final void rule__SelectionStatement__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3880:2: ( rule__SelectionStatement__Group__0__Impl rule__SelectionStatement__Group__1 )
			// InternalDsl.g:3881:2: rule__SelectionStatement__Group__0__Impl rule__SelectionStatement__Group__1
			{
			pushFollow(FOLLOW_41);
			rule__SelectionStatement__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__0"



	// $ANTLR start "rule__SelectionStatement__Group__0__Impl"
	// InternalDsl.g:3888:1: rule__SelectionStatement__Group__0__Impl : ( () ) ;
	public final void rule__SelectionStatement__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3892:2: ( ( () ) )
			// InternalDsl.g:3893:2: ( () )
			{
			// InternalDsl.g:3893:2: ( () )
			// InternalDsl.g:3894:2: ()
			{
			 before(grammarAccess.getSelectionStatementAccess().getSelectionStatementAction_0()); 
			// InternalDsl.g:3895:2: ()
			// InternalDsl.g:3895:3: 
			{
			}

			 after(grammarAccess.getSelectionStatementAccess().getSelectionStatementAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__0__Impl"



	// $ANTLR start "rule__SelectionStatement__Group__1"
	// InternalDsl.g:3903:1: rule__SelectionStatement__Group__1 : rule__SelectionStatement__Group__1__Impl rule__SelectionStatement__Group__2 ;
	public final void rule__SelectionStatement__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3907:2: ( rule__SelectionStatement__Group__1__Impl rule__SelectionStatement__Group__2 )
			// InternalDsl.g:3908:2: rule__SelectionStatement__Group__1__Impl rule__SelectionStatement__Group__2
			{
			pushFollow(FOLLOW_42);
			rule__SelectionStatement__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__1"



	// $ANTLR start "rule__SelectionStatement__Group__1__Impl"
	// InternalDsl.g:3915:1: rule__SelectionStatement__Group__1__Impl : ( 'if' ) ;
	public final void rule__SelectionStatement__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3919:2: ( ( 'if' ) )
			// InternalDsl.g:3920:2: ( 'if' )
			{
			// InternalDsl.g:3920:2: ( 'if' )
			// InternalDsl.g:3921:2: 'if'
			{
			 before(grammarAccess.getSelectionStatementAccess().getIfKeyword_1()); 
			match(input,41,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getIfKeyword_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__1__Impl"



	// $ANTLR start "rule__SelectionStatement__Group__2"
	// InternalDsl.g:3930:1: rule__SelectionStatement__Group__2 : rule__SelectionStatement__Group__2__Impl rule__SelectionStatement__Group__3 ;
	public final void rule__SelectionStatement__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3934:2: ( rule__SelectionStatement__Group__2__Impl rule__SelectionStatement__Group__3 )
			// InternalDsl.g:3935:2: rule__SelectionStatement__Group__2__Impl rule__SelectionStatement__Group__3
			{
			pushFollow(FOLLOW_4);
			rule__SelectionStatement__Group__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__2"



	// $ANTLR start "rule__SelectionStatement__Group__2__Impl"
	// InternalDsl.g:3942:1: rule__SelectionStatement__Group__2__Impl : ( '(' ) ;
	public final void rule__SelectionStatement__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3946:2: ( ( '(' ) )
			// InternalDsl.g:3947:2: ( '(' )
			{
			// InternalDsl.g:3947:2: ( '(' )
			// InternalDsl.g:3948:2: '('
			{
			 before(grammarAccess.getSelectionStatementAccess().getLeftParenthesisKeyword_2()); 
			match(input,15,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getLeftParenthesisKeyword_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__2__Impl"



	// $ANTLR start "rule__SelectionStatement__Group__3"
	// InternalDsl.g:3957:1: rule__SelectionStatement__Group__3 : rule__SelectionStatement__Group__3__Impl rule__SelectionStatement__Group__4 ;
	public final void rule__SelectionStatement__Group__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3961:2: ( rule__SelectionStatement__Group__3__Impl rule__SelectionStatement__Group__4 )
			// InternalDsl.g:3962:2: rule__SelectionStatement__Group__3__Impl rule__SelectionStatement__Group__4
			{
			pushFollow(FOLLOW_21);
			rule__SelectionStatement__Group__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__3"



	// $ANTLR start "rule__SelectionStatement__Group__3__Impl"
	// InternalDsl.g:3969:1: rule__SelectionStatement__Group__3__Impl : ( ( rule__SelectionStatement__GuardsAssignment_3 ) ) ;
	public final void rule__SelectionStatement__Group__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3973:2: ( ( ( rule__SelectionStatement__GuardsAssignment_3 ) ) )
			// InternalDsl.g:3974:2: ( ( rule__SelectionStatement__GuardsAssignment_3 ) )
			{
			// InternalDsl.g:3974:2: ( ( rule__SelectionStatement__GuardsAssignment_3 ) )
			// InternalDsl.g:3975:2: ( rule__SelectionStatement__GuardsAssignment_3 )
			{
			 before(grammarAccess.getSelectionStatementAccess().getGuardsAssignment_3()); 
			// InternalDsl.g:3976:2: ( rule__SelectionStatement__GuardsAssignment_3 )
			// InternalDsl.g:3976:3: rule__SelectionStatement__GuardsAssignment_3
			{
			pushFollow(FOLLOW_2);
			rule__SelectionStatement__GuardsAssignment_3();
			state._fsp--;

			}

			 after(grammarAccess.getSelectionStatementAccess().getGuardsAssignment_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__3__Impl"



	// $ANTLR start "rule__SelectionStatement__Group__4"
	// InternalDsl.g:3984:1: rule__SelectionStatement__Group__4 : rule__SelectionStatement__Group__4__Impl rule__SelectionStatement__Group__5 ;
	public final void rule__SelectionStatement__Group__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:3988:2: ( rule__SelectionStatement__Group__4__Impl rule__SelectionStatement__Group__5 )
			// InternalDsl.g:3989:2: rule__SelectionStatement__Group__4__Impl rule__SelectionStatement__Group__5
			{
			pushFollow(FOLLOW_43);
			rule__SelectionStatement__Group__4__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__5();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__4"



	// $ANTLR start "rule__SelectionStatement__Group__4__Impl"
	// InternalDsl.g:3996:1: rule__SelectionStatement__Group__4__Impl : ( ')' ) ;
	public final void rule__SelectionStatement__Group__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4000:2: ( ( ')' ) )
			// InternalDsl.g:4001:2: ( ')' )
			{
			// InternalDsl.g:4001:2: ( ')' )
			// InternalDsl.g:4002:2: ')'
			{
			 before(grammarAccess.getSelectionStatementAccess().getRightParenthesisKeyword_4()); 
			match(input,16,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getRightParenthesisKeyword_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__4__Impl"



	// $ANTLR start "rule__SelectionStatement__Group__5"
	// InternalDsl.g:4011:1: rule__SelectionStatement__Group__5 : rule__SelectionStatement__Group__5__Impl rule__SelectionStatement__Group__6 ;
	public final void rule__SelectionStatement__Group__5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4015:2: ( rule__SelectionStatement__Group__5__Impl rule__SelectionStatement__Group__6 )
			// InternalDsl.g:4016:2: rule__SelectionStatement__Group__5__Impl rule__SelectionStatement__Group__6
			{
			pushFollow(FOLLOW_6);
			rule__SelectionStatement__Group__5__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__6();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__5"



	// $ANTLR start "rule__SelectionStatement__Group__5__Impl"
	// InternalDsl.g:4023:1: rule__SelectionStatement__Group__5__Impl : ( 'then' ) ;
	public final void rule__SelectionStatement__Group__5__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4027:2: ( ( 'then' ) )
			// InternalDsl.g:4028:2: ( 'then' )
			{
			// InternalDsl.g:4028:2: ( 'then' )
			// InternalDsl.g:4029:2: 'then'
			{
			 before(grammarAccess.getSelectionStatementAccess().getThenKeyword_5()); 
			match(input,50,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getThenKeyword_5()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__5__Impl"



	// $ANTLR start "rule__SelectionStatement__Group__6"
	// InternalDsl.g:4038:1: rule__SelectionStatement__Group__6 : rule__SelectionStatement__Group__6__Impl rule__SelectionStatement__Group__7 ;
	public final void rule__SelectionStatement__Group__6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4042:2: ( rule__SelectionStatement__Group__6__Impl rule__SelectionStatement__Group__7 )
			// InternalDsl.g:4043:2: rule__SelectionStatement__Group__6__Impl rule__SelectionStatement__Group__7
			{
			pushFollow(FOLLOW_8);
			rule__SelectionStatement__Group__6__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__7();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__6"



	// $ANTLR start "rule__SelectionStatement__Group__6__Impl"
	// InternalDsl.g:4050:1: rule__SelectionStatement__Group__6__Impl : ( '{' ) ;
	public final void rule__SelectionStatement__Group__6__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4054:2: ( ( '{' ) )
			// InternalDsl.g:4055:2: ( '{' )
			{
			// InternalDsl.g:4055:2: ( '{' )
			// InternalDsl.g:4056:2: '{'
			{
			 before(grammarAccess.getSelectionStatementAccess().getLeftCurlyBracketKeyword_6()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getLeftCurlyBracketKeyword_6()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__6__Impl"



	// $ANTLR start "rule__SelectionStatement__Group__7"
	// InternalDsl.g:4065:1: rule__SelectionStatement__Group__7 : rule__SelectionStatement__Group__7__Impl rule__SelectionStatement__Group__8 ;
	public final void rule__SelectionStatement__Group__7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4069:2: ( rule__SelectionStatement__Group__7__Impl rule__SelectionStatement__Group__8 )
			// InternalDsl.g:4070:2: rule__SelectionStatement__Group__7__Impl rule__SelectionStatement__Group__8
			{
			pushFollow(FOLLOW_7);
			rule__SelectionStatement__Group__7__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__8();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__7"



	// $ANTLR start "rule__SelectionStatement__Group__7__Impl"
	// InternalDsl.g:4077:1: rule__SelectionStatement__Group__7__Impl : ( ( rule__SelectionStatement__CommandsAssignment_7 ) ) ;
	public final void rule__SelectionStatement__Group__7__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4081:2: ( ( ( rule__SelectionStatement__CommandsAssignment_7 ) ) )
			// InternalDsl.g:4082:2: ( ( rule__SelectionStatement__CommandsAssignment_7 ) )
			{
			// InternalDsl.g:4082:2: ( ( rule__SelectionStatement__CommandsAssignment_7 ) )
			// InternalDsl.g:4083:2: ( rule__SelectionStatement__CommandsAssignment_7 )
			{
			 before(grammarAccess.getSelectionStatementAccess().getCommandsAssignment_7()); 
			// InternalDsl.g:4084:2: ( rule__SelectionStatement__CommandsAssignment_7 )
			// InternalDsl.g:4084:3: rule__SelectionStatement__CommandsAssignment_7
			{
			pushFollow(FOLLOW_2);
			rule__SelectionStatement__CommandsAssignment_7();
			state._fsp--;

			}

			 after(grammarAccess.getSelectionStatementAccess().getCommandsAssignment_7()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__7__Impl"



	// $ANTLR start "rule__SelectionStatement__Group__8"
	// InternalDsl.g:4092:1: rule__SelectionStatement__Group__8 : rule__SelectionStatement__Group__8__Impl rule__SelectionStatement__Group__9 ;
	public final void rule__SelectionStatement__Group__8() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4096:2: ( rule__SelectionStatement__Group__8__Impl rule__SelectionStatement__Group__9 )
			// InternalDsl.g:4097:2: rule__SelectionStatement__Group__8__Impl rule__SelectionStatement__Group__9
			{
			pushFollow(FOLLOW_44);
			rule__SelectionStatement__Group__8__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__9();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__8"



	// $ANTLR start "rule__SelectionStatement__Group__8__Impl"
	// InternalDsl.g:4104:1: rule__SelectionStatement__Group__8__Impl : ( '}' ) ;
	public final void rule__SelectionStatement__Group__8__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4108:2: ( ( '}' ) )
			// InternalDsl.g:4109:2: ( '}' )
			{
			// InternalDsl.g:4109:2: ( '}' )
			// InternalDsl.g:4110:2: '}'
			{
			 before(grammarAccess.getSelectionStatementAccess().getRightCurlyBracketKeyword_8()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getRightCurlyBracketKeyword_8()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__8__Impl"



	// $ANTLR start "rule__SelectionStatement__Group__9"
	// InternalDsl.g:4119:1: rule__SelectionStatement__Group__9 : rule__SelectionStatement__Group__9__Impl rule__SelectionStatement__Group__10 ;
	public final void rule__SelectionStatement__Group__9() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4123:2: ( rule__SelectionStatement__Group__9__Impl rule__SelectionStatement__Group__10 )
			// InternalDsl.g:4124:2: rule__SelectionStatement__Group__9__Impl rule__SelectionStatement__Group__10
			{
			pushFollow(FOLLOW_45);
			rule__SelectionStatement__Group__9__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__10();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__9"



	// $ANTLR start "rule__SelectionStatement__Group__9__Impl"
	// InternalDsl.g:4131:1: rule__SelectionStatement__Group__9__Impl : ( ( rule__SelectionStatement__Group_9__0 )* ) ;
	public final void rule__SelectionStatement__Group__9__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4135:2: ( ( ( rule__SelectionStatement__Group_9__0 )* ) )
			// InternalDsl.g:4136:2: ( ( rule__SelectionStatement__Group_9__0 )* )
			{
			// InternalDsl.g:4136:2: ( ( rule__SelectionStatement__Group_9__0 )* )
			// InternalDsl.g:4137:2: ( rule__SelectionStatement__Group_9__0 )*
			{
			 before(grammarAccess.getSelectionStatementAccess().getGroup_9()); 
			// InternalDsl.g:4138:2: ( rule__SelectionStatement__Group_9__0 )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==38) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// InternalDsl.g:4138:3: rule__SelectionStatement__Group_9__0
					{
					pushFollow(FOLLOW_46);
					rule__SelectionStatement__Group_9__0();
					state._fsp--;

					}
					break;

				default :
					break loop30;
				}
			}

			 after(grammarAccess.getSelectionStatementAccess().getGroup_9()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__9__Impl"



	// $ANTLR start "rule__SelectionStatement__Group__10"
	// InternalDsl.g:4146:1: rule__SelectionStatement__Group__10 : rule__SelectionStatement__Group__10__Impl ;
	public final void rule__SelectionStatement__Group__10() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4150:2: ( rule__SelectionStatement__Group__10__Impl )
			// InternalDsl.g:4151:2: rule__SelectionStatement__Group__10__Impl
			{
			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group__10__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__10"



	// $ANTLR start "rule__SelectionStatement__Group__10__Impl"
	// InternalDsl.g:4157:1: rule__SelectionStatement__Group__10__Impl : ( 'fi' ) ;
	public final void rule__SelectionStatement__Group__10__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4161:2: ( ( 'fi' ) )
			// InternalDsl.g:4162:2: ( 'fi' )
			{
			// InternalDsl.g:4162:2: ( 'fi' )
			// InternalDsl.g:4163:2: 'fi'
			{
			 before(grammarAccess.getSelectionStatementAccess().getFiKeyword_10()); 
			match(input,39,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getFiKeyword_10()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group__10__Impl"



	// $ANTLR start "rule__SelectionStatement__Group_9__0"
	// InternalDsl.g:4173:1: rule__SelectionStatement__Group_9__0 : rule__SelectionStatement__Group_9__0__Impl rule__SelectionStatement__Group_9__1 ;
	public final void rule__SelectionStatement__Group_9__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4177:2: ( rule__SelectionStatement__Group_9__0__Impl rule__SelectionStatement__Group_9__1 )
			// InternalDsl.g:4178:2: rule__SelectionStatement__Group_9__0__Impl rule__SelectionStatement__Group_9__1
			{
			pushFollow(FOLLOW_42);
			rule__SelectionStatement__Group_9__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group_9__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__0"



	// $ANTLR start "rule__SelectionStatement__Group_9__0__Impl"
	// InternalDsl.g:4185:1: rule__SelectionStatement__Group_9__0__Impl : ( 'elseif' ) ;
	public final void rule__SelectionStatement__Group_9__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4189:2: ( ( 'elseif' ) )
			// InternalDsl.g:4190:2: ( 'elseif' )
			{
			// InternalDsl.g:4190:2: ( 'elseif' )
			// InternalDsl.g:4191:2: 'elseif'
			{
			 before(grammarAccess.getSelectionStatementAccess().getElseifKeyword_9_0()); 
			match(input,38,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getElseifKeyword_9_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__0__Impl"



	// $ANTLR start "rule__SelectionStatement__Group_9__1"
	// InternalDsl.g:4200:1: rule__SelectionStatement__Group_9__1 : rule__SelectionStatement__Group_9__1__Impl rule__SelectionStatement__Group_9__2 ;
	public final void rule__SelectionStatement__Group_9__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4204:2: ( rule__SelectionStatement__Group_9__1__Impl rule__SelectionStatement__Group_9__2 )
			// InternalDsl.g:4205:2: rule__SelectionStatement__Group_9__1__Impl rule__SelectionStatement__Group_9__2
			{
			pushFollow(FOLLOW_4);
			rule__SelectionStatement__Group_9__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group_9__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__1"



	// $ANTLR start "rule__SelectionStatement__Group_9__1__Impl"
	// InternalDsl.g:4212:1: rule__SelectionStatement__Group_9__1__Impl : ( '(' ) ;
	public final void rule__SelectionStatement__Group_9__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4216:2: ( ( '(' ) )
			// InternalDsl.g:4217:2: ( '(' )
			{
			// InternalDsl.g:4217:2: ( '(' )
			// InternalDsl.g:4218:2: '('
			{
			 before(grammarAccess.getSelectionStatementAccess().getLeftParenthesisKeyword_9_1()); 
			match(input,15,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getLeftParenthesisKeyword_9_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__1__Impl"



	// $ANTLR start "rule__SelectionStatement__Group_9__2"
	// InternalDsl.g:4227:1: rule__SelectionStatement__Group_9__2 : rule__SelectionStatement__Group_9__2__Impl rule__SelectionStatement__Group_9__3 ;
	public final void rule__SelectionStatement__Group_9__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4231:2: ( rule__SelectionStatement__Group_9__2__Impl rule__SelectionStatement__Group_9__3 )
			// InternalDsl.g:4232:2: rule__SelectionStatement__Group_9__2__Impl rule__SelectionStatement__Group_9__3
			{
			pushFollow(FOLLOW_21);
			rule__SelectionStatement__Group_9__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group_9__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__2"



	// $ANTLR start "rule__SelectionStatement__Group_9__2__Impl"
	// InternalDsl.g:4239:1: rule__SelectionStatement__Group_9__2__Impl : ( ( rule__SelectionStatement__GuardsAssignment_9_2 ) ) ;
	public final void rule__SelectionStatement__Group_9__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4243:2: ( ( ( rule__SelectionStatement__GuardsAssignment_9_2 ) ) )
			// InternalDsl.g:4244:2: ( ( rule__SelectionStatement__GuardsAssignment_9_2 ) )
			{
			// InternalDsl.g:4244:2: ( ( rule__SelectionStatement__GuardsAssignment_9_2 ) )
			// InternalDsl.g:4245:2: ( rule__SelectionStatement__GuardsAssignment_9_2 )
			{
			 before(grammarAccess.getSelectionStatementAccess().getGuardsAssignment_9_2()); 
			// InternalDsl.g:4246:2: ( rule__SelectionStatement__GuardsAssignment_9_2 )
			// InternalDsl.g:4246:3: rule__SelectionStatement__GuardsAssignment_9_2
			{
			pushFollow(FOLLOW_2);
			rule__SelectionStatement__GuardsAssignment_9_2();
			state._fsp--;

			}

			 after(grammarAccess.getSelectionStatementAccess().getGuardsAssignment_9_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__2__Impl"



	// $ANTLR start "rule__SelectionStatement__Group_9__3"
	// InternalDsl.g:4254:1: rule__SelectionStatement__Group_9__3 : rule__SelectionStatement__Group_9__3__Impl rule__SelectionStatement__Group_9__4 ;
	public final void rule__SelectionStatement__Group_9__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4258:2: ( rule__SelectionStatement__Group_9__3__Impl rule__SelectionStatement__Group_9__4 )
			// InternalDsl.g:4259:2: rule__SelectionStatement__Group_9__3__Impl rule__SelectionStatement__Group_9__4
			{
			pushFollow(FOLLOW_43);
			rule__SelectionStatement__Group_9__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group_9__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__3"



	// $ANTLR start "rule__SelectionStatement__Group_9__3__Impl"
	// InternalDsl.g:4266:1: rule__SelectionStatement__Group_9__3__Impl : ( ')' ) ;
	public final void rule__SelectionStatement__Group_9__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4270:2: ( ( ')' ) )
			// InternalDsl.g:4271:2: ( ')' )
			{
			// InternalDsl.g:4271:2: ( ')' )
			// InternalDsl.g:4272:2: ')'
			{
			 before(grammarAccess.getSelectionStatementAccess().getRightParenthesisKeyword_9_3()); 
			match(input,16,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getRightParenthesisKeyword_9_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__3__Impl"



	// $ANTLR start "rule__SelectionStatement__Group_9__4"
	// InternalDsl.g:4281:1: rule__SelectionStatement__Group_9__4 : rule__SelectionStatement__Group_9__4__Impl rule__SelectionStatement__Group_9__5 ;
	public final void rule__SelectionStatement__Group_9__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4285:2: ( rule__SelectionStatement__Group_9__4__Impl rule__SelectionStatement__Group_9__5 )
			// InternalDsl.g:4286:2: rule__SelectionStatement__Group_9__4__Impl rule__SelectionStatement__Group_9__5
			{
			pushFollow(FOLLOW_6);
			rule__SelectionStatement__Group_9__4__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group_9__5();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__4"



	// $ANTLR start "rule__SelectionStatement__Group_9__4__Impl"
	// InternalDsl.g:4293:1: rule__SelectionStatement__Group_9__4__Impl : ( 'then' ) ;
	public final void rule__SelectionStatement__Group_9__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4297:2: ( ( 'then' ) )
			// InternalDsl.g:4298:2: ( 'then' )
			{
			// InternalDsl.g:4298:2: ( 'then' )
			// InternalDsl.g:4299:2: 'then'
			{
			 before(grammarAccess.getSelectionStatementAccess().getThenKeyword_9_4()); 
			match(input,50,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getThenKeyword_9_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__4__Impl"



	// $ANTLR start "rule__SelectionStatement__Group_9__5"
	// InternalDsl.g:4308:1: rule__SelectionStatement__Group_9__5 : rule__SelectionStatement__Group_9__5__Impl rule__SelectionStatement__Group_9__6 ;
	public final void rule__SelectionStatement__Group_9__5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4312:2: ( rule__SelectionStatement__Group_9__5__Impl rule__SelectionStatement__Group_9__6 )
			// InternalDsl.g:4313:2: rule__SelectionStatement__Group_9__5__Impl rule__SelectionStatement__Group_9__6
			{
			pushFollow(FOLLOW_8);
			rule__SelectionStatement__Group_9__5__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group_9__6();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__5"



	// $ANTLR start "rule__SelectionStatement__Group_9__5__Impl"
	// InternalDsl.g:4320:1: rule__SelectionStatement__Group_9__5__Impl : ( '{' ) ;
	public final void rule__SelectionStatement__Group_9__5__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4324:2: ( ( '{' ) )
			// InternalDsl.g:4325:2: ( '{' )
			{
			// InternalDsl.g:4325:2: ( '{' )
			// InternalDsl.g:4326:2: '{'
			{
			 before(grammarAccess.getSelectionStatementAccess().getLeftCurlyBracketKeyword_9_5()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getLeftCurlyBracketKeyword_9_5()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__5__Impl"



	// $ANTLR start "rule__SelectionStatement__Group_9__6"
	// InternalDsl.g:4335:1: rule__SelectionStatement__Group_9__6 : rule__SelectionStatement__Group_9__6__Impl rule__SelectionStatement__Group_9__7 ;
	public final void rule__SelectionStatement__Group_9__6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4339:2: ( rule__SelectionStatement__Group_9__6__Impl rule__SelectionStatement__Group_9__7 )
			// InternalDsl.g:4340:2: rule__SelectionStatement__Group_9__6__Impl rule__SelectionStatement__Group_9__7
			{
			pushFollow(FOLLOW_7);
			rule__SelectionStatement__Group_9__6__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group_9__7();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__6"



	// $ANTLR start "rule__SelectionStatement__Group_9__6__Impl"
	// InternalDsl.g:4347:1: rule__SelectionStatement__Group_9__6__Impl : ( ( rule__SelectionStatement__CommandsAssignment_9_6 ) ) ;
	public final void rule__SelectionStatement__Group_9__6__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4351:2: ( ( ( rule__SelectionStatement__CommandsAssignment_9_6 ) ) )
			// InternalDsl.g:4352:2: ( ( rule__SelectionStatement__CommandsAssignment_9_6 ) )
			{
			// InternalDsl.g:4352:2: ( ( rule__SelectionStatement__CommandsAssignment_9_6 ) )
			// InternalDsl.g:4353:2: ( rule__SelectionStatement__CommandsAssignment_9_6 )
			{
			 before(grammarAccess.getSelectionStatementAccess().getCommandsAssignment_9_6()); 
			// InternalDsl.g:4354:2: ( rule__SelectionStatement__CommandsAssignment_9_6 )
			// InternalDsl.g:4354:3: rule__SelectionStatement__CommandsAssignment_9_6
			{
			pushFollow(FOLLOW_2);
			rule__SelectionStatement__CommandsAssignment_9_6();
			state._fsp--;

			}

			 after(grammarAccess.getSelectionStatementAccess().getCommandsAssignment_9_6()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__6__Impl"



	// $ANTLR start "rule__SelectionStatement__Group_9__7"
	// InternalDsl.g:4362:1: rule__SelectionStatement__Group_9__7 : rule__SelectionStatement__Group_9__7__Impl ;
	public final void rule__SelectionStatement__Group_9__7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4366:2: ( rule__SelectionStatement__Group_9__7__Impl )
			// InternalDsl.g:4367:2: rule__SelectionStatement__Group_9__7__Impl
			{
			pushFollow(FOLLOW_2);
			rule__SelectionStatement__Group_9__7__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__7"



	// $ANTLR start "rule__SelectionStatement__Group_9__7__Impl"
	// InternalDsl.g:4373:1: rule__SelectionStatement__Group_9__7__Impl : ( '}' ) ;
	public final void rule__SelectionStatement__Group_9__7__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4377:2: ( ( '}' ) )
			// InternalDsl.g:4378:2: ( '}' )
			{
			// InternalDsl.g:4378:2: ( '}' )
			// InternalDsl.g:4379:2: '}'
			{
			 before(grammarAccess.getSelectionStatementAccess().getRightCurlyBracketKeyword_9_7()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getSelectionStatementAccess().getRightCurlyBracketKeyword_9_7()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__Group_9__7__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__0"
	// InternalDsl.g:4389:1: rule__SmallRepetitionStatement__Group__0 : rule__SmallRepetitionStatement__Group__0__Impl rule__SmallRepetitionStatement__Group__1 ;
	public final void rule__SmallRepetitionStatement__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4393:2: ( rule__SmallRepetitionStatement__Group__0__Impl rule__SmallRepetitionStatement__Group__1 )
			// InternalDsl.g:4394:2: rule__SmallRepetitionStatement__Group__0__Impl rule__SmallRepetitionStatement__Group__1
			{
			pushFollow(FOLLOW_47);
			rule__SmallRepetitionStatement__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__0"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__0__Impl"
	// InternalDsl.g:4401:1: rule__SmallRepetitionStatement__Group__0__Impl : ( () ) ;
	public final void rule__SmallRepetitionStatement__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4405:2: ( ( () ) )
			// InternalDsl.g:4406:2: ( () )
			{
			// InternalDsl.g:4406:2: ( () )
			// InternalDsl.g:4407:2: ()
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getSmallRepetitionStatementAction_0()); 
			// InternalDsl.g:4408:2: ()
			// InternalDsl.g:4408:3: 
			{
			}

			 after(grammarAccess.getSmallRepetitionStatementAccess().getSmallRepetitionStatementAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__0__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__1"
	// InternalDsl.g:4416:1: rule__SmallRepetitionStatement__Group__1 : rule__SmallRepetitionStatement__Group__1__Impl rule__SmallRepetitionStatement__Group__2 ;
	public final void rule__SmallRepetitionStatement__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4420:2: ( rule__SmallRepetitionStatement__Group__1__Impl rule__SmallRepetitionStatement__Group__2 )
			// InternalDsl.g:4421:2: rule__SmallRepetitionStatement__Group__1__Impl rule__SmallRepetitionStatement__Group__2
			{
			pushFollow(FOLLOW_42);
			rule__SmallRepetitionStatement__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__1"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__1__Impl"
	// InternalDsl.g:4428:1: rule__SmallRepetitionStatement__Group__1__Impl : ( 'while' ) ;
	public final void rule__SmallRepetitionStatement__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4432:2: ( ( 'while' ) )
			// InternalDsl.g:4433:2: ( 'while' )
			{
			// InternalDsl.g:4433:2: ( 'while' )
			// InternalDsl.g:4434:2: 'while'
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getWhileKeyword_1()); 
			match(input,54,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getWhileKeyword_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__1__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__2"
	// InternalDsl.g:4443:1: rule__SmallRepetitionStatement__Group__2 : rule__SmallRepetitionStatement__Group__2__Impl rule__SmallRepetitionStatement__Group__3 ;
	public final void rule__SmallRepetitionStatement__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4447:2: ( rule__SmallRepetitionStatement__Group__2__Impl rule__SmallRepetitionStatement__Group__3 )
			// InternalDsl.g:4448:2: rule__SmallRepetitionStatement__Group__2__Impl rule__SmallRepetitionStatement__Group__3
			{
			pushFollow(FOLLOW_4);
			rule__SmallRepetitionStatement__Group__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__2"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__2__Impl"
	// InternalDsl.g:4455:1: rule__SmallRepetitionStatement__Group__2__Impl : ( '(' ) ;
	public final void rule__SmallRepetitionStatement__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4459:2: ( ( '(' ) )
			// InternalDsl.g:4460:2: ( '(' )
			{
			// InternalDsl.g:4460:2: ( '(' )
			// InternalDsl.g:4461:2: '('
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getLeftParenthesisKeyword_2()); 
			match(input,15,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getLeftParenthesisKeyword_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__2__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__3"
	// InternalDsl.g:4470:1: rule__SmallRepetitionStatement__Group__3 : rule__SmallRepetitionStatement__Group__3__Impl rule__SmallRepetitionStatement__Group__4 ;
	public final void rule__SmallRepetitionStatement__Group__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4474:2: ( rule__SmallRepetitionStatement__Group__3__Impl rule__SmallRepetitionStatement__Group__4 )
			// InternalDsl.g:4475:2: rule__SmallRepetitionStatement__Group__3__Impl rule__SmallRepetitionStatement__Group__4
			{
			pushFollow(FOLLOW_21);
			rule__SmallRepetitionStatement__Group__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__3"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__3__Impl"
	// InternalDsl.g:4482:1: rule__SmallRepetitionStatement__Group__3__Impl : ( ( rule__SmallRepetitionStatement__GuardAssignment_3 ) ) ;
	public final void rule__SmallRepetitionStatement__Group__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4486:2: ( ( ( rule__SmallRepetitionStatement__GuardAssignment_3 ) ) )
			// InternalDsl.g:4487:2: ( ( rule__SmallRepetitionStatement__GuardAssignment_3 ) )
			{
			// InternalDsl.g:4487:2: ( ( rule__SmallRepetitionStatement__GuardAssignment_3 ) )
			// InternalDsl.g:4488:2: ( rule__SmallRepetitionStatement__GuardAssignment_3 )
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getGuardAssignment_3()); 
			// InternalDsl.g:4489:2: ( rule__SmallRepetitionStatement__GuardAssignment_3 )
			// InternalDsl.g:4489:3: rule__SmallRepetitionStatement__GuardAssignment_3
			{
			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__GuardAssignment_3();
			state._fsp--;

			}

			 after(grammarAccess.getSmallRepetitionStatementAccess().getGuardAssignment_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__3__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__4"
	// InternalDsl.g:4497:1: rule__SmallRepetitionStatement__Group__4 : rule__SmallRepetitionStatement__Group__4__Impl rule__SmallRepetitionStatement__Group__5 ;
	public final void rule__SmallRepetitionStatement__Group__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4501:2: ( rule__SmallRepetitionStatement__Group__4__Impl rule__SmallRepetitionStatement__Group__5 )
			// InternalDsl.g:4502:2: rule__SmallRepetitionStatement__Group__4__Impl rule__SmallRepetitionStatement__Group__5
			{
			pushFollow(FOLLOW_48);
			rule__SmallRepetitionStatement__Group__4__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__5();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__4"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__4__Impl"
	// InternalDsl.g:4509:1: rule__SmallRepetitionStatement__Group__4__Impl : ( ')' ) ;
	public final void rule__SmallRepetitionStatement__Group__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4513:2: ( ( ')' ) )
			// InternalDsl.g:4514:2: ( ')' )
			{
			// InternalDsl.g:4514:2: ( ')' )
			// InternalDsl.g:4515:2: ')'
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getRightParenthesisKeyword_4()); 
			match(input,16,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getRightParenthesisKeyword_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__4__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__5"
	// InternalDsl.g:4524:1: rule__SmallRepetitionStatement__Group__5 : rule__SmallRepetitionStatement__Group__5__Impl rule__SmallRepetitionStatement__Group__6 ;
	public final void rule__SmallRepetitionStatement__Group__5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4528:2: ( rule__SmallRepetitionStatement__Group__5__Impl rule__SmallRepetitionStatement__Group__6 )
			// InternalDsl.g:4529:2: rule__SmallRepetitionStatement__Group__5__Impl rule__SmallRepetitionStatement__Group__6
			{
			pushFollow(FOLLOW_49);
			rule__SmallRepetitionStatement__Group__5__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__6();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__5"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__5__Impl"
	// InternalDsl.g:4536:1: rule__SmallRepetitionStatement__Group__5__Impl : ( 'do' ) ;
	public final void rule__SmallRepetitionStatement__Group__5__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4540:2: ( ( 'do' ) )
			// InternalDsl.g:4541:2: ( 'do' )
			{
			// InternalDsl.g:4541:2: ( 'do' )
			// InternalDsl.g:4542:2: 'do'
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getDoKeyword_5()); 
			match(input,37,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getDoKeyword_5()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__5__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__6"
	// InternalDsl.g:4551:1: rule__SmallRepetitionStatement__Group__6 : rule__SmallRepetitionStatement__Group__6__Impl rule__SmallRepetitionStatement__Group__7 ;
	public final void rule__SmallRepetitionStatement__Group__6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4555:2: ( rule__SmallRepetitionStatement__Group__6__Impl rule__SmallRepetitionStatement__Group__7 )
			// InternalDsl.g:4556:2: rule__SmallRepetitionStatement__Group__6__Impl rule__SmallRepetitionStatement__Group__7
			{
			pushFollow(FOLLOW_33);
			rule__SmallRepetitionStatement__Group__6__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__7();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__6"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__6__Impl"
	// InternalDsl.g:4563:1: rule__SmallRepetitionStatement__Group__6__Impl : ( 'inv:' ) ;
	public final void rule__SmallRepetitionStatement__Group__6__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4567:2: ( ( 'inv:' ) )
			// InternalDsl.g:4568:2: ( 'inv:' )
			{
			// InternalDsl.g:4568:2: ( 'inv:' )
			// InternalDsl.g:4569:2: 'inv:'
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getInvKeyword_6()); 
			match(input,43,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getInvKeyword_6()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__6__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__7"
	// InternalDsl.g:4578:1: rule__SmallRepetitionStatement__Group__7 : rule__SmallRepetitionStatement__Group__7__Impl rule__SmallRepetitionStatement__Group__8 ;
	public final void rule__SmallRepetitionStatement__Group__7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4582:2: ( rule__SmallRepetitionStatement__Group__7__Impl rule__SmallRepetitionStatement__Group__8 )
			// InternalDsl.g:4583:2: rule__SmallRepetitionStatement__Group__7__Impl rule__SmallRepetitionStatement__Group__8
			{
			pushFollow(FOLLOW_4);
			rule__SmallRepetitionStatement__Group__7__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__8();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__7"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__7__Impl"
	// InternalDsl.g:4590:1: rule__SmallRepetitionStatement__Group__7__Impl : ( '[' ) ;
	public final void rule__SmallRepetitionStatement__Group__7__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4594:2: ( ( '[' ) )
			// InternalDsl.g:4595:2: ( '[' )
			{
			// InternalDsl.g:4595:2: ( '[' )
			// InternalDsl.g:4596:2: '['
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getLeftSquareBracketKeyword_7()); 
			match(input,34,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getLeftSquareBracketKeyword_7()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__7__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__8"
	// InternalDsl.g:4605:1: rule__SmallRepetitionStatement__Group__8 : rule__SmallRepetitionStatement__Group__8__Impl rule__SmallRepetitionStatement__Group__9 ;
	public final void rule__SmallRepetitionStatement__Group__8() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4609:2: ( rule__SmallRepetitionStatement__Group__8__Impl rule__SmallRepetitionStatement__Group__9 )
			// InternalDsl.g:4610:2: rule__SmallRepetitionStatement__Group__8__Impl rule__SmallRepetitionStatement__Group__9
			{
			pushFollow(FOLLOW_18);
			rule__SmallRepetitionStatement__Group__8__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__9();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__8"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__8__Impl"
	// InternalDsl.g:4617:1: rule__SmallRepetitionStatement__Group__8__Impl : ( ( rule__SmallRepetitionStatement__InvariantAssignment_8 ) ) ;
	public final void rule__SmallRepetitionStatement__Group__8__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4621:2: ( ( ( rule__SmallRepetitionStatement__InvariantAssignment_8 ) ) )
			// InternalDsl.g:4622:2: ( ( rule__SmallRepetitionStatement__InvariantAssignment_8 ) )
			{
			// InternalDsl.g:4622:2: ( ( rule__SmallRepetitionStatement__InvariantAssignment_8 ) )
			// InternalDsl.g:4623:2: ( rule__SmallRepetitionStatement__InvariantAssignment_8 )
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getInvariantAssignment_8()); 
			// InternalDsl.g:4624:2: ( rule__SmallRepetitionStatement__InvariantAssignment_8 )
			// InternalDsl.g:4624:3: rule__SmallRepetitionStatement__InvariantAssignment_8
			{
			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__InvariantAssignment_8();
			state._fsp--;

			}

			 after(grammarAccess.getSmallRepetitionStatementAccess().getInvariantAssignment_8()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__8__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__9"
	// InternalDsl.g:4632:1: rule__SmallRepetitionStatement__Group__9 : rule__SmallRepetitionStatement__Group__9__Impl rule__SmallRepetitionStatement__Group__10 ;
	public final void rule__SmallRepetitionStatement__Group__9() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4636:2: ( rule__SmallRepetitionStatement__Group__9__Impl rule__SmallRepetitionStatement__Group__10 )
			// InternalDsl.g:4637:2: rule__SmallRepetitionStatement__Group__9__Impl rule__SmallRepetitionStatement__Group__10
			{
			pushFollow(FOLLOW_50);
			rule__SmallRepetitionStatement__Group__9__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__10();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__9"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__9__Impl"
	// InternalDsl.g:4644:1: rule__SmallRepetitionStatement__Group__9__Impl : ( ']' ) ;
	public final void rule__SmallRepetitionStatement__Group__9__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4648:2: ( ( ']' ) )
			// InternalDsl.g:4649:2: ( ']' )
			{
			// InternalDsl.g:4649:2: ( ']' )
			// InternalDsl.g:4650:2: ']'
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getRightSquareBracketKeyword_9()); 
			match(input,35,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getRightSquareBracketKeyword_9()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__9__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__10"
	// InternalDsl.g:4659:1: rule__SmallRepetitionStatement__Group__10 : rule__SmallRepetitionStatement__Group__10__Impl rule__SmallRepetitionStatement__Group__11 ;
	public final void rule__SmallRepetitionStatement__Group__10() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4663:2: ( rule__SmallRepetitionStatement__Group__10__Impl rule__SmallRepetitionStatement__Group__11 )
			// InternalDsl.g:4664:2: rule__SmallRepetitionStatement__Group__10__Impl rule__SmallRepetitionStatement__Group__11
			{
			pushFollow(FOLLOW_33);
			rule__SmallRepetitionStatement__Group__10__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__11();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__10"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__10__Impl"
	// InternalDsl.g:4671:1: rule__SmallRepetitionStatement__Group__10__Impl : ( 'var:' ) ;
	public final void rule__SmallRepetitionStatement__Group__10__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4675:2: ( ( 'var:' ) )
			// InternalDsl.g:4676:2: ( 'var:' )
			{
			// InternalDsl.g:4676:2: ( 'var:' )
			// InternalDsl.g:4677:2: 'var:'
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getVarKeyword_10()); 
			match(input,52,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getVarKeyword_10()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__10__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__11"
	// InternalDsl.g:4686:1: rule__SmallRepetitionStatement__Group__11 : rule__SmallRepetitionStatement__Group__11__Impl rule__SmallRepetitionStatement__Group__12 ;
	public final void rule__SmallRepetitionStatement__Group__11() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4690:2: ( rule__SmallRepetitionStatement__Group__11__Impl rule__SmallRepetitionStatement__Group__12 )
			// InternalDsl.g:4691:2: rule__SmallRepetitionStatement__Group__11__Impl rule__SmallRepetitionStatement__Group__12
			{
			pushFollow(FOLLOW_4);
			rule__SmallRepetitionStatement__Group__11__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__12();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__11"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__11__Impl"
	// InternalDsl.g:4698:1: rule__SmallRepetitionStatement__Group__11__Impl : ( '[' ) ;
	public final void rule__SmallRepetitionStatement__Group__11__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4702:2: ( ( '[' ) )
			// InternalDsl.g:4703:2: ( '[' )
			{
			// InternalDsl.g:4703:2: ( '[' )
			// InternalDsl.g:4704:2: '['
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getLeftSquareBracketKeyword_11()); 
			match(input,34,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getLeftSquareBracketKeyword_11()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__11__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__12"
	// InternalDsl.g:4713:1: rule__SmallRepetitionStatement__Group__12 : rule__SmallRepetitionStatement__Group__12__Impl rule__SmallRepetitionStatement__Group__13 ;
	public final void rule__SmallRepetitionStatement__Group__12() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4717:2: ( rule__SmallRepetitionStatement__Group__12__Impl rule__SmallRepetitionStatement__Group__13 )
			// InternalDsl.g:4718:2: rule__SmallRepetitionStatement__Group__12__Impl rule__SmallRepetitionStatement__Group__13
			{
			pushFollow(FOLLOW_18);
			rule__SmallRepetitionStatement__Group__12__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__13();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__12"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__12__Impl"
	// InternalDsl.g:4725:1: rule__SmallRepetitionStatement__Group__12__Impl : ( ( rule__SmallRepetitionStatement__VariantAssignment_12 ) ) ;
	public final void rule__SmallRepetitionStatement__Group__12__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4729:2: ( ( ( rule__SmallRepetitionStatement__VariantAssignment_12 ) ) )
			// InternalDsl.g:4730:2: ( ( rule__SmallRepetitionStatement__VariantAssignment_12 ) )
			{
			// InternalDsl.g:4730:2: ( ( rule__SmallRepetitionStatement__VariantAssignment_12 ) )
			// InternalDsl.g:4731:2: ( rule__SmallRepetitionStatement__VariantAssignment_12 )
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getVariantAssignment_12()); 
			// InternalDsl.g:4732:2: ( rule__SmallRepetitionStatement__VariantAssignment_12 )
			// InternalDsl.g:4732:3: rule__SmallRepetitionStatement__VariantAssignment_12
			{
			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__VariantAssignment_12();
			state._fsp--;

			}

			 after(grammarAccess.getSmallRepetitionStatementAccess().getVariantAssignment_12()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__12__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__13"
	// InternalDsl.g:4740:1: rule__SmallRepetitionStatement__Group__13 : rule__SmallRepetitionStatement__Group__13__Impl rule__SmallRepetitionStatement__Group__14 ;
	public final void rule__SmallRepetitionStatement__Group__13() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4744:2: ( rule__SmallRepetitionStatement__Group__13__Impl rule__SmallRepetitionStatement__Group__14 )
			// InternalDsl.g:4745:2: rule__SmallRepetitionStatement__Group__13__Impl rule__SmallRepetitionStatement__Group__14
			{
			pushFollow(FOLLOW_6);
			rule__SmallRepetitionStatement__Group__13__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__14();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__13"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__13__Impl"
	// InternalDsl.g:4752:1: rule__SmallRepetitionStatement__Group__13__Impl : ( ']' ) ;
	public final void rule__SmallRepetitionStatement__Group__13__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4756:2: ( ( ']' ) )
			// InternalDsl.g:4757:2: ( ']' )
			{
			// InternalDsl.g:4757:2: ( ']' )
			// InternalDsl.g:4758:2: ']'
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getRightSquareBracketKeyword_13()); 
			match(input,35,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getRightSquareBracketKeyword_13()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__13__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__14"
	// InternalDsl.g:4767:1: rule__SmallRepetitionStatement__Group__14 : rule__SmallRepetitionStatement__Group__14__Impl rule__SmallRepetitionStatement__Group__15 ;
	public final void rule__SmallRepetitionStatement__Group__14() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4771:2: ( rule__SmallRepetitionStatement__Group__14__Impl rule__SmallRepetitionStatement__Group__15 )
			// InternalDsl.g:4772:2: rule__SmallRepetitionStatement__Group__14__Impl rule__SmallRepetitionStatement__Group__15
			{
			pushFollow(FOLLOW_8);
			rule__SmallRepetitionStatement__Group__14__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__15();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__14"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__14__Impl"
	// InternalDsl.g:4779:1: rule__SmallRepetitionStatement__Group__14__Impl : ( '{' ) ;
	public final void rule__SmallRepetitionStatement__Group__14__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4783:2: ( ( '{' ) )
			// InternalDsl.g:4784:2: ( '{' )
			{
			// InternalDsl.g:4784:2: ( '{' )
			// InternalDsl.g:4785:2: '{'
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getLeftCurlyBracketKeyword_14()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getLeftCurlyBracketKeyword_14()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__14__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__15"
	// InternalDsl.g:4794:1: rule__SmallRepetitionStatement__Group__15 : rule__SmallRepetitionStatement__Group__15__Impl rule__SmallRepetitionStatement__Group__16 ;
	public final void rule__SmallRepetitionStatement__Group__15() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4798:2: ( rule__SmallRepetitionStatement__Group__15__Impl rule__SmallRepetitionStatement__Group__16 )
			// InternalDsl.g:4799:2: rule__SmallRepetitionStatement__Group__15__Impl rule__SmallRepetitionStatement__Group__16
			{
			pushFollow(FOLLOW_7);
			rule__SmallRepetitionStatement__Group__15__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__16();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__15"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__15__Impl"
	// InternalDsl.g:4806:1: rule__SmallRepetitionStatement__Group__15__Impl : ( ( rule__SmallRepetitionStatement__LoopStatementAssignment_15 ) ) ;
	public final void rule__SmallRepetitionStatement__Group__15__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4810:2: ( ( ( rule__SmallRepetitionStatement__LoopStatementAssignment_15 ) ) )
			// InternalDsl.g:4811:2: ( ( rule__SmallRepetitionStatement__LoopStatementAssignment_15 ) )
			{
			// InternalDsl.g:4811:2: ( ( rule__SmallRepetitionStatement__LoopStatementAssignment_15 ) )
			// InternalDsl.g:4812:2: ( rule__SmallRepetitionStatement__LoopStatementAssignment_15 )
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getLoopStatementAssignment_15()); 
			// InternalDsl.g:4813:2: ( rule__SmallRepetitionStatement__LoopStatementAssignment_15 )
			// InternalDsl.g:4813:3: rule__SmallRepetitionStatement__LoopStatementAssignment_15
			{
			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__LoopStatementAssignment_15();
			state._fsp--;

			}

			 after(grammarAccess.getSmallRepetitionStatementAccess().getLoopStatementAssignment_15()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__15__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__16"
	// InternalDsl.g:4821:1: rule__SmallRepetitionStatement__Group__16 : rule__SmallRepetitionStatement__Group__16__Impl rule__SmallRepetitionStatement__Group__17 ;
	public final void rule__SmallRepetitionStatement__Group__16() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4825:2: ( rule__SmallRepetitionStatement__Group__16__Impl rule__SmallRepetitionStatement__Group__17 )
			// InternalDsl.g:4826:2: rule__SmallRepetitionStatement__Group__16__Impl rule__SmallRepetitionStatement__Group__17
			{
			pushFollow(FOLLOW_51);
			rule__SmallRepetitionStatement__Group__16__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__17();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__16"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__16__Impl"
	// InternalDsl.g:4833:1: rule__SmallRepetitionStatement__Group__16__Impl : ( '}' ) ;
	public final void rule__SmallRepetitionStatement__Group__16__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4837:2: ( ( '}' ) )
			// InternalDsl.g:4838:2: ( '}' )
			{
			// InternalDsl.g:4838:2: ( '}' )
			// InternalDsl.g:4839:2: '}'
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getRightCurlyBracketKeyword_16()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getRightCurlyBracketKeyword_16()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__16__Impl"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__17"
	// InternalDsl.g:4848:1: rule__SmallRepetitionStatement__Group__17 : rule__SmallRepetitionStatement__Group__17__Impl ;
	public final void rule__SmallRepetitionStatement__Group__17() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4852:2: ( rule__SmallRepetitionStatement__Group__17__Impl )
			// InternalDsl.g:4853:2: rule__SmallRepetitionStatement__Group__17__Impl
			{
			pushFollow(FOLLOW_2);
			rule__SmallRepetitionStatement__Group__17__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__17"



	// $ANTLR start "rule__SmallRepetitionStatement__Group__17__Impl"
	// InternalDsl.g:4859:1: rule__SmallRepetitionStatement__Group__17__Impl : ( 'od' ) ;
	public final void rule__SmallRepetitionStatement__Group__17__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4863:2: ( ( 'od' ) )
			// InternalDsl.g:4864:2: ( 'od' )
			{
			// InternalDsl.g:4864:2: ( 'od' )
			// InternalDsl.g:4865:2: 'od'
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getOdKeyword_17()); 
			match(input,45,FOLLOW_2); 
			 after(grammarAccess.getSmallRepetitionStatementAccess().getOdKeyword_17()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__Group__17__Impl"



	// $ANTLR start "rule__Variant__Group__0"
	// InternalDsl.g:4875:1: rule__Variant__Group__0 : rule__Variant__Group__0__Impl rule__Variant__Group__1 ;
	public final void rule__Variant__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4879:2: ( rule__Variant__Group__0__Impl rule__Variant__Group__1 )
			// InternalDsl.g:4880:2: rule__Variant__Group__0__Impl rule__Variant__Group__1
			{
			pushFollow(FOLLOW_4);
			rule__Variant__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Variant__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Variant__Group__0"



	// $ANTLR start "rule__Variant__Group__0__Impl"
	// InternalDsl.g:4887:1: rule__Variant__Group__0__Impl : ( () ) ;
	public final void rule__Variant__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4891:2: ( ( () ) )
			// InternalDsl.g:4892:2: ( () )
			{
			// InternalDsl.g:4892:2: ( () )
			// InternalDsl.g:4893:2: ()
			{
			 before(grammarAccess.getVariantAccess().getVariantAction_0()); 
			// InternalDsl.g:4894:2: ()
			// InternalDsl.g:4894:3: 
			{
			}

			 after(grammarAccess.getVariantAccess().getVariantAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Variant__Group__0__Impl"



	// $ANTLR start "rule__Variant__Group__1"
	// InternalDsl.g:4902:1: rule__Variant__Group__1 : rule__Variant__Group__1__Impl ;
	public final void rule__Variant__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4906:2: ( rule__Variant__Group__1__Impl )
			// InternalDsl.g:4907:2: rule__Variant__Group__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__Variant__Group__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Variant__Group__1"



	// $ANTLR start "rule__Variant__Group__1__Impl"
	// InternalDsl.g:4913:1: rule__Variant__Group__1__Impl : ( ( rule__Variant__NameAssignment_1 ) ) ;
	public final void rule__Variant__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4917:2: ( ( ( rule__Variant__NameAssignment_1 ) ) )
			// InternalDsl.g:4918:2: ( ( rule__Variant__NameAssignment_1 ) )
			{
			// InternalDsl.g:4918:2: ( ( rule__Variant__NameAssignment_1 ) )
			// InternalDsl.g:4919:2: ( rule__Variant__NameAssignment_1 )
			{
			 before(grammarAccess.getVariantAccess().getNameAssignment_1()); 
			// InternalDsl.g:4920:2: ( rule__Variant__NameAssignment_1 )
			// InternalDsl.g:4920:3: rule__Variant__NameAssignment_1
			{
			pushFollow(FOLLOW_2);
			rule__Variant__NameAssignment_1();
			state._fsp--;

			}

			 after(grammarAccess.getVariantAccess().getNameAssignment_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Variant__Group__1__Impl"



	// $ANTLR start "rule__JavaVariables__Group__0"
	// InternalDsl.g:4929:1: rule__JavaVariables__Group__0 : rule__JavaVariables__Group__0__Impl rule__JavaVariables__Group__1 ;
	public final void rule__JavaVariables__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4933:2: ( rule__JavaVariables__Group__0__Impl rule__JavaVariables__Group__1 )
			// InternalDsl.g:4934:2: rule__JavaVariables__Group__0__Impl rule__JavaVariables__Group__1
			{
			pushFollow(FOLLOW_52);
			rule__JavaVariables__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JavaVariables__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group__0"



	// $ANTLR start "rule__JavaVariables__Group__0__Impl"
	// InternalDsl.g:4941:1: rule__JavaVariables__Group__0__Impl : ( () ) ;
	public final void rule__JavaVariables__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4945:2: ( ( () ) )
			// InternalDsl.g:4946:2: ( () )
			{
			// InternalDsl.g:4946:2: ( () )
			// InternalDsl.g:4947:2: ()
			{
			 before(grammarAccess.getJavaVariablesAccess().getJavaVariablesAction_0()); 
			// InternalDsl.g:4948:2: ()
			// InternalDsl.g:4948:3: 
			{
			}

			 after(grammarAccess.getJavaVariablesAccess().getJavaVariablesAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group__0__Impl"



	// $ANTLR start "rule__JavaVariables__Group__1"
	// InternalDsl.g:4956:1: rule__JavaVariables__Group__1 : rule__JavaVariables__Group__1__Impl rule__JavaVariables__Group__2 ;
	public final void rule__JavaVariables__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4960:2: ( rule__JavaVariables__Group__1__Impl rule__JavaVariables__Group__2 )
			// InternalDsl.g:4961:2: rule__JavaVariables__Group__1__Impl rule__JavaVariables__Group__2
			{
			pushFollow(FOLLOW_53);
			rule__JavaVariables__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JavaVariables__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group__1"



	// $ANTLR start "rule__JavaVariables__Group__1__Impl"
	// InternalDsl.g:4968:1: rule__JavaVariables__Group__1__Impl : ( 'JavaVariables' ) ;
	public final void rule__JavaVariables__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4972:2: ( ( 'JavaVariables' ) )
			// InternalDsl.g:4973:2: ( 'JavaVariables' )
			{
			// InternalDsl.g:4973:2: ( 'JavaVariables' )
			// InternalDsl.g:4974:2: 'JavaVariables'
			{
			 before(grammarAccess.getJavaVariablesAccess().getJavaVariablesKeyword_1()); 
			match(input,32,FOLLOW_2); 
			 after(grammarAccess.getJavaVariablesAccess().getJavaVariablesKeyword_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group__1__Impl"



	// $ANTLR start "rule__JavaVariables__Group__2"
	// InternalDsl.g:4983:1: rule__JavaVariables__Group__2 : rule__JavaVariables__Group__2__Impl ;
	public final void rule__JavaVariables__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4987:2: ( rule__JavaVariables__Group__2__Impl )
			// InternalDsl.g:4988:2: rule__JavaVariables__Group__2__Impl
			{
			pushFollow(FOLLOW_2);
			rule__JavaVariables__Group__2__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group__2"



	// $ANTLR start "rule__JavaVariables__Group__2__Impl"
	// InternalDsl.g:4994:1: rule__JavaVariables__Group__2__Impl : ( ( rule__JavaVariables__Group_2__0 )? ) ;
	public final void rule__JavaVariables__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:4998:2: ( ( ( rule__JavaVariables__Group_2__0 )? ) )
			// InternalDsl.g:4999:2: ( ( rule__JavaVariables__Group_2__0 )? )
			{
			// InternalDsl.g:4999:2: ( ( rule__JavaVariables__Group_2__0 )? )
			// InternalDsl.g:5000:2: ( rule__JavaVariables__Group_2__0 )?
			{
			 before(grammarAccess.getJavaVariablesAccess().getGroup_2()); 
			// InternalDsl.g:5001:2: ( rule__JavaVariables__Group_2__0 )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==53) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// InternalDsl.g:5001:3: rule__JavaVariables__Group_2__0
					{
					pushFollow(FOLLOW_2);
					rule__JavaVariables__Group_2__0();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getJavaVariablesAccess().getGroup_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group__2__Impl"



	// $ANTLR start "rule__JavaVariables__Group_2__0"
	// InternalDsl.g:5010:1: rule__JavaVariables__Group_2__0 : rule__JavaVariables__Group_2__0__Impl rule__JavaVariables__Group_2__1 ;
	public final void rule__JavaVariables__Group_2__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5014:2: ( rule__JavaVariables__Group_2__0__Impl rule__JavaVariables__Group_2__1 )
			// InternalDsl.g:5015:2: rule__JavaVariables__Group_2__0__Impl rule__JavaVariables__Group_2__1
			{
			pushFollow(FOLLOW_6);
			rule__JavaVariables__Group_2__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JavaVariables__Group_2__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2__0"



	// $ANTLR start "rule__JavaVariables__Group_2__0__Impl"
	// InternalDsl.g:5022:1: rule__JavaVariables__Group_2__0__Impl : ( 'variables' ) ;
	public final void rule__JavaVariables__Group_2__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5026:2: ( ( 'variables' ) )
			// InternalDsl.g:5027:2: ( 'variables' )
			{
			// InternalDsl.g:5027:2: ( 'variables' )
			// InternalDsl.g:5028:2: 'variables'
			{
			 before(grammarAccess.getJavaVariablesAccess().getVariablesKeyword_2_0()); 
			match(input,53,FOLLOW_2); 
			 after(grammarAccess.getJavaVariablesAccess().getVariablesKeyword_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2__0__Impl"



	// $ANTLR start "rule__JavaVariables__Group_2__1"
	// InternalDsl.g:5037:1: rule__JavaVariables__Group_2__1 : rule__JavaVariables__Group_2__1__Impl rule__JavaVariables__Group_2__2 ;
	public final void rule__JavaVariables__Group_2__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5041:2: ( rule__JavaVariables__Group_2__1__Impl rule__JavaVariables__Group_2__2 )
			// InternalDsl.g:5042:2: rule__JavaVariables__Group_2__1__Impl rule__JavaVariables__Group_2__2
			{
			pushFollow(FOLLOW_4);
			rule__JavaVariables__Group_2__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JavaVariables__Group_2__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2__1"



	// $ANTLR start "rule__JavaVariables__Group_2__1__Impl"
	// InternalDsl.g:5049:1: rule__JavaVariables__Group_2__1__Impl : ( '{' ) ;
	public final void rule__JavaVariables__Group_2__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5053:2: ( ( '{' ) )
			// InternalDsl.g:5054:2: ( '{' )
			{
			// InternalDsl.g:5054:2: ( '{' )
			// InternalDsl.g:5055:2: '{'
			{
			 before(grammarAccess.getJavaVariablesAccess().getLeftCurlyBracketKeyword_2_1()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getJavaVariablesAccess().getLeftCurlyBracketKeyword_2_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2__1__Impl"



	// $ANTLR start "rule__JavaVariables__Group_2__2"
	// InternalDsl.g:5064:1: rule__JavaVariables__Group_2__2 : rule__JavaVariables__Group_2__2__Impl rule__JavaVariables__Group_2__3 ;
	public final void rule__JavaVariables__Group_2__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5068:2: ( rule__JavaVariables__Group_2__2__Impl rule__JavaVariables__Group_2__3 )
			// InternalDsl.g:5069:2: rule__JavaVariables__Group_2__2__Impl rule__JavaVariables__Group_2__3
			{
			pushFollow(FOLLOW_54);
			rule__JavaVariables__Group_2__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JavaVariables__Group_2__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2__2"



	// $ANTLR start "rule__JavaVariables__Group_2__2__Impl"
	// InternalDsl.g:5076:1: rule__JavaVariables__Group_2__2__Impl : ( ( rule__JavaVariables__VariablesAssignment_2_2 ) ) ;
	public final void rule__JavaVariables__Group_2__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5080:2: ( ( ( rule__JavaVariables__VariablesAssignment_2_2 ) ) )
			// InternalDsl.g:5081:2: ( ( rule__JavaVariables__VariablesAssignment_2_2 ) )
			{
			// InternalDsl.g:5081:2: ( ( rule__JavaVariables__VariablesAssignment_2_2 ) )
			// InternalDsl.g:5082:2: ( rule__JavaVariables__VariablesAssignment_2_2 )
			{
			 before(grammarAccess.getJavaVariablesAccess().getVariablesAssignment_2_2()); 
			// InternalDsl.g:5083:2: ( rule__JavaVariables__VariablesAssignment_2_2 )
			// InternalDsl.g:5083:3: rule__JavaVariables__VariablesAssignment_2_2
			{
			pushFollow(FOLLOW_2);
			rule__JavaVariables__VariablesAssignment_2_2();
			state._fsp--;

			}

			 after(grammarAccess.getJavaVariablesAccess().getVariablesAssignment_2_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2__2__Impl"



	// $ANTLR start "rule__JavaVariables__Group_2__3"
	// InternalDsl.g:5091:1: rule__JavaVariables__Group_2__3 : rule__JavaVariables__Group_2__3__Impl rule__JavaVariables__Group_2__4 ;
	public final void rule__JavaVariables__Group_2__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5095:2: ( rule__JavaVariables__Group_2__3__Impl rule__JavaVariables__Group_2__4 )
			// InternalDsl.g:5096:2: rule__JavaVariables__Group_2__3__Impl rule__JavaVariables__Group_2__4
			{
			pushFollow(FOLLOW_7);
			rule__JavaVariables__Group_2__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JavaVariables__Group_2__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2__3"



	// $ANTLR start "rule__JavaVariables__Group_2__3__Impl"
	// InternalDsl.g:5103:1: rule__JavaVariables__Group_2__3__Impl : ( ( rule__JavaVariables__Group_2_3__0 )* ) ;
	public final void rule__JavaVariables__Group_2__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5107:2: ( ( ( rule__JavaVariables__Group_2_3__0 )* ) )
			// InternalDsl.g:5108:2: ( ( rule__JavaVariables__Group_2_3__0 )* )
			{
			// InternalDsl.g:5108:2: ( ( rule__JavaVariables__Group_2_3__0 )* )
			// InternalDsl.g:5109:2: ( rule__JavaVariables__Group_2_3__0 )*
			{
			 before(grammarAccess.getJavaVariablesAccess().getGroup_2_3()); 
			// InternalDsl.g:5110:2: ( rule__JavaVariables__Group_2_3__0 )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==19) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// InternalDsl.g:5110:3: rule__JavaVariables__Group_2_3__0
					{
					pushFollow(FOLLOW_28);
					rule__JavaVariables__Group_2_3__0();
					state._fsp--;

					}
					break;

				default :
					break loop32;
				}
			}

			 after(grammarAccess.getJavaVariablesAccess().getGroup_2_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2__3__Impl"



	// $ANTLR start "rule__JavaVariables__Group_2__4"
	// InternalDsl.g:5118:1: rule__JavaVariables__Group_2__4 : rule__JavaVariables__Group_2__4__Impl ;
	public final void rule__JavaVariables__Group_2__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5122:2: ( rule__JavaVariables__Group_2__4__Impl )
			// InternalDsl.g:5123:2: rule__JavaVariables__Group_2__4__Impl
			{
			pushFollow(FOLLOW_2);
			rule__JavaVariables__Group_2__4__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2__4"



	// $ANTLR start "rule__JavaVariables__Group_2__4__Impl"
	// InternalDsl.g:5129:1: rule__JavaVariables__Group_2__4__Impl : ( '}' ) ;
	public final void rule__JavaVariables__Group_2__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5133:2: ( ( '}' ) )
			// InternalDsl.g:5134:2: ( '}' )
			{
			// InternalDsl.g:5134:2: ( '}' )
			// InternalDsl.g:5135:2: '}'
			{
			 before(grammarAccess.getJavaVariablesAccess().getRightCurlyBracketKeyword_2_4()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getJavaVariablesAccess().getRightCurlyBracketKeyword_2_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2__4__Impl"



	// $ANTLR start "rule__JavaVariables__Group_2_3__0"
	// InternalDsl.g:5145:1: rule__JavaVariables__Group_2_3__0 : rule__JavaVariables__Group_2_3__0__Impl rule__JavaVariables__Group_2_3__1 ;
	public final void rule__JavaVariables__Group_2_3__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5149:2: ( rule__JavaVariables__Group_2_3__0__Impl rule__JavaVariables__Group_2_3__1 )
			// InternalDsl.g:5150:2: rule__JavaVariables__Group_2_3__0__Impl rule__JavaVariables__Group_2_3__1
			{
			pushFollow(FOLLOW_4);
			rule__JavaVariables__Group_2_3__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JavaVariables__Group_2_3__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2_3__0"



	// $ANTLR start "rule__JavaVariables__Group_2_3__0__Impl"
	// InternalDsl.g:5157:1: rule__JavaVariables__Group_2_3__0__Impl : ( ',' ) ;
	public final void rule__JavaVariables__Group_2_3__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5161:2: ( ( ',' ) )
			// InternalDsl.g:5162:2: ( ',' )
			{
			// InternalDsl.g:5162:2: ( ',' )
			// InternalDsl.g:5163:2: ','
			{
			 before(grammarAccess.getJavaVariablesAccess().getCommaKeyword_2_3_0()); 
			match(input,19,FOLLOW_2); 
			 after(grammarAccess.getJavaVariablesAccess().getCommaKeyword_2_3_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2_3__0__Impl"



	// $ANTLR start "rule__JavaVariables__Group_2_3__1"
	// InternalDsl.g:5172:1: rule__JavaVariables__Group_2_3__1 : rule__JavaVariables__Group_2_3__1__Impl ;
	public final void rule__JavaVariables__Group_2_3__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5176:2: ( rule__JavaVariables__Group_2_3__1__Impl )
			// InternalDsl.g:5177:2: rule__JavaVariables__Group_2_3__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__JavaVariables__Group_2_3__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2_3__1"



	// $ANTLR start "rule__JavaVariables__Group_2_3__1__Impl"
	// InternalDsl.g:5183:1: rule__JavaVariables__Group_2_3__1__Impl : ( ( rule__JavaVariables__VariablesAssignment_2_3_1 ) ) ;
	public final void rule__JavaVariables__Group_2_3__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5187:2: ( ( ( rule__JavaVariables__VariablesAssignment_2_3_1 ) ) )
			// InternalDsl.g:5188:2: ( ( rule__JavaVariables__VariablesAssignment_2_3_1 ) )
			{
			// InternalDsl.g:5188:2: ( ( rule__JavaVariables__VariablesAssignment_2_3_1 ) )
			// InternalDsl.g:5189:2: ( rule__JavaVariables__VariablesAssignment_2_3_1 )
			{
			 before(grammarAccess.getJavaVariablesAccess().getVariablesAssignment_2_3_1()); 
			// InternalDsl.g:5190:2: ( rule__JavaVariables__VariablesAssignment_2_3_1 )
			// InternalDsl.g:5190:3: rule__JavaVariables__VariablesAssignment_2_3_1
			{
			pushFollow(FOLLOW_2);
			rule__JavaVariables__VariablesAssignment_2_3_1();
			state._fsp--;

			}

			 after(grammarAccess.getJavaVariablesAccess().getVariablesAssignment_2_3_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__Group_2_3__1__Impl"



	// $ANTLR start "rule__JavaVariable__Group__0"
	// InternalDsl.g:5199:1: rule__JavaVariable__Group__0 : rule__JavaVariable__Group__0__Impl rule__JavaVariable__Group__1 ;
	public final void rule__JavaVariable__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5203:2: ( rule__JavaVariable__Group__0__Impl rule__JavaVariable__Group__1 )
			// InternalDsl.g:5204:2: rule__JavaVariable__Group__0__Impl rule__JavaVariable__Group__1
			{
			pushFollow(FOLLOW_4);
			rule__JavaVariable__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__JavaVariable__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariable__Group__0"



	// $ANTLR start "rule__JavaVariable__Group__0__Impl"
	// InternalDsl.g:5211:1: rule__JavaVariable__Group__0__Impl : ( () ) ;
	public final void rule__JavaVariable__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5215:2: ( ( () ) )
			// InternalDsl.g:5216:2: ( () )
			{
			// InternalDsl.g:5216:2: ( () )
			// InternalDsl.g:5217:2: ()
			{
			 before(grammarAccess.getJavaVariableAccess().getJavaVariableAction_0()); 
			// InternalDsl.g:5218:2: ()
			// InternalDsl.g:5218:3: 
			{
			}

			 after(grammarAccess.getJavaVariableAccess().getJavaVariableAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariable__Group__0__Impl"



	// $ANTLR start "rule__JavaVariable__Group__1"
	// InternalDsl.g:5226:1: rule__JavaVariable__Group__1 : rule__JavaVariable__Group__1__Impl ;
	public final void rule__JavaVariable__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5230:2: ( rule__JavaVariable__Group__1__Impl )
			// InternalDsl.g:5231:2: rule__JavaVariable__Group__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__JavaVariable__Group__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariable__Group__1"



	// $ANTLR start "rule__JavaVariable__Group__1__Impl"
	// InternalDsl.g:5237:1: rule__JavaVariable__Group__1__Impl : ( ( rule__JavaVariable__NameAssignment_1 ) ) ;
	public final void rule__JavaVariable__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5241:2: ( ( ( rule__JavaVariable__NameAssignment_1 ) ) )
			// InternalDsl.g:5242:2: ( ( rule__JavaVariable__NameAssignment_1 ) )
			{
			// InternalDsl.g:5242:2: ( ( rule__JavaVariable__NameAssignment_1 ) )
			// InternalDsl.g:5243:2: ( rule__JavaVariable__NameAssignment_1 )
			{
			 before(grammarAccess.getJavaVariableAccess().getNameAssignment_1()); 
			// InternalDsl.g:5244:2: ( rule__JavaVariable__NameAssignment_1 )
			// InternalDsl.g:5244:3: rule__JavaVariable__NameAssignment_1
			{
			pushFollow(FOLLOW_2);
			rule__JavaVariable__NameAssignment_1();
			state._fsp--;

			}

			 after(grammarAccess.getJavaVariableAccess().getNameAssignment_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariable__Group__1__Impl"



	// $ANTLR start "rule__GlobalConditions__Group__0"
	// InternalDsl.g:5253:1: rule__GlobalConditions__Group__0 : rule__GlobalConditions__Group__0__Impl rule__GlobalConditions__Group__1 ;
	public final void rule__GlobalConditions__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5257:2: ( rule__GlobalConditions__Group__0__Impl rule__GlobalConditions__Group__1 )
			// InternalDsl.g:5258:2: rule__GlobalConditions__Group__0__Impl rule__GlobalConditions__Group__1
			{
			pushFollow(FOLLOW_55);
			rule__GlobalConditions__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__GlobalConditions__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group__0"



	// $ANTLR start "rule__GlobalConditions__Group__0__Impl"
	// InternalDsl.g:5265:1: rule__GlobalConditions__Group__0__Impl : ( () ) ;
	public final void rule__GlobalConditions__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5269:2: ( ( () ) )
			// InternalDsl.g:5270:2: ( () )
			{
			// InternalDsl.g:5270:2: ( () )
			// InternalDsl.g:5271:2: ()
			{
			 before(grammarAccess.getGlobalConditionsAccess().getGlobalConditionsAction_0()); 
			// InternalDsl.g:5272:2: ()
			// InternalDsl.g:5272:3: 
			{
			}

			 after(grammarAccess.getGlobalConditionsAccess().getGlobalConditionsAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group__0__Impl"



	// $ANTLR start "rule__GlobalConditions__Group__1"
	// InternalDsl.g:5280:1: rule__GlobalConditions__Group__1 : rule__GlobalConditions__Group__1__Impl rule__GlobalConditions__Group__2 ;
	public final void rule__GlobalConditions__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5284:2: ( rule__GlobalConditions__Group__1__Impl rule__GlobalConditions__Group__2 )
			// InternalDsl.g:5285:2: rule__GlobalConditions__Group__1__Impl rule__GlobalConditions__Group__2
			{
			pushFollow(FOLLOW_56);
			rule__GlobalConditions__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__GlobalConditions__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group__1"



	// $ANTLR start "rule__GlobalConditions__Group__1__Impl"
	// InternalDsl.g:5292:1: rule__GlobalConditions__Group__1__Impl : ( 'GlobalConditions' ) ;
	public final void rule__GlobalConditions__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5296:2: ( ( 'GlobalConditions' ) )
			// InternalDsl.g:5297:2: ( 'GlobalConditions' )
			{
			// InternalDsl.g:5297:2: ( 'GlobalConditions' )
			// InternalDsl.g:5298:2: 'GlobalConditions'
			{
			 before(grammarAccess.getGlobalConditionsAccess().getGlobalConditionsKeyword_1()); 
			match(input,31,FOLLOW_2); 
			 after(grammarAccess.getGlobalConditionsAccess().getGlobalConditionsKeyword_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group__1__Impl"



	// $ANTLR start "rule__GlobalConditions__Group__2"
	// InternalDsl.g:5307:1: rule__GlobalConditions__Group__2 : rule__GlobalConditions__Group__2__Impl ;
	public final void rule__GlobalConditions__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5311:2: ( rule__GlobalConditions__Group__2__Impl )
			// InternalDsl.g:5312:2: rule__GlobalConditions__Group__2__Impl
			{
			pushFollow(FOLLOW_2);
			rule__GlobalConditions__Group__2__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group__2"



	// $ANTLR start "rule__GlobalConditions__Group__2__Impl"
	// InternalDsl.g:5318:1: rule__GlobalConditions__Group__2__Impl : ( ( rule__GlobalConditions__Group_2__0 )? ) ;
	public final void rule__GlobalConditions__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5322:2: ( ( ( rule__GlobalConditions__Group_2__0 )? ) )
			// InternalDsl.g:5323:2: ( ( rule__GlobalConditions__Group_2__0 )? )
			{
			// InternalDsl.g:5323:2: ( ( rule__GlobalConditions__Group_2__0 )? )
			// InternalDsl.g:5324:2: ( rule__GlobalConditions__Group_2__0 )?
			{
			 before(grammarAccess.getGlobalConditionsAccess().getGroup_2()); 
			// InternalDsl.g:5325:2: ( rule__GlobalConditions__Group_2__0 )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==36) ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// InternalDsl.g:5325:3: rule__GlobalConditions__Group_2__0
					{
					pushFollow(FOLLOW_2);
					rule__GlobalConditions__Group_2__0();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getGlobalConditionsAccess().getGroup_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group__2__Impl"



	// $ANTLR start "rule__GlobalConditions__Group_2__0"
	// InternalDsl.g:5334:1: rule__GlobalConditions__Group_2__0 : rule__GlobalConditions__Group_2__0__Impl rule__GlobalConditions__Group_2__1 ;
	public final void rule__GlobalConditions__Group_2__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5338:2: ( rule__GlobalConditions__Group_2__0__Impl rule__GlobalConditions__Group_2__1 )
			// InternalDsl.g:5339:2: rule__GlobalConditions__Group_2__0__Impl rule__GlobalConditions__Group_2__1
			{
			pushFollow(FOLLOW_6);
			rule__GlobalConditions__Group_2__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__GlobalConditions__Group_2__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2__0"



	// $ANTLR start "rule__GlobalConditions__Group_2__0__Impl"
	// InternalDsl.g:5346:1: rule__GlobalConditions__Group_2__0__Impl : ( 'conditions' ) ;
	public final void rule__GlobalConditions__Group_2__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5350:2: ( ( 'conditions' ) )
			// InternalDsl.g:5351:2: ( 'conditions' )
			{
			// InternalDsl.g:5351:2: ( 'conditions' )
			// InternalDsl.g:5352:2: 'conditions'
			{
			 before(grammarAccess.getGlobalConditionsAccess().getConditionsKeyword_2_0()); 
			match(input,36,FOLLOW_2); 
			 after(grammarAccess.getGlobalConditionsAccess().getConditionsKeyword_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2__0__Impl"



	// $ANTLR start "rule__GlobalConditions__Group_2__1"
	// InternalDsl.g:5361:1: rule__GlobalConditions__Group_2__1 : rule__GlobalConditions__Group_2__1__Impl rule__GlobalConditions__Group_2__2 ;
	public final void rule__GlobalConditions__Group_2__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5365:2: ( rule__GlobalConditions__Group_2__1__Impl rule__GlobalConditions__Group_2__2 )
			// InternalDsl.g:5366:2: rule__GlobalConditions__Group_2__1__Impl rule__GlobalConditions__Group_2__2
			{
			pushFollow(FOLLOW_4);
			rule__GlobalConditions__Group_2__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__GlobalConditions__Group_2__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2__1"



	// $ANTLR start "rule__GlobalConditions__Group_2__1__Impl"
	// InternalDsl.g:5373:1: rule__GlobalConditions__Group_2__1__Impl : ( '{' ) ;
	public final void rule__GlobalConditions__Group_2__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5377:2: ( ( '{' ) )
			// InternalDsl.g:5378:2: ( '{' )
			{
			// InternalDsl.g:5378:2: ( '{' )
			// InternalDsl.g:5379:2: '{'
			{
			 before(grammarAccess.getGlobalConditionsAccess().getLeftCurlyBracketKeyword_2_1()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getGlobalConditionsAccess().getLeftCurlyBracketKeyword_2_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2__1__Impl"



	// $ANTLR start "rule__GlobalConditions__Group_2__2"
	// InternalDsl.g:5388:1: rule__GlobalConditions__Group_2__2 : rule__GlobalConditions__Group_2__2__Impl rule__GlobalConditions__Group_2__3 ;
	public final void rule__GlobalConditions__Group_2__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5392:2: ( rule__GlobalConditions__Group_2__2__Impl rule__GlobalConditions__Group_2__3 )
			// InternalDsl.g:5393:2: rule__GlobalConditions__Group_2__2__Impl rule__GlobalConditions__Group_2__3
			{
			pushFollow(FOLLOW_54);
			rule__GlobalConditions__Group_2__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__GlobalConditions__Group_2__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2__2"



	// $ANTLR start "rule__GlobalConditions__Group_2__2__Impl"
	// InternalDsl.g:5400:1: rule__GlobalConditions__Group_2__2__Impl : ( ( rule__GlobalConditions__ConditionsAssignment_2_2 ) ) ;
	public final void rule__GlobalConditions__Group_2__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5404:2: ( ( ( rule__GlobalConditions__ConditionsAssignment_2_2 ) ) )
			// InternalDsl.g:5405:2: ( ( rule__GlobalConditions__ConditionsAssignment_2_2 ) )
			{
			// InternalDsl.g:5405:2: ( ( rule__GlobalConditions__ConditionsAssignment_2_2 ) )
			// InternalDsl.g:5406:2: ( rule__GlobalConditions__ConditionsAssignment_2_2 )
			{
			 before(grammarAccess.getGlobalConditionsAccess().getConditionsAssignment_2_2()); 
			// InternalDsl.g:5407:2: ( rule__GlobalConditions__ConditionsAssignment_2_2 )
			// InternalDsl.g:5407:3: rule__GlobalConditions__ConditionsAssignment_2_2
			{
			pushFollow(FOLLOW_2);
			rule__GlobalConditions__ConditionsAssignment_2_2();
			state._fsp--;

			}

			 after(grammarAccess.getGlobalConditionsAccess().getConditionsAssignment_2_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2__2__Impl"



	// $ANTLR start "rule__GlobalConditions__Group_2__3"
	// InternalDsl.g:5415:1: rule__GlobalConditions__Group_2__3 : rule__GlobalConditions__Group_2__3__Impl rule__GlobalConditions__Group_2__4 ;
	public final void rule__GlobalConditions__Group_2__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5419:2: ( rule__GlobalConditions__Group_2__3__Impl rule__GlobalConditions__Group_2__4 )
			// InternalDsl.g:5420:2: rule__GlobalConditions__Group_2__3__Impl rule__GlobalConditions__Group_2__4
			{
			pushFollow(FOLLOW_7);
			rule__GlobalConditions__Group_2__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__GlobalConditions__Group_2__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2__3"



	// $ANTLR start "rule__GlobalConditions__Group_2__3__Impl"
	// InternalDsl.g:5427:1: rule__GlobalConditions__Group_2__3__Impl : ( ( rule__GlobalConditions__Group_2_3__0 )* ) ;
	public final void rule__GlobalConditions__Group_2__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5431:2: ( ( ( rule__GlobalConditions__Group_2_3__0 )* ) )
			// InternalDsl.g:5432:2: ( ( rule__GlobalConditions__Group_2_3__0 )* )
			{
			// InternalDsl.g:5432:2: ( ( rule__GlobalConditions__Group_2_3__0 )* )
			// InternalDsl.g:5433:2: ( rule__GlobalConditions__Group_2_3__0 )*
			{
			 before(grammarAccess.getGlobalConditionsAccess().getGroup_2_3()); 
			// InternalDsl.g:5434:2: ( rule__GlobalConditions__Group_2_3__0 )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==19) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// InternalDsl.g:5434:3: rule__GlobalConditions__Group_2_3__0
					{
					pushFollow(FOLLOW_28);
					rule__GlobalConditions__Group_2_3__0();
					state._fsp--;

					}
					break;

				default :
					break loop34;
				}
			}

			 after(grammarAccess.getGlobalConditionsAccess().getGroup_2_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2__3__Impl"



	// $ANTLR start "rule__GlobalConditions__Group_2__4"
	// InternalDsl.g:5442:1: rule__GlobalConditions__Group_2__4 : rule__GlobalConditions__Group_2__4__Impl ;
	public final void rule__GlobalConditions__Group_2__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5446:2: ( rule__GlobalConditions__Group_2__4__Impl )
			// InternalDsl.g:5447:2: rule__GlobalConditions__Group_2__4__Impl
			{
			pushFollow(FOLLOW_2);
			rule__GlobalConditions__Group_2__4__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2__4"



	// $ANTLR start "rule__GlobalConditions__Group_2__4__Impl"
	// InternalDsl.g:5453:1: rule__GlobalConditions__Group_2__4__Impl : ( '}' ) ;
	public final void rule__GlobalConditions__Group_2__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5457:2: ( ( '}' ) )
			// InternalDsl.g:5458:2: ( '}' )
			{
			// InternalDsl.g:5458:2: ( '}' )
			// InternalDsl.g:5459:2: '}'
			{
			 before(grammarAccess.getGlobalConditionsAccess().getRightCurlyBracketKeyword_2_4()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getGlobalConditionsAccess().getRightCurlyBracketKeyword_2_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2__4__Impl"



	// $ANTLR start "rule__GlobalConditions__Group_2_3__0"
	// InternalDsl.g:5469:1: rule__GlobalConditions__Group_2_3__0 : rule__GlobalConditions__Group_2_3__0__Impl rule__GlobalConditions__Group_2_3__1 ;
	public final void rule__GlobalConditions__Group_2_3__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5473:2: ( rule__GlobalConditions__Group_2_3__0__Impl rule__GlobalConditions__Group_2_3__1 )
			// InternalDsl.g:5474:2: rule__GlobalConditions__Group_2_3__0__Impl rule__GlobalConditions__Group_2_3__1
			{
			pushFollow(FOLLOW_4);
			rule__GlobalConditions__Group_2_3__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__GlobalConditions__Group_2_3__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2_3__0"



	// $ANTLR start "rule__GlobalConditions__Group_2_3__0__Impl"
	// InternalDsl.g:5481:1: rule__GlobalConditions__Group_2_3__0__Impl : ( ',' ) ;
	public final void rule__GlobalConditions__Group_2_3__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5485:2: ( ( ',' ) )
			// InternalDsl.g:5486:2: ( ',' )
			{
			// InternalDsl.g:5486:2: ( ',' )
			// InternalDsl.g:5487:2: ','
			{
			 before(grammarAccess.getGlobalConditionsAccess().getCommaKeyword_2_3_0()); 
			match(input,19,FOLLOW_2); 
			 after(grammarAccess.getGlobalConditionsAccess().getCommaKeyword_2_3_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2_3__0__Impl"



	// $ANTLR start "rule__GlobalConditions__Group_2_3__1"
	// InternalDsl.g:5496:1: rule__GlobalConditions__Group_2_3__1 : rule__GlobalConditions__Group_2_3__1__Impl ;
	public final void rule__GlobalConditions__Group_2_3__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5500:2: ( rule__GlobalConditions__Group_2_3__1__Impl )
			// InternalDsl.g:5501:2: rule__GlobalConditions__Group_2_3__1__Impl
			{
			pushFollow(FOLLOW_2);
			rule__GlobalConditions__Group_2_3__1__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2_3__1"



	// $ANTLR start "rule__GlobalConditions__Group_2_3__1__Impl"
	// InternalDsl.g:5507:1: rule__GlobalConditions__Group_2_3__1__Impl : ( ( rule__GlobalConditions__ConditionsAssignment_2_3_1 ) ) ;
	public final void rule__GlobalConditions__Group_2_3__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5511:2: ( ( ( rule__GlobalConditions__ConditionsAssignment_2_3_1 ) ) )
			// InternalDsl.g:5512:2: ( ( rule__GlobalConditions__ConditionsAssignment_2_3_1 ) )
			{
			// InternalDsl.g:5512:2: ( ( rule__GlobalConditions__ConditionsAssignment_2_3_1 ) )
			// InternalDsl.g:5513:2: ( rule__GlobalConditions__ConditionsAssignment_2_3_1 )
			{
			 before(grammarAccess.getGlobalConditionsAccess().getConditionsAssignment_2_3_1()); 
			// InternalDsl.g:5514:2: ( rule__GlobalConditions__ConditionsAssignment_2_3_1 )
			// InternalDsl.g:5514:3: rule__GlobalConditions__ConditionsAssignment_2_3_1
			{
			pushFollow(FOLLOW_2);
			rule__GlobalConditions__ConditionsAssignment_2_3_1();
			state._fsp--;

			}

			 after(grammarAccess.getGlobalConditionsAccess().getConditionsAssignment_2_3_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__Group_2_3__1__Impl"



	// $ANTLR start "rule__Renaming__Group__0"
	// InternalDsl.g:5523:1: rule__Renaming__Group__0 : rule__Renaming__Group__0__Impl rule__Renaming__Group__1 ;
	public final void rule__Renaming__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5527:2: ( rule__Renaming__Group__0__Impl rule__Renaming__Group__1 )
			// InternalDsl.g:5528:2: rule__Renaming__Group__0__Impl rule__Renaming__Group__1
			{
			pushFollow(FOLLOW_57);
			rule__Renaming__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Renaming__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group__0"



	// $ANTLR start "rule__Renaming__Group__0__Impl"
	// InternalDsl.g:5535:1: rule__Renaming__Group__0__Impl : ( () ) ;
	public final void rule__Renaming__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5539:2: ( ( () ) )
			// InternalDsl.g:5540:2: ( () )
			{
			// InternalDsl.g:5540:2: ( () )
			// InternalDsl.g:5541:2: ()
			{
			 before(grammarAccess.getRenamingAccess().getRenamingAction_0()); 
			// InternalDsl.g:5542:2: ()
			// InternalDsl.g:5542:3: 
			{
			}

			 after(grammarAccess.getRenamingAccess().getRenamingAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group__0__Impl"



	// $ANTLR start "rule__Renaming__Group__1"
	// InternalDsl.g:5550:1: rule__Renaming__Group__1 : rule__Renaming__Group__1__Impl rule__Renaming__Group__2 ;
	public final void rule__Renaming__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5554:2: ( rule__Renaming__Group__1__Impl rule__Renaming__Group__2 )
			// InternalDsl.g:5555:2: rule__Renaming__Group__1__Impl rule__Renaming__Group__2
			{
			pushFollow(FOLLOW_58);
			rule__Renaming__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Renaming__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group__1"



	// $ANTLR start "rule__Renaming__Group__1__Impl"
	// InternalDsl.g:5562:1: rule__Renaming__Group__1__Impl : ( 'Renaming' ) ;
	public final void rule__Renaming__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5566:2: ( ( 'Renaming' ) )
			// InternalDsl.g:5567:2: ( 'Renaming' )
			{
			// InternalDsl.g:5567:2: ( 'Renaming' )
			// InternalDsl.g:5568:2: 'Renaming'
			{
			 before(grammarAccess.getRenamingAccess().getRenamingKeyword_1()); 
			match(input,33,FOLLOW_2); 
			 after(grammarAccess.getRenamingAccess().getRenamingKeyword_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group__1__Impl"



	// $ANTLR start "rule__Renaming__Group__2"
	// InternalDsl.g:5577:1: rule__Renaming__Group__2 : rule__Renaming__Group__2__Impl ;
	public final void rule__Renaming__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5581:2: ( rule__Renaming__Group__2__Impl )
			// InternalDsl.g:5582:2: rule__Renaming__Group__2__Impl
			{
			pushFollow(FOLLOW_2);
			rule__Renaming__Group__2__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group__2"



	// $ANTLR start "rule__Renaming__Group__2__Impl"
	// InternalDsl.g:5588:1: rule__Renaming__Group__2__Impl : ( ( rule__Renaming__Group_2__0 )? ) ;
	public final void rule__Renaming__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5592:2: ( ( ( rule__Renaming__Group_2__0 )? ) )
			// InternalDsl.g:5593:2: ( ( rule__Renaming__Group_2__0 )? )
			{
			// InternalDsl.g:5593:2: ( ( rule__Renaming__Group_2__0 )? )
			// InternalDsl.g:5594:2: ( rule__Renaming__Group_2__0 )?
			{
			 before(grammarAccess.getRenamingAccess().getGroup_2()); 
			// InternalDsl.g:5595:2: ( rule__Renaming__Group_2__0 )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==48) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// InternalDsl.g:5595:3: rule__Renaming__Group_2__0
					{
					pushFollow(FOLLOW_2);
					rule__Renaming__Group_2__0();
					state._fsp--;

					}
					break;

			}

			 after(grammarAccess.getRenamingAccess().getGroup_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group__2__Impl"



	// $ANTLR start "rule__Renaming__Group_2__0"
	// InternalDsl.g:5604:1: rule__Renaming__Group_2__0 : rule__Renaming__Group_2__0__Impl rule__Renaming__Group_2__1 ;
	public final void rule__Renaming__Group_2__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5608:2: ( rule__Renaming__Group_2__0__Impl rule__Renaming__Group_2__1 )
			// InternalDsl.g:5609:2: rule__Renaming__Group_2__0__Impl rule__Renaming__Group_2__1
			{
			pushFollow(FOLLOW_6);
			rule__Renaming__Group_2__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Renaming__Group_2__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group_2__0"



	// $ANTLR start "rule__Renaming__Group_2__0__Impl"
	// InternalDsl.g:5616:1: rule__Renaming__Group_2__0__Impl : ( 'renames' ) ;
	public final void rule__Renaming__Group_2__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5620:2: ( ( 'renames' ) )
			// InternalDsl.g:5621:2: ( 'renames' )
			{
			// InternalDsl.g:5621:2: ( 'renames' )
			// InternalDsl.g:5622:2: 'renames'
			{
			 before(grammarAccess.getRenamingAccess().getRenamesKeyword_2_0()); 
			match(input,48,FOLLOW_2); 
			 after(grammarAccess.getRenamingAccess().getRenamesKeyword_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group_2__0__Impl"



	// $ANTLR start "rule__Renaming__Group_2__1"
	// InternalDsl.g:5631:1: rule__Renaming__Group_2__1 : rule__Renaming__Group_2__1__Impl rule__Renaming__Group_2__2 ;
	public final void rule__Renaming__Group_2__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5635:2: ( rule__Renaming__Group_2__1__Impl rule__Renaming__Group_2__2 )
			// InternalDsl.g:5636:2: rule__Renaming__Group_2__1__Impl rule__Renaming__Group_2__2
			{
			pushFollow(FOLLOW_6);
			rule__Renaming__Group_2__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Renaming__Group_2__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group_2__1"



	// $ANTLR start "rule__Renaming__Group_2__1__Impl"
	// InternalDsl.g:5643:1: rule__Renaming__Group_2__1__Impl : ( '{' ) ;
	public final void rule__Renaming__Group_2__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5647:2: ( ( '{' ) )
			// InternalDsl.g:5648:2: ( '{' )
			{
			// InternalDsl.g:5648:2: ( '{' )
			// InternalDsl.g:5649:2: '{'
			{
			 before(grammarAccess.getRenamingAccess().getLeftCurlyBracketKeyword_2_1()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getRenamingAccess().getLeftCurlyBracketKeyword_2_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group_2__1__Impl"



	// $ANTLR start "rule__Renaming__Group_2__2"
	// InternalDsl.g:5658:1: rule__Renaming__Group_2__2 : rule__Renaming__Group_2__2__Impl rule__Renaming__Group_2__3 ;
	public final void rule__Renaming__Group_2__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5662:2: ( rule__Renaming__Group_2__2__Impl rule__Renaming__Group_2__3 )
			// InternalDsl.g:5663:2: rule__Renaming__Group_2__2__Impl rule__Renaming__Group_2__3
			{
			pushFollow(FOLLOW_59);
			rule__Renaming__Group_2__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Renaming__Group_2__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group_2__2"



	// $ANTLR start "rule__Renaming__Group_2__2__Impl"
	// InternalDsl.g:5670:1: rule__Renaming__Group_2__2__Impl : ( ( rule__Renaming__RenameAssignment_2_2 ) ) ;
	public final void rule__Renaming__Group_2__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5674:2: ( ( ( rule__Renaming__RenameAssignment_2_2 ) ) )
			// InternalDsl.g:5675:2: ( ( rule__Renaming__RenameAssignment_2_2 ) )
			{
			// InternalDsl.g:5675:2: ( ( rule__Renaming__RenameAssignment_2_2 ) )
			// InternalDsl.g:5676:2: ( rule__Renaming__RenameAssignment_2_2 )
			{
			 before(grammarAccess.getRenamingAccess().getRenameAssignment_2_2()); 
			// InternalDsl.g:5677:2: ( rule__Renaming__RenameAssignment_2_2 )
			// InternalDsl.g:5677:3: rule__Renaming__RenameAssignment_2_2
			{
			pushFollow(FOLLOW_2);
			rule__Renaming__RenameAssignment_2_2();
			state._fsp--;

			}

			 after(grammarAccess.getRenamingAccess().getRenameAssignment_2_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group_2__2__Impl"



	// $ANTLR start "rule__Renaming__Group_2__3"
	// InternalDsl.g:5685:1: rule__Renaming__Group_2__3 : rule__Renaming__Group_2__3__Impl rule__Renaming__Group_2__4 ;
	public final void rule__Renaming__Group_2__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5689:2: ( rule__Renaming__Group_2__3__Impl rule__Renaming__Group_2__4 )
			// InternalDsl.g:5690:2: rule__Renaming__Group_2__3__Impl rule__Renaming__Group_2__4
			{
			pushFollow(FOLLOW_7);
			rule__Renaming__Group_2__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Renaming__Group_2__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group_2__3"



	// $ANTLR start "rule__Renaming__Group_2__3__Impl"
	// InternalDsl.g:5697:1: rule__Renaming__Group_2__3__Impl : ( ( rule__Renaming__RenameAssignment_2_3 )* ) ;
	public final void rule__Renaming__Group_2__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5701:2: ( ( ( rule__Renaming__RenameAssignment_2_3 )* ) )
			// InternalDsl.g:5702:2: ( ( rule__Renaming__RenameAssignment_2_3 )* )
			{
			// InternalDsl.g:5702:2: ( ( rule__Renaming__RenameAssignment_2_3 )* )
			// InternalDsl.g:5703:2: ( rule__Renaming__RenameAssignment_2_3 )*
			{
			 before(grammarAccess.getRenamingAccess().getRenameAssignment_2_3()); 
			// InternalDsl.g:5704:2: ( rule__Renaming__RenameAssignment_2_3 )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0==55) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// InternalDsl.g:5704:3: rule__Renaming__RenameAssignment_2_3
					{
					pushFollow(FOLLOW_60);
					rule__Renaming__RenameAssignment_2_3();
					state._fsp--;

					}
					break;

				default :
					break loop36;
				}
			}

			 after(grammarAccess.getRenamingAccess().getRenameAssignment_2_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group_2__3__Impl"



	// $ANTLR start "rule__Renaming__Group_2__4"
	// InternalDsl.g:5712:1: rule__Renaming__Group_2__4 : rule__Renaming__Group_2__4__Impl ;
	public final void rule__Renaming__Group_2__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5716:2: ( rule__Renaming__Group_2__4__Impl )
			// InternalDsl.g:5717:2: rule__Renaming__Group_2__4__Impl
			{
			pushFollow(FOLLOW_2);
			rule__Renaming__Group_2__4__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group_2__4"



	// $ANTLR start "rule__Renaming__Group_2__4__Impl"
	// InternalDsl.g:5723:1: rule__Renaming__Group_2__4__Impl : ( '}' ) ;
	public final void rule__Renaming__Group_2__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5727:2: ( ( '}' ) )
			// InternalDsl.g:5728:2: ( '}' )
			{
			// InternalDsl.g:5728:2: ( '}' )
			// InternalDsl.g:5729:2: '}'
			{
			 before(grammarAccess.getRenamingAccess().getRightCurlyBracketKeyword_2_4()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getRenamingAccess().getRightCurlyBracketKeyword_2_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__Group_2__4__Impl"



	// $ANTLR start "rule__Rename__Group__0"
	// InternalDsl.g:5739:1: rule__Rename__Group__0 : rule__Rename__Group__0__Impl rule__Rename__Group__1 ;
	public final void rule__Rename__Group__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5743:2: ( rule__Rename__Group__0__Impl rule__Rename__Group__1 )
			// InternalDsl.g:5744:2: rule__Rename__Group__0__Impl rule__Rename__Group__1
			{
			pushFollow(FOLLOW_6);
			rule__Rename__Group__0__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Rename__Group__1();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__0"



	// $ANTLR start "rule__Rename__Group__0__Impl"
	// InternalDsl.g:5751:1: rule__Rename__Group__0__Impl : ( () ) ;
	public final void rule__Rename__Group__0__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5755:2: ( ( () ) )
			// InternalDsl.g:5756:2: ( () )
			{
			// InternalDsl.g:5756:2: ( () )
			// InternalDsl.g:5757:2: ()
			{
			 before(grammarAccess.getRenameAccess().getRenameAction_0()); 
			// InternalDsl.g:5758:2: ()
			// InternalDsl.g:5758:3: 
			{
			}

			 after(grammarAccess.getRenameAccess().getRenameAction_0()); 
			}

			}

		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__0__Impl"



	// $ANTLR start "rule__Rename__Group__1"
	// InternalDsl.g:5766:1: rule__Rename__Group__1 : rule__Rename__Group__1__Impl rule__Rename__Group__2 ;
	public final void rule__Rename__Group__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5770:2: ( rule__Rename__Group__1__Impl rule__Rename__Group__2 )
			// InternalDsl.g:5771:2: rule__Rename__Group__1__Impl rule__Rename__Group__2
			{
			pushFollow(FOLLOW_61);
			rule__Rename__Group__1__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Rename__Group__2();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__1"



	// $ANTLR start "rule__Rename__Group__1__Impl"
	// InternalDsl.g:5778:1: rule__Rename__Group__1__Impl : ( '{' ) ;
	public final void rule__Rename__Group__1__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5782:2: ( ( '{' ) )
			// InternalDsl.g:5783:2: ( '{' )
			{
			// InternalDsl.g:5783:2: ( '{' )
			// InternalDsl.g:5784:2: '{'
			{
			 before(grammarAccess.getRenameAccess().getLeftCurlyBracketKeyword_1()); 
			match(input,55,FOLLOW_2); 
			 after(grammarAccess.getRenameAccess().getLeftCurlyBracketKeyword_1()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__1__Impl"



	// $ANTLR start "rule__Rename__Group__2"
	// InternalDsl.g:5793:1: rule__Rename__Group__2 : rule__Rename__Group__2__Impl rule__Rename__Group__3 ;
	public final void rule__Rename__Group__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5797:2: ( rule__Rename__Group__2__Impl rule__Rename__Group__3 )
			// InternalDsl.g:5798:2: rule__Rename__Group__2__Impl rule__Rename__Group__3
			{
			pushFollow(FOLLOW_4);
			rule__Rename__Group__2__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Rename__Group__3();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__2"



	// $ANTLR start "rule__Rename__Group__2__Impl"
	// InternalDsl.g:5805:1: rule__Rename__Group__2__Impl : ( 'type' ) ;
	public final void rule__Rename__Group__2__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5809:2: ( ( 'type' ) )
			// InternalDsl.g:5810:2: ( 'type' )
			{
			// InternalDsl.g:5810:2: ( 'type' )
			// InternalDsl.g:5811:2: 'type'
			{
			 before(grammarAccess.getRenameAccess().getTypeKeyword_2()); 
			match(input,51,FOLLOW_2); 
			 after(grammarAccess.getRenameAccess().getTypeKeyword_2()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__2__Impl"



	// $ANTLR start "rule__Rename__Group__3"
	// InternalDsl.g:5820:1: rule__Rename__Group__3 : rule__Rename__Group__3__Impl rule__Rename__Group__4 ;
	public final void rule__Rename__Group__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5824:2: ( rule__Rename__Group__3__Impl rule__Rename__Group__4 )
			// InternalDsl.g:5825:2: rule__Rename__Group__3__Impl rule__Rename__Group__4
			{
			pushFollow(FOLLOW_62);
			rule__Rename__Group__3__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Rename__Group__4();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__3"



	// $ANTLR start "rule__Rename__Group__3__Impl"
	// InternalDsl.g:5832:1: rule__Rename__Group__3__Impl : ( ( rule__Rename__TypeAssignment_3 ) ) ;
	public final void rule__Rename__Group__3__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5836:2: ( ( ( rule__Rename__TypeAssignment_3 ) ) )
			// InternalDsl.g:5837:2: ( ( rule__Rename__TypeAssignment_3 ) )
			{
			// InternalDsl.g:5837:2: ( ( rule__Rename__TypeAssignment_3 ) )
			// InternalDsl.g:5838:2: ( rule__Rename__TypeAssignment_3 )
			{
			 before(grammarAccess.getRenameAccess().getTypeAssignment_3()); 
			// InternalDsl.g:5839:2: ( rule__Rename__TypeAssignment_3 )
			// InternalDsl.g:5839:3: rule__Rename__TypeAssignment_3
			{
			pushFollow(FOLLOW_2);
			rule__Rename__TypeAssignment_3();
			state._fsp--;

			}

			 after(grammarAccess.getRenameAccess().getTypeAssignment_3()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__3__Impl"



	// $ANTLR start "rule__Rename__Group__4"
	// InternalDsl.g:5847:1: rule__Rename__Group__4 : rule__Rename__Group__4__Impl rule__Rename__Group__5 ;
	public final void rule__Rename__Group__4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5851:2: ( rule__Rename__Group__4__Impl rule__Rename__Group__5 )
			// InternalDsl.g:5852:2: rule__Rename__Group__4__Impl rule__Rename__Group__5
			{
			pushFollow(FOLLOW_4);
			rule__Rename__Group__4__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Rename__Group__5();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__4"



	// $ANTLR start "rule__Rename__Group__4__Impl"
	// InternalDsl.g:5859:1: rule__Rename__Group__4__Impl : ( 'function' ) ;
	public final void rule__Rename__Group__4__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5863:2: ( ( 'function' ) )
			// InternalDsl.g:5864:2: ( 'function' )
			{
			// InternalDsl.g:5864:2: ( 'function' )
			// InternalDsl.g:5865:2: 'function'
			{
			 before(grammarAccess.getRenameAccess().getFunctionKeyword_4()); 
			match(input,40,FOLLOW_2); 
			 after(grammarAccess.getRenameAccess().getFunctionKeyword_4()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__4__Impl"



	// $ANTLR start "rule__Rename__Group__5"
	// InternalDsl.g:5874:1: rule__Rename__Group__5 : rule__Rename__Group__5__Impl rule__Rename__Group__6 ;
	public final void rule__Rename__Group__5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5878:2: ( rule__Rename__Group__5__Impl rule__Rename__Group__6 )
			// InternalDsl.g:5879:2: rule__Rename__Group__5__Impl rule__Rename__Group__6
			{
			pushFollow(FOLLOW_63);
			rule__Rename__Group__5__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Rename__Group__6();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__5"



	// $ANTLR start "rule__Rename__Group__5__Impl"
	// InternalDsl.g:5886:1: rule__Rename__Group__5__Impl : ( ( rule__Rename__FunctionAssignment_5 ) ) ;
	public final void rule__Rename__Group__5__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5890:2: ( ( ( rule__Rename__FunctionAssignment_5 ) ) )
			// InternalDsl.g:5891:2: ( ( rule__Rename__FunctionAssignment_5 ) )
			{
			// InternalDsl.g:5891:2: ( ( rule__Rename__FunctionAssignment_5 ) )
			// InternalDsl.g:5892:2: ( rule__Rename__FunctionAssignment_5 )
			{
			 before(grammarAccess.getRenameAccess().getFunctionAssignment_5()); 
			// InternalDsl.g:5893:2: ( rule__Rename__FunctionAssignment_5 )
			// InternalDsl.g:5893:3: rule__Rename__FunctionAssignment_5
			{
			pushFollow(FOLLOW_2);
			rule__Rename__FunctionAssignment_5();
			state._fsp--;

			}

			 after(grammarAccess.getRenameAccess().getFunctionAssignment_5()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__5__Impl"



	// $ANTLR start "rule__Rename__Group__6"
	// InternalDsl.g:5901:1: rule__Rename__Group__6 : rule__Rename__Group__6__Impl rule__Rename__Group__7 ;
	public final void rule__Rename__Group__6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5905:2: ( rule__Rename__Group__6__Impl rule__Rename__Group__7 )
			// InternalDsl.g:5906:2: rule__Rename__Group__6__Impl rule__Rename__Group__7
			{
			pushFollow(FOLLOW_4);
			rule__Rename__Group__6__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Rename__Group__7();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__6"



	// $ANTLR start "rule__Rename__Group__6__Impl"
	// InternalDsl.g:5913:1: rule__Rename__Group__6__Impl : ( 'newName' ) ;
	public final void rule__Rename__Group__6__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5917:2: ( ( 'newName' ) )
			// InternalDsl.g:5918:2: ( 'newName' )
			{
			// InternalDsl.g:5918:2: ( 'newName' )
			// InternalDsl.g:5919:2: 'newName'
			{
			 before(grammarAccess.getRenameAccess().getNewNameKeyword_6()); 
			match(input,44,FOLLOW_2); 
			 after(grammarAccess.getRenameAccess().getNewNameKeyword_6()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__6__Impl"



	// $ANTLR start "rule__Rename__Group__7"
	// InternalDsl.g:5928:1: rule__Rename__Group__7 : rule__Rename__Group__7__Impl rule__Rename__Group__8 ;
	public final void rule__Rename__Group__7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5932:2: ( rule__Rename__Group__7__Impl rule__Rename__Group__8 )
			// InternalDsl.g:5933:2: rule__Rename__Group__7__Impl rule__Rename__Group__8
			{
			pushFollow(FOLLOW_7);
			rule__Rename__Group__7__Impl();
			state._fsp--;

			pushFollow(FOLLOW_2);
			rule__Rename__Group__8();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__7"



	// $ANTLR start "rule__Rename__Group__7__Impl"
	// InternalDsl.g:5940:1: rule__Rename__Group__7__Impl : ( ( rule__Rename__NewNameAssignment_7 ) ) ;
	public final void rule__Rename__Group__7__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5944:2: ( ( ( rule__Rename__NewNameAssignment_7 ) ) )
			// InternalDsl.g:5945:2: ( ( rule__Rename__NewNameAssignment_7 ) )
			{
			// InternalDsl.g:5945:2: ( ( rule__Rename__NewNameAssignment_7 ) )
			// InternalDsl.g:5946:2: ( rule__Rename__NewNameAssignment_7 )
			{
			 before(grammarAccess.getRenameAccess().getNewNameAssignment_7()); 
			// InternalDsl.g:5947:2: ( rule__Rename__NewNameAssignment_7 )
			// InternalDsl.g:5947:3: rule__Rename__NewNameAssignment_7
			{
			pushFollow(FOLLOW_2);
			rule__Rename__NewNameAssignment_7();
			state._fsp--;

			}

			 after(grammarAccess.getRenameAccess().getNewNameAssignment_7()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__7__Impl"



	// $ANTLR start "rule__Rename__Group__8"
	// InternalDsl.g:5955:1: rule__Rename__Group__8 : rule__Rename__Group__8__Impl ;
	public final void rule__Rename__Group__8() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5959:2: ( rule__Rename__Group__8__Impl )
			// InternalDsl.g:5960:2: rule__Rename__Group__8__Impl
			{
			pushFollow(FOLLOW_2);
			rule__Rename__Group__8__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__8"



	// $ANTLR start "rule__Rename__Group__8__Impl"
	// InternalDsl.g:5966:1: rule__Rename__Group__8__Impl : ( '}' ) ;
	public final void rule__Rename__Group__8__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:5970:2: ( ( '}' ) )
			// InternalDsl.g:5971:2: ( '}' )
			{
			// InternalDsl.g:5971:2: ( '}' )
			// InternalDsl.g:5972:2: '}'
			{
			 before(grammarAccess.getRenameAccess().getRightCurlyBracketKeyword_8()); 
			match(input,56,FOLLOW_2); 
			 after(grammarAccess.getRenameAccess().getRightCurlyBracketKeyword_8()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__Group__8__Impl"



	// $ANTLR start "rule__CbCProblem__UnorderedGroup"
	// InternalDsl.g:5982:1: rule__CbCProblem__UnorderedGroup : rule__CbCProblem__UnorderedGroup__0 {...}?;
	public final void rule__CbCProblem__UnorderedGroup() throws RecognitionException {

				int stackSize = keepStackSize();
				getUnorderedGroupHelper().enter(grammarAccess.getCbCProblemAccess().getUnorderedGroup());
			
		try {
			// InternalDsl.g:5987:2: ( rule__CbCProblem__UnorderedGroup__0 {...}?)
			// InternalDsl.g:5988:2: rule__CbCProblem__UnorderedGroup__0 {...}?
			{
			pushFollow(FOLLOW_2);
			rule__CbCProblem__UnorderedGroup__0();
			state._fsp--;

			if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getCbCProblemAccess().getUnorderedGroup()) ) {
				throw new FailedPredicateException(input, "rule__CbCProblem__UnorderedGroup", "getUnorderedGroupHelper().canLeave(grammarAccess.getCbCProblemAccess().getUnorderedGroup())");
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				getUnorderedGroupHelper().leave(grammarAccess.getCbCProblemAccess().getUnorderedGroup());
				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCProblem__UnorderedGroup"



	// $ANTLR start "rule__CbCProblem__UnorderedGroup__Impl"
	// InternalDsl.g:5996:1: rule__CbCProblem__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__CbCProblem__CbcformulaAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__GlobalconditionAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__JavaVariableAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__RenamingAssignment_3 ) ) ) ) ) ;
	public final void rule__CbCProblem__UnorderedGroup__Impl() throws RecognitionException {

				int stackSize = keepStackSize();
				boolean selected = false;
			
		try {
			// InternalDsl.g:6001:3: ( ( ({...}? => ( ( ( rule__CbCProblem__CbcformulaAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__GlobalconditionAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__JavaVariableAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__RenamingAssignment_3 ) ) ) ) ) )
			// InternalDsl.g:6002:3: ( ({...}? => ( ( ( rule__CbCProblem__CbcformulaAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__GlobalconditionAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__JavaVariableAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__RenamingAssignment_3 ) ) ) ) )
			{
			// InternalDsl.g:6002:3: ( ({...}? => ( ( ( rule__CbCProblem__CbcformulaAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__GlobalconditionAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__JavaVariableAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CbCProblem__RenamingAssignment_3 ) ) ) ) )
			int alt37=4;
			int LA37_0 = input.LA(1);
			if ( LA37_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 0) ) {
				alt37=1;
			}
			else if ( LA37_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 1) ) {
				alt37=2;
			}
			else if ( LA37_0 == 32 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 2) ) {
				alt37=3;
			}
			else if ( LA37_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 3) ) {
				alt37=4;
			}

			switch (alt37) {
				case 1 :
					// InternalDsl.g:6003:3: ({...}? => ( ( ( rule__CbCProblem__CbcformulaAssignment_0 ) ) ) )
					{
					// InternalDsl.g:6003:3: ({...}? => ( ( ( rule__CbCProblem__CbcformulaAssignment_0 ) ) ) )
					// InternalDsl.g:6004:4: {...}? => ( ( ( rule__CbCProblem__CbcformulaAssignment_0 ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 0) ) {
						throw new FailedPredicateException(input, "rule__CbCProblem__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 0)");
					}
					// InternalDsl.g:6004:104: ( ( ( rule__CbCProblem__CbcformulaAssignment_0 ) ) )
					// InternalDsl.g:6005:5: ( ( rule__CbCProblem__CbcformulaAssignment_0 ) )
					{

										getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 0);
									

										selected = true;
									
					// InternalDsl.g:6011:5: ( ( rule__CbCProblem__CbcformulaAssignment_0 ) )
					// InternalDsl.g:6012:6: ( rule__CbCProblem__CbcformulaAssignment_0 )
					{
					 before(grammarAccess.getCbCProblemAccess().getCbcformulaAssignment_0()); 
					// InternalDsl.g:6013:6: ( rule__CbCProblem__CbcformulaAssignment_0 )
					// InternalDsl.g:6013:7: rule__CbCProblem__CbcformulaAssignment_0
					{
					pushFollow(FOLLOW_2);
					rule__CbCProblem__CbcformulaAssignment_0();
					state._fsp--;

					}

					 after(grammarAccess.getCbCProblemAccess().getCbcformulaAssignment_0()); 
					}

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:6018:3: ({...}? => ( ( ( rule__CbCProblem__GlobalconditionAssignment_1 ) ) ) )
					{
					// InternalDsl.g:6018:3: ({...}? => ( ( ( rule__CbCProblem__GlobalconditionAssignment_1 ) ) ) )
					// InternalDsl.g:6019:4: {...}? => ( ( ( rule__CbCProblem__GlobalconditionAssignment_1 ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 1) ) {
						throw new FailedPredicateException(input, "rule__CbCProblem__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 1)");
					}
					// InternalDsl.g:6019:104: ( ( ( rule__CbCProblem__GlobalconditionAssignment_1 ) ) )
					// InternalDsl.g:6020:5: ( ( rule__CbCProblem__GlobalconditionAssignment_1 ) )
					{

										getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 1);
									

										selected = true;
									
					// InternalDsl.g:6026:5: ( ( rule__CbCProblem__GlobalconditionAssignment_1 ) )
					// InternalDsl.g:6027:6: ( rule__CbCProblem__GlobalconditionAssignment_1 )
					{
					 before(grammarAccess.getCbCProblemAccess().getGlobalconditionAssignment_1()); 
					// InternalDsl.g:6028:6: ( rule__CbCProblem__GlobalconditionAssignment_1 )
					// InternalDsl.g:6028:7: rule__CbCProblem__GlobalconditionAssignment_1
					{
					pushFollow(FOLLOW_2);
					rule__CbCProblem__GlobalconditionAssignment_1();
					state._fsp--;

					}

					 after(grammarAccess.getCbCProblemAccess().getGlobalconditionAssignment_1()); 
					}

					}

					}

					}
					break;
				case 3 :
					// InternalDsl.g:6033:3: ({...}? => ( ( ( rule__CbCProblem__JavaVariableAssignment_2 ) ) ) )
					{
					// InternalDsl.g:6033:3: ({...}? => ( ( ( rule__CbCProblem__JavaVariableAssignment_2 ) ) ) )
					// InternalDsl.g:6034:4: {...}? => ( ( ( rule__CbCProblem__JavaVariableAssignment_2 ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 2) ) {
						throw new FailedPredicateException(input, "rule__CbCProblem__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 2)");
					}
					// InternalDsl.g:6034:104: ( ( ( rule__CbCProblem__JavaVariableAssignment_2 ) ) )
					// InternalDsl.g:6035:5: ( ( rule__CbCProblem__JavaVariableAssignment_2 ) )
					{

										getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 2);
									

										selected = true;
									
					// InternalDsl.g:6041:5: ( ( rule__CbCProblem__JavaVariableAssignment_2 ) )
					// InternalDsl.g:6042:6: ( rule__CbCProblem__JavaVariableAssignment_2 )
					{
					 before(grammarAccess.getCbCProblemAccess().getJavaVariableAssignment_2()); 
					// InternalDsl.g:6043:6: ( rule__CbCProblem__JavaVariableAssignment_2 )
					// InternalDsl.g:6043:7: rule__CbCProblem__JavaVariableAssignment_2
					{
					pushFollow(FOLLOW_2);
					rule__CbCProblem__JavaVariableAssignment_2();
					state._fsp--;

					}

					 after(grammarAccess.getCbCProblemAccess().getJavaVariableAssignment_2()); 
					}

					}

					}

					}
					break;
				case 4 :
					// InternalDsl.g:6048:3: ({...}? => ( ( ( rule__CbCProblem__RenamingAssignment_3 ) ) ) )
					{
					// InternalDsl.g:6048:3: ({...}? => ( ( ( rule__CbCProblem__RenamingAssignment_3 ) ) ) )
					// InternalDsl.g:6049:4: {...}? => ( ( ( rule__CbCProblem__RenamingAssignment_3 ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 3) ) {
						throw new FailedPredicateException(input, "rule__CbCProblem__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 3)");
					}
					// InternalDsl.g:6049:104: ( ( ( rule__CbCProblem__RenamingAssignment_3 ) ) )
					// InternalDsl.g:6050:5: ( ( rule__CbCProblem__RenamingAssignment_3 ) )
					{

										getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 3);
									

										selected = true;
									
					// InternalDsl.g:6056:5: ( ( rule__CbCProblem__RenamingAssignment_3 ) )
					// InternalDsl.g:6057:6: ( rule__CbCProblem__RenamingAssignment_3 )
					{
					 before(grammarAccess.getCbCProblemAccess().getRenamingAssignment_3()); 
					// InternalDsl.g:6058:6: ( rule__CbCProblem__RenamingAssignment_3 )
					// InternalDsl.g:6058:7: rule__CbCProblem__RenamingAssignment_3
					{
					pushFollow(FOLLOW_2);
					rule__CbCProblem__RenamingAssignment_3();
					state._fsp--;

					}

					 after(grammarAccess.getCbCProblemAccess().getRenamingAssignment_3()); 
					}

					}

					}

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				if (selected)
					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCbCProblemAccess().getUnorderedGroup());
				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCProblem__UnorderedGroup__Impl"



	// $ANTLR start "rule__CbCProblem__UnorderedGroup__0"
	// InternalDsl.g:6071:1: rule__CbCProblem__UnorderedGroup__0 : rule__CbCProblem__UnorderedGroup__Impl ( rule__CbCProblem__UnorderedGroup__1 )? ;
	public final void rule__CbCProblem__UnorderedGroup__0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6075:2: ( rule__CbCProblem__UnorderedGroup__Impl ( rule__CbCProblem__UnorderedGroup__1 )? )
			// InternalDsl.g:6076:2: rule__CbCProblem__UnorderedGroup__Impl ( rule__CbCProblem__UnorderedGroup__1 )?
			{
			pushFollow(FOLLOW_64);
			rule__CbCProblem__UnorderedGroup__Impl();
			state._fsp--;

			// InternalDsl.g:6077:2: ( rule__CbCProblem__UnorderedGroup__1 )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( LA38_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 0) ) {
				alt38=1;
			}
			else if ( LA38_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 1) ) {
				alt38=1;
			}
			else if ( LA38_0 == 32 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 2) ) {
				alt38=1;
			}
			else if ( LA38_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 3) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// InternalDsl.g:6077:2: rule__CbCProblem__UnorderedGroup__1
					{
					pushFollow(FOLLOW_2);
					rule__CbCProblem__UnorderedGroup__1();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCProblem__UnorderedGroup__0"



	// $ANTLR start "rule__CbCProblem__UnorderedGroup__1"
	// InternalDsl.g:6083:1: rule__CbCProblem__UnorderedGroup__1 : rule__CbCProblem__UnorderedGroup__Impl ( rule__CbCProblem__UnorderedGroup__2 )? ;
	public final void rule__CbCProblem__UnorderedGroup__1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6087:2: ( rule__CbCProblem__UnorderedGroup__Impl ( rule__CbCProblem__UnorderedGroup__2 )? )
			// InternalDsl.g:6088:2: rule__CbCProblem__UnorderedGroup__Impl ( rule__CbCProblem__UnorderedGroup__2 )?
			{
			pushFollow(FOLLOW_64);
			rule__CbCProblem__UnorderedGroup__Impl();
			state._fsp--;

			// InternalDsl.g:6089:2: ( rule__CbCProblem__UnorderedGroup__2 )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( LA39_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 0) ) {
				alt39=1;
			}
			else if ( LA39_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 1) ) {
				alt39=1;
			}
			else if ( LA39_0 == 32 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 2) ) {
				alt39=1;
			}
			else if ( LA39_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 3) ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// InternalDsl.g:6089:2: rule__CbCProblem__UnorderedGroup__2
					{
					pushFollow(FOLLOW_2);
					rule__CbCProblem__UnorderedGroup__2();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCProblem__UnorderedGroup__1"



	// $ANTLR start "rule__CbCProblem__UnorderedGroup__2"
	// InternalDsl.g:6095:1: rule__CbCProblem__UnorderedGroup__2 : rule__CbCProblem__UnorderedGroup__Impl ( rule__CbCProblem__UnorderedGroup__3 )? ;
	public final void rule__CbCProblem__UnorderedGroup__2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6099:2: ( rule__CbCProblem__UnorderedGroup__Impl ( rule__CbCProblem__UnorderedGroup__3 )? )
			// InternalDsl.g:6100:2: rule__CbCProblem__UnorderedGroup__Impl ( rule__CbCProblem__UnorderedGroup__3 )?
			{
			pushFollow(FOLLOW_64);
			rule__CbCProblem__UnorderedGroup__Impl();
			state._fsp--;

			// InternalDsl.g:6101:2: ( rule__CbCProblem__UnorderedGroup__3 )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( LA40_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 0) ) {
				alt40=1;
			}
			else if ( LA40_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 1) ) {
				alt40=1;
			}
			else if ( LA40_0 == 32 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 2) ) {
				alt40=1;
			}
			else if ( LA40_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 3) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// InternalDsl.g:6101:2: rule__CbCProblem__UnorderedGroup__3
					{
					pushFollow(FOLLOW_2);
					rule__CbCProblem__UnorderedGroup__3();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCProblem__UnorderedGroup__2"



	// $ANTLR start "rule__CbCProblem__UnorderedGroup__3"
	// InternalDsl.g:6107:1: rule__CbCProblem__UnorderedGroup__3 : rule__CbCProblem__UnorderedGroup__Impl ;
	public final void rule__CbCProblem__UnorderedGroup__3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6111:2: ( rule__CbCProblem__UnorderedGroup__Impl )
			// InternalDsl.g:6112:2: rule__CbCProblem__UnorderedGroup__Impl
			{
			pushFollow(FOLLOW_2);
			rule__CbCProblem__UnorderedGroup__Impl();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCProblem__UnorderedGroup__3"



	// $ANTLR start "rule__CbCProblem__CbcformulaAssignment_0"
	// InternalDsl.g:6119:1: rule__CbCProblem__CbcformulaAssignment_0 : ( ruleCbCFormula ) ;
	public final void rule__CbCProblem__CbcformulaAssignment_0() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6123:2: ( ( ruleCbCFormula ) )
			// InternalDsl.g:6124:2: ( ruleCbCFormula )
			{
			// InternalDsl.g:6124:2: ( ruleCbCFormula )
			// InternalDsl.g:6125:3: ruleCbCFormula
			{
			 before(grammarAccess.getCbCProblemAccess().getCbcformulaCbCFormulaParserRuleCall_0_0()); 
			pushFollow(FOLLOW_2);
			ruleCbCFormula();
			state._fsp--;

			 after(grammarAccess.getCbCProblemAccess().getCbcformulaCbCFormulaParserRuleCall_0_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCProblem__CbcformulaAssignment_0"



	// $ANTLR start "rule__CbCProblem__GlobalconditionAssignment_1"
	// InternalDsl.g:6134:1: rule__CbCProblem__GlobalconditionAssignment_1 : ( ruleGlobalConditions ) ;
	public final void rule__CbCProblem__GlobalconditionAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6138:2: ( ( ruleGlobalConditions ) )
			// InternalDsl.g:6139:2: ( ruleGlobalConditions )
			{
			// InternalDsl.g:6139:2: ( ruleGlobalConditions )
			// InternalDsl.g:6140:3: ruleGlobalConditions
			{
			 before(grammarAccess.getCbCProblemAccess().getGlobalconditionGlobalConditionsParserRuleCall_1_0()); 
			pushFollow(FOLLOW_2);
			ruleGlobalConditions();
			state._fsp--;

			 after(grammarAccess.getCbCProblemAccess().getGlobalconditionGlobalConditionsParserRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCProblem__GlobalconditionAssignment_1"



	// $ANTLR start "rule__CbCProblem__JavaVariableAssignment_2"
	// InternalDsl.g:6149:1: rule__CbCProblem__JavaVariableAssignment_2 : ( ruleJavaVariables ) ;
	public final void rule__CbCProblem__JavaVariableAssignment_2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6153:2: ( ( ruleJavaVariables ) )
			// InternalDsl.g:6154:2: ( ruleJavaVariables )
			{
			// InternalDsl.g:6154:2: ( ruleJavaVariables )
			// InternalDsl.g:6155:3: ruleJavaVariables
			{
			 before(grammarAccess.getCbCProblemAccess().getJavaVariableJavaVariablesParserRuleCall_2_0()); 
			pushFollow(FOLLOW_2);
			ruleJavaVariables();
			state._fsp--;

			 after(grammarAccess.getCbCProblemAccess().getJavaVariableJavaVariablesParserRuleCall_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCProblem__JavaVariableAssignment_2"



	// $ANTLR start "rule__CbCProblem__RenamingAssignment_3"
	// InternalDsl.g:6164:1: rule__CbCProblem__RenamingAssignment_3 : ( ruleRenaming ) ;
	public final void rule__CbCProblem__RenamingAssignment_3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6168:2: ( ( ruleRenaming ) )
			// InternalDsl.g:6169:2: ( ruleRenaming )
			{
			// InternalDsl.g:6169:2: ( ruleRenaming )
			// InternalDsl.g:6170:3: ruleRenaming
			{
			 before(grammarAccess.getCbCProblemAccess().getRenamingRenamingParserRuleCall_3_0()); 
			pushFollow(FOLLOW_2);
			ruleRenaming();
			state._fsp--;

			 after(grammarAccess.getCbCProblemAccess().getRenamingRenamingParserRuleCall_3_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCProblem__RenamingAssignment_3"



	// $ANTLR start "rule__CbCFormula__NameAssignment_1"
	// InternalDsl.g:6179:1: rule__CbCFormula__NameAssignment_1 : ( ruleEString ) ;
	public final void rule__CbCFormula__NameAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6183:2: ( ( ruleEString ) )
			// InternalDsl.g:6184:2: ( ruleEString )
			{
			// InternalDsl.g:6184:2: ( ruleEString )
			// InternalDsl.g:6185:3: ruleEString
			{
			 before(grammarAccess.getCbCFormulaAccess().getNameEStringParserRuleCall_1_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getCbCFormulaAccess().getNameEStringParserRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__NameAssignment_1"



	// $ANTLR start "rule__CbCFormula__PreConditionAssignment_4"
	// InternalDsl.g:6194:1: rule__CbCFormula__PreConditionAssignment_4 : ( ruleCondition ) ;
	public final void rule__CbCFormula__PreConditionAssignment_4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6198:2: ( ( ruleCondition ) )
			// InternalDsl.g:6199:2: ( ruleCondition )
			{
			// InternalDsl.g:6199:2: ( ruleCondition )
			// InternalDsl.g:6200:3: ruleCondition
			{
			 before(grammarAccess.getCbCFormulaAccess().getPreConditionConditionParserRuleCall_4_0()); 
			pushFollow(FOLLOW_2);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getCbCFormulaAccess().getPreConditionConditionParserRuleCall_4_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__PreConditionAssignment_4"



	// $ANTLR start "rule__CbCFormula__StatementAssignment_7"
	// InternalDsl.g:6209:1: rule__CbCFormula__StatementAssignment_7 : ( ruleAbstractStatement ) ;
	public final void rule__CbCFormula__StatementAssignment_7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6213:2: ( ( ruleAbstractStatement ) )
			// InternalDsl.g:6214:2: ( ruleAbstractStatement )
			{
			// InternalDsl.g:6214:2: ( ruleAbstractStatement )
			// InternalDsl.g:6215:3: ruleAbstractStatement
			{
			 before(grammarAccess.getCbCFormulaAccess().getStatementAbstractStatementParserRuleCall_7_0()); 
			pushFollow(FOLLOW_2);
			ruleAbstractStatement();
			state._fsp--;

			 after(grammarAccess.getCbCFormulaAccess().getStatementAbstractStatementParserRuleCall_7_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__StatementAssignment_7"



	// $ANTLR start "rule__CbCFormula__PostConditionAssignment_11"
	// InternalDsl.g:6224:1: rule__CbCFormula__PostConditionAssignment_11 : ( ruleCondition ) ;
	public final void rule__CbCFormula__PostConditionAssignment_11() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6228:2: ( ( ruleCondition ) )
			// InternalDsl.g:6229:2: ( ruleCondition )
			{
			// InternalDsl.g:6229:2: ( ruleCondition )
			// InternalDsl.g:6230:3: ruleCondition
			{
			 before(grammarAccess.getCbCFormulaAccess().getPostConditionConditionParserRuleCall_11_0()); 
			pushFollow(FOLLOW_2);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getCbCFormulaAccess().getPostConditionConditionParserRuleCall_11_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CbCFormula__PostConditionAssignment_11"



	// $ANTLR start "rule__AbstractStatement_Impl__NameAssignment_1"
	// InternalDsl.g:6239:1: rule__AbstractStatement_Impl__NameAssignment_1 : ( ruleCodeString ) ;
	public final void rule__AbstractStatement_Impl__NameAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6243:2: ( ( ruleCodeString ) )
			// InternalDsl.g:6244:2: ( ruleCodeString )
			{
			// InternalDsl.g:6244:2: ( ruleCodeString )
			// InternalDsl.g:6245:3: ruleCodeString
			{
			 before(grammarAccess.getAbstractStatement_ImplAccess().getNameCodeStringParserRuleCall_1_0()); 
			pushFollow(FOLLOW_2);
			ruleCodeString();
			state._fsp--;

			 after(grammarAccess.getAbstractStatement_ImplAccess().getNameCodeStringParserRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__AbstractStatement_Impl__NameAssignment_1"



	// $ANTLR start "rule__MethodStatement__NameAssignment_1"
	// InternalDsl.g:6254:1: rule__MethodStatement__NameAssignment_1 : ( ruleEString ) ;
	public final void rule__MethodStatement__NameAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6258:2: ( ( ruleEString ) )
			// InternalDsl.g:6259:2: ( ruleEString )
			{
			// InternalDsl.g:6259:2: ( ruleEString )
			// InternalDsl.g:6260:3: ruleEString
			{
			 before(grammarAccess.getMethodStatementAccess().getNameEStringParserRuleCall_1_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getMethodStatementAccess().getNameEStringParserRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__MethodStatement__NameAssignment_1"



	// $ANTLR start "rule__ReturnStatement__NameAssignment_2"
	// InternalDsl.g:6269:1: rule__ReturnStatement__NameAssignment_2 : ( ruleCodeString ) ;
	public final void rule__ReturnStatement__NameAssignment_2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6273:2: ( ( ruleCodeString ) )
			// InternalDsl.g:6274:2: ( ruleCodeString )
			{
			// InternalDsl.g:6274:2: ( ruleCodeString )
			// InternalDsl.g:6275:3: ruleCodeString
			{
			 before(grammarAccess.getReturnStatementAccess().getNameCodeStringParserRuleCall_2_0()); 
			pushFollow(FOLLOW_2);
			ruleCodeString();
			state._fsp--;

			 after(grammarAccess.getReturnStatementAccess().getNameCodeStringParserRuleCall_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__ReturnStatement__NameAssignment_2"



	// $ANTLR start "rule__StrengthWeakStatement__WeakPreConditionAssignment_3"
	// InternalDsl.g:6284:1: rule__StrengthWeakStatement__WeakPreConditionAssignment_3 : ( ruleCondition ) ;
	public final void rule__StrengthWeakStatement__WeakPreConditionAssignment_3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6288:2: ( ( ruleCondition ) )
			// InternalDsl.g:6289:2: ( ruleCondition )
			{
			// InternalDsl.g:6289:2: ( ruleCondition )
			// InternalDsl.g:6290:3: ruleCondition
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getWeakPreConditionConditionParserRuleCall_3_0()); 
			pushFollow(FOLLOW_2);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getStrengthWeakStatementAccess().getWeakPreConditionConditionParserRuleCall_3_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__WeakPreConditionAssignment_3"



	// $ANTLR start "rule__StrengthWeakStatement__NameAssignment_6"
	// InternalDsl.g:6299:1: rule__StrengthWeakStatement__NameAssignment_6 : ( ruleCodeString ) ;
	public final void rule__StrengthWeakStatement__NameAssignment_6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6303:2: ( ( ruleCodeString ) )
			// InternalDsl.g:6304:2: ( ruleCodeString )
			{
			// InternalDsl.g:6304:2: ( ruleCodeString )
			// InternalDsl.g:6305:3: ruleCodeString
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getNameCodeStringParserRuleCall_6_0()); 
			pushFollow(FOLLOW_2);
			ruleCodeString();
			state._fsp--;

			 after(grammarAccess.getStrengthWeakStatementAccess().getNameCodeStringParserRuleCall_6_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__NameAssignment_6"



	// $ANTLR start "rule__StrengthWeakStatement__StrongPostConditionAssignment_10"
	// InternalDsl.g:6314:1: rule__StrengthWeakStatement__StrongPostConditionAssignment_10 : ( ruleCondition ) ;
	public final void rule__StrengthWeakStatement__StrongPostConditionAssignment_10() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6318:2: ( ( ruleCondition ) )
			// InternalDsl.g:6319:2: ( ruleCondition )
			{
			// InternalDsl.g:6319:2: ( ruleCondition )
			// InternalDsl.g:6320:3: ruleCondition
			{
			 before(grammarAccess.getStrengthWeakStatementAccess().getStrongPostConditionConditionParserRuleCall_10_0()); 
			pushFollow(FOLLOW_2);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getStrengthWeakStatementAccess().getStrongPostConditionConditionParserRuleCall_10_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__StrengthWeakStatement__StrongPostConditionAssignment_10"



	// $ANTLR start "rule__Condition__NameAssignment_1"
	// InternalDsl.g:6329:1: rule__Condition__NameAssignment_1 : ( ruleEString ) ;
	public final void rule__Condition__NameAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6333:2: ( ( ruleEString ) )
			// InternalDsl.g:6334:2: ( ruleEString )
			{
			// InternalDsl.g:6334:2: ( ruleEString )
			// InternalDsl.g:6335:3: ruleEString
			{
			 before(grammarAccess.getConditionAccess().getNameEStringParserRuleCall_1_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getConditionAccess().getNameEStringParserRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Condition__NameAssignment_1"



	// $ANTLR start "rule__SkipStatement__NameAssignment"
	// InternalDsl.g:6344:1: rule__SkipStatement__NameAssignment : ( ( ';' ) ) ;
	public final void rule__SkipStatement__NameAssignment() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6348:2: ( ( ( ';' ) ) )
			// InternalDsl.g:6349:2: ( ( ';' ) )
			{
			// InternalDsl.g:6349:2: ( ( ';' ) )
			// InternalDsl.g:6350:3: ( ';' )
			{
			 before(grammarAccess.getSkipStatementAccess().getNameSemicolonKeyword_0()); 
			// InternalDsl.g:6351:3: ( ';' )
			// InternalDsl.g:6352:4: ';'
			{
			 before(grammarAccess.getSkipStatementAccess().getNameSemicolonKeyword_0()); 
			match(input,24,FOLLOW_2); 
			 after(grammarAccess.getSkipStatementAccess().getNameSemicolonKeyword_0()); 
			}

			 after(grammarAccess.getSkipStatementAccess().getNameSemicolonKeyword_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SkipStatement__NameAssignment"



	// $ANTLR start "rule__CompositionStatement__FirstStatementAssignment_2"
	// InternalDsl.g:6363:1: rule__CompositionStatement__FirstStatementAssignment_2 : ( ruleAbstractStatement ) ;
	public final void rule__CompositionStatement__FirstStatementAssignment_2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6367:2: ( ( ruleAbstractStatement ) )
			// InternalDsl.g:6368:2: ( ruleAbstractStatement )
			{
			// InternalDsl.g:6368:2: ( ruleAbstractStatement )
			// InternalDsl.g:6369:3: ruleAbstractStatement
			{
			 before(grammarAccess.getCompositionStatementAccess().getFirstStatementAbstractStatementParserRuleCall_2_0()); 
			pushFollow(FOLLOW_2);
			ruleAbstractStatement();
			state._fsp--;

			 after(grammarAccess.getCompositionStatementAccess().getFirstStatementAbstractStatementParserRuleCall_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__FirstStatementAssignment_2"



	// $ANTLR start "rule__CompositionStatement__IntermediateConditionAssignment_6"
	// InternalDsl.g:6378:1: rule__CompositionStatement__IntermediateConditionAssignment_6 : ( ruleCondition ) ;
	public final void rule__CompositionStatement__IntermediateConditionAssignment_6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6382:2: ( ( ruleCondition ) )
			// InternalDsl.g:6383:2: ( ruleCondition )
			{
			// InternalDsl.g:6383:2: ( ruleCondition )
			// InternalDsl.g:6384:3: ruleCondition
			{
			 before(grammarAccess.getCompositionStatementAccess().getIntermediateConditionConditionParserRuleCall_6_0()); 
			pushFollow(FOLLOW_2);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getCompositionStatementAccess().getIntermediateConditionConditionParserRuleCall_6_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__IntermediateConditionAssignment_6"



	// $ANTLR start "rule__CompositionStatement__SecondStatementAssignment_9"
	// InternalDsl.g:6393:1: rule__CompositionStatement__SecondStatementAssignment_9 : ( ruleAbstractStatement ) ;
	public final void rule__CompositionStatement__SecondStatementAssignment_9() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6397:2: ( ( ruleAbstractStatement ) )
			// InternalDsl.g:6398:2: ( ruleAbstractStatement )
			{
			// InternalDsl.g:6398:2: ( ruleAbstractStatement )
			// InternalDsl.g:6399:3: ruleAbstractStatement
			{
			 before(grammarAccess.getCompositionStatementAccess().getSecondStatementAbstractStatementParserRuleCall_9_0()); 
			pushFollow(FOLLOW_2);
			ruleAbstractStatement();
			state._fsp--;

			 after(grammarAccess.getCompositionStatementAccess().getSecondStatementAbstractStatementParserRuleCall_9_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__CompositionStatement__SecondStatementAssignment_9"



	// $ANTLR start "rule__JavaStatement__NameAssignment"
	// InternalDsl.g:6408:1: rule__JavaStatement__NameAssignment : ( ruleEString ) ;
	public final void rule__JavaStatement__NameAssignment() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6412:2: ( ( ruleEString ) )
			// InternalDsl.g:6413:2: ( ruleEString )
			{
			// InternalDsl.g:6413:2: ( ruleEString )
			// InternalDsl.g:6414:3: ruleEString
			{
			 before(grammarAccess.getJavaStatementAccess().getNameEStringParserRuleCall_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getJavaStatementAccess().getNameEStringParserRuleCall_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaStatement__NameAssignment"



	// $ANTLR start "rule__JMLAnnotation__RequiresAssignment_1"
	// InternalDsl.g:6423:1: rule__JMLAnnotation__RequiresAssignment_1 : ( ruleEString ) ;
	public final void rule__JMLAnnotation__RequiresAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6427:2: ( ( ruleEString ) )
			// InternalDsl.g:6428:2: ( ruleEString )
			{
			// InternalDsl.g:6428:2: ( ruleEString )
			// InternalDsl.g:6429:3: ruleEString
			{
			 before(grammarAccess.getJMLAnnotationAccess().getRequiresEStringParserRuleCall_1_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getJMLAnnotationAccess().getRequiresEStringParserRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__RequiresAssignment_1"



	// $ANTLR start "rule__JMLAnnotation__AssignableAssignment_4"
	// InternalDsl.g:6438:1: rule__JMLAnnotation__AssignableAssignment_4 : ( ruleEString ) ;
	public final void rule__JMLAnnotation__AssignableAssignment_4() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6442:2: ( ( ruleEString ) )
			// InternalDsl.g:6443:2: ( ruleEString )
			{
			// InternalDsl.g:6443:2: ( ruleEString )
			// InternalDsl.g:6444:3: ruleEString
			{
			 before(grammarAccess.getJMLAnnotationAccess().getAssignableEStringParserRuleCall_4_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getJMLAnnotationAccess().getAssignableEStringParserRuleCall_4_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__AssignableAssignment_4"



	// $ANTLR start "rule__JMLAnnotation__EnsuresAssignment_7"
	// InternalDsl.g:6453:1: rule__JMLAnnotation__EnsuresAssignment_7 : ( ruleEString ) ;
	public final void rule__JMLAnnotation__EnsuresAssignment_7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6457:2: ( ( ruleEString ) )
			// InternalDsl.g:6458:2: ( ruleEString )
			{
			// InternalDsl.g:6458:2: ( ruleEString )
			// InternalDsl.g:6459:3: ruleEString
			{
			 before(grammarAccess.getJMLAnnotationAccess().getEnsuresEStringParserRuleCall_7_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getJMLAnnotationAccess().getEnsuresEStringParserRuleCall_7_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JMLAnnotation__EnsuresAssignment_7"



	// $ANTLR start "rule__BlockStatement__NameAssignment_1"
	// InternalDsl.g:6468:1: rule__BlockStatement__NameAssignment_1 : ( ruleEString ) ;
	public final void rule__BlockStatement__NameAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6472:2: ( ( ruleEString ) )
			// InternalDsl.g:6473:2: ( ruleEString )
			{
			// InternalDsl.g:6473:2: ( ruleEString )
			// InternalDsl.g:6474:3: ruleEString
			{
			 before(grammarAccess.getBlockStatementAccess().getNameEStringParserRuleCall_1_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getBlockStatementAccess().getNameEStringParserRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__NameAssignment_1"



	// $ANTLR start "rule__BlockStatement__JmlAnnotationAssignment_3"
	// InternalDsl.g:6483:1: rule__BlockStatement__JmlAnnotationAssignment_3 : ( ruleJMLAnnotation ) ;
	public final void rule__BlockStatement__JmlAnnotationAssignment_3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6487:2: ( ( ruleJMLAnnotation ) )
			// InternalDsl.g:6488:2: ( ruleJMLAnnotation )
			{
			// InternalDsl.g:6488:2: ( ruleJMLAnnotation )
			// InternalDsl.g:6489:3: ruleJMLAnnotation
			{
			 before(grammarAccess.getBlockStatementAccess().getJmlAnnotationJMLAnnotationParserRuleCall_3_0()); 
			pushFollow(FOLLOW_2);
			ruleJMLAnnotation();
			state._fsp--;

			 after(grammarAccess.getBlockStatementAccess().getJmlAnnotationJMLAnnotationParserRuleCall_3_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__JmlAnnotationAssignment_3"



	// $ANTLR start "rule__BlockStatement__JavaStatementAssignment_5"
	// InternalDsl.g:6498:1: rule__BlockStatement__JavaStatementAssignment_5 : ( ruleJavaStatement ) ;
	public final void rule__BlockStatement__JavaStatementAssignment_5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6502:2: ( ( ruleJavaStatement ) )
			// InternalDsl.g:6503:2: ( ruleJavaStatement )
			{
			// InternalDsl.g:6503:2: ( ruleJavaStatement )
			// InternalDsl.g:6504:3: ruleJavaStatement
			{
			 before(grammarAccess.getBlockStatementAccess().getJavaStatementJavaStatementParserRuleCall_5_0()); 
			pushFollow(FOLLOW_2);
			ruleJavaStatement();
			state._fsp--;

			 after(grammarAccess.getBlockStatementAccess().getJavaStatementJavaStatementParserRuleCall_5_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__BlockStatement__JavaStatementAssignment_5"



	// $ANTLR start "rule__SelectionStatement__GuardsAssignment_3"
	// InternalDsl.g:6513:1: rule__SelectionStatement__GuardsAssignment_3 : ( ruleCondition ) ;
	public final void rule__SelectionStatement__GuardsAssignment_3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6517:2: ( ( ruleCondition ) )
			// InternalDsl.g:6518:2: ( ruleCondition )
			{
			// InternalDsl.g:6518:2: ( ruleCondition )
			// InternalDsl.g:6519:3: ruleCondition
			{
			 before(grammarAccess.getSelectionStatementAccess().getGuardsConditionParserRuleCall_3_0()); 
			pushFollow(FOLLOW_2);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getSelectionStatementAccess().getGuardsConditionParserRuleCall_3_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__GuardsAssignment_3"



	// $ANTLR start "rule__SelectionStatement__CommandsAssignment_7"
	// InternalDsl.g:6528:1: rule__SelectionStatement__CommandsAssignment_7 : ( ruleAbstractStatement ) ;
	public final void rule__SelectionStatement__CommandsAssignment_7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6532:2: ( ( ruleAbstractStatement ) )
			// InternalDsl.g:6533:2: ( ruleAbstractStatement )
			{
			// InternalDsl.g:6533:2: ( ruleAbstractStatement )
			// InternalDsl.g:6534:3: ruleAbstractStatement
			{
			 before(grammarAccess.getSelectionStatementAccess().getCommandsAbstractStatementParserRuleCall_7_0()); 
			pushFollow(FOLLOW_2);
			ruleAbstractStatement();
			state._fsp--;

			 after(grammarAccess.getSelectionStatementAccess().getCommandsAbstractStatementParserRuleCall_7_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__CommandsAssignment_7"



	// $ANTLR start "rule__SelectionStatement__GuardsAssignment_9_2"
	// InternalDsl.g:6543:1: rule__SelectionStatement__GuardsAssignment_9_2 : ( ruleCondition ) ;
	public final void rule__SelectionStatement__GuardsAssignment_9_2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6547:2: ( ( ruleCondition ) )
			// InternalDsl.g:6548:2: ( ruleCondition )
			{
			// InternalDsl.g:6548:2: ( ruleCondition )
			// InternalDsl.g:6549:3: ruleCondition
			{
			 before(grammarAccess.getSelectionStatementAccess().getGuardsConditionParserRuleCall_9_2_0()); 
			pushFollow(FOLLOW_2);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getSelectionStatementAccess().getGuardsConditionParserRuleCall_9_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__GuardsAssignment_9_2"



	// $ANTLR start "rule__SelectionStatement__CommandsAssignment_9_6"
	// InternalDsl.g:6558:1: rule__SelectionStatement__CommandsAssignment_9_6 : ( ruleAbstractStatement ) ;
	public final void rule__SelectionStatement__CommandsAssignment_9_6() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6562:2: ( ( ruleAbstractStatement ) )
			// InternalDsl.g:6563:2: ( ruleAbstractStatement )
			{
			// InternalDsl.g:6563:2: ( ruleAbstractStatement )
			// InternalDsl.g:6564:3: ruleAbstractStatement
			{
			 before(grammarAccess.getSelectionStatementAccess().getCommandsAbstractStatementParserRuleCall_9_6_0()); 
			pushFollow(FOLLOW_2);
			ruleAbstractStatement();
			state._fsp--;

			 after(grammarAccess.getSelectionStatementAccess().getCommandsAbstractStatementParserRuleCall_9_6_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SelectionStatement__CommandsAssignment_9_6"



	// $ANTLR start "rule__SmallRepetitionStatement__GuardAssignment_3"
	// InternalDsl.g:6573:1: rule__SmallRepetitionStatement__GuardAssignment_3 : ( ruleCondition ) ;
	public final void rule__SmallRepetitionStatement__GuardAssignment_3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6577:2: ( ( ruleCondition ) )
			// InternalDsl.g:6578:2: ( ruleCondition )
			{
			// InternalDsl.g:6578:2: ( ruleCondition )
			// InternalDsl.g:6579:3: ruleCondition
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getGuardConditionParserRuleCall_3_0()); 
			pushFollow(FOLLOW_2);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getSmallRepetitionStatementAccess().getGuardConditionParserRuleCall_3_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__GuardAssignment_3"



	// $ANTLR start "rule__SmallRepetitionStatement__InvariantAssignment_8"
	// InternalDsl.g:6588:1: rule__SmallRepetitionStatement__InvariantAssignment_8 : ( ruleCondition ) ;
	public final void rule__SmallRepetitionStatement__InvariantAssignment_8() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6592:2: ( ( ruleCondition ) )
			// InternalDsl.g:6593:2: ( ruleCondition )
			{
			// InternalDsl.g:6593:2: ( ruleCondition )
			// InternalDsl.g:6594:3: ruleCondition
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getInvariantConditionParserRuleCall_8_0()); 
			pushFollow(FOLLOW_2);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getSmallRepetitionStatementAccess().getInvariantConditionParserRuleCall_8_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__InvariantAssignment_8"



	// $ANTLR start "rule__SmallRepetitionStatement__VariantAssignment_12"
	// InternalDsl.g:6603:1: rule__SmallRepetitionStatement__VariantAssignment_12 : ( ruleVariant ) ;
	public final void rule__SmallRepetitionStatement__VariantAssignment_12() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6607:2: ( ( ruleVariant ) )
			// InternalDsl.g:6608:2: ( ruleVariant )
			{
			// InternalDsl.g:6608:2: ( ruleVariant )
			// InternalDsl.g:6609:3: ruleVariant
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getVariantVariantParserRuleCall_12_0()); 
			pushFollow(FOLLOW_2);
			ruleVariant();
			state._fsp--;

			 after(grammarAccess.getSmallRepetitionStatementAccess().getVariantVariantParserRuleCall_12_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__VariantAssignment_12"



	// $ANTLR start "rule__SmallRepetitionStatement__LoopStatementAssignment_15"
	// InternalDsl.g:6618:1: rule__SmallRepetitionStatement__LoopStatementAssignment_15 : ( ruleAbstractStatement ) ;
	public final void rule__SmallRepetitionStatement__LoopStatementAssignment_15() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6622:2: ( ( ruleAbstractStatement ) )
			// InternalDsl.g:6623:2: ( ruleAbstractStatement )
			{
			// InternalDsl.g:6623:2: ( ruleAbstractStatement )
			// InternalDsl.g:6624:3: ruleAbstractStatement
			{
			 before(grammarAccess.getSmallRepetitionStatementAccess().getLoopStatementAbstractStatementParserRuleCall_15_0()); 
			pushFollow(FOLLOW_2);
			ruleAbstractStatement();
			state._fsp--;

			 after(grammarAccess.getSmallRepetitionStatementAccess().getLoopStatementAbstractStatementParserRuleCall_15_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__SmallRepetitionStatement__LoopStatementAssignment_15"



	// $ANTLR start "rule__Variant__NameAssignment_1"
	// InternalDsl.g:6633:1: rule__Variant__NameAssignment_1 : ( ruleEString ) ;
	public final void rule__Variant__NameAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6637:2: ( ( ruleEString ) )
			// InternalDsl.g:6638:2: ( ruleEString )
			{
			// InternalDsl.g:6638:2: ( ruleEString )
			// InternalDsl.g:6639:3: ruleEString
			{
			 before(grammarAccess.getVariantAccess().getNameEStringParserRuleCall_1_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getVariantAccess().getNameEStringParserRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Variant__NameAssignment_1"



	// $ANTLR start "rule__JavaVariables__VariablesAssignment_2_2"
	// InternalDsl.g:6648:1: rule__JavaVariables__VariablesAssignment_2_2 : ( ruleJavaVariable ) ;
	public final void rule__JavaVariables__VariablesAssignment_2_2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6652:2: ( ( ruleJavaVariable ) )
			// InternalDsl.g:6653:2: ( ruleJavaVariable )
			{
			// InternalDsl.g:6653:2: ( ruleJavaVariable )
			// InternalDsl.g:6654:3: ruleJavaVariable
			{
			 before(grammarAccess.getJavaVariablesAccess().getVariablesJavaVariableParserRuleCall_2_2_0()); 
			pushFollow(FOLLOW_2);
			ruleJavaVariable();
			state._fsp--;

			 after(grammarAccess.getJavaVariablesAccess().getVariablesJavaVariableParserRuleCall_2_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__VariablesAssignment_2_2"



	// $ANTLR start "rule__JavaVariables__VariablesAssignment_2_3_1"
	// InternalDsl.g:6663:1: rule__JavaVariables__VariablesAssignment_2_3_1 : ( ruleJavaVariable ) ;
	public final void rule__JavaVariables__VariablesAssignment_2_3_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6667:2: ( ( ruleJavaVariable ) )
			// InternalDsl.g:6668:2: ( ruleJavaVariable )
			{
			// InternalDsl.g:6668:2: ( ruleJavaVariable )
			// InternalDsl.g:6669:3: ruleJavaVariable
			{
			 before(grammarAccess.getJavaVariablesAccess().getVariablesJavaVariableParserRuleCall_2_3_1_0()); 
			pushFollow(FOLLOW_2);
			ruleJavaVariable();
			state._fsp--;

			 after(grammarAccess.getJavaVariablesAccess().getVariablesJavaVariableParserRuleCall_2_3_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariables__VariablesAssignment_2_3_1"



	// $ANTLR start "rule__JavaVariable__NameAssignment_1"
	// InternalDsl.g:6678:1: rule__JavaVariable__NameAssignment_1 : ( ruleEString ) ;
	public final void rule__JavaVariable__NameAssignment_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6682:2: ( ( ruleEString ) )
			// InternalDsl.g:6683:2: ( ruleEString )
			{
			// InternalDsl.g:6683:2: ( ruleEString )
			// InternalDsl.g:6684:3: ruleEString
			{
			 before(grammarAccess.getJavaVariableAccess().getNameEStringParserRuleCall_1_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getJavaVariableAccess().getNameEStringParserRuleCall_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__JavaVariable__NameAssignment_1"



	// $ANTLR start "rule__GlobalConditions__ConditionsAssignment_2_2"
	// InternalDsl.g:6693:1: rule__GlobalConditions__ConditionsAssignment_2_2 : ( ruleCondition ) ;
	public final void rule__GlobalConditions__ConditionsAssignment_2_2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6697:2: ( ( ruleCondition ) )
			// InternalDsl.g:6698:2: ( ruleCondition )
			{
			// InternalDsl.g:6698:2: ( ruleCondition )
			// InternalDsl.g:6699:3: ruleCondition
			{
			 before(grammarAccess.getGlobalConditionsAccess().getConditionsConditionParserRuleCall_2_2_0()); 
			pushFollow(FOLLOW_2);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getGlobalConditionsAccess().getConditionsConditionParserRuleCall_2_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__ConditionsAssignment_2_2"



	// $ANTLR start "rule__GlobalConditions__ConditionsAssignment_2_3_1"
	// InternalDsl.g:6708:1: rule__GlobalConditions__ConditionsAssignment_2_3_1 : ( ruleCondition ) ;
	public final void rule__GlobalConditions__ConditionsAssignment_2_3_1() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6712:2: ( ( ruleCondition ) )
			// InternalDsl.g:6713:2: ( ruleCondition )
			{
			// InternalDsl.g:6713:2: ( ruleCondition )
			// InternalDsl.g:6714:3: ruleCondition
			{
			 before(grammarAccess.getGlobalConditionsAccess().getConditionsConditionParserRuleCall_2_3_1_0()); 
			pushFollow(FOLLOW_2);
			ruleCondition();
			state._fsp--;

			 after(grammarAccess.getGlobalConditionsAccess().getConditionsConditionParserRuleCall_2_3_1_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__GlobalConditions__ConditionsAssignment_2_3_1"



	// $ANTLR start "rule__Renaming__RenameAssignment_2_2"
	// InternalDsl.g:6723:1: rule__Renaming__RenameAssignment_2_2 : ( ruleRename ) ;
	public final void rule__Renaming__RenameAssignment_2_2() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6727:2: ( ( ruleRename ) )
			// InternalDsl.g:6728:2: ( ruleRename )
			{
			// InternalDsl.g:6728:2: ( ruleRename )
			// InternalDsl.g:6729:3: ruleRename
			{
			 before(grammarAccess.getRenamingAccess().getRenameRenameParserRuleCall_2_2_0()); 
			pushFollow(FOLLOW_2);
			ruleRename();
			state._fsp--;

			 after(grammarAccess.getRenamingAccess().getRenameRenameParserRuleCall_2_2_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__RenameAssignment_2_2"



	// $ANTLR start "rule__Renaming__RenameAssignment_2_3"
	// InternalDsl.g:6738:1: rule__Renaming__RenameAssignment_2_3 : ( ruleRename ) ;
	public final void rule__Renaming__RenameAssignment_2_3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6742:2: ( ( ruleRename ) )
			// InternalDsl.g:6743:2: ( ruleRename )
			{
			// InternalDsl.g:6743:2: ( ruleRename )
			// InternalDsl.g:6744:3: ruleRename
			{
			 before(grammarAccess.getRenamingAccess().getRenameRenameParserRuleCall_2_3_0()); 
			pushFollow(FOLLOW_2);
			ruleRename();
			state._fsp--;

			 after(grammarAccess.getRenamingAccess().getRenameRenameParserRuleCall_2_3_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Renaming__RenameAssignment_2_3"



	// $ANTLR start "rule__Rename__TypeAssignment_3"
	// InternalDsl.g:6753:1: rule__Rename__TypeAssignment_3 : ( ruleEString ) ;
	public final void rule__Rename__TypeAssignment_3() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6757:2: ( ( ruleEString ) )
			// InternalDsl.g:6758:2: ( ruleEString )
			{
			// InternalDsl.g:6758:2: ( ruleEString )
			// InternalDsl.g:6759:3: ruleEString
			{
			 before(grammarAccess.getRenameAccess().getTypeEStringParserRuleCall_3_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getRenameAccess().getTypeEStringParserRuleCall_3_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__TypeAssignment_3"



	// $ANTLR start "rule__Rename__FunctionAssignment_5"
	// InternalDsl.g:6768:1: rule__Rename__FunctionAssignment_5 : ( ruleEString ) ;
	public final void rule__Rename__FunctionAssignment_5() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6772:2: ( ( ruleEString ) )
			// InternalDsl.g:6773:2: ( ruleEString )
			{
			// InternalDsl.g:6773:2: ( ruleEString )
			// InternalDsl.g:6774:3: ruleEString
			{
			 before(grammarAccess.getRenameAccess().getFunctionEStringParserRuleCall_5_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getRenameAccess().getFunctionEStringParserRuleCall_5_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__FunctionAssignment_5"



	// $ANTLR start "rule__Rename__NewNameAssignment_7"
	// InternalDsl.g:6783:1: rule__Rename__NewNameAssignment_7 : ( ruleEString ) ;
	public final void rule__Rename__NewNameAssignment_7() throws RecognitionException {

				int stackSize = keepStackSize();
			
		try {
			// InternalDsl.g:6787:2: ( ( ruleEString ) )
			// InternalDsl.g:6788:2: ( ruleEString )
			{
			// InternalDsl.g:6788:2: ( ruleEString )
			// InternalDsl.g:6789:3: ruleEString
			{
			 before(grammarAccess.getRenameAccess().getNewNameEStringParserRuleCall_7_0()); 
			pushFollow(FOLLOW_2);
			ruleEString();
			state._fsp--;

			 after(grammarAccess.getRenameAccess().getNewNameEStringParserRuleCall_7_0()); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving

				restoreStackSize(stackSize);

		}
	}
	// $ANTLR end "rule__Rename__NewNameAssignment_7"

	// Delegated rules



	public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000220L});
	public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00C2820021000220L});
	public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000402000000L});
	public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000108060L});
	public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100060L});
	public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001564000L});
	public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000564002L});
	public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000060L});
	public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000400208000L});
	public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000110060L});
	public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000100020L});
	public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000800100060L});
	public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0080000004000000L});
	public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x000000C000000000L});
	public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0100000000080000L});
	public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0180000000000000L});
	public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x00000003C0000002L});
}
