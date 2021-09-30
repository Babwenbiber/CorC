package de.tu_bs.cs.isf.cbc.cbcmodel.string_saver;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.tu_bs.cs.isf.cbc.cbcmodel.CbcmodelFactory;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.JMLExpression;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.ConditionImpl;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.JMLExpressionImpl;

public class ConditionExtension extends ConditionImpl{
	public String stringRepresentation;
	
	public ConditionExtension(Condition condition) {
		super();
		if (condition == null) {
			stringRepresentation = "";
			return;
		} else if (condition instanceof ConditionExtension) {
			stringRepresentation = ((ConditionExtension)condition).stringRepresentation;
		} else if (condition instanceof ConditionImpl) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(condition);
			if (node == null) {
				if (condition.getName() != null) {
					stringRepresentation = condition.getName();
				} else {
					stringRepresentation = "";
				}
			} else {
				stringRepresentation = NodeModelUtils.getTokenText(node);
			}
		} 
		this.condition = EcoreUtil.copy(condition.getCondition());
	}
	
	public ConditionExtension(JMLExpression jmlExpression) {
		super();
		if (jmlExpression == null) {
			stringRepresentation = "";
			return;
		} else if (jmlExpression instanceof JMLExpressionExtension) {
			stringRepresentation = ((JMLExpressionExtension)jmlExpression).stringRepresentation;
		} else if (jmlExpression instanceof JMLExpressionImpl) {
			stringRepresentation = NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(jmlExpression));
		} 
		this.condition = CbcmodelFactory.eINSTANCE.createExpression();
	}
	
	public ConditionExtension(Condition condition1, Condition condition2) {
		this(condition1);
		stringRepresentation = "(" + stringRepresentation + ") & ";
		String secondCondString  = "";
		if (condition2 instanceof ConditionExtension) {
			secondCondString = ((ConditionExtension)condition2).stringRepresentation;
		} else if (condition2 instanceof ConditionImpl) {
			secondCondString = NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(condition2));
		}
		if (secondCondString.isEmpty()) {
			secondCondString = "true";
		}
		stringRepresentation += "(" + secondCondString + ")";
	}
	
	public ConditionExtension(Condition condition1, List<Condition> condition2) {
		this(condition1);
		stringRepresentation = "(" + stringRepresentation + ")";
		for (Condition cond: condition2) {
			String secondCondString  = "";
			if (cond instanceof ConditionExtension) {
				secondCondString = ((ConditionExtension)cond).stringRepresentation;
			} else if (cond instanceof ConditionImpl) {
				secondCondString = NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(cond));
			}
			if (secondCondString.isEmpty()) {
				secondCondString = "true";
			}
			stringRepresentation += " & (" + secondCondString + ")";
		}
	}
}
