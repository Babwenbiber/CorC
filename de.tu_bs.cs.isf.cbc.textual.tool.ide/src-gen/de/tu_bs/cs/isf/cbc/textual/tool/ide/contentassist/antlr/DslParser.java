/*
 * generated by Xtext 2.10.0
 */
package de.tu_bs.cs.isf.cbc.textual.tool.ide.contentassist.antlr;

import com.google.inject.Inject;
import de.tu_bs.cs.isf.cbc.textual.tool.ide.contentassist.antlr.internal.InternalDslParser;
import de.tu_bs.cs.isf.cbc.textual.tool.services.DslGrammarAccess;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

public class DslParser extends AbstractContentAssistParser {

	@Inject
	private DslGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalDslParser createParser() {
		InternalDslParser result = new InternalDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getAbstractStatementAccess().getAlternatives(), "rule__AbstractStatement__Alternatives");
					put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
					put(grammarAccess.getCodeStringAccess().getAlternatives_1_1(), "rule__CodeString__Alternatives_1_1");
					put(grammarAccess.getCodeStringAccess().getAlternatives_4(), "rule__CodeString__Alternatives_4");
					put(grammarAccess.getCodeStringAccess().getAlternatives_5_2(), "rule__CodeString__Alternatives_5_2");
					put(grammarAccess.getVariableStringAccess().getAlternatives_2(), "rule__VariableString__Alternatives_2");
					put(grammarAccess.getVariableStringAccess().getAlternatives_2_0_0_1_0(), "rule__VariableString__Alternatives_2_0_0_1_0");
					put(grammarAccess.getVariableStringAccess().getAlternatives_2_0_0_1_1_1(), "rule__VariableString__Alternatives_2_0_0_1_1_1");
					put(grammarAccess.getVariableStringAccess().getAlternatives_2_1_0_1(), "rule__VariableString__Alternatives_2_1_0_1");
					put(grammarAccess.getOperationAccess().getAlternatives(), "rule__Operation__Alternatives");
					put(grammarAccess.getCbCFormulaAccess().getGroup(), "rule__CbCFormula__Group__0");
					put(grammarAccess.getCodeStringAccess().getGroup(), "rule__CodeString__Group__0");
					put(grammarAccess.getCodeStringAccess().getGroup_1(), "rule__CodeString__Group_1__0");
					put(grammarAccess.getCodeStringAccess().getGroup_4_1(), "rule__CodeString__Group_4_1__0");
					put(grammarAccess.getCodeStringAccess().getGroup_5(), "rule__CodeString__Group_5__0");
					put(grammarAccess.getCodeStringAccess().getGroup_5_2_1(), "rule__CodeString__Group_5_2_1__0");
					put(grammarAccess.getVariableStringAccess().getGroup(), "rule__VariableString__Group__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_0(), "rule__VariableString__Group_2_0__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_0_0(), "rule__VariableString__Group_2_0_0__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1(), "rule__VariableString__Group_2_0_0_1__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1_0_1(), "rule__VariableString__Group_2_0_0_1_0_1__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1_1(), "rule__VariableString__Group_2_0_0_1_1__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_0_0_1_1_1_1(), "rule__VariableString__Group_2_0_0_1_1_1_1__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_0_1(), "rule__VariableString__Group_2_0_1__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_1(), "rule__VariableString__Group_2_1__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_1_0(), "rule__VariableString__Group_2_1_0__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_1_0_1_1(), "rule__VariableString__Group_2_1_0_1_1__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_1_1(), "rule__VariableString__Group_2_1_1__0");
					put(grammarAccess.getVariableStringAccess().getGroup_2_2(), "rule__VariableString__Group_2_2__0");
					put(grammarAccess.getAbstractStatement_ImplAccess().getGroup(), "rule__AbstractStatement_Impl__Group__0");
					put(grammarAccess.getMethodStatementAccess().getGroup(), "rule__MethodStatement__Group__0");
					put(grammarAccess.getReturnStatementAccess().getGroup(), "rule__ReturnStatement__Group__0");
					put(grammarAccess.getStrengthWeakStatementAccess().getGroup(), "rule__StrengthWeakStatement__Group__0");
					put(grammarAccess.getConditionAccess().getGroup(), "rule__Condition__Group__0");
					put(grammarAccess.getCompositionStatementAccess().getGroup(), "rule__CompositionStatement__Group__0");
					put(grammarAccess.getJMLAnnotationAccess().getGroup(), "rule__JMLAnnotation__Group__0");
					put(grammarAccess.getBlockStatementAccess().getGroup(), "rule__BlockStatement__Group__0");
					put(grammarAccess.getSelectionStatementAccess().getGroup(), "rule__SelectionStatement__Group__0");
					put(grammarAccess.getSelectionStatementAccess().getGroup_9(), "rule__SelectionStatement__Group_9__0");
					put(grammarAccess.getSmallRepetitionStatementAccess().getGroup(), "rule__SmallRepetitionStatement__Group__0");
					put(grammarAccess.getEIntAccess().getGroup(), "rule__EInt__Group__0");
					put(grammarAccess.getVariantAccess().getGroup(), "rule__Variant__Group__0");
					put(grammarAccess.getJavaVariablesAccess().getGroup(), "rule__JavaVariables__Group__0");
					put(grammarAccess.getJavaVariablesAccess().getGroup_2(), "rule__JavaVariables__Group_2__0");
					put(grammarAccess.getJavaVariablesAccess().getGroup_2_3(), "rule__JavaVariables__Group_2_3__0");
					put(grammarAccess.getJavaVariableAccess().getGroup(), "rule__JavaVariable__Group__0");
					put(grammarAccess.getGlobalConditionsAccess().getGroup(), "rule__GlobalConditions__Group__0");
					put(grammarAccess.getGlobalConditionsAccess().getGroup_2(), "rule__GlobalConditions__Group_2__0");
					put(grammarAccess.getGlobalConditionsAccess().getGroup_2_3(), "rule__GlobalConditions__Group_2_3__0");
					put(grammarAccess.getRenamingAccess().getGroup(), "rule__Renaming__Group__0");
					put(grammarAccess.getRenamingAccess().getGroup_2(), "rule__Renaming__Group_2__0");
					put(grammarAccess.getRenameAccess().getGroup(), "rule__Rename__Group__0");
					put(grammarAccess.getCbCProblemAccess().getCbcformulaAssignment_0(), "rule__CbCProblem__CbcformulaAssignment_0");
					put(grammarAccess.getCbCProblemAccess().getGlobalconditionAssignment_1(), "rule__CbCProblem__GlobalconditionAssignment_1");
					put(grammarAccess.getCbCProblemAccess().getJavaVariableAssignment_2(), "rule__CbCProblem__JavaVariableAssignment_2");
					put(grammarAccess.getCbCProblemAccess().getRenamingAssignment_3(), "rule__CbCProblem__RenamingAssignment_3");
					put(grammarAccess.getCbCFormulaAccess().getNameAssignment_1(), "rule__CbCFormula__NameAssignment_1");
					put(grammarAccess.getCbCFormulaAccess().getPreConditionAssignment_4(), "rule__CbCFormula__PreConditionAssignment_4");
					put(grammarAccess.getCbCFormulaAccess().getStatementAssignment_7(), "rule__CbCFormula__StatementAssignment_7");
					put(grammarAccess.getCbCFormulaAccess().getPostConditionAssignment_11(), "rule__CbCFormula__PostConditionAssignment_11");
					put(grammarAccess.getAbstractStatement_ImplAccess().getNameAssignment_1(), "rule__AbstractStatement_Impl__NameAssignment_1");
					put(grammarAccess.getMethodStatementAccess().getNameAssignment_1(), "rule__MethodStatement__NameAssignment_1");
					put(grammarAccess.getReturnStatementAccess().getNameAssignment_2(), "rule__ReturnStatement__NameAssignment_2");
					put(grammarAccess.getStrengthWeakStatementAccess().getPreConditionAssignment_3(), "rule__StrengthWeakStatement__PreConditionAssignment_3");
					put(grammarAccess.getStrengthWeakStatementAccess().getNameAssignment_6(), "rule__StrengthWeakStatement__NameAssignment_6");
					put(grammarAccess.getStrengthWeakStatementAccess().getPostConditionAssignment_10(), "rule__StrengthWeakStatement__PostConditionAssignment_10");
					put(grammarAccess.getConditionAccess().getNameAssignment_1(), "rule__Condition__NameAssignment_1");
					put(grammarAccess.getSkipStatementAccess().getNameAssignment(), "rule__SkipStatement__NameAssignment");
					put(grammarAccess.getCompositionStatementAccess().getFirstStatementAssignment_2(), "rule__CompositionStatement__FirstStatementAssignment_2");
					put(grammarAccess.getCompositionStatementAccess().getIntermediateConditionAssignment_6(), "rule__CompositionStatement__IntermediateConditionAssignment_6");
					put(grammarAccess.getCompositionStatementAccess().getSecondStatementAssignment_9(), "rule__CompositionStatement__SecondStatementAssignment_9");
					put(grammarAccess.getJMLAnnotationAccess().getRequiresAssignment_1(), "rule__JMLAnnotation__RequiresAssignment_1");
					put(grammarAccess.getJMLAnnotationAccess().getAssignableAssignment_4(), "rule__JMLAnnotation__AssignableAssignment_4");
					put(grammarAccess.getJMLAnnotationAccess().getEnsuresAssignment_7(), "rule__JMLAnnotation__EnsuresAssignment_7");
					put(grammarAccess.getBlockStatementAccess().getNameAssignment_1(), "rule__BlockStatement__NameAssignment_1");
					put(grammarAccess.getBlockStatementAccess().getJmlAnnotationAssignment_3(), "rule__BlockStatement__JmlAnnotationAssignment_3");
					put(grammarAccess.getBlockStatementAccess().getJavaStatementAssignment_5(), "rule__BlockStatement__JavaStatementAssignment_5");
					put(grammarAccess.getSelectionStatementAccess().getGuardsAssignment_3(), "rule__SelectionStatement__GuardsAssignment_3");
					put(grammarAccess.getSelectionStatementAccess().getCommandsAssignment_7(), "rule__SelectionStatement__CommandsAssignment_7");
					put(grammarAccess.getSelectionStatementAccess().getGuardsAssignment_9_2(), "rule__SelectionStatement__GuardsAssignment_9_2");
					put(grammarAccess.getSelectionStatementAccess().getCommandsAssignment_9_6(), "rule__SelectionStatement__CommandsAssignment_9_6");
					put(grammarAccess.getSmallRepetitionStatementAccess().getGuardAssignment_3(), "rule__SmallRepetitionStatement__GuardAssignment_3");
					put(grammarAccess.getSmallRepetitionStatementAccess().getInvariantAssignment_8(), "rule__SmallRepetitionStatement__InvariantAssignment_8");
					put(grammarAccess.getSmallRepetitionStatementAccess().getVariantAssignment_12(), "rule__SmallRepetitionStatement__VariantAssignment_12");
					put(grammarAccess.getSmallRepetitionStatementAccess().getLoopStatementAssignment_15(), "rule__SmallRepetitionStatement__LoopStatementAssignment_15");
					put(grammarAccess.getVariantAccess().getNameAssignment_1(), "rule__Variant__NameAssignment_1");
					put(grammarAccess.getJavaVariablesAccess().getVariablesAssignment_2_2(), "rule__JavaVariables__VariablesAssignment_2_2");
					put(grammarAccess.getJavaVariablesAccess().getVariablesAssignment_2_3_1(), "rule__JavaVariables__VariablesAssignment_2_3_1");
					put(grammarAccess.getJavaVariableAccess().getNameAssignment_1(), "rule__JavaVariable__NameAssignment_1");
					put(grammarAccess.getGlobalConditionsAccess().getConditionsAssignment_2_2(), "rule__GlobalConditions__ConditionsAssignment_2_2");
					put(grammarAccess.getGlobalConditionsAccess().getConditionsAssignment_2_3_1(), "rule__GlobalConditions__ConditionsAssignment_2_3_1");
					put(grammarAccess.getRenamingAccess().getRenameAssignment_2_2(), "rule__Renaming__RenameAssignment_2_2");
					put(grammarAccess.getRenamingAccess().getRenameAssignment_2_3(), "rule__Renaming__RenameAssignment_2_3");
					put(grammarAccess.getRenameAccess().getTypeAssignment_3(), "rule__Rename__TypeAssignment_3");
					put(grammarAccess.getRenameAccess().getFunctionAssignment_5(), "rule__Rename__FunctionAssignment_5");
					put(grammarAccess.getRenameAccess().getNewNameAssignment_7(), "rule__Rename__NewNameAssignment_7");
					put(grammarAccess.getCbCProblemAccess().getUnorderedGroup(), "rule__CbCProblem__UnorderedGroup");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			InternalDslParser typedParser = (InternalDslParser) parser;
			typedParser.entryRuleCbCProblem();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public DslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(DslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
