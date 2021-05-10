/**
 * generated by Xtext 2.10.0
 */
package de.tu_bs.cs.isf.cbc.textual.tool.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbcmodelPackage;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.MethodStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.ReturnStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SelectionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SkipStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SmallRepetitionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.StrengthWeakStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.AbstractStatementImpl;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.ReturnStatementImpl;
import de.tu_bs.cs.isf.cbc.textual.tool.validation.AbstractDslValidator;
import de.tu_bs.cs.isf.cbc.textual.tool.validation.TraverseFormula;
import de.tu_bs.cs.isf.cbc.util.ProveWithKey;
import de.tu_bs.cs.isf.toolkit.support.compare.CompareMethodBodies;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class DslValidator extends AbstractDslValidator {
  public static final String INVALID_NAME = "invalidName";
  
  public static final String NOT_PROVED = "notProved";
  
  @Check
  public void checkSyntaxOfStatement(final AbstractStatement statement) {
    boolean _equals = statement.getClass().equals(AbstractStatementImpl.class);
    if (_equals) {
      if (((!Objects.equal(statement.getName(), null)) && (!statement.getName().isEmpty()))) {
        boolean _readAndTestMethodBodyWithJaMoPP2 = CompareMethodBodies.readAndTestMethodBodyWithJaMoPP2(statement.getName());
        boolean _not = (!_readAndTestMethodBodyWithJaMoPP2);
        if (_not) {
          this.warning("Statement has not the correct syntax.", 
            CbcmodelPackage.Literals.ABSTRACT_STATEMENT__NAME, 
            DslValidator.INVALID_NAME);
        }
      }
    }
  }
  
  @Check
  public void checkSyntaxOfReturnStatement(final ReturnStatement statement) {
    boolean _equals = statement.getClass().equals(ReturnStatementImpl.class);
    if (_equals) {
      if (((!Objects.equal(statement.getName(), null)) && (!statement.getName().isEmpty()))) {
        boolean _readAndTestMethodBodyWithJaMoPP2 = CompareMethodBodies.readAndTestMethodBodyWithJaMoPP2(statement.getName());
        boolean _not = (!_readAndTestMethodBodyWithJaMoPP2);
        if (_not) {
          this.warning("Statement has not the correct syntax.", 
            CbcmodelPackage.Literals.ABSTRACT_STATEMENT__NAME, 
            DslValidator.INVALID_NAME);
        }
      }
    }
  }
  
  @Check
  public void checkSyntaxOfCondition(final Condition condition) {
    if (((((!Objects.equal(condition.getName(), null)) && (!condition.getName().isEmpty())) && (!condition.getName().contains("forall"))) && (!condition.getName().contains("exists")))) {
      boolean _readAndTestAssertWithJaMoPP = CompareMethodBodies.readAndTestAssertWithJaMoPP(condition.getName().replaceAll("->", "&"));
      boolean _not = (!_readAndTestAssertWithJaMoPP);
      if (_not) {
        this.warning("Condition has not the correct syntax.", 
          CbcmodelPackage.Literals.CONDITION__NAME, 
          DslValidator.INVALID_NAME);
      }
    }
  }
  
  @Check(CheckType.EXPENSIVE)
  public void checkProveOfStatement(final AbstractStatement statement) {
    boolean _equals = statement.getClass().equals(AbstractStatementImpl.class);
    if (_equals) {
      CbCFormula formula = Iterators.<CbCFormula>filter(statement.eResource().getAllContents(), CbCFormula.class).next();
      TraverseFormula traverser = new TraverseFormula();
      traverser.traverseFormula(formula, statement);
      int numberFile = traverser.foundFile;
      final boolean closed = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), numberFile);
      if ((!closed)) {
        this.info("Statement is not proved.", 
          CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN, 
          DslValidator.NOT_PROVED);
      }
    }
  }
  
  @Check(CheckType.EXPENSIVE)
  public void checkProveOfReturnStatement(final ReturnStatement statement) {
    CbCFormula formula = Iterators.<CbCFormula>filter(statement.eResource().getAllContents(), CbCFormula.class).next();
    TraverseFormula traverser = new TraverseFormula();
    traverser.traverseFormula(formula, statement);
    int numberFile = traverser.foundFile;
    final boolean closed = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), numberFile);
    if ((!closed)) {
      this.info("ReturnStatement is not proved.", 
        CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN, 
        DslValidator.NOT_PROVED);
    }
  }
  
  @Check(CheckType.EXPENSIVE)
  public void checkProveOfStrengthWeakStatement(final StrengthWeakStatement statement) {
    CbCFormula formula = Iterators.<CbCFormula>filter(statement.eResource().getAllContents(), CbCFormula.class).next();
    TraverseFormula traverser = new TraverseFormula();
    traverser.traverseFormula(formula, statement);
    int numberFile = traverser.foundFile;
    final boolean closedPre = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), numberFile);
    final boolean closedPost = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), (numberFile + 1));
    final boolean closedStd = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), (numberFile + 2));
    if ((!closedPre)) {
      this.info("PreCondition of Statement is not proved.", 
        CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN, 
        DslValidator.NOT_PROVED);
    }
    if ((!closedPost)) {
      this.info("PostCondition of Statement is not proved.", 
        CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN, 
        DslValidator.NOT_PROVED);
    }
    if ((!closedStd)) {
      this.info("Statement is not proved.", 
        CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN, 
        DslValidator.NOT_PROVED);
    }
  }
  
  @Check(CheckType.EXPENSIVE)
  public void checkProveOfMethodStatement(final MethodStatement statement) {
    CbCFormula formula = Iterators.<CbCFormula>filter(statement.eResource().getAllContents(), CbCFormula.class).next();
    TraverseFormula traverser = new TraverseFormula();
    traverser.traverseFormula(formula, statement);
    int numberFile = traverser.foundFile;
    final boolean closedPre = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), numberFile);
    final boolean closedPost = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), (numberFile + 1));
    if ((!closedPre)) {
      this.info("PreCondition of MethodStatement is not proved.", 
        CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN, 
        DslValidator.NOT_PROVED);
    }
    if ((!closedPost)) {
      this.info("PostCondition of MethodStatement is not proved.", 
        CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN, 
        DslValidator.NOT_PROVED);
    }
  }
  
  @Check(CheckType.EXPENSIVE)
  public void checkProveOfSkipStatement(final SkipStatement statement) {
    CbCFormula formula = Iterators.<CbCFormula>filter(statement.eResource().getAllContents(), CbCFormula.class).next();
    TraverseFormula traverser = new TraverseFormula();
    traverser.traverseFormula(formula, statement);
    int numberFile = traverser.foundFile;
    final boolean closed = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), numberFile);
    if ((!closed)) {
      this.info("SkipStatement is not proved.", 
        CbcmodelPackage.Literals.ABSTRACT_STATEMENT__PROVEN, 
        DslValidator.NOT_PROVED);
    }
  }
  
  @Check(CheckType.EXPENSIVE)
  public void checkProveOfRepetitionStatement(final SmallRepetitionStatement statement) {
    CbCFormula formula = Iterators.<CbCFormula>filter(statement.eResource().getAllContents(), CbCFormula.class).next();
    TraverseFormula traverser = new TraverseFormula();
    traverser.traverseFormula(formula, statement);
    int numberFile = traverser.foundFile;
    boolean closedPre = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), numberFile);
    boolean closedPost = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), (numberFile + 1));
    boolean closedVariant = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), (numberFile + 2));
    if ((!closedPre)) {
      this.info("PreCondition of RepetitionStatement is not proved.", 
        CbcmodelPackage.Literals.SMALL_REPETITION_STATEMENT__PRE_PROVEN, 
        DslValidator.NOT_PROVED);
    }
    if ((!closedPost)) {
      this.info("PostCondition of RepetitionStatement is not proved.", 
        CbcmodelPackage.Literals.SMALL_REPETITION_STATEMENT__POST_PROVEN, 
        DslValidator.NOT_PROVED);
    }
    if ((!closedVariant)) {
      this.info("Variant of RepetitionStatement is not proved.", 
        CbcmodelPackage.Literals.SMALL_REPETITION_STATEMENT__VARIANT_PROVEN, 
        DslValidator.NOT_PROVED);
    }
  }
  
  @Check(CheckType.EXPENSIVE)
  public void checkProveOfSelectionStatement(final SelectionStatement statement) {
    CbCFormula formula = Iterators.<CbCFormula>filter(statement.eResource().getAllContents(), CbCFormula.class).next();
    TraverseFormula traverser = new TraverseFormula();
    traverser.traverseFormula(formula, statement);
    int numberFile = traverser.foundFile;
    boolean closed = ProveWithKey.checkFileIsProven(statement.eResource().getURI(), numberFile);
    if ((!closed)) {
      this.info("PreCondition of SelectionStatement is not proved.", 
        CbcmodelPackage.Literals.SELECTION_STATEMENT__PRE_PROVE, 
        DslValidator.NOT_PROVED);
    }
  }
}
