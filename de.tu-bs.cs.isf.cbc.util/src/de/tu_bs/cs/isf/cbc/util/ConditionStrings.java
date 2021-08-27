package de.tu_bs.cs.isf.cbc.util;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.BlockStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.JMLExpressionExtension;

public class ConditionStrings {
	public String pre;
	public String post;
	public String preFormula;
	public String postFormula;
	
	public ConditionStrings(AbstractStatement statement, CbCFormula formula) {
		this(statement);
		//TODO: Parser.getConditionFromCondition() ???
		preFormula = getStringFromCondition(statement.getPreCondition());
		postFormula = getStringFromCondition(statement.getPostCondition());
	}
	
	
	public ConditionStrings(BlockStatement statement) {
		pre = ((JMLExpressionExtension)statement.getJmlAnnotation().getRequires()).stringRepresentation; 
		post = ((JMLExpressionExtension)statement.getJmlAnnotation().getEnsures()).stringRepresentation; 
	}
	
	public ConditionStrings(AbstractStatement statement) {
		pre = getStringFromCondition(statement.getPreCondition());
		post= getStringFromCondition(statement.getPostCondition());
	}
	
	public ConditionStrings(JavaStatement statement) {
		pre = getStringFromCondition(statement.getPreCondition());
		post= getStringFromCondition(statement.getPostCondition());
	}
	
	private String getStringFromCondition(Condition cond) {
		if (cond instanceof ConditionExtension) {
			return ((ConditionExtension)cond).stringRepresentation;
		} else {
			if (cond.getName()!= null) {
				return cond.getName();
			} else {
				return Parser.getStringFromObject(cond);
			}
		}
	}
}
