package de.tu_bs.cs.isf.cbc.cbcmodel.string_saver;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.tu_bs.cs.isf.cbc.cbcmodel.impl.ConditionImpl;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.JavaVariableImpl;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariable;

public class JavaVariableExtension extends JavaVariableImpl {
	public String stringRepresentation;
	
	public JavaVariableExtension(JavaVariable var) {
		super();
		if (var instanceof JavaVariableExtension) {
			stringRepresentation = ((JavaVariableExtension)var).stringRepresentation;
		} else if (var instanceof ConditionImpl) {
			stringRepresentation = NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(var));
		} 
		this.var = EcoreUtil.copy(var.getVar());
	}
	
	public JavaVariableExtension(String var) {
		super();
		stringRepresentation = var;
	}

}
