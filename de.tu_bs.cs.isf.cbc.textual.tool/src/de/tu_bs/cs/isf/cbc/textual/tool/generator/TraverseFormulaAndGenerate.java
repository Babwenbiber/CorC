package de.tu_bs.cs.isf.cbc.textual.tool.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCProblem;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbcmodelFactory;
import de.tu_bs.cs.isf.cbc.cbcmodel.CompositionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.GlobalConditions;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariable;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables;
import de.tu_bs.cs.isf.cbc.cbcmodel.MethodStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.Rename;
import de.tu_bs.cs.isf.cbc.cbcmodel.Renaming;
import de.tu_bs.cs.isf.cbc.cbcmodel.ReturnStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SelectionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SkipStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.BlockStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SmallRepetitionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.StrengthWeakStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.AbstractStatementImpl;
import de.tu_bs.cs.isf.cbc.cbcmodel.singleton.CbCFormulaSingleton;
import de.tu_bs.cs.isf.cbc.util.ConstructCodeBlock;
import de.tu_bs.cs.isf.cbc.util.FilenamePrefix;
import de.tu_bs.cs.isf.cbc.util.Parser;
import de.tu_bs.cs.isf.cbc.util.ProveWithKey;

public class TraverseFormulaAndGenerate {

	private JavaVariables vars;
	private GlobalConditions conds;
	private Renaming renaming;
	private URI uri;
	private int numberFile;
	private CbCFormula formula;
	private Resource resource;
	private CbcmodelFactory factory;

	TraverseFormulaAndGenerate(JavaVariables vars, GlobalConditions conds, Renaming renaming, URI uri,
			CbCFormula formula, Resource resource) {
		this.vars = vars;
		this.conds = conds;
		this.renaming = renaming;
		this.uri = uri;
		this.numberFile = 0;
		this.formula = formula;
		this.resource = resource;
		this.factory = CbcmodelFactory.eINSTANCE;
		
		CbCFormulaSingleton.init(formula);
	}

	public CbCFormula traverseFormulaAndGenerate() {		
		AbstractStatement statement = formula.getStatement();
		statement.setPreCondition(factory.createCondition());
		statement.getPreCondition().setCondition(formula.getPreCondition().getCondition());
		statement.setPostCondition(factory.createCondition());
		statement.getPostCondition().setCondition(formula.getPostCondition().getCondition());
		System.out.println("lessgo Traverse");
		castStatementAndTraverse(statement);
		
		return formula;
	}

	private void castStatementAndTraverse(AbstractStatement statement) {
		if (statement.getClass().equals(AbstractStatementImpl.class)) {
			ProveWithKey.createProveStatementWithKey(statement, vars, conds, renaming, null, uri, numberFile++, false, FilenamePrefix.STATEMENT);
		} else if (statement instanceof SmallRepetitionStatement) {
			SmallRepetitionStatement repetitionStatement = (SmallRepetitionStatement) statement;
			traverseRepetitionStatement(repetitionStatement);
		} else if (statement instanceof SelectionStatement) {
			SelectionStatement selectionStatement = (SelectionStatement) statement;
			traverseSelectionStatement(selectionStatement);
		} else if (statement instanceof CompositionStatement) {
			CompositionStatement compositionStatement = (CompositionStatement) statement;
			traverseCompositionStatement(compositionStatement);
		} else if (statement instanceof MethodStatement) {
			Collection<CbCFormula> formulas = getLinkedFormulas(statement);
			if (formulas.size() == 1) {
				CbCFormula formula = formulas.iterator().next();
				CbCProblem problem = (CbCProblem) formula.eContainer();
				JavaVariables varsFormula = problem.getJavaVariable();
				GlobalConditions condsFormula = problem.getGlobalcondition();
				Renaming renamingFormula = problem.getRenaming();

				List<JavaVariable> vars = mergeJavaVariables(this.vars, varsFormula);
				List<Condition> conds = mergeGlobalConditions(this.conds, condsFormula);
				List<Rename> renaming = mergeRenaming(this.renaming, renamingFormula);
				ProveWithKey.createProveMethodFormulaWithKey(Parser.getStringFromObject(formula.getPreCondition()), Parser.getStringFromObject(statement.getPreCondition()),
						vars, conds, renaming, uri, numberFile++, false, FilenamePrefix.PRE_IMPL);
				ProveWithKey.createProveMethodFormulaWithKey(Parser.getStringFromObject(statement.getPostCondition()), Parser.getStringFromObject(formula.getPostCondition()),
						vars, conds, renaming, uri, numberFile++, false, FilenamePrefix.POST_IMPL);
			}
		} else if (statement instanceof SkipStatement) {
			ProveWithKey.createProveStatementWithKey(statement, vars, conds, renaming, null, uri, numberFile++, false, FilenamePrefix.SKIP);
		} else if (statement instanceof ReturnStatement) {
			ProveWithKey.createProveStatementWithKey(statement, vars, conds, renaming, null, uri, numberFile++, false, FilenamePrefix.RETURN);
		} else if (statement instanceof StrengthWeakStatement) {
			StrengthWeakStatement swStatement = (StrengthWeakStatement)statement;
			ProveWithKey.createProvePreImplPreWithKey(Parser.getStringFromObject(statement.getPreCondition()),
					Parser.getStringFromObject(swStatement.getWeakPreCondition()), vars, conds, renaming, uri, numberFile++, false, FilenamePrefix.PRE_IMPL);
			ProveWithKey.createProvePostImplPostWithKey(Parser.getStringFromObject(statement.getPostCondition()),
					Parser.getStringFromObject(swStatement.getStrongPostCondition()), vars, conds, renaming, uri,
					numberFile++, false, FilenamePrefix.POST_IMPL);
			ProveWithKey.createProveStatementWithKey(statement, vars, conds, renaming, null, uri, numberFile++, false, FilenamePrefix.STATEMENT);

		} else if (statement instanceof BlockStatement) {

			BlockStatement blockStatement = (BlockStatement) statement;
			ProveWithKey.createProveRequiresWithKey(Parser.getStringFromObject(statement.getPreCondition()),
					Parser.getStringFromObject(blockStatement.getJmlAnnotation().getRequires()), vars, conds, renaming, uri, numberFile++, false, FilenamePrefix.PRE_IMPL);
			ProveWithKey.createProveEnsuresWithKey(Parser.getStringFromObject(statement.getPostCondition()),
					Parser.getStringFromObject(blockStatement.getJmlAnnotation().getEnsures()), vars, conds, renaming, uri, numberFile++, false, FilenamePrefix.POST_IMPL);
			traverseBlockStatement(blockStatement);
		}
	}

