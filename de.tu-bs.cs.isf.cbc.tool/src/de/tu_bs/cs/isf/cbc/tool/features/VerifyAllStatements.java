package de.tu_bs.cs.isf.cbc.tool.features;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.ui.editor.XtextEditor;
import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.BlockStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.Composition3Statement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CompositionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.GlobalConditions;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables;
import de.tu_bs.cs.isf.cbc.cbcmodel.ProductVariant;
import de.tu_bs.cs.isf.cbc.cbcmodel.Renaming;
import de.tu_bs.cs.isf.cbc.cbcmodel.RepetitionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SelectionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SmallRepetitionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.VariableKind;
import de.tu_bs.cs.isf.cbc.cbcmodel.Variant;
import de.tu_bs.cs.isf.cbc.tool.helper.StringParser;
import de.tu_bs.cs.isf.cbc.util.Console;
import de.tu_bs.cs.isf.cbc.util.ConstructCodeBlock;
import de.tu_bs.cs.isf.cbc.util.FilenamePrefix;
import de.tu_bs.cs.isf.cbc.util.ListParser;
import de.tu_bs.cs.isf.cbc.util.ProveJavaWithKey;
import de.tu_bs.cs.isf.cbc.util.ProveWithKey;
import de.tu_bs.cs.isf.taxonomy.graphiti.features.MyAbstractAsynchronousCustomFeature;


/**
 * Class that changes the abstract value of algorithms
 * @author Tobias
 *
 */
public class VerifyAllStatements extends MyAbstractAsynchronousCustomFeature {
	
    
    /**
     * Constructor of the class
     * @param fp	The FeatureProvider
     */
    public VerifyAllStatements(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Verify All Statements";
    }
 
    @Override
    public String getDescription() {
        return "Verify all of the statements.";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        return true;
    }
 
    @Override
    public void execute(ICustomContext context, IProgressMonitor monitor) {
    	String ws = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
    	URI uri = URI.createFileURI(ws + getDiagram().eResource().getURI()
    			.trimSegments(1).toPlatformString(true)+ "/");
    	JavaVariables vars = null;
		Renaming renaming = null;
		CbCFormula formula = null;
		GlobalConditions conds = null;
		for (Shape shape : getDiagram().getChildren()) {
			Object obj = getBusinessObjectForPictogramElement(shape);
			if (obj instanceof JavaVariables) {
				vars = (JavaVariables) obj;
			} else if (obj instanceof Renaming) {
				renaming = (Renaming) obj;
			} else if (obj instanceof CbCFormula) {
				formula = (CbCFormula) obj;
			} else if (obj instanceof GlobalConditions) {
				conds = (GlobalConditions) obj;
			}
		}
		AbstractStatement statement = formula.getStatement();
		boolean prove = false;
		prove = proveChildStatement(statement.getRefinement(), vars, conds, renaming, uri, null);	
		if (prove) {
			statement.setProven(true);
		} else {
			statement.setProven(false);
		}
		Console.println("All statements verified");
    }
    
    
    private static boolean proveChildStatement(AbstractStatement statement, JavaVariables vars, GlobalConditions conds, Renaming renaming, URI uri, IProgressMonitor monitor) {
		boolean prove = false;
		 if (statement instanceof SmallRepetitionStatement) {
			prove = proveSmallReptitionStatement(statement, vars, conds, renaming, uri, monitor);
		 } else if (statement instanceof CompositionStatement) {
			prove = proveCompositionStatement(statement, vars, conds, renaming, uri, monitor);
		} else if (statement instanceof BlockStatement) {
			prove = proveBlockStatement(statement, vars, conds, renaming, uri, monitor);
		} else if (statement instanceof Composition3Statement) {
			prove = proveComposition3Statement(statement, vars, conds, renaming, uri, monitor);
		} else if (statement instanceof SelectionStatement) {
			prove = proveSelectionStatement(statement, vars, conds, renaming, uri, monitor);
		} else if (statement instanceof RepetitionStatement) {
			prove = proveRepetitionStatement(statement, vars, conds, renaming, uri, monitor);
		} else if (statement instanceof AbstractStatement) {
			prove = proveAbstractStatement(statement, vars, conds, renaming, uri, monitor);
		}
		return prove;
	}
    
