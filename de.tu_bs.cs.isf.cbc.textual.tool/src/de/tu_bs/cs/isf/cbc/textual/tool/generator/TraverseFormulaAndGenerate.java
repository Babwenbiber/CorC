package de.tu_bs.cs.isf.cbc.textual.tool.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XBlockExpression;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCProblem;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbcmodelFactory;
import de.tu_bs.cs.isf.cbc.cbcmodel.CompositionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.GlobalConditions;
import de.tu_bs.cs.isf.cbc.cbcmodel.InlineBlockStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.InlineJavaBlockStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.JMLExpression;
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
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ExpressionExtension;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.JMLExpressionExtension;
import de.tu_bs.cs.isf.cbc.util.ConstructCodeBlock;
import de.tu_bs.cs.isf.cbc.util.FileUtil;
import de.tu_bs.cs.isf.cbc.util.FilenamePrefix;
import de.tu_bs.cs.isf.cbc.util.HashTable;
import de.tu_bs.cs.isf.cbc.util.ListParser;
import de.tu_bs.cs.isf.cbc.util.Parser;
import de.tu_bs.cs.isf.cbc.util.ProveJavaWithKey;
import de.tu_bs.cs.isf.cbc.util.ProveWithKey;

public class TraverseFormulaAndGenerate {

	protected JavaVariables vars;
	protected GlobalConditions conds;
	protected Renaming renaming;
	protected URI uri;
	protected int numberFile;
	protected CbCFormula formula;
	protected Resource resource;
	protected CbcmodelFactory factory;
	protected boolean firstBlockSeen = false;
	protected boolean parseFormula = true;

	TraverseFormulaAndGenerate(JavaVariables vars, GlobalConditions conds, Renaming renaming, URI uri,
			CbCFormula formula, Resource resource) {
		this.vars = vars;
		this.conds = conds;
		this.renaming = renaming;
		this.uri = uri;
		System.out.println("uri is " + uri.path());
		this.numberFile = 0;
		this.formula = formula;
		this.resource = resource;
		this.factory = CbcmodelFactory.eINSTANCE;
		
		CbCFormulaSingleton.init(formula);
	}

	public CbCFormula traverseFormulaAndGenerate() {	
		ProveJavaWithKey.createJavaGlobalVariables(ListParser.getListStringFromListVariables(vars.getVariables()), uri);
		
		AbstractStatement statement = formula.getStatement();
		statement.setPreCondition(new ConditionExtension(formula.getPreCondition()));
		statement.setPostCondition(new ConditionExtension(formula.getPostCondition()));
		System.out.println("lessgo Traverse");
		castStatementAndTraverse(statement);
		String location =  FileUtil.getProject(uri).getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		System.out.println("LOCATION IS" + location + "\nUri is  still " + uri.path());

		HashTable.overrideOldOverview(location);
		
		return CbCFormulaSingleton.getCbCFormula();
	}

