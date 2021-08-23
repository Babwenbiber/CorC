package de.tu_bs.cs.isf.cbc.cbcmodel.string_saver;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariable;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.JavaVariableImpl;

public class JavaVariableExtension extends JavaVariableImpl {
	public String stringRepresentation;
	
	public JavaVariableExtension(JavaVariable javaVariable) {
		if (javaVariable instanceof JavaVariableImpl) {
			stringRepresentation = NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(javaVariable));
		} else {
			stringRepresentation = ((JavaVariableExtension)javaVariable).stringRepresentation;
		}
		this.var = EcoreUtil.copy(javaVariable.getVar());
		this.type = EcoreUtil.copy(javaVariable.getType());
	}
}