    private static boolean proveCompositionStatement(AbstractStatement statement, JavaVariables vars, GlobalConditions conds, Renaming renaming, URI uri, IProgressMonitor monitor) {
    	boolean prove1, prove2 = false;
    	CompositionStatement compositionStatement = (CompositionStatement) statement;
    	if (compositionStatement.getFirstStatement().getRefinement() != null) {
    		prove1 = proveChildStatement(compositionStatement.getFirstStatement().getRefinement(), vars, conds, renaming, uri, monitor);
    	} else {
    		prove1 = proveChildStatement(compositionStatement.getFirstStatement(), vars, conds, renaming, uri, monitor);
    	}
    	if (compositionStatement.getSecondStatement().getRefinement() != null) {
    		prove2 = proveChildStatement(compositionStatement.getSecondStatement().getRefinement(), vars, conds, renaming, uri, monitor);
    	} else {
    		prove2 = proveChildStatement(compositionStatement.getSecondStatement(), vars, conds, renaming, uri, monitor);
    	}
    	if (prove1 && prove2 && true)  {
    		statement.setProven(true);
    	} else {
    		statement.setProven(false);
    	}
		return (prove1 && prove2 && true);
    }
    
    private static boolean proveComposition3Statement(AbstractStatement statement, JavaVariables vars, GlobalConditions conds, Renaming renaming, URI uri, IProgressMonitor monitor) {
    	boolean prove1, prove2, prove3 = false;
    	Composition3Statement compositionStatement = (Composition3Statement) statement;
    	if (compositionStatement.getFirstStatement().getRefinement() != null) {
    		prove1 = proveChildStatement(compositionStatement.getFirstStatement().getRefinement(), vars, conds, renaming, uri, monitor);
    	} else {
    		prove1 = proveChildStatement(compositionStatement.getFirstStatement(), vars, conds, renaming, uri, monitor);
    	}
    	if (compositionStatement.getSecondStatement().getRefinement() != null) {
    		prove2 = proveChildStatement(compositionStatement.getSecondStatement().getRefinement(), vars, conds, renaming, uri, monitor);
    	} else {
    		prove2 = proveChildStatement(compositionStatement.getSecondStatement(), vars, conds, renaming, uri, null);
    	}
    	if (compositionStatement.getThirdStatement().getRefinement() != null) {
    		prove3 = proveChildStatement(compositionStatement.getThirdStatement().getRefinement(), vars, conds, renaming, uri, monitor);
    	} else {
    		prove3 = proveChildStatement(compositionStatement.getThirdStatement(), vars, conds, renaming, uri, monitor);
    	}
    	if (prove1 && prove2 && prove3 && true) {
			statement.setProven(true);
		} else {
			statement.setProven(false);
		}
		return (prove1 && prove2 && prove3 && true);
    }