	protected void castStatementAndTraverse(AbstractStatement statement) {
		if (!(statement instanceof BlockStatement)) {
			ConditionExtension c = new ConditionExtension(statement.getPreCondition());
			c.stringRepresentation = Parser.rewriteJMLConditionToKeY(c.stringRepresentation);
			statement.setPreCondition(c);
			c = new ConditionExtension(statement.getPostCondition());
			c.stringRepresentation = Parser.rewriteJMLConditionToKeY(c.stringRepresentation);
			statement.setPostCondition(c);
		}
		if (statement.getClass().equals(AbstractStatementImpl.class)) {
			ProveWithKey.createProveStatementWithKey(statement,  ListParser.getListStringFromListVariables(vars.getVariables()),
					ListParser.getListStringFromListCondition(conds), renaming, null, uri, numberFile++, false, FilenamePrefix.STATEMENT, "");
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
						 ListParser.getListStringFromListVariables(vars),
							ListParser.getListStringFromListCondition(conds), renaming, uri, numberFile++, false, FilenamePrefix.PRE_IMPL);
				ProveWithKey.createProveMethodFormulaWithKey(Parser.getStringFromObject(statement.getPostCondition()), Parser.getStringFromObject(formula.getPostCondition()),
						 ListParser.getListStringFromListVariables(vars),
							ListParser.getListStringFromListCondition(conds), renaming, uri, numberFile++, false, FilenamePrefix.POST_IMPL);
			}
		} else if (statement instanceof SkipStatement) {
			ProveWithKey.createProveStatementWithKey(statement,  ListParser.getListStringFromListVariables(vars.getVariables()),
					ListParser.getListStringFromListCondition(conds), renaming, null, uri, numberFile++, false, FilenamePrefix.SKIP, "");
		} else if (statement instanceof ReturnStatement) {
			ProveWithKey.createProveStatementWithKey(statement,  ListParser.getListStringFromListVariables(vars.getVariables()),
					ListParser.getListStringFromListCondition(conds), renaming, null, uri, numberFile++, false, FilenamePrefix.RETURN, "");
		} else if (statement instanceof StrengthWeakStatement) {
			StrengthWeakStatement swStatement = (StrengthWeakStatement)statement;
			ProveWithKey.createProvePreImplPreWithKey(Parser.getStringFromObject(statement.getPreCondition()),
					Parser.getStringFromObject(swStatement.getWeakPreCondition()),  ListParser.getListStringFromListVariables(vars.getVariables()),
					ListParser.getListStringFromListCondition(conds), renaming, uri, numberFile++, false, FilenamePrefix.PRE_IMPL);
			ProveWithKey.createProvePostImplPostWithKey(Parser.getStringFromObject(statement.getPostCondition()),
					Parser.getStringFromObject(swStatement.getStrongPostCondition()), ListParser.getListStringFromListVariables(vars.getVariables()),
					ListParser.getListStringFromListCondition(conds), renaming, uri,
					numberFile++, false, FilenamePrefix.POST_IMPL);
			ProveWithKey.createProveStatementWithKey(statement,  ListParser.getListStringFromListVariables(vars.getVariables()),
					ListParser.getListStringFromListCondition(conds), renaming, null, uri, numberFile++, false, FilenamePrefix.STATEMENT, "");

		} else if (statement instanceof BlockStatement) {

			BlockStatement blockStatement = (BlockStatement) statement;
			traverseBlockStatement(blockStatement);
		} else if (statement instanceof InlineBlockStatement) {
			
			InlineBlockStatement block = (InlineBlockStatement) statement;
			if (block.getBlock() != null) {
				block.getBlock().setPreCondition(block.getPreCondition());
				block.getBlock().setPostCondition(block.getPostCondition());
				castStatementAndTraverse(block.getBlock());
				return;
			}

			BlockStatement reference = block.getReferences();
			reference.setPreCondition(new ConditionExtension(block.getPreCondition()));
			reference.setPostCondition(new ConditionExtension(block.getPostCondition()));
			castStatementAndTraverse(reference);
			
		}
	}

	private void traverseRepetitionStatement(SmallRepetitionStatement repetitionStatement) {
		AbstractStatement loopStatement = repetitionStatement.getLoopStatement();
		ConditionExtension invariant = new ConditionExtension(repetitionStatement.getInvariant());
		ConditionExtension guard = new ConditionExtension(repetitionStatement.getGuard());
		ConditionExtension pre = new ConditionExtension(repetitionStatement.getPreCondition());
		ConditionExtension post = new ConditionExtension(repetitionStatement.getPostCondition());
		loopStatement.setPreCondition(new ConditionExtension(invariant, guard));
		
		loopStatement.setPostCondition(invariant);
		//pre -> inv
		ProveWithKey.createProvePreWithKey(pre.stringRepresentation, invariant.stringRepresentation,
				ListParser.getListStringFromListVariables(vars.getVariables()),
				ListParser.getListStringFromListCondition(conds), renaming, uri, numberFile++, false, FilenamePrefix.PRE_IMPL, true);
		//inv&!guard -> post
		ProveWithKey.createProvePostWithKey(invariant.stringRepresentation, guard.stringRepresentation,
				post.stringRepresentation,  ListParser.getListStringFromListVariables(vars.getVariables()),
				ListParser.getListStringFromListCondition(conds), renaming, uri, numberFile++, false, FilenamePrefix.POST_IMPL);
		String code = ConstructCodeBlock.constructCodeBlockAndVerify3(repetitionStatement);
		//variant
		ProveWithKey.createProveVariant2WithKey(code, invariant.stringRepresentation,
				guard.stringRepresentation, new ExpressionExtension(repetitionStatement.getVariant().getVar()).stringRepresentation,
				ListParser.getListStringFromListVariables(vars.getVariables()),
				ListParser.getListStringFromListCondition(conds), renaming, uri,
				numberFile++, false, FilenamePrefix.VARIANT2);

		castStatementAndTraverse(loopStatement);
	}

	private void traverseSelectionStatement(SelectionStatement selectionStatement) {
		ConditionExtension pre = new ConditionExtension(selectionStatement.getPreCondition());
		EList<ConditionExtension> guards = new BasicEList<ConditionExtension>();
		for (Condition cond: selectionStatement.getGuards()) {
			guards.add(new ConditionExtension(cond));
		}
		ProveWithKey.createProvePreSelWithKey(ListParser.getListStringFromListCondition(guards), pre.stringRepresentation,
				 ListParser.getListStringFromListVariables(vars.getVariables()),
					ListParser.getListStringFromListCondition(conds), renaming, uri, numberFile++, false, FilenamePrefix.SELECTION);
		for (int i = 0; i < selectionStatement.getCommands().size(); i++) {
			AbstractStatement childStatement = selectionStatement.getCommands().get(i);
			Condition childGuard = selectionStatement.getGuards().get(i);
			childStatement.setPreCondition(new ConditionExtension(pre,childGuard));
			childStatement.setPostCondition(new ConditionExtension(selectionStatement.getPostCondition()));
			castStatementAndTraverse(childStatement);
		}
	}

	private void traverseCompositionStatement(CompositionStatement compositionStatement) {
		AbstractStatement firstStatement = compositionStatement.getFirstStatement();
		AbstractStatement secondStatement = compositionStatement.getSecondStatement();

		firstStatement.setPreCondition(new ConditionExtension(compositionStatement.getPreCondition()));
		firstStatement.setPostCondition(new ConditionExtension(compositionStatement.getIntermediateCondition()));
		secondStatement.setPreCondition(new ConditionExtension(compositionStatement.getIntermediateCondition()));
		secondStatement.setPostCondition(new ConditionExtension(compositionStatement.getPostCondition()));
		castStatementAndTraverse(firstStatement);
		castStatementAndTraverse(secondStatement);
	}

	protected void traverseBlockStatement(BlockStatement blockStatement) {
		String blockName; 
		String preName; 
		String postName; 
		if (parseFormula) {
			blockName = FilenamePrefix.JAVA_STATEMENT;
			preName = FilenamePrefix.PRE_IMPL;
			postName = FilenamePrefix.POST_IMPL;
		} else {
			blockName = blockStatement.getName();
			preName = blockStatement.getName() + "_pre";
			postName = blockStatement.getName() + "_post";
		}
		if (conds == null) {
			conds = factory.createGlobalConditions();
		}
		if (blockStatement.getJmlAnnotation() == null) {
			blockStatement.setJmlAnnotation(factory.createJMLAnnotation());
			JMLExpression expression = new JMLExpressionExtension(blockStatement.getPreCondition(), conds.getConditions());
			((JMLExpressionExtension)expression).stringRepresentation = Parser.rewriteConditionToJML(((JMLExpressionExtension)expression).stringRepresentation);
			blockStatement.getJmlAnnotation().setRequires(expression);
			expression = new JMLExpressionExtension(blockStatement.getPostCondition(), conds.getConditions());
			((JMLExpressionExtension)expression).stringRepresentation = Parser.rewriteConditionToJML(((JMLExpressionExtension)expression).stringRepresentation);
			blockStatement.getJmlAnnotation().setEnsures(expression);
		}		
		if (!firstBlockSeen) {
			firstBlockSeen = true;
			ProveWithKey.createProvePreImplPreWithKeyNoChildRename(new ConditionExtension(
					(Condition)blockStatement.getPreCondition()).stringRepresentation,
					Parser.rewriteJMLConditionToKeY(Parser.getStringFromObject(blockStatement.getJmlAnnotation().getRequires())),
					ListParser.getListStringFromListVariables(vars.getVariables()),
					ListParser.getListStringFromListCondition(conds), renaming, uri, numberFile++, false, preName, parseFormula);
			ProveWithKey.createProvePostImplPostWithKeyNoChildRename(new ConditionExtension(
					(Condition)blockStatement.getPostCondition()).stringRepresentation,
					Parser.rewriteJMLConditionToKeY(Parser.getStringFromObject(blockStatement.getJmlAnnotation().getEnsures())),
					ListParser.getListStringFromListVariables(vars.getVariables()),
					ListParser.getListStringFromListCondition(conds), renaming, uri, numberFile++, false, postName, parseFormula);
		}
		JavaStatement javaStatement = (JavaStatement) blockStatement.getJavaStatement();

		
		if (javaStatement != null) {	
			ProveJavaWithKey.createProveBlockStatementWithKey(blockStatement, ListParser.getListStringFromListVariables(vars.getVariables()),
					null, uri, numberFile++, false, blockName, parseFormula);
			EList<XExpression> statements = javaStatement.getStatement();
			for (XExpression s: statements) {
				System.out.println("statement is " + Parser.getStringFromObject(s));
				checkJavaStatementForBlock(s);
			}
		} else {
			AbstractStatement cbcStatement = blockStatement.getCbcStatement();
			cbcStatement.setPreCondition(new ConditionExtension(blockStatement.getJmlAnnotation().getRequires()));
			cbcStatement.setPostCondition(new ConditionExtension(blockStatement.getJmlAnnotation().getEnsures()));
			castStatementAndTraverse(cbcStatement);
		}

	}
	
	private void checkJavaStatementForBlock(XExpression s) {
		if (s instanceof XBasicForLoopExpression) {
			for (XExpression e: ((XBlockExpression)((XBasicForLoopExpression) s).getEachExpression()).getExpressions()) {
				checkJavaStatementForBlock(e);
			}
		} else if (s instanceof XForLoopExpression) {
			for (XExpression e: ((XBlockExpression)((XForLoopExpression) s).getEachExpression()).getExpressions()) {
				checkJavaStatementForBlock(e);
			}
		} else if (s instanceof XWhileExpression) {
			checkJavaStatementForBlock(((XBlockExpression)((XWhileExpression) s).getBody()));
		} else if (s instanceof XIfExpression) {
			checkJavaStatementForBlock(((XIfExpression) s).getThen());
		} else if (s instanceof InlineJavaBlockStatement) {
			BlockStatement newBlockStatement = (BlockStatement)((InlineJavaBlockStatement)s).getReferences();
			newBlockStatement.setJmlAnnotation(((InlineJavaBlockStatement)s).getJmlAnnotation());
			traverseBlockStatement(newBlockStatement);
		}
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
				if (var1.getVar().equals(var2.getVar()) && var1.getType().equals(var2.getType())) {
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
