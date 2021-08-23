package de.tu_bs.cs.isf.cbc.cbcmodel.string_saver;

import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.tu_bs.cs.isf.cbc.cbcmodel.Expression;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.ExpressionImpl;

public class ExpressionExtension extends ExpressionImpl{
	public String stringRepresentation;
	
	public ExpressionExtension(Expression expression) {
		super();
		if (expression instanceof ExpressionExtension) {
			stringRepresentation = ((ExpressionExtension)expression).stringRepresentation;
		} else if (expression instanceof ExpressionImpl) {
			stringRepresentation = NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(expression));
		} 
		this.foreach = expression.getForeach();
		this.type = expression.getType();
		this.var = expression.getVar();
		this.right = expression.getRight();
		this.exists = expression.getExists();
		this.isTrue = expression.isIsTrue();
	}
}
