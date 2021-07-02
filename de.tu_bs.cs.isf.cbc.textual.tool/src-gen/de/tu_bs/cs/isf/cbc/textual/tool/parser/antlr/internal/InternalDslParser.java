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
		"'='", "'=='", "'>'", "'>='", "'?'", "'@'", "'@ensures'", "'@requires'", 
		"'Block'", "'Conditions'", "'Do'", "'Elseif'", "'Fi'", "'Formula'", "'Function'", 
		"'GlobalConditions'", "'If'", "'Intm:'", "'Inv:'", "'JavaVariables'", 
		"'NewName'", "'Od'", "'Post:'", "'Pre:'", "'Renames'", "'Renaming'", "'Return'", 
		"'Then'", "'Type'", "'Var:'", "'Variables'", "'While'", "'['", "']'", 
		"'^'", "'^='", "'break'", "'case'", "'catch'", "'class'", "'continue'", 
		"'default'", "'do'", "'else'", "'extends'", "'extension'", "'false'", 
		"'final'", "'finally'", "'for'", "'if'", "'import'", "'instanceof'", "'new'", 
		"'null'", "'return'", "'static'", "'super'", "'switch'", "'synchronized'", 
		"'throw'", "'true'", "'try'", "'while'", "'{'", "'|'", "'|='", "'||'", 
		"'}'", "'~'"
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
	public static final int T__113=113;
	public static final int T__114=114;
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
	// InternalDsl.g:71:1: ruleCbCProblem returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) ) ) ;
	public final EObject ruleCbCProblem() throws RecognitionException {
		EObject current = null;


		EObject lv_cbcformula_1_0 =null;
		EObject lv_globalcondition_2_0 =null;
		EObject lv_javaVariable_3_0 =null;
		EObject lv_renaming_4_0 =null;


			enterRule();

		try {
			// InternalDsl.g:77:2: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) ) ) )
			// InternalDsl.g:78:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) ) )
			{
			// InternalDsl.g:78:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) ) )
			// InternalDsl.g:79:3: ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) )
			{
			// InternalDsl.g:79:3: ( ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?) )
			// InternalDsl.g:80:4: ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?)
			{
			getUnorderedGroupHelper().enter(grammarAccess.getCbCProblemAccess().getUnorderedGroup());
			// InternalDsl.g:83:4: ( ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?)
			// InternalDsl.g:84:5: ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+ {...}?
			{
			// InternalDsl.g:84:5: ( ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) ) )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=5;
				int LA1_0 = input.LA(1);
				if ( LA1_0 == 58 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 0) ) {
					alt1=1;
				}
				else if ( LA1_0 == 60 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 1) ) {
					alt1=2;
				}
				else if ( LA1_0 == 64 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 2) ) {
					alt1=3;
				}
				else if ( LA1_0 == 70 && getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 3) ) {
					alt1=4;
				}

				switch (alt1) {
				case 1 :
					// InternalDsl.g:85:3: ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) )
					{
					// InternalDsl.g:85:3: ({...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) ) )
					// InternalDsl.g:86:4: {...}? => ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 0) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleCbCProblem", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 0)");
					}
					// InternalDsl.g:86:104: ( ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) ) )
					// InternalDsl.g:87:5: ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) )
					{
					getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 0);
					// InternalDsl.g:90:8: ({...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) ) )
					// InternalDsl.g:90:9: {...}? => ( (lv_cbcformula_1_0= ruleCbCFormula ) )
					{
					if ( !((true)) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleCbCProblem", "true");
					}
					// InternalDsl.g:90:18: ( (lv_cbcformula_1_0= ruleCbCFormula ) )
					// InternalDsl.g:90:19: (lv_cbcformula_1_0= ruleCbCFormula )
					{
					// InternalDsl.g:90:19: (lv_cbcformula_1_0= ruleCbCFormula )
					// InternalDsl.g:91:9: lv_cbcformula_1_0= ruleCbCFormula
					{
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getCbCProblemAccess().getCbcformulaCbCFormulaParserRuleCall_0_0());
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

					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCbCProblemAccess().getUnorderedGroup());
					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:113:3: ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) )
					{
					// InternalDsl.g:113:3: ({...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) ) )
					// InternalDsl.g:114:4: {...}? => ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 1) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleCbCProblem", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 1)");
					}
					// InternalDsl.g:114:104: ( ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) ) )
					// InternalDsl.g:115:5: ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) )
					{
					getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 1);
					// InternalDsl.g:118:8: ({...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) ) )
					// InternalDsl.g:118:9: {...}? => ( (lv_globalcondition_2_0= ruleGlobalConditions ) )
					{
					if ( !((true)) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleCbCProblem", "true");
					}
					// InternalDsl.g:118:18: ( (lv_globalcondition_2_0= ruleGlobalConditions ) )
					// InternalDsl.g:118:19: (lv_globalcondition_2_0= ruleGlobalConditions )
					{
					// InternalDsl.g:118:19: (lv_globalcondition_2_0= ruleGlobalConditions )
					// InternalDsl.g:119:9: lv_globalcondition_2_0= ruleGlobalConditions
					{
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getCbCProblemAccess().getGlobalconditionGlobalConditionsParserRuleCall_1_0());
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

					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCbCProblemAccess().getUnorderedGroup());
					}

					}

					}
					break;
				case 3 :
					// InternalDsl.g:141:3: ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) )
					{
					// InternalDsl.g:141:3: ({...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) ) )
					// InternalDsl.g:142:4: {...}? => ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 2) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleCbCProblem", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 2)");
					}
					// InternalDsl.g:142:104: ( ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) ) )
					// InternalDsl.g:143:5: ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) )
					{
					getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 2);
					// InternalDsl.g:146:8: ({...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) ) )
					// InternalDsl.g:146:9: {...}? => ( (lv_javaVariable_3_0= ruleJavaVariables ) )
					{
					if ( !((true)) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleCbCProblem", "true");
					}
					// InternalDsl.g:146:18: ( (lv_javaVariable_3_0= ruleJavaVariables ) )
					// InternalDsl.g:146:19: (lv_javaVariable_3_0= ruleJavaVariables )
					{
					// InternalDsl.g:146:19: (lv_javaVariable_3_0= ruleJavaVariables )
					// InternalDsl.g:147:9: lv_javaVariable_3_0= ruleJavaVariables
					{
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getCbCProblemAccess().getJavaVariableJavaVariablesParserRuleCall_2_0());
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

					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCbCProblemAccess().getUnorderedGroup());
					}

					}

					}
					break;
				case 4 :
					// InternalDsl.g:169:3: ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) )
					{
					// InternalDsl.g:169:3: ({...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) ) )
					// InternalDsl.g:170:4: {...}? => ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 3) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleCbCProblem", "getUnorderedGroupHelper().canSelect(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 3)");
					}
					// InternalDsl.g:170:104: ( ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) ) )
					// InternalDsl.g:171:5: ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) )
					{
					getUnorderedGroupHelper().select(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), 3);
					// InternalDsl.g:174:8: ({...}? => ( (lv_renaming_4_0= ruleRenaming ) ) )
					// InternalDsl.g:174:9: {...}? => ( (lv_renaming_4_0= ruleRenaming ) )
					{
					if ( !((true)) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleCbCProblem", "true");
					}
					// InternalDsl.g:174:18: ( (lv_renaming_4_0= ruleRenaming ) )
					// InternalDsl.g:174:19: (lv_renaming_4_0= ruleRenaming )
					{
					// InternalDsl.g:174:19: (lv_renaming_4_0= ruleRenaming )
					// InternalDsl.g:175:9: lv_renaming_4_0= ruleRenaming
					{
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getCbCProblemAccess().getRenamingRenamingParserRuleCall_3_0());
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

					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCbCProblemAccess().getUnorderedGroup());
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

			if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getCbCProblemAccess().getUnorderedGroup()) ) {
				if (state.backtracking>0) {state.failed=true; return current;}
				throw new FailedPredicateException(input, "ruleCbCProblem", "getUnorderedGroupHelper().canLeave(grammarAccess.getCbCProblemAccess().getUnorderedGroup())");
			}
			}

			}

			getUnorderedGroupHelper().leave(grammarAccess.getCbCProblemAccess().getUnorderedGroup());
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
	// InternalDsl.g:208:1: entryRuleCbCFormula returns [EObject current=null] :iv_ruleCbCFormula= ruleCbCFormula EOF ;
	public final EObject entryRuleCbCFormula() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleCbCFormula =null;

		try {
			// InternalDsl.g:208:51: (iv_ruleCbCFormula= ruleCbCFormula EOF )
			// InternalDsl.g:209:2: iv_ruleCbCFormula= ruleCbCFormula EOF
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
	// InternalDsl.g:215:1: ruleCbCFormula returns [EObject current=null] : (otherlv_0= 'Formula' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'Pre:' otherlv_3= '(' ( (lv_preCondition_4_0= ruleCondition ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_statement_7_0= ruleAbstractStatement ) ) otherlv_8= '}' otherlv_9= 'Post:' otherlv_10= '(' ( (lv_postCondition_11_0= ruleCondition ) ) otherlv_12= ')' ) ;
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
			// InternalDsl.g:221:2: ( (otherlv_0= 'Formula' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'Pre:' otherlv_3= '(' ( (lv_preCondition_4_0= ruleCondition ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_statement_7_0= ruleAbstractStatement ) ) otherlv_8= '}' otherlv_9= 'Post:' otherlv_10= '(' ( (lv_postCondition_11_0= ruleCondition ) ) otherlv_12= ')' ) )
			// InternalDsl.g:222:2: (otherlv_0= 'Formula' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'Pre:' otherlv_3= '(' ( (lv_preCondition_4_0= ruleCondition ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_statement_7_0= ruleAbstractStatement ) ) otherlv_8= '}' otherlv_9= 'Post:' otherlv_10= '(' ( (lv_postCondition_11_0= ruleCondition ) ) otherlv_12= ')' )
			{
			// InternalDsl.g:222:2: (otherlv_0= 'Formula' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'Pre:' otherlv_3= '(' ( (lv_preCondition_4_0= ruleCondition ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_statement_7_0= ruleAbstractStatement ) ) otherlv_8= '}' otherlv_9= 'Post:' otherlv_10= '(' ( (lv_postCondition_11_0= ruleCondition ) ) otherlv_12= ')' )
			// InternalDsl.g:223:3: otherlv_0= 'Formula' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'Pre:' otherlv_3= '(' ( (lv_preCondition_4_0= ruleCondition ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_statement_7_0= ruleAbstractStatement ) ) otherlv_8= '}' otherlv_9= 'Post:' otherlv_10= '(' ( (lv_postCondition_11_0= ruleCondition ) ) otherlv_12= ')'
			{
			otherlv_0=(Token)match(input,58,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getCbCFormulaAccess().getFormulaKeyword_0());
					}
			// InternalDsl.g:227:3: ( (lv_name_1_0= ruleEString ) )
			// InternalDsl.g:228:4: (lv_name_1_0= ruleEString )
			{
			// InternalDsl.g:228:4: (lv_name_1_0= ruleEString )
			// InternalDsl.g:229:5: lv_name_1_0= ruleEString
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

			otherlv_2=(Token)match(input,68,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getCbCFormulaAccess().getPreKeyword_2());
					}
			otherlv_3=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getCbCFormulaAccess().getLeftParenthesisKeyword_3());
					}
			// InternalDsl.g:254:3: ( (lv_preCondition_4_0= ruleCondition ) )
			// InternalDsl.g:255:4: (lv_preCondition_4_0= ruleCondition )
			{
			// InternalDsl.g:255:4: (lv_preCondition_4_0= ruleCondition )
			// InternalDsl.g:256:5: lv_preCondition_4_0= ruleCondition
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
			otherlv_6=(Token)match(input,109,FOLLOW_10); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getCbCFormulaAccess().getLeftCurlyBracketKeyword_6());
					}
			// InternalDsl.g:281:3: ( (lv_statement_7_0= ruleAbstractStatement ) )
			// InternalDsl.g:282:4: (lv_statement_7_0= ruleAbstractStatement )
			{
			// InternalDsl.g:282:4: (lv_statement_7_0= ruleAbstractStatement )
			// InternalDsl.g:283:5: lv_statement_7_0= ruleAbstractStatement
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

			otherlv_8=(Token)match(input,113,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getCbCFormulaAccess().getRightCurlyBracketKeyword_8());
					}
			otherlv_9=(Token)match(input,67,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_9, grammarAccess.getCbCFormulaAccess().getPostKeyword_9());
					}
			otherlv_10=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_10, grammarAccess.getCbCFormulaAccess().getLeftParenthesisKeyword_10());
					}
			// InternalDsl.g:312:3: ( (lv_postCondition_11_0= ruleCondition ) )
			// InternalDsl.g:313:4: (lv_postCondition_11_0= ruleCondition )
			{
			// InternalDsl.g:313:4: (lv_postCondition_11_0= ruleCondition )
			// InternalDsl.g:314:5: lv_postCondition_11_0= ruleCondition
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
	// InternalDsl.g:339:1: entryRuleAbstractStatement returns [EObject current=null] :iv_ruleAbstractStatement= ruleAbstractStatement EOF ;
	public final EObject entryRuleAbstractStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleAbstractStatement =null;

		try {
			// InternalDsl.g:339:58: (iv_ruleAbstractStatement= ruleAbstractStatement EOF )
			// InternalDsl.g:340:2: iv_ruleAbstractStatement= ruleAbstractStatement EOF
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
	// InternalDsl.g:346:1: ruleAbstractStatement returns [EObject current=null] : (this_AbstractStatement_Impl_0= ruleAbstractStatement_Impl |this_InlineBlockStatement_1= ruleInlineBlockStatement |this_CompositionStatement_2= ruleCompositionStatement |this_SkipStatement_3= ruleSkipStatement |this_SelectionStatement_4= ruleSelectionStatement |this_SmallRepetitionStatement_5= ruleSmallRepetitionStatement |this_MethodStatement_6= ruleMethodStatement |this_ReturnStatement_7= ruleReturnStatement |this_StrengthWeakStatement_8= ruleStrengthWeakStatement ) ;
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
			// InternalDsl.g:352:2: ( (this_AbstractStatement_Impl_0= ruleAbstractStatement_Impl |this_InlineBlockStatement_1= ruleInlineBlockStatement |this_CompositionStatement_2= ruleCompositionStatement |this_SkipStatement_3= ruleSkipStatement |this_SelectionStatement_4= ruleSelectionStatement |this_SmallRepetitionStatement_5= ruleSmallRepetitionStatement |this_MethodStatement_6= ruleMethodStatement |this_ReturnStatement_7= ruleReturnStatement |this_StrengthWeakStatement_8= ruleStrengthWeakStatement ) )
			// InternalDsl.g:353:2: (this_AbstractStatement_Impl_0= ruleAbstractStatement_Impl |this_InlineBlockStatement_1= ruleInlineBlockStatement |this_CompositionStatement_2= ruleCompositionStatement |this_SkipStatement_3= ruleSkipStatement |this_SelectionStatement_4= ruleSelectionStatement |this_SmallRepetitionStatement_5= ruleSmallRepetitionStatement |this_MethodStatement_6= ruleMethodStatement |this_ReturnStatement_7= ruleReturnStatement |this_StrengthWeakStatement_8= ruleStrengthWeakStatement )
			{
			// InternalDsl.g:353:2: (this_AbstractStatement_Impl_0= ruleAbstractStatement_Impl |this_InlineBlockStatement_1= ruleInlineBlockStatement |this_CompositionStatement_2= ruleCompositionStatement |this_SkipStatement_3= ruleSkipStatement |this_SelectionStatement_4= ruleSelectionStatement |this_SmallRepetitionStatement_5= ruleSmallRepetitionStatement |this_MethodStatement_6= ruleMethodStatement |this_ReturnStatement_7= ruleReturnStatement |this_StrengthWeakStatement_8= ruleStrengthWeakStatement )
			int alt2=9;
			switch ( input.LA(1) ) {
			case RULE_ID:
				{
				int LA2_1 = input.LA(2);
				if ( (LA2_1==45||LA2_1==77) ) {
					alt2=1;
				}
				else if ( (LA2_1==EOF||LA2_1==113) ) {
					alt2=7;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
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
			case 53:
				{
				alt2=2;
				}
				break;
			case 109:
				{
				alt2=3;
				}
				break;
			case 41:
				{
				alt2=4;
				}
				break;
			case 61:
				{
				alt2=5;
				}
				break;
			case 76:
				{
				alt2=6;
				}
				break;
			case RULE_STRING:
				{
				alt2=7;
				}
				break;
			case 71:
				{
				alt2=8;
				}
				break;
			case 68:
				{
				alt2=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// InternalDsl.g:354:3: this_AbstractStatement_Impl_0= ruleAbstractStatement_Impl
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
					// InternalDsl.g:363:3: this_InlineBlockStatement_1= ruleInlineBlockStatement
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
					// InternalDsl.g:372:3: this_CompositionStatement_2= ruleCompositionStatement
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
					// InternalDsl.g:381:3: this_SkipStatement_3= ruleSkipStatement
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
					// InternalDsl.g:390:3: this_SelectionStatement_4= ruleSelectionStatement
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
					// InternalDsl.g:399:3: this_SmallRepetitionStatement_5= ruleSmallRepetitionStatement
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
					// InternalDsl.g:408:3: this_MethodStatement_6= ruleMethodStatement
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
					// InternalDsl.g:417:3: this_ReturnStatement_7= ruleReturnStatement
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
					// InternalDsl.g:426:3: this_StrengthWeakStatement_8= ruleStrengthWeakStatement
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
	// InternalDsl.g:438:1: entryRuleEString returns [String current=null] :iv_ruleEString= ruleEString EOF ;
	public final String entryRuleEString() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleEString =null;

		try {
			// InternalDsl.g:438:47: (iv_ruleEString= ruleEString EOF )
			// InternalDsl.g:439:2: iv_ruleEString= ruleEString EOF
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
	// InternalDsl.g:445:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID ) ;
	public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_STRING_0=null;
		Token this_ID_1=null;


			enterRule();

		try {
			// InternalDsl.g:451:2: ( (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID ) )
			// InternalDsl.g:452:2: (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID )
			{
			// InternalDsl.g:452:2: (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==RULE_STRING) ) {
				alt3=1;
			}
			else if ( (LA3_0==RULE_ID) ) {
				alt3=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// InternalDsl.g:453:3: this_STRING_0= RULE_STRING
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
					// InternalDsl.g:461:3: this_ID_1= RULE_ID
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
	// InternalDsl.g:472:1: entryRuleCodeString returns [String current=null] :iv_ruleCodeString= ruleCodeString EOF ;
	public final String entryRuleCodeString() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleCodeString =null;

		try {
			// InternalDsl.g:472:50: (iv_ruleCodeString= ruleCodeString EOF )
			// InternalDsl.g:473:2: iv_ruleCodeString= ruleCodeString EOF
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
	// InternalDsl.g:479:1: ruleCodeString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )? kw= '=' (kw= '(' )? (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )* kw= ';' )+ ;
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
			// InternalDsl.g:485:2: ( (this_ID_0= RULE_ID (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )? kw= '=' (kw= '(' )? (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )* kw= ';' )+ )
			// InternalDsl.g:486:2: (this_ID_0= RULE_ID (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )? kw= '=' (kw= '(' )? (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )* kw= ';' )+
			{
			// InternalDsl.g:486:2: (this_ID_0= RULE_ID (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )? kw= '=' (kw= '(' )? (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )* kw= ';' )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==RULE_ID) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// InternalDsl.g:487:3: this_ID_0= RULE_ID (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )? kw= '=' (kw= '(' )? (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )* kw= ';'
					{
					this_ID_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_ID_0);
							}
					if ( state.backtracking==0 ) {
								newLeafNode(this_ID_0, grammarAccess.getCodeStringAccess().getIDTerminalRuleCall_0());
							}
					// InternalDsl.g:494:3: (kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']' )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==77) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// InternalDsl.g:495:4: kw= '[' (this_ID_2= RULE_ID |this_INT_3= RULE_INT ) kw= ']'
							{
							kw=(Token)match(input,77,FOLLOW_14); if (state.failed) return current;
							if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getCodeStringAccess().getLeftSquareBracketKeyword_1_0());
										}
							// InternalDsl.g:500:4: (this_ID_2= RULE_ID |this_INT_3= RULE_INT )
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==RULE_ID) ) {
								alt4=1;
							}
							else if ( (LA4_0==RULE_INT) ) {
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
									// InternalDsl.g:501:5: this_ID_2= RULE_ID
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
									// InternalDsl.g:509:5: this_INT_3= RULE_INT
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

							kw=(Token)match(input,78,FOLLOW_16); if (state.failed) return current;
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
					// InternalDsl.g:528:3: (kw= '(' )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==22) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// InternalDsl.g:529:4: kw= '('
							{
							kw=(Token)match(input,22,FOLLOW_18); if (state.failed) return current;
							if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getCodeStringAccess().getLeftParenthesisKeyword_3());
										}
							}
							break;

					}

					// InternalDsl.g:535:3: (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) )
					int alt8=2;
					switch ( input.LA(1) ) {
					case 32:
						{
						int LA8_1 = input.LA(2);
						if ( (LA8_1==RULE_ID) ) {
							alt8=1;
						}
						else if ( (LA8_1==RULE_INT) ) {
							alt8=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return current;}
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
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						throw nvae;
					}
					switch (alt8) {
						case 1 :
							// InternalDsl.g:536:4: this_VariableString_7= ruleVariableString
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
							// InternalDsl.g:547:4: ( (kw= '-' )? this_INT_9= RULE_INT )
							{
							// InternalDsl.g:547:4: ( (kw= '-' )? this_INT_9= RULE_INT )
							// InternalDsl.g:548:5: (kw= '-' )? this_INT_9= RULE_INT
							{
							// InternalDsl.g:548:5: (kw= '-' )?
							int alt7=2;
							int LA7_0 = input.LA(1);
							if ( (LA7_0==32) ) {
								alt7=1;
							}
							switch (alt7) {
								case 1 :
									// InternalDsl.g:549:6: kw= '-'
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

					// InternalDsl.g:564:3: (this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )* )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==17||LA13_0==26||LA13_0==28||LA13_0==32||LA13_0==38) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// InternalDsl.g:565:4: this_Operation_10= ruleOperation (kw= '(' )* (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) ) (kw= ')' )*
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
							// InternalDsl.g:575:4: (kw= '(' )*
							loop9:
							while (true) {
								int alt9=2;
								int LA9_0 = input.LA(1);
								if ( (LA9_0==22) ) {
									alt9=1;
								}

								switch (alt9) {
								case 1 :
									// InternalDsl.g:576:5: kw= '('
									{
									kw=(Token)match(input,22,FOLLOW_17); if (state.failed) return current;
									if ( state.backtracking==0 ) {
														current.merge(kw);
														newLeafNode(kw, grammarAccess.getCodeStringAccess().getLeftParenthesisKeyword_5_1());
													}
									}
									break;

								default :
									break loop9;
								}
							}

							// InternalDsl.g:582:4: (this_VariableString_12= ruleVariableString | ( (kw= '-' )? this_INT_14= RULE_INT ) )
							int alt11=2;
							switch ( input.LA(1) ) {
							case 32:
								{
								int LA11_1 = input.LA(2);
								if ( (LA11_1==RULE_ID) ) {
									alt11=1;
								}
								else if ( (LA11_1==RULE_INT) ) {
									alt11=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return current;}
									int nvaeMark = input.mark();
									try {
										input.consume();
										NoViableAltException nvae =
											new NoViableAltException("", 11, 1, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case RULE_ID:
								{
								alt11=1;
								}
								break;
							case RULE_INT:
								{
								alt11=2;
								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return current;}
								NoViableAltException nvae =
									new NoViableAltException("", 11, 0, input);
								throw nvae;
							}
							switch (alt11) {
								case 1 :
									// InternalDsl.g:583:5: this_VariableString_12= ruleVariableString
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
									// InternalDsl.g:594:5: ( (kw= '-' )? this_INT_14= RULE_INT )
									{
									// InternalDsl.g:594:5: ( (kw= '-' )? this_INT_14= RULE_INT )
									// InternalDsl.g:595:6: (kw= '-' )? this_INT_14= RULE_INT
									{
									// InternalDsl.g:595:6: (kw= '-' )?
									int alt10=2;
									int LA10_0 = input.LA(1);
									if ( (LA10_0==32) ) {
										alt10=1;
									}
									switch (alt10) {
										case 1 :
											// InternalDsl.g:596:7: kw= '-'
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

							// InternalDsl.g:611:4: (kw= ')' )*
							loop12:
							while (true) {
								int alt12=2;
								int LA12_0 = input.LA(1);
								if ( (LA12_0==25) ) {
									alt12=1;
								}

								switch (alt12) {
								case 1 :
									// InternalDsl.g:612:5: kw= ')'
									{
									kw=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
									if ( state.backtracking==0 ) {
														current.merge(kw);
														newLeafNode(kw, grammarAccess.getCodeStringAccess().getRightParenthesisKeyword_5_3());
													}
									}
									break;

								default :
									break loop12;
								}
							}

							}
							break;

						default :
							break loop13;
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
					if ( cnt14 >= 1 ) break loop14;
					if (state.backtracking>0) {state.failed=true; return current;}
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
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
	// InternalDsl.g:628:1: entryRuleVariableString returns [String current=null] :iv_ruleVariableString= ruleVariableString EOF ;
	public final String entryRuleVariableString() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleVariableString =null;

		try {
			// InternalDsl.g:628:54: (iv_ruleVariableString= ruleVariableString EOF )
			// InternalDsl.g:629:2: iv_ruleVariableString= ruleVariableString EOF
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
	// InternalDsl.g:635:1: ruleVariableString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_ID_1= RULE_ID ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )? ) ;
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
			// InternalDsl.g:641:2: ( ( (kw= '-' )? this_ID_1= RULE_ID ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )? ) )
			// InternalDsl.g:642:2: ( (kw= '-' )? this_ID_1= RULE_ID ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )? )
			{
			// InternalDsl.g:642:2: ( (kw= '-' )? this_ID_1= RULE_ID ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )? )
			// InternalDsl.g:643:3: (kw= '-' )? this_ID_1= RULE_ID ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )?
			{
			// InternalDsl.g:643:3: (kw= '-' )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==32) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// InternalDsl.g:644:4: kw= '-'
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
			// InternalDsl.g:657:3: ( ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? ) | ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? ) | (kw= '.' this_VariableString_21= ruleVariableString ) )?
			int alt26=4;
			switch ( input.LA(1) ) {
				case 22:
					{
					alt26=1;
					}
					break;
				case 77:
					{
					alt26=2;
					}
					break;
				case 36:
					{
					alt26=3;
					}
					break;
			}
			switch (alt26) {
				case 1 :
					// InternalDsl.g:658:4: ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? )
					{
					// InternalDsl.g:658:4: ( (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )? )
					// InternalDsl.g:659:5: (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' ) (kw= '.' this_VariableString_12= ruleVariableString )?
					{
					// InternalDsl.g:659:5: (kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')' )
					// InternalDsl.g:660:6: kw= '(' ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )? kw= ')'
					{
					kw=(Token)match(input,22,FOLLOW_25); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getVariableStringAccess().getLeftParenthesisKeyword_2_0_0_0());
										}
					// InternalDsl.g:665:6: ( (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )* )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( ((LA21_0 >= RULE_ID && LA21_0 <= RULE_INT)||LA21_0==32) ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// InternalDsl.g:666:7: (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) ) (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )*
							{
							// InternalDsl.g:666:7: (this_VariableString_3= ruleVariableString | ( (kw= '-' )? this_INT_5= RULE_INT ) )
							int alt17=2;
							switch ( input.LA(1) ) {
							case 32:
								{
								int LA17_1 = input.LA(2);
								if ( (LA17_1==RULE_ID) ) {
									alt17=1;
								}
								else if ( (LA17_1==RULE_INT) ) {
									alt17=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return current;}
									int nvaeMark = input.mark();
									try {
										input.consume();
										NoViableAltException nvae =
											new NoViableAltException("", 17, 1, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case RULE_ID:
								{
								alt17=1;
								}
								break;
							case RULE_INT:
								{
								alt17=2;
								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return current;}
								NoViableAltException nvae =
									new NoViableAltException("", 17, 0, input);
								throw nvae;
							}
							switch (alt17) {
								case 1 :
									// InternalDsl.g:667:8: this_VariableString_3= ruleVariableString
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
									// InternalDsl.g:678:8: ( (kw= '-' )? this_INT_5= RULE_INT )
									{
									// InternalDsl.g:678:8: ( (kw= '-' )? this_INT_5= RULE_INT )
									// InternalDsl.g:679:9: (kw= '-' )? this_INT_5= RULE_INT
									{
									// InternalDsl.g:679:9: (kw= '-' )?
									int alt16=2;
									int LA16_0 = input.LA(1);
									if ( (LA16_0==32) ) {
										alt16=1;
									}
									switch (alt16) {
										case 1 :
											// InternalDsl.g:680:10: kw= '-'
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

							// InternalDsl.g:695:7: (kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) ) )*
							loop20:
							while (true) {
								int alt20=2;
								int LA20_0 = input.LA(1);
								if ( (LA20_0==31) ) {
									alt20=1;
								}

								switch (alt20) {
								case 1 :
									// InternalDsl.g:696:8: kw= ',' (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) )
									{
									kw=(Token)match(input,31,FOLLOW_18); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	current.merge(kw);
																	newLeafNode(kw, grammarAccess.getVariableStringAccess().getCommaKeyword_2_0_0_1_1_0());
																}
									// InternalDsl.g:701:8: (this_VariableString_7= ruleVariableString | ( (kw= '-' )? this_INT_9= RULE_INT ) )
									int alt19=2;
									switch ( input.LA(1) ) {
									case 32:
										{
										int LA19_1 = input.LA(2);
										if ( (LA19_1==RULE_ID) ) {
											alt19=1;
										}
										else if ( (LA19_1==RULE_INT) ) {
											alt19=2;
										}

										else {
											if (state.backtracking>0) {state.failed=true; return current;}
											int nvaeMark = input.mark();
											try {
												input.consume();
												NoViableAltException nvae =
													new NoViableAltException("", 19, 1, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

										}
										break;
									case RULE_ID:
										{
										alt19=1;
										}
										break;
									case RULE_INT:
										{
										alt19=2;
										}
										break;
									default:
										if (state.backtracking>0) {state.failed=true; return current;}
										NoViableAltException nvae =
											new NoViableAltException("", 19, 0, input);
										throw nvae;
									}
									switch (alt19) {
										case 1 :
											// InternalDsl.g:702:9: this_VariableString_7= ruleVariableString
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
											// InternalDsl.g:713:9: ( (kw= '-' )? this_INT_9= RULE_INT )
											{
											// InternalDsl.g:713:9: ( (kw= '-' )? this_INT_9= RULE_INT )
											// InternalDsl.g:714:10: (kw= '-' )? this_INT_9= RULE_INT
											{
											// InternalDsl.g:714:10: (kw= '-' )?
											int alt18=2;
											int LA18_0 = input.LA(1);
											if ( (LA18_0==32) ) {
												alt18=1;
											}
											switch (alt18) {
												case 1 :
													// InternalDsl.g:715:11: kw= '-'
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
									break loop20;
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

					// InternalDsl.g:738:5: (kw= '.' this_VariableString_12= ruleVariableString )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==36) ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// InternalDsl.g:739:6: kw= '.' this_VariableString_12= ruleVariableString
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
					// InternalDsl.g:757:4: ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? )
					{
					// InternalDsl.g:757:4: ( (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )? )
					// InternalDsl.g:758:5: (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' ) (kw= '.' this_VariableString_19= ruleVariableString )?
					{
					// InternalDsl.g:758:5: (kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']' )
					// InternalDsl.g:759:6: kw= '[' (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )? kw= ']'
					{
					kw=(Token)match(input,77,FOLLOW_29); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getVariableStringAccess().getLeftSquareBracketKeyword_2_1_0_0());
										}
					// InternalDsl.g:764:6: (this_VariableString_14= ruleVariableString | ( (kw= '-' )? this_INT_16= RULE_INT ) )?
					int alt24=3;
					switch ( input.LA(1) ) {
						case 32:
							{
							int LA24_1 = input.LA(2);
							if ( (LA24_1==RULE_ID) ) {
								alt24=1;
							}
							else if ( (LA24_1==RULE_INT) ) {
								alt24=2;
							}
							}
							break;
						case RULE_ID:
							{
							alt24=1;
							}
							break;
						case RULE_INT:
							{
							alt24=2;
							}
							break;
					}
					switch (alt24) {
						case 1 :
							// InternalDsl.g:765:7: this_VariableString_14= ruleVariableString
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
							// InternalDsl.g:776:7: ( (kw= '-' )? this_INT_16= RULE_INT )
							{
							// InternalDsl.g:776:7: ( (kw= '-' )? this_INT_16= RULE_INT )
							// InternalDsl.g:777:8: (kw= '-' )? this_INT_16= RULE_INT
							{
							// InternalDsl.g:777:8: (kw= '-' )?
							int alt23=2;
							int LA23_0 = input.LA(1);
							if ( (LA23_0==32) ) {
								alt23=1;
							}
							switch (alt23) {
								case 1 :
									// InternalDsl.g:778:9: kw= '-'
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

					kw=(Token)match(input,78,FOLLOW_27); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											current.merge(kw);
											newLeafNode(kw, grammarAccess.getVariableStringAccess().getRightSquareBracketKeyword_2_1_0_2());
										}
					}

					// InternalDsl.g:799:5: (kw= '.' this_VariableString_19= ruleVariableString )?
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==36) ) {
						alt25=1;
					}
					switch (alt25) {
						case 1 :
							// InternalDsl.g:800:6: kw= '.' this_VariableString_19= ruleVariableString
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
					// InternalDsl.g:818:4: (kw= '.' this_VariableString_21= ruleVariableString )
					{
					// InternalDsl.g:818:4: (kw= '.' this_VariableString_21= ruleVariableString )
					// InternalDsl.g:819:5: kw= '.' this_VariableString_21= ruleVariableString
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
	// InternalDsl.g:840:1: entryRuleOperation returns [String current=null] :iv_ruleOperation= ruleOperation EOF ;
	public final String entryRuleOperation() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOperation =null;

		try {
			// InternalDsl.g:840:49: (iv_ruleOperation= ruleOperation EOF )
			// InternalDsl.g:841:2: iv_ruleOperation= ruleOperation EOF
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
	// InternalDsl.g:847:1: ruleOperation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' |kw= '-' |kw= '*' |kw= '/' |kw= '%' ) ;
	public final AntlrDatatypeRuleToken ruleOperation() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:853:2: ( (kw= '+' |kw= '-' |kw= '*' |kw= '/' |kw= '%' ) )
			// InternalDsl.g:854:2: (kw= '+' |kw= '-' |kw= '*' |kw= '/' |kw= '%' )
			{
			// InternalDsl.g:854:2: (kw= '+' |kw= '-' |kw= '*' |kw= '/' |kw= '%' )
			int alt27=5;
			switch ( input.LA(1) ) {
			case 28:
				{
				alt27=1;
				}
				break;
			case 32:
				{
				alt27=2;
				}
				break;
			case 26:
				{
				alt27=3;
				}
				break;
			case 38:
				{
				alt27=4;
				}
				break;
			case 17:
				{
				alt27=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}
			switch (alt27) {
				case 1 :
					// InternalDsl.g:855:3: kw= '+'
					{
					kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOperationAccess().getPlusSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:861:3: kw= '-'
					{
					kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOperationAccess().getHyphenMinusKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalDsl.g:867:3: kw= '*'
					{
					kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOperationAccess().getAsteriskKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalDsl.g:873:3: kw= '/'
					{
					kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOperationAccess().getSolidusKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalDsl.g:879:3: kw= '%'
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
	// InternalDsl.g:888:1: entryRuleAbstractStatement_Impl returns [EObject current=null] :iv_ruleAbstractStatement_Impl= ruleAbstractStatement_Impl EOF ;
	public final EObject entryRuleAbstractStatement_Impl() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleAbstractStatement_Impl =null;

		try {
			// InternalDsl.g:888:63: (iv_ruleAbstractStatement_Impl= ruleAbstractStatement_Impl EOF )
			// InternalDsl.g:889:2: iv_ruleAbstractStatement_Impl= ruleAbstractStatement_Impl EOF
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
	// InternalDsl.g:895:1: ruleAbstractStatement_Impl returns [EObject current=null] : ( () ( (lv_name_1_0= ruleCodeString ) ) ) ;
	public final EObject ruleAbstractStatement_Impl() throws RecognitionException {
		EObject current = null;


		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:901:2: ( ( () ( (lv_name_1_0= ruleCodeString ) ) ) )
			// InternalDsl.g:902:2: ( () ( (lv_name_1_0= ruleCodeString ) ) )
			{
			// InternalDsl.g:902:2: ( () ( (lv_name_1_0= ruleCodeString ) ) )
			// InternalDsl.g:903:3: () ( (lv_name_1_0= ruleCodeString ) )
			{
			// InternalDsl.g:903:3: ()
			// InternalDsl.g:904:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getAbstractStatement_ImplAccess().getAbstractStatementAction_0(),
								current);
						}
			}

			// InternalDsl.g:910:3: ( (lv_name_1_0= ruleCodeString ) )
			// InternalDsl.g:911:4: (lv_name_1_0= ruleCodeString )
			{
			// InternalDsl.g:911:4: (lv_name_1_0= ruleCodeString )
			// InternalDsl.g:912:5: lv_name_1_0= ruleCodeString
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
	// InternalDsl.g:933:1: entryRuleMethodStatement returns [EObject current=null] :iv_ruleMethodStatement= ruleMethodStatement EOF ;
	public final EObject entryRuleMethodStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleMethodStatement =null;

		try {
			// InternalDsl.g:933:56: (iv_ruleMethodStatement= ruleMethodStatement EOF )
			// InternalDsl.g:934:2: iv_ruleMethodStatement= ruleMethodStatement EOF
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
	// InternalDsl.g:940:1: ruleMethodStatement returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) ) ;
	public final EObject ruleMethodStatement() throws RecognitionException {
		EObject current = null;


		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:946:2: ( ( () ( (lv_name_1_0= ruleEString ) ) ) )
			// InternalDsl.g:947:2: ( () ( (lv_name_1_0= ruleEString ) ) )
			{
			// InternalDsl.g:947:2: ( () ( (lv_name_1_0= ruleEString ) ) )
			// InternalDsl.g:948:3: () ( (lv_name_1_0= ruleEString ) )
			{
			// InternalDsl.g:948:3: ()
			// InternalDsl.g:949:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getMethodStatementAccess().getMethodStatementAction_0(),
								current);
						}
			}

			// InternalDsl.g:955:3: ( (lv_name_1_0= ruleEString ) )
			// InternalDsl.g:956:4: (lv_name_1_0= ruleEString )
			{
			// InternalDsl.g:956:4: (lv_name_1_0= ruleEString )
			// InternalDsl.g:957:5: lv_name_1_0= ruleEString
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
	// InternalDsl.g:978:1: entryRuleReturnStatement returns [EObject current=null] :iv_ruleReturnStatement= ruleReturnStatement EOF ;
	public final EObject entryRuleReturnStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleReturnStatement =null;

		try {
			// InternalDsl.g:978:56: (iv_ruleReturnStatement= ruleReturnStatement EOF )
			// InternalDsl.g:979:2: iv_ruleReturnStatement= ruleReturnStatement EOF
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
	// InternalDsl.g:985:1: ruleReturnStatement returns [EObject current=null] : ( () otherlv_1= 'Return' ( (lv_name_2_0= ruleCodeString ) ) ) ;
	public final EObject ruleReturnStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		AntlrDatatypeRuleToken lv_name_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:991:2: ( ( () otherlv_1= 'Return' ( (lv_name_2_0= ruleCodeString ) ) ) )
			// InternalDsl.g:992:2: ( () otherlv_1= 'Return' ( (lv_name_2_0= ruleCodeString ) ) )
			{
			// InternalDsl.g:992:2: ( () otherlv_1= 'Return' ( (lv_name_2_0= ruleCodeString ) ) )
			// InternalDsl.g:993:3: () otherlv_1= 'Return' ( (lv_name_2_0= ruleCodeString ) )
			{
			// InternalDsl.g:993:3: ()
			// InternalDsl.g:994:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getReturnStatementAccess().getReturnStatementAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,71,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getReturnStatementAccess().getReturnKeyword_1());
					}
			// InternalDsl.g:1004:3: ( (lv_name_2_0= ruleCodeString ) )
			// InternalDsl.g:1005:4: (lv_name_2_0= ruleCodeString )
			{
			// InternalDsl.g:1005:4: (lv_name_2_0= ruleCodeString )
			// InternalDsl.g:1006:5: lv_name_2_0= ruleCodeString
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
	// InternalDsl.g:1027:1: entryRuleStrengthWeakStatement returns [EObject current=null] :iv_ruleStrengthWeakStatement= ruleStrengthWeakStatement EOF ;
	public final EObject entryRuleStrengthWeakStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleStrengthWeakStatement =null;

		try {
			// InternalDsl.g:1027:62: (iv_ruleStrengthWeakStatement= ruleStrengthWeakStatement EOF )
			// InternalDsl.g:1028:2: iv_ruleStrengthWeakStatement= ruleStrengthWeakStatement EOF
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
	// InternalDsl.g:1034:1: ruleStrengthWeakStatement returns [EObject current=null] : ( () otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_weakPreCondition_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_name_6_0= ruleCodeString ) ) otherlv_7= '}' otherlv_8= 'Post:' otherlv_9= '(' ( (lv_strongPostCondition_10_0= ruleCondition ) ) otherlv_11= ')' ) ;
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
			// InternalDsl.g:1040:2: ( ( () otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_weakPreCondition_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_name_6_0= ruleCodeString ) ) otherlv_7= '}' otherlv_8= 'Post:' otherlv_9= '(' ( (lv_strongPostCondition_10_0= ruleCondition ) ) otherlv_11= ')' ) )
			// InternalDsl.g:1041:2: ( () otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_weakPreCondition_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_name_6_0= ruleCodeString ) ) otherlv_7= '}' otherlv_8= 'Post:' otherlv_9= '(' ( (lv_strongPostCondition_10_0= ruleCondition ) ) otherlv_11= ')' )
			{
			// InternalDsl.g:1041:2: ( () otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_weakPreCondition_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_name_6_0= ruleCodeString ) ) otherlv_7= '}' otherlv_8= 'Post:' otherlv_9= '(' ( (lv_strongPostCondition_10_0= ruleCondition ) ) otherlv_11= ')' )
			// InternalDsl.g:1042:3: () otherlv_1= 'Pre:' otherlv_2= '(' ( (lv_weakPreCondition_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_name_6_0= ruleCodeString ) ) otherlv_7= '}' otherlv_8= 'Post:' otherlv_9= '(' ( (lv_strongPostCondition_10_0= ruleCondition ) ) otherlv_11= ')'
			{
			// InternalDsl.g:1042:3: ()
			// InternalDsl.g:1043:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getStrengthWeakStatementAccess().getStrengthWeakStatementAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,68,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getStrengthWeakStatementAccess().getPreKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getStrengthWeakStatementAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:1057:3: ( (lv_weakPreCondition_3_0= ruleCondition ) )
			// InternalDsl.g:1058:4: (lv_weakPreCondition_3_0= ruleCondition )
			{
			// InternalDsl.g:1058:4: (lv_weakPreCondition_3_0= ruleCondition )
			// InternalDsl.g:1059:5: lv_weakPreCondition_3_0= ruleCondition
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
			otherlv_5=(Token)match(input,109,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getStrengthWeakStatementAccess().getLeftCurlyBracketKeyword_5());
					}
			// InternalDsl.g:1084:3: ( (lv_name_6_0= ruleCodeString ) )
			// InternalDsl.g:1085:4: (lv_name_6_0= ruleCodeString )
			{
			// InternalDsl.g:1085:4: (lv_name_6_0= ruleCodeString )
			// InternalDsl.g:1086:5: lv_name_6_0= ruleCodeString
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

			otherlv_7=(Token)match(input,113,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_7, grammarAccess.getStrengthWeakStatementAccess().getRightCurlyBracketKeyword_7());
					}
			otherlv_8=(Token)match(input,67,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getStrengthWeakStatementAccess().getPostKeyword_8());
					}
			otherlv_9=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_9, grammarAccess.getStrengthWeakStatementAccess().getLeftParenthesisKeyword_9());
					}
			// InternalDsl.g:1115:3: ( (lv_strongPostCondition_10_0= ruleCondition ) )
			// InternalDsl.g:1116:4: (lv_strongPostCondition_10_0= ruleCondition )
			{
			// InternalDsl.g:1116:4: (lv_strongPostCondition_10_0= ruleCondition )
			// InternalDsl.g:1117:5: lv_strongPostCondition_10_0= ruleCondition
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
	// InternalDsl.g:1142:1: entryRuleCondition returns [EObject current=null] :iv_ruleCondition= ruleCondition EOF ;
	public final EObject entryRuleCondition() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleCondition =null;

		try {
			// InternalDsl.g:1142:50: (iv_ruleCondition= ruleCondition EOF )
			// InternalDsl.g:1143:2: iv_ruleCondition= ruleCondition EOF
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
	// InternalDsl.g:1149:1: ruleCondition returns [EObject current=null] : ( () ( (lv_condition_1_0= ruleExpression ) ) ) ;
	public final EObject ruleCondition() throws RecognitionException {
		EObject current = null;


		EObject lv_condition_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1155:2: ( ( () ( (lv_condition_1_0= ruleExpression ) ) ) )
			// InternalDsl.g:1156:2: ( () ( (lv_condition_1_0= ruleExpression ) ) )
			{
			// InternalDsl.g:1156:2: ( () ( (lv_condition_1_0= ruleExpression ) ) )
			// InternalDsl.g:1157:3: () ( (lv_condition_1_0= ruleExpression ) )
			{
			// InternalDsl.g:1157:3: ()
			// InternalDsl.g:1158:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getConditionAccess().getConditionAction_0(),
								current);
						}
			}

			// InternalDsl.g:1164:3: ( (lv_condition_1_0= ruleExpression ) )
			// InternalDsl.g:1165:4: (lv_condition_1_0= ruleExpression )
			{
			// InternalDsl.g:1165:4: (lv_condition_1_0= ruleExpression )
			// InternalDsl.g:1166:5: lv_condition_1_0= ruleExpression
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
	// InternalDsl.g:1187:1: entryRuleSkipStatement returns [EObject current=null] :iv_ruleSkipStatement= ruleSkipStatement EOF ;
	public final EObject entryRuleSkipStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleSkipStatement =null;

		try {
			// InternalDsl.g:1187:54: (iv_ruleSkipStatement= ruleSkipStatement EOF )
			// InternalDsl.g:1188:2: iv_ruleSkipStatement= ruleSkipStatement EOF
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
	// InternalDsl.g:1194:1: ruleSkipStatement returns [EObject current=null] : ( (lv_name_0_0= ';' ) ) ;
	public final EObject ruleSkipStatement() throws RecognitionException {
		EObject current = null;


		Token lv_name_0_0=null;


			enterRule();

		try {
			// InternalDsl.g:1200:2: ( ( (lv_name_0_0= ';' ) ) )
			// InternalDsl.g:1201:2: ( (lv_name_0_0= ';' ) )
			{
			// InternalDsl.g:1201:2: ( (lv_name_0_0= ';' ) )
			// InternalDsl.g:1202:3: (lv_name_0_0= ';' )
			{
			// InternalDsl.g:1202:3: (lv_name_0_0= ';' )
			// InternalDsl.g:1203:4: lv_name_0_0= ';'
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
	// InternalDsl.g:1218:1: entryRuleCompositionStatement returns [EObject current=null] :iv_ruleCompositionStatement= ruleCompositionStatement EOF ;
	public final EObject entryRuleCompositionStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleCompositionStatement =null;

		try {
			// InternalDsl.g:1218:61: (iv_ruleCompositionStatement= ruleCompositionStatement EOF )
			// InternalDsl.g:1219:2: iv_ruleCompositionStatement= ruleCompositionStatement EOF
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
	// InternalDsl.g:1225:1: ruleCompositionStatement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_firstStatement_2_0= ruleAbstractStatement ) ) otherlv_3= '}' otherlv_4= 'Intm:' otherlv_5= '(' ( (lv_intermediateCondition_6_0= ruleCondition ) ) otherlv_7= ')' otherlv_8= '{' ( (lv_secondStatement_9_0= ruleAbstractStatement ) ) otherlv_10= '}' ) ;
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
			// InternalDsl.g:1231:2: ( ( () otherlv_1= '{' ( (lv_firstStatement_2_0= ruleAbstractStatement ) ) otherlv_3= '}' otherlv_4= 'Intm:' otherlv_5= '(' ( (lv_intermediateCondition_6_0= ruleCondition ) ) otherlv_7= ')' otherlv_8= '{' ( (lv_secondStatement_9_0= ruleAbstractStatement ) ) otherlv_10= '}' ) )
			// InternalDsl.g:1232:2: ( () otherlv_1= '{' ( (lv_firstStatement_2_0= ruleAbstractStatement ) ) otherlv_3= '}' otherlv_4= 'Intm:' otherlv_5= '(' ( (lv_intermediateCondition_6_0= ruleCondition ) ) otherlv_7= ')' otherlv_8= '{' ( (lv_secondStatement_9_0= ruleAbstractStatement ) ) otherlv_10= '}' )
			{
			// InternalDsl.g:1232:2: ( () otherlv_1= '{' ( (lv_firstStatement_2_0= ruleAbstractStatement ) ) otherlv_3= '}' otherlv_4= 'Intm:' otherlv_5= '(' ( (lv_intermediateCondition_6_0= ruleCondition ) ) otherlv_7= ')' otherlv_8= '{' ( (lv_secondStatement_9_0= ruleAbstractStatement ) ) otherlv_10= '}' )
			// InternalDsl.g:1233:3: () otherlv_1= '{' ( (lv_firstStatement_2_0= ruleAbstractStatement ) ) otherlv_3= '}' otherlv_4= 'Intm:' otherlv_5= '(' ( (lv_intermediateCondition_6_0= ruleCondition ) ) otherlv_7= ')' otherlv_8= '{' ( (lv_secondStatement_9_0= ruleAbstractStatement ) ) otherlv_10= '}'
			{
			// InternalDsl.g:1233:3: ()
			// InternalDsl.g:1234:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getCompositionStatementAccess().getCompositionStatementAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,109,FOLLOW_10); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getCompositionStatementAccess().getLeftCurlyBracketKeyword_1());
					}
			// InternalDsl.g:1244:3: ( (lv_firstStatement_2_0= ruleAbstractStatement ) )
			// InternalDsl.g:1245:4: (lv_firstStatement_2_0= ruleAbstractStatement )
			{
			// InternalDsl.g:1245:4: (lv_firstStatement_2_0= ruleAbstractStatement )
			// InternalDsl.g:1246:5: lv_firstStatement_2_0= ruleAbstractStatement
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

			otherlv_3=(Token)match(input,113,FOLLOW_30); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getCompositionStatementAccess().getRightCurlyBracketKeyword_3());
					}
			otherlv_4=(Token)match(input,62,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getCompositionStatementAccess().getIntmKeyword_4());
					}
			otherlv_5=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getCompositionStatementAccess().getLeftParenthesisKeyword_5());
					}
			// InternalDsl.g:1275:3: ( (lv_intermediateCondition_6_0= ruleCondition ) )
			// InternalDsl.g:1276:4: (lv_intermediateCondition_6_0= ruleCondition )
			{
			// InternalDsl.g:1276:4: (lv_intermediateCondition_6_0= ruleCondition )
			// InternalDsl.g:1277:5: lv_intermediateCondition_6_0= ruleCondition
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
			otherlv_8=(Token)match(input,109,FOLLOW_10); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getCompositionStatementAccess().getLeftCurlyBracketKeyword_8());
					}
			// InternalDsl.g:1302:3: ( (lv_secondStatement_9_0= ruleAbstractStatement ) )
			// InternalDsl.g:1303:4: (lv_secondStatement_9_0= ruleAbstractStatement )
			{
			// InternalDsl.g:1303:4: (lv_secondStatement_9_0= ruleAbstractStatement )
			// InternalDsl.g:1304:5: lv_secondStatement_9_0= ruleAbstractStatement
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

			otherlv_10=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:1329:1: entryRuleJavaStatement returns [EObject current=null] :iv_ruleJavaStatement= ruleJavaStatement EOF ;
	public final EObject entryRuleJavaStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJavaStatement =null;

		try {
			// InternalDsl.g:1329:54: (iv_ruleJavaStatement= ruleJavaStatement EOF )
			// InternalDsl.g:1330:2: iv_ruleJavaStatement= ruleJavaStatement EOF
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
	// InternalDsl.g:1336:1: ruleJavaStatement returns [EObject current=null] : ( (lv_name_0_0= ruleXJStatementOrBlock ) )+ ;
	public final EObject ruleJavaStatement() throws RecognitionException {
		EObject current = null;


		EObject lv_name_0_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1342:2: ( ( (lv_name_0_0= ruleXJStatementOrBlock ) )+ )
			// InternalDsl.g:1343:2: ( (lv_name_0_0= ruleXJStatementOrBlock ) )+
			{
			// InternalDsl.g:1343:2: ( (lv_name_0_0= ruleXJStatementOrBlock ) )+
			int cnt28=0;
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( ((LA28_0 >= RULE_CHARACTER && LA28_0 <= RULE_INT)||LA28_0==RULE_STRING||LA28_0==14||LA28_0==22||(LA28_0 >= 28 && LA28_0 <= 29)||(LA28_0 >= 32 && LA28_0 <= 33)||LA28_0==41||LA28_0==81||LA28_0==85||LA28_0==87||(LA28_0 >= 89 && LA28_0 <= 92)||(LA28_0 >= 94 && LA28_0 <= 96)||(LA28_0 >= 98 && LA28_0 <= 109)||LA28_0==114) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// InternalDsl.g:1344:3: (lv_name_0_0= ruleXJStatementOrBlock )
					{
					// InternalDsl.g:1344:3: (lv_name_0_0= ruleXJStatementOrBlock )
					// InternalDsl.g:1345:4: lv_name_0_0= ruleXJStatementOrBlock
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getJavaStatementAccess().getNameXJStatementOrBlockParserRuleCall_0());
								}
					pushFollow(FOLLOW_31);
					lv_name_0_0=ruleXJStatementOrBlock();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									if (current==null) {
										current = createModelElementForParent(grammarAccess.getJavaStatementRule());
									}
									add(
										current,
										"name",
										lv_name_0_0,
										"jbase.Jbase.XJStatementOrBlock");
									afterParserOrEnumRuleCall();
								}
					}

					}
					break;

				default :
					if ( cnt28 >= 1 ) break loop28;
					if (state.backtracking>0) {state.failed=true; return current;}
					EarlyExitException eee = new EarlyExitException(28, input);
					throw eee;
				}
				cnt28++;
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
	// InternalDsl.g:1365:1: entryRuleJMLAnnotation returns [EObject current=null] :iv_ruleJMLAnnotation= ruleJMLAnnotation EOF ;
	public final EObject entryRuleJMLAnnotation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJMLAnnotation =null;

		try {
			// InternalDsl.g:1365:54: (iv_ruleJMLAnnotation= ruleJMLAnnotation EOF )
			// InternalDsl.g:1366:2: iv_ruleJMLAnnotation= ruleJMLAnnotation EOF
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
	// InternalDsl.g:1372:1: ruleJMLAnnotation returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) ) )+ {...}?) ) ) ;
	public final EObject ruleJMLAnnotation() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_requires_2_0 =null;
		EObject lv_ensures_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1378:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) ) )+ {...}?) ) ) )
			// InternalDsl.g:1379:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) ) )+ {...}?) ) )
			{
			// InternalDsl.g:1379:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) ) )+ {...}?) ) )
			// InternalDsl.g:1380:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) ) )+ {...}?) )
			{
			// InternalDsl.g:1380:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) ) )+ {...}?) )
			// InternalDsl.g:1381:4: ( ( ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) ) )+ {...}?)
			{
			getUnorderedGroupHelper().enter(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup());
			// InternalDsl.g:1384:4: ( ( ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) ) )+ {...}?)
			// InternalDsl.g:1385:5: ( ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) ) )+ {...}?
			{
			// InternalDsl.g:1385:5: ( ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) ) )+
			int cnt29=0;
			loop29:
			while (true) {
				int alt29=3;
				int LA29_0 = input.LA(1);
				if ( LA29_0 == 52 && getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 0) ) {
					alt29=1;
				}
				else if ( LA29_0 == 51 && getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 1) ) {
					alt29=2;
				}

				switch (alt29) {
				case 1 :
					// InternalDsl.g:1386:3: ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) )
					{
					// InternalDsl.g:1386:3: ({...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) ) )
					// InternalDsl.g:1387:4: {...}? => ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 0) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleJMLAnnotation", "getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 0)");
					}
					// InternalDsl.g:1387:107: ( ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) ) )
					// InternalDsl.g:1388:5: ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) )
					{
					getUnorderedGroupHelper().select(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 0);
					// InternalDsl.g:1391:8: ({...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' ) )
					// InternalDsl.g:1391:9: {...}? => (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' )
					{
					if ( !((true)) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleJMLAnnotation", "true");
					}
					// InternalDsl.g:1391:18: (otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';' )
					// InternalDsl.g:1391:19: otherlv_1= '@requires' ( (lv_requires_2_0= ruleCondition ) ) otherlv_3= ';'
					{
					otherlv_1=(Token)match(input,52,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
													newLeafNode(otherlv_1, grammarAccess.getJMLAnnotationAccess().getRequiresKeyword_0_0());
												}
					// InternalDsl.g:1395:8: ( (lv_requires_2_0= ruleCondition ) )
					// InternalDsl.g:1396:9: (lv_requires_2_0= ruleCondition )
					{
					// InternalDsl.g:1396:9: (lv_requires_2_0= ruleCondition )
					// InternalDsl.g:1397:10: lv_requires_2_0= ruleCondition
					{
					if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getJMLAnnotationAccess().getRequiresConditionParserRuleCall_0_1_0());
														}
					pushFollow(FOLLOW_32);
					lv_requires_2_0=ruleCondition();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getJMLAnnotationRule());
															}
															set(
																current,
																"requires",
																lv_requires_2_0,
																"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
															afterParserOrEnumRuleCall();
														}
					}

					}

					otherlv_3=(Token)match(input,41,FOLLOW_33); if (state.failed) return current;
					if ( state.backtracking==0 ) {
													newLeafNode(otherlv_3, grammarAccess.getJMLAnnotationAccess().getSemicolonKeyword_0_2());
												}
					}

					}

					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup());
					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:1424:3: ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) )
					{
					// InternalDsl.g:1424:3: ({...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) ) )
					// InternalDsl.g:1425:4: {...}? => ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) )
					{
					if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 1) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleJMLAnnotation", "getUnorderedGroupHelper().canSelect(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 1)");
					}
					// InternalDsl.g:1425:107: ( ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) ) )
					// InternalDsl.g:1426:5: ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) )
					{
					getUnorderedGroupHelper().select(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup(), 1);
					// InternalDsl.g:1429:8: ({...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' ) )
					// InternalDsl.g:1429:9: {...}? => (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' )
					{
					if ( !((true)) ) {
						if (state.backtracking>0) {state.failed=true; return current;}
						throw new FailedPredicateException(input, "ruleJMLAnnotation", "true");
					}
					// InternalDsl.g:1429:18: (otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';' )
					// InternalDsl.g:1429:19: otherlv_4= '@ensures' ( (lv_ensures_5_0= ruleCondition ) ) otherlv_6= ';'
					{
					otherlv_4=(Token)match(input,51,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
													newLeafNode(otherlv_4, grammarAccess.getJMLAnnotationAccess().getEnsuresKeyword_1_0());
												}
					// InternalDsl.g:1433:8: ( (lv_ensures_5_0= ruleCondition ) )
					// InternalDsl.g:1434:9: (lv_ensures_5_0= ruleCondition )
					{
					// InternalDsl.g:1434:9: (lv_ensures_5_0= ruleCondition )
					// InternalDsl.g:1435:10: lv_ensures_5_0= ruleCondition
					{
					if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getJMLAnnotationAccess().getEnsuresConditionParserRuleCall_1_1_0());
														}
					pushFollow(FOLLOW_32);
					lv_ensures_5_0=ruleCondition();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getJMLAnnotationRule());
															}
															set(
																current,
																"ensures",
																lv_ensures_5_0,
																"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.Condition");
															afterParserOrEnumRuleCall();
														}
					}

					}

					otherlv_6=(Token)match(input,41,FOLLOW_33); if (state.failed) return current;
					if ( state.backtracking==0 ) {
													newLeafNode(otherlv_6, grammarAccess.getJMLAnnotationAccess().getSemicolonKeyword_1_2());
												}
					}

					}

					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getJMLAnnotationAccess().getUnorderedGroup());
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
	// InternalDsl.g:1473:1: entryRuleInlineBlockStatement returns [EObject current=null] :iv_ruleInlineBlockStatement= ruleInlineBlockStatement EOF ;
	public final EObject entryRuleInlineBlockStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleInlineBlockStatement =null;

		try {
			// InternalDsl.g:1473:61: (iv_ruleInlineBlockStatement= ruleInlineBlockStatement EOF )
			// InternalDsl.g:1474:2: iv_ruleInlineBlockStatement= ruleInlineBlockStatement EOF
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
	// InternalDsl.g:1480:1: ruleInlineBlockStatement returns [EObject current=null] : ( ( (lv_block_0_0= ruleBlockStatement ) ) | (otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) ) ) ) ;
	public final EObject ruleInlineBlockStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_block_0_0 =null;
		AntlrDatatypeRuleToken lv_name_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1486:2: ( ( ( (lv_block_0_0= ruleBlockStatement ) ) | (otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) ) ) ) )
			// InternalDsl.g:1487:2: ( ( (lv_block_0_0= ruleBlockStatement ) ) | (otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) ) ) )
			{
			// InternalDsl.g:1487:2: ( ( (lv_block_0_0= ruleBlockStatement ) ) | (otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) ) ) )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==53) ) {
				int LA30_1 = input.LA(2);
				if ( (LA30_1==RULE_STRING) ) {
					int LA30_2 = input.LA(3);
					if ( (LA30_2==40) ) {
						alt30=1;
					}
					else if ( (LA30_2==EOF||LA30_2==113) ) {
						alt30=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 30, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA30_1==RULE_ID) ) {
					int LA30_3 = input.LA(3);
					if ( (LA30_3==40) ) {
						alt30=1;
					}
					else if ( (LA30_3==EOF||LA30_3==113) ) {
						alt30=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 30, 3, input);
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
							new NoViableAltException("", 30, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// InternalDsl.g:1488:3: ( (lv_block_0_0= ruleBlockStatement ) )
					{
					// InternalDsl.g:1488:3: ( (lv_block_0_0= ruleBlockStatement ) )
					// InternalDsl.g:1489:4: (lv_block_0_0= ruleBlockStatement )
					{
					// InternalDsl.g:1489:4: (lv_block_0_0= ruleBlockStatement )
					// InternalDsl.g:1490:5: lv_block_0_0= ruleBlockStatement
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getInlineBlockStatementAccess().getBlockBlockStatementParserRuleCall_0_0());
									}
					pushFollow(FOLLOW_2);
					lv_block_0_0=ruleBlockStatement();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getInlineBlockStatementRule());
										}
										set(
											current,
											"block",
											lv_block_0_0,
											"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.BlockStatement");
										afterParserOrEnumRuleCall();
									}
					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:1508:3: (otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) ) )
					{
					// InternalDsl.g:1508:3: (otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) ) )
					// InternalDsl.g:1509:4: otherlv_1= 'Block' ( (lv_name_2_0= ruleEString ) )
					{
					otherlv_1=(Token)match(input,53,FOLLOW_4); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_1, grammarAccess.getInlineBlockStatementAccess().getBlockKeyword_1_0());
								}
					// InternalDsl.g:1513:4: ( (lv_name_2_0= ruleEString ) )
					// InternalDsl.g:1514:5: (lv_name_2_0= ruleEString )
					{
					// InternalDsl.g:1514:5: (lv_name_2_0= ruleEString )
					// InternalDsl.g:1515:6: lv_name_2_0= ruleEString
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getInlineBlockStatementAccess().getNameEStringParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_2);
					lv_name_2_0=ruleEString();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getInlineBlockStatementRule());
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
	// InternalDsl.g:1537:1: entryRuleBlockStatement returns [EObject current=null] :iv_ruleBlockStatement= ruleBlockStatement EOF ;
	public final EObject entryRuleBlockStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleBlockStatement =null;

		try {
			// InternalDsl.g:1537:55: (iv_ruleBlockStatement= ruleBlockStatement EOF )
			// InternalDsl.g:1538:2: iv_ruleBlockStatement= ruleBlockStatement EOF
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
	// InternalDsl.g:1544:1: ruleBlockStatement returns [EObject current=null] : (otherlv_0= 'Block' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_jmlAnnotation_3_0= ruleJMLAnnotation ) )? otherlv_4= '{' ( (lv_javaStatement_5_0= ruleJavaStatement ) ) otherlv_6= '}' ) ;
	public final EObject ruleBlockStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;
		EObject lv_jmlAnnotation_3_0 =null;
		EObject lv_javaStatement_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1550:2: ( (otherlv_0= 'Block' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_jmlAnnotation_3_0= ruleJMLAnnotation ) )? otherlv_4= '{' ( (lv_javaStatement_5_0= ruleJavaStatement ) ) otherlv_6= '}' ) )
			// InternalDsl.g:1551:2: (otherlv_0= 'Block' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_jmlAnnotation_3_0= ruleJMLAnnotation ) )? otherlv_4= '{' ( (lv_javaStatement_5_0= ruleJavaStatement ) ) otherlv_6= '}' )
			{
			// InternalDsl.g:1551:2: (otherlv_0= 'Block' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_jmlAnnotation_3_0= ruleJMLAnnotation ) )? otherlv_4= '{' ( (lv_javaStatement_5_0= ruleJavaStatement ) ) otherlv_6= '}' )
			// InternalDsl.g:1552:3: otherlv_0= 'Block' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_jmlAnnotation_3_0= ruleJMLAnnotation ) )? otherlv_4= '{' ( (lv_javaStatement_5_0= ruleJavaStatement ) ) otherlv_6= '}'
			{
			otherlv_0=(Token)match(input,53,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getBlockStatementAccess().getBlockKeyword_0());
					}
			// InternalDsl.g:1556:3: ( (lv_name_1_0= ruleEString ) )
			// InternalDsl.g:1557:4: (lv_name_1_0= ruleEString )
			{
			// InternalDsl.g:1557:4: (lv_name_1_0= ruleEString )
			// InternalDsl.g:1558:5: lv_name_1_0= ruleEString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getBlockStatementAccess().getNameEStringParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_34);
			lv_name_1_0=ruleEString();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getBlockStatementRule());
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

			otherlv_2=(Token)match(input,40,FOLLOW_35); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getBlockStatementAccess().getColonKeyword_2());
					}
			// InternalDsl.g:1579:3: ( (lv_jmlAnnotation_3_0= ruleJMLAnnotation ) )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( ((LA31_0 >= 51 && LA31_0 <= 52)) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// InternalDsl.g:1580:4: (lv_jmlAnnotation_3_0= ruleJMLAnnotation )
					{
					// InternalDsl.g:1580:4: (lv_jmlAnnotation_3_0= ruleJMLAnnotation )
					// InternalDsl.g:1581:5: lv_jmlAnnotation_3_0= ruleJMLAnnotation
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getBlockStatementAccess().getJmlAnnotationJMLAnnotationParserRuleCall_3_0());
									}
					pushFollow(FOLLOW_9);
					lv_jmlAnnotation_3_0=ruleJMLAnnotation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getBlockStatementRule());
										}
										set(
											current,
											"jmlAnnotation",
											lv_jmlAnnotation_3_0,
											"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.JMLAnnotation");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			otherlv_4=(Token)match(input,109,FOLLOW_36); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getBlockStatementAccess().getLeftCurlyBracketKeyword_4());
					}
			// InternalDsl.g:1602:3: ( (lv_javaStatement_5_0= ruleJavaStatement ) )
			// InternalDsl.g:1603:4: (lv_javaStatement_5_0= ruleJavaStatement )
			{
			// InternalDsl.g:1603:4: (lv_javaStatement_5_0= ruleJavaStatement )
			// InternalDsl.g:1604:5: lv_javaStatement_5_0= ruleJavaStatement
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getBlockStatementAccess().getJavaStatementJavaStatementParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_11);
			lv_javaStatement_5_0=ruleJavaStatement();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getBlockStatementRule());
								}
								set(
									current,
									"javaStatement",
									lv_javaStatement_5_0,
									"de.tu_bs.cs.isf.cbc.textual.tool.Dsl.JavaStatement");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_6=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getBlockStatementAccess().getRightCurlyBracketKeyword_6());
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
	// InternalDsl.g:1629:1: entryRuleSelectionStatement returns [EObject current=null] :iv_ruleSelectionStatement= ruleSelectionStatement EOF ;
	public final EObject entryRuleSelectionStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleSelectionStatement =null;

		try {
			// InternalDsl.g:1629:59: (iv_ruleSelectionStatement= ruleSelectionStatement EOF )
			// InternalDsl.g:1630:2: iv_ruleSelectionStatement= ruleSelectionStatement EOF
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
	// InternalDsl.g:1636:1: ruleSelectionStatement returns [EObject current=null] : ( () otherlv_1= 'If' otherlv_2= '(' ( (lv_guards_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Then' otherlv_6= '{' ( (lv_commands_7_0= ruleAbstractStatement ) ) otherlv_8= '}' (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )* otherlv_17= 'Fi' ) ;
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
			// InternalDsl.g:1642:2: ( ( () otherlv_1= 'If' otherlv_2= '(' ( (lv_guards_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Then' otherlv_6= '{' ( (lv_commands_7_0= ruleAbstractStatement ) ) otherlv_8= '}' (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )* otherlv_17= 'Fi' ) )
			// InternalDsl.g:1643:2: ( () otherlv_1= 'If' otherlv_2= '(' ( (lv_guards_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Then' otherlv_6= '{' ( (lv_commands_7_0= ruleAbstractStatement ) ) otherlv_8= '}' (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )* otherlv_17= 'Fi' )
			{
			// InternalDsl.g:1643:2: ( () otherlv_1= 'If' otherlv_2= '(' ( (lv_guards_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Then' otherlv_6= '{' ( (lv_commands_7_0= ruleAbstractStatement ) ) otherlv_8= '}' (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )* otherlv_17= 'Fi' )
			// InternalDsl.g:1644:3: () otherlv_1= 'If' otherlv_2= '(' ( (lv_guards_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Then' otherlv_6= '{' ( (lv_commands_7_0= ruleAbstractStatement ) ) otherlv_8= '}' (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )* otherlv_17= 'Fi'
			{
			// InternalDsl.g:1644:3: ()
			// InternalDsl.g:1645:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getSelectionStatementAccess().getSelectionStatementAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,61,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getSelectionStatementAccess().getIfKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getSelectionStatementAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:1659:3: ( (lv_guards_3_0= ruleCondition ) )
			// InternalDsl.g:1660:4: (lv_guards_3_0= ruleCondition )
			{
			// InternalDsl.g:1660:4: (lv_guards_3_0= ruleCondition )
			// InternalDsl.g:1661:5: lv_guards_3_0= ruleCondition
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

			otherlv_4=(Token)match(input,25,FOLLOW_37); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getSelectionStatementAccess().getRightParenthesisKeyword_4());
					}
			otherlv_5=(Token)match(input,72,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getSelectionStatementAccess().getThenKeyword_5());
					}
			otherlv_6=(Token)match(input,109,FOLLOW_10); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getSelectionStatementAccess().getLeftCurlyBracketKeyword_6());
					}
			// InternalDsl.g:1690:3: ( (lv_commands_7_0= ruleAbstractStatement ) )
			// InternalDsl.g:1691:4: (lv_commands_7_0= ruleAbstractStatement )
			{
			// InternalDsl.g:1691:4: (lv_commands_7_0= ruleAbstractStatement )
			// InternalDsl.g:1692:5: lv_commands_7_0= ruleAbstractStatement
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

			otherlv_8=(Token)match(input,113,FOLLOW_38); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getSelectionStatementAccess().getRightCurlyBracketKeyword_8());
					}
			// InternalDsl.g:1713:3: (otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}' )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==56) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// InternalDsl.g:1714:4: otherlv_9= 'Elseif' otherlv_10= '(' ( (lv_guards_11_0= ruleCondition ) ) otherlv_12= ')' otherlv_13= 'Then' otherlv_14= '{' ( (lv_commands_15_0= ruleAbstractStatement ) ) otherlv_16= '}'
					{
					otherlv_9=(Token)match(input,56,FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_9, grammarAccess.getSelectionStatementAccess().getElseifKeyword_9_0());
								}
					otherlv_10=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_10, grammarAccess.getSelectionStatementAccess().getLeftParenthesisKeyword_9_1());
								}
					// InternalDsl.g:1722:4: ( (lv_guards_11_0= ruleCondition ) )
					// InternalDsl.g:1723:5: (lv_guards_11_0= ruleCondition )
					{
					// InternalDsl.g:1723:5: (lv_guards_11_0= ruleCondition )
					// InternalDsl.g:1724:6: lv_guards_11_0= ruleCondition
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

					otherlv_12=(Token)match(input,25,FOLLOW_37); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_12, grammarAccess.getSelectionStatementAccess().getRightParenthesisKeyword_9_3());
								}
					otherlv_13=(Token)match(input,72,FOLLOW_9); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_13, grammarAccess.getSelectionStatementAccess().getThenKeyword_9_4());
								}
					otherlv_14=(Token)match(input,109,FOLLOW_10); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_14, grammarAccess.getSelectionStatementAccess().getLeftCurlyBracketKeyword_9_5());
								}
					// InternalDsl.g:1753:4: ( (lv_commands_15_0= ruleAbstractStatement ) )
					// InternalDsl.g:1754:5: (lv_commands_15_0= ruleAbstractStatement )
					{
					// InternalDsl.g:1754:5: (lv_commands_15_0= ruleAbstractStatement )
					// InternalDsl.g:1755:6: lv_commands_15_0= ruleAbstractStatement
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

					otherlv_16=(Token)match(input,113,FOLLOW_38); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_16, grammarAccess.getSelectionStatementAccess().getRightCurlyBracketKeyword_9_7());
								}
					}
					break;

				default :
					break loop32;
				}
			}

			otherlv_17=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:1785:1: entryRuleSmallRepetitionStatement returns [EObject current=null] :iv_ruleSmallRepetitionStatement= ruleSmallRepetitionStatement EOF ;
	public final EObject entryRuleSmallRepetitionStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleSmallRepetitionStatement =null;

		try {
			// InternalDsl.g:1785:65: (iv_ruleSmallRepetitionStatement= ruleSmallRepetitionStatement EOF )
			// InternalDsl.g:1786:2: iv_ruleSmallRepetitionStatement= ruleSmallRepetitionStatement EOF
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
	// InternalDsl.g:1792:1: ruleSmallRepetitionStatement returns [EObject current=null] : ( () otherlv_1= 'While' otherlv_2= '(' ( (lv_guard_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Do' otherlv_6= 'Inv:' otherlv_7= '(' ( (lv_invariant_8_0= ruleCondition ) ) otherlv_9= ')' otherlv_10= 'Var:' otherlv_11= '(' ( (lv_variant_12_0= ruleVariant ) ) otherlv_13= ')' otherlv_14= '{' ( (lv_loopStatement_15_0= ruleAbstractStatement ) ) otherlv_16= '}' otherlv_17= 'Od' ) ;
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
			// InternalDsl.g:1798:2: ( ( () otherlv_1= 'While' otherlv_2= '(' ( (lv_guard_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Do' otherlv_6= 'Inv:' otherlv_7= '(' ( (lv_invariant_8_0= ruleCondition ) ) otherlv_9= ')' otherlv_10= 'Var:' otherlv_11= '(' ( (lv_variant_12_0= ruleVariant ) ) otherlv_13= ')' otherlv_14= '{' ( (lv_loopStatement_15_0= ruleAbstractStatement ) ) otherlv_16= '}' otherlv_17= 'Od' ) )
			// InternalDsl.g:1799:2: ( () otherlv_1= 'While' otherlv_2= '(' ( (lv_guard_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Do' otherlv_6= 'Inv:' otherlv_7= '(' ( (lv_invariant_8_0= ruleCondition ) ) otherlv_9= ')' otherlv_10= 'Var:' otherlv_11= '(' ( (lv_variant_12_0= ruleVariant ) ) otherlv_13= ')' otherlv_14= '{' ( (lv_loopStatement_15_0= ruleAbstractStatement ) ) otherlv_16= '}' otherlv_17= 'Od' )
			{
			// InternalDsl.g:1799:2: ( () otherlv_1= 'While' otherlv_2= '(' ( (lv_guard_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Do' otherlv_6= 'Inv:' otherlv_7= '(' ( (lv_invariant_8_0= ruleCondition ) ) otherlv_9= ')' otherlv_10= 'Var:' otherlv_11= '(' ( (lv_variant_12_0= ruleVariant ) ) otherlv_13= ')' otherlv_14= '{' ( (lv_loopStatement_15_0= ruleAbstractStatement ) ) otherlv_16= '}' otherlv_17= 'Od' )
			// InternalDsl.g:1800:3: () otherlv_1= 'While' otherlv_2= '(' ( (lv_guard_3_0= ruleCondition ) ) otherlv_4= ')' otherlv_5= 'Do' otherlv_6= 'Inv:' otherlv_7= '(' ( (lv_invariant_8_0= ruleCondition ) ) otherlv_9= ')' otherlv_10= 'Var:' otherlv_11= '(' ( (lv_variant_12_0= ruleVariant ) ) otherlv_13= ')' otherlv_14= '{' ( (lv_loopStatement_15_0= ruleAbstractStatement ) ) otherlv_16= '}' otherlv_17= 'Od'
			{
			// InternalDsl.g:1800:3: ()
			// InternalDsl.g:1801:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getSmallRepetitionStatementAccess().getSmallRepetitionStatementAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,76,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getSmallRepetitionStatementAccess().getWhileKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getSmallRepetitionStatementAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:1815:3: ( (lv_guard_3_0= ruleCondition ) )
			// InternalDsl.g:1816:4: (lv_guard_3_0= ruleCondition )
			{
			// InternalDsl.g:1816:4: (lv_guard_3_0= ruleCondition )
			// InternalDsl.g:1817:5: lv_guard_3_0= ruleCondition
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

			otherlv_4=(Token)match(input,25,FOLLOW_39); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getSmallRepetitionStatementAccess().getRightParenthesisKeyword_4());
					}
			otherlv_5=(Token)match(input,55,FOLLOW_40); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getSmallRepetitionStatementAccess().getDoKeyword_5());
					}
			otherlv_6=(Token)match(input,63,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getSmallRepetitionStatementAccess().getInvKeyword_6());
					}
			otherlv_7=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_7, grammarAccess.getSmallRepetitionStatementAccess().getLeftParenthesisKeyword_7());
					}
			// InternalDsl.g:1850:3: ( (lv_invariant_8_0= ruleCondition ) )
			// InternalDsl.g:1851:4: (lv_invariant_8_0= ruleCondition )
			{
			// InternalDsl.g:1851:4: (lv_invariant_8_0= ruleCondition )
			// InternalDsl.g:1852:5: lv_invariant_8_0= ruleCondition
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

			otherlv_9=(Token)match(input,25,FOLLOW_41); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_9, grammarAccess.getSmallRepetitionStatementAccess().getRightParenthesisKeyword_9());
					}
			otherlv_10=(Token)match(input,74,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_10, grammarAccess.getSmallRepetitionStatementAccess().getVarKeyword_10());
					}
			otherlv_11=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_11, grammarAccess.getSmallRepetitionStatementAccess().getLeftParenthesisKeyword_11());
					}
			// InternalDsl.g:1881:3: ( (lv_variant_12_0= ruleVariant ) )
			// InternalDsl.g:1882:4: (lv_variant_12_0= ruleVariant )
			{
			// InternalDsl.g:1882:4: (lv_variant_12_0= ruleVariant )
			// InternalDsl.g:1883:5: lv_variant_12_0= ruleVariant
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
			otherlv_14=(Token)match(input,109,FOLLOW_10); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_14, grammarAccess.getSmallRepetitionStatementAccess().getLeftCurlyBracketKeyword_14());
					}
			// InternalDsl.g:1908:3: ( (lv_loopStatement_15_0= ruleAbstractStatement ) )
			// InternalDsl.g:1909:4: (lv_loopStatement_15_0= ruleAbstractStatement )
			{
			// InternalDsl.g:1909:4: (lv_loopStatement_15_0= ruleAbstractStatement )
			// InternalDsl.g:1910:5: lv_loopStatement_15_0= ruleAbstractStatement
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

			otherlv_16=(Token)match(input,113,FOLLOW_42); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_16, grammarAccess.getSmallRepetitionStatementAccess().getRightCurlyBracketKeyword_16());
					}
			otherlv_17=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:1939:1: entryRuleVariant returns [EObject current=null] :iv_ruleVariant= ruleVariant EOF ;
	public final EObject entryRuleVariant() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleVariant =null;

		try {
			// InternalDsl.g:1939:48: (iv_ruleVariant= ruleVariant EOF )
			// InternalDsl.g:1940:2: iv_ruleVariant= ruleVariant EOF
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
	// InternalDsl.g:1946:1: ruleVariant returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) ) ;
	public final EObject ruleVariant() throws RecognitionException {
		EObject current = null;


		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:1952:2: ( ( () ( (lv_name_1_0= ruleEString ) ) ) )
			// InternalDsl.g:1953:2: ( () ( (lv_name_1_0= ruleEString ) ) )
			{
			// InternalDsl.g:1953:2: ( () ( (lv_name_1_0= ruleEString ) ) )
			// InternalDsl.g:1954:3: () ( (lv_name_1_0= ruleEString ) )
			{
			// InternalDsl.g:1954:3: ()
			// InternalDsl.g:1955:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getVariantAccess().getVariantAction_0(),
								current);
						}
			}

			// InternalDsl.g:1961:3: ( (lv_name_1_0= ruleEString ) )
			// InternalDsl.g:1962:4: (lv_name_1_0= ruleEString )
			{
			// InternalDsl.g:1962:4: (lv_name_1_0= ruleEString )
			// InternalDsl.g:1963:5: lv_name_1_0= ruleEString
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
	// InternalDsl.g:1984:1: entryRuleJavaVariables returns [EObject current=null] :iv_ruleJavaVariables= ruleJavaVariables EOF ;
	public final EObject entryRuleJavaVariables() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJavaVariables =null;

		try {
			// InternalDsl.g:1984:54: (iv_ruleJavaVariables= ruleJavaVariables EOF )
			// InternalDsl.g:1985:2: iv_ruleJavaVariables= ruleJavaVariables EOF
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
	// InternalDsl.g:1991:1: ruleJavaVariables returns [EObject current=null] : ( () otherlv_1= 'JavaVariables' (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )? ) ;
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
			// InternalDsl.g:1997:2: ( ( () otherlv_1= 'JavaVariables' (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )? ) )
			// InternalDsl.g:1998:2: ( () otherlv_1= 'JavaVariables' (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )? )
			{
			// InternalDsl.g:1998:2: ( () otherlv_1= 'JavaVariables' (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )? )
			// InternalDsl.g:1999:3: () otherlv_1= 'JavaVariables' (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )?
			{
			// InternalDsl.g:1999:3: ()
			// InternalDsl.g:2000:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getJavaVariablesAccess().getJavaVariablesAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,64,FOLLOW_43); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getJavaVariablesAccess().getJavaVariablesKeyword_1());
					}
			// InternalDsl.g:2010:3: (otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']' )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==75) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// InternalDsl.g:2011:4: otherlv_2= 'Variables' otherlv_3= '[' ( (lv_variables_4_0= ruleJavaVariable ) ) (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )* otherlv_7= ']'
					{
					otherlv_2=(Token)match(input,75,FOLLOW_44); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getJavaVariablesAccess().getVariablesKeyword_2_0());
								}
					otherlv_3=(Token)match(input,77,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_3, grammarAccess.getJavaVariablesAccess().getLeftSquareBracketKeyword_2_1());
								}
					// InternalDsl.g:2019:4: ( (lv_variables_4_0= ruleJavaVariable ) )
					// InternalDsl.g:2020:5: (lv_variables_4_0= ruleJavaVariable )
					{
					// InternalDsl.g:2020:5: (lv_variables_4_0= ruleJavaVariable )
					// InternalDsl.g:2021:6: lv_variables_4_0= ruleJavaVariable
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getJavaVariablesAccess().getVariablesJavaVariableParserRuleCall_2_2_0());
										}
					pushFollow(FOLLOW_45);
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

					// InternalDsl.g:2038:4: (otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) ) )*
					loop33:
					while (true) {
						int alt33=2;
						int LA33_0 = input.LA(1);
						if ( (LA33_0==31) ) {
							alt33=1;
						}

						switch (alt33) {
						case 1 :
							// InternalDsl.g:2039:5: otherlv_5= ',' ( (lv_variables_6_0= ruleJavaVariable ) )
							{
							otherlv_5=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_5, grammarAccess.getJavaVariablesAccess().getCommaKeyword_2_3_0());
											}
							// InternalDsl.g:2043:5: ( (lv_variables_6_0= ruleJavaVariable ) )
							// InternalDsl.g:2044:6: (lv_variables_6_0= ruleJavaVariable )
							{
							// InternalDsl.g:2044:6: (lv_variables_6_0= ruleJavaVariable )
							// InternalDsl.g:2045:7: lv_variables_6_0= ruleJavaVariable
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJavaVariablesAccess().getVariablesJavaVariableParserRuleCall_2_3_1_0());
													}
							pushFollow(FOLLOW_45);
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
							break loop33;
						}
					}

					otherlv_7=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:2072:1: entryRuleJavaVariable returns [EObject current=null] :iv_ruleJavaVariable= ruleJavaVariable EOF ;
	public final EObject entryRuleJavaVariable() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJavaVariable =null;

		try {
			// InternalDsl.g:2072:53: (iv_ruleJavaVariable= ruleJavaVariable EOF )
			// InternalDsl.g:2073:2: iv_ruleJavaVariable= ruleJavaVariable EOF
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
	// InternalDsl.g:2079:1: ruleJavaVariable returns [EObject current=null] : ( () ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_var_2_0= ruleVariableOrMethodName ) ) ) ;
	public final EObject ruleJavaVariable() throws RecognitionException {
		EObject current = null;


		EObject lv_type_1_0 =null;
		EObject lv_var_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2085:2: ( ( () ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_var_2_0= ruleVariableOrMethodName ) ) ) )
			// InternalDsl.g:2086:2: ( () ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_var_2_0= ruleVariableOrMethodName ) ) )
			{
			// InternalDsl.g:2086:2: ( () ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_var_2_0= ruleVariableOrMethodName ) ) )
			// InternalDsl.g:2087:3: () ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_var_2_0= ruleVariableOrMethodName ) )
			{
			// InternalDsl.g:2087:3: ()
			// InternalDsl.g:2088:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getJavaVariableAccess().getJavaVariableAction_0(),
								current);
						}
			}

			// InternalDsl.g:2094:3: ( (lv_type_1_0= ruleJvmTypeReference ) )
			// InternalDsl.g:2095:4: (lv_type_1_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:2095:4: (lv_type_1_0= ruleJvmTypeReference )
			// InternalDsl.g:2096:5: lv_type_1_0= ruleJvmTypeReference
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

			// InternalDsl.g:2113:3: ( (lv_var_2_0= ruleVariableOrMethodName ) )
			// InternalDsl.g:2114:4: (lv_var_2_0= ruleVariableOrMethodName )
			{
			// InternalDsl.g:2114:4: (lv_var_2_0= ruleVariableOrMethodName )
			// InternalDsl.g:2115:5: lv_var_2_0= ruleVariableOrMethodName
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
	// InternalDsl.g:2136:1: entryRuleGlobalConditions returns [EObject current=null] :iv_ruleGlobalConditions= ruleGlobalConditions EOF ;
	public final EObject entryRuleGlobalConditions() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleGlobalConditions =null;

		try {
			// InternalDsl.g:2136:57: (iv_ruleGlobalConditions= ruleGlobalConditions EOF )
			// InternalDsl.g:2137:2: iv_ruleGlobalConditions= ruleGlobalConditions EOF
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
	// InternalDsl.g:2143:1: ruleGlobalConditions returns [EObject current=null] : ( () otherlv_1= 'GlobalConditions' (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )? ) ;
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
			// InternalDsl.g:2149:2: ( ( () otherlv_1= 'GlobalConditions' (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )? ) )
			// InternalDsl.g:2150:2: ( () otherlv_1= 'GlobalConditions' (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )? )
			{
			// InternalDsl.g:2150:2: ( () otherlv_1= 'GlobalConditions' (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )? )
			// InternalDsl.g:2151:3: () otherlv_1= 'GlobalConditions' (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )?
			{
			// InternalDsl.g:2151:3: ()
			// InternalDsl.g:2152:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getGlobalConditionsAccess().getGlobalConditionsAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,60,FOLLOW_46); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getGlobalConditionsAccess().getGlobalConditionsKeyword_1());
					}
			// InternalDsl.g:2162:3: (otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']' )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==54) ) {
				alt36=1;
			}
			switch (alt36) {
				case 1 :
					// InternalDsl.g:2163:4: otherlv_2= 'Conditions' otherlv_3= '[' ( (lv_conditions_4_0= ruleCondition ) ) (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )* otherlv_7= ']'
					{
					otherlv_2=(Token)match(input,54,FOLLOW_44); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getGlobalConditionsAccess().getConditionsKeyword_2_0());
								}
					otherlv_3=(Token)match(input,77,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_3, grammarAccess.getGlobalConditionsAccess().getLeftSquareBracketKeyword_2_1());
								}
					// InternalDsl.g:2171:4: ( (lv_conditions_4_0= ruleCondition ) )
					// InternalDsl.g:2172:5: (lv_conditions_4_0= ruleCondition )
					{
					// InternalDsl.g:2172:5: (lv_conditions_4_0= ruleCondition )
					// InternalDsl.g:2173:6: lv_conditions_4_0= ruleCondition
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getGlobalConditionsAccess().getConditionsConditionParserRuleCall_2_2_0());
										}
					pushFollow(FOLLOW_45);
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

					// InternalDsl.g:2190:4: (otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) ) )*
					loop35:
					while (true) {
						int alt35=2;
						int LA35_0 = input.LA(1);
						if ( (LA35_0==31) ) {
							alt35=1;
						}

						switch (alt35) {
						case 1 :
							// InternalDsl.g:2191:5: otherlv_5= ',' ( (lv_conditions_6_0= ruleCondition ) )
							{
							otherlv_5=(Token)match(input,31,FOLLOW_7); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_5, grammarAccess.getGlobalConditionsAccess().getCommaKeyword_2_3_0());
											}
							// InternalDsl.g:2195:5: ( (lv_conditions_6_0= ruleCondition ) )
							// InternalDsl.g:2196:6: (lv_conditions_6_0= ruleCondition )
							{
							// InternalDsl.g:2196:6: (lv_conditions_6_0= ruleCondition )
							// InternalDsl.g:2197:7: lv_conditions_6_0= ruleCondition
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getGlobalConditionsAccess().getConditionsConditionParserRuleCall_2_3_1_0());
													}
							pushFollow(FOLLOW_45);
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
							break loop35;
						}
					}

					otherlv_7=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:2224:1: entryRuleRenaming returns [EObject current=null] :iv_ruleRenaming= ruleRenaming EOF ;
	public final EObject entryRuleRenaming() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleRenaming =null;

		try {
			// InternalDsl.g:2224:49: (iv_ruleRenaming= ruleRenaming EOF )
			// InternalDsl.g:2225:2: iv_ruleRenaming= ruleRenaming EOF
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
	// InternalDsl.g:2231:1: ruleRenaming returns [EObject current=null] : ( () otherlv_1= 'Renaming' (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )? ) ;
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
			// InternalDsl.g:2237:2: ( ( () otherlv_1= 'Renaming' (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )? ) )
			// InternalDsl.g:2238:2: ( () otherlv_1= 'Renaming' (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )? )
			{
			// InternalDsl.g:2238:2: ( () otherlv_1= 'Renaming' (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )? )
			// InternalDsl.g:2239:3: () otherlv_1= 'Renaming' (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )?
			{
			// InternalDsl.g:2239:3: ()
			// InternalDsl.g:2240:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getRenamingAccess().getRenamingAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,70,FOLLOW_47); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getRenamingAccess().getRenamingKeyword_1());
					}
			// InternalDsl.g:2250:3: (otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']' )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==69) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// InternalDsl.g:2251:4: otherlv_2= 'Renames' otherlv_3= '[' ( (lv_rename_4_0= ruleRename ) ) ( (lv_rename_5_0= ruleRename ) )* otherlv_6= ']'
					{
					otherlv_2=(Token)match(input,69,FOLLOW_44); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getRenamingAccess().getRenamesKeyword_2_0());
								}
					otherlv_3=(Token)match(input,77,FOLLOW_9); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_3, grammarAccess.getRenamingAccess().getLeftSquareBracketKeyword_2_1());
								}
					// InternalDsl.g:2259:4: ( (lv_rename_4_0= ruleRename ) )
					// InternalDsl.g:2260:5: (lv_rename_4_0= ruleRename )
					{
					// InternalDsl.g:2260:5: (lv_rename_4_0= ruleRename )
					// InternalDsl.g:2261:6: lv_rename_4_0= ruleRename
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getRenamingAccess().getRenameRenameParserRuleCall_2_2_0());
										}
					pushFollow(FOLLOW_48);
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

					// InternalDsl.g:2278:4: ( (lv_rename_5_0= ruleRename ) )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==109) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// InternalDsl.g:2279:5: (lv_rename_5_0= ruleRename )
							{
							// InternalDsl.g:2279:5: (lv_rename_5_0= ruleRename )
							// InternalDsl.g:2280:6: lv_rename_5_0= ruleRename
							{
							if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getRenamingAccess().getRenameRenameParserRuleCall_2_3_0());
												}
							pushFollow(FOLLOW_48);
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
							break loop37;
						}
					}

					otherlv_6=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:2306:1: entryRuleRename returns [EObject current=null] :iv_ruleRename= ruleRename EOF ;
	public final EObject entryRuleRename() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleRename =null;

		try {
			// InternalDsl.g:2306:47: (iv_ruleRename= ruleRename EOF )
			// InternalDsl.g:2307:2: iv_ruleRename= ruleRename EOF
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
	// InternalDsl.g:2313:1: ruleRename returns [EObject current=null] : ( () otherlv_1= '{' otherlv_2= 'Type' ( (lv_type_3_0= ruleEString ) ) otherlv_4= 'Function' ( (lv_function_5_0= ruleEString ) ) otherlv_6= 'NewName' ( (lv_newName_7_0= ruleEString ) ) otherlv_8= '}' ) ;
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
			// InternalDsl.g:2319:2: ( ( () otherlv_1= '{' otherlv_2= 'Type' ( (lv_type_3_0= ruleEString ) ) otherlv_4= 'Function' ( (lv_function_5_0= ruleEString ) ) otherlv_6= 'NewName' ( (lv_newName_7_0= ruleEString ) ) otherlv_8= '}' ) )
			// InternalDsl.g:2320:2: ( () otherlv_1= '{' otherlv_2= 'Type' ( (lv_type_3_0= ruleEString ) ) otherlv_4= 'Function' ( (lv_function_5_0= ruleEString ) ) otherlv_6= 'NewName' ( (lv_newName_7_0= ruleEString ) ) otherlv_8= '}' )
			{
			// InternalDsl.g:2320:2: ( () otherlv_1= '{' otherlv_2= 'Type' ( (lv_type_3_0= ruleEString ) ) otherlv_4= 'Function' ( (lv_function_5_0= ruleEString ) ) otherlv_6= 'NewName' ( (lv_newName_7_0= ruleEString ) ) otherlv_8= '}' )
			// InternalDsl.g:2321:3: () otherlv_1= '{' otherlv_2= 'Type' ( (lv_type_3_0= ruleEString ) ) otherlv_4= 'Function' ( (lv_function_5_0= ruleEString ) ) otherlv_6= 'NewName' ( (lv_newName_7_0= ruleEString ) ) otherlv_8= '}'
			{
			// InternalDsl.g:2321:3: ()
			// InternalDsl.g:2322:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getRenameAccess().getRenameAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,109,FOLLOW_49); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getRenameAccess().getLeftCurlyBracketKeyword_1());
					}
			otherlv_2=(Token)match(input,73,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getRenameAccess().getTypeKeyword_2());
					}
			// InternalDsl.g:2336:3: ( (lv_type_3_0= ruleEString ) )
			// InternalDsl.g:2337:4: (lv_type_3_0= ruleEString )
			{
			// InternalDsl.g:2337:4: (lv_type_3_0= ruleEString )
			// InternalDsl.g:2338:5: lv_type_3_0= ruleEString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getRenameAccess().getTypeEStringParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_50);
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

			otherlv_4=(Token)match(input,59,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getRenameAccess().getFunctionKeyword_4());
					}
			// InternalDsl.g:2359:3: ( (lv_function_5_0= ruleEString ) )
			// InternalDsl.g:2360:4: (lv_function_5_0= ruleEString )
			{
			// InternalDsl.g:2360:4: (lv_function_5_0= ruleEString )
			// InternalDsl.g:2361:5: lv_function_5_0= ruleEString
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getRenameAccess().getFunctionEStringParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_51);
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

			otherlv_6=(Token)match(input,65,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getRenameAccess().getNewNameKeyword_6());
					}
			// InternalDsl.g:2382:3: ( (lv_newName_7_0= ruleEString ) )
			// InternalDsl.g:2383:4: (lv_newName_7_0= ruleEString )
			{
			// InternalDsl.g:2383:4: (lv_newName_7_0= ruleEString )
			// InternalDsl.g:2384:5: lv_newName_7_0= ruleEString
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

			otherlv_8=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:2409:1: entryRuleExpression returns [EObject current=null] :iv_ruleExpression= ruleExpression EOF ;
	public final EObject entryRuleExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleExpression =null;

		try {
			// InternalDsl.g:2409:51: (iv_ruleExpression= ruleExpression EOF )
			// InternalDsl.g:2410:2: iv_ruleExpression= ruleExpression EOF
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
	// InternalDsl.g:2416:1: ruleExpression returns [EObject current=null] :this_Foreach_0= ruleForeach ;
	public final EObject ruleExpression() throws RecognitionException {
		EObject current = null;


		EObject this_Foreach_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2422:2: (this_Foreach_0= ruleForeach )
			// InternalDsl.g:2423:2: this_Foreach_0= ruleForeach
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
	// InternalDsl.g:2434:1: entryRuleVariableOrMethodName returns [EObject current=null] :iv_ruleVariableOrMethodName= ruleVariableOrMethodName EOF ;
	public final EObject entryRuleVariableOrMethodName() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleVariableOrMethodName =null;

		try {
			// InternalDsl.g:2434:61: (iv_ruleVariableOrMethodName= ruleVariableOrMethodName EOF )
			// InternalDsl.g:2435:2: iv_ruleVariableOrMethodName= ruleVariableOrMethodName EOF
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
	// InternalDsl.g:2441:1: ruleVariableOrMethodName returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
	public final EObject ruleVariableOrMethodName() throws RecognitionException {
		EObject current = null;


		Token lv_name_0_0=null;


			enterRule();

		try {
			// InternalDsl.g:2447:2: ( ( (lv_name_0_0= RULE_ID ) ) )
			// InternalDsl.g:2448:2: ( (lv_name_0_0= RULE_ID ) )
			{
			// InternalDsl.g:2448:2: ( (lv_name_0_0= RULE_ID ) )
			// InternalDsl.g:2449:3: (lv_name_0_0= RULE_ID )
			{
			// InternalDsl.g:2449:3: (lv_name_0_0= RULE_ID )
			// InternalDsl.g:2450:4: lv_name_0_0= RULE_ID
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
	// InternalDsl.g:2469:1: entryRuleForeach returns [EObject current=null] :iv_ruleForeach= ruleForeach EOF ;
	public final EObject entryRuleForeach() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleForeach =null;

		try {
			// InternalDsl.g:2469:48: (iv_ruleForeach= ruleForeach EOF )
			// InternalDsl.g:2470:2: iv_ruleForeach= ruleForeach EOF
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
	// InternalDsl.g:2476:1: ruleForeach returns [EObject current=null] : (this_Exists_0= ruleExists | ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' ) ) ;
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
			// InternalDsl.g:2482:2: ( (this_Exists_0= ruleExists | ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' ) ) )
			// InternalDsl.g:2483:2: (this_Exists_0= ruleExists | ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' ) )
			{
			// InternalDsl.g:2483:2: (this_Exists_0= ruleExists | ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' ) )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( ((LA39_0 >= RULE_DECIMAL && LA39_0 <= RULE_INT)||(LA39_0 >= 22 && LA39_0 <= 23)||LA39_0==91||LA39_0==106) ) {
				alt39=1;
			}
			else if ( (LA39_0==24) ) {
				alt39=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// InternalDsl.g:2484:3: this_Exists_0= ruleExists
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
					// InternalDsl.g:2493:3: ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' )
					{
					// InternalDsl.g:2493:3: ( ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')' )
					// InternalDsl.g:2494:4: ( (lv_foreach_1_0= '(\\\\foreach' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleExists ) ) otherlv_6= ')'
					{
					// InternalDsl.g:2494:4: ( (lv_foreach_1_0= '(\\\\foreach' ) )
					// InternalDsl.g:2495:5: (lv_foreach_1_0= '(\\\\foreach' )
					{
					// InternalDsl.g:2495:5: (lv_foreach_1_0= '(\\\\foreach' )
					// InternalDsl.g:2496:6: lv_foreach_1_0= '(\\\\foreach'
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

					// InternalDsl.g:2508:4: ( (lv_type_2_0= ruleJvmTypeReference ) )
					// InternalDsl.g:2509:5: (lv_type_2_0= ruleJvmTypeReference )
					{
					// InternalDsl.g:2509:5: (lv_type_2_0= ruleJvmTypeReference )
					// InternalDsl.g:2510:6: lv_type_2_0= ruleJvmTypeReference
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

					// InternalDsl.g:2527:4: ( (lv_var_3_0= ruleVariableOrMethodName ) )
					// InternalDsl.g:2528:5: (lv_var_3_0= ruleVariableOrMethodName )
					{
					// InternalDsl.g:2528:5: (lv_var_3_0= ruleVariableOrMethodName )
					// InternalDsl.g:2529:6: lv_var_3_0= ruleVariableOrMethodName
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getForeachAccess().getVarVariableOrMethodNameParserRuleCall_1_2_0());
										}
					pushFollow(FOLLOW_32);
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
					// InternalDsl.g:2550:4: ( (lv_right_5_0= ruleExists ) )
					// InternalDsl.g:2551:5: (lv_right_5_0= ruleExists )
					{
					// InternalDsl.g:2551:5: (lv_right_5_0= ruleExists )
					// InternalDsl.g:2552:6: lv_right_5_0= ruleExists
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
	// InternalDsl.g:2578:1: entryRuleExists returns [EObject current=null] :iv_ruleExists= ruleExists EOF ;
	public final EObject entryRuleExists() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleExists =null;

		try {
			// InternalDsl.g:2578:47: (iv_ruleExists= ruleExists EOF )
			// InternalDsl.g:2579:2: iv_ruleExists= ruleExists EOF
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
	// InternalDsl.g:2585:1: ruleExists returns [EObject current=null] : (this_Relation_0= ruleRelation | ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' ) ) ;
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
			// InternalDsl.g:2591:2: ( (this_Relation_0= ruleRelation | ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' ) ) )
			// InternalDsl.g:2592:2: (this_Relation_0= ruleRelation | ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' ) )
			{
			// InternalDsl.g:2592:2: (this_Relation_0= ruleRelation | ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' ) )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( ((LA40_0 >= RULE_DECIMAL && LA40_0 <= RULE_INT)||LA40_0==22||LA40_0==91||LA40_0==106) ) {
				alt40=1;
			}
			else if ( (LA40_0==23) ) {
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
					// InternalDsl.g:2593:3: this_Relation_0= ruleRelation
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
					// InternalDsl.g:2602:3: ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' )
					{
					// InternalDsl.g:2602:3: ( ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')' )
					// InternalDsl.g:2603:4: ( (lv_exists_1_0= '(\\\\exists' ) ) ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_var_3_0= ruleVariableOrMethodName ) ) otherlv_4= ';' ( (lv_right_5_0= ruleRelation ) ) otherlv_6= ')'
					{
					// InternalDsl.g:2603:4: ( (lv_exists_1_0= '(\\\\exists' ) )
					// InternalDsl.g:2604:5: (lv_exists_1_0= '(\\\\exists' )
					{
					// InternalDsl.g:2604:5: (lv_exists_1_0= '(\\\\exists' )
					// InternalDsl.g:2605:6: lv_exists_1_0= '(\\\\exists'
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

					// InternalDsl.g:2617:4: ( (lv_type_2_0= ruleJvmTypeReference ) )
					// InternalDsl.g:2618:5: (lv_type_2_0= ruleJvmTypeReference )
					{
					// InternalDsl.g:2618:5: (lv_type_2_0= ruleJvmTypeReference )
					// InternalDsl.g:2619:6: lv_type_2_0= ruleJvmTypeReference
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

					// InternalDsl.g:2636:4: ( (lv_var_3_0= ruleVariableOrMethodName ) )
					// InternalDsl.g:2637:5: (lv_var_3_0= ruleVariableOrMethodName )
					{
					// InternalDsl.g:2637:5: (lv_var_3_0= ruleVariableOrMethodName )
					// InternalDsl.g:2638:6: lv_var_3_0= ruleVariableOrMethodName
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getExistsAccess().getVarVariableOrMethodNameParserRuleCall_1_2_0());
										}
					pushFollow(FOLLOW_32);
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
					// InternalDsl.g:2659:4: ( (lv_right_5_0= ruleRelation ) )
					// InternalDsl.g:2660:5: (lv_right_5_0= ruleRelation )
					{
					// InternalDsl.g:2660:5: (lv_right_5_0= ruleRelation )
					// InternalDsl.g:2661:6: lv_right_5_0= ruleRelation
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
	// InternalDsl.g:2687:1: entryRuleRelation returns [EObject current=null] :iv_ruleRelation= ruleRelation EOF ;
	public final EObject entryRuleRelation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleRelation =null;

		try {
			// InternalDsl.g:2687:49: (iv_ruleRelation= ruleRelation EOF )
			// InternalDsl.g:2688:2: iv_ruleRelation= ruleRelation EOF
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
	// InternalDsl.g:2694:1: ruleRelation returns [EObject current=null] : (this_Implication_0= ruleImplication ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )* ) ;
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
			// InternalDsl.g:2700:2: ( (this_Implication_0= ruleImplication ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )* ) )
			// InternalDsl.g:2701:2: (this_Implication_0= ruleImplication ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )* )
			{
			// InternalDsl.g:2701:2: (this_Implication_0= ruleImplication ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )* )
			// InternalDsl.g:2702:3: this_Implication_0= ruleImplication ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )*
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
			// InternalDsl.g:2710:3: ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) ) )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==42||(LA42_0 >= 44 && LA42_0 <= 45)||(LA42_0 >= 47 && LA42_0 <= 48)) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// InternalDsl.g:2711:4: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) ) ( (lv_right_11_0= ruleImplication ) )
					{
					// InternalDsl.g:2711:4: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '>' ) | ( () otherlv_6= '=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) )
					int alt41=5;
					switch ( input.LA(1) ) {
					case 42:
						{
						alt41=1;
						}
						break;
					case 47:
						{
						alt41=2;
						}
						break;
					case 45:
						{
						alt41=3;
						}
						break;
					case 44:
						{
						alt41=4;
						}
						break;
					case 48:
						{
						alt41=5;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 41, 0, input);
						throw nvae;
					}
					switch (alt41) {
						case 1 :
							// InternalDsl.g:2712:5: ( () otherlv_2= '<' )
							{
							// InternalDsl.g:2712:5: ( () otherlv_2= '<' )
							// InternalDsl.g:2713:6: () otherlv_2= '<'
							{
							// InternalDsl.g:2713:6: ()
							// InternalDsl.g:2714:7: 
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
							// InternalDsl.g:2726:5: ( () otherlv_4= '>' )
							{
							// InternalDsl.g:2726:5: ( () otherlv_4= '>' )
							// InternalDsl.g:2727:6: () otherlv_4= '>'
							{
							// InternalDsl.g:2727:6: ()
							// InternalDsl.g:2728:7: 
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
							// InternalDsl.g:2740:5: ( () otherlv_6= '=' )
							{
							// InternalDsl.g:2740:5: ( () otherlv_6= '=' )
							// InternalDsl.g:2741:6: () otherlv_6= '='
							{
							// InternalDsl.g:2741:6: ()
							// InternalDsl.g:2742:7: 
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
							// InternalDsl.g:2754:5: ( () otherlv_8= '<=' )
							{
							// InternalDsl.g:2754:5: ( () otherlv_8= '<=' )
							// InternalDsl.g:2755:6: () otherlv_8= '<='
							{
							// InternalDsl.g:2755:6: ()
							// InternalDsl.g:2756:7: 
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
							// InternalDsl.g:2768:5: ( () otherlv_10= '>=' )
							{
							// InternalDsl.g:2768:5: ( () otherlv_10= '>=' )
							// InternalDsl.g:2769:6: () otherlv_10= '>='
							{
							// InternalDsl.g:2769:6: ()
							// InternalDsl.g:2770:7: 
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

					// InternalDsl.g:2782:4: ( (lv_right_11_0= ruleImplication ) )
					// InternalDsl.g:2783:5: (lv_right_11_0= ruleImplication )
					{
					// InternalDsl.g:2783:5: (lv_right_11_0= ruleImplication )
					// InternalDsl.g:2784:6: lv_right_11_0= ruleImplication
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
					break loop42;
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
	// InternalDsl.g:2806:1: entryRuleImplication returns [EObject current=null] :iv_ruleImplication= ruleImplication EOF ;
	public final EObject entryRuleImplication() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleImplication =null;

		try {
			// InternalDsl.g:2806:52: (iv_ruleImplication= ruleImplication EOF )
			// InternalDsl.g:2807:2: iv_ruleImplication= ruleImplication EOF
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
	// InternalDsl.g:2813:1: ruleImplication returns [EObject current=null] : (this_Concat_0= ruleConcat ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )* ) ;
	public final EObject ruleImplication() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject this_Concat_0 =null;
		EObject lv_right_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2819:2: ( (this_Concat_0= ruleConcat ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )* ) )
			// InternalDsl.g:2820:2: (this_Concat_0= ruleConcat ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )* )
			{
			// InternalDsl.g:2820:2: (this_Concat_0= ruleConcat ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )* )
			// InternalDsl.g:2821:3: this_Concat_0= ruleConcat ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )*
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
			// InternalDsl.g:2829:3: ( ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) ) )*
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0==35) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// InternalDsl.g:2830:4: ( () otherlv_2= '->' ) ( (lv_right_3_0= ruleConcat ) )
					{
					// InternalDsl.g:2830:4: ( () otherlv_2= '->' )
					// InternalDsl.g:2831:5: () otherlv_2= '->'
					{
					// InternalDsl.g:2831:5: ()
					// InternalDsl.g:2832:6: 
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

					// InternalDsl.g:2843:4: ( (lv_right_3_0= ruleConcat ) )
					// InternalDsl.g:2844:5: (lv_right_3_0= ruleConcat )
					{
					// InternalDsl.g:2844:5: (lv_right_3_0= ruleConcat )
					// InternalDsl.g:2845:6: lv_right_3_0= ruleConcat
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
	// $ANTLR end "ruleImplication"



	// $ANTLR start "entryRuleConcat"
	// InternalDsl.g:2867:1: entryRuleConcat returns [EObject current=null] :iv_ruleConcat= ruleConcat EOF ;
	public final EObject entryRuleConcat() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleConcat =null;

		try {
			// InternalDsl.g:2867:47: (iv_ruleConcat= ruleConcat EOF )
			// InternalDsl.g:2868:2: iv_ruleConcat= ruleConcat EOF
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
	// InternalDsl.g:2874:1: ruleConcat returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) ;
	public final EObject ruleConcat() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject this_PrimaryExpression_0 =null;
		EObject lv_right_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:2880:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) )
			// InternalDsl.g:2881:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
			{
			// InternalDsl.g:2881:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
			// InternalDsl.g:2882:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
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
			// InternalDsl.g:2890:3: ( ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
			loop45:
			while (true) {
				int alt45=2;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==20||LA45_0==110) ) {
					alt45=1;
				}

				switch (alt45) {
				case 1 :
					// InternalDsl.g:2891:4: ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) ) ( (lv_right_5_0= rulePrimaryExpression ) )
					{
					// InternalDsl.g:2891:4: ( ( () otherlv_2= '&' ) | ( () otherlv_4= '|' ) )
					int alt44=2;
					int LA44_0 = input.LA(1);
					if ( (LA44_0==20) ) {
						alt44=1;
					}
					else if ( (LA44_0==110) ) {
						alt44=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 44, 0, input);
						throw nvae;
					}

					switch (alt44) {
						case 1 :
							// InternalDsl.g:2892:5: ( () otherlv_2= '&' )
							{
							// InternalDsl.g:2892:5: ( () otherlv_2= '&' )
							// InternalDsl.g:2893:6: () otherlv_2= '&'
							{
							// InternalDsl.g:2893:6: ()
							// InternalDsl.g:2894:7: 
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
							// InternalDsl.g:2906:5: ( () otherlv_4= '|' )
							{
							// InternalDsl.g:2906:5: ( () otherlv_4= '|' )
							// InternalDsl.g:2907:6: () otherlv_4= '|'
							{
							// InternalDsl.g:2907:6: ()
							// InternalDsl.g:2908:7: 
							{
							if ( state.backtracking==0 ) {
														current = forceCreateModelElementAndSet(
															grammarAccess.getConcatAccess().getOrLeftAction_1_0_1_0(),
															current);
													}
							}

							otherlv_4=(Token)match(input,110,FOLLOW_53); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_4, grammarAccess.getConcatAccess().getVerticalLineKeyword_1_0_1_1());
												}
							}

							}
							break;

					}

					// InternalDsl.g:2920:4: ( (lv_right_5_0= rulePrimaryExpression ) )
					// InternalDsl.g:2921:5: (lv_right_5_0= rulePrimaryExpression )
					{
					// InternalDsl.g:2921:5: (lv_right_5_0= rulePrimaryExpression )
					// InternalDsl.g:2922:6: lv_right_5_0= rulePrimaryExpression
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
					break loop45;
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
	// InternalDsl.g:2944:1: entryRulePrimaryExpression returns [EObject current=null] :iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
	public final EObject entryRulePrimaryExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_rulePrimaryExpression =null;

		try {
			// InternalDsl.g:2944:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
			// InternalDsl.g:2945:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
	// InternalDsl.g:2951:1: rulePrimaryExpression returns [EObject current=null] : ( ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ) | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? ) | ( () ruleNumber ) ) ;
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
			// InternalDsl.g:2957:2: ( ( ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ) | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? ) | ( () ruleNumber ) ) )
			// InternalDsl.g:2958:2: ( ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ) | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? ) | ( () ruleNumber ) )
			{
			// InternalDsl.g:2958:2: ( ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ) | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? ) | ( () ruleNumber ) )
			int alt50=4;
			switch ( input.LA(1) ) {
			case 91:
			case 106:
				{
				alt50=1;
				}
				break;
			case 22:
				{
				alt50=2;
				}
				break;
			case RULE_ID:
				{
				alt50=3;
				}
				break;
			case RULE_DECIMAL:
			case RULE_HEX:
			case RULE_INT:
				{
				alt50=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 50, 0, input);
				throw nvae;
			}
			switch (alt50) {
				case 1 :
					// InternalDsl.g:2959:3: ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
					{
					// InternalDsl.g:2959:3: ( () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
					// InternalDsl.g:2960:4: () ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
					{
					// InternalDsl.g:2960:4: ()
					// InternalDsl.g:2961:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getPrimaryExpressionAccess().getExpressionAction_0_0(),
											current);
									}
					}

					// InternalDsl.g:2967:4: ( ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
					// InternalDsl.g:2968:5: ( ( 'false' | ( ( 'true' ) ) ) )=> (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
					{
					// InternalDsl.g:2978:5: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
					int alt46=2;
					int LA46_0 = input.LA(1);
					if ( (LA46_0==91) ) {
						alt46=1;
					}
					else if ( (LA46_0==106) ) {
						alt46=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 46, 0, input);
						throw nvae;
					}

					switch (alt46) {
						case 1 :
							// InternalDsl.g:2979:6: otherlv_1= 'false'
							{
							otherlv_1=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getFalseKeyword_0_1_0_0());
												}
							}
							break;
						case 2 :
							// InternalDsl.g:2984:6: ( (lv_isTrue_2_0= 'true' ) )
							{
							// InternalDsl.g:2984:6: ( (lv_isTrue_2_0= 'true' ) )
							// InternalDsl.g:2985:7: (lv_isTrue_2_0= 'true' )
							{
							// InternalDsl.g:2985:7: (lv_isTrue_2_0= 'true' )
							// InternalDsl.g:2986:8: lv_isTrue_2_0= 'true'
							{
							lv_isTrue_2_0=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(lv_isTrue_2_0, grammarAccess.getPrimaryExpressionAccess().getIsTrueTrueKeyword_0_1_0_1_0());
														}
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElement(grammarAccess.getPrimaryExpressionRule());
															}
															setWithLastConsumed(current, "isTrue", true, "true");
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
					// InternalDsl.g:3002:3: (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' )
					{
					// InternalDsl.g:3002:3: (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' )
					// InternalDsl.g:3003:4: otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')'
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
					// InternalDsl.g:3021:3: ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? )
					{
					// InternalDsl.g:3021:3: ( () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )? )
					// InternalDsl.g:3022:4: () ( (lv_func_7_0= ruleVariableOrMethodName ) ) (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )?
					{
					// InternalDsl.g:3022:4: ()
					// InternalDsl.g:3023:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getPrimaryExpressionAccess().getFunctionCallAction_2_0(),
											current);
									}
					}

					// InternalDsl.g:3029:4: ( (lv_func_7_0= ruleVariableOrMethodName ) )
					// InternalDsl.g:3030:5: (lv_func_7_0= ruleVariableOrMethodName )
					{
					// InternalDsl.g:3030:5: (lv_func_7_0= ruleVariableOrMethodName )
					// InternalDsl.g:3031:6: lv_func_7_0= ruleVariableOrMethodName
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

					// InternalDsl.g:3048:4: (otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')' )?
					int alt49=2;
					int LA49_0 = input.LA(1);
					if ( (LA49_0==22) ) {
						alt49=1;
					}
					switch (alt49) {
						case 1 :
							// InternalDsl.g:3049:5: otherlv_8= '(' ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )? otherlv_12= ')'
							{
							otherlv_8=(Token)match(input,22,FOLLOW_58); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_8, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_2_0());
											}
							// InternalDsl.g:3053:5: ( ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )* )?
							int alt48=2;
							int LA48_0 = input.LA(1);
							if ( ((LA48_0 >= RULE_DECIMAL && LA48_0 <= RULE_INT)||(LA48_0 >= 22 && LA48_0 <= 24)||LA48_0==91||LA48_0==106) ) {
								alt48=1;
							}
							switch (alt48) {
								case 1 :
									// InternalDsl.g:3054:6: ( (lv_args_9_0= ruleExpression ) ) (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )*
									{
									// InternalDsl.g:3054:6: ( (lv_args_9_0= ruleExpression ) )
									// InternalDsl.g:3055:7: (lv_args_9_0= ruleExpression )
									{
									// InternalDsl.g:3055:7: (lv_args_9_0= ruleExpression )
									// InternalDsl.g:3056:8: lv_args_9_0= ruleExpression
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

									// InternalDsl.g:3073:6: (otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) ) )*
									loop47:
									while (true) {
										int alt47=2;
										int LA47_0 = input.LA(1);
										if ( (LA47_0==31) ) {
											alt47=1;
										}

										switch (alt47) {
										case 1 :
											// InternalDsl.g:3074:7: otherlv_10= ',' ( (lv_args_11_0= ruleExpression ) )
											{
											otherlv_10=(Token)match(input,31,FOLLOW_7); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																		newLeafNode(otherlv_10, grammarAccess.getPrimaryExpressionAccess().getCommaKeyword_2_2_1_1_0());
																	}
											// InternalDsl.g:3078:7: ( (lv_args_11_0= ruleExpression ) )
											// InternalDsl.g:3079:8: (lv_args_11_0= ruleExpression )
											{
											// InternalDsl.g:3079:8: (lv_args_11_0= ruleExpression )
											// InternalDsl.g:3080:9: lv_args_11_0= ruleExpression
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
											break loop47;
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
					// InternalDsl.g:3106:3: ( () ruleNumber )
					{
					// InternalDsl.g:3106:3: ( () ruleNumber )
					// InternalDsl.g:3107:4: () ruleNumber
					{
					// InternalDsl.g:3107:4: ()
					// InternalDsl.g:3108:5: 
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
	// InternalDsl.g:3126:1: entryRuleXJStatementOrBlock returns [EObject current=null] :iv_ruleXJStatementOrBlock= ruleXJStatementOrBlock EOF ;
	public final EObject entryRuleXJStatementOrBlock() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJStatementOrBlock =null;

		try {
			// InternalDsl.g:3126:59: (iv_ruleXJStatementOrBlock= ruleXJStatementOrBlock EOF )
			// InternalDsl.g:3127:2: iv_ruleXJStatementOrBlock= ruleXJStatementOrBlock EOF
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
	// InternalDsl.g:3133:1: ruleXJStatementOrBlock returns [EObject current=null] : ( ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression ) |this_XJSingleStatement_1= ruleXJSingleStatement ) ;
	public final EObject ruleXJStatementOrBlock() throws RecognitionException {
		EObject current = null;


		EObject this_XBlockExpression_0 =null;
		EObject this_XJSingleStatement_1 =null;


			enterRule();

		try {
			// InternalDsl.g:3139:2: ( ( ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression ) |this_XJSingleStatement_1= ruleXJSingleStatement ) )
			// InternalDsl.g:3140:2: ( ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression ) |this_XJSingleStatement_1= ruleXJSingleStatement )
			{
			// InternalDsl.g:3140:2: ( ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression ) |this_XJSingleStatement_1= ruleXJSingleStatement )
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==109) ) {
				int LA51_1 = input.LA(2);
				if ( (synpred2_InternalDsl()) ) {
					alt51=1;
				}
				else if ( (true) ) {
					alt51=2;
				}

			}
			else if ( ((LA51_0 >= RULE_CHARACTER && LA51_0 <= RULE_INT)||LA51_0==RULE_STRING||LA51_0==14||LA51_0==22||(LA51_0 >= 28 && LA51_0 <= 29)||(LA51_0 >= 32 && LA51_0 <= 33)||LA51_0==41||LA51_0==81||LA51_0==85||LA51_0==87||(LA51_0 >= 89 && LA51_0 <= 92)||(LA51_0 >= 94 && LA51_0 <= 96)||(LA51_0 >= 98 && LA51_0 <= 108)||LA51_0==114) ) {
				alt51=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 51, 0, input);
				throw nvae;
			}

			switch (alt51) {
				case 1 :
					// InternalDsl.g:3141:3: ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression )
					{
					// InternalDsl.g:3141:3: ( ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression )
					// InternalDsl.g:3142:4: ( ruleXBlockExpression )=>this_XBlockExpression_0= ruleXBlockExpression
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
					// InternalDsl.g:3153:3: this_XJSingleStatement_1= ruleXJSingleStatement
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
	// InternalDsl.g:3165:1: entryRuleXImportDeclaration returns [EObject current=null] :iv_ruleXImportDeclaration= ruleXImportDeclaration EOF ;
	public final EObject entryRuleXImportDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXImportDeclaration =null;

		try {
			// InternalDsl.g:3165:59: (iv_ruleXImportDeclaration= ruleXImportDeclaration EOF )
			// InternalDsl.g:3166:2: iv_ruleXImportDeclaration= ruleXImportDeclaration EOF
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
	// InternalDsl.g:3172:1: ruleXImportDeclaration returns [EObject current=null] : ( ( ( 'import' )=>otherlv_0= 'import' ) ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) ) ( ( ';' )=>otherlv_7= ';' )* ) ;
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
			// InternalDsl.g:3178:2: ( ( ( ( 'import' )=>otherlv_0= 'import' ) ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) ) ( ( ';' )=>otherlv_7= ';' )* ) )
			// InternalDsl.g:3179:2: ( ( ( 'import' )=>otherlv_0= 'import' ) ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) ) ( ( ';' )=>otherlv_7= ';' )* )
			{
			// InternalDsl.g:3179:2: ( ( ( 'import' )=>otherlv_0= 'import' ) ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) ) ( ( ';' )=>otherlv_7= ';' )* )
			// InternalDsl.g:3180:3: ( ( 'import' )=>otherlv_0= 'import' ) ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) ) ( ( ';' )=>otherlv_7= ';' )*
			{
			// InternalDsl.g:3180:3: ( ( 'import' )=>otherlv_0= 'import' )
			// InternalDsl.g:3181:4: ( 'import' )=>otherlv_0= 'import'
			{
			otherlv_0=(Token)match(input,96,FOLLOW_59); if (state.failed) return current;
			if ( state.backtracking==0 ) {
							newLeafNode(otherlv_0, grammarAccess.getXImportDeclarationAccess().getImportKeyword_0());
						}
			}

			// InternalDsl.g:3187:3: ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) )
			int alt53=3;
			alt53 = dfa53.predict(input);
			switch (alt53) {
				case 1 :
					// InternalDsl.g:3188:4: ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) )
					{
					// InternalDsl.g:3188:4: ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) )
					// InternalDsl.g:3189:5: ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) )
					{
					// InternalDsl.g:3189:5: ( (lv_static_1_0= 'static' ) )
					// InternalDsl.g:3190:6: (lv_static_1_0= 'static' )
					{
					// InternalDsl.g:3190:6: (lv_static_1_0= 'static' )
					// InternalDsl.g:3191:7: lv_static_1_0= 'static'
					{
					lv_static_1_0=(Token)match(input,101,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(lv_static_1_0, grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0());
											}
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXImportDeclarationRule());
												}
												setWithLastConsumed(current, "static", true, "static");
											}
					}

					}

					// InternalDsl.g:3203:5: ( ( ruleQualifiedNameInStaticImport ) )
					// InternalDsl.g:3204:6: ( ruleQualifiedNameInStaticImport )
					{
					// InternalDsl.g:3204:6: ( ruleQualifiedNameInStaticImport )
					// InternalDsl.g:3205:7: ruleQualifiedNameInStaticImport
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

					// InternalDsl.g:3219:5: ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) )
					int alt52=2;
					int LA52_0 = input.LA(1);
					if ( (LA52_0==26) ) {
						alt52=1;
					}
					else if ( (LA52_0==RULE_ID) ) {
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
							// InternalDsl.g:3220:6: ( (lv_wildcard_3_0= '*' ) )
							{
							// InternalDsl.g:3220:6: ( (lv_wildcard_3_0= '*' ) )
							// InternalDsl.g:3221:7: (lv_wildcard_3_0= '*' )
							{
							// InternalDsl.g:3221:7: (lv_wildcard_3_0= '*' )
							// InternalDsl.g:3222:8: lv_wildcard_3_0= '*'
							{
							lv_wildcard_3_0=(Token)match(input,26,FOLLOW_61); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(lv_wildcard_3_0, grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_2_0_0());
														}
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElement(grammarAccess.getXImportDeclarationRule());
															}
															setWithLastConsumed(current, "wildcard", true, "*");
														}
							}

							}

							}
							break;
						case 2 :
							// InternalDsl.g:3235:6: ( (lv_memberName_4_0= ruleValidID ) )
							{
							// InternalDsl.g:3235:6: ( (lv_memberName_4_0= ruleValidID ) )
							// InternalDsl.g:3236:7: (lv_memberName_4_0= ruleValidID )
							{
							// InternalDsl.g:3236:7: (lv_memberName_4_0= ruleValidID )
							// InternalDsl.g:3237:8: lv_memberName_4_0= ruleValidID
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
					// InternalDsl.g:3257:4: ( ( ruleQualifiedName ) )
					{
					// InternalDsl.g:3257:4: ( ( ruleQualifiedName ) )
					// InternalDsl.g:3258:5: ( ruleQualifiedName )
					{
					// InternalDsl.g:3258:5: ( ruleQualifiedName )
					// InternalDsl.g:3259:6: ruleQualifiedName
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
					// InternalDsl.g:3274:4: ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) )
					{
					// InternalDsl.g:3274:4: ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) )
					// InternalDsl.g:3275:5: (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard )
					{
					// InternalDsl.g:3275:5: (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard )
					// InternalDsl.g:3276:6: lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard
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

			// InternalDsl.g:3294:3: ( ( ';' )=>otherlv_7= ';' )*
			loop54:
			while (true) {
				int alt54=2;
				int LA54_0 = input.LA(1);
				if ( (LA54_0==41) && (synpred4_InternalDsl())) {
					alt54=1;
				}

				switch (alt54) {
				case 1 :
					// InternalDsl.g:3295:4: ( ';' )=>otherlv_7= ';'
					{
					otherlv_7=(Token)match(input,41,FOLLOW_61); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_7, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
								}
					}
					break;

				default :
					break loop54;
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
	// InternalDsl.g:3305:1: entryRuleJvmTypeReference returns [EObject current=null] :iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
	public final EObject entryRuleJvmTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmTypeReference =null;

		try {
			// InternalDsl.g:3305:57: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
			// InternalDsl.g:3306:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
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
	// InternalDsl.g:3312:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) ;
	public final EObject ruleJvmTypeReference() throws RecognitionException {
		EObject current = null;


		EObject this_JvmParameterizedTypeReference_0 =null;


			enterRule();

		try {
			// InternalDsl.g:3318:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) )
			// InternalDsl.g:3319:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
			{
			// InternalDsl.g:3319:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
			// InternalDsl.g:3320:3: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
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
			// InternalDsl.g:3328:3: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
			loop55:
			while (true) {
				int alt55=2;
				int LA55_0 = input.LA(1);
				if ( (LA55_0==77) ) {
					int LA55_2 = input.LA(2);
					if ( (LA55_2==78) ) {
						int LA55_3 = input.LA(3);
						if ( (synpred5_InternalDsl()) ) {
							alt55=1;
						}

					}

				}

				switch (alt55) {
				case 1 :
					// InternalDsl.g:3329:4: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
					{
					// InternalDsl.g:3335:4: ( () ruleArrayBrackets )
					// InternalDsl.g:3336:5: () ruleArrayBrackets
					{
					// InternalDsl.g:3336:5: ()
					// InternalDsl.g:3337:6: 
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
	// $ANTLR end "ruleJvmTypeReference"



	// $ANTLR start "entryRuleFullJvmFormalParameter"
	// InternalDsl.g:3356:1: entryRuleFullJvmFormalParameter returns [EObject current=null] :iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
	public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleFullJvmFormalParameter =null;

		try {
			// InternalDsl.g:3356:63: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
			// InternalDsl.g:3357:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
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
	// InternalDsl.g:3363:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( () ( (lv_final_1_0= 'final' ) )? ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ( (lv_varArgs_3_0= '...' ) )? ( (lv_name_4_0= ruleValidID ) ) ) ;
	public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		Token lv_final_1_0=null;
		Token lv_varArgs_3_0=null;
		EObject lv_parameterType_2_0 =null;
		AntlrDatatypeRuleToken lv_name_4_0 =null;


			enterRule();

		try {
			// InternalDsl.g:3369:2: ( ( () ( (lv_final_1_0= 'final' ) )? ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ( (lv_varArgs_3_0= '...' ) )? ( (lv_name_4_0= ruleValidID ) ) ) )
			// InternalDsl.g:3370:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ( (lv_varArgs_3_0= '...' ) )? ( (lv_name_4_0= ruleValidID ) ) )
			{
			// InternalDsl.g:3370:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ( (lv_varArgs_3_0= '...' ) )? ( (lv_name_4_0= ruleValidID ) ) )
			// InternalDsl.g:3371:3: () ( (lv_final_1_0= 'final' ) )? ( (lv_parameterType_2_0= ruleJvmTypeReference ) ) ( (lv_varArgs_3_0= '...' ) )? ( (lv_name_4_0= ruleValidID ) )
			{
			// InternalDsl.g:3371:3: ()
			// InternalDsl.g:3372:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getFullJvmFormalParameterAccess().getXJJvmFormalParameterAction_0(),
								current);
						}
			}

			// InternalDsl.g:3378:3: ( (lv_final_1_0= 'final' ) )?
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==92) ) {
				alt56=1;
			}
			switch (alt56) {
				case 1 :
					// InternalDsl.g:3379:4: (lv_final_1_0= 'final' )
					{
					// InternalDsl.g:3379:4: (lv_final_1_0= 'final' )
					// InternalDsl.g:3380:5: lv_final_1_0= 'final'
					{
					lv_final_1_0=(Token)match(input,92,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(lv_final_1_0, grammarAccess.getFullJvmFormalParameterAccess().getFinalFinalKeyword_1_0());
									}
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getFullJvmFormalParameterRule());
										}
										setWithLastConsumed(current, "final", true, "final");
									}
					}

					}
					break;

			}

			// InternalDsl.g:3392:3: ( (lv_parameterType_2_0= ruleJvmTypeReference ) )
			// InternalDsl.g:3393:4: (lv_parameterType_2_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:3393:4: (lv_parameterType_2_0= ruleJvmTypeReference )
			// InternalDsl.g:3394:5: lv_parameterType_2_0= ruleJvmTypeReference
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

			// InternalDsl.g:3411:3: ( (lv_varArgs_3_0= '...' ) )?
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==37) ) {
				alt57=1;
			}
			switch (alt57) {
				case 1 :
					// InternalDsl.g:3412:4: (lv_varArgs_3_0= '...' )
					{
					// InternalDsl.g:3412:4: (lv_varArgs_3_0= '...' )
					// InternalDsl.g:3413:5: lv_varArgs_3_0= '...'
					{
					lv_varArgs_3_0=(Token)match(input,37,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(lv_varArgs_3_0, grammarAccess.getFullJvmFormalParameterAccess().getVarArgsFullStopFullStopFullStopKeyword_3_0());
									}
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getFullJvmFormalParameterRule());
										}
										setWithLastConsumed(current, "varArgs", true, "...");
									}
					}

					}
					break;

			}

			// InternalDsl.g:3425:3: ( (lv_name_4_0= ruleValidID ) )
			// InternalDsl.g:3426:4: (lv_name_4_0= ruleValidID )
			{
			// InternalDsl.g:3426:4: (lv_name_4_0= ruleValidID )
			// InternalDsl.g:3427:5: lv_name_4_0= ruleValidID
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
	// InternalDsl.g:3448:1: entryRuleXJSingleStatement returns [EObject current=null] :iv_ruleXJSingleStatement= ruleXJSingleStatement EOF ;
	public final EObject entryRuleXJSingleStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJSingleStatement =null;

		try {
			// InternalDsl.g:3448:58: (iv_ruleXJSingleStatement= ruleXJSingleStatement EOF )
			// InternalDsl.g:3449:2: iv_ruleXJSingleStatement= ruleXJSingleStatement EOF
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
	// InternalDsl.g:3455:1: ruleXJSingleStatement returns [EObject current=null] : (this_XJSemicolonStatement_0= ruleXJSemicolonStatement |this_XSwitchExpression_1= ruleXSwitchExpression |this_XIfExpression_2= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression ) |this_XBasicForLoopExpression_4= ruleXBasicForLoopExpression |this_XWhileExpression_5= ruleXWhileExpression | ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement ) |this_XTryCatchFinallyExpression_7= ruleXTryCatchFinallyExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression ) |this_XJEmptyStatement_9= ruleXJEmptyStatement ) ;
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
			// InternalDsl.g:3461:2: ( (this_XJSemicolonStatement_0= ruleXJSemicolonStatement |this_XSwitchExpression_1= ruleXSwitchExpression |this_XIfExpression_2= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression ) |this_XBasicForLoopExpression_4= ruleXBasicForLoopExpression |this_XWhileExpression_5= ruleXWhileExpression | ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement ) |this_XTryCatchFinallyExpression_7= ruleXTryCatchFinallyExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression ) |this_XJEmptyStatement_9= ruleXJEmptyStatement ) )
			// InternalDsl.g:3462:2: (this_XJSemicolonStatement_0= ruleXJSemicolonStatement |this_XSwitchExpression_1= ruleXSwitchExpression |this_XIfExpression_2= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression ) |this_XBasicForLoopExpression_4= ruleXBasicForLoopExpression |this_XWhileExpression_5= ruleXWhileExpression | ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement ) |this_XTryCatchFinallyExpression_7= ruleXTryCatchFinallyExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression ) |this_XJEmptyStatement_9= ruleXJEmptyStatement )
			{
			// InternalDsl.g:3462:2: (this_XJSemicolonStatement_0= ruleXJSemicolonStatement |this_XSwitchExpression_1= ruleXSwitchExpression |this_XIfExpression_2= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression ) |this_XBasicForLoopExpression_4= ruleXBasicForLoopExpression |this_XWhileExpression_5= ruleXWhileExpression | ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement ) |this_XTryCatchFinallyExpression_7= ruleXTryCatchFinallyExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression ) |this_XJEmptyStatement_9= ruleXJEmptyStatement )
			int alt58=10;
			int LA58_0 = input.LA(1);
			if ( ((LA58_0 >= RULE_CHARACTER && LA58_0 <= RULE_INT)||LA58_0==RULE_STRING||LA58_0==14||LA58_0==22||(LA58_0 >= 28 && LA58_0 <= 29)||(LA58_0 >= 32 && LA58_0 <= 33)||LA58_0==81||LA58_0==85||LA58_0==87||(LA58_0 >= 89 && LA58_0 <= 92)||LA58_0==96||(LA58_0 >= 98 && LA58_0 <= 102)||(LA58_0 >= 105 && LA58_0 <= 106)||LA58_0==109||LA58_0==114) ) {
				alt58=1;
			}
			else if ( (LA58_0==103) ) {
				alt58=2;
			}
			else if ( (LA58_0==95) ) {
				alt58=3;
			}
			else if ( (LA58_0==94) ) {
				int LA58_32 = input.LA(2);
				if ( (synpred6_InternalDsl()) ) {
					alt58=4;
				}
				else if ( (true) ) {
					alt58=5;
				}

			}
			else if ( (LA58_0==108) ) {
				alt58=6;
			}
			else if ( (LA58_0==107) ) {
				int LA58_34 = input.LA(2);
				if ( (synpred7_InternalDsl()) ) {
					alt58=7;
				}
				else if ( (true) ) {
					alt58=8;
				}

			}
			else if ( (LA58_0==104) && (synpred8_InternalDsl())) {
				alt58=9;
			}
			else if ( (LA58_0==41) ) {
				alt58=10;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 58, 0, input);
				throw nvae;
			}

			switch (alt58) {
				case 1 :
					// InternalDsl.g:3463:3: this_XJSemicolonStatement_0= ruleXJSemicolonStatement
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
					// InternalDsl.g:3472:3: this_XSwitchExpression_1= ruleXSwitchExpression
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
					// InternalDsl.g:3481:3: this_XIfExpression_2= ruleXIfExpression
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
					// InternalDsl.g:3490:3: ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression )
					{
					// InternalDsl.g:3490:3: ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression )
					// InternalDsl.g:3491:4: ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_3= ruleXForLoopExpression
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
					// InternalDsl.g:3514:3: this_XBasicForLoopExpression_4= ruleXBasicForLoopExpression
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
					// InternalDsl.g:3523:3: this_XWhileExpression_5= ruleXWhileExpression
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
					// InternalDsl.g:3532:3: ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement )
					{
					// InternalDsl.g:3532:3: ( ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement )
					// InternalDsl.g:3533:4: ( ( () 'try' ( ( '(' ) ) ) )=>this_XJTryWithResourcesStatement_6= ruleXJTryWithResourcesStatement
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
					// InternalDsl.g:3554:3: this_XTryCatchFinallyExpression_7= ruleXTryCatchFinallyExpression
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
					// InternalDsl.g:3563:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression )
					{
					// InternalDsl.g:3563:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression )
					// InternalDsl.g:3564:4: ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_8= ruleXSynchronizedExpression
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
					// InternalDsl.g:3581:3: this_XJEmptyStatement_9= ruleXJEmptyStatement
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
	// InternalDsl.g:3593:1: entryRuleXJSemicolonStatement returns [EObject current=null] :iv_ruleXJSemicolonStatement= ruleXJSemicolonStatement EOF ;
	public final EObject entryRuleXJSemicolonStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJSemicolonStatement =null;

		try {
			// InternalDsl.g:3593:61: (iv_ruleXJSemicolonStatement= ruleXJSemicolonStatement EOF )
			// InternalDsl.g:3594:2: iv_ruleXJSemicolonStatement= ruleXJSemicolonStatement EOF
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
	// InternalDsl.g:3600:1: ruleXJSemicolonStatement returns [EObject current=null] : ( () ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) ) ( ( ';' )=> (lv_semicolon_2_0= ';' ) )? ) ;
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
			// InternalDsl.g:3606:2: ( ( () ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) ) ( ( ';' )=> (lv_semicolon_2_0= ';' ) )? ) )
			// InternalDsl.g:3607:2: ( () ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) ) ( ( ';' )=> (lv_semicolon_2_0= ';' ) )? )
			{
			// InternalDsl.g:3607:2: ( () ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) ) ( ( ';' )=> (lv_semicolon_2_0= ';' ) )? )
			// InternalDsl.g:3608:3: () ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) ) ( ( ';' )=> (lv_semicolon_2_0= ';' ) )?
			{
			// InternalDsl.g:3608:3: ()
			// InternalDsl.g:3609:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJSemicolonStatementAccess().getXJSemicolonStatementAction_0(),
								current);
						}
			}

			// InternalDsl.g:3615:3: ( ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) ) )
			// InternalDsl.g:3616:4: ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) )
			{
			// InternalDsl.g:3616:4: ( (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression ) )
			// InternalDsl.g:3617:5: (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression )
			{
			// InternalDsl.g:3617:5: (lv_expression_1_1= ruleXJBranchingStatement |lv_expression_1_2= ruleXExpressionOrVarDeclaration |lv_expression_1_3= ruleXDoWhileExpression |lv_expression_1_4= ruleXReturnExpression |lv_expression_1_5= ruleXThrowExpression )
			int alt59=5;
			switch ( input.LA(1) ) {
			case 81:
			case 85:
				{
				alt59=1;
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
			case 89:
			case 90:
			case 91:
			case 92:
			case 96:
			case 98:
			case 99:
			case 101:
			case 102:
			case 106:
			case 109:
			case 114:
				{
				alt59=2;
				}
				break;
			case 87:
				{
				alt59=3;
				}
				break;
			case 100:
				{
				alt59=4;
				}
				break;
			case 105:
				{
				alt59=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				throw nvae;
			}
			switch (alt59) {
				case 1 :
					// InternalDsl.g:3618:6: lv_expression_1_1= ruleXJBranchingStatement
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
					// InternalDsl.g:3634:6: lv_expression_1_2= ruleXExpressionOrVarDeclaration
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
					// InternalDsl.g:3650:6: lv_expression_1_3= ruleXDoWhileExpression
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
					// InternalDsl.g:3666:6: lv_expression_1_4= ruleXReturnExpression
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
					// InternalDsl.g:3682:6: lv_expression_1_5= ruleXThrowExpression
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

			// InternalDsl.g:3700:3: ( ( ';' )=> (lv_semicolon_2_0= ';' ) )?
			int alt60=2;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==41) ) {
				int LA60_1 = input.LA(2);
				if ( (synpred9_InternalDsl()) ) {
					alt60=1;
				}
			}
			switch (alt60) {
				case 1 :
					// InternalDsl.g:3701:4: ( ';' )=> (lv_semicolon_2_0= ';' )
					{
					// InternalDsl.g:3702:4: (lv_semicolon_2_0= ';' )
					// InternalDsl.g:3703:5: lv_semicolon_2_0= ';'
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
	// InternalDsl.g:3719:1: entryRuleXJEmptyStatement returns [EObject current=null] :iv_ruleXJEmptyStatement= ruleXJEmptyStatement EOF ;
	public final EObject entryRuleXJEmptyStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJEmptyStatement =null;

		try {
			// InternalDsl.g:3719:57: (iv_ruleXJEmptyStatement= ruleXJEmptyStatement EOF )
			// InternalDsl.g:3720:2: iv_ruleXJEmptyStatement= ruleXJEmptyStatement EOF
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
	// InternalDsl.g:3726:1: ruleXJEmptyStatement returns [EObject current=null] : ( () ( (lv_semicolon_1_0= ';' ) ) ) ;
	public final EObject ruleXJEmptyStatement() throws RecognitionException {
		EObject current = null;


		Token lv_semicolon_1_0=null;


			enterRule();

		try {
			// InternalDsl.g:3732:2: ( ( () ( (lv_semicolon_1_0= ';' ) ) ) )
			// InternalDsl.g:3733:2: ( () ( (lv_semicolon_1_0= ';' ) ) )
			{
			// InternalDsl.g:3733:2: ( () ( (lv_semicolon_1_0= ';' ) ) )
			// InternalDsl.g:3734:3: () ( (lv_semicolon_1_0= ';' ) )
			{
			// InternalDsl.g:3734:3: ()
			// InternalDsl.g:3735:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJEmptyStatementAccess().getXJSemicolonStatementAction_0(),
								current);
						}
			}

			// InternalDsl.g:3741:3: ( (lv_semicolon_1_0= ';' ) )
			// InternalDsl.g:3742:4: (lv_semicolon_1_0= ';' )
			{
			// InternalDsl.g:3742:4: (lv_semicolon_1_0= ';' )
			// InternalDsl.g:3743:5: lv_semicolon_1_0= ';'
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
	// InternalDsl.g:3759:1: entryRuleXJBranchingStatement returns [EObject current=null] :iv_ruleXJBranchingStatement= ruleXJBranchingStatement EOF ;
	public final EObject entryRuleXJBranchingStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJBranchingStatement =null;

		try {
			// InternalDsl.g:3759:61: (iv_ruleXJBranchingStatement= ruleXJBranchingStatement EOF )
			// InternalDsl.g:3760:2: iv_ruleXJBranchingStatement= ruleXJBranchingStatement EOF
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
	// InternalDsl.g:3766:1: ruleXJBranchingStatement returns [EObject current=null] : ( ( () otherlv_1= 'continue' ) | ( () otherlv_3= 'break' ) ) ;
	public final EObject ruleXJBranchingStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;


			enterRule();

		try {
			// InternalDsl.g:3772:2: ( ( ( () otherlv_1= 'continue' ) | ( () otherlv_3= 'break' ) ) )
			// InternalDsl.g:3773:2: ( ( () otherlv_1= 'continue' ) | ( () otherlv_3= 'break' ) )
			{
			// InternalDsl.g:3773:2: ( ( () otherlv_1= 'continue' ) | ( () otherlv_3= 'break' ) )
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==85) ) {
				alt61=1;
			}
			else if ( (LA61_0==81) ) {
				alt61=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 61, 0, input);
				throw nvae;
			}

			switch (alt61) {
				case 1 :
					// InternalDsl.g:3774:3: ( () otherlv_1= 'continue' )
					{
					// InternalDsl.g:3774:3: ( () otherlv_1= 'continue' )
					// InternalDsl.g:3775:4: () otherlv_1= 'continue'
					{
					// InternalDsl.g:3775:4: ()
					// InternalDsl.g:3776:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getXJBranchingStatementAccess().getXJContinueStatementAction_0_0(),
											current);
									}
					}

					otherlv_1=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_1, grammarAccess.getXJBranchingStatementAccess().getContinueKeyword_0_1());
								}
					}

					}
					break;
				case 2 :
					// InternalDsl.g:3788:3: ( () otherlv_3= 'break' )
					{
					// InternalDsl.g:3788:3: ( () otherlv_3= 'break' )
					// InternalDsl.g:3789:4: () otherlv_3= 'break'
					{
					// InternalDsl.g:3789:4: ()
					// InternalDsl.g:3790:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getXJBranchingStatementAccess().getXJBreakStatementAction_1_0(),
											current);
									}
					}

					otherlv_3=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:3805:1: entryRuleXBlockExpression returns [EObject current=null] :iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
	public final EObject entryRuleXBlockExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBlockExpression =null;

		try {
			// InternalDsl.g:3805:57: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
			// InternalDsl.g:3806:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
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
	// InternalDsl.g:3812:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )* otherlv_3= '}' ) ;
	public final EObject ruleXBlockExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		EObject lv_expressions_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:3818:2: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )* otherlv_3= '}' ) )
			// InternalDsl.g:3819:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )* otherlv_3= '}' )
			{
			// InternalDsl.g:3819:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )* otherlv_3= '}' )
			// InternalDsl.g:3820:3: () otherlv_1= '{' ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )* otherlv_3= '}'
			{
			// InternalDsl.g:3820:3: ()
			// InternalDsl.g:3821:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,109,FOLLOW_64); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
					}
			// InternalDsl.g:3831:3: ( (lv_expressions_2_0= ruleXJStatementOrBlock ) )*
			loop62:
			while (true) {
				int alt62=2;
				int LA62_0 = input.LA(1);
				if ( ((LA62_0 >= RULE_CHARACTER && LA62_0 <= RULE_INT)||LA62_0==RULE_STRING||LA62_0==14||LA62_0==22||(LA62_0 >= 28 && LA62_0 <= 29)||(LA62_0 >= 32 && LA62_0 <= 33)||LA62_0==41||LA62_0==81||LA62_0==85||LA62_0==87||(LA62_0 >= 89 && LA62_0 <= 92)||(LA62_0 >= 94 && LA62_0 <= 96)||(LA62_0 >= 98 && LA62_0 <= 109)||LA62_0==114) ) {
					alt62=1;
				}

				switch (alt62) {
				case 1 :
					// InternalDsl.g:3832:4: (lv_expressions_2_0= ruleXJStatementOrBlock )
					{
					// InternalDsl.g:3832:4: (lv_expressions_2_0= ruleXJStatementOrBlock )
					// InternalDsl.g:3833:5: lv_expressions_2_0= ruleXJStatementOrBlock
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
					break loop62;
				}
			}

			otherlv_3=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:3858:1: entryRuleXVariableDeclaration returns [EObject current=null] :iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
	public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXVariableDeclaration =null;

		try {
			// InternalDsl.g:3858:61: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
			// InternalDsl.g:3859:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
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
	// InternalDsl.g:3865:1: ruleXVariableDeclaration returns [EObject current=null] : ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) ) (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )? ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )* ) ;
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
			// InternalDsl.g:3871:2: ( ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) ) (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )? ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )* ) )
			// InternalDsl.g:3872:2: ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) ) (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )? ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )* )
			{
			// InternalDsl.g:3872:2: ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) ) (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )? ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )* )
			// InternalDsl.g:3873:3: ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) ) (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )? ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )*
			{
			// InternalDsl.g:3873:3: ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) ) )
			// InternalDsl.g:3874:4: ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) )
			{
			// InternalDsl.g:3894:4: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) )
			// InternalDsl.g:3895:5: () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) )
			{
			// InternalDsl.g:3895:5: ()
			// InternalDsl.g:3896:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXVariableDeclarationAccess().getXJVariableDeclarationAction_0_0_0(),
										current);
								}
			}

			// InternalDsl.g:3902:5: ( (lv_final_1_0= 'final' ) )?
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==92) ) {
				alt63=1;
			}
			switch (alt63) {
				case 1 :
					// InternalDsl.g:3903:6: (lv_final_1_0= 'final' )
					{
					// InternalDsl.g:3903:6: (lv_final_1_0= 'final' )
					// InternalDsl.g:3904:7: lv_final_1_0= 'final'
					{
					lv_final_1_0=(Token)match(input,92,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(lv_final_1_0, grammarAccess.getXVariableDeclarationAccess().getFinalFinalKeyword_0_0_1_0());
											}
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXVariableDeclarationRule());
												}
												setWithLastConsumed(current, "final", true, "final");
											}
					}

					}
					break;

			}

			// InternalDsl.g:3916:5: ( (lv_type_2_0= ruleJvmTypeReference ) )
			// InternalDsl.g:3917:6: (lv_type_2_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:3917:6: (lv_type_2_0= ruleJvmTypeReference )
			// InternalDsl.g:3918:7: lv_type_2_0= ruleJvmTypeReference
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

			// InternalDsl.g:3935:5: ( (lv_name_3_0= ruleValidID ) )
			// InternalDsl.g:3936:6: (lv_name_3_0= ruleValidID )
			{
			// InternalDsl.g:3936:6: (lv_name_3_0= ruleValidID )
			// InternalDsl.g:3937:7: lv_name_3_0= ruleValidID
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

			// InternalDsl.g:3956:3: (otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==45) ) {
				alt64=1;
			}
			switch (alt64) {
				case 1 :
					// InternalDsl.g:3957:4: otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) )
					{
					otherlv_4=(Token)match(input,45,FOLLOW_66); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_4, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_1_0());
								}
					// InternalDsl.g:3961:4: ( (lv_right_5_0= ruleXExpression ) )
					// InternalDsl.g:3962:5: (lv_right_5_0= ruleXExpression )
					{
					// InternalDsl.g:3962:5: (lv_right_5_0= ruleXExpression )
					// InternalDsl.g:3963:6: lv_right_5_0= ruleXExpression
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

			// InternalDsl.g:3981:3: ( ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) ) )*
			loop65:
			while (true) {
				int alt65=2;
				int LA65_0 = input.LA(1);
				if ( (LA65_0==31) ) {
					int LA65_2 = input.LA(2);
					if ( (LA65_2==RULE_ID) ) {
						int LA65_3 = input.LA(3);
						if ( (synpred11_InternalDsl()) ) {
							alt65=1;
						}

					}

				}

				switch (alt65) {
				case 1 :
					// InternalDsl.g:3982:4: ( ( ',' )=>otherlv_6= ',' ) ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) )
					{
					// InternalDsl.g:3982:4: ( ( ',' )=>otherlv_6= ',' )
					// InternalDsl.g:3983:5: ( ',' )=>otherlv_6= ','
					{
					otherlv_6=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getCommaKeyword_2_0());
									}
					}

					// InternalDsl.g:3989:4: ( (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration ) )
					// InternalDsl.g:3990:5: (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration )
					{
					// InternalDsl.g:3990:5: (lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration )
					// InternalDsl.g:3991:6: lv_additionalVariables_7_0= ruleXJAdditionalXVariableDeclaration
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
					break loop65;
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
	// InternalDsl.g:4013:1: entryRuleXJAdditionalXVariableDeclaration returns [EObject current=null] :iv_ruleXJAdditionalXVariableDeclaration= ruleXJAdditionalXVariableDeclaration EOF ;
	public final EObject entryRuleXJAdditionalXVariableDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJAdditionalXVariableDeclaration =null;

		try {
			// InternalDsl.g:4013:73: (iv_ruleXJAdditionalXVariableDeclaration= ruleXJAdditionalXVariableDeclaration EOF )
			// InternalDsl.g:4014:2: iv_ruleXJAdditionalXVariableDeclaration= ruleXJAdditionalXVariableDeclaration EOF
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
	// InternalDsl.g:4020:1: ruleXJAdditionalXVariableDeclaration returns [EObject current=null] : ( () ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )? ) ;
	public final EObject ruleXJAdditionalXVariableDeclaration() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;
		EObject lv_right_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:4026:2: ( ( () ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )? ) )
			// InternalDsl.g:4027:2: ( () ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )? )
			{
			// InternalDsl.g:4027:2: ( () ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )? )
			// InternalDsl.g:4028:3: () ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )?
			{
			// InternalDsl.g:4028:3: ()
			// InternalDsl.g:4029:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJAdditionalXVariableDeclarationAccess().getXJAdditionalXVariableDeclarationAction_0(),
								current);
						}
			}

			// InternalDsl.g:4035:3: ( (lv_name_1_0= ruleValidID ) )
			// InternalDsl.g:4036:4: (lv_name_1_0= ruleValidID )
			{
			// InternalDsl.g:4036:4: (lv_name_1_0= ruleValidID )
			// InternalDsl.g:4037:5: lv_name_1_0= ruleValidID
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

			// InternalDsl.g:4054:3: (otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) ) )?
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==45) ) {
				alt66=1;
			}
			switch (alt66) {
				case 1 :
					// InternalDsl.g:4055:4: otherlv_2= '=' ( (lv_right_3_0= ruleXExpression ) )
					{
					otherlv_2=(Token)match(input,45,FOLLOW_66); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getXJAdditionalXVariableDeclarationAccess().getEqualsSignKeyword_2_0());
								}
					// InternalDsl.g:4059:4: ( (lv_right_3_0= ruleXExpression ) )
					// InternalDsl.g:4060:5: (lv_right_3_0= ruleXExpression )
					{
					// InternalDsl.g:4060:5: (lv_right_3_0= ruleXExpression )
					// InternalDsl.g:4061:6: lv_right_3_0= ruleXExpression
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
	// InternalDsl.g:4083:1: entryRuleXAssignment returns [EObject current=null] :iv_ruleXAssignment= ruleXAssignment EOF ;
	public final EObject entryRuleXAssignment() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAssignment =null;

		try {
			// InternalDsl.g:4083:52: (iv_ruleXAssignment= ruleXAssignment EOF )
			// InternalDsl.g:4084:2: iv_ruleXAssignment= ruleXAssignment EOF
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
	// InternalDsl.g:4090:1: ruleXAssignment returns [EObject current=null] : ( ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) ) | (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? ) ) ;
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
			// InternalDsl.g:4096:2: ( ( ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) ) | (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? ) ) )
			// InternalDsl.g:4097:2: ( ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) ) | (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? ) )
			{
			// InternalDsl.g:4097:2: ( ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) ) | (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? ) )
			int alt69=3;
			switch ( input.LA(1) ) {
			case RULE_ID:
				{
				int LA69_1 = input.LA(2);
				if ( (synpred12_InternalDsl()) ) {
					alt69=1;
				}
				else if ( (synpred13_InternalDsl()) ) {
					alt69=2;
				}
				else if ( (true) ) {
					alt69=3;
				}

				}
				break;
			case 89:
				{
				int LA69_2 = input.LA(2);
				if ( (synpred12_InternalDsl()) ) {
					alt69=1;
				}
				else if ( (synpred13_InternalDsl()) ) {
					alt69=2;
				}
				else if ( (true) ) {
					alt69=3;
				}

				}
				break;
			case 101:
				{
				int LA69_3 = input.LA(2);
				if ( (synpred12_InternalDsl()) ) {
					alt69=1;
				}
				else if ( (synpred13_InternalDsl()) ) {
					alt69=2;
				}
				else if ( (true) ) {
					alt69=3;
				}

				}
				break;
			case 96:
				{
				int LA69_4 = input.LA(2);
				if ( (synpred12_InternalDsl()) ) {
					alt69=1;
				}
				else if ( (synpred13_InternalDsl()) ) {
					alt69=2;
				}
				else if ( (true) ) {
					alt69=3;
				}

				}
				break;
			case 90:
				{
				int LA69_5 = input.LA(2);
				if ( (synpred12_InternalDsl()) ) {
					alt69=1;
				}
				else if ( (synpred13_InternalDsl()) ) {
					alt69=2;
				}
				else if ( (true) ) {
					alt69=3;
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
			case 91:
			case 98:
			case 99:
			case 102:
			case 106:
			case 109:
			case 114:
				{
				alt69=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 69, 0, input);
				throw nvae;
			}
			switch (alt69) {
				case 1 :
					// InternalDsl.g:4098:3: ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) )
					{
					// InternalDsl.g:4098:3: ( ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) )
					// InternalDsl.g:4099:4: ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) )
					{
					// InternalDsl.g:4099:4: ( ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign ) )
					// InternalDsl.g:4100:5: ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign )
					{
					// InternalDsl.g:4127:5: ( () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign )
					// InternalDsl.g:4128:6: () ( ( ruleFeatureCallID ) ) otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* ruleOpSingleAssign
					{
					// InternalDsl.g:4128:6: ()
					// InternalDsl.g:4129:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElement(
													grammarAccess.getXAssignmentAccess().getXJAssignmentAction_0_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:4135:6: ( ( ruleFeatureCallID ) )
					// InternalDsl.g:4136:7: ( ruleFeatureCallID )
					{
					// InternalDsl.g:4136:7: ( ruleFeatureCallID )
					// InternalDsl.g:4137:8: ruleFeatureCallID
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXAssignmentRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_0_0_1_0());
												}
					pushFollow(FOLLOW_44);
					ruleFeatureCallID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					otherlv_2=(Token)match(input,77,FOLLOW_66); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_2, grammarAccess.getXAssignmentAccess().getLeftSquareBracketKeyword_0_0_0_2());
										}
					// InternalDsl.g:4155:6: ( (lv_indexes_3_0= ruleXExpression ) )
					// InternalDsl.g:4156:7: (lv_indexes_3_0= ruleXExpression )
					{
					// InternalDsl.g:4156:7: (lv_indexes_3_0= ruleXExpression )
					// InternalDsl.g:4157:8: lv_indexes_3_0= ruleXExpression
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

					otherlv_4=(Token)match(input,78,FOLLOW_13); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_4, grammarAccess.getXAssignmentAccess().getRightSquareBracketKeyword_0_0_0_4());
										}
					// InternalDsl.g:4178:6: (otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )*
					loop67:
					while (true) {
						int alt67=2;
						int LA67_0 = input.LA(1);
						if ( (LA67_0==77) ) {
							alt67=1;
						}

						switch (alt67) {
						case 1 :
							// InternalDsl.g:4179:7: otherlv_5= '[' ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']'
							{
							otherlv_5=(Token)match(input,77,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_5, grammarAccess.getXAssignmentAccess().getLeftSquareBracketKeyword_0_0_0_5_0());
													}
							// InternalDsl.g:4183:7: ( (lv_indexes_6_0= ruleXExpression ) )
							// InternalDsl.g:4184:8: (lv_indexes_6_0= ruleXExpression )
							{
							// InternalDsl.g:4184:8: (lv_indexes_6_0= ruleXExpression )
							// InternalDsl.g:4185:9: lv_indexes_6_0= ruleXExpression
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

							otherlv_7=(Token)match(input,78,FOLLOW_13); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_7, grammarAccess.getXAssignmentAccess().getRightSquareBracketKeyword_0_0_0_5_2());
													}
							}
							break;

						default :
							break loop67;
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

					// InternalDsl.g:4216:4: ( (lv_value_9_0= ruleXAssignment ) )
					// InternalDsl.g:4217:5: (lv_value_9_0= ruleXAssignment )
					{
					// InternalDsl.g:4217:5: (lv_value_9_0= ruleXAssignment )
					// InternalDsl.g:4218:6: lv_value_9_0= ruleXAssignment
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
					// InternalDsl.g:4237:3: ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) )
					{
					// InternalDsl.g:4237:3: ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) ) )
					// InternalDsl.g:4238:4: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_13_0= ruleXAssignment ) )
					{
					// InternalDsl.g:4238:4: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
					// InternalDsl.g:4239:5: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					{
					// InternalDsl.g:4250:5: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					// InternalDsl.g:4251:6: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
					{
					// InternalDsl.g:4251:6: ()
					// InternalDsl.g:4252:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElement(
													grammarAccess.getXAssignmentAccess().getXAssignmentAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:4258:6: ( ( ruleFeatureCallID ) )
					// InternalDsl.g:4259:7: ( ruleFeatureCallID )
					{
					// InternalDsl.g:4259:7: ( ruleFeatureCallID )
					// InternalDsl.g:4260:8: ruleFeatureCallID
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

					// InternalDsl.g:4283:4: ( (lv_value_13_0= ruleXAssignment ) )
					// InternalDsl.g:4284:5: (lv_value_13_0= ruleXAssignment )
					{
					// InternalDsl.g:4284:5: (lv_value_13_0= ruleXAssignment )
					// InternalDsl.g:4285:6: lv_value_13_0= ruleXAssignment
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
					// InternalDsl.g:4304:3: (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? )
					{
					// InternalDsl.g:4304:3: (this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )? )
					// InternalDsl.g:4305:4: this_XOrExpression_14= ruleXOrExpression ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )?
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
					// InternalDsl.g:4313:4: ( ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) ) | ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) ) )?
					int alt68=3;
					switch ( input.LA(1) ) {
						case 49:
							{
							int LA68_1 = input.LA(2);
							if ( (synpred14_InternalDsl()) ) {
								alt68=1;
							}
							}
							break;
						case 30:
							{
							int LA68_2 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt68=2;
							}
							}
							break;
						case 34:
							{
							int LA68_3 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt68=2;
							}
							}
							break;
						case 27:
							{
							int LA68_4 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt68=2;
							}
							}
							break;
						case 39:
							{
							int LA68_5 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt68=2;
							}
							}
							break;
						case 18:
							{
							int LA68_6 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt68=2;
							}
							}
							break;
						case 21:
							{
							int LA68_7 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt68=2;
							}
							}
							break;
						case 111:
							{
							int LA68_8 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt68=2;
							}
							}
							break;
						case 80:
							{
							int LA68_9 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt68=2;
							}
							}
							break;
						case 42:
							{
							int LA68_10 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt68=2;
							}
							}
							break;
						case 47:
							{
							int LA68_11 = input.LA(2);
							if ( (synpred15_InternalDsl()) ) {
								alt68=2;
							}
							}
							break;
					}
					switch (alt68) {
						case 1 :
							// InternalDsl.g:4314:5: ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) )
							{
							// InternalDsl.g:4314:5: ( ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) ) )
							// InternalDsl.g:4315:6: ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) ) ( (lv_then_17_0= ruleXExpression ) ) otherlv_18= ':' ( (lv_else_19_0= ruleXExpression ) )
							{
							// InternalDsl.g:4315:6: ( ( ( () '?' ) )=> ( () otherlv_16= '?' ) )
							// InternalDsl.g:4316:7: ( ( () '?' ) )=> ( () otherlv_16= '?' )
							{
							// InternalDsl.g:4322:7: ( () otherlv_16= '?' )
							// InternalDsl.g:4323:8: () otherlv_16= '?'
							{
							// InternalDsl.g:4323:8: ()
							// InternalDsl.g:4324:9: 
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

							// InternalDsl.g:4336:6: ( (lv_then_17_0= ruleXExpression ) )
							// InternalDsl.g:4337:7: (lv_then_17_0= ruleXExpression )
							{
							// InternalDsl.g:4337:7: (lv_then_17_0= ruleXExpression )
							// InternalDsl.g:4338:8: lv_then_17_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXAssignmentAccess().getThenXExpressionParserRuleCall_2_1_0_1_0());
														}
							pushFollow(FOLLOW_34);
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
							// InternalDsl.g:4359:6: ( (lv_else_19_0= ruleXExpression ) )
							// InternalDsl.g:4360:7: (lv_else_19_0= ruleXExpression )
							{
							// InternalDsl.g:4360:7: (lv_else_19_0= ruleXExpression )
							// InternalDsl.g:4361:8: lv_else_19_0= ruleXExpression
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
							// InternalDsl.g:4380:5: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) )
							{
							// InternalDsl.g:4380:5: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) ) )
							// InternalDsl.g:4381:6: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_22_0= ruleXAssignment ) )
							{
							// InternalDsl.g:4381:6: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
							// InternalDsl.g:4382:7: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
							{
							// InternalDsl.g:4392:7: ( () ( ( ruleOpMultiAssign ) ) )
							// InternalDsl.g:4393:8: () ( ( ruleOpMultiAssign ) )
							{
							// InternalDsl.g:4393:8: ()
							// InternalDsl.g:4394:9: 
							{
							if ( state.backtracking==0 ) {
																current = forceCreateModelElementAndSet(
																	grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_2_1_1_0_0_0(),
																	current);
															}
							}

							// InternalDsl.g:4400:8: ( ( ruleOpMultiAssign ) )
							// InternalDsl.g:4401:9: ( ruleOpMultiAssign )
							{
							// InternalDsl.g:4401:9: ( ruleOpMultiAssign )
							// InternalDsl.g:4402:10: ruleOpMultiAssign
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

							// InternalDsl.g:4418:6: ( (lv_rightOperand_22_0= ruleXAssignment ) )
							// InternalDsl.g:4419:7: (lv_rightOperand_22_0= ruleXAssignment )
							{
							// InternalDsl.g:4419:7: (lv_rightOperand_22_0= ruleXAssignment )
							// InternalDsl.g:4420:8: lv_rightOperand_22_0= ruleXAssignment
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
	// InternalDsl.g:4444:1: entryRuleOpMultiAssign returns [String current=null] :iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
	public final String entryRuleOpMultiAssign() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpMultiAssign =null;

		try {
			// InternalDsl.g:4444:53: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
			// InternalDsl.g:4445:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
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
	// InternalDsl.g:4451:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' |kw= '&=' |kw= '|=' |kw= '^=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) ;
	public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:4457:2: ( (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' |kw= '&=' |kw= '|=' |kw= '^=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) )
			// InternalDsl.g:4458:2: (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' |kw= '&=' |kw= '|=' |kw= '^=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
			{
			// InternalDsl.g:4458:2: (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' |kw= '&=' |kw= '|=' |kw= '^=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
			int alt71=10;
			switch ( input.LA(1) ) {
			case 30:
				{
				alt71=1;
				}
				break;
			case 34:
				{
				alt71=2;
				}
				break;
			case 27:
				{
				alt71=3;
				}
				break;
			case 39:
				{
				alt71=4;
				}
				break;
			case 18:
				{
				alt71=5;
				}
				break;
			case 21:
				{
				alt71=6;
				}
				break;
			case 111:
				{
				alt71=7;
				}
				break;
			case 80:
				{
				alt71=8;
				}
				break;
			case 42:
				{
				alt71=9;
				}
				break;
			case 47:
				{
				alt71=10;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 71, 0, input);
				throw nvae;
			}
			switch (alt71) {
				case 1 :
					// InternalDsl.g:4459:3: kw= '+='
					{
					kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:4465:3: kw= '-='
					{
					kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalDsl.g:4471:3: kw= '*='
					{
					kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalDsl.g:4477:3: kw= '/='
					{
					kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalDsl.g:4483:3: kw= '%='
					{
					kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
							}
					}
					break;
				case 6 :
					// InternalDsl.g:4489:3: kw= '&='
					{
					kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAmpersandEqualsSignKeyword_5());
							}
					}
					break;
				case 7 :
					// InternalDsl.g:4495:3: kw= '|='
					{
					kw=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getVerticalLineEqualsSignKeyword_6());
							}
					}
					break;
				case 8 :
					// InternalDsl.g:4501:3: kw= '^='
					{
					kw=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getCircumflexAccentEqualsSignKeyword_7());
							}
					}
					break;
				case 9 :
					// InternalDsl.g:4507:3: (kw= '<' kw= '<' kw= '=' )
					{
					// InternalDsl.g:4507:3: (kw= '<' kw= '<' kw= '=' )
					// InternalDsl.g:4508:4: kw= '<' kw= '<' kw= '='
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
					// InternalDsl.g:4525:3: (kw= '>' (kw= '>' )? kw= '>=' )
					{
					// InternalDsl.g:4525:3: (kw= '>' (kw= '>' )? kw= '>=' )
					// InternalDsl.g:4526:4: kw= '>' (kw= '>' )? kw= '>='
					{
					kw=(Token)match(input,47,FOLLOW_71); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_9_0());
								}
					// InternalDsl.g:4531:4: (kw= '>' )?
					int alt70=2;
					int LA70_0 = input.LA(1);
					if ( (LA70_0==47) ) {
						alt70=1;
					}
					switch (alt70) {
						case 1 :
							// InternalDsl.g:4532:5: kw= '>'
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
	// InternalDsl.g:4548:1: entryRuleXJFeatureCallWithArrayAccess returns [EObject current=null] :iv_ruleXJFeatureCallWithArrayAccess= ruleXJFeatureCallWithArrayAccess EOF ;
	public final EObject entryRuleXJFeatureCallWithArrayAccess() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJFeatureCallWithArrayAccess =null;

		try {
			// InternalDsl.g:4548:69: (iv_ruleXJFeatureCallWithArrayAccess= ruleXJFeatureCallWithArrayAccess EOF )
			// InternalDsl.g:4549:2: iv_ruleXJFeatureCallWithArrayAccess= ruleXJFeatureCallWithArrayAccess EOF
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
			int alt73=2;
			alt73 = dfa73.predict(input);
			switch (alt73) {
				case 1 :
					// InternalDsl.g:<invalid or missing tree structure>
					{
					// InternalDsl.g:4596:4: ( () otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' ( ( ( '[' )=>otherlv_5= '[' ) ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )* )
					// InternalDsl.g:4597:5: () otherlv_2= '[' ( (lv_indexes_3_0= ruleXExpression ) ) otherlv_4= ']' ( ( ( '[' )=>otherlv_5= '[' ) ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )*
					{
					// InternalDsl.g:4597:5: ()
					// InternalDsl.g:4598:6: 
					{
					if ( state.backtracking==0 ) {
											current = forceCreateModelElementAndSet(
												grammarAccess.getXJFeatureCallWithArrayAccessAccess().getXJArrayAccessExpressionArrayAction_1_0_0(),
												current);
										}
					}

					otherlv_2=(Token)match(input,77,FOLLOW_66); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_2, grammarAccess.getXJFeatureCallWithArrayAccessAccess().getLeftSquareBracketKeyword_1_0_1());
									}
					// InternalDsl.g:4608:5: ( (lv_indexes_3_0= ruleXExpression ) )
					// InternalDsl.g:4609:6: (lv_indexes_3_0= ruleXExpression )
					{
					// InternalDsl.g:4609:6: (lv_indexes_3_0= ruleXExpression )
					// InternalDsl.g:4610:7: lv_indexes_3_0= ruleXExpression
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

					otherlv_4=(Token)match(input,78,FOLLOW_62); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_4, grammarAccess.getXJFeatureCallWithArrayAccessAccess().getRightSquareBracketKeyword_1_0_3());
									}
					// InternalDsl.g:4631:5: ( ( ( '[' )=>otherlv_5= '[' ) ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )*
					loop72:
					while (true) {
						int alt72=2;
						alt72 = dfa72.predict(input);
						switch (alt72) {
						case 1 :
							// InternalDsl.g:4632:6: ( ( '[' )=>otherlv_5= '[' ) ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']'
							{
							// InternalDsl.g:4632:6: ( ( '[' )=>otherlv_5= '[' )
							// InternalDsl.g:4633:7: ( '[' )=>otherlv_5= '['
							{
							otherlv_5=(Token)match(input,77,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_5, grammarAccess.getXJFeatureCallWithArrayAccessAccess().getLeftSquareBracketKeyword_1_0_4_0());
													}
							}

							// InternalDsl.g:4639:6: ( (lv_indexes_6_0= ruleXExpression ) )
							// InternalDsl.g:4640:7: (lv_indexes_6_0= ruleXExpression )
							{
							// InternalDsl.g:4640:7: (lv_indexes_6_0= ruleXExpression )
							// InternalDsl.g:4641:8: lv_indexes_6_0= ruleXExpression
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

							otherlv_7=(Token)match(input,78,FOLLOW_62); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_7, grammarAccess.getXJFeatureCallWithArrayAccessAccess().getRightSquareBracketKeyword_1_0_4_2());
												}
							}
							break;

						default :
							break loop72;
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
	// InternalDsl.g:4669:1: entryRuleXFeatureCall returns [EObject current=null] :iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
	public final EObject entryRuleXFeatureCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXFeatureCall =null;

		try {
			// InternalDsl.g:4669:53: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
			// InternalDsl.g:4670:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
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
	// InternalDsl.g:4676:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )? ) ;
	public final EObject ruleXFeatureCall() throws RecognitionException {
		EObject current = null;


		Token lv_explicitOperationCall_2_0=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_featureCallArguments_3_0 =null;
		EObject lv_featureCallArguments_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:4682:2: ( ( () ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )? ) )
			// InternalDsl.g:4683:2: ( () ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )? )
			{
			// InternalDsl.g:4683:2: ( () ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )? )
			// InternalDsl.g:4684:3: () ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )?
			{
			// InternalDsl.g:4684:3: ()
			// InternalDsl.g:4685:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
								current);
						}
			}

			// InternalDsl.g:4691:3: ( ( ruleIdOrSuper ) )
			// InternalDsl.g:4692:4: ( ruleIdOrSuper )
			{
			// InternalDsl.g:4692:4: ( ruleIdOrSuper )
			// InternalDsl.g:4693:5: ruleIdOrSuper
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

			// InternalDsl.g:4707:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )?
			int alt76=2;
			alt76 = dfa76.predict(input);
			switch (alt76) {
				case 1 :
					// InternalDsl.g:4708:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')'
					{
					// InternalDsl.g:4708:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) )
					// InternalDsl.g:4709:5: ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' )
					{
					// InternalDsl.g:4713:5: (lv_explicitOperationCall_2_0= '(' )
					// InternalDsl.g:4714:6: lv_explicitOperationCall_2_0= '('
					{
					lv_explicitOperationCall_2_0=(Token)match(input,22,FOLLOW_73); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_explicitOperationCall_2_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_2_0_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXFeatureCallRule());
											}
											setWithLastConsumed(current, "explicitOperationCall", true, "(");
										}
					}

					}

					// InternalDsl.g:4726:4: ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )?
					int alt75=2;
					int LA75_0 = input.LA(1);
					if ( ((LA75_0 >= RULE_CHARACTER && LA75_0 <= RULE_INT)||LA75_0==RULE_STRING||LA75_0==14||LA75_0==22||(LA75_0 >= 28 && LA75_0 <= 29)||(LA75_0 >= 32 && LA75_0 <= 33)||(LA75_0 >= 89 && LA75_0 <= 91)||LA75_0==96||(LA75_0 >= 98 && LA75_0 <= 99)||(LA75_0 >= 101 && LA75_0 <= 102)||LA75_0==106||LA75_0==109||LA75_0==114) ) {
						alt75=1;
					}
					switch (alt75) {
						case 1 :
							// InternalDsl.g:4727:5: ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )*
							{
							// InternalDsl.g:4727:5: ( (lv_featureCallArguments_3_0= ruleXExpression ) )
							// InternalDsl.g:4728:6: (lv_featureCallArguments_3_0= ruleXExpression )
							{
							// InternalDsl.g:4728:6: (lv_featureCallArguments_3_0= ruleXExpression )
							// InternalDsl.g:4729:7: lv_featureCallArguments_3_0= ruleXExpression
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

							// InternalDsl.g:4746:5: (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )*
							loop74:
							while (true) {
								int alt74=2;
								int LA74_0 = input.LA(1);
								if ( (LA74_0==31) ) {
									alt74=1;
								}

								switch (alt74) {
								case 1 :
									// InternalDsl.g:4747:6: otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) )
									{
									otherlv_4=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_1_1_0());
														}
									// InternalDsl.g:4751:6: ( (lv_featureCallArguments_5_0= ruleXExpression ) )
									// InternalDsl.g:4752:7: (lv_featureCallArguments_5_0= ruleXExpression )
									{
									// InternalDsl.g:4752:7: (lv_featureCallArguments_5_0= ruleXExpression )
									// InternalDsl.g:4753:8: lv_featureCallArguments_5_0= ruleXExpression
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
									break loop74;
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
	// InternalDsl.g:4781:1: entryRuleXConstructorCall returns [EObject current=null] :iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
	public final EObject entryRuleXConstructorCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXConstructorCall =null;

		try {
			// InternalDsl.g:4781:57: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
			// InternalDsl.g:4782:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
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
	// InternalDsl.g:4788:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )? ) ;
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
			// InternalDsl.g:4794:2: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )? ) )
			// InternalDsl.g:4795:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )? )
			{
			// InternalDsl.g:4795:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )? )
			// InternalDsl.g:4796:3: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )?
			{
			// InternalDsl.g:4796:3: ()
			// InternalDsl.g:4797:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXConstructorCallAccess().getXJConstructorCallAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,98,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
					}
			// InternalDsl.g:4807:3: ( ( ruleQualifiedName ) )
			// InternalDsl.g:4808:4: ( ruleQualifiedName )
			{
			// InternalDsl.g:4808:4: ( ruleQualifiedName )
			// InternalDsl.g:4809:5: ruleQualifiedName
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

			// InternalDsl.g:4823:3: ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )?
			int alt79=2;
			alt79 = dfa79.predict(input);
			switch (alt79) {
				case 1 :
					// InternalDsl.g:4824:4: ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>'
					{
					// InternalDsl.g:4824:4: ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) )
					// InternalDsl.g:4825:5: ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' )
					{
					// InternalDsl.g:4829:5: (lv_explicitTypeArguments_3_0= '<' )
					// InternalDsl.g:4830:6: lv_explicitTypeArguments_3_0= '<'
					{
					lv_explicitTypeArguments_3_0=(Token)match(input,42,FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_explicitTypeArguments_3_0, grammarAccess.getXConstructorCallAccess().getExplicitTypeArgumentsLessThanSignKeyword_3_0_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXConstructorCallRule());
											}
											setWithLastConsumed(current, "explicitTypeArguments", true, "<");
										}
					}

					}

					// InternalDsl.g:4842:4: ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )?
					int alt78=2;
					int LA78_0 = input.LA(1);
					if ( (LA78_0==RULE_ID||LA78_0==49) ) {
						alt78=1;
					}
					switch (alt78) {
						case 1 :
							// InternalDsl.g:4843:5: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
							{
							// InternalDsl.g:4843:5: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
							// InternalDsl.g:4844:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
							{
							// InternalDsl.g:4844:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
							// InternalDsl.g:4845:7: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
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

							// InternalDsl.g:4862:5: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
							loop77:
							while (true) {
								int alt77=2;
								int LA77_0 = input.LA(1);
								if ( (LA77_0==31) ) {
									alt77=1;
								}

								switch (alt77) {
								case 1 :
									// InternalDsl.g:4863:6: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
									{
									otherlv_5=(Token)match(input,31,FOLLOW_77); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_1_1_0());
														}
									// InternalDsl.g:4867:6: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
									// InternalDsl.g:4868:7: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
									{
									// InternalDsl.g:4868:7: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
									// InternalDsl.g:4869:8: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
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
									break loop77;
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

			// InternalDsl.g:4893:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )?
			int alt82=2;
			alt82 = dfa82.predict(input);
			switch (alt82) {
				case 1 :
					// InternalDsl.g:4894:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')'
					{
					// InternalDsl.g:4894:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) )
					// InternalDsl.g:4895:5: ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' )
					{
					// InternalDsl.g:4899:5: (lv_explicitConstructorCall_8_0= '(' )
					// InternalDsl.g:4900:6: lv_explicitConstructorCall_8_0= '('
					{
					lv_explicitConstructorCall_8_0=(Token)match(input,22,FOLLOW_73); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_explicitConstructorCall_8_0, grammarAccess.getXConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXConstructorCallRule());
											}
											setWithLastConsumed(current, "explicitConstructorCall", true, "(");
										}
					}

					}

					// InternalDsl.g:4912:4: ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )?
					int alt81=2;
					int LA81_0 = input.LA(1);
					if ( ((LA81_0 >= RULE_CHARACTER && LA81_0 <= RULE_INT)||LA81_0==RULE_STRING||LA81_0==14||LA81_0==22||(LA81_0 >= 28 && LA81_0 <= 29)||(LA81_0 >= 32 && LA81_0 <= 33)||(LA81_0 >= 89 && LA81_0 <= 91)||LA81_0==96||(LA81_0 >= 98 && LA81_0 <= 99)||(LA81_0 >= 101 && LA81_0 <= 102)||LA81_0==106||LA81_0==109||LA81_0==114) ) {
						alt81=1;
					}
					switch (alt81) {
						case 1 :
							// InternalDsl.g:4913:5: ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )*
							{
							// InternalDsl.g:4913:5: ( (lv_arguments_9_0= ruleXExpression ) )
							// InternalDsl.g:4914:6: (lv_arguments_9_0= ruleXExpression )
							{
							// InternalDsl.g:4914:6: (lv_arguments_9_0= ruleXExpression )
							// InternalDsl.g:4915:7: lv_arguments_9_0= ruleXExpression
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

							// InternalDsl.g:4932:5: (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )*
							loop80:
							while (true) {
								int alt80=2;
								int LA80_0 = input.LA(1);
								if ( (LA80_0==31) ) {
									alt80=1;
								}

								switch (alt80) {
								case 1 :
									// InternalDsl.g:4933:6: otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) )
									{
									otherlv_10=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_10, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_1_0());
														}
									// InternalDsl.g:4937:6: ( (lv_arguments_11_0= ruleXExpression ) )
									// InternalDsl.g:4938:7: (lv_arguments_11_0= ruleXExpression )
									{
									// InternalDsl.g:4938:7: (lv_arguments_11_0= ruleXExpression )
									// InternalDsl.g:4939:8: lv_arguments_11_0= ruleXExpression
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
									break loop80;
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
	// InternalDsl.g:4967:1: entryRuleXJArrayConstructorCall returns [EObject current=null] :iv_ruleXJArrayConstructorCall= ruleXJArrayConstructorCall EOF ;
	public final EObject entryRuleXJArrayConstructorCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJArrayConstructorCall =null;

		try {
			// InternalDsl.g:4967:63: (iv_ruleXJArrayConstructorCall= ruleXJArrayConstructorCall EOF )
			// InternalDsl.g:4968:2: iv_ruleXJArrayConstructorCall= ruleXJArrayConstructorCall EOF
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
	// InternalDsl.g:4974:1: ruleXJArrayConstructorCall returns [EObject current=null] : ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) ) ( (lv_indexes_4_0= ruleXExpression ) )? otherlv_5= ']' ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )* ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )? ) ;
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
			// InternalDsl.g:4980:2: ( ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) ) ( (lv_indexes_4_0= ruleXExpression ) )? otherlv_5= ']' ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )* ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )? ) )
			// InternalDsl.g:4981:2: ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) ) ( (lv_indexes_4_0= ruleXExpression ) )? otherlv_5= ']' ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )* ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )? )
			{
			// InternalDsl.g:4981:2: ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) ) ( (lv_indexes_4_0= ruleXExpression ) )? otherlv_5= ']' ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )* ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )? )
			// InternalDsl.g:4982:3: ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) ) ( (lv_indexes_4_0= ruleXExpression ) )? otherlv_5= ']' ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )* ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )?
			{
			// InternalDsl.g:4982:3: ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) ) )
			// InternalDsl.g:4983:4: ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=> ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) )
			{
			// InternalDsl.g:4999:4: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) ) )
			// InternalDsl.g:5000:5: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_dimensions_3_0= ruleXJArrayDimension ) )
			{
			// InternalDsl.g:5000:5: ()
			// InternalDsl.g:5001:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXJArrayConstructorCallAccess().getXJArrayConstructorCallAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,98,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXJArrayConstructorCallAccess().getNewKeyword_0_0_1());
							}
			// InternalDsl.g:5011:5: ( ( ruleQualifiedName ) )
			// InternalDsl.g:5012:6: ( ruleQualifiedName )
			{
			// InternalDsl.g:5012:6: ( ruleQualifiedName )
			// InternalDsl.g:5013:7: ruleQualifiedName
			{
			if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getXJArrayConstructorCallRule());
										}
									}
			if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXJArrayConstructorCallAccess().getTypeJvmTypeCrossReference_0_0_2_0());
									}
			pushFollow(FOLLOW_44);
			ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
										afterParserOrEnumRuleCall();
									}
			}

			}

			// InternalDsl.g:5027:5: ( (lv_dimensions_3_0= ruleXJArrayDimension ) )
			// InternalDsl.g:5028:6: (lv_dimensions_3_0= ruleXJArrayDimension )
			{
			// InternalDsl.g:5028:6: (lv_dimensions_3_0= ruleXJArrayDimension )
			// InternalDsl.g:5029:7: lv_dimensions_3_0= ruleXJArrayDimension
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

			// InternalDsl.g:5048:3: ( (lv_indexes_4_0= ruleXExpression ) )?
			int alt83=2;
			int LA83_0 = input.LA(1);
			if ( ((LA83_0 >= RULE_CHARACTER && LA83_0 <= RULE_INT)||LA83_0==RULE_STRING||LA83_0==14||LA83_0==22||(LA83_0 >= 28 && LA83_0 <= 29)||(LA83_0 >= 32 && LA83_0 <= 33)||(LA83_0 >= 89 && LA83_0 <= 91)||LA83_0==96||(LA83_0 >= 98 && LA83_0 <= 99)||(LA83_0 >= 101 && LA83_0 <= 102)||LA83_0==106||LA83_0==109||LA83_0==114) ) {
				alt83=1;
			}
			switch (alt83) {
				case 1 :
					// InternalDsl.g:5049:4: (lv_indexes_4_0= ruleXExpression )
					{
					// InternalDsl.g:5049:4: (lv_indexes_4_0= ruleXExpression )
					// InternalDsl.g:5050:5: lv_indexes_4_0= ruleXExpression
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

			otherlv_5=(Token)match(input,78,FOLLOW_79); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getXJArrayConstructorCallAccess().getRightSquareBracketKeyword_2());
					}
			// InternalDsl.g:5071:3: ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )*
			loop85:
			while (true) {
				int alt85=2;
				alt85 = dfa85.predict(input);
				switch (alt85) {
				case 1 :
					// InternalDsl.g:5072:4: ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']'
					{
					// InternalDsl.g:5072:4: ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) )
					// InternalDsl.g:5073:5: ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension )
					{
					// InternalDsl.g:5077:5: (lv_dimensions_6_0= ruleXJArrayDimension )
					// InternalDsl.g:5078:6: lv_dimensions_6_0= ruleXJArrayDimension
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

					// InternalDsl.g:5095:4: ( (lv_indexes_7_0= ruleXExpression ) )?
					int alt84=2;
					int LA84_0 = input.LA(1);
					if ( ((LA84_0 >= RULE_CHARACTER && LA84_0 <= RULE_INT)||LA84_0==RULE_STRING||LA84_0==14||LA84_0==22||(LA84_0 >= 28 && LA84_0 <= 29)||(LA84_0 >= 32 && LA84_0 <= 33)||(LA84_0 >= 89 && LA84_0 <= 91)||LA84_0==96||(LA84_0 >= 98 && LA84_0 <= 99)||(LA84_0 >= 101 && LA84_0 <= 102)||LA84_0==106||LA84_0==109||LA84_0==114) ) {
						alt84=1;
					}
					switch (alt84) {
						case 1 :
							// InternalDsl.g:5096:5: (lv_indexes_7_0= ruleXExpression )
							{
							// InternalDsl.g:5096:5: (lv_indexes_7_0= ruleXExpression )
							// InternalDsl.g:5097:6: lv_indexes_7_0= ruleXExpression
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

					otherlv_8=(Token)match(input,78,FOLLOW_79); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_8, grammarAccess.getXJArrayConstructorCallAccess().getRightSquareBracketKeyword_3_2());
								}
					}
					break;

				default :
					break loop85;
				}
			}

			// InternalDsl.g:5119:3: ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )?
			int alt86=2;
			alt86 = dfa86.predict(input);
			switch (alt86) {
				case 1 :
					// InternalDsl.g:5120:4: ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral )
					{
					// InternalDsl.g:5124:4: (lv_arrayLiteral_9_0= ruleXJArrayLiteral )
					// InternalDsl.g:5125:5: lv_arrayLiteral_9_0= ruleXJArrayLiteral
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
	// InternalDsl.g:5146:1: entryRuleXJArrayDimension returns [EObject current=null] :iv_ruleXJArrayDimension= ruleXJArrayDimension EOF ;
	public final EObject entryRuleXJArrayDimension() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJArrayDimension =null;

		try {
			// InternalDsl.g:5146:57: (iv_ruleXJArrayDimension= ruleXJArrayDimension EOF )
			// InternalDsl.g:5147:2: iv_ruleXJArrayDimension= ruleXJArrayDimension EOF
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
	// InternalDsl.g:5153:1: ruleXJArrayDimension returns [EObject current=null] : ( () otherlv_1= '[' ) ;
	public final EObject ruleXJArrayDimension() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;


			enterRule();

		try {
			// InternalDsl.g:5159:2: ( ( () otherlv_1= '[' ) )
			// InternalDsl.g:5160:2: ( () otherlv_1= '[' )
			{
			// InternalDsl.g:5160:2: ( () otherlv_1= '[' )
			// InternalDsl.g:5161:3: () otherlv_1= '['
			{
			// InternalDsl.g:5161:3: ()
			// InternalDsl.g:5162:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJArrayDimensionAccess().getXJArrayDimensionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:5176:1: entryRuleXCastedExpression returns [EObject current=null] :iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
	public final EObject entryRuleXCastedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCastedExpression =null;

		try {
			// InternalDsl.g:5176:58: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
			// InternalDsl.g:5177:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
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
	// InternalDsl.g:5183:1: ruleXCastedExpression returns [EObject current=null] : ( ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) ) |this_XPostfixOperation_5= ruleXPostfixOperation ) ;
	public final EObject ruleXCastedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		EObject lv_type_2_0 =null;
		EObject lv_target_4_0 =null;
		EObject this_XPostfixOperation_5 =null;


			enterRule();

		try {
			// InternalDsl.g:5189:2: ( ( ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) ) |this_XPostfixOperation_5= ruleXPostfixOperation ) )
			// InternalDsl.g:5190:2: ( ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) ) |this_XPostfixOperation_5= ruleXPostfixOperation )
			{
			// InternalDsl.g:5190:2: ( ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) ) |this_XPostfixOperation_5= ruleXPostfixOperation )
			int alt87=2;
			int LA87_0 = input.LA(1);
			if ( (LA87_0==22) ) {
				int LA87_1 = input.LA(2);
				if ( (synpred25_InternalDsl()) ) {
					alt87=1;
				}
				else if ( (true) ) {
					alt87=2;
				}

			}
			else if ( ((LA87_0 >= RULE_CHARACTER && LA87_0 <= RULE_INT)||LA87_0==RULE_STRING||LA87_0==29||LA87_0==33||(LA87_0 >= 89 && LA87_0 <= 91)||LA87_0==96||(LA87_0 >= 98 && LA87_0 <= 99)||(LA87_0 >= 101 && LA87_0 <= 102)||LA87_0==106||LA87_0==109) ) {
				alt87=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 87, 0, input);
				throw nvae;
			}

			switch (alt87) {
				case 1 :
					// InternalDsl.g:5191:3: ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) )
					{
					// InternalDsl.g:5191:3: ( ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) ) )
					// InternalDsl.g:5192:4: ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )=> ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) )
					{
					// InternalDsl.g:5209:4: ( () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) ) )
					// InternalDsl.g:5210:5: () otherlv_1= '(' ( (lv_type_2_0= ruleJvmTypeReference ) ) otherlv_3= ')' ( (lv_target_4_0= ruleXExpression ) )
					{
					// InternalDsl.g:5210:5: ()
					// InternalDsl.g:5211:6: 
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
					// InternalDsl.g:5221:5: ( (lv_type_2_0= ruleJvmTypeReference ) )
					// InternalDsl.g:5222:6: (lv_type_2_0= ruleJvmTypeReference )
					{
					// InternalDsl.g:5222:6: (lv_type_2_0= ruleJvmTypeReference )
					// InternalDsl.g:5223:7: lv_type_2_0= ruleJvmTypeReference
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
					// InternalDsl.g:5244:5: ( (lv_target_4_0= ruleXExpression ) )
					// InternalDsl.g:5245:6: (lv_target_4_0= ruleXExpression )
					{
					// InternalDsl.g:5245:6: (lv_target_4_0= ruleXExpression )
					// InternalDsl.g:5246:7: lv_target_4_0= ruleXExpression
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
					// InternalDsl.g:5266:3: this_XPostfixOperation_5= ruleXPostfixOperation
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
	// InternalDsl.g:5278:1: entryRuleXPostfixOperation returns [EObject current=null] :iv_ruleXPostfixOperation= ruleXPostfixOperation EOF ;
	public final EObject entryRuleXPostfixOperation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXPostfixOperation =null;

		try {
			// InternalDsl.g:5278:58: (iv_ruleXPostfixOperation= ruleXPostfixOperation EOF )
			// InternalDsl.g:5279:2: iv_ruleXPostfixOperation= ruleXPostfixOperation EOF
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
			int alt90=2;
			int LA90_0 = input.LA(1);
			if ( (LA90_0==29) && (synpred26_InternalDsl())) {
				alt90=1;
			}
			else if ( (LA90_0==33) && (synpred26_InternalDsl())) {
				alt90=1;
			}
			else if ( ((LA90_0 >= RULE_CHARACTER && LA90_0 <= RULE_INT)||LA90_0==RULE_STRING||LA90_0==22||(LA90_0 >= 89 && LA90_0 <= 91)||LA90_0==96||(LA90_0 >= 98 && LA90_0 <= 99)||(LA90_0 >= 101 && LA90_0 <= 102)||LA90_0==106||LA90_0==109) ) {
				alt90=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 90, 0, input);
				throw nvae;
			}

			switch (alt90) {
				case 1 :
					// InternalDsl.g:5293:3: ( ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
					{
					// InternalDsl.g:5293:3: ( ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
					// InternalDsl.g:5294:4: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
					{
					// InternalDsl.g:5294:4: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )
					// InternalDsl.g:5295:5: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
					{
					// InternalDsl.g:5305:5: ( () ( ( ruleOpPostfix ) ) )
					// InternalDsl.g:5306:6: () ( ( ruleOpPostfix ) )
					{
					// InternalDsl.g:5306:6: ()
					// InternalDsl.g:5307:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElement(
													grammarAccess.getXPostfixOperationAccess().getXJPrefixOperationAction_0_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:5313:6: ( ( ruleOpPostfix ) )
					// InternalDsl.g:5314:7: ( ruleOpPostfix )
					{
					// InternalDsl.g:5314:7: ( ruleOpPostfix )
					// InternalDsl.g:5315:8: ruleOpPostfix
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

					// InternalDsl.g:5331:4: ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
					// InternalDsl.g:5332:5: (lv_operand_2_0= ruleXMemberFeatureCall )
					{
					// InternalDsl.g:5332:5: (lv_operand_2_0= ruleXMemberFeatureCall )
					// InternalDsl.g:5333:6: lv_operand_2_0= ruleXMemberFeatureCall
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
					int alt89=3;
					switch ( input.LA(1) ) {
						case 29:
							{
							int LA89_1 = input.LA(2);
							if ( (synpred27_InternalDsl()) ) {
								alt89=1;
							}
							}
							break;
						case 33:
							{
							int LA89_2 = input.LA(2);
							if ( (synpred27_InternalDsl()) ) {
								alt89=1;
							}
							}
							break;
						case 77:
							{
							int LA89_3 = input.LA(2);
							if ( (synpred29_InternalDsl()) ) {
								alt89=2;
							}
							}
							break;
					}
					switch (alt89) {
						case 1 :
							// InternalDsl.g:5362:5: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )
							{
							// InternalDsl.g:5362:5: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )
							// InternalDsl.g:5363:6: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
							{
							// InternalDsl.g:5373:6: ( () ( ( ruleOpPostfix ) ) )
							// InternalDsl.g:5374:7: () ( ( ruleOpPostfix ) )
							{
							// InternalDsl.g:5374:7: ()
							// InternalDsl.g:5375:8: 
							{
							if ( state.backtracking==0 ) {
															current = forceCreateModelElementAndSet(
																grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_1_0_0_0(),
																current);
														}
							}

							// InternalDsl.g:5381:7: ( ( ruleOpPostfix ) )
							// InternalDsl.g:5382:8: ( ruleOpPostfix )
							{
							// InternalDsl.g:5382:8: ( ruleOpPostfix )
							// InternalDsl.g:5383:9: ruleOpPostfix
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
							// InternalDsl.g:5425:6: ( () otherlv_7= '[' ( (lv_indexes_8_0= ruleXExpression ) ) otherlv_9= ']' ( ( ( '[' )=>otherlv_10= '[' ) ( (lv_indexes_11_0= ruleXExpression ) ) otherlv_12= ']' )* )
							// InternalDsl.g:5426:7: () otherlv_7= '[' ( (lv_indexes_8_0= ruleXExpression ) ) otherlv_9= ']' ( ( ( '[' )=>otherlv_10= '[' ) ( (lv_indexes_11_0= ruleXExpression ) ) otherlv_12= ']' )*
							{
							// InternalDsl.g:5426:7: ()
							// InternalDsl.g:5427:8: 
							{
							if ( state.backtracking==0 ) {
															current = forceCreateModelElementAndSet(
																grammarAccess.getXPostfixOperationAccess().getXJArrayAccessExpressionArrayAction_1_1_1_0_0(),
																current);
														}
							}

							otherlv_7=(Token)match(input,77,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_7, grammarAccess.getXPostfixOperationAccess().getLeftSquareBracketKeyword_1_1_1_0_1());
													}
							// InternalDsl.g:5437:7: ( (lv_indexes_8_0= ruleXExpression ) )
							// InternalDsl.g:5438:8: (lv_indexes_8_0= ruleXExpression )
							{
							// InternalDsl.g:5438:8: (lv_indexes_8_0= ruleXExpression )
							// InternalDsl.g:5439:9: lv_indexes_8_0= ruleXExpression
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

							otherlv_9=(Token)match(input,78,FOLLOW_62); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_9, grammarAccess.getXPostfixOperationAccess().getRightSquareBracketKeyword_1_1_1_0_3());
													}
							// InternalDsl.g:5460:7: ( ( ( '[' )=>otherlv_10= '[' ) ( (lv_indexes_11_0= ruleXExpression ) ) otherlv_12= ']' )*
							loop88:
							while (true) {
								int alt88=2;
								alt88 = dfa88.predict(input);
								switch (alt88) {
								case 1 :
									// InternalDsl.g:5461:8: ( ( '[' )=>otherlv_10= '[' ) ( (lv_indexes_11_0= ruleXExpression ) ) otherlv_12= ']'
									{
									// InternalDsl.g:5461:8: ( ( '[' )=>otherlv_10= '[' )
									// InternalDsl.g:5462:9: ( '[' )=>otherlv_10= '['
									{
									otherlv_10=(Token)match(input,77,FOLLOW_66); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																		newLeafNode(otherlv_10, grammarAccess.getXPostfixOperationAccess().getLeftSquareBracketKeyword_1_1_1_0_4_0());
																	}
									}

									// InternalDsl.g:5468:8: ( (lv_indexes_11_0= ruleXExpression ) )
									// InternalDsl.g:5469:9: (lv_indexes_11_0= ruleXExpression )
									{
									// InternalDsl.g:5469:9: (lv_indexes_11_0= ruleXExpression )
									// InternalDsl.g:5470:10: lv_indexes_11_0= ruleXExpression
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

									otherlv_12=(Token)match(input,78,FOLLOW_62); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	newLeafNode(otherlv_12, grammarAccess.getXPostfixOperationAccess().getRightSquareBracketKeyword_1_1_1_0_4_2());
																}
									}
									break;

								default :
									break loop88;
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
	// InternalDsl.g:5500:1: entryRuleXMemberFeatureCall returns [EObject current=null] :iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
	public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXMemberFeatureCall =null;

		try {
			// InternalDsl.g:5500:59: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
			// InternalDsl.g:5501:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
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
	// InternalDsl.g:5507:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )* ) ;
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
			// InternalDsl.g:5513:2: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )* ) )
			// InternalDsl.g:5514:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )* )
			{
			// InternalDsl.g:5514:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )* )
			// InternalDsl.g:5515:3: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )*
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
			// InternalDsl.g:5523:3: ( ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) ) | ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) ) | ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? ) )*
			loop95:
			while (true) {
				int alt95=4;
				int LA95_0 = input.LA(1);
				if ( (LA95_0==77) ) {
					int LA95_2 = input.LA(2);
					if ( (synpred31_InternalDsl()) ) {
						alt95=1;
					}

				}
				else if ( (LA95_0==36) ) {
					int LA95_3 = input.LA(2);
					if ( (synpred31_InternalDsl()) ) {
						alt95=1;
					}
					else if ( (synpred32_InternalDsl()) ) {
						alt95=2;
					}
					else if ( (synpred33_InternalDsl()) ) {
						alt95=3;
					}

				}

				switch (alt95) {
				case 1 :
					// InternalDsl.g:5524:4: ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) )
					{
					// InternalDsl.g:5524:4: ( ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' ) )
					// InternalDsl.g:5525:5: ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )=> ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' )
					{
					// InternalDsl.g:5537:5: ( () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class' )
					// InternalDsl.g:5538:6: () ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )* otherlv_3= '.' otherlv_4= 'class'
					{
					// InternalDsl.g:5538:6: ()
					// InternalDsl.g:5539:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXMemberFeatureCallAccess().getXJClassObjectTypeExpressionAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:5545:6: ( (lv_arrayDimensions_2_0= ruleArrayBrackets ) )*
					loop91:
					while (true) {
						int alt91=2;
						int LA91_0 = input.LA(1);
						if ( (LA91_0==77) ) {
							alt91=1;
						}

						switch (alt91) {
						case 1 :
							// InternalDsl.g:5546:7: (lv_arrayDimensions_2_0= ruleArrayBrackets )
							{
							// InternalDsl.g:5546:7: (lv_arrayDimensions_2_0= ruleArrayBrackets )
							// InternalDsl.g:5547:8: lv_arrayDimensions_2_0= ruleArrayBrackets
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
							break loop91;
						}
					}

					otherlv_3=(Token)match(input,36,FOLLOW_84); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_3, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_2());
										}
					otherlv_4=(Token)match(input,84,FOLLOW_82); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_4, grammarAccess.getXMemberFeatureCallAccess().getClassKeyword_1_0_0_3());
										}
					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:5575:4: ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) )
					{
					// InternalDsl.g:5575:4: ( ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) ) )
					// InternalDsl.g:5576:5: ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_9_0= ruleXAssignment ) )
					{
					// InternalDsl.g:5576:5: ( ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
					// InternalDsl.g:5577:6: ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					{
					// InternalDsl.g:5589:6: ( () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					// InternalDsl.g:5590:7: () otherlv_6= '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
					{
					// InternalDsl.g:5590:7: ()
					// InternalDsl.g:5591:8: 
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
					// InternalDsl.g:5601:7: ( ( ruleFeatureCallID ) )
					// InternalDsl.g:5602:8: ( ruleFeatureCallID )
					{
					// InternalDsl.g:5602:8: ( ruleFeatureCallID )
					// InternalDsl.g:5603:9: ruleFeatureCallID
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

					// InternalDsl.g:5626:5: ( (lv_value_9_0= ruleXAssignment ) )
					// InternalDsl.g:5627:6: (lv_value_9_0= ruleXAssignment )
					{
					// InternalDsl.g:5627:6: (lv_value_9_0= ruleXAssignment )
					// InternalDsl.g:5628:7: lv_value_9_0= ruleXAssignment
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
					// InternalDsl.g:5647:4: ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? )
					{
					// InternalDsl.g:5647:4: ( ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )? )
					// InternalDsl.g:5648:5: ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) ) ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )?
					{
					// InternalDsl.g:5648:5: ( ( ( () '.' ) )=> ( () otherlv_11= '.' ) )
					// InternalDsl.g:5649:6: ( ( () '.' ) )=> ( () otherlv_11= '.' )
					{
					// InternalDsl.g:5655:6: ( () otherlv_11= '.' )
					// InternalDsl.g:5656:7: () otherlv_11= '.'
					{
					// InternalDsl.g:5656:7: ()
					// InternalDsl.g:5657:8: 
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

					// InternalDsl.g:5669:5: ( ( ruleIdOrSuper ) )
					// InternalDsl.g:5670:6: ( ruleIdOrSuper )
					{
					// InternalDsl.g:5670:6: ( ruleIdOrSuper )
					// InternalDsl.g:5671:7: ruleIdOrSuper
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

					// InternalDsl.g:5685:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )?
					int alt94=2;
					alt94 = dfa94.predict(input);
					switch (alt94) {
						case 1 :
							// InternalDsl.g:5686:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')'
							{
							// InternalDsl.g:5686:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) )
							// InternalDsl.g:5687:7: ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' )
							{
							// InternalDsl.g:5691:7: (lv_explicitOperationCall_13_0= '(' )
							// InternalDsl.g:5692:8: lv_explicitOperationCall_13_0= '('
							{
							lv_explicitOperationCall_13_0=(Token)match(input,22,FOLLOW_73); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(lv_explicitOperationCall_13_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_2_2_0_0());
														}
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
															}
															setWithLastConsumed(current, "explicitOperationCall", true, "(");
														}
							}

							}

							// InternalDsl.g:5704:6: ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )?
							int alt93=2;
							int LA93_0 = input.LA(1);
							if ( ((LA93_0 >= RULE_CHARACTER && LA93_0 <= RULE_INT)||LA93_0==RULE_STRING||LA93_0==14||LA93_0==22||(LA93_0 >= 28 && LA93_0 <= 29)||(LA93_0 >= 32 && LA93_0 <= 33)||(LA93_0 >= 89 && LA93_0 <= 91)||LA93_0==96||(LA93_0 >= 98 && LA93_0 <= 99)||(LA93_0 >= 101 && LA93_0 <= 102)||LA93_0==106||LA93_0==109||LA93_0==114) ) {
								alt93=1;
							}
							switch (alt93) {
								case 1 :
									// InternalDsl.g:5705:7: ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )*
									{
									// InternalDsl.g:5705:7: ( (lv_memberCallArguments_14_0= ruleXExpression ) )
									// InternalDsl.g:5706:8: (lv_memberCallArguments_14_0= ruleXExpression )
									{
									// InternalDsl.g:5706:8: (lv_memberCallArguments_14_0= ruleXExpression )
									// InternalDsl.g:5707:9: lv_memberCallArguments_14_0= ruleXExpression
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

									// InternalDsl.g:5724:7: (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )*
									loop92:
									while (true) {
										int alt92=2;
										int LA92_0 = input.LA(1);
										if ( (LA92_0==31) ) {
											alt92=1;
										}

										switch (alt92) {
										case 1 :
											// InternalDsl.g:5725:8: otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) )
											{
											otherlv_15=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																			newLeafNode(otherlv_15, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_2_2_1_1_0());
																		}
											// InternalDsl.g:5729:8: ( (lv_memberCallArguments_16_0= ruleXExpression ) )
											// InternalDsl.g:5730:9: (lv_memberCallArguments_16_0= ruleXExpression )
											{
											// InternalDsl.g:5730:9: (lv_memberCallArguments_16_0= ruleXExpression )
											// InternalDsl.g:5731:10: lv_memberCallArguments_16_0= ruleXExpression
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
											break loop92;
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
					break loop95;
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
	// InternalDsl.g:5761:1: entryRuleXForLoopExpression returns [EObject current=null] :iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
	public final EObject entryRuleXForLoopExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXForLoopExpression =null;

		try {
			// InternalDsl.g:5761:59: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
			// InternalDsl.g:5762:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
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
	// InternalDsl.g:5768:1: ruleXForLoopExpression returns [EObject current=null] : ( ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) ) ) ;
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
			// InternalDsl.g:5774:2: ( ( ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) ) ) )
			// InternalDsl.g:5775:2: ( ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) ) )
			{
			// InternalDsl.g:5775:2: ( ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) ) )
			// InternalDsl.g:5776:3: ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) )
			{
			// InternalDsl.g:5776:3: ( ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' ) )
			// InternalDsl.g:5777:4: ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' )
			{
			// InternalDsl.g:5790:4: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':' )
			// InternalDsl.g:5791:5: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ':'
			{
			// InternalDsl.g:5791:5: ()
			// InternalDsl.g:5792:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,94,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0_0_1());
							}
			otherlv_2=(Token)match(input,22,FOLLOW_87); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2());
							}
			// InternalDsl.g:5806:5: ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) )
			// InternalDsl.g:5807:6: (lv_declaredParam_3_0= ruleFullJvmFormalParameter )
			{
			// InternalDsl.g:5807:6: (lv_declaredParam_3_0= ruleFullJvmFormalParameter )
			// InternalDsl.g:5808:7: lv_declaredParam_3_0= ruleFullJvmFormalParameter
			{
			if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_0_0_3_0());
									}
			pushFollow(FOLLOW_34);
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

			// InternalDsl.g:5831:3: ( (lv_forExpression_5_0= ruleXExpression ) )
			// InternalDsl.g:5832:4: (lv_forExpression_5_0= ruleXExpression )
			{
			// InternalDsl.g:5832:4: (lv_forExpression_5_0= ruleXExpression )
			// InternalDsl.g:5833:5: lv_forExpression_5_0= ruleXExpression
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

			otherlv_6=(Token)match(input,25,FOLLOW_36); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_2());
					}
			// InternalDsl.g:5854:3: ( (lv_eachExpression_7_0= ruleXJStatementOrBlock ) )
			// InternalDsl.g:5855:4: (lv_eachExpression_7_0= ruleXJStatementOrBlock )
			{
			// InternalDsl.g:5855:4: (lv_eachExpression_7_0= ruleXJStatementOrBlock )
			// InternalDsl.g:5856:5: lv_eachExpression_7_0= ruleXJStatementOrBlock
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
	// InternalDsl.g:5877:1: entryRuleXBasicForLoopExpression returns [EObject current=null] :iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF ;
	public final EObject entryRuleXBasicForLoopExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBasicForLoopExpression =null;

		try {
			// InternalDsl.g:5877:64: (iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF )
			// InternalDsl.g:5878:2: iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF
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
	// InternalDsl.g:5884:1: ruleXBasicForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) ) ) ;
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
			// InternalDsl.g:5890:2: ( ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) ) ) )
			// InternalDsl.g:5891:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) ) )
			{
			// InternalDsl.g:5891:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) ) )
			// InternalDsl.g:5892:3: () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) )
			{
			// InternalDsl.g:5892:3: ()
			// InternalDsl.g:5893:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBasicForLoopExpressionAccess().getXBasicForLoopExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,94,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXBasicForLoopExpressionAccess().getForKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_88); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXBasicForLoopExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:5907:3: ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )?
			int alt97=2;
			int LA97_0 = input.LA(1);
			if ( ((LA97_0 >= RULE_CHARACTER && LA97_0 <= RULE_INT)||LA97_0==RULE_STRING||LA97_0==14||LA97_0==22||(LA97_0 >= 28 && LA97_0 <= 29)||(LA97_0 >= 32 && LA97_0 <= 33)||(LA97_0 >= 89 && LA97_0 <= 92)||LA97_0==96||(LA97_0 >= 98 && LA97_0 <= 99)||(LA97_0 >= 101 && LA97_0 <= 102)||LA97_0==106||LA97_0==109||LA97_0==114) ) {
				alt97=1;
			}
			switch (alt97) {
				case 1 :
					// InternalDsl.g:5908:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
					{
					// InternalDsl.g:5908:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) )
					// InternalDsl.g:5909:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
					{
					// InternalDsl.g:5909:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
					// InternalDsl.g:5910:6: lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration
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

					// InternalDsl.g:5927:4: (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
					loop96:
					while (true) {
						int alt96=2;
						int LA96_0 = input.LA(1);
						if ( (LA96_0==31) ) {
							alt96=1;
						}

						switch (alt96) {
						case 1 :
							// InternalDsl.g:5928:5: otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
							{
							otherlv_4=(Token)match(input,31,FOLLOW_90); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_3_1_0());
											}
							// InternalDsl.g:5932:5: ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
							// InternalDsl.g:5933:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
							{
							// InternalDsl.g:5933:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
							// InternalDsl.g:5934:7: lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration
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
							break loop96;
						}
					}

					}
					break;

			}

			otherlv_6=(Token)match(input,41,FOLLOW_91); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_4());
					}
			// InternalDsl.g:5957:3: ( (lv_expression_7_0= ruleXExpression ) )?
			int alt98=2;
			int LA98_0 = input.LA(1);
			if ( ((LA98_0 >= RULE_CHARACTER && LA98_0 <= RULE_INT)||LA98_0==RULE_STRING||LA98_0==14||LA98_0==22||(LA98_0 >= 28 && LA98_0 <= 29)||(LA98_0 >= 32 && LA98_0 <= 33)||(LA98_0 >= 89 && LA98_0 <= 91)||LA98_0==96||(LA98_0 >= 98 && LA98_0 <= 99)||(LA98_0 >= 101 && LA98_0 <= 102)||LA98_0==106||LA98_0==109||LA98_0==114) ) {
				alt98=1;
			}
			switch (alt98) {
				case 1 :
					// InternalDsl.g:5958:4: (lv_expression_7_0= ruleXExpression )
					{
					// InternalDsl.g:5958:4: (lv_expression_7_0= ruleXExpression )
					// InternalDsl.g:5959:5: lv_expression_7_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionXExpressionParserRuleCall_5_0());
									}
					pushFollow(FOLLOW_32);
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
			// InternalDsl.g:5980:3: ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )?
			int alt100=2;
			int LA100_0 = input.LA(1);
			if ( ((LA100_0 >= RULE_CHARACTER && LA100_0 <= RULE_INT)||LA100_0==RULE_STRING||LA100_0==14||LA100_0==22||(LA100_0 >= 28 && LA100_0 <= 29)||(LA100_0 >= 32 && LA100_0 <= 33)||(LA100_0 >= 89 && LA100_0 <= 91)||LA100_0==96||(LA100_0 >= 98 && LA100_0 <= 99)||(LA100_0 >= 101 && LA100_0 <= 102)||LA100_0==106||LA100_0==109||LA100_0==114) ) {
				alt100=1;
			}
			switch (alt100) {
				case 1 :
					// InternalDsl.g:5981:4: ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
					{
					// InternalDsl.g:5981:4: ( (lv_updateExpressions_9_0= ruleXExpression ) )
					// InternalDsl.g:5982:5: (lv_updateExpressions_9_0= ruleXExpression )
					{
					// InternalDsl.g:5982:5: (lv_updateExpressions_9_0= ruleXExpression )
					// InternalDsl.g:5983:6: lv_updateExpressions_9_0= ruleXExpression
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

					// InternalDsl.g:6000:4: (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
					loop99:
					while (true) {
						int alt99=2;
						int LA99_0 = input.LA(1);
						if ( (LA99_0==31) ) {
							alt99=1;
						}

						switch (alt99) {
						case 1 :
							// InternalDsl.g:6001:5: otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) )
							{
							otherlv_10=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_10, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_7_1_0());
											}
							// InternalDsl.g:6005:5: ( (lv_updateExpressions_11_0= ruleXExpression ) )
							// InternalDsl.g:6006:6: (lv_updateExpressions_11_0= ruleXExpression )
							{
							// InternalDsl.g:6006:6: (lv_updateExpressions_11_0= ruleXExpression )
							// InternalDsl.g:6007:7: lv_updateExpressions_11_0= ruleXExpression
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
							break loop99;
						}
					}

					}
					break;

			}

			otherlv_12=(Token)match(input,25,FOLLOW_36); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_12, grammarAccess.getXBasicForLoopExpressionAccess().getRightParenthesisKeyword_8());
					}
			// InternalDsl.g:6030:3: ( (lv_eachExpression_13_0= ruleXJStatementOrBlock ) )
			// InternalDsl.g:6031:4: (lv_eachExpression_13_0= ruleXJStatementOrBlock )
			{
			// InternalDsl.g:6031:4: (lv_eachExpression_13_0= ruleXJStatementOrBlock )
			// InternalDsl.g:6032:5: lv_eachExpression_13_0= ruleXJStatementOrBlock
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
	// InternalDsl.g:6053:1: entryRuleXIfExpression returns [EObject current=null] :iv_ruleXIfExpression= ruleXIfExpression EOF ;
	public final EObject entryRuleXIfExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXIfExpression =null;

		try {
			// InternalDsl.g:6053:54: (iv_ruleXIfExpression= ruleXIfExpression EOF )
			// InternalDsl.g:6054:2: iv_ruleXIfExpression= ruleXIfExpression EOF
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
	// InternalDsl.g:6060:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXJStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )? ) ;
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
			// InternalDsl.g:6066:2: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXJStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )? ) )
			// InternalDsl.g:6067:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXJStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )? )
			{
			// InternalDsl.g:6067:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXJStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )? )
			// InternalDsl.g:6068:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXJStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )?
			{
			// InternalDsl.g:6068:3: ()
			// InternalDsl.g:6069:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,95,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:6083:3: ( (lv_if_3_0= ruleXExpression ) )
			// InternalDsl.g:6084:4: (lv_if_3_0= ruleXExpression )
			{
			// InternalDsl.g:6084:4: (lv_if_3_0= ruleXExpression )
			// InternalDsl.g:6085:5: lv_if_3_0= ruleXExpression
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

			otherlv_4=(Token)match(input,25,FOLLOW_36); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
					}
			// InternalDsl.g:6106:3: ( (lv_then_5_0= ruleXJStatementOrBlock ) )
			// InternalDsl.g:6107:4: (lv_then_5_0= ruleXJStatementOrBlock )
			{
			// InternalDsl.g:6107:4: (lv_then_5_0= ruleXJStatementOrBlock )
			// InternalDsl.g:6108:5: lv_then_5_0= ruleXJStatementOrBlock
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

			// InternalDsl.g:6125:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) ) )?
			int alt101=2;
			int LA101_0 = input.LA(1);
			if ( (LA101_0==88) ) {
				int LA101_1 = input.LA(2);
				if ( (synpred36_InternalDsl()) ) {
					alt101=1;
				}
			}
			switch (alt101) {
				case 1 :
					// InternalDsl.g:6126:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXJStatementOrBlock ) )
					{
					// InternalDsl.g:6126:4: ( ( 'else' )=>otherlv_6= 'else' )
					// InternalDsl.g:6127:5: ( 'else' )=>otherlv_6= 'else'
					{
					otherlv_6=(Token)match(input,88,FOLLOW_36); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
									}
					}

					// InternalDsl.g:6133:4: ( (lv_else_7_0= ruleXJStatementOrBlock ) )
					// InternalDsl.g:6134:5: (lv_else_7_0= ruleXJStatementOrBlock )
					{
					// InternalDsl.g:6134:5: (lv_else_7_0= ruleXJStatementOrBlock )
					// InternalDsl.g:6135:6: lv_else_7_0= ruleXJStatementOrBlock
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
	// InternalDsl.g:6157:1: entryRuleXWhileExpression returns [EObject current=null] :iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
	public final EObject entryRuleXWhileExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXWhileExpression =null;

		try {
			// InternalDsl.g:6157:57: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
			// InternalDsl.g:6158:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
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
	// InternalDsl.g:6164:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXJStatementOrBlock ) ) ) ;
	public final EObject ruleXWhileExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_predicate_3_0 =null;
		EObject lv_body_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6170:2: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXJStatementOrBlock ) ) ) )
			// InternalDsl.g:6171:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXJStatementOrBlock ) ) )
			{
			// InternalDsl.g:6171:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXJStatementOrBlock ) ) )
			// InternalDsl.g:6172:3: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXJStatementOrBlock ) )
			{
			// InternalDsl.g:6172:3: ()
			// InternalDsl.g:6173:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,108,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:6187:3: ( (lv_predicate_3_0= ruleXExpression ) )
			// InternalDsl.g:6188:4: (lv_predicate_3_0= ruleXExpression )
			{
			// InternalDsl.g:6188:4: (lv_predicate_3_0= ruleXExpression )
			// InternalDsl.g:6189:5: lv_predicate_3_0= ruleXExpression
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

			otherlv_4=(Token)match(input,25,FOLLOW_36); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
					}
			// InternalDsl.g:6210:3: ( (lv_body_5_0= ruleXJStatementOrBlock ) )
			// InternalDsl.g:6211:4: (lv_body_5_0= ruleXJStatementOrBlock )
			{
			// InternalDsl.g:6211:4: (lv_body_5_0= ruleXJStatementOrBlock )
			// InternalDsl.g:6212:5: lv_body_5_0= ruleXJStatementOrBlock
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
	// InternalDsl.g:6233:1: entryRuleXDoWhileExpression returns [EObject current=null] :iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
	public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXDoWhileExpression =null;

		try {
			// InternalDsl.g:6233:59: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
			// InternalDsl.g:6234:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
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
	// InternalDsl.g:6240:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXJStatementOrBlock ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
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
			// InternalDsl.g:6246:2: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXJStatementOrBlock ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
			// InternalDsl.g:6247:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXJStatementOrBlock ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
			{
			// InternalDsl.g:6247:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXJStatementOrBlock ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
			// InternalDsl.g:6248:3: () otherlv_1= 'do' ( (lv_body_2_0= ruleXJStatementOrBlock ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
			{
			// InternalDsl.g:6248:3: ()
			// InternalDsl.g:6249:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,87,FOLLOW_36); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
					}
			// InternalDsl.g:6259:3: ( (lv_body_2_0= ruleXJStatementOrBlock ) )
			// InternalDsl.g:6260:4: (lv_body_2_0= ruleXJStatementOrBlock )
			{
			// InternalDsl.g:6260:4: (lv_body_2_0= ruleXJStatementOrBlock )
			// InternalDsl.g:6261:5: lv_body_2_0= ruleXJStatementOrBlock
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

			otherlv_3=(Token)match(input,108,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
					}
			otherlv_4=(Token)match(input,22,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
					}
			// InternalDsl.g:6286:3: ( (lv_predicate_5_0= ruleXExpression ) )
			// InternalDsl.g:6287:4: (lv_predicate_5_0= ruleXExpression )
			{
			// InternalDsl.g:6287:4: (lv_predicate_5_0= ruleXExpression )
			// InternalDsl.g:6288:5: lv_predicate_5_0= ruleXExpression
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
	// InternalDsl.g:6313:1: entryRuleXSwitchExpression returns [EObject current=null] :iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
	public final EObject entryRuleXSwitchExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSwitchExpression =null;

		try {
			// InternalDsl.g:6313:58: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
			// InternalDsl.g:6314:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
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
	// InternalDsl.g:6320:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' otherlv_2= '(' ( (lv_switch_3_0= ruleXExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )* (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )? otherlv_10= '}' ) ;
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
			// InternalDsl.g:6326:2: ( ( () otherlv_1= 'switch' otherlv_2= '(' ( (lv_switch_3_0= ruleXExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )* (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )? otherlv_10= '}' ) )
			// InternalDsl.g:6327:2: ( () otherlv_1= 'switch' otherlv_2= '(' ( (lv_switch_3_0= ruleXExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )* (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )? otherlv_10= '}' )
			{
			// InternalDsl.g:6327:2: ( () otherlv_1= 'switch' otherlv_2= '(' ( (lv_switch_3_0= ruleXExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )* (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )? otherlv_10= '}' )
			// InternalDsl.g:6328:3: () otherlv_1= 'switch' otherlv_2= '(' ( (lv_switch_3_0= ruleXExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )* (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )? otherlv_10= '}'
			{
			// InternalDsl.g:6328:3: ()
			// InternalDsl.g:6329:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,103,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
					}
			otherlv_2=(Token)match(input,22,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:6343:3: ( (lv_switch_3_0= ruleXExpression ) )
			// InternalDsl.g:6344:4: (lv_switch_3_0= ruleXExpression )
			{
			// InternalDsl.g:6344:4: (lv_switch_3_0= ruleXExpression )
			// InternalDsl.g:6345:5: lv_switch_3_0= ruleXExpression
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
			otherlv_5=(Token)match(input,109,FOLLOW_94); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_5());
					}
			// InternalDsl.g:6370:3: ( (lv_cases_6_0= ruleXCasePart ) )*
			loop102:
			while (true) {
				int alt102=2;
				int LA102_0 = input.LA(1);
				if ( (LA102_0==82) ) {
					alt102=1;
				}

				switch (alt102) {
				case 1 :
					// InternalDsl.g:6371:4: (lv_cases_6_0= ruleXCasePart )
					{
					// InternalDsl.g:6371:4: (lv_cases_6_0= ruleXCasePart )
					// InternalDsl.g:6372:5: lv_cases_6_0= ruleXCasePart
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
					break loop102;
				}
			}

			// InternalDsl.g:6389:3: (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) ) )?
			int alt103=2;
			int LA103_0 = input.LA(1);
			if ( (LA103_0==86) ) {
				alt103=1;
			}
			switch (alt103) {
				case 1 :
					// InternalDsl.g:6390:4: otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXJSwitchStatements ) )
					{
					otherlv_7=(Token)match(input,86,FOLLOW_34); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_7_0());
								}
					otherlv_8=(Token)match(input,40,FOLLOW_64); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_7_1());
								}
					// InternalDsl.g:6398:4: ( (lv_default_9_0= ruleXJSwitchStatements ) )
					// InternalDsl.g:6399:5: (lv_default_9_0= ruleXJSwitchStatements )
					{
					// InternalDsl.g:6399:5: (lv_default_9_0= ruleXJSwitchStatements )
					// InternalDsl.g:6400:6: lv_default_9_0= ruleXJSwitchStatements
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

			otherlv_10=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:6426:1: entryRuleXCasePart returns [EObject current=null] :iv_ruleXCasePart= ruleXCasePart EOF ;
	public final EObject entryRuleXCasePart() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCasePart =null;

		try {
			// InternalDsl.g:6426:50: (iv_ruleXCasePart= ruleXCasePart EOF )
			// InternalDsl.g:6427:2: iv_ruleXCasePart= ruleXCasePart EOF
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
	// InternalDsl.g:6433:1: ruleXCasePart returns [EObject current=null] : ( () otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) otherlv_3= ':' ( (lv_then_4_0= ruleXJSwitchStatements ) ) ) ;
	public final EObject ruleXCasePart() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		EObject lv_case_2_0 =null;
		EObject lv_then_4_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6439:2: ( ( () otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) otherlv_3= ':' ( (lv_then_4_0= ruleXJSwitchStatements ) ) ) )
			// InternalDsl.g:6440:2: ( () otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) otherlv_3= ':' ( (lv_then_4_0= ruleXJSwitchStatements ) ) )
			{
			// InternalDsl.g:6440:2: ( () otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) otherlv_3= ':' ( (lv_then_4_0= ruleXJSwitchStatements ) ) )
			// InternalDsl.g:6441:3: () otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) otherlv_3= ':' ( (lv_then_4_0= ruleXJSwitchStatements ) )
			{
			// InternalDsl.g:6441:3: ()
			// InternalDsl.g:6442:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXCasePartAccess().getXCasePartAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,82,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1());
					}
			// InternalDsl.g:6452:3: ( (lv_case_2_0= ruleXExpression ) )
			// InternalDsl.g:6453:4: (lv_case_2_0= ruleXExpression )
			{
			// InternalDsl.g:6453:4: (lv_case_2_0= ruleXExpression )
			// InternalDsl.g:6454:5: lv_case_2_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_34);
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

			otherlv_3=(Token)match(input,40,FOLLOW_36); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_3());
					}
			// InternalDsl.g:6475:3: ( (lv_then_4_0= ruleXJSwitchStatements ) )
			// InternalDsl.g:6476:4: (lv_then_4_0= ruleXJSwitchStatements )
			{
			// InternalDsl.g:6476:4: (lv_then_4_0= ruleXJSwitchStatements )
			// InternalDsl.g:6477:5: lv_then_4_0= ruleXJSwitchStatements
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
	// InternalDsl.g:6498:1: entryRuleXJSwitchStatements returns [EObject current=null] :iv_ruleXJSwitchStatements= ruleXJSwitchStatements EOF ;
	public final EObject entryRuleXJSwitchStatements() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJSwitchStatements =null;

		try {
			// InternalDsl.g:6498:59: (iv_ruleXJSwitchStatements= ruleXJSwitchStatements EOF )
			// InternalDsl.g:6499:2: iv_ruleXJSwitchStatements= ruleXJSwitchStatements EOF
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
	// InternalDsl.g:6505:1: ruleXJSwitchStatements returns [EObject current=null] : ( () ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )* ) ;
	public final EObject ruleXJSwitchStatements() throws RecognitionException {
		EObject current = null;


		EObject lv_expressions_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6511:2: ( ( () ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )* ) )
			// InternalDsl.g:6512:2: ( () ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )* )
			{
			// InternalDsl.g:6512:2: ( () ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )* )
			// InternalDsl.g:6513:3: () ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )*
			{
			// InternalDsl.g:6513:3: ()
			// InternalDsl.g:6514:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJSwitchStatementsAccess().getXJSwitchStatementsAction_0(),
								current);
						}
			}

			// InternalDsl.g:6520:3: ( (lv_expressions_1_0= ruleXJStatementOrBlock ) )*
			loop104:
			while (true) {
				int alt104=2;
				int LA104_0 = input.LA(1);
				if ( ((LA104_0 >= RULE_CHARACTER && LA104_0 <= RULE_INT)||LA104_0==RULE_STRING||LA104_0==14||LA104_0==22||(LA104_0 >= 28 && LA104_0 <= 29)||(LA104_0 >= 32 && LA104_0 <= 33)||LA104_0==41||LA104_0==81||LA104_0==85||LA104_0==87||(LA104_0 >= 89 && LA104_0 <= 92)||(LA104_0 >= 94 && LA104_0 <= 96)||(LA104_0 >= 98 && LA104_0 <= 109)||LA104_0==114) ) {
					alt104=1;
				}

				switch (alt104) {
				case 1 :
					// InternalDsl.g:6521:4: (lv_expressions_1_0= ruleXJStatementOrBlock )
					{
					// InternalDsl.g:6521:4: (lv_expressions_1_0= ruleXJStatementOrBlock )
					// InternalDsl.g:6522:5: lv_expressions_1_0= ruleXJStatementOrBlock
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
					break loop104;
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
	// InternalDsl.g:6543:1: entryRuleXJTryWithResourcesStatement returns [EObject current=null] :iv_ruleXJTryWithResourcesStatement= ruleXJTryWithResourcesStatement EOF ;
	public final EObject entryRuleXJTryWithResourcesStatement() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJTryWithResourcesStatement =null;

		try {
			// InternalDsl.g:6543:68: (iv_ruleXJTryWithResourcesStatement= ruleXJTryWithResourcesStatement EOF )
			// InternalDsl.g:6544:2: iv_ruleXJTryWithResourcesStatement= ruleXJTryWithResourcesStatement EOF
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
	// InternalDsl.g:6550:1: ruleXJTryWithResourcesStatement returns [EObject current=null] : ( ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) ) ( (lv_resourceDeclarations_3_0= ruleXJTryWithResourcesVariableDeclaration ) )* otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ( (lv_catchClauses_6_0= ruleXCatchClause ) )* (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )? ) ;
	public final EObject ruleXJTryWithResourcesStatement() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token lv_openParenthesis_2_0=null;
		Token otherlv_4=null;
		Token otherlv_7=null;
		EObject lv_resourceDeclarations_3_0 =null;
		EObject lv_expression_5_0 =null;
		EObject lv_catchClauses_6_0 =null;
		EObject lv_finallyExpression_8_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6556:2: ( ( ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) ) ( (lv_resourceDeclarations_3_0= ruleXJTryWithResourcesVariableDeclaration ) )* otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ( (lv_catchClauses_6_0= ruleXCatchClause ) )* (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )? ) )
			// InternalDsl.g:6557:2: ( ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) ) ( (lv_resourceDeclarations_3_0= ruleXJTryWithResourcesVariableDeclaration ) )* otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ( (lv_catchClauses_6_0= ruleXCatchClause ) )* (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )? )
			{
			// InternalDsl.g:6557:2: ( ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) ) ( (lv_resourceDeclarations_3_0= ruleXJTryWithResourcesVariableDeclaration ) )* otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ( (lv_catchClauses_6_0= ruleXCatchClause ) )* (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )? )
			// InternalDsl.g:6558:3: ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) ) ( (lv_resourceDeclarations_3_0= ruleXJTryWithResourcesVariableDeclaration ) )* otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ( (lv_catchClauses_6_0= ruleXCatchClause ) )* (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )?
			{
			// InternalDsl.g:6558:3: ( ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) ) )
			// InternalDsl.g:6559:4: ( ( () 'try' ( ( '(' ) ) ) )=> ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) )
			{
			// InternalDsl.g:6570:4: ( () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) ) )
			// InternalDsl.g:6571:5: () otherlv_1= 'try' ( (lv_openParenthesis_2_0= '(' ) )
			{
			// InternalDsl.g:6571:5: ()
			// InternalDsl.g:6572:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXJTryWithResourcesStatementAccess().getXJTryWithResourcesStatementAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,107,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXJTryWithResourcesStatementAccess().getTryKeyword_0_0_1());
							}
			// InternalDsl.g:6582:5: ( (lv_openParenthesis_2_0= '(' ) )
			// InternalDsl.g:6583:6: (lv_openParenthesis_2_0= '(' )
			{
			// InternalDsl.g:6583:6: (lv_openParenthesis_2_0= '(' )
			// InternalDsl.g:6584:7: lv_openParenthesis_2_0= '('
			{
			lv_openParenthesis_2_0=(Token)match(input,22,FOLLOW_95); if (state.failed) return current;
			if ( state.backtracking==0 ) {
										newLeafNode(lv_openParenthesis_2_0, grammarAccess.getXJTryWithResourcesStatementAccess().getOpenParenthesisLeftParenthesisKeyword_0_0_2_0());
									}
			if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getXJTryWithResourcesStatementRule());
										}
										setWithLastConsumed(current, "openParenthesis", true, "(");
									}
			}

			}

			}

			}

			// InternalDsl.g:6598:3: ( (lv_resourceDeclarations_3_0= ruleXJTryWithResourcesVariableDeclaration ) )*
			loop105:
			while (true) {
				int alt105=2;
				int LA105_0 = input.LA(1);
				if ( (LA105_0==RULE_ID||LA105_0==92) ) {
					alt105=1;
				}

				switch (alt105) {
				case 1 :
					// InternalDsl.g:6599:4: (lv_resourceDeclarations_3_0= ruleXJTryWithResourcesVariableDeclaration )
					{
					// InternalDsl.g:6599:4: (lv_resourceDeclarations_3_0= ruleXJTryWithResourcesVariableDeclaration )
					// InternalDsl.g:6600:5: lv_resourceDeclarations_3_0= ruleXJTryWithResourcesVariableDeclaration
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXJTryWithResourcesStatementAccess().getResourceDeclarationsXJTryWithResourcesVariableDeclarationParserRuleCall_1_0());
									}
					pushFollow(FOLLOW_95);
					lv_resourceDeclarations_3_0=ruleXJTryWithResourcesVariableDeclaration();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXJTryWithResourcesStatementRule());
										}
										add(
											current,
											"resourceDeclarations",
											lv_resourceDeclarations_3_0,
											"jbase.Jbase.XJTryWithResourcesVariableDeclaration");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					break loop105;
				}
			}

			otherlv_4=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXJTryWithResourcesStatementAccess().getRightParenthesisKeyword_2());
					}
			// InternalDsl.g:6621:3: ( (lv_expression_5_0= ruleXBlockExpression ) )
			// InternalDsl.g:6622:4: (lv_expression_5_0= ruleXBlockExpression )
			{
			// InternalDsl.g:6622:4: (lv_expression_5_0= ruleXBlockExpression )
			// InternalDsl.g:6623:5: lv_expression_5_0= ruleXBlockExpression
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

			// InternalDsl.g:6640:3: ( (lv_catchClauses_6_0= ruleXCatchClause ) )*
			loop106:
			while (true) {
				int alt106=2;
				int LA106_0 = input.LA(1);
				if ( (LA106_0==83) ) {
					alt106=1;
				}

				switch (alt106) {
				case 1 :
					// InternalDsl.g:6641:4: (lv_catchClauses_6_0= ruleXCatchClause )
					{
					// InternalDsl.g:6641:4: (lv_catchClauses_6_0= ruleXCatchClause )
					// InternalDsl.g:6642:5: lv_catchClauses_6_0= ruleXCatchClause
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
					break loop106;
				}
			}

			// InternalDsl.g:6659:3: (otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) ) )?
			int alt107=2;
			int LA107_0 = input.LA(1);
			if ( (LA107_0==93) ) {
				alt107=1;
			}
			switch (alt107) {
				case 1 :
					// InternalDsl.g:6660:4: otherlv_7= 'finally' ( (lv_finallyExpression_8_0= ruleXBlockExpression ) )
					{
					otherlv_7=(Token)match(input,93,FOLLOW_9); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_7, grammarAccess.getXJTryWithResourcesStatementAccess().getFinallyKeyword_5_0());
								}
					// InternalDsl.g:6664:4: ( (lv_finallyExpression_8_0= ruleXBlockExpression ) )
					// InternalDsl.g:6665:5: (lv_finallyExpression_8_0= ruleXBlockExpression )
					{
					// InternalDsl.g:6665:5: (lv_finallyExpression_8_0= ruleXBlockExpression )
					// InternalDsl.g:6666:6: lv_finallyExpression_8_0= ruleXBlockExpression
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
	// InternalDsl.g:6688:1: entryRuleXJTryWithResourcesVariableDeclaration returns [EObject current=null] :iv_ruleXJTryWithResourcesVariableDeclaration= ruleXJTryWithResourcesVariableDeclaration EOF ;
	public final EObject entryRuleXJTryWithResourcesVariableDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJTryWithResourcesVariableDeclaration =null;

		try {
			// InternalDsl.g:6688:78: (iv_ruleXJTryWithResourcesVariableDeclaration= ruleXJTryWithResourcesVariableDeclaration EOF )
			// InternalDsl.g:6689:2: iv_ruleXJTryWithResourcesVariableDeclaration= ruleXJTryWithResourcesVariableDeclaration EOF
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
	// InternalDsl.g:6695:1: ruleXJTryWithResourcesVariableDeclaration returns [EObject current=null] : ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ( (lv_semicolon_6_0= ';' ) )? ) ;
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
			// InternalDsl.g:6701:2: ( ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ( (lv_semicolon_6_0= ';' ) )? ) )
			// InternalDsl.g:6702:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ( (lv_semicolon_6_0= ';' ) )? )
			{
			// InternalDsl.g:6702:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ( (lv_semicolon_6_0= ';' ) )? )
			// InternalDsl.g:6703:3: () ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ( (lv_semicolon_6_0= ';' ) )?
			{
			// InternalDsl.g:6703:3: ()
			// InternalDsl.g:6704:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJTryWithResourcesVariableDeclarationAccess().getXJTryWithResourcesVariableDeclarationAction_0(),
								current);
						}
			}

			// InternalDsl.g:6710:3: ( (lv_final_1_0= 'final' ) )?
			int alt108=2;
			int LA108_0 = input.LA(1);
			if ( (LA108_0==92) ) {
				alt108=1;
			}
			switch (alt108) {
				case 1 :
					// InternalDsl.g:6711:4: (lv_final_1_0= 'final' )
					{
					// InternalDsl.g:6711:4: (lv_final_1_0= 'final' )
					// InternalDsl.g:6712:5: lv_final_1_0= 'final'
					{
					lv_final_1_0=(Token)match(input,92,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(lv_final_1_0, grammarAccess.getXJTryWithResourcesVariableDeclarationAccess().getFinalFinalKeyword_1_0());
									}
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getXJTryWithResourcesVariableDeclarationRule());
										}
										setWithLastConsumed(current, "final", true, "final");
									}
					}

					}
					break;

			}

			// InternalDsl.g:6724:3: ( (lv_type_2_0= ruleJvmTypeReference ) )
			// InternalDsl.g:6725:4: (lv_type_2_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:6725:4: (lv_type_2_0= ruleJvmTypeReference )
			// InternalDsl.g:6726:5: lv_type_2_0= ruleJvmTypeReference
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

			// InternalDsl.g:6743:3: ( (lv_name_3_0= ruleValidID ) )
			// InternalDsl.g:6744:4: (lv_name_3_0= ruleValidID )
			{
			// InternalDsl.g:6744:4: (lv_name_3_0= ruleValidID )
			// InternalDsl.g:6745:5: lv_name_3_0= ruleValidID
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
			// InternalDsl.g:6766:3: ( (lv_right_5_0= ruleXExpression ) )
			// InternalDsl.g:6767:4: (lv_right_5_0= ruleXExpression )
			{
			// InternalDsl.g:6767:4: (lv_right_5_0= ruleXExpression )
			// InternalDsl.g:6768:5: lv_right_5_0= ruleXExpression
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

			// InternalDsl.g:6785:3: ( (lv_semicolon_6_0= ';' ) )?
			int alt109=2;
			int LA109_0 = input.LA(1);
			if ( (LA109_0==41) ) {
				alt109=1;
			}
			switch (alt109) {
				case 1 :
					// InternalDsl.g:6786:4: (lv_semicolon_6_0= ';' )
					{
					// InternalDsl.g:6786:4: (lv_semicolon_6_0= ';' )
					// InternalDsl.g:6787:5: lv_semicolon_6_0= ';'
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
	// InternalDsl.g:6803:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] :iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
	public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXTryCatchFinallyExpression =null;

		try {
			// InternalDsl.g:6803:67: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
			// InternalDsl.g:6804:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
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
	// InternalDsl.g:6810:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXBlockExpression ) ) ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) ) ) ;
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
			// InternalDsl.g:6816:2: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXBlockExpression ) ) ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) ) ) )
			// InternalDsl.g:6817:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXBlockExpression ) ) ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) ) )
			{
			// InternalDsl.g:6817:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXBlockExpression ) ) ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) ) )
			// InternalDsl.g:6818:3: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXBlockExpression ) ) ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) )
			{
			// InternalDsl.g:6818:3: ()
			// InternalDsl.g:6819:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,107,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
					}
			// InternalDsl.g:6829:3: ( (lv_expression_2_0= ruleXBlockExpression ) )
			// InternalDsl.g:6830:4: (lv_expression_2_0= ruleXBlockExpression )
			{
			// InternalDsl.g:6830:4: (lv_expression_2_0= ruleXBlockExpression )
			// InternalDsl.g:6831:5: lv_expression_2_0= ruleXBlockExpression
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

			// InternalDsl.g:6848:3: ( ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) ) )
			int alt112=2;
			int LA112_0 = input.LA(1);
			if ( (LA112_0==83) ) {
				alt112=1;
			}
			else if ( (LA112_0==93) ) {
				alt112=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 112, 0, input);
				throw nvae;
			}

			switch (alt112) {
				case 1 :
					// InternalDsl.g:6849:4: ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? )
					{
					// InternalDsl.g:6849:4: ( ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )? )
					// InternalDsl.g:6850:5: ( (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )?
					{
					// InternalDsl.g:6850:5: ( (lv_catchClauses_3_0= ruleXCatchClause ) )+
					int cnt110=0;
					loop110:
					while (true) {
						int alt110=2;
						int LA110_0 = input.LA(1);
						if ( (LA110_0==83) ) {
							alt110=1;
						}

						switch (alt110) {
						case 1 :
							// InternalDsl.g:6851:6: (lv_catchClauses_3_0= ruleXCatchClause )
							{
							// InternalDsl.g:6851:6: (lv_catchClauses_3_0= ruleXCatchClause )
							// InternalDsl.g:6852:7: lv_catchClauses_3_0= ruleXCatchClause
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
							if ( cnt110 >= 1 ) break loop110;
							if (state.backtracking>0) {state.failed=true; return current;}
							EarlyExitException eee = new EarlyExitException(110, input);
							throw eee;
						}
						cnt110++;
					}

					// InternalDsl.g:6869:5: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) ) )?
					int alt111=2;
					int LA111_0 = input.LA(1);
					if ( (LA111_0==93) && (synpred38_InternalDsl())) {
						alt111=1;
					}
					switch (alt111) {
						case 1 :
							// InternalDsl.g:6870:6: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXBlockExpression ) )
							{
							// InternalDsl.g:6870:6: ( ( 'finally' )=>otherlv_4= 'finally' )
							// InternalDsl.g:6871:7: ( 'finally' )=>otherlv_4= 'finally'
							{
							otherlv_4=(Token)match(input,93,FOLLOW_9); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
													}
							}

							// InternalDsl.g:6877:6: ( (lv_finallyExpression_5_0= ruleXBlockExpression ) )
							// InternalDsl.g:6878:7: (lv_finallyExpression_5_0= ruleXBlockExpression )
							{
							// InternalDsl.g:6878:7: (lv_finallyExpression_5_0= ruleXBlockExpression )
							// InternalDsl.g:6879:8: lv_finallyExpression_5_0= ruleXBlockExpression
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
					// InternalDsl.g:6899:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) )
					{
					// InternalDsl.g:6899:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) ) )
					// InternalDsl.g:6900:5: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXBlockExpression ) )
					{
					otherlv_6=(Token)match(input,93,FOLLOW_9); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
									}
					// InternalDsl.g:6904:5: ( (lv_finallyExpression_7_0= ruleXBlockExpression ) )
					// InternalDsl.g:6905:6: (lv_finallyExpression_7_0= ruleXBlockExpression )
					{
					// InternalDsl.g:6905:6: (lv_finallyExpression_7_0= ruleXBlockExpression )
					// InternalDsl.g:6906:7: lv_finallyExpression_7_0= ruleXBlockExpression
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
	// InternalDsl.g:6929:1: entryRuleXCatchClause returns [EObject current=null] :iv_ruleXCatchClause= ruleXCatchClause EOF ;
	public final EObject entryRuleXCatchClause() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCatchClause =null;

		try {
			// InternalDsl.g:6929:53: (iv_ruleXCatchClause= ruleXCatchClause EOF )
			// InternalDsl.g:6930:2: iv_ruleXCatchClause= ruleXCatchClause EOF
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
	// InternalDsl.g:6936:1: ruleXCatchClause returns [EObject current=null] : ( () ( ( 'catch' )=>otherlv_1= 'catch' ) otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ) ;
	public final EObject ruleXCatchClause() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_declaredParam_3_0 =null;
		EObject lv_expression_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:6942:2: ( ( () ( ( 'catch' )=>otherlv_1= 'catch' ) otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ) )
			// InternalDsl.g:6943:2: ( () ( ( 'catch' )=>otherlv_1= 'catch' ) otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) )
			{
			// InternalDsl.g:6943:2: ( () ( ( 'catch' )=>otherlv_1= 'catch' ) otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) )
			// InternalDsl.g:6944:3: () ( ( 'catch' )=>otherlv_1= 'catch' ) otherlv_2= '(' ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) )
			{
			// InternalDsl.g:6944:3: ()
			// InternalDsl.g:6945:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXCatchClauseAccess().getXCatchClauseAction_0(),
								current);
						}
			}

			// InternalDsl.g:6951:3: ( ( 'catch' )=>otherlv_1= 'catch' )
			// InternalDsl.g:6952:4: ( 'catch' )=>otherlv_1= 'catch'
			{
			otherlv_1=(Token)match(input,83,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
							newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getCatchKeyword_1());
						}
			}

			otherlv_2=(Token)match(input,22,FOLLOW_87); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_2());
					}
			// InternalDsl.g:6962:3: ( (lv_declaredParam_3_0= ruleFullJvmFormalParameter ) )
			// InternalDsl.g:6963:4: (lv_declaredParam_3_0= ruleFullJvmFormalParameter )
			{
			// InternalDsl.g:6963:4: (lv_declaredParam_3_0= ruleFullJvmFormalParameter )
			// InternalDsl.g:6964:5: lv_declaredParam_3_0= ruleFullJvmFormalParameter
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
			// InternalDsl.g:6985:3: ( (lv_expression_5_0= ruleXBlockExpression ) )
			// InternalDsl.g:6986:4: (lv_expression_5_0= ruleXBlockExpression )
			{
			// InternalDsl.g:6986:4: (lv_expression_5_0= ruleXBlockExpression )
			// InternalDsl.g:6987:5: lv_expression_5_0= ruleXBlockExpression
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
	// InternalDsl.g:7008:1: entryRuleXSynchronizedExpression returns [EObject current=null] :iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF ;
	public final EObject entryRuleXSynchronizedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSynchronizedExpression =null;

		try {
			// InternalDsl.g:7008:64: (iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF )
			// InternalDsl.g:7009:2: iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF
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
	// InternalDsl.g:7015:1: ruleXSynchronizedExpression returns [EObject current=null] : ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ) ;
	public final EObject ruleXSynchronizedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_param_3_0 =null;
		EObject lv_expression_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7021:2: ( ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) ) )
			// InternalDsl.g:7022:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) )
			{
			// InternalDsl.g:7022:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) ) )
			// InternalDsl.g:7023:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXBlockExpression ) )
			{
			// InternalDsl.g:7023:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) )
			// InternalDsl.g:7024:4: ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' )
			{
			// InternalDsl.g:7031:4: ( () otherlv_1= 'synchronized' otherlv_2= '(' )
			// InternalDsl.g:7032:5: () otherlv_1= 'synchronized' otherlv_2= '('
			{
			// InternalDsl.g:7032:5: ()
			// InternalDsl.g:7033:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXSynchronizedExpressionAccess().getXSynchronizedExpressionAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,104,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXSynchronizedExpressionAccess().getSynchronizedKeyword_0_0_1());
							}
			otherlv_2=(Token)match(input,22,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_2, grammarAccess.getXSynchronizedExpressionAccess().getLeftParenthesisKeyword_0_0_2());
							}
			}

			}

			// InternalDsl.g:7049:3: ( (lv_param_3_0= ruleXExpression ) )
			// InternalDsl.g:7050:4: (lv_param_3_0= ruleXExpression )
			{
			// InternalDsl.g:7050:4: (lv_param_3_0= ruleXExpression )
			// InternalDsl.g:7051:5: lv_param_3_0= ruleXExpression
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
			// InternalDsl.g:7072:3: ( (lv_expression_5_0= ruleXBlockExpression ) )
			// InternalDsl.g:7073:4: (lv_expression_5_0= ruleXBlockExpression )
			{
			// InternalDsl.g:7073:4: (lv_expression_5_0= ruleXBlockExpression )
			// InternalDsl.g:7074:5: lv_expression_5_0= ruleXBlockExpression
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
	// InternalDsl.g:7095:1: entryRuleXPrimaryExpression returns [EObject current=null] :iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
	public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXPrimaryExpression =null;

		try {
			// InternalDsl.g:7095:59: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
			// InternalDsl.g:7096:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
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
	// InternalDsl.g:7102:1: ruleXPrimaryExpression returns [EObject current=null] : ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall ) |this_XConstructorCall_1= ruleXConstructorCall |this_XJFeatureCallWithArrayAccess_2= ruleXJFeatureCallWithArrayAccess |this_XLiteral_3= ruleXLiteral |this_XParenthesizedExpression_4= ruleXParenthesizedExpression ) ;
	public final EObject ruleXPrimaryExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XJArrayConstructorCall_0 =null;
		EObject this_XConstructorCall_1 =null;
		EObject this_XJFeatureCallWithArrayAccess_2 =null;
		EObject this_XLiteral_3 =null;
		EObject this_XParenthesizedExpression_4 =null;


			enterRule();

		try {
			// InternalDsl.g:7108:2: ( ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall ) |this_XConstructorCall_1= ruleXConstructorCall |this_XJFeatureCallWithArrayAccess_2= ruleXJFeatureCallWithArrayAccess |this_XLiteral_3= ruleXLiteral |this_XParenthesizedExpression_4= ruleXParenthesizedExpression ) )
			// InternalDsl.g:7109:2: ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall ) |this_XConstructorCall_1= ruleXConstructorCall |this_XJFeatureCallWithArrayAccess_2= ruleXJFeatureCallWithArrayAccess |this_XLiteral_3= ruleXLiteral |this_XParenthesizedExpression_4= ruleXParenthesizedExpression )
			{
			// InternalDsl.g:7109:2: ( ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall ) |this_XConstructorCall_1= ruleXConstructorCall |this_XJFeatureCallWithArrayAccess_2= ruleXJFeatureCallWithArrayAccess |this_XLiteral_3= ruleXLiteral |this_XParenthesizedExpression_4= ruleXParenthesizedExpression )
			int alt113=5;
			switch ( input.LA(1) ) {
			case 98:
				{
				int LA113_1 = input.LA(2);
				if ( (synpred41_InternalDsl()) ) {
					alt113=1;
				}
				else if ( (true) ) {
					alt113=2;
				}

				}
				break;
			case RULE_ID:
			case 89:
			case 90:
			case 96:
			case 101:
			case 102:
				{
				alt113=3;
				}
				break;
			case RULE_CHARACTER:
			case RULE_DECIMAL:
			case RULE_HEX:
			case RULE_INT:
			case RULE_STRING:
			case 91:
			case 99:
			case 106:
			case 109:
				{
				alt113=4;
				}
				break;
			case 22:
				{
				alt113=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 113, 0, input);
				throw nvae;
			}
			switch (alt113) {
				case 1 :
					// InternalDsl.g:7110:3: ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall )
					{
					// InternalDsl.g:7110:3: ( ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall )
					// InternalDsl.g:7111:4: ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )=>this_XJArrayConstructorCall_0= ruleXJArrayConstructorCall
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
					// InternalDsl.g:7137:3: this_XConstructorCall_1= ruleXConstructorCall
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
					// InternalDsl.g:7146:3: this_XJFeatureCallWithArrayAccess_2= ruleXJFeatureCallWithArrayAccess
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
					// InternalDsl.g:7155:3: this_XLiteral_3= ruleXLiteral
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
					// InternalDsl.g:7164:3: this_XParenthesizedExpression_4= ruleXParenthesizedExpression
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
	// InternalDsl.g:7176:1: entryRuleXLiteral returns [EObject current=null] :iv_ruleXLiteral= ruleXLiteral EOF ;
	public final EObject entryRuleXLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXLiteral =null;

		try {
			// InternalDsl.g:7176:49: (iv_ruleXLiteral= ruleXLiteral EOF )
			// InternalDsl.g:7177:2: iv_ruleXLiteral= ruleXLiteral EOF
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
	// InternalDsl.g:7183:1: ruleXLiteral returns [EObject current=null] : (this_XBooleanLiteral_0= ruleXBooleanLiteral |this_XNumberLiteral_1= ruleXNumberLiteral |this_XNullLiteral_2= ruleXNullLiteral |this_XCharLiteral_3= ruleXCharLiteral |this_XStringLiteral_4= ruleXStringLiteral |this_XJArrayLiteral_5= ruleXJArrayLiteral ) ;
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
			// InternalDsl.g:7189:2: ( (this_XBooleanLiteral_0= ruleXBooleanLiteral |this_XNumberLiteral_1= ruleXNumberLiteral |this_XNullLiteral_2= ruleXNullLiteral |this_XCharLiteral_3= ruleXCharLiteral |this_XStringLiteral_4= ruleXStringLiteral |this_XJArrayLiteral_5= ruleXJArrayLiteral ) )
			// InternalDsl.g:7190:2: (this_XBooleanLiteral_0= ruleXBooleanLiteral |this_XNumberLiteral_1= ruleXNumberLiteral |this_XNullLiteral_2= ruleXNullLiteral |this_XCharLiteral_3= ruleXCharLiteral |this_XStringLiteral_4= ruleXStringLiteral |this_XJArrayLiteral_5= ruleXJArrayLiteral )
			{
			// InternalDsl.g:7190:2: (this_XBooleanLiteral_0= ruleXBooleanLiteral |this_XNumberLiteral_1= ruleXNumberLiteral |this_XNullLiteral_2= ruleXNullLiteral |this_XCharLiteral_3= ruleXCharLiteral |this_XStringLiteral_4= ruleXStringLiteral |this_XJArrayLiteral_5= ruleXJArrayLiteral )
			int alt114=6;
			switch ( input.LA(1) ) {
			case 91:
			case 106:
				{
				alt114=1;
				}
				break;
			case RULE_DECIMAL:
			case RULE_HEX:
			case RULE_INT:
				{
				alt114=2;
				}
				break;
			case 99:
				{
				alt114=3;
				}
				break;
			case RULE_CHARACTER:
				{
				alt114=4;
				}
				break;
			case RULE_STRING:
				{
				alt114=5;
				}
				break;
			case 109:
				{
				alt114=6;
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
					// InternalDsl.g:7191:3: this_XBooleanLiteral_0= ruleXBooleanLiteral
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
					// InternalDsl.g:7200:3: this_XNumberLiteral_1= ruleXNumberLiteral
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
					// InternalDsl.g:7209:3: this_XNullLiteral_2= ruleXNullLiteral
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
					// InternalDsl.g:7218:3: this_XCharLiteral_3= ruleXCharLiteral
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
					// InternalDsl.g:7227:3: this_XStringLiteral_4= ruleXStringLiteral
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
					// InternalDsl.g:7236:3: this_XJArrayLiteral_5= ruleXJArrayLiteral
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
	// InternalDsl.g:7248:1: entryRuleXJArrayLiteral returns [EObject current=null] :iv_ruleXJArrayLiteral= ruleXJArrayLiteral EOF ;
	public final EObject entryRuleXJArrayLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXJArrayLiteral =null;

		try {
			// InternalDsl.g:7248:55: (iv_ruleXJArrayLiteral= ruleXJArrayLiteral EOF )
			// InternalDsl.g:7249:2: iv_ruleXJArrayLiteral= ruleXJArrayLiteral EOF
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
	// InternalDsl.g:7255:1: ruleXJArrayLiteral returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )? otherlv_5= '}' ) ;
	public final EObject ruleXJArrayLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		EObject lv_elements_2_0 =null;
		EObject lv_elements_4_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7261:2: ( ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )? otherlv_5= '}' ) )
			// InternalDsl.g:7262:2: ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )? otherlv_5= '}' )
			{
			// InternalDsl.g:7262:2: ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )? otherlv_5= '}' )
			// InternalDsl.g:7263:3: () otherlv_1= '{' ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )? otherlv_5= '}'
			{
			// InternalDsl.g:7263:3: ()
			// InternalDsl.g:7264:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXJArrayLiteralAccess().getXJArrayLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,109,FOLLOW_98); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXJArrayLiteralAccess().getLeftCurlyBracketKeyword_1());
					}
			// InternalDsl.g:7274:3: ( ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )* )?
			int alt116=2;
			int LA116_0 = input.LA(1);
			if ( ((LA116_0 >= RULE_CHARACTER && LA116_0 <= RULE_INT)||LA116_0==RULE_STRING||LA116_0==14||LA116_0==22||(LA116_0 >= 28 && LA116_0 <= 29)||(LA116_0 >= 32 && LA116_0 <= 33)||(LA116_0 >= 89 && LA116_0 <= 91)||LA116_0==96||(LA116_0 >= 98 && LA116_0 <= 99)||(LA116_0 >= 101 && LA116_0 <= 102)||LA116_0==106||LA116_0==109||LA116_0==114) ) {
				alt116=1;
			}
			switch (alt116) {
				case 1 :
					// InternalDsl.g:7275:4: ( (lv_elements_2_0= ruleXExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )*
					{
					// InternalDsl.g:7275:4: ( (lv_elements_2_0= ruleXExpression ) )
					// InternalDsl.g:7276:5: (lv_elements_2_0= ruleXExpression )
					{
					// InternalDsl.g:7276:5: (lv_elements_2_0= ruleXExpression )
					// InternalDsl.g:7277:6: lv_elements_2_0= ruleXExpression
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

					// InternalDsl.g:7294:4: (otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) ) )*
					loop115:
					while (true) {
						int alt115=2;
						int LA115_0 = input.LA(1);
						if ( (LA115_0==31) ) {
							alt115=1;
						}

						switch (alt115) {
						case 1 :
							// InternalDsl.g:7295:5: otherlv_3= ',' ( (lv_elements_4_0= ruleXExpression ) )
							{
							otherlv_3=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_3, grammarAccess.getXJArrayLiteralAccess().getCommaKeyword_2_1_0());
											}
							// InternalDsl.g:7299:5: ( (lv_elements_4_0= ruleXExpression ) )
							// InternalDsl.g:7300:6: (lv_elements_4_0= ruleXExpression )
							{
							// InternalDsl.g:7300:6: (lv_elements_4_0= ruleXExpression )
							// InternalDsl.g:7301:7: lv_elements_4_0= ruleXExpression
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
							break loop115;
						}
					}

					}
					break;

			}

			otherlv_5=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:7328:1: entryRuleXCharLiteral returns [EObject current=null] :iv_ruleXCharLiteral= ruleXCharLiteral EOF ;
	public final EObject entryRuleXCharLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCharLiteral =null;

		try {
			// InternalDsl.g:7328:53: (iv_ruleXCharLiteral= ruleXCharLiteral EOF )
			// InternalDsl.g:7329:2: iv_ruleXCharLiteral= ruleXCharLiteral EOF
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
	// InternalDsl.g:7335:1: ruleXCharLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_CHARACTER ) ) ) ;
	public final EObject ruleXCharLiteral() throws RecognitionException {
		EObject current = null;


		Token lv_value_1_0=null;


			enterRule();

		try {
			// InternalDsl.g:7341:2: ( ( () ( (lv_value_1_0= RULE_CHARACTER ) ) ) )
			// InternalDsl.g:7342:2: ( () ( (lv_value_1_0= RULE_CHARACTER ) ) )
			{
			// InternalDsl.g:7342:2: ( () ( (lv_value_1_0= RULE_CHARACTER ) ) )
			// InternalDsl.g:7343:3: () ( (lv_value_1_0= RULE_CHARACTER ) )
			{
			// InternalDsl.g:7343:3: ()
			// InternalDsl.g:7344:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXCharLiteralAccess().getXJCharLiteralAction_0(),
								current);
						}
			}

			// InternalDsl.g:7350:3: ( (lv_value_1_0= RULE_CHARACTER ) )
			// InternalDsl.g:7351:4: (lv_value_1_0= RULE_CHARACTER )
			{
			// InternalDsl.g:7351:4: (lv_value_1_0= RULE_CHARACTER )
			// InternalDsl.g:7352:5: lv_value_1_0= RULE_CHARACTER
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
	// InternalDsl.g:7372:1: entryRuleXStringLiteral returns [EObject current=null] :iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
	public final EObject entryRuleXStringLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXStringLiteral =null;

		try {
			// InternalDsl.g:7372:55: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
			// InternalDsl.g:7373:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
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
	// InternalDsl.g:7379:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
	public final EObject ruleXStringLiteral() throws RecognitionException {
		EObject current = null;


		Token lv_value_1_0=null;


			enterRule();

		try {
			// InternalDsl.g:7385:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
			// InternalDsl.g:7386:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
			{
			// InternalDsl.g:7386:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
			// InternalDsl.g:7387:3: () ( (lv_value_1_0= RULE_STRING ) )
			{
			// InternalDsl.g:7387:3: ()
			// InternalDsl.g:7388:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
								current);
						}
			}

			// InternalDsl.g:7394:3: ( (lv_value_1_0= RULE_STRING ) )
			// InternalDsl.g:7395:4: (lv_value_1_0= RULE_STRING )
			{
			// InternalDsl.g:7395:4: (lv_value_1_0= RULE_STRING )
			// InternalDsl.g:7396:5: lv_value_1_0= RULE_STRING
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
	// InternalDsl.g:7416:1: entryRuleOpEquality returns [String current=null] :iv_ruleOpEquality= ruleOpEquality EOF ;
	public final String entryRuleOpEquality() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpEquality =null;

		try {
			// InternalDsl.g:7416:50: (iv_ruleOpEquality= ruleOpEquality EOF )
			// InternalDsl.g:7417:2: iv_ruleOpEquality= ruleOpEquality EOF
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
	// InternalDsl.g:7423:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' |kw= '!=' ) ;
	public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7429:2: ( (kw= '==' |kw= '!=' ) )
			// InternalDsl.g:7430:2: (kw= '==' |kw= '!=' )
			{
			// InternalDsl.g:7430:2: (kw= '==' |kw= '!=' )
			int alt117=2;
			int LA117_0 = input.LA(1);
			if ( (LA117_0==46) ) {
				alt117=1;
			}
			else if ( (LA117_0==15) ) {
				alt117=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 117, 0, input);
				throw nvae;
			}

			switch (alt117) {
				case 1 :
					// InternalDsl.g:7431:3: kw= '=='
					{
					kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:7437:3: kw= '!='
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
	// InternalDsl.g:7446:1: entryRuleOpMulti returns [String current=null] :iv_ruleOpMulti= ruleOpMulti EOF ;
	public final String entryRuleOpMulti() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpMulti =null;

		try {
			// InternalDsl.g:7446:47: (iv_ruleOpMulti= ruleOpMulti EOF )
			// InternalDsl.g:7447:2: iv_ruleOpMulti= ruleOpMulti EOF
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
	// InternalDsl.g:7453:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' |kw= '/' |kw= '%' ) ;
	public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7459:2: ( (kw= '*' |kw= '/' |kw= '%' ) )
			// InternalDsl.g:7460:2: (kw= '*' |kw= '/' |kw= '%' )
			{
			// InternalDsl.g:7460:2: (kw= '*' |kw= '/' |kw= '%' )
			int alt118=3;
			switch ( input.LA(1) ) {
			case 26:
				{
				alt118=1;
				}
				break;
			case 38:
				{
				alt118=2;
				}
				break;
			case 17:
				{
				alt118=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 118, 0, input);
				throw nvae;
			}
			switch (alt118) {
				case 1 :
					// InternalDsl.g:7461:3: kw= '*'
					{
					kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:7467:3: kw= '/'
					{
					kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalDsl.g:7473:3: kw= '%'
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
	// InternalDsl.g:7482:1: entryRuleOpOther returns [String current=null] :iv_ruleOpOther= ruleOpOther EOF ;
	public final String entryRuleOpOther() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpOther =null;

		try {
			// InternalDsl.g:7482:47: (iv_ruleOpOther= ruleOpOther EOF )
			// InternalDsl.g:7483:2: iv_ruleOpOther= ruleOpOther EOF
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
	// InternalDsl.g:7489:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) |kw= '<<' ) ;
	public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7495:2: ( ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) |kw= '<<' ) )
			// InternalDsl.g:7496:2: ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) |kw= '<<' )
			{
			// InternalDsl.g:7496:2: ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) |kw= '<<' )
			int alt120=2;
			int LA120_0 = input.LA(1);
			if ( (LA120_0==47) ) {
				alt120=1;
			}
			else if ( (LA120_0==43) ) {
				alt120=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 120, 0, input);
				throw nvae;
			}

			switch (alt120) {
				case 1 :
					// InternalDsl.g:7497:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) )
					{
					// InternalDsl.g:7497:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) )
					// InternalDsl.g:7498:4: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' )
					{
					kw=(Token)match(input,47,FOLLOW_100); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_0());
								}
					// InternalDsl.g:7503:4: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' )
					int alt119=2;
					int LA119_0 = input.LA(1);
					if ( (LA119_0==47) ) {
						int LA119_1 = input.LA(2);
						if ( (LA119_1==47) && (synpred42_InternalDsl())) {
							alt119=1;
						}
						else if ( (LA119_1==EOF||(LA119_1 >= RULE_CHARACTER && LA119_1 <= RULE_INT)||LA119_1==RULE_STRING||LA119_1==14||LA119_1==22||(LA119_1 >= 28 && LA119_1 <= 29)||(LA119_1 >= 32 && LA119_1 <= 33)||(LA119_1 >= 89 && LA119_1 <= 91)||LA119_1==96||(LA119_1 >= 98 && LA119_1 <= 99)||(LA119_1 >= 101 && LA119_1 <= 102)||LA119_1==106||LA119_1==109||LA119_1==114) ) {
							alt119=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return current;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 119, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 119, 0, input);
						throw nvae;
					}

					switch (alt119) {
						case 1 :
							// InternalDsl.g:7504:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
							{
							// InternalDsl.g:7504:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
							// InternalDsl.g:7505:6: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
							{
							// InternalDsl.g:7510:6: (kw= '>' kw= '>' )
							// InternalDsl.g:7511:7: kw= '>' kw= '>'
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
							// InternalDsl.g:7524:5: kw= '>'
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
					// InternalDsl.g:7532:3: kw= '<<'
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
	// InternalDsl.g:7541:1: entryRuleXAndExpression returns [EObject current=null] :iv_ruleXAndExpression= ruleXAndExpression EOF ;
	public final EObject entryRuleXAndExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAndExpression =null;

		try {
			// InternalDsl.g:7541:55: (iv_ruleXAndExpression= ruleXAndExpression EOF )
			// InternalDsl.g:7542:2: iv_ruleXAndExpression= ruleXAndExpression EOF
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
	// InternalDsl.g:7548:1: ruleXAndExpression returns [EObject current=null] : (this_XBitwiseInclusiveOrExpression_0= ruleXBitwiseInclusiveOrExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )* ) ;
	public final EObject ruleXAndExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XBitwiseInclusiveOrExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7554:2: ( (this_XBitwiseInclusiveOrExpression_0= ruleXBitwiseInclusiveOrExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )* ) )
			// InternalDsl.g:7555:2: (this_XBitwiseInclusiveOrExpression_0= ruleXBitwiseInclusiveOrExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )* )
			{
			// InternalDsl.g:7555:2: (this_XBitwiseInclusiveOrExpression_0= ruleXBitwiseInclusiveOrExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )* )
			// InternalDsl.g:7556:3: this_XBitwiseInclusiveOrExpression_0= ruleXBitwiseInclusiveOrExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )*
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
			// InternalDsl.g:7564:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) ) )*
			loop121:
			while (true) {
				int alt121=2;
				int LA121_0 = input.LA(1);
				if ( (LA121_0==19) ) {
					int LA121_2 = input.LA(2);
					if ( (synpred43_InternalDsl()) ) {
						alt121=1;
					}

				}

				switch (alt121) {
				case 1 :
					// InternalDsl.g:7565:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) )
					{
					// InternalDsl.g:7565:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
					// InternalDsl.g:7566:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
					{
					// InternalDsl.g:7576:5: ( () ( ( ruleOpAnd ) ) )
					// InternalDsl.g:7577:6: () ( ( ruleOpAnd ) )
					{
					// InternalDsl.g:7577:6: ()
					// InternalDsl.g:7578:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:7584:6: ( ( ruleOpAnd ) )
					// InternalDsl.g:7585:7: ( ruleOpAnd )
					{
					// InternalDsl.g:7585:7: ( ruleOpAnd )
					// InternalDsl.g:7586:8: ruleOpAnd
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

					// InternalDsl.g:7602:4: ( (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression ) )
					// InternalDsl.g:7603:5: (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression )
					{
					// InternalDsl.g:7603:5: (lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression )
					// InternalDsl.g:7604:6: lv_rightOperand_3_0= ruleXBitwiseInclusiveOrExpression
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
					break loop121;
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
	// InternalDsl.g:7626:1: entryRuleXBitwiseInclusiveOrExpression returns [EObject current=null] :iv_ruleXBitwiseInclusiveOrExpression= ruleXBitwiseInclusiveOrExpression EOF ;
	public final EObject entryRuleXBitwiseInclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBitwiseInclusiveOrExpression =null;

		try {
			// InternalDsl.g:7626:70: (iv_ruleXBitwiseInclusiveOrExpression= ruleXBitwiseInclusiveOrExpression EOF )
			// InternalDsl.g:7627:2: iv_ruleXBitwiseInclusiveOrExpression= ruleXBitwiseInclusiveOrExpression EOF
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
	// InternalDsl.g:7633:1: ruleXBitwiseInclusiveOrExpression returns [EObject current=null] : (this_XBitwiseExclusiveOrExpression_0= ruleXBitwiseExclusiveOrExpression ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )* ) ;
	public final EObject ruleXBitwiseInclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XBitwiseExclusiveOrExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7639:2: ( (this_XBitwiseExclusiveOrExpression_0= ruleXBitwiseExclusiveOrExpression ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )* ) )
			// InternalDsl.g:7640:2: (this_XBitwiseExclusiveOrExpression_0= ruleXBitwiseExclusiveOrExpression ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )* )
			{
			// InternalDsl.g:7640:2: (this_XBitwiseExclusiveOrExpression_0= ruleXBitwiseExclusiveOrExpression ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )* )
			// InternalDsl.g:7641:3: this_XBitwiseExclusiveOrExpression_0= ruleXBitwiseExclusiveOrExpression ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )*
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
			// InternalDsl.g:7649:3: ( ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) ) )*
			loop122:
			while (true) {
				int alt122=2;
				int LA122_0 = input.LA(1);
				if ( (LA122_0==110) ) {
					int LA122_2 = input.LA(2);
					if ( (synpred44_InternalDsl()) ) {
						alt122=1;
					}

				}

				switch (alt122) {
				case 1 :
					// InternalDsl.g:7650:4: ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) )
					{
					// InternalDsl.g:7650:4: ( ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) ) )
					// InternalDsl.g:7651:5: ( ( () ( ( ruleOpInclusiveOr ) ) ) )=> ( () ( ( ruleOpInclusiveOr ) ) )
					{
					// InternalDsl.g:7661:5: ( () ( ( ruleOpInclusiveOr ) ) )
					// InternalDsl.g:7662:6: () ( ( ruleOpInclusiveOr ) )
					{
					// InternalDsl.g:7662:6: ()
					// InternalDsl.g:7663:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXBitwiseInclusiveOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:7669:6: ( ( ruleOpInclusiveOr ) )
					// InternalDsl.g:7670:7: ( ruleOpInclusiveOr )
					{
					// InternalDsl.g:7670:7: ( ruleOpInclusiveOr )
					// InternalDsl.g:7671:8: ruleOpInclusiveOr
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

					// InternalDsl.g:7687:4: ( (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression ) )
					// InternalDsl.g:7688:5: (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression )
					{
					// InternalDsl.g:7688:5: (lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression )
					// InternalDsl.g:7689:6: lv_rightOperand_3_0= ruleXBitwiseExclusiveOrExpression
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
	// $ANTLR end "ruleXBitwiseInclusiveOrExpression"



	// $ANTLR start "entryRuleOpInclusiveOr"
	// InternalDsl.g:7711:1: entryRuleOpInclusiveOr returns [String current=null] :iv_ruleOpInclusiveOr= ruleOpInclusiveOr EOF ;
	public final String entryRuleOpInclusiveOr() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpInclusiveOr =null;

		try {
			// InternalDsl.g:7711:53: (iv_ruleOpInclusiveOr= ruleOpInclusiveOr EOF )
			// InternalDsl.g:7712:2: iv_ruleOpInclusiveOr= ruleOpInclusiveOr EOF
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
	// InternalDsl.g:7718:1: ruleOpInclusiveOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '|' ;
	public final AntlrDatatypeRuleToken ruleOpInclusiveOr() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7724:2: (kw= '|' )
			// InternalDsl.g:7725:2: kw= '|'
			{
			kw=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:7733:1: entryRuleXBitwiseExclusiveOrExpression returns [EObject current=null] :iv_ruleXBitwiseExclusiveOrExpression= ruleXBitwiseExclusiveOrExpression EOF ;
	public final EObject entryRuleXBitwiseExclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBitwiseExclusiveOrExpression =null;

		try {
			// InternalDsl.g:7733:70: (iv_ruleXBitwiseExclusiveOrExpression= ruleXBitwiseExclusiveOrExpression EOF )
			// InternalDsl.g:7734:2: iv_ruleXBitwiseExclusiveOrExpression= ruleXBitwiseExclusiveOrExpression EOF
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
	// InternalDsl.g:7740:1: ruleXBitwiseExclusiveOrExpression returns [EObject current=null] : (this_XBitwiseAndExpression_0= ruleXBitwiseAndExpression ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )* ) ;
	public final EObject ruleXBitwiseExclusiveOrExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XBitwiseAndExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7746:2: ( (this_XBitwiseAndExpression_0= ruleXBitwiseAndExpression ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )* ) )
			// InternalDsl.g:7747:2: (this_XBitwiseAndExpression_0= ruleXBitwiseAndExpression ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )* )
			{
			// InternalDsl.g:7747:2: (this_XBitwiseAndExpression_0= ruleXBitwiseAndExpression ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )* )
			// InternalDsl.g:7748:3: this_XBitwiseAndExpression_0= ruleXBitwiseAndExpression ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )*
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
			// InternalDsl.g:7756:3: ( ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) ) )*
			loop123:
			while (true) {
				int alt123=2;
				int LA123_0 = input.LA(1);
				if ( (LA123_0==79) ) {
					int LA123_2 = input.LA(2);
					if ( (synpred45_InternalDsl()) ) {
						alt123=1;
					}

				}

				switch (alt123) {
				case 1 :
					// InternalDsl.g:7757:4: ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) )
					{
					// InternalDsl.g:7757:4: ( ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) ) )
					// InternalDsl.g:7758:5: ( ( () ( ( ruleOpExclusiveOr ) ) ) )=> ( () ( ( ruleOpExclusiveOr ) ) )
					{
					// InternalDsl.g:7768:5: ( () ( ( ruleOpExclusiveOr ) ) )
					// InternalDsl.g:7769:6: () ( ( ruleOpExclusiveOr ) )
					{
					// InternalDsl.g:7769:6: ()
					// InternalDsl.g:7770:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXBitwiseExclusiveOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:7776:6: ( ( ruleOpExclusiveOr ) )
					// InternalDsl.g:7777:7: ( ruleOpExclusiveOr )
					{
					// InternalDsl.g:7777:7: ( ruleOpExclusiveOr )
					// InternalDsl.g:7778:8: ruleOpExclusiveOr
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

					// InternalDsl.g:7794:4: ( (lv_rightOperand_3_0= ruleXBitwiseAndExpression ) )
					// InternalDsl.g:7795:5: (lv_rightOperand_3_0= ruleXBitwiseAndExpression )
					{
					// InternalDsl.g:7795:5: (lv_rightOperand_3_0= ruleXBitwiseAndExpression )
					// InternalDsl.g:7796:6: lv_rightOperand_3_0= ruleXBitwiseAndExpression
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
	// $ANTLR end "ruleXBitwiseExclusiveOrExpression"



	// $ANTLR start "entryRuleOpExclusiveOr"
	// InternalDsl.g:7818:1: entryRuleOpExclusiveOr returns [String current=null] :iv_ruleOpExclusiveOr= ruleOpExclusiveOr EOF ;
	public final String entryRuleOpExclusiveOr() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpExclusiveOr =null;

		try {
			// InternalDsl.g:7818:53: (iv_ruleOpExclusiveOr= ruleOpExclusiveOr EOF )
			// InternalDsl.g:7819:2: iv_ruleOpExclusiveOr= ruleOpExclusiveOr EOF
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
	// InternalDsl.g:7825:1: ruleOpExclusiveOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '^' ;
	public final AntlrDatatypeRuleToken ruleOpExclusiveOr() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7831:2: (kw= '^' )
			// InternalDsl.g:7832:2: kw= '^'
			{
			kw=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:7840:1: entryRuleXBitwiseAndExpression returns [EObject current=null] :iv_ruleXBitwiseAndExpression= ruleXBitwiseAndExpression EOF ;
	public final EObject entryRuleXBitwiseAndExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBitwiseAndExpression =null;

		try {
			// InternalDsl.g:7840:62: (iv_ruleXBitwiseAndExpression= ruleXBitwiseAndExpression EOF )
			// InternalDsl.g:7841:2: iv_ruleXBitwiseAndExpression= ruleXBitwiseAndExpression EOF
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
	// InternalDsl.g:7847:1: ruleXBitwiseAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
	public final EObject ruleXBitwiseAndExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XEqualityExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:7853:2: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
			// InternalDsl.g:7854:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
			{
			// InternalDsl.g:7854:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
			// InternalDsl.g:7855:3: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
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
			// InternalDsl.g:7863:3: ( ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
			loop124:
			while (true) {
				int alt124=2;
				int LA124_0 = input.LA(1);
				if ( (LA124_0==20) ) {
					int LA124_2 = input.LA(2);
					if ( (synpred46_InternalDsl()) ) {
						alt124=1;
					}

				}

				switch (alt124) {
				case 1 :
					// InternalDsl.g:7864:4: ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
					{
					// InternalDsl.g:7864:4: ( ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) ) )
					// InternalDsl.g:7865:5: ( ( () ( ( ruleOpBitwiseAnd ) ) ) )=> ( () ( ( ruleOpBitwiseAnd ) ) )
					{
					// InternalDsl.g:7875:5: ( () ( ( ruleOpBitwiseAnd ) ) )
					// InternalDsl.g:7876:6: () ( ( ruleOpBitwiseAnd ) )
					{
					// InternalDsl.g:7876:6: ()
					// InternalDsl.g:7877:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXBitwiseAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:7883:6: ( ( ruleOpBitwiseAnd ) )
					// InternalDsl.g:7884:7: ( ruleOpBitwiseAnd )
					{
					// InternalDsl.g:7884:7: ( ruleOpBitwiseAnd )
					// InternalDsl.g:7885:8: ruleOpBitwiseAnd
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

					// InternalDsl.g:7901:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
					// InternalDsl.g:7902:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
					{
					// InternalDsl.g:7902:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
					// InternalDsl.g:7903:6: lv_rightOperand_3_0= ruleXEqualityExpression
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
	// $ANTLR end "ruleXBitwiseAndExpression"



	// $ANTLR start "entryRuleOpBitwiseAnd"
	// InternalDsl.g:7925:1: entryRuleOpBitwiseAnd returns [String current=null] :iv_ruleOpBitwiseAnd= ruleOpBitwiseAnd EOF ;
	public final String entryRuleOpBitwiseAnd() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpBitwiseAnd =null;

		try {
			// InternalDsl.g:7925:52: (iv_ruleOpBitwiseAnd= ruleOpBitwiseAnd EOF )
			// InternalDsl.g:7926:2: iv_ruleOpBitwiseAnd= ruleOpBitwiseAnd EOF
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
	// InternalDsl.g:7932:1: ruleOpBitwiseAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&' ;
	public final AntlrDatatypeRuleToken ruleOpBitwiseAnd() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7938:2: (kw= '&' )
			// InternalDsl.g:7939:2: kw= '&'
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
	// InternalDsl.g:7947:1: entryRuleOpUnary returns [String current=null] :iv_ruleOpUnary= ruleOpUnary EOF ;
	public final String entryRuleOpUnary() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpUnary =null;

		try {
			// InternalDsl.g:7947:47: (iv_ruleOpUnary= ruleOpUnary EOF )
			// InternalDsl.g:7948:2: iv_ruleOpUnary= ruleOpUnary EOF
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
	// InternalDsl.g:7954:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' |kw= '-' |kw= '+' |kw= '~' ) ;
	public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:7960:2: ( (kw= '!' |kw= '-' |kw= '+' |kw= '~' ) )
			// InternalDsl.g:7961:2: (kw= '!' |kw= '-' |kw= '+' |kw= '~' )
			{
			// InternalDsl.g:7961:2: (kw= '!' |kw= '-' |kw= '+' |kw= '~' )
			int alt125=4;
			switch ( input.LA(1) ) {
			case 14:
				{
				alt125=1;
				}
				break;
			case 32:
				{
				alt125=2;
				}
				break;
			case 28:
				{
				alt125=3;
				}
				break;
			case 114:
				{
				alt125=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 125, 0, input);
				throw nvae;
			}
			switch (alt125) {
				case 1 :
					// InternalDsl.g:7962:3: kw= '!'
					{
					kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:7968:3: kw= '-'
					{
					kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalDsl.g:7974:3: kw= '+'
					{
					kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalDsl.g:7980:3: kw= '~'
					{
					kw=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:7989:1: entryRuleXAnnotationElementValueOrCommaList returns [EObject current=null] :iv_ruleXAnnotationElementValueOrCommaList= ruleXAnnotationElementValueOrCommaList EOF ;
	public final EObject entryRuleXAnnotationElementValueOrCommaList() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAnnotationElementValueOrCommaList =null;

		try {
			// InternalDsl.g:7989:75: (iv_ruleXAnnotationElementValueOrCommaList= ruleXAnnotationElementValueOrCommaList EOF )
			// InternalDsl.g:7990:2: iv_ruleXAnnotationElementValueOrCommaList= ruleXAnnotationElementValueOrCommaList EOF
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
	// InternalDsl.g:7996:1: ruleXAnnotationElementValueOrCommaList returns [EObject current=null] : ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression ) ;
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
			// InternalDsl.g:8002:2: ( ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression ) )
			// InternalDsl.g:8003:2: ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression )
			{
			// InternalDsl.g:8003:2: ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression )
			int alt128=2;
			int LA128_0 = input.LA(1);
			if ( (LA128_0==109) ) {
				int LA128_1 = input.LA(2);
				if ( (synpred47_InternalDsl()) ) {
					alt128=1;
				}
				else if ( (true) ) {
					alt128=2;
				}

			}
			else if ( ((LA128_0 >= RULE_CHARACTER && LA128_0 <= RULE_INT)||LA128_0==RULE_STRING||LA128_0==14||LA128_0==22||(LA128_0 >= 28 && LA128_0 <= 29)||(LA128_0 >= 32 && LA128_0 <= 33)||LA128_0==50||(LA128_0 >= 89 && LA128_0 <= 91)||LA128_0==96||(LA128_0 >= 98 && LA128_0 <= 99)||(LA128_0 >= 101 && LA128_0 <= 102)||LA128_0==106||LA128_0==114) ) {
				alt128=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 128, 0, input);
				throw nvae;
			}

			switch (alt128) {
				case 1 :
					// InternalDsl.g:8004:3: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' )
					{
					// InternalDsl.g:8004:3: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' )
					// InternalDsl.g:8005:4: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}'
					{
					// InternalDsl.g:8005:4: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) )
					// InternalDsl.g:8006:5: ( ( () '{' ) )=> ( () otherlv_1= '{' )
					{
					// InternalDsl.g:8012:5: ( () otherlv_1= '{' )
					// InternalDsl.g:8013:6: () otherlv_1= '{'
					{
					// InternalDsl.g:8013:6: ()
					// InternalDsl.g:8014:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElement(
													grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXJArrayLiteralAction_0_0_0_0(),
													current);
											}
					}

					otherlv_1=(Token)match(input,109,FOLLOW_105); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_1, grammarAccess.getXAnnotationElementValueOrCommaListAccess().getLeftCurlyBracketKeyword_0_0_0_1());
										}
					}

					}

					// InternalDsl.g:8026:4: ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )?
					int alt127=2;
					int LA127_0 = input.LA(1);
					if ( ((LA127_0 >= RULE_CHARACTER && LA127_0 <= RULE_INT)||LA127_0==RULE_STRING||LA127_0==14||LA127_0==22||(LA127_0 >= 28 && LA127_0 <= 29)||(LA127_0 >= 32 && LA127_0 <= 33)||LA127_0==50||(LA127_0 >= 89 && LA127_0 <= 91)||LA127_0==96||(LA127_0 >= 98 && LA127_0 <= 99)||(LA127_0 >= 101 && LA127_0 <= 102)||LA127_0==106||LA127_0==109||LA127_0==114) ) {
						alt127=1;
					}
					switch (alt127) {
						case 1 :
							// InternalDsl.g:8027:5: ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )*
							{
							// InternalDsl.g:8027:5: ( (lv_elements_2_0= ruleXAnnotationOrExpression ) )
							// InternalDsl.g:8028:6: (lv_elements_2_0= ruleXAnnotationOrExpression )
							{
							// InternalDsl.g:8028:6: (lv_elements_2_0= ruleXAnnotationOrExpression )
							// InternalDsl.g:8029:7: lv_elements_2_0= ruleXAnnotationOrExpression
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

							// InternalDsl.g:8046:5: (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )*
							loop126:
							while (true) {
								int alt126=2;
								int LA126_0 = input.LA(1);
								if ( (LA126_0==31) ) {
									alt126=1;
								}

								switch (alt126) {
								case 1 :
									// InternalDsl.g:8047:6: otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) )
									{
									otherlv_3=(Token)match(input,31,FOLLOW_106); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_3, grammarAccess.getXAnnotationElementValueOrCommaListAccess().getCommaKeyword_0_1_1_0());
														}
									// InternalDsl.g:8051:6: ( (lv_elements_4_0= ruleXAnnotationOrExpression ) )
									// InternalDsl.g:8052:7: (lv_elements_4_0= ruleXAnnotationOrExpression )
									{
									// InternalDsl.g:8052:7: (lv_elements_4_0= ruleXAnnotationOrExpression )
									// InternalDsl.g:8053:8: lv_elements_4_0= ruleXAnnotationOrExpression
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
									break loop126;
								}
							}

							}
							break;

					}

					otherlv_5=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_5, grammarAccess.getXAnnotationElementValueOrCommaListAccess().getRightCurlyBracketKeyword_0_2());
								}
					}

					}
					break;
				case 2 :
					// InternalDsl.g:8078:3: this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression
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
	// InternalDsl.g:8090:1: entryRuleXAnnotationElementValue returns [EObject current=null] :iv_ruleXAnnotationElementValue= ruleXAnnotationElementValue EOF ;
	public final EObject entryRuleXAnnotationElementValue() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAnnotationElementValue =null;

		try {
			// InternalDsl.g:8090:64: (iv_ruleXAnnotationElementValue= ruleXAnnotationElementValue EOF )
			// InternalDsl.g:8091:2: iv_ruleXAnnotationElementValue= ruleXAnnotationElementValue EOF
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
	// InternalDsl.g:8097:1: ruleXAnnotationElementValue returns [EObject current=null] : ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression ) ;
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
			// InternalDsl.g:8103:2: ( ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression ) )
			// InternalDsl.g:8104:2: ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression )
			{
			// InternalDsl.g:8104:2: ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' ) |this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression )
			int alt131=2;
			int LA131_0 = input.LA(1);
			if ( (LA131_0==109) ) {
				int LA131_1 = input.LA(2);
				if ( (synpred48_InternalDsl()) ) {
					alt131=1;
				}
				else if ( (true) ) {
					alt131=2;
				}

			}
			else if ( ((LA131_0 >= RULE_CHARACTER && LA131_0 <= RULE_INT)||LA131_0==RULE_STRING||LA131_0==14||LA131_0==22||(LA131_0 >= 28 && LA131_0 <= 29)||(LA131_0 >= 32 && LA131_0 <= 33)||LA131_0==50||(LA131_0 >= 89 && LA131_0 <= 91)||LA131_0==96||(LA131_0 >= 98 && LA131_0 <= 99)||(LA131_0 >= 101 && LA131_0 <= 102)||LA131_0==106||LA131_0==114) ) {
				alt131=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 131, 0, input);
				throw nvae;
			}

			switch (alt131) {
				case 1 :
					// InternalDsl.g:8105:3: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' )
					{
					// InternalDsl.g:8105:3: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}' )
					// InternalDsl.g:8106:4: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )? otherlv_5= '}'
					{
					// InternalDsl.g:8106:4: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) )
					// InternalDsl.g:8107:5: ( ( () '{' ) )=> ( () otherlv_1= '{' )
					{
					// InternalDsl.g:8113:5: ( () otherlv_1= '{' )
					// InternalDsl.g:8114:6: () otherlv_1= '{'
					{
					// InternalDsl.g:8114:6: ()
					// InternalDsl.g:8115:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElement(
													grammarAccess.getXAnnotationElementValueAccess().getXJArrayLiteralAction_0_0_0_0(),
													current);
											}
					}

					otherlv_1=(Token)match(input,109,FOLLOW_105); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_1, grammarAccess.getXAnnotationElementValueAccess().getLeftCurlyBracketKeyword_0_0_0_1());
										}
					}

					}

					// InternalDsl.g:8127:4: ( ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )* )?
					int alt130=2;
					int LA130_0 = input.LA(1);
					if ( ((LA130_0 >= RULE_CHARACTER && LA130_0 <= RULE_INT)||LA130_0==RULE_STRING||LA130_0==14||LA130_0==22||(LA130_0 >= 28 && LA130_0 <= 29)||(LA130_0 >= 32 && LA130_0 <= 33)||LA130_0==50||(LA130_0 >= 89 && LA130_0 <= 91)||LA130_0==96||(LA130_0 >= 98 && LA130_0 <= 99)||(LA130_0 >= 101 && LA130_0 <= 102)||LA130_0==106||LA130_0==109||LA130_0==114) ) {
						alt130=1;
					}
					switch (alt130) {
						case 1 :
							// InternalDsl.g:8128:5: ( (lv_elements_2_0= ruleXAnnotationOrExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )*
							{
							// InternalDsl.g:8128:5: ( (lv_elements_2_0= ruleXAnnotationOrExpression ) )
							// InternalDsl.g:8129:6: (lv_elements_2_0= ruleXAnnotationOrExpression )
							{
							// InternalDsl.g:8129:6: (lv_elements_2_0= ruleXAnnotationOrExpression )
							// InternalDsl.g:8130:7: lv_elements_2_0= ruleXAnnotationOrExpression
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

							// InternalDsl.g:8147:5: (otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) ) )*
							loop129:
							while (true) {
								int alt129=2;
								int LA129_0 = input.LA(1);
								if ( (LA129_0==31) ) {
									alt129=1;
								}

								switch (alt129) {
								case 1 :
									// InternalDsl.g:8148:6: otherlv_3= ',' ( (lv_elements_4_0= ruleXAnnotationOrExpression ) )
									{
									otherlv_3=(Token)match(input,31,FOLLOW_106); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_3, grammarAccess.getXAnnotationElementValueAccess().getCommaKeyword_0_1_1_0());
														}
									// InternalDsl.g:8152:6: ( (lv_elements_4_0= ruleXAnnotationOrExpression ) )
									// InternalDsl.g:8153:7: (lv_elements_4_0= ruleXAnnotationOrExpression )
									{
									// InternalDsl.g:8153:7: (lv_elements_4_0= ruleXAnnotationOrExpression )
									// InternalDsl.g:8154:8: lv_elements_4_0= ruleXAnnotationOrExpression
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
									break loop129;
								}
							}

							}
							break;

					}

					otherlv_5=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_5, grammarAccess.getXAnnotationElementValueAccess().getRightCurlyBracketKeyword_0_2());
								}
					}

					}
					break;
				case 2 :
					// InternalDsl.g:8179:3: this_XAnnotationOrExpression_6= ruleXAnnotationOrExpression
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
	// InternalDsl.g:8191:1: entryRuleXAnnotation returns [EObject current=null] :iv_ruleXAnnotation= ruleXAnnotation EOF ;
	public final EObject entryRuleXAnnotation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAnnotation =null;

		try {
			// InternalDsl.g:8191:52: (iv_ruleXAnnotation= ruleXAnnotation EOF )
			// InternalDsl.g:8192:2: iv_ruleXAnnotation= ruleXAnnotation EOF
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
	// InternalDsl.g:8198:1: ruleXAnnotation returns [EObject current=null] : ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )? ) ;
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
			// InternalDsl.g:8204:2: ( ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )? ) )
			// InternalDsl.g:8205:2: ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )? )
			{
			// InternalDsl.g:8205:2: ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )? )
			// InternalDsl.g:8206:3: () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )?
			{
			// InternalDsl.g:8206:3: ()
			// InternalDsl.g:8207:4: 
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
			// InternalDsl.g:8217:3: ( ( ruleQualifiedName ) )
			// InternalDsl.g:8218:4: ( ruleQualifiedName )
			{
			// InternalDsl.g:8218:4: ( ruleQualifiedName )
			// InternalDsl.g:8219:5: ruleQualifiedName
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

			// InternalDsl.g:8233:3: ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')' )?
			int alt134=2;
			int LA134_0 = input.LA(1);
			if ( (LA134_0==22) && (synpred49_InternalDsl())) {
				alt134=1;
			}
			switch (alt134) {
				case 1 :
					// InternalDsl.g:8234:4: ( ( '(' )=>otherlv_3= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )? otherlv_8= ')'
					{
					// InternalDsl.g:8234:4: ( ( '(' )=>otherlv_3= '(' )
					// InternalDsl.g:8235:5: ( '(' )=>otherlv_3= '('
					{
					otherlv_3=(Token)match(input,22,FOLLOW_107); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_3, grammarAccess.getXAnnotationAccess().getLeftParenthesisKeyword_3_0());
									}
					}

					// InternalDsl.g:8241:4: ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) ) )?
					int alt133=3;
					int LA133_0 = input.LA(1);
					if ( (LA133_0==RULE_ID) ) {
						int LA133_1 = input.LA(2);
						if ( (synpred50_InternalDsl()) ) {
							alt133=1;
						}
						else if ( (true) ) {
							alt133=2;
						}
					}
					else if ( ((LA133_0 >= RULE_CHARACTER && LA133_0 <= RULE_HEX)||LA133_0==RULE_INT||LA133_0==RULE_STRING||LA133_0==14||LA133_0==22||(LA133_0 >= 28 && LA133_0 <= 29)||(LA133_0 >= 32 && LA133_0 <= 33)||LA133_0==50||(LA133_0 >= 89 && LA133_0 <= 91)||LA133_0==96||(LA133_0 >= 98 && LA133_0 <= 99)||(LA133_0 >= 101 && LA133_0 <= 102)||LA133_0==106||LA133_0==109||LA133_0==114) ) {
						alt133=2;
					}
					switch (alt133) {
						case 1 :
							// InternalDsl.g:8242:5: ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* )
							{
							// InternalDsl.g:8242:5: ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* )
							// InternalDsl.g:8243:6: ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )*
							{
							// InternalDsl.g:8243:6: ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) )
							// InternalDsl.g:8244:7: ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair )
							{
							// InternalDsl.g:8253:7: (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair )
							// InternalDsl.g:8254:8: lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair
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

							// InternalDsl.g:8271:6: (otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )*
							loop132:
							while (true) {
								int alt132=2;
								int LA132_0 = input.LA(1);
								if ( (LA132_0==31) ) {
									alt132=1;
								}

								switch (alt132) {
								case 1 :
									// InternalDsl.g:8272:7: otherlv_5= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) )
									{
									otherlv_5=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_5, grammarAccess.getXAnnotationAccess().getCommaKeyword_3_1_0_1_0());
															}
									// InternalDsl.g:8276:7: ( ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) )
									// InternalDsl.g:8277:8: ( ( ( ( ruleValidID ) ) '=' ) )=> (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair )
									{
									// InternalDsl.g:8286:8: (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair )
									// InternalDsl.g:8287:9: lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair
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
									break loop132;
								}
							}

							}

							}
							break;
						case 2 :
							// InternalDsl.g:8307:5: ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) )
							{
							// InternalDsl.g:8307:5: ( (lv_value_7_0= ruleXAnnotationElementValueOrCommaList ) )
							// InternalDsl.g:8308:6: (lv_value_7_0= ruleXAnnotationElementValueOrCommaList )
							{
							// InternalDsl.g:8308:6: (lv_value_7_0= ruleXAnnotationElementValueOrCommaList )
							// InternalDsl.g:8309:7: lv_value_7_0= ruleXAnnotationElementValueOrCommaList
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
	// InternalDsl.g:8336:1: entryRuleXAnnotationElementValuePair returns [EObject current=null] :iv_ruleXAnnotationElementValuePair= ruleXAnnotationElementValuePair EOF ;
	public final EObject entryRuleXAnnotationElementValuePair() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAnnotationElementValuePair =null;

		try {
			// InternalDsl.g:8336:68: (iv_ruleXAnnotationElementValuePair= ruleXAnnotationElementValuePair EOF )
			// InternalDsl.g:8337:2: iv_ruleXAnnotationElementValuePair= ruleXAnnotationElementValuePair EOF
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
	// InternalDsl.g:8343:1: ruleXAnnotationElementValuePair returns [EObject current=null] : ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) ) ( (lv_value_2_0= ruleXAnnotationElementValue ) ) ) ;
	public final EObject ruleXAnnotationElementValuePair() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_value_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8349:2: ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) ) ( (lv_value_2_0= ruleXAnnotationElementValue ) ) ) )
			// InternalDsl.g:8350:2: ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) ) ( (lv_value_2_0= ruleXAnnotationElementValue ) ) )
			{
			// InternalDsl.g:8350:2: ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) ) ( (lv_value_2_0= ruleXAnnotationElementValue ) ) )
			// InternalDsl.g:8351:3: ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) ) ( (lv_value_2_0= ruleXAnnotationElementValue ) )
			{
			// InternalDsl.g:8351:3: ( ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' ) )
			// InternalDsl.g:8352:4: ( ( ( ( ruleValidID ) ) '=' ) )=> ( ( ( ruleValidID ) ) otherlv_1= '=' )
			{
			// InternalDsl.g:8361:4: ( ( ( ruleValidID ) ) otherlv_1= '=' )
			// InternalDsl.g:8362:5: ( ( ruleValidID ) ) otherlv_1= '='
			{
			// InternalDsl.g:8362:5: ( ( ruleValidID ) )
			// InternalDsl.g:8363:6: ( ruleValidID )
			{
			// InternalDsl.g:8363:6: ( ruleValidID )
			// InternalDsl.g:8364:7: ruleValidID
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

			// InternalDsl.g:8384:3: ( (lv_value_2_0= ruleXAnnotationElementValue ) )
			// InternalDsl.g:8385:4: (lv_value_2_0= ruleXAnnotationElementValue )
			{
			// InternalDsl.g:8385:4: (lv_value_2_0= ruleXAnnotationElementValue )
			// InternalDsl.g:8386:5: lv_value_2_0= ruleXAnnotationElementValue
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
	// InternalDsl.g:8407:1: entryRuleXAnnotationOrExpression returns [EObject current=null] :iv_ruleXAnnotationOrExpression= ruleXAnnotationOrExpression EOF ;
	public final EObject entryRuleXAnnotationOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAnnotationOrExpression =null;

		try {
			// InternalDsl.g:8407:64: (iv_ruleXAnnotationOrExpression= ruleXAnnotationOrExpression EOF )
			// InternalDsl.g:8408:2: iv_ruleXAnnotationOrExpression= ruleXAnnotationOrExpression EOF
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
	// InternalDsl.g:8414:1: ruleXAnnotationOrExpression returns [EObject current=null] : (this_XAnnotation_0= ruleXAnnotation |this_XExpression_1= ruleXExpression ) ;
	public final EObject ruleXAnnotationOrExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAnnotation_0 =null;
		EObject this_XExpression_1 =null;


			enterRule();

		try {
			// InternalDsl.g:8420:2: ( (this_XAnnotation_0= ruleXAnnotation |this_XExpression_1= ruleXExpression ) )
			// InternalDsl.g:8421:2: (this_XAnnotation_0= ruleXAnnotation |this_XExpression_1= ruleXExpression )
			{
			// InternalDsl.g:8421:2: (this_XAnnotation_0= ruleXAnnotation |this_XExpression_1= ruleXExpression )
			int alt135=2;
			int LA135_0 = input.LA(1);
			if ( (LA135_0==50) ) {
				alt135=1;
			}
			else if ( ((LA135_0 >= RULE_CHARACTER && LA135_0 <= RULE_INT)||LA135_0==RULE_STRING||LA135_0==14||LA135_0==22||(LA135_0 >= 28 && LA135_0 <= 29)||(LA135_0 >= 32 && LA135_0 <= 33)||(LA135_0 >= 89 && LA135_0 <= 91)||LA135_0==96||(LA135_0 >= 98 && LA135_0 <= 99)||(LA135_0 >= 101 && LA135_0 <= 102)||LA135_0==106||LA135_0==109||LA135_0==114) ) {
				alt135=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 135, 0, input);
				throw nvae;
			}

			switch (alt135) {
				case 1 :
					// InternalDsl.g:8422:3: this_XAnnotation_0= ruleXAnnotation
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
					// InternalDsl.g:8431:3: this_XExpression_1= ruleXExpression
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
	// InternalDsl.g:8443:1: entryRuleXExpression returns [EObject current=null] :iv_ruleXExpression= ruleXExpression EOF ;
	public final EObject entryRuleXExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpression =null;

		try {
			// InternalDsl.g:8443:52: (iv_ruleXExpression= ruleXExpression EOF )
			// InternalDsl.g:8444:2: iv_ruleXExpression= ruleXExpression EOF
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
	// InternalDsl.g:8450:1: ruleXExpression returns [EObject current=null] :this_XAssignment_0= ruleXAssignment ;
	public final EObject ruleXExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAssignment_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8456:2: (this_XAssignment_0= ruleXAssignment )
			// InternalDsl.g:8457:2: this_XAssignment_0= ruleXAssignment
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
	// InternalDsl.g:8468:1: entryRuleOpSingleAssign returns [String current=null] :iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
	public final String entryRuleOpSingleAssign() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpSingleAssign =null;

		try {
			// InternalDsl.g:8468:54: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
			// InternalDsl.g:8469:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
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
	// InternalDsl.g:8475:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
	public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:8481:2: (kw= '=' )
			// InternalDsl.g:8482:2: kw= '='
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
	// InternalDsl.g:8490:1: entryRuleXOrExpression returns [EObject current=null] :iv_ruleXOrExpression= ruleXOrExpression EOF ;
	public final EObject entryRuleXOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXOrExpression =null;

		try {
			// InternalDsl.g:8490:54: (iv_ruleXOrExpression= ruleXOrExpression EOF )
			// InternalDsl.g:8491:2: iv_ruleXOrExpression= ruleXOrExpression EOF
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
	// InternalDsl.g:8497:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
	public final EObject ruleXOrExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAndExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8503:2: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
			// InternalDsl.g:8504:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
			{
			// InternalDsl.g:8504:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
			// InternalDsl.g:8505:3: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
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
			// InternalDsl.g:8513:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
			loop136:
			while (true) {
				int alt136=2;
				int LA136_0 = input.LA(1);
				if ( (LA136_0==112) ) {
					int LA136_2 = input.LA(2);
					if ( (synpred53_InternalDsl()) ) {
						alt136=1;
					}

				}

				switch (alt136) {
				case 1 :
					// InternalDsl.g:8514:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
					{
					// InternalDsl.g:8514:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
					// InternalDsl.g:8515:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
					{
					// InternalDsl.g:8525:5: ( () ( ( ruleOpOr ) ) )
					// InternalDsl.g:8526:6: () ( ( ruleOpOr ) )
					{
					// InternalDsl.g:8526:6: ()
					// InternalDsl.g:8527:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:8533:6: ( ( ruleOpOr ) )
					// InternalDsl.g:8534:7: ( ruleOpOr )
					{
					// InternalDsl.g:8534:7: ( ruleOpOr )
					// InternalDsl.g:8535:8: ruleOpOr
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

					// InternalDsl.g:8551:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
					// InternalDsl.g:8552:5: (lv_rightOperand_3_0= ruleXAndExpression )
					{
					// InternalDsl.g:8552:5: (lv_rightOperand_3_0= ruleXAndExpression )
					// InternalDsl.g:8553:6: lv_rightOperand_3_0= ruleXAndExpression
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
					break loop136;
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
	// InternalDsl.g:8575:1: entryRuleOpOr returns [String current=null] :iv_ruleOpOr= ruleOpOr EOF ;
	public final String entryRuleOpOr() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpOr =null;

		try {
			// InternalDsl.g:8575:44: (iv_ruleOpOr= ruleOpOr EOF )
			// InternalDsl.g:8576:2: iv_ruleOpOr= ruleOpOr EOF
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
	// InternalDsl.g:8582:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
	public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:8588:2: (kw= '||' )
			// InternalDsl.g:8589:2: kw= '||'
			{
			kw=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:8597:1: entryRuleOpAnd returns [String current=null] :iv_ruleOpAnd= ruleOpAnd EOF ;
	public final String entryRuleOpAnd() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpAnd =null;

		try {
			// InternalDsl.g:8597:45: (iv_ruleOpAnd= ruleOpAnd EOF )
			// InternalDsl.g:8598:2: iv_ruleOpAnd= ruleOpAnd EOF
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
	// InternalDsl.g:8604:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
	public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:8610:2: (kw= '&&' )
			// InternalDsl.g:8611:2: kw= '&&'
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
	// InternalDsl.g:8619:1: entryRuleXEqualityExpression returns [EObject current=null] :iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
	public final EObject entryRuleXEqualityExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXEqualityExpression =null;

		try {
			// InternalDsl.g:8619:60: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
			// InternalDsl.g:8620:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
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
	// InternalDsl.g:8626:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
	public final EObject ruleXEqualityExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XRelationalExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8632:2: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
			// InternalDsl.g:8633:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
			{
			// InternalDsl.g:8633:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
			// InternalDsl.g:8634:3: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
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
			// InternalDsl.g:8642:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
			loop137:
			while (true) {
				int alt137=2;
				int LA137_0 = input.LA(1);
				if ( (LA137_0==46) ) {
					int LA137_2 = input.LA(2);
					if ( (synpred54_InternalDsl()) ) {
						alt137=1;
					}

				}
				else if ( (LA137_0==15) ) {
					int LA137_3 = input.LA(2);
					if ( (synpred54_InternalDsl()) ) {
						alt137=1;
					}

				}

				switch (alt137) {
				case 1 :
					// InternalDsl.g:8643:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
					{
					// InternalDsl.g:8643:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
					// InternalDsl.g:8644:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
					{
					// InternalDsl.g:8654:5: ( () ( ( ruleOpEquality ) ) )
					// InternalDsl.g:8655:6: () ( ( ruleOpEquality ) )
					{
					// InternalDsl.g:8655:6: ()
					// InternalDsl.g:8656:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:8662:6: ( ( ruleOpEquality ) )
					// InternalDsl.g:8663:7: ( ruleOpEquality )
					{
					// InternalDsl.g:8663:7: ( ruleOpEquality )
					// InternalDsl.g:8664:8: ruleOpEquality
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

					// InternalDsl.g:8680:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
					// InternalDsl.g:8681:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
					{
					// InternalDsl.g:8681:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
					// InternalDsl.g:8682:6: lv_rightOperand_3_0= ruleXRelationalExpression
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
	// $ANTLR end "ruleXEqualityExpression"



	// $ANTLR start "entryRuleXRelationalExpression"
	// InternalDsl.g:8704:1: entryRuleXRelationalExpression returns [EObject current=null] :iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
	public final EObject entryRuleXRelationalExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXRelationalExpression =null;

		try {
			// InternalDsl.g:8704:62: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
			// InternalDsl.g:8705:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
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
	// InternalDsl.g:8711:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
	public final EObject ruleXRelationalExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject this_XOtherOperatorExpression_0 =null;
		EObject lv_type_3_0 =null;
		EObject lv_rightOperand_6_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8717:2: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
			// InternalDsl.g:8718:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
			{
			// InternalDsl.g:8718:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
			// InternalDsl.g:8719:3: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
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
			// InternalDsl.g:8727:3: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
			loop138:
			while (true) {
				int alt138=3;
				switch ( input.LA(1) ) {
				case 42:
					{
					int LA138_2 = input.LA(2);
					if ( (synpred56_InternalDsl()) ) {
						alt138=2;
					}

					}
					break;
				case 47:
					{
					int LA138_3 = input.LA(2);
					if ( (synpred56_InternalDsl()) ) {
						alt138=2;
					}

					}
					break;
				case 97:
					{
					int LA138_4 = input.LA(2);
					if ( (synpred55_InternalDsl()) ) {
						alt138=1;
					}

					}
					break;
				case 48:
					{
					int LA138_5 = input.LA(2);
					if ( (synpred56_InternalDsl()) ) {
						alt138=2;
					}

					}
					break;
				}
				switch (alt138) {
				case 1 :
					// InternalDsl.g:8728:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
					{
					// InternalDsl.g:8728:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
					// InternalDsl.g:8729:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
					{
					// InternalDsl.g:8729:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
					// InternalDsl.g:8730:6: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
					{
					// InternalDsl.g:8736:6: ( () otherlv_2= 'instanceof' )
					// InternalDsl.g:8737:7: () otherlv_2= 'instanceof'
					{
					// InternalDsl.g:8737:7: ()
					// InternalDsl.g:8738:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
														current);
												}
					}

					otherlv_2=(Token)match(input,97,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
											}
					}

					}

					// InternalDsl.g:8750:5: ( (lv_type_3_0= ruleJvmTypeReference ) )
					// InternalDsl.g:8751:6: (lv_type_3_0= ruleJvmTypeReference )
					{
					// InternalDsl.g:8751:6: (lv_type_3_0= ruleJvmTypeReference )
					// InternalDsl.g:8752:7: lv_type_3_0= ruleJvmTypeReference
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
					// InternalDsl.g:8771:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
					{
					// InternalDsl.g:8771:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
					// InternalDsl.g:8772:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
					{
					// InternalDsl.g:8772:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
					// InternalDsl.g:8773:6: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
					{
					// InternalDsl.g:8783:6: ( () ( ( ruleOpCompare ) ) )
					// InternalDsl.g:8784:7: () ( ( ruleOpCompare ) )
					{
					// InternalDsl.g:8784:7: ()
					// InternalDsl.g:8785:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
														current);
												}
					}

					// InternalDsl.g:8791:7: ( ( ruleOpCompare ) )
					// InternalDsl.g:8792:8: ( ruleOpCompare )
					{
					// InternalDsl.g:8792:8: ( ruleOpCompare )
					// InternalDsl.g:8793:9: ruleOpCompare
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

					// InternalDsl.g:8809:5: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
					// InternalDsl.g:8810:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
					{
					// InternalDsl.g:8810:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
					// InternalDsl.g:8811:7: lv_rightOperand_6_0= ruleXOtherOperatorExpression
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
	// $ANTLR end "ruleXRelationalExpression"



	// $ANTLR start "entryRuleOpCompare"
	// InternalDsl.g:8834:1: entryRuleOpCompare returns [String current=null] :iv_ruleOpCompare= ruleOpCompare EOF ;
	public final String entryRuleOpCompare() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpCompare =null;

		try {
			// InternalDsl.g:8834:49: (iv_ruleOpCompare= ruleOpCompare EOF )
			// InternalDsl.g:8835:2: iv_ruleOpCompare= ruleOpCompare EOF
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
	// InternalDsl.g:8841:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' ) ;
	public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:8847:2: ( (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' ) )
			// InternalDsl.g:8848:2: (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' )
			{
			// InternalDsl.g:8848:2: (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' )
			int alt139=4;
			switch ( input.LA(1) ) {
			case 48:
				{
				alt139=1;
				}
				break;
			case 42:
				{
				int LA139_2 = input.LA(2);
				if ( (LA139_2==45) ) {
					alt139=2;
				}
				else if ( (LA139_2==EOF||(LA139_2 >= RULE_CHARACTER && LA139_2 <= RULE_INT)||LA139_2==RULE_STRING||LA139_2==14||LA139_2==22||(LA139_2 >= 28 && LA139_2 <= 29)||(LA139_2 >= 32 && LA139_2 <= 33)||(LA139_2 >= 89 && LA139_2 <= 91)||LA139_2==96||(LA139_2 >= 98 && LA139_2 <= 99)||(LA139_2 >= 101 && LA139_2 <= 102)||LA139_2==106||LA139_2==109||LA139_2==114) ) {
					alt139=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 139, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 47:
				{
				alt139=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 139, 0, input);
				throw nvae;
			}
			switch (alt139) {
				case 1 :
					// InternalDsl.g:8849:3: kw= '>='
					{
					kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:8855:3: (kw= '<' kw= '=' )
					{
					// InternalDsl.g:8855:3: (kw= '<' kw= '=' )
					// InternalDsl.g:8856:4: kw= '<' kw= '='
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
					// InternalDsl.g:8868:3: kw= '>'
					{
					kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalDsl.g:8874:3: kw= '<'
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
	// InternalDsl.g:8883:1: entryRuleXOtherOperatorExpression returns [EObject current=null] :iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
	public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXOtherOperatorExpression =null;

		try {
			// InternalDsl.g:8883:65: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
			// InternalDsl.g:8884:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
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
	// InternalDsl.g:8890:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
	public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAdditiveExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8896:2: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
			// InternalDsl.g:8897:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
			{
			// InternalDsl.g:8897:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
			// InternalDsl.g:8898:3: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
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
			// InternalDsl.g:8906:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
			loop140:
			while (true) {
				int alt140=2;
				int LA140_0 = input.LA(1);
				if ( (LA140_0==47) ) {
					int LA140_2 = input.LA(2);
					if ( (synpred57_InternalDsl()) ) {
						alt140=1;
					}

				}
				else if ( (LA140_0==43) ) {
					int LA140_3 = input.LA(2);
					if ( (synpred57_InternalDsl()) ) {
						alt140=1;
					}

				}

				switch (alt140) {
				case 1 :
					// InternalDsl.g:8907:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
					{
					// InternalDsl.g:8907:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
					// InternalDsl.g:8908:5: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
					{
					// InternalDsl.g:8918:5: ( () ( ( ruleOpOther ) ) )
					// InternalDsl.g:8919:6: () ( ( ruleOpOther ) )
					{
					// InternalDsl.g:8919:6: ()
					// InternalDsl.g:8920:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:8926:6: ( ( ruleOpOther ) )
					// InternalDsl.g:8927:7: ( ruleOpOther )
					{
					// InternalDsl.g:8927:7: ( ruleOpOther )
					// InternalDsl.g:8928:8: ruleOpOther
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

					// InternalDsl.g:8944:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
					// InternalDsl.g:8945:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
					{
					// InternalDsl.g:8945:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
					// InternalDsl.g:8946:6: lv_rightOperand_3_0= ruleXAdditiveExpression
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
					break loop140;
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
	// InternalDsl.g:8968:1: entryRuleXAdditiveExpression returns [EObject current=null] :iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
	public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAdditiveExpression =null;

		try {
			// InternalDsl.g:8968:60: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
			// InternalDsl.g:8969:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
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
	// InternalDsl.g:8975:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
	public final EObject ruleXAdditiveExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XMultiplicativeExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:8981:2: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
			// InternalDsl.g:8982:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
			{
			// InternalDsl.g:8982:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
			// InternalDsl.g:8983:3: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
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
			// InternalDsl.g:8991:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
			loop141:
			while (true) {
				int alt141=2;
				int LA141_0 = input.LA(1);
				if ( (LA141_0==28) ) {
					int LA141_2 = input.LA(2);
					if ( (synpred58_InternalDsl()) ) {
						alt141=1;
					}

				}
				else if ( (LA141_0==32) ) {
					int LA141_3 = input.LA(2);
					if ( (synpred58_InternalDsl()) ) {
						alt141=1;
					}

				}

				switch (alt141) {
				case 1 :
					// InternalDsl.g:8992:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
					{
					// InternalDsl.g:8992:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
					// InternalDsl.g:8993:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
					{
					// InternalDsl.g:9003:5: ( () ( ( ruleOpAdd ) ) )
					// InternalDsl.g:9004:6: () ( ( ruleOpAdd ) )
					{
					// InternalDsl.g:9004:6: ()
					// InternalDsl.g:9005:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:9011:6: ( ( ruleOpAdd ) )
					// InternalDsl.g:9012:7: ( ruleOpAdd )
					{
					// InternalDsl.g:9012:7: ( ruleOpAdd )
					// InternalDsl.g:9013:8: ruleOpAdd
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

					// InternalDsl.g:9029:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
					// InternalDsl.g:9030:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
					{
					// InternalDsl.g:9030:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
					// InternalDsl.g:9031:6: lv_rightOperand_3_0= ruleXMultiplicativeExpression
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
	// $ANTLR end "ruleXAdditiveExpression"



	// $ANTLR start "entryRuleOpAdd"
	// InternalDsl.g:9053:1: entryRuleOpAdd returns [String current=null] :iv_ruleOpAdd= ruleOpAdd EOF ;
	public final String entryRuleOpAdd() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpAdd =null;

		try {
			// InternalDsl.g:9053:45: (iv_ruleOpAdd= ruleOpAdd EOF )
			// InternalDsl.g:9054:2: iv_ruleOpAdd= ruleOpAdd EOF
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
	// InternalDsl.g:9060:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' |kw= '-' ) ;
	public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:9066:2: ( (kw= '+' |kw= '-' ) )
			// InternalDsl.g:9067:2: (kw= '+' |kw= '-' )
			{
			// InternalDsl.g:9067:2: (kw= '+' |kw= '-' )
			int alt142=2;
			int LA142_0 = input.LA(1);
			if ( (LA142_0==28) ) {
				alt142=1;
			}
			else if ( (LA142_0==32) ) {
				alt142=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 142, 0, input);
				throw nvae;
			}

			switch (alt142) {
				case 1 :
					// InternalDsl.g:9068:3: kw= '+'
					{
					kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:9074:3: kw= '-'
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
	// InternalDsl.g:9083:1: entryRuleXMultiplicativeExpression returns [EObject current=null] :iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
	public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXMultiplicativeExpression =null;

		try {
			// InternalDsl.g:9083:66: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
			// InternalDsl.g:9084:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
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
	// InternalDsl.g:9090:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
	public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XUnaryOperation_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9096:2: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
			// InternalDsl.g:9097:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
			{
			// InternalDsl.g:9097:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
			// InternalDsl.g:9098:3: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
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
			// InternalDsl.g:9106:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
			loop143:
			while (true) {
				int alt143=2;
				switch ( input.LA(1) ) {
				case 26:
					{
					int LA143_2 = input.LA(2);
					if ( (synpred59_InternalDsl()) ) {
						alt143=1;
					}

					}
					break;
				case 38:
					{
					int LA143_3 = input.LA(2);
					if ( (synpred59_InternalDsl()) ) {
						alt143=1;
					}

					}
					break;
				case 17:
					{
					int LA143_4 = input.LA(2);
					if ( (synpred59_InternalDsl()) ) {
						alt143=1;
					}

					}
					break;
				}
				switch (alt143) {
				case 1 :
					// InternalDsl.g:9107:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
					{
					// InternalDsl.g:9107:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
					// InternalDsl.g:9108:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
					{
					// InternalDsl.g:9118:5: ( () ( ( ruleOpMulti ) ) )
					// InternalDsl.g:9119:6: () ( ( ruleOpMulti ) )
					{
					// InternalDsl.g:9119:6: ()
					// InternalDsl.g:9120:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalDsl.g:9126:6: ( ( ruleOpMulti ) )
					// InternalDsl.g:9127:7: ( ruleOpMulti )
					{
					// InternalDsl.g:9127:7: ( ruleOpMulti )
					// InternalDsl.g:9128:8: ruleOpMulti
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

					// InternalDsl.g:9144:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
					// InternalDsl.g:9145:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
					{
					// InternalDsl.g:9145:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
					// InternalDsl.g:9146:6: lv_rightOperand_3_0= ruleXUnaryOperation
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
					break loop143;
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
	// InternalDsl.g:9168:1: entryRuleXUnaryOperation returns [EObject current=null] :iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
	public final EObject entryRuleXUnaryOperation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXUnaryOperation =null;

		try {
			// InternalDsl.g:9168:56: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
			// InternalDsl.g:9169:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
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
	// InternalDsl.g:9175:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression ) ;
	public final EObject ruleXUnaryOperation() throws RecognitionException {
		EObject current = null;


		EObject lv_operand_2_0 =null;
		EObject this_XCastedExpression_3 =null;


			enterRule();

		try {
			// InternalDsl.g:9181:2: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression ) )
			// InternalDsl.g:9182:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression )
			{
			// InternalDsl.g:9182:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression )
			int alt144=2;
			int LA144_0 = input.LA(1);
			if ( (LA144_0==14||LA144_0==28||LA144_0==32||LA144_0==114) ) {
				alt144=1;
			}
			else if ( ((LA144_0 >= RULE_CHARACTER && LA144_0 <= RULE_INT)||LA144_0==RULE_STRING||LA144_0==22||LA144_0==29||LA144_0==33||(LA144_0 >= 89 && LA144_0 <= 91)||LA144_0==96||(LA144_0 >= 98 && LA144_0 <= 99)||(LA144_0 >= 101 && LA144_0 <= 102)||LA144_0==106||LA144_0==109) ) {
				alt144=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 144, 0, input);
				throw nvae;
			}

			switch (alt144) {
				case 1 :
					// InternalDsl.g:9183:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
					{
					// InternalDsl.g:9183:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
					// InternalDsl.g:9184:4: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) )
					{
					// InternalDsl.g:9184:4: ()
					// InternalDsl.g:9185:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
											current);
									}
					}

					// InternalDsl.g:9191:4: ( ( ruleOpUnary ) )
					// InternalDsl.g:9192:5: ( ruleOpUnary )
					{
					// InternalDsl.g:9192:5: ( ruleOpUnary )
					// InternalDsl.g:9193:6: ruleOpUnary
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

					// InternalDsl.g:9207:4: ( (lv_operand_2_0= ruleXUnaryOperation ) )
					// InternalDsl.g:9208:5: (lv_operand_2_0= ruleXUnaryOperation )
					{
					// InternalDsl.g:9208:5: (lv_operand_2_0= ruleXUnaryOperation )
					// InternalDsl.g:9209:6: lv_operand_2_0= ruleXUnaryOperation
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
					// InternalDsl.g:9228:3: this_XCastedExpression_3= ruleXCastedExpression
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
	// InternalDsl.g:9240:1: entryRuleOpPostfix returns [String current=null] :iv_ruleOpPostfix= ruleOpPostfix EOF ;
	public final String entryRuleOpPostfix() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpPostfix =null;

		try {
			// InternalDsl.g:9240:49: (iv_ruleOpPostfix= ruleOpPostfix EOF )
			// InternalDsl.g:9241:2: iv_ruleOpPostfix= ruleOpPostfix EOF
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
	// InternalDsl.g:9247:1: ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' |kw= '--' ) ;
	public final AntlrDatatypeRuleToken ruleOpPostfix() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:9253:2: ( (kw= '++' |kw= '--' ) )
			// InternalDsl.g:9254:2: (kw= '++' |kw= '--' )
			{
			// InternalDsl.g:9254:2: (kw= '++' |kw= '--' )
			int alt145=2;
			int LA145_0 = input.LA(1);
			if ( (LA145_0==29) ) {
				alt145=1;
			}
			else if ( (LA145_0==33) ) {
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
					// InternalDsl.g:9255:3: kw= '++'
					{
					kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalDsl.g:9261:3: kw= '--'
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
	// InternalDsl.g:9270:1: entryRuleXSetLiteral returns [EObject current=null] :iv_ruleXSetLiteral= ruleXSetLiteral EOF ;
	public final EObject entryRuleXSetLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSetLiteral =null;

		try {
			// InternalDsl.g:9270:52: (iv_ruleXSetLiteral= ruleXSetLiteral EOF )
			// InternalDsl.g:9271:2: iv_ruleXSetLiteral= ruleXSetLiteral EOF
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
	// InternalDsl.g:9277:1: ruleXSetLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) ;
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
			// InternalDsl.g:9283:2: ( ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) )
			// InternalDsl.g:9284:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
			{
			// InternalDsl.g:9284:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
			// InternalDsl.g:9285:3: () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}'
			{
			// InternalDsl.g:9285:3: ()
			// InternalDsl.g:9286:4: 
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
			otherlv_2=(Token)match(input,109,FOLLOW_98); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXSetLiteralAccess().getLeftCurlyBracketKeyword_2());
					}
			// InternalDsl.g:9300:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
			int alt147=2;
			int LA147_0 = input.LA(1);
			if ( ((LA147_0 >= RULE_CHARACTER && LA147_0 <= RULE_INT)||LA147_0==RULE_STRING||LA147_0==14||LA147_0==22||(LA147_0 >= 28 && LA147_0 <= 29)||(LA147_0 >= 32 && LA147_0 <= 33)||(LA147_0 >= 89 && LA147_0 <= 91)||LA147_0==96||(LA147_0 >= 98 && LA147_0 <= 99)||(LA147_0 >= 101 && LA147_0 <= 102)||LA147_0==106||LA147_0==109||LA147_0==114) ) {
				alt147=1;
			}
			switch (alt147) {
				case 1 :
					// InternalDsl.g:9301:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					{
					// InternalDsl.g:9301:4: ( (lv_elements_3_0= ruleXExpression ) )
					// InternalDsl.g:9302:5: (lv_elements_3_0= ruleXExpression )
					{
					// InternalDsl.g:9302:5: (lv_elements_3_0= ruleXExpression )
					// InternalDsl.g:9303:6: lv_elements_3_0= ruleXExpression
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

					// InternalDsl.g:9320:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					loop146:
					while (true) {
						int alt146=2;
						int LA146_0 = input.LA(1);
						if ( (LA146_0==31) ) {
							alt146=1;
						}

						switch (alt146) {
						case 1 :
							// InternalDsl.g:9321:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
							{
							otherlv_4=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXSetLiteralAccess().getCommaKeyword_3_1_0());
											}
							// InternalDsl.g:9325:5: ( (lv_elements_5_0= ruleXExpression ) )
							// InternalDsl.g:9326:6: (lv_elements_5_0= ruleXExpression )
							{
							// InternalDsl.g:9326:6: (lv_elements_5_0= ruleXExpression )
							// InternalDsl.g:9327:7: lv_elements_5_0= ruleXExpression
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
							break loop146;
						}
					}

					}
					break;

			}

			otherlv_6=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:9354:1: entryRuleXListLiteral returns [EObject current=null] :iv_ruleXListLiteral= ruleXListLiteral EOF ;
	public final EObject entryRuleXListLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXListLiteral =null;

		try {
			// InternalDsl.g:9354:53: (iv_ruleXListLiteral= ruleXListLiteral EOF )
			// InternalDsl.g:9355:2: iv_ruleXListLiteral= ruleXListLiteral EOF
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
	// InternalDsl.g:9361:1: ruleXListLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) ;
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
			// InternalDsl.g:9367:2: ( ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) )
			// InternalDsl.g:9368:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
			{
			// InternalDsl.g:9368:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
			// InternalDsl.g:9369:3: () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']'
			{
			// InternalDsl.g:9369:3: ()
			// InternalDsl.g:9370:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXListLiteralAccess().getXListLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,16,FOLLOW_44); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXListLiteralAccess().getNumberSignKeyword_1());
					}
			otherlv_2=(Token)match(input,77,FOLLOW_78); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXListLiteralAccess().getLeftSquareBracketKeyword_2());
					}
			// InternalDsl.g:9384:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
			int alt149=2;
			int LA149_0 = input.LA(1);
			if ( ((LA149_0 >= RULE_CHARACTER && LA149_0 <= RULE_INT)||LA149_0==RULE_STRING||LA149_0==14||LA149_0==22||(LA149_0 >= 28 && LA149_0 <= 29)||(LA149_0 >= 32 && LA149_0 <= 33)||(LA149_0 >= 89 && LA149_0 <= 91)||LA149_0==96||(LA149_0 >= 98 && LA149_0 <= 99)||(LA149_0 >= 101 && LA149_0 <= 102)||LA149_0==106||LA149_0==109||LA149_0==114) ) {
				alt149=1;
			}
			switch (alt149) {
				case 1 :
					// InternalDsl.g:9385:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					{
					// InternalDsl.g:9385:4: ( (lv_elements_3_0= ruleXExpression ) )
					// InternalDsl.g:9386:5: (lv_elements_3_0= ruleXExpression )
					{
					// InternalDsl.g:9386:5: (lv_elements_3_0= ruleXExpression )
					// InternalDsl.g:9387:6: lv_elements_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
										}
					pushFollow(FOLLOW_45);
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

					// InternalDsl.g:9404:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					loop148:
					while (true) {
						int alt148=2;
						int LA148_0 = input.LA(1);
						if ( (LA148_0==31) ) {
							alt148=1;
						}

						switch (alt148) {
						case 1 :
							// InternalDsl.g:9405:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
							{
							otherlv_4=(Token)match(input,31,FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXListLiteralAccess().getCommaKeyword_3_1_0());
											}
							// InternalDsl.g:9409:5: ( (lv_elements_5_0= ruleXExpression ) )
							// InternalDsl.g:9410:6: (lv_elements_5_0= ruleXExpression )
							{
							// InternalDsl.g:9410:6: (lv_elements_5_0= ruleXExpression )
							// InternalDsl.g:9411:7: lv_elements_5_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
													}
							pushFollow(FOLLOW_45);
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
							break loop148;
						}
					}

					}
					break;

			}

			otherlv_6=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:9438:1: entryRuleXExpressionInClosure returns [EObject current=null] :iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
	public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpressionInClosure =null;

		try {
			// InternalDsl.g:9438:61: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
			// InternalDsl.g:9439:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
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
	// InternalDsl.g:9445:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
	public final EObject ruleXExpressionInClosure() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject lv_expressions_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9451:2: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
			// InternalDsl.g:9452:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
			{
			// InternalDsl.g:9452:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
			// InternalDsl.g:9453:3: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
			{
			// InternalDsl.g:9453:3: ()
			// InternalDsl.g:9454:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
								current);
						}
			}

			// InternalDsl.g:9460:3: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
			loop151:
			while (true) {
				int alt151=2;
				int LA151_0 = input.LA(1);
				if ( ((LA151_0 >= RULE_CHARACTER && LA151_0 <= RULE_INT)||LA151_0==RULE_STRING||LA151_0==14||LA151_0==22||(LA151_0 >= 28 && LA151_0 <= 29)||(LA151_0 >= 32 && LA151_0 <= 33)||(LA151_0 >= 89 && LA151_0 <= 92)||LA151_0==96||(LA151_0 >= 98 && LA151_0 <= 99)||(LA151_0 >= 101 && LA151_0 <= 102)||LA151_0==106||LA151_0==109||LA151_0==114) ) {
					alt151=1;
				}

				switch (alt151) {
				case 1 :
					// InternalDsl.g:9461:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
					{
					// InternalDsl.g:9461:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
					// InternalDsl.g:9462:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
					{
					// InternalDsl.g:9462:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
					// InternalDsl.g:9463:6: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
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

					// InternalDsl.g:9480:4: (otherlv_2= ';' )?
					int alt150=2;
					int LA150_0 = input.LA(1);
					if ( (LA150_0==41) ) {
						alt150=1;
					}
					switch (alt150) {
						case 1 :
							// InternalDsl.g:9481:5: otherlv_2= ';'
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
					break loop151;
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
	// InternalDsl.g:9491:1: entryRuleXParenthesizedExpression returns [EObject current=null] :iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
	public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXParenthesizedExpression =null;

		try {
			// InternalDsl.g:9491:65: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
			// InternalDsl.g:9492:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
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
	// InternalDsl.g:9498:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
	public final EObject ruleXParenthesizedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token otherlv_2=null;
		EObject this_XExpression_1 =null;


			enterRule();

		try {
			// InternalDsl.g:9504:2: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
			// InternalDsl.g:9505:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
			{
			// InternalDsl.g:9505:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
			// InternalDsl.g:9506:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
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
	// InternalDsl.g:9526:1: entryRuleXExpressionOrVarDeclaration returns [EObject current=null] :iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF ;
	public final EObject entryRuleXExpressionOrVarDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpressionOrVarDeclaration =null;

		try {
			// InternalDsl.g:9526:68: (iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF )
			// InternalDsl.g:9527:2: iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF
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
	// InternalDsl.g:9533:1: ruleXExpressionOrVarDeclaration returns [EObject current=null] : ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration ) |this_XExpression_1= ruleXExpression ) ;
	public final EObject ruleXExpressionOrVarDeclaration() throws RecognitionException {
		EObject current = null;


		EObject this_XVariableDeclaration_0 =null;
		EObject this_XExpression_1 =null;


			enterRule();

		try {
			// InternalDsl.g:9539:2: ( ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration ) |this_XExpression_1= ruleXExpression ) )
			// InternalDsl.g:9540:2: ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration ) |this_XExpression_1= ruleXExpression )
			{
			// InternalDsl.g:9540:2: ( ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration ) |this_XExpression_1= ruleXExpression )
			int alt152=2;
			int LA152_0 = input.LA(1);
			if ( (LA152_0==92) && (synpred60_InternalDsl())) {
				alt152=1;
			}
			else if ( (LA152_0==RULE_ID) ) {
				int LA152_2 = input.LA(2);
				if ( (synpred60_InternalDsl()) ) {
					alt152=1;
				}
				else if ( (true) ) {
					alt152=2;
				}

			}
			else if ( ((LA152_0 >= RULE_CHARACTER && LA152_0 <= RULE_HEX)||LA152_0==RULE_INT||LA152_0==RULE_STRING||LA152_0==14||LA152_0==22||(LA152_0 >= 28 && LA152_0 <= 29)||(LA152_0 >= 32 && LA152_0 <= 33)||(LA152_0 >= 89 && LA152_0 <= 91)||LA152_0==96||(LA152_0 >= 98 && LA152_0 <= 99)||(LA152_0 >= 101 && LA152_0 <= 102)||LA152_0==106||LA152_0==109||LA152_0==114) ) {
				alt152=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 152, 0, input);
				throw nvae;
			}

			switch (alt152) {
				case 1 :
					// InternalDsl.g:9541:3: ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration )
					{
					// InternalDsl.g:9541:3: ( ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration )
					// InternalDsl.g:9542:4: ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=>this_XVariableDeclaration_0= ruleXVariableDeclaration
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
					// InternalDsl.g:9572:3: this_XExpression_1= ruleXExpression
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
	// InternalDsl.g:9584:1: entryRuleJvmFormalParameter returns [EObject current=null] :iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
	public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmFormalParameter =null;

		try {
			// InternalDsl.g:9584:59: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
			// InternalDsl.g:9585:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
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
	// InternalDsl.g:9591:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
	public final EObject ruleJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject lv_parameterType_0_0 =null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9597:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
			// InternalDsl.g:9598:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
			{
			// InternalDsl.g:9598:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
			// InternalDsl.g:9599:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
			{
			// InternalDsl.g:9599:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
			int alt153=2;
			int LA153_0 = input.LA(1);
			if ( (LA153_0==RULE_ID) ) {
				int LA153_1 = input.LA(2);
				if ( (LA153_1==RULE_ID||LA153_1==36||LA153_1==42||LA153_1==77) ) {
					alt153=1;
				}
			}
			switch (alt153) {
				case 1 :
					// InternalDsl.g:9600:4: (lv_parameterType_0_0= ruleJvmTypeReference )
					{
					// InternalDsl.g:9600:4: (lv_parameterType_0_0= ruleJvmTypeReference )
					// InternalDsl.g:9601:5: lv_parameterType_0_0= ruleJvmTypeReference
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

			// InternalDsl.g:9618:3: ( (lv_name_1_0= ruleValidID ) )
			// InternalDsl.g:9619:4: (lv_name_1_0= ruleValidID )
			{
			// InternalDsl.g:9619:4: (lv_name_1_0= ruleValidID )
			// InternalDsl.g:9620:5: lv_name_1_0= ruleValidID
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
	// InternalDsl.g:9641:1: entryRuleFeatureCallID returns [String current=null] :iv_ruleFeatureCallID= ruleFeatureCallID EOF ;
	public final String entryRuleFeatureCallID() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleFeatureCallID =null;

		try {
			// InternalDsl.g:9641:53: (iv_ruleFeatureCallID= ruleFeatureCallID EOF )
			// InternalDsl.g:9642:2: iv_ruleFeatureCallID= ruleFeatureCallID EOF
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
	// InternalDsl.g:9648:1: ruleFeatureCallID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' ) ;
	public final AntlrDatatypeRuleToken ruleFeatureCallID() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9654:2: ( (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' ) )
			// InternalDsl.g:9655:2: (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' )
			{
			// InternalDsl.g:9655:2: (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' )
			int alt154=5;
			switch ( input.LA(1) ) {
			case RULE_ID:
				{
				alt154=1;
				}
				break;
			case 89:
				{
				alt154=2;
				}
				break;
			case 101:
				{
				alt154=3;
				}
				break;
			case 96:
				{
				alt154=4;
				}
				break;
			case 90:
				{
				alt154=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 154, 0, input);
				throw nvae;
			}
			switch (alt154) {
				case 1 :
					// InternalDsl.g:9656:3: this_ValidID_0= ruleValidID
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
					// InternalDsl.g:9667:3: kw= 'extends'
					{
					kw=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtendsKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalDsl.g:9673:3: kw= 'static'
					{
					kw=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getStaticKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalDsl.g:9679:3: kw= 'import'
					{
					kw=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getImportKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalDsl.g:9685:3: kw= 'extension'
					{
					kw=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:9694:1: entryRuleIdOrSuper returns [String current=null] :iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
	public final String entryRuleIdOrSuper() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleIdOrSuper =null;

		try {
			// InternalDsl.g:9694:49: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
			// InternalDsl.g:9695:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
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
	// InternalDsl.g:9701:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' ) ;
	public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_FeatureCallID_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9707:2: ( (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' ) )
			// InternalDsl.g:9708:2: (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' )
			{
			// InternalDsl.g:9708:2: (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' )
			int alt155=2;
			int LA155_0 = input.LA(1);
			if ( (LA155_0==RULE_ID||(LA155_0 >= 89 && LA155_0 <= 90)||LA155_0==96||LA155_0==101) ) {
				alt155=1;
			}
			else if ( (LA155_0==102) ) {
				alt155=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 155, 0, input);
				throw nvae;
			}

			switch (alt155) {
				case 1 :
					// InternalDsl.g:9709:3: this_FeatureCallID_0= ruleFeatureCallID
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
					// InternalDsl.g:9720:3: kw= 'super'
					{
					kw=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:9729:1: entryRuleXBooleanLiteral returns [EObject current=null] :iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
	public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBooleanLiteral =null;

		try {
			// InternalDsl.g:9729:56: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
			// InternalDsl.g:9730:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
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
	// InternalDsl.g:9736:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
	public final EObject ruleXBooleanLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token lv_isTrue_2_0=null;


			enterRule();

		try {
			// InternalDsl.g:9742:2: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
			// InternalDsl.g:9743:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
			{
			// InternalDsl.g:9743:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
			// InternalDsl.g:9744:3: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
			{
			// InternalDsl.g:9744:3: ()
			// InternalDsl.g:9745:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
								current);
						}
			}

			// InternalDsl.g:9751:3: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
			int alt156=2;
			int LA156_0 = input.LA(1);
			if ( (LA156_0==91) ) {
				alt156=1;
			}
			else if ( (LA156_0==106) ) {
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
					// InternalDsl.g:9752:4: otherlv_1= 'false'
					{
					otherlv_1=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
								}
					}
					break;
				case 2 :
					// InternalDsl.g:9757:4: ( (lv_isTrue_2_0= 'true' ) )
					{
					// InternalDsl.g:9757:4: ( (lv_isTrue_2_0= 'true' ) )
					// InternalDsl.g:9758:5: (lv_isTrue_2_0= 'true' )
					{
					// InternalDsl.g:9758:5: (lv_isTrue_2_0= 'true' )
					// InternalDsl.g:9759:6: lv_isTrue_2_0= 'true'
					{
					lv_isTrue_2_0=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXBooleanLiteralRule());
											}
											setWithLastConsumed(current, "isTrue", true, "true");
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
	// InternalDsl.g:9776:1: entryRuleXNullLiteral returns [EObject current=null] :iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
	public final EObject entryRuleXNullLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXNullLiteral =null;

		try {
			// InternalDsl.g:9776:53: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
			// InternalDsl.g:9777:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
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
	// InternalDsl.g:9783:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
	public final EObject ruleXNullLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;


			enterRule();

		try {
			// InternalDsl.g:9789:2: ( ( () otherlv_1= 'null' ) )
			// InternalDsl.g:9790:2: ( () otherlv_1= 'null' )
			{
			// InternalDsl.g:9790:2: ( () otherlv_1= 'null' )
			// InternalDsl.g:9791:3: () otherlv_1= 'null'
			{
			// InternalDsl.g:9791:3: ()
			// InternalDsl.g:9792:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:9806:1: entryRuleXNumberLiteral returns [EObject current=null] :iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
	public final EObject entryRuleXNumberLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXNumberLiteral =null;

		try {
			// InternalDsl.g:9806:55: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
			// InternalDsl.g:9807:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
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
	// InternalDsl.g:9813:1: ruleXNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
	public final EObject ruleXNumberLiteral() throws RecognitionException {
		EObject current = null;


		AntlrDatatypeRuleToken lv_value_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9819:2: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
			// InternalDsl.g:9820:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
			{
			// InternalDsl.g:9820:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
			// InternalDsl.g:9821:3: () ( (lv_value_1_0= ruleNumber ) )
			{
			// InternalDsl.g:9821:3: ()
			// InternalDsl.g:9822:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
								current);
						}
			}

			// InternalDsl.g:9828:3: ( (lv_value_1_0= ruleNumber ) )
			// InternalDsl.g:9829:4: (lv_value_1_0= ruleNumber )
			{
			// InternalDsl.g:9829:4: (lv_value_1_0= ruleNumber )
			// InternalDsl.g:9830:5: lv_value_1_0= ruleNumber
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
	// InternalDsl.g:9851:1: entryRuleXThrowExpression returns [EObject current=null] :iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
	public final EObject entryRuleXThrowExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXThrowExpression =null;

		try {
			// InternalDsl.g:9851:57: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
			// InternalDsl.g:9852:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
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
	// InternalDsl.g:9858:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
	public final EObject ruleXThrowExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_expression_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9864:2: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
			// InternalDsl.g:9865:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
			{
			// InternalDsl.g:9865:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
			// InternalDsl.g:9866:3: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
			{
			// InternalDsl.g:9866:3: ()
			// InternalDsl.g:9867:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,105,FOLLOW_66); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
					}
			// InternalDsl.g:9877:3: ( (lv_expression_2_0= ruleXExpression ) )
			// InternalDsl.g:9878:4: (lv_expression_2_0= ruleXExpression )
			{
			// InternalDsl.g:9878:4: (lv_expression_2_0= ruleXExpression )
			// InternalDsl.g:9879:5: lv_expression_2_0= ruleXExpression
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
	// InternalDsl.g:9900:1: entryRuleXReturnExpression returns [EObject current=null] :iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
	public final EObject entryRuleXReturnExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXReturnExpression =null;

		try {
			// InternalDsl.g:9900:58: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
			// InternalDsl.g:9901:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
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
	// InternalDsl.g:9907:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
	public final EObject ruleXReturnExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_expression_2_0 =null;


			enterRule();

		try {
			// InternalDsl.g:9913:2: ( ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) )
			// InternalDsl.g:9914:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
			{
			// InternalDsl.g:9914:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
			// InternalDsl.g:9915:3: () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
			{
			// InternalDsl.g:9915:3: ()
			// InternalDsl.g:9916:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,100,FOLLOW_116); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
					}
			// InternalDsl.g:9926:3: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
			int alt157=2;
			switch ( input.LA(1) ) {
				case RULE_ID:
					{
					int LA157_1 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 89:
					{
					int LA157_2 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 101:
					{
					int LA157_3 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 96:
					{
					int LA157_4 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 90:
					{
					int LA157_5 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 14:
					{
					int LA157_6 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 32:
					{
					int LA157_7 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 28:
					{
					int LA157_8 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 114:
					{
					int LA157_9 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 22:
					{
					int LA157_10 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 29:
					{
					int LA157_11 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 33:
					{
					int LA157_12 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 98:
					{
					int LA157_13 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 102:
					{
					int LA157_14 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 91:
					{
					int LA157_15 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 106:
					{
					int LA157_16 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case RULE_HEX:
					{
					int LA157_17 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case RULE_INT:
					{
					int LA157_18 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case RULE_DECIMAL:
					{
					int LA157_19 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 99:
					{
					int LA157_20 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case RULE_CHARACTER:
					{
					int LA157_21 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case RULE_STRING:
					{
					int LA157_22 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
				case 109:
					{
					int LA157_23 = input.LA(2);
					if ( (synpred61_InternalDsl()) ) {
						alt157=1;
					}
					}
					break;
			}
			switch (alt157) {
				case 1 :
					// InternalDsl.g:9927:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )=> (lv_expression_2_0= ruleXExpression )
					{
					// InternalDsl.g:9928:4: (lv_expression_2_0= ruleXExpression )
					// InternalDsl.g:9929:5: lv_expression_2_0= ruleXExpression
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
	// InternalDsl.g:9950:1: entryRuleQualifiedName returns [String current=null] :iv_ruleQualifiedName= ruleQualifiedName EOF ;
	public final String entryRuleQualifiedName() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedName =null;

		try {
			// InternalDsl.g:9950:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
			// InternalDsl.g:9951:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
	// InternalDsl.g:9957:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
	public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;
		AntlrDatatypeRuleToken this_ValidID_2 =null;


			enterRule();

		try {
			// InternalDsl.g:9963:2: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
			// InternalDsl.g:9964:2: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
			{
			// InternalDsl.g:9964:2: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
			// InternalDsl.g:9965:3: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
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
			// InternalDsl.g:9975:3: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
			loop158:
			while (true) {
				int alt158=2;
				int LA158_0 = input.LA(1);
				if ( (LA158_0==36) ) {
					int LA158_2 = input.LA(2);
					if ( (LA158_2==RULE_ID) ) {
						int LA158_3 = input.LA(3);
						if ( (synpred62_InternalDsl()) ) {
							alt158=1;
						}

					}

				}

				switch (alt158) {
				case 1 :
					// InternalDsl.g:9976:4: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
					{
					// InternalDsl.g:9976:4: ( ( '.' )=>kw= '.' )
					// InternalDsl.g:9977:5: ( '.' )=>kw= '.'
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
					break loop158;
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
	// InternalDsl.g:9999:1: entryRuleNumber returns [String current=null] :iv_ruleNumber= ruleNumber EOF ;
	public final String entryRuleNumber() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleNumber =null;


			HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

		try {
			// InternalDsl.g:10001:2: (iv_ruleNumber= ruleNumber EOF )
			// InternalDsl.g:10002:2: iv_ruleNumber= ruleNumber EOF
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
	// InternalDsl.g:10011:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
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
			// InternalDsl.g:10018:2: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
			// InternalDsl.g:10019:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) )
			{
			// InternalDsl.g:10019:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) )
			int alt162=2;
			int LA162_0 = input.LA(1);
			if ( (LA162_0==RULE_HEX) ) {
				alt162=1;
			}
			else if ( (LA162_0==RULE_DECIMAL||LA162_0==RULE_INT) ) {
				alt162=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 162, 0, input);
				throw nvae;
			}

			switch (alt162) {
				case 1 :
					// InternalDsl.g:10020:3: this_HEX_0= RULE_HEX
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
					// InternalDsl.g:10028:3: ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? )
					{
					// InternalDsl.g:10028:3: ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? )
					// InternalDsl.g:10029:4: (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )?
					{
					// InternalDsl.g:10029:4: (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL )
					int alt159=2;
					int LA159_0 = input.LA(1);
					if ( (LA159_0==RULE_INT) ) {
						alt159=1;
					}
					else if ( (LA159_0==RULE_DECIMAL) ) {
						alt159=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 159, 0, input);
						throw nvae;
					}

					switch (alt159) {
						case 1 :
							// InternalDsl.g:10030:5: this_INT_1= RULE_INT
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
							// InternalDsl.g:10038:5: this_DECIMAL_2= RULE_DECIMAL
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

					// InternalDsl.g:10046:4: (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )?
					int alt161=2;
					int LA161_0 = input.LA(1);
					if ( (LA161_0==36) ) {
						int LA161_1 = input.LA(2);
						if ( (LA161_1==RULE_DECIMAL||LA161_1==RULE_INT) ) {
							alt161=1;
						}
					}
					switch (alt161) {
						case 1 :
							// InternalDsl.g:10047:5: kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL )
							{
							kw=(Token)match(input,36,FOLLOW_117); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(kw);
												newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0());
											}
							// InternalDsl.g:10052:5: (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL )
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
									// InternalDsl.g:10053:6: this_INT_4= RULE_INT
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
									// InternalDsl.g:10061:6: this_DECIMAL_5= RULE_DECIMAL
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
	// InternalDsl.g:10078:1: entryRuleArrayBrackets returns [String current=null] :iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
	public final String entryRuleArrayBrackets() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleArrayBrackets =null;

		try {
			// InternalDsl.g:10078:53: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
			// InternalDsl.g:10079:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
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
	// InternalDsl.g:10085:1: ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' kw= ']' ) ;
	public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalDsl.g:10091:2: ( (kw= '[' kw= ']' ) )
			// InternalDsl.g:10092:2: (kw= '[' kw= ']' )
			{
			// InternalDsl.g:10092:2: (kw= '[' kw= ']' )
			// InternalDsl.g:10093:3: kw= '[' kw= ']'
			{
			kw=(Token)match(input,77,FOLLOW_15); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(kw);
						newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0());
					}
			kw=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
	// InternalDsl.g:10107:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] :iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
	public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmParameterizedTypeReference =null;

		try {
			// InternalDsl.g:10107:70: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
			// InternalDsl.g:10108:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
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
	// InternalDsl.g:10114:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
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
			// InternalDsl.g:10120:2: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
			// InternalDsl.g:10121:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
			{
			// InternalDsl.g:10121:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
			// InternalDsl.g:10122:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
			{
			// InternalDsl.g:10122:3: ( ( ruleQualifiedName ) )
			// InternalDsl.g:10123:4: ( ruleQualifiedName )
			{
			// InternalDsl.g:10123:4: ( ruleQualifiedName )
			// InternalDsl.g:10124:5: ruleQualifiedName
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

			// InternalDsl.g:10138:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
			int alt167=2;
			alt167 = dfa167.predict(input);
			switch (alt167) {
				case 1 :
					// InternalDsl.g:10139:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
					{
					// InternalDsl.g:10139:4: ( ( '<' )=>otherlv_1= '<' )
					// InternalDsl.g:10140:5: ( '<' )=>otherlv_1= '<'
					{
					otherlv_1=(Token)match(input,42,FOLLOW_77); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
									}
					}

					// InternalDsl.g:10146:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
					// InternalDsl.g:10147:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
					{
					// InternalDsl.g:10147:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
					// InternalDsl.g:10148:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
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

					// InternalDsl.g:10165:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
					loop163:
					while (true) {
						int alt163=2;
						int LA163_0 = input.LA(1);
						if ( (LA163_0==31) ) {
							alt163=1;
						}

						switch (alt163) {
						case 1 :
							// InternalDsl.g:10166:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
							{
							otherlv_3=(Token)match(input,31,FOLLOW_77); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
											}
							// InternalDsl.g:10170:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
							// InternalDsl.g:10171:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
							{
							// InternalDsl.g:10171:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
							// InternalDsl.g:10172:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
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
							break loop163;
						}
					}

					otherlv_5=(Token)match(input,47,FOLLOW_27); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
								}
					// InternalDsl.g:10194:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
					loop166:
					while (true) {
						int alt166=2;
						int LA166_0 = input.LA(1);
						if ( (LA166_0==36) ) {
							int LA166_2 = input.LA(2);
							if ( (LA166_2==RULE_ID) ) {
								int LA166_3 = input.LA(3);
								if ( (synpred64_InternalDsl()) ) {
									alt166=1;
								}

							}

						}

						switch (alt166) {
						case 1 :
							// InternalDsl.g:10195:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
							{
							// InternalDsl.g:10195:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
							// InternalDsl.g:10196:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
							{
							// InternalDsl.g:10202:6: ( () otherlv_7= '.' )
							// InternalDsl.g:10203:7: () otherlv_7= '.'
							{
							// InternalDsl.g:10203:7: ()
							// InternalDsl.g:10204:8: 
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

							// InternalDsl.g:10216:5: ( ( ruleValidID ) )
							// InternalDsl.g:10217:6: ( ruleValidID )
							{
							// InternalDsl.g:10217:6: ( ruleValidID )
							// InternalDsl.g:10218:7: ruleValidID
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

							// InternalDsl.g:10232:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
							int alt165=2;
							alt165 = dfa165.predict(input);
							switch (alt165) {
								case 1 :
									// InternalDsl.g:10233:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
									{
									// InternalDsl.g:10233:6: ( ( '<' )=>otherlv_9= '<' )
									// InternalDsl.g:10234:7: ( '<' )=>otherlv_9= '<'
									{
									otherlv_9=(Token)match(input,42,FOLLOW_77); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_9, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0());
															}
									}

									// InternalDsl.g:10240:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
									// InternalDsl.g:10241:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
									{
									// InternalDsl.g:10241:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
									// InternalDsl.g:10242:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
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

									// InternalDsl.g:10259:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
									loop164:
									while (true) {
										int alt164=2;
										int LA164_0 = input.LA(1);
										if ( (LA164_0==31) ) {
											alt164=1;
										}

										switch (alt164) {
										case 1 :
											// InternalDsl.g:10260:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
											{
											otherlv_11=(Token)match(input,31,FOLLOW_77); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																		newLeafNode(otherlv_11, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0());
																	}
											// InternalDsl.g:10264:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
											// InternalDsl.g:10265:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
											{
											// InternalDsl.g:10265:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
											// InternalDsl.g:10266:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
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
											break loop164;
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
							break loop166;
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
	// InternalDsl.g:10295:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] :iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
	public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmArgumentTypeReference =null;

		try {
			// InternalDsl.g:10295:65: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
			// InternalDsl.g:10296:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
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
	// InternalDsl.g:10302:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
	public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
		EObject current = null;


		EObject this_JvmTypeReference_0 =null;
		EObject this_JvmWildcardTypeReference_1 =null;


			enterRule();

		try {
			// InternalDsl.g:10308:2: ( (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
			// InternalDsl.g:10309:2: (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
			{
			// InternalDsl.g:10309:2: (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
			int alt168=2;
			int LA168_0 = input.LA(1);
			if ( (LA168_0==RULE_ID) ) {
				alt168=1;
			}
			else if ( (LA168_0==49) ) {
				alt168=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 168, 0, input);
				throw nvae;
			}

			switch (alt168) {
				case 1 :
					// InternalDsl.g:10310:3: this_JvmTypeReference_0= ruleJvmTypeReference
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
					// InternalDsl.g:10319:3: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
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
	// InternalDsl.g:10331:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] :iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
	public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmWildcardTypeReference =null;

		try {
			// InternalDsl.g:10331:65: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
			// InternalDsl.g:10332:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
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
	// InternalDsl.g:10338:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
	public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_constraints_2_0 =null;
		EObject lv_constraints_3_0 =null;
		EObject lv_constraints_4_0 =null;
		EObject lv_constraints_5_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10344:2: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
			// InternalDsl.g:10345:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
			{
			// InternalDsl.g:10345:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
			// InternalDsl.g:10346:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
			{
			// InternalDsl.g:10346:3: ()
			// InternalDsl.g:10347:4: 
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
			// InternalDsl.g:10357:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
			int alt171=3;
			int LA171_0 = input.LA(1);
			if ( (LA171_0==89) ) {
				alt171=1;
			}
			else if ( (LA171_0==102) ) {
				alt171=2;
			}
			switch (alt171) {
				case 1 :
					// InternalDsl.g:10358:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
					{
					// InternalDsl.g:10358:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
					// InternalDsl.g:10359:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
					{
					// InternalDsl.g:10359:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
					// InternalDsl.g:10360:6: (lv_constraints_2_0= ruleJvmUpperBound )
					{
					// InternalDsl.g:10360:6: (lv_constraints_2_0= ruleJvmUpperBound )
					// InternalDsl.g:10361:7: lv_constraints_2_0= ruleJvmUpperBound
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

					// InternalDsl.g:10378:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
					loop169:
					while (true) {
						int alt169=2;
						int LA169_0 = input.LA(1);
						if ( (LA169_0==20) ) {
							alt169=1;
						}

						switch (alt169) {
						case 1 :
							// InternalDsl.g:10379:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
							{
							// InternalDsl.g:10379:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
							// InternalDsl.g:10380:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
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
							break loop169;
						}
					}

					}

					}
					break;
				case 2 :
					// InternalDsl.g:10399:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
					{
					// InternalDsl.g:10399:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
					// InternalDsl.g:10400:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
					{
					// InternalDsl.g:10400:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
					// InternalDsl.g:10401:6: (lv_constraints_4_0= ruleJvmLowerBound )
					{
					// InternalDsl.g:10401:6: (lv_constraints_4_0= ruleJvmLowerBound )
					// InternalDsl.g:10402:7: lv_constraints_4_0= ruleJvmLowerBound
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

					// InternalDsl.g:10419:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
					loop170:
					while (true) {
						int alt170=2;
						int LA170_0 = input.LA(1);
						if ( (LA170_0==20) ) {
							alt170=1;
						}

						switch (alt170) {
						case 1 :
							// InternalDsl.g:10420:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
							{
							// InternalDsl.g:10420:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
							// InternalDsl.g:10421:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
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
							break loop170;
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
	// InternalDsl.g:10444:1: entryRuleJvmUpperBound returns [EObject current=null] :iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
	public final EObject entryRuleJvmUpperBound() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmUpperBound =null;

		try {
			// InternalDsl.g:10444:54: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
			// InternalDsl.g:10445:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
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
	// InternalDsl.g:10451:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmUpperBound() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10457:2: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalDsl.g:10458:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalDsl.g:10458:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalDsl.g:10459:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,89,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
					}
			// InternalDsl.g:10463:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalDsl.g:10464:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:10464:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalDsl.g:10465:5: lv_typeReference_1_0= ruleJvmTypeReference
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
	// InternalDsl.g:10486:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] :iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
	public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmUpperBoundAnded =null;

		try {
			// InternalDsl.g:10486:59: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
			// InternalDsl.g:10487:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
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
	// InternalDsl.g:10493:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10499:2: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalDsl.g:10500:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalDsl.g:10500:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalDsl.g:10501:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
					}
			// InternalDsl.g:10505:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalDsl.g:10506:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:10506:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalDsl.g:10507:5: lv_typeReference_1_0= ruleJvmTypeReference
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
	// InternalDsl.g:10528:1: entryRuleJvmLowerBound returns [EObject current=null] :iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
	public final EObject entryRuleJvmLowerBound() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmLowerBound =null;

		try {
			// InternalDsl.g:10528:54: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
			// InternalDsl.g:10529:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
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
	// InternalDsl.g:10535:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmLowerBound() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10541:2: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalDsl.g:10542:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalDsl.g:10542:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalDsl.g:10543:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,102,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
					}
			// InternalDsl.g:10547:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalDsl.g:10548:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:10548:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalDsl.g:10549:5: lv_typeReference_1_0= ruleJvmTypeReference
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
	// InternalDsl.g:10570:1: entryRuleJvmLowerBoundAnded returns [EObject current=null] :iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF ;
	public final EObject entryRuleJvmLowerBoundAnded() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmLowerBoundAnded =null;

		try {
			// InternalDsl.g:10570:59: (iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF )
			// InternalDsl.g:10571:2: iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF
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
	// InternalDsl.g:10577:1: ruleJvmLowerBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmLowerBoundAnded() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10583:2: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalDsl.g:10584:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalDsl.g:10584:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalDsl.g:10585:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0());
					}
			// InternalDsl.g:10589:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalDsl.g:10590:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalDsl.g:10590:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalDsl.g:10591:5: lv_typeReference_1_0= ruleJvmTypeReference
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
	// InternalDsl.g:10612:1: entryRuleQualifiedNameWithWildcard returns [String current=null] :iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
	public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard =null;

		try {
			// InternalDsl.g:10612:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
			// InternalDsl.g:10613:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
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
	// InternalDsl.g:10619:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) ;
	public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_QualifiedName_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10625:2: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) )
			// InternalDsl.g:10626:2: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
			{
			// InternalDsl.g:10626:2: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
			// InternalDsl.g:10627:3: this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*'
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
	// InternalDsl.g:10651:1: entryRuleValidID returns [String current=null] :iv_ruleValidID= ruleValidID EOF ;
	public final String entryRuleValidID() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleValidID =null;

		try {
			// InternalDsl.g:10651:47: (iv_ruleValidID= ruleValidID EOF )
			// InternalDsl.g:10652:2: iv_ruleValidID= ruleValidID EOF
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
	// InternalDsl.g:10658:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
	public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_ID_0=null;


			enterRule();

		try {
			// InternalDsl.g:10664:2: (this_ID_0= RULE_ID )
			// InternalDsl.g:10665:2: this_ID_0= RULE_ID
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
	// InternalDsl.g:10675:1: entryRuleQualifiedNameInStaticImport returns [String current=null] :iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF ;
	public final String entryRuleQualifiedNameInStaticImport() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedNameInStaticImport =null;

		try {
			// InternalDsl.g:10675:67: (iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF )
			// InternalDsl.g:10676:2: iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF
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
	// InternalDsl.g:10682:1: ruleQualifiedNameInStaticImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '.' )+ ;
	public final AntlrDatatypeRuleToken ruleQualifiedNameInStaticImport() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;


			enterRule();

		try {
			// InternalDsl.g:10688:2: ( (this_ValidID_0= ruleValidID kw= '.' )+ )
			// InternalDsl.g:10689:2: (this_ValidID_0= ruleValidID kw= '.' )+
			{
			// InternalDsl.g:10689:2: (this_ValidID_0= ruleValidID kw= '.' )+
			int cnt172=0;
			loop172:
			while (true) {
				int alt172=2;
				int LA172_0 = input.LA(1);
				if ( (LA172_0==RULE_ID) ) {
					int LA172_2 = input.LA(2);
					if ( (LA172_2==36) ) {
						alt172=1;
					}

				}

				switch (alt172) {
				case 1 :
					// InternalDsl.g:10690:3: this_ValidID_0= ruleValidID kw= '.'
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
					if ( cnt172 >= 1 ) break loop172;
					if (state.backtracking>0) {state.failed=true; return current;}
					EarlyExitException eee = new EarlyExitException(172, input);
					throw eee;
				}
				cnt172++;
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
		// InternalDsl.g:3142:4: ( ruleXBlockExpression )
		// InternalDsl.g:3142:5: ruleXBlockExpression
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
		// InternalDsl.g:3295:4: ( ';' )
		// InternalDsl.g:3295:5: ';'
		{
		match(input,41,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred4_InternalDsl

	// $ANTLR start synpred5_InternalDsl
	public final void synpred5_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:3329:4: ( ( () ruleArrayBrackets ) )
		// InternalDsl.g:3329:5: ( () ruleArrayBrackets )
		{
		// InternalDsl.g:3329:5: ( () ruleArrayBrackets )
		// InternalDsl.g:3330:5: () ruleArrayBrackets
		{
		// InternalDsl.g:3330:5: ()
		// InternalDsl.g:3331:5: 
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
		// InternalDsl.g:3491:4: ( ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' ) )
		// InternalDsl.g:3491:5: ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' )
		{
		// InternalDsl.g:3491:5: ( () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':' )
		// InternalDsl.g:3492:5: () 'for' '(' ( ( ruleFullJvmFormalParameter ) ) ':'
		{
		// InternalDsl.g:3492:5: ()
		// InternalDsl.g:3493:5: 
		{
		}

		match(input,94,FOLLOW_6); if (state.failed) return;
		match(input,22,FOLLOW_87); if (state.failed) return;
		// InternalDsl.g:3496:5: ( ( ruleFullJvmFormalParameter ) )
		// InternalDsl.g:3497:6: ( ruleFullJvmFormalParameter )
		{
		// InternalDsl.g:3497:6: ( ruleFullJvmFormalParameter )
		// InternalDsl.g:3498:7: ruleFullJvmFormalParameter
		{
		pushFollow(FOLLOW_34);
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
		// InternalDsl.g:3533:4: ( ( () 'try' ( ( '(' ) ) ) )
		// InternalDsl.g:3533:5: ( () 'try' ( ( '(' ) ) )
		{
		// InternalDsl.g:3533:5: ( () 'try' ( ( '(' ) ) )
		// InternalDsl.g:3534:5: () 'try' ( ( '(' ) )
		{
		// InternalDsl.g:3534:5: ()
		// InternalDsl.g:3535:5: 
		{
		}

		match(input,107,FOLLOW_6); if (state.failed) return;
		// InternalDsl.g:3537:5: ( ( '(' ) )
		// InternalDsl.g:3538:6: ( '(' )
		{
		// InternalDsl.g:3538:6: ( '(' )
		// InternalDsl.g:3539:7: '('
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
		// InternalDsl.g:3564:4: ( ( () 'synchronized' '(' ) )
		// InternalDsl.g:3564:5: ( () 'synchronized' '(' )
		{
		// InternalDsl.g:3564:5: ( () 'synchronized' '(' )
		// InternalDsl.g:3565:5: () 'synchronized' '('
		{
		// InternalDsl.g:3565:5: ()
		// InternalDsl.g:3566:5: 
		{
		}

		match(input,104,FOLLOW_6); if (state.failed) return;
		match(input,22,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred8_InternalDsl

	// $ANTLR start synpred9_InternalDsl
	public final void synpred9_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:3701:4: ( ';' )
		// InternalDsl.g:3701:5: ';'
		{
		match(input,41,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred9_InternalDsl

	// $ANTLR start synpred11_InternalDsl
	public final void synpred11_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:3983:5: ( ',' )
		// InternalDsl.g:3983:6: ','
		{
		match(input,31,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred11_InternalDsl

	// $ANTLR start synpred12_InternalDsl
	public final void synpred12_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4100:5: ( ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign ) )
		// InternalDsl.g:4100:6: ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign )
		{
		// InternalDsl.g:4100:6: ( () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign )
		// InternalDsl.g:4101:6: () ( ( ruleFeatureCallID ) ) '[' ( ( ruleXExpression ) ) ']' ( '[' ( ( ruleXExpression ) ) ']' )* ruleOpSingleAssign
		{
		// InternalDsl.g:4101:6: ()
		// InternalDsl.g:4102:6: 
		{
		}

		// InternalDsl.g:4103:6: ( ( ruleFeatureCallID ) )
		// InternalDsl.g:4104:7: ( ruleFeatureCallID )
		{
		// InternalDsl.g:4104:7: ( ruleFeatureCallID )
		// InternalDsl.g:4105:8: ruleFeatureCallID
		{
		pushFollow(FOLLOW_44);
		ruleFeatureCallID();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,77,FOLLOW_66); if (state.failed) return;
		// InternalDsl.g:4109:6: ( ( ruleXExpression ) )
		// InternalDsl.g:4110:7: ( ruleXExpression )
		{
		// InternalDsl.g:4110:7: ( ruleXExpression )
		// InternalDsl.g:4111:8: ruleXExpression
		{
		pushFollow(FOLLOW_15);
		ruleXExpression();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,78,FOLLOW_13); if (state.failed) return;
		// InternalDsl.g:4115:6: ( '[' ( ( ruleXExpression ) ) ']' )*
		loop174:
		while (true) {
			int alt174=2;
			int LA174_0 = input.LA(1);
			if ( (LA174_0==77) ) {
				alt174=1;
			}

			switch (alt174) {
			case 1 :
				// InternalDsl.g:4116:7: '[' ( ( ruleXExpression ) ) ']'
				{
				match(input,77,FOLLOW_66); if (state.failed) return;
				// InternalDsl.g:4117:7: ( ( ruleXExpression ) )
				// InternalDsl.g:4118:8: ( ruleXExpression )
				{
				// InternalDsl.g:4118:8: ( ruleXExpression )
				// InternalDsl.g:4119:9: ruleXExpression
				{
				pushFollow(FOLLOW_15);
				ruleXExpression();
				state._fsp--;
				if (state.failed) return;
				}

				}

				match(input,78,FOLLOW_13); if (state.failed) return;
				}
				break;

			default :
				break loop174;
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
		// InternalDsl.g:4239:5: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
		// InternalDsl.g:4239:6: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		{
		// InternalDsl.g:4239:6: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		// InternalDsl.g:4240:6: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
		{
		// InternalDsl.g:4240:6: ()
		// InternalDsl.g:4241:6: 
		{
		}

		// InternalDsl.g:4242:6: ( ( ruleFeatureCallID ) )
		// InternalDsl.g:4243:7: ( ruleFeatureCallID )
		{
		// InternalDsl.g:4243:7: ( ruleFeatureCallID )
		// InternalDsl.g:4244:8: ruleFeatureCallID
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
		// InternalDsl.g:4316:7: ( ( () '?' ) )
		// InternalDsl.g:4316:8: ( () '?' )
		{
		// InternalDsl.g:4316:8: ( () '?' )
		// InternalDsl.g:4317:8: () '?'
		{
		// InternalDsl.g:4317:8: ()
		// InternalDsl.g:4318:8: 
		{
		}

		match(input,49,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred14_InternalDsl

	// $ANTLR start synpred15_InternalDsl
	public final void synpred15_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4382:7: ( ( () ( ( ruleOpMultiAssign ) ) ) )
		// InternalDsl.g:4382:8: ( () ( ( ruleOpMultiAssign ) ) )
		{
		// InternalDsl.g:4382:8: ( () ( ( ruleOpMultiAssign ) ) )
		// InternalDsl.g:4383:8: () ( ( ruleOpMultiAssign ) )
		{
		// InternalDsl.g:4383:8: ()
		// InternalDsl.g:4384:8: 
		{
		}

		// InternalDsl.g:4385:8: ( ( ruleOpMultiAssign ) )
		// InternalDsl.g:4386:9: ( ruleOpMultiAssign )
		{
		// InternalDsl.g:4386:9: ( ruleOpMultiAssign )
		// InternalDsl.g:4387:10: ruleOpMultiAssign
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
		// InternalDsl.g:4584:7: ( '[' )
		// InternalDsl.g:4584:8: '['
		{
		match(input,77,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred16_InternalDsl

	// $ANTLR start synpred17_InternalDsl
	public final void synpred17_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4572:4: ( ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* ) )
		// InternalDsl.g:4572:5: ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* )
		{
		// InternalDsl.g:4572:5: ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* )
		// InternalDsl.g:4573:5: () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )*
		{
		// InternalDsl.g:4573:5: ()
		// InternalDsl.g:4574:5: 
		{
		}

		match(input,77,FOLLOW_66); if (state.failed) return;
		// InternalDsl.g:4576:5: ( ( ruleXExpression ) )
		// InternalDsl.g:4577:6: ( ruleXExpression )
		{
		// InternalDsl.g:4577:6: ( ruleXExpression )
		// InternalDsl.g:4578:7: ruleXExpression
		{
		pushFollow(FOLLOW_15);
		ruleXExpression();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,78,FOLLOW_62); if (state.failed) return;
		// InternalDsl.g:4582:5: ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )*
		loop175:
		while (true) {
			int alt175=2;
			int LA175_0 = input.LA(1);
			if ( (LA175_0==77) && (synpred16_InternalDsl())) {
				alt175=1;
			}

			switch (alt175) {
			case 1 :
				// InternalDsl.g:4583:6: ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']'
				{
				// InternalDsl.g:4583:6: ( ( '[' )=> '[' )
				// InternalDsl.g:4584:7: ( '[' )=> '['
				{
				match(input,77,FOLLOW_66); if (state.failed) return;
				}

				// InternalDsl.g:4587:6: ( ( ruleXExpression ) )
				// InternalDsl.g:4588:7: ( ruleXExpression )
				{
				// InternalDsl.g:4588:7: ( ruleXExpression )
				// InternalDsl.g:4589:8: ruleXExpression
				{
				pushFollow(FOLLOW_15);
				ruleXExpression();
				state._fsp--;
				if (state.failed) return;
				}

				}

				match(input,78,FOLLOW_62); if (state.failed) return;
				}
				break;

			default :
				break loop175;
			}
		}

		}

		}

	}
	// $ANTLR end synpred17_InternalDsl

	// $ANTLR start synpred18_InternalDsl
	public final void synpred18_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4633:7: ( '[' )
		// InternalDsl.g:4633:8: '['
		{
		match(input,77,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred18_InternalDsl

	// $ANTLR start synpred19_InternalDsl
	public final void synpred19_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4709:5: ( ( '(' ) )
		// InternalDsl.g:4709:6: ( '(' )
		{
		// InternalDsl.g:4709:6: ( '(' )
		// InternalDsl.g:4710:6: '('
		{
		match(input,22,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred19_InternalDsl

	// $ANTLR start synpred20_InternalDsl
	public final void synpred20_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4825:5: ( ( '<' ) )
		// InternalDsl.g:4825:6: ( '<' )
		{
		// InternalDsl.g:4825:6: ( '<' )
		// InternalDsl.g:4826:6: '<'
		{
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred20_InternalDsl

	// $ANTLR start synpred21_InternalDsl
	public final void synpred21_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:4895:5: ( ( '(' ) )
		// InternalDsl.g:4895:6: ( '(' )
		{
		// InternalDsl.g:4895:6: ( '(' )
		// InternalDsl.g:4896:6: '('
		{
		match(input,22,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred21_InternalDsl

	// $ANTLR start synpred23_InternalDsl
	public final void synpred23_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5073:5: ( ( ruleXJArrayDimension ) )
		// InternalDsl.g:5073:6: ( ruleXJArrayDimension )
		{
		// InternalDsl.g:5073:6: ( ruleXJArrayDimension )
		// InternalDsl.g:5074:6: ruleXJArrayDimension
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
		// InternalDsl.g:5120:4: ( ( ruleXJArrayLiteral ) )
		// InternalDsl.g:5120:5: ( ruleXJArrayLiteral )
		{
		// InternalDsl.g:5120:5: ( ruleXJArrayLiteral )
		// InternalDsl.g:5121:5: ruleXJArrayLiteral
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
		// InternalDsl.g:5192:4: ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )
		// InternalDsl.g:5192:5: ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) )
		{
		// InternalDsl.g:5192:5: ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) )
		// InternalDsl.g:5193:5: () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) )
		{
		// InternalDsl.g:5193:5: ()
		// InternalDsl.g:5194:5: 
		{
		}

		match(input,22,FOLLOW_23); if (state.failed) return;
		// InternalDsl.g:5196:5: ( ( ruleJvmTypeReference ) )
		// InternalDsl.g:5197:6: ( ruleJvmTypeReference )
		{
		// InternalDsl.g:5197:6: ( ruleJvmTypeReference )
		// InternalDsl.g:5198:7: ruleJvmTypeReference
		{
		pushFollow(FOLLOW_8);
		ruleJvmTypeReference();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,25,FOLLOW_66); if (state.failed) return;
		// InternalDsl.g:5202:5: ( ( ruleXExpression ) )
		// InternalDsl.g:5203:6: ( ruleXExpression )
		{
		// InternalDsl.g:5203:6: ( ruleXExpression )
		// InternalDsl.g:5204:7: ruleXExpression
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
		// InternalDsl.g:5295:5: ( ( () ( ( ruleOpPostfix ) ) ) )
		// InternalDsl.g:5295:6: ( () ( ( ruleOpPostfix ) ) )
		{
		// InternalDsl.g:5295:6: ( () ( ( ruleOpPostfix ) ) )
		// InternalDsl.g:5296:6: () ( ( ruleOpPostfix ) )
		{
		// InternalDsl.g:5296:6: ()
		// InternalDsl.g:5297:6: 
		{
		}

		// InternalDsl.g:5298:6: ( ( ruleOpPostfix ) )
		// InternalDsl.g:5299:7: ( ruleOpPostfix )
		{
		// InternalDsl.g:5299:7: ( ruleOpPostfix )
		// InternalDsl.g:5300:8: ruleOpPostfix
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
		// InternalDsl.g:5363:6: ( ( () ( ( ruleOpPostfix ) ) ) )
		// InternalDsl.g:5363:7: ( () ( ( ruleOpPostfix ) ) )
		{
		// InternalDsl.g:5363:7: ( () ( ( ruleOpPostfix ) ) )
		// InternalDsl.g:5364:7: () ( ( ruleOpPostfix ) )
		{
		// InternalDsl.g:5364:7: ()
		// InternalDsl.g:5365:7: 
		{
		}

		// InternalDsl.g:5366:7: ( ( ruleOpPostfix ) )
		// InternalDsl.g:5367:8: ( ruleOpPostfix )
		{
		// InternalDsl.g:5367:8: ( ruleOpPostfix )
		// InternalDsl.g:5368:9: ruleOpPostfix
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
		// InternalDsl.g:5413:9: ( '[' )
		// InternalDsl.g:5413:10: '['
		{
		match(input,77,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred28_InternalDsl

	// $ANTLR start synpred29_InternalDsl
	public final void synpred29_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5401:6: ( ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* ) )
		// InternalDsl.g:5401:7: ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* )
		{
		// InternalDsl.g:5401:7: ( () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )* )
		// InternalDsl.g:5402:7: () '[' ( ( ruleXExpression ) ) ']' ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )*
		{
		// InternalDsl.g:5402:7: ()
		// InternalDsl.g:5403:7: 
		{
		}

		match(input,77,FOLLOW_66); if (state.failed) return;
		// InternalDsl.g:5405:7: ( ( ruleXExpression ) )
		// InternalDsl.g:5406:8: ( ruleXExpression )
		{
		// InternalDsl.g:5406:8: ( ruleXExpression )
		// InternalDsl.g:5407:9: ruleXExpression
		{
		pushFollow(FOLLOW_15);
		ruleXExpression();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,78,FOLLOW_62); if (state.failed) return;
		// InternalDsl.g:5411:7: ( ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']' )*
		loop176:
		while (true) {
			int alt176=2;
			int LA176_0 = input.LA(1);
			if ( (LA176_0==77) && (synpred28_InternalDsl())) {
				alt176=1;
			}

			switch (alt176) {
			case 1 :
				// InternalDsl.g:5412:8: ( ( '[' )=> '[' ) ( ( ruleXExpression ) ) ']'
				{
				// InternalDsl.g:5412:8: ( ( '[' )=> '[' )
				// InternalDsl.g:5413:9: ( '[' )=> '['
				{
				match(input,77,FOLLOW_66); if (state.failed) return;
				}

				// InternalDsl.g:5416:8: ( ( ruleXExpression ) )
				// InternalDsl.g:5417:9: ( ruleXExpression )
				{
				// InternalDsl.g:5417:9: ( ruleXExpression )
				// InternalDsl.g:5418:10: ruleXExpression
				{
				pushFollow(FOLLOW_15);
				ruleXExpression();
				state._fsp--;
				if (state.failed) return;
				}

				}

				match(input,78,FOLLOW_62); if (state.failed) return;
				}
				break;

			default :
				break loop176;
			}
		}

		}

		}

	}
	// $ANTLR end synpred29_InternalDsl

	// $ANTLR start synpred30_InternalDsl
	public final void synpred30_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5462:9: ( '[' )
		// InternalDsl.g:5462:10: '['
		{
		match(input,77,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred30_InternalDsl

	// $ANTLR start synpred31_InternalDsl
	public final void synpred31_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5525:5: ( ( () ( ( ruleArrayBrackets ) )* '.' 'class' ) )
		// InternalDsl.g:5525:6: ( () ( ( ruleArrayBrackets ) )* '.' 'class' )
		{
		// InternalDsl.g:5525:6: ( () ( ( ruleArrayBrackets ) )* '.' 'class' )
		// InternalDsl.g:5526:6: () ( ( ruleArrayBrackets ) )* '.' 'class'
		{
		// InternalDsl.g:5526:6: ()
		// InternalDsl.g:5527:6: 
		{
		}

		// InternalDsl.g:5528:6: ( ( ruleArrayBrackets ) )*
		loop177:
		while (true) {
			int alt177=2;
			int LA177_0 = input.LA(1);
			if ( (LA177_0==77) ) {
				alt177=1;
			}

			switch (alt177) {
			case 1 :
				// InternalDsl.g:5529:7: ( ruleArrayBrackets )
				{
				// InternalDsl.g:5529:7: ( ruleArrayBrackets )
				// InternalDsl.g:5530:8: ruleArrayBrackets
				{
				pushFollow(FOLLOW_83);
				ruleArrayBrackets();
				state._fsp--;
				if (state.failed) return;
				}

				}
				break;

			default :
				break loop177;
			}
		}

		match(input,36,FOLLOW_84); if (state.failed) return;
		match(input,84,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred31_InternalDsl

	// $ANTLR start synpred32_InternalDsl
	public final void synpred32_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5577:6: ( ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
		// InternalDsl.g:5577:7: ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		{
		// InternalDsl.g:5577:7: ( () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		// InternalDsl.g:5578:7: () '.' ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
		{
		// InternalDsl.g:5578:7: ()
		// InternalDsl.g:5579:7: 
		{
		}

		match(input,36,FOLLOW_85); if (state.failed) return;
		// InternalDsl.g:5581:7: ( ( ruleFeatureCallID ) )
		// InternalDsl.g:5582:8: ( ruleFeatureCallID )
		{
		// InternalDsl.g:5582:8: ( ruleFeatureCallID )
		// InternalDsl.g:5583:9: ruleFeatureCallID
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
		// InternalDsl.g:5649:6: ( ( () '.' ) )
		// InternalDsl.g:5649:7: ( () '.' )
		{
		// InternalDsl.g:5649:7: ( () '.' )
		// InternalDsl.g:5650:7: () '.'
		{
		// InternalDsl.g:5650:7: ()
		// InternalDsl.g:5651:7: 
		{
		}

		match(input,36,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred33_InternalDsl

	// $ANTLR start synpred34_InternalDsl
	public final void synpred34_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:5687:7: ( ( '(' ) )
		// InternalDsl.g:5687:8: ( '(' )
		{
		// InternalDsl.g:5687:8: ( '(' )
		// InternalDsl.g:5688:8: '('
		{
		match(input,22,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred34_InternalDsl

	// $ANTLR start synpred36_InternalDsl
	public final void synpred36_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:6127:5: ( 'else' )
		// InternalDsl.g:6127:6: 'else'
		{
		match(input,88,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred36_InternalDsl

	// $ANTLR start synpred38_InternalDsl
	public final void synpred38_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:6871:7: ( 'finally' )
		// InternalDsl.g:6871:8: 'finally'
		{
		match(input,93,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred38_InternalDsl

	// $ANTLR start synpred41_InternalDsl
	public final void synpred41_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:7111:4: ( ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) ) )
		// InternalDsl.g:7111:5: ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) )
		{
		// InternalDsl.g:7111:5: ( () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) ) )
		// InternalDsl.g:7112:5: () 'new' ( ( ruleQualifiedName ) ) ( ( ruleXJArrayDimension ) )
		{
		// InternalDsl.g:7112:5: ()
		// InternalDsl.g:7113:5: 
		{
		}

		match(input,98,FOLLOW_23); if (state.failed) return;
		// InternalDsl.g:7115:5: ( ( ruleQualifiedName ) )
		// InternalDsl.g:7116:6: ( ruleQualifiedName )
		{
		// InternalDsl.g:7116:6: ( ruleQualifiedName )
		// InternalDsl.g:7117:7: ruleQualifiedName
		{
		pushFollow(FOLLOW_44);
		ruleQualifiedName();
		state._fsp--;
		if (state.failed) return;
		}

		}

		// InternalDsl.g:7120:5: ( ( ruleXJArrayDimension ) )
		// InternalDsl.g:7121:6: ( ruleXJArrayDimension )
		{
		// InternalDsl.g:7121:6: ( ruleXJArrayDimension )
		// InternalDsl.g:7122:7: ruleXJArrayDimension
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
		// InternalDsl.g:7505:6: ( ( '>' '>' ) )
		// InternalDsl.g:7505:7: ( '>' '>' )
		{
		// InternalDsl.g:7505:7: ( '>' '>' )
		// InternalDsl.g:7506:7: '>' '>'
		{
		match(input,47,FOLLOW_100); if (state.failed) return;
		match(input,47,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred42_InternalDsl

	// $ANTLR start synpred43_InternalDsl
	public final void synpred43_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:7566:5: ( ( () ( ( ruleOpAnd ) ) ) )
		// InternalDsl.g:7566:6: ( () ( ( ruleOpAnd ) ) )
		{
		// InternalDsl.g:7566:6: ( () ( ( ruleOpAnd ) ) )
		// InternalDsl.g:7567:6: () ( ( ruleOpAnd ) )
		{
		// InternalDsl.g:7567:6: ()
		// InternalDsl.g:7568:6: 
		{
		}

		// InternalDsl.g:7569:6: ( ( ruleOpAnd ) )
		// InternalDsl.g:7570:7: ( ruleOpAnd )
		{
		// InternalDsl.g:7570:7: ( ruleOpAnd )
		// InternalDsl.g:7571:8: ruleOpAnd
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
		// InternalDsl.g:7651:5: ( ( () ( ( ruleOpInclusiveOr ) ) ) )
		// InternalDsl.g:7651:6: ( () ( ( ruleOpInclusiveOr ) ) )
		{
		// InternalDsl.g:7651:6: ( () ( ( ruleOpInclusiveOr ) ) )
		// InternalDsl.g:7652:6: () ( ( ruleOpInclusiveOr ) )
		{
		// InternalDsl.g:7652:6: ()
		// InternalDsl.g:7653:6: 
		{
		}

		// InternalDsl.g:7654:6: ( ( ruleOpInclusiveOr ) )
		// InternalDsl.g:7655:7: ( ruleOpInclusiveOr )
		{
		// InternalDsl.g:7655:7: ( ruleOpInclusiveOr )
		// InternalDsl.g:7656:8: ruleOpInclusiveOr
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
		// InternalDsl.g:7758:5: ( ( () ( ( ruleOpExclusiveOr ) ) ) )
		// InternalDsl.g:7758:6: ( () ( ( ruleOpExclusiveOr ) ) )
		{
		// InternalDsl.g:7758:6: ( () ( ( ruleOpExclusiveOr ) ) )
		// InternalDsl.g:7759:6: () ( ( ruleOpExclusiveOr ) )
		{
		// InternalDsl.g:7759:6: ()
		// InternalDsl.g:7760:6: 
		{
		}

		// InternalDsl.g:7761:6: ( ( ruleOpExclusiveOr ) )
		// InternalDsl.g:7762:7: ( ruleOpExclusiveOr )
		{
		// InternalDsl.g:7762:7: ( ruleOpExclusiveOr )
		// InternalDsl.g:7763:8: ruleOpExclusiveOr
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
		// InternalDsl.g:7865:5: ( ( () ( ( ruleOpBitwiseAnd ) ) ) )
		// InternalDsl.g:7865:6: ( () ( ( ruleOpBitwiseAnd ) ) )
		{
		// InternalDsl.g:7865:6: ( () ( ( ruleOpBitwiseAnd ) ) )
		// InternalDsl.g:7866:6: () ( ( ruleOpBitwiseAnd ) )
		{
		// InternalDsl.g:7866:6: ()
		// InternalDsl.g:7867:6: 
		{
		}

		// InternalDsl.g:7868:6: ( ( ruleOpBitwiseAnd ) )
		// InternalDsl.g:7869:7: ( ruleOpBitwiseAnd )
		{
		// InternalDsl.g:7869:7: ( ruleOpBitwiseAnd )
		// InternalDsl.g:7870:8: ruleOpBitwiseAnd
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
		// InternalDsl.g:8006:5: ( ( () '{' ) )
		// InternalDsl.g:8006:6: ( () '{' )
		{
		// InternalDsl.g:8006:6: ( () '{' )
		// InternalDsl.g:8007:6: () '{'
		{
		// InternalDsl.g:8007:6: ()
		// InternalDsl.g:8008:6: 
		{
		}

		match(input,109,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred47_InternalDsl

	// $ANTLR start synpred48_InternalDsl
	public final void synpred48_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8107:5: ( ( () '{' ) )
		// InternalDsl.g:8107:6: ( () '{' )
		{
		// InternalDsl.g:8107:6: ( () '{' )
		// InternalDsl.g:8108:6: () '{'
		{
		// InternalDsl.g:8108:6: ()
		// InternalDsl.g:8109:6: 
		{
		}

		match(input,109,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred48_InternalDsl

	// $ANTLR start synpred49_InternalDsl
	public final void synpred49_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8235:5: ( '(' )
		// InternalDsl.g:8235:6: '('
		{
		match(input,22,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred49_InternalDsl

	// $ANTLR start synpred50_InternalDsl
	public final void synpred50_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8244:7: ( ( ( ( ruleValidID ) ) '=' ) )
		// InternalDsl.g:8244:8: ( ( ( ruleValidID ) ) '=' )
		{
		// InternalDsl.g:8244:8: ( ( ( ruleValidID ) ) '=' )
		// InternalDsl.g:8245:8: ( ( ruleValidID ) ) '='
		{
		// InternalDsl.g:8245:8: ( ( ruleValidID ) )
		// InternalDsl.g:8246:9: ( ruleValidID )
		{
		// InternalDsl.g:8246:9: ( ruleValidID )
		// InternalDsl.g:8247:10: ruleValidID
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
		// InternalDsl.g:8515:5: ( ( () ( ( ruleOpOr ) ) ) )
		// InternalDsl.g:8515:6: ( () ( ( ruleOpOr ) ) )
		{
		// InternalDsl.g:8515:6: ( () ( ( ruleOpOr ) ) )
		// InternalDsl.g:8516:6: () ( ( ruleOpOr ) )
		{
		// InternalDsl.g:8516:6: ()
		// InternalDsl.g:8517:6: 
		{
		}

		// InternalDsl.g:8518:6: ( ( ruleOpOr ) )
		// InternalDsl.g:8519:7: ( ruleOpOr )
		{
		// InternalDsl.g:8519:7: ( ruleOpOr )
		// InternalDsl.g:8520:8: ruleOpOr
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
		// InternalDsl.g:8644:5: ( ( () ( ( ruleOpEquality ) ) ) )
		// InternalDsl.g:8644:6: ( () ( ( ruleOpEquality ) ) )
		{
		// InternalDsl.g:8644:6: ( () ( ( ruleOpEquality ) ) )
		// InternalDsl.g:8645:6: () ( ( ruleOpEquality ) )
		{
		// InternalDsl.g:8645:6: ()
		// InternalDsl.g:8646:6: 
		{
		}

		// InternalDsl.g:8647:6: ( ( ruleOpEquality ) )
		// InternalDsl.g:8648:7: ( ruleOpEquality )
		{
		// InternalDsl.g:8648:7: ( ruleOpEquality )
		// InternalDsl.g:8649:8: ruleOpEquality
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
		// InternalDsl.g:8730:6: ( ( () 'instanceof' ) )
		// InternalDsl.g:8730:7: ( () 'instanceof' )
		{
		// InternalDsl.g:8730:7: ( () 'instanceof' )
		// InternalDsl.g:8731:7: () 'instanceof'
		{
		// InternalDsl.g:8731:7: ()
		// InternalDsl.g:8732:7: 
		{
		}

		match(input,97,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred55_InternalDsl

	// $ANTLR start synpred56_InternalDsl
	public final void synpred56_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:8773:6: ( ( () ( ( ruleOpCompare ) ) ) )
		// InternalDsl.g:8773:7: ( () ( ( ruleOpCompare ) ) )
		{
		// InternalDsl.g:8773:7: ( () ( ( ruleOpCompare ) ) )
		// InternalDsl.g:8774:7: () ( ( ruleOpCompare ) )
		{
		// InternalDsl.g:8774:7: ()
		// InternalDsl.g:8775:7: 
		{
		}

		// InternalDsl.g:8776:7: ( ( ruleOpCompare ) )
		// InternalDsl.g:8777:8: ( ruleOpCompare )
		{
		// InternalDsl.g:8777:8: ( ruleOpCompare )
		// InternalDsl.g:8778:9: ruleOpCompare
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
		// InternalDsl.g:8908:5: ( ( () ( ( ruleOpOther ) ) ) )
		// InternalDsl.g:8908:6: ( () ( ( ruleOpOther ) ) )
		{
		// InternalDsl.g:8908:6: ( () ( ( ruleOpOther ) ) )
		// InternalDsl.g:8909:6: () ( ( ruleOpOther ) )
		{
		// InternalDsl.g:8909:6: ()
		// InternalDsl.g:8910:6: 
		{
		}

		// InternalDsl.g:8911:6: ( ( ruleOpOther ) )
		// InternalDsl.g:8912:7: ( ruleOpOther )
		{
		// InternalDsl.g:8912:7: ( ruleOpOther )
		// InternalDsl.g:8913:8: ruleOpOther
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
		// InternalDsl.g:8993:5: ( ( () ( ( ruleOpAdd ) ) ) )
		// InternalDsl.g:8993:6: ( () ( ( ruleOpAdd ) ) )
		{
		// InternalDsl.g:8993:6: ( () ( ( ruleOpAdd ) ) )
		// InternalDsl.g:8994:6: () ( ( ruleOpAdd ) )
		{
		// InternalDsl.g:8994:6: ()
		// InternalDsl.g:8995:6: 
		{
		}

		// InternalDsl.g:8996:6: ( ( ruleOpAdd ) )
		// InternalDsl.g:8997:7: ( ruleOpAdd )
		{
		// InternalDsl.g:8997:7: ( ruleOpAdd )
		// InternalDsl.g:8998:8: ruleOpAdd
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
		// InternalDsl.g:9108:5: ( ( () ( ( ruleOpMulti ) ) ) )
		// InternalDsl.g:9108:6: ( () ( ( ruleOpMulti ) ) )
		{
		// InternalDsl.g:9108:6: ( () ( ( ruleOpMulti ) ) )
		// InternalDsl.g:9109:6: () ( ( ruleOpMulti ) )
		{
		// InternalDsl.g:9109:6: ()
		// InternalDsl.g:9110:6: 
		{
		}

		// InternalDsl.g:9111:6: ( ( ruleOpMulti ) )
		// InternalDsl.g:9112:7: ( ruleOpMulti )
		{
		// InternalDsl.g:9112:7: ( ruleOpMulti )
		// InternalDsl.g:9113:8: ruleOpMulti
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
		// InternalDsl.g:9542:4: ( ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
		// InternalDsl.g:9542:5: ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
		{
		// InternalDsl.g:9542:5: ( () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
		// InternalDsl.g:9543:5: () ( ( 'final' ) )? ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
		{
		// InternalDsl.g:9543:5: ()
		// InternalDsl.g:9544:5: 
		{
		}

		// InternalDsl.g:9545:5: ( ( 'final' ) )?
		int alt178=2;
		int LA178_0 = input.LA(1);
		if ( (LA178_0==92) ) {
			alt178=1;
		}
		switch (alt178) {
			case 1 :
				// InternalDsl.g:9546:6: ( 'final' )
				{
				// InternalDsl.g:9546:6: ( 'final' )
				// InternalDsl.g:9547:7: 'final'
				{
				match(input,92,FOLLOW_23); if (state.failed) return;
				}

				}
				break;

		}

		// InternalDsl.g:9550:5: ( ( ruleJvmTypeReference ) )
		// InternalDsl.g:9551:6: ( ruleJvmTypeReference )
		{
		// InternalDsl.g:9551:6: ( ruleJvmTypeReference )
		// InternalDsl.g:9552:7: ruleJvmTypeReference
		{
		pushFollow(FOLLOW_23);
		ruleJvmTypeReference();
		state._fsp--;
		if (state.failed) return;
		}

		}

		// InternalDsl.g:9555:5: ( ( ruleValidID ) )
		// InternalDsl.g:9556:6: ( ruleValidID )
		{
		// InternalDsl.g:9556:6: ( ruleValidID )
		// InternalDsl.g:9557:7: ruleValidID
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
		// InternalDsl.g:9927:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | '~' | '(' | '++' | '--' | 'new' | 'super' | 'false' | 'true' | 'null' | '{' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_CHARACTER | RULE_STRING )
		// InternalDsl.g:
		{
		if ( (input.LA(1) >= RULE_CHARACTER && input.LA(1) <= RULE_INT)||input.LA(1)==RULE_STRING||input.LA(1)==14||input.LA(1)==22||(input.LA(1) >= 28 && input.LA(1) <= 29)||(input.LA(1) >= 32 && input.LA(1) <= 33)||(input.LA(1) >= 89 && input.LA(1) <= 91)||input.LA(1)==96||(input.LA(1) >= 98 && input.LA(1) <= 99)||(input.LA(1) >= 101 && input.LA(1) <= 102)||input.LA(1)==106||input.LA(1)==109||input.LA(1)==114 ) {
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
		// InternalDsl.g:9977:5: ( '.' )
		// InternalDsl.g:9977:6: '.'
		{
		match(input,36,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred62_InternalDsl

	// $ANTLR start synpred63_InternalDsl
	public final void synpred63_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:10140:5: ( '<' )
		// InternalDsl.g:10140:6: '<'
		{
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred63_InternalDsl

	// $ANTLR start synpred64_InternalDsl
	public final void synpred64_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:10196:6: ( ( () '.' ) )
		// InternalDsl.g:10196:7: ( () '.' )
		{
		// InternalDsl.g:10196:7: ( () '.' )
		// InternalDsl.g:10197:7: () '.'
		{
		// InternalDsl.g:10197:7: ()
		// InternalDsl.g:10198:7: 
		{
		}

		match(input,36,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred64_InternalDsl

	// $ANTLR start synpred65_InternalDsl
	public final void synpred65_InternalDsl_fragment() throws RecognitionException {
		// InternalDsl.g:10234:7: ( '<' )
		// InternalDsl.g:10234:8: '<'
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


	protected DFA53 dfa53 = new DFA53(this);
	protected DFA73 dfa73 = new DFA73(this);
	protected DFA72 dfa72 = new DFA72(this);
	protected DFA76 dfa76 = new DFA76(this);
	protected DFA79 dfa79 = new DFA79(this);
	protected DFA82 dfa82 = new DFA82(this);
	protected DFA85 dfa85 = new DFA85(this);
	protected DFA86 dfa86 = new DFA86(this);
	protected DFA88 dfa88 = new DFA88(this);
	protected DFA94 dfa94 = new DFA94(this);
	protected DFA167 dfa167 = new DFA167(this);
	protected DFA165 dfa165 = new DFA165(this);
	static final String dfa_1s = "\7\uffff";
	static final String dfa_2s = "\2\uffff\1\4\2\uffff\1\4\1\uffff";
	static final String dfa_3s = "\1\10\1\uffff\1\44\1\10\1\uffff\1\44\1\uffff";
	static final String dfa_4s = "\1\145\1\uffff\1\51\1\32\1\uffff\1\51\1\uffff";
	static final String dfa_5s = "\1\uffff\1\1\2\uffff\1\2\1\uffff\1\3";
	static final String dfa_6s = "\7\uffff}>";
	static final String[] dfa_7s = {
			"\1\2\134\uffff\1\1",
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

	protected class DFA53 extends DFA {

		public DFA53(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 53;
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
			return "3187:3: ( ( ( (lv_static_1_0= 'static' ) ) ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_3_0= '*' ) ) | ( (lv_memberName_4_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildcard ) ) )";
		}
	}

	static final String dfa_8s = "\111\uffff";
	static final String dfa_9s = "\1\2\110\uffff";
	static final String dfa_10s = "\1\5\1\0\107\uffff";
	static final String dfa_11s = "\1\162\1\0\107\uffff";
	static final String dfa_12s = "\2\uffff\1\2\105\uffff\1\1";
	static final String dfa_13s = "\1\uffff\1\0\107\uffff}>";
	static final String[] dfa_14s = {
			"\5\2\2\uffff\1\2\1\uffff\2\2\1\uffff\6\2\2\uffff\12\2\1\uffff\1\2\1\uffff\6\2\2\uffff\4\2\33\uffff\1\1\5\2\2\uffff\10\2\1\uffff\25\2",
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

	protected class DFA73 extends DFA {

		public DFA73(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 73;
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
						int LA73_1 = input.LA(1);
						 
						int index73_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred17_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index73_1);
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
	static final String dfa_15s = "\1\1\110\uffff";
	static final String dfa_16s = "\1\5\1\uffff\1\0\106\uffff";
	static final String dfa_17s = "\1\162\1\uffff\1\0\106\uffff";
	static final String dfa_18s = "\1\uffff\1\2\106\uffff\1\1";
	static final String dfa_19s = "\2\uffff\1\0\106\uffff}>";
	static final String[] dfa_20s = {
			"\5\1\2\uffff\1\1\1\uffff\2\1\1\uffff\6\1\2\uffff\12\1\1\uffff\1\1\1\uffff\6\1\2\uffff\4\1\33\uffff\1\2\5\1\2\uffff\10\1\1\uffff\25\1",
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

	protected class DFA72 extends DFA {

		public DFA72(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 72;
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
			return "()* loopback of 4631:5: ( ( ( '[' )=>otherlv_5= '[' ) ( (lv_indexes_6_0= ruleXExpression ) ) otherlv_7= ']' )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA72_2 = input.LA(1);
						 
						int index72_2 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred18_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index72_2);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 72, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String[] dfa_21s = {
			"\5\2\2\uffff\1\2\1\uffff\2\2\1\uffff\5\2\1\1\2\uffff\12\2\1\uffff\1\2\1\uffff\6\2\2\uffff\4\2\33\uffff\6\2\2\uffff\10\2\1\uffff\25\2",
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

	protected class DFA76 extends DFA {

		public DFA76(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 76;
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
			return "4707:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_2_0= '(' ) ) ( ( (lv_featureCallArguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_featureCallArguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA76_1 = input.LA(1);
						 
						int index76_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred19_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index76_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 76, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String[] dfa_22s = {
			"\5\2\2\uffff\1\2\1\uffff\2\2\1\uffff\6\2\2\uffff\12\2\1\uffff\1\2\1\uffff\4\2\1\1\1\2\2\uffff\4\2\33\uffff\6\2\2\uffff\10\2\1\uffff\25\2",
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

	protected class DFA79 extends DFA {

		public DFA79(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 79;
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
			return "4823:3: ( ( ( ( '<' ) )=> (lv_explicitTypeArguments_3_0= '<' ) ) ( ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* )? otherlv_7= '>' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA79_1 = input.LA(1);
						 
						int index79_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred20_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index79_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 79, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA82 extends DFA {

		public DFA82(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 82;
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
			return "4893:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( (lv_arguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_arguments_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA82_1 = input.LA(1);
						 
						int index82_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred21_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index82_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 82, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String dfa_23s = "\1\5\2\uffff\1\0\105\uffff";
	static final String dfa_24s = "\1\162\2\uffff\1\0\105\uffff";
	static final String dfa_25s = "\3\uffff\1\0\105\uffff}>";
	static final String[] dfa_26s = {
			"\5\1\2\uffff\1\1\1\uffff\2\1\1\uffff\6\1\2\uffff\12\1\1\uffff\1\1\1\uffff\6\1\2\uffff\4\1\33\uffff\1\3\5\1\2\uffff\10\1\1\uffff\25\1",
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

	protected class DFA85 extends DFA {

		public DFA85(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 85;
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
			return "()* loopback of 5071:3: ( ( ( ( ruleXJArrayDimension ) )=> (lv_dimensions_6_0= ruleXJArrayDimension ) ) ( (lv_indexes_7_0= ruleXExpression ) )? otherlv_8= ']' )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA85_3 = input.LA(1);
						 
						int index85_3 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred23_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index85_3);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 85, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String[] dfa_27s = {
			"\5\2\2\uffff\1\2\1\uffff\2\2\1\uffff\6\2\2\uffff\12\2\1\uffff\1\2\1\uffff\6\2\2\uffff\4\2\33\uffff\6\2\2\uffff\10\2\1\uffff\17\2\1\1\5\2",
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

	protected class DFA86 extends DFA {

		public DFA86(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 86;
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
			return "5119:3: ( ( ( ruleXJArrayLiteral ) )=> (lv_arrayLiteral_9_0= ruleXJArrayLiteral ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA86_1 = input.LA(1);
						 
						int index86_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred24_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index86_1);
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
	static final String dfa_28s = "\1\5\35\uffff\1\0\52\uffff";
	static final String dfa_29s = "\1\162\35\uffff\1\0\52\uffff";
	static final String dfa_30s = "\36\uffff\1\0\52\uffff}>";
	static final String[] dfa_31s = {
			"\5\1\2\uffff\1\1\1\uffff\2\1\1\uffff\6\1\2\uffff\12\1\1\uffff\1\1\1\uffff\6\1\2\uffff\4\1\33\uffff\1\36\5\1\2\uffff\10\1\1\uffff\25\1",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
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

	protected class DFA88 extends DFA {

		public DFA88(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 88;
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
			return "()* loopback of 5460:7: ( ( ( '[' )=>otherlv_10= '[' ) ( (lv_indexes_11_0= ruleXExpression ) ) otherlv_12= ']' )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA88_30 = input.LA(1);
						 
						int index88_30 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred30_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index88_30);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 88, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA94 extends DFA {

		public DFA94(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 94;
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
			return "5685:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_13_0= '(' ) ) ( ( (lv_memberCallArguments_14_0= ruleXExpression ) ) (otherlv_15= ',' ( (lv_memberCallArguments_16_0= ruleXExpression ) ) )* )? otherlv_17= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA94_1 = input.LA(1);
						 
						int index94_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred34_InternalDsl()) ) {s = 72;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index94_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 94, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String dfa_32s = "\112\uffff";
	static final String dfa_33s = "\1\2\111\uffff";
	static final String dfa_34s = "\1\5\1\0\110\uffff";
	static final String dfa_35s = "\1\162\1\0\110\uffff";
	static final String dfa_36s = "\2\uffff\1\2\106\uffff\1\1";
	static final String dfa_37s = "\1\uffff\1\0\110\uffff}>";
	static final String[] dfa_38s = {
			"\5\2\2\uffff\1\2\1\uffff\2\2\1\uffff\6\2\2\uffff\12\2\1\uffff\6\2\1\1\1\2\2\uffff\4\2\33\uffff\6\2\2\uffff\10\2\1\uffff\25\2",
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

	protected class DFA167 extends DFA {

		public DFA167(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 167;
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
			return "10138:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA167_1 = input.LA(1);
						 
						int index167_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred63_InternalDsl()) ) {s = 73;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index167_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 167, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA165 extends DFA {

		public DFA165(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 165;
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
			return "10232:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA165_1 = input.LA(1);
						 
						int index165_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred65_InternalDsl()) ) {s = 73;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index165_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 165, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x1400000000000002L,0x0000000000000041L});
	public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001100L});
	public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000001C003C0L,0x0000040008000000L});
	public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x2020020000001100L,0x0000200000001090L});
	public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000200000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000300L});
	public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000100400300L});
	public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000100000300L});
	public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000024114020000L});
	public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000024116020000L});
	public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001000400002L,0x0000000000002000L});
	public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000102000300L});
	public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000082000000L});
	public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000100L});
	public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000100000300L,0x0000000000004000L});
	public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00000203304053E2L,0x00043FFDDEA20000L});
	public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0018000000000002L});
	public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0018000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00000203304053E0L,0x00043FFDDEA20000L});
	public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
	public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000080000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0040000000000002L});
	public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
	public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000200000004000L});
	public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000C003C0L,0x0000040008000000L});
	public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x00000000004003C0L,0x0000040008000000L});
	public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0001B40000000002L});
	public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000100002L,0x0000400000000000L});
	public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000003C003C0L,0x0000040008000000L});
	public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000100L,0x0000002000000000L});
	public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000004000100L});
	public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000002000000100L});
	public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x00000203304053E0L,0x00063FFDDEA20000L});
	public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000200080000002L});
	public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x00000003304053E0L,0x0004246D0E000000L});
	public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0002848448240002L,0x0000800000010000L});
	public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0001800000000000L});
	public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x00000003324053E0L,0x0004246D0E000000L});
	public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000040000400002L});
	public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0002800000000100L});
	public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000800080000000L});
	public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0002000000000100L});
	public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x00000003304053E0L,0x0004246D0E004000L});
	public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000200000002000L});
	public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x00000000004013E0L,0x0000246D0E000000L});
	public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000220000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000001000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000001000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000100L,0x0000002106000000L});
	public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000100L,0x0000006106000000L});
	public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000100L,0x0000000010000000L});
	public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x00000203304053E0L,0x0004246D1E000000L});
	public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000020080000000L});
	public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x00000003304053E0L,0x0004246D1E000000L});
	public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x00000203304053E0L,0x0004246D0E000000L});
	public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0002000000440000L});
	public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000002000100L,0x0000000010000000L});
	public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000002L,0x0000000020080000L});
	public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x0000000020080000L});
	public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x00000003304053E0L,0x0006246D0E000000L});
	public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000080000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000002L,0x0000400000000000L});
	public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
	public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x00040003304053E0L,0x0006246D0E000000L});
	public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x00040003304053E0L,0x0004246D0E000000L});
	public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x00040003324053E0L,0x0004246D0E000000L});
	public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000002L,0x0001000000000000L});
	public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000400000008002L});
	public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0001840000000002L,0x0000000200000000L});
	public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000880000000002L});
	public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000110000002L});
	public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000004004020002L});
	public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x00000203304053E2L,0x0004246D1E000000L});
	public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x00000003304053E2L,0x0004246D1E000000L});
	public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x00000003304053E2L,0x0004246D0E000000L});
	public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000000240L});
	public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000041000000002L});
	public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000000000002L,0x0000004002000000L});
	public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000004000000L});
}
