package de.tu_bs.cs.isf.cbc.cbcmodel.string_saver;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.ConditionImpl;

public class ConditionExtension extends ConditionImpl{
	public String stringRepresentation;
	
	public ConditionExtension(Condition condition) {
		super();
		if (condition instanceof ConditionExtension) {
			stringRepresentation = ((ConditionExtension)condition).stringRepresentation;
		} else if (condition instanceof ConditionImpl) {
			stringRepresentation = NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(condition));
		} 
		this.condition = EcoreUtil.copy(condition.getCondition());
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
}
