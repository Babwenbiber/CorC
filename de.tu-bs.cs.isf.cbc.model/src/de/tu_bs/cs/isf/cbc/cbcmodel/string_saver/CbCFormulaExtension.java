package de.tu_bs.cs.isf.cbc.cbcmodel.string_saver;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.CbCFormulaImpl;

public class CbCFormulaExtension extends CbCFormulaImpl{
	public String stringRepresentation;
	
	public CbCFormulaExtension(CbCFormula formula) {
		super();
		if (formula instanceof CbCFormulaImpl) {
			this.name = formula.getName();
			stringRepresentation = name;
			this.preCondition = new ConditionExtension(formula.getPreCondition());
			this.postCondition = new ConditionExtension(formula.getPostCondition());
			this.proven = formula.isProven();
			this.statement = EcoreUtil.copy(formula.getStatement());
			this.compositionTechnique = formula.getCompositionTechnique();
		}
	}
}
