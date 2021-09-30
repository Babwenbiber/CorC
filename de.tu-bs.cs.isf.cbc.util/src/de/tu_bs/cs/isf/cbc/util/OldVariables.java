package de.tu_bs.cs.isf.cbc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OldVariables {

	String statement;
	List<String> oldVariables;
	
	public OldVariables(String _statement, List<String> globalVariables) {
		this.statement = _statement;
		this.oldVariables = new ArrayList<String>();
		for (String var: globalVariables) {
			String varType= var.split(" ")[0];
			String varName = var.split(" ")[1];
			while (statement.contains("\\old("+varName+")")) {
				oldVariables = getMergedVariables(Arrays.asList(varType + " " + "old_" + varName));
				this.statement = this.statement.replace("\\old("+varName+")", "old_" + varName);
			}
		}
	}
	
	public List<String> getMergedVariables(List<String> variables) {
		for (String var: oldVariables) {
			if (!variables.contains(var)) {
				variables.add(var);
			}
		}
		return variables;
	}
}
