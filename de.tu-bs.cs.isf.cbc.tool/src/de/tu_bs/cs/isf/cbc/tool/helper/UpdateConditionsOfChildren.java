package de.tu_bs.cs.isf.cbc.tool.helper;

import org.eclipse.emf.ecore.EObject;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.Composition3Statement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CompositionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.MethodStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.RepetitionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.ReturnStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SelectionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SkipStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SmallRepetitionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.StrengthWeakStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension;
import de.tu_bs.cs.isf.cbc.util.Parser;

public class UpdateConditionsOfChildren {

	public static void updateConditionsofChildren(Condition condition) {
		AbstractStatement statement = (AbstractStatement) condition.eContainer();
		if (statement instanceof CompositionStatement || statement instanceof Composition3Statement
				|| statement instanceof RepetitionStatement || statement instanceof SmallRepetitionStatement
				|| statement instanceof SelectionStatement) {
			if (statement.getParent() != null) {
				updateRefinedStatement(statement.getParent(), statement);
			}
		} else if (statement.getRefinement() != null) {
			AbstractStatement refinedStatement = statement.getRefinement();
			updateRefinedStatement(statement, refinedStatement);
		}
	}

	public static void updateRefinedStatement(AbstractStatement parentStatement, AbstractStatement refinedStatement) {
		ConditionExtension preParent = new ConditionExtension(parentStatement.getPreCondition());
		ConditionExtension postParent =new ConditionExtension(parentStatement.getPostCondition());

//		refinedStatement.setProven(false);
		if (refinedStatement instanceof SkipStatement) {
			SkipStatement childSkip = (SkipStatement) refinedStatement;
			ConditionExtension preSkip= new ConditionExtension(childSkip.getPreCondition());
			ConditionExtension postSkip=new ConditionExtension(childSkip.getPostCondition());
			if (!preSkip.stringRepresentation.equals(preParent.stringRepresentation)
					|| !postSkip.stringRepresentation.equals(postParent.stringRepresentation)) {
				refinedStatement.setProven(false);
			}
			ConditionExtension preChild = new ConditionExtension(childSkip.getPreCondition());
			preChild.stringRepresentation = preParent.stringRepresentation;
			ConditionExtension postChild = new ConditionExtension(childSkip.getPostCondition());
			postChild.stringRepresentation = postParent.stringRepresentation;

		} else if (refinedStatement instanceof CompositionStatement) {
			CompositionStatement childCompo = (CompositionStatement) refinedStatement;
			AbstractStatement firstStatement = childCompo.getFirstStatement();
			AbstractStatement secondStatement = childCompo.getSecondStatement();
			ConditionExtension firstPre = new ConditionExtension(firstStatement.getPreCondition());
			ConditionExtension firstPost= new ConditionExtension(firstStatement.getPostCondition());
			ConditionExtension secondPre = new ConditionExtension(secondStatement.getPreCondition());
			ConditionExtension secondPost= new ConditionExtension(secondStatement.getPostCondition());
			ConditionExtension intm = new ConditionExtension(childCompo.getIntermediateCondition());

			if (!firstPre.stringRepresentation.equals(preParent.stringRepresentation)
					|| !firstPost.stringRepresentation
							.equals(intm.stringRepresentation)
					|| !secondPre.stringRepresentation
							.equals(intm.stringRepresentation)
					|| !secondPost.stringRepresentation.equals(postParent.stringRepresentation)) {
				refinedStatement.setProven(false);
			}
			firstPre.stringRepresentation = preParent.stringRepresentation;
			firstPost.stringRepresentation = intm.stringRepresentation;
			secondPre.stringRepresentation = intm.stringRepresentation;
			secondPost.stringRepresentation = preParent.stringRepresentation;
			firstStatement.setPreCondition(firstPre);
			firstStatement.setPostCondition(firstPost);
			secondStatement.setPreCondition(secondPre);
			secondStatement.setPostCondition(secondPost);

			if (firstStatement.getRefinement() != null) {
				updateRefinedStatement(firstStatement, firstStatement.getRefinement());
			}
			if (secondStatement.getRefinement() != null) {
				updateRefinedStatement(secondStatement, secondStatement.getRefinement());
			}

		} else if (refinedStatement instanceof Composition3Statement) {
			Composition3Statement childCompo = (Composition3Statement) refinedStatement;
			AbstractStatement firstStatement = childCompo.getFirstStatement();
			AbstractStatement secondStatement = childCompo.getSecondStatement();
			AbstractStatement thirdStatement = childCompo.getThirdStatement();
			
			ConditionExtension firstPre = new ConditionExtension(firstStatement.getPreCondition());
			ConditionExtension firstPost= new ConditionExtension(firstStatement.getPostCondition());
			ConditionExtension secondPre = new ConditionExtension(secondStatement.getPreCondition());
			ConditionExtension secondPost= new ConditionExtension(secondStatement.getPostCondition());
			ConditionExtension thirdPre = new ConditionExtension(thirdStatement.getPreCondition());
			ConditionExtension thirdPost= new ConditionExtension(thirdStatement.getPostCondition());
			ConditionExtension firstIntm = new ConditionExtension(childCompo.getFirstIntermediateCondition());
			ConditionExtension secondIntm = new ConditionExtension(childCompo.getSecondIntermediateCondition());

			if (!firstPre.stringRepresentation.equals(preParent.stringRepresentation)
					|| !firstPost.stringRepresentation
							.equals(firstIntm.stringRepresentation)
					|| !secondPre.stringRepresentation
							.equals(firstIntm.stringRepresentation)
					|| !secondPost.stringRepresentation
							.equals(secondIntm.stringRepresentation)
					|| !thirdPre.stringRepresentation
							.equals(secondIntm.stringRepresentation)
					|| !thirdPost.stringRepresentation.equals(postParent.stringRepresentation)) {
				refinedStatement.setProven(false);
			}

			firstPre.stringRepresentation = preParent.stringRepresentation;
			firstPost.stringRepresentation = firstIntm.stringRepresentation;
			secondPre.stringRepresentation =  firstIntm.stringRepresentation;
			secondPost.stringRepresentation =  secondIntm.stringRepresentation;
			thirdPre.stringRepresentation =  secondIntm.stringRepresentation;
			thirdPost.stringRepresentation = preParent.stringRepresentation;
			firstStatement.setPreCondition(firstPre);
			firstStatement.setPostCondition(firstPost);
			secondStatement.setPreCondition(secondPre);
			secondStatement.setPostCondition(secondPost);
			thirdStatement.setPreCondition(thirdPre);
			thirdStatement.setPostCondition(thirdPost);

			if (firstStatement.getRefinement() != null) {
				updateRefinedStatement(firstStatement, firstStatement.getRefinement());
			}
			if (secondStatement.getRefinement() != null) {
				updateRefinedStatement(secondStatement, secondStatement.getRefinement());
			}
			if (thirdStatement.getRefinement() != null) {
				updateRefinedStatement(thirdStatement, thirdStatement.getRefinement());
			}

		} else if (refinedStatement instanceof RepetitionStatement) {
			RepetitionStatement childRep = (RepetitionStatement) refinedStatement;
			AbstractStatement startStatement = childRep.getStartStatement();
			AbstractStatement loopStatement = childRep.getLoopStatement();
			AbstractStatement endStatement = childRep.getEndStatement();

			ConditionExtension startPre = new ConditionExtension(startStatement.getPreCondition());
			ConditionExtension startPost= new ConditionExtension(startStatement.getPostCondition());
			ConditionExtension loopPre = new ConditionExtension(loopStatement.getPreCondition());
			ConditionExtension loopPost= new ConditionExtension(loopStatement.getPostCondition());
			ConditionExtension endPre = new ConditionExtension(endStatement.getPreCondition());
			ConditionExtension endPost= new ConditionExtension(endStatement.getPostCondition());
			ConditionExtension inv = new ConditionExtension(childRep.getInvariant());
			ConditionExtension guard = new ConditionExtension(childRep.getGuard());
			
			ConditionExtension invAndGuard = new ConditionExtension(childRep.getInvariant(), childRep.getGuard());
			ConditionExtension invAndNotGuard = new ConditionExtension(childRep.getInvariant());
			invAndNotGuard.stringRepresentation = "(" + invAndNotGuard.stringRepresentation + ") & !(" + guard.stringRepresentation + ")";
			
			if (!startPre.stringRepresentation.equals(preParent.stringRepresentation)
					|| !startPost.stringRepresentation.equals(inv.stringRepresentation)
					|| !loopPre.stringRepresentation.equals(
							invAndGuard.stringRepresentation)
					|| !loopPost.stringRepresentation.equals(inv.stringRepresentation)
					|| !endPre.stringRepresentation.equals(invAndNotGuard.stringRepresentation)
					|| !endPost.stringRepresentation.equals(postParent.stringRepresentation)) {
				refinedStatement.setProven(false);
				childRep.setVariantProven(false);
			}

			startPre.stringRepresentation = preParent.stringRepresentation;
			startPost.stringRepresentation = inv.stringRepresentation;
			loopPre.stringRepresentation = invAndGuard.stringRepresentation;
			loopPost.stringRepresentation = inv.stringRepresentation;
			endPre.stringRepresentation = invAndNotGuard.stringRepresentation;
			endPost.stringRepresentation = preParent.stringRepresentation;
			startStatement.setPreCondition(startPre);
			startStatement.setPostCondition(startPost);
			loopStatement.setPreCondition(loopPre);
			loopStatement.setPostCondition(loopPost);
			endStatement.setPreCondition(endPre);
			endStatement.setPostCondition(endPost);
			
		

			if (startStatement.getRefinement() != null) {
				updateRefinedStatement(startStatement, startStatement.getRefinement());
			}
			if (loopStatement.getRefinement() != null) {
				updateRefinedStatement(loopStatement, loopStatement.getRefinement());
			}
			if (endStatement.getRefinement() != null) {
				updateRefinedStatement(endStatement, endStatement.getRefinement());
			}

		} else if (refinedStatement instanceof SmallRepetitionStatement) {
			SmallRepetitionStatement childRep = (SmallRepetitionStatement) refinedStatement;
			AbstractStatement loopStatement = childRep.getLoopStatement();
			
			ConditionExtension childPre = new ConditionExtension(childRep.getPreCondition());
			ConditionExtension childPost= new ConditionExtension(childRep.getPostCondition());
			ConditionExtension loopPre = new ConditionExtension(loopStatement.getPreCondition());
			ConditionExtension loopPost= new ConditionExtension(loopStatement.getPostCondition());
			
			ConditionExtension inv = new ConditionExtension(childRep.getInvariant());
			
			ConditionExtension invAndGuard = new ConditionExtension(childRep.getInvariant(), childRep.getGuard());
		
			if (!loopPre.stringRepresentation
					.equals(invAndGuard)
					|| !loopPost.stringRepresentation.equals(inv.stringRepresentation)) {
				refinedStatement.setProven(false);
				childRep.setVariantProven(false);
			}
			if (!loopPost.stringRepresentation.equals(inv.stringRepresentation)
					|| !childPre.stringRepresentation.equals(preParent)) {
				childRep.setPreProven(false);
			}
			if (!loopPre.stringRepresentation
					.equals(invAndGuard.stringRepresentation)
					|| !childPost.stringRepresentation.equals(postParent)) {
				childRep.setPostProven(false);
			}

			childPre.stringRepresentation = preParent.stringRepresentation;
			childPost.stringRepresentation = postParent.stringRepresentation;
			loopPre.stringRepresentation = invAndGuard.stringRepresentation;
			loopPost.stringRepresentation = inv.stringRepresentation;
			
			childRep.setPreCondition(childPre);
			childRep.setPostCondition(childPost);
			loopStatement.setPreCondition(loopPre);
			loopStatement.setPostCondition(loopPost);
		
			if (loopStatement.getRefinement() != null) {
				updateRefinedStatement(loopStatement, loopStatement.getRefinement());
			}

		} else if (refinedStatement instanceof SelectionStatement) {
			SelectionStatement childSel = (SelectionStatement) refinedStatement;

			for (int i = 0; i < childSel.getCommands().size(); i++) {
				AbstractStatement childStatement = childSel.getCommands().get(i);
				ConditionExtension childGuard = new ConditionExtension(childSel.getGuards().get(i));
				
				ConditionExtension childPre = new ConditionExtension(childStatement.getPreCondition());
				ConditionExtension childPost= new ConditionExtension(childStatement.getPostCondition());
				ConditionExtension invAndGuard = new ConditionExtension(childPre, childGuard);

				String preCondParent = Parser.getConditionFromCondition(preParent.stringRepresentation);
				String modifiablePreParent = Parser.getModifieableVarsFromCondition(preParent.stringRepresentation)
						.equals("\\\\everything;") ? ""
								: "modifiable(" + Parser.getModifieableVarsFromCondition(preParent.stringRepresentation) + ");";

				if (!childPre.stringRepresentation
						.equals(invAndGuard.stringRepresentation)
						|| !childPost.stringRepresentation.equals(postParent.stringRepresentation)) {
					refinedStatement.setProven(false);
				}
				if (!childPre.stringRepresentation
						.equals(invAndGuard.stringRepresentation)) {
					childSel.setPreProve(false);
				}

				childPre.stringRepresentation = invAndGuard.stringRepresentation;
				childPost.stringRepresentation = postParent.stringRepresentation;
				
				childStatement.setPreCondition(childPre);
				childStatement.setPostCondition(childPost);
			
				if (childStatement.getRefinement() != null) {
					updateRefinedStatement(childStatement, childStatement.getRefinement());
				}
			}

		} else if (refinedStatement instanceof MethodStatement) {
			MethodStatement childAbstract = (MethodStatement) refinedStatement;

			ConditionExtension childPre = new ConditionExtension(childAbstract.getPreCondition());
			ConditionExtension childPost= new ConditionExtension(childAbstract.getPostCondition());
			
			if (!childPre.stringRepresentation.equals(preParent.stringRepresentation)
					|| !childPost.stringRepresentation.equals(postParent.stringRepresentation)) {
				refinedStatement.setProven(false);
			}

			childPre.stringRepresentation = preParent.stringRepresentation;
			childPost.stringRepresentation = postParent.stringRepresentation;
			
			childAbstract.setPreCondition(childPre);
			childAbstract.setPostCondition(childPost);
		
		} else if (refinedStatement instanceof ReturnStatement) {
			ReturnStatement childReturn = (ReturnStatement) refinedStatement;
			ConditionExtension childPre = new ConditionExtension(childReturn.getPreCondition());
			ConditionExtension childPost= new ConditionExtension(childReturn.getPostCondition());
			CbCFormula formula = getFormula(parentStatement);
			ConditionExtension formulaPost= new ConditionExtension(formula.getPostCondition());
			if (formula != null) {
				if (!childPre.stringRepresentation.equals(preParent.stringRepresentation) || 
						!childPost.stringRepresentation.equals(formulaPost.stringRepresentation)) {
					refinedStatement.setProven(false);
				}

				childPre.stringRepresentation = preParent.stringRepresentation;
				childPost.stringRepresentation = formulaPost.stringRepresentation;
				
				childReturn.setPreCondition(childPre);
				childReturn.setPostCondition(childPost);
				
			}

		} else if (refinedStatement instanceof StrengthWeakStatement) {
			StrengthWeakStatement childStrengthWeak = (StrengthWeakStatement) refinedStatement;
			refinedStatement.setProven(false);
			
			if (childStrengthWeak.getRefinement() != null) {
				updateRefinedStatement(childStrengthWeak, childStrengthWeak.getRefinement());
			}

		} else if (refinedStatement instanceof AbstractStatement) {
			AbstractStatement childAbstract = (AbstractStatement) refinedStatement;
			ConditionExtension childPre = new ConditionExtension(childAbstract.getPreCondition());
			ConditionExtension childPost= new ConditionExtension(childAbstract.getPostCondition());
			if (!childPre.stringRepresentation.equals(preParent.stringRepresentation)
					|| !childPost.stringRepresentation.equals(postParent.stringRepresentation)) {
				refinedStatement.setProven(false);
			}

			childPre.stringRepresentation = preParent.stringRepresentation;
			childPost.stringRepresentation = postParent.stringRepresentation;
			
			childAbstract.setPreCondition(childPre);
			childAbstract.setPostCondition(childPost);

		}
	}