	private static boolean proveAbstractStatement(AbstractStatement statement, JavaVariables vars, GlobalConditions conds, 
			Renaming renaming, URI uri, IProgressMonitor monitor) {
		if (!statement.isProven()) {
			boolean prove = false;
			EList<ProductVariant> variants = null;

			prove = ProveWithKey.proveStatementWithKey(statement, StringParser.getVariableListToStringList(vars),
						StringParser.getConditionListToStringList(conds), renaming, variants, uri, monitor, 
						FilenamePrefix.ABSTRACT_STATEMENT, StringParser.getReturnVariableStringFromVariables(vars.getVariables()));
			if (prove) {
				statement.setProven(true);
			} else {
				statement.setProven(false);
			}
	    	return prove;
		} else {
			Console.println("Abstract statement: " + statement.getName() +" already true");
			return true;
		}
    }
	
    
    private static boolean proveSelectionStatement(AbstractStatement statement, JavaVariables vars, GlobalConditions conds, Renaming renaming, URI uri, IProgressMonitor monitor) {
    	boolean prove = true;
    	SelectionStatement selectionStatement = (SelectionStatement) statement;
		for (AbstractStatement childStatement : selectionStatement.getCommands()) {
			prove = (proveChildStatement(childStatement.getRefinement(), vars, conds, renaming, uri, monitor) && prove && true);
		}
		boolean provePre = selectionStatement.isPreProve();
		if (!(selectionStatement.isProven() && provePre && true)) {
			if (!selectionStatement.isPreProve()) {
				List<String> guards = StringParser.getConditionListToStringList(selectionStatement.getGuards());
				List<String> globalConds = StringParser.getConditionListToStringList(conds);
				List<String> javaVars = StringParser.getVariableListToStringList(vars);
				Condition preCondition = selectionStatement.getParent().getPreCondition();
				provePre = ProveWithKey.provePreSelWithKey(guards, preCondition.getName(), javaVars, globalConds, renaming, uri, null, FilenamePrefix.SELECTION);
				selectionStatement.setPreProve(provePre);
			}
			if (provePre && prove && true) {
				selectionStatement.setProven(true);
			} else {
				selectionStatement.setProven(false);
			}
			return (prove && provePre && true);
    	} else {
    		Console.println("Selection statement already true");
    		return true;
    	}
    }
    
    private static boolean proveBlockStatement(AbstractStatement statement, JavaVariables vars, GlobalConditions conds, Renaming renaming, URI uri, IProgressMonitor monitor) {
    	boolean prove = false;
    	BlockStatement blockStatement = (BlockStatement) statement;   	
    	
		if (!statement.isProven()) {
			ProveJavaWithKey.createJavaGlobalVariables(ListParser.getListStringFromListVariables(vars.getVariables()), uri);
			
			EList<ProductVariant> variants = null;
			prove = ProveWithKey.proveBlockStatementFromVizWithKey(blockStatement,  StringParser.getVariableListToStringList(vars),
					StringParser.getConditionListToStringList(conds), renaming, variants, uri, monitor, FilenamePrefix.JAVA_STATEMENT );
			if (prove) {
				statement.setProven(true);
			} else {
				statement.setProven(false);
			}
			System.out.println("block is proven: " + prove);
	    	return prove;
		} else {
			Console.println("Block statement: " + statement.getName() + " already true");
			return true;
		}
		
//    	if (prove && true)  {
//    		statement.setProven(true);
//    	} else {
//    		statement.setProven(false);
//    	}
//		return (prove && true);
    }

