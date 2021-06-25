package de.tu_bs.cs.isf.cbc.util;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension;

public class ConditionStrings {
	public String pre;
	public String post;
	public String preFormula;
	public String postFormula;
	
	public ConditionStrings(AbstractStatement statement, CbCFormula formula) {
		this(statement);
		//TODO: Parser.getConditionFromCondition() ???
		Condition cond = statement.getPreCondition();
		cond = formula.getPreCondition();
		if (cond instanceof ConditionExtension) {
			preFormula = ((ConditionExtension)cond).stringRepresentation;
		} else {
			preFormula = Parser.getStringFromObject(cond);
		}
		cond = formula.getPostCondition();
		if (cond instanceof ConditionExtension) {
			postFormula = ((ConditionExtension)cond).stringRepresentation;
		} else {
			postFormula = Parser.getStringFromObject(cond);
		}
	}
	
	
	public ConditionStrings(AbstractStatement statement) {
		Condition cond = statement.getPreCondition();
		if (cond instanceof ConditionExtension) {
			pre = ((ConditionExtension)cond).stringRepresentation;
		} else {
			pre = Parser.getStringFromObject(cond);
		}
		cond = statement.getPostCondition();
		if (cond instanceof ConditionExtension) {
			post = ((ConditionExtension)cond).stringRepresentation;
		} else {
			post = Parser.getStringFromObject(cond);
		}
	}
	
	public ConditionStrings(JavaStatement statement) {
		Condition cond = statement.getPreCondition();
		if (cond instanceof ConditionExtension) {
			pre = ((ConditionExtension)cond).stringRepresentation;
		} else {
			pre = Parser.getStringFromObject(cond);
		}
		cond = statement.getPostCondition();
		if (cond instanceof ConditionExtension) {
			post = ((ConditionExtension)cond).stringRepresentation;
		} else {
			post = Parser.getStringFromObject(cond);
		}
	}
}