	private static CbCFormula getFormula(AbstractStatement statement) {
		if (statement.getParent() != null) {
			return getFormula(statement.getParent());
		}
		EObject parent = statement.eContainer();
		if (parent != null && parent instanceof AbstractStatement) {
			return getFormula((AbstractStatement) parent);
		} else if (parent != null && parent instanceof CbCFormula) {
			return (CbCFormula) parent;
		}
		return null;
	}

	public static void setAllStatementsUnproven(AbstractStatement statement) {
		statement.setProven(false);
		if (statement instanceof CompositionStatement) {
			CompositionStatement childCompo = (CompositionStatement) statement;
			AbstractStatement firstStatement = childCompo.getFirstStatement();
			AbstractStatement secondStatement = childCompo.getSecondStatement();

			firstStatement.setProven(false);
			if (firstStatement.getRefinement() != null) {
				setAllStatementsUnproven(firstStatement.getRefinement());
			}
			secondStatement.setProven(false);
			if (secondStatement.getRefinement() != null) {
				setAllStatementsUnproven(secondStatement.getRefinement());
			}

		} else if (statement instanceof Composition3Statement) {
			Composition3Statement childCompo = (Composition3Statement) statement;
			AbstractStatement firstStatement = childCompo.getFirstStatement();
			AbstractStatement secondStatement = childCompo.getSecondStatement();
			AbstractStatement thirdStatement = childCompo.getThirdStatement();

			firstStatement.setProven(false);
			if (firstStatement.getRefinement() != null) {
				setAllStatementsUnproven(firstStatement.getRefinement());
			}
			secondStatement.setProven(false);
			if (secondStatement.getRefinement() != null) {
				setAllStatementsUnproven(secondStatement.getRefinement());
			}
			thirdStatement.setProven(false);
			if (thirdStatement.getRefinement() != null) {
				setAllStatementsUnproven(thirdStatement.getRefinement());
			}

		} else if (statement instanceof RepetitionStatement) {
			RepetitionStatement childRep = (RepetitionStatement) statement;
			AbstractStatement startStatement = childRep.getStartStatement();
			AbstractStatement loopStatement = childRep.getLoopStatement();
			AbstractStatement endStatement = childRep.getEndStatement();

			childRep.setVariantProven(false);
			startStatement.setProven(false);
			if (startStatement.getRefinement() != null) {
				setAllStatementsUnproven(startStatement.getRefinement());
			}
			loopStatement.setProven(false);
			if (loopStatement.getRefinement() != null) {
				setAllStatementsUnproven(loopStatement.getRefinement());
			}
			endStatement.setProven(false);
			if (endStatement.getRefinement() != null) {
				setAllStatementsUnproven(endStatement.getRefinement());
			}

		} else if (statement instanceof SmallRepetitionStatement) {
			SmallRepetitionStatement childRep = (SmallRepetitionStatement) statement;
			AbstractStatement loopStatement = childRep.getLoopStatement();

			childRep.setPreProven(false);
			childRep.setPostProven(false);
			childRep.setVariantProven(false);

			loopStatement.setProven(false);
			if (loopStatement.getRefinement() != null) {
				setAllStatementsUnproven(loopStatement.getRefinement());
			}

		} else if (statement instanceof SelectionStatement) {
			SelectionStatement childSel = (SelectionStatement) statement;
			childSel.setPreProve(false);
			for (int i = 0; i < childSel.getCommands().size(); i++) {
				AbstractStatement childStatement = childSel.getCommands().get(i);

				childStatement.setProven(false);
				if (childStatement.getRefinement() != null) {
					setAllStatementsUnproven(childStatement.getRefinement());
				}
			}

		} else if (statement instanceof AbstractStatement) {
			if (statement.getRefinement() != null) {
				setAllStatementsUnproven(statement.getRefinement());
			}
		}
	}
}