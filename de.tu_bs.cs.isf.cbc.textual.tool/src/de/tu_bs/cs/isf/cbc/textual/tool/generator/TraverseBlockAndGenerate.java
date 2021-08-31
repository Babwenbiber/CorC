package de.tu_bs.cs.isf.cbc.textual.tool.generator;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.BlockStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.GlobalConditions;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables;
import de.tu_bs.cs.isf.cbc.cbcmodel.Renaming;
import de.tu_bs.cs.isf.cbc.cbcmodel.singleton.CbCFormulaSingleton;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension;
import de.tu_bs.cs.isf.cbc.util.FileUtil;
import de.tu_bs.cs.isf.cbc.util.HashTable;
import de.tu_bs.cs.isf.cbc.util.ListParser;
import de.tu_bs.cs.isf.cbc.util.ProveJavaWithKey;

public class TraverseBlockAndGenerate extends TraverseFormulaAndGenerate {
	private BlockStatement block;

	TraverseBlockAndGenerate(JavaVariables vars, GlobalConditions conds, Renaming renaming, URI uri, CbCFormula formula,
			Resource resource) {
		super(vars, conds, renaming, uri, formula, resource);
	}
	
	TraverseBlockAndGenerate(URI uri, BlockStatement block,
			Resource resource) {
		super(null, null, null, uri, null, resource);
		this.formula = factory.createCbCFormula();
		CbCFormulaSingleton.init(formula);
		this.vars = factory.createJavaVariables(); 
		String ws = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		this.uri = URI.createFileURI(ws + uri.trimSegments(1).toPlatformString(true)+ "/");
		System.out.println("lessgo Traverse BLOCK ws " + ws + " " + uri.path());

		this.parseFormula = false;
		this.block = block;
	}
	
	public BlockStatement traverseBlockAndGenerate() {	
		castStatementAndTraverse(block);
		
//		String location =  FileUtil.getProject(uri).getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		System.out.println("Uri is  still " + uri.path());

		
		return block;
	}

}
