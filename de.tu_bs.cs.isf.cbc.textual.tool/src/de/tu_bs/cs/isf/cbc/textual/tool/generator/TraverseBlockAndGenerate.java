package de.tu_bs.cs.isf.cbc.textual.tool.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.BlockStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.GlobalConditions;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariable;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables;
import de.tu_bs.cs.isf.cbc.cbcmodel.Renaming;
import de.tu_bs.cs.isf.cbc.cbcmodel.singleton.CbCFormulaSingleton;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.JavaVariableExtension;
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
		String ws = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		this.uri = URI.createFileURI(ws + uri.trimSegments(1).toPlatformString(true)+ "/");
		System.out.println("lessgo Traverse BLOCK ws " + ws + " " + uri.path());

		this.parseFormula = false;
		this.block = block;
		this.vars = getVariablesFromGlobalVarsFile();
		saveCurrentPath();
	}
	
	
	private void saveCurrentPath() {
		try {
		String str = uri.path();
		String path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + "/context.txt";
	    BufferedWriter writer = new BufferedWriter(new FileWriter(path));
	    writer.write(str);
	    
	    writer.close();
		} catch (IOException e) {
			System.err.println("couldnt save current context " + e.toString());
		}
	}
	
	public BlockStatement traverseBlockAndGenerate() {	
		castStatementAndTraverse(block);
		
//		String location =  FileUtil.getProject(uri).getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		System.out.println("Uri is  still " + uri.path());

		
		return block;
	}

	public JavaVariables getVariablesFromGlobalVarsFile() {
		JavaVariables globalVars = factory.createJavaVariables();
		File varFile = new File(uri.path()+ "GlobalJavaVariables.java");
		if (varFile.exists()) {
			Scanner reader;
			try {
				reader = new Scanner(varFile);
			
			      while (reader.hasNextLine()) {
			        String data = reader.nextLine();
			        if (data.contains("public static")) {
			        	String newVarType = data.split(" ")[2];
			        	String newVarName = data.split(" ")[3].replaceAll(";", "");
				        System.out.println("newVar " +newVarName);
				        globalVars.getVariables().add(new JavaVariableExtension(newVarType, newVarName));
			        }
			      }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("file exists " + varFile.exists());
		return globalVars;
	}
}