	private static boolean proveRepetitionStatement(AbstractStatement statement, JavaVariables vars, GlobalConditions conds, Renaming renaming, URI uri, IProgressMonitor monitor) {
		boolean prove = true;
		boolean provePre, provePost, proveVar = false;
		RepetitionStatement repStatement = (RepetitionStatement) statement;
		if (repStatement.getLoopStatement().getRefinement() != null) {
			prove = (proveChildStatement(repStatement.getLoopStatement().getRefinement(), vars, conds, renaming, uri, monitor) && true);
		}
		if (repStatement.getStartStatement().getRefinement() != null) {
			prove = (proveChildStatement(repStatement.getStartStatement().getRefinement(), vars, conds, renaming, uri, monitor) && prove && true);
		}
		if (repStatement.getEndStatement().getRefinement() != null) {
			prove = (proveChildStatement(repStatement.getEndStatement().getRefinement(), vars, conds, renaming, uri, monitor) && prove && true);
		}
		if (!(repStatement.isVariantProven() && repStatement.isProven()) && true) {
			String invariant = repStatement.getInvariant().getName();
			String preCondition = repStatement.getPreCondition().getName();
			String guard = repStatement.getGuard().getName();
			String postCondition = repStatement.getPostCondition().getName();
			String code = ConstructCodeBlock.constructCodeBlockAndVerify(statement);
			Variant variant = repStatement.getVariant();
			provePre = ProveWithKey.provePreWithKey(invariant, preCondition,  StringParser.getVariableListToStringList(vars),
					StringParser.getConditionListToStringList(conds), renaming, uri, monitor, FilenamePrefix.REPETITION);
			provePost = ProveWithKey.provePostWithKey(invariant, guard, postCondition,  StringParser.getVariableListToStringList(vars),
					StringParser.getConditionListToStringList(conds), renaming, uri, monitor, FilenamePrefix.REPETITION);
			proveVar = ProveWithKey.proveVariant2WithKey(code, invariant, guard, variant.getName(),  StringParser.getVariableListToStringList(vars),
					StringParser.getConditionListToStringList(conds), renaming, uri, monitor, FilenamePrefix.REPETITION);
			repStatement.setVariantProven(proveVar);
			if (prove && provePre && provePost && proveVar && true) {
				statement.setProven(true);
			} else {
				statement.setProven(false);
			}	
	    	return (provePre && provePost && proveVar && true);
		} else {
			repStatement.setVariantProven(true);
    		Console.println("Repetition statement already true");
    		return true;
		}
    }
	
	private static boolean proveSmallReptitionStatement(AbstractStatement statement, JavaVariables vars, GlobalConditions conds, Renaming renaming, URI uri, IProgressMonitor monitor) {
		SmallRepetitionStatement repStatement = (SmallRepetitionStatement) statement;
		boolean prove = true;
		if (repStatement.getLoopStatement().getRefinement() != null) {
			prove = (proveChildStatement(repStatement.getLoopStatement().getRefinement(), vars, conds, renaming, uri, null) && prove && true);
		}
		boolean provePre = repStatement.isPreProven();
		boolean provePost = repStatement.isPostProven();
		boolean proveVar = repStatement.isVariantProven();
		if (!(repStatement.isProven() && provePre && provePost && proveVar && true)) {
			Condition invariant = repStatement.getInvariant();
			Condition preCondition = repStatement.getParent().getPreCondition();
			Condition guard = repStatement.getGuard();
			Condition postCondition = repStatement.getParent().getPostCondition();
			String code = ConstructCodeBlock.constructCodeBlockAndVerify(statement);
			Variant variant = repStatement.getVariant();
			if (!provePre) {
				provePre = ProveWithKey.provePreWithKey(invariant.getName(), preCondition.getName(),  StringParser.getVariableListToStringList(vars),
						StringParser.getConditionListToStringList(conds), renaming, uri, monitor,FilenamePrefix.REPETITION);
				repStatement.setPreProven(provePre);
			}
			if (!provePost) {
				provePost = ProveWithKey.provePostWithKey(invariant.getName(), guard.getName(), postCondition.getName(),  StringParser.getVariableListToStringList(vars),
						StringParser.getConditionListToStringList(conds),renaming, uri, monitor, FilenamePrefix.REPETITION);
				repStatement.setPostProven(provePost);
			}
			if (!proveVar) {
				proveVar = ProveWithKey.proveVariant2WithKey(code, invariant.getName(), guard.getName(), variant.getName(),  StringParser.getVariableListToStringList(vars),
						StringParser.getConditionListToStringList(conds), renaming, uri, monitor, FilenamePrefix.REPETITION);
				repStatement.setVariantProven(proveVar);	
			}
			if (prove && provePre && provePost && proveVar) {
				repStatement.setProven(true);
			} else {
				repStatement.setProven(false);
			} 
	    	return prove;
		} else {
			repStatement.setPreProven(true);
			repStatement.setPostProven(true);
			repStatement.setVariantProven(true);
    		Console.println("SRepetition statement already true");
			return true;
		}
	}

}