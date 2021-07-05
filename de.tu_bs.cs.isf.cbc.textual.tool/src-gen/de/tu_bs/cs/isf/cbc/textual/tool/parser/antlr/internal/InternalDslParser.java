package de.tu_bs.cs.isf.cbc.textual.tool.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.tu_bs.cs.isf.cbc.textual.tool.services.DslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class InternalDslParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ANY_OTHER", "RULE_CHARACTER", 
		"RULE_DECIMAL", "RULE_HEX", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", 
		"RULE_SL_COMMENT", "RULE_STRING", "RULE_WS", "'!'", "'!='", "'#'", "'%'", 
		"'%='", "'&&'", "'&'", "'&='", "'('", "'(\\\\exists'", "'(\\\\foreach'", 
		"')'", "'*'", "'*='", "'+'", "'++'", "'+='", "','", "'-'", "'--'", "'-='", 
		"'->'", "'.'", "'...'", "'/'", "'/='", "':'", "';'", "'<'", "'<<'", "'<='", 
		"'='", "'=='", "'>'", "'>='", "'?'", "'@'", "'Block'", "'Conditions'", 
		"'Do'", "'Elseif'", "'Fi'", "'Formula'", "'Function'", "'GlobalConditions'", 
		"'If'", "'Intm:'", "'Inv:'", "'JavaVariables'", "'NewName'", "'Od'", "'Post:'", 
		"'Pre:'", "'Renames'", "'Renaming'", "'Return'", "'Then'", "'Type'", "'Var:'", 
		"'Variables'", "'While'", "'['", "']'", "'^'", "'^='", "'break'", "'case'", 
		"'catch'", "'class'", "'continue'", "'default'", "'do'", "'else'", "'extends'", 
		"'extension'", "'false'", "'final'", "'finally'", "'for'", "'if'", "'import'", 
		"'instanceof'", "'new'", "'null'", "'return'", "'static'", "'super'", 
		"'switch'", "'synchronized'", "'throw'", "'true'", "'try'", "'while'", 
		"'{'", "'|'", "'|='", "'||'", "'}'", "'~'"
	};
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
	public AbstractInternalAntlrParser[] getDelegates() {
		return new AbstractInternalAntlrParser[] {};
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

	    public InternalDslParser(TokenStream input, DslGrammarAccess grammarAccess) {
	        this(input);
	        this.grammarAccess = grammarAccess;
	        registerRules(grammarAccess.getGrammar());
	    }

	    @Override
	    protected String getFirstRuleName() {
	    	return "CbCProblem";
	   	}

	   	@Override
	   	protected DslGrammarAccess getGrammarAccess() {
	   		return grammarAccess;
	   	}




	// $ANTLR start "entryRuleCbCProblem"
	// InternalDsl.g:64:1: entryRuleCbCProblem returns [EObject current=null] :iv_ruleCbCProblem= ruleCbCProblem EOF ;
	public final EObject entryRuleCbCProblem() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleCbCProblem =null;

		try {
			// InternalDsl.g:64:51: (iv_ruleCbCProblem= ruleCbCProblem EOF )
			// InternalDsl.g:65:2: iv_ruleCbCProblem= ruleCbCProblem EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getCbCProblemRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleCbCProblem=ruleCbCProblem();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleCbCProblem; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleCbCProblem"



	// $ANTLR start "ruleCbCProblem"
	// InternalDsl.g:71:1: ruleCbCProblem returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) ) ) |this_BlockStatement_5= ruleBlockStatement ) ;
	public final EObject ruleCbCProblem() throws RecognitionException {
		EObject current = null;


		EObject lv_cbcformula_1_0 =null;
		EObject lv_globalcondition_2_0 =null;
		EObject lv_javaVariable_3_0 =null;
		EObject lv_renaming_4_0 =null;
		EObject this_BlockStatement_5 =null;


			enterRule();

		try {
			// InternalDsl.g:77:2: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) ) ) |this_BlockStatement_5= ruleBlockStatement ) )
			// InternalDsl.g:78:2: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) ) ) |this_BlockStatement_5= ruleBlockStatement )
			{
			// InternalDsl.g:78:2: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) ) ) |this_BlockStatement_5= ruleBlockStatement )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==56||LA2_0==58||LA2_0==62||LA2_0==68) ) {
				alt2=1;
			}
			else if ( (LA2_0==51) ) {
				alt2=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// InternalDsl.g:79:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) ) )
					{
					// InternalDsl.g:79:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) ) )
					// InternalDsl.g:80:4: ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) )
					{
					// InternalDsl.g:80:4: ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) )
					// InternalDsl.g:81:5: ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?)
					{
					getUnorderedGroupHelper().enter(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0());
					// InternalDsl.g:84:5: ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?)
					// InternalDsl.g:85:6: ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?
					{
					// InternalDsl.g:85:6: ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+
					int cnt1=0;
					loop1:
					while (true) {
						int alt1=5;
						int LA1_0 = input.LA(1);
						if ( LA1_0 == 56 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 0) ) {
							alt1=1;
						}
						else if ( LA1_0 == 58 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 1) ) {
							alt1=2;
						}
						else if ( LA1_0 == 62 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 2) ) {
							alt1=3;
						}
						else if ( LA1_0 == 68 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 3) ) {
							alt1=4;
						}

						switch (alt1) {
						case 1 :
							// InternalDsl.g:86:4: ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) )
							{
							// InternalDsl.g:86:4: ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) )
							// InternalDsl.g:87:5: {...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) )
							{
							if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 0) ) {
								if (state.backtracking>0) {state.failed=true; return current;}
								throw new FailedPredicateException(input, "ruleCbCProblem", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 0)");
							}
							// InternalDsl.g:87:107: ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) )
							// InternalDsl.g:88:6: ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) )
							{
							getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 0);
							// InternalDsl.g:91:9: ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) )
							// InternalDsl.g:91:10: {...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) )
							{
							if ( !((true)) ) {
								if (state.backtracking>0) {state.failed=true; return current;}
								throw new FailedPredicateException(input, "ruleCbCProblem", "true");
							}
							// InternalDsl.g:91:19: ( (lv_cbcformula_1_0= ruleCbCFormula ) )
							// InternalDsl.g:91:20: (lv_cbcformula_1_0= ruleCbCFormula )
							{
							// InternalDsl.g:91:20: (lv_cbcformula_1_0= ruleCbCFormula )
							// InternalDsl.g:92:10: lv_cbcformula_1_0= ruleCbCFormula
							{
							if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getCbCProblemAccess().getCbcformulaCbCFormulaParserRuleCall_0_0_0());
																}
							pushFollow(FOLLOW_3);
							lv_cbcformula_1_0=ruleCbCFormula();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getCbCProblemRule());
																	}
																	set(
																		current,
																		"cbcformula",
																		lv_cbcformula_1_0,
																		"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.CbCFormula");
																	afterParserOrEnumRuleCall();
																}
							}

							}

							}

							getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0());
							}

							}

							}
							break;
						case 2 :
							// InternalDsl.g:114:4: ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) )
							{
							// InternalDsl.g:114:4: ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) )
							// InternalDsl.g:115:5: {...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) )
							{
							if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 1) ) {
								if (state.backtracking>0) {state.failed=true; return current;}
								throw new FailedPredicateException(input, "ruleCbCProblem", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 1)");
							}
							// InternalDsl.g:115:107: ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) )
							// InternalDsl.g:116:6: ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) )
							{
							getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 1);
							// InternalDsl.g:119:9: ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) )
							// InternalDsl.g:119:10: {...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) )
							{
							if ( !((true)) ) {
								if (state.backtracking>0) {state.failed=true; return current;}
								throw new FailedPredicateException(input, "ruleCbCProblem", "true");
							}
							// InternalDsl.g:119:19: ( (lv_globalcondition_2_0= ruleGlobalConditions ) )
							// InternalDsl.g:119:20: (lv_globalcondition_2_0= ruleGlobalConditions )
							{
							// InternalDsl.g:119:20: (lv_globalcondition_2_0= ruleGlobalConditions )
							// InternalDsl.g:120:10: lv_globalcondition_2_0= ruleGlobalConditions
							{
							if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getCbCProblemAccess().getGlobalconditionGlobalConditionsParserRuleCall_0_1_0());
																}
							pushFollow(FOLLOW_3);
							lv_globalcondition_2_0=ruleGlobalConditions();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getCbCProblemRule());
																	}
																	set(
																		current,
																		"globalcondition",
																		lv_globalcondition_2_0,
																		"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.GlobalConditions");
																	afterParserOrEnumRuleCall();
																}
							}

							}

							}

							getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0());
							}

							}

							}
							break;
						case 3 :
							// InternalDsl.g:142:4: ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) )
							{
							// InternalDsl.g:142:4: ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) )
							// InternalDsl.g:143:5: {...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) )
							{
							if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 2) ) {
								if (state.backtracking>0) {state.failed=true; return current;}
								throw new FailedPredicateException(input, "ruleCbCProblem", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 2)");
							}
							// InternalDsl.g:143:107: ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) )
							// InternalDsl.g:144:6: ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) )
							{
							getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 2);
							// InternalDsl.g:147:9: ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) )
							// InternalDsl.g:147:10: {...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) )
							{
							if ( !((true)) ) {
								if (state.backtracking>0) {state.failed=true; return current;}
								throw new FailedPredicateException(input, "ruleCbCProblem", "true");
							}
							// InternalDsl.g:147:19: ( (lv_javaVariable_3_0= ruleJavaVariables ) )
							// InternalDsl.g:147:20: (lv_javaVariable_3_0= ruleJavaVariables )
							{
							// InternalDsl.g:147:20: (lv_javaVariable_3_0= ruleJavaVariables )
							// InternalDsl.g:148:10: lv_javaVariable_3_0= ruleJavaVariables
							{
							if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getCbCProblemAccess().getJavaVariableJavaVariablesParserRuleCall_0_2_0());
																}
							pushFollow(FOLLOW_3);
							lv_javaVariable_3_0=ruleJavaVariables();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getCbCProblemRule());
																	}
																	set(
																		current,
																		"javaVariable",
																		lv_javaVariable_3_0,
																		"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.JavaVariables");
																	afterParserOrEnumRuleCall();
																}
							}

							}

							}

							getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0());
							}

							}

							}
							break;
						case 4 :
							// InternalDsl.g:170:4: ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) )
							{
							// InternalDsl.g:170:4: ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) )
							// InternalDsl.g:171:5: {...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) )
							{
							if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 3) ) {
								if (state.backtracking>0) {state.failed=true; return current;}
								throw new FailedPredicateException(input, "ruleCbCProblem", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 3)");
							}
							// InternalDsl.g:171:107: ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) )
							// InternalDsl.g:172:6: ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) )
							{
							getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0(), 3);
							// InternalDsl.g:175:9: ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) )
							// InternalDsl.g:175:10: {...}? => ( (lv_renaming_4_0= ruleRenaming ) )
							{
							if ( !((true)) ) {
								if (state.backtracking>0) {state.failed=true; return current;}
								throw new FailedPredicateException(input, "ruleCbCProblem", "true");
							}
							// InternalDsl.g:175:19: ( (lv_renaming_4_0= ruleRenaming ) )
							// InternalDsl.g:175:20: (lv_renaming_4_0= ruleRenaming )
							{
							// InternalDsl.g:175:20: (lv_renaming_4_0= ruleRenaming )
							// InternalDsl.g:176:10: lv_renaming_4_0= ruleRenaming
							{
							if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getCbCProblemAccess().getRenamingRenamingParserRuleCall_0_3_0());
																}
							pushFollow(FOLLOW_3);
							lv_renaming_4_0=ruleRenaming();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getCbCProblemRule());
																	}
																	set(
																		current,
																		"renaming",
																		lv_renaming_4_0,
																		"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Renaming");
																	afterParserOrEnumRuleCall();
																}
							}

							}

							}

							getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0());
							}

							}

							}
							break;

						default :
							if ( cnt1 >= 1 ) break loop1;
							if (state.backtracking>0) {state.failed=true; return current;}
							EarlyExitException eee = new EarlyExitException(1, input);
							throw eee;
						}
						cnt1++;
					}

					if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0()) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleCbCProblem", "getUnorderedGroupHelper().canLeave(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0())");
					}
					}

					}

					getUnorderedGroupHelper().leave(grammarAccess.getCbCProblemAccess().getUnorderedGroup_0());
					}

					}
					break;
				case 2 :
					// InternalDsl.g:207:3: this_BlockStatement_5= ruleBlockStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getCbCProblemAccess().getBlockStatementParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_BlockStatement_5=ruleBlockStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_BlockStatement_5;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleCbCProblem"



	// $ANTLR start "entryRuleCbCFormula"
	// InternalDsl.g:219:1: entryRuleCbCFormula returns [EObject current=null] :iv_ruleCbCFormula= ruleCbCFormula EOF ;
	public final EObject entryRuleCbCFormula() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleCbCFormula =null;

		try {
			// InternalDsl.g:219:51: (iv_ruleCbCFormula= ruleCbCFormula EOF )
			// InternalDsl.g:220:2: iv_ruleCbCFormula= ruleCbCFormula EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getCbCFormulaRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleCbCFormula=ruleCbCFormula();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleCbCFormula; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleCbCFormula"



	// $ANTLR start "ruleCbCFormula"
	// InternalDsl.g:226:1: ruleCbCFormula returns [EObject current=null] : (otherlv_0= 'Formula' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'Pre:' otherlv_3= '(' ( (lv_preCondition_4_0= ruleCondition ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_statement_7_0= ruleAbstractStatement ) ) otherlv_8= '}' otherlv_9= 'Post:' otherlv_10= '(' ( (lv_postCondition_11_0= ruleCondition ) ) otherlv_12= ')' ) ;
	public final EObject ruleCbCFormula() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token otherlv_2=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token otherlv_9=null;
		Token otherlv_10=null;
		Token otherlv_12=null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;
		EObject lv_preCondition_4_0 =null;
		EObject lv_statement_7_0 =null;
		EObject lv_postCondition_11_0 =null;


			enterRule();

		try {
			// InternalDsl.g:232:2: ( (otherlv_0= 'Formula' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'Pre:' otherlv_3= '(' ( (lv_preCondition_4_0= ruleCondition ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_statement_7_0= ruleAbstractStatement ) ) otherlv_8= '}' otherlv_9= 'Post:' otherlv_10= '(' ( (lv_postCondition_11_0= ruleCondition ) ) otherlv_12= ')' ) )
			// InternalDsl.g:233:2: (otherlv_0= 'Formula' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'Pre:' otherlv_3= '(' ( (lv_preCondition_4_0= ruleCondition ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_statement_7_0= ruleAbstractStatement ) ) otherlv_8= '}' otherlv_9= 'Post:' otherlv_10= '(' ( (lv_postCondition_11_0= ruleCondition ) ) otherlv_12= ')' )
			{
			// InternalDsl.g:233:2: (otherlv_0= 'Formula' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'Pre:' otherlv_3= '(' ( (lv_preCondition_4_0= ruleCondition ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_statement_7_0= ruleAbstractStatement ) ) otherlv_8= '}' otherlv_9= 'Post:' otherlv_10= '(' ( (lv_postCondition_11_0= ruleCondition ) ) otherlv_12= ')' )
			// InternalDsl.g:234:3: otherlv_0= 'Formula' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'Pre:' otherlv_3= '(' ( (lv_preCondition_4_0= ruleCondition ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_statement_7_0= ruleAbstractStatement ) ) otherlv_8= '}' otherlv_9= 'Post:' otherlv_10= '(' ( (lv_postCondition_11_0= ruleCondition ) ) otherlv_12= ')'
			{
			otherlv_0=(Token)match(input,56,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getCbCFormulaAccess().getFormulaKeyword_0());
					}
			// InternalDsl.g:238:3: ( (lv_name_1_0= ruleEString ) )
			// InternalDsl.g:239:4: (lv_name_1_0= ruleEString )
			{
			// InternalDsl.g:239:4: (lv_name_1_0= ruleEString )
			// InternalDsl.g:240:5: lv_name_1_0= ruleEString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getCbCFormulaAccess().getNameEStringParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_5);
			lv_name_1_0=ruleEString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getCbCFormulaRule());
								}
								set(
									current,
									"name",
									lv_name_1_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.EString");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_2=(Token)match(input,66,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getCbCFormulaAccess().getPreKeyword_2());
					}
			otherlv_3=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getCbCFormulaAccess().getLeftParenthesisKeyword_3());
					}
			// InternalDsl.g:265:3: ( (lv_preCondition_4_0= ruleCondition ) )
			// InternalDsl.g:266:4: (lv_preCondition_4_0= ruleCondition )
			{
			// InternalDsl.g:266:4: (lv_preCondition_4_0= ruleCondition )
			// InternalDsl.g:267:5: lv_preCondition_4_0= ruleCondition
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getCbCFormulaAccess().getPreConditionConditionParserRuleCall_4_0());
							}
			pushFollow(FOLLOW_8);
			lv_preCondition_4_0=ruleCondition();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getCbCFormulaRule());
								}
								set(
									current,
									"preCondition",
									lv_preCondition_4_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_5=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getCbCFormulaAccess().getRightParenthesisKeyword_5());
					}
			otherlv_6=(Token)match(input,107,FOLLOW_10); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getCbCFormulaAccess().getLeftCurlyBracketKeyword_6());
					}
			// InternalDsl.g:292:3: ( (lv_statement_7_0= ruleAbstractStatement ) )
			// InternalDsl.g:293:4: (lv_statement_7_0= ruleAbstractStatement )
			{
			// InternalDsl.g:293:4: (lv_statement_7_0= ruleAbstractStatement )
			// InternalDsl.g:294:5: lv_statement_7_0= ruleAbstractStatement
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getCbCFormulaAccess().getStatementAbstractStatementParserRuleCall_7_0());
							}
			pushFollow(FOLLOW_11);
			lv_statement_7_0=ruleAbstractStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getCbCFormulaRule());
								}
								set(
									current,
									"statement",
									lv_statement_7_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.AbstractStatement");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_8=(Token)match(input,111,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getCbCFormulaAccess().getRightCurlyBracketKeyword_8());
					}
			otherlv_9=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_9, grammarAccess.getCbCFormulaAccess().getPostKeyword_9());
					}
			otherlv_10=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_10, grammarAccess.getCbCFormulaAccess().getLeftParenthesisKeyword_10());
					}
			// InternalDsl.g:323:3: ( (lv_postCondition_11_0= ruleCondition ) )
			// InternalDsl.g:324:4: (lv_postCondition_11_0= ruleCondition )
			{
			// InternalDsl.g:324:4: (lv_postCondition_11_0= ruleCondition )
			// InternalDsl.g:325:5: lv_postCondition_11_0= ruleCondition
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getCbCFormulaAccess().getPostConditionConditionParserRuleCall_11_0());
							}
			pushFollow(FOLLOW_8);
			lv_postCondition_11_0=ruleCondition();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getCbCFormulaRule());
								}
								set(
									current,
									"postCondition",
									lv_postCondition_11_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_12=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_12, grammarAccess.getCbCFormulaAccess().getRightParenthesisKeyword_12());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleCbCFormula"



	// $ANTLR start "entryRuleAbstractStatement"
	// InternalDsl.g:350:1: entryRuleAbstractStatement returns [EObject current=null] :iv_ruleAbstractStatement= ruleAbstractStatement EOF ;
	public final EObject entryRuleAbstractStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleAbstractStatement =null;

		try {
			// InternalDsl.g:350:58: (iv_ruleAbstractStatement= ruleAbstractStatement EOF )
			// InternalDsl.g:351:2: iv_ruleAbstractStatement= ruleAbstractStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getAbstractStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleAbstractStatement=ruleAbstractStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleAbstractStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleAbstractStatement"



	// $ANTLR start "ruleAbstractStatement"
	// InternalDsl.g:357:1: ruleAbstractStatement returns [EObject current=null] : (this_AbstractStatement_Impl_0= ruleAbstractStatement_Impl |this_InlineBlockStatement_1= ruleInlineBlockStatement |this_CompositionStatement_2= ruleCompositionStatement |this_SkipStatement_3= ruleSkipStatement |this_SelectionStatement_4= ruleSelectionStatement |this_SmallRepetitionStatement_5= ruleSmallRepetitionStatement |this_MethodStatement_6= ruleMethodStatement |this_ReturnStatement_7= ruleReturnStatement |this_StrengthWeakStatement_8= ruleStrengthWeakStatement ) ;
	public final EObject ruleAbstractStatement() throws RecognitionException {
		EObject current = null;


		EObject this_AbstractStatement_Impl_0 =null;
		EObject this_InlineBlockStatement_1 =null;
		EObject this_CompositionStatement_2 =null;
		EObject this_SkipStatement_3 =null;
		EObject this_SelectionStatement_4 =null;
		EObject this_SmallRepetitionStatement_5 =null;
		EObject this_MethodStatement_6 =null;
		EObject this_ReturnStatement_7 =null;
		EObject this_StrengthWeakStatement_8 =null;


			enterRule();

		try {
			// InternalDsl.g:363:2: ( (this_AbstractStatement_Impl_0= ruleAbstractStatement_Impl |this_InlineBlockStatement_1= ruleInlineBlockStatement |this_CompositionStatement_2= ruleCompositionStatement |this_SkipStatement_3= ruleSkipStatement |this_SelectionStatement_4= ruleSelectionStatement |this_SmallRepetitionStatement_5= ruleSmallRepetitionStatement |this_MethodStatement_6= ruleMethodStatement |this_ReturnStatement_7= ruleReturnStatement |this_StrengthWeakStatement_8= ruleStrengthWeakStatement ) )
			// InternalDsl.g:364:2: (this_AbstractStatement_Impl_0= ruleAbstractStatement_Impl |this_InlineBlockStatement_1= ruleInlineBlockStatement |this_CompositionStatement_2= ruleCompositionStatement |this_SkipStatement_3= ruleSkipStatement |this_SelectionStatement_4= ruleSelectionStatement |this_SmallRepetitionStatement_5= ruleSmallRepetitionStatement |this_MethodStatement_6= ruleMethodStatement |this_ReturnStatement_7= ruleReturnStatement |this_StrengthWeakStatement_8= ruleStrengthWeakStatement )
			{
			// InternalDsl.g:364:2: (this_AbstractStatement_Impl_0= ruleAbstractStatement_Impl |this_InlineBlockStatement_1= ruleInlineBlockStatement |this_CompositionStatement_2= ruleCompositionStatement |this_SkipStatement_3= ruleSkipStatement |this_SelectionStatement_4= ruleSelectionStatement |this_SmallRepetitionStatement_5= ruleSmallRepetitionStatement |this_MethodStatement_6= ruleMethodStatement |this_ReturnStatement_7= ruleReturnStatement |this_StrengthWeakStatement_8= ruleStrengthWeakStatement )
			int alt3=9;
			switch ( input.LA(1) ) {
			case RULE_ID:
				{
				int LA3_1 = input.LA(2);
				if ( (LA3_1==45||LA3_1==75) ) {
					alt3=1;
				}
				else if ( (LA3_1==EOF||LA3_1==111) ) {
					alt3=7;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 51:
				{
				alt3=2;
				}
				break;
			case 107:
				{
				alt3=3;
				}
				break;
			case 41:
				{
				alt3=4;
				}
				break;
			case 59:
				{
				alt3=5;
				}
				break;
			case 74:
				{
				alt3=6;
				}
				break;
			case RULE_STRING:
				{
				alt3=7;
				}
				break;
			case 69:
				{
				alt3=8;
				}
				break;
			case 66:
				{
				alt3=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// InternalDsl.g:365:3: this_AbstractStatement_Impl_0= ruleAbstractStatement_Impl
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getAbstractStatementAccess().getAbstractStatement_ImplParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_AbstractStatement_Impl_0=ruleAbstractStatement_Impl();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_AbstractStatement_Impl_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalDsl.g:374:3: this_InlineBlockStatement_1= ruleInlineBlockStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getAbstractStatementAccess().getInlineBlockStatementParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_InlineBlockStatement_1=ruleInlineBlockStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_InlineBlockStatement_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 3 :
					// InternalDsl.g:383:3: this_CompositionStatement_2= ruleCompositionStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getAbstractStatementAccess().getCompositionStatementParserRuleCall_2());
							}
					pushFollow(FOLLOW_2);
					this_CompositionStatement_2=ruleCompositionStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_CompositionStatement_2;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 4 :
					// InternalDsl.g:392:3: this_SkipStatement_3= ruleSkipStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getAbstractStatementAccess().getSkipStatementParserRuleCall_3());
							}
					pushFollow(FOLLOW_2);
					this_SkipStatement_3=ruleSkipStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_SkipStatement_3;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 5 :
					// InternalDsl.g:401:3: this_SelectionStatement_4= ruleSelectionStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getAbstractStatementAccess().getSelectionStatementParserRuleCall_4());
							}
					pushFollow(FOLLOW_2);
					this_SelectionStatement_4=ruleSelectionStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_SelectionStatement_4;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 6 :
					// InternalDsl.g:410:3: this_SmallRepetitionStatement_5= ruleSmallRepetitionStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getAbstractStatementAccess().getSmallRepetitionStatementParserRuleCall_5());
							}
					pushFollow(FOLLOW_2);
					this_SmallRepetitionStatement_5=ruleSmallRepetitionStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_SmallRepetitionStatement_5;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 7 :
					// InternalDsl.g:419:3: this_MethodStatement_6= ruleMethodStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getAbstractStatementAccess().getMethodStatementParserRuleCall_6());
							}
					pushFollow(FOLLOW_2);
					this_MethodStatement_6=ruleMethodStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_MethodStatement_6;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 8 :
					// InternalDsl.g:428:3: this_ReturnStatement_7= ruleReturnStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getAbstractStatementAccess().getReturnStatementParserRuleCall_7());
							}
					pushFollow(FOLLOW_2);
					this_ReturnStatement_7=ruleReturnStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_ReturnStatement_7;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 9 :
					// InternalDsl.g:437:3: this_StrengthWeakStatement_8= ruleStrengthWeakStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getAbstractStatementAccess().getStrengthWeakStatementParserRuleCall_8());
							}
					pushFollow(FOLLOW_2);
					this_StrengthWeakStatement_8=ruleStrengthWeakStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_StrengthWeakStatement_8;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleAbstractStatement"



	// $ANTLR start "entryRuleEString"
	// InternalDsl.g:449:1: entryRuleEString returns [String current=null] :iv_ruleEString= ruleEString EOF ;
	public final String entryRuleEString() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleEString =null;

		try {
			// InternalDsl.g:449:47: (iv_ruleEString= ruleEString EOF )
			// InternalDsl.g:450:2: iv_ruleEString= ruleEString EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getEStringRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleEString=ruleEString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleEString.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleEString"



	// $ANTLR start "ruleEString"
	// InternalDsl.g:456:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID ) ;
	public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_STRING_0=null;
		Token this_ID_1=null;


			enterRule();

		try {
			// InternalDsl.g:462:2: ( (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID ) )
			// InternalDsl.g:463:2: (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID )
			{
			// InternalDsl.g:463:2: (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==RULE_STRING) ) {
				alt4=1;
			}
			else if ( (LA4_0==RULE_ID) ) {
				alt4=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// InternalDsl.g:464:3: this_STRING_0= RULE_STRING
					{
					this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_STRING_0);
							}
					if ( state.backtracking==0 ) {
								newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:472:3: this_ID_1= RULE_ID
					{
					this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_ID_1);
							}
					if ( state.backtracking==0 ) {
								newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleEString"



	// $ANTLR start "entryRuleCodeString"
	// InternalDsl.g:483:1: entryRuleCodeString returns [String current=null] :iv_ruleCodeString= ruleCodeString EOF ;
	public final String entryRuleCodeString() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleCodeString =null;

		try {
			// InternalDsl.g:483:50: (iv_ruleCodeString= ruleCodeString EOF )
			// InternalDsl.g:484:2: iv_ruleCodeString= ruleCodeString EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getCodeStringRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleCodeString=ruleCodeString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleCodeString.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleCodeString"



	// $ANTLR start "ruleCodeString"
	// InternalDsl.g:490:1: ruleCodeString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )? kw= '=' (kw= '(' )? (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )* kw= ';' )+ ;
	public final AntlrDatatypeRuleToken ruleCodeString() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_ID_0=null;
		Token kw=null;
		Token this_ID_2=null;
		Token this_INT_3=null;
		Token this_INT_9=null;
		Token this_INT_14=null;
		AntlrDatatypeRuleToken this_VariableString_7 =null;
		AntlrDatatypeRuleToken this_Operation_10 =null;
		AntlrDatatypeRuleToken this_VariableString_12 =null;


			enterRule();

		try {
			// InternalDsl.g:496:2: ( (this_ID_0= RULE_ID (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )? kw= '=' (kw= '(' )? (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )* kw= ';' )+ )
			// InternalDsl.g:497:2: (this_ID_0= RULE_ID (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )? kw= '=' (kw= '(' )? (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )* kw= ';' )+
			{
			// InternalDsl.g:497:2: (this_ID_0= RULE_ID (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )? kw= '=' (kw= '(' )? (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )* kw= ';' )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==RULE_ID) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// InternalDsl.g:498:3: this_ID_0= RULE_ID (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )? kw= '=' (kw= '(' )? (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )* kw= ';'
					{
					this_ID_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_ID_0);
							}
					if ( state.backtracking==0 ) {
								newLeafNode(this_ID_0, grammarAccess.getCodeStringAccess().getIDTerminalRuleCall_0());
							}
					// InternalDsl.g:505:3: (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==75) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// InternalDsl.g:506:4: kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']'
							{
							kw=(Token)match(input,75,FOLLOW_14); if (state.failed) return current;
							if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getCodeStringAccess().getLeftSquareBracketKeyword_1_0());
										}
							// InternalDsl.g:511:4: (this_ID_2= RULE_ID |this_INT_3= RULE_INT )
							int alt5=2;
							int LA5_0 = input.LA(1);
							if ( (LA5_0==RULE_ID) ) {
								alt5=1;
							}
							else if ( (LA5_0==RULE_INT) ) {
								alt5=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return current;}
								NoViableAltException nvae =
									new NoViableAltException("", 5, 0, input);
								throw nvae;
							}

							switch (alt5) {
								case 1 :
									// InternalDsl.g:512:5: this_ID_2= RULE_ID
									{
									this_ID_2=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
									if ( state.backtracking==0 ) {
														current.merge(this_ID_2);
													}
									if ( state.backtracking==0 ) {
														newLeafNode(this_ID_2, grammarAccess.getCodeStringAccess().getIDTerminalRuleCall_1_1_0());
													}
									}
									break;
								case 2 :
									// InternalDsl.g:520:5: this_INT_3= RULE_INT
									{
									this_INT_3=(Token)match(input,RULE_INT,FOLLOW_15); if (state.failed) return current;
									if ( state.backtracking==0 ) {
														current.merge(this_INT_3);
													}
									if ( state.backtracking==0 ) {
														newLeafNode(this_INT_3, grammarAccess.getCodeStringAccess().getINTTerminalRuleCall_1_1_1());
													}
									}
									break;

							}

							kw=(Token)match(input,76,FOLLOW_16); if (state.failed) return current;
							if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getCodeStringAccess().getRightSquareBracketKeyword_1_2());
										}
							}
							break;

					}

					kw=(Token)match(input,45,FOLLOW_17); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getCodeStringAccess().getEqualsSignKeyword_2());
							}
					// InternalDsl.g:539:3: (kw= '(' )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==22) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// InternalDsl.g:540:4: kw= '('
							{
							kw=(Token)match(input,22,FOLLOW_18); if (state.failed) return current;
							if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getCodeStringAccess().getLeftParenthesisKeyword_3());
										}
							}
							break;

					}

					// InternalDsl.g:546:3: (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) )
					int alt9=2;
					switch ( input.LA(1) ) {
					case 32:
						{
						int LA9_1 = input.LA(2);
						if ( (LA9_1==RULE_ID) ) {
							alt9=1;
						}
						else if ( (LA9_1==RULE_INT) ) {
							alt9=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return current;}
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
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 9, 0, input);
						throw nvae;
					}
					switch (alt9) {
						case 1 :
							// InternalDsl.g:547:4: this_VariableString_7= ruleVariableString
							{
							if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getCodeStringAccess().getVariableStringParserRuleCall_4_0());
										}
							pushFollow(FOLLOW_19);
							this_VariableString_7=ruleVariableString();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
											current.merge(this_VariableString_7);
										}
							if ( state.backtracking==0 ) {
											afterParserOrEnumRuleCall();
										}
							}
							break;
						case 2 :
							// InternalDsl.g:558:4: ( (kw= '-' )? this_INT_9= RULE_INT )
							{
							// InternalDsl.g:558:4: ( (kw= '-' )? this_INT_9= RULE_INT )
							// InternalDsl.g:559:5: (kw= '-' )? this_INT_9= RULE_INT
							{
							// InternalDsl.g:559:5: (kw= '-' )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==32) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// InternalDsl.g:560:6: kw= '-'
									{
									kw=(Token)match(input,32,FOLLOW_20); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															current.merge(kw);
															newLeafNode(kw, grammarAccess.getCodeStringAccess().getHyphenMinusKeyword_4_1_0());
														}
									}
									break;

							}

							this_INT_9=(Token)match(input,RULE_INT,FOLLOW_19); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(this_INT_9);
											}
							if ( state.backtracking==0 ) {
												newLeafNode(this_INT_9, grammarAccess.getCodeStringAccess().getINTTerminalRuleCall_4_1_1());
											}
							}

							}
							break;

					}

					// InternalDsl.g:575:3: (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==17||LA14_0==26||LA14_0==28||LA14_0==32||LA14_0==38) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// InternalDsl.g:576:4: this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )*
							{
							if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getCodeStringAccess().getOperationParserRuleCall_5_0());
										}
							pushFollow(FOLLOW_17);
							this_Operation_10=ruleOperation();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
											current.merge(this_Operation_10);
										}
							if ( state.backtracking==0 ) {
											afterParserOrEnumRuleCall();
										}
							// InternalDsl.g:586:4: (kw= '(' )*
							loop10:
							while (true) {
								int alt10=2;
								int LA10_0 = input.LA(1);
								if ( (LA10_0==22) ) {
									alt10=1;
								}

								switch (alt10) {
								case 1 :
									// InternalDsl.g:587:5: kw= '('
									{
									kw=(Token)match(input,22,FOLLOW_17); if (state.failed) return current;
									if ( state.backtracking==0 ) {
														current.merge(kw);
														newLeafNode(kw, grammarAccess.getCodeStringAccess().getLeftParenthesisKeyword_5_1());
													}
									}
									break;

								default :
									break loop10;
								}
							}

							// InternalDsl.g:593:4: (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) )
							int alt12=2;
							switch ( input.LA(1) ) {
							case 32:
								{
								int LA12_1 = input.LA(2);
								if ( (LA12_1==RULE_ID) ) {
									alt12=1;
								}
								else if ( (LA12_1==RULE_INT) ) {
									alt12=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return current;}
									int nvaeMark = input.mark();
									try {
										input.consume();
										NoViableAltException nvae =
											new NoViableAltException("", 12, 1, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case RULE_ID:
								{
								alt12=1;
								}
								break;
							case RULE_INT:
								{
								alt12=2;
								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return current;}
								NoViableAltException nvae =
									new NoViableAltException("", 12, 0, input);
								throw nvae;
							}
							switch (alt12) {
								case 1 :
									// InternalDsl.g:594:5: this_VariableString_12= ruleVariableString
									{
									if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getCodeStringAccess().getVariableStringParserRuleCall_5_2_0());
													}
									pushFollow(FOLLOW_21);
									this_VariableString_12=ruleVariableString();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
														current.merge(this_VariableString_12);
													}
									if ( state.backtracking==0 ) {
														afterParserOrEnumRuleCall();
													}
									}
									break;
								case 2 :
									// InternalDsl.g:605:5: ( (kw= '-' )? this_INT_14= RULE_INT )
									{
									// InternalDsl.g:605:5: ( (kw= '-' )? this_INT_14= RULE_INT )
									// InternalDsl.g:606:6: (kw= '-' )? this_INT_14= RULE_INT
									{
									// InternalDsl.g:606:6: (kw= '-' )?
									int alt11=2;
									int LA11_0 = input.LA(1);
									if ( (LA11_0==32) ) {
										alt11=1;
									}
									switch (alt11) {
										case 1 :
											// InternalDsl.g:607:7: kw= '-'
											{
											kw=(Token)match(input,32,FOLLOW_20); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																		current.merge(kw);
																		newLeafNode(kw, grammarAccess.getCodeStringAccess().getHyphenMinusKeyword_5_2_1_0());
																	}
											}
											break;

									}

									this_INT_14=(Token)match(input,RULE_INT,FOLLOW_21); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															current.merge(this_INT_14);
														}
									if ( state.backtracking==0 ) {
															newLeafNode(this_INT_14, grammarAccess.getCodeStringAccess().getINTTerminalRuleCall_5_2_1_1());
														}
									}

									}
									break;

							}

							// InternalDsl.g:622:4: (kw= ')' )*
							loop13:
							while (true) {
								int alt13=2;
								int LA13_0 = input.LA(1);
								if ( (LA13_0==25) ) {
									alt13=1;
								}

								switch (alt13) {
								case 1 :
									// InternalDsl.g:623:5: kw= ')'
									{
									kw=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
									if ( state.backtracking==0 ) {
														current.merge(kw);
														newLeafNode(kw, grammarAccess.getCodeStringAccess().getRightParenthesisKeyword_5_3());
													}
									}
									break;

								default :
									break loop13;
								}
							}

							}
							break;

						default :
							break loop14;
						}
					}

					kw=(Token)match(input,41,FOLLOW_22); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getCodeStringAccess().getSemicolonKeyword_6());
							}
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					if (state.backtracking>0) {state.failed=true; return current;}
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleCodeString"



	// $ANTLR start "entryRuleVariableString"
	// InternalDsl.g:639:1: entryRuleVariableString returns [String current=null] :iv_ruleVariableString= ruleVariableString EOF ;
	public final String entryRuleVariableString() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleVariableString =null;

		try {
			// InternalDsl.g:639:54: (iv_ruleVariableString= ruleVariableString EOF )
			// InternalDsl.g:640:2: iv_ruleVariableString= ruleVariableString EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getVariableStringRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleVariableString=ruleVariableString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleVariableString.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleVariableString"



	// $ANTLR start "ruleVariableString"
	// InternalDsl.g:646:1: ruleVariableString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_ID_1= RULE_ID ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )? ) ;
	public final AntlrDatatypeRuleToken ruleVariableString() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		Token this_ID_1=null;
		Token this_INT_5=null;
		Token this_INT_9=null;
		Token this_INT_16=null;
		AntlrDatatypeRuleToken this_VariableString_3 =null;
		AntlrDatatypeRuleToken this_VariableString_7 =null;
		AntlrDatatypeRuleToken this_VariableString_12 =null;
		AntlrDatatypeRuleToken this_VariableString_14 =null;
		AntlrDatatypeRuleToken this_VariableString_19 =null;
		AntlrDatatypeRuleToken this_VariableString_21 =null;


			enterRule();

		try {
			// InternalDsl.g:652:2: ( ( (kw= '-' )? this_ID_1= RULE_ID ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )? ) )
			// InternalDsl.g:653:2: ( (kw= '-' )? this_ID_1= RULE_ID ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )? )
			{
			// InternalDsl.g:653:2: ( (kw= '-' )? this_ID_1= RULE_ID ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )? )
			// InternalDsl.g:654:3: (kw= '-' )? this_ID_1= RULE_ID ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )?
			{
			// InternalDsl.g:654:3: (kw= '-' )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==32) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// InternalDsl.g:655:4: kw= '-'
					{
					kw=(Token)match(input,32,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_0());
								}
					}
					break;

			}

			this_ID_1=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(this_ID_1);
					}
			if ( state.backtracking==0 ) {
						newLeafNode(this_ID_1, grammarAccess.getVariableStringAccess().getIDTerminalRuleCall_1());
					}
			// InternalDsl.g:668:3: ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )?
			int alt27=4;
			switch ( input.LA(1) ) {
				case 22:
					{
					alt27=1;
					}
					break;
				case 75:
					{
					alt27=2;
					}
					break;
				case 36:
					{
					alt27=3;
					}
					break;
			}
			switch (alt27) {
				case 1 :
					// InternalDsl.g:669:4: ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? )
					{
					// InternalDsl.g:669:4: ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? )
					// InternalDsl.g:670:5: (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )?
					{
					// InternalDsl.g:670:5: (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' )
					// InternalDsl.g:671:6: kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')'
					{
					kw=(Token)match(input,22,FOLLOW_25); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getVariableStringAccess().getLeftParenthesisKeyword_2_0_0_0());
										}
					// InternalDsl.g:676:6: ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( ((LA22_0 >= RULE_ID && LA22_0 <= RULE_INT)||LA22_0==32) ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// InternalDsl.g:677:7: (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )*
							{
							// InternalDsl.g:677:7: (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) )
							int alt18=2;
							switch ( input.LA(1) ) {
							case 32:
								{
								int LA18_1 = input.LA(2);
								if ( (LA18_1==RULE_ID) ) {
									alt18=1;
								}
								else if ( (LA18_1==RULE_INT) ) {
									alt18=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return current;}
									int nvaeMark = input.mark();
									try {
										input.consume();
										NoViableAltException nvae =
											new NoViableAltException("", 18, 1, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case RULE_ID:
								{
								alt18=1;
								}
								break;
							case RULE_INT:
								{
								alt18=2;
								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return current;}
								NoViableAltException nvae =
									new NoViableAltException("", 18, 0, input);
								throw nvae;
							}
							switch (alt18) {
								case 1 :
									// InternalDsl.g:678:8: this_VariableString_3= ruleVariableString
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_0_0_1_0_0());
																}
									pushFollow(FOLLOW_26);
									this_VariableString_3=ruleVariableString();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	current.merge(this_VariableString_3);
																}
									if ( state.backtracking==0 ) {
																	afterParserOrEnumRuleCall();
																}
									}
									break;
								case 2 :
									// InternalDsl.g:689:8: ( (kw= '-' )? this_INT_5= RULE_INT )
									{
									// InternalDsl.g:689:8: ( (kw= '-' )? this_INT_5= RULE_INT )
									// InternalDsl.g:690:9: (kw= '-' )? this_INT_5= RULE_INT
									{
									// InternalDsl.g:690:9: (kw= '-' )?
									int alt17=2;
									int LA17_0 = input.LA(1);
									if ( (LA17_0==32) ) {
										alt17=1;
									}
									switch (alt17) {
										case 1 :
											// InternalDsl.g:691:10: kw= '-'
											{
											kw=(Token)match(input,32,FOLLOW_20); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																					current.merge(kw);
																					newLeafNode(kw, grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_2_0_0_1_0_1_0());
																				}
											}
											break;

									}

									this_INT_5=(Token)match(input,RULE_INT,FOLLOW_26); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																		current.merge(this_INT_5);
																	}
									if ( state.backtracking==0 ) {
																		newLeafNode(this_INT_5, grammarAccess.getVariableStringAccess().getINTTerminalRuleCall_2_0_0_1_0_1_1());
																	}
									}

									}
									break;

							}

							// InternalDsl.g:706:7: (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )*
							loop21:
							while (true) {
								int alt21=2;
								int LA21_0 = input.LA(1);
								if ( (LA21_0==31) ) {
									alt21=1;
								}

								switch (alt21) {
								case 1 :
									// InternalDsl.g:707:8: kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) )
									{
									kw=(Token)match(input,31,FOLLOW_18); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	current.merge(kw);
																	newLeafNode(kw, grammarAccess.getVariableStringAccess().getCommaKeyword_2_0_0_1_1_0());
																}
									// InternalDsl.g:712:8: (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) )
									int alt20=2;
									switch ( input.LA(1) ) {
									case 32:
										{
										int LA20_1 = input.LA(2);
										if ( (LA20_1==RULE_ID) ) {
											alt20=1;
										}
										else if ( (LA20_1==RULE_INT) ) {
											alt20=2;
										}

										else {
											if (state.backtracking>0) {state.failed=true; return current;}
											int nvaeMark = input.mark();
											try {
												input.consume();
												NoViableAltException nvae =
													new NoViableAltException("", 20, 1, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

										}
										break;
									case RULE_ID:
										{
										alt20=1;
										}
										break;
									case RULE_INT:
										{
										alt20=2;
										}
										break;
									default:
										if (state.backtracking>0) {state.failed=true; return current;}
										NoViableAltException nvae =
											new NoViableAltException("", 20, 0, input);
										throw nvae;
									}
									switch (alt20) {
										case 1 :
											// InternalDsl.g:713:9: this_VariableString_7= ruleVariableString
											{
											if ( state.backtracking==0 ) {
																				newCompositeNode(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_0_0_1_1_1_0());
																			}
											pushFollow(FOLLOW_26);
											this_VariableString_7=ruleVariableString();
											state._fsp--;
											if (state.failed) return current;
											if ( state.backtracking==0 ) {
																				current.merge(this_VariableString_7);
																			}
											if ( state.backtracking==0 ) {
																				afterParserOrEnumRuleCall();
																			}
											}
											break;
										case 2 :
											// InternalDsl.g:724:9: ( (kw= '-' )? this_INT_9= RULE_INT )
											{
											// InternalDsl.g:724:9: ( (kw= '-' )? this_INT_9= RULE_INT )
											// InternalDsl.g:725:10: (kw= '-' )? this_INT_9= RULE_INT
											{
											// InternalDsl.g:725:10: (kw= '-' )?
											int alt19=2;
											int LA19_0 = input.LA(1);
											if ( (LA19_0==32) ) {
												alt19=1;
											}
											switch (alt19) {
												case 1 :
													// InternalDsl.g:726:11: kw= '-'
													{
													kw=(Token)match(input,32,FOLLOW_20); if (state.failed) return current;
													if ( state.backtracking==0 ) {
																								current.merge(kw);
																								newLeafNode(kw, grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_2_0_0_1_1_1_1_0());
																							}
													}
													break;

											}

											this_INT_9=(Token)match(input,RULE_INT,FOLLOW_26); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																					current.merge(this_INT_9);
																				}
											if ( state.backtracking==0 ) {
																					newLeafNode(this_INT_9, grammarAccess.getVariableStringAccess().getINTTerminalRuleCall_2_0_0_1_1_1_1_1());
																				}
											}

											}
											break;

									}

									}
									break;

								default :
									break loop21;
								}
							}

							}
							break;

					}

					kw=(Token)match(input,25,FOLLOW_27); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getVariableStringAccess().getRightParenthesisKeyword_2_0_0_2());
										}
					}

					// InternalDsl.g:749:5: (kw= '.' this_VariableString_12= ruleVariableString )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==36) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// InternalDsl.g:750:6: kw= '.' this_VariableString_12= ruleVariableString
							{
							kw=(Token)match(input,36,FOLLOW_28); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													current.merge(kw);
													newLeafNode(kw, grammarAccess.getVariableStringAccess().getFullStopKeyword_2_0_1_0());
												}
							if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_0_1_1());
												}
							pushFollow(FOLLOW_2);
							this_VariableString_12=ruleVariableString();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
													current.merge(this_VariableString_12);
												}
							if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
							}
							break;

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:768:4: ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? )
					{
					// InternalDsl.g:768:4: ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? )
					// InternalDsl.g:769:5: (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )?
					{
					// InternalDsl.g:769:5: (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' )
					// InternalDsl.g:770:6: kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']'
					{
					kw=(Token)match(input,75,FOLLOW_29); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getVariableStringAccess().getLeftSquareBracketKeyword_2_1_0_0());
										}
					// InternalDsl.g:775:6: (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )?
					int alt25=3;
					switch ( input.LA(1) ) {
						case 32:
							{
							int LA25_1 = input.LA(2);
							if ( (LA25_1==RULE_ID) ) {
								alt25=1;
							}
							else if ( (LA25_1==RULE_INT) ) {
								alt25=2;
							}
							}
							break;
						case RULE_ID:
							{
							alt25=1;
							}
							break;
						case RULE_INT:
							{
							alt25=2;
							}
							break;
					}
					switch (alt25) {
						case 1 :
							// InternalDsl.g:776:7: this_VariableString_14= ruleVariableString
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_1_0_1_0());
													}
							pushFollow(FOLLOW_15);
							this_VariableString_14=ruleVariableString();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														current.merge(this_VariableString_14);
													}
							if ( state.backtracking==0 ) {
														afterParserOrEnumRuleCall();
													}
							}
							break;
						case 2 :
							// InternalDsl.g:787:7: ( (kw= '-' )? this_INT_16= RULE_INT )
							{
							// InternalDsl.g:787:7: ( (kw= '-' )? this_INT_16= RULE_INT )
							// InternalDsl.g:788:8: (kw= '-' )? this_INT_16= RULE_INT
							{
							// InternalDsl.g:788:8: (kw= '-' )?
							int alt24=2;
							int LA24_0 = input.LA(1);
							if ( (LA24_0==32) ) {
								alt24=1;
							}
							switch (alt24) {
								case 1 :
									// InternalDsl.g:789:9: kw= '-'
									{
									kw=(Token)match(input,32,FOLLOW_20); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																		current.merge(kw);
																		newLeafNode(kw, grammarAccess.getVariableStringAccess().getHyphenMinusKeyword_2_1_0_1_1_0());
																	}
									}
									break;

							}

							this_INT_16=(Token)match(input,RULE_INT,FOLLOW_15); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															current.merge(this_INT_16);
														}
							if ( state.backtracking==0 ) {
															newLeafNode(this_INT_16, grammarAccess.getVariableStringAccess().getINTTerminalRuleCall_2_1_0_1_1_1());
														}
							}

							}
							break;

					}

					kw=(Token)match(input,76,FOLLOW_27); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getVariableStringAccess().getRightSquareBracketKeyword_2_1_0_2());
										}
					}

					// InternalDsl.g:810:5: (kw= '.' this_VariableString_19= ruleVariableString )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==36) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// InternalDsl.g:811:6: kw= '.' this_VariableString_19= ruleVariableString
							{
							kw=(Token)match(input,36,FOLLOW_28); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													current.merge(kw);
													newLeafNode(kw, grammarAccess.getVariableStringAccess().getFullStopKeyword_2_1_1_0());
												}
							if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_1_1_1());
												}
							pushFollow(FOLLOW_2);
							this_VariableString_19=ruleVariableString();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
													current.merge(this_VariableString_19);
												}
							if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
							}
							break;

					}

					}

					}
					break;
				case 3 :
					// InternalDsl.g:829:4: (kw= '.' this_VariableString_21= ruleVariableString )
					{
					// InternalDsl.g:829:4: (kw= '.' this_VariableString_21= ruleVariableString )
					// InternalDsl.g:830:5: kw= '.' this_VariableString_21= ruleVariableString
					{
					kw=(Token)match(input,36,FOLLOW_28); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										current.merge(kw);
										newLeafNode(kw, grammarAccess.getVariableStringAccess().getFullStopKeyword_2_2_0());
									}
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getVariableStringAccess().getVariableStringParserRuleCall_2_2_1());
									}
					pushFollow(FOLLOW_2);
					this_VariableString_21=ruleVariableString();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										current.merge(this_VariableString_21);
									}
					if ( state.backtracking==0 ) {
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleVariableString"



	// $ANTLR start "entryRuleOperation"
	// InternalDsl.g:851:1: entryRuleOperation returns [String current=null] :iv_ruleOperation= ruleOperation EOF ;
	public final String entryRuleOperation() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOperation =null;

		try {
			// InternalDsl.g:851:49: (iv_ruleOperation= ruleOperation EOF )
			// InternalDsl.g:852:2: iv_ruleOperation= ruleOperation EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOperationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOperation=ruleOperation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOperation.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOperation"



	// $ANTLR start "ruleOperation"
	// InternalDsl.g:858:1: ruleOperation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' |kw= '-' |kw= '*' |kw= '/' |kw= '%' ) ;
	public final AntlrDatatypeRuleToken ruleOperation() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:864:2: ( (kw= '+' |kw= '-' |kw= '*' |kw= '/' |kw= '%' ) )
			// InternalDsl.g:865:2: (kw= '+' |kw= '-' |kw= '*' |kw= '/' |kw= '%' )
			{
			// InternalDsl.g:865:2: (kw= '+' |kw= '-' |kw= '*' |kw= '/' |kw= '%' )
			int alt28=5;
			switch ( input.LA(1) ) {
			case 28:
				{
				alt28=1;
				}
				break;
			case 32:
				{
				alt28=2;
				}
				break;
			case 26:
				{
				alt28=3;
				}
				break;
			case 38:
				{
				alt28=4;
				}
				break;
			case 17:
				{
				alt28=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// InternalDsl.g:866:3: kw= '+'
					{
					kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOperationAccess().getPlusSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:872:3: kw= '-'
					{
					kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOperationAccess().getHyphenMinusKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalDsl.g:878:3: kw= '*'
					{
					kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOperationAccess().getAsteriskKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalDsl.g:884:3: kw= '/'
					{
					kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOperationAccess().getSolidusKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalDsl.g:890:3: kw= '%'
					{
					kw=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOperationAccess().getPercentSignKeyword_4());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOperation"



	// $ANTLR start "entryRuleAbstractStatement_Impl"
	// InternalDsl.g:899:1: entryRuleAbstractStatement_Impl returns [EObject current=null] :iv_ruleAbstractStatement_Impl= ruleAbstractStatement_Impl EOF ;
	public final EObject entryRuleAbstractStatement_Impl() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleAbstractStatement_Impl =null;

		try {
			// InternalDsl.g:899:63: (iv_ruleAbstractStatement_Impl= ruleAbstractStatement_Impl EOF )
			// InternalDsl.g:900:2: iv_ruleAbstractStatement_Impl= ruleAbstractStatement_Impl EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getAbstractStatement_ImplRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleAbstractStatement_Impl=ruleAbstractStatement_Impl();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleAbstractStatement_Impl; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleAbstractStatement_Impl"



	// $ANTLR start "ruleAbstractStatement_Impl"
	// InternalDsl.g:906:1: ruleAbstractStatement_Impl returns [EObject current=null] : ( () ( (lv_name_1_0= ruleCodeString ) ) ) ;
	public final EObject ruleAbstractStatement_Impl() throws RecognitionException {
		EObject current = null;


		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:912:2: ( ( () ( (lv_name_1_0= ruleCodeString ) ) ) )
			// InternalDsl.g:913:2: ( () ( (lv_name_1_0= ruleCodeString ) ) )
			{
			// InternalDsl.g:913:2: ( () ( (lv_name_1_0= ruleCodeString ) ) )
			// InternalDsl.g:914:3: () ( (lv_name_1_0= ruleCodeString ) )
			{
			// InternalDsl.g:914:3: ()
			// InternalDsl.g:915:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getAbstractStatement_ImplAccess().getAbstractStatementAction_0(),
								current);
						}
			}

			// InternalDsl.g:921:3: ( (lv_name_1_0= ruleCodeString ) )
			// InternalDsl.g:922:4: (lv_name_1_0= ruleCodeString )
			{
			// InternalDsl.g:922:4: (lv_name_1_0= ruleCodeString )
			// InternalDsl.g:923:5: lv_name_1_0= ruleCodeString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getAbstractStatement_ImplAccess().getNameCodeStringParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_name_1_0=ruleCodeString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getAbstractStatement_ImplRule());
								}
								set(
									current,
									"name",
									lv_name_1_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.CodeString");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleAbstractStatement_Impl"



	// $ANTLR start "entryRuleMethodStatement"
	// InternalDsl.g:944:1: entryRuleMethodStatement returns [EObject current=null] :iv_ruleMethodStatement= ruleMethodStatement EOF ;
	public final EObject entryRuleMethodStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleMethodStatement =null;

		try {
			// InternalDsl.g:944:56: (iv_ruleMethodStatement= ruleMethodStatement EOF )
			// InternalDsl.g:945:2: iv_ruleMethodStatement= ruleMethodStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getMethodStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleMethodStatement=ruleMethodStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleMethodStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleMethodStatement"



	// $ANTLR start "ruleMethodStatement"
	// InternalDsl.g:951:1: ruleMethodStatement returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) ) ;
	public final EObject ruleMethodStatement() throws RecognitionException {
		EObject current = null;


		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:957:2: ( ( () ( (lv_name_1_0= ruleEString ) ) ) )
			// InternalDsl.g:958:2: ( () ( (lv_name_1_0= ruleEString ) ) )
			{
			// InternalDsl.g:958:2: ( () ( (lv_name_1_0= ruleEString ) ) )
			// InternalDsl.g:959:3: () ( (lv_name_1_0= ruleEString ) )
			{
			// InternalDsl.g:959:3: ()
			// InternalDsl.g:960:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getMethodStatementAccess().getMethodStatementAction_0(),
								current);
						}
			}

			// InternalDsl.g:966:3: ( (lv_name_1_0= ruleEString ) )
			// InternalDsl.g:967:4: (lv_name_1_0= ruleEString )
			{
			// InternalDsl.g:967:4: (lv_name_1_0= ruleEString )
			// InternalDsl.g:968:5: lv_name_1_0= ruleEString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getMethodStatementAccess().getNameEStringParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_name_1_0=ruleEString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getMethodStatementRule());
								}
								set(
									current,
									"name",
									lv_name_1_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.EString");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleMethodStatement"



	// $ANTLR start "entryRuleReturnStatement"
	// InternalDsl.g:989:1: entryRuleReturnStatement returns [EObject current=null] :iv_ruleReturnStatement= ruleReturnStatement EOF ;
	public final EObject entryRuleReturnStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleReturnStatement =null;

		try {
			// InternalDsl.g:989:56: (iv_ruleReturnStatement= ruleReturnStatement EOF )
			// InternalDsl.g:990:2: iv_ruleReturnStatement= ruleReturnStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getReturnStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleReturnStatement=ruleReturnStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleReturnStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleReturnStatement"



	// $ANTLR start "ruleReturnStatement"
	// InternalDsl.g:996:1: ruleReturnStatement returns [EObject current=null] : ( () otherlv_1= 'Return' ( (lv_name_2_0= ruleCodeString ) ) ) ;
	public final EObject ruleReturnStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		AntlrDatatypeRuleToken lv_name_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1002:2: ( ( () otherlv_1= 'Return' ( (lv_name_2_0= ruleCodeString ) ) ) )
			// InternalDsl.g:1003:2: ( () otherlv_1= 'Return' ( (lv_name_2_0= ruleCodeString ) ) )
			{
			// InternalDsl.g:1003:2: ( () otherlv_1= 'Return' ( (lv_name_2_0= ruleCodeString ) ) )
			// InternalDsl.g:1004:3: () otherlv_1= 'Return' ( (lv_name_2_0= ruleCodeString ) )
			{
			// InternalDsl.g:1004:3: ()
			// InternalDsl.g:1005:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getReturnStatementAccess().getReturnStatementAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,69,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getReturnStatementAccess().getReturnKeyword_1());
					}
			// InternalDsl.g:1015:3: ( (lv_name_2_0= ruleCodeString ) )
			// InternalDsl.g:1016:4: (lv_name_2_0= ruleCodeString )
			{
			// InternalDsl.g:1016:4: (lv_name_2_0= ruleCodeString )
			// InternalDsl.g:1017:5: lv_name_2_0= ruleCodeString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getReturnStatementAccess().getNameCodeStringParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_2);
			lv_name_2_0=ruleCodeString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getReturnStatementRule());
								}
								set(
									current,
									"name",
									lv_name_2_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.CodeString");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleReturnStatement"



	// $ANTLR start "entryRuleStrengthWeakStatement"
	// InternalDsl.g:1038:1: entryRuleStrengthWeakStatement returns [EObject current=null] :iv_ruleStrengthWeakStatement= ruleStrengthWeakStatement EOF ;
	public final EObject entryRuleStrengthWeakStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleStrengthWeakStatement =null;

		try {
			// InternalDsl.g:1038:62: (iv_ruleStrengthWeakStatement= ruleStrengthWeakStatement EOF )
			// InternalDsl.g:1039:2: iv_ruleStrengthWeakStatement= ruleStrengthWeakStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getStrengthWeakStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleStrengthWeakStatement=ruleStrengthWeakStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleStrengthWeakStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleStrengthWeakStatement"



	// $ANTLR start "ruleStrengthWeakStatement"
	// InternalDsl.g:1045:1: ruleStrengthWeakStatement returns [EObject current=null] : ( () otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_weakPreCondition_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_name_6_0= ruleCodeString ) ) otherlv_7= '}' otherlv_8= 'Post:' otherlv_9= '(' ( (lv_strongPostCondition_10_0= ruleCondition ) ) otherlv_11= ')' ) ;
	public final EObject ruleStrengthWeakStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		Token otherlv_8=null;
		Token otherlv_9=null;
		Token otherlv_11=null;
		EObject lv_weakPreCondition_3_0 =null;
		AntlrDatatypeRuleToken lv_name_6_0 =null;
		EObject lv_strongPostCondition_10_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1051:2: ( ( () otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_weakPreCondition_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_name_6_0= ruleCodeString ) ) otherlv_7= '}' otherlv_8= 'Post:' otherlv_9= '(' ( (lv_strongPostCondition_10_0= ruleCondition ) ) otherlv_11= ')' ) )
			// InternalDsl.g:1052:2: ( () otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_weakPreCondition_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_name_6_0= ruleCodeString ) ) otherlv_7= '}' otherlv_8= 'Post:' otherlv_9= '(' ( (lv_strongPostCondition_10_0= ruleCondition ) ) otherlv_11= ')' )
			{
			// InternalDsl.g:1052:2: ( () otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_weakPreCondition_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_name_6_0= ruleCodeString ) ) otherlv_7= '}' otherlv_8= 'Post:' otherlv_9= '(' ( (lv_strongPostCondition_10_0= ruleCondition ) ) otherlv_11= ')' )
			// InternalDsl.g:1053:3: () otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_weakPreCondition_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_name_6_0= ruleCodeString ) ) otherlv_7= '}' otherlv_8= 'Post:' otherlv_9= '(' ( (lv_strongPostCondition_10_0= ruleCondition ) ) otherlv_11= ')'
			{
			// InternalDsl.g:1053:3: ()
			// InternalDsl.g:1054:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getStrengthWeakStatementAccess().getStrengthWeakStatementAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,66,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getStrengthWeakStatementAccess().getPreKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getStrengthWeakStatementAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:1068:3: ( (lv_weakPreCondition_3_0= ruleCondition ) )
			// InternalDsl.g:1069:4: (lv_weakPreCondition_3_0= ruleCondition )
			{
			// InternalDsl.g:1069:4: (lv_weakPreCondition_3_0= ruleCondition )
			// InternalDsl.g:1070:5: lv_weakPreCondition_3_0= ruleCondition
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getStrengthWeakStatementAccess().getWeakPreConditionConditionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_8);
			lv_weakPreCondition_3_0=ruleCondition();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getStrengthWeakStatementRule());
								}
								set(
									current,
									"weakPreCondition",
									lv_weakPreCondition_3_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getStrengthWeakStatementAccess().getRightParenthesisKeyword_4());
					}
			otherlv_5=(Token)match(input,107,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getStrengthWeakStatementAccess().getLeftCurlyBracketKeyword_5());
					}
			// InternalDsl.g:1095:3: ( (lv_name_6_0= ruleCodeString ) )
			// InternalDsl.g:1096:4: (lv_name_6_0= ruleCodeString )
			{
			// InternalDsl.g:1096:4: (lv_name_6_0= ruleCodeString )
			// InternalDsl.g:1097:5: lv_name_6_0= ruleCodeString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getStrengthWeakStatementAccess().getNameCodeStringParserRuleCall_6_0());
							}
			pushFollow(FOLLOW_11);
			lv_name_6_0=ruleCodeString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getStrengthWeakStatementRule());
								}
								set(
									current,
									"name",
									lv_name_6_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.CodeString");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_7=(Token)match(input,111,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_7, grammarAccess.getStrengthWeakStatementAccess().getRightCurlyBracketKeyword_7());
					}
			otherlv_8=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getStrengthWeakStatementAccess().getPostKeyword_8());
					}
			otherlv_9=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_9, grammarAccess.getStrengthWeakStatementAccess().getLeftParenthesisKeyword_9());
					}
			// InternalDsl.g:1126:3: ( (lv_strongPostCondition_10_0= ruleCondition ) )
			// InternalDsl.g:1127:4: (lv_strongPostCondition_10_0= ruleCondition )
			{
			// InternalDsl.g:1127:4: (lv_strongPostCondition_10_0= ruleCondition )
			// InternalDsl.g:1128:5: lv_strongPostCondition_10_0= ruleCondition
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getStrengthWeakStatementAccess().getStrongPostConditionConditionParserRuleCall_10_0());
							}
			pushFollow(FOLLOW_8);
			lv_strongPostCondition_10_0=ruleCondition();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getStrengthWeakStatementRule());
								}
								set(
									current,
									"strongPostCondition",
									lv_strongPostCondition_10_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_11=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_11, grammarAccess.getStrengthWeakStatementAccess().getRightParenthesisKeyword_11());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleStrengthWeakStatement"



	// $ANTLR start "entryRuleCondition"
	// InternalDsl.g:1153:1: entryRuleCondition returns [EObject current=null] :iv_ruleCondition= ruleCondition EOF ;
	public final EObject entryRuleCondition() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleCondition =null;

		try {
			// InternalDsl.g:1153:50: (iv_ruleCondition= ruleCondition EOF )
			// InternalDsl.g:1154:2: iv_ruleCondition= ruleCondition EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getConditionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleCondition=ruleCondition();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleCondition; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleCondition"



	// $ANTLR start "ruleCondition"
	// InternalDsl.g:1160:1: ruleCondition returns [EObject current=null] : ( () ( (lv_condition_1_0= ruleExpression ) ) ) ;
	public final EObject ruleCondition() throws RecognitionException {
		EObject current = null;


		EObject lv_condition_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1166:2: ( ( () ( (lv_condition_1_0= ruleExpression ) ) ) )
			// InternalDsl.g:1167:2: ( () ( (lv_condition_1_0= ruleExpression ) ) )
			{
			// InternalDsl.g:1167:2: ( () ( (lv_condition_1_0= ruleExpression ) ) )
			// InternalDsl.g:1168:3: () ( (lv_condition_1_0= ruleExpression ) )
			{
			// InternalDsl.g:1168:3: ()
			// InternalDsl.g:1169:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getConditionAccess().getConditionAction_0(),
								current);
						}
			}

			// InternalDsl.g:1175:3: ( (lv_condition_1_0= ruleExpression ) )
			// InternalDsl.g:1176:4: (lv_condition_1_0= ruleExpression )
			{
			// InternalDsl.g:1176:4: (lv_condition_1_0= ruleExpression )
			// InternalDsl.g:1177:5: lv_condition_1_0= ruleExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getConditionAccess().getConditionExpressionParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_condition_1_0=ruleExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getConditionRule());
								}
								set(
									current,
									"condition",
									lv_condition_1_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Expression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleCondition"



	// $ANTLR start "entryRuleSkipStatement"
	// InternalDsl.g:1198:1: entryRuleSkipStatement returns [EObject current=null] :iv_ruleSkipStatement= ruleSkipStatement EOF ;
	public final EObject entryRuleSkipStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleSkipStatement =null;

		try {
			// InternalDsl.g:1198:54: (iv_ruleSkipStatement= ruleSkipStatement EOF )
			// InternalDsl.g:1199:2: iv_ruleSkipStatement= ruleSkipStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getSkipStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleSkipStatement=ruleSkipStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleSkipStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleSkipStatement"



	// $ANTLR start "ruleSkipStatement"
	// InternalDsl.g:1205:1: ruleSkipStatement returns [EObject current=null] : ( (lv_name_0_0= ';' ) ) ;
	public final EObject ruleSkipStatement() throws RecognitionException {
		EObject current = null;


		Token lv_name_0_0=null;


			enterRule();

		try {
			// InternalDsl.g:1211:2: ( ( (lv_name_0_0= ';' ) ) )
			// InternalDsl.g:1212:2: ( (lv_name_0_0= ';' ) )
			{
			// InternalDsl.g:1212:2: ( (lv_name_0_0= ';' ) )
			// InternalDsl.g:1213:3: (lv_name_0_0= ';' )
			{
			// InternalDsl.g:1213:3: (lv_name_0_0= ';' )
			// InternalDsl.g:1214:4: lv_name_0_0= ';'
			{
			lv_name_0_0=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
							newLeafNode(lv_name_0_0, grammarAccess.getSkipStatementAccess().getNameSemicolonKeyword_0());
						}
			if ( state.backtracking==0 ) {
							if (current==null) {
								current = createModelElement(grammarAccess.getSkipStatementRule());
							}
							setWithLastConsumed(current, "name", lv_name_0_0, ";");
						}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleSkipStatement"



	// $ANTLR start "entryRuleCompositionStatement"
	// InternalDsl.g:1229:1: entryRuleCompositionStatement returns [EObject current=null] :iv_ruleCompositionStatement= ruleCompositionStatement EOF ;
	public final EObject entryRuleCompositionStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleCompositionStatement =null;

		try {
			// InternalDsl.g:1229:61: (iv_ruleCompositionStatement= ruleCompositionStatement EOF )
			// InternalDsl.g:1230:2: iv_ruleCompositionStatement= ruleCompositionStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getCompositionStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleCompositionStatement=ruleCompositionStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleCompositionStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleCompositionStatement"



	// $ANTLR start "ruleCompositionStatement"
	// InternalDsl.g:1236:1: ruleCompositionStatement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_firstStatement_2_0= ruleAbstractStatement ) ) otherlv_3= '}' otherlv_4= 'Intm:' otherlv_5= '(' ( (lv_intermediateCondition_6_0= ruleCondition ) ) otherlv_7= ')' otherlv_8= '{' ( (lv_secondStatement_9_0= ruleAbstractStatement ) ) otherlv_10= '}' ) ;
	public final EObject ruleCompositionStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_4=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		Token otherlv_8=null;
		Token otherlv_10=null;
		EObject lv_firstStatement_2_0 =null;
		EObject lv_intermediateCondition_6_0 =null;
		EObject lv_secondStatement_9_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1242:2: ( ( () otherlv_1= '{' ( (lv_firstStatement_2_0= ruleAbstractStatement ) ) otherlv_3= '}' otherlv_4= 'Intm:' otherlv_5= '(' ( (lv_intermediateCondition_6_0= ruleCondition ) ) otherlv_7= ')' otherlv_8= '{' ( (lv_secondStatement_9_0= ruleAbstractStatement ) ) otherlv_10= '}' ) )
			// InternalDsl.g:1243:2: ( () otherlv_1= '{' ( (lv_firstStatement_2_0= ruleAbstractStatement ) ) otherlv_3= '}' otherlv_4= 'Intm:' otherlv_5= '(' ( (lv_intermediateCondition_6_0= ruleCondition ) ) otherlv_7= ')' otherlv_8= '{' ( (lv_secondStatement_9_0= ruleAbstractStatement ) ) otherlv_10= '}' )
			{
			// InternalDsl.g:1243:2: ( () otherlv_1= '{' ( (lv_firstStatement_2_0= ruleAbstractStatement ) ) otherlv_3= '}' otherlv_4= 'Intm:' otherlv_5= '(' ( (lv_intermediateCondition_6_0= ruleCondition ) ) otherlv_7= ')' otherlv_8= '{' ( (lv_secondStatement_9_0= ruleAbstractStatement ) ) otherlv_10= '}' )
			// InternalDsl.g:1244:3: () otherlv_1= '{' ( (lv_firstStatement_2_0= ruleAbstractStatement ) ) otherlv_3= '}' otherlv_4= 'Intm:' otherlv_5= '(' ( (lv_intermediateCondition_6_0= ruleCondition ) ) otherlv_7= ')' otherlv_8= '{' ( (lv_secondStatement_9_0= ruleAbstractStatement ) ) otherlv_10= '}'
			{
			// InternalDsl.g:1244:3: ()
			// InternalDsl.g:1245:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getCompositionStatementAccess().getCompositionStatementAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,107,FOLLOW_10); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getCompositionStatementAccess().getLeftCurlyBracketKeyword_1());
					}
			// InternalDsl.g:1255:3: ( (lv_firstStatement_2_0= ruleAbstractStatement ) )
			// InternalDsl.g:1256:4: (lv_firstStatement_2_0= ruleAbstractStatement )
			{
			// InternalDsl.g:1256:4: (lv_firstStatement_2_0= ruleAbstractStatement )
			// InternalDsl.g:1257:5: lv_firstStatement_2_0= ruleAbstractStatement
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getCompositionStatementAccess().getFirstStatementAbstractStatementParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_11);
			lv_firstStatement_2_0=ruleAbstractStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getCompositionStatementRule());
								}
								set(
									current,
									"firstStatement",
									lv_firstStatement_2_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.AbstractStatement");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_3=(Token)match(input,111,FOLLOW_30); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getCompositionStatementAccess().getRightCurlyBracketKeyword_3());
					}
			otherlv_4=(Token)match(input,60,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getCompositionStatementAccess().getIntmKeyword_4());
					}
			otherlv_5=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getCompositionStatementAccess().getLeftParenthesisKeyword_5());
					}
			// InternalDsl.g:1286:3: ( (lv_intermediateCondition_6_0= ruleCondition ) )
			// InternalDsl.g:1287:4: (lv_intermediateCondition_6_0= ruleCondition )
			{
			// InternalDsl.g:1287:4: (lv_intermediateCondition_6_0= ruleCondition )
			// InternalDsl.g:1288:5: lv_intermediateCondition_6_0= ruleCondition
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getCompositionStatementAccess().getIntermediateConditionConditionParserRuleCall_6_0());
							}
			pushFollow(FOLLOW_8);
			lv_intermediateCondition_6_0=ruleCondition();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getCompositionStatementRule());
								}
								set(
									current,
									"intermediateCondition",
									lv_intermediateCondition_6_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_7=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_7, grammarAccess.getCompositionStatementAccess().getRightParenthesisKeyword_7());
					}
			otherlv_8=(Token)match(input,107,FOLLOW_10); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getCompositionStatementAccess().getLeftCurlyBracketKeyword_8());
					}
			// InternalDsl.g:1313:3: ( (lv_secondStatement_9_0= ruleAbstractStatement ) )
			// InternalDsl.g:1314:4: (lv_secondStatement_9_0= ruleAbstractStatement )
			{
			// InternalDsl.g:1314:4: (lv_secondStatement_9_0= ruleAbstractStatement )
			// InternalDsl.g:1315:5: lv_secondStatement_9_0= ruleAbstractStatement
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getCompositionStatementAccess().getSecondStatementAbstractStatementParserRuleCall_9_0());
							}
			pushFollow(FOLLOW_11);
			lv_secondStatement_9_0=ruleAbstractStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getCompositionStatementRule());
								}
								set(
									current,
									"secondStatement",
									lv_secondStatement_9_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.AbstractStatement");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_10=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_10, grammarAccess.getCompositionStatementAccess().getRightCurlyBracketKeyword_10());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleCompositionStatement"



	// $ANTLR start "entryRuleJavaStatement"
	// InternalDsl.g:1340:1: entryRuleJavaStatement returns [EObject current=null] :iv_ruleJavaStatement= ruleJavaStatement EOF ;
	public final EObject entryRuleJavaStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJavaStatement =null;

		try {
			// InternalDsl.g:1340:54: (iv_ruleJavaStatement= ruleJavaStatement EOF )
			// InternalDsl.g:1341:2: iv_ruleJavaStatement= ruleJavaStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJavaStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJavaStatement=ruleJavaStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJavaStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJavaStatement"



	// $ANTLR start "ruleJavaStatement"
	// InternalDsl.g:1347:1: ruleJavaStatement returns [EObject current=null] : ( () ( (lv_statement_1_0= ruleXJStatementOrBlock ) )+ ) ;
	public final EObject ruleJavaStatement() throws RecognitionException {
		EObject current = null;


		EObject lv_statement_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1353:2: ( ( () ( (lv_statement_1_0= ruleXJStatementOrBlock ) )+ ) )
			// InternalDsl.g:1354:2: ( () ( (lv_statement_1_0= ruleXJStatementOrBlock ) )+ )
			{
			// InternalDsl.g:1354:2: ( () ( (lv_statement_1_0= ruleXJStatementOrBlock ) )+ )
			// InternalDsl.g:1355:3: () ( (lv_statement_1_0= ruleXJStatementOrBlock ) )+
			{
			// InternalDsl.g:1355:3: ()
			// InternalDsl.g:1356:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getJavaStatementAccess().getJavaStatementAction_0(),
								current);
						}
			}

			// InternalDsl.g:1362:3: ( (lv_statement_1_0= ruleXJStatementOrBlock ) )+
			int cnt29=0;
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( ((LA29_0 >= RULE_CHARACTER && LA29_0 <= RULE_INT)||LA29_0==RULE_STRING||LA29_0==14||LA29_0==22||(LA29_0 >= 28 && LA29_0 <= 29)||(LA29_0 >= 32 && LA29_0 <= 33)||LA29_0==41||LA29_0==79||LA29_0==83||LA29_0==85||(LA29_0 >= 87 && LA29_0 <= 90)||(LA29_0 >= 92 && LA29_0 <= 94)||(LA29_0 >= 96 && LA29_0 <= 107)||LA29_0==112) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// InternalDsl.g:1363:4: (lv_statement_1_0= ruleXJStatementOrBlock )
					{
					// InternalDsl.g:1363:4: (lv_statement_1_0= ruleXJStatementOrBlock )
					// InternalDsl.g:1364:5: lv_statement_1_0= ruleXJStatementOrBlock
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getJavaStatementAccess().getStatementXJStatementOrBlockParserRuleCall_1_0());
									}
					pushFollow(FOLLOW_31);
					lv_statement_1_0=ruleXJStatementOrBlock();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getJavaStatementRule());
										}
										add(
											current,
											"statement",
											lv_statement_1_0,
											"jbase.Jbase.XJStatementOrBlock");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					if ( cnt29 >= 1 ) break loop29;
					if (state.backtracking>0) {state.failed=true; return current;}
					EarlyExitException eee = new EarlyExitException(29, input);
					throw eee;
				}
				cnt29++;
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJavaStatement"



	// $ANTLR start "entryRuleJMLAnnotation"
	// InternalDsl.g:1385:1: entryRuleJMLAnnotation returns [EObject current=null] :iv_ruleJMLAnnotation= ruleJMLAnnotation EOF ;
	public final EObject entryRuleJMLAnnotation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJMLAnnotation =null;

		try {
			// InternalDsl.g:1385:54: (iv_ruleJMLAnnotation= ruleJMLAnnotation EOF )
			// InternalDsl.g:1386:2: iv_ruleJMLAnnotation= ruleJMLAnnotation EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJMLAnnotationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJMLAnnotation=ruleJMLAnnotation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJMLAnnotation; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJMLAnnotation"



	// $ANTLR start "ruleJMLAnnotation"
	// InternalDsl.g:1392:1: ruleJMLAnnotation returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) ) )+ {...}?) ) ) ;
	public final EObject ruleJMLAnnotation() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_5=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		EObject lv_requires_3_0 =null;
		EObject lv_ensures_7_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1398:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) ) )+ {...}?) ) ) )
			// InternalDsl.g:1399:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) ) )+ {...}?) ) )
			{
			// InternalDsl.g:1399:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) ) )+ {...}?) ) )
			// InternalDsl.g:1400:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) ) )+ {...}?) )
			{
			// InternalDsl.g:1400:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) ) )+ {...}?) )
			// InternalDsl.g:1401:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) ) )+ {...}?)
			{
			getUnorderedGroupHelper().enter(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup());
			// InternalDsl.g:1404:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) ) )+ {...}?)
			// InternalDsl.g:1405:5: ( ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) ) )+ {...}?
			{
			// InternalDsl.g:1405:5: ( ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) ) )+
			int cnt30=0;
			loop30:
			while (true) {
				int alt30=3;
				int LA30_0 = input.LA(1);
				if ( LA30_0 == 66 && getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 0) ) {
					alt30=1;
				}
				else if ( LA30_0 == 65 && getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 1) ) {
					alt30=2;
				}

				switch (alt30) {
				case 1 :
					// InternalDsl.g:1406:3: ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) )
					{
					// InternalDsl.g:1406:3: ({...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) ) )
					// InternalDsl.g:1407:4: {...}? => ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 0) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleJMLAnnotation", "getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 0)");
					}
					// InternalDsl.g:1407:107: ( ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) ) )
					// InternalDsl.g:1408:5: ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) )
					{
					getUnorderedGroupHelper().select(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 0);
					// InternalDsl.g:1411:8: ({...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' ) )
					// InternalDsl.g:1411:9: {...}? => (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' )
					{
					if ( !((true)) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleJMLAnnotation", "true");
					}
					// InternalDsl.g:1411:18: (otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')' )
					// InternalDsl.g:1411:19: otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_requires_3_0= ruleCondition ) ) otherlv_4= ')'
					{
					otherlv_1=(Token)match(input,66,FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {
													newLeafNode(otherlv_1, grammarAccess.getJMLAnnotationAccess().getPreKeyword_0_0());
												}
					otherlv_2=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
													newLeafNode(otherlv_2, grammarAccess.getJMLAnnotationAccess().getLeftParenthesisKeyword_0_1());
												}
					// InternalDsl.g:1419:8: ( (lv_requires_3_0= ruleCondition ) )
					// InternalDsl.g:1420:9: (lv_requires_3_0= ruleCondition )
					{
					// InternalDsl.g:1420:9: (lv_requires_3_0= ruleCondition )
					// InternalDsl.g:1421:10: lv_requires_3_0= ruleCondition
					{
					if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getJMLAnnotationAccess().getRequiresConditionParserRuleCall_0_2_0());
														}
					pushFollow(FOLLOW_8);
					lv_requires_3_0=ruleCondition();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getJMLAnnotationRule());
															}
															set(
																current,
																"requires",
																lv_requires_3_0,
																"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
															afterParserOrEnumRuleCall();
														}
					}

					}

					otherlv_4=(Token)match(input,25,FOLLOW_32); if (state.failed) return current;
					if ( state.backtracking==0 ) {
													newLeafNode(otherlv_4, grammarAccess.getJMLAnnotationAccess().getRightParenthesisKeyword_0_3());
												}
					}

					}

					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup());
					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:1448:3: ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) )
					{
					// InternalDsl.g:1448:3: ({...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) ) )
					// InternalDsl.g:1449:4: {...}? => ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 1) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleJMLAnnotation", "getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 1)");
					}
					// InternalDsl.g:1449:107: ( ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) ) )
					// InternalDsl.g:1450:5: ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) )
					{
					getUnorderedGroupHelper().select(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 1);
					// InternalDsl.g:1453:8: ({...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' ) )
					// InternalDsl.g:1453:9: {...}? => (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' )
					{
					if ( !((true)) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleJMLAnnotation", "true");
					}
					// InternalDsl.g:1453:18: (otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')' )
					// InternalDsl.g:1453:19: otherlv_5= 'Post:' otherlv_6= '(' ( (lv_ensures_7_0= ruleCondition ) ) otherlv_8= ')'
					{
					otherlv_5=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {
													newLeafNode(otherlv_5, grammarAccess.getJMLAnnotationAccess().getPostKeyword_1_0());
												}
					otherlv_6=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
													newLeafNode(otherlv_6, grammarAccess.getJMLAnnotationAccess().getLeftParenthesisKeyword_1_1());
												}
					// InternalDsl.g:1461:8: ( (lv_ensures_7_0= ruleCondition ) )
					// InternalDsl.g:1462:9: (lv_ensures_7_0= ruleCondition )
					{
					// InternalDsl.g:1462:9: (lv_ensures_7_0= ruleCondition )
					// InternalDsl.g:1463:10: lv_ensures_7_0= ruleCondition
					{
					if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getJMLAnnotationAccess().getEnsuresConditionParserRuleCall_1_2_0());
														}
					pushFollow(FOLLOW_8);
					lv_ensures_7_0=ruleCondition();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getJMLAnnotationRule());
															}
															set(
																current,
																"ensures",
																lv_ensures_7_0,
																"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
															afterParserOrEnumRuleCall();
														}
					}

					}

					otherlv_8=(Token)match(input,25,FOLLOW_32); if (state.failed) return current;
					if ( state.backtracking==0 ) {
													newLeafNode(otherlv_8, grammarAccess.getJMLAnnotationAccess().getRightParenthesisKeyword_1_3());
												}
					}

					}

					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup());
					}

					}

					}
					break;

				default :
					if ( cnt30 >= 1 ) break loop30;
					if (state.backtracking>0) {state.failed=true; return current;}
					EarlyExitException eee = new EarlyExitException(30, input);
					throw eee;
				}
				cnt30++;
			}

			if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup()) ) {
				if (state.backtracking>0) {state.failed=true; return current;}
				throw new FailedPredicateException(input, "ruleJMLAnnotation", "getUnorderedGroupHelper().canLeave(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup())");
			}
			}

			}

			getUnorderedGroupHelper().leave(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup());
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJMLAnnotation"



	// $ANTLR start "entryRuleInlineBlockStatement"
	// InternalDsl.g:1501:1: entryRuleInlineBlockStatement returns [EObject current=null] :iv_ruleInlineBlockStatement= ruleInlineBlockStatement EOF ;
	public final EObject entryRuleInlineBlockStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleInlineBlockStatement =null;

		try {
			// InternalDsl.g:1501:61: (iv_ruleInlineBlockStatement= ruleInlineBlockStatement EOF )
			// InternalDsl.g:1502:2: iv_ruleInlineBlockStatement= ruleInlineBlockStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getInlineBlockStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleInlineBlockStatement=ruleInlineBlockStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleInlineBlockStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleInlineBlockStatement"



	// $ANTLR start "ruleInlineBlockStatement"
	// InternalDsl.g:1508:1: ruleInlineBlockStatement returns [EObject current=null] : ( ( () ( (lv_block_1_0= ruleBlockStatement ) ) ) | ( () otherlv_3= 'Block' ( (otherlv_4= RULE_ID ) ) ) ) ;
	public final EObject ruleInlineBlockStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_3=null;
		Token otherlv_4=null;
		EObject lv_block_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1514:2: ( ( ( () ( (lv_block_1_0= ruleBlockStatement ) ) ) | ( () otherlv_3= 'Block' ( (otherlv_4= RULE_ID ) ) ) ) )
			// InternalDsl.g:1515:2: ( ( () ( (lv_block_1_0= ruleBlockStatement ) ) ) | ( () otherlv_3= 'Block' ( (otherlv_4= RULE_ID ) ) ) )
			{
			// InternalDsl.g:1515:2: ( ( () ( (lv_block_1_0= ruleBlockStatement ) ) ) | ( () otherlv_3= 'Block' ( (otherlv_4= RULE_ID ) ) ) )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==51) ) {
				int LA31_1 = input.LA(2);
				if ( (LA31_1==RULE_STRING) ) {
					alt31=1;
				}
				else if ( (LA31_1==RULE_ID) ) {
					int LA31_3 = input.LA(3);
					if ( (LA31_3==40) ) {
						alt31=1;
					}
					else if ( (LA31_3==EOF||LA31_3==111) ) {
						alt31=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 31, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 31, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// InternalDsl.g:1516:3: ( () ( (lv_block_1_0= ruleBlockStatement ) ) )
					{
					// InternalDsl.g:1516:3: ( () ( (lv_block_1_0= ruleBlockStatement ) ) )
					// InternalDsl.g:1517:4: () ( (lv_block_1_0= ruleBlockStatement ) )
					{
					// InternalDsl.g:1517:4: ()
					// InternalDsl.g:1518:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getInlineBlockStatementAccess().getInlineBlockStatementAction_0_0(),
											current);
									}
					}

					// InternalDsl.g:1524:4: ( (lv_block_1_0= ruleBlockStatement ) )
					// InternalDsl.g:1525:5: (lv_block_1_0= ruleBlockStatement )
					{
					// InternalDsl.g:1525:5: (lv_block_1_0= ruleBlockStatement )
					// InternalDsl.g:1526:6: lv_block_1_0= ruleBlockStatement
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getInlineBlockStatementAccess().getBlockBlockStatementParserRuleCall_0_1_0());
										}
					pushFollow(FOLLOW_2);
					lv_block_1_0=ruleBlockStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getInlineBlockStatementRule());
											}
											set(
												current,
												"block",
												lv_block_1_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.BlockStatement");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:1545:3: ( () otherlv_3= 'Block' ( (otherlv_4= RULE_ID ) ) )
					{
					// InternalDsl.g:1545:3: ( () otherlv_3= 'Block' ( (otherlv_4= RULE_ID ) ) )
					// InternalDsl.g:1546:4: () otherlv_3= 'Block' ( (otherlv_4= RULE_ID ) )
					{
					// InternalDsl.g:1546:4: ()
					// InternalDsl.g:1547:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getInlineBlockStatementAccess().getInlineBlockStatementAction_1_0(),
											current);
									}
					}

					otherlv_3=(Token)match(input,51,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_3, grammarAccess.getInlineBlockStatementAccess().getBlockKeyword_1_1());
								}
					// InternalDsl.g:1557:4: ( (otherlv_4= RULE_ID ) )
					// InternalDsl.g:1558:5: (otherlv_4= RULE_ID )
					{
					// InternalDsl.g:1558:5: (otherlv_4= RULE_ID )
					// InternalDsl.g:1559:6: otherlv_4= RULE_ID
					{
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getInlineBlockStatementRule());
											}
										}
					otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_4, grammarAccess.getInlineBlockStatementAccess().getReferencesBlockStatementCrossReference_1_2_0());
										}
					}

					}

					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleInlineBlockStatement"



	// $ANTLR start "entryRuleBlockStatement"
	// InternalDsl.g:1575:1: entryRuleBlockStatement returns [EObject current=null] :iv_ruleBlockStatement= ruleBlockStatement EOF ;
	public final EObject entryRuleBlockStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleBlockStatement =null;

		try {
			// InternalDsl.g:1575:55: (iv_ruleBlockStatement= ruleBlockStatement EOF )
			// InternalDsl.g:1576:2: iv_ruleBlockStatement= ruleBlockStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getBlockStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleBlockStatement=ruleBlockStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleBlockStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleBlockStatement"



	// $ANTLR start "ruleBlockStatement"
	// InternalDsl.g:1582:1: ruleBlockStatement returns [EObject current=null] : ( () otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_jmlAnnotation_4_0= ruleJMLAnnotation ) )? otherlv_5= '{' ( (lv_javaStatement_6_0= ruleJavaStatement ) ) otherlv_7= '}' ) ;
	public final EObject ruleBlockStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		AntlrDatatypeRuleToken lv_name_2_0 =null;
		EObject lv_jmlAnnotation_4_0 =null;
		EObject lv_javaStatement_6_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1588:2: ( ( () otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_jmlAnnotation_4_0= ruleJMLAnnotation ) )? otherlv_5= '{' ( (lv_javaStatement_6_0= ruleJavaStatement ) ) otherlv_7= '}' ) )
			// InternalDsl.g:1589:2: ( () otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_jmlAnnotation_4_0= ruleJMLAnnotation ) )? otherlv_5= '{' ( (lv_javaStatement_6_0= ruleJavaStatement ) ) otherlv_7= '}' )
			{
			// InternalDsl.g:1589:2: ( () otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_jmlAnnotation_4_0= ruleJMLAnnotation ) )? otherlv_5= '{' ( (lv_javaStatement_6_0= ruleJavaStatement ) ) otherlv_7= '}' )
			// InternalDsl.g:1590:3: () otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_jmlAnnotation_4_0= ruleJMLAnnotation ) )? otherlv_5= '{' ( (lv_javaStatement_6_0= ruleJavaStatement ) ) otherlv_7= '}'
			{
			// InternalDsl.g:1590:3: ()
			// InternalDsl.g:1591:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getBlockStatementAccess().getBlockStatementAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,51,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getBlockStatementAccess().getBlockKeyword_1());
					}
			// InternalDsl.g:1601:3: ( (lv_name_2_0= ruleEString ) )
			// InternalDsl.g:1602:4: (lv_name_2_0= ruleEString )
			{
			// InternalDsl.g:1602:4: (lv_name_2_0= ruleEString )
			// InternalDsl.g:1603:5: lv_name_2_0= ruleEString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getBlockStatementAccess().getNameEStringParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_33);
			lv_name_2_0=ruleEString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getBlockStatementRule());
								}
								set(
									current,
									"name",
									lv_name_2_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.EString");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_3=(Token)match(input,40,FOLLOW_34); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getBlockStatementAccess().getColonKeyword_3());
					}
			// InternalDsl.g:1624:3: ( (lv_jmlAnnotation_4_0= ruleJMLAnnotation ) )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( ((LA32_0 >= 65 && LA32_0 <= 66)) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// InternalDsl.g:1625:4: (lv_jmlAnnotation_4_0= ruleJMLAnnotation )
					{
					// InternalDsl.g:1625:4: (lv_jmlAnnotation_4_0= ruleJMLAnnotation )
					// InternalDsl.g:1626:5: lv_jmlAnnotation_4_0= ruleJMLAnnotation
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getBlockStatementAccess().getJmlAnnotationJMLAnnotationParserRuleCall_4_0());
									}
					pushFollow(FOLLOW_9);
					lv_jmlAnnotation_4_0=ruleJMLAnnotation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getBlockStatementRule());
										}
										set(
											current,
											"jmlAnnotation",
											lv_jmlAnnotation_4_0,
											"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.JMLAnnotation");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			otherlv_5=(Token)match(input,107,FOLLOW_35); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getBlockStatementAccess().getLeftCurlyBracketKeyword_5());
					}
			// InternalDsl.g:1647:3: ( (lv_javaStatement_6_0= ruleJavaStatement ) )
			// InternalDsl.g:1648:4: (lv_javaStatement_6_0= ruleJavaStatement )
			{
			// InternalDsl.g:1648:4: (lv_javaStatement_6_0= ruleJavaStatement )
			// InternalDsl.g:1649:5: lv_javaStatement_6_0= ruleJavaStatement
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getBlockStatementAccess().getJavaStatementJavaStatementParserRuleCall_6_0());
							}
			pushFollow(FOLLOW_11);
			lv_javaStatement_6_0=ruleJavaStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getBlockStatementRule());
								}
								set(
									current,
									"javaStatement",
									lv_javaStatement_6_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.JavaStatement");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_7=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_7, grammarAccess.getBlockStatementAccess().getRightCurlyBracketKeyword_7());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleBlockStatement"



	// $ANTLR start "entryRuleSelectionStatement"
	// InternalDsl.g:1674:1: entryRuleSelectionStatement returns [EObject current=null] :iv_ruleSelectionStatement= ruleSelectionStatement EOF ;
	public final EObject entryRuleSelectionStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleSelectionStatement =null;

		try {
			// InternalDsl.g:1674:59: (iv_ruleSelectionStatement= ruleSelectionStatement EOF )
			// InternalDsl.g:1675:2: iv_ruleSelectionStatement= ruleSelectionStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getSelectionStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleSelectionStatement=ruleSelectionStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleSelectionStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleSelectionStatement"



	// $ANTLR start "ruleSelectionStatement"
	// InternalDsl.g:1681:1: ruleSelectionStatement returns [EObject current=null] : ( () otherlv_1= 'If' otherlv_2= '(' ( (lv_guards_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Then' otherlv_6= '{' ( (lv_commands_7_0= ruleAbstractStatement ) ) otherlv_8= '}' (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )* otherlv_17= 'Fi' ) ;
	public final EObject ruleSelectionStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_5=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token otherlv_9=null;
		Token otherlv_10=null;
		Token otherlv_12=null;
		Token otherlv_13=null;
		Token otherlv_14=null;
		Token otherlv_16=null;
		Token otherlv_17=null;
		EObject lv_guards_3_0 =null;
		EObject lv_commands_7_0 =null;
		EObject lv_guards_11_0 =null;
		EObject lv_commands_15_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1687:2: ( ( () otherlv_1= 'If' otherlv_2= '(' ( (lv_guards_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Then' otherlv_6= '{' ( (lv_commands_7_0= ruleAbstractStatement ) ) otherlv_8= '}' (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )* otherlv_17= 'Fi' ) )
			// InternalDsl.g:1688:2: ( () otherlv_1= 'If' otherlv_2= '(' ( (lv_guards_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Then' otherlv_6= '{' ( (lv_commands_7_0= ruleAbstractStatement ) ) otherlv_8= '}' (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )* otherlv_17= 'Fi' )
			{
			// InternalDsl.g:1688:2: ( () otherlv_1= 'If' otherlv_2= '(' ( (lv_guards_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Then' otherlv_6= '{' ( (lv_commands_7_0= ruleAbstractStatement ) ) otherlv_8= '}' (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )* otherlv_17= 'Fi' )
			// InternalDsl.g:1689:3: () otherlv_1= 'If' otherlv_2= '(' ( (lv_guards_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Then' otherlv_6= '{' ( (lv_commands_7_0= ruleAbstractStatement ) ) otherlv_8= '}' (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )* otherlv_17= 'Fi'
			{
			// InternalDsl.g:1689:3: ()
			// InternalDsl.g:1690:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getSelectionStatementAccess().getSelectionStatementAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,59,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getSelectionStatementAccess().getIfKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getSelectionStatementAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:1704:3: ( (lv_guards_3_0= ruleCondition ) )
			// InternalDsl.g:1705:4: (lv_guards_3_0= ruleCondition )
			{
			// InternalDsl.g:1705:4: (lv_guards_3_0= ruleCondition )
			// InternalDsl.g:1706:5: lv_guards_3_0= ruleCondition
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getSelectionStatementAccess().getGuardsConditionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_8);
			lv_guards_3_0=ruleCondition();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getSelectionStatementRule());
								}
								add(
									current,
									"guards",
									lv_guards_3_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,25,FOLLOW_36); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getSelectionStatementAccess().getRightParenthesisKeyword_4());
					}
			otherlv_5=(Token)match(input,70,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getSelectionStatementAccess().getThenKeyword_5());
					}
			otherlv_6=(Token)match(input,107,FOLLOW_10); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getSelectionStatementAccess().getLeftCurlyBracketKeyword_6());
					}
			// InternalDsl.g:1735:3: ( (lv_commands_7_0= ruleAbstractStatement ) )
			// InternalDsl.g:1736:4: (lv_commands_7_0= ruleAbstractStatement )
			{
			// InternalDsl.g:1736:4: (lv_commands_7_0= ruleAbstractStatement )
			// InternalDsl.g:1737:5: lv_commands_7_0= ruleAbstractStatement
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getSelectionStatementAccess().getCommandsAbstractStatementParserRuleCall_7_0());
							}
			pushFollow(FOLLOW_11);
			lv_commands_7_0=ruleAbstractStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getSelectionStatementRule());
								}
								add(
									current,
									"commands",
									lv_commands_7_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.AbstractStatement");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_8=(Token)match(input,111,FOLLOW_37); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getSelectionStatementAccess().getRightCurlyBracketKeyword_8());
					}
			// InternalDsl.g:1758:3: (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==54) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// InternalDsl.g:1759:4: otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}'
					{
					otherlv_9=(Token)match(input,54,FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_9, grammarAccess.getSelectionStatementAccess().getElseifKeyword_9_0());
								}
					otherlv_10=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_10, grammarAccess.getSelectionStatementAccess().getLeftParenthesisKeyword_9_1());
								}
					// InternalDsl.g:1767:4: ( (lv_guards_11_0= ruleCondition ) )
					// InternalDsl.g:1768:5: (lv_guards_11_0= ruleCondition )
					{
					// InternalDsl.g:1768:5: (lv_guards_11_0= ruleCondition )
					// InternalDsl.g:1769:6: lv_guards_11_0= ruleCondition
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getSelectionStatementAccess().getGuardsConditionParserRuleCall_9_2_0());
										}
					pushFollow(FOLLOW_8);
					lv_guards_11_0=ruleCondition();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getSelectionStatementRule());
											}
											add(
												current,
												"guards",
												lv_guards_11_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
											afterParserOrEnumRuleCall();
										}
					}

					}

					otherlv_12=(Token)match(input,25,FOLLOW_36); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_12, grammarAccess.getSelectionStatementAccess().getRightParenthesisKeyword_9_3());
								}
					otherlv_13=(Token)match(input,70,FOLLOW_9); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_13, grammarAccess.getSelectionStatementAccess().getThenKeyword_9_4());
								}
					otherlv_14=(Token)match(input,107,FOLLOW_10); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_14, grammarAccess.getSelectionStatementAccess().getLeftCurlyBracketKeyword_9_5());
								}
					// InternalDsl.g:1798:4: ( (lv_commands_15_0= ruleAbstractStatement ) )
					// InternalDsl.g:1799:5: (lv_commands_15_0= ruleAbstractStatement )
					{
					// InternalDsl.g:1799:5: (lv_commands_15_0= ruleAbstractStatement )
					// InternalDsl.g:1800:6: lv_commands_15_0= ruleAbstractStatement
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getSelectionStatementAccess().getCommandsAbstractStatementParserRuleCall_9_6_0());
										}
					pushFollow(FOLLOW_11);
					lv_commands_15_0=ruleAbstractStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getSelectionStatementRule());
											}
											add(
												current,
												"commands",
												lv_commands_15_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.AbstractStatement");
											afterParserOrEnumRuleCall();
										}
					}

					}

					otherlv_16=(Token)match(input,111,FOLLOW_37); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_16, grammarAccess.getSelectionStatementAccess().getRightCurlyBracketKeyword_9_7());
								}
					}
					break;

				default :
					break loop33;
				}
			}

			otherlv_17=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_17, grammarAccess.getSelectionStatementAccess().getFiKeyword_10());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleSelectionStatement"



	// $ANTLR start "entryRuleSmallRepetitionStatement"
	// InternalDsl.g:1830:1: entryRuleSmallRepetitionStatement returns [EObject current=null] :iv_ruleSmallRepetitionStatement= ruleSmallRepetitionStatement EOF ;
	public final EObject entryRuleSmallRepetitionStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleSmallRepetitionStatement =null;

		try {
			// InternalDsl.g:1830:65: (iv_ruleSmallRepetitionStatement= ruleSmallRepetitionStatement EOF )
			// InternalDsl.g:1831:2: iv_ruleSmallRepetitionStatement= ruleSmallRepetitionStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getSmallRepetitionStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleSmallRepetitionStatement=ruleSmallRepetitionStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleSmallRepetitionStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleSmallRepetitionStatement"



	// $ANTLR start "ruleSmallRepetitionStatement"
	// InternalDsl.g:1837:1: ruleSmallRepetitionStatement returns [EObject current=null] : ( () otherlv_1= 'While' otherlv_2= '(' ( (lv_guard_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Do' otherlv_6= 'Inv:' otherlv_7= '(' ( (lv_invariant_8_0= ruleCondition ) ) otherlv_9= ')' otherlv_10= 'Var:' otherlv_11= '(' ( (lv_variant_12_0= ruleVariant ) ) otherlv_13= ')' otherlv_14= '{' ( (lv_loopStatement_15_0= ruleAbstractStatement ) ) otherlv_16= '}' otherlv_17= 'Od' ) ;
	public final EObject ruleSmallRepetitionStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_5=null;
		Token otherlv_6=null;
		Token otherlv_7=null;
		Token otherlv_9=null;
		Token otherlv_10=null;
		Token otherlv_11=null;
		Token otherlv_13=null;
		Token otherlv_14=null;
		Token otherlv_16=null;
		Token otherlv_17=null;
		EObject lv_guard_3_0 =null;
		EObject lv_invariant_8_0 =null;
		EObject lv_variant_12_0 =null;
		EObject lv_loopStatement_15_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1843:2: ( ( () otherlv_1= 'While' otherlv_2= '(' ( (lv_guard_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Do' otherlv_6= 'Inv:' otherlv_7= '(' ( (lv_invariant_8_0= ruleCondition ) ) otherlv_9= ')' otherlv_10= 'Var:' otherlv_11= '(' ( (lv_variant_12_0= ruleVariant ) ) otherlv_13= ')' otherlv_14= '{' ( (lv_loopStatement_15_0= ruleAbstractStatement ) ) otherlv_16= '}' otherlv_17= 'Od' ) )
			// InternalDsl.g:1844:2: ( () otherlv_1= 'While' otherlv_2= '(' ( (lv_guard_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Do' otherlv_6= 'Inv:' otherlv_7= '(' ( (lv_invariant_8_0= ruleCondition ) ) otherlv_9= ')' otherlv_10= 'Var:' otherlv_11= '(' ( (lv_variant_12_0= ruleVariant ) ) otherlv_13= ')' otherlv_14= '{' ( (lv_loopStatement_15_0= ruleAbstractStatement ) ) otherlv_16= '}' otherlv_17= 'Od' )
			{
			// InternalDsl.g:1844:2: ( () otherlv_1= 'While' otherlv_2= '(' ( (lv_guard_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Do' otherlv_6= 'Inv:' otherlv_7= '(' ( (lv_invariant_8_0= ruleCondition ) ) otherlv_9= ')' otherlv_10= 'Var:' otherlv_11= '(' ( (lv_variant_12_0= ruleVariant ) ) otherlv_13= ')' otherlv_14= '{' ( (lv_loopStatement_15_0= ruleAbstractStatement ) ) otherlv_16= '}' otherlv_17= 'Od' )
			// InternalDsl.g:1845:3: () otherlv_1= 'While' otherlv_2= '(' ( (lv_guard_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Do' otherlv_6= 'Inv:' otherlv_7= '(' ( (lv_invariant_8_0= ruleCondition ) ) otherlv_9= ')' otherlv_10= 'Var:' otherlv_11= '(' ( (lv_variant_12_0= ruleVariant ) ) otherlv_13= ')' otherlv_14= '{' ( (lv_loopStatement_15_0= ruleAbstractStatement ) ) otherlv_16= '}' otherlv_17= 'Od'
			{
			// InternalDsl.g:1845:3: ()
			// InternalDsl.g:1846:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getSmallRepetitionStatementAccess().getSmallRepetitionStatementAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,74,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getSmallRepetitionStatementAccess().getWhileKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getSmallRepetitionStatementAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:1860:3: ( (lv_guard_3_0= ruleCondition ) )
			// InternalDsl.g:1861:4: (lv_guard_3_0= ruleCondition )
			{
			// InternalDsl.g:1861:4: (lv_guard_3_0= ruleCondition )
			// InternalDsl.g:1862:5: lv_guard_3_0= ruleCondition
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getSmallRepetitionStatementAccess().getGuardConditionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_8);
			lv_guard_3_0=ruleCondition();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getSmallRepetitionStatementRule());
								}
								set(
									current,
									"guard",
									lv_guard_3_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,25,FOLLOW_38); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getSmallRepetitionStatementAccess().getRightParenthesisKeyword_4());
					}
			otherlv_5=(Token)match(input,53,FOLLOW_39); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getSmallRepetitionStatementAccess().getDoKeyword_5());
					}
			otherlv_6=(Token)match(input,61,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getSmallRepetitionStatementAccess().getInvKeyword_6());
					}
			otherlv_7=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_7, grammarAccess.getSmallRepetitionStatementAccess().getLeftParenthesisKeyword_7());
					}
			// InternalDsl.g:1895:3: ( (lv_invariant_8_0= ruleCondition ) )
			// InternalDsl.g:1896:4: (lv_invariant_8_0= ruleCondition )
			{
			// InternalDsl.g:1896:4: (lv_invariant_8_0= ruleCondition )
			// InternalDsl.g:1897:5: lv_invariant_8_0= ruleCondition
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getSmallRepetitionStatementAccess().getInvariantConditionParserRuleCall_8_0());
							}
			pushFollow(FOLLOW_8);
			lv_invariant_8_0=ruleCondition();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getSmallRepetitionStatementRule());
								}
								set(
									current,
									"invariant",
									lv_invariant_8_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_9=(Token)match(input,25,FOLLOW_40); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_9, grammarAccess.getSmallRepetitionStatementAccess().getRightParenthesisKeyword_9());
					}
			otherlv_10=(Token)match(input,72,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_10, grammarAccess.getSmallRepetitionStatementAccess().getVarKeyword_10());
					}
			otherlv_11=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_11, grammarAccess.getSmallRepetitionStatementAccess().getLeftParenthesisKeyword_11());
					}
			// InternalDsl.g:1926:3: ( (lv_variant_12_0= ruleVariant ) )
			// InternalDsl.g:1927:4: (lv_variant_12_0= ruleVariant )
			{
			// InternalDsl.g:1927:4: (lv_variant_12_0= ruleVariant )
			// InternalDsl.g:1928:5: lv_variant_12_0= ruleVariant
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getSmallRepetitionStatementAccess().getVariantVariantParserRuleCall_12_0());
							}
			pushFollow(FOLLOW_8);
			lv_variant_12_0=ruleVariant();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getSmallRepetitionStatementRule());
								}
								set(
									current,
									"variant",
									lv_variant_12_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Variant");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_13=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_13, grammarAccess.getSmallRepetitionStatementAccess().getRightParenthesisKeyword_13());
					}
			otherlv_14=(Token)match(input,107,FOLLOW_10); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_14, grammarAccess.getSmallRepetitionStatementAccess().getLeftCurlyBracketKeyword_14());
					}
			// InternalDsl.g:1953:3: ( (lv_loopStatement_15_0= ruleAbstractStatement ) )
			// InternalDsl.g:1954:4: (lv_loopStatement_15_0= ruleAbstractStatement )
			{
			// InternalDsl.g:1954:4: (lv_loopStatement_15_0= ruleAbstractStatement )
			// InternalDsl.g:1955:5: lv_loopStatement_15_0= ruleAbstractStatement
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getSmallRepetitionStatementAccess().getLoopStatementAbstractStatementParserRuleCall_15_0());
							}
			pushFollow(FOLLOW_11);
			lv_loopStatement_15_0=ruleAbstractStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getSmallRepetitionStatementRule());
								}
								set(
									current,
									"loopStatement",
									lv_loopStatement_15_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.AbstractStatement");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_16=(Token)match(input,111,FOLLOW_41); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_16, grammarAccess.getSmallRepetitionStatementAccess().getRightCurlyBracketKeyword_16());
					}
			otherlv_17=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_17, grammarAccess.getSmallRepetitionStatementAccess().getOdKeyword_17());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleSmallRepetitionStatement"



	// $ANTLR start "entryRuleVariant"
	// InternalDsl.g:1984:1: entryRuleVariant returns [EObject current=null] :iv_ruleVariant= ruleVariant EOF ;
	public final EObject entryRuleVariant() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleVariant =null;

		try {
			// InternalDsl.g:1984:48: (iv_ruleVariant= ruleVariant EOF )
			// InternalDsl.g:1985:2: iv_ruleVariant= ruleVariant EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getVariantRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleVariant=ruleVariant();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleVariant; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleVariant"



	// $ANTLR start "ruleVariant"
	// InternalDsl.g:1991:1: ruleVariant returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) ) ;
	public final EObject ruleVariant() throws RecognitionException {
		EObject current = null;


		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1997:2: ( ( () ( (lv_name_1_0= ruleEString ) ) ) )
			// InternalDsl.g:1998:2: ( () ( (lv_name_1_0= ruleEString ) ) )
			{
			// InternalDsl.g:1998:2: ( () ( (lv_name_1_0= ruleEString ) ) )
			// InternalDsl.g:1999:3: () ( (lv_name_1_0= ruleEString ) )
			{
			// InternalDsl.g:1999:3: ()
			// InternalDsl.g:2000:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getVariantAccess().getVariantAction_0(),
								current);
						}
			}

			// InternalDsl.g:2006:3: ( (lv_name_1_0= ruleEString ) )
			// InternalDsl.g:2007:4: (lv_name_1_0= ruleEString )
			{
			// InternalDsl.g:2007:4: (lv_name_1_0= ruleEString )
			// InternalDsl.g:2008:5: lv_name_1_0= ruleEString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getVariantAccess().getNameEStringParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_name_1_0=ruleEString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getVariantRule());
								}
								set(
									current,
									"name",
									lv_name_1_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.EString");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleVariant"



	// $ANTLR start "entryRuleJavaVariables"
	// InternalDsl.g:2029:1: entryRuleJavaVariables returns [EObject current=null] :iv_ruleJavaVariables= ruleJavaVariables EOF ;
	public final EObject entryRuleJavaVariables() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJavaVariables =null;

		try {
			// InternalDsl.g:2029:54: (iv_ruleJavaVariables= ruleJavaVariables EOF )
			// InternalDsl.g:2030:2: iv_ruleJavaVariables= ruleJavaVariables EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJavaVariablesRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJavaVariables=ruleJavaVariables();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJavaVariables; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJavaVariables"



	// $ANTLR start "ruleJavaVariables"
	// InternalDsl.g:2036:1: ruleJavaVariables returns [EObject current=null] : ( () otherlv_1= 'JavaVariables' (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )? ) ;
	public final EObject ruleJavaVariables() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		EObject lv_variables_4_0 =null;
		EObject lv_variables_6_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2042:2: ( ( () otherlv_1= 'JavaVariables' (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )? ) )
			// InternalDsl.g:2043:2: ( () otherlv_1= 'JavaVariables' (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )? )
			{
			// InternalDsl.g:2043:2: ( () otherlv_1= 'JavaVariables' (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )? )
			// InternalDsl.g:2044:3: () otherlv_1= 'JavaVariables' (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )?
			{
			// InternalDsl.g:2044:3: ()
			// InternalDsl.g:2045:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getJavaVariablesAccess().getJavaVariablesAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,62,FOLLOW_42); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getJavaVariablesAccess().getJavaVariablesKeyword_1());
					}
			// InternalDsl.g:2055:3: (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==73) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// InternalDsl.g:2056:4: otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']'
					{
					otherlv_2=(Token)match(input,73,FOLLOW_43); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getJavaVariablesAccess().getVariablesKeyword_2_0());
								}
					otherlv_3=(Token)match(input,75,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_3, grammarAccess.getJavaVariablesAccess().getLeftSquareBracketKeyword_2_1());
								}
					// InternalDsl.g:2064:4: ( (lv_variables_4_0= ruleJavaVariable ) )
					// InternalDsl.g:2065:5: (lv_variables_4_0= ruleJavaVariable )
					{
					// InternalDsl.g:2065:5: (lv_variables_4_0= ruleJavaVariable )
					// InternalDsl.g:2066:6: lv_variables_4_0= ruleJavaVariable
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getJavaVariablesAccess().getVariablesJavaVariableParserRuleCall_2_2_0());
										}
					pushFollow(FOLLOW_44);
					lv_variables_4_0=ruleJavaVariable();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getJavaVariablesRule());
											}
											add(
												current,
												"variables",
												lv_variables_4_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.JavaVariable");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:2083:4: (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )*
					loop34:
					while (true) {
						int alt34=2;
						int LA34_0 = input.LA(1);
						if ( (LA34_0==31) ) {
							alt34=1;
						}

						switch (alt34) {
						case 1 :
							// InternalDsl.g:2084:5: otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) )
							{
							otherlv_5=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_5, grammarAccess.getJavaVariablesAccess().getCommaKeyword_2_3_0());
											}
							// InternalDsl.g:2088:5: ( (lv_variables_6_0= ruleJavaVariable ) )
							// InternalDsl.g:2089:6: (lv_variables_6_0= ruleJavaVariable )
							{
							// InternalDsl.g:2089:6: (lv_variables_6_0= ruleJavaVariable )
							// InternalDsl.g:2090:7: lv_variables_6_0= ruleJavaVariable
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJavaVariablesAccess().getVariablesJavaVariableParserRuleCall_2_3_1_0());
													}
							pushFollow(FOLLOW_44);
							lv_variables_6_0=ruleJavaVariable();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getJavaVariablesRule());
														}
														add(
															current,
															"variables",
															lv_variables_6_0,
															"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.JavaVariable");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop34;
						}
					}

					otherlv_7=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_7, grammarAccess.getJavaVariablesAccess().getRightSquareBracketKeyword_2_4());
								}
					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJavaVariables"



	// $ANTLR start "entryRuleJavaVariable"
	// InternalDsl.g:2117:1: entryRuleJavaVariable returns [EObject current=null] :iv_ruleJavaVariable= ruleJavaVariable EOF ;
	public final EObject entryRuleJavaVariable() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJavaVariable =null;

		try {
			// InternalDsl.g:2117:53: (iv_ruleJavaVariable= ruleJavaVariable EOF )
			// InternalDsl.g:2118:2: iv_ruleJavaVariable= ruleJavaVariable EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJavaVariableRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJavaVariable=ruleJavaVariable();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJavaVariable; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJavaVariable"



	// $ANTLR start "ruleJavaVariable"
	// InternalDsl.g:2124:1: ruleJavaVariable returns [EObject current=null] : ( () ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_var_2_0= ruleVariableOrMethodName ) ) ) ;
	public final EObject ruleJavaVariable() throws RecognitionException {
		EObject current = null;


		EObject lv_type_1_0 =null;
		EObject lv_var_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2130:2: ( ( () ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_var_2_0= ruleVariableOrMethodName ) ) ) )
			// InternalDsl.g:2131:2: ( () ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_var_2_0= ruleVariableOrMethodName ) ) )
			{
			// InternalDsl.g:2131:2: ( () ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_var_2_0= ruleVariableOrMethodName ) ) )
			// InternalDsl.g:2132:3: () ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_var_2_0= ruleVariableOrMethodName ) )
			{
			// InternalDsl.g:2132:3: ()
			// InternalDsl.g:2133:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getJavaVariableAccess().getJavaVariableAction_0(),
								current);
						}
			}

			// InternalDsl.g:2139:3: ( (lv_type_1_0= ruleJvmTypeReference ) )
			// InternalDsl.g:2140:4: (lv_type_1_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:2140:4: (lv_type_1_0= ruleJvmTypeReference )
			// InternalDsl.g:2141:5: lv_type_1_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJavaVariableAccess().getTypeJvmTypeReferenceParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_23);
			lv_type_1_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJavaVariableRule());
								}
								set(
									current,
									"type",
									lv_type_1_0,
									"jbase.Jbase.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:2158:3: ( (lv_var_2_0= ruleVariableOrMethodName ) )
			// InternalDsl.g:2159:4: (lv_var_2_0= ruleVariableOrMethodName )
			{
			// InternalDsl.g:2159:4: (lv_var_2_0= ruleVariableOrMethodName )
			// InternalDsl.g:2160:5: lv_var_2_0= ruleVariableOrMethodName
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJavaVariableAccess().getVarVariableOrMethodNameParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_2);
			lv_var_2_0=ruleVariableOrMethodName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJavaVariableRule());
								}
								set(
									current,
									"var",
									lv_var_2_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.VariableOrMethodName");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJavaVariable"



	// $ANTLR start "entryRuleGlobalConditions"
	// InternalDsl.g:2181:1: entryRuleGlobalConditions returns [EObject current=null] :iv_ruleGlobalConditions= ruleGlobalConditions EOF ;
	public final EObject entryRuleGlobalConditions() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleGlobalConditions =null;

		try {
			// InternalDsl.g:2181:57: (iv_ruleGlobalConditions= ruleGlobalConditions EOF )
			// InternalDsl.g:2182:2: iv_ruleGlobalConditions= ruleGlobalConditions EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getGlobalConditionsRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleGlobalConditions=ruleGlobalConditions();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleGlobalConditions; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleGlobalConditions"



	// $ANTLR start "ruleGlobalConditions"
	// InternalDsl.g:2188:1: ruleGlobalConditions returns [EObject current=null] : ( () otherlv_1= 'GlobalConditions' (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )? ) ;
	public final EObject ruleGlobalConditions() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		EObject lv_conditions_4_0 =null;
		EObject lv_conditions_6_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2194:2: ( ( () otherlv_1= 'GlobalConditions' (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )? ) )
			// InternalDsl.g:2195:2: ( () otherlv_1= 'GlobalConditions' (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )? )
			{
			// InternalDsl.g:2195:2: ( () otherlv_1= 'GlobalConditions' (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )? )
			// InternalDsl.g:2196:3: () otherlv_1= 'GlobalConditions' (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )?
			{
			// InternalDsl.g:2196:3: ()
			// InternalDsl.g:2197:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getGlobalConditionsAccess().getGlobalConditionsAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,58,FOLLOW_45); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getGlobalConditionsAccess().getGlobalConditionsKeyword_1());
					}
			// InternalDsl.g:2207:3: (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==52) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// InternalDsl.g:2208:4: otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']'
					{
					otherlv_2=(Token)match(input,52,FOLLOW_43); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getGlobalConditionsAccess().getConditionsKeyword_2_0());
								}
					otherlv_3=(Token)match(input,75,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_3, grammarAccess.getGlobalConditionsAccess().getLeftSquareBracketKeyword_2_1());
								}
					// InternalDsl.g:2216:4: ( (lv_conditions_4_0= ruleCondition ) )
					// InternalDsl.g:2217:5: (lv_conditions_4_0= ruleCondition )
					{
					// InternalDsl.g:2217:5: (lv_conditions_4_0= ruleCondition )
					// InternalDsl.g:2218:6: lv_conditions_4_0= ruleCondition
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getGlobalConditionsAccess().getConditionsConditionParserRuleCall_2_2_0());
										}
					pushFollow(FOLLOW_44);
					lv_conditions_4_0=ruleCondition();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getGlobalConditionsRule());
											}
											add(
												current,
												"conditions",
												lv_conditions_4_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:2235:4: (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )*
					loop36:
					while (true) {
						int alt36=2;
						int LA36_0 = input.LA(1);
						if ( (LA36_0==31) ) {
							alt36=1;
						}

						switch (alt36) {
						case 1 :
							// InternalDsl.g:2236:5: otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) )
							{
							otherlv_5=(Token)match(input,31,FOLLOW_7); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_5, grammarAccess.getGlobalConditionsAccess().getCommaKeyword_2_3_0());
											}
							// InternalDsl.g:2240:5: ( (lv_conditions_6_0= ruleCondition ) )
							// InternalDsl.g:2241:6: (lv_conditions_6_0= ruleCondition )
							{
							// InternalDsl.g:2241:6: (lv_conditions_6_0= ruleCondition )
							// InternalDsl.g:2242:7: lv_conditions_6_0= ruleCondition
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getGlobalConditionsAccess().getConditionsConditionParserRuleCall_2_3_1_0());
													}
							pushFollow(FOLLOW_44);
							lv_conditions_6_0=ruleCondition();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getGlobalConditionsRule());
														}
														add(
															current,
															"conditions",
															lv_conditions_6_0,
															"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop36;
						}
					}

					otherlv_7=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_7, grammarAccess.getGlobalConditionsAccess().getRightSquareBracketKeyword_2_4());
								}
					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleGlobalConditions"



	// $ANTLR start "entryRuleRenaming"
	// InternalDsl.g:2269:1: entryRuleRenaming returns [EObject current=null] :iv_ruleRenaming= ruleRenaming EOF ;
	public final EObject entryRuleRenaming() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleRenaming =null;

		try {
			// InternalDsl.g:2269:49: (iv_ruleRenaming= ruleRenaming EOF )
			// InternalDsl.g:2270:2: iv_ruleRenaming= ruleRenaming EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getRenamingRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleRenaming=ruleRenaming();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleRenaming; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleRenaming"



	// $ANTLR start "ruleRenaming"
	// InternalDsl.g:2276:1: ruleRenaming returns [EObject current=null] : ( () otherlv_1= 'Renaming' (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )? ) ;
	public final EObject ruleRenaming() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_3=null;
		Token otherlv_6=null;
		EObject lv_rename_4_0 =null;
		EObject lv_rename_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2282:2: ( ( () otherlv_1= 'Renaming' (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )? ) )
			// InternalDsl.g:2283:2: ( () otherlv_1= 'Renaming' (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )? )
			{
			// InternalDsl.g:2283:2: ( () otherlv_1= 'Renaming' (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )? )
			// InternalDsl.g:2284:3: () otherlv_1= 'Renaming' (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )?
			{
			// InternalDsl.g:2284:3: ()
			// InternalDsl.g:2285:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getRenamingAccess().getRenamingAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,68,FOLLOW_46); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getRenamingAccess().getRenamingKeyword_1());
					}
			// InternalDsl.g:2295:3: (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==67) ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// InternalDsl.g:2296:4: otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']'
					{
					otherlv_2=(Token)match(input,67,FOLLOW_43); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getRenamingAccess().getRenamesKeyword_2_0());
								}
					otherlv_3=(Token)match(input,75,FOLLOW_9); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_3, grammarAccess.getRenamingAccess().getLeftSquareBracketKeyword_2_1());
								}
					// InternalDsl.g:2304:4: ( (lv_rename_4_0= ruleRename ) )
					// InternalDsl.g:2305:5: (lv_rename_4_0= ruleRename )
					{
					// InternalDsl.g:2305:5: (lv_rename_4_0= ruleRename )
					// InternalDsl.g:2306:6: lv_rename_4_0= ruleRename
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getRenamingAccess().getRenameRenameParserRuleCall_2_2_0());
										}
					pushFollow(FOLLOW_47);
					lv_rename_4_0=ruleRename();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getRenamingRule());
											}
											add(
												current,
												"rename",
												lv_rename_4_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Rename");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:2323:4: ( (lv_rename_5_0= ruleRename ) )*
					loop38:
					while (true) {
						int alt38=2;
						int LA38_0 = input.LA(1);
						if ( (LA38_0==107) ) {
							alt38=1;
						}

						switch (alt38) {
						case 1 :
							// InternalDsl.g:2324:5: (lv_rename_5_0= ruleRename )
							{
							// InternalDsl.g:2324:5: (lv_rename_5_0= ruleRename )
							// InternalDsl.g:2325:6: lv_rename_5_0= ruleRename
							{
							if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getRenamingAccess().getRenameRenameParserRuleCall_2_3_0());
												}
							pushFollow(FOLLOW_47);
							lv_rename_5_0=ruleRename();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElementForParent(grammarAccess.getRenamingRule());
													}
													add(
														current,
														"rename",
														lv_rename_5_0,
														"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Rename");
													afterParserOrEnumRuleCall();
												}
							}

							}
							break;

						default :
							break loop38;
						}
					}

					otherlv_6=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_6, grammarAccess.getRenamingAccess().getRightSquareBracketKeyword_2_4());
								}
					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleRenaming"



	// $ANTLR start "entryRuleRename"
	// InternalDsl.g:2351:1: entryRuleRename returns [EObject current=null] :iv_ruleRename= ruleRename EOF ;
	public final EObject entryRuleRename() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleRename =null;

		try {
			// InternalDsl.g:2351:47: (iv_ruleRename= ruleRename EOF )
			// InternalDsl.g:2352:2: iv_ruleRename= ruleRename EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getRenameRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleRename=ruleRename();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleRename; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleRename"



	// $ANTLR start "ruleRename"
	// InternalDsl.g:2358:1: ruleRename returns [EObject current=null] : ( () otherlv_1= '{' otherlv_2= 'Type' ( (lv_type_3_0= ruleEString ) ) otherlv_4= 'Function' ( (lv_function_5_0= ruleEString ) ) otherlv_6= 'NewName' ( (lv_newName_7_0= ruleEString ) ) otherlv_8= '}' ) ;
	public final EObject ruleRename() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		AntlrDatatypeRuleToken lv_type_3_0 =null;
		AntlrDatatypeRuleToken lv_function_5_0 =null;
		AntlrDatatypeRuleToken lv_newName_7_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2364:2: ( ( () otherlv_1= '{' otherlv_2= 'Type' ( (lv_type_3_0= ruleEString ) ) otherlv_4= 'Function' ( (lv_function_5_0= ruleEString ) ) otherlv_6= 'NewName' ( (lv_newName_7_0= ruleEString ) ) otherlv_8= '}' ) )
			// InternalDsl.g:2365:2: ( () otherlv_1= '{' otherlv_2= 'Type' ( (lv_type_3_0= ruleEString ) ) otherlv_4= 'Function' ( (lv_function_5_0= ruleEString ) ) otherlv_6= 'NewName' ( (lv_newName_7_0= ruleEString ) ) otherlv_8= '}' )
			{
			// InternalDsl.g:2365:2: ( () otherlv_1= '{' otherlv_2= 'Type' ( (lv_type_3_0= ruleEString ) ) otherlv_4= 'Function' ( (lv_function_5_0= ruleEString ) ) otherlv_6= 'NewName' ( (lv_newName_7_0= ruleEString ) ) otherlv_8= '}' )
			// InternalDsl.g:2366:3: () otherlv_1= '{' otherlv_2= 'Type' ( (lv_type_3_0= ruleEString ) ) otherlv_4= 'Function' ( (lv_function_5_0= ruleEString ) ) otherlv_6= 'NewName' ( (lv_newName_7_0= ruleEString ) ) otherlv_8= '}'
			{
			// InternalDsl.g:2366:3: ()
			// InternalDsl.g:2367:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getRenameAccess().getRenameAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,107,FOLLOW_48); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getRenameAccess().getLeftCurlyBracketKeyword_1());
					}
			otherlv_2=(Token)match(input,71,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getRenameAccess().getTypeKeyword_2());
					}
			// InternalDsl.g:2381:3: ( (lv_type_3_0= ruleEString ) )
			// InternalDsl.g:2382:4: (lv_type_3_0= ruleEString )
			{
			// InternalDsl.g:2382:4: (lv_type_3_0= ruleEString )
			// InternalDsl.g:2383:5: lv_type_3_0= ruleEString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getRenameAccess().getTypeEStringParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_49);
			lv_type_3_0=ruleEString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getRenameRule());
								}
								set(
									current,
									"type",
									lv_type_3_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.EString");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,57,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getRenameAccess().getFunctionKeyword_4());
					}
			// InternalDsl.g:2404:3: ( (lv_function_5_0= ruleEString ) )
			// InternalDsl.g:2405:4: (lv_function_5_0= ruleEString )
			{
			// InternalDsl.g:2405:4: (lv_function_5_0= ruleEString )
			// InternalDsl.g:2406:5: lv_function_5_0= ruleEString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getRenameAccess().getFunctionEStringParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_50);
			lv_function_5_0=ruleEString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getRenameRule());
								}
								set(
									current,
									"function",
									lv_function_5_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.EString");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_6=(Token)match(input,63,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getRenameAccess().getNewNameKeyword_6());
					}
			// InternalDsl.g:2427:3: ( (lv_newName_7_0= ruleEString ) )
			// InternalDsl.g:2428:4: (lv_newName_7_0= ruleEString )
			{
			// InternalDsl.g:2428:4: (lv_newName_7_0= ruleEString )
			// InternalDsl.g:2429:5: lv_newName_7_0= ruleEString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getRenameAccess().getNewNameEStringParserRuleCall_7_0());
							}
			pushFollow(FOLLOW_11);
			lv_newName_7_0=ruleEString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getRenameRule());
								}
								set(
									current,
									"newName",
									lv_newName_7_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.EString");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_8=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getRenameAccess().getRightCurlyBracketKeyword_8());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleRename"



	// $ANTLR start "entryRuleExpression"
	// InternalDsl.g:2454:1: entryRuleExpression returns [EObject current=null] :iv_ruleExpression= ruleExpression EOF ;
	public final EObject entryRuleExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleExpression =null;

		try {
			// InternalDsl.g:2454:51: (iv_ruleExpression= ruleExpression EOF )
			// InternalDsl.g:2455:2: iv_ruleExpression= ruleExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleExpression=ruleExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleExpression"



	// $ANTLR start "ruleExpression"
	// InternalDsl.g:2461:1: ruleExpression returns [EObject current=null] :this_Foreach_0= ruleForeach ;
	public final EObject ruleExpression() throws RecognitionException {
		EObject current = null;


		EObject this_Foreach_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2467:2: (this_Foreach_0= ruleForeach )
			// InternalDsl.g:2468:2: this_Foreach_0= ruleForeach
			{
			if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getExpressionAccess().getForeachParserRuleCall());
				}
			pushFollow(FOLLOW_2);
			this_Foreach_0=ruleForeach();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current = this_Foreach_0;
					afterParserOrEnumRuleCall();
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleExpression"



	// $ANTLR start "entryRuleVariableOrMethodName"
	// InternalDsl.g:2479:1: entryRuleVariableOrMethodName returns [EObject current=null] :iv_ruleVariableOrMethodName= ruleVariableOrMethodName EOF ;
	public final EObject entryRuleVariableOrMethodName() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleVariableOrMethodName =null;

		try {
			// InternalDsl.g:2479:61: (iv_ruleVariableOrMethodName= ruleVariableOrMethodName EOF )
			// InternalDsl.g:2480:2: iv_ruleVariableOrMethodName= ruleVariableOrMethodName EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getVariableOrMethodNameRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleVariableOrMethodName=ruleVariableOrMethodName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleVariableOrMethodName; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleVariableOrMethodName"



	// $ANTLR start "ruleVariableOrMethodName"
	// InternalDsl.g:2486:1: ruleVariableOrMethodName returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
	public final EObject ruleVariableOrMethodName() throws RecognitionException {
		EObject current = null;


		Token lv_name_0_0=null;


			enterRule();

		try {
			// InternalDsl.g:2492:2: ( ( (lv_name_0_0= RULE_ID ) ) )
			// InternalDsl.g:2493:2: ( (lv_name_0_0= RULE_ID ) )
			{
			// InternalDsl.g:2493:2: ( (lv_name_0_0= RULE_ID ) )
			// InternalDsl.g:2494:3: (lv_name_0_0= RULE_ID )
			{
			// InternalDsl.g:2494:3: (lv_name_0_0= RULE_ID )
			// InternalDsl.g:2495:4: lv_name_0_0= RULE_ID
			{
			lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
							newLeafNode(lv_name_0_0, grammarAccess.getVariableOrMethodNameAccess().getNameIDTerminalRuleCall_0());
						}
			if ( state.backtracking==0 ) {
							if (current==null) {
								current = createModelElement(grammarAccess.getVariableOrMethodNameRule());
							}
							setWithLastConsumed(
								current,
								"name",
								lv_name_0_0,
								"org.eclipse.xtext.xbase.Xtype.ID");
						}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleVariableOrMethodName"



	// $ANTLR start "entryRuleForeach"
	// InternalDsl.g:2514:1: entryRuleForeach returns [EObject current=null] :iv_ruleForeach= ruleForeach EOF ;
	public final EObject entryRuleForeach() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleForeach =null;

		try {
			// InternalDsl.g:2514:48: (iv_ruleForeach= ruleForeach EOF )
			// InternalDsl.g:2515:2: iv_ruleForeach= ruleForeach EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getForeachRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleForeach=ruleForeach();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleForeach; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleForeach"



	// $ANTLR start "ruleForeach"
	// InternalDsl.g:2521:1: ruleForeach returns [EObject current=null] : (this_Exists_0= ruleExists | ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' ) ) ;
	public final EObject ruleForeach() throws RecognitionException {
		EObject current = null;


		Token lv_foreach_1_0=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject this_Exists_0 =null;
		EObject lv_type_2_0 =null;
		EObject lv_var_3_0 =null;
		EObject lv_right_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2527:2: ( (this_Exists_0= ruleExists | ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' ) ) )
			// InternalDsl.g:2528:2: (this_Exists_0= ruleExists | ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' ) )
			{
			// InternalDsl.g:2528:2: (this_Exists_0= ruleExists | ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' ) )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( ((LA40_0 >= RULE_DECIMAL && LA40_0 <= RULE_INT)||(LA40_0 >= 22 && LA40_0 <= 23)||LA40_0==89||LA40_0==104) ) {
				alt40=1;
			}
			else if ( (LA40_0==24) ) {
				alt40=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// InternalDsl.g:2529:3: this_Exists_0= ruleExists
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getForeachAccess().getExistsParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_Exists_0=ruleExists();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_Exists_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalDsl.g:2538:3: ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' )
					{
					// InternalDsl.g:2538:3: ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' )
					// InternalDsl.g:2539:4: ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')'
					{
					// InternalDsl.g:2539:4: ( (lv_foreach_1_0= '(\\\\foreach' ) )
					// InternalDsl.g:2540:5: (lv_foreach_1_0= '(\\\\foreach' )
					{
					// InternalDsl.g:2540:5: (lv_foreach_1_0= '(\\\\foreach' )
					// InternalDsl.g:2541:6: lv_foreach_1_0= '(\\\\foreach'
					{
					lv_foreach_1_0=(Token)match(input,24,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_foreach_1_0, grammarAccess.getForeachAccess().getForeachForeachKeyword_1_0_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getForeachRule());
											}
											setWithLastConsumed(current, "foreach", lv_foreach_1_0, "(\\foreach");
										}
					}

					}

					// InternalDsl.g:2553:4: ( (lv_type_2_0= ruleJvmTypeReference ) )
					// InternalDsl.g:2554:5: (lv_type_2_0= ruleJvmTypeReference )
					{
					// InternalDsl.g:2554:5: (lv_type_2_0= ruleJvmTypeReference )
					// InternalDsl.g:2555:6: lv_type_2_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getForeachAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_23);
					lv_type_2_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getForeachRule());
											}
											set(
												current,
												"type",
												lv_type_2_0,
												"jbase.Jbase.JvmTypeReference");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:2572:4: ( (lv_var_3_0= ruleVariableOrMethodName ) )
					// InternalDsl.g:2573:5: (lv_var_3_0= ruleVariableOrMethodName )
					{
					// InternalDsl.g:2573:5: (lv_var_3_0= ruleVariableOrMethodName )
					// InternalDsl.g:2574:6: lv_var_3_0= ruleVariableOrMethodName
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getForeachAccess().getVarVariableOrMethodNameParserRuleCall_1_2_0());
										}
					pushFollow(FOLLOW_51);
					lv_var_3_0=ruleVariableOrMethodName();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getForeachRule());
											}
											set(
												current,
												"var",
												lv_var_3_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.VariableOrMethodName");
											afterParserOrEnumRuleCall();
										}
					}

					}

					otherlv_4=(Token)match(input,41,FOLLOW_52); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_4, grammarAccess.getForeachAccess().getSemicolonKeyword_1_3());
								}
					// InternalDsl.g:2595:4: ( (lv_right_5_0= ruleExists ) )
					// InternalDsl.g:2596:5: (lv_right_5_0= ruleExists )
					{
					// InternalDsl.g:2596:5: (lv_right_5_0= ruleExists )
					// InternalDsl.g:2597:6: lv_right_5_0= ruleExists
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getForeachAccess().getRightExistsParserRuleCall_1_4_0());
										}
					pushFollow(FOLLOW_8);
					lv_right_5_0=ruleExists();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getForeachRule());
											}
											set(
												current,
												"right",
												lv_right_5_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Exists");
											afterParserOrEnumRuleCall();
										}
					}

					}

					otherlv_6=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_6, grammarAccess.getForeachAccess().getRightParenthesisKeyword_1_5());
								}
					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleForeach"



	// $ANTLR start "entryRuleExists"
	// InternalDsl.g:2623:1: entryRuleExists returns [EObject current=null] :iv_ruleExists= ruleExists EOF ;
	public final EObject entryRuleExists() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleExists =null;

		try {
			// InternalDsl.g:2623:47: (iv_ruleExists= ruleExists EOF )
			// InternalDsl.g:2624:2: iv_ruleExists= ruleExists EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getExistsRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleExists=ruleExists();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleExists; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleExists"



	// $ANTLR start "ruleExists"
	// InternalDsl.g:2630:1: ruleExists returns [EObject current=null] : (this_Relation_0= ruleRelation | ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' ) ) ;
	public final EObject ruleExists() throws RecognitionException {
		EObject current = null;


		Token lv_exists_1_0=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject this_Relation_0 =null;
		EObject lv_type_2_0 =null;
		EObject lv_var_3_0 =null;
		EObject lv_right_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2636:2: ( (this_Relation_0= ruleRelation | ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' ) ) )
			// InternalDsl.g:2637:2: (this_Relation_0= ruleRelation | ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' ) )
			{
			// InternalDsl.g:2637:2: (this_Relation_0= ruleRelation | ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' ) )
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( ((LA41_0 >= RULE_DECIMAL && LA41_0 <= RULE_INT)||LA41_0==22||LA41_0==89||LA41_0==104) ) {
				alt41=1;
			}
			else if ( (LA41_0==23) ) {
				alt41=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// InternalDsl.g:2638:3: this_Relation_0= ruleRelation
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getExistsAccess().getRelationParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_Relation_0=ruleRelation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_Relation_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalDsl.g:2647:3: ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' )
					{
					// InternalDsl.g:2647:3: ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' )
					// InternalDsl.g:2648:4: ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')'
					{
					// InternalDsl.g:2648:4: ( (lv_exists_1_0= '(\\\\exists' ) )
					// InternalDsl.g:2649:5: (lv_exists_1_0= '(\\\\exists' )
					{
					// InternalDsl.g:2649:5: (lv_exists_1_0= '(\\\\exists' )
					// InternalDsl.g:2650:6: lv_exists_1_0= '(\\\\exists'
					{
					lv_exists_1_0=(Token)match(input,23,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_exists_1_0, grammarAccess.getExistsAccess().getExistsExistsKeyword_1_0_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getExistsRule());
											}
											setWithLastConsumed(current, "exists", lv_exists_1_0, "(\\exists");
										}
					}

					}

					// InternalDsl.g:2662:4: ( (lv_type_2_0= ruleJvmTypeReference ) )
					// InternalDsl.g:2663:5: (lv_type_2_0= ruleJvmTypeReference )
					{
					// InternalDsl.g:2663:5: (lv_type_2_0= ruleJvmTypeReference )
					// InternalDsl.g:2664:6: lv_type_2_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getExistsAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_23);
					lv_type_2_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getExistsRule());
											}
											set(
												current,
												"type",
												lv_type_2_0,
												"jbase.Jbase.JvmTypeReference");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:2681:4: ( (lv_var_3_0= ruleVariableOrMethodName ) )
					// InternalDsl.g:2682:5: (lv_var_3_0= ruleVariableOrMethodName )
					{
					// InternalDsl.g:2682:5: (lv_var_3_0= ruleVariableOrMethodName )
					// InternalDsl.g:2683:6: lv_var_3_0= ruleVariableOrMethodName
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getExistsAccess().getVarVariableOrMethodNameParserRuleCall_1_2_0());
										}
					pushFollow(FOLLOW_51);
					lv_var_3_0=ruleVariableOrMethodName();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getExistsRule());
											}
											set(
												current,
												"var",
												lv_var_3_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.VariableOrMethodName");
											afterParserOrEnumRuleCall();
										}
					}

					}

					otherlv_4=(Token)match(input,41,FOLLOW_53); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_4, grammarAccess.getExistsAccess().getSemicolonKeyword_1_3());
								}
					// InternalDsl.g:2704:4: ( (lv_right_5_0= ruleRelation ) )
					// InternalDsl.g:2705:5: (lv_right_5_0= ruleRelation )
					{
					// InternalDsl.g:2705:5: (lv_right_5_0= ruleRelation )
					// InternalDsl.g:2706:6: lv_right_5_0= ruleRelation
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getExistsAccess().getRightRelationParserRuleCall_1_4_0());
										}
					pushFollow(FOLLOW_8);
					lv_right_5_0=ruleRelation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getExistsRule());
											}
											set(
												current,
												"right",
												lv_right_5_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Relation");
											afterParserOrEnumRuleCall();
										}
					}

					}

					otherlv_6=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_6, grammarAccess.getExistsAccess().getRightParenthesisKeyword_1_5());
								}
					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleExists"



	// $ANTLR start "entryRuleRelation"
	// InternalDsl.g:2732:1: entryRuleRelation returns [EObject current=null] :iv_ruleRelation= ruleRelation EOF ;
	public final EObject entryRuleRelation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleRelation =null;

		try {
			// InternalDsl.g:2732:49: (iv_ruleRelation= ruleRelation EOF )
			// InternalDsl.g:2733:2: iv_ruleRelation= ruleRelation EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getRelationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleRelation=ruleRelation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleRelation; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleRelation"



	// $ANTLR start "ruleRelation"
	// InternalDsl.g:2739:1: ruleRelation returns [EObject current=null] : (this_Implication_0= ruleImplication ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )* ) ;
	public final EObject ruleRelation() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token otherlv_10=null;
		EObject this_Implication_0 =null;
		EObject lv_right_11_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2745:2: ( (this_Implication_0= ruleImplication ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )* ) )
			// InternalDsl.g:2746:2: (this_Implication_0= ruleImplication ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )* )
			{
			// InternalDsl.g:2746:2: (this_Implication_0= ruleImplication ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )* )
			// InternalDsl.g:2747:3: this_Implication_0= ruleImplication ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getRelationAccess().getImplicationParserRuleCall_0());
					}
			pushFollow(FOLLOW_54);
			this_Implication_0=ruleImplication();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_Implication_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:2755:3: ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )*
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0==42||(LA43_0 >= 44 && LA43_0 <= 45)||(LA43_0 >= 47 && LA43_0 <= 48)) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// InternalDsl.g:2756:4: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) )
					{
					// InternalDsl.g:2756:4: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) )
					int alt42=5;
					switch ( input.LA(1) ) {
					case 42:
						{
						alt42=1;
						}
						break;
					case 47:
						{
						alt42=2;
						}
						break;
					case 45:
						{
						alt42=3;
						}
						break;
					case 44:
						{
						alt42=4;
						}
						break;
					case 48:
						{
						alt42=5;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 42, 0, input);
						throw nvae;
					}
					switch (alt42) {
						case 1 :
							// InternalDsl.g:2757:5: ( () otherlv_2= '<' )
							{
							// InternalDsl.g:2757:5: ( () otherlv_2= '<' )
							// InternalDsl.g:2758:6: () otherlv_2= '<'
							{
							// InternalDsl.g:2758:6: ()
							// InternalDsl.g:2759:7: 
							{
							if ( state.backtracking==0 ) {
														current = forceCreateModelElementAndSet(
															grammarAccess.getRelationAccess().getLowerLeftAction_1_0_0_0(),
															current);
													}
							}

							otherlv_2=(Token)match(input,42,FOLLOW_53); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_2, grammarAccess.getRelationAccess().getLessThanSignKeyword_1_0_0_1());
												}
							}

							}
							break;
						case 2 :
							// InternalDsl.g:2771:5: ( () otherlv_4= '>' )
							{
							// InternalDsl.g:2771:5: ( () otherlv_4= '>' )
							// InternalDsl.g:2772:6: () otherlv_4= '>'
							{
							// InternalDsl.g:2772:6: ()
							// InternalDsl.g:2773:7: 
							{
							if ( state.backtracking==0 ) {
														current = forceCreateModelElementAndSet(
															grammarAccess.getRelationAccess().getGreaterLeftAction_1_0_1_0(),
															current);
													}
							}

							otherlv_4=(Token)match(input,47,FOLLOW_53); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_4, grammarAccess.getRelationAccess().getGreaterThanSignKeyword_1_0_1_1());
												}
							}

							}
							break;
						case 3 :
							// InternalDsl.g:2785:5: ( () otherlv_6= '=' )
							{
							// InternalDsl.g:2785:5: ( () otherlv_6= '=' )
							// InternalDsl.g:2786:6: () otherlv_6= '='
							{
							// InternalDsl.g:2786:6: ()
							// InternalDsl.g:2787:7: 
							{
							if ( state.backtracking==0 ) {
														current = forceCreateModelElementAndSet(
															grammarAccess.getRelationAccess().getEqualLeftAction_1_0_2_0(),
															current);
													}
							}

							otherlv_6=(Token)match(input,45,FOLLOW_53); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_6, grammarAccess.getRelationAccess().getEqualsSignKeyword_1_0_2_1());
												}
							}

							}
							break;
						case 4 :
							// InternalDsl.g:2799:5: ( () otherlv_8= '<=' )
							{
							// InternalDsl.g:2799:5: ( () otherlv_8= '<=' )
							// InternalDsl.g:2800:6: () otherlv_8= '<='
							{
							// InternalDsl.g:2800:6: ()
							// InternalDsl.g:2801:7: 
							{
							if ( state.backtracking==0 ) {
														current = forceCreateModelElementAndSet(
															grammarAccess.getRelationAccess().getLowerEqualLeftAction_1_0_3_0(),
															current);
													}
							}

							otherlv_8=(Token)match(input,44,FOLLOW_53); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_8, grammarAccess.getRelationAccess().getLessThanSignEqualsSignKeyword_1_0_3_1());
												}
							}

							}
							break;
						case 5 :
							// InternalDsl.g:2813:5: ( () otherlv_10= '>=' )
							{
							// InternalDsl.g:2813:5: ( () otherlv_10= '>=' )
							// InternalDsl.g:2814:6: () otherlv_10= '>='
							{
							// InternalDsl.g:2814:6: ()
							// InternalDsl.g:2815:7: 
							{
							if ( state.backtracking==0 ) {
														current = forceCreateModelElementAndSet(
															grammarAccess.getRelationAccess().getGreaterEqualLeftAction_1_0_4_0(),
															current);
													}
							}

							otherlv_10=(Token)match(input,48,FOLLOW_53); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_10, grammarAccess.getRelationAccess().getGreaterThanSignEqualsSignKeyword_1_0_4_1());
												}
							}

							}
							break;

					}

					// InternalDsl.g:2827:4: ( (lv_right_11_0= ruleImplication ) )
					// InternalDsl.g:2828:5: (lv_right_11_0= ruleImplication )
					{
					// InternalDsl.g:2828:5: (lv_right_11_0= ruleImplication )
					// InternalDsl.g:2829:6: lv_right_11_0= ruleImplication
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getRelationAccess().getRightImplicationParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_54);
					lv_right_11_0=ruleImplication();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getRelationRule());
											}
											set(
												current,
												"right",
												lv_right_11_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Implication");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop43;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleRelation"



	// $ANTLR start "entryRuleImplication"
	// InternalDsl.g:2851:1: entryRuleImplication returns [EObject current=null] :iv_ruleImplication= ruleImplication EOF ;
	public final EObject entryRuleImplication() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleImplication =null;

		try {
			// InternalDsl.g:2851:52: (iv_ruleImplication= ruleImplication EOF )
			// InternalDsl.g:2852:2: iv_ruleImplication= ruleImplication EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getImplicationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleImplication=ruleImplication();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleImplication; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleImplication"



	// $ANTLR start "ruleImplication"
	// InternalDsl.g:2858:1: ruleImplication returns [EObject current=null] : (this_Concat_0= ruleConcat ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )* ) ;
	public final EObject ruleImplication() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject this_Concat_0 =null;
		EObject lv_right_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2864:2: ( (this_Concat_0= ruleConcat ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )* ) )
			// InternalDsl.g:2865:2: (this_Concat_0= ruleConcat ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )* )
			{
			// InternalDsl.g:2865:2: (this_Concat_0= ruleConcat ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )* )
			// InternalDsl.g:2866:3: this_Concat_0= ruleConcat ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getImplicationAccess().getConcatParserRuleCall_0());
					}
			pushFollow(FOLLOW_55);
			this_Concat_0=ruleConcat();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_Concat_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:2874:3: ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )*
			loop44:
			while (true) {
				int alt44=2;
				int LA44_0 = input.LA(1);
				if ( (LA44_0==35) ) {
					alt44=1;
				}

				switch (alt44) {
				case 1 :
					// InternalDsl.g:2875:4: ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) )
					{
					// InternalDsl.g:2875:4: ( () otherlv_2= '->' )
					// InternalDsl.g:2876:5: () otherlv_2= '->'
					{
					// InternalDsl.g:2876:5: ()
					// InternalDsl.g:2877:6: 
					{
					if ( state.backtracking==0 ) {
											current = forceCreateModelElementAndSet(
												grammarAccess.getImplicationAccess().getImplLeftAction_1_0_0(),
												current);
										}
					}

					otherlv_2=(Token)match(input,35,FOLLOW_53); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_2, grammarAccess.getImplicationAccess().getHyphenMinusGreaterThanSignKeyword_1_0_1());
									}
					}

					// InternalDsl.g:2888:4: ( (lv_right_3_0= ruleConcat ) )
					// InternalDsl.g:2889:5: (lv_right_3_0= ruleConcat )
					{
					// InternalDsl.g:2889:5: (lv_right_3_0= ruleConcat )
					// InternalDsl.g:2890:6: lv_right_3_0= ruleConcat
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getImplicationAccess().getRightConcatParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_55);
					lv_right_3_0=ruleConcat();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getImplicationRule());
											}
											set(
												current,
												"right",
												lv_right_3_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Concat");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop44;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleImplication"



	// $ANTLR start "entryRuleConcat"
	// InternalDsl.g:2912:1: entryRuleConcat returns [EObject current=null] :iv_ruleConcat= ruleConcat EOF ;
	public final EObject entryRuleConcat() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleConcat =null;

		try {
			// InternalDsl.g:2912:47: (iv_ruleConcat= ruleConcat EOF )
			// InternalDsl.g:2913:2: iv_ruleConcat= ruleConcat EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getConcatRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleConcat=ruleConcat();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleConcat; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleConcat"



	// $ANTLR start "ruleConcat"
	// InternalDsl.g:2919:1: ruleConcat returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) ;
	public final EObject ruleConcat() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject this_PrimaryExpression_0 =null;
		EObject lv_right_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2925:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) )
			// InternalDsl.g:2926:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
			{
			// InternalDsl.g:2926:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
			// InternalDsl.g:2927:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getConcatAccess().getPrimaryExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_56);
			this_PrimaryExpression_0=rulePrimaryExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_PrimaryExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:2935:3: ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
			loop46:
			while (true) {
				int alt46=2;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==20||LA46_0==108) ) {
					alt46=1;
				}

				switch (alt46) {
				case 1 :
					// InternalDsl.g:2936:4: ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) )
					{
					// InternalDsl.g:2936:4: ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) )
					int alt45=2;
					int LA45_0 = input.LA(1);
					if ( (LA45_0==20) ) {
						alt45=1;
					}
					else if ( (LA45_0==108) ) {
						alt45=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 45, 0, input);
						throw nvae;
					}

					switch (alt45) {
						case 1 :
							// InternalDsl.g:2937:5: ( () otherlv_2= '&' )
							{
							// InternalDsl.g:2937:5: ( () otherlv_2= '&' )
							// InternalDsl.g:2938:6: () otherlv_2= '&'
							{
							// InternalDsl.g:2938:6: ()
							// InternalDsl.g:2939:7: 
							{
							if ( state.backtracking==0 ) {
														current = forceCreateModelElementAndSet(
															grammarAccess.getConcatAccess().getAndLeftAction_1_0_0_0(),
															current);
													}
							}

							otherlv_2=(Token)match(input,20,FOLLOW_53); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_2, grammarAccess.getConcatAccess().getAmpersandKeyword_1_0_0_1());
												}
							}

							}
							break;
						case 2 :
							// InternalDsl.g:2951:5: ( () otherlv_4= '|' )
							{
							// InternalDsl.g:2951:5: ( () otherlv_4= '|' )
							// InternalDsl.g:2952:6: () otherlv_4= '|'
							{
							// InternalDsl.g:2952:6: ()
							// InternalDsl.g:2953:7: 
							{
							if ( state.backtracking==0 ) {
														current = forceCreateModelElementAndSet(
															grammarAccess.getConcatAccess().getOrLeftAction_1_0_1_0(),
															current);
													}
							}

							otherlv_4=(Token)match(input,108,FOLLOW_53); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_4, grammarAccess.getConcatAccess().getVerticalLineKeyword_1_0_1_1());
												}
							}

							}
							break;

					}

					// InternalDsl.g:2965:4: ( (lv_right_5_0= rulePrimaryExpression ) )
					// InternalDsl.g:2966:5: (lv_right_5_0= rulePrimaryExpression )
					{
					// InternalDsl.g:2966:5: (lv_right_5_0= rulePrimaryExpression )
					// InternalDsl.g:2967:6: lv_right_5_0= rulePrimaryExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getConcatAccess().getRightPrimaryExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_56);
					lv_right_5_0=rulePrimaryExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getConcatRule());
											}
											set(
												current,
												"right",
												lv_right_5_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.PrimaryExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop46;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleConcat"



	// $ANTLR start "entryRulePrimaryExpression"
	// InternalDsl.g:2989:1: entryRulePrimaryExpression returns [EObject current=null] :iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
	public final EObject entryRulePrimaryExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_rulePrimaryExpression =null;

		try {
			// InternalDsl.g:2989:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
			// InternalDsl.g:2990:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getPrimaryExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_rulePrimaryExpression=rulePrimaryExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_rulePrimaryExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRulePrimaryExpression"



	// $ANTLR start "rulePrimaryExpression"
	// InternalDsl.g:2996:1: rulePrimaryExpression returns [EObject current=null] : ( ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ) | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? ) | ( () ruleNumber ) ) ;
	public final EObject rulePrimaryExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token lv_isTrue_2_0=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token otherlv_8=null;
		Token otherlv_10=null;
		Token otherlv_12=null;
		EObject this_Expression_4 =null;
		EObject lv_func_7_0 =null;
		EObject lv_args_9_0 =null;
		EObject lv_args_11_0 =null;


			enterRule();

		try {
			// InternalDsl.g:3002:2: ( ( ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ) | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? ) | ( () ruleNumber ) ) )
			// InternalDsl.g:3003:2: ( ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ) | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? ) | ( () ruleNumber ) )
			{
			// InternalDsl.g:3003:2: ( ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ) | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? ) | ( () ruleNumber ) )
			int alt51=4;
			switch ( input.LA(1) ) {
			case 89:
			case 104:
				{
				alt51=1;
				}
				break;
			case 22:
				{
				alt51=2;
				}
				break;
			case RULE_ID:
				{
				alt51=3;
				}
				break;
			case RULE_DECIMAL:
			case RULE_HEX:
			case RULE_INT:
				{
				alt51=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 51, 0, input);
				throw nvae;
			}
			switch (alt51) {
				case 1 :
					// InternalDsl.g:3004:3: ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
					{
					// InternalDsl.g:3004:3: ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
					// InternalDsl.g:3005:4: () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
					{
					// InternalDsl.g:3005:4: ()
					// InternalDsl.g:3006:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getPrimaryExpressionAccess().getExpressionAction_0_0(),
											current);
									}
					}

					// InternalDsl.g:3012:4: ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
					// InternalDsl.g:3013:5: ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
					{
					// InternalDsl.g:3023:5: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
					int alt47=2;
					int LA47_0 = input.LA(1);
					if ( (LA47_0==89) ) {
						alt47=1;
					}
					else if ( (LA47_0==104) ) {
						alt47=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 47, 0, input);
						throw nvae;
					}

					switch (alt47) {
						case 1 :
							// InternalDsl.g:3024:6: otherlv_1= 'false'
							{
							otherlv_1=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getFalseKeyword_0_1_0_0());
												}
							}
							break;
						case 2 :
							// InternalDsl.g:3029:6: ( (lv_isTrue_2_0= 'true' ) )
							{
							// InternalDsl.g:3029:6: ( (lv_isTrue_2_0= 'true' ) )
							// InternalDsl.g:3030:7: (lv_isTrue_2_0= 'true' )
							{
							// InternalDsl.g:3030:7: (lv_isTrue_2_0= 'true' )
							// InternalDsl.g:3031:8: lv_isTrue_2_0= 'true'
							{
							lv_isTrue_2_0=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(lv_isTrue_2_0, grammarAccess.getPrimaryExpressionAccess().getIsTrueTrueKeyword_0_1_0_1_0());
														}
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElement(grammarAccess.getPrimaryExpressionRule());
															}
															setWithLastConsumed(current, "isTrue", lv_isTrue_2_0 != null, "true");
														}
							}

							}

							}
							break;

					}

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:3047:3: (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' )
					{
					// InternalDsl.g:3047:3: (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' )
					// InternalDsl.g:3048:4: otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')'
					{
					otherlv_3=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0());
								}
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1());
								}
					pushFollow(FOLLOW_8);
					this_Expression_4=ruleExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_Expression_4;
									afterParserOrEnumRuleCall();
								}
					otherlv_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2());
								}
					}

					}
					break;
				case 3 :
					// InternalDsl.g:3066:3: ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? )
					{
					// InternalDsl.g:3066:3: ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? )
					// InternalDsl.g:3067:4: () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )?
					{
					// InternalDsl.g:3067:4: ()
					// InternalDsl.g:3068:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getPrimaryExpressionAccess().getFunctionCallAction_2_0(),
											current);
									}
					}

					// InternalDsl.g:3074:4: ( (lv_func_7_0= ruleVariableOrMethodName ) )
					// InternalDsl.g:3075:5: (lv_func_7_0= ruleVariableOrMethodName )
					{
					// InternalDsl.g:3075:5: (lv_func_7_0= ruleVariableOrMethodName )
					// InternalDsl.g:3076:6: lv_func_7_0= ruleVariableOrMethodName
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFuncVariableOrMethodNameParserRuleCall_2_1_0());
										}
					pushFollow(FOLLOW_57);
					lv_func_7_0=ruleVariableOrMethodName();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
											}
											set(
												current,
												"func",
												lv_func_7_0,
												"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.VariableOrMethodName");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:3093:4: (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )?
					int alt50=2;
					int LA50_0 = input.LA(1);
					if ( (LA50_0==22) ) {
						alt50=1;
					}
					switch (alt50) {
						case 1 :
							// InternalDsl.g:3094:5: otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')'
							{
							otherlv_8=(Token)match(input,22,FOLLOW_58); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_8, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_2_0());
											}
							// InternalDsl.g:3098:5: ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )?
							int alt49=2;
							int LA49_0 = input.LA(1);
							if ( ((LA49_0 >= RULE_DECIMAL && LA49_0 <= RULE_INT)||(LA49_0 >= 22 && LA49_0 <= 24)||LA49_0==89||LA49_0==104) ) {
								alt49=1;
							}
							switch (alt49) {
								case 1 :
									// InternalDsl.g:3099:6: ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )*
									{
									// InternalDsl.g:3099:6: ( (lv_args_9_0= ruleExpression ) )
									// InternalDsl.g:3100:7: (lv_args_9_0= ruleExpression )
									{
									// InternalDsl.g:3100:7: (lv_args_9_0= ruleExpression )
									// InternalDsl.g:3101:8: lv_args_9_0= ruleExpression
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_1_0_0());
																}
									pushFollow(FOLLOW_26);
									lv_args_9_0=ruleExpression();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
																	}
																	add(
																		current,
																		"args",
																		lv_args_9_0,
																		"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Expression");
																	afterParserOrEnumRuleCall();
																}
									}

									}

									// InternalDsl.g:3118:6: (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )*
									loop48:
									while (true) {
										int alt48=2;
										int LA48_0 = input.LA(1);
										if ( (LA48_0==31) ) {
											alt48=1;
										}

										switch (alt48) {
										case 1 :
											// InternalDsl.g:3119:7: otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) )
											{
											otherlv_10=(Token)match(input,31,FOLLOW_7); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																		newLeafNode(otherlv_10, grammarAccess.getPrimaryExpressionAccess().getCommaKeyword_2_2_1_1_0());
																	}
											// InternalDsl.g:3123:7: ( (lv_args_11_0= ruleExpression ) )
											// InternalDsl.g:3124:8: (lv_args_11_0= ruleExpression )
											{
											// InternalDsl.g:3124:8: (lv_args_11_0= ruleExpression )
											// InternalDsl.g:3125:9: lv_args_11_0= ruleExpression
											{
											if ( state.backtracking==0 ) {
																				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_1_1_1_0());
																			}
											pushFollow(FOLLOW_26);
											lv_args_11_0=ruleExpression();
											state._fsp--;
											if (state.failed) return current;
											if ( state.backtracking==0 ) {
																				if (current==null) {
																					current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
																				}
																				add(
																					current,
																					"args",
																					lv_args_11_0,
																					"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Expression");
																				afterParserOrEnumRuleCall();
																			}
											}

											}

											}
											break;

										default :
											break loop48;
										}
									}

									}
									break;

							}

							otherlv_12=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_12, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2_2());
											}
							}
							break;

					}

					}

					}
					break;
				case 4 :
					// InternalDsl.g:3151:3: ( () ruleNumber )
					{
					// InternalDsl.g:3151:3: ( () ruleNumber )
					// InternalDsl.g:3152:4: () ruleNumber
					{
					// InternalDsl.g:3152:4: ()
					// InternalDsl.g:3153:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getPrimaryExpressionAccess().getExpressionAction_3_0(),
											current);
									}
					}

					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNumberParserRuleCall_3_1());
								}
					pushFollow(FOLLOW_2);
					ruleNumber();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									afterParserOrEnumRuleCall();
								}
					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "rulePrimaryExpression"



	// $ANTLR start "entryRuleXJStatementOrBlock"
	// InternalDsl.g:3171:1: entryRuleXJStatementOrBlock returns [EObject current=null] :iv_ruleXJStatementOrBlock= ruleXJStatementOrBlock EOF ;
	public final EObject entryRuleXJStatementOrBlock() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJStatementOrBlock =null;

		try {
			// InternalDsl.g:3171:59: (iv_ruleXJStatementOrBlock= ruleXJStatementOrBlock EOF )
			// InternalDsl.g:3172:2: iv_ruleXJStatementOrBlock= ruleXJStatementOrBlock EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJStatementOrBlockRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJStatementOrBlock=ruleXJStatementOrBlock();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJStatementOrBlock; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJStatementOrBlock"



	// $ANTLR start "ruleXJStatementOrBlock"
	// InternalDsl.g:3178:1: ruleXJStatementOrBlock returns [EObject current=null] : ( ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression ) |this_XJSingleStatement_1= ruleXJSingleStatement ) ;
	public final EObject ruleXJStatementOrBlock() throws RecognitionException {
		EObject current = null;


		EObject this_XBlockExpression_0 =null;
		EObject this_XJSingleStatement_1 =null;


			enterRule();

		try {
			// InternalDsl.g:3184:2: ( ( ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression ) |this_XJSingleStatement_1= ruleXJSingleStatement ) )
			// InternalDsl.g:3185:2: ( ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression ) |this_XJSingleStatement_1= ruleXJSingleStatement )
			{
			// InternalDsl.g:3185:2: ( ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression ) |this_XJSingleStatement_1= ruleXJSingleStatement )
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==107) ) {
				int LA52_1 = input.LA(2);
				if ( (synpred2_InternalDsl()) ) {
					alt52=1;
				}
				else if ( (true) ) {
					alt52=2;
				}

			}
			else if ( ((LA52_0 >= RULE_CHARACTER && LA52_0 <= RULE_INT)||LA52_0==RULE_STRING||LA52_0==14||LA52_0==22||(LA52_0 >= 28 && LA52_0 <= 29)||(LA52_0 >= 32 && LA52_0 <= 33)||LA52_0==41||LA52_0==79||LA52_0==83||LA52_0==85||(LA52_0 >= 87 && LA52_0 <= 90)||(LA52_0 >= 92 && LA52_0 <= 94)||(LA52_0 >= 96 && LA52_0 <= 106)||LA52_0==112) ) {
				alt52=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 52, 0, input);
				throw nvae;
			}

			switch (alt52) {
				case 1 :
					// InternalDsl.g:3186:3: ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression )
					{
					// InternalDsl.g:3186:3: ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression )
					// InternalDsl.g:3187:4: ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXJStatementOrBlockAccess().getXBlockExpressionParserRuleCall_0());
								}
					pushFollow(FOLLOW_2);
					this_XBlockExpression_0=ruleXBlockExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XBlockExpression_0;
									afterParserOrEnumRuleCall();
								}
					}

					}
					break;
				case 2 :
					// InternalDsl.g:3198:3: this_XJSingleStatement_1= ruleXJSingleStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJStatementOrBlockAccess().getXJSingleStatementParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XJSingleStatement_1=ruleXJSingleStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XJSingleStatement_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJStatementOrBlock"



	// $ANTLR start "entryRuleXImportDeclaration"
	// InternalDsl.g:3210:1: entryRuleXImportDeclaration returns [EObject current=null] :iv_ruleXImportDeclaration= ruleXImportDeclaration EOF ;
	public final EObject entryRuleXImportDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXImportDeclaration =null;

		try {
			// InternalDsl.g:3210:59: (iv_ruleXImportDeclaration= ruleXImportDeclaration EOF )
			// InternalDsl.g:3211:2: iv_ruleXImportDeclaration= ruleXImportDeclaration EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXImportDeclarationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXImportDeclaration=ruleXImportDeclaration();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXImportDeclaration; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXImportDeclaration"



	// $ANTLR start "ruleXImportDeclaration"
	// InternalDsl.g:3217:1: ruleXImportDeclaration returns [EObject current=null] : ( ( ( 'import' )=>otherlv_0= 'import' ) ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) ) ( ( ';' )=>otherlv_7= ';' )* ) ;
	public final EObject ruleXImportDeclaration() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token lv_static_1_0=null;
		Token lv_wildcard_3_0=null;
		Token otherlv_7=null;
		AntlrDatatypeRuleToken lv_memberName_4_0 =null;
		AntlrDatatypeRuleToken lv_importedNamespace_6_0 =null;


			enterRule();

		try {
			// InternalDsl.g:3223:2: ( ( ( ( 'import' )=>otherlv_0= 'import' ) ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) ) ( ( ';' )=>otherlv_7= ';' )* ) )
			// InternalDsl.g:3224:2: ( ( ( 'import' )=>otherlv_0= 'import' ) ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) ) ( ( ';' )=>otherlv_7= ';' )* )
			{
			// InternalDsl.g:3224:2: ( ( ( 'import' )=>otherlv_0= 'import' ) ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) ) ( ( ';' )=>otherlv_7= ';' )* )
			// InternalDsl.g:3225:3: ( ( 'import' )=>otherlv_0= 'import' ) ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) ) ( ( ';' )=>otherlv_7= ';' )*
			{
			// InternalDsl.g:3225:3: ( ( 'import' )=>otherlv_0= 'import' )
			// InternalDsl.g:3226:4: ( 'import' )=>otherlv_0= 'import'
			{
			otherlv_0=(Token)match(input,94,FOLLOW_59); if (state.failed) return current;
			if ( state.backtracking==0 ) {
							newLeafNode(otherlv_0, grammarAccess.getXImportDeclarationAccess().getImportKeyword_0());
						}
			}

			// InternalDsl.g:3232:3: ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) )
			int alt54=3;
			alt54 = dfa54.predict(input);
			switch (alt54) {
				case 1 :
					// InternalDsl.g:3233:4: ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) )
					{
					// InternalDsl.g:3233:4: ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) )
					// InternalDsl.g:3234:5: ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) )
					{
					// InternalDsl.g:3234:5: ( (lv_static_1_0= 'static' ) )
					// InternalDsl.g:3235:6: (lv_static_1_0= 'static' )
					{
					// InternalDsl.g:3235:6: (lv_static_1_0= 'static' )
					// InternalDsl.g:3236:7: lv_static_1_0= 'static'
					{
					lv_static_1_0=(Token)match(input,99,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(lv_static_1_0, grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0());
											}
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXImportDeclarationRule());
												}
												setWithLastConsumed(current, "static", lv_static_1_0 != null, "static");
											}
					}

					}

					// InternalDsl.g:3248:5: ( ( ruleQualifiedNameInStaticImport ) )
					// InternalDsl.g:3249:6: ( ruleQualifiedNameInStaticImport )
					{
					// InternalDsl.g:3249:6: ( ruleQualifiedNameInStaticImport )
					// InternalDsl.g:3250:7: ruleQualifiedNameInStaticImport
					{
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXImportDeclarationRule());
												}
											}
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_1_0());
											}
					pushFollow(FOLLOW_60);
					ruleQualifiedNameInStaticImport();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalDsl.g:3264:5: ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) )
					int alt53=2;
					int LA53_0 = input.LA(1);
					if ( (LA53_0==26) ) {
						alt53=1;
					}
					else if ( (LA53_0==RULE_ID) ) {
						alt53=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 53, 0, input);
						throw nvae;
					}

					switch (alt53) {
						case 1 :
							// InternalDsl.g:3265:6: ( (lv_wildcard_3_0= '*' ) )
							{
							// InternalDsl.g:3265:6: ( (lv_wildcard_3_0= '*' ) )
							// InternalDsl.g:3266:7: (lv_wildcard_3_0= '*' )
							{
							// InternalDsl.g:3266:7: (lv_wildcard_3_0= '*' )
							// InternalDsl.g:3267:8: lv_wildcard_3_0= '*'
							{
							lv_wildcard_3_0=(Token)match(input,26,FOLLOW_61); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(lv_wildcard_3_0, grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_2_0_0());
														}
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElement(grammarAccess.getXImportDeclarationRule());
															}
															setWithLastConsumed(current, "wildcard", lv_wildcard_3_0 != null, "*");
														}
							}

							}

							}
							break;
						case 2 :
							// InternalDsl.g:3280:6: ( (lv_memberName_4_0= ruleValidID ) )
							{
							// InternalDsl.g:3280:6: ( (lv_memberName_4_0= ruleValidID ) )
							// InternalDsl.g:3281:7: (lv_memberName_4_0= ruleValidID )
							{
							// InternalDsl.g:3281:7: (lv_memberName_4_0= ruleValidID )
							// InternalDsl.g:3282:8: lv_memberName_4_0= ruleValidID
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_2_1_0());
														}
							pushFollow(FOLLOW_61);
							lv_memberName_4_0=ruleValidID();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
															}
															set(
																current,
																"memberName",
																lv_memberName_4_0,
																"org.eclipse.xtext.xbase.Xtype.ValidID");
															afterParserOrEnumRuleCall();
														}
							}

							}

							}
							break;

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:3302:4: ( ( ruleQualifiedName ) )
					{
					// InternalDsl.g:3302:4: ( ( ruleQualifiedName ) )
					// InternalDsl.g:3303:5: ( ruleQualifiedName )
					{
					// InternalDsl.g:3303:5: ( ruleQualifiedName )
					// InternalDsl.g:3304:6: ruleQualifiedName
					{
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXImportDeclarationRule());
											}
										}
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0());
										}
					pushFollow(FOLLOW_61);
					ruleQualifiedName();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;
				case 3 :
					// InternalDsl.g:3319:4: ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) )
					{
					// InternalDsl.g:3319:4: ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) )
					// InternalDsl.g:3320:5: (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard )
					{
					// InternalDsl.g:3320:5: (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard )
					// InternalDsl.g:3321:6: lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0());
										}
					pushFollow(FOLLOW_61);
					lv_importedNamespace_6_0=ruleQualifiedNameWithWildcard();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
											}
											set(
												current,
												"importedNamespace",
												lv_importedNamespace_6_0,
												"org.eclipse.xtext.xbase.Xtype.QualifiedNameWithWildcard");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			// InternalDsl.g:3339:3: ( ( ';' )=>otherlv_7= ';' )*
			loop55:
			while (true) {
				int alt55=2;
				int LA55_0 = input.LA(1);
				if ( (LA55_0==41) && (synpred4_InternalDsl())) {
					alt55=1;
				}

				switch (alt55) {
				case 1 :
					// InternalDsl.g:3340:4: ( ';' )=>otherlv_7= ';'
					{
					otherlv_7=(Token)match(input,41,FOLLOW_61); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_7, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
								}
					}
					break;

				default :
					break loop55;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXImportDeclaration"



	// $ANTLR start "entryRuleJvmTypeReference"
	// InternalDsl.g:3350:1: entryRuleJvmTypeReference returns [EObject current=null] :iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
	public final EObject entryRuleJvmTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmTypeReference =null;

		try {
			// InternalDsl.g:3350:57: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
			// InternalDsl.g:3351:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmTypeReference=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmTypeReference; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmTypeReference"



	// $ANTLR start "ruleJvmTypeReference"
	// InternalDsl.g:3357:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) ;
	public final EObject ruleJvmTypeReference() throws RecognitionException {
		EObject current = null;


		EObject this_JvmParameterizedTypeReference_0 =null;


			enterRule();

		try {
			// InternalDsl.g:3363:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) )
			// InternalDsl.g:3364:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
			{
			// InternalDsl.g:3364:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
			// InternalDsl.g:3365:3: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0());
					}
			pushFollow(FOLLOW_62);
			this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_JvmParameterizedTypeReference_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:3373:3: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
			loop56:
			while (true) {
				int alt56=2;
				int LA56_0 = input.LA(1);
				if ( (LA56_0==75) ) {
					int LA56_2 = input.LA(2);
					if ( (LA56_2==76) ) {
						int LA56_3 = input.LA(3);
						if ( (synpred5_InternalDsl()) ) {
							alt56=1;
						}

					}

				}

				switch (alt56) {
				case 1 :
					// InternalDsl.g:3374:4: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
					{
					// InternalDsl.g:3380:4: ( () ruleArrayBrackets )
					// InternalDsl.g:3381:5: () ruleArrayBrackets
					{
					// InternalDsl.g:3381:5: ()
					// InternalDsl.g:3382:6: 
					{
					if ( state.backtracking==0 ) {
											current = forceCreateModelElementAndSet(
												grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_1_0_0(),
												current);
										}
					}

					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_1_0_1());
									}
					pushFollow(FOLLOW_62);
					ruleArrayBrackets();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					break loop56;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmTypeReference"



	// $ANTLR start "entryRuleFullJvmFormalParameter"
	// InternalDsl.g:3401:1: entryRuleFullJvmFormalParameter returns [EObject current=null] :iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
	public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleFullJvmFormalParameter =null;

		try {
			// InternalDsl.g:3401:63: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
			// InternalDsl.g:3402:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleFullJvmFormalParameter; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleFullJvmFormalParameter"



	// $ANTLR start "ruleFullJvmFormalParameter"
	// InternalDsl.g:3408:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( () ( (lv_final_1_0= 'final' ) )? ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ( (lv_varArgs_3_0= '...' ) )? ( (lv_name_4_0= ruleValidID ) ) ) ;
	public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		Token lv_final_1_0=null;
		Token lv_varArgs_3_0=null;
		EObject lv_parameterType_2_0 =null;
		AntlrDatatypeRuleToken lv_name_4_0 =null;


			enterRule();

		try {
			// InternalDsl.g:3414:2: ( ( () ( (lv_final_1_0= 'final' ) )? ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ( (lv_varArgs_3_0= '...' ) )? ( (lv_name_4_0= ruleValidID ) ) ) )
			// InternalDsl.g:3415:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ( (lv_varArgs_3_0= '...' ) )? ( (lv_name_4_0= ruleValidID ) ) )
			{
			// InternalDsl.g:3415:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ( (lv_varArgs_3_0= '...' ) )? ( (lv_name_4_0= ruleValidID ) ) )
			// InternalDsl.g:3416:3: () ( (lv_final_1_0= 'final' ) )? ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ( (lv_varArgs_3_0= '...' ) )? ( (lv_name_4_0= ruleValidID ) )
			{
			// InternalDsl.g:3416:3: ()
			// InternalDsl.g:3417:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getFullJvmFormalParameterAccess().getXJJvmFormalParameterAction_0(),
								current);
						}
			}

			// InternalDsl.g:3423:3: ( (lv_final_1_0= 'final' ) )?
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==90) ) {
				alt57=1;
			}
			switch (alt57) {
				case 1 :
					// InternalDsl.g:3424:4: (lv_final_1_0= 'final' )
					{
					// InternalDsl.g:3424:4: (lv_final_1_0= 'final' )
					// InternalDsl.g:3425:5: lv_final_1_0= 'final'
					{
					lv_final_1_0=(Token)match(input,90,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(lv_final_1_0, grammarAccess.getFullJvmFormalParameterAccess().getFinalFinalKeyword_1_0());
									}
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getFullJvmFormalParameterRule());
										}
										setWithLastConsumed(current, "final", lv_final_1_0 != null, "final");
									}
					}

					}
					break;

			}

			// InternalDsl.g:3437:3: ( (lv_parameterType_2_0= ruleJvmTypeReference ) )
			// InternalDsl.g:3438:4: (lv_parameterType_2_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:3438:4: (lv_parameterType_2_0= ruleJvmTypeReference )
			// InternalDsl.g:3439:5: lv_parameterType_2_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_63);
			lv_parameterType_2_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
								}
								set(
									current,
									"parameterType",
									lv_parameterType_2_0,
									"jbase.Jbase.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:3456:3: ( (lv_varArgs_3_0= '...' ) )?
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==37) ) {
				alt58=1;
			}
			switch (alt58) {
				case 1 :
					// InternalDsl.g:3457:4: (lv_varArgs_3_0= '...' )
					{
					// InternalDsl.g:3457:4: (lv_varArgs_3_0= '...' )
					// InternalDsl.g:3458:5: lv_varArgs_3_0= '...'
					{
					lv_varArgs_3_0=(Token)match(input,37,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(lv_varArgs_3_0, grammarAccess.getFullJvmFormalParameterAccess().getVarArgsFullStopFullStopFullStopKeyword_3_0());
									}
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getFullJvmFormalParameterRule());
										}
										setWithLastConsumed(current, "varArgs", lv_varArgs_3_0 != null, "...");
									}
					}

					}
					break;

			}

			// InternalDsl.g:3470:3: ( (lv_name_4_0= ruleValidID ) )
			// InternalDsl.g:3471:4: (lv_name_4_0= ruleValidID )
			{
			// InternalDsl.g:3471:4: (lv_name_4_0= ruleValidID )
			// InternalDsl.g:3472:5: lv_name_4_0= ruleValidID
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_4_0());
							}
			pushFollow(FOLLOW_2);
			lv_name_4_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
								}
								set(
									current,
									"name",
									lv_name_4_0,
									"org.eclipse.xtext.xbase.Xtype.ValidID");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleFullJvmFormalParameter"



	// $ANTLR start "entryRuleXJSingleStatement"
	// InternalDsl.g:3493:1: entryRuleXJSingleStatement returns [EObject current=null] :iv_ruleXJSingleStatement= ruleXJSingleStatement EOF ;
	public final EObject entryRuleXJSingleStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJSingleStatement =null;

		try {
			// InternalDsl.g:3493:58: (iv_ruleXJSingleStatement= ruleXJSingleStatement EOF )
			// InternalDsl.g:3494:2: iv_ruleXJSingleStatement= ruleXJSingleStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJSingleStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJSingleStatement=ruleXJSingleStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJSingleStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJSingleStatement"



	// $ANTLR start "ruleXJSingleStatement"
	// InternalDsl.g:3500:1: ruleXJSingleStatement returns [EObject current=null] : (this_XJSemicolonStatement_0= ruleXJSemicolonStatement |this_XSwitchExpression_1= ruleXSwitchExpression |this_XIfExpression_2= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression ) |this_XBasicForLoopExpression_4= ruleXBasicForLoopExpression |this_XWhileExpression_5= ruleXWhileExpression | ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement ) |this_XTryCatchFinallyExpression_7= ruleXTryCatchFinallyExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression ) |this_XJEmptyStatement_9= ruleXJEmptyStatement ) ;
	public final EObject ruleXJSingleStatement() throws RecognitionException {
		EObject current = null;


		EObject this_XJSemicolonStatement_0 =null;
		EObject this_XSwitchExpression_1 =null;
		EObject this_XIfExpression_2 =null;
		EObject this_XForLoopExpression_3 =null;
		EObject this_XBasicForLoopExpression_4 =null;
		EObject this_XWhileExpression_5 =null;
		EObject this_XJTryWithResourcesStatement_6 =null;
		EObject this_XTryCatchFinallyExpression_7 =null;
		EObject this_XSynchronizedExpression_8 =null;
		EObject this_XJEmptyStatement_9 =null;


			enterRule();

		try {
			// InternalDsl.g:3506:2: ( (this_XJSemicolonStatement_0= ruleXJSemicolonStatement |this_XSwitchExpression_1= ruleXSwitchExpression |this_XIfExpression_2= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression ) |this_XBasicForLoopExpression_4= ruleXBasicForLoopExpression |this_XWhileExpression_5= ruleXWhileExpression | ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement ) |this_XTryCatchFinallyExpression_7= ruleXTryCatchFinallyExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression ) |this_XJEmptyStatement_9= ruleXJEmptyStatement ) )
			// InternalDsl.g:3507:2: (this_XJSemicolonStatement_0= ruleXJSemicolonStatement |this_XSwitchExpression_1= ruleXSwitchExpression |this_XIfExpression_2= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression ) |this_XBasicForLoopExpression_4= ruleXBasicForLoopExpression |this_XWhileExpression_5= ruleXWhileExpression | ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement ) |this_XTryCatchFinallyExpression_7= ruleXTryCatchFinallyExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression ) |this_XJEmptyStatement_9= ruleXJEmptyStatement )
			{
			// InternalDsl.g:3507:2: (this_XJSemicolonStatement_0= ruleXJSemicolonStatement |this_XSwitchExpression_1= ruleXSwitchExpression |this_XIfExpression_2= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression ) |this_XBasicForLoopExpression_4= ruleXBasicForLoopExpression |this_XWhileExpression_5= ruleXWhileExpression | ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement ) |this_XTryCatchFinallyExpression_7= ruleXTryCatchFinallyExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression ) |this_XJEmptyStatement_9= ruleXJEmptyStatement )
			int alt59=10;
			int LA59_0 = input.LA(1);
			if ( ((LA59_0 >= RULE_CHARACTER && LA59_0 <= RULE_INT)||LA59_0==RULE_STRING||LA59_0==14||LA59_0==22||(LA59_0 >= 28 && LA59_0 <= 29)||(LA59_0 >= 32 && LA59_0 <= 33)||LA59_0==79||LA59_0==83||LA59_0==85||(LA59_0 >= 87 && LA59_0 <= 90)||LA59_0==94||(LA59_0 >= 96 && LA59_0 <= 100)||(LA59_0 >= 103 && LA59_0 <= 104)||LA59_0==107||LA59_0==112) ) {
				alt59=1;
			}
			else if ( (LA59_0==101) ) {
				alt59=2;
			}
			else if ( (LA59_0==93) ) {
				alt59=3;
			}
			else if ( (LA59_0==92) ) {
				int LA59_32 = input.LA(2);
				if ( (synpred6_InternalDsl()) ) {
					alt59=4;
				}
				else if ( (true) ) {
					alt59=5;
				}

			}
			else if ( (LA59_0==106) ) {
				alt59=6;
			}
			else if ( (LA59_0==105) ) {
				int LA59_34 = input.LA(2);
				if ( (synpred7_InternalDsl()) ) {
					alt59=7;
				}
				else if ( (true) ) {
					alt59=8;
				}

			}
			else if ( (LA59_0==102) && (synpred8_InternalDsl())) {
				alt59=9;
			}
			else if ( (LA59_0==41) ) {
				alt59=10;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				throw nvae;
			}

			switch (alt59) {
				case 1 :
					// InternalDsl.g:3508:3: this_XJSemicolonStatement_0= ruleXJSemicolonStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJSingleStatementAccess().getXJSemicolonStatementParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_XJSemicolonStatement_0=ruleXJSemicolonStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XJSemicolonStatement_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalDsl.g:3517:3: this_XSwitchExpression_1= ruleXSwitchExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJSingleStatementAccess().getXSwitchExpressionParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XSwitchExpression_1=ruleXSwitchExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XSwitchExpression_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 3 :
					// InternalDsl.g:3526:3: this_XIfExpression_2= ruleXIfExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJSingleStatementAccess().getXIfExpressionParserRuleCall_2());
							}
					pushFollow(FOLLOW_2);
					this_XIfExpression_2=ruleXIfExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XIfExpression_2;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 4 :
					// InternalDsl.g:3535:3: ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression )
					{
					// InternalDsl.g:3535:3: ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression )
					// InternalDsl.g:3536:4: ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXJSingleStatementAccess().getXForLoopExpressionParserRuleCall_3());
								}
					pushFollow(FOLLOW_2);
					this_XForLoopExpression_3=ruleXForLoopExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XForLoopExpression_3;
									afterParserOrEnumRuleCall();
								}
					}

					}
					break;
				case 5 :
					// InternalDsl.g:3559:3: this_XBasicForLoopExpression_4= ruleXBasicForLoopExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJSingleStatementAccess().getXBasicForLoopExpressionParserRuleCall_4());
							}
					pushFollow(FOLLOW_2);
					this_XBasicForLoopExpression_4=ruleXBasicForLoopExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XBasicForLoopExpression_4;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 6 :
					// InternalDsl.g:3568:3: this_XWhileExpression_5= ruleXWhileExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJSingleStatementAccess().getXWhileExpressionParserRuleCall_5());
							}
					pushFollow(FOLLOW_2);
					this_XWhileExpression_5=ruleXWhileExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XWhileExpression_5;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 7 :
					// InternalDsl.g:3577:3: ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement )
					{
					// InternalDsl.g:3577:3: ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement )
					// InternalDsl.g:3578:4: ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXJSingleStatementAccess().getXJTryWithResourcesStatementParserRuleCall_6());
								}
					pushFollow(FOLLOW_2);
					this_XJTryWithResourcesStatement_6=ruleXJTryWithResourcesStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XJTryWithResourcesStatement_6;
									afterParserOrEnumRuleCall();
								}
					}

					}
					break;
				case 8 :
					// InternalDsl.g:3599:3: this_XTryCatchFinallyExpression_7= ruleXTryCatchFinallyExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJSingleStatementAccess().getXTryCatchFinallyExpressionParserRuleCall_7());
							}
					pushFollow(FOLLOW_2);
					this_XTryCatchFinallyExpression_7=ruleXTryCatchFinallyExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XTryCatchFinallyExpression_7;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 9 :
					// InternalDsl.g:3608:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression )
					{
					// InternalDsl.g:3608:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression )
					// InternalDsl.g:3609:4: ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXJSingleStatementAccess().getXSynchronizedExpressionParserRuleCall_8());
								}
					pushFollow(FOLLOW_2);
					this_XSynchronizedExpression_8=ruleXSynchronizedExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XSynchronizedExpression_8;
									afterParserOrEnumRuleCall();
								}
					}

					}
					break;
				case 10 :
					// InternalDsl.g:3626:3: this_XJEmptyStatement_9= ruleXJEmptyStatement
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJSingleStatementAccess().getXJEmptyStatementParserRuleCall_9());
							}
					pushFollow(FOLLOW_2);
					this_XJEmptyStatement_9=ruleXJEmptyStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XJEmptyStatement_9;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJSingleStatement"



	// $ANTLR start "entryRuleXJSemicolonStatement"
	// InternalDsl.g:3638:1: entryRuleXJSemicolonStatement returns [EObject current=null] :iv_ruleXJSemicolonStatement= ruleXJSemicolonStatement EOF ;
	public final EObject entryRuleXJSemicolonStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJSemicolonStatement =null;

		try {
			// InternalDsl.g:3638:61: (iv_ruleXJSemicolonStatement= ruleXJSemicolonStatement EOF )
			// InternalDsl.g:3639:2: iv_ruleXJSemicolonStatement= ruleXJSemicolonStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJSemicolonStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJSemicolonStatement=ruleXJSemicolonStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJSemicolonStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJSemicolonStatement"



	// $ANTLR start "ruleXJSemicolonStatement"
	// InternalDsl.g:3645:1: ruleXJSemicolonStatement returns [EObject current=null] : ( () ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) ) ( ( ';' )=> (lv_semicolon_2_0= ';' ) )? ) ;
	public final EObject ruleXJSemicolonStatement() throws RecognitionException {
		EObject current = null;


		Token lv_semicolon_2_0=null;
		EObject lv_expression_1_1 =null;
		EObject lv_expression_1_2 =null;
		EObject lv_expression_1_3 =null;
		EObject lv_expression_1_4 =null;
		EObject lv_expression_1_5 =null;


			enterRule();

		try {
			// InternalDsl.g:3651:2: ( ( () ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) ) ( ( ';' )=> (lv_semicolon_2_0= ';' ) )? ) )
			// InternalDsl.g:3652:2: ( () ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) ) ( ( ';' )=> (lv_semicolon_2_0= ';' ) )? )
			{
			// InternalDsl.g:3652:2: ( () ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) ) ( ( ';' )=> (lv_semicolon_2_0= ';' ) )? )
			// InternalDsl.g:3653:3: () ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) ) ( ( ';' )=> (lv_semicolon_2_0= ';' ) )?
			{
			// InternalDsl.g:3653:3: ()
			// InternalDsl.g:3654:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJSemicolonStatementAccess().getXJSemicolonStatementAction_0(),
								current);
						}
			}

			// InternalDsl.g:3660:3: ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) )
			// InternalDsl.g:3661:4: ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) )
			{
			// InternalDsl.g:3661:4: ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) )
			// InternalDsl.g:3662:5: (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression )
			{
			// InternalDsl.g:3662:5: (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression )
			int alt60=5;
			switch ( input.LA(1) ) {
			case 79:
			case 83:
				{
				alt60=1;
				}
				break;
			case RULE_CHARACTER:
			case RULE_DECIMAL:
			case RULE_HEX:
			case RULE_ID:
			case RULE_INT:
			case RULE_STRING:
			case 14:
			case 22:
			case 28:
			case 29:
			case 32:
			case 33:
			case 87:
			case 88:
			case 89:
			case 90:
			case 94:
			case 96:
			case 97:
			case 99:
			case 100:
			case 104:
			case 107:
			case 112:
				{
				alt60=2;
				}
				break;
			case 85:
				{
				alt60=3;
				}
				break;
			case 98:
				{
				alt60=4;
				}
				break;
			case 103:
				{
				alt60=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 60, 0, input);
				throw nvae;
			}
			switch (alt60) {
				case 1 :
					// InternalDsl.g:3663:6: lv_expression_1_1= ruleXJBranchingStatement
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXJSemicolonStatementAccess().getExpressionXJBranchingStatementParserRuleCall_1_0_0());
										}
					pushFollow(FOLLOW_61);
					lv_expression_1_1=ruleXJBranchingStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXJSemicolonStatementRule());
											}
											set(
												current,
												"expression",
												lv_expression_1_1,
												"jbase.Jbase.XJBranchingStatement");
											afterParserOrEnumRuleCall();
										}
					}
					break;
				case 2 :
					// InternalDsl.g:3679:6: lv_expression_1_2= ruleXExpressionOrVarDeclaration
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXJSemicolonStatementAccess().getExpressionXExpressionOrVarDeclarationParserRuleCall_1_0_1());
										}
					pushFollow(FOLLOW_61);
					lv_expression_1_2=ruleXExpressionOrVarDeclaration();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXJSemicolonStatementRule());
											}
											set(
												current,
												"expression",
												lv_expression_1_2,
												"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
											afterParserOrEnumRuleCall();
										}
					}
					break;
				case 3 :
					// InternalDsl.g:3695:6: lv_expression_1_3= ruleXDoWhileExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXJSemicolonStatementAccess().getExpressionXDoWhileExpressionParserRuleCall_1_0_2());
										}
					pushFollow(FOLLOW_61);
					lv_expression_1_3=ruleXDoWhileExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXJSemicolonStatementRule());
											}
											set(
												current,
												"expression",
												lv_expression_1_3,
												"jbase.Jbase.XDoWhileExpression");
											afterParserOrEnumRuleCall();
										}
					}
					break;
				case 4 :
					// InternalDsl.g:3711:6: lv_expression_1_4= ruleXReturnExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXJSemicolonStatementAccess().getExpressionXReturnExpressionParserRuleCall_1_0_3());
										}
					pushFollow(FOLLOW_61);
					lv_expression_1_4=ruleXReturnExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXJSemicolonStatementRule());
											}
											set(
												current,
												"expression",
												lv_expression_1_4,
												"org.eclipse.xtext.xbase.Xbase.XReturnExpression");
											afterParserOrEnumRuleCall();
										}
					}
					break;
				case 5 :
					// InternalDsl.g:3727:6: lv_expression_1_5= ruleXThrowExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXJSemicolonStatementAccess().getExpressionXThrowExpressionParserRuleCall_1_0_4());
										}
					pushFollow(FOLLOW_61);
					lv_expression_1_5=ruleXThrowExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXJSemicolonStatementRule());
											}
											set(
												current,
												"expression",
												lv_expression_1_5,
												"org.eclipse.xtext.xbase.Xbase.XThrowExpression");
											afterParserOrEnumRuleCall();
										}
					}
					break;

			}

			}

			}

			// InternalDsl.g:3745:3: ( ( ';' )=> (lv_semicolon_2_0= ';' ) )?
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==41) ) {
				int LA61_1 = input.LA(2);
				if ( (synpred9_InternalDsl()) ) {
					alt61=1;
				}
			}
			switch (alt61) {
				case 1 :
					// InternalDsl.g:3746:4: ( ';' )=> (lv_semicolon_2_0= ';' )
					{
					// InternalDsl.g:3747:4: (lv_semicolon_2_0= ';' )
					// InternalDsl.g:3748:5: lv_semicolon_2_0= ';'
					{
					lv_semicolon_2_0=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(lv_semicolon_2_0, grammarAccess.getXJSemicolonStatementAccess().getSemicolonSemicolonKeyword_2_0());
									}
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getXJSemicolonStatementRule());
										}
										setWithLastConsumed(current, "semicolon", lv_semicolon_2_0, ";");
									}
					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJSemicolonStatement"



	// $ANTLR start "entryRuleXJEmptyStatement"
	// InternalDsl.g:3764:1: entryRuleXJEmptyStatement returns [EObject current=null] :iv_ruleXJEmptyStatement= ruleXJEmptyStatement EOF ;
	public final EObject entryRuleXJEmptyStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJEmptyStatement =null;

		try {
			// InternalDsl.g:3764:57: (iv_ruleXJEmptyStatement= ruleXJEmptyStatement EOF )
			// InternalDsl.g:3765:2: iv_ruleXJEmptyStatement= ruleXJEmptyStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJEmptyStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJEmptyStatement=ruleXJEmptyStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJEmptyStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJEmptyStatement"



	// $ANTLR start "ruleXJEmptyStatement"
	// InternalDsl.g:3771:1: ruleXJEmptyStatement returns [EObject current=null] : ( () ( (lv_semicolon_1_0= ';' ) ) ) ;
	public final EObject ruleXJEmptyStatement() throws RecognitionException {
		EObject current = null;


		Token lv_semicolon_1_0=null;


			enterRule();

		try {
			// InternalDsl.g:3777:2: ( ( () ( (lv_semicolon_1_0= ';' ) ) ) )
			// InternalDsl.g:3778:2: ( () ( (lv_semicolon_1_0= ';' ) ) )
			{
			// InternalDsl.g:3778:2: ( () ( (lv_semicolon_1_0= ';' ) ) )
			// InternalDsl.g:3779:3: () ( (lv_semicolon_1_0= ';' ) )
			{
			// InternalDsl.g:3779:3: ()
			// InternalDsl.g:3780:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJEmptyStatementAccess().getXJSemicolonStatementAction_0(),
								current);
						}
			}

			// InternalDsl.g:3786:3: ( (lv_semicolon_1_0= ';' ) )
			// InternalDsl.g:3787:4: (lv_semicolon_1_0= ';' )
			{
			// InternalDsl.g:3787:4: (lv_semicolon_1_0= ';' )
			// InternalDsl.g:3788:5: lv_semicolon_1_0= ';'
			{
			lv_semicolon_1_0=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(lv_semicolon_1_0, grammarAccess.getXJEmptyStatementAccess().getSemicolonSemicolonKeyword_1_0());
							}
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXJEmptyStatementRule());
								}
								setWithLastConsumed(current, "semicolon", lv_semicolon_1_0, ";");
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJEmptyStatement"



	// $ANTLR start "entryRuleXJBranchingStatement"
	// InternalDsl.g:3804:1: entryRuleXJBranchingStatement returns [EObject current=null] :iv_ruleXJBranchingStatement= ruleXJBranchingStatement EOF ;
	public final EObject entryRuleXJBranchingStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJBranchingStatement =null;

		try {
			// InternalDsl.g:3804:61: (iv_ruleXJBranchingStatement= ruleXJBranchingStatement EOF )
			// InternalDsl.g:3805:2: iv_ruleXJBranchingStatement= ruleXJBranchingStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJBranchingStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJBranchingStatement=ruleXJBranchingStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJBranchingStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJBranchingStatement"



	// $ANTLR start "ruleXJBranchingStatement"
	// InternalDsl.g:3811:1: ruleXJBranchingStatement returns [EObject current=null] : ( ( () otherlv_1= 'continue' ) | ( () otherlv_3= 'break' ) ) ;
	public final EObject ruleXJBranchingStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;


			enterRule();

		try {
			// InternalDsl.g:3817:2: ( ( ( () otherlv_1= 'continue' ) | ( () otherlv_3= 'break' ) ) )
			// InternalDsl.g:3818:2: ( ( () otherlv_1= 'continue' ) | ( () otherlv_3= 'break' ) )
			{
			// InternalDsl.g:3818:2: ( ( () otherlv_1= 'continue' ) | ( () otherlv_3= 'break' ) )
			int alt62=2;
			int LA62_0 = input.LA(1);
			if ( (LA62_0==83) ) {
				alt62=1;
			}
			else if ( (LA62_0==79) ) {
				alt62=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 62, 0, input);
				throw nvae;
			}

			switch (alt62) {
				case 1 :
					// InternalDsl.g:3819:3: ( () otherlv_1= 'continue' )
					{
					// InternalDsl.g:3819:3: ( () otherlv_1= 'continue' )
					// InternalDsl.g:3820:4: () otherlv_1= 'continue'
					{
					// InternalDsl.g:3820:4: ()
					// InternalDsl.g:3821:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getXJBranchingStatementAccess().getXJContinueStatementAction_0_0(),
											current);
									}
					}

					otherlv_1=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_1, grammarAccess.getXJBranchingStatementAccess().getContinueKeyword_0_1());
								}
					}

					}
					break;
				case 2 :
					// InternalDsl.g:3833:3: ( () otherlv_3= 'break' )
					{
					// InternalDsl.g:3833:3: ( () otherlv_3= 'break' )
					// InternalDsl.g:3834:4: () otherlv_3= 'break'
					{
					// InternalDsl.g:3834:4: ()
					// InternalDsl.g:3835:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getXJBranchingStatementAccess().getXJBreakStatementAction_1_0(),
											current);
									}
					}

					otherlv_3=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_3, grammarAccess.getXJBranchingStatementAccess().getBreakKeyword_1_1());
								}
					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJBranchingStatement"



	// $ANTLR start "entryRuleXBlockExpression"
	// InternalDsl.g:3850:1: entryRuleXBlockExpression returns [EObject current=null] :iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
	public final EObject entryRuleXBlockExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBlockExpression =null;

		try {
			// InternalDsl.g:3850:57: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
			// InternalDsl.g:3851:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXBlockExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXBlockExpression=ruleXBlockExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXBlockExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXBlockExpression"



	// $ANTLR start "ruleXBlockExpression"
	// InternalDsl.g:3857:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )* otherlv_3= '}' ) ;
	public final EObject ruleXBlockExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		EObject lv_expressions_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:3863:2: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )* otherlv_3= '}' ) )
			// InternalDsl.g:3864:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )* otherlv_3= '}' )
			{
			// InternalDsl.g:3864:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )* otherlv_3= '}' )
			// InternalDsl.g:3865:3: () otherlv_1= '{' ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )* otherlv_3= '}'
			{
			// InternalDsl.g:3865:3: ()
			// InternalDsl.g:3866:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,107,FOLLOW_64); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
					}
			// InternalDsl.g:3876:3: ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )*
			loop63:
			while (true) {
				int alt63=2;
				int LA63_0 = input.LA(1);
				if ( ((LA63_0 >= RULE_CHARACTER && LA63_0 <= RULE_INT)||LA63_0==RULE_STRING||LA63_0==14||LA63_0==22||(LA63_0 >= 28 && LA63_0 <= 29)||(LA63_0 >= 32 && LA63_0 <= 33)||LA63_0==41||LA63_0==79||LA63_0==83||LA63_0==85||(LA63_0 >= 87 && LA63_0 <= 90)||(LA63_0 >= 92 && LA63_0 <= 94)||(LA63_0 >= 96 && LA63_0 <= 107)||LA63_0==112) ) {
					alt63=1;
				}

				switch (alt63) {
				case 1 :
					// InternalDsl.g:3877:4: (lv_expressions_2_0= ruleXJStatementOrBlock )
					{
					// InternalDsl.g:3877:4: (lv_expressions_2_0= ruleXJStatementOrBlock )
					// InternalDsl.g:3878:5: lv_expressions_2_0= ruleXJStatementOrBlock
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXJStatementOrBlockParserRuleCall_2_0());
									}
					pushFollow(FOLLOW_64);
					lv_expressions_2_0=ruleXJStatementOrBlock();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXBlockExpressionRule());
										}
										add(
											current,
											"expressions",
											lv_expressions_2_0,
											"jbase.Jbase.XJStatementOrBlock");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					break loop63;
				}
			}

			otherlv_3=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXBlockExpression"



	// $ANTLR start "entryRuleXVariableDeclaration"
	// InternalDsl.g:3903:1: entryRuleXVariableDeclaration returns [EObject current=null] :iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
	public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXVariableDeclaration =null;

		try {
			// InternalDsl.g:3903:61: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
			// InternalDsl.g:3904:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXVariableDeclarationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXVariableDeclaration=ruleXVariableDeclaration();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXVariableDeclaration; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXVariableDeclaration"



	// $ANTLR start "ruleXVariableDeclaration"
	// InternalDsl.g:3910:1: ruleXVariableDeclaration returns [EObject current=null] : ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) ) (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )? ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )* ) ;
	public final EObject ruleXVariableDeclaration() throws RecognitionException {
		EObject current = null;


		Token lv_final_1_0=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_type_2_0 =null;
		AntlrDatatypeRuleToken lv_name_3_0 =null;
		EObject lv_right_5_0 =null;
		EObject lv_additionalVariables_7_0 =null;


			enterRule();

		try {
			// InternalDsl.g:3916:2: ( ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) ) (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )? ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )* ) )
			// InternalDsl.g:3917:2: ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) ) (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )? ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )* )
			{
			// InternalDsl.g:3917:2: ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) ) (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )? ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )* )
			// InternalDsl.g:3918:3: ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) ) (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )? ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )*
			{
			// InternalDsl.g:3918:3: ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) )
			// InternalDsl.g:3919:4: ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) )
			{
			// InternalDsl.g:3939:4: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) )
			// InternalDsl.g:3940:5: () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) )
			{
			// InternalDsl.g:3940:5: ()
			// InternalDsl.g:3941:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXVariableDeclarationAccess().getXJVariableDeclarationAction_0_0_0(),
										current);
								}
			}

			// InternalDsl.g:3947:5: ( (lv_final_1_0= 'final' ) )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==90) ) {
				alt64=1;
			}
			switch (alt64) {
				case 1 :
					// InternalDsl.g:3948:6: (lv_final_1_0= 'final' )
					{
					// InternalDsl.g:3948:6: (lv_final_1_0= 'final' )
					// InternalDsl.g:3949:7: lv_final_1_0= 'final'
					{
					lv_final_1_0=(Token)match(input,90,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(lv_final_1_0, grammarAccess.getXVariableDeclarationAccess().getFinalFinalKeyword_0_0_1_0());
											}
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXVariableDeclarationRule());
												}
												setWithLastConsumed(current, "final", lv_final_1_0 != null, "final");
											}
					}

					}
					break;

			}

			// InternalDsl.g:3961:5: ( (lv_type_2_0= ruleJvmTypeReference ) )
			// InternalDsl.g:3962:6: (lv_type_2_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:3962:6: (lv_type_2_0= ruleJvmTypeReference )
			// InternalDsl.g:3963:7: lv_type_2_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_0_0_2_0());
									}
			pushFollow(FOLLOW_23);
			lv_type_2_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
										}
										set(
											current,
											"type",
											lv_type_2_0,
											"jbase.Jbase.JvmTypeReference");
										afterParserOrEnumRuleCall();
									}
			}

			}

			// InternalDsl.g:3980:5: ( (lv_name_3_0= ruleValidID ) )
			// InternalDsl.g:3981:6: (lv_name_3_0= ruleValidID )
			{
			// InternalDsl.g:3981:6: (lv_name_3_0= ruleValidID )
			// InternalDsl.g:3982:7: lv_name_3_0= ruleValidID
			{
			if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_0_0_3_0());
									}
			pushFollow(FOLLOW_65);
			lv_name_3_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
										}
										set(
											current,
											"name",
											lv_name_3_0,
											"org.eclipse.xtext.xbase.Xtype.ValidID");
										afterParserOrEnumRuleCall();
									}
			}

			}

			}

			}

			// InternalDsl.g:4001:3: (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==45) ) {
				alt65=1;
			}
			switch (alt65) {
				case 1 :
					// InternalDsl.g:4002:4: otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) )
					{
					otherlv_4=(Token)match(input,45,FOLLOW_66); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_4, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_1_0());
								}
					// InternalDsl.g:4006:4: ( (lv_right_5_0= ruleXExpression ) )
					// InternalDsl.g:4007:5: (lv_right_5_0= ruleXExpression )
					{
					// InternalDsl.g:4007:5: (lv_right_5_0= ruleXExpression )
					// InternalDsl.g:4008:6: lv_right_5_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_67);
					lv_right_5_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
											}
											set(
												current,
												"right",
												lv_right_5_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			// InternalDsl.g:4026:3: ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )*
			loop66:
			while (true) {
				int alt66=2;
				int LA66_0 = input.LA(1);
				if ( (LA66_0==31) ) {
					int LA66_2 = input.LA(2);
					if ( (LA66_2==RULE_ID) ) {
						int LA66_3 = input.LA(3);
						if ( (synpred11_InternalDsl()) ) {
							alt66=1;
						}

					}

				}

				switch (alt66) {
				case 1 :
					// InternalDsl.g:4027:4: ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) )
					{
					// InternalDsl.g:4027:4: ( ( ',' )=>otherlv_6= ',' )
					// InternalDsl.g:4028:5: ( ',' )=>otherlv_6= ','
					{
					otherlv_6=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getCommaKeyword_2_0());
									}
					}

					// InternalDsl.g:4034:4: ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) )
					// InternalDsl.g:4035:5: (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration )
					{
					// InternalDsl.g:4035:5: (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration )
					// InternalDsl.g:4036:6: lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getAdditionalVariablesXJAdditionalXVariableDeclarationParserRuleCall_2_1_0());
										}
					pushFollow(FOLLOW_67);
					lv_additionalVariables_7_0=ruleXJAdditionalXVariableDeclaration();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
											}
											add(
												current,
												"additionalVariables",
												lv_additionalVariables_7_0,
												"jbase.Jbase.XJAdditionalXVariableDeclaration");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop66;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXVariableDeclaration"



	// $ANTLR start "entryRuleXJAdditionalXVariableDeclaration"
	// InternalDsl.g:4058:1: entryRuleXJAdditionalXVariableDeclaration returns [EObject current=null] :iv_ruleXJAdditionalXVariableDeclaration= ruleXJAdditionalXVariableDeclaration EOF ;
	public final EObject entryRuleXJAdditionalXVariableDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJAdditionalXVariableDeclaration =null;

		try {
			// InternalDsl.g:4058:73: (iv_ruleXJAdditionalXVariableDeclaration= ruleXJAdditionalXVariableDeclaration EOF )
			// InternalDsl.g:4059:2: iv_ruleXJAdditionalXVariableDeclaration= ruleXJAdditionalXVariableDeclaration EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJAdditionalXVariableDeclarationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJAdditionalXVariableDeclaration=ruleXJAdditionalXVariableDeclaration();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJAdditionalXVariableDeclaration; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJAdditionalXVariableDeclaration"



	// $ANTLR start "ruleXJAdditionalXVariableDeclaration"
	// InternalDsl.g:4065:1: ruleXJAdditionalXVariableDeclaration returns [EObject current=null] : ( () ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )? ) ;
	public final EObject ruleXJAdditionalXVariableDeclaration() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;
		EObject lv_right_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:4071:2: ( ( () ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )? ) )
			// InternalDsl.g:4072:2: ( () ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )? )
			{
			// InternalDsl.g:4072:2: ( () ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )? )
			// InternalDsl.g:4073:3: () ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )?
			{
			// InternalDsl.g:4073:3: ()
			// InternalDsl.g:4074:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJAdditionalXVariableDeclarationAccess().getXJAdditionalXVariableDeclarationAction_0(),
								current);
						}
			}

			// InternalDsl.g:4080:3: ( (lv_name_1_0= ruleValidID ) )
			// InternalDsl.g:4081:4: (lv_name_1_0= ruleValidID )
			{
			// InternalDsl.g:4081:4: (lv_name_1_0= ruleValidID )
			// InternalDsl.g:4082:5: lv_name_1_0= ruleValidID
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJAdditionalXVariableDeclarationAccess().getNameValidIDParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_68);
			lv_name_1_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXJAdditionalXVariableDeclarationRule());
								}
								set(
									current,
									"name",
									lv_name_1_0,
									"org.eclipse.xtext.xbase.Xtype.ValidID");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:4099:3: (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )?
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==45) ) {
				alt67=1;
			}
			switch (alt67) {
				case 1 :
					// InternalDsl.g:4100:4: otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) )
					{
					otherlv_2=(Token)match(input,45,FOLLOW_66); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getXJAdditionalXVariableDeclarationAccess().getEqualsSignKeyword_2_0());
								}
					// InternalDsl.g:4104:4: ( (lv_right_3_0= ruleXExpression ) )
					// InternalDsl.g:4105:5: (lv_right_3_0= ruleXExpression )
					{
					// InternalDsl.g:4105:5: (lv_right_3_0= ruleXExpression )
					// InternalDsl.g:4106:6: lv_right_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXJAdditionalXVariableDeclarationAccess().getRightXExpressionParserRuleCall_2_1_0());
										}
					pushFollow(FOLLOW_2);
					lv_right_3_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXJAdditionalXVariableDeclarationRule());
											}
											set(
												current,
												"right",
												lv_right_3_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJAdditionalXVariableDeclaration"



	// $ANTLR start "entryRuleXAssignment"
	// InternalDsl.g:4128:1: entryRuleXAssignment returns [EObject current=null] :iv_ruleXAssignment= ruleXAssignment EOF ;
	public final EObject entryRuleXAssignment() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAssignment =null;

		try {
			// InternalDsl.g:4128:52: (iv_ruleXAssignment= ruleXAssignment EOF )
			// InternalDsl.g:4129:2: iv_ruleXAssignment= ruleXAssignment EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXAssignmentRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXAssignment=ruleXAssignment();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXAssignment; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXAssignment"



	// $ANTLR start "ruleXAssignment"
	// InternalDsl.g:4135:1: ruleXAssignment returns [EObject current=null] : ( ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) ) | (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? ) ) ;
	public final EObject ruleXAssignment() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		Token otherlv_16=null;
		Token otherlv_18=null;
		EObject lv_indexes_3_0 =null;
		EObject lv_indexes_6_0 =null;
		EObject lv_value_9_0 =null;
		EObject lv_value_13_0 =null;
		EObject this_XOrExpression_14 =null;
		EObject lv_then_17_0 =null;
		EObject lv_else_19_0 =null;
		EObject lv_rightOperand_22_0 =null;


			enterRule();

		try {
			// InternalDsl.g:4141:2: ( ( ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) ) | (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? ) ) )
			// InternalDsl.g:4142:2: ( ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) ) | (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? ) )
			{
			// InternalDsl.g:4142:2: ( ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) ) | (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? ) )
			int alt70=3;
			switch ( input.LA(1) ) {
			case RULE_ID:
				{
				int LA70_1 = input.LA(2);
				if ( (synpred12_InternalDsl()) ) {
					alt70=1;
				}
				else if ( (synpred13_InternalDsl()) ) {
					alt70=2;
				}
				else if ( (true) ) {
					alt70=3;
				}

				}
				break;
			case 87:
				{
				int LA70_2 = input.LA(2);
				if ( (synpred12_InternalDsl()) ) {
					alt70=1;
				}
				else if ( (synpred13_InternalDsl()) ) {
					alt70=2;
				}
				else if ( (true) ) {
					alt70=3;
				}

				}
				break;
			case 99:
				{
				int LA70_3 = input.LA(2);
				if ( (synpred12_InternalDsl()) ) {
					alt70=1;
				}
				else if ( (synpred13_InternalDsl()) ) {
					alt70=2;
				}
				else if ( (true) ) {
					alt70=3;
				}

				}
				break;
			case 94:
				{
				int LA70_4 = input.LA(2);
				if ( (synpred12_InternalDsl()) ) {
					alt70=1;
				}
				else if ( (synpred13_InternalDsl()) ) {
					alt70=2;
				}
				else if ( (true) ) {
					alt70=3;
				}

				}
				break;
			case 88:
				{
				int LA70_5 = input.LA(2);
				if ( (synpred12_InternalDsl()) ) {
					alt70=1;
				}
				else if ( (synpred13_InternalDsl()) ) {
					alt70=2;
				}
				else if ( (true) ) {
					alt70=3;
				}

				}
				break;
			case RULE_CHARACTER:
			case RULE_DECIMAL:
			case RULE_HEX:
			case RULE_INT:
			case RULE_STRING:
			case 14:
			case 22:
			case 28:
			case 29:
			case 32:
			case 33:
			case 89:
			case 96:
			case 97:
			case 100:
			case 104:
			case 107:
			case 112:
				{
				alt70=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 70, 0, input);
				throw nvae;
			}
			switch (alt70) {
				case 1 :
					// InternalDsl.g:4143:3: ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) )
					{
					// InternalDsl.g:4143:3: ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) )
					// InternalDsl.g:4144:4: ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) )
					{
					// InternalDsl.g:4144:4: ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) )
					// InternalDsl.g:4145:5: ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign )
					{
					// InternalDsl.g:4172:5: ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign )
					// InternalDsl.g:4173:6: () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign
					{
					// InternalDsl.g:4173:6: ()
					// InternalDsl.g:4174:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElement(
													grammarAccess.getXAssignmentAccess().getXJAssignmentAction_0_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:4180:6: ( ( ruleFeatureCallID ) )
					// InternalDsl.g:4181:7: ( ruleFeatureCallID )
					{
					// InternalDsl.g:4181:7: ( ruleFeatureCallID )
					// InternalDsl.g:4182:8: ruleFeatureCallID
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXAssignmentRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_0_0_1_0());
												}
					pushFollow(FOLLOW_43);
					ruleFeatureCallID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					otherlv_2=(Token)match(input,75,FOLLOW_66); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_2, grammarAccess.getXAssignmentAccess().getLeftSquareBracketKeyword_0_0_0_2());
										}
					// InternalDsl.g:4200:6: ( (lv_indexes_3_0= ruleXExpression ) )
					// InternalDsl.g:4201:7: (lv_indexes_3_0= ruleXExpression )
					{
					// InternalDsl.g:4201:7: (lv_indexes_3_0= ruleXExpression )
					// InternalDsl.g:4202:8: lv_indexes_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXAssignmentAccess().getIndexesXExpressionParserRuleCall_0_0_0_3_0());
												}
					pushFollow(FOLLOW_15);
					lv_indexes_3_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElementForParent(grammarAccess.getXAssignmentRule());
													}
													add(
														current,
														"indexes",
														lv_indexes_3_0,
														"org.eclipse.xtext.xbase.Xbase.XExpression");
													afterParserOrEnumRuleCall();
												}
					}

					}

					otherlv_4=(Token)match(input,76,FOLLOW_13); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_4, grammarAccess.getXAssignmentAccess().getRightSquareBracketKeyword_0_0_0_4());
										}
					// InternalDsl.g:4223:6: (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )*
					loop68:
					while (true) {
						int alt68=2;
						int LA68_0 = input.LA(1);
						if ( (LA68_0==75) ) {
							alt68=1;
						}

						switch (alt68) {
						case 1 :
							// InternalDsl.g:4224:7: otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']'
							{
							otherlv_5=(Token)match(input,75,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_5, grammarAccess.getXAssignmentAccess().getLeftSquareBracketKeyword_0_0_0_5_0());
													}
							// InternalDsl.g:4228:7: ( (lv_indexes_6_0= ruleXExpression ) )
							// InternalDsl.g:4229:8: (lv_indexes_6_0= ruleXExpression )
							{
							// InternalDsl.g:4229:8: (lv_indexes_6_0= ruleXExpression )
							// InternalDsl.g:4230:9: lv_indexes_6_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
																newCompositeNode(grammarAccess.getXAssignmentAccess().getIndexesXExpressionParserRuleCall_0_0_0_5_1_0());
															}
							pushFollow(FOLLOW_15);
							lv_indexes_6_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
																if (current==null) {
																	current = createModelElementForParent(grammarAccess.getXAssignmentRule());
																}
																add(
																	current,
																	"indexes",
																	lv_indexes_6_0,
																	"org.eclipse.xtext.xbase.Xbase.XExpression");
																afterParserOrEnumRuleCall();
															}
							}

							}

							otherlv_7=(Token)match(input,76,FOLLOW_13); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_7, grammarAccess.getXAssignmentAccess().getRightSquareBracketKeyword_0_0_0_5_2());
													}
							}
							break;

						default :
							break loop68;
						}
					}

					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_0_0_6());
										}
					pushFollow(FOLLOW_66);
					ruleOpSingleAssign();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:4261:4: ( (lv_value_9_0= ruleXAssignment ) )
					// InternalDsl.g:4262:5: (lv_value_9_0= ruleXAssignment )
					{
					// InternalDsl.g:4262:5: (lv_value_9_0= ruleXAssignment )
					// InternalDsl.g:4263:6: lv_value_9_0= ruleXAssignment
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_1_0());
										}
					pushFollow(FOLLOW_2);
					lv_value_9_0=ruleXAssignment();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXAssignmentRule());
											}
											set(
												current,
												"value",
												lv_value_9_0,
												"jbase.Jbase.XAssignment");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:4282:3: ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) )
					{
					// InternalDsl.g:4282:3: ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) )
					// InternalDsl.g:4283:4: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) )
					{
					// InternalDsl.g:4283:4: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
					// InternalDsl.g:4284:5: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					{
					// InternalDsl.g:4295:5: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					// InternalDsl.g:4296:6: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
					{
					// InternalDsl.g:4296:6: ()
					// InternalDsl.g:4297:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElement(
													grammarAccess.getXAssignmentAccess().getXAssignmentAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:4303:6: ( ( ruleFeatureCallID ) )
					// InternalDsl.g:4304:7: ( ruleFeatureCallID )
					{
					// InternalDsl.g:4304:7: ( ruleFeatureCallID )
					// InternalDsl.g:4305:8: ruleFeatureCallID
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXAssignmentRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_16);
					ruleFeatureCallID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_1_0_0_2());
										}
					pushFollow(FOLLOW_66);
					ruleOpSingleAssign();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:4328:4: ( (lv_value_13_0= ruleXAssignment ) )
					// InternalDsl.g:4329:5: (lv_value_13_0= ruleXAssignment )
					{
					// InternalDsl.g:4329:5: (lv_value_13_0= ruleXAssignment )
					// InternalDsl.g:4330:6: lv_value_13_0= ruleXAssignment
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_2);
					lv_value_13_0=ruleXAssignment();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXAssignmentRule());
											}
											set(
												current,
												"value",
												lv_value_13_0,
												"jbase.Jbase.XAssignment");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}

					}
					break;
				case 3 :
					// InternalDsl.g:4349:3: (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? )
					{
					// InternalDsl.g:4349:3: (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? )
					// InternalDsl.g:4350:4: this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )?
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_2_0());
								}
					pushFollow(FOLLOW_69);
					this_XOrExpression_14=ruleXOrExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XOrExpression_14;
									afterParserOrEnumRuleCall();
								}
					// InternalDsl.g:4358:4: ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )?
					int alt69=3;
					switch ( input.LA(1) ) {
						case 49:
							{
							int LA69_1 = input.LA(2);
							if ( (synpred14_InternalDsl()) ) {
								alt69=1;
							}
							}
							break;
						case 30:
							{
							int LA69_2 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt69=2;
							}
							}
							break;
						case 34:
							{
							int LA69_3 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt69=2;
							}
							}
							break;
						case 27:
							{
							int LA69_4 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt69=2;
							}
							}
							break;
						case 39:
							{
							int LA69_5 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt69=2;
							}
							}
							break;
						case 18:
							{
							int LA69_6 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt69=2;
							}
							}
							break;
						case 21:
							{
							int LA69_7 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt69=2;
							}
							}
							break;
						case 109:
							{
							int LA69_8 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt69=2;
							}
							}
							break;
						case 78:
							{
							int LA69_9 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt69=2;
							}
							}
							break;
						case 42:
							{
							int LA69_10 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt69=2;
							}
							}
							break;
						case 47:
							{
							int LA69_11 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt69=2;
							}
							}
							break;
					}
					switch (alt69) {
						case 1 :
							// InternalDsl.g:4359:5: ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) )
							{
							// InternalDsl.g:4359:5: ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) )
							// InternalDsl.g:4360:6: ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) )
							{
							// InternalDsl.g:4360:6: ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) )
							// InternalDsl.g:4361:7: ( ( () '?' ) )=> ( () otherlv_16= '?' )
							{
							// InternalDsl.g:4367:7: ( () otherlv_16= '?' )
							// InternalDsl.g:4368:8: () otherlv_16= '?'
							{
							// InternalDsl.g:4368:8: ()
							// InternalDsl.g:4369:9: 
							{
							if ( state.backtracking==0 ) {
																current = forceCreateModelElementAndSet(
																	grammarAccess.getXAssignmentAccess().getXJConditionalExpressionIfAction_2_1_0_0_0_0(),
																	current);
															}
							}

							otherlv_16=(Token)match(input,49,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(otherlv_16, grammarAccess.getXAssignmentAccess().getQuestionMarkKeyword_2_1_0_0_0_1());
														}
							}

							}

							// InternalDsl.g:4381:6: ( (lv_then_17_0= ruleXExpression ) )
							// InternalDsl.g:4382:7: (lv_then_17_0= ruleXExpression )
							{
							// InternalDsl.g:4382:7: (lv_then_17_0= ruleXExpression )
							// InternalDsl.g:4383:8: lv_then_17_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXAssignmentAccess().getThenXExpressionParserRuleCall_2_1_0_1_0());
														}
							pushFollow(FOLLOW_33);
							lv_then_17_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXAssignmentRule());
															}
															set(
																current,
																"then",
																lv_then_17_0,
																"org.eclipse.xtext.xbase.Xbase.XExpression");
															afterParserOrEnumRuleCall();
														}
							}

							}

							otherlv_18=(Token)match(input,40,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_18, grammarAccess.getXAssignmentAccess().getColonKeyword_2_1_0_2());
												}
							// InternalDsl.g:4404:6: ( (lv_else_19_0= ruleXExpression ) )
							// InternalDsl.g:4405:7: (lv_else_19_0= ruleXExpression )
							{
							// InternalDsl.g:4405:7: (lv_else_19_0= ruleXExpression )
							// InternalDsl.g:4406:8: lv_else_19_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXAssignmentAccess().getElseXExpressionParserRuleCall_2_1_0_3_0());
														}
							pushFollow(FOLLOW_2);
							lv_else_19_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXAssignmentRule());
															}
															set(
																current,
																"else",
																lv_else_19_0,
																"org.eclipse.xtext.xbase.Xbase.XExpression");
															afterParserOrEnumRuleCall();
														}
							}

							}

							}

							}
							break;
						case 2 :
							// InternalDsl.g:4425:5: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) )
							{
							// InternalDsl.g:4425:5: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) )
							// InternalDsl.g:4426:6: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) )
							{
							// InternalDsl.g:4426:6: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
							// InternalDsl.g:4427:7: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
							{
							// InternalDsl.g:4437:7: ( () ( ( ruleOpMultiAssign ) ) )
							// InternalDsl.g:4438:8: () ( ( ruleOpMultiAssign ) )
							{
							// InternalDsl.g:4438:8: ()
							// InternalDsl.g:4439:9: 
							{
							if ( state.backtracking==0 ) {
																current = forceCreateModelElementAndSet(
																	grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_2_1_1_0_0_0(),
																	current);
															}
							}

							// InternalDsl.g:4445:8: ( ( ruleOpMultiAssign ) )
							// InternalDsl.g:4446:9: ( ruleOpMultiAssign )
							{
							// InternalDsl.g:4446:9: ( ruleOpMultiAssign )
							// InternalDsl.g:4447:10: ruleOpMultiAssign
							{
							if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElement(grammarAccess.getXAssignmentRule());
																	}
																}
							if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_2_1_1_0_0_1_0());
																}
							pushFollow(FOLLOW_66);
							ruleOpMultiAssign();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
																	afterParserOrEnumRuleCall();
																}
							}

							}

							}

							}

							// InternalDsl.g:4463:6: ( (lv_rightOperand_22_0= ruleXAssignment ) )
							// InternalDsl.g:4464:7: (lv_rightOperand_22_0= ruleXAssignment )
							{
							// InternalDsl.g:4464:7: (lv_rightOperand_22_0= ruleXAssignment )
							// InternalDsl.g:4465:8: lv_rightOperand_22_0= ruleXAssignment
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_2_1_1_1_0());
														}
							pushFollow(FOLLOW_2);
							lv_rightOperand_22_0=ruleXAssignment();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXAssignmentRule());
															}
															set(
																current,
																"rightOperand",
																lv_rightOperand_22_0,
																"jbase.Jbase.XAssignment");
															afterParserOrEnumRuleCall();
														}
							}

							}

							}

							}
							break;

					}

					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXAssignment"



	// $ANTLR start "entryRuleOpMultiAssign"
	// InternalDsl.g:4489:1: entryRuleOpMultiAssign returns [String current=null] :iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
	public final String entryRuleOpMultiAssign() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpMultiAssign =null;

		try {
			// InternalDsl.g:4489:53: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
			// InternalDsl.g:4490:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpMultiAssignRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpMultiAssign=ruleOpMultiAssign();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpMultiAssign.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpMultiAssign"



	// $ANTLR start "ruleOpMultiAssign"
	// InternalDsl.g:4496:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' |kw= '&=' |kw= '|=' |kw= '^=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) ;
	public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:4502:2: ( (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' |kw= '&=' |kw= '|=' |kw= '^=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) )
			// InternalDsl.g:4503:2: (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' |kw= '&=' |kw= '|=' |kw= '^=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
			{
			// InternalDsl.g:4503:2: (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' |kw= '&=' |kw= '|=' |kw= '^=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
			int alt72=10;
			switch ( input.LA(1) ) {
			case 30:
				{
				alt72=1;
				}
				break;
			case 34:
				{
				alt72=2;
				}
				break;
			case 27:
				{
				alt72=3;
				}
				break;
			case 39:
				{
				alt72=4;
				}
				break;
			case 18:
				{
				alt72=5;
				}
				break;
			case 21:
				{
				alt72=6;
				}
				break;
			case 109:
				{
				alt72=7;
				}
				break;
			case 78:
				{
				alt72=8;
				}
				break;
			case 42:
				{
				alt72=9;
				}
				break;
			case 47:
				{
				alt72=10;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 72, 0, input);
				throw nvae;
			}
			switch (alt72) {
				case 1 :
					// InternalDsl.g:4504:3: kw= '+='
					{
					kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:4510:3: kw= '-='
					{
					kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalDsl.g:4516:3: kw= '*='
					{
					kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalDsl.g:4522:3: kw= '/='
					{
					kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalDsl.g:4528:3: kw= '%='
					{
					kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
							}
					}
					break;
				case 6 :
					// InternalDsl.g:4534:3: kw= '&='
					{
					kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAmpersandEqualsSignKeyword_5());
							}
					}
					break;
				case 7 :
					// InternalDsl.g:4540:3: kw= '|='
					{
					kw=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getVerticalLineEqualsSignKeyword_6());
							}
					}
					break;
				case 8 :
					// InternalDsl.g:4546:3: kw= '^='
					{
					kw=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getCircumflexAccentEqualsSignKeyword_7());
							}
					}
					break;
				case 9 :
					// InternalDsl.g:4552:3: (kw= '<' kw= '<' kw= '=' )
					{
					// InternalDsl.g:4552:3: (kw= '<' kw= '<' kw= '=' )
					// InternalDsl.g:4553:4: kw= '<' kw= '<' kw= '='
					{
					kw=(Token)match(input,42,FOLLOW_70); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_8_0());
								}
					kw=(Token)match(input,42,FOLLOW_16); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_8_1());
								}
					kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_8_2());
								}
					}

					}
					break;
				case 10 :
					// InternalDsl.g:4570:3: (kw= '>' (kw= '>' )? kw= '>=' )
					{
					// InternalDsl.g:4570:3: (kw= '>' (kw= '>' )? kw= '>=' )
					// InternalDsl.g:4571:4: kw= '>' (kw= '>' )? kw= '>='
					{
					kw=(Token)match(input,47,FOLLOW_71); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_9_0());
								}
					// InternalDsl.g:4576:4: (kw= '>' )?
					int alt71=2;
					int LA71_0 = input.LA(1);
					if ( (LA71_0==47) ) {
						alt71=1;
					}
					switch (alt71) {
						case 1 :
							// InternalDsl.g:4577:5: kw= '>'
							{
							kw=(Token)match(input,47,FOLLOW_72); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(kw);
												newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_9_1());
											}
							}
							break;

					}

					kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_9_2());
								}
					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpMultiAssign"



	// $ANTLR start "entryRuleXJFeatureCallWithArrayAccess"
	// InternalDsl.g:4593:1: entryRuleXJFeatureCallWithArrayAccess returns [EObject current=null] :iv_ruleXJFeatureCallWithArrayAccess= ruleXJFeatureCallWithArrayAccess EOF ;
	public final EObject entryRuleXJFeatureCallWithArrayAccess() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJFeatureCallWithArrayAccess =null;

		try {
			// InternalDsl.g:4593:69: (iv_ruleXJFeatureCallWithArrayAccess= ruleXJFeatureCallWithArrayAccess EOF )
			// InternalDsl.g:4594:2: iv_ruleXJFeatureCallWithArrayAccess= ruleXJFeatureCallWithArrayAccess EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJFeatureCallWithArrayAccessRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJFeatureCallWithArrayAccess=ruleXJFeatureCallWithArrayAccess();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJFeatureCallWithArrayAccess; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJFeatureCallWithArrayAccess"



	// $ANTLR start "ruleXJFeatureCallWithArrayAccess"
	// InternalDsl.g:<invalid or missing tree structure>
	public final EObject ruleXJFeatureCallWithArrayAccess() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		EObject this_XFeatureCall_0 =null;
		EObject lv_indexes_3_0 =null;
		EObject lv_indexes_6_0 =null;


			enterRule();

		try {
			// InternalDsl.g:<invalid or missing tree structure>
			// InternalDsl.g:<invalid or missing tree structure>
			{
			// InternalDsl.g:<invalid or missing tree structure>
			// InternalDsl.g:<invalid or missing tree structure>
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXJFeatureCallWithArrayAccessAccess().getXFeatureCallParserRuleCall_0());
					}
			pushFollow(FOLLOW_62);
			this_XFeatureCall_0=ruleXFeatureCall();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XFeatureCall_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:<invalid or missing tree structure>
			int alt74=2;
			alt74 = dfa74.predict(input);
			switch (alt74) {
				case 1 :
					// InternalDsl.g:<invalid or missing tree structure>
					{
					// InternalDsl.g:4641:4: ( () otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' ( ( ( '[' )=>otherlv_5= '[' ) ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* )
					// InternalDsl.g:4642:5: () otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' ( ( ( '[' )=>otherlv_5= '[' ) ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )*
					{
					// InternalDsl.g:4642:5: ()
					// InternalDsl.g:4643:6: 
					{
					if ( state.backtracking==0 ) {
											current = forceCreateModelElementAndSet(
												grammarAccess.getXJFeatureCallWithArrayAccessAccess().getXJArrayAccessExpressionArrayAction_1_0_0(),
												current);
										}
					}

					otherlv_2=(Token)match(input,75,FOLLOW_66); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_2, grammarAccess.getXJFeatureCallWithArrayAccessAccess().getLeftSquareBracketKeyword_1_0_1());
									}
					// InternalDsl.g:4653:5: ( (lv_indexes_3_0= ruleXExpression ) )
					// InternalDsl.g:4654:6: (lv_indexes_3_0= ruleXExpression )
					{
					// InternalDsl.g:4654:6: (lv_indexes_3_0= ruleXExpression )
					// InternalDsl.g:4655:7: lv_indexes_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXJFeatureCallWithArrayAccessAccess().getIndexesXExpressionParserRuleCall_1_0_2_0());
											}
					pushFollow(FOLLOW_15);
					lv_indexes_3_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXJFeatureCallWithArrayAccessRule());
												}
												add(
													current,
													"indexes",
													lv_indexes_3_0,
													"org.eclipse.xtext.xbase.Xbase.XExpression");
												afterParserOrEnumRuleCall();
											}
					}

					}

					otherlv_4=(Token)match(input,76,FOLLOW_62); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_4, grammarAccess.getXJFeatureCallWithArrayAccessAccess().getRightSquareBracketKeyword_1_0_3());
									}
					// InternalDsl.g:4676:5: ( ( ( '[' )=>otherlv_5= '[' ) ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )*
					loop73:
					while (true) {
						int alt73=2;
						alt73 = dfa73.predict(input);
						switch (alt73) {
						case 1 :
							// InternalDsl.g:4677:6: ( ( '[' )=>otherlv_5= '[' ) ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']'
							{
							// InternalDsl.g:4677:6: ( ( '[' )=>otherlv_5= '[' )
							// InternalDsl.g:4678:7: ( '[' )=>otherlv_5= '['
							{
							otherlv_5=(Token)match(input,75,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_5, grammarAccess.getXJFeatureCallWithArrayAccessAccess().getLeftSquareBracketKeyword_1_0_4_0());
													}
							}

							// InternalDsl.g:4684:6: ( (lv_indexes_6_0= ruleXExpression ) )
							// InternalDsl.g:4685:7: (lv_indexes_6_0= ruleXExpression )
							{
							// InternalDsl.g:4685:7: (lv_indexes_6_0= ruleXExpression )
							// InternalDsl.g:4686:8: lv_indexes_6_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXJFeatureCallWithArrayAccessAccess().getIndexesXExpressionParserRuleCall_1_0_4_1_0());
														}
							pushFollow(FOLLOW_15);
							lv_indexes_6_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXJFeatureCallWithArrayAccessRule());
															}
															add(
																current,
																"indexes",
																lv_indexes_6_0,
																"org.eclipse.xtext.xbase.Xbase.XExpression");
															afterParserOrEnumRuleCall();
														}
							}

							}

							otherlv_7=(Token)match(input,76,FOLLOW_62); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_7, grammarAccess.getXJFeatureCallWithArrayAccessAccess().getRightSquareBracketKeyword_1_0_4_2());
												}
							}
							break;

						default :
							break loop73;
						}
					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJFeatureCallWithArrayAccess"



	// $ANTLR start "entryRuleXFeatureCall"
	// InternalDsl.g:4714:1: entryRuleXFeatureCall returns [EObject current=null] :iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
	public final EObject entryRuleXFeatureCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXFeatureCall =null;

		try {
			// InternalDsl.g:4714:53: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
			// InternalDsl.g:4715:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXFeatureCallRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXFeatureCall=ruleXFeatureCall();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXFeatureCall; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXFeatureCall"



	// $ANTLR start "ruleXFeatureCall"
	// InternalDsl.g:4721:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )? ) ;
	public final EObject ruleXFeatureCall() throws RecognitionException {
		EObject current = null;


		Token lv_explicitOperationCall_2_0=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_featureCallArguments_3_0 =null;
		EObject lv_featureCallArguments_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:4727:2: ( ( () ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )? ) )
			// InternalDsl.g:4728:2: ( () ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )? )
			{
			// InternalDsl.g:4728:2: ( () ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )? )
			// InternalDsl.g:4729:3: () ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )?
			{
			// InternalDsl.g:4729:3: ()
			// InternalDsl.g:4730:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
								current);
						}
			}

			// InternalDsl.g:4736:3: ( ( ruleIdOrSuper ) )
			// InternalDsl.g:4737:4: ( ruleIdOrSuper )
			{
			// InternalDsl.g:4737:4: ( ruleIdOrSuper )
			// InternalDsl.g:4738:5: ruleIdOrSuper
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXFeatureCallRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0());
							}
			pushFollow(FOLLOW_57);
			ruleIdOrSuper();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:4752:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )?
			int alt77=2;
			alt77 = dfa77.predict(input);
			switch (alt77) {
				case 1 :
					// InternalDsl.g:4753:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')'
					{
					// InternalDsl.g:4753:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) )
					// InternalDsl.g:4754:5: ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' )
					{
					// InternalDsl.g:4758:5: (lv_explicitOperationCall_2_0= '(' )
					// InternalDsl.g:4759:6: lv_explicitOperationCall_2_0= '('
					{
					lv_explicitOperationCall_2_0=(Token)match(input,22,FOLLOW_73); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_explicitOperationCall_2_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_2_0_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXFeatureCallRule());
											}
											setWithLastConsumed(current, "explicitOperationCall", lv_explicitOperationCall_2_0 != null, "(");
										}
					}

					}

					// InternalDsl.g:4771:4: ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )?
					int alt76=2;
					int LA76_0 = input.LA(1);
					if ( ((LA76_0 >= RULE_CHARACTER && LA76_0 <= RULE_INT)||LA76_0==RULE_STRING||LA76_0==14||LA76_0==22||(LA76_0 >= 28 && LA76_0 <= 29)||(LA76_0 >= 32 && LA76_0 <= 33)||(LA76_0 >= 87 && LA76_0 <= 89)||LA76_0==94||(LA76_0 >= 96 && LA76_0 <= 97)||(LA76_0 >= 99 && LA76_0 <= 100)||LA76_0==104||LA76_0==107||LA76_0==112) ) {
						alt76=1;
					}
					switch (alt76) {
						case 1 :
							// InternalDsl.g:4772:5: ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )*
							{
							// InternalDsl.g:4772:5: ( (lv_featureCallArguments_3_0= ruleXExpression ) )
							// InternalDsl.g:4773:6: (lv_featureCallArguments_3_0= ruleXExpression )
							{
							// InternalDsl.g:4773:6: (lv_featureCallArguments_3_0= ruleXExpression )
							// InternalDsl.g:4774:7: lv_featureCallArguments_3_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_0_0());
													}
							pushFollow(FOLLOW_26);
							lv_featureCallArguments_3_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
														}
														add(
															current,
															"featureCallArguments",
															lv_featureCallArguments_3_0,
															"org.eclipse.xtext.xbase.Xbase.XExpression");
														afterParserOrEnumRuleCall();
													}
							}

							}

							// InternalDsl.g:4791:5: (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )*
							loop75:
							while (true) {
								int alt75=2;
								int LA75_0 = input.LA(1);
								if ( (LA75_0==31) ) {
									alt75=1;
								}

								switch (alt75) {
								case 1 :
									// InternalDsl.g:4792:6: otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) )
									{
									otherlv_4=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_1_1_0());
														}
									// InternalDsl.g:4796:6: ( (lv_featureCallArguments_5_0= ruleXExpression ) )
									// InternalDsl.g:4797:7: (lv_featureCallArguments_5_0= ruleXExpression )
									{
									// InternalDsl.g:4797:7: (lv_featureCallArguments_5_0= ruleXExpression )
									// InternalDsl.g:4798:8: lv_featureCallArguments_5_0= ruleXExpression
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_1_1_0());
																}
									pushFollow(FOLLOW_26);
									lv_featureCallArguments_5_0=ruleXExpression();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
																	}
																	add(
																		current,
																		"featureCallArguments",
																		lv_featureCallArguments_5_0,
																		"org.eclipse.xtext.xbase.Xbase.XExpression");
																	afterParserOrEnumRuleCall();
																}
									}

									}

									}
									break;

								default :
									break loop75;
								}
							}

							}
							break;

					}

					otherlv_6=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_2_2());
								}
					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXFeatureCall"



	// $ANTLR start "entryRuleXConstructorCall"
	// InternalDsl.g:4826:1: entryRuleXConstructorCall returns [EObject current=null] :iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
	public final EObject entryRuleXConstructorCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXConstructorCall =null;

		try {
			// InternalDsl.g:4826:57: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
			// InternalDsl.g:4827:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXConstructorCallRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXConstructorCall=ruleXConstructorCall();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXConstructorCall; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXConstructorCall"



	// $ANTLR start "ruleXConstructorCall"
	// InternalDsl.g:4833:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )? ) ;
	public final EObject ruleXConstructorCall() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token lv_explicitTypeArguments_3_0=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		Token lv_explicitConstructorCall_8_0=null;
		Token otherlv_10=null;
		Token otherlv_12=null;
		EObject lv_typeArguments_4_0 =null;
		EObject lv_typeArguments_6_0 =null;
		EObject lv_arguments_9_0 =null;
		EObject lv_arguments_11_0 =null;


			enterRule();

		try {
			// InternalDsl.g:4839:2: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )? ) )
			// InternalDsl.g:4840:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )? )
			{
			// InternalDsl.g:4840:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )? )
			// InternalDsl.g:4841:3: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )?
			{
			// InternalDsl.g:4841:3: ()
			// InternalDsl.g:4842:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXConstructorCallAccess().getXJConstructorCallAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,96,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
					}
			// InternalDsl.g:4852:3: ( ( ruleQualifiedName ) )
			// InternalDsl.g:4853:4: ( ruleQualifiedName )
			{
			// InternalDsl.g:4853:4: ( ruleQualifiedName )
			// InternalDsl.g:4854:5: ruleQualifiedName
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXConstructorCallRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0());
							}
			pushFollow(FOLLOW_74);
			ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:4868:3: ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )?
			int alt80=2;
			alt80 = dfa80.predict(input);
			switch (alt80) {
				case 1 :
					// InternalDsl.g:4869:4: ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>'
					{
					// InternalDsl.g:4869:4: ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) )
					// InternalDsl.g:4870:5: ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' )
					{
					// InternalDsl.g:4874:5: (lv_explicitTypeArguments_3_0= '<' )
					// InternalDsl.g:4875:6: lv_explicitTypeArguments_3_0= '<'
					{
					lv_explicitTypeArguments_3_0=(Token)match(input,42,FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_explicitTypeArguments_3_0, grammarAccess.getXConstructorCallAccess().getExplicitTypeArgumentsLessThanSignKeyword_3_0_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXConstructorCallRule());
											}
											setWithLastConsumed(current, "explicitTypeArguments", lv_explicitTypeArguments_3_0 != null, "<");
										}
					}

					}

					// InternalDsl.g:4887:4: ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )?
					int alt79=2;
					int LA79_0 = input.LA(1);
					if ( (LA79_0==RULE_ID||LA79_0==49) ) {
						alt79=1;
					}
					switch (alt79) {
						case 1 :
							// InternalDsl.g:4888:5: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
							{
							// InternalDsl.g:4888:5: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
							// InternalDsl.g:4889:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
							{
							// InternalDsl.g:4889:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
							// InternalDsl.g:4890:7: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0_0());
													}
							pushFollow(FOLLOW_76);
							lv_typeArguments_4_0=ruleJvmArgumentTypeReference();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
														}
														add(
															current,
															"typeArguments",
															lv_typeArguments_4_0,
															"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
														afterParserOrEnumRuleCall();
													}
							}

							}

							// InternalDsl.g:4907:5: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
							loop78:
							while (true) {
								int alt78=2;
								int LA78_0 = input.LA(1);
								if ( (LA78_0==31) ) {
									alt78=1;
								}

								switch (alt78) {
								case 1 :
									// InternalDsl.g:4908:6: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
									{
									otherlv_5=(Token)match(input,31,FOLLOW_77); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_1_1_0());
														}
									// InternalDsl.g:4912:6: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
									// InternalDsl.g:4913:7: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
									{
									// InternalDsl.g:4913:7: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
									// InternalDsl.g:4914:8: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_1_1_0());
																}
									pushFollow(FOLLOW_76);
									lv_typeArguments_6_0=ruleJvmArgumentTypeReference();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
																	}
																	add(
																		current,
																		"typeArguments",
																		lv_typeArguments_6_0,
																		"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
																	afterParserOrEnumRuleCall();
																}
									}

									}

									}
									break;

								default :
									break loop78;
								}
							}

							}
							break;

					}

					otherlv_7=(Token)match(input,47,FOLLOW_57); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_2());
								}
					}
					break;

			}

			// InternalDsl.g:4938:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )?
			int alt83=2;
			alt83 = dfa83.predict(input);
			switch (alt83) {
				case 1 :
					// InternalDsl.g:4939:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')'
					{
					// InternalDsl.g:4939:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) )
					// InternalDsl.g:4940:5: ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' )
					{
					// InternalDsl.g:4944:5: (lv_explicitConstructorCall_8_0= '(' )
					// InternalDsl.g:4945:6: lv_explicitConstructorCall_8_0= '('
					{
					lv_explicitConstructorCall_8_0=(Token)match(input,22,FOLLOW_73); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_explicitConstructorCall_8_0, grammarAccess.getXConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXConstructorCallRule());
											}
											setWithLastConsumed(current, "explicitConstructorCall", lv_explicitConstructorCall_8_0 != null, "(");
										}
					}

					}

					// InternalDsl.g:4957:4: ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )?
					int alt82=2;
					int LA82_0 = input.LA(1);
					if ( ((LA82_0 >= RULE_CHARACTER && LA82_0 <= RULE_INT)||LA82_0==RULE_STRING||LA82_0==14||LA82_0==22||(LA82_0 >= 28 && LA82_0 <= 29)||(LA82_0 >= 32 && LA82_0 <= 33)||(LA82_0 >= 87 && LA82_0 <= 89)||LA82_0==94||(LA82_0 >= 96 && LA82_0 <= 97)||(LA82_0 >= 99 && LA82_0 <= 100)||LA82_0==104||LA82_0==107||LA82_0==112) ) {
						alt82=1;
					}
					switch (alt82) {
						case 1 :
							// InternalDsl.g:4958:5: ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )*
							{
							// InternalDsl.g:4958:5: ( (lv_arguments_9_0= ruleXExpression ) )
							// InternalDsl.g:4959:6: (lv_arguments_9_0= ruleXExpression )
							{
							// InternalDsl.g:4959:6: (lv_arguments_9_0= ruleXExpression )
							// InternalDsl.g:4960:7: lv_arguments_9_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_0_0());
													}
							pushFollow(FOLLOW_26);
							lv_arguments_9_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
														}
														add(
															current,
															"arguments",
															lv_arguments_9_0,
															"org.eclipse.xtext.xbase.Xbase.XExpression");
														afterParserOrEnumRuleCall();
													}
							}

							}

							// InternalDsl.g:4977:5: (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )*
							loop81:
							while (true) {
								int alt81=2;
								int LA81_0 = input.LA(1);
								if ( (LA81_0==31) ) {
									alt81=1;
								}

								switch (alt81) {
								case 1 :
									// InternalDsl.g:4978:6: otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) )
									{
									otherlv_10=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_10, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_1_0());
														}
									// InternalDsl.g:4982:6: ( (lv_arguments_11_0= ruleXExpression ) )
									// InternalDsl.g:4983:7: (lv_arguments_11_0= ruleXExpression )
									{
									// InternalDsl.g:4983:7: (lv_arguments_11_0= ruleXExpression )
									// InternalDsl.g:4984:8: lv_arguments_11_0= ruleXExpression
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_0());
																}
									pushFollow(FOLLOW_26);
									lv_arguments_11_0=ruleXExpression();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
																	}
																	add(
																		current,
																		"arguments",
																		lv_arguments_11_0,
																		"org.eclipse.xtext.xbase.Xbase.XExpression");
																	afterParserOrEnumRuleCall();
																}
									}

									}

									}
									break;

								default :
									break loop81;
								}
							}

							}
							break;

					}

					otherlv_12=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_12, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2());
								}
					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXConstructorCall"



	// $ANTLR start "entryRuleXJArrayConstructorCall"
	// InternalDsl.g:5012:1: entryRuleXJArrayConstructorCall returns [EObject current=null] :iv_ruleXJArrayConstructorCall= ruleXJArrayConstructorCall EOF ;
	public final EObject entryRuleXJArrayConstructorCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJArrayConstructorCall =null;

		try {
			// InternalDsl.g:5012:63: (iv_ruleXJArrayConstructorCall= ruleXJArrayConstructorCall EOF )
			// InternalDsl.g:5013:2: iv_ruleXJArrayConstructorCall= ruleXJArrayConstructorCall EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJArrayConstructorCallRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJArrayConstructorCall=ruleXJArrayConstructorCall();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJArrayConstructorCall; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJArrayConstructorCall"



	// $ANTLR start "ruleXJArrayConstructorCall"
	// InternalDsl.g:5019:1: ruleXJArrayConstructorCall returns [EObject current=null] : ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) ) ( (lv_indexes_4_0= ruleXExpression ) )? otherlv_5= ']' ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )* ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )? ) ;
	public final EObject ruleXJArrayConstructorCall() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_5=null;
		Token otherlv_8=null;
		EObject lv_dimensions_3_0 =null;
		EObject lv_indexes_4_0 =null;
		EObject lv_dimensions_6_0 =null;
		EObject lv_indexes_7_0 =null;
		EObject lv_arrayLiteral_9_0 =null;


			enterRule();

		try {
			// InternalDsl.g:5025:2: ( ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) ) ( (lv_indexes_4_0= ruleXExpression ) )? otherlv_5= ']' ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )* ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )? ) )
			// InternalDsl.g:5026:2: ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) ) ( (lv_indexes_4_0= ruleXExpression ) )? otherlv_5= ']' ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )* ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )? )
			{
			// InternalDsl.g:5026:2: ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) ) ( (lv_indexes_4_0= ruleXExpression ) )? otherlv_5= ']' ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )* ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )? )
			// InternalDsl.g:5027:3: ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) ) ( (lv_indexes_4_0= ruleXExpression ) )? otherlv_5= ']' ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )* ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )?
			{
			// InternalDsl.g:5027:3: ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) )
			// InternalDsl.g:5028:4: ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) )
			{
			// InternalDsl.g:5044:4: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) )
			// InternalDsl.g:5045:5: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) )
			{
			// InternalDsl.g:5045:5: ()
			// InternalDsl.g:5046:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXJArrayConstructorCallAccess().getXJArrayConstructorCallAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,96,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXJArrayConstructorCallAccess().getNewKeyword_0_0_1());
							}
			// InternalDsl.g:5056:5: ( ( ruleQualifiedName ) )
			// InternalDsl.g:5057:6: ( ruleQualifiedName )
			{
			// InternalDsl.g:5057:6: ( ruleQualifiedName )
			// InternalDsl.g:5058:7: ruleQualifiedName
			{
			if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getXJArrayConstructorCallRule());
										}
									}
			if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXJArrayConstructorCallAccess().getTypeJvmTypeCrossReference_0_0_2_0());
									}
			pushFollow(FOLLOW_43);
			ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
										afterParserOrEnumRuleCall();
									}
			}

			}

			// InternalDsl.g:5072:5: ( (lv_dimensions_3_0= ruleXJArrayDimension ) )
			// InternalDsl.g:5073:6: (lv_dimensions_3_0= ruleXJArrayDimension )
			{
			// InternalDsl.g:5073:6: (lv_dimensions_3_0= ruleXJArrayDimension )
			// InternalDsl.g:5074:7: lv_dimensions_3_0= ruleXJArrayDimension
			{
			if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXJArrayConstructorCallAccess().getDimensionsXJArrayDimensionParserRuleCall_0_0_3_0());
									}
			pushFollow(FOLLOW_78);
			lv_dimensions_3_0=ruleXJArrayDimension();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXJArrayConstructorCallRule());
										}
										add(
											current,
											"dimensions",
											lv_dimensions_3_0,
											"jbase.Jbase.XJArrayDimension");
										afterParserOrEnumRuleCall();
									}
			}

			}

			}

			}

			// InternalDsl.g:5093:3: ( (lv_indexes_4_0= ruleXExpression ) )?
			int alt84=2;
			int LA84_0 = input.LA(1);
			if ( ((LA84_0 >= RULE_CHARACTER && LA84_0 <= RULE_INT)||LA84_0==RULE_STRING||LA84_0==14||LA84_0==22||(LA84_0 >= 28 && LA84_0 <= 29)||(LA84_0 >= 32 && LA84_0 <= 33)||(LA84_0 >= 87 && LA84_0 <= 89)||LA84_0==94||(LA84_0 >= 96 && LA84_0 <= 97)||(LA84_0 >= 99 && LA84_0 <= 100)||LA84_0==104||LA84_0==107||LA84_0==112) ) {
				alt84=1;
			}
			switch (alt84) {
				case 1 :
					// InternalDsl.g:5094:4: (lv_indexes_4_0= ruleXExpression )
					{
					// InternalDsl.g:5094:4: (lv_indexes_4_0= ruleXExpression )
					// InternalDsl.g:5095:5: lv_indexes_4_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXJArrayConstructorCallAccess().getIndexesXExpressionParserRuleCall_1_0());
									}
					pushFollow(FOLLOW_15);
					lv_indexes_4_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXJArrayConstructorCallRule());
										}
										add(
											current,
											"indexes",
											lv_indexes_4_0,
											"org.eclipse.xtext.xbase.Xbase.XExpression");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			otherlv_5=(Token)match(input,76,FOLLOW_79); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getXJArrayConstructorCallAccess().getRightSquareBracketKeyword_2());
					}
			// InternalDsl.g:5116:3: ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )*
			loop86:
			while (true) {
				int alt86=2;
				alt86 = dfa86.predict(input);
				switch (alt86) {
				case 1 :
					// InternalDsl.g:5117:4: ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']'
					{
					// InternalDsl.g:5117:4: ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) )
					// InternalDsl.g:5118:5: ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension )
					{
					// InternalDsl.g:5122:5: (lv_dimensions_6_0= ruleXJArrayDimension )
					// InternalDsl.g:5123:6: lv_dimensions_6_0= ruleXJArrayDimension
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXJArrayConstructorCallAccess().getDimensionsXJArrayDimensionParserRuleCall_3_0_0());
										}
					pushFollow(FOLLOW_78);
					lv_dimensions_6_0=ruleXJArrayDimension();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXJArrayConstructorCallRule());
											}
											add(
												current,
												"dimensions",
												lv_dimensions_6_0,
												"jbase.Jbase.XJArrayDimension");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:5140:4: ( (lv_indexes_7_0= ruleXExpression ) )?
					int alt85=2;
					int LA85_0 = input.LA(1);
					if ( ((LA85_0 >= RULE_CHARACTER && LA85_0 <= RULE_INT)||LA85_0==RULE_STRING||LA85_0==14||LA85_0==22||(LA85_0 >= 28 && LA85_0 <= 29)||(LA85_0 >= 32 && LA85_0 <= 33)||(LA85_0 >= 87 && LA85_0 <= 89)||LA85_0==94||(LA85_0 >= 96 && LA85_0 <= 97)||(LA85_0 >= 99 && LA85_0 <= 100)||LA85_0==104||LA85_0==107||LA85_0==112) ) {
						alt85=1;
					}
					switch (alt85) {
						case 1 :
							// InternalDsl.g:5141:5: (lv_indexes_7_0= ruleXExpression )
							{
							// InternalDsl.g:5141:5: (lv_indexes_7_0= ruleXExpression )
							// InternalDsl.g:5142:6: lv_indexes_7_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXJArrayConstructorCallAccess().getIndexesXExpressionParserRuleCall_3_1_0());
												}
							pushFollow(FOLLOW_15);
							lv_indexes_7_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElementForParent(grammarAccess.getXJArrayConstructorCallRule());
													}
													add(
														current,
														"indexes",
														lv_indexes_7_0,
														"org.eclipse.xtext.xbase.Xbase.XExpression");
													afterParserOrEnumRuleCall();
												}
							}

							}
							break;

					}

					otherlv_8=(Token)match(input,76,FOLLOW_79); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_8, grammarAccess.getXJArrayConstructorCallAccess().getRightSquareBracketKeyword_3_2());
								}
					}
					break;

				default :
					break loop86;
				}
			}

			// InternalDsl.g:5164:3: ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )?
			int alt87=2;
			alt87 = dfa87.predict(input);
			switch (alt87) {
				case 1 :
					// InternalDsl.g:5165:4: ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral )
					{
					// InternalDsl.g:5169:4: (lv_arrayLiteral_9_0= ruleXJArrayLiteral )
					// InternalDsl.g:5170:5: lv_arrayLiteral_9_0= ruleXJArrayLiteral
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXJArrayConstructorCallAccess().getArrayLiteralXJArrayLiteralParserRuleCall_4_0());
									}
					pushFollow(FOLLOW_2);
					lv_arrayLiteral_9_0=ruleXJArrayLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXJArrayConstructorCallRule());
										}
										set(
											current,
											"arrayLiteral",
											lv_arrayLiteral_9_0,
											"jbase.Jbase.XJArrayLiteral");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJArrayConstructorCall"



	// $ANTLR start "entryRuleXJArrayDimension"
	// InternalDsl.g:5191:1: entryRuleXJArrayDimension returns [EObject current=null] :iv_ruleXJArrayDimension= ruleXJArrayDimension EOF ;
	public final EObject entryRuleXJArrayDimension() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJArrayDimension =null;

		try {
			// InternalDsl.g:5191:57: (iv_ruleXJArrayDimension= ruleXJArrayDimension EOF )
			// InternalDsl.g:5192:2: iv_ruleXJArrayDimension= ruleXJArrayDimension EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJArrayDimensionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJArrayDimension=ruleXJArrayDimension();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJArrayDimension; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJArrayDimension"



	// $ANTLR start "ruleXJArrayDimension"
	// InternalDsl.g:5198:1: ruleXJArrayDimension returns [EObject current=null] : ( () otherlv_1= '[' ) ;
	public final EObject ruleXJArrayDimension() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;


			enterRule();

		try {
			// InternalDsl.g:5204:2: ( ( () otherlv_1= '[' ) )
			// InternalDsl.g:5205:2: ( () otherlv_1= '[' )
			{
			// InternalDsl.g:5205:2: ( () otherlv_1= '[' )
			// InternalDsl.g:5206:3: () otherlv_1= '['
			{
			// InternalDsl.g:5206:3: ()
			// InternalDsl.g:5207:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJArrayDimensionAccess().getXJArrayDimensionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXJArrayDimensionAccess().getLeftSquareBracketKeyword_1());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJArrayDimension"



	// $ANTLR start "entryRuleXCastedExpression"
	// InternalDsl.g:5221:1: entryRuleXCastedExpression returns [EObject current=null] :iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
	public final EObject entryRuleXCastedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCastedExpression =null;

		try {
			// InternalDsl.g:5221:58: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
			// InternalDsl.g:5222:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXCastedExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXCastedExpression=ruleXCastedExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXCastedExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXCastedExpression"



	// $ANTLR start "ruleXCastedExpression"
	// InternalDsl.g:5228:1: ruleXCastedExpression returns [EObject current=null] : ( ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) ) |this_XPostfixOperation_5= ruleXPostfixOperation ) ;
	public final EObject ruleXCastedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		EObject lv_type_2_0 =null;
		EObject lv_target_4_0 =null;
		EObject this_XPostfixOperation_5 =null;


			enterRule();

		try {
			// InternalDsl.g:5234:2: ( ( ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) ) |this_XPostfixOperation_5= ruleXPostfixOperation ) )
			// InternalDsl.g:5235:2: ( ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) ) |this_XPostfixOperation_5= ruleXPostfixOperation )
			{
			// InternalDsl.g:5235:2: ( ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) ) |this_XPostfixOperation_5= ruleXPostfixOperation )
			int alt88=2;
			int LA88_0 = input.LA(1);
			if ( (LA88_0==22) ) {
				int LA88_1 = input.LA(2);
				if ( (synpred25_InternalDsl()) ) {
					alt88=1;
				}
				else if ( (true) ) {
					alt88=2;
				}

			}
			else if ( ((LA88_0 >= RULE_CHARACTER && LA88_0 <= RULE_INT)||LA88_0==RULE_STRING||LA88_0==29||LA88_0==33||(LA88_0 >= 87 && LA88_0 <= 89)||LA88_0==94||(LA88_0 >= 96 && LA88_0 <= 97)||(LA88_0 >= 99 && LA88_0 <= 100)||LA88_0==104||LA88_0==107) ) {
				alt88=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 88, 0, input);
				throw nvae;
			}

			switch (alt88) {
				case 1 :
					// InternalDsl.g:5236:3: ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) )
					{
					// InternalDsl.g:5236:3: ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) )
					// InternalDsl.g:5237:4: ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) )
					{
					// InternalDsl.g:5254:4: ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) )
					// InternalDsl.g:5255:5: () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) )
					{
					// InternalDsl.g:5255:5: ()
					// InternalDsl.g:5256:6: 
					{
					if ( state.backtracking==0 ) {
											current = forceCreateModelElement(
												grammarAccess.getXCastedExpressionAccess().getXCastedExpressionAction_0_0_0(),
												current);
										}
					}

					otherlv_1=(Token)match(input,22,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_1, grammarAccess.getXCastedExpressionAccess().getLeftParenthesisKeyword_0_0_1());
									}
					// InternalDsl.g:5266:5: ( (lv_type_2_0= ruleJvmTypeReference ) )
					// InternalDsl.g:5267:6: (lv_type_2_0= ruleJvmTypeReference )
					{
					// InternalDsl.g:5267:6: (lv_type_2_0= ruleJvmTypeReference )
					// InternalDsl.g:5268:7: lv_type_2_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_0_0_2_0());
											}
					pushFollow(FOLLOW_8);
					lv_type_2_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
												}
												set(
													current,
													"type",
													lv_type_2_0,
													"jbase.Jbase.JvmTypeReference");
												afterParserOrEnumRuleCall();
											}
					}

					}

					otherlv_3=(Token)match(input,25,FOLLOW_66); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_3, grammarAccess.getXCastedExpressionAccess().getRightParenthesisKeyword_0_0_3());
									}
					// InternalDsl.g:5289:5: ( (lv_target_4_0= ruleXExpression ) )
					// InternalDsl.g:5290:6: (lv_target_4_0= ruleXExpression )
					{
					// InternalDsl.g:5290:6: (lv_target_4_0= ruleXExpression )
					// InternalDsl.g:5291:7: lv_target_4_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTargetXExpressionParserRuleCall_0_0_4_0());
											}
					pushFollow(FOLLOW_2);
					lv_target_4_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
												}
												set(
													current,
													"target",
													lv_target_4_0,
													"org.eclipse.xtext.xbase.Xbase.XExpression");
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:5311:3: this_XPostfixOperation_5= ruleXPostfixOperation
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXPostfixOperationParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XPostfixOperation_5=ruleXPostfixOperation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XPostfixOperation_5;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXCastedExpression"



	// $ANTLR start "entryRuleXPostfixOperation"
	// InternalDsl.g:5323:1: entryRuleXPostfixOperation returns [EObject current=null] :iv_ruleXPostfixOperation= ruleXPostfixOperation EOF ;
	public final EObject entryRuleXPostfixOperation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXPostfixOperation =null;

		try {
			// InternalDsl.g:5323:58: (iv_ruleXPostfixOperation= ruleXPostfixOperation EOF )
			// InternalDsl.g:5324:2: iv_ruleXPostfixOperation= ruleXPostfixOperation EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXPostfixOperationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXPostfixOperation=ruleXPostfixOperation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXPostfixOperation; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXPostfixOperation"



	// $ANTLR start "ruleXPostfixOperation"
	// InternalDsl.g:<invalid or missing tree structure>
	public final EObject ruleXPostfixOperation() throws RecognitionException {
		EObject current = null;


		Token otherlv_7=null;
		Token otherlv_9=null;
		Token otherlv_10=null;
		Token otherlv_12=null;
		EObject lv_operand_2_0 =null;
		EObject this_XMemberFeatureCall_3 =null;
		EObject lv_indexes_8_0 =null;
		EObject lv_indexes_11_0 =null;


			enterRule();

		try {
			// InternalDsl.g:<invalid or missing tree structure>
			// InternalDsl.g:<invalid or missing tree structure>
			{
			// InternalDsl.g:<invalid or missing tree structure>
			int alt91=2;
			int LA91_0 = input.LA(1);
			if ( (LA91_0==29) && (synpred26_InternalDsl())) {
				alt91=1;
			}
			else if ( (LA91_0==33) && (synpred26_InternalDsl())) {
				alt91=1;
			}
			else if ( ((LA91_0 >= RULE_CHARACTER && LA91_0 <= RULE_INT)||LA91_0==RULE_STRING||LA91_0==22||(LA91_0 >= 87 && LA91_0 <= 89)||LA91_0==94||(LA91_0 >= 96 && LA91_0 <= 97)||(LA91_0 >= 99 && LA91_0 <= 100)||LA91_0==104||LA91_0==107) ) {
				alt91=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 91, 0, input);
				throw nvae;
			}

			switch (alt91) {
				case 1 :
					// InternalDsl.g:5338:3: ( ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
					{
					// InternalDsl.g:5338:3: ( ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
					// InternalDsl.g:5339:4: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
					{
					// InternalDsl.g:5339:4: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )
					// InternalDsl.g:5340:5: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
					{
					// InternalDsl.g:5350:5: ( () ( ( ruleOpPostfix ) ) )
					// InternalDsl.g:5351:6: () ( ( ruleOpPostfix ) )
					{
					// InternalDsl.g:5351:6: ()
					// InternalDsl.g:5352:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElement(
													grammarAccess.getXPostfixOperationAccess().getXJPrefixOperationAction_0_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:5358:6: ( ( ruleOpPostfix ) )
					// InternalDsl.g:5359:7: ( ruleOpPostfix )
					{
					// InternalDsl.g:5359:7: ( ruleOpPostfix )
					// InternalDsl.g:5360:8: ruleOpPostfix
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXPostfixOperationRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_0_0_1_0());
												}
					pushFollow(FOLLOW_80);
					ruleOpPostfix();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalDsl.g:5376:4: ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
					// InternalDsl.g:5377:5: (lv_operand_2_0= ruleXMemberFeatureCall )
					{
					// InternalDsl.g:5377:5: (lv_operand_2_0= ruleXMemberFeatureCall )
					// InternalDsl.g:5378:6: lv_operand_2_0= ruleXMemberFeatureCall
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXPostfixOperationAccess().getOperandXMemberFeatureCallParserRuleCall_0_1_0());
										}
					pushFollow(FOLLOW_2);
					lv_operand_2_0=ruleXMemberFeatureCall();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXPostfixOperationRule());
											}
											set(
												current,
												"operand",
												lv_operand_2_0,
												"jbase.Jbase.XMemberFeatureCall");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:<invalid or missing tree structure>
					{
					// InternalDsl.g:<invalid or missing tree structure>
					// InternalDsl.g:<invalid or missing tree structure>
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXPostfixOperationAccess().getXMemberFeatureCallParserRuleCall_1_0());
								}
					pushFollow(FOLLOW_81);
					this_XMemberFeatureCall_3=ruleXMemberFeatureCall();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XMemberFeatureCall_3;
									afterParserOrEnumRuleCall();
								}
					// InternalDsl.g:<invalid or missing tree structure>
					int alt90=3;
					switch ( input.LA(1) ) {
						case 29:
							{
							int LA90_1 = input.LA(2);
							if ( (synpred27_InternalDsl()) ) {
								alt90=1;
							}
							}
							break;
						case 33:
							{
							int LA90_2 = input.LA(2);
							if ( (synpred27_InternalDsl()) ) {
								alt90=1;
							}
							}
							break;
						case 75:
							{
							int LA90_3 = input.LA(2);
							if ( (synpred29_InternalDsl()) ) {
								alt90=2;
							}
							}
							break;
					}
					switch (alt90) {
						case 1 :
							// InternalDsl.g:5407:5: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )
							{
							// InternalDsl.g:5407:5: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )
							// InternalDsl.g:5408:6: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
							{
							// InternalDsl.g:5418:6: ( () ( ( ruleOpPostfix ) ) )
							// InternalDsl.g:5419:7: () ( ( ruleOpPostfix ) )
							{
							// InternalDsl.g:5419:7: ()
							// InternalDsl.g:5420:8: 
							{
							if ( state.backtracking==0 ) {
															current = forceCreateModelElementAndSet(
																grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_1_0_0_0(),
																current);
														}
							}

							// InternalDsl.g:5426:7: ( ( ruleOpPostfix ) )
							// InternalDsl.g:5427:8: ( ruleOpPostfix )
							{
							// InternalDsl.g:5427:8: ( ruleOpPostfix )
							// InternalDsl.g:5428:9: ruleOpPostfix
							{
							if ( state.backtracking==0 ) {
																if (current==null) {
																	current = createModelElement(grammarAccess.getXPostfixOperationRule());
																}
															}
							if ( state.backtracking==0 ) {
																newCompositeNode(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
															}
							pushFollow(FOLLOW_2);
							ruleOpPostfix();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
																afterParserOrEnumRuleCall();
															}
							}

							}

							}

							}

							}
							break;
						case 2 :
							// InternalDsl.g:<invalid or missing tree structure>
							{
							// InternalDsl.g:<invalid or missing tree structure>
							// InternalDsl.g:<invalid or missing tree structure>
							{
							// InternalDsl.g:5470:6: ( () otherlv_7= '[' ( (lv_indexes_8_0= ruleXExpression ) ) otherlv_9= ']' ( ( ( '[' )=>otherlv_10= '[' ) ( (lv_indexes_11_0= ruleXExpression ) ) otherlv_12= ']' )* )
							// InternalDsl.g:5471:7: () otherlv_7= '[' ( (lv_indexes_8_0= ruleXExpression ) ) otherlv_9= ']' ( ( ( '[' )=>otherlv_10= '[' ) ( (lv_indexes_11_0= ruleXExpression ) ) otherlv_12= ']' )*
							{
							// InternalDsl.g:5471:7: ()
							// InternalDsl.g:5472:8: 
							{
							if ( state.backtracking==0 ) {
															current = forceCreateModelElementAndSet(
																grammarAccess.getXPostfixOperationAccess().getXJArrayAccessExpressionArrayAction_1_1_1_0_0(),
																current);
														}
							}

							otherlv_7=(Token)match(input,75,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_7, grammarAccess.getXPostfixOperationAccess().getLeftSquareBracketKeyword_1_1_1_0_1());
													}
							// InternalDsl.g:5482:7: ( (lv_indexes_8_0= ruleXExpression ) )
							// InternalDsl.g:5483:8: (lv_indexes_8_0= ruleXExpression )
							{
							// InternalDsl.g:5483:8: (lv_indexes_8_0= ruleXExpression )
							// InternalDsl.g:5484:9: lv_indexes_8_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
																newCompositeNode(grammarAccess.getXPostfixOperationAccess().getIndexesXExpressionParserRuleCall_1_1_1_0_2_0());
															}
							pushFollow(FOLLOW_15);
							lv_indexes_8_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
																if (current==null) {
																	current = createModelElementForParent(grammarAccess.getXPostfixOperationRule());
																}
																add(
																	current,
																	"indexes",
																	lv_indexes_8_0,
																	"org.eclipse.xtext.xbase.Xbase.XExpression");
																afterParserOrEnumRuleCall();
															}
							}

							}

							otherlv_9=(Token)match(input,76,FOLLOW_62); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_9, grammarAccess.getXPostfixOperationAccess().getRightSquareBracketKeyword_1_1_1_0_3());
													}
							// InternalDsl.g:5505:7: ( ( ( '[' )=>otherlv_10= '[' ) ( (lv_indexes_11_0= ruleXExpression ) ) otherlv_12= ']' )*
							loop89:
							while (true) {
								int alt89=2;
								alt89 = dfa89.predict(input);
								switch (alt89) {
								case 1 :
									// InternalDsl.g:5506:8: ( ( '[' )=>otherlv_10= '[' ) ( (lv_indexes_11_0= ruleXExpression ) ) otherlv_12= ']'
									{
									// InternalDsl.g:5506:8: ( ( '[' )=>otherlv_10= '[' )
									// InternalDsl.g:5507:9: ( '[' )=>otherlv_10= '['
									{
									otherlv_10=(Token)match(input,75,FOLLOW_66); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																		newLeafNode(otherlv_10, grammarAccess.getXPostfixOperationAccess().getLeftSquareBracketKeyword_1_1_1_0_4_0());
																	}
									}

									// InternalDsl.g:5513:8: ( (lv_indexes_11_0= ruleXExpression ) )
									// InternalDsl.g:5514:9: (lv_indexes_11_0= ruleXExpression )
									{
									// InternalDsl.g:5514:9: (lv_indexes_11_0= ruleXExpression )
									// InternalDsl.g:5515:10: lv_indexes_11_0= ruleXExpression
									{
									if ( state.backtracking==0 ) {
																			newCompositeNode(grammarAccess.getXPostfixOperationAccess().getIndexesXExpressionParserRuleCall_1_1_1_0_4_1_0());
																		}
									pushFollow(FOLLOW_15);
									lv_indexes_11_0=ruleXExpression();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																			if (current==null) {
																				current = createModelElementForParent(grammarAccess.getXPostfixOperationRule());
																			}
																			add(
																				current,
																				"indexes",
																				lv_indexes_11_0,
																				"org.eclipse.xtext.xbase.Xbase.XExpression");
																			afterParserOrEnumRuleCall();
																		}
									}

									}

									otherlv_12=(Token)match(input,76,FOLLOW_62); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	newLeafNode(otherlv_12, grammarAccess.getXPostfixOperationAccess().getRightSquareBracketKeyword_1_1_1_0_4_2());
																}
									}
									break;

								default :
									break loop89;
								}
							}

							}

							}

							}
							break;

					}

					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXPostfixOperation"



	// $ANTLR start "entryRuleXMemberFeatureCall"
	// InternalDsl.g:5545:1: entryRuleXMemberFeatureCall returns [EObject current=null] :iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
	public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXMemberFeatureCall =null;

		try {
			// InternalDsl.g:5545:59: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
			// InternalDsl.g:5546:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXMemberFeatureCall; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXMemberFeatureCall"



	// $ANTLR start "ruleXMemberFeatureCall"
	// InternalDsl.g:5552:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )* ) ;
	public final EObject ruleXMemberFeatureCall() throws RecognitionException {
		EObject current = null;


		Token otherlv_3=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_11=null;
		Token lv_explicitOperationCall_13_0=null;
		Token otherlv_15=null;
		Token otherlv_17=null;
		EObject this_XPrimaryExpression_0 =null;
		AntlrDatatypeRuleToken lv_arrayDimensions_2_0 =null;
		EObject lv_value_9_0 =null;
		EObject lv_memberCallArguments_14_0 =null;
		EObject lv_memberCallArguments_16_0 =null;


			enterRule();

		try {
			// InternalDsl.g:5558:2: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )* ) )
			// InternalDsl.g:5559:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )* )
			{
			// InternalDsl.g:5559:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )* )
			// InternalDsl.g:5560:3: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_82);
			this_XPrimaryExpression_0=ruleXPrimaryExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XPrimaryExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:5568:3: ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )*
			loop96:
			while (true) {
				int alt96=4;
				int LA96_0 = input.LA(1);
				if ( (LA96_0==75) ) {
					int LA96_2 = input.LA(2);
					if ( (synpred31_InternalDsl()) ) {
						alt96=1;
					}

				}
				else if ( (LA96_0==36) ) {
					int LA96_3 = input.LA(2);
					if ( (synpred31_InternalDsl()) ) {
						alt96=1;
					}
					else if ( (synpred32_InternalDsl()) ) {
						alt96=2;
					}
					else if ( (synpred33_InternalDsl()) ) {
						alt96=3;
					}

				}

				switch (alt96) {
				case 1 :
					// InternalDsl.g:5569:4: ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) )
					{
					// InternalDsl.g:5569:4: ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) )
					// InternalDsl.g:5570:5: ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' )
					{
					// InternalDsl.g:5582:5: ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' )
					// InternalDsl.g:5583:6: () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class'
					{
					// InternalDsl.g:5583:6: ()
					// InternalDsl.g:5584:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXMemberFeatureCallAccess().getXJClassObjectTypeExpressionAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:5590:6: ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )*
					loop92:
					while (true) {
						int alt92=2;
						int LA92_0 = input.LA(1);
						if ( (LA92_0==75) ) {
							alt92=1;
						}

						switch (alt92) {
						case 1 :
							// InternalDsl.g:5591:7: (lv_arrayDimensions_2_0= ruleArrayBrackets )
							{
							// InternalDsl.g:5591:7: (lv_arrayDimensions_2_0= ruleArrayBrackets )
							// InternalDsl.g:5592:8: lv_arrayDimensions_2_0= ruleArrayBrackets
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getArrayDimensionsArrayBracketsParserRuleCall_1_0_0_1_0());
														}
							pushFollow(FOLLOW_83);
							lv_arrayDimensions_2_0=ruleArrayBrackets();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
															}
															add(
																current,
																"arrayDimensions",
																lv_arrayDimensions_2_0,
																"org.eclipse.xtext.xbase.Xtype.ArrayBrackets");
															afterParserOrEnumRuleCall();
														}
							}

							}
							break;

						default :
							break loop92;
						}
					}

					otherlv_3=(Token)match(input,36,FOLLOW_84); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_3, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_2());
										}
					otherlv_4=(Token)match(input,82,FOLLOW_82); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_4, grammarAccess.getXMemberFeatureCallAccess().getClassKeyword_1_0_0_3());
										}
					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:5620:4: ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) )
					{
					// InternalDsl.g:5620:4: ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) )
					// InternalDsl.g:5621:5: ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) )
					{
					// InternalDsl.g:5621:5: ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
					// InternalDsl.g:5622:6: ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					{
					// InternalDsl.g:5634:6: ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					// InternalDsl.g:5635:7: () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
					{
					// InternalDsl.g:5635:7: ()
					// InternalDsl.g:5636:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_1_0_0_0(),
														current);
												}
					}

					otherlv_6=(Token)match(input,36,FOLLOW_85); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(otherlv_6, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1());
											}
					// InternalDsl.g:5646:7: ( ( ruleFeatureCallID ) )
					// InternalDsl.g:5647:8: ( ruleFeatureCallID )
					{
					// InternalDsl.g:5647:8: ( ruleFeatureCallID )
					// InternalDsl.g:5648:9: ruleFeatureCallID
					{
					if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
														}
													}
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_2_0());
													}
					pushFollow(FOLLOW_16);
					ruleFeatureCallID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
														afterParserOrEnumRuleCall();
													}
					}

					}

					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_1_0_0_3());
											}
					pushFollow(FOLLOW_66);
					ruleOpSingleAssign();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalDsl.g:5671:5: ( (lv_value_9_0= ruleXAssignment ) )
					// InternalDsl.g:5672:6: (lv_value_9_0= ruleXAssignment )
					{
					// InternalDsl.g:5672:6: (lv_value_9_0= ruleXAssignment )
					// InternalDsl.g:5673:7: lv_value_9_0= ruleXAssignment
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_1_1_0());
											}
					pushFollow(FOLLOW_82);
					lv_value_9_0=ruleXAssignment();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
												}
												set(
													current,
													"value",
													lv_value_9_0,
													"jbase.Jbase.XAssignment");
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}
					break;
				case 3 :
					// InternalDsl.g:5692:4: ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? )
					{
					// InternalDsl.g:5692:4: ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? )
					// InternalDsl.g:5693:5: ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )?
					{
					// InternalDsl.g:5693:5: ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) )
					// InternalDsl.g:5694:6: ( ( () '.' ) )=> ( () otherlv_11= '.' )
					{
					// InternalDsl.g:5700:6: ( () otherlv_11= '.' )
					// InternalDsl.g:5701:7: () otherlv_11= '.'
					{
					// InternalDsl.g:5701:7: ()
					// InternalDsl.g:5702:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_2_0_0_0(),
														current);
												}
					}

					otherlv_11=(Token)match(input,36,FOLLOW_86); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(otherlv_11, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_2_0_0_1());
											}
					}

					}

					// InternalDsl.g:5714:5: ( ( ruleIdOrSuper ) )
					// InternalDsl.g:5715:6: ( ruleIdOrSuper )
					{
					// InternalDsl.g:5715:6: ( ruleIdOrSuper )
					// InternalDsl.g:5716:7: ruleIdOrSuper
					{
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
												}
											}
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_2_1_0());
											}
					pushFollow(FOLLOW_24);
					ruleIdOrSuper();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalDsl.g:5730:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )?
					int alt95=2;
					alt95 = dfa95.predict(input);
					switch (alt95) {
						case 1 :
							// InternalDsl.g:5731:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')'
							{
							// InternalDsl.g:5731:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) )
							// InternalDsl.g:5732:7: ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' )
							{
							// InternalDsl.g:5736:7: (lv_explicitOperationCall_13_0= '(' )
							// InternalDsl.g:5737:8: lv_explicitOperationCall_13_0= '('
							{
							lv_explicitOperationCall_13_0=(Token)match(input,22,FOLLOW_73); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(lv_explicitOperationCall_13_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_2_2_0_0());
														}
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
															}
															setWithLastConsumed(current, "explicitOperationCall", lv_explicitOperationCall_13_0 != null, "(");
														}
							}

							}

							// InternalDsl.g:5749:6: ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )?
							int alt94=2;
							int LA94_0 = input.LA(1);
							if ( ((LA94_0 >= RULE_CHARACTER && LA94_0 <= RULE_INT)||LA94_0==RULE_STRING||LA94_0==14||LA94_0==22||(LA94_0 >= 28 && LA94_0 <= 29)||(LA94_0 >= 32 && LA94_0 <= 33)||(LA94_0 >= 87 && LA94_0 <= 89)||LA94_0==94||(LA94_0 >= 96 && LA94_0 <= 97)||(LA94_0 >= 99 && LA94_0 <= 100)||LA94_0==104||LA94_0==107||LA94_0==112) ) {
								alt94=1;
							}
							switch (alt94) {
								case 1 :
									// InternalDsl.g:5750:7: ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )*
									{
									// InternalDsl.g:5750:7: ( (lv_memberCallArguments_14_0= ruleXExpression ) )
									// InternalDsl.g:5751:8: (lv_memberCallArguments_14_0= ruleXExpression )
									{
									// InternalDsl.g:5751:8: (lv_memberCallArguments_14_0= ruleXExpression )
									// InternalDsl.g:5752:9: lv_memberCallArguments_14_0= ruleXExpression
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_2_2_1_0_0());
																	}
									pushFollow(FOLLOW_26);
									lv_memberCallArguments_14_0=ruleXExpression();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																		if (current==null) {
																			current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
																		}
																		add(
																			current,
																			"memberCallArguments",
																			lv_memberCallArguments_14_0,
																			"org.eclipse.xtext.xbase.Xbase.XExpression");
																		afterParserOrEnumRuleCall();
																	}
									}

									}

									// InternalDsl.g:5769:7: (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )*
									loop93:
									while (true) {
										int alt93=2;
										int LA93_0 = input.LA(1);
										if ( (LA93_0==31) ) {
											alt93=1;
										}

										switch (alt93) {
										case 1 :
											// InternalDsl.g:5770:8: otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) )
											{
											otherlv_15=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																			newLeafNode(otherlv_15, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_2_2_1_1_0());
																		}
											// InternalDsl.g:5774:8: ( (lv_memberCallArguments_16_0= ruleXExpression ) )
											// InternalDsl.g:5775:9: (lv_memberCallArguments_16_0= ruleXExpression )
											{
											// InternalDsl.g:5775:9: (lv_memberCallArguments_16_0= ruleXExpression )
											// InternalDsl.g:5776:10: lv_memberCallArguments_16_0= ruleXExpression
											{
											if ( state.backtracking==0 ) {
																					newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_2_2_1_1_1_0());
																				}
											pushFollow(FOLLOW_26);
											lv_memberCallArguments_16_0=ruleXExpression();
											state._fsp--;
											if (state.failed) return current;
											if ( state.backtracking==0 ) {
																					if (current==null) {
																						current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
																					}
																					add(
																						current,
																						"memberCallArguments",
																						lv_memberCallArguments_16_0,
																						"org.eclipse.xtext.xbase.Xbase.XExpression");
																					afterParserOrEnumRuleCall();
																				}
											}

											}

											}
											break;

										default :
											break loop93;
										}
									}

									}
									break;

							}

							otherlv_17=(Token)match(input,25,FOLLOW_82); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_17, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_2_2_2());
												}
							}
							break;

					}

					}

					}
					break;

				default :
					break loop96;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXMemberFeatureCall"



	// $ANTLR start "entryRuleXForLoopExpression"
	// InternalDsl.g:5806:1: entryRuleXForLoopExpression returns [EObject current=null] :iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
	public final EObject entryRuleXForLoopExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXForLoopExpression =null;

		try {
			// InternalDsl.g:5806:59: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
			// InternalDsl.g:5807:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXForLoopExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXForLoopExpression=ruleXForLoopExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXForLoopExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXForLoopExpression"



	// $ANTLR start "ruleXForLoopExpression"
	// InternalDsl.g:5813:1: ruleXForLoopExpression returns [EObject current=null] : ( ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) ) ) ;
	public final EObject ruleXForLoopExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_declaredParam_3_0 =null;
		EObject lv_forExpression_5_0 =null;
		EObject lv_eachExpression_7_0 =null;


			enterRule();

		try {
			// InternalDsl.g:5819:2: ( ( ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) ) ) )
			// InternalDsl.g:5820:2: ( ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) ) )
			{
			// InternalDsl.g:5820:2: ( ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) ) )
			// InternalDsl.g:5821:3: ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) )
			{
			// InternalDsl.g:5821:3: ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) )
			// InternalDsl.g:5822:4: ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' )
			{
			// InternalDsl.g:5835:4: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' )
			// InternalDsl.g:5836:5: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':'
			{
			// InternalDsl.g:5836:5: ()
			// InternalDsl.g:5837:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,92,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0_0_1());
							}
			otherlv_2=(Token)match(input,22,FOLLOW_87); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2());
							}
			// InternalDsl.g:5851:5: ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) )
			// InternalDsl.g:5852:6: (lv_declaredParam_3_0= ruleFullJvmFormalParameter )
			{
			// InternalDsl.g:5852:6: (lv_declaredParam_3_0= ruleFullJvmFormalParameter )
			// InternalDsl.g:5853:7: lv_declaredParam_3_0= ruleFullJvmFormalParameter
			{
			if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_0_0_3_0());
									}
			pushFollow(FOLLOW_33);
			lv_declaredParam_3_0=ruleFullJvmFormalParameter();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
										}
										set(
											current,
											"declaredParam",
											lv_declaredParam_3_0,
											"jbase.Jbase.FullJvmFormalParameter");
										afterParserOrEnumRuleCall();
									}
			}

			}

			otherlv_4=(Token)match(input,40,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_0_0_4());
							}
			}

			}

			// InternalDsl.g:5876:3: ( (lv_forExpression_5_0= ruleXExpression ) )
			// InternalDsl.g:5877:4: (lv_forExpression_5_0= ruleXExpression )
			{
			// InternalDsl.g:5877:4: (lv_forExpression_5_0= ruleXExpression )
			// InternalDsl.g:5878:5: lv_forExpression_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_8);
			lv_forExpression_5_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
								}
								set(
									current,
									"forExpression",
									lv_forExpression_5_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_6=(Token)match(input,25,FOLLOW_35); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_2());
					}
			// InternalDsl.g:5899:3: ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) )
			// InternalDsl.g:5900:4: (lv_eachExpression_7_0= ruleXJStatementOrBlock )
			{
			// InternalDsl.g:5900:4: (lv_eachExpression_7_0= ruleXJStatementOrBlock )
			// InternalDsl.g:5901:5: lv_eachExpression_7_0= ruleXJStatementOrBlock
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXJStatementOrBlockParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_2);
			lv_eachExpression_7_0=ruleXJStatementOrBlock();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
								}
								set(
									current,
									"eachExpression",
									lv_eachExpression_7_0,
									"jbase.Jbase.XJStatementOrBlock");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXForLoopExpression"



	// $ANTLR start "entryRuleXBasicForLoopExpression"
	// InternalDsl.g:5922:1: entryRuleXBasicForLoopExpression returns [EObject current=null] :iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF ;
	public final EObject entryRuleXBasicForLoopExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBasicForLoopExpression =null;

		try {
			// InternalDsl.g:5922:64: (iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF )
			// InternalDsl.g:5923:2: iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXBasicForLoopExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXBasicForLoopExpression=ruleXBasicForLoopExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXBasicForLoopExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXBasicForLoopExpression"



	// $ANTLR start "ruleXBasicForLoopExpression"
	// InternalDsl.g:5929:1: ruleXBasicForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) ) ) ;
	public final EObject ruleXBasicForLoopExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token otherlv_10=null;
		Token otherlv_12=null;
		EObject lv_initExpressions_3_0 =null;
		EObject lv_initExpressions_5_0 =null;
		EObject lv_expression_7_0 =null;
		EObject lv_updateExpressions_9_0 =null;
		EObject lv_updateExpressions_11_0 =null;
		EObject lv_eachExpression_13_0 =null;


			enterRule();

		try {
			// InternalDsl.g:5935:2: ( ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) ) ) )
			// InternalDsl.g:5936:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) ) )
			{
			// InternalDsl.g:5936:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) ) )
			// InternalDsl.g:5937:3: () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) )
			{
			// InternalDsl.g:5937:3: ()
			// InternalDsl.g:5938:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBasicForLoopExpressionAccess().getXBasicForLoopExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,92,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXBasicForLoopExpressionAccess().getForKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_88); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXBasicForLoopExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:5952:3: ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )?
			int alt98=2;
			int LA98_0 = input.LA(1);
			if ( ((LA98_0 >= RULE_CHARACTER && LA98_0 <= RULE_INT)||LA98_0==RULE_STRING||LA98_0==14||LA98_0==22||(LA98_0 >= 28 && LA98_0 <= 29)||(LA98_0 >= 32 && LA98_0 <= 33)||(LA98_0 >= 87 && LA98_0 <= 90)||LA98_0==94||(LA98_0 >= 96 && LA98_0 <= 97)||(LA98_0 >= 99 && LA98_0 <= 100)||LA98_0==104||LA98_0==107||LA98_0==112) ) {
				alt98=1;
			}
			switch (alt98) {
				case 1 :
					// InternalDsl.g:5953:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
					{
					// InternalDsl.g:5953:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) )
					// InternalDsl.g:5954:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
					{
					// InternalDsl.g:5954:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
					// InternalDsl.g:5955:6: lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0());
										}
					pushFollow(FOLLOW_89);
					lv_initExpressions_3_0=ruleXExpressionOrVarDeclaration();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
											}
											add(
												current,
												"initExpressions",
												lv_initExpressions_3_0,
												"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:5972:4: (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
					loop97:
					while (true) {
						int alt97=2;
						int LA97_0 = input.LA(1);
						if ( (LA97_0==31) ) {
							alt97=1;
						}

						switch (alt97) {
						case 1 :
							// InternalDsl.g:5973:5: otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
							{
							otherlv_4=(Token)match(input,31,FOLLOW_90); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_3_1_0());
											}
							// InternalDsl.g:5977:5: ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
							// InternalDsl.g:5978:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
							{
							// InternalDsl.g:5978:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
							// InternalDsl.g:5979:7: lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0());
													}
							pushFollow(FOLLOW_89);
							lv_initExpressions_5_0=ruleXExpressionOrVarDeclaration();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
														}
														add(
															current,
															"initExpressions",
															lv_initExpressions_5_0,
															"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop97;
						}
					}

					}
					break;

			}

			otherlv_6=(Token)match(input,41,FOLLOW_91); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_4());
					}
			// InternalDsl.g:6002:3: ( (lv_expression_7_0= ruleXExpression ) )?
			int alt99=2;
			int LA99_0 = input.LA(1);
			if ( ((LA99_0 >= RULE_CHARACTER && LA99_0 <= RULE_INT)||LA99_0==RULE_STRING||LA99_0==14||LA99_0==22||(LA99_0 >= 28 && LA99_0 <= 29)||(LA99_0 >= 32 && LA99_0 <= 33)||(LA99_0 >= 87 && LA99_0 <= 89)||LA99_0==94||(LA99_0 >= 96 && LA99_0 <= 97)||(LA99_0 >= 99 && LA99_0 <= 100)||LA99_0==104||LA99_0==107||LA99_0==112) ) {
				alt99=1;
			}
			switch (alt99) {
				case 1 :
					// InternalDsl.g:6003:4: (lv_expression_7_0= ruleXExpression )
					{
					// InternalDsl.g:6003:4: (lv_expression_7_0= ruleXExpression )
					// InternalDsl.g:6004:5: lv_expression_7_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionXExpressionParserRuleCall_5_0());
									}
					pushFollow(FOLLOW_51);
					lv_expression_7_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
										}
										set(
											current,
											"expression",
											lv_expression_7_0,
											"org.eclipse.xtext.xbase.Xbase.XExpression");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			otherlv_8=(Token)match(input,41,FOLLOW_73); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_6());
					}
			// InternalDsl.g:6025:3: ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )?
			int alt101=2;
			int LA101_0 = input.LA(1);
			if ( ((LA101_0 >= RULE_CHARACTER && LA101_0 <= RULE_INT)||LA101_0==RULE_STRING||LA101_0==14||LA101_0==22||(LA101_0 >= 28 && LA101_0 <= 29)||(LA101_0 >= 32 && LA101_0 <= 33)||(LA101_0 >= 87 && LA101_0 <= 89)||LA101_0==94||(LA101_0 >= 96 && LA101_0 <= 97)||(LA101_0 >= 99 && LA101_0 <= 100)||LA101_0==104||LA101_0==107||LA101_0==112) ) {
				alt101=1;
			}
			switch (alt101) {
				case 1 :
					// InternalDsl.g:6026:4: ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
					{
					// InternalDsl.g:6026:4: ( (lv_updateExpressions_9_0= ruleXExpression ) )
					// InternalDsl.g:6027:5: (lv_updateExpressions_9_0= ruleXExpression )
					{
					// InternalDsl.g:6027:5: (lv_updateExpressions_9_0= ruleXExpression )
					// InternalDsl.g:6028:6: lv_updateExpressions_9_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_0_0());
										}
					pushFollow(FOLLOW_26);
					lv_updateExpressions_9_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
											}
											add(
												current,
												"updateExpressions",
												lv_updateExpressions_9_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:6045:4: (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
					loop100:
					while (true) {
						int alt100=2;
						int LA100_0 = input.LA(1);
						if ( (LA100_0==31) ) {
							alt100=1;
						}

						switch (alt100) {
						case 1 :
							// InternalDsl.g:6046:5: otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) )
							{
							otherlv_10=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_10, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_7_1_0());
											}
							// InternalDsl.g:6050:5: ( (lv_updateExpressions_11_0= ruleXExpression ) )
							// InternalDsl.g:6051:6: (lv_updateExpressions_11_0= ruleXExpression )
							{
							// InternalDsl.g:6051:6: (lv_updateExpressions_11_0= ruleXExpression )
							// InternalDsl.g:6052:7: lv_updateExpressions_11_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_1_1_0());
													}
							pushFollow(FOLLOW_26);
							lv_updateExpressions_11_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
														}
														add(
															current,
															"updateExpressions",
															lv_updateExpressions_11_0,
															"org.eclipse.xtext.xbase.Xbase.XExpression");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop100;
						}
					}

					}
					break;

			}

			otherlv_12=(Token)match(input,25,FOLLOW_35); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_12, grammarAccess.getXBasicForLoopExpressionAccess().getRightParenthesisKeyword_8());
					}
			// InternalDsl.g:6075:3: ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) )
			// InternalDsl.g:6076:4: (lv_eachExpression_13_0= ruleXJStatementOrBlock )
			{
			// InternalDsl.g:6076:4: (lv_eachExpression_13_0= ruleXJStatementOrBlock )
			// InternalDsl.g:6077:5: lv_eachExpression_13_0= ruleXJStatementOrBlock
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionXJStatementOrBlockParserRuleCall_9_0());
							}
			pushFollow(FOLLOW_2);
			lv_eachExpression_13_0=ruleXJStatementOrBlock();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
								}
								set(
									current,
									"eachExpression",
									lv_eachExpression_13_0,
									"jbase.Jbase.XJStatementOrBlock");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXBasicForLoopExpression"



	// $ANTLR start "entryRuleXIfExpression"
	// InternalDsl.g:6098:1: entryRuleXIfExpression returns [EObject current=null] :iv_ruleXIfExpression= ruleXIfExpression EOF ;
	public final EObject entryRuleXIfExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXIfExpression =null;

		try {
			// InternalDsl.g:6098:54: (iv_ruleXIfExpression= ruleXIfExpression EOF )
			// InternalDsl.g:6099:2: iv_ruleXIfExpression= ruleXIfExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXIfExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXIfExpression=ruleXIfExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXIfExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXIfExpression"



	// $ANTLR start "ruleXIfExpression"
	// InternalDsl.g:6105:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXJStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )? ) ;
	public final EObject ruleXIfExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_if_3_0 =null;
		EObject lv_then_5_0 =null;
		EObject lv_else_7_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6111:2: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXJStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )? ) )
			// InternalDsl.g:6112:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXJStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )? )
			{
			// InternalDsl.g:6112:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXJStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )? )
			// InternalDsl.g:6113:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXJStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )?
			{
			// InternalDsl.g:6113:3: ()
			// InternalDsl.g:6114:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,93,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:6128:3: ( (lv_if_3_0= ruleXExpression ) )
			// InternalDsl.g:6129:4: (lv_if_3_0= ruleXExpression )
			{
			// InternalDsl.g:6129:4: (lv_if_3_0= ruleXExpression )
			// InternalDsl.g:6130:5: lv_if_3_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_8);
			lv_if_3_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
								}
								set(
									current,
									"if",
									lv_if_3_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,25,FOLLOW_35); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
					}
			// InternalDsl.g:6151:3: ( (lv_then_5_0= ruleXJStatementOrBlock ) )
			// InternalDsl.g:6152:4: (lv_then_5_0= ruleXJStatementOrBlock )
			{
			// InternalDsl.g:6152:4: (lv_then_5_0= ruleXJStatementOrBlock )
			// InternalDsl.g:6153:5: lv_then_5_0= ruleXJStatementOrBlock
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXJStatementOrBlockParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_92);
			lv_then_5_0=ruleXJStatementOrBlock();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
								}
								set(
									current,
									"then",
									lv_then_5_0,
									"jbase.Jbase.XJStatementOrBlock");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:6170:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )?
			int alt102=2;
			int LA102_0 = input.LA(1);
			if ( (LA102_0==86) ) {
				int LA102_1 = input.LA(2);
				if ( (synpred36_InternalDsl()) ) {
					alt102=1;
				}
			}
			switch (alt102) {
				case 1 :
					// InternalDsl.g:6171:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) )
					{
					// InternalDsl.g:6171:4: ( ( 'else' )=>otherlv_6= 'else' )
					// InternalDsl.g:6172:5: ( 'else' )=>otherlv_6= 'else'
					{
					otherlv_6=(Token)match(input,86,FOLLOW_35); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
									}
					}

					// InternalDsl.g:6178:4: ( (lv_else_7_0= ruleXJStatementOrBlock ) )
					// InternalDsl.g:6179:5: (lv_else_7_0= ruleXJStatementOrBlock )
					{
					// InternalDsl.g:6179:5: (lv_else_7_0= ruleXJStatementOrBlock )
					// InternalDsl.g:6180:6: lv_else_7_0= ruleXJStatementOrBlock
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXJStatementOrBlockParserRuleCall_6_1_0());
										}
					pushFollow(FOLLOW_2);
					lv_else_7_0=ruleXJStatementOrBlock();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
											}
											set(
												current,
												"else",
												lv_else_7_0,
												"jbase.Jbase.XJStatementOrBlock");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXIfExpression"



	// $ANTLR start "entryRuleXWhileExpression"
	// InternalDsl.g:6202:1: entryRuleXWhileExpression returns [EObject current=null] :iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
	public final EObject entryRuleXWhileExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXWhileExpression =null;

		try {
			// InternalDsl.g:6202:57: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
			// InternalDsl.g:6203:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXWhileExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXWhileExpression=ruleXWhileExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXWhileExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXWhileExpression"



	// $ANTLR start "ruleXWhileExpression"
	// InternalDsl.g:6209:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXJStatementOrBlock ) ) ) ;
	public final EObject ruleXWhileExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_predicate_3_0 =null;
		EObject lv_body_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6215:2: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXJStatementOrBlock ) ) ) )
			// InternalDsl.g:6216:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXJStatementOrBlock ) ) )
			{
			// InternalDsl.g:6216:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXJStatementOrBlock ) ) )
			// InternalDsl.g:6217:3: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXJStatementOrBlock ) )
			{
			// InternalDsl.g:6217:3: ()
			// InternalDsl.g:6218:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,106,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:6232:3: ( (lv_predicate_3_0= ruleXExpression ) )
			// InternalDsl.g:6233:4: (lv_predicate_3_0= ruleXExpression )
			{
			// InternalDsl.g:6233:4: (lv_predicate_3_0= ruleXExpression )
			// InternalDsl.g:6234:5: lv_predicate_3_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_8);
			lv_predicate_3_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
								}
								set(
									current,
									"predicate",
									lv_predicate_3_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,25,FOLLOW_35); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
					}
			// InternalDsl.g:6255:3: ( (lv_body_5_0= ruleXJStatementOrBlock ) )
			// InternalDsl.g:6256:4: (lv_body_5_0= ruleXJStatementOrBlock )
			{
			// InternalDsl.g:6256:4: (lv_body_5_0= ruleXJStatementOrBlock )
			// InternalDsl.g:6257:5: lv_body_5_0= ruleXJStatementOrBlock
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXJStatementOrBlockParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_2);
			lv_body_5_0=ruleXJStatementOrBlock();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
								}
								set(
									current,
									"body",
									lv_body_5_0,
									"jbase.Jbase.XJStatementOrBlock");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXWhileExpression"



	// $ANTLR start "entryRuleXDoWhileExpression"
	// InternalDsl.g:6278:1: entryRuleXDoWhileExpression returns [EObject current=null] :iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
	public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXDoWhileExpression =null;

		try {
			// InternalDsl.g:6278:59: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
			// InternalDsl.g:6279:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXDoWhileExpression=ruleXDoWhileExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXDoWhileExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXDoWhileExpression"



	// $ANTLR start "ruleXDoWhileExpression"
	// InternalDsl.g:6285:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXJStatementOrBlock ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
	public final EObject ruleXDoWhileExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_body_2_0 =null;
		EObject lv_predicate_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6291:2: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXJStatementOrBlock ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
			// InternalDsl.g:6292:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXJStatementOrBlock ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
			{
			// InternalDsl.g:6292:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXJStatementOrBlock ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
			// InternalDsl.g:6293:3: () otherlv_1= 'do' ( (lv_body_2_0= ruleXJStatementOrBlock ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
			{
			// InternalDsl.g:6293:3: ()
			// InternalDsl.g:6294:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,85,FOLLOW_35); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
					}
			// InternalDsl.g:6304:3: ( (lv_body_2_0= ruleXJStatementOrBlock ) )
			// InternalDsl.g:6305:4: (lv_body_2_0= ruleXJStatementOrBlock )
			{
			// InternalDsl.g:6305:4: (lv_body_2_0= ruleXJStatementOrBlock )
			// InternalDsl.g:6306:5: lv_body_2_0= ruleXJStatementOrBlock
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXJStatementOrBlockParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_93);
			lv_body_2_0=ruleXJStatementOrBlock();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
								}
								set(
									current,
									"body",
									lv_body_2_0,
									"jbase.Jbase.XJStatementOrBlock");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_3=(Token)match(input,106,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
					}
			otherlv_4=(Token)match(input,22,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
					}
			// InternalDsl.g:6331:3: ( (lv_predicate_5_0= ruleXExpression ) )
			// InternalDsl.g:6332:4: (lv_predicate_5_0= ruleXExpression )
			{
			// InternalDsl.g:6332:4: (lv_predicate_5_0= ruleXExpression )
			// InternalDsl.g:6333:5: lv_predicate_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_8);
			lv_predicate_5_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
								}
								set(
									current,
									"predicate",
									lv_predicate_5_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_6=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXDoWhileExpression"



	// $ANTLR start "entryRuleXSwitchExpression"
	// InternalDsl.g:6358:1: entryRuleXSwitchExpression returns [EObject current=null] :iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
	public final EObject entryRuleXSwitchExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSwitchExpression =null;

		try {
			// InternalDsl.g:6358:58: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
			// InternalDsl.g:6359:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXSwitchExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXSwitchExpression=ruleXSwitchExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXSwitchExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXSwitchExpression"



	// $ANTLR start "ruleXSwitchExpression"
	// InternalDsl.g:6365:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' otherlv_2= '(' ( (lv_switch_3_0= ruleXExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )* (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )? otherlv_10= '}' ) ;
	public final EObject ruleXSwitchExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		Token otherlv_8=null;
		Token otherlv_10=null;
		EObject lv_switch_3_0 =null;
		EObject lv_cases_6_0 =null;
		EObject lv_default_9_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6371:2: ( ( () otherlv_1= 'switch' otherlv_2= '(' ( (lv_switch_3_0= ruleXExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )* (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )? otherlv_10= '}' ) )
			// InternalDsl.g:6372:2: ( () otherlv_1= 'switch' otherlv_2= '(' ( (lv_switch_3_0= ruleXExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )* (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )? otherlv_10= '}' )
			{
			// InternalDsl.g:6372:2: ( () otherlv_1= 'switch' otherlv_2= '(' ( (lv_switch_3_0= ruleXExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )* (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )? otherlv_10= '}' )
			// InternalDsl.g:6373:3: () otherlv_1= 'switch' otherlv_2= '(' ( (lv_switch_3_0= ruleXExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )* (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )? otherlv_10= '}'
			{
			// InternalDsl.g:6373:3: ()
			// InternalDsl.g:6374:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,101,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:6388:3: ( (lv_switch_3_0= ruleXExpression ) )
			// InternalDsl.g:6389:4: (lv_switch_3_0= ruleXExpression )
			{
			// InternalDsl.g:6389:4: (lv_switch_3_0= ruleXExpression )
			// InternalDsl.g:6390:5: lv_switch_3_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_8);
			lv_switch_3_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
								}
								set(
									current,
									"switch",
									lv_switch_3_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_4());
					}
			otherlv_5=(Token)match(input,107,FOLLOW_94); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_5());
					}
			// InternalDsl.g:6415:3: ( (lv_cases_6_0= ruleXCasePart ) )*
			loop103:
			while (true) {
				int alt103=2;
				int LA103_0 = input.LA(1);
				if ( (LA103_0==80) ) {
					alt103=1;
				}

				switch (alt103) {
				case 1 :
					// InternalDsl.g:6416:4: (lv_cases_6_0= ruleXCasePart )
					{
					// InternalDsl.g:6416:4: (lv_cases_6_0= ruleXCasePart )
					// InternalDsl.g:6417:5: lv_cases_6_0= ruleXCasePart
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_6_0());
									}
					pushFollow(FOLLOW_94);
					lv_cases_6_0=ruleXCasePart();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
										}
										add(
											current,
											"cases",
											lv_cases_6_0,
											"jbase.Jbase.XCasePart");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					break loop103;
				}
			}

			// InternalDsl.g:6434:3: (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )?
			int alt104=2;
			int LA104_0 = input.LA(1);
			if ( (LA104_0==84) ) {
				alt104=1;
			}
			switch (alt104) {
				case 1 :
					// InternalDsl.g:6435:4: otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) )
					{
					otherlv_7=(Token)match(input,84,FOLLOW_33); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_7_0());
								}
					otherlv_8=(Token)match(input,40,FOLLOW_64); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_7_1());
								}
					// InternalDsl.g:6443:4: ( (lv_default_9_0= ruleXJSwitchStatements ) )
					// InternalDsl.g:6444:5: (lv_default_9_0= ruleXJSwitchStatements )
					{
					// InternalDsl.g:6444:5: (lv_default_9_0= ruleXJSwitchStatements )
					// InternalDsl.g:6445:6: lv_default_9_0= ruleXJSwitchStatements
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXJSwitchStatementsParserRuleCall_7_2_0());
										}
					pushFollow(FOLLOW_11);
					lv_default_9_0=ruleXJSwitchStatements();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
											}
											set(
												current,
												"default",
												lv_default_9_0,
												"jbase.Jbase.XJSwitchStatements");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			otherlv_10=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_8());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXSwitchExpression"



	// $ANTLR start "entryRuleXCasePart"
	// InternalDsl.g:6471:1: entryRuleXCasePart returns [EObject current=null] :iv_ruleXCasePart= ruleXCasePart EOF ;
	public final EObject entryRuleXCasePart() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCasePart =null;

		try {
			// InternalDsl.g:6471:50: (iv_ruleXCasePart= ruleXCasePart EOF )
			// InternalDsl.g:6472:2: iv_ruleXCasePart= ruleXCasePart EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXCasePartRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXCasePart=ruleXCasePart();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXCasePart; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXCasePart"



	// $ANTLR start "ruleXCasePart"
	// InternalDsl.g:6478:1: ruleXCasePart returns [EObject current=null] : ( () otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) otherlv_3= ':' ( (lv_then_4_0= ruleXJSwitchStatements ) ) ) ;
	public final EObject ruleXCasePart() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		EObject lv_case_2_0 =null;
		EObject lv_then_4_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6484:2: ( ( () otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) otherlv_3= ':' ( (lv_then_4_0= ruleXJSwitchStatements ) ) ) )
			// InternalDsl.g:6485:2: ( () otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) otherlv_3= ':' ( (lv_then_4_0= ruleXJSwitchStatements ) ) )
			{
			// InternalDsl.g:6485:2: ( () otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) otherlv_3= ':' ( (lv_then_4_0= ruleXJSwitchStatements ) ) )
			// InternalDsl.g:6486:3: () otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) otherlv_3= ':' ( (lv_then_4_0= ruleXJSwitchStatements ) )
			{
			// InternalDsl.g:6486:3: ()
			// InternalDsl.g:6487:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXCasePartAccess().getXCasePartAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,80,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1());
					}
			// InternalDsl.g:6497:3: ( (lv_case_2_0= ruleXExpression ) )
			// InternalDsl.g:6498:4: (lv_case_2_0= ruleXExpression )
			{
			// InternalDsl.g:6498:4: (lv_case_2_0= ruleXExpression )
			// InternalDsl.g:6499:5: lv_case_2_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_33);
			lv_case_2_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXCasePartRule());
								}
								set(
									current,
									"case",
									lv_case_2_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_3=(Token)match(input,40,FOLLOW_35); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_3());
					}
			// InternalDsl.g:6520:3: ( (lv_then_4_0= ruleXJSwitchStatements ) )
			// InternalDsl.g:6521:4: (lv_then_4_0= ruleXJSwitchStatements )
			{
			// InternalDsl.g:6521:4: (lv_then_4_0= ruleXJSwitchStatements )
			// InternalDsl.g:6522:5: lv_then_4_0= ruleXJSwitchStatements
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXCasePartAccess().getThenXJSwitchStatementsParserRuleCall_4_0());
							}
			pushFollow(FOLLOW_2);
			lv_then_4_0=ruleXJSwitchStatements();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXCasePartRule());
								}
								set(
									current,
									"then",
									lv_then_4_0,
									"jbase.Jbase.XJSwitchStatements");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXCasePart"



	// $ANTLR start "entryRuleXJSwitchStatements"
	// InternalDsl.g:6543:1: entryRuleXJSwitchStatements returns [EObject current=null] :iv_ruleXJSwitchStatements= ruleXJSwitchStatements EOF ;
	public final EObject entryRuleXJSwitchStatements() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJSwitchStatements =null;

		try {
			// InternalDsl.g:6543:59: (iv_ruleXJSwitchStatements= ruleXJSwitchStatements EOF )
			// InternalDsl.g:6544:2: iv_ruleXJSwitchStatements= ruleXJSwitchStatements EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJSwitchStatementsRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJSwitchStatements=ruleXJSwitchStatements();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJSwitchStatements; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJSwitchStatements"



	// $ANTLR start "ruleXJSwitchStatements"
	// InternalDsl.g:6550:1: ruleXJSwitchStatements returns [EObject current=null] : ( () ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )* ) ;
	public final EObject ruleXJSwitchStatements() throws RecognitionException {
		EObject current = null;


		EObject lv_expressions_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6556:2: ( ( () ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )* ) )
			// InternalDsl.g:6557:2: ( () ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )* )
			{
			// InternalDsl.g:6557:2: ( () ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )* )
			// InternalDsl.g:6558:3: () ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )*
			{
			// InternalDsl.g:6558:3: ()
			// InternalDsl.g:6559:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJSwitchStatementsAccess().getXJSwitchStatementsAction_0(),
								current);
						}
			}

			// InternalDsl.g:6565:3: ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )*
			loop105:
			while (true) {
				int alt105=2;
				int LA105_0 = input.LA(1);
				if ( ((LA105_0 >= RULE_CHARACTER && LA105_0 <= RULE_INT)||LA105_0==RULE_STRING||LA105_0==14||LA105_0==22||(LA105_0 >= 28 && LA105_0 <= 29)||(LA105_0 >= 32 && LA105_0 <= 33)||LA105_0==41||LA105_0==79||LA105_0==83||LA105_0==85||(LA105_0 >= 87 && LA105_0 <= 90)||(LA105_0 >= 92 && LA105_0 <= 94)||(LA105_0 >= 96 && LA105_0 <= 107)||LA105_0==112) ) {
					alt105=1;
				}

				switch (alt105) {
				case 1 :
					// InternalDsl.g:6566:4: (lv_expressions_1_0= ruleXJStatementOrBlock )
					{
					// InternalDsl.g:6566:4: (lv_expressions_1_0= ruleXJStatementOrBlock )
					// InternalDsl.g:6567:5: lv_expressions_1_0= ruleXJStatementOrBlock
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXJSwitchStatementsAccess().getExpressionsXJStatementOrBlockParserRuleCall_1_0());
									}
					pushFollow(FOLLOW_31);
					lv_expressions_1_0=ruleXJStatementOrBlock();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXJSwitchStatementsRule());
										}
										add(
											current,
											"expressions",
											lv_expressions_1_0,
											"jbase.Jbase.XJStatementOrBlock");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					break loop105;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJSwitchStatements"



	// $ANTLR start "entryRuleXJTryWithResourcesStatement"
	// InternalDsl.g:6588:1: entryRuleXJTryWithResourcesStatement returns [EObject current=null] :iv_ruleXJTryWithResourcesStatement= ruleXJTryWithResourcesStatement EOF ;
	public final EObject entryRuleXJTryWithResourcesStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJTryWithResourcesStatement =null;

		try {
			// InternalDsl.g:6588:68: (iv_ruleXJTryWithResourcesStatement= ruleXJTryWithResourcesStatement EOF )
			// InternalDsl.g:6589:2: iv_ruleXJTryWithResourcesStatement= ruleXJTryWithResourcesStatement EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJTryWithResourcesStatementRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJTryWithResourcesStatement=ruleXJTryWithResourcesStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJTryWithResourcesStatement; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJTryWithResourcesStatement"



	// $ANTLR start "ruleXJTryWithResourcesStatement"
	// InternalDsl.g:6595:1: ruleXJTryWithResourcesStatement returns [EObject current=null] : ( ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) ) ( (lv_resources_3_0= ruleXJTryWithResourcesVariableDeclaration ) )* otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ( (lv_catchClauses_6_0= ruleXCatchClause ) )* (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )? ) ;
	public final EObject ruleXJTryWithResourcesStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token lv_openParenthesis_2_0=null;
		Token otherlv_4=null;
		Token otherlv_7=null;
		EObject lv_resources_3_0 =null;
		EObject lv_expression_5_0 =null;
		EObject lv_catchClauses_6_0 =null;
		EObject lv_finallyExpression_8_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6601:2: ( ( ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) ) ( (lv_resources_3_0= ruleXJTryWithResourcesVariableDeclaration ) )* otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ( (lv_catchClauses_6_0= ruleXCatchClause ) )* (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )? ) )
			// InternalDsl.g:6602:2: ( ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) ) ( (lv_resources_3_0= ruleXJTryWithResourcesVariableDeclaration ) )* otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ( (lv_catchClauses_6_0= ruleXCatchClause ) )* (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )? )
			{
			// InternalDsl.g:6602:2: ( ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) ) ( (lv_resources_3_0= ruleXJTryWithResourcesVariableDeclaration ) )* otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ( (lv_catchClauses_6_0= ruleXCatchClause ) )* (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )? )
			// InternalDsl.g:6603:3: ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) ) ( (lv_resources_3_0= ruleXJTryWithResourcesVariableDeclaration ) )* otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ( (lv_catchClauses_6_0= ruleXCatchClause ) )* (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )?
			{
			// InternalDsl.g:6603:3: ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) )
			// InternalDsl.g:6604:4: ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) )
			{
			// InternalDsl.g:6615:4: ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) )
			// InternalDsl.g:6616:5: () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) )
			{
			// InternalDsl.g:6616:5: ()
			// InternalDsl.g:6617:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXJTryWithResourcesStatementAccess().getXJTryWithResourcesStatementAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,105,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXJTryWithResourcesStatementAccess().getTryKeyword_0_0_1());
							}
			// InternalDsl.g:6627:5: ( (lv_openParenthesis_2_0= '(' ) )
			// InternalDsl.g:6628:6: (lv_openParenthesis_2_0= '(' )
			{
			// InternalDsl.g:6628:6: (lv_openParenthesis_2_0= '(' )
			// InternalDsl.g:6629:7: lv_openParenthesis_2_0= '('
			{
			lv_openParenthesis_2_0=(Token)match(input,22,FOLLOW_95); if (state.failed) return current;
			if ( state.backtracking==0 ) {
										newLeafNode(lv_openParenthesis_2_0, grammarAccess.getXJTryWithResourcesStatementAccess().getOpenParenthesisLeftParenthesisKeyword_0_0_2_0());
									}
			if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getXJTryWithResourcesStatementRule());
										}
										setWithLastConsumed(current, "openParenthesis", lv_openParenthesis_2_0 != null, "(");
									}
			}

			}

			}

			}

			// InternalDsl.g:6643:3: ( (lv_resources_3_0= ruleXJTryWithResourcesVariableDeclaration ) )*
			loop106:
			while (true) {
				int alt106=2;
				int LA106_0 = input.LA(1);
				if ( (LA106_0==RULE_ID||LA106_0==90) ) {
					alt106=1;
				}

				switch (alt106) {
				case 1 :
					// InternalDsl.g:6644:4: (lv_resources_3_0= ruleXJTryWithResourcesVariableDeclaration )
					{
					// InternalDsl.g:6644:4: (lv_resources_3_0= ruleXJTryWithResourcesVariableDeclaration )
					// InternalDsl.g:6645:5: lv_resources_3_0= ruleXJTryWithResourcesVariableDeclaration
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXJTryWithResourcesStatementAccess().getResourcesXJTryWithResourcesVariableDeclarationParserRuleCall_1_0());
									}
					pushFollow(FOLLOW_95);
					lv_resources_3_0=ruleXJTryWithResourcesVariableDeclaration();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXJTryWithResourcesStatementRule());
										}
										add(
											current,
											"resources",
											lv_resources_3_0,
											"jbase.Jbase.XJTryWithResourcesVariableDeclaration");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					break loop106;
				}
			}

			otherlv_4=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXJTryWithResourcesStatementAccess().getRightParenthesisKeyword_2());
					}
			// InternalDsl.g:6666:3: ( (lv_expression_5_0= ruleXBlockExpression ) )
			// InternalDsl.g:6667:4: (lv_expression_5_0= ruleXBlockExpression )
			{
			// InternalDsl.g:6667:4: (lv_expression_5_0= ruleXBlockExpression )
			// InternalDsl.g:6668:5: lv_expression_5_0= ruleXBlockExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJTryWithResourcesStatementAccess().getExpressionXBlockExpressionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_96);
			lv_expression_5_0=ruleXBlockExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXJTryWithResourcesStatementRule());
								}
								set(
									current,
									"expression",
									lv_expression_5_0,
									"jbase.Jbase.XBlockExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:6685:3: ( (lv_catchClauses_6_0= ruleXCatchClause ) )*
			loop107:
			while (true) {
				int alt107=2;
				int LA107_0 = input.LA(1);
				if ( (LA107_0==81) ) {
					alt107=1;
				}

				switch (alt107) {
				case 1 :
					// InternalDsl.g:6686:4: (lv_catchClauses_6_0= ruleXCatchClause )
					{
					// InternalDsl.g:6686:4: (lv_catchClauses_6_0= ruleXCatchClause )
					// InternalDsl.g:6687:5: lv_catchClauses_6_0= ruleXCatchClause
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXJTryWithResourcesStatementAccess().getCatchClausesXCatchClauseParserRuleCall_4_0());
									}
					pushFollow(FOLLOW_96);
					lv_catchClauses_6_0=ruleXCatchClause();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXJTryWithResourcesStatementRule());
										}
										add(
											current,
											"catchClauses",
											lv_catchClauses_6_0,
											"jbase.Jbase.XCatchClause");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					break loop107;
				}
			}

			// InternalDsl.g:6704:3: (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )?
			int alt108=2;
			int LA108_0 = input.LA(1);
			if ( (LA108_0==91) ) {
				alt108=1;
			}
			switch (alt108) {
				case 1 :
					// InternalDsl.g:6705:4: otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) )
					{
					otherlv_7=(Token)match(input,91,FOLLOW_9); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_7, grammarAccess.getXJTryWithResourcesStatementAccess().getFinallyKeyword_5_0());
								}
					// InternalDsl.g:6709:4: ( (lv_finallyExpression_8_0= ruleXBlockExpression ) )
					// InternalDsl.g:6710:5: (lv_finallyExpression_8_0= ruleXBlockExpression )
					{
					// InternalDsl.g:6710:5: (lv_finallyExpression_8_0= ruleXBlockExpression )
					// InternalDsl.g:6711:6: lv_finallyExpression_8_0= ruleXBlockExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXJTryWithResourcesStatementAccess().getFinallyExpressionXBlockExpressionParserRuleCall_5_1_0());
										}
					pushFollow(FOLLOW_2);
					lv_finallyExpression_8_0=ruleXBlockExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXJTryWithResourcesStatementRule());
											}
											set(
												current,
												"finallyExpression",
												lv_finallyExpression_8_0,
												"jbase.Jbase.XBlockExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJTryWithResourcesStatement"



	// $ANTLR start "entryRuleXJTryWithResourcesVariableDeclaration"
	// InternalDsl.g:6733:1: entryRuleXJTryWithResourcesVariableDeclaration returns [EObject current=null] :iv_ruleXJTryWithResourcesVariableDeclaration= ruleXJTryWithResourcesVariableDeclaration EOF ;
	public final EObject entryRuleXJTryWithResourcesVariableDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJTryWithResourcesVariableDeclaration =null;

		try {
			// InternalDsl.g:6733:78: (iv_ruleXJTryWithResourcesVariableDeclaration= ruleXJTryWithResourcesVariableDeclaration EOF )
			// InternalDsl.g:6734:2: iv_ruleXJTryWithResourcesVariableDeclaration= ruleXJTryWithResourcesVariableDeclaration EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJTryWithResourcesVariableDeclarationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJTryWithResourcesVariableDeclaration=ruleXJTryWithResourcesVariableDeclaration();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJTryWithResourcesVariableDeclaration; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJTryWithResourcesVariableDeclaration"



	// $ANTLR start "ruleXJTryWithResourcesVariableDeclaration"
	// InternalDsl.g:6740:1: ruleXJTryWithResourcesVariableDeclaration returns [EObject current=null] : ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ( (lv_semicolon_6_0= ';' ) )? ) ;
	public final EObject ruleXJTryWithResourcesVariableDeclaration() throws RecognitionException {
		EObject current = null;


		Token lv_final_1_0=null;
		Token otherlv_4=null;
		Token lv_semicolon_6_0=null;
		EObject lv_type_2_0 =null;
		AntlrDatatypeRuleToken lv_name_3_0 =null;
		EObject lv_right_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6746:2: ( ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ( (lv_semicolon_6_0= ';' ) )? ) )
			// InternalDsl.g:6747:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ( (lv_semicolon_6_0= ';' ) )? )
			{
			// InternalDsl.g:6747:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ( (lv_semicolon_6_0= ';' ) )? )
			// InternalDsl.g:6748:3: () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ( (lv_semicolon_6_0= ';' ) )?
			{
			// InternalDsl.g:6748:3: ()
			// InternalDsl.g:6749:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJTryWithResourcesVariableDeclarationAccess().getXJTryWithResourcesVariableDeclarationAction_0(),
								current);
						}
			}

			// InternalDsl.g:6755:3: ( (lv_final_1_0= 'final' ) )?
			int alt109=2;
			int LA109_0 = input.LA(1);
			if ( (LA109_0==90) ) {
				alt109=1;
			}
			switch (alt109) {
				case 1 :
					// InternalDsl.g:6756:4: (lv_final_1_0= 'final' )
					{
					// InternalDsl.g:6756:4: (lv_final_1_0= 'final' )
					// InternalDsl.g:6757:5: lv_final_1_0= 'final'
					{
					lv_final_1_0=(Token)match(input,90,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(lv_final_1_0, grammarAccess.getXJTryWithResourcesVariableDeclarationAccess().getFinalFinalKeyword_1_0());
									}
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getXJTryWithResourcesVariableDeclarationRule());
										}
										setWithLastConsumed(current, "final", lv_final_1_0 != null, "final");
									}
					}

					}
					break;

			}

			// InternalDsl.g:6769:3: ( (lv_type_2_0= ruleJvmTypeReference ) )
			// InternalDsl.g:6770:4: (lv_type_2_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:6770:4: (lv_type_2_0= ruleJvmTypeReference )
			// InternalDsl.g:6771:5: lv_type_2_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJTryWithResourcesVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_23);
			lv_type_2_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXJTryWithResourcesVariableDeclarationRule());
								}
								set(
									current,
									"type",
									lv_type_2_0,
									"jbase.Jbase.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:6788:3: ( (lv_name_3_0= ruleValidID ) )
			// InternalDsl.g:6789:4: (lv_name_3_0= ruleValidID )
			{
			// InternalDsl.g:6789:4: (lv_name_3_0= ruleValidID )
			// InternalDsl.g:6790:5: lv_name_3_0= ruleValidID
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJTryWithResourcesVariableDeclarationAccess().getNameValidIDParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_16);
			lv_name_3_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXJTryWithResourcesVariableDeclarationRule());
								}
								set(
									current,
									"name",
									lv_name_3_0,
									"org.eclipse.xtext.xbase.Xtype.ValidID");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,45,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXJTryWithResourcesVariableDeclarationAccess().getEqualsSignKeyword_4());
					}
			// InternalDsl.g:6811:3: ( (lv_right_5_0= ruleXExpression ) )
			// InternalDsl.g:6812:4: (lv_right_5_0= ruleXExpression )
			{
			// InternalDsl.g:6812:4: (lv_right_5_0= ruleXExpression )
			// InternalDsl.g:6813:5: lv_right_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXJTryWithResourcesVariableDeclarationAccess().getRightXExpressionParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_61);
			lv_right_5_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXJTryWithResourcesVariableDeclarationRule());
								}
								set(
									current,
									"right",
									lv_right_5_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:6830:3: ( (lv_semicolon_6_0= ';' ) )?
			int alt110=2;
			int LA110_0 = input.LA(1);
			if ( (LA110_0==41) ) {
				alt110=1;
			}
			switch (alt110) {
				case 1 :
					// InternalDsl.g:6831:4: (lv_semicolon_6_0= ';' )
					{
					// InternalDsl.g:6831:4: (lv_semicolon_6_0= ';' )
					// InternalDsl.g:6832:5: lv_semicolon_6_0= ';'
					{
					lv_semicolon_6_0=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(lv_semicolon_6_0, grammarAccess.getXJTryWithResourcesVariableDeclarationAccess().getSemicolonSemicolonKeyword_6_0());
									}
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getXJTryWithResourcesVariableDeclarationRule());
										}
										setWithLastConsumed(current, "semicolon", lv_semicolon_6_0, ";");
									}
					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJTryWithResourcesVariableDeclaration"



	// $ANTLR start "entryRuleXTryCatchFinallyExpression"
	// InternalDsl.g:6848:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] :iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
	public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXTryCatchFinallyExpression =null;

		try {
			// InternalDsl.g:6848:67: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
			// InternalDsl.g:6849:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXTryCatchFinallyExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXTryCatchFinallyExpression"



	// $ANTLR start "ruleXTryCatchFinallyExpression"
	// InternalDsl.g:6855:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXBlockExpression ) ) ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) ) ) ;
	public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_expression_2_0 =null;
		EObject lv_catchClauses_3_0 =null;
		EObject lv_finallyExpression_5_0 =null;
		EObject lv_finallyExpression_7_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6861:2: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXBlockExpression ) ) ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) ) ) )
			// InternalDsl.g:6862:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXBlockExpression ) ) ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) ) )
			{
			// InternalDsl.g:6862:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXBlockExpression ) ) ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) ) )
			// InternalDsl.g:6863:3: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXBlockExpression ) ) ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) )
			{
			// InternalDsl.g:6863:3: ()
			// InternalDsl.g:6864:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,105,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
					}
			// InternalDsl.g:6874:3: ( (lv_expression_2_0= ruleXBlockExpression ) )
			// InternalDsl.g:6875:4: (lv_expression_2_0= ruleXBlockExpression )
			{
			// InternalDsl.g:6875:4: (lv_expression_2_0= ruleXBlockExpression )
			// InternalDsl.g:6876:5: lv_expression_2_0= ruleXBlockExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXBlockExpressionParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_97);
			lv_expression_2_0=ruleXBlockExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
								}
								set(
									current,
									"expression",
									lv_expression_2_0,
									"jbase.Jbase.XBlockExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:6893:3: ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) )
			int alt113=2;
			int LA113_0 = input.LA(1);
			if ( (LA113_0==81) ) {
				alt113=1;
			}
			else if ( (LA113_0==91) ) {
				alt113=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 113, 0, input);
				throw nvae;
			}

			switch (alt113) {
				case 1 :
					// InternalDsl.g:6894:4: ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? )
					{
					// InternalDsl.g:6894:4: ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? )
					// InternalDsl.g:6895:5: ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )?
					{
					// InternalDsl.g:6895:5: ( (lv_catchClauses_3_0= ruleXCatchClause ) )+
					int cnt111=0;
					loop111:
					while (true) {
						int alt111=2;
						int LA111_0 = input.LA(1);
						if ( (LA111_0==81) ) {
							alt111=1;
						}

						switch (alt111) {
						case 1 :
							// InternalDsl.g:6896:6: (lv_catchClauses_3_0= ruleXCatchClause )
							{
							// InternalDsl.g:6896:6: (lv_catchClauses_3_0= ruleXCatchClause )
							// InternalDsl.g:6897:7: lv_catchClauses_3_0= ruleXCatchClause
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0());
													}
							pushFollow(FOLLOW_96);
							lv_catchClauses_3_0=ruleXCatchClause();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
														}
														add(
															current,
															"catchClauses",
															lv_catchClauses_3_0,
															"jbase.Jbase.XCatchClause");
														afterParserOrEnumRuleCall();
													}
							}

							}
							break;

						default :
							if ( cnt111 >= 1 ) break loop111;
							if (state.backtracking>0) {state.failed=true; return current;}
							EarlyExitException eee = new EarlyExitException(111, input);
							throw eee;
						}
						cnt111++;
					}

					// InternalDsl.g:6914:5: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )?
					int alt112=2;
					int LA112_0 = input.LA(1);
					if ( (LA112_0==91) && (synpred38_InternalDsl())) {
						alt112=1;
					}
					switch (alt112) {
						case 1 :
							// InternalDsl.g:6915:6: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) )
							{
							// InternalDsl.g:6915:6: ( ( 'finally' )=>otherlv_4= 'finally' )
							// InternalDsl.g:6916:7: ( 'finally' )=>otherlv_4= 'finally'
							{
							otherlv_4=(Token)match(input,91,FOLLOW_9); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
													}
							}

							// InternalDsl.g:6922:6: ( (lv_finallyExpression_5_0= ruleXBlockExpression ) )
							// InternalDsl.g:6923:7: (lv_finallyExpression_5_0= ruleXBlockExpression )
							{
							// InternalDsl.g:6923:7: (lv_finallyExpression_5_0= ruleXBlockExpression )
							// InternalDsl.g:6924:8: lv_finallyExpression_5_0= ruleXBlockExpression
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXBlockExpressionParserRuleCall_3_0_1_1_0());
														}
							pushFollow(FOLLOW_2);
							lv_finallyExpression_5_0=ruleXBlockExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
															}
															set(
																current,
																"finallyExpression",
																lv_finallyExpression_5_0,
																"jbase.Jbase.XBlockExpression");
															afterParserOrEnumRuleCall();
														}
							}

							}

							}
							break;

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:6944:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) )
					{
					// InternalDsl.g:6944:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) )
					// InternalDsl.g:6945:5: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) )
					{
					otherlv_6=(Token)match(input,91,FOLLOW_9); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
									}
					// InternalDsl.g:6949:5: ( (lv_finallyExpression_7_0= ruleXBlockExpression ) )
					// InternalDsl.g:6950:6: (lv_finallyExpression_7_0= ruleXBlockExpression )
					{
					// InternalDsl.g:6950:6: (lv_finallyExpression_7_0= ruleXBlockExpression )
					// InternalDsl.g:6951:7: lv_finallyExpression_7_0= ruleXBlockExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXBlockExpressionParserRuleCall_3_1_1_0());
											}
					pushFollow(FOLLOW_2);
					lv_finallyExpression_7_0=ruleXBlockExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
												}
												set(
													current,
													"finallyExpression",
													lv_finallyExpression_7_0,
													"jbase.Jbase.XBlockExpression");
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXTryCatchFinallyExpression"



	// $ANTLR start "entryRuleXCatchClause"
	// InternalDsl.g:6974:1: entryRuleXCatchClause returns [EObject current=null] :iv_ruleXCatchClause= ruleXCatchClause EOF ;
	public final EObject entryRuleXCatchClause() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCatchClause =null;

		try {
			// InternalDsl.g:6974:53: (iv_ruleXCatchClause= ruleXCatchClause EOF )
			// InternalDsl.g:6975:2: iv_ruleXCatchClause= ruleXCatchClause EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXCatchClauseRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXCatchClause=ruleXCatchClause();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXCatchClause; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXCatchClause"



	// $ANTLR start "ruleXCatchClause"
	// InternalDsl.g:6981:1: ruleXCatchClause returns [EObject current=null] : ( () ( ( 'catch' )=>otherlv_1= 'catch' ) otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ) ;
	public final EObject ruleXCatchClause() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_declaredParam_3_0 =null;
		EObject lv_expression_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6987:2: ( ( () ( ( 'catch' )=>otherlv_1= 'catch' ) otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ) )
			// InternalDsl.g:6988:2: ( () ( ( 'catch' )=>otherlv_1= 'catch' ) otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) )
			{
			// InternalDsl.g:6988:2: ( () ( ( 'catch' )=>otherlv_1= 'catch' ) otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) )
			// InternalDsl.g:6989:3: () ( ( 'catch' )=>otherlv_1= 'catch' ) otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) )
			{
			// InternalDsl.g:6989:3: ()
			// InternalDsl.g:6990:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXCatchClauseAccess().getXCatchClauseAction_0(),
								current);
						}
			}

			// InternalDsl.g:6996:3: ( ( 'catch' )=>otherlv_1= 'catch' )
			// InternalDsl.g:6997:4: ( 'catch' )=>otherlv_1= 'catch'
			{
			otherlv_1=(Token)match(input,81,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
							newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getCatchKeyword_1());
						}
			}

			otherlv_2=(Token)match(input,22,FOLLOW_87); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:7007:3: ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) )
			// InternalDsl.g:7008:4: (lv_declaredParam_3_0= ruleFullJvmFormalParameter )
			{
			// InternalDsl.g:7008:4: (lv_declaredParam_3_0= ruleFullJvmFormalParameter )
			// InternalDsl.g:7009:5: lv_declaredParam_3_0= ruleFullJvmFormalParameter
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_8);
			lv_declaredParam_3_0=ruleFullJvmFormalParameter();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
								}
								set(
									current,
									"declaredParam",
									lv_declaredParam_3_0,
									"jbase.Jbase.FullJvmFormalParameter");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_4());
					}
			// InternalDsl.g:7030:3: ( (lv_expression_5_0= ruleXBlockExpression ) )
			// InternalDsl.g:7031:4: (lv_expression_5_0= ruleXBlockExpression )
			{
			// InternalDsl.g:7031:4: (lv_expression_5_0= ruleXBlockExpression )
			// InternalDsl.g:7032:5: lv_expression_5_0= ruleXBlockExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXBlockExpressionParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_2);
			lv_expression_5_0=ruleXBlockExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
								}
								set(
									current,
									"expression",
									lv_expression_5_0,
									"jbase.Jbase.XBlockExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXCatchClause"



	// $ANTLR start "entryRuleXSynchronizedExpression"
	// InternalDsl.g:7053:1: entryRuleXSynchronizedExpression returns [EObject current=null] :iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF ;
	public final EObject entryRuleXSynchronizedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSynchronizedExpression =null;

		try {
			// InternalDsl.g:7053:64: (iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF )
			// InternalDsl.g:7054:2: iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXSynchronizedExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXSynchronizedExpression=ruleXSynchronizedExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXSynchronizedExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXSynchronizedExpression"



	// $ANTLR start "ruleXSynchronizedExpression"
	// InternalDsl.g:7060:1: ruleXSynchronizedExpression returns [EObject current=null] : ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ) ;
	public final EObject ruleXSynchronizedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_param_3_0 =null;
		EObject lv_expression_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7066:2: ( ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ) )
			// InternalDsl.g:7067:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) )
			{
			// InternalDsl.g:7067:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) )
			// InternalDsl.g:7068:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) )
			{
			// InternalDsl.g:7068:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) )
			// InternalDsl.g:7069:4: ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' )
			{
			// InternalDsl.g:7076:4: ( () otherlv_1= 'synchronized' otherlv_2= '(' )
			// InternalDsl.g:7077:5: () otherlv_1= 'synchronized' otherlv_2= '('
			{
			// InternalDsl.g:7077:5: ()
			// InternalDsl.g:7078:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXSynchronizedExpressionAccess().getXSynchronizedExpressionAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,102,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXSynchronizedExpressionAccess().getSynchronizedKeyword_0_0_1());
							}
			otherlv_2=(Token)match(input,22,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_2, grammarAccess.getXSynchronizedExpressionAccess().getLeftParenthesisKeyword_0_0_2());
							}
			}

			}

			// InternalDsl.g:7094:3: ( (lv_param_3_0= ruleXExpression ) )
			// InternalDsl.g:7095:4: (lv_param_3_0= ruleXExpression )
			{
			// InternalDsl.g:7095:4: (lv_param_3_0= ruleXExpression )
			// InternalDsl.g:7096:5: lv_param_3_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getParamXExpressionParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_8);
			lv_param_3_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
								}
								set(
									current,
									"param",
									lv_param_3_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXSynchronizedExpressionAccess().getRightParenthesisKeyword_2());
					}
			// InternalDsl.g:7117:3: ( (lv_expression_5_0= ruleXBlockExpression ) )
			// InternalDsl.g:7118:4: (lv_expression_5_0= ruleXBlockExpression )
			{
			// InternalDsl.g:7118:4: (lv_expression_5_0= ruleXBlockExpression )
			// InternalDsl.g:7119:5: lv_expression_5_0= ruleXBlockExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getExpressionXBlockExpressionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_2);
			lv_expression_5_0=ruleXBlockExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
								}
								set(
									current,
									"expression",
									lv_expression_5_0,
									"jbase.Jbase.XBlockExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXSynchronizedExpression"



	// $ANTLR start "entryRuleXPrimaryExpression"
	// InternalDsl.g:7140:1: entryRuleXPrimaryExpression returns [EObject current=null] :iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
	public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXPrimaryExpression =null;

		try {
			// InternalDsl.g:7140:59: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
			// InternalDsl.g:7141:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXPrimaryExpression=ruleXPrimaryExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXPrimaryExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXPrimaryExpression"



	// $ANTLR start "ruleXPrimaryExpression"
	// InternalDsl.g:7147:1: ruleXPrimaryExpression returns [EObject current=null] : ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall ) |this_XConstructorCall_1= ruleXConstructorCall |this_XJFeatureCallWithArrayAccess_2= ruleXJFeatureCallWithArrayAccess |this_XLiteral_3= ruleXLiteral |this_XParenthesizedExpression_4= ruleXParenthesizedExpression ) ;
	public final EObject ruleXPrimaryExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XJArrayConstructorCall_0 =null;
		EObject this_XConstructorCall_1 =null;
		EObject this_XJFeatureCallWithArrayAccess_2 =null;
		EObject this_XLiteral_3 =null;
		EObject this_XParenthesizedExpression_4 =null;


			enterRule();

		try {
			// InternalDsl.g:7153:2: ( ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall ) |this_XConstructorCall_1= ruleXConstructorCall |this_XJFeatureCallWithArrayAccess_2= ruleXJFeatureCallWithArrayAccess |this_XLiteral_3= ruleXLiteral |this_XParenthesizedExpression_4= ruleXParenthesizedExpression ) )
			// InternalDsl.g:7154:2: ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall ) |this_XConstructorCall_1= ruleXConstructorCall |this_XJFeatureCallWithArrayAccess_2= ruleXJFeatureCallWithArrayAccess |this_XLiteral_3= ruleXLiteral |this_XParenthesizedExpression_4= ruleXParenthesizedExpression )
			{
			// InternalDsl.g:7154:2: ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall ) |this_XConstructorCall_1= ruleXConstructorCall |this_XJFeatureCallWithArrayAccess_2= ruleXJFeatureCallWithArrayAccess |this_XLiteral_3= ruleXLiteral |this_XParenthesizedExpression_4= ruleXParenthesizedExpression )
			int alt114=5;
			switch ( input.LA(1) ) {
			case 96:
				{
				int LA114_1 = input.LA(2);
				if ( (synpred41_InternalDsl()) ) {
					alt114=1;
				}
				else if ( (true) ) {
					alt114=2;
				}

				}
				break;
			case RULE_ID:
			case 87:
			case 88:
			case 94:
			case 99:
			case 100:
				{
				alt114=3;
				}
				break;
			case RULE_CHARACTER:
			case RULE_DECIMAL:
			case RULE_HEX:
			case RULE_INT:
			case RULE_STRING:
			case 89:
			case 97:
			case 104:
			case 107:
				{
				alt114=4;
				}
				break;
			case 22:
				{
				alt114=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 114, 0, input);
				throw nvae;
			}
			switch (alt114) {
				case 1 :
					// InternalDsl.g:7155:3: ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall )
					{
					// InternalDsl.g:7155:3: ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall )
					// InternalDsl.g:7156:4: ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXJArrayConstructorCallParserRuleCall_0());
								}
					pushFollow(FOLLOW_2);
					this_XJArrayConstructorCall_0=ruleXJArrayConstructorCall();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XJArrayConstructorCall_0;
									afterParserOrEnumRuleCall();
								}
					}

					}
					break;
				case 2 :
					// InternalDsl.g:7182:3: this_XConstructorCall_1= ruleXConstructorCall
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XConstructorCall_1=ruleXConstructorCall();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XConstructorCall_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 3 :
					// InternalDsl.g:7191:3: this_XJFeatureCallWithArrayAccess_2= ruleXJFeatureCallWithArrayAccess
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXJFeatureCallWithArrayAccessParserRuleCall_2());
							}
					pushFollow(FOLLOW_2);
					this_XJFeatureCallWithArrayAccess_2=ruleXJFeatureCallWithArrayAccess();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XJFeatureCallWithArrayAccess_2;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 4 :
					// InternalDsl.g:7200:3: this_XLiteral_3= ruleXLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_3());
							}
					pushFollow(FOLLOW_2);
					this_XLiteral_3=ruleXLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XLiteral_3;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 5 :
					// InternalDsl.g:7209:3: this_XParenthesizedExpression_4= ruleXParenthesizedExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_4());
							}
					pushFollow(FOLLOW_2);
					this_XParenthesizedExpression_4=ruleXParenthesizedExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XParenthesizedExpression_4;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXPrimaryExpression"



	// $ANTLR start "entryRuleXLiteral"
	// InternalDsl.g:7221:1: entryRuleXLiteral returns [EObject current=null] :iv_ruleXLiteral= ruleXLiteral EOF ;
	public final EObject entryRuleXLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXLiteral =null;

		try {
			// InternalDsl.g:7221:49: (iv_ruleXLiteral= ruleXLiteral EOF )
			// InternalDsl.g:7222:2: iv_ruleXLiteral= ruleXLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXLiteral=ruleXLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXLiteral"



	// $ANTLR start "ruleXLiteral"
	// InternalDsl.g:7228:1: ruleXLiteral returns [EObject current=null] : (this_XBooleanLiteral_0= ruleXBooleanLiteral |this_XNumberLiteral_1= ruleXNumberLiteral |this_XNullLiteral_2= ruleXNullLiteral |this_XCharLiteral_3= ruleXCharLiteral |this_XStringLiteral_4= ruleXStringLiteral |this_XJArrayLiteral_5= ruleXJArrayLiteral ) ;
	public final EObject ruleXLiteral() throws RecognitionException {
		EObject current = null;


		EObject this_XBooleanLiteral_0 =null;
		EObject this_XNumberLiteral_1 =null;
		EObject this_XNullLiteral_2 =null;
		EObject this_XCharLiteral_3 =null;
		EObject this_XStringLiteral_4 =null;
		EObject this_XJArrayLiteral_5 =null;


			enterRule();

		try {
			// InternalDsl.g:7234:2: ( (this_XBooleanLiteral_0= ruleXBooleanLiteral |this_XNumberLiteral_1= ruleXNumberLiteral |this_XNullLiteral_2= ruleXNullLiteral |this_XCharLiteral_3= ruleXCharLiteral |this_XStringLiteral_4= ruleXStringLiteral |this_XJArrayLiteral_5= ruleXJArrayLiteral ) )
			// InternalDsl.g:7235:2: (this_XBooleanLiteral_0= ruleXBooleanLiteral |this_XNumberLiteral_1= ruleXNumberLiteral |this_XNullLiteral_2= ruleXNullLiteral |this_XCharLiteral_3= ruleXCharLiteral |this_XStringLiteral_4= ruleXStringLiteral |this_XJArrayLiteral_5= ruleXJArrayLiteral )
			{
			// InternalDsl.g:7235:2: (this_XBooleanLiteral_0= ruleXBooleanLiteral |this_XNumberLiteral_1= ruleXNumberLiteral |this_XNullLiteral_2= ruleXNullLiteral |this_XCharLiteral_3= ruleXCharLiteral |this_XStringLiteral_4= ruleXStringLiteral |this_XJArrayLiteral_5= ruleXJArrayLiteral )
			int alt115=6;
			switch ( input.LA(1) ) {
			case 89:
			case 104:
				{
				alt115=1;
				}
				break;
			case RULE_DECIMAL:
			case RULE_HEX:
			case RULE_INT:
				{
				alt115=2;
				}
				break;
			case 97:
				{
				alt115=3;
				}
				break;
			case RULE_CHARACTER:
				{
				alt115=4;
				}
				break;
			case RULE_STRING:
				{
				alt115=5;
				}
				break;
			case 107:
				{
				alt115=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 115, 0, input);
				throw nvae;
			}
			switch (alt115) {
				case 1 :
					// InternalDsl.g:7236:3: this_XBooleanLiteral_0= ruleXBooleanLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_XBooleanLiteral_0=ruleXBooleanLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XBooleanLiteral_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalDsl.g:7245:3: this_XNumberLiteral_1= ruleXNumberLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XNumberLiteral_1=ruleXNumberLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XNumberLiteral_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 3 :
					// InternalDsl.g:7254:3: this_XNullLiteral_2= ruleXNullLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_2());
							}
					pushFollow(FOLLOW_2);
					this_XNullLiteral_2=ruleXNullLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XNullLiteral_2;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 4 :
					// InternalDsl.g:7263:3: this_XCharLiteral_3= ruleXCharLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXCharLiteralParserRuleCall_3());
							}
					pushFollow(FOLLOW_2);
					this_XCharLiteral_3=ruleXCharLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XCharLiteral_3;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 5 :
					// InternalDsl.g:7272:3: this_XStringLiteral_4= ruleXStringLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4());
							}
					pushFollow(FOLLOW_2);
					this_XStringLiteral_4=ruleXStringLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XStringLiteral_4;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 6 :
					// InternalDsl.g:7281:3: this_XJArrayLiteral_5= ruleXJArrayLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXJArrayLiteralParserRuleCall_5());
							}
					pushFollow(FOLLOW_2);
					this_XJArrayLiteral_5=ruleXJArrayLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XJArrayLiteral_5;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXLiteral"



	// $ANTLR start "entryRuleXJArrayLiteral"
	// InternalDsl.g:7293:1: entryRuleXJArrayLiteral returns [EObject current=null] :iv_ruleXJArrayLiteral= ruleXJArrayLiteral EOF ;
	public final EObject entryRuleXJArrayLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJArrayLiteral =null;

		try {
			// InternalDsl.g:7293:55: (iv_ruleXJArrayLiteral= ruleXJArrayLiteral EOF )
			// InternalDsl.g:7294:2: iv_ruleXJArrayLiteral= ruleXJArrayLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXJArrayLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXJArrayLiteral=ruleXJArrayLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXJArrayLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXJArrayLiteral"



	// $ANTLR start "ruleXJArrayLiteral"
	// InternalDsl.g:7300:1: ruleXJArrayLiteral returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )? otherlv_5= '}' ) ;
	public final EObject ruleXJArrayLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		EObject lv_elements_2_0 =null;
		EObject lv_elements_4_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7306:2: ( ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )? otherlv_5= '}' ) )
			// InternalDsl.g:7307:2: ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )? otherlv_5= '}' )
			{
			// InternalDsl.g:7307:2: ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )? otherlv_5= '}' )
			// InternalDsl.g:7308:3: () otherlv_1= '{' ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )? otherlv_5= '}'
			{
			// InternalDsl.g:7308:3: ()
			// InternalDsl.g:7309:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJArrayLiteralAccess().getXJArrayLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,107,FOLLOW_98); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXJArrayLiteralAccess().getLeftCurlyBracketKeyword_1());
					}
			// InternalDsl.g:7319:3: ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )?
			int alt117=2;
			int LA117_0 = input.LA(1);
			if ( ((LA117_0 >= RULE_CHARACTER && LA117_0 <= RULE_INT)||LA117_0==RULE_STRING||LA117_0==14||LA117_0==22||(LA117_0 >= 28 && LA117_0 <= 29)||(LA117_0 >= 32 && LA117_0 <= 33)||(LA117_0 >= 87 && LA117_0 <= 89)||LA117_0==94||(LA117_0 >= 96 && LA117_0 <= 97)||(LA117_0 >= 99 && LA117_0 <= 100)||LA117_0==104||LA117_0==107||LA117_0==112) ) {
				alt117=1;
			}
			switch (alt117) {
				case 1 :
					// InternalDsl.g:7320:4: ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )*
					{
					// InternalDsl.g:7320:4: ( (lv_elements_2_0= ruleXExpression ) )
					// InternalDsl.g:7321:5: (lv_elements_2_0= ruleXExpression )
					{
					// InternalDsl.g:7321:5: (lv_elements_2_0= ruleXExpression )
					// InternalDsl.g:7322:6: lv_elements_2_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXJArrayLiteralAccess().getElementsXExpressionParserRuleCall_2_0_0());
										}
					pushFollow(FOLLOW_99);
					lv_elements_2_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXJArrayLiteralRule());
											}
											add(
												current,
												"elements",
												lv_elements_2_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:7339:4: (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )*
					loop116:
					while (true) {
						int alt116=2;
						int LA116_0 = input.LA(1);
						if ( (LA116_0==31) ) {
							alt116=1;
						}

						switch (alt116) {
						case 1 :
							// InternalDsl.g:7340:5: otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) )
							{
							otherlv_3=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_3, grammarAccess.getXJArrayLiteralAccess().getCommaKeyword_2_1_0());
											}
							// InternalDsl.g:7344:5: ( (lv_elements_4_0= ruleXExpression ) )
							// InternalDsl.g:7345:6: (lv_elements_4_0= ruleXExpression )
							{
							// InternalDsl.g:7345:6: (lv_elements_4_0= ruleXExpression )
							// InternalDsl.g:7346:7: lv_elements_4_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXJArrayLiteralAccess().getElementsXExpressionParserRuleCall_2_1_1_0());
													}
							pushFollow(FOLLOW_99);
							lv_elements_4_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXJArrayLiteralRule());
														}
														add(
															current,
															"elements",
															lv_elements_4_0,
															"org.eclipse.xtext.xbase.Xbase.XExpression");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop116;
						}
					}

					}
					break;

			}

			otherlv_5=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getXJArrayLiteralAccess().getRightCurlyBracketKeyword_3());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXJArrayLiteral"



	// $ANTLR start "entryRuleXCharLiteral"
	// InternalDsl.g:7373:1: entryRuleXCharLiteral returns [EObject current=null] :iv_ruleXCharLiteral= ruleXCharLiteral EOF ;
	public final EObject entryRuleXCharLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCharLiteral =null;

		try {
			// InternalDsl.g:7373:53: (iv_ruleXCharLiteral= ruleXCharLiteral EOF )
			// InternalDsl.g:7374:2: iv_ruleXCharLiteral= ruleXCharLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXCharLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXCharLiteral=ruleXCharLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXCharLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXCharLiteral"



	// $ANTLR start "ruleXCharLiteral"
	// InternalDsl.g:7380:1: ruleXCharLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_CHARACTER ) ) ) ;
	public final EObject ruleXCharLiteral() throws RecognitionException {
		EObject current = null;


		Token lv_value_1_0=null;


			enterRule();

		try {
			// InternalDsl.g:7386:2: ( ( () ( (lv_value_1_0= RULE_CHARACTER ) ) ) )
			// InternalDsl.g:7387:2: ( () ( (lv_value_1_0= RULE_CHARACTER ) ) )
			{
			// InternalDsl.g:7387:2: ( () ( (lv_value_1_0= RULE_CHARACTER ) ) )
			// InternalDsl.g:7388:3: () ( (lv_value_1_0= RULE_CHARACTER ) )
			{
			// InternalDsl.g:7388:3: ()
			// InternalDsl.g:7389:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXCharLiteralAccess().getXJCharLiteralAction_0(),
								current);
						}
			}

			// InternalDsl.g:7395:3: ( (lv_value_1_0= RULE_CHARACTER ) )
			// InternalDsl.g:7396:4: (lv_value_1_0= RULE_CHARACTER )
			{
			// InternalDsl.g:7396:4: (lv_value_1_0= RULE_CHARACTER )
			// InternalDsl.g:7397:5: lv_value_1_0= RULE_CHARACTER
			{
			lv_value_1_0=(Token)match(input,RULE_CHARACTER,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(lv_value_1_0, grammarAccess.getXCharLiteralAccess().getValueCHARACTERTerminalRuleCall_1_0());
							}
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXCharLiteralRule());
								}
								setWithLastConsumed(
									current,
									"value",
									lv_value_1_0,
									"jbase.Jbase.CHARACTER");
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXCharLiteral"



	// $ANTLR start "entryRuleXStringLiteral"
	// InternalDsl.g:7417:1: entryRuleXStringLiteral returns [EObject current=null] :iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
	public final EObject entryRuleXStringLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXStringLiteral =null;

		try {
			// InternalDsl.g:7417:55: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
			// InternalDsl.g:7418:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXStringLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXStringLiteral=ruleXStringLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXStringLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXStringLiteral"



	// $ANTLR start "ruleXStringLiteral"
	// InternalDsl.g:7424:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
	public final EObject ruleXStringLiteral() throws RecognitionException {
		EObject current = null;


		Token lv_value_1_0=null;


			enterRule();

		try {
			// InternalDsl.g:7430:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
			// InternalDsl.g:7431:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
			{
			// InternalDsl.g:7431:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
			// InternalDsl.g:7432:3: () ( (lv_value_1_0= RULE_STRING ) )
			{
			// InternalDsl.g:7432:3: ()
			// InternalDsl.g:7433:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
								current);
						}
			}

			// InternalDsl.g:7439:3: ( (lv_value_1_0= RULE_STRING ) )
			// InternalDsl.g:7440:4: (lv_value_1_0= RULE_STRING )
			{
			// InternalDsl.g:7440:4: (lv_value_1_0= RULE_STRING )
			// InternalDsl.g:7441:5: lv_value_1_0= RULE_STRING
			{
			lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(lv_value_1_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
							}
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXStringLiteralRule());
								}
								setWithLastConsumed(
									current,
									"value",
									lv_value_1_0,
									"jbase.Jbase.STRING");
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXStringLiteral"



	// $ANTLR start "entryRuleOpEquality"
	// InternalDsl.g:7461:1: entryRuleOpEquality returns [String current=null] :iv_ruleOpEquality= ruleOpEquality EOF ;
	public final String entryRuleOpEquality() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpEquality =null;

		try {
			// InternalDsl.g:7461:50: (iv_ruleOpEquality= ruleOpEquality EOF )
			// InternalDsl.g:7462:2: iv_ruleOpEquality= ruleOpEquality EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpEqualityRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpEquality=ruleOpEquality();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpEquality.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpEquality"



	// $ANTLR start "ruleOpEquality"
	// InternalDsl.g:7468:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' |kw= '!=' ) ;
	public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7474:2: ( (kw= '==' |kw= '!=' ) )
			// InternalDsl.g:7475:2: (kw= '==' |kw= '!=' )
			{
			// InternalDsl.g:7475:2: (kw= '==' |kw= '!=' )
			int alt118=2;
			int LA118_0 = input.LA(1);
			if ( (LA118_0==46) ) {
				alt118=1;
			}
			else if ( (LA118_0==15) ) {
				alt118=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 118, 0, input);
				throw nvae;
			}

			switch (alt118) {
				case 1 :
					// InternalDsl.g:7476:3: kw= '=='
					{
					kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:7482:3: kw= '!='
					{
					kw=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpEquality"



	// $ANTLR start "entryRuleOpMulti"
	// InternalDsl.g:7491:1: entryRuleOpMulti returns [String current=null] :iv_ruleOpMulti= ruleOpMulti EOF ;
	public final String entryRuleOpMulti() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpMulti =null;

		try {
			// InternalDsl.g:7491:47: (iv_ruleOpMulti= ruleOpMulti EOF )
			// InternalDsl.g:7492:2: iv_ruleOpMulti= ruleOpMulti EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpMultiRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpMulti=ruleOpMulti();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpMulti.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpMulti"



	// $ANTLR start "ruleOpMulti"
	// InternalDsl.g:7498:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' |kw= '/' |kw= '%' ) ;
	public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7504:2: ( (kw= '*' |kw= '/' |kw= '%' ) )
			// InternalDsl.g:7505:2: (kw= '*' |kw= '/' |kw= '%' )
			{
			// InternalDsl.g:7505:2: (kw= '*' |kw= '/' |kw= '%' )
			int alt119=3;
			switch ( input.LA(1) ) {
			case 26:
				{
				alt119=1;
				}
				break;
			case 38:
				{
				alt119=2;
				}
				break;
			case 17:
				{
				alt119=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 119, 0, input);
				throw nvae;
			}
			switch (alt119) {
				case 1 :
					// InternalDsl.g:7506:3: kw= '*'
					{
					kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:7512:3: kw= '/'
					{
					kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalDsl.g:7518:3: kw= '%'
					{
					kw=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_2());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpMulti"



	// $ANTLR start "entryRuleOpOther"
	// InternalDsl.g:7527:1: entryRuleOpOther returns [String current=null] :iv_ruleOpOther= ruleOpOther EOF ;
	public final String entryRuleOpOther() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpOther =null;

		try {
			// InternalDsl.g:7527:47: (iv_ruleOpOther= ruleOpOther EOF )
			// InternalDsl.g:7528:2: iv_ruleOpOther= ruleOpOther EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpOtherRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpOther=ruleOpOther();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpOther.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpOther"



	// $ANTLR start "ruleOpOther"
	// InternalDsl.g:7534:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) |kw= '<<' ) ;
	public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7540:2: ( ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) |kw= '<<' ) )
			// InternalDsl.g:7541:2: ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) |kw= '<<' )
			{
			// InternalDsl.g:7541:2: ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) |kw= '<<' )
			int alt121=2;
			int LA121_0 = input.LA(1);
			if ( (LA121_0==47) ) {
				alt121=1;
			}
			else if ( (LA121_0==43) ) {
				alt121=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 121, 0, input);
				throw nvae;
			}

			switch (alt121) {
				case 1 :
					// InternalDsl.g:7542:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) )
					{
					// InternalDsl.g:7542:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) )
					// InternalDsl.g:7543:4: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' )
					{
					kw=(Token)match(input,47,FOLLOW_100); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_0());
								}
					// InternalDsl.g:7548:4: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' )
					int alt120=2;
					int LA120_0 = input.LA(1);
					if ( (LA120_0==47) ) {
						int LA120_1 = input.LA(2);
						if ( (LA120_1==47) && (synpred42_InternalDsl())) {
							alt120=1;
						}
						else if ( (LA120_1==EOF||(LA120_1 >= RULE_CHARACTER && LA120_1 <= RULE_INT)||LA120_1==RULE_STRING||LA120_1==14||LA120_1==22||(LA120_1 >= 28 && LA120_1 <= 29)||(LA120_1 >= 32 && LA120_1 <= 33)||(LA120_1 >= 87 && LA120_1 <= 89)||LA120_1==94||(LA120_1 >= 96 && LA120_1 <= 97)||(LA120_1 >= 99 && LA120_1 <= 100)||LA120_1==104||LA120_1==107||LA120_1==112) ) {
							alt120=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return current;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 120, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 120, 0, input);
						throw nvae;
					}

					switch (alt120) {
						case 1 :
							// InternalDsl.g:7549:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
							{
							// InternalDsl.g:7549:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
							// InternalDsl.g:7550:6: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
							{
							// InternalDsl.g:7555:6: (kw= '>' kw= '>' )
							// InternalDsl.g:7556:7: kw= '>' kw= '>'
							{
							kw=(Token)match(input,47,FOLLOW_100); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														current.merge(kw);
														newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_0_0_0());
													}
							kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														current.merge(kw);
														newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_0_0_1());
													}
							}

							}

							}
							break;
						case 2 :
							// InternalDsl.g:7569:5: kw= '>'
							{
							kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(kw);
												newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_1());
											}
							}
							break;

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:7577:3: kw= '<<'
					{
					kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignLessThanSignKeyword_1());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpOther"



	// $ANTLR start "entryRuleXAndExpression"
	// InternalDsl.g:7586:1: entryRuleXAndExpression returns [EObject current=null] :iv_ruleXAndExpression= ruleXAndExpression EOF ;
	public final EObject entryRuleXAndExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAndExpression =null;

		try {
			// InternalDsl.g:7586:55: (iv_ruleXAndExpression= ruleXAndExpression EOF )
			// InternalDsl.g:7587:2: iv_ruleXAndExpression= ruleXAndExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXAndExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXAndExpression=ruleXAndExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXAndExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXAndExpression"



	// $ANTLR start "ruleXAndExpression"
	// InternalDsl.g:7593:1: ruleXAndExpression returns [EObject current=null] : (this_XBitwiseInclusiveOrExpression_0= ruleXBitwiseInclusiveOrExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )* ) ;
	public final EObject ruleXAndExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XBitwiseInclusiveOrExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7599:2: ( (this_XBitwiseInclusiveOrExpression_0= ruleXBitwiseInclusiveOrExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )* ) )
			// InternalDsl.g:7600:2: (this_XBitwiseInclusiveOrExpression_0= ruleXBitwiseInclusiveOrExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )* )
			{
			// InternalDsl.g:7600:2: (this_XBitwiseInclusiveOrExpression_0= ruleXBitwiseInclusiveOrExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )* )
			// InternalDsl.g:7601:3: this_XBitwiseInclusiveOrExpression_0= ruleXBitwiseInclusiveOrExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXAndExpressionAccess().getXBitwiseInclusiveOrExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_101);
			this_XBitwiseInclusiveOrExpression_0=ruleXBitwiseInclusiveOrExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XBitwiseInclusiveOrExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:7609:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )*
			loop122:
			while (true) {
				int alt122=2;
				int LA122_0 = input.LA(1);
				if ( (LA122_0==19) ) {
					int LA122_2 = input.LA(2);
					if ( (synpred43_InternalDsl()) ) {
						alt122=1;
					}

				}

				switch (alt122) {
				case 1 :
					// InternalDsl.g:7610:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) )
					{
					// InternalDsl.g:7610:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
					// InternalDsl.g:7611:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
					{
					// InternalDsl.g:7621:5: ( () ( ( ruleOpAnd ) ) )
					// InternalDsl.g:7622:6: () ( ( ruleOpAnd ) )
					{
					// InternalDsl.g:7622:6: ()
					// InternalDsl.g:7623:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:7629:6: ( ( ruleOpAnd ) )
					// InternalDsl.g:7630:7: ( ruleOpAnd )
					{
					// InternalDsl.g:7630:7: ( ruleOpAnd )
					// InternalDsl.g:7631:8: ruleOpAnd
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXAndExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_66);
					ruleOpAnd();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalDsl.g:7647:4: ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) )
					// InternalDsl.g:7648:5: (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression )
					{
					// InternalDsl.g:7648:5: (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression )
					// InternalDsl.g:7649:6: lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXBitwiseInclusiveOrExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_101);
					lv_rightOperand_3_0=ruleXBitwiseInclusiveOrExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXAndExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"jbase.Jbase.XBitwiseInclusiveOrExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop122;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXAndExpression"



	// $ANTLR start "entryRuleXBitwiseInclusiveOrExpression"
	// InternalDsl.g:7671:1: entryRuleXBitwiseInclusiveOrExpression returns [EObject current=null] :iv_ruleXBitwiseInclusiveOrExpression= ruleXBitwiseInclusiveOrExpression EOF ;
	public final EObject entryRuleXBitwiseInclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBitwiseInclusiveOrExpression =null;

		try {
			// InternalDsl.g:7671:70: (iv_ruleXBitwiseInclusiveOrExpression= ruleXBitwiseInclusiveOrExpression EOF )
			// InternalDsl.g:7672:2: iv_ruleXBitwiseInclusiveOrExpression= ruleXBitwiseInclusiveOrExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXBitwiseInclusiveOrExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXBitwiseInclusiveOrExpression=ruleXBitwiseInclusiveOrExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXBitwiseInclusiveOrExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXBitwiseInclusiveOrExpression"



	// $ANTLR start "ruleXBitwiseInclusiveOrExpression"
	// InternalDsl.g:7678:1: ruleXBitwiseInclusiveOrExpression returns [EObject current=null] : (this_XBitwiseExclusiveOrExpression_0= ruleXBitwiseExclusiveOrExpression ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )* ) ;
	public final EObject ruleXBitwiseInclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XBitwiseExclusiveOrExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7684:2: ( (this_XBitwiseExclusiveOrExpression_0= ruleXBitwiseExclusiveOrExpression ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )* ) )
			// InternalDsl.g:7685:2: (this_XBitwiseExclusiveOrExpression_0= ruleXBitwiseExclusiveOrExpression ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )* )
			{
			// InternalDsl.g:7685:2: (this_XBitwiseExclusiveOrExpression_0= ruleXBitwiseExclusiveOrExpression ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )* )
			// InternalDsl.g:7686:3: this_XBitwiseExclusiveOrExpression_0= ruleXBitwiseExclusiveOrExpression ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXBitwiseInclusiveOrExpressionAccess().getXBitwiseExclusiveOrExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_102);
			this_XBitwiseExclusiveOrExpression_0=ruleXBitwiseExclusiveOrExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XBitwiseExclusiveOrExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:7694:3: ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )*
			loop123:
			while (true) {
				int alt123=2;
				int LA123_0 = input.LA(1);
				if ( (LA123_0==108) ) {
					int LA123_2 = input.LA(2);
					if ( (synpred44_InternalDsl()) ) {
						alt123=1;
					}

				}

				switch (alt123) {
				case 1 :
					// InternalDsl.g:7695:4: ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) )
					{
					// InternalDsl.g:7695:4: ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) )
					// InternalDsl.g:7696:5: ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) )
					{
					// InternalDsl.g:7706:5: ( () ( ( ruleOpInclusiveOr ) ) )
					// InternalDsl.g:7707:6: () ( ( ruleOpInclusiveOr ) )
					{
					// InternalDsl.g:7707:6: ()
					// InternalDsl.g:7708:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXBitwiseInclusiveOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:7714:6: ( ( ruleOpInclusiveOr ) )
					// InternalDsl.g:7715:7: ( ruleOpInclusiveOr )
					{
					// InternalDsl.g:7715:7: ( ruleOpInclusiveOr )
					// InternalDsl.g:7716:8: ruleOpInclusiveOr
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXBitwiseInclusiveOrExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXBitwiseInclusiveOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_66);
					ruleOpInclusiveOr();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalDsl.g:7732:4: ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) )
					// InternalDsl.g:7733:5: (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression )
					{
					// InternalDsl.g:7733:5: (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression )
					// InternalDsl.g:7734:6: lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXBitwiseInclusiveOrExpressionAccess().getRightOperandXBitwiseExclusiveOrExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_102);
					lv_rightOperand_3_0=ruleXBitwiseExclusiveOrExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXBitwiseInclusiveOrExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"jbase.Jbase.XBitwiseExclusiveOrExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop123;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXBitwiseInclusiveOrExpression"



	// $ANTLR start "entryRuleOpInclusiveOr"
	// InternalDsl.g:7756:1: entryRuleOpInclusiveOr returns [String current=null] :iv_ruleOpInclusiveOr= ruleOpInclusiveOr EOF ;
	public final String entryRuleOpInclusiveOr() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpInclusiveOr =null;

		try {
			// InternalDsl.g:7756:53: (iv_ruleOpInclusiveOr= ruleOpInclusiveOr EOF )
			// InternalDsl.g:7757:2: iv_ruleOpInclusiveOr= ruleOpInclusiveOr EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpInclusiveOrRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpInclusiveOr=ruleOpInclusiveOr();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpInclusiveOr.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpInclusiveOr"



	// $ANTLR start "ruleOpInclusiveOr"
	// InternalDsl.g:7763:1: ruleOpInclusiveOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '|' ;
	public final AntlrDatatypeRuleToken ruleOpInclusiveOr() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7769:2: (kw= '|' )
			// InternalDsl.g:7770:2: kw= '|'
			{
			kw=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpInclusiveOrAccess().getVerticalLineKeyword());
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpInclusiveOr"



	// $ANTLR start "entryRuleXBitwiseExclusiveOrExpression"
	// InternalDsl.g:7778:1: entryRuleXBitwiseExclusiveOrExpression returns [EObject current=null] :iv_ruleXBitwiseExclusiveOrExpression= ruleXBitwiseExclusiveOrExpression EOF ;
	public final EObject entryRuleXBitwiseExclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBitwiseExclusiveOrExpression =null;

		try {
			// InternalDsl.g:7778:70: (iv_ruleXBitwiseExclusiveOrExpression= ruleXBitwiseExclusiveOrExpression EOF )
			// InternalDsl.g:7779:2: iv_ruleXBitwiseExclusiveOrExpression= ruleXBitwiseExclusiveOrExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXBitwiseExclusiveOrExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXBitwiseExclusiveOrExpression=ruleXBitwiseExclusiveOrExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXBitwiseExclusiveOrExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXBitwiseExclusiveOrExpression"



	// $ANTLR start "ruleXBitwiseExclusiveOrExpression"
	// InternalDsl.g:7785:1: ruleXBitwiseExclusiveOrExpression returns [EObject current=null] : (this_XBitwiseAndExpression_0= ruleXBitwiseAndExpression ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )* ) ;
	public final EObject ruleXBitwiseExclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XBitwiseAndExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7791:2: ( (this_XBitwiseAndExpression_0= ruleXBitwiseAndExpression ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )* ) )
			// InternalDsl.g:7792:2: (this_XBitwiseAndExpression_0= ruleXBitwiseAndExpression ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )* )
			{
			// InternalDsl.g:7792:2: (this_XBitwiseAndExpression_0= ruleXBitwiseAndExpression ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )* )
			// InternalDsl.g:7793:3: this_XBitwiseAndExpression_0= ruleXBitwiseAndExpression ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXBitwiseExclusiveOrExpressionAccess().getXBitwiseAndExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_103);
			this_XBitwiseAndExpression_0=ruleXBitwiseAndExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XBitwiseAndExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:7801:3: ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )*
			loop124:
			while (true) {
				int alt124=2;
				int LA124_0 = input.LA(1);
				if ( (LA124_0==77) ) {
					int LA124_2 = input.LA(2);
					if ( (synpred45_InternalDsl()) ) {
						alt124=1;
					}

				}

				switch (alt124) {
				case 1 :
					// InternalDsl.g:7802:4: ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) )
					{
					// InternalDsl.g:7802:4: ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) )
					// InternalDsl.g:7803:5: ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) )
					{
					// InternalDsl.g:7813:5: ( () ( ( ruleOpExclusiveOr ) ) )
					// InternalDsl.g:7814:6: () ( ( ruleOpExclusiveOr ) )
					{
					// InternalDsl.g:7814:6: ()
					// InternalDsl.g:7815:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXBitwiseExclusiveOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:7821:6: ( ( ruleOpExclusiveOr ) )
					// InternalDsl.g:7822:7: ( ruleOpExclusiveOr )
					{
					// InternalDsl.g:7822:7: ( ruleOpExclusiveOr )
					// InternalDsl.g:7823:8: ruleOpExclusiveOr
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXBitwiseExclusiveOrExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXBitwiseExclusiveOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_66);
					ruleOpExclusiveOr();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalDsl.g:7839:4: ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) )
					// InternalDsl.g:7840:5: (lv_rightOperand_3_0= ruleXBitwiseAndExpression )
					{
					// InternalDsl.g:7840:5: (lv_rightOperand_3_0= ruleXBitwiseAndExpression )
					// InternalDsl.g:7841:6: lv_rightOperand_3_0= ruleXBitwiseAndExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXBitwiseExclusiveOrExpressionAccess().getRightOperandXBitwiseAndExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_103);
					lv_rightOperand_3_0=ruleXBitwiseAndExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXBitwiseExclusiveOrExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"jbase.Jbase.XBitwiseAndExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop124;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXBitwiseExclusiveOrExpression"



	// $ANTLR start "entryRuleOpExclusiveOr"
	// InternalDsl.g:7863:1: entryRuleOpExclusiveOr returns [String current=null] :iv_ruleOpExclusiveOr= ruleOpExclusiveOr EOF ;
	public final String entryRuleOpExclusiveOr() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpExclusiveOr =null;

		try {
			// InternalDsl.g:7863:53: (iv_ruleOpExclusiveOr= ruleOpExclusiveOr EOF )
			// InternalDsl.g:7864:2: iv_ruleOpExclusiveOr= ruleOpExclusiveOr EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpExclusiveOrRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpExclusiveOr=ruleOpExclusiveOr();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpExclusiveOr.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpExclusiveOr"



	// $ANTLR start "ruleOpExclusiveOr"
	// InternalDsl.g:7870:1: ruleOpExclusiveOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '^' ;
	public final AntlrDatatypeRuleToken ruleOpExclusiveOr() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7876:2: (kw= '^' )
			// InternalDsl.g:7877:2: kw= '^'
			{
			kw=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpExclusiveOrAccess().getCircumflexAccentKeyword());
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpExclusiveOr"



	// $ANTLR start "entryRuleXBitwiseAndExpression"
	// InternalDsl.g:7885:1: entryRuleXBitwiseAndExpression returns [EObject current=null] :iv_ruleXBitwiseAndExpression= ruleXBitwiseAndExpression EOF ;
	public final EObject entryRuleXBitwiseAndExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBitwiseAndExpression =null;

		try {
			// InternalDsl.g:7885:62: (iv_ruleXBitwiseAndExpression= ruleXBitwiseAndExpression EOF )
			// InternalDsl.g:7886:2: iv_ruleXBitwiseAndExpression= ruleXBitwiseAndExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXBitwiseAndExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXBitwiseAndExpression=ruleXBitwiseAndExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXBitwiseAndExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXBitwiseAndExpression"



	// $ANTLR start "ruleXBitwiseAndExpression"
	// InternalDsl.g:7892:1: ruleXBitwiseAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
	public final EObject ruleXBitwiseAndExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XEqualityExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7898:2: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
			// InternalDsl.g:7899:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
			{
			// InternalDsl.g:7899:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
			// InternalDsl.g:7900:3: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXBitwiseAndExpressionAccess().getXEqualityExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_104);
			this_XEqualityExpression_0=ruleXEqualityExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XEqualityExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:7908:3: ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
			loop125:
			while (true) {
				int alt125=2;
				int LA125_0 = input.LA(1);
				if ( (LA125_0==20) ) {
					int LA125_2 = input.LA(2);
					if ( (synpred46_InternalDsl()) ) {
						alt125=1;
					}

				}

				switch (alt125) {
				case 1 :
					// InternalDsl.g:7909:4: ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
					{
					// InternalDsl.g:7909:4: ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) )
					// InternalDsl.g:7910:5: ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) )
					{
					// InternalDsl.g:7920:5: ( () ( ( ruleOpBitwiseAnd ) ) )
					// InternalDsl.g:7921:6: () ( ( ruleOpBitwiseAnd ) )
					{
					// InternalDsl.g:7921:6: ()
					// InternalDsl.g:7922:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXBitwiseAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:7928:6: ( ( ruleOpBitwiseAnd ) )
					// InternalDsl.g:7929:7: ( ruleOpBitwiseAnd )
					{
					// InternalDsl.g:7929:7: ( ruleOpBitwiseAnd )
					// InternalDsl.g:7930:8: ruleOpBitwiseAnd
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXBitwiseAndExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXBitwiseAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_66);
					ruleOpBitwiseAnd();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalDsl.g:7946:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
					// InternalDsl.g:7947:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
					{
					// InternalDsl.g:7947:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
					// InternalDsl.g:7948:6: lv_rightOperand_3_0= ruleXEqualityExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXBitwiseAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_104);
					lv_rightOperand_3_0=ruleXEqualityExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXBitwiseAndExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"org.eclipse.xtext.xbase.Xbase.XEqualityExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop125;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXBitwiseAndExpression"



	// $ANTLR start "entryRuleOpBitwiseAnd"
	// InternalDsl.g:7970:1: entryRuleOpBitwiseAnd returns [String current=null] :iv_ruleOpBitwiseAnd= ruleOpBitwiseAnd EOF ;
	public final String entryRuleOpBitwiseAnd() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpBitwiseAnd =null;

		try {
			// InternalDsl.g:7970:52: (iv_ruleOpBitwiseAnd= ruleOpBitwiseAnd EOF )
			// InternalDsl.g:7971:2: iv_ruleOpBitwiseAnd= ruleOpBitwiseAnd EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpBitwiseAndRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpBitwiseAnd=ruleOpBitwiseAnd();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpBitwiseAnd.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpBitwiseAnd"



	// $ANTLR start "ruleOpBitwiseAnd"
	// InternalDsl.g:7977:1: ruleOpBitwiseAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&' ;
	public final AntlrDatatypeRuleToken ruleOpBitwiseAnd() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7983:2: (kw= '&' )
			// InternalDsl.g:7984:2: kw= '&'
			{
			kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpBitwiseAndAccess().getAmpersandKeyword());
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpBitwiseAnd"



	// $ANTLR start "entryRuleOpUnary"
	// InternalDsl.g:7992:1: entryRuleOpUnary returns [String current=null] :iv_ruleOpUnary= ruleOpUnary EOF ;
	public final String entryRuleOpUnary() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpUnary =null;

		try {
			// InternalDsl.g:7992:47: (iv_ruleOpUnary= ruleOpUnary EOF )
			// InternalDsl.g:7993:2: iv_ruleOpUnary= ruleOpUnary EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpUnaryRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpUnary=ruleOpUnary();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpUnary.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpUnary"



	// $ANTLR start "ruleOpUnary"
	// InternalDsl.g:7999:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' |kw= '-' |kw= '+' |kw= '~' ) ;
	public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:8005:2: ( (kw= '!' |kw= '-' |kw= '+' |kw= '~' ) )
			// InternalDsl.g:8006:2: (kw= '!' |kw= '-' |kw= '+' |kw= '~' )
			{
			// InternalDsl.g:8006:2: (kw= '!' |kw= '-' |kw= '+' |kw= '~' )
			int alt126=4;
			switch ( input.LA(1) ) {
			case 14:
				{
				alt126=1;
				}
				break;
			case 32:
				{
				alt126=2;
				}
				break;
			case 28:
				{
				alt126=3;
				}
				break;
			case 112:
				{
				alt126=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 126, 0, input);
				throw nvae;
			}
			switch (alt126) {
				case 1 :
					// InternalDsl.g:8007:3: kw= '!'
					{
					kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:8013:3: kw= '-'
					{
					kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalDsl.g:8019:3: kw= '+'
					{
					kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalDsl.g:8025:3: kw= '~'
					{
					kw=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getTildeKeyword_3());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpUnary"



	// $ANTLR start "entryRuleXAnnotationElementValueOrCommaList"
	// InternalDsl.g:8034:1: entryRuleXAnnotationElementValueOrCommaList returns [EObject current=null] :iv_ruleXAnnotationElementValueOrCommaList= ruleXAnnotationElementValueOrCommaList EOF ;
	public final EObject entryRuleXAnnotationElementValueOrCommaList() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAnnotationElementValueOrCommaList =null;

		try {
			// InternalDsl.g:8034:75: (iv_ruleXAnnotationElementValueOrCommaList= ruleXAnnotationElementValueOrCommaList EOF )
			// InternalDsl.g:8035:2: iv_ruleXAnnotationElementValueOrCommaList= ruleXAnnotationElementValueOrCommaList EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXAnnotationElementValueOrCommaListRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXAnnotationElementValueOrCommaList=ruleXAnnotationElementValueOrCommaList();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXAnnotationElementValueOrCommaList; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXAnnotationElementValueOrCommaList"



	// $ANTLR start "ruleXAnnotationElementValueOrCommaList"
	// InternalDsl.g:8041:1: ruleXAnnotationElementValueOrCommaList returns [EObject current=null] : ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression ) ;
	public final EObject ruleXAnnotationElementValueOrCommaList() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		EObject lv_elements_2_0 =null;
		EObject lv_elements_4_0 =null;
		EObject this_XAnnotationOrExpression_6 =null;


			enterRule();

		try {
			// InternalDsl.g:8047:2: ( ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression ) )
			// InternalDsl.g:8048:2: ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression )
			{
			// InternalDsl.g:8048:2: ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression )
			int alt129=2;
			int LA129_0 = input.LA(1);
			if ( (LA129_0==107) ) {
				int LA129_1 = input.LA(2);
				if ( (synpred47_InternalDsl()) ) {
					alt129=1;
				}
				else if ( (true) ) {
					alt129=2;
				}

			}
			else if ( ((LA129_0 >= RULE_CHARACTER && LA129_0 <= RULE_INT)||LA129_0==RULE_STRING||LA129_0==14||LA129_0==22||(LA129_0 >= 28 && LA129_0 <= 29)||(LA129_0 >= 32 && LA129_0 <= 33)||LA129_0==50||(LA129_0 >= 87 && LA129_0 <= 89)||LA129_0==94||(LA129_0 >= 96 && LA129_0 <= 97)||(LA129_0 >= 99 && LA129_0 <= 100)||LA129_0==104||LA129_0==112) ) {
				alt129=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 129, 0, input);
				throw nvae;
			}

			switch (alt129) {
				case 1 :
					// InternalDsl.g:8049:3: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' )
					{
					// InternalDsl.g:8049:3: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' )
					// InternalDsl.g:8050:4: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}'
					{
					// InternalDsl.g:8050:4: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) )
					// InternalDsl.g:8051:5: ( ( () '{' ) )=> ( () otherlv_1= '{' )
					{
					// InternalDsl.g:8057:5: ( () otherlv_1= '{' )
					// InternalDsl.g:8058:6: () otherlv_1= '{'
					{
					// InternalDsl.g:8058:6: ()
					// InternalDsl.g:8059:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElement(
													grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXJArrayLiteralAction_0_0_0_0(),
													current);
											}
					}

					otherlv_1=(Token)match(input,107,FOLLOW_105); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_1, grammarAccess.getXAnnotationElementValueOrCommaListAccess().getLeftCurlyBracketKeyword_0_0_0_1());
										}
					}

					}

					// InternalDsl.g:8071:4: ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )?
					int alt128=2;
					int LA128_0 = input.LA(1);
					if ( ((LA128_0 >= RULE_CHARACTER && LA128_0 <= RULE_INT)||LA128_0==RULE_STRING||LA128_0==14||LA128_0==22||(LA128_0 >= 28 && LA128_0 <= 29)||(LA128_0 >= 32 && LA128_0 <= 33)||LA128_0==50||(LA128_0 >= 87 && LA128_0 <= 89)||LA128_0==94||(LA128_0 >= 96 && LA128_0 <= 97)||(LA128_0 >= 99 && LA128_0 <= 100)||LA128_0==104||LA128_0==107||LA128_0==112) ) {
						alt128=1;
					}
					switch (alt128) {
						case 1 :
							// InternalDsl.g:8072:5: ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )*
							{
							// InternalDsl.g:8072:5: ( (lv_elements_2_0= ruleXAnnotationOrExpression ) )
							// InternalDsl.g:8073:6: (lv_elements_2_0= ruleXAnnotationOrExpression )
							{
							// InternalDsl.g:8073:6: (lv_elements_2_0= ruleXAnnotationOrExpression )
							// InternalDsl.g:8074:7: lv_elements_2_0= ruleXAnnotationOrExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0());
													}
							pushFollow(FOLLOW_99);
							lv_elements_2_0=ruleXAnnotationOrExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXAnnotationElementValueOrCommaListRule());
														}
														add(
															current,
															"elements",
															lv_elements_2_0,
															"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationOrExpression");
														afterParserOrEnumRuleCall();
													}
							}

							}

							// InternalDsl.g:8091:5: (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )*
							loop127:
							while (true) {
								int alt127=2;
								int LA127_0 = input.LA(1);
								if ( (LA127_0==31) ) {
									alt127=1;
								}

								switch (alt127) {
								case 1 :
									// InternalDsl.g:8092:6: otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) )
									{
									otherlv_3=(Token)match(input,31,FOLLOW_106); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_3, grammarAccess.getXAnnotationElementValueOrCommaListAccess().getCommaKeyword_0_1_1_0());
														}
									// InternalDsl.g:8096:6: ( (lv_elements_4_0= ruleXAnnotationOrExpression ) )
									// InternalDsl.g:8097:7: (lv_elements_4_0= ruleXAnnotationOrExpression )
									{
									// InternalDsl.g:8097:7: (lv_elements_4_0= ruleXAnnotationOrExpression )
									// InternalDsl.g:8098:8: lv_elements_4_0= ruleXAnnotationOrExpression
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0());
																}
									pushFollow(FOLLOW_99);
									lv_elements_4_0=ruleXAnnotationOrExpression();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getXAnnotationElementValueOrCommaListRule());
																	}
																	add(
																		current,
																		"elements",
																		lv_elements_4_0,
																		"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationOrExpression");
																	afterParserOrEnumRuleCall();
																}
									}

									}

									}
									break;

								default :
									break loop127;
								}
							}

							}
							break;

					}

					otherlv_5=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_5, grammarAccess.getXAnnotationElementValueOrCommaListAccess().getRightCurlyBracketKeyword_0_2());
								}
					}

					}
					break;
				case 2 :
					// InternalDsl.g:8123:3: this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXAnnotationOrExpressionParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XAnnotationOrExpression_6=ruleXAnnotationOrExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XAnnotationOrExpression_6;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXAnnotationElementValueOrCommaList"



	// $ANTLR start "entryRuleXAnnotationElementValue"
	// InternalDsl.g:8135:1: entryRuleXAnnotationElementValue returns [EObject current=null] :iv_ruleXAnnotationElementValue= ruleXAnnotationElementValue EOF ;
	public final EObject entryRuleXAnnotationElementValue() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAnnotationElementValue =null;

		try {
			// InternalDsl.g:8135:64: (iv_ruleXAnnotationElementValue= ruleXAnnotationElementValue EOF )
			// InternalDsl.g:8136:2: iv_ruleXAnnotationElementValue= ruleXAnnotationElementValue EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXAnnotationElementValueRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXAnnotationElementValue=ruleXAnnotationElementValue();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXAnnotationElementValue; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXAnnotationElementValue"



	// $ANTLR start "ruleXAnnotationElementValue"
	// InternalDsl.g:8142:1: ruleXAnnotationElementValue returns [EObject current=null] : ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression ) ;
	public final EObject ruleXAnnotationElementValue() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		EObject lv_elements_2_0 =null;
		EObject lv_elements_4_0 =null;
		EObject this_XAnnotationOrExpression_6 =null;


			enterRule();

		try {
			// InternalDsl.g:8148:2: ( ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression ) )
			// InternalDsl.g:8149:2: ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression )
			{
			// InternalDsl.g:8149:2: ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression )
			int alt132=2;
			int LA132_0 = input.LA(1);
			if ( (LA132_0==107) ) {
				int LA132_1 = input.LA(2);
				if ( (synpred48_InternalDsl()) ) {
					alt132=1;
				}
				else if ( (true) ) {
					alt132=2;
				}

			}
			else if ( ((LA132_0 >= RULE_CHARACTER && LA132_0 <= RULE_INT)||LA132_0==RULE_STRING||LA132_0==14||LA132_0==22||(LA132_0 >= 28 && LA132_0 <= 29)||(LA132_0 >= 32 && LA132_0 <= 33)||LA132_0==50||(LA132_0 >= 87 && LA132_0 <= 89)||LA132_0==94||(LA132_0 >= 96 && LA132_0 <= 97)||(LA132_0 >= 99 && LA132_0 <= 100)||LA132_0==104||LA132_0==112) ) {
				alt132=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 132, 0, input);
				throw nvae;
			}

			switch (alt132) {
				case 1 :
					// InternalDsl.g:8150:3: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' )
					{
					// InternalDsl.g:8150:3: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' )
					// InternalDsl.g:8151:4: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}'
					{
					// InternalDsl.g:8151:4: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) )
					// InternalDsl.g:8152:5: ( ( () '{' ) )=> ( () otherlv_1= '{' )
					{
					// InternalDsl.g:8158:5: ( () otherlv_1= '{' )
					// InternalDsl.g:8159:6: () otherlv_1= '{'
					{
					// InternalDsl.g:8159:6: ()
					// InternalDsl.g:8160:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElement(
													grammarAccess.getXAnnotationElementValueAccess().getXJArrayLiteralAction_0_0_0_0(),
													current);
											}
					}

					otherlv_1=(Token)match(input,107,FOLLOW_105); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_1, grammarAccess.getXAnnotationElementValueAccess().getLeftCurlyBracketKeyword_0_0_0_1());
										}
					}

					}

					// InternalDsl.g:8172:4: ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )?
					int alt131=2;
					int LA131_0 = input.LA(1);
					if ( ((LA131_0 >= RULE_CHARACTER && LA131_0 <= RULE_INT)||LA131_0==RULE_STRING||LA131_0==14||LA131_0==22||(LA131_0 >= 28 && LA131_0 <= 29)||(LA131_0 >= 32 && LA131_0 <= 33)||LA131_0==50||(LA131_0 >= 87 && LA131_0 <= 89)||LA131_0==94||(LA131_0 >= 96 && LA131_0 <= 97)||(LA131_0 >= 99 && LA131_0 <= 100)||LA131_0==104||LA131_0==107||LA131_0==112) ) {
						alt131=1;
					}
					switch (alt131) {
						case 1 :
							// InternalDsl.g:8173:5: ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )*
							{
							// InternalDsl.g:8173:5: ( (lv_elements_2_0= ruleXAnnotationOrExpression ) )
							// InternalDsl.g:8174:6: (lv_elements_2_0= ruleXAnnotationOrExpression )
							{
							// InternalDsl.g:8174:6: (lv_elements_2_0= ruleXAnnotationOrExpression )
							// InternalDsl.g:8175:7: lv_elements_2_0= ruleXAnnotationOrExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0());
													}
							pushFollow(FOLLOW_99);
							lv_elements_2_0=ruleXAnnotationOrExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXAnnotationElementValueRule());
														}
														add(
															current,
															"elements",
															lv_elements_2_0,
															"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationOrExpression");
														afterParserOrEnumRuleCall();
													}
							}

							}

							// InternalDsl.g:8192:5: (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )*
							loop130:
							while (true) {
								int alt130=2;
								int LA130_0 = input.LA(1);
								if ( (LA130_0==31) ) {
									alt130=1;
								}

								switch (alt130) {
								case 1 :
									// InternalDsl.g:8193:6: otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) )
									{
									otherlv_3=(Token)match(input,31,FOLLOW_106); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_3, grammarAccess.getXAnnotationElementValueAccess().getCommaKeyword_0_1_1_0());
														}
									// InternalDsl.g:8197:6: ( (lv_elements_4_0= ruleXAnnotationOrExpression ) )
									// InternalDsl.g:8198:7: (lv_elements_4_0= ruleXAnnotationOrExpression )
									{
									// InternalDsl.g:8198:7: (lv_elements_4_0= ruleXAnnotationOrExpression )
									// InternalDsl.g:8199:8: lv_elements_4_0= ruleXAnnotationOrExpression
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0());
																}
									pushFollow(FOLLOW_99);
									lv_elements_4_0=ruleXAnnotationOrExpression();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getXAnnotationElementValueRule());
																	}
																	add(
																		current,
																		"elements",
																		lv_elements_4_0,
																		"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationOrExpression");
																	afterParserOrEnumRuleCall();
																}
									}

									}

									}
									break;

								default :
									break loop130;
								}
							}

							}
							break;

					}

					otherlv_5=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_5, grammarAccess.getXAnnotationElementValueAccess().getRightCurlyBracketKeyword_0_2());
								}
					}

					}
					break;
				case 2 :
					// InternalDsl.g:8224:3: this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getXAnnotationOrExpressionParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XAnnotationOrExpression_6=ruleXAnnotationOrExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XAnnotationOrExpression_6;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXAnnotationElementValue"



	// $ANTLR start "entryRuleXAnnotation"
	// InternalDsl.g:8236:1: entryRuleXAnnotation returns [EObject current=null] :iv_ruleXAnnotation= ruleXAnnotation EOF ;
	public final EObject entryRuleXAnnotation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAnnotation =null;

		try {
			// InternalDsl.g:8236:52: (iv_ruleXAnnotation= ruleXAnnotation EOF )
			// InternalDsl.g:8237:2: iv_ruleXAnnotation= ruleXAnnotation EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXAnnotationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXAnnotation=ruleXAnnotation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXAnnotation; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXAnnotation"



	// $ANTLR start "ruleXAnnotation"
	// InternalDsl.g:8243:1: ruleXAnnotation returns [EObject current=null] : ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )? ) ;
	public final EObject ruleXAnnotation() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token otherlv_8=null;
		EObject lv_elementValuePairs_4_0 =null;
		EObject lv_elementValuePairs_6_0 =null;
		EObject lv_value_7_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8249:2: ( ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )? ) )
			// InternalDsl.g:8250:2: ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )? )
			{
			// InternalDsl.g:8250:2: ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )? )
			// InternalDsl.g:8251:3: () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )?
			{
			// InternalDsl.g:8251:3: ()
			// InternalDsl.g:8252:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXAnnotationAccess().getXAnnotationAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,50,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXAnnotationAccess().getCommercialAtKeyword_1());
					}
			// InternalDsl.g:8262:3: ( ( ruleQualifiedName ) )
			// InternalDsl.g:8263:4: ( ruleQualifiedName )
			{
			// InternalDsl.g:8263:4: ( ruleQualifiedName )
			// InternalDsl.g:8264:5: ruleQualifiedName
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXAnnotationRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXAnnotationAccess().getAnnotationTypeJvmAnnotationTypeCrossReference_2_0());
							}
			pushFollow(FOLLOW_57);
			ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:8278:3: ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )?
			int alt135=2;
			int LA135_0 = input.LA(1);
			if ( (LA135_0==22) && (synpred49_InternalDsl())) {
				alt135=1;
			}
			switch (alt135) {
				case 1 :
					// InternalDsl.g:8279:4: ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')'
					{
					// InternalDsl.g:8279:4: ( ( '(' )=>otherlv_3= '(' )
					// InternalDsl.g:8280:5: ( '(' )=>otherlv_3= '('
					{
					otherlv_3=(Token)match(input,22,FOLLOW_107); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_3, grammarAccess.getXAnnotationAccess().getLeftParenthesisKeyword_3_0());
									}
					}

					// InternalDsl.g:8286:4: ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )?
					int alt134=3;
					int LA134_0 = input.LA(1);
					if ( (LA134_0==RULE_ID) ) {
						int LA134_1 = input.LA(2);
						if ( (synpred50_InternalDsl()) ) {
							alt134=1;
						}
						else if ( (true) ) {
							alt134=2;
						}
					}
					else if ( ((LA134_0 >= RULE_CHARACTER && LA134_0 <= RULE_HEX)||LA134_0==RULE_INT||LA134_0==RULE_STRING||LA134_0==14||LA134_0==22||(LA134_0 >= 28 && LA134_0 <= 29)||(LA134_0 >= 32 && LA134_0 <= 33)||LA134_0==50||(LA134_0 >= 87 && LA134_0 <= 89)||LA134_0==94||(LA134_0 >= 96 && LA134_0 <= 97)||(LA134_0 >= 99 && LA134_0 <= 100)||LA134_0==104||LA134_0==107||LA134_0==112) ) {
						alt134=2;
					}
					switch (alt134) {
						case 1 :
							// InternalDsl.g:8287:5: ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* )
							{
							// InternalDsl.g:8287:5: ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* )
							// InternalDsl.g:8288:6: ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )*
							{
							// InternalDsl.g:8288:6: ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) )
							// InternalDsl.g:8289:7: ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair )
							{
							// InternalDsl.g:8298:7: (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair )
							// InternalDsl.g:8299:8: lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXAnnotationAccess().getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_0_0());
														}
							pushFollow(FOLLOW_26);
							lv_elementValuePairs_4_0=ruleXAnnotationElementValuePair();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXAnnotationRule());
															}
															add(
																current,
																"elementValuePairs",
																lv_elementValuePairs_4_0,
																"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationElementValuePair");
															afterParserOrEnumRuleCall();
														}
							}

							}

							// InternalDsl.g:8316:6: (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )*
							loop133:
							while (true) {
								int alt133=2;
								int LA133_0 = input.LA(1);
								if ( (LA133_0==31) ) {
									alt133=1;
								}

								switch (alt133) {
								case 1 :
									// InternalDsl.g:8317:7: otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) )
									{
									otherlv_5=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_5, grammarAccess.getXAnnotationAccess().getCommaKeyword_3_1_0_1_0());
															}
									// InternalDsl.g:8321:7: ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) )
									// InternalDsl.g:8322:8: ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair )
									{
									// InternalDsl.g:8331:8: (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair )
									// InternalDsl.g:8332:9: lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXAnnotationAccess().getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_1_1_0());
																	}
									pushFollow(FOLLOW_26);
									lv_elementValuePairs_6_0=ruleXAnnotationElementValuePair();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																		if (current==null) {
																			current = createModelElementForParent(grammarAccess.getXAnnotationRule());
																		}
																		add(
																			current,
																			"elementValuePairs",
																			lv_elementValuePairs_6_0,
																			"org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations.XAnnotationElementValuePair");
																		afterParserOrEnumRuleCall();
																	}
									}

									}

									}
									break;

								default :
									break loop133;
								}
							}

							}

							}
							break;
						case 2 :
							// InternalDsl.g:8352:5: ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) )
							{
							// InternalDsl.g:8352:5: ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) )
							// InternalDsl.g:8353:6: (lv_value_7_0= ruleXAnnotationElementValueOrCommaList )
							{
							// InternalDsl.g:8353:6: (lv_value_7_0= ruleXAnnotationElementValueOrCommaList )
							// InternalDsl.g:8354:7: lv_value_7_0= ruleXAnnotationElementValueOrCommaList
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXAnnotationAccess().getValueXAnnotationElementValueOrCommaListParserRuleCall_3_1_1_0());
													}
							pushFollow(FOLLOW_8);
							lv_value_7_0=ruleXAnnotationElementValueOrCommaList();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXAnnotationRule());
														}
														set(
															current,
															"value",
															lv_value_7_0,
															"jbase.Jbase.XAnnotationElementValueOrCommaList");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

					}

					otherlv_8=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_8, grammarAccess.getXAnnotationAccess().getRightParenthesisKeyword_3_2());
								}
					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXAnnotation"



	// $ANTLR start "entryRuleXAnnotationElementValuePair"
	// InternalDsl.g:8381:1: entryRuleXAnnotationElementValuePair returns [EObject current=null] :iv_ruleXAnnotationElementValuePair= ruleXAnnotationElementValuePair EOF ;
	public final EObject entryRuleXAnnotationElementValuePair() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAnnotationElementValuePair =null;

		try {
			// InternalDsl.g:8381:68: (iv_ruleXAnnotationElementValuePair= ruleXAnnotationElementValuePair EOF )
			// InternalDsl.g:8382:2: iv_ruleXAnnotationElementValuePair= ruleXAnnotationElementValuePair EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXAnnotationElementValuePairRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXAnnotationElementValuePair=ruleXAnnotationElementValuePair();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXAnnotationElementValuePair; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXAnnotationElementValuePair"



	// $ANTLR start "ruleXAnnotationElementValuePair"
	// InternalDsl.g:8388:1: ruleXAnnotationElementValuePair returns [EObject current=null] : ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) ) ( (lv_value_2_0= ruleXAnnotationElementValue ) ) ) ;
	public final EObject ruleXAnnotationElementValuePair() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_value_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8394:2: ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) ) ( (lv_value_2_0= ruleXAnnotationElementValue ) ) ) )
			// InternalDsl.g:8395:2: ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) ) ( (lv_value_2_0= ruleXAnnotationElementValue ) ) )
			{
			// InternalDsl.g:8395:2: ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) ) ( (lv_value_2_0= ruleXAnnotationElementValue ) ) )
			// InternalDsl.g:8396:3: ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) ) ( (lv_value_2_0= ruleXAnnotationElementValue ) )
			{
			// InternalDsl.g:8396:3: ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) )
			// InternalDsl.g:8397:4: ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' )
			{
			// InternalDsl.g:8406:4: ( ( ( ruleValidID ) ) otherlv_1= '=' )
			// InternalDsl.g:8407:5: ( ( ruleValidID ) ) otherlv_1= '='
			{
			// InternalDsl.g:8407:5: ( ( ruleValidID ) )
			// InternalDsl.g:8408:6: ( ruleValidID )
			{
			// InternalDsl.g:8408:6: ( ruleValidID )
			// InternalDsl.g:8409:7: ruleValidID
			{
			if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getXAnnotationElementValuePairRule());
										}
									}
			if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXAnnotationElementValuePairAccess().getElementJvmOperationCrossReference_0_0_0_0());
									}
			pushFollow(FOLLOW_16);
			ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
										afterParserOrEnumRuleCall();
									}
			}

			}

			otherlv_1=(Token)match(input,45,FOLLOW_106); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXAnnotationElementValuePairAccess().getEqualsSignKeyword_0_0_1());
							}
			}

			}

			// InternalDsl.g:8429:3: ( (lv_value_2_0= ruleXAnnotationElementValue ) )
			// InternalDsl.g:8430:4: (lv_value_2_0= ruleXAnnotationElementValue )
			{
			// InternalDsl.g:8430:4: (lv_value_2_0= ruleXAnnotationElementValue )
			// InternalDsl.g:8431:5: lv_value_2_0= ruleXAnnotationElementValue
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXAnnotationElementValuePairAccess().getValueXAnnotationElementValueParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_value_2_0=ruleXAnnotationElementValue();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXAnnotationElementValuePairRule());
								}
								set(
									current,
									"value",
									lv_value_2_0,
									"jbase.Jbase.XAnnotationElementValue");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXAnnotationElementValuePair"



	// $ANTLR start "entryRuleXAnnotationOrExpression"
	// InternalDsl.g:8452:1: entryRuleXAnnotationOrExpression returns [EObject current=null] :iv_ruleXAnnotationOrExpression= ruleXAnnotationOrExpression EOF ;
	public final EObject entryRuleXAnnotationOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAnnotationOrExpression =null;

		try {
			// InternalDsl.g:8452:64: (iv_ruleXAnnotationOrExpression= ruleXAnnotationOrExpression EOF )
			// InternalDsl.g:8453:2: iv_ruleXAnnotationOrExpression= ruleXAnnotationOrExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXAnnotationOrExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXAnnotationOrExpression=ruleXAnnotationOrExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXAnnotationOrExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXAnnotationOrExpression"



	// $ANTLR start "ruleXAnnotationOrExpression"
	// InternalDsl.g:8459:1: ruleXAnnotationOrExpression returns [EObject current=null] : (this_XAnnotation_0= ruleXAnnotation |this_XExpression_1= ruleXExpression ) ;
	public final EObject ruleXAnnotationOrExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAnnotation_0 =null;
		EObject this_XExpression_1 =null;


			enterRule();

		try {
			// InternalDsl.g:8465:2: ( (this_XAnnotation_0= ruleXAnnotation |this_XExpression_1= ruleXExpression ) )
			// InternalDsl.g:8466:2: (this_XAnnotation_0= ruleXAnnotation |this_XExpression_1= ruleXExpression )
			{
			// InternalDsl.g:8466:2: (this_XAnnotation_0= ruleXAnnotation |this_XExpression_1= ruleXExpression )
			int alt136=2;
			int LA136_0 = input.LA(1);
			if ( (LA136_0==50) ) {
				alt136=1;
			}
			else if ( ((LA136_0 >= RULE_CHARACTER && LA136_0 <= RULE_INT)||LA136_0==RULE_STRING||LA136_0==14||LA136_0==22||(LA136_0 >= 28 && LA136_0 <= 29)||(LA136_0 >= 32 && LA136_0 <= 33)||(LA136_0 >= 87 && LA136_0 <= 89)||LA136_0==94||(LA136_0 >= 96 && LA136_0 <= 97)||(LA136_0 >= 99 && LA136_0 <= 100)||LA136_0==104||LA136_0==107||LA136_0==112) ) {
				alt136=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 136, 0, input);
				throw nvae;
			}

			switch (alt136) {
				case 1 :
					// InternalDsl.g:8467:3: this_XAnnotation_0= ruleXAnnotation
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXAnnotationOrExpressionAccess().getXAnnotationParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_XAnnotation_0=ruleXAnnotation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XAnnotation_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalDsl.g:8476:3: this_XExpression_1= ruleXExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXAnnotationOrExpressionAccess().getXExpressionParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XExpression_1=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XExpression_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXAnnotationOrExpression"



	// $ANTLR start "entryRuleXExpression"
	// InternalDsl.g:8488:1: entryRuleXExpression returns [EObject current=null] :iv_ruleXExpression= ruleXExpression EOF ;
	public final EObject entryRuleXExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpression =null;

		try {
			// InternalDsl.g:8488:52: (iv_ruleXExpression= ruleXExpression EOF )
			// InternalDsl.g:8489:2: iv_ruleXExpression= ruleXExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXExpression=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXExpression"



	// $ANTLR start "ruleXExpression"
	// InternalDsl.g:8495:1: ruleXExpression returns [EObject current=null] :this_XAssignment_0= ruleXAssignment ;
	public final EObject ruleXExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAssignment_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8501:2: (this_XAssignment_0= ruleXAssignment )
			// InternalDsl.g:8502:2: this_XAssignment_0= ruleXAssignment
			{
			if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall());
				}
			pushFollow(FOLLOW_2);
			this_XAssignment_0=ruleXAssignment();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current = this_XAssignment_0;
					afterParserOrEnumRuleCall();
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXExpression"



	// $ANTLR start "entryRuleOpSingleAssign"
	// InternalDsl.g:8513:1: entryRuleOpSingleAssign returns [String current=null] :iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
	public final String entryRuleOpSingleAssign() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpSingleAssign =null;

		try {
			// InternalDsl.g:8513:54: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
			// InternalDsl.g:8514:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpSingleAssignRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpSingleAssign=ruleOpSingleAssign();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpSingleAssign.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpSingleAssign"



	// $ANTLR start "ruleOpSingleAssign"
	// InternalDsl.g:8520:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
	public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:8526:2: (kw= '=' )
			// InternalDsl.g:8527:2: kw= '='
			{
			kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword());
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpSingleAssign"



	// $ANTLR start "entryRuleXOrExpression"
	// InternalDsl.g:8535:1: entryRuleXOrExpression returns [EObject current=null] :iv_ruleXOrExpression= ruleXOrExpression EOF ;
	public final EObject entryRuleXOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXOrExpression =null;

		try {
			// InternalDsl.g:8535:54: (iv_ruleXOrExpression= ruleXOrExpression EOF )
			// InternalDsl.g:8536:2: iv_ruleXOrExpression= ruleXOrExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXOrExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXOrExpression=ruleXOrExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXOrExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXOrExpression"



	// $ANTLR start "ruleXOrExpression"
	// InternalDsl.g:8542:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
	public final EObject ruleXOrExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAndExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8548:2: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
			// InternalDsl.g:8549:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
			{
			// InternalDsl.g:8549:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
			// InternalDsl.g:8550:3: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_108);
			this_XAndExpression_0=ruleXAndExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XAndExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:8558:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
			loop137:
			while (true) {
				int alt137=2;
				int LA137_0 = input.LA(1);
				if ( (LA137_0==110) ) {
					int LA137_2 = input.LA(2);
					if ( (synpred53_InternalDsl()) ) {
						alt137=1;
					}

				}

				switch (alt137) {
				case 1 :
					// InternalDsl.g:8559:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
					{
					// InternalDsl.g:8559:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
					// InternalDsl.g:8560:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
					{
					// InternalDsl.g:8570:5: ( () ( ( ruleOpOr ) ) )
					// InternalDsl.g:8571:6: () ( ( ruleOpOr ) )
					{
					// InternalDsl.g:8571:6: ()
					// InternalDsl.g:8572:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:8578:6: ( ( ruleOpOr ) )
					// InternalDsl.g:8579:7: ( ruleOpOr )
					{
					// InternalDsl.g:8579:7: ( ruleOpOr )
					// InternalDsl.g:8580:8: ruleOpOr
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXOrExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_66);
					ruleOpOr();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalDsl.g:8596:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
					// InternalDsl.g:8597:5: (lv_rightOperand_3_0= ruleXAndExpression )
					{
					// InternalDsl.g:8597:5: (lv_rightOperand_3_0= ruleXAndExpression )
					// InternalDsl.g:8598:6: lv_rightOperand_3_0= ruleXAndExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_108);
					lv_rightOperand_3_0=ruleXAndExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXOrExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"jbase.Jbase.XAndExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop137;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXOrExpression"



	// $ANTLR start "entryRuleOpOr"
	// InternalDsl.g:8620:1: entryRuleOpOr returns [String current=null] :iv_ruleOpOr= ruleOpOr EOF ;
	public final String entryRuleOpOr() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpOr =null;

		try {
			// InternalDsl.g:8620:44: (iv_ruleOpOr= ruleOpOr EOF )
			// InternalDsl.g:8621:2: iv_ruleOpOr= ruleOpOr EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpOrRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpOr=ruleOpOr();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpOr.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpOr"



	// $ANTLR start "ruleOpOr"
	// InternalDsl.g:8627:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
	public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:8633:2: (kw= '||' )
			// InternalDsl.g:8634:2: kw= '||'
			{
			kw=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword());
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpOr"



	// $ANTLR start "entryRuleOpAnd"
	// InternalDsl.g:8642:1: entryRuleOpAnd returns [String current=null] :iv_ruleOpAnd= ruleOpAnd EOF ;
	public final String entryRuleOpAnd() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpAnd =null;

		try {
			// InternalDsl.g:8642:45: (iv_ruleOpAnd= ruleOpAnd EOF )
			// InternalDsl.g:8643:2: iv_ruleOpAnd= ruleOpAnd EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpAndRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpAnd=ruleOpAnd();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpAnd.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpAnd"



	// $ANTLR start "ruleOpAnd"
	// InternalDsl.g:8649:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
	public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:8655:2: (kw= '&&' )
			// InternalDsl.g:8656:2: kw= '&&'
			{
			kw=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword());
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpAnd"



	// $ANTLR start "entryRuleXEqualityExpression"
	// InternalDsl.g:8664:1: entryRuleXEqualityExpression returns [EObject current=null] :iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
	public final EObject entryRuleXEqualityExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXEqualityExpression =null;

		try {
			// InternalDsl.g:8664:60: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
			// InternalDsl.g:8665:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXEqualityExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXEqualityExpression=ruleXEqualityExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXEqualityExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXEqualityExpression"



	// $ANTLR start "ruleXEqualityExpression"
	// InternalDsl.g:8671:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
	public final EObject ruleXEqualityExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XRelationalExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8677:2: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
			// InternalDsl.g:8678:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
			{
			// InternalDsl.g:8678:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
			// InternalDsl.g:8679:3: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_109);
			this_XRelationalExpression_0=ruleXRelationalExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XRelationalExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:8687:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
			loop138:
			while (true) {
				int alt138=2;
				int LA138_0 = input.LA(1);
				if ( (LA138_0==46) ) {
					int LA138_2 = input.LA(2);
					if ( (synpred54_InternalDsl()) ) {
						alt138=1;
					}

				}
				else if ( (LA138_0==15) ) {
					int LA138_3 = input.LA(2);
					if ( (synpred54_InternalDsl()) ) {
						alt138=1;
					}

				}

				switch (alt138) {
				case 1 :
					// InternalDsl.g:8688:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
					{
					// InternalDsl.g:8688:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
					// InternalDsl.g:8689:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
					{
					// InternalDsl.g:8699:5: ( () ( ( ruleOpEquality ) ) )
					// InternalDsl.g:8700:6: () ( ( ruleOpEquality ) )
					{
					// InternalDsl.g:8700:6: ()
					// InternalDsl.g:8701:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:8707:6: ( ( ruleOpEquality ) )
					// InternalDsl.g:8708:7: ( ruleOpEquality )
					{
					// InternalDsl.g:8708:7: ( ruleOpEquality )
					// InternalDsl.g:8709:8: ruleOpEquality
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXEqualityExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_66);
					ruleOpEquality();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalDsl.g:8725:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
					// InternalDsl.g:8726:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
					{
					// InternalDsl.g:8726:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
					// InternalDsl.g:8727:6: lv_rightOperand_3_0= ruleXRelationalExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_109);
					lv_rightOperand_3_0=ruleXRelationalExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXEqualityExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"org.eclipse.xtext.xbase.Xbase.XRelationalExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop138;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXEqualityExpression"



	// $ANTLR start "entryRuleXRelationalExpression"
	// InternalDsl.g:8749:1: entryRuleXRelationalExpression returns [EObject current=null] :iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
	public final EObject entryRuleXRelationalExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXRelationalExpression =null;

		try {
			// InternalDsl.g:8749:62: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
			// InternalDsl.g:8750:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXRelationalExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXRelationalExpression=ruleXRelationalExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXRelationalExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXRelationalExpression"



	// $ANTLR start "ruleXRelationalExpression"
	// InternalDsl.g:8756:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
	public final EObject ruleXRelationalExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject this_XOtherOperatorExpression_0 =null;
		EObject lv_type_3_0 =null;
		EObject lv_rightOperand_6_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8762:2: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
			// InternalDsl.g:8763:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
			{
			// InternalDsl.g:8763:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
			// InternalDsl.g:8764:3: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_110);
			this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XOtherOperatorExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:8772:3: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
			loop139:
			while (true) {
				int alt139=3;
				switch ( input.LA(1) ) {
				case 42:
					{
					int LA139_2 = input.LA(2);
					if ( (synpred56_InternalDsl()) ) {
						alt139=2;
					}

					}
					break;
				case 47:
					{
					int LA139_3 = input.LA(2);
					if ( (synpred56_InternalDsl()) ) {
						alt139=2;
					}

					}
					break;
				case 95:
					{
					int LA139_4 = input.LA(2);
					if ( (synpred55_InternalDsl()) ) {
						alt139=1;
					}

					}
					break;
				case 48:
					{
					int LA139_5 = input.LA(2);
					if ( (synpred56_InternalDsl()) ) {
						alt139=2;
					}

					}
					break;
				}
				switch (alt139) {
				case 1 :
					// InternalDsl.g:8773:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
					{
					// InternalDsl.g:8773:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
					// InternalDsl.g:8774:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
					{
					// InternalDsl.g:8774:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
					// InternalDsl.g:8775:6: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
					{
					// InternalDsl.g:8781:6: ( () otherlv_2= 'instanceof' )
					// InternalDsl.g:8782:7: () otherlv_2= 'instanceof'
					{
					// InternalDsl.g:8782:7: ()
					// InternalDsl.g:8783:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
														current);
												}
					}

					otherlv_2=(Token)match(input,95,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
											}
					}

					}

					// InternalDsl.g:8795:5: ( (lv_type_3_0= ruleJvmTypeReference ) )
					// InternalDsl.g:8796:6: (lv_type_3_0= ruleJvmTypeReference )
					{
					// InternalDsl.g:8796:6: (lv_type_3_0= ruleJvmTypeReference )
					// InternalDsl.g:8797:7: lv_type_3_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0());
											}
					pushFollow(FOLLOW_110);
					lv_type_3_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
												}
												set(
													current,
													"type",
													lv_type_3_0,
													"jbase.Jbase.JvmTypeReference");
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:8816:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
					{
					// InternalDsl.g:8816:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
					// InternalDsl.g:8817:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
					{
					// InternalDsl.g:8817:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
					// InternalDsl.g:8818:6: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
					{
					// InternalDsl.g:8828:6: ( () ( ( ruleOpCompare ) ) )
					// InternalDsl.g:8829:7: () ( ( ruleOpCompare ) )
					{
					// InternalDsl.g:8829:7: ()
					// InternalDsl.g:8830:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
														current);
												}
					}

					// InternalDsl.g:8836:7: ( ( ruleOpCompare ) )
					// InternalDsl.g:8837:8: ( ruleOpCompare )
					{
					// InternalDsl.g:8837:8: ( ruleOpCompare )
					// InternalDsl.g:8838:9: ruleOpCompare
					{
					if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElement(grammarAccess.getXRelationalExpressionRule());
														}
													}
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
													}
					pushFollow(FOLLOW_66);
					ruleOpCompare();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
														afterParserOrEnumRuleCall();
													}
					}

					}

					}

					}

					// InternalDsl.g:8854:5: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
					// InternalDsl.g:8855:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
					{
					// InternalDsl.g:8855:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
					// InternalDsl.g:8856:7: lv_rightOperand_6_0= ruleXOtherOperatorExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0());
											}
					pushFollow(FOLLOW_110);
					lv_rightOperand_6_0=ruleXOtherOperatorExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
												}
												set(
													current,
													"rightOperand",
													lv_rightOperand_6_0,
													"org.eclipse.xtext.xbase.Xbase.XOtherOperatorExpression");
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}
					break;

				default :
					break loop139;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXRelationalExpression"



	// $ANTLR start "entryRuleOpCompare"
	// InternalDsl.g:8879:1: entryRuleOpCompare returns [String current=null] :iv_ruleOpCompare= ruleOpCompare EOF ;
	public final String entryRuleOpCompare() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpCompare =null;

		try {
			// InternalDsl.g:8879:49: (iv_ruleOpCompare= ruleOpCompare EOF )
			// InternalDsl.g:8880:2: iv_ruleOpCompare= ruleOpCompare EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpCompareRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpCompare=ruleOpCompare();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpCompare.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpCompare"



	// $ANTLR start "ruleOpCompare"
	// InternalDsl.g:8886:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' ) ;
	public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:8892:2: ( (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' ) )
			// InternalDsl.g:8893:2: (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' )
			{
			// InternalDsl.g:8893:2: (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' )
			int alt140=4;
			switch ( input.LA(1) ) {
			case 48:
				{
				alt140=1;
				}
				break;
			case 42:
				{
				int LA140_2 = input.LA(2);
				if ( (LA140_2==45) ) {
					alt140=2;
				}
				else if ( (LA140_2==EOF||(LA140_2 >= RULE_CHARACTER && LA140_2 <= RULE_INT)||LA140_2==RULE_STRING||LA140_2==14||LA140_2==22||(LA140_2 >= 28 && LA140_2 <= 29)||(LA140_2 >= 32 && LA140_2 <= 33)||(LA140_2 >= 87 && LA140_2 <= 89)||LA140_2==94||(LA140_2 >= 96 && LA140_2 <= 97)||(LA140_2 >= 99 && LA140_2 <= 100)||LA140_2==104||LA140_2==107||LA140_2==112) ) {
					alt140=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 140, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 47:
				{
				alt140=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 140, 0, input);
				throw nvae;
			}
			switch (alt140) {
				case 1 :
					// InternalDsl.g:8894:3: kw= '>='
					{
					kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:8900:3: (kw= '<' kw= '=' )
					{
					// InternalDsl.g:8900:3: (kw= '<' kw= '=' )
					// InternalDsl.g:8901:4: kw= '<' kw= '='
					{
					kw=(Token)match(input,42,FOLLOW_16); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0());
								}
					kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1());
								}
					}

					}
					break;
				case 3 :
					// InternalDsl.g:8913:3: kw= '>'
					{
					kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalDsl.g:8919:3: kw= '<'
					{
					kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpCompare"



	// $ANTLR start "entryRuleXOtherOperatorExpression"
	// InternalDsl.g:8928:1: entryRuleXOtherOperatorExpression returns [EObject current=null] :iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
	public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXOtherOperatorExpression =null;

		try {
			// InternalDsl.g:8928:65: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
			// InternalDsl.g:8929:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXOtherOperatorExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXOtherOperatorExpression"



	// $ANTLR start "ruleXOtherOperatorExpression"
	// InternalDsl.g:8935:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
	public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAdditiveExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8941:2: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
			// InternalDsl.g:8942:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
			{
			// InternalDsl.g:8942:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
			// InternalDsl.g:8943:3: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_111);
			this_XAdditiveExpression_0=ruleXAdditiveExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XAdditiveExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:8951:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
			loop141:
			while (true) {
				int alt141=2;
				int LA141_0 = input.LA(1);
				if ( (LA141_0==47) ) {
					int LA141_2 = input.LA(2);
					if ( (synpred57_InternalDsl()) ) {
						alt141=1;
					}

				}
				else if ( (LA141_0==43) ) {
					int LA141_3 = input.LA(2);
					if ( (synpred57_InternalDsl()) ) {
						alt141=1;
					}

				}

				switch (alt141) {
				case 1 :
					// InternalDsl.g:8952:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
					{
					// InternalDsl.g:8952:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
					// InternalDsl.g:8953:5: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
					{
					// InternalDsl.g:8963:5: ( () ( ( ruleOpOther ) ) )
					// InternalDsl.g:8964:6: () ( ( ruleOpOther ) )
					{
					// InternalDsl.g:8964:6: ()
					// InternalDsl.g:8965:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:8971:6: ( ( ruleOpOther ) )
					// InternalDsl.g:8972:7: ( ruleOpOther )
					{
					// InternalDsl.g:8972:7: ( ruleOpOther )
					// InternalDsl.g:8973:8: ruleOpOther
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_66);
					ruleOpOther();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalDsl.g:8989:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
					// InternalDsl.g:8990:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
					{
					// InternalDsl.g:8990:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
					// InternalDsl.g:8991:6: lv_rightOperand_3_0= ruleXAdditiveExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_111);
					lv_rightOperand_3_0=ruleXAdditiveExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXOtherOperatorExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"org.eclipse.xtext.xbase.Xbase.XAdditiveExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop141;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXOtherOperatorExpression"



	// $ANTLR start "entryRuleXAdditiveExpression"
	// InternalDsl.g:9013:1: entryRuleXAdditiveExpression returns [EObject current=null] :iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
	public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAdditiveExpression =null;

		try {
			// InternalDsl.g:9013:60: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
			// InternalDsl.g:9014:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXAdditiveExpression=ruleXAdditiveExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXAdditiveExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXAdditiveExpression"



	// $ANTLR start "ruleXAdditiveExpression"
	// InternalDsl.g:9020:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
	public final EObject ruleXAdditiveExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XMultiplicativeExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9026:2: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
			// InternalDsl.g:9027:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
			{
			// InternalDsl.g:9027:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
			// InternalDsl.g:9028:3: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_112);
			this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XMultiplicativeExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:9036:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
			loop142:
			while (true) {
				int alt142=2;
				int LA142_0 = input.LA(1);
				if ( (LA142_0==28) ) {
					int LA142_2 = input.LA(2);
					if ( (synpred58_InternalDsl()) ) {
						alt142=1;
					}

				}
				else if ( (LA142_0==32) ) {
					int LA142_3 = input.LA(2);
					if ( (synpred58_InternalDsl()) ) {
						alt142=1;
					}

				}

				switch (alt142) {
				case 1 :
					// InternalDsl.g:9037:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
					{
					// InternalDsl.g:9037:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
					// InternalDsl.g:9038:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
					{
					// InternalDsl.g:9048:5: ( () ( ( ruleOpAdd ) ) )
					// InternalDsl.g:9049:6: () ( ( ruleOpAdd ) )
					{
					// InternalDsl.g:9049:6: ()
					// InternalDsl.g:9050:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:9056:6: ( ( ruleOpAdd ) )
					// InternalDsl.g:9057:7: ( ruleOpAdd )
					{
					// InternalDsl.g:9057:7: ( ruleOpAdd )
					// InternalDsl.g:9058:8: ruleOpAdd
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_66);
					ruleOpAdd();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalDsl.g:9074:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
					// InternalDsl.g:9075:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
					{
					// InternalDsl.g:9075:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
					// InternalDsl.g:9076:6: lv_rightOperand_3_0= ruleXMultiplicativeExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_112);
					lv_rightOperand_3_0=ruleXMultiplicativeExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXAdditiveExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"org.eclipse.xtext.xbase.Xbase.XMultiplicativeExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop142;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXAdditiveExpression"



	// $ANTLR start "entryRuleOpAdd"
	// InternalDsl.g:9098:1: entryRuleOpAdd returns [String current=null] :iv_ruleOpAdd= ruleOpAdd EOF ;
	public final String entryRuleOpAdd() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpAdd =null;

		try {
			// InternalDsl.g:9098:45: (iv_ruleOpAdd= ruleOpAdd EOF )
			// InternalDsl.g:9099:2: iv_ruleOpAdd= ruleOpAdd EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpAddRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpAdd=ruleOpAdd();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpAdd.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpAdd"



	// $ANTLR start "ruleOpAdd"
	// InternalDsl.g:9105:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' |kw= '-' ) ;
	public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:9111:2: ( (kw= '+' |kw= '-' ) )
			// InternalDsl.g:9112:2: (kw= '+' |kw= '-' )
			{
			// InternalDsl.g:9112:2: (kw= '+' |kw= '-' )
			int alt143=2;
			int LA143_0 = input.LA(1);
			if ( (LA143_0==28) ) {
				alt143=1;
			}
			else if ( (LA143_0==32) ) {
				alt143=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 143, 0, input);
				throw nvae;
			}

			switch (alt143) {
				case 1 :
					// InternalDsl.g:9113:3: kw= '+'
					{
					kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:9119:3: kw= '-'
					{
					kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpAdd"



	// $ANTLR start "entryRuleXMultiplicativeExpression"
	// InternalDsl.g:9128:1: entryRuleXMultiplicativeExpression returns [EObject current=null] :iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
	public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXMultiplicativeExpression =null;

		try {
			// InternalDsl.g:9128:66: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
			// InternalDsl.g:9129:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXMultiplicativeExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXMultiplicativeExpression"



	// $ANTLR start "ruleXMultiplicativeExpression"
	// InternalDsl.g:9135:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
	public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XUnaryOperation_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9141:2: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
			// InternalDsl.g:9142:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
			{
			// InternalDsl.g:9142:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
			// InternalDsl.g:9143:3: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0());
					}
			pushFollow(FOLLOW_113);
			this_XUnaryOperation_0=ruleXUnaryOperation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XUnaryOperation_0;
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:9151:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
			loop144:
			while (true) {
				int alt144=2;
				switch ( input.LA(1) ) {
				case 26:
					{
					int LA144_2 = input.LA(2);
					if ( (synpred59_InternalDsl()) ) {
						alt144=1;
					}

					}
					break;
				case 38:
					{
					int LA144_3 = input.LA(2);
					if ( (synpred59_InternalDsl()) ) {
						alt144=1;
					}

					}
					break;
				case 17:
					{
					int LA144_4 = input.LA(2);
					if ( (synpred59_InternalDsl()) ) {
						alt144=1;
					}

					}
					break;
				}
				switch (alt144) {
				case 1 :
					// InternalDsl.g:9152:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
					{
					// InternalDsl.g:9152:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
					// InternalDsl.g:9153:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
					{
					// InternalDsl.g:9163:5: ( () ( ( ruleOpMulti ) ) )
					// InternalDsl.g:9164:6: () ( ( ruleOpMulti ) )
					{
					// InternalDsl.g:9164:6: ()
					// InternalDsl.g:9165:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:9171:6: ( ( ruleOpMulti ) )
					// InternalDsl.g:9172:7: ( ruleOpMulti )
					{
					// InternalDsl.g:9172:7: ( ruleOpMulti )
					// InternalDsl.g:9173:8: ruleOpMulti
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_66);
					ruleOpMulti();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalDsl.g:9189:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
					// InternalDsl.g:9190:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
					{
					// InternalDsl.g:9190:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
					// InternalDsl.g:9191:6: lv_rightOperand_3_0= ruleXUnaryOperation
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_113);
					lv_rightOperand_3_0=ruleXUnaryOperation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXMultiplicativeExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop144;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXMultiplicativeExpression"



	// $ANTLR start "entryRuleXUnaryOperation"
	// InternalDsl.g:9213:1: entryRuleXUnaryOperation returns [EObject current=null] :iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
	public final EObject entryRuleXUnaryOperation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXUnaryOperation =null;

		try {
			// InternalDsl.g:9213:56: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
			// InternalDsl.g:9214:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXUnaryOperationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXUnaryOperation=ruleXUnaryOperation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXUnaryOperation; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXUnaryOperation"



	// $ANTLR start "ruleXUnaryOperation"
	// InternalDsl.g:9220:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression ) ;
	public final EObject ruleXUnaryOperation() throws RecognitionException {
		EObject current = null;


		EObject lv_operand_2_0 =null;
		EObject this_XCastedExpression_3 =null;


			enterRule();

		try {
			// InternalDsl.g:9226:2: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression ) )
			// InternalDsl.g:9227:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression )
			{
			// InternalDsl.g:9227:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression )
			int alt145=2;
			int LA145_0 = input.LA(1);
			if ( (LA145_0==14||LA145_0==28||LA145_0==32||LA145_0==112) ) {
				alt145=1;
			}
			else if ( ((LA145_0 >= RULE_CHARACTER && LA145_0 <= RULE_INT)||LA145_0==RULE_STRING||LA145_0==22||LA145_0==29||LA145_0==33||(LA145_0 >= 87 && LA145_0 <= 89)||LA145_0==94||(LA145_0 >= 96 && LA145_0 <= 97)||(LA145_0 >= 99 && LA145_0 <= 100)||LA145_0==104||LA145_0==107) ) {
				alt145=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 145, 0, input);
				throw nvae;
			}

			switch (alt145) {
				case 1 :
					// InternalDsl.g:9228:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
					{
					// InternalDsl.g:9228:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
					// InternalDsl.g:9229:4: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) )
					{
					// InternalDsl.g:9229:4: ()
					// InternalDsl.g:9230:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
											current);
									}
					}

					// InternalDsl.g:9236:4: ( ( ruleOpUnary ) )
					// InternalDsl.g:9237:5: ( ruleOpUnary )
					{
					// InternalDsl.g:9237:5: ( ruleOpUnary )
					// InternalDsl.g:9238:6: ruleOpUnary
					{
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXUnaryOperationRule());
											}
										}
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
										}
					pushFollow(FOLLOW_66);
					ruleOpUnary();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:9252:4: ( (lv_operand_2_0= ruleXUnaryOperation ) )
					// InternalDsl.g:9253:5: (lv_operand_2_0= ruleXUnaryOperation )
					{
					// InternalDsl.g:9253:5: (lv_operand_2_0= ruleXUnaryOperation )
					// InternalDsl.g:9254:6: lv_operand_2_0= ruleXUnaryOperation
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0());
										}
					pushFollow(FOLLOW_2);
					lv_operand_2_0=ruleXUnaryOperation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXUnaryOperationRule());
											}
											set(
												current,
												"operand",
												lv_operand_2_0,
												"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:9273:3: this_XCastedExpression_3= ruleXCastedExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XCastedExpression_3=ruleXCastedExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XCastedExpression_3;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXUnaryOperation"



	// $ANTLR start "entryRuleOpPostfix"
	// InternalDsl.g:9285:1: entryRuleOpPostfix returns [String current=null] :iv_ruleOpPostfix= ruleOpPostfix EOF ;
	public final String entryRuleOpPostfix() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpPostfix =null;

		try {
			// InternalDsl.g:9285:49: (iv_ruleOpPostfix= ruleOpPostfix EOF )
			// InternalDsl.g:9286:2: iv_ruleOpPostfix= ruleOpPostfix EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpPostfixRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpPostfix=ruleOpPostfix();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpPostfix.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpPostfix"



	// $ANTLR start "ruleOpPostfix"
	// InternalDsl.g:9292:1: ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' |kw= '--' ) ;
	public final AntlrDatatypeRuleToken ruleOpPostfix() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:9298:2: ( (kw= '++' |kw= '--' ) )
			// InternalDsl.g:9299:2: (kw= '++' |kw= '--' )
			{
			// InternalDsl.g:9299:2: (kw= '++' |kw= '--' )
			int alt146=2;
			int LA146_0 = input.LA(1);
			if ( (LA146_0==29) ) {
				alt146=1;
			}
			else if ( (LA146_0==33) ) {
				alt146=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 146, 0, input);
				throw nvae;
			}

			switch (alt146) {
				case 1 :
					// InternalDsl.g:9300:3: kw= '++'
					{
					kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:9306:3: kw= '--'
					{
					kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpPostfix"



	// $ANTLR start "entryRuleXSetLiteral"
	// InternalDsl.g:9315:1: entryRuleXSetLiteral returns [EObject current=null] :iv_ruleXSetLiteral= ruleXSetLiteral EOF ;
	public final EObject entryRuleXSetLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSetLiteral =null;

		try {
			// InternalDsl.g:9315:52: (iv_ruleXSetLiteral= ruleXSetLiteral EOF )
			// InternalDsl.g:9316:2: iv_ruleXSetLiteral= ruleXSetLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXSetLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXSetLiteral=ruleXSetLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXSetLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXSetLiteral"



	// $ANTLR start "ruleXSetLiteral"
	// InternalDsl.g:9322:1: ruleXSetLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) ;
	public final EObject ruleXSetLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_elements_3_0 =null;
		EObject lv_elements_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9328:2: ( ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) )
			// InternalDsl.g:9329:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
			{
			// InternalDsl.g:9329:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
			// InternalDsl.g:9330:3: () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}'
			{
			// InternalDsl.g:9330:3: ()
			// InternalDsl.g:9331:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXSetLiteralAccess().getXSetLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,16,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXSetLiteralAccess().getNumberSignKeyword_1());
					}
			otherlv_2=(Token)match(input,107,FOLLOW_98); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXSetLiteralAccess().getLeftCurlyBracketKeyword_2());
					}
			// InternalDsl.g:9345:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
			int alt148=2;
			int LA148_0 = input.LA(1);
			if ( ((LA148_0 >= RULE_CHARACTER && LA148_0 <= RULE_INT)||LA148_0==RULE_STRING||LA148_0==14||LA148_0==22||(LA148_0 >= 28 && LA148_0 <= 29)||(LA148_0 >= 32 && LA148_0 <= 33)||(LA148_0 >= 87 && LA148_0 <= 89)||LA148_0==94||(LA148_0 >= 96 && LA148_0 <= 97)||(LA148_0 >= 99 && LA148_0 <= 100)||LA148_0==104||LA148_0==107||LA148_0==112) ) {
				alt148=1;
			}
			switch (alt148) {
				case 1 :
					// InternalDsl.g:9346:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					{
					// InternalDsl.g:9346:4: ( (lv_elements_3_0= ruleXExpression ) )
					// InternalDsl.g:9347:5: (lv_elements_3_0= ruleXExpression )
					{
					// InternalDsl.g:9347:5: (lv_elements_3_0= ruleXExpression )
					// InternalDsl.g:9348:6: lv_elements_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
										}
					pushFollow(FOLLOW_99);
					lv_elements_3_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
											}
											add(
												current,
												"elements",
												lv_elements_3_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:9365:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					loop147:
					while (true) {
						int alt147=2;
						int LA147_0 = input.LA(1);
						if ( (LA147_0==31) ) {
							alt147=1;
						}

						switch (alt147) {
						case 1 :
							// InternalDsl.g:9366:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
							{
							otherlv_4=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXSetLiteralAccess().getCommaKeyword_3_1_0());
											}
							// InternalDsl.g:9370:5: ( (lv_elements_5_0= ruleXExpression ) )
							// InternalDsl.g:9371:6: (lv_elements_5_0= ruleXExpression )
							{
							// InternalDsl.g:9371:6: (lv_elements_5_0= ruleXExpression )
							// InternalDsl.g:9372:7: lv_elements_5_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
													}
							pushFollow(FOLLOW_99);
							lv_elements_5_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
														}
														add(
															current,
															"elements",
															lv_elements_5_0,
															"org.eclipse.xtext.xbase.Xbase.XExpression");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop147;
						}
					}

					}
					break;

			}

			otherlv_6=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXSetLiteralAccess().getRightCurlyBracketKeyword_4());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXSetLiteral"



	// $ANTLR start "entryRuleXListLiteral"
	// InternalDsl.g:9399:1: entryRuleXListLiteral returns [EObject current=null] :iv_ruleXListLiteral= ruleXListLiteral EOF ;
	public final EObject entryRuleXListLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXListLiteral =null;

		try {
			// InternalDsl.g:9399:53: (iv_ruleXListLiteral= ruleXListLiteral EOF )
			// InternalDsl.g:9400:2: iv_ruleXListLiteral= ruleXListLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXListLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXListLiteral=ruleXListLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXListLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXListLiteral"



	// $ANTLR start "ruleXListLiteral"
	// InternalDsl.g:9406:1: ruleXListLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) ;
	public final EObject ruleXListLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_elements_3_0 =null;
		EObject lv_elements_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9412:2: ( ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) )
			// InternalDsl.g:9413:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
			{
			// InternalDsl.g:9413:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
			// InternalDsl.g:9414:3: () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']'
			{
			// InternalDsl.g:9414:3: ()
			// InternalDsl.g:9415:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXListLiteralAccess().getXListLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,16,FOLLOW_43); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXListLiteralAccess().getNumberSignKeyword_1());
					}
			otherlv_2=(Token)match(input,75,FOLLOW_78); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXListLiteralAccess().getLeftSquareBracketKeyword_2());
					}
			// InternalDsl.g:9429:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
			int alt150=2;
			int LA150_0 = input.LA(1);
			if ( ((LA150_0 >= RULE_CHARACTER && LA150_0 <= RULE_INT)||LA150_0==RULE_STRING||LA150_0==14||LA150_0==22||(LA150_0 >= 28 && LA150_0 <= 29)||(LA150_0 >= 32 && LA150_0 <= 33)||(LA150_0 >= 87 && LA150_0 <= 89)||LA150_0==94||(LA150_0 >= 96 && LA150_0 <= 97)||(LA150_0 >= 99 && LA150_0 <= 100)||LA150_0==104||LA150_0==107||LA150_0==112) ) {
				alt150=1;
			}
			switch (alt150) {
				case 1 :
					// InternalDsl.g:9430:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					{
					// InternalDsl.g:9430:4: ( (lv_elements_3_0= ruleXExpression ) )
					// InternalDsl.g:9431:5: (lv_elements_3_0= ruleXExpression )
					{
					// InternalDsl.g:9431:5: (lv_elements_3_0= ruleXExpression )
					// InternalDsl.g:9432:6: lv_elements_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
										}
					pushFollow(FOLLOW_44);
					lv_elements_3_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXListLiteralRule());
											}
											add(
												current,
												"elements",
												lv_elements_3_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:9449:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					loop149:
					while (true) {
						int alt149=2;
						int LA149_0 = input.LA(1);
						if ( (LA149_0==31) ) {
							alt149=1;
						}

						switch (alt149) {
						case 1 :
							// InternalDsl.g:9450:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
							{
							otherlv_4=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXListLiteralAccess().getCommaKeyword_3_1_0());
											}
							// InternalDsl.g:9454:5: ( (lv_elements_5_0= ruleXExpression ) )
							// InternalDsl.g:9455:6: (lv_elements_5_0= ruleXExpression )
							{
							// InternalDsl.g:9455:6: (lv_elements_5_0= ruleXExpression )
							// InternalDsl.g:9456:7: lv_elements_5_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
													}
							pushFollow(FOLLOW_44);
							lv_elements_5_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXListLiteralRule());
														}
														add(
															current,
															"elements",
															lv_elements_5_0,
															"org.eclipse.xtext.xbase.Xbase.XExpression");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop149;
						}
					}

					}
					break;

			}

			otherlv_6=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXListLiteralAccess().getRightSquareBracketKeyword_4());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXListLiteral"



	// $ANTLR start "entryRuleXExpressionInClosure"
	// InternalDsl.g:9483:1: entryRuleXExpressionInClosure returns [EObject current=null] :iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
	public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpressionInClosure =null;

		try {
			// InternalDsl.g:9483:61: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
			// InternalDsl.g:9484:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXExpressionInClosureRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXExpressionInClosure=ruleXExpressionInClosure();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXExpressionInClosure; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXExpressionInClosure"



	// $ANTLR start "ruleXExpressionInClosure"
	// InternalDsl.g:9490:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
	public final EObject ruleXExpressionInClosure() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject lv_expressions_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9496:2: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
			// InternalDsl.g:9497:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
			{
			// InternalDsl.g:9497:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
			// InternalDsl.g:9498:3: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
			{
			// InternalDsl.g:9498:3: ()
			// InternalDsl.g:9499:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
								current);
						}
			}

			// InternalDsl.g:9505:3: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
			loop152:
			while (true) {
				int alt152=2;
				int LA152_0 = input.LA(1);
				if ( ((LA152_0 >= RULE_CHARACTER && LA152_0 <= RULE_INT)||LA152_0==RULE_STRING||LA152_0==14||LA152_0==22||(LA152_0 >= 28 && LA152_0 <= 29)||(LA152_0 >= 32 && LA152_0 <= 33)||(LA152_0 >= 87 && LA152_0 <= 90)||LA152_0==94||(LA152_0 >= 96 && LA152_0 <= 97)||(LA152_0 >= 99 && LA152_0 <= 100)||LA152_0==104||LA152_0==107||LA152_0==112) ) {
					alt152=1;
				}

				switch (alt152) {
				case 1 :
					// InternalDsl.g:9506:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
					{
					// InternalDsl.g:9506:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
					// InternalDsl.g:9507:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
					{
					// InternalDsl.g:9507:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
					// InternalDsl.g:9508:6: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0());
										}
					pushFollow(FOLLOW_114);
					lv_expressions_1_0=ruleXExpressionOrVarDeclaration();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXExpressionInClosureRule());
											}
											add(
												current,
												"expressions",
												lv_expressions_1_0,
												"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:9525:4: (otherlv_2= ';' )?
					int alt151=2;
					int LA151_0 = input.LA(1);
					if ( (LA151_0==41) ) {
						alt151=1;
					}
					switch (alt151) {
						case 1 :
							// InternalDsl.g:9526:5: otherlv_2= ';'
							{
							otherlv_2=(Token)match(input,41,FOLLOW_115); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
											}
							}
							break;

					}

					}
					break;

				default :
					break loop152;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXExpressionInClosure"



	// $ANTLR start "entryRuleXParenthesizedExpression"
	// InternalDsl.g:9536:1: entryRuleXParenthesizedExpression returns [EObject current=null] :iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
	public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXParenthesizedExpression =null;

		try {
			// InternalDsl.g:9536:65: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
			// InternalDsl.g:9537:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXParenthesizedExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXParenthesizedExpression"



	// $ANTLR start "ruleXParenthesizedExpression"
	// InternalDsl.g:9543:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
	public final EObject ruleXParenthesizedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token otherlv_2=null;
		EObject this_XExpression_1 =null;


			enterRule();

		try {
			// InternalDsl.g:9549:2: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
			// InternalDsl.g:9550:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
			{
			// InternalDsl.g:9550:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
			// InternalDsl.g:9551:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
			{
			otherlv_0=(Token)match(input,22,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
					}
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1());
					}
			pushFollow(FOLLOW_8);
			this_XExpression_1=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XExpression_1;
						afterParserOrEnumRuleCall();
					}
			otherlv_2=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXParenthesizedExpression"



	// $ANTLR start "entryRuleXExpressionOrVarDeclaration"
	// InternalDsl.g:9571:1: entryRuleXExpressionOrVarDeclaration returns [EObject current=null] :iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF ;
	public final EObject entryRuleXExpressionOrVarDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpressionOrVarDeclaration =null;

		try {
			// InternalDsl.g:9571:68: (iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF )
			// InternalDsl.g:9572:2: iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXExpressionOrVarDeclaration=ruleXExpressionOrVarDeclaration();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXExpressionOrVarDeclaration; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXExpressionOrVarDeclaration"



	// $ANTLR start "ruleXExpressionOrVarDeclaration"
	// InternalDsl.g:9578:1: ruleXExpressionOrVarDeclaration returns [EObject current=null] : ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration ) |this_XExpression_1= ruleXExpression ) ;
	public final EObject ruleXExpressionOrVarDeclaration() throws RecognitionException {
		EObject current = null;


		EObject this_XVariableDeclaration_0 =null;
		EObject this_XExpression_1 =null;


			enterRule();

		try {
			// InternalDsl.g:9584:2: ( ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration ) |this_XExpression_1= ruleXExpression ) )
			// InternalDsl.g:9585:2: ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration ) |this_XExpression_1= ruleXExpression )
			{
			// InternalDsl.g:9585:2: ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration ) |this_XExpression_1= ruleXExpression )
			int alt153=2;
			int LA153_0 = input.LA(1);
			if ( (LA153_0==90) && (synpred60_InternalDsl())) {
				alt153=1;
			}
			else if ( (LA153_0==RULE_ID) ) {
				int LA153_2 = input.LA(2);
				if ( (synpred60_InternalDsl()) ) {
					alt153=1;
				}
				else if ( (true) ) {
					alt153=2;
				}

			}
			else if ( ((LA153_0 >= RULE_CHARACTER && LA153_0 <= RULE_HEX)||LA153_0==RULE_INT||LA153_0==RULE_STRING||LA153_0==14||LA153_0==22||(LA153_0 >= 28 && LA153_0 <= 29)||(LA153_0 >= 32 && LA153_0 <= 33)||(LA153_0 >= 87 && LA153_0 <= 89)||LA153_0==94||(LA153_0 >= 96 && LA153_0 <= 97)||(LA153_0 >= 99 && LA153_0 <= 100)||LA153_0==104||LA153_0==107||LA153_0==112) ) {
				alt153=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 153, 0, input);
				throw nvae;
			}

			switch (alt153) {
				case 1 :
					// InternalDsl.g:9586:3: ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration )
					{
					// InternalDsl.g:9586:3: ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration )
					// InternalDsl.g:9587:4: ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXVariableDeclarationParserRuleCall_0());
								}
					pushFollow(FOLLOW_2);
					this_XVariableDeclaration_0=ruleXVariableDeclaration();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XVariableDeclaration_0;
									afterParserOrEnumRuleCall();
								}
					}

					}
					break;
				case 2 :
					// InternalDsl.g:9617:3: this_XExpression_1= ruleXExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXExpressionParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XExpression_1=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XExpression_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXExpressionOrVarDeclaration"



	// $ANTLR start "entryRuleJvmFormalParameter"
	// InternalDsl.g:9629:1: entryRuleJvmFormalParameter returns [EObject current=null] :iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
	public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmFormalParameter =null;

		try {
			// InternalDsl.g:9629:59: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
			// InternalDsl.g:9630:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmFormalParameterRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmFormalParameter=ruleJvmFormalParameter();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmFormalParameter; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmFormalParameter"



	// $ANTLR start "ruleJvmFormalParameter"
	// InternalDsl.g:9636:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
	public final EObject ruleJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject lv_parameterType_0_0 =null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9642:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
			// InternalDsl.g:9643:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
			{
			// InternalDsl.g:9643:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
			// InternalDsl.g:9644:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
			{
			// InternalDsl.g:9644:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
			int alt154=2;
			int LA154_0 = input.LA(1);
			if ( (LA154_0==RULE_ID) ) {
				int LA154_1 = input.LA(2);
				if ( (LA154_1==RULE_ID||LA154_1==36||LA154_1==42||LA154_1==75) ) {
					alt154=1;
				}
			}
			switch (alt154) {
				case 1 :
					// InternalDsl.g:9645:4: (lv_parameterType_0_0= ruleJvmTypeReference )
					{
					// InternalDsl.g:9645:4: (lv_parameterType_0_0= ruleJvmTypeReference )
					// InternalDsl.g:9646:5: lv_parameterType_0_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
									}
					pushFollow(FOLLOW_23);
					lv_parameterType_0_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
										}
										set(
											current,
											"parameterType",
											lv_parameterType_0_0,
											"jbase.Jbase.JvmTypeReference");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			// InternalDsl.g:9663:3: ( (lv_name_1_0= ruleValidID ) )
			// InternalDsl.g:9664:4: (lv_name_1_0= ruleValidID )
			{
			// InternalDsl.g:9664:4: (lv_name_1_0= ruleValidID )
			// InternalDsl.g:9665:5: lv_name_1_0= ruleValidID
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_name_1_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
								}
								set(
									current,
									"name",
									lv_name_1_0,
									"org.eclipse.xtext.xbase.Xtype.ValidID");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmFormalParameter"



	// $ANTLR start "entryRuleFeatureCallID"
	// InternalDsl.g:9686:1: entryRuleFeatureCallID returns [String current=null] :iv_ruleFeatureCallID= ruleFeatureCallID EOF ;
	public final String entryRuleFeatureCallID() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleFeatureCallID =null;

		try {
			// InternalDsl.g:9686:53: (iv_ruleFeatureCallID= ruleFeatureCallID EOF )
			// InternalDsl.g:9687:2: iv_ruleFeatureCallID= ruleFeatureCallID EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getFeatureCallIDRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleFeatureCallID=ruleFeatureCallID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleFeatureCallID.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleFeatureCallID"



	// $ANTLR start "ruleFeatureCallID"
	// InternalDsl.g:9693:1: ruleFeatureCallID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' ) ;
	public final AntlrDatatypeRuleToken ruleFeatureCallID() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9699:2: ( (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' ) )
			// InternalDsl.g:9700:2: (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' )
			{
			// InternalDsl.g:9700:2: (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' )
			int alt155=5;
			switch ( input.LA(1) ) {
			case RULE_ID:
				{
				alt155=1;
				}
				break;
			case 87:
				{
				alt155=2;
				}
				break;
			case 99:
				{
				alt155=3;
				}
				break;
			case 94:
				{
				alt155=4;
				}
				break;
			case 88:
				{
				alt155=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 155, 0, input);
				throw nvae;
			}
			switch (alt155) {
				case 1 :
					// InternalDsl.g:9701:3: this_ValidID_0= ruleValidID
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getFeatureCallIDAccess().getValidIDParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_ValidID_0=ruleValidID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_ValidID_0);
							}
					if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalDsl.g:9712:3: kw= 'extends'
					{
					kw=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtendsKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalDsl.g:9718:3: kw= 'static'
					{
					kw=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getStaticKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalDsl.g:9724:3: kw= 'import'
					{
					kw=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getImportKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalDsl.g:9730:3: kw= 'extension'
					{
					kw=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtensionKeyword_4());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleFeatureCallID"



	// $ANTLR start "entryRuleIdOrSuper"
	// InternalDsl.g:9739:1: entryRuleIdOrSuper returns [String current=null] :iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
	public final String entryRuleIdOrSuper() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleIdOrSuper =null;

		try {
			// InternalDsl.g:9739:49: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
			// InternalDsl.g:9740:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getIdOrSuperRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleIdOrSuper=ruleIdOrSuper();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleIdOrSuper.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleIdOrSuper"



	// $ANTLR start "ruleIdOrSuper"
	// InternalDsl.g:9746:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' ) ;
	public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_FeatureCallID_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9752:2: ( (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' ) )
			// InternalDsl.g:9753:2: (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' )
			{
			// InternalDsl.g:9753:2: (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' )
			int alt156=2;
			int LA156_0 = input.LA(1);
			if ( (LA156_0==RULE_ID||(LA156_0 >= 87 && LA156_0 <= 88)||LA156_0==94||LA156_0==99) ) {
				alt156=1;
			}
			else if ( (LA156_0==100) ) {
				alt156=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 156, 0, input);
				throw nvae;
			}

			switch (alt156) {
				case 1 :
					// InternalDsl.g:9754:3: this_FeatureCallID_0= ruleFeatureCallID
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getIdOrSuperAccess().getFeatureCallIDParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_FeatureCallID_0=ruleFeatureCallID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_FeatureCallID_0);
							}
					if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalDsl.g:9765:3: kw= 'super'
					{
					kw=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getIdOrSuperAccess().getSuperKeyword_1());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleIdOrSuper"



	// $ANTLR start "entryRuleXBooleanLiteral"
	// InternalDsl.g:9774:1: entryRuleXBooleanLiteral returns [EObject current=null] :iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
	public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBooleanLiteral =null;

		try {
			// InternalDsl.g:9774:56: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
			// InternalDsl.g:9775:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXBooleanLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXBooleanLiteral=ruleXBooleanLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXBooleanLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXBooleanLiteral"



	// $ANTLR start "ruleXBooleanLiteral"
	// InternalDsl.g:9781:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
	public final EObject ruleXBooleanLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token lv_isTrue_2_0=null;


			enterRule();

		try {
			// InternalDsl.g:9787:2: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
			// InternalDsl.g:9788:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
			{
			// InternalDsl.g:9788:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
			// InternalDsl.g:9789:3: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
			{
			// InternalDsl.g:9789:3: ()
			// InternalDsl.g:9790:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
								current);
						}
			}

			// InternalDsl.g:9796:3: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
			int alt157=2;
			int LA157_0 = input.LA(1);
			if ( (LA157_0==89) ) {
				alt157=1;
			}
			else if ( (LA157_0==104) ) {
				alt157=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 157, 0, input);
				throw nvae;
			}

			switch (alt157) {
				case 1 :
					// InternalDsl.g:9797:4: otherlv_1= 'false'
					{
					otherlv_1=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
								}
					}
					break;
				case 2 :
					// InternalDsl.g:9802:4: ( (lv_isTrue_2_0= 'true' ) )
					{
					// InternalDsl.g:9802:4: ( (lv_isTrue_2_0= 'true' ) )
					// InternalDsl.g:9803:5: (lv_isTrue_2_0= 'true' )
					{
					// InternalDsl.g:9803:5: (lv_isTrue_2_0= 'true' )
					// InternalDsl.g:9804:6: lv_isTrue_2_0= 'true'
					{
					lv_isTrue_2_0=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXBooleanLiteralRule());
											}
											setWithLastConsumed(current, "isTrue", lv_isTrue_2_0 != null, "true");
										}
					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXBooleanLiteral"



	// $ANTLR start "entryRuleXNullLiteral"
	// InternalDsl.g:9821:1: entryRuleXNullLiteral returns [EObject current=null] :iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
	public final EObject entryRuleXNullLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXNullLiteral =null;

		try {
			// InternalDsl.g:9821:53: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
			// InternalDsl.g:9822:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXNullLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXNullLiteral=ruleXNullLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXNullLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXNullLiteral"



	// $ANTLR start "ruleXNullLiteral"
	// InternalDsl.g:9828:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
	public final EObject ruleXNullLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;


			enterRule();

		try {
			// InternalDsl.g:9834:2: ( ( () otherlv_1= 'null' ) )
			// InternalDsl.g:9835:2: ( () otherlv_1= 'null' )
			{
			// InternalDsl.g:9835:2: ( () otherlv_1= 'null' )
			// InternalDsl.g:9836:3: () otherlv_1= 'null'
			{
			// InternalDsl.g:9836:3: ()
			// InternalDsl.g:9837:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXNullLiteral"



	// $ANTLR start "entryRuleXNumberLiteral"
	// InternalDsl.g:9851:1: entryRuleXNumberLiteral returns [EObject current=null] :iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
	public final EObject entryRuleXNumberLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXNumberLiteral =null;

		try {
			// InternalDsl.g:9851:55: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
			// InternalDsl.g:9852:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXNumberLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXNumberLiteral=ruleXNumberLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXNumberLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXNumberLiteral"



	// $ANTLR start "ruleXNumberLiteral"
	// InternalDsl.g:9858:1: ruleXNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
	public final EObject ruleXNumberLiteral() throws RecognitionException {
		EObject current = null;


		AntlrDatatypeRuleToken lv_value_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9864:2: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
			// InternalDsl.g:9865:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
			{
			// InternalDsl.g:9865:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
			// InternalDsl.g:9866:3: () ( (lv_value_1_0= ruleNumber ) )
			{
			// InternalDsl.g:9866:3: ()
			// InternalDsl.g:9867:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
								current);
						}
			}

			// InternalDsl.g:9873:3: ( (lv_value_1_0= ruleNumber ) )
			// InternalDsl.g:9874:4: (lv_value_1_0= ruleNumber )
			{
			// InternalDsl.g:9874:4: (lv_value_1_0= ruleNumber )
			// InternalDsl.g:9875:5: lv_value_1_0= ruleNumber
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_value_1_0=ruleNumber();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXNumberLiteralRule());
								}
								set(
									current,
									"value",
									lv_value_1_0,
									"org.eclipse.xtext.xbase.Xbase.Number");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXNumberLiteral"



	// $ANTLR start "entryRuleXThrowExpression"
	// InternalDsl.g:9896:1: entryRuleXThrowExpression returns [EObject current=null] :iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
	public final EObject entryRuleXThrowExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXThrowExpression =null;

		try {
			// InternalDsl.g:9896:57: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
			// InternalDsl.g:9897:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXThrowExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXThrowExpression=ruleXThrowExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXThrowExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXThrowExpression"



	// $ANTLR start "ruleXThrowExpression"
	// InternalDsl.g:9903:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
	public final EObject ruleXThrowExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_expression_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9909:2: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
			// InternalDsl.g:9910:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
			{
			// InternalDsl.g:9910:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
			// InternalDsl.g:9911:3: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
			{
			// InternalDsl.g:9911:3: ()
			// InternalDsl.g:9912:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,103,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
					}
			// InternalDsl.g:9922:3: ( (lv_expression_2_0= ruleXExpression ) )
			// InternalDsl.g:9923:4: (lv_expression_2_0= ruleXExpression )
			{
			// InternalDsl.g:9923:4: (lv_expression_2_0= ruleXExpression )
			// InternalDsl.g:9924:5: lv_expression_2_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_2);
			lv_expression_2_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXThrowExpressionRule());
								}
								set(
									current,
									"expression",
									lv_expression_2_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXThrowExpression"



	// $ANTLR start "entryRuleXReturnExpression"
	// InternalDsl.g:9945:1: entryRuleXReturnExpression returns [EObject current=null] :iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
	public final EObject entryRuleXReturnExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXReturnExpression =null;

		try {
			// InternalDsl.g:9945:58: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
			// InternalDsl.g:9946:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXReturnExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXReturnExpression=ruleXReturnExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXReturnExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXReturnExpression"



	// $ANTLR start "ruleXReturnExpression"
	// InternalDsl.g:9952:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
	public final EObject ruleXReturnExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_expression_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9958:2: ( ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) )
			// InternalDsl.g:9959:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
			{
			// InternalDsl.g:9959:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
			// InternalDsl.g:9960:3: () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
			{
			// InternalDsl.g:9960:3: ()
			// InternalDsl.g:9961:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,98,FOLLOW_116); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
					}
			// InternalDsl.g:9971:3: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
			int alt158=2;
			switch ( input.LA(1) ) {
				case RULE_ID:
					{
					int LA158_1 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 87:
					{
					int LA158_2 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 99:
					{
					int LA158_3 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 94:
					{
					int LA158_4 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 88:
					{
					int LA158_5 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 14:
					{
					int LA158_6 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 32:
					{
					int LA158_7 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 28:
					{
					int LA158_8 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 112:
					{
					int LA158_9 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 22:
					{
					int LA158_10 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 29:
					{
					int LA158_11 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 33:
					{
					int LA158_12 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 96:
					{
					int LA158_13 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 100:
					{
					int LA158_14 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 89:
					{
					int LA158_15 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 104:
					{
					int LA158_16 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case RULE_HEX:
					{
					int LA158_17 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case RULE_INT:
					{
					int LA158_18 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case RULE_DECIMAL:
					{
					int LA158_19 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 97:
					{
					int LA158_20 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case RULE_CHARACTER:
					{
					int LA158_21 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case RULE_STRING:
					{
					int LA158_22 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
				case 107:
					{
					int LA158_23 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt158=1;
					}
					}
					break;
			}
			switch (alt158) {
				case 1 :
					// InternalDsl.g:9972:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression )
					{
					// InternalDsl.g:9973:4: (lv_expression_2_0= ruleXExpression )
					// InternalDsl.g:9974:5: lv_expression_2_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
									}
					pushFollow(FOLLOW_2);
					lv_expression_2_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXReturnExpressionRule());
										}
										set(
											current,
											"expression",
											lv_expression_2_0,
											"org.eclipse.xtext.xbase.Xbase.XExpression");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXReturnExpression"



	// $ANTLR start "entryRuleQualifiedName"
	// InternalDsl.g:9995:1: entryRuleQualifiedName returns [String current=null] :iv_ruleQualifiedName= ruleQualifiedName EOF ;
	public final String entryRuleQualifiedName() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedName =null;

		try {
			// InternalDsl.g:9995:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
			// InternalDsl.g:9996:2: iv_ruleQualifiedName= ruleQualifiedName EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getQualifiedNameRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleQualifiedName=ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleQualifiedName.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleQualifiedName"



	// $ANTLR start "ruleQualifiedName"
	// InternalDsl.g:10002:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
	public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;
		AntlrDatatypeRuleToken this_ValidID_2 =null;


			enterRule();

		try {
			// InternalDsl.g:10008:2: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
			// InternalDsl.g:10009:2: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
			{
			// InternalDsl.g:10009:2: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
			// InternalDsl.g:10010:3: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
					}
			pushFollow(FOLLOW_27);
			this_ValidID_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(this_ValidID_0);
					}
			if ( state.backtracking==0 ) {
						afterParserOrEnumRuleCall();
					}
			// InternalDsl.g:10020:3: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
			loop159:
			while (true) {
				int alt159=2;
				int LA159_0 = input.LA(1);
				if ( (LA159_0==36) ) {
					int LA159_2 = input.LA(2);
					if ( (LA159_2==RULE_ID) ) {
						int LA159_3 = input.LA(3);
						if ( (synpred62_InternalDsl()) ) {
							alt159=1;
						}

					}

				}

				switch (alt159) {
				case 1 :
					// InternalDsl.g:10021:4: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
					{
					// InternalDsl.g:10021:4: ( ( '.' )=>kw= '.' )
					// InternalDsl.g:10022:5: ( '.' )=>kw= '.'
					{
					kw=(Token)match(input,36,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										current.merge(kw);
										newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
									}
					}

					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
								}
					pushFollow(FOLLOW_27);
					this_ValidID_2=ruleValidID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(this_ValidID_2);
								}
					if ( state.backtracking==0 ) {
									afterParserOrEnumRuleCall();
								}
					}
					break;

				default :
					break loop159;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleQualifiedName"



	// $ANTLR start "entryRuleNumber"
	// InternalDsl.g:10044:1: entryRuleNumber returns [String current=null] :iv_ruleNumber= ruleNumber EOF ;
	public final String entryRuleNumber() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleNumber =null;


			HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

		try {
			// InternalDsl.g:10046:2: (iv_ruleNumber= ruleNumber EOF )
			// InternalDsl.g:10047:2: iv_ruleNumber= ruleNumber EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getNumberRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleNumber=ruleNumber();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleNumber.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving

				myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleNumber"



	// $ANTLR start "ruleNumber"
	// InternalDsl.g:10056:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
	public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_HEX_0=null;
		Token this_INT_1=null;
		Token this_DECIMAL_2=null;
		Token kw=null;
		Token this_INT_4=null;
		Token this_DECIMAL_5=null;


			enterRule();
			HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

		try {
			// InternalDsl.g:10063:2: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
			// InternalDsl.g:10064:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) )
			{
			// InternalDsl.g:10064:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) )
			int alt163=2;
			int LA163_0 = input.LA(1);
			if ( (LA163_0==RULE_HEX) ) {
				alt163=1;
			}
			else if ( (LA163_0==RULE_DECIMAL||LA163_0==RULE_INT) ) {
				alt163=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 163, 0, input);
				throw nvae;
			}

			switch (alt163) {
				case 1 :
					// InternalDsl.g:10065:3: this_HEX_0= RULE_HEX
					{
					this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_HEX_0);
							}
					if ( state.backtracking==0 ) {
								newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:10073:3: ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? )
					{
					// InternalDsl.g:10073:3: ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? )
					// InternalDsl.g:10074:4: (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )?
					{
					// InternalDsl.g:10074:4: (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL )
					int alt160=2;
					int LA160_0 = input.LA(1);
					if ( (LA160_0==RULE_INT) ) {
						alt160=1;
					}
					else if ( (LA160_0==RULE_DECIMAL) ) {
						alt160=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 160, 0, input);
						throw nvae;
					}

					switch (alt160) {
						case 1 :
							// InternalDsl.g:10075:5: this_INT_1= RULE_INT
							{
							this_INT_1=(Token)match(input,RULE_INT,FOLLOW_27); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(this_INT_1);
											}
							if ( state.backtracking==0 ) {
												newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0());
											}
							}
							break;
						case 2 :
							// InternalDsl.g:10083:5: this_DECIMAL_2= RULE_DECIMAL
							{
							this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_27); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(this_DECIMAL_2);
											}
							if ( state.backtracking==0 ) {
												newLeafNode(this_DECIMAL_2, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1());
											}
							}
							break;

					}

					// InternalDsl.g:10091:4: (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )?
					int alt162=2;
					int LA162_0 = input.LA(1);
					if ( (LA162_0==36) ) {
						int LA162_1 = input.LA(2);
						if ( (LA162_1==RULE_DECIMAL||LA162_1==RULE_INT) ) {
							alt162=1;
						}
					}
					switch (alt162) {
						case 1 :
							// InternalDsl.g:10092:5: kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL )
							{
							kw=(Token)match(input,36,FOLLOW_117); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(kw);
												newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0());
											}
							// InternalDsl.g:10097:5: (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL )
							int alt161=2;
							int LA161_0 = input.LA(1);
							if ( (LA161_0==RULE_INT) ) {
								alt161=1;
							}
							else if ( (LA161_0==RULE_DECIMAL) ) {
								alt161=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return current;}
								NoViableAltException nvae =
									new NoViableAltException("", 161, 0, input);
								throw nvae;
							}

							switch (alt161) {
								case 1 :
									// InternalDsl.g:10098:6: this_INT_4= RULE_INT
									{
									this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															current.merge(this_INT_4);
														}
									if ( state.backtracking==0 ) {
															newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0());
														}
									}
									break;
								case 2 :
									// InternalDsl.g:10106:6: this_DECIMAL_5= RULE_DECIMAL
									{
									this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															current.merge(this_DECIMAL_5);
														}
									if ( state.backtracking==0 ) {
															newLeafNode(this_DECIMAL_5, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1());
														}
									}
									break;

							}

							}
							break;

					}

					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving

				myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleNumber"



	// $ANTLR start "entryRuleArrayBrackets"
	// InternalDsl.g:10123:1: entryRuleArrayBrackets returns [String current=null] :iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
	public final String entryRuleArrayBrackets() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleArrayBrackets =null;

		try {
			// InternalDsl.g:10123:53: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
			// InternalDsl.g:10124:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getArrayBracketsRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleArrayBrackets=ruleArrayBrackets();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleArrayBrackets.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleArrayBrackets"



	// $ANTLR start "ruleArrayBrackets"
	// InternalDsl.g:10130:1: ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' kw= ']' ) ;
	public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:10136:2: ( (kw= '[' kw= ']' ) )
			// InternalDsl.g:10137:2: (kw= '[' kw= ']' )
			{
			// InternalDsl.g:10137:2: (kw= '[' kw= ']' )
			// InternalDsl.g:10138:3: kw= '[' kw= ']'
			{
			kw=(Token)match(input,75,FOLLOW_15); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(kw);
						newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0());
					}
			kw=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(kw);
						newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleArrayBrackets"



	// $ANTLR start "entryRuleJvmParameterizedTypeReference"
	// InternalDsl.g:10152:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] :iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
	public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmParameterizedTypeReference =null;

		try {
			// InternalDsl.g:10152:70: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
			// InternalDsl.g:10153:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmParameterizedTypeReference; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmParameterizedTypeReference"



	// $ANTLR start "ruleJvmParameterizedTypeReference"
	// InternalDsl.g:10159:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
	public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		Token otherlv_9=null;
		Token otherlv_11=null;
		Token otherlv_13=null;
		EObject lv_arguments_2_0 =null;
		EObject lv_arguments_4_0 =null;
		EObject lv_arguments_10_0 =null;
		EObject lv_arguments_12_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10165:2: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
			// InternalDsl.g:10166:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
			{
			// InternalDsl.g:10166:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
			// InternalDsl.g:10167:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
			{
			// InternalDsl.g:10167:3: ( ( ruleQualifiedName ) )
			// InternalDsl.g:10168:4: ( ruleQualifiedName )
			{
			// InternalDsl.g:10168:4: ( ruleQualifiedName )
			// InternalDsl.g:10169:5: ruleQualifiedName
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0());
							}
			pushFollow(FOLLOW_118);
			ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalDsl.g:10183:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
			int alt168=2;
			alt168 = dfa168.predict(input);
			switch (alt168) {
				case 1 :
					// InternalDsl.g:10184:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
					{
					// InternalDsl.g:10184:4: ( ( '<' )=>otherlv_1= '<' )
					// InternalDsl.g:10185:5: ( '<' )=>otherlv_1= '<'
					{
					otherlv_1=(Token)match(input,42,FOLLOW_77); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
									}
					}

					// InternalDsl.g:10191:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
					// InternalDsl.g:10192:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
					{
					// InternalDsl.g:10192:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
					// InternalDsl.g:10193:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_76);
					lv_arguments_2_0=ruleJvmArgumentTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
											}
											add(
												current,
												"arguments",
												lv_arguments_2_0,
												"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalDsl.g:10210:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
					loop164:
					while (true) {
						int alt164=2;
						int LA164_0 = input.LA(1);
						if ( (LA164_0==31) ) {
							alt164=1;
						}

						switch (alt164) {
						case 1 :
							// InternalDsl.g:10211:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
							{
							otherlv_3=(Token)match(input,31,FOLLOW_77); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
											}
							// InternalDsl.g:10215:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
							// InternalDsl.g:10216:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
							{
							// InternalDsl.g:10216:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
							// InternalDsl.g:10217:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
													}
							pushFollow(FOLLOW_76);
							lv_arguments_4_0=ruleJvmArgumentTypeReference();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
														}
														add(
															current,
															"arguments",
															lv_arguments_4_0,
															"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop164;
						}
					}

					otherlv_5=(Token)match(input,47,FOLLOW_27); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
								}
					// InternalDsl.g:10239:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
					loop167:
					while (true) {
						int alt167=2;
						int LA167_0 = input.LA(1);
						if ( (LA167_0==36) ) {
							int LA167_2 = input.LA(2);
							if ( (LA167_2==RULE_ID) ) {
								int LA167_3 = input.LA(3);
								if ( (synpred64_InternalDsl()) ) {
									alt167=1;
								}

							}

						}

						switch (alt167) {
						case 1 :
							// InternalDsl.g:10240:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
							{
							// InternalDsl.g:10240:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
							// InternalDsl.g:10241:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
							{
							// InternalDsl.g:10247:6: ( () otherlv_7= '.' )
							// InternalDsl.g:10248:7: () otherlv_7= '.'
							{
							// InternalDsl.g:10248:7: ()
							// InternalDsl.g:10249:8: 
							{
							if ( state.backtracking==0 ) {
															current = forceCreateModelElementAndSet(
																grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0(),
																current);
														}
							}

							otherlv_7=(Token)match(input,36,FOLLOW_23); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_7, grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1());
													}
							}

							}

							// InternalDsl.g:10261:5: ( ( ruleValidID ) )
							// InternalDsl.g:10262:6: ( ruleValidID )
							{
							// InternalDsl.g:10262:6: ( ruleValidID )
							// InternalDsl.g:10263:7: ruleValidID
							{
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
														}
													}
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0());
													}
							pushFollow(FOLLOW_119);
							ruleValidID();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														afterParserOrEnumRuleCall();
													}
							}

							}

							// InternalDsl.g:10277:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
							int alt166=2;
							alt166 = dfa166.predict(input);
							switch (alt166) {
								case 1 :
									// InternalDsl.g:10278:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
									{
									// InternalDsl.g:10278:6: ( ( '<' )=>otherlv_9= '<' )
									// InternalDsl.g:10279:7: ( '<' )=>otherlv_9= '<'
									{
									otherlv_9=(Token)match(input,42,FOLLOW_77); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_9, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0());
															}
									}

									// InternalDsl.g:10285:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
									// InternalDsl.g:10286:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
									{
									// InternalDsl.g:10286:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
									// InternalDsl.g:10287:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0());
																}
									pushFollow(FOLLOW_76);
									lv_arguments_10_0=ruleJvmArgumentTypeReference();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
																	}
																	add(
																		current,
																		"arguments",
																		lv_arguments_10_0,
																		"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
																	afterParserOrEnumRuleCall();
																}
									}

									}

									// InternalDsl.g:10304:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
									loop165:
									while (true) {
										int alt165=2;
										int LA165_0 = input.LA(1);
										if ( (LA165_0==31) ) {
											alt165=1;
										}

										switch (alt165) {
										case 1 :
											// InternalDsl.g:10305:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
											{
											otherlv_11=(Token)match(input,31,FOLLOW_77); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																		newLeafNode(otherlv_11, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0());
																	}
											// InternalDsl.g:10309:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
											// InternalDsl.g:10310:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
											{
											// InternalDsl.g:10310:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
											// InternalDsl.g:10311:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
											{
											if ( state.backtracking==0 ) {
																				newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0());
																			}
											pushFollow(FOLLOW_76);
											lv_arguments_12_0=ruleJvmArgumentTypeReference();
											state._fsp--;
											if (state.failed) return current;
											if ( state.backtracking==0 ) {
																				if (current==null) {
																					current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
																				}
																				add(
																					current,
																					"arguments",
																					lv_arguments_12_0,
																					"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
																				afterParserOrEnumRuleCall();
																			}
											}

											}

											}
											break;

										default :
											break loop165;
										}
									}

									otherlv_13=(Token)match(input,47,FOLLOW_27); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_13, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3());
														}
									}
									break;

							}

							}
							break;

						default :
							break loop167;
						}
					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmParameterizedTypeReference"



	// $ANTLR start "entryRuleJvmArgumentTypeReference"
	// InternalDsl.g:10340:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] :iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
	public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmArgumentTypeReference =null;

		try {
			// InternalDsl.g:10340:65: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
			// InternalDsl.g:10341:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmArgumentTypeReference; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmArgumentTypeReference"



	// $ANTLR start "ruleJvmArgumentTypeReference"
	// InternalDsl.g:10347:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
	public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
		EObject current = null;


		EObject this_JvmTypeReference_0 =null;
		EObject this_JvmWildcardTypeReference_1 =null;


			enterRule();

		try {
			// InternalDsl.g:10353:2: ( (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
			// InternalDsl.g:10354:2: (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
			{
			// InternalDsl.g:10354:2: (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
			int alt169=2;
			int LA169_0 = input.LA(1);
			if ( (LA169_0==RULE_ID) ) {
				alt169=1;
			}
			else if ( (LA169_0==49) ) {
				alt169=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 169, 0, input);
				throw nvae;
			}

			switch (alt169) {
				case 1 :
					// InternalDsl.g:10355:3: this_JvmTypeReference_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_JvmTypeReference_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_JvmTypeReference_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalDsl.g:10364:3: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_JvmWildcardTypeReference_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmArgumentTypeReference"



	// $ANTLR start "entryRuleJvmWildcardTypeReference"
	// InternalDsl.g:10376:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] :iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
	public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmWildcardTypeReference =null;

		try {
			// InternalDsl.g:10376:65: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
			// InternalDsl.g:10377:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmWildcardTypeReference; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmWildcardTypeReference"



	// $ANTLR start "ruleJvmWildcardTypeReference"
	// InternalDsl.g:10383:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
	public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_constraints_2_0 =null;
		EObject lv_constraints_3_0 =null;
		EObject lv_constraints_4_0 =null;
		EObject lv_constraints_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10389:2: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
			// InternalDsl.g:10390:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
			{
			// InternalDsl.g:10390:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
			// InternalDsl.g:10391:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
			{
			// InternalDsl.g:10391:3: ()
			// InternalDsl.g:10392:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,49,FOLLOW_120); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
					}
			// InternalDsl.g:10402:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
			int alt172=3;
			int LA172_0 = input.LA(1);
			if ( (LA172_0==87) ) {
				alt172=1;
			}
			else if ( (LA172_0==100) ) {
				alt172=2;
			}
			switch (alt172) {
				case 1 :
					// InternalDsl.g:10403:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
					{
					// InternalDsl.g:10403:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
					// InternalDsl.g:10404:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
					{
					// InternalDsl.g:10404:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
					// InternalDsl.g:10405:6: (lv_constraints_2_0= ruleJvmUpperBound )
					{
					// InternalDsl.g:10405:6: (lv_constraints_2_0= ruleJvmUpperBound )
					// InternalDsl.g:10406:7: lv_constraints_2_0= ruleJvmUpperBound
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0());
											}
					pushFollow(FOLLOW_104);
					lv_constraints_2_0=ruleJvmUpperBound();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
												}
												add(
													current,
													"constraints",
													lv_constraints_2_0,
													"org.eclipse.xtext.xbase.Xtype.JvmUpperBound");
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalDsl.g:10423:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
					loop170:
					while (true) {
						int alt170=2;
						int LA170_0 = input.LA(1);
						if ( (LA170_0==20) ) {
							alt170=1;
						}

						switch (alt170) {
						case 1 :
							// InternalDsl.g:10424:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
							{
							// InternalDsl.g:10424:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
							// InternalDsl.g:10425:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0());
													}
							pushFollow(FOLLOW_104);
							lv_constraints_3_0=ruleJvmUpperBoundAnded();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
														}
														add(
															current,
															"constraints",
															lv_constraints_3_0,
															"org.eclipse.xtext.xbase.Xtype.JvmUpperBoundAnded");
														afterParserOrEnumRuleCall();
													}
							}

							}
							break;

						default :
							break loop170;
						}
					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:10444:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
					{
					// InternalDsl.g:10444:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
					// InternalDsl.g:10445:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
					{
					// InternalDsl.g:10445:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
					// InternalDsl.g:10446:6: (lv_constraints_4_0= ruleJvmLowerBound )
					{
					// InternalDsl.g:10446:6: (lv_constraints_4_0= ruleJvmLowerBound )
					// InternalDsl.g:10447:7: lv_constraints_4_0= ruleJvmLowerBound
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0());
											}
					pushFollow(FOLLOW_104);
					lv_constraints_4_0=ruleJvmLowerBound();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
												}
												add(
													current,
													"constraints",
													lv_constraints_4_0,
													"org.eclipse.xtext.xbase.Xtype.JvmLowerBound");
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalDsl.g:10464:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
					loop171:
					while (true) {
						int alt171=2;
						int LA171_0 = input.LA(1);
						if ( (LA171_0==20) ) {
							alt171=1;
						}

						switch (alt171) {
						case 1 :
							// InternalDsl.g:10465:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
							{
							// InternalDsl.g:10465:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
							// InternalDsl.g:10466:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0());
													}
							pushFollow(FOLLOW_104);
							lv_constraints_5_0=ruleJvmLowerBoundAnded();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
														}
														add(
															current,
															"constraints",
															lv_constraints_5_0,
															"org.eclipse.xtext.xbase.Xtype.JvmLowerBoundAnded");
														afterParserOrEnumRuleCall();
													}
							}

							}
							break;

						default :
							break loop171;
						}
					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmWildcardTypeReference"



	// $ANTLR start "entryRuleJvmUpperBound"
	// InternalDsl.g:10489:1: entryRuleJvmUpperBound returns [EObject current=null] :iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
	public final EObject entryRuleJvmUpperBound() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmUpperBound =null;

		try {
			// InternalDsl.g:10489:54: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
			// InternalDsl.g:10490:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmUpperBoundRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmUpperBound=ruleJvmUpperBound();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmUpperBound; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmUpperBound"



	// $ANTLR start "ruleJvmUpperBound"
	// InternalDsl.g:10496:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmUpperBound() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10502:2: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalDsl.g:10503:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalDsl.g:10503:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalDsl.g:10504:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,87,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
					}
			// InternalDsl.g:10508:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalDsl.g:10509:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:10509:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalDsl.g:10510:5: lv_typeReference_1_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_typeReference_1_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
								}
								set(
									current,
									"typeReference",
									lv_typeReference_1_0,
									"jbase.Jbase.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmUpperBound"



	// $ANTLR start "entryRuleJvmUpperBoundAnded"
	// InternalDsl.g:10531:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] :iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
	public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmUpperBoundAnded =null;

		try {
			// InternalDsl.g:10531:59: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
			// InternalDsl.g:10532:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmUpperBoundAnded; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmUpperBoundAnded"



	// $ANTLR start "ruleJvmUpperBoundAnded"
	// InternalDsl.g:10538:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10544:2: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalDsl.g:10545:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalDsl.g:10545:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalDsl.g:10546:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
					}
			// InternalDsl.g:10550:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalDsl.g:10551:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:10551:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalDsl.g:10552:5: lv_typeReference_1_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_typeReference_1_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
								}
								set(
									current,
									"typeReference",
									lv_typeReference_1_0,
									"jbase.Jbase.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmUpperBoundAnded"



	// $ANTLR start "entryRuleJvmLowerBound"
	// InternalDsl.g:10573:1: entryRuleJvmLowerBound returns [EObject current=null] :iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
	public final EObject entryRuleJvmLowerBound() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmLowerBound =null;

		try {
			// InternalDsl.g:10573:54: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
			// InternalDsl.g:10574:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmLowerBoundRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmLowerBound=ruleJvmLowerBound();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmLowerBound; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmLowerBound"



	// $ANTLR start "ruleJvmLowerBound"
	// InternalDsl.g:10580:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmLowerBound() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10586:2: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalDsl.g:10587:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalDsl.g:10587:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalDsl.g:10588:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,100,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
					}
			// InternalDsl.g:10592:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalDsl.g:10593:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:10593:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalDsl.g:10594:5: lv_typeReference_1_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_typeReference_1_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
								}
								set(
									current,
									"typeReference",
									lv_typeReference_1_0,
									"jbase.Jbase.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmLowerBound"



	// $ANTLR start "entryRuleJvmLowerBoundAnded"
	// InternalDsl.g:10615:1: entryRuleJvmLowerBoundAnded returns [EObject current=null] :iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF ;
	public final EObject entryRuleJvmLowerBoundAnded() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmLowerBoundAnded =null;

		try {
			// InternalDsl.g:10615:59: (iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF )
			// InternalDsl.g:10616:2: iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmLowerBoundAndedRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmLowerBoundAnded=ruleJvmLowerBoundAnded();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmLowerBoundAnded; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmLowerBoundAnded"



	// $ANTLR start "ruleJvmLowerBoundAnded"
	// InternalDsl.g:10622:1: ruleJvmLowerBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmLowerBoundAnded() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10628:2: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalDsl.g:10629:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalDsl.g:10629:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalDsl.g:10630:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0());
					}
			// InternalDsl.g:10634:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalDsl.g:10635:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:10635:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalDsl.g:10636:5: lv_typeReference_1_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_typeReference_1_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJvmLowerBoundAndedRule());
								}
								set(
									current,
									"typeReference",
									lv_typeReference_1_0,
									"jbase.Jbase.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmLowerBoundAnded"



	// $ANTLR start "entryRuleQualifiedNameWithWildcard"
	// InternalDsl.g:10657:1: entryRuleQualifiedNameWithWildcard returns [String current=null] :iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
	public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard =null;

		try {
			// InternalDsl.g:10657:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
			// InternalDsl.g:10658:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleQualifiedNameWithWildcard.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleQualifiedNameWithWildcard"



	// $ANTLR start "ruleQualifiedNameWithWildcard"
	// InternalDsl.g:10664:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) ;
	public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_QualifiedName_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10670:2: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) )
			// InternalDsl.g:10671:2: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
			{
			// InternalDsl.g:10671:2: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
			// InternalDsl.g:10672:3: this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*'
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
					}
			pushFollow(FOLLOW_121);
			this_QualifiedName_0=ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(this_QualifiedName_0);
					}
			if ( state.backtracking==0 ) {
						afterParserOrEnumRuleCall();
					}
			kw=(Token)match(input,36,FOLLOW_122); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(kw);
						newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1());
					}
			kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(kw);
						newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleQualifiedNameWithWildcard"



	// $ANTLR start "entryRuleValidID"
	// InternalDsl.g:10696:1: entryRuleValidID returns [String current=null] :iv_ruleValidID= ruleValidID EOF ;
	public final String entryRuleValidID() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleValidID =null;

		try {
			// InternalDsl.g:10696:47: (iv_ruleValidID= ruleValidID EOF )
			// InternalDsl.g:10697:2: iv_ruleValidID= ruleValidID EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getValidIDRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleValidID=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleValidID.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleValidID"



	// $ANTLR start "ruleValidID"
	// InternalDsl.g:10703:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
	public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_ID_0=null;


			enterRule();

		try {
			// InternalDsl.g:10709:2: (this_ID_0= RULE_ID )
			// InternalDsl.g:10710:2: this_ID_0= RULE_ID
			{
			this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current.merge(this_ID_0);
				}
			if ( state.backtracking==0 ) {
					newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall());
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleValidID"



	// $ANTLR start "entryRuleQualifiedNameInStaticImport"
	// InternalDsl.g:10720:1: entryRuleQualifiedNameInStaticImport returns [String current=null] :iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF ;
	public final String entryRuleQualifiedNameInStaticImport() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedNameInStaticImport =null;

		try {
			// InternalDsl.g:10720:67: (iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF )
			// InternalDsl.g:10721:2: iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getQualifiedNameInStaticImportRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleQualifiedNameInStaticImport=ruleQualifiedNameInStaticImport();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleQualifiedNameInStaticImport.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleQualifiedNameInStaticImport"



	// $ANTLR start "ruleQualifiedNameInStaticImport"
	// InternalDsl.g:10727:1: ruleQualifiedNameInStaticImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '.' )+ ;
	public final AntlrDatatypeRuleToken ruleQualifiedNameInStaticImport() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10733:2: ( (this_ValidID_0= ruleValidID kw= '.' )+ )
			// InternalDsl.g:10734:2: (this_ValidID_0= ruleValidID kw= '.' )+
			{
			// InternalDsl.g:10734:2: (this_ValidID_0= ruleValidID kw= '.' )+
			int cnt173=0;
			loop173:
			while (true) {
				int alt173=2;
				int LA173_0 = input.LA(1);
				if ( (LA173_0==RULE_ID) ) {
					int LA173_2 = input.LA(2);
					if ( (LA173_2==36) ) {
						alt173=1;
					}

				}

				switch (alt173) {
				case 1 :
					// InternalDsl.g:10735:3: this_ValidID_0= ruleValidID kw= '.'
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0());
							}
					pushFollow(FOLLOW_121);
					this_ValidID_0=ruleValidID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_ValidID_0);
							}
					if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
					kw=(Token)match(input,36,FOLLOW_22); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1());
							}
					}
					break;

				default :
					if ( cnt173 >= 1 ) break loop173;
					if (state.backtracking>0) {state.failed=true; return current;}
					EarlyExitException eee = new EarlyExitException(173, input);
					throw eee;
				}
				cnt173++;
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleQualifiedNameInStaticImport"

	// $ANTLR start synpred2_InternalDsl
	public final void synpred2_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:3187:4: ( ruleXBlockExpression )
		// InternalDsl.g:3187:5: ruleXBlockExpression
		{
		pushFollow(FOLLOW_2);
		ruleXBlockExpression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred2_InternalDsl

	// $ANTLR start synpred4_InternalDsl
	public final void synpred4_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:3340:4: ( ';' )
		// InternalDsl.g:3340:5: ';'
		{
		match(input,41,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred4_InternalDsl

	// $ANTLR start synpred5_InternalDsl
	public final void synpred5_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:3374:4: ( ( () ruleArrayBrackets ) )
		// InternalDsl.g:3374:5: ( () ruleArrayBrackets )
		{
		// InternalDsl.g:3374:5: ( () ruleArrayBrackets )
		// InternalDsl.g:3375:5: () ruleArrayBrackets
		{
		// InternalDsl.g:3375:5: ()
		// InternalDsl.g:3376:5: 
		{
		}

		pushFollow(FOLLOW_2);
		ruleArrayBrackets();
		state._fsp--;
		if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred5_InternalDsl

	// $ANTLR start synpred6_InternalDsl
	public final void synpred6_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:3536:4: ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )
		// InternalDsl.g:3536:5: ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' )
		{
		// InternalDsl.g:3536:5: ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' )
		// InternalDsl.g:3537:5: () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':'
		{
		// InternalDsl.g:3537:5: ()
		// InternalDsl.g:3538:5: 
		{
		}

		match(input,92,FOLLOW_6); if (state.failed) return;
		match(input,22,FOLLOW_87); if (state.failed) return;
		// InternalDsl.g:3541:5: ( ( ruleFullJvmFormalParameter ) )
		// InternalDsl.g:3542:6: ( ruleFullJvmFormalParameter )
		{
		// InternalDsl.g:3542:6: ( ruleFullJvmFormalParameter )
		// InternalDsl.g:3543:7: ruleFullJvmFormalParameter
		{
		pushFollow(FOLLOW_33);
		ruleFullJvmFormalParameter();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,40,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred6_InternalDsl

	// $ANTLR start synpred7_InternalDsl
	public final void synpred7_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:3578:4: ( ( () 'try' ( ( '(' ) ) ) )
		// InternalDsl.g:3578:5: ( () 'try' ( ( '(' ) ) )
		{
		// InternalDsl.g:3578:5: ( () 'try' ( ( '(' ) ) )
		// InternalDsl.g:3579:5: () 'try' ( ( '(' ) )
		{
		// InternalDsl.g:3579:5: ()
		// InternalDsl.g:3580:5: 
		{
		}

		match(input,105,FOLLOW_6); if (state.failed) return;
		// InternalDsl.g:3582:5: ( ( '(' ) )
		// InternalDsl.g:3583:6: ( '(' )
		{
		// InternalDsl.g:3583:6: ( '(' )
		// InternalDsl.g:3584:7: '('
		{
		match(input,22,FOLLOW_2); if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred7_InternalDsl

	// $ANTLR start synpred8_InternalDsl
	public final void synpred8_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:3609:4: ( ( () 'synchronized' '(' ) )
		// InternalDsl.g:3609:5: ( () 'synchronized' '(' )
		{
		// InternalDsl.g:3609:5: ( () 'synchronized' '(' )
		// InternalDsl.g:3610:5: () 'synchronized' '('
		{
		// InternalDsl.g:3610:5: ()
		// InternalDsl.g:3611:5: 
		{
		}

		match(input,102,FOLLOW_6); if (state.failed) return;
		match(input,22,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred8_InternalDsl

	// $ANTLR start synpred9_InternalDsl
	public final void synpred9_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:3746:4: ( ';' )
		// InternalDsl.g:3746:5: ';'
		{
		match(input,41,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred9_InternalDsl

	// $ANTLR start synpred11_InternalDsl
	public final void synpred11_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4028:5: ( ',' )
		// InternalDsl.g:4028:6: ','
		{
		match(input,31,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred11_InternalDsl

	// $ANTLR start synpred12_InternalDsl
	public final void synpred12_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4145:5: ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )
		// InternalDsl.g:4145:6: ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign )
		{
		// InternalDsl.g:4145:6: ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign )
		// InternalDsl.g:4146:6: () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign
		{
		// InternalDsl.g:4146:6: ()
		// InternalDsl.g:4147:6: 
		{
		}

		// InternalDsl.g:4148:6: ( ( ruleFeatureCallID ) )
		// InternalDsl.g:4149:7: ( ruleFeatureCallID )
		{
		// InternalDsl.g:4149:7: ( ruleFeatureCallID )
		// InternalDsl.g:4150:8: ruleFeatureCallID
		{
		pushFollow(FOLLOW_43);
		ruleFeatureCallID();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,75,FOLLOW_66); if (state.failed) return;
		// InternalDsl.g:4154:6: ( ( ruleXExpression ) )
		// InternalDsl.g:4155:7: ( ruleXExpression )
		{
		// InternalDsl.g:4155:7: ( ruleXExpression )
		// InternalDsl.g:4156:8: ruleXExpression
		{
		pushFollow(FOLLOW_15);
		ruleXExpression();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,76,FOLLOW_13); if (state.failed) return;
		// InternalDsl.g:4160:6: ( '[' ( ( ruleXExpression ) ) ']' )*
		loop175:
		while (true) {
			int alt175=2;
			int LA175_0 = input.LA(1);
			if ( (LA175_0==75) ) {
				alt175=1;
			}

			switch (alt175) {
			case 1 :
				// InternalDsl.g:4161:7: '[' ( ( ruleXExpression ) ) ']'
				{
				match(input,75,FOLLOW_66); if (state.failed) return;
				// InternalDsl.g:4162:7: ( ( ruleXExpression ) )
				// InternalDsl.g:4163:8: ( ruleXExpression )
				{
				// InternalDsl.g:4163:8: ( ruleXExpression )
				// InternalDsl.g:4164:9: ruleXExpression
				{
				pushFollow(FOLLOW_15);
				ruleXExpression();
				state._fsp--;
				if (state.failed) return;
				}

				}

				match(input,76,FOLLOW_13); if (state.failed) return;
				}
				break;

			default :
				break loop175;
			}
		}

		pushFollow(FOLLOW_2);
		ruleOpSingleAssign();
		state._fsp--;
		if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred12_InternalDsl

	// $ANTLR start synpred13_InternalDsl
	public final void synpred13_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4284:5: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
		// InternalDsl.g:4284:6: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		{
		// InternalDsl.g:4284:6: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		// InternalDsl.g:4285:6: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
		{
		// InternalDsl.g:4285:6: ()
		// InternalDsl.g:4286:6: 
		{
		}

		// InternalDsl.g:4287:6: ( ( ruleFeatureCallID ) )
		// InternalDsl.g:4288:7: ( ruleFeatureCallID )
		{
		// InternalDsl.g:4288:7: ( ruleFeatureCallID )
		// InternalDsl.g:4289:8: ruleFeatureCallID
		{
		pushFollow(FOLLOW_16);
		ruleFeatureCallID();
		state._fsp--;
		if (state.failed) return;
		}

		}

		pushFollow(FOLLOW_2);
		ruleOpSingleAssign();
		state._fsp--;
		if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred13_InternalDsl

	// $ANTLR start synpred14_InternalDsl
	public final void synpred14_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4361:7: ( ( () '?' ) )
		// InternalDsl.g:4361:8: ( () '?' )
		{
		// InternalDsl.g:4361:8: ( () '?' )
		// InternalDsl.g:4362:8: () '?'
		{
		// InternalDsl.g:4362:8: ()
		// InternalDsl.g:4363:8: 
		{
		}

		match(input,49,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred14_InternalDsl

	// $ANTLR start synpred15_InternalDsl
	public final void synpred15_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4427:7: ( ( () ( ( ruleOpMultiAssign ) ) ) )
		// InternalDsl.g:4427:8: ( () ( ( ruleOpMultiAssign ) ) )
		{
		// InternalDsl.g:4427:8: ( () ( ( ruleOpMultiAssign ) ) )
		// InternalDsl.g:4428:8: () ( ( ruleOpMultiAssign ) )
		{
		// InternalDsl.g:4428:8: ()
		// InternalDsl.g:4429:8: 
		{
		}

		// InternalDsl.g:4430:8: ( ( ruleOpMultiAssign ) )
		// InternalDsl.g:4431:9: ( ruleOpMultiAssign )
		{
		// InternalDsl.g:4431:9: ( ruleOpMultiAssign )
		// InternalDsl.g:4432:10: ruleOpMultiAssign
		{
		pushFollow(FOLLOW_2);
		ruleOpMultiAssign();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred15_InternalDsl

	// $ANTLR start synpred16_InternalDsl
	public final void synpred16_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4629:7: ( '[' )
		// InternalDsl.g:4629:8: '['
		{
		match(input,75,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred16_InternalDsl

	// $ANTLR start synpred17_InternalDsl
	public final void synpred17_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4617:4: ( ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* ) )
		// InternalDsl.g:4617:5: ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* )
		{
		// InternalDsl.g:4617:5: ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* )
		// InternalDsl.g:4618:5: () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )*
		{
		// InternalDsl.g:4618:5: ()
		// InternalDsl.g:4619:5: 
		{
		}

		match(input,75,FOLLOW_66); if (state.failed) return;
		// InternalDsl.g:4621:5: ( ( ruleXExpression ) )
		// InternalDsl.g:4622:6: ( ruleXExpression )
		{
		// InternalDsl.g:4622:6: ( ruleXExpression )
		// InternalDsl.g:4623:7: ruleXExpression
		{
		pushFollow(FOLLOW_15);
		ruleXExpression();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,76,FOLLOW_62); if (state.failed) return;
		// InternalDsl.g:4627:5: ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )*
		loop176:
		while (true) {
			int alt176=2;
			int LA176_0 = input.LA(1);
			if ( (LA176_0==75) && (synpred16_InternalDsl())) {
				alt176=1;
			}

			switch (alt176) {
			case 1 :
				// InternalDsl.g:4628:6: ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']'
				{
				// InternalDsl.g:4628:6: ( ( '[' )=> '[' )
				// InternalDsl.g:4629:7: ( '[' )=> '['
				{
				match(input,75,FOLLOW_66); if (state.failed) return;
				}

				// InternalDsl.g:4632:6: ( ( ruleXExpression ) )
				// InternalDsl.g:4633:7: ( ruleXExpression )
				{
				// InternalDsl.g:4633:7: ( ruleXExpression )
				// InternalDsl.g:4634:8: ruleXExpression
				{
				pushFollow(FOLLOW_15);
				ruleXExpression();
				state._fsp--;
				if (state.failed) return;
				}

				}

				match(input,76,FOLLOW_62); if (state.failed) return;
				}
				break;

			default :
				break loop176;
			}
		}

		}

		}

	}
	// $ANTLR end synpred17_InternalDsl

	// $ANTLR start synpred18_InternalDsl
	public final void synpred18_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4678:7: ( '[' )
		// InternalDsl.g:4678:8: '['
		{
		match(input,75,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred18_InternalDsl

	// $ANTLR start synpred19_InternalDsl
	public final void synpred19_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4754:5: ( ( '(' ) )
		// InternalDsl.g:4754:6: ( '(' )
		{
		// InternalDsl.g:4754:6: ( '(' )
		// InternalDsl.g:4755:6: '('
		{
		match(input,22,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred19_InternalDsl

	// $ANTLR start synpred20_InternalDsl
	public final void synpred20_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4870:5: ( ( '<' ) )
		// InternalDsl.g:4870:6: ( '<' )
		{
		// InternalDsl.g:4870:6: ( '<' )
		// InternalDsl.g:4871:6: '<'
		{
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred20_InternalDsl

	// $ANTLR start synpred21_InternalDsl
	public final void synpred21_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4940:5: ( ( '(' ) )
		// InternalDsl.g:4940:6: ( '(' )
		{
		// InternalDsl.g:4940:6: ( '(' )
		// InternalDsl.g:4941:6: '('
		{
		match(input,22,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred21_InternalDsl

	// $ANTLR start synpred23_InternalDsl
	public final void synpred23_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5118:5: ( ( ruleXJArrayDimension ) )
		// InternalDsl.g:5118:6: ( ruleXJArrayDimension )
		{
		// InternalDsl.g:5118:6: ( ruleXJArrayDimension )
		// InternalDsl.g:5119:6: ruleXJArrayDimension
		{
		pushFollow(FOLLOW_2);
		ruleXJArrayDimension();
		state._fsp--;
		if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred23_InternalDsl

	// $ANTLR start synpred24_InternalDsl
	public final void synpred24_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5165:4: ( ( ruleXJArrayLiteral ) )
		// InternalDsl.g:5165:5: ( ruleXJArrayLiteral )
		{
		// InternalDsl.g:5165:5: ( ruleXJArrayLiteral )
		// InternalDsl.g:5166:5: ruleXJArrayLiteral
		{
		pushFollow(FOLLOW_2);
		ruleXJArrayLiteral();
		state._fsp--;
		if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred24_InternalDsl

	// $ANTLR start synpred25_InternalDsl
	public final void synpred25_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5237:4: ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )
		// InternalDsl.g:5237:5: ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) )
		{
		// InternalDsl.g:5237:5: ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) )
		// InternalDsl.g:5238:5: () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) )
		{
		// InternalDsl.g:5238:5: ()
		// InternalDsl.g:5239:5: 
		{
		}

		match(input,22,FOLLOW_23); if (state.failed) return;
		// InternalDsl.g:5241:5: ( ( ruleJvmTypeReference ) )
		// InternalDsl.g:5242:6: ( ruleJvmTypeReference )
		{
		// InternalDsl.g:5242:6: ( ruleJvmTypeReference )
		// InternalDsl.g:5243:7: ruleJvmTypeReference
		{
		pushFollow(FOLLOW_8);
		ruleJvmTypeReference();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,25,FOLLOW_66); if (state.failed) return;
		// InternalDsl.g:5247:5: ( ( ruleXExpression ) )
		// InternalDsl.g:5248:6: ( ruleXExpression )
		{
		// InternalDsl.g:5248:6: ( ruleXExpression )
		// InternalDsl.g:5249:7: ruleXExpression
		{
		pushFollow(FOLLOW_2);
		ruleXExpression();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred25_InternalDsl

	// $ANTLR start synpred26_InternalDsl
	public final void synpred26_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5340:5: ( ( () ( ( ruleOpPostfix ) ) ) )
		// InternalDsl.g:5340:6: ( () ( ( ruleOpPostfix ) ) )
		{
		// InternalDsl.g:5340:6: ( () ( ( ruleOpPostfix ) ) )
		// InternalDsl.g:5341:6: () ( ( ruleOpPostfix ) )
		{
		// InternalDsl.g:5341:6: ()
		// InternalDsl.g:5342:6: 
		{
		}

		// InternalDsl.g:5343:6: ( ( ruleOpPostfix ) )
		// InternalDsl.g:5344:7: ( ruleOpPostfix )
		{
		// InternalDsl.g:5344:7: ( ruleOpPostfix )
		// InternalDsl.g:5345:8: ruleOpPostfix
		{
		pushFollow(FOLLOW_2);
		ruleOpPostfix();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred26_InternalDsl

	// $ANTLR start synpred27_InternalDsl
	public final void synpred27_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5408:6: ( ( () ( ( ruleOpPostfix ) ) ) )
		// InternalDsl.g:5408:7: ( () ( ( ruleOpPostfix ) ) )
		{
		// InternalDsl.g:5408:7: ( () ( ( ruleOpPostfix ) ) )
		// InternalDsl.g:5409:7: () ( ( ruleOpPostfix ) )
		{
		// InternalDsl.g:5409:7: ()
		// InternalDsl.g:5410:7: 
		{
		}

		// InternalDsl.g:5411:7: ( ( ruleOpPostfix ) )
		// InternalDsl.g:5412:8: ( ruleOpPostfix )
		{
		// InternalDsl.g:5412:8: ( ruleOpPostfix )
		// InternalDsl.g:5413:9: ruleOpPostfix
		{
		pushFollow(FOLLOW_2);
		ruleOpPostfix();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred27_InternalDsl

	// $ANTLR start synpred28_InternalDsl
	public final void synpred28_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5458:9: ( '[' )
		// InternalDsl.g:5458:10: '['
		{
		match(input,75,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred28_InternalDsl

	// $ANTLR start synpred29_InternalDsl
	public final void synpred29_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5446:6: ( ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* ) )
		// InternalDsl.g:5446:7: ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* )
		{
		// InternalDsl.g:5446:7: ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* )
		// InternalDsl.g:5447:7: () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )*
		{
		// InternalDsl.g:5447:7: ()
		// InternalDsl.g:5448:7: 
		{
		}

		match(input,75,FOLLOW_66); if (state.failed) return;
		// InternalDsl.g:5450:7: ( ( ruleXExpression ) )
		// InternalDsl.g:5451:8: ( ruleXExpression )
		{
		// InternalDsl.g:5451:8: ( ruleXExpression )
		// InternalDsl.g:5452:9: ruleXExpression
		{
		pushFollow(FOLLOW_15);
		ruleXExpression();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,76,FOLLOW_62); if (state.failed) return;
		// InternalDsl.g:5456:7: ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )*
		loop177:
		while (true) {
			int alt177=2;
			int LA177_0 = input.LA(1);
			if ( (LA177_0==75) && (synpred28_InternalDsl())) {
				alt177=1;
			}

			switch (alt177) {
			case 1 :
				// InternalDsl.g:5457:8: ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']'
				{
				// InternalDsl.g:5457:8: ( ( '[' )=> '[' )
				// InternalDsl.g:5458:9: ( '[' )=> '['
				{
				match(input,75,FOLLOW_66); if (state.failed) return;
				}

				// InternalDsl.g:5461:8: ( ( ruleXExpression ) )
				// InternalDsl.g:5462:9: ( ruleXExpression )
				{
				// InternalDsl.g:5462:9: ( ruleXExpression )
				// InternalDsl.g:5463:10: ruleXExpression
				{
				pushFollow(FOLLOW_15);
				ruleXExpression();
				state._fsp--;
				if (state.failed) return;
				}

				}

				match(input,76,FOLLOW_62); if (state.failed) return;
				}
				break;

			default :
				break loop177;
			}
		}

		}

		}

	}
	// $ANTLR end synpred29_InternalDsl

	// $ANTLR start synpred30_InternalDsl
	public final void synpred30_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5507:9: ( '[' )
		// InternalDsl.g:5507:10: '['
		{
		match(input,75,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred30_InternalDsl

	// $ANTLR start synpred31_InternalDsl
	public final void synpred31_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5570:5: ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )
		// InternalDsl.g:5570:6: ( () ( ( ruleArrayBrackets ) )* '.' 'class' )
		{
		// InternalDsl.g:5570:6: ( () ( ( ruleArrayBrackets ) )* '.' 'class' )
		// InternalDsl.g:5571:6: () ( ( ruleArrayBrackets ) )* '.' 'class'
		{
		// InternalDsl.g:5571:6: ()
		// InternalDsl.g:5572:6: 
		{
		}

		// InternalDsl.g:5573:6: ( ( ruleArrayBrackets ) )*
		loop178:
		while (true) {
			int alt178=2;
			int LA178_0 = input.LA(1);
			if ( (LA178_0==75) ) {
				alt178=1;
			}

			switch (alt178) {
			case 1 :
				// InternalDsl.g:5574:7: ( ruleArrayBrackets )
				{
				// InternalDsl.g:5574:7: ( ruleArrayBrackets )
				// InternalDsl.g:5575:8: ruleArrayBrackets
				{
				pushFollow(FOLLOW_83);
				ruleArrayBrackets();
				state._fsp--;
				if (state.failed) return;
				}

				}
				break;

			default :
				break loop178;
			}
		}

		match(input,36,FOLLOW_84); if (state.failed) return;
		match(input,82,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred31_InternalDsl

	// $ANTLR start synpred32_InternalDsl
	public final void synpred32_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5622:6: ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
		// InternalDsl.g:5622:7: ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		{
		// InternalDsl.g:5622:7: ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		// InternalDsl.g:5623:7: () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
		{
		// InternalDsl.g:5623:7: ()
		// InternalDsl.g:5624:7: 
		{
		}

		match(input,36,FOLLOW_85); if (state.failed) return;
		// InternalDsl.g:5626:7: ( ( ruleFeatureCallID ) )
		// InternalDsl.g:5627:8: ( ruleFeatureCallID )
		{
		// InternalDsl.g:5627:8: ( ruleFeatureCallID )
		// InternalDsl.g:5628:9: ruleFeatureCallID
		{
		pushFollow(FOLLOW_16);
		ruleFeatureCallID();
		state._fsp--;
		if (state.failed) return;
		}

		}

		pushFollow(FOLLOW_2);
		ruleOpSingleAssign();
		state._fsp--;
		if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred32_InternalDsl

	// $ANTLR start synpred33_InternalDsl
	public final void synpred33_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5694:6: ( ( () '.' ) )
		// InternalDsl.g:5694:7: ( () '.' )
		{
		// InternalDsl.g:5694:7: ( () '.' )
		// InternalDsl.g:5695:7: () '.'
		{
		// InternalDsl.g:5695:7: ()
		// InternalDsl.g:5696:7: 
		{
		}

		match(input,36,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred33_InternalDsl

	// $ANTLR start synpred34_InternalDsl
	public final void synpred34_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5732:7: ( ( '(' ) )
		// InternalDsl.g:5732:8: ( '(' )
		{
		// InternalDsl.g:5732:8: ( '(' )
		// InternalDsl.g:5733:8: '('
		{
		match(input,22,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred34_InternalDsl

	// $ANTLR start synpred36_InternalDsl
	public final void synpred36_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:6172:5: ( 'else' )
		// InternalDsl.g:6172:6: 'else'
		{
		match(input,86,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred36_InternalDsl

	// $ANTLR start synpred38_InternalDsl
	public final void synpred38_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:6916:7: ( 'finally' )
		// InternalDsl.g:6916:8: 'finally'
		{
		match(input,91,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred38_InternalDsl

	// $ANTLR start synpred41_InternalDsl
	public final void synpred41_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:7156:4: ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )
		// InternalDsl.g:7156:5: ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) )
		{
		// InternalDsl.g:7156:5: ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) )
		// InternalDsl.g:7157:5: () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) )
		{
		// InternalDsl.g:7157:5: ()
		// InternalDsl.g:7158:5: 
		{
		}

		match(input,96,FOLLOW_23); if (state.failed) return;
		// InternalDsl.g:7160:5: ( ( ruleQualifiedName ) )
		// InternalDsl.g:7161:6: ( ruleQualifiedName )
		{
		// InternalDsl.g:7161:6: ( ruleQualifiedName )
		// InternalDsl.g:7162:7: ruleQualifiedName
		{
		pushFollow(FOLLOW_43);
		ruleQualifiedName();
		state._fsp--;
		if (state.failed) return;
		}

		}

		// InternalDsl.g:7165:5: ( ( ruleXJArrayDimension ) )
		// InternalDsl.g:7166:6: ( ruleXJArrayDimension )
		{
		// InternalDsl.g:7166:6: ( ruleXJArrayDimension )
		// InternalDsl.g:7167:7: ruleXJArrayDimension
		{
		pushFollow(FOLLOW_2);
		ruleXJArrayDimension();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred41_InternalDsl

	// $ANTLR start synpred42_InternalDsl
	public final void synpred42_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:7550:6: ( ( '>' '>' ) )
		// InternalDsl.g:7550:7: ( '>' '>' )
		{
		// InternalDsl.g:7550:7: ( '>' '>' )
		// InternalDsl.g:7551:7: '>' '>'
		{
		match(input,47,FOLLOW_100); if (state.failed) return;
		match(input,47,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred42_InternalDsl

	// $ANTLR start synpred43_InternalDsl
	public final void synpred43_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:7611:5: ( ( () ( ( ruleOpAnd ) ) ) )
		// InternalDsl.g:7611:6: ( () ( ( ruleOpAnd ) ) )
		{
		// InternalDsl.g:7611:6: ( () ( ( ruleOpAnd ) ) )
		// InternalDsl.g:7612:6: () ( ( ruleOpAnd ) )
		{
		// InternalDsl.g:7612:6: ()
		// InternalDsl.g:7613:6: 
		{
		}

		// InternalDsl.g:7614:6: ( ( ruleOpAnd ) )
		// InternalDsl.g:7615:7: ( ruleOpAnd )
		{
		// InternalDsl.g:7615:7: ( ruleOpAnd )
		// InternalDsl.g:7616:8: ruleOpAnd
		{
		pushFollow(FOLLOW_2);
		ruleOpAnd();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred43_InternalDsl

	// $ANTLR start synpred44_InternalDsl
	public final void synpred44_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:7696:5: ( ( () ( ( ruleOpInclusiveOr ) ) ) )
		// InternalDsl.g:7696:6: ( () ( ( ruleOpInclusiveOr ) ) )
		{
		// InternalDsl.g:7696:6: ( () ( ( ruleOpInclusiveOr ) ) )
		// InternalDsl.g:7697:6: () ( ( ruleOpInclusiveOr ) )
		{
		// InternalDsl.g:7697:6: ()
		// InternalDsl.g:7698:6: 
		{
		}

		// InternalDsl.g:7699:6: ( ( ruleOpInclusiveOr ) )
		// InternalDsl.g:7700:7: ( ruleOpInclusiveOr )
		{
		// InternalDsl.g:7700:7: ( ruleOpInclusiveOr )
		// InternalDsl.g:7701:8: ruleOpInclusiveOr
		{
		pushFollow(FOLLOW_2);
		ruleOpInclusiveOr();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred44_InternalDsl

	// $ANTLR start synpred45_InternalDsl
	public final void synpred45_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:7803:5: ( ( () ( ( ruleOpExclusiveOr ) ) ) )
		// InternalDsl.g:7803:6: ( () ( ( ruleOpExclusiveOr ) ) )
		{
		// InternalDsl.g:7803:6: ( () ( ( ruleOpExclusiveOr ) ) )
		// InternalDsl.g:7804:6: () ( ( ruleOpExclusiveOr ) )
		{
		// InternalDsl.g:7804:6: ()
		// InternalDsl.g:7805:6: 
		{
		}

		// InternalDsl.g:7806:6: ( ( ruleOpExclusiveOr ) )
		// InternalDsl.g:7807:7: ( ruleOpExclusiveOr )
		{
		// InternalDsl.g:7807:7: ( ruleOpExclusiveOr )
		// InternalDsl.g:7808:8: ruleOpExclusiveOr
		{
		pushFollow(FOLLOW_2);
		ruleOpExclusiveOr();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred45_InternalDsl

	// $ANTLR start synpred46_InternalDsl
	public final void synpred46_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:7910:5: ( ( () ( ( ruleOpBitwiseAnd ) ) ) )
		// InternalDsl.g:7910:6: ( () ( ( ruleOpBitwiseAnd ) ) )
		{
		// InternalDsl.g:7910:6: ( () ( ( ruleOpBitwiseAnd ) ) )
		// InternalDsl.g:7911:6: () ( ( ruleOpBitwiseAnd ) )
		{
		// InternalDsl.g:7911:6: ()
		// InternalDsl.g:7912:6: 
		{
		}

		// InternalDsl.g:7913:6: ( ( ruleOpBitwiseAnd ) )
		// InternalDsl.g:7914:7: ( ruleOpBitwiseAnd )
		{
		// InternalDsl.g:7914:7: ( ruleOpBitwiseAnd )
		// InternalDsl.g:7915:8: ruleOpBitwiseAnd
		{
		pushFollow(FOLLOW_2);
		ruleOpBitwiseAnd();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred46_InternalDsl

	// $ANTLR start synpred47_InternalDsl
	public final void synpred47_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8051:5: ( ( () '{' ) )
		// InternalDsl.g:8051:6: ( () '{' )
		{
		// InternalDsl.g:8051:6: ( () '{' )
		// InternalDsl.g:8052:6: () '{'
		{
		// InternalDsl.g:8052:6: ()
		// InternalDsl.g:8053:6: 
		{
		}

		match(input,107,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred47_InternalDsl

	// $ANTLR start synpred48_InternalDsl
	public final void synpred48_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8152:5: ( ( () '{' ) )
		// InternalDsl.g:8152:6: ( () '{' )
		{
		// InternalDsl.g:8152:6: ( () '{' )
		// InternalDsl.g:8153:6: () '{'
		{
		// InternalDsl.g:8153:6: ()
		// InternalDsl.g:8154:6: 
		{
		}

		match(input,107,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred48_InternalDsl

	// $ANTLR start synpred49_InternalDsl
	public final void synpred49_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8280:5: ( '(' )
		// InternalDsl.g:8280:6: '('
		{
		match(input,22,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred49_InternalDsl

	// $ANTLR start synpred50_InternalDsl
	public final void synpred50_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8289:7: ( ( ( ( ruleValidID ) ) '=' ) )
		// InternalDsl.g:8289:8: ( ( ( ruleValidID ) ) '=' )
		{
		// InternalDsl.g:8289:8: ( ( ( ruleValidID ) ) '=' )
		// InternalDsl.g:8290:8: ( ( ruleValidID ) ) '='
		{
		// InternalDsl.g:8290:8: ( ( ruleValidID ) )
		// InternalDsl.g:8291:9: ( ruleValidID )
		{
		// InternalDsl.g:8291:9: ( ruleValidID )
		// InternalDsl.g:8292:10: ruleValidID
		{
		pushFollow(FOLLOW_16);
		ruleValidID();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,45,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred50_InternalDsl

	// $ANTLR start synpred53_InternalDsl
	public final void synpred53_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8560:5: ( ( () ( ( ruleOpOr ) ) ) )
		// InternalDsl.g:8560:6: ( () ( ( ruleOpOr ) ) )
		{
		// InternalDsl.g:8560:6: ( () ( ( ruleOpOr ) ) )
		// InternalDsl.g:8561:6: () ( ( ruleOpOr ) )
		{
		// InternalDsl.g:8561:6: ()
		// InternalDsl.g:8562:6: 
		{
		}

		// InternalDsl.g:8563:6: ( ( ruleOpOr ) )
		// InternalDsl.g:8564:7: ( ruleOpOr )
		{
		// InternalDsl.g:8564:7: ( ruleOpOr )
		// InternalDsl.g:8565:8: ruleOpOr
		{
		pushFollow(FOLLOW_2);
		ruleOpOr();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred53_InternalDsl

	// $ANTLR start synpred54_InternalDsl
	public final void synpred54_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8689:5: ( ( () ( ( ruleOpEquality ) ) ) )
		// InternalDsl.g:8689:6: ( () ( ( ruleOpEquality ) ) )
		{
		// InternalDsl.g:8689:6: ( () ( ( ruleOpEquality ) ) )
		// InternalDsl.g:8690:6: () ( ( ruleOpEquality ) )
		{
		// InternalDsl.g:8690:6: ()
		// InternalDsl.g:8691:6: 
		{
		}

		// InternalDsl.g:8692:6: ( ( ruleOpEquality ) )
		// InternalDsl.g:8693:7: ( ruleOpEquality )
		{
		// InternalDsl.g:8693:7: ( ruleOpEquality )
		// InternalDsl.g:8694:8: ruleOpEquality
		{
		pushFollow(FOLLOW_2);
		ruleOpEquality();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred54_InternalDsl

	// $ANTLR start synpred55_InternalDsl
	public final void synpred55_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8775:6: ( ( () 'instanceof' ) )
		// InternalDsl.g:8775:7: ( () 'instanceof' )
		{
		// InternalDsl.g:8775:7: ( () 'instanceof' )
		// InternalDsl.g:8776:7: () 'instanceof'
		{
		// InternalDsl.g:8776:7: ()
		// InternalDsl.g:8777:7: 
		{
		}

		match(input,95,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred55_InternalDsl

	// $ANTLR start synpred56_InternalDsl
	public final void synpred56_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8818:6: ( ( () ( ( ruleOpCompare ) ) ) )
		// InternalDsl.g:8818:7: ( () ( ( ruleOpCompare ) ) )
		{
		// InternalDsl.g:8818:7: ( () ( ( ruleOpCompare ) ) )
		// InternalDsl.g:8819:7: () ( ( ruleOpCompare ) )
		{
		// InternalDsl.g:8819:7: ()
		// InternalDsl.g:8820:7: 
		{
		}

		// InternalDsl.g:8821:7: ( ( ruleOpCompare ) )
		// InternalDsl.g:8822:8: ( ruleOpCompare )
		{
		// InternalDsl.g:8822:8: ( ruleOpCompare )
		// InternalDsl.g:8823:9: ruleOpCompare
		{
		pushFollow(FOLLOW_2);
		ruleOpCompare();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred56_InternalDsl

	// $ANTLR start synpred57_InternalDsl
	public final void synpred57_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8953:5: ( ( () ( ( ruleOpOther ) ) ) )
		// InternalDsl.g:8953:6: ( () ( ( ruleOpOther ) ) )
		{
		// InternalDsl.g:8953:6: ( () ( ( ruleOpOther ) ) )
		// InternalDsl.g:8954:6: () ( ( ruleOpOther ) )
		{
		// InternalDsl.g:8954:6: ()
		// InternalDsl.g:8955:6: 
		{
		}

		// InternalDsl.g:8956:6: ( ( ruleOpOther ) )
		// InternalDsl.g:8957:7: ( ruleOpOther )
		{
		// InternalDsl.g:8957:7: ( ruleOpOther )
		// InternalDsl.g:8958:8: ruleOpOther
		{
		pushFollow(FOLLOW_2);
		ruleOpOther();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred57_InternalDsl

	// $ANTLR start synpred58_InternalDsl
	public final void synpred58_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:9038:5: ( ( () ( ( ruleOpAdd ) ) ) )
		// InternalDsl.g:9038:6: ( () ( ( ruleOpAdd ) ) )
		{
		// InternalDsl.g:9038:6: ( () ( ( ruleOpAdd ) ) )
		// InternalDsl.g:9039:6: () ( ( ruleOpAdd ) )
		{
		// InternalDsl.g:9039:6: ()
		// InternalDsl.g:9040:6: 
		{
		}

		// InternalDsl.g:9041:6: ( ( ruleOpAdd ) )
		// InternalDsl.g:9042:7: ( ruleOpAdd )
		{
		// InternalDsl.g:9042:7: ( ruleOpAdd )
		// InternalDsl.g:9043:8: ruleOpAdd
		{
		pushFollow(FOLLOW_2);
		ruleOpAdd();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred58_InternalDsl

	// $ANTLR start synpred59_InternalDsl
	public final void synpred59_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:9153:5: ( ( () ( ( ruleOpMulti ) ) ) )
		// InternalDsl.g:9153:6: ( () ( ( ruleOpMulti ) ) )
		{
		// InternalDsl.g:9153:6: ( () ( ( ruleOpMulti ) ) )
		// InternalDsl.g:9154:6: () ( ( ruleOpMulti ) )
		{
		// InternalDsl.g:9154:6: ()
		// InternalDsl.g:9155:6: 
		{
		}

		// InternalDsl.g:9156:6: ( ( ruleOpMulti ) )
		// InternalDsl.g:9157:7: ( ruleOpMulti )
		{
		// InternalDsl.g:9157:7: ( ruleOpMulti )
		// InternalDsl.g:9158:8: ruleOpMulti
		{
		pushFollow(FOLLOW_2);
		ruleOpMulti();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred59_InternalDsl

	// $ANTLR start synpred60_InternalDsl
	public final void synpred60_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:9587:4: ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
		// InternalDsl.g:9587:5: ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
		{
		// InternalDsl.g:9587:5: ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
		// InternalDsl.g:9588:5: () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
		{
		// InternalDsl.g:9588:5: ()
		// InternalDsl.g:9589:5: 
		{
		}

		// InternalDsl.g:9590:5: ( ( 'final' ) )?
		int alt179=2;
		int LA179_0 = input.LA(1);
		if ( (LA179_0==90) ) {
			alt179=1;
		}
		switch (alt179) {
			case 1 :
				// InternalDsl.g:9591:6: ( 'final' )
				{
				// InternalDsl.g:9591:6: ( 'final' )
				// InternalDsl.g:9592:7: 'final'
				{
				match(input,90,FOLLOW_23); if (state.failed) return;
				}

				}
				break;

		}

		// InternalDsl.g:9595:5: ( ( ruleJvmTypeReference ) )
		// InternalDsl.g:9596:6: ( ruleJvmTypeReference )
		{
		// InternalDsl.g:9596:6: ( ruleJvmTypeReference )
		// InternalDsl.g:9597:7: ruleJvmTypeReference
		{
		pushFollow(FOLLOW_23);
		ruleJvmTypeReference();
		state._fsp--;
		if (state.failed) return;
		}

		}

		// InternalDsl.g:9600:5: ( ( ruleValidID ) )
		// InternalDsl.g:9601:6: ( ruleValidID )
		{
		// InternalDsl.g:9601:6: ( ruleValidID )
		// InternalDsl.g:9602:7: ruleValidID
		{
		pushFollow(FOLLOW_2);
		ruleValidID();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred60_InternalDsl

	// $ANTLR start synpred61_InternalDsl
	public final void synpred61_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:9972:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )
		// InternalDsl.g:
		{
		if ( (input.LA(1) >= RULE_CHARACTER && input.LA(1) <= RULE_INT)||input.LA(1)==RULE_STRING||input.LA(1)==14||input.LA(1)==22||(input.LA(1) >= 28 && input.LA(1) <= 29)||(input.LA(1) >= 32 && input.LA(1) <= 33)||(input.LA(1) >= 87 && input.LA(1) <= 89)||input.LA(1)==94||(input.LA(1) >= 96 && input.LA(1) <= 97)||(input.LA(1) >= 99 && input.LA(1) <= 100)||input.LA(1)==104||input.LA(1)==107||input.LA(1)==112 ) {
			input.consume();
			state.errorRecovery=false;
			state.failed=false;
		}
		else {
			if (state.backtracking>0) {state.failed=true; return;}
			MismatchedSetException mse = new MismatchedSetException(null,input);
			throw mse;
		}
		}

	}
	// $ANTLR end synpred61_InternalDsl

	// $ANTLR start synpred62_InternalDsl
	public final void synpred62_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:10022:5: ( '.' )
		// InternalDsl.g:10022:6: '.'
		{
		match(input,36,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred62_InternalDsl

	// $ANTLR start synpred63_InternalDsl
	public final void synpred63_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:10185:5: ( '<' )
		// InternalDsl.g:10185:6: '<'
		{
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred63_InternalDsl

	// $ANTLR start synpred64_InternalDsl
	public final void synpred64_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:10241:6: ( ( () '.' ) )
		// InternalDsl.g:10241:7: ( () '.' )
		{
		// InternalDsl.g:10241:7: ( () '.' )
		// InternalDsl.g:10242:7: () '.'
		{
		// InternalDsl.g:10242:7: ()
		// InternalDsl.g:10243:7: 
		{
		}

		match(input,36,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred64_InternalDsl

	// $ANTLR start synpred65_InternalDsl
	public final void synpred65_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:10279:7: ( '<' )
		// InternalDsl.g:10279:8: '<'
		{
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred65_InternalDsl

	// Delegated rules

	public final boolean synpred2_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred60_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred60_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred8_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred21_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred21_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred42_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred42_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred64_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred64_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred63_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred63_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred41_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred41_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred43_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred43_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred23_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred23_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred44_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred44_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred7_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred7_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred61_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred61_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred62_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred62_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred65_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred65_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred5_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred6_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred6_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred20_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred20_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred29_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred29_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred18_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred18_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred19_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred19_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred49_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred49_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred38_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred38_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred27_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred27_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred48_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred48_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred58_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred58_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred59_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred59_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred16_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred16_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred26_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred26_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred25_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred25_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred46_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred46_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred14_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred14_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred15_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred15_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred56_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred56_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred57_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred57_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred45_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred45_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred47_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred47_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred34_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred34_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred36_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred36_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred13_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred13_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred24_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred24_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred9_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred9_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred17_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred17_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred28_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred28_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred50_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred50_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred53_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred53_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred11_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred11_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred54_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred54_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred30_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred30_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred32_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred32_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred55_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred55_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred12_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred12_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred33_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred33_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred31_InternalDsl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred31_InternalDsl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA54 dfa54 = new DFA54(this);
	protected DFA74 dfa74 = new DFA74(this);
	protected DFA73 dfa73 = new DFA73(this);
	protected DFA77 dfa77 = new DFA77(this);
	protected DFA80 dfa80 = new DFA80(this);
	protected DFA83 dfa83 = new DFA83(this);
	protected DFA86 dfa86 = new DFA86(this);
	protected DFA87 dfa87 = new DFA87(this);
	protected DFA89 dfa89 = new DFA89(this);
	protected DFA95 dfa95 = new DFA95(this);
	protected DFA168 dfa168 = new DFA168(this);
	protected DFA166 dfa166 = new DFA166(this);
	static final String dfa_1s = "\7\uffff";
	static final String dfa_2s = "\2\uffff\1\4\2\uffff\1\4\1\uffff";
	static final String dfa_3s = "\1\10\1\uffff\1\44\1\10\1\uffff\1\44\1\uffff";
	static final String dfa_4s = "\1\143\1\uffff\1\51\1\32\1\uffff\1\51\1\uffff";
	static final String dfa_5s = "\1\uffff\1\1\2\uffff\1\2\1\uffff\1\3";
	static final String dfa_6s = "\7\uffff}>";
	static final String[] dfa_7s = {
			"\1\2\132\uffff\1\1",
			"",
			"\1\3\4\uffff\1\4",
			"\1\5\21\uffff\1\6",
			"",
			"\1\3\4\uffff\1\4",
			""
	};

	static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
	static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
	static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
	static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
	static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
	static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
	static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

	protected class DFA54 extends DFA {

		public DFA54(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 54;
			this.eot = dfa_1;
			this.eof = dfa_2;
			this.min = dfa_3;
			this.max = dfa_4;
			this.accept = dfa_5;
			this.special = dfa_6;
			this.transition = dfa_7;
		}
		@Override
		public String getDescription() {
			return "3232:3: ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) )";
		}
	}

	static final String dfa_8s = "\111\uffff";
	static final String dfa_9s = "\1\2\110\uffff";
	static final String dfa_10s = "\1\5\1\0\107\uffff";
	static final String dfa_11s = "\1\160\1\0\107\uffff";
	static final String dfa_12s = "\2\uffff\1\2\105\uffff\1\1";
	static final String dfa_13s = "\1\uffff\1\0\107\uffff}>";
	static final String[] dfa_14s = {
			"\5\2\2\uffff\1\2\1\uffff\2\2\1\uffff\6\2\2\uffff\12\2\1\uffff\1\2\1\uffff\6\2\2\uffff\4\2\31\uffff\1\1\5\2\2\uffff\10\2\1\uffff\25\2",
			"\1\uffff",
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
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
	static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
	static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
	static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
	static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
	static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
	static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

	protected class DFA74 extends DFA {

		public DFA74(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 74;
			this.eot = dfa_8;
			this.eof = dfa_9;
			this.min = dfa_10;
			this.max = dfa_11;
			this.accept = dfa_12;
			this.special = dfa_13;
			this.transition = dfa_14;
		}
		@Override
		public String getDescription() {
			return "<invalid or missing tree structure>";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA74_1 = input.LA(1);
						 
						int index74_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred17_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index74_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 74, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String dfa_15s = "\1\1\110\uffff";
	static final String dfa_16s = "\1\5\1\uffff\1\0\106\uffff";
	static final String dfa_17s = "\1\160\1\uffff\1\0\106\uffff";
	static final String dfa_18s = "\1\uffff\1\2\106\uffff\1\1";
	static final String dfa_19s = "\2\uffff\1\0\106\uffff}>";
	static final String[] dfa_20s = {
			"\5\1\2\uffff\1\1\1\uffff\2\1\1\uffff\6\1\2\uffff\12\1\1\uffff\1\1\1\uffff\6\1\2\uffff\4\1\31\uffff\1\2\5\1\2\uffff\10\1\1\uffff\25\1",
			"",
			"\1\uffff",
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
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};
	static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
	static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
	static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
	static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
	static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
	static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

	protected class DFA73 extends DFA {

		public DFA73(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 73;
			this.eot = dfa_8;
			this.eof = dfa_15;
			this.min = dfa_16;
			this.max = dfa_17;
			this.accept = dfa_18;
			this.special = dfa_19;
			this.transition = dfa_20;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 4676:5: ( ( ( '[' )=>otherlv_5= '[' ) ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA73_2 = input.LA(1);
						 
						int index73_2 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred18_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index73_2);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 73, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String[] dfa_21s = {
			"\5\2\2\uffff\1\2\1\uffff\2\2\1\uffff\5\2\1\1\2\uffff\12\2\1\uffff\1\2\1\uffff\6\2\2\uffff\4\2\31\uffff\6\2\2\uffff\10\2\1\uffff\25\2",
			"\1\uffff",
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
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};
	static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

	protected class DFA77 extends DFA {

		public DFA77(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 77;
			this.eot = dfa_8;
			this.eof = dfa_9;
			this.min = dfa_10;
			this.max = dfa_11;
			this.accept = dfa_12;
			this.special = dfa_13;
			this.transition = dfa_21;
		}
		@Override
		public String getDescription() {
			return "4752:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA77_1 = input.LA(1);
						 
						int index77_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred19_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index77_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 77, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String[] dfa_22s = {
			"\5\2\2\uffff\1\2\1\uffff\2\2\1\uffff\6\2\2\uffff\12\2\1\uffff\1\2\1\uffff\4\2\1\1\1\2\2\uffff\4\2\31\uffff\6\2\2\uffff\10\2\1\uffff\25\2",
			"\1\uffff",
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
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};
	static final short[][] dfa_22 = unpackEncodedStringArray(dfa_22s);

	protected class DFA80 extends DFA {

		public DFA80(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 80;
			this.eot = dfa_8;
			this.eof = dfa_9;
			this.min = dfa_10;
			this.max = dfa_11;
			this.accept = dfa_12;
			this.special = dfa_13;
			this.transition = dfa_22;
		}
		@Override
		public String getDescription() {
			return "4868:3: ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA80_1 = input.LA(1);
						 
						int index80_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred20_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index80_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 80, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA83 extends DFA {

		public DFA83(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 83;
			this.eot = dfa_8;
			this.eof = dfa_9;
			this.min = dfa_10;
			this.max = dfa_11;
			this.accept = dfa_12;
			this.special = dfa_13;
			this.transition = dfa_21;
		}
		@Override
		public String getDescription() {
			return "4938:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA83_1 = input.LA(1);
						 
						int index83_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred21_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index83_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 83, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String dfa_23s = "\1\5\2\uffff\1\0\105\uffff";
	static final String dfa_24s = "\1\160\2\uffff\1\0\105\uffff";
	static final String dfa_25s = "\3\uffff\1\0\105\uffff}>";
	static final String[] dfa_26s = {
			"\5\1\2\uffff\1\1\1\uffff\2\1\1\uffff\6\1\2\uffff\12\1\1\uffff\1\1\1\uffff\6\1\2\uffff\4\1\31\uffff\1\3\5\1\2\uffff\10\1\1\uffff\25\1",
			"",
			"",
			"\1\uffff",
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
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};
	static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
	static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
	static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
	static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

	protected class DFA86 extends DFA {

		public DFA86(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 86;
			this.eot = dfa_8;
			this.eof = dfa_15;
			this.min = dfa_23;
			this.max = dfa_24;
			this.accept = dfa_18;
			this.special = dfa_25;
			this.transition = dfa_26;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 5116:3: ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA86_3 = input.LA(1);
						 
						int index86_3 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred23_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index86_3);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 86, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String[] dfa_27s = {
			"\5\2\2\uffff\1\2\1\uffff\2\2\1\uffff\6\2\2\uffff\12\2\1\uffff\1\2\1\uffff\6\2\2\uffff\4\2\31\uffff\6\2\2\uffff\10\2\1\uffff\17\2\1\1\5\2",
			"\1\uffff",
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
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};
	static final short[][] dfa_27 = unpackEncodedStringArray(dfa_27s);

	protected class DFA87 extends DFA {

		public DFA87(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 87;
			this.eot = dfa_8;
			this.eof = dfa_9;
			this.min = dfa_10;
			this.max = dfa_11;
			this.accept = dfa_12;
			this.special = dfa_13;
			this.transition = dfa_27;
		}
		@Override
		public String getDescription() {
			return "5164:3: ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA87_1 = input.LA(1);
						 
						int index87_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred24_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index87_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 87, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String dfa_28s = "\1\5\35\uffff\1\0\52\uffff";
	static final String dfa_29s = "\1\160\35\uffff\1\0\52\uffff";
	static final String dfa_30s = "\36\uffff\1\0\52\uffff}>";
	static final String[] dfa_31s = {
			"\5\1\2\uffff\1\1\1\uffff\2\1\1\uffff\6\1\2\uffff\12\1\1\uffff\1\1\1\uffff\6\1\2\uffff\4\1\31\uffff\1\36\5\1\2\uffff\10\1\1\uffff\25\1",
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
			"\1\uffff",
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
			""
	};
	static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
	static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
	static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
	static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

	protected class DFA89 extends DFA {

		public DFA89(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 89;
			this.eot = dfa_8;
			this.eof = dfa_15;
			this.min = dfa_28;
			this.max = dfa_29;
			this.accept = dfa_18;
			this.special = dfa_30;
			this.transition = dfa_31;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 5505:7: ( ( ( '[' )=>otherlv_10= '[' ) ( (lv_indexes_11_0= ruleXExpression ) ) otherlv_12= ']' )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA89_30 = input.LA(1);
						 
						int index89_30 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred30_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index89_30);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 89, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA95 extends DFA {

		public DFA95(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 95;
			this.eot = dfa_8;
			this.eof = dfa_9;
			this.min = dfa_10;
			this.max = dfa_11;
			this.accept = dfa_12;
			this.special = dfa_13;
			this.transition = dfa_21;
		}
		@Override
		public String getDescription() {
			return "5730:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA95_1 = input.LA(1);
						 
						int index95_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred34_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index95_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 95, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String dfa_32s = "\112\uffff";
	static final String dfa_33s = "\1\2\111\uffff";
	static final String dfa_34s = "\1\5\1\0\110\uffff";
	static final String dfa_35s = "\1\160\1\0\110\uffff";
	static final String dfa_36s = "\2\uffff\1\2\106\uffff\1\1";
	static final String dfa_37s = "\1\uffff\1\0\110\uffff}>";
	static final String[] dfa_38s = {
			"\5\2\2\uffff\1\2\1\uffff\2\2\1\uffff\6\2\2\uffff\12\2\1\uffff\6\2\1\1\1\2\2\uffff\4\2\31\uffff\6\2\2\uffff\10\2\1\uffff\25\2",
			"\1\uffff",
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
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
	static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
	static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
	static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
	static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
	static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
	static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

	protected class DFA168 extends DFA {

		public DFA168(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 168;
			this.eot = dfa_32;
			this.eof = dfa_33;
			this.min = dfa_34;
			this.max = dfa_35;
			this.accept = dfa_36;
			this.special = dfa_37;
			this.transition = dfa_38;
		}
		@Override
		public String getDescription() {
			return "10183:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA168_1 = input.LA(1);
						 
						int index168_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred63_InternalDsl()) ) {s = 73;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index168_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 168, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA166 extends DFA {

		public DFA166(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 166;
			this.eot = dfa_32;
			this.eof = dfa_33;
			this.min = dfa_34;
			this.max = dfa_35;
			this.accept = dfa_36;
			this.special = dfa_37;
			this.transition = dfa_38;
		}
		@Override
		public String getDescription() {
			return "10277:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA166_1 = input.LA(1);
						 
						int index166_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred65_InternalDsl()) ) {s = 73;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index166_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 166, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x4500000000000002L,0x0000000000000010L});
	public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001100L});
	public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000001C003C0L,0x0000010002000000L});
	public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0808020000001100L,0x0000080000000424L});
	public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000200000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000300L});
	public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000100400300L});
	public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000100000300L});
	public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000024114020000L});
	public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000024116020000L});
	public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001000400002L,0x0000000000000800L});
	public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000102000300L});
	public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000082000000L});
	public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000100L});
	public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000100000300L,0x0000000000001000L});
	public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00000203304053E2L,0x00010FFF77A88000L});
	public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
	public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000006L});
	public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00000203304053E0L,0x00010FFF77A88000L});
	public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00C0000000000000L});
	public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
	public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000080000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
	public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000080000001000L});
	public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000C003C0L,0x0000010002000000L});
	public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x00000000004003C0L,0x0000010002000000L});
	public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0001B40000000002L});
	public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000100002L,0x0000100000000000L});
	public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000003C003C0L,0x0000010002000000L});
	public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000100L,0x0000000800000000L});
	public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000004000100L});
	public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
	public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000002000000100L});
	public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x00000203304053E0L,0x00018FFF77A88000L});
	public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000200080000002L});
	public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x00000003304053E0L,0x0001091B43800000L});
	public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0002848448240002L,0x0000200000004000L});
	public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0001800000000000L});
	public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x00000003324053E0L,0x0001091B43800000L});
	public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000040000400002L});
	public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0002800000000100L});
	public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000800080000000L});
	public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0002000000000100L});
	public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x00000003304053E0L,0x0001091B43801000L});
	public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000800L});
	public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x00000000004013E0L,0x0000091B43800000L});
	public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000220000002L,0x0000000000000800L});
	public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000001000000002L,0x0000000000000800L});
	public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000001000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000100L,0x0000000841800000L});
	public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000100L,0x0000001841800000L});
	public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000100L,0x0000000004000000L});
	public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x00000203304053E0L,0x0001091B47800000L});
	public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000020080000000L});
	public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x00000003304053E0L,0x0001091B47800000L});
	public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x00000203304053E0L,0x0001091B43800000L});
	public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
	public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0000800000110000L});
	public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000002000100L,0x0000000004000000L});
	public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000002L,0x0000000008020000L});
	public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x0000000008020000L});
	public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x00000003304053E0L,0x0001891B43800000L});
	public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000080000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
	public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x00040003304053E0L,0x0001891B43800000L});
	public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x00040003304053E0L,0x0001091B43800000L});
	public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x00040003324053E0L,0x0001091B43800000L});
	public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000002L,0x0000400000000000L});
	public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000400000008002L});
	public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0001840000000002L,0x0000000080000000L});
	public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000880000000002L});
	public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000110000002L});
	public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000004004020002L});
	public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x00000203304053E2L,0x0001091B47800000L});
	public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x00000003304053E2L,0x0001091B47800000L});
	public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x00000003304053E2L,0x0001091B43800000L});
	public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000000240L});
	public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000041000000002L});
	public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000000000002L,0x0000001000800000L});
	public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000004000000L});
}
