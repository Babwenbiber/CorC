/**
 * generated by Xtext 2.10.0
 */
package de.tu_bs.cs.isf.cbc.textual.tool.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
@SuppressWarnings("all")
public class DslProposalProvider extends AbstractDslProposalProvider {
  @Override
  public void complete_CompositionStatement(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_CompositionStatement(model, ruleCall, context, acceptor);
    final String proposal = (((("{\n" + "\t;\n") + "} Intm: (true) {\n") + "\t;\n") + "}");
    acceptor.accept(this.createCompletionProposal(proposal, "Composition", null, context));
  }
  
  @Override
  public void complete_SmallRepetitionStatement(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_SmallRepetitionStatement(model, ruleCall, context, acceptor);
    final String proposal = (((("While (true) Do\n" + "\t\tInv: (true) Var: (<variant>)\n") + "\t\t{\n") + "\t\t\t;\n") + "\t\t} Od");
    acceptor.accept(this.createCompletionProposal(proposal, "Repetition", null, context));
  }
  
  @Override
  public void complete_SelectionStatement(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_SelectionStatement(model, ruleCall, context, acceptor);
    final String proposal = ((("If (true) Then\n" + "\t\t{;}\n") + "\t\tElseif (false) Then\n") + "\t\t{;} Fi");
    acceptor.accept(this.createCompletionProposal(proposal, "Selection", null, context));
  }
  
  @Override
  public void complete_BlockStatement(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_SelectionStatement(model, ruleCall, context, acceptor);
    final String proposal = (((((("Block <name>:\n" + "/*@ requires (true);\n") + "  @ ensures (true);\n") + " */\n") + "{\n") + "\t;\n") + "}");
    acceptor.accept(this.createCompletionProposal(proposal, "Block", null, context));
  }
  
  @Override
  public void complete_CbCFormula(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_CbCFormula(model, ruleCall, context, acceptor);
    final String proposal = ((("Formula <formula>\n" + "\tPre: (true)\n") + "\t{;}\n") + "\tPost: (true)");
    acceptor.accept(this.createCompletionProposal(proposal, "Formula", null, context));
  }
  
  @Override
  public void complete_StrengthWeakStatement(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_StrengthWeakStatement(model, ruleCall, context, acceptor);
    final String proposal = (("Pre: (true)\n" + "\t\t{;}\n") + "\t\tPost: (true)");
    acceptor.accept(this.createCompletionProposal(proposal, "StrengthWeak", null, context));
  }
  
  @Override
  public void complete_JavaVariables(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_JavaVariables(model, ruleCall, context, acceptor);
    final String proposal = ("JavaVariables\n" + "\tVariables [int i]\n");
    acceptor.accept(this.createCompletionProposal(proposal, "JavaVariables", null, context));
  }
  
  @Override
  public void complete_GlobalConditions(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_GlobalConditions(model, ruleCall, context, acceptor);
    final String proposal = ("GlobalConditions\n" + "\tConditions [true=true]\n");
    acceptor.accept(this.createCompletionProposal(proposal, "GlobalConditions", null, context));
  }
  
  @Override
  public void complete_Renaming(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_Renaming(model, ruleCall, context, acceptor);
    final String proposal = ((((("Renaming\n" + "\tRenames [\n") + "\t\t{Type \"<type>\"") + " Function \"<functionName>\"") + " NewName \"<newName>\"}\n") + "\t]");
    acceptor.accept(this.createCompletionProposal(proposal, "Renames", null, context));
  }
  
  @Override
  public void complete_Rename(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_Rename(model, ruleCall, context, acceptor);
    final String proposal = (("{Type \"<type>\"" + " Function \"<functionName>\"") + " NewName \"<newName>\"}");
    acceptor.accept(this.createCompletionProposal(proposal, "Rename", null, context));
  }
}
