package de.tu_bs.cs.isf.cbc.tool.features;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariable;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables;
import de.tu_bs.cs.isf.cbc.cbcmodel.Method;
import de.tu_bs.cs.isf.cbc.util.ListParser;
import de.tu_bs.cs.isf.cbc.util.ProveJavaWithKey;
import de.tu_bs.cs.isf.cbc.util.ProveWithKey;
import de.tu_bs.cs.isf.taxonomy.graphiti.features.MyInputDialog;
import de.tu_bs.cs.isf.toolkit.support.compare.CompareMethodBodies;

public class AddGlobalVariablesForBlock extends AbstractCustomFeature {
	
	/**
	 * boolean that indicate if something changes
	 */
    private boolean hasDoneChanges = false;
    
    /**
     * Constructor of the class
     * @param fp	The FeatureProvider
     */
    public AddGlobalVariablesForBlock(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Generate Java Global Variables";
    }
 
    @Override
    public String getDescription() {
        return "Generate Java Global Variables for Blocks";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof JavaVariables) {
                ret = true;
            }
        }
        return ret;
    }
 
    @Override
    public void execute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof JavaVariables) {
            	JavaVariables variables = (JavaVariables) bo;
            	String ws = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
            	URI uri = URI.createFileURI(ws + getDiagram().eResource().getURI()
            			.trimSegments(1).toPlatformString(true)+ "/");
            	System.out.println("ws is " + uri.path());
        		ProveJavaWithKey.createJavaGlobalVariables(ListParser.getListStringFromListVariables(variables.getVariables()), uri, false);
            }
        }
    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
    
    /**
     * Helper method that asks for a String as input
     * @param dialogTitle	The title of the dialog
     * @param dialogMessage	A message inside the dialog
     * @param initialValue	The current code of the Method
     * @return	The new code of the Method
     */
    public static String askString(String dialogTitle, String dialogMessage, String initialValue) {
		String ret = null;
		Shell shell = getShell();
		if (initialValue == null) {
			initialValue = "\n\n\n\n";
		}
		MyInputDialog inputDialog = new MyInputDialog(shell, dialogTitle, dialogMessage, initialValue, null);
		int retDialog = inputDialog.open();
		if (retDialog == Window.OK) {
			ret = inputDialog.getValue();
		}
		return ret;
	}
    
    /**
	 * Returns the currently active Shell.
	 * 
	 * @return The currently active Shell.
	 */
	private static Shell getShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
}