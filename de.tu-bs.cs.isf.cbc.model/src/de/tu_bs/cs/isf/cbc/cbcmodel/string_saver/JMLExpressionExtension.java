package de.tu_bs.cs.isf.cbc.cbcmodel.string_saver;

import org.eclipse.emf.ecore.util.EcoreUtil;
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
			stringRepresentation = ((JMLExpressionExtension)condition).stringRepresentation;
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
	
//	public JMLExpressionExtension(Condition condition1, Condition condition2) {
//		this(condition1);
//		stringRepresentation = "(" + stringRepresentation + ") & ";
//		String secondCondString  = "";
//		if (condition2 instanceof JMLExpressionExtension) {
//			secondCondString = ((JMLExpressionExtension)condition2).stringRepresentation;
//		} else if (condition2 instanceof ConditionImpl) {
//			secondCondString = NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(condition2));
//		}
//		if (secondCondString.isEmpty()) {
//			secondCondString = "true";
//		}
//		stringRepresentation += "(" + secondCondString + ")";
//	}
}
