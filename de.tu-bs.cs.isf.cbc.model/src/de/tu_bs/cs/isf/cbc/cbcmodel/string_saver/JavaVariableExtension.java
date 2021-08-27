package de.tu_bs.cs.isf.cbc.cbcmodel.string_saver;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariable;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.JavaVariableImpl;

public class JavaVariableExtension extends JavaVariableImpl {
	public String stringRepresentation;
	
	public JavaVariableExtension(JavaVariable javaVariable) {
		if (javaVariable instanceof JavaVariableImpl) {
			ICompositeNode  node = NodeModelUtils.findActualNodeFor(javaVariable);
			if (node == null) {
				stringRepresentation =javaVariable.getName();
	
			} else {
				stringRepresentation = NodeModelUtils.getTokenText(node);
			}
		} else {
			stringRepresentation = ((JavaVariableExtension)javaVariable).stringRepresentation;
		}
		this.var = EcoreUtil.copy(javaVariable.getVar());
		this.type = EcoreUtil.copy(javaVariable.getType());
	}
}
