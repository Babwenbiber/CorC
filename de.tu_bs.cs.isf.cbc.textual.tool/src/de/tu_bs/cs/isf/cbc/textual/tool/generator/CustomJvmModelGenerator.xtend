package de.tu_bs.cs.isf.cbc.textual.tool.generator;

import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCProblem
import de.tu_bs.cs.isf.cbc.cbcmodel.GlobalConditions
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables
import de.tu_bs.cs.isf.cbc.cbcmodel.Renaming
import java.io.IOException
import java.util.Collections
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess

class CustomJvmModelGenerator implements IGenerator{

	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		System.out.println("lessgo doGenerate1");
		
		var JavaVariables vars = null
		var GlobalConditions conds = null
		var Renaming renaming = null
		if (resource.allContents.filter(JavaVariables).hasNext) {
			vars = resource.allContents.filter(JavaVariables).next
		}
		if (resource.allContents.filter(GlobalConditions).hasNext) {
			conds = resource.allContents.filter(GlobalConditions).next
		}
		if (resource.allContents.filter(Renaming).hasNext) {
			renaming = resource.allContents.filter(Renaming).next
		}
		if (!resource.allContents.filter(CbCFormula).hasNext) {
			return
		}		
		var formula = resource.allContents.filter(CbCFormula).next;
		val TraverseFormulaAndGenerate traverser = new TraverseFormulaAndGenerate(vars, conds, renaming, resource.URI, formula, resource)
		formula = traverser.traverseFormulaAndGenerate()
		
		val ResourceSet rs = new ResourceSetImpl();
		val String workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		var URI uri = resource.URI;
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("cbcmodel");
		val Resource r = rs.createResource(URI.createFileURI(workspace + uri.toPlatformString(true)));
		r.getContents().addAll(resource.contents);
		val problem = r.contents.get(0) as CbCProblem
		problem.cbcformula = formula;
		try {
			r.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
