package de.tu_bs.cs.isf.commands.toolbar.handler;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbcmodelFactory;
import de.tu_bs.cs.isf.cbc.cbcmodel.CompositionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SelectionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SmallRepetitionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.StrengthWeakStatement;

/**
 * Class to cast from textual model to graphical model (add AbstractStatements in Composition, Repetition and Selection)
 * @author tobias
 *
 */
public class TraverseFormulaAndTransform {
	
	private static CbcmodelFactory factory = CbcmodelFactory.eINSTANCE;

	public static CbCFormula traverseFormulaAndTransform(CbCFormula formula) {
		AbstractStatement refinedStatement = formula.getStatement();
		AbstractStatement abstractStatement = factory.createAbstractStatement();
		abstractStatement.setName("Statement");
		abstractStatement.setPreCondition(factory.createCondition());
		abstractStatement.getPreCondition().setCondition(formula.getPreCondition().getCondition());
		abstractStatement.setPostCondition(factory.createCondition());
		abstractStatement.getPostCondition().setCondition(formula.getPostCondition().getCondition());
		formula.setStatement(abstractStatement);
		abstractStatement.setRefinement(refinedStatement);
		castStatementAndTraverse(refinedStatement);
		return formula;
	}

	private static void castStatementAndTraverse(AbstractStatement statement) {
		if (statement instanceof SmallRepetitionStatement) {
			SmallRepetitionStatement repetitionStatement = (SmallRepetitionStatement) statement;
			traverseRepetitionStatement(repetitionStatement);
		} else if (statement instanceof SelectionStatement) {
			SelectionStatement selectionStatement = (SelectionStatement) statement;
			traverseSelectionStatement(selectionStatement);
		} else if (statement instanceof CompositionStatement) {
			CompositionStatement compositionStatement = (CompositionStatement) statement;
			traverseCompositionStatement(compositionStatement);
		} else if (statement instanceof StrengthWeakStatement) {
			StrengthWeakStatement StrengthWeakStatement = (StrengthWeakStatement) statement;
			traverseStrengthWeakStatement(StrengthWeakStatement);
		}
	}

	private static void traverseRepetitionStatement(SmallRepetitionStatement repetitionStatement) {
		AbstractStatement loopStatement = repetitionStatement.getLoopStatement();
		
		AbstractStatement abstractStatement = factory.createAbstractStatement();
		abstractStatement.setName("LoopStatement");
		abstractStatement.setPreCondition(factory.createCondition());
		abstractStatement.getPreCondition().setCondition(loopStatement.getPreCondition().getCondition());
		abstractStatement.setPostCondition(factory.createCondition());
		abstractStatement.getPostCondition().setCondition(loopStatement.getPostCondition().getCondition());
		repetitionStatement.setLoopStatement(abstractStatement);
		abstractStatement.setRefinement(loopStatement);
		castStatementAndTraverse(loopStatement);
	}
	
	private static void traverseSelectionStatement(SelectionStatement selectionStatement) {
		for (int i = 0; i < selectionStatement.getCommands().size(); i++) {
			AbstractStatement childStatement = (AbstractStatement) selectionStatement.getCommands().get(i);
			
			AbstractStatement abstractStatement = factory.createAbstractStatement();
			abstractStatement.setName("SelectionStatement" + i);
			abstractStatement.setPreCondition(factory.createCondition());
			abstractStatement.getPreCondition().setCondition(childStatement.getPreCondition().getCondition());
			abstractStatement.setPostCondition(factory.createCondition());
			abstractStatement.getPostCondition().setCondition(childStatement.getPostCondition().getCondition());
			selectionStatement.getCommands().set(i, abstractStatement);
			abstractStatement.setRefinement(childStatement);
			castStatementAndTraverse(childStatement);
		}
	}
	
	private static void traverseCompositionStatement(CompositionStatement compositionStatement) {
		AbstractStatement firstStatement = compositionStatement.getFirstStatement();
		AbstractStatement secondStatement = compositionStatement.getSecondStatement();
		
		AbstractStatement abstractStatement = factory.createAbstractStatement();
		abstractStatement.setName("FirstStatement");
		abstractStatement.setPreCondition(factory.createCondition());
		abstractStatement.getPreCondition().setCondition(firstStatement.getPreCondition().getCondition());
		abstractStatement.setPostCondition(factory.createCondition());
		abstractStatement.getPostCondition().setCondition(firstStatement.getPostCondition().getCondition());
		compositionStatement.setFirstStatement(abstractStatement);
		abstractStatement.setRefinement(firstStatement);
		castStatementAndTraverse(firstStatement);
	
		abstractStatement = factory.createAbstractStatement();
		abstractStatement.setName("SecondStatement");
		abstractStatement.setPreCondition(factory.createCondition());
		abstractStatement.getPreCondition().setCondition(secondStatement.getPreCondition().getCondition());
		abstractStatement.setPostCondition(factory.createCondition());
		abstractStatement.getPostCondition().setCondition(secondStatement.getPostCondition().getCondition());
		compositionStatement.setSecondStatement(abstractStatement);
		abstractStatement.setRefinement(secondStatement);
		castStatementAndTraverse(secondStatement);
	}
	
	private static void traverseStrengthWeakStatement(StrengthWeakStatement statement) {
		AbstractStatement abstractStatement = factory.createAbstractStatement();
		abstractStatement.setName(statement.getName());
		statement.setName("Statement");
		abstractStatement.setPreCondition(factory.createCondition());
		abstractStatement.getPreCondition().setCondition(statement.getPreCondition().getCondition());
		abstractStatement.setPostCondition(factory.createCondition());
		abstractStatement.getPostCondition().setCondition(statement.getPostCondition().getCondition());
		statement.setRefinement(abstractStatement);
	}

	
}
