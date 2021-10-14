package de.tu_bs.cs.isf.cbc.cbcmodel.string_saver;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.JMLExpression;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.ConditionImpl;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.JMLExpressionImpl;

public class JMLExpressionExtension extends JMLExpressionImpl{
	public String stringRepresentation;
	
	public JMLExpressionExtension(Condition condition) {
		super();
		if (condition instanceof ConditionExtension) {
			stringRepresentation = ((ConditionExtension)condition).stringRepresentation;
		} else if (condition instanceof ConditionImpl) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(condition);
			if (node == null) {
				stringRepresentation = "";
			} else {
				stringRepresentation = NodeModelUtils.getTokenText(node);
			}
		} 
	}
	
	public JMLExpressionExtension(JMLExpression exp) {
		super();
		ICompositeNode node = NodeModelUtils.findActualNodeFor(exp);
		if (node == null) {
			stringRepresentation = "";
		} else {
			stringRepresentation = NodeModelUtils.getTokenText(node);
		}
	}
	
	public JMLExpressionExtension(Condition condition1, EList<Condition> conditions) {
		this(condition1);
		stringRepresentation = "((" + stringRepresentation + ") & ";
		String secondCondString  = "";
		boolean init = false;
		for (Condition cond: conditions) {
			if (init) {
				secondCondString += " & ";
			} else {
				init = true;
			}
			if (cond instanceof JMLExpressionExtension) {
				secondCondString += ((JMLExpressionExtension)cond).stringRepresentation;
			} else if (cond instanceof ConditionImpl) {
				secondCondString += NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(cond));
			}
		}
		if (secondCondString.isEmpty()) {
			secondCondString = "true";
		}
		stringRepresentation += "(" + secondCondString + "))";
	}
}
