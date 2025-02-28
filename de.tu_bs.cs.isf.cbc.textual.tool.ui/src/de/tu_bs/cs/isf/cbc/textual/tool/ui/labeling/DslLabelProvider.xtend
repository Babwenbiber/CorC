/*
 * generated by Xtext 2.10.0
 */
package de.tu_bs.cs.isf.cbc.textual.tool.ui.labeling

import com.google.inject.Inject
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula
import de.tu_bs.cs.isf.cbc.cbcmodel.CompositionStatement
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition
import de.tu_bs.cs.isf.cbc.cbcmodel.SelectionStatement
import de.tu_bs.cs.isf.cbc.cbcmodel.SmallRepetitionStatement
import de.tu_bs.cs.isf.cbc.cbcmodel.Variant
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.AbstractStatementImpl
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.CompositionStatementImpl
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.SelectionStatementImpl
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.SmallRepetitionStatementImpl
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.MethodStatementImpl
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class DslLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Labels and icons can be computed like this:
	
	def text(Condition condition) {
		//TODO:
		if (condition.eContainer instanceof SmallRepetitionStatement) {
			var statement = condition.eContainer as SmallRepetitionStatement
			if (statement.invariant.equals(condition)) {
				'Invariant: ' + new ConditionExtension(condition).stringRepresentation
			} else if (statement.guard.equals(condition)) {
				'Guard: ' + condition.name
			}
		} else if (condition.eContainer instanceof CompositionStatement) {
			var statement = condition.eContainer as CompositionStatement
			if (statement.intermediateCondition.equals(condition)) {
				'Intm: ' + condition.name
			}
		} else if (condition.eContainer instanceof SelectionStatement) {
			var statement = condition.eContainer as SelectionStatement
			if (statement.guards.contains(condition)) {
				var int i = statement.guards.indexOf(condition)
				'Guard' + i +  ': ' + condition.name
			}
		} else if (condition.eContainer instanceof CbCFormula) {
			var formula = condition.eContainer as CbCFormula
			if (formula.preCondition.equals(condition)) {
				'Pre: ' + condition.name
			} else if (formula.postCondition.equals(condition)) {
				'Post: ' + condition.name
			}
		} 
	}
	
	def text(Variant variant) {
		'variant: ' + variant.name
	}
	
	def text(SmallRepetitionStatementImpl std) {
		'Repetition Statement' 
	}
	
	def text(CompositionStatementImpl std) {
		'Composition Statement' 
	}
	
	def text(SelectionStatementImpl std) {
		'Selection Statement' 
	}
	
	def text(MethodStatementImpl std) {
		'MethodStatement: ' + std.name 
	}
	
	def text(AbstractStatementImpl std) {
		'Statement: ' + std.name 
	}
	
	def text(CbCFormula formula) {
		'Formula: ' + formula.name 
	}
//
//	def image(Greeting ele) {
//		'Greeting.gif'
//	}
}
