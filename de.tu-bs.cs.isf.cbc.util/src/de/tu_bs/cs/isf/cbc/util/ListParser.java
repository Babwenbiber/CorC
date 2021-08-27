package de.tu_bs.cs.isf.cbc.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.GlobalConditions;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariable;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.JavaVariableExtension;

public class ListParser {
	static public List<String> getListStringFromListCondition(GlobalConditions conditions) {
		if (conditions == null) {
			return new ArrayList<String>();
		}
		return getListStringFromListCondition(conditions.getConditions());
	}
	static public List<String> getListStringFromListCondition(EList<?> conditions) {
		List<String> strList = new ArrayList<String>();
		for(Object c: conditions) {
			strList.add(new ConditionExtension((Condition)c).stringRepresentation);
		}
		return strList;
	}
	
	static public List<String> getListStringFromListCondition(List<?> conditions) {
		List<String> strList = new ArrayList<String>();
		for(Object c: conditions) {
			strList.add(new ConditionExtension((Condition)c).stringRepresentation);
		}
		return strList;
	}
	
	
	static public List<String> getListStringFromListVariables(JavaVariables variables) {
		if (variables == null) {
			return new ArrayList<String>();
		}
		return getListStringFromListVariables(variables.getVariables());
	}
	static public List<String> getListStringFromListVariables(EList<JavaVariable> variables) {
		List<String> strList = new ArrayList<String>();
		for(JavaVariable v: variables) {
			strList.add(new JavaVariableExtension(v).stringRepresentation);
		}
		return strList;
	}
	static public List<String> getListStringFromListVariables(List<JavaVariable> variables) {
		List<String> strList = new ArrayList<String>();
		for(JavaVariable v: variables) {
			strList.add(new JavaVariableExtension(v).stringRepresentation);
		}
		return strList;
	}

}
