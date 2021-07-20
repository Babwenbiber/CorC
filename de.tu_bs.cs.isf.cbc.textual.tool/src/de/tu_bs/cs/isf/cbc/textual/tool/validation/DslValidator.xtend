/*
 * generated by Xtext 2.10.0
 */
package de.tu_bs.cs.isf.cbc.textual.tool.validation

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula
import de.tu_bs.cs.isf.cbc.cbcmodel.CbcmodelPackage
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition
import de.tu_bs.cs.isf.cbc.cbcmodel.SelectionStatement
import de.tu_bs.cs.isf.cbc.cbcmodel.SmallRepetitionStatement
import de.tu_bs.cs.isf.cbc.util.ProveWithKey
import de.tu_bs.cs.isf.toolkit.support.compare.CompareMethodBodies
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.AbstractStatementImpl
import de.tu_bs.cs.isf.cbc.cbcmodel.ReturnStatement
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.ReturnStatementImpl
import de.tu_bs.cs.isf.cbc.cbcmodel.MethodStatement
import de.tu_bs.cs.isf.cbc.cbcmodel.SkipStatement
import de.tu_bs.cs.isf.cbc.cbcmodel.StrengthWeakStatement
import de.tu_bs.cs.isf.cbc.util.FilenamePrefix
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class DslValidator extends AbstractDslValidator {
	
	public static val INVALID_NAME = 'invalidName'
	public static val NOT_PROVED = 'notProved'

	@Check
	def checkSyntaxOfStatement(AbstractStatement statement) {
		if (statement.class.equals(AbstractStatementImpl)) {
			if (statement.name !== null && !statement.name.isEmpty) {
				if (!CompareMethodBodies.readAndTestMethodBodyWithJaMoPP2(statement.name)) {
					warning('Statement has not the correct syntax.', 
						CbcmodelPackage.Literals.ABSTRACT_STATEMENT__NAME,
						INVALID_NAME)
				}
			}
		}
	}
	
	@Check
	def checkSyntaxOfReturnStatement(ReturnStatement statement) {
		if (statement.class.equals(ReturnStatementImpl)) {
			if (statement.name !== null && !statement.name.isEmpty) {
				if (!CompareMethodBodies.readAndTestMethodBodyWithJaMoPP2(statement.name)) {
					warning('Statement has not the correct syntax.', 
						CbcmodelPackage.Literals.ABSTRACT_STATEMENT__NAME,
						INVALID_NAME)
				}
			}
		}
	}
	
	@Check
	def checkSyntaxOfCondition(Condition condition) {
		if (condition.condition !== null) {
			val cond = new ConditionExtension(condition)
			if (!cond.stringRepresentation.contains("forall") && !cond.stringRepresentation.contains("exists")) {
				if (!CompareMethodBodies.readAndTestAssertWithJaMoPP(cond.stringRepresentation.replaceAll("->", "&"))) {
					warning('Condition has not the correct syntax.', 
						CbcmodelPackage.Literals.CONDITION__NAME,
						INVALID_NAME)
				}
			}
		}
	}
	
	@Check(CheckType.EXPENSIVE)
	def checkProveOfStatement(AbstractStatement statement) {
		if (statement.class.equals(AbstractStatementImpl)) {
			var formula = statement.eResource.allContents.filter(CbCFormula).next;
			var TraverseFormula traverser = new TraverseFormula();
			traverser.traverseFormula(formula, statement);
			var int numberFile = traverser.foundFile;
			val boolean closed = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile, FilenamePrefix.STATEMENT);
			if (!closed) {
				info("Statement is not proved.", 
						CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN,
						NOT_PROVED);
			}
		}
	}
	
	@Check(CheckType.EXPENSIVE)
	def checkProveOfReturnStatement(ReturnStatement statement) {
		var formula = statement.eResource.allContents.filter(CbCFormula).next;
		var TraverseFormula traverser = new TraverseFormula();
		traverser.traverseFormula(formula, statement);
		var int numberFile = traverser.foundFile;
		val boolean closed = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile, FilenamePrefix.RETURN);
		if (!closed) {
			info("ReturnStatement is not proved.", 
					CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN,
					NOT_PROVED);
		}
	}
	
	@Check(CheckType.EXPENSIVE)
	def checkProveOfStrengthWeakStatement(StrengthWeakStatement statement) {
		var formula = statement.eResource.allContents.filter(CbCFormula).next;
		var TraverseFormula traverser = new TraverseFormula();
		traverser.traverseFormula(formula, statement);
		var int numberFile = traverser.foundFile;
		val boolean closedPre = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile, FilenamePrefix.PRE);
		val boolean closedPost = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile + 1, FilenamePrefix.POST);
		val boolean closedStd = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile + 2, FilenamePrefix.STATEMENT);
		if (!closedPre) {
			info("PreCondition of Statement is not proved.", 
					CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN,
					NOT_PROVED);
		}
		if (!closedPost) {
			info("PostCondition of Statement is not proved.", 
					CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN,
					NOT_PROVED);
		}
		if (!closedStd) {
				info("Statement is not proved.", 
						CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN,
						NOT_PROVED);
			}
	}
	
	@Check(CheckType.EXPENSIVE)
	def checkProveOfMethodStatement(MethodStatement statement) {
		var formula = statement.eResource.allContents.filter(CbCFormula).next;
		var TraverseFormula traverser = new TraverseFormula();
		traverser.traverseFormula(formula, statement);
		var int numberFile = traverser.foundFile;
		val boolean closedPre = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile, FilenamePrefix.PRE);
		val boolean closedPost = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile+1, FilenamePrefix.POST);
		if (!closedPre) {
			info("PreCondition of MethodStatement is not proved.", 
					CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN,
					NOT_PROVED);
		}
		if (!closedPost) {
			info("PostCondition of MethodStatement is not proved.", 
					CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN,
					NOT_PROVED);
		}
	}
	
	@Check(CheckType.EXPENSIVE)
	def checkProveOfSkipStatement(SkipStatement statement) {
		var formula = statement.eResource.allContents.filter(CbCFormula).next;
		var TraverseFormula traverser = new TraverseFormula();
		traverser.traverseFormula(formula, statement);
		var int numberFile = traverser.foundFile;
		val boolean closed = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile, FilenamePrefix.SKIP);
		if (!closed) {
			info("SkipStatement is not proved.", 
					CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN,
					NOT_PROVED);
		}
	}
	
	@Check(CheckType.EXPENSIVE)
	def checkProveOfRepetitionStatement(SmallRepetitionStatement statement) {
		var formula = statement.eResource.allContents.filter(CbCFormula).next;
		var TraverseFormula traverser = new TraverseFormula();
		traverser.traverseFormula(formula, statement);
		var int numberFile = traverser.foundFile;
		var boolean closedPre = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile, FilenamePrefix.PRE);
		var boolean closedPost = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile+1, FilenamePrefix.POST);
		var boolean closedVariant = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile+2, FilenamePrefix.VARIANT2);
		if (!closedPre) {
			info('PreCondition of RepetitionStatement is not proved.', 
					CbcmodelPackage.Literals.SMALL_REPETITION_STATEMENT__PRE_PROVEN,
					NOT_PROVED)
		}
		if (!closedPost) {
			info('PostCondition of RepetitionStatement is not proved.', 
					CbcmodelPackage.Literals.SMALL_REPETITION_STATEMENT__POST_PROVEN,
					NOT_PROVED)
		}
		if (!closedVariant) {
			info('Variant of RepetitionStatement is not proved.', 
					CbcmodelPackage.Literals.SMALL_REPETITION_STATEMENT__VARIANT_PROVEN,
					NOT_PROVED)
		}
	}
	
	@Check(CheckType.EXPENSIVE)
	def checkProveOfSelectionStatement(SelectionStatement statement) {
		var formula = statement.eResource.allContents.filter(CbCFormula).next;
		var TraverseFormula traverser = new TraverseFormula();
		traverser.traverseFormula(formula, statement);
		var int numberFile = traverser.foundFile;
		var boolean closed = ProveWithKey.checkFileIsProven(statement.eResource.URI, numberFile, FilenamePrefix.SELECTION);
		if (!closed) {
			info('PreCondition of SelectionStatement is not proved.', 
					CbcmodelPackage.Literals.SELECTION_STATEMENT__PRE_PROVE,
					NOT_PROVED)
					//TODO:  should be CbcmodelPackage.Literals.SELECTION_STATEMENT__PRE_PROVE
		}
	}
}