	private void traverseRepetitionStatement(SmallRepetitionStatement repetitionStatement) {
		AbstractStatement loopStatement = repetitionStatement.getLoopStatement();
//		loopStatement.setPreCondition(factory.createCondition());
//		loopStatement.getPreCondition().getCondition("(" + repetitionStatement.getInvariant().getCondition() + ") & ("
//				+ repetitionStatement.getGuard().getCondition() + ")");
//		loopStatement.setPostCondition(factory.createCondition());
//		loopStatement.getPostCondition().getCondition(repetitionStatement.getInvariant().getCondition());
		ProveWithKey.createProvePreWithKey(Parser.getStringFromObject(repetitionStatement.getInvariant()), Parser.getStringFromObject(repetitionStatement.getPreCondition()),
				vars, conds, renaming, uri, numberFile++, false, FilenamePrefix.PRE_IMPL);
		ProveWithKey.createProvePostWithKey(Parser.getStringFromObject(repetitionStatement.getInvariant()), Parser.getStringFromObject(repetitionStatement.getGuard()),
				Parser.getStringFromObject(repetitionStatement.getPostCondition()), vars, conds, renaming, uri, numberFile++, false, FilenamePrefix.POST_IMPL);
		String code = ConstructCodeBlock.constructCodeBlockAndVerify3(repetitionStatement);
		ProveWithKey.createProveVariant2WithKey(code, Parser.getStringFromObject(repetitionStatement.getInvariant()),
				Parser.getStringFromObject(repetitionStatement.getGuard()), repetitionStatement.getVariant(), vars, conds, renaming, uri,
				numberFile++, false, FilenamePrefix.VARIANT2);

		castStatementAndTraverse(loopStatement);
	}

	private void traverseSelectionStatement(SelectionStatement selectionStatement) {
		ProveWithKey.createProvePreSelWithKey(selectionStatement.getGuards(), Parser.getStringFromObject(selectionStatement.getPreCondition()),
				vars, conds, renaming, uri, numberFile++, false, FilenamePrefix.SELECTION);
		for (int i = 0; i < selectionStatement.getCommands().size(); i++) {
			AbstractStatement childStatement = selectionStatement.getCommands().get(i);
			Condition childGuard = selectionStatement.getGuards().get(i);
			//TODO:
//			childStatement.setPreCondition(factory.createCondition());
//			childStatement.getPreCondition().setName(
//					"(" + selectionStatement.getPreCondition().getName() + ") & (" + childGuard.getName() + ")");
//			childStatement.setPostCondition(factory.createCondition());
//			childStatement.getPostCondition().setName(selectionStatement.getPostCondition().getName());
			castStatementAndTraverse(childStatement);
		}
	}

