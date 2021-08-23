package de.tu_bs.cs.isf.cbc.tool.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.GlobalConditions;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariable;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables;
import de.tu_bs.cs.isf.cbc.cbcmodel.VariableKind;

public class StringParser {
	public static List<String> getConditionListToStringList(GlobalConditions conditions) {
		if (conditions == null) {
			return new ArrayList<String>();
		}
		return getConditionListToStringList(conditions.getConditions());
	}
	
	private static List<String> getConditionListToStringList(EList<Condition> conditions) {
		List<String> strings = new ArrayList();
		for(Condition c: conditions) {
			strings.add(c.getName());
		}
		return strings;
	}
	
	public static List<String> getConditionListToStringList(List<Condition> conditions) {
		List<String> strings = new ArrayList();
		for(Condition c: conditions) {
			strings.add(c.getName());
		}
		return strings;
	}
	
	public static List<String> getVariableListToStringList(JavaVariables variables) {
		if (variables == null) {
			return new ArrayList<String>();
		}
		return getVariableListToStringList(variables.getVariables());
	}
	
	private static List<String> getVariableListToStringList(EList<JavaVariable> variables) {
		List<String> strings = new ArrayList();
		for(JavaVariable v: variables) {
			strings.add(v.getName());
		}
		return strings;
	}
	
	public static List<String> getVariableListToStringList(List<JavaVariable> variables) {
		List<String> strings = new ArrayList();
		for(JavaVariable v: variables) {
			strings.add(v.getName());
		}
		return strings;
	}
	
	public static String getReturnVariableStringFromVariables(EList<JavaVariable> vars) {
		if (vars == null) return "";
		String returnVariable= "";
		for (JavaVariable var: vars) {
			if (var.getKind() == VariableKind.RETURN) {
				returnVariable = var.getName();
			}
		}
		return returnVariable;
	}
}
