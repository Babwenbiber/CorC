/**
 * generated by Xtext 2.10.0
 */
package de.tu_bs.cs.isf.cbc.textual.tool.ui.labeling;

import com.google.inject.Inject;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.Variant;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.AbstractStatementImpl;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.CompositionStatementImpl;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.MethodStatementImpl;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.SelectionStatementImpl;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.SmallRepetitionStatementImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
@SuppressWarnings("all")
public class DslLabelProvider extends DefaultEObjectLabelProvider {
  @Inject
  public DslLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public Object text(final Condition condition) {
    return null;
  }
  
  public String text(final Variant variant) {
    String _name = variant.getName();
    return ("variant: " + _name);
  }
  
  public String text(final SmallRepetitionStatementImpl std) {
    return "Repetition Statement";
  }
  
  public String text(final CompositionStatementImpl std) {
    return "Composition Statement";
  }
  
  public String text(final SelectionStatementImpl std) {
    return "Selection Statement";
  }
  
  public String text(final MethodStatementImpl std) {
    String _name = std.getName();
    return ("MethodStatement: " + _name);
  }
  
  public String text(final AbstractStatementImpl std) {
    String _name = std.getName();
    return ("Statement: " + _name);
  }
  
  public String text(final CbCFormula formula) {
    String _name = formula.getName();
    return ("Formula: " + _name);
  }
}