	private void traverseCompositionStatement(CompositionStatement compositionStatement) {
		AbstractStatement firstStatement = compositionStatement.getFirstStatement();
		AbstractStatement secondStatement = compositionStatement.getSecondStatement();

		firstStatement.setPreCondition(factory.createCondition());
		firstStatement.getPreCondition().setCondition(compositionStatement.getPreCondition().getCondition());
//		firstStatement.setPreCondition(compositionStatement.getPreCondition());
		firstStatement.setPostCondition(factory.createCondition());
		firstStatement.getPostCondition().setCondition(compositionStatement.getIntermediateCondition().getCondition());
		secondStatement.setPreCondition(factory.createCondition());
		secondStatement.getPreCondition().setCondition(compositionStatement.getIntermediateCondition().getCondition());
		secondStatement.setPostCondition(factory.createCondition());
		secondStatement.getPostCondition().setCondition(compositionStatement.getPostCondition().getCondition());
		castStatementAndTraverse(firstStatement);
		castStatementAndTraverse(secondStatement);
	}

	private void traverseBlockStatement(BlockStatement blockStatement) {
		JavaStatement statement = blockStatement.getJavaStatement();

		statement.setPreCondition(factory.createCondition());
		statement.getPreCondition().setCondition(blockStatement.getJmlAnnotation().getRequires().getCondition());
		statement.setPostCondition(factory.createCondition());
		statement.getPostCondition().setCondition(blockStatement.getJmlAnnotation().getEnsures().getCondition());
		
		ProveWithKey.createProveJavaStatementWithKey(statement, vars, conds, renaming, null, uri, numberFile++, false, FilenamePrefix.JAVA_STATEMENT);
	}
	
	private Collection<CbCFormula> getLinkedFormulas(AbstractStatement statement) {
		final Collection<CbCFormula> ret = new HashSet<CbCFormula>();
		final Collection<CbCFormula> allFormulas = getFormulas();
		for (final CbCFormula possibleFormula : allFormulas) {
			if (!EcoreUtil.equals(this.formula, possibleFormula)) { // always filter out the current formula
				if (possibleFormula != null && possibleFormula.getName().equals(statement.getName())) {
					ret.add(possibleFormula);
				}
			}
		}
		return ret;
	}

	private Collection<CbCFormula> getFormulas() {
		Collection<CbCFormula> result = Collections.emptyList();
		URI uri = resource.getURI();
		URI uriTrimmed = uri.trimFragment();
		if (uriTrimmed.isPlatformResource()) {
			String platformString = uriTrimmed.toPlatformString(true);
			IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (fileResource != null) {
				IProject project = fileResource.getProject();
				result = GetCbCFileUtil.getCbCFormulas(project);
			}
		}

		return result;
	}

	private List<JavaVariable> mergeJavaVariables(JavaVariables vars1, JavaVariables vars2) {
		if (vars1 == null && vars2 == null) {
			return null;
		} else if (vars1 != null && vars2 == null) {
			return vars1.getVariables();
		} else if (vars1 == null && vars2 != null) {
			return vars2.getVariables();
		}
		List<JavaVariable> newVars = new ArrayList<JavaVariable>();
		newVars.addAll(vars2.getVariables());
		for (JavaVariable var1 : vars1.getVariables()) {
			boolean isNew = true;
			for (JavaVariable var2 : vars2.getVariables()) {
				if (var1.getName().equals(var2.getName()) /*&& var1.getKind().equals(var2.getKind())*/) {
					isNew = false;
				}
			}
			if (isNew) {
				newVars.add(var1);
			}
			isNew = true;
		}
		return newVars;
	}

	private List<Condition> mergeGlobalConditions(GlobalConditions conds1, GlobalConditions conds2) {
		if (conds1 == null && conds2 == null) {
			return null;
		} else if (conds1 != null && conds2 == null) {
			return conds1.getConditions();
		} else if (conds1 == null && conds2 != null) {
			return conds2.getConditions();
		}
		List<Condition> newConds = new ArrayList<Condition>();
		newConds.addAll(conds2.getConditions());
		for (Condition cond1 : conds1.getConditions()) {
			boolean isNew = true;
			for (Condition cond2 : conds2.getConditions()) {
				if (cond1.getCondition().equals(cond2.getCondition())) {
					isNew = false;
				}
			}
			if (isNew) {
				newConds.add(cond1);
			}
			isNew = true;
		}
		return newConds;
	}

	private List<Rename> mergeRenaming(Renaming renaming1, Renaming renaming2) {
		if (renaming1 == null && renaming2 == null) {
			return null;
		} else if (renaming1 != null && renaming2 == null) {
			return renaming1.getRename();
		} else if (renaming1 == null && renaming2 != null) {
			return renaming2.getRename();
		}
		List<Rename> newRenaming = new ArrayList<Rename>();
		newRenaming.addAll(renaming2.getRename());
		for (Rename rename1 : renaming1.getRename()) {
			boolean isNew = true;
			for (Rename rename2 : renaming2.getRename()) {
				if (rename1.getFunction().equals(rename2.getFunction()) && rename1.getType().equals(rename2.getType())
						&& rename1.getNewName().equals(rename2.getNewName())) {
					isNew = false;
				}
			}
			if (isNew) {
				newRenaming.add(rename1);
			}
			isNew = true;
		}
		return newRenaming;
	}

}
