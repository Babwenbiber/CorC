package de.tu_bs.cs.isf.cbc.util;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;

import de.tu_bs.cs.isf.cbc.cbcmodel.BlockStatement;

public class ProveJavaWithKey {

	public static File createProveBlockStatementWithKey(BlockStatement statement, List<String> vars, List<String> refinements, URI uri, int numberFile,
			boolean override, String name) {
		return createProveBlockStatementWithKey(statement, vars, refinements, uri, numberFile, override, name, true);
	}
	public static File createProveBlockStatementWithKey(BlockStatement statement, List<String> vars, List<String> refinements, URI uri, int numberFile,
			boolean override, String name, boolean parseFormula) {
		FileUtil.setApplicationUri(uri);
		
		IProject thisProject = FileUtil.getProject(uri);
		String statementBody;
		if (statement.getJavaStatement() != null) {
			statementBody = Parser.replaceVariablesWithGlobalVariables(vars, 
					Parser.replaceBlockStatementsInString(
							Parser.getStringFromObject(statement.getJavaStatement())));
		} else {
			statementBody = "";
		}
				
		String requiresBody = Parser.replaceVariablesWithGlobalVariables(vars,
				Parser.getStringFromObject(statement.getJmlAnnotation().getRequires()));
		String ensuresBody = Parser.replaceVariablesWithGlobalVariables(vars,
				Parser.getStringFromObject(statement.getJmlAnnotation().getEnsures()));
		String packageName;
		if (parseFormula) {
			packageName = "prove" + uri.trimFileExtension().lastSegment();
		} else {
			String[] tmp = uri.path().split("/");
			packageName = tmp[tmp.length - 1];
		}

		String problem = 
			"package "+ packageName + ";\n\n" + 
			"class " + statement.getName() + "{\n" +
			"\t/*@ public normal_behavior\n" +
			"\t  @ requires " + requiresBody + ";\n" +
			"\t  @ ensures " + ensuresBody + ";\n" +
			"\t*/\n" +
			"\tpublic static void getBlock() {\n" +
			"\t\t" + statementBody + "\n\t}\n"+
			"}";
		String location;
		File keyFile;
		if (parseFormula) {
			location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
			keyFile = FileUtil.writeJavaFile(problem, location, numberFile, override, name);
		} else {
			location = uri.trimFileExtension().path();
			keyFile = FileUtil.writeJavaFile(problem, location, override, name + ".java");
		}
		 
		return keyFile;
	}
	
	public static File createJavaGlobalVariables(List<String> vars, URI uri) {
		FileUtil.setApplicationUri(uri);
		String packageName = "prove" + uri.trimFileExtension().lastSegment();

		IProject thisProject = FileUtil.getProject(uri);
		String variables = "";
		for(String v: vars) {
			variables += "\tpublic static " + v +";\n";
		}
		String problem = 
			"package "+ packageName + ";\n\n" + 
			"class GlobalJavaVariables {\n" +
			variables +
			"}";
		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File javaFile = FileUtil.writeToFileFromContent(problem, location, "GlobalJavaVariables.java");
		return javaFile;
	}
}
