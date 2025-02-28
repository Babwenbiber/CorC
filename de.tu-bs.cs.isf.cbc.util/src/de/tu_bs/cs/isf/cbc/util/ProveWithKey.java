package de.tu_bs.cs.isf.cbc.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.key_project.util.collection.ImmutableSet;

import com.google.common.collect.Lists;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.CompositionTechnique;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.ProductVariant;
import de.tu_bs.cs.isf.cbc.cbcmodel.Rename;
import de.tu_bs.cs.isf.cbc.cbcmodel.Renaming;
import de.tu_bs.cs.isf.cbc.cbcmodel.VariableKind;
import de.tu_bs.cs.isf.cbc.cbcmodel.Variant;
import de.uka.ilkd.key.control.KeYEnvironment;
import de.uka.ilkd.key.gui.MainWindow;
import de.uka.ilkd.key.java.abstraction.KeYJavaType;
import de.uka.ilkd.key.logic.op.IObserverFunction;
import de.uka.ilkd.key.proof.ApplyStrategy.IStopCondition;
import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.proof.init.ProofInputException;
import de.uka.ilkd.key.proof.io.ProblemLoaderException;
import de.uka.ilkd.key.settings.ChoiceSettings;
import de.uka.ilkd.key.settings.ProofSettings;
import de.uka.ilkd.key.speclang.Contract;
import de.uka.ilkd.key.strategy.StrategyProperties;
import de.uka.ilkd.key.util.KeYTypeUtil;
import de.uka.ilkd.key.util.MiscTools;
import de.tu_bs.cs.isf.cbc.cbcmodel.singleton.CbCFormulaSingleton;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension;

public class ProveWithKey {
	public static final String REGEX_ORIGINAL = "original";
	public static final String REGEX_RESULT = "\\\\result";

	public static boolean proveStatementWithKey(AbstractStatement statement, List<String> vars, List<String> conds,
			Renaming renaming, EList<ProductVariant> variants, URI uri, IProgressMonitor monitor, String name, String returnVariable) {
		if (variants == null || variants.size() == 0) {
			File location = createProveStatementWithKey(statement, vars, conds, renaming, null, uri, 0, true, name, returnVariable);
			Console.println("Verify Pre -> {Statement} Post");
			return KeyNativeConnection.proveWithKey(location, monitor);
		} else {
			boolean proven = true;
			for (int i = 0; i < variants.size(); i++) {
				ProductVariant variant = (ProductVariant) variants.get(i);
				List<String> refinements = Lists.newArrayList(variant.getRefinementChain().split(","));
				File location = createProveStatementWithKey(statement, vars, conds, renaming, refinements, uri, i,
						true, name, returnVariable);
				Console.println("Verify Pre -> {Statement} Post");

				if (!KeyNativeConnection.proveWithKey(location, monitor)) {
					proven = false;
				}
			}
			return proven;
		}
	}
	
	public static boolean proveJavaStatementWithKey(JavaStatement statement, List<String> vars, List<String> conds,
			Renaming renaming, EList<ProductVariant> variants, URI uri, IProgressMonitor monitor, String name) {
		if (variants == null || variants.size() == 0) {
			File location = createProveJavaStatementWithKey(statement, vars, conds, renaming, null, uri, 0, true, name);
			Console.println("Verify Pre -> {JavaStatement} Post");
			return KeyNativeConnection.proveWithKey(location, monitor);
		} else {
			boolean proven = true;
			for (int i = 0; i < variants.size(); i++) {
				ProductVariant variant = (ProductVariant) variants.get(i);
				List<String> refinements = Lists.newArrayList(variant.getRefinementChain().split(","));
				File location = createProveJavaStatementWithKey(statement, vars, conds, renaming, refinements, uri, i,
						true, name);
				Console.println("Verify Pre -> {JavaStatement} Post");

				if (!KeyNativeConnection.proveWithKey(location, monitor)) {
					proven = false;
				}
			}
			return proven;
		}
	}

	public static boolean proveStatementWithKey2(String className, AbstractStatement statement, List<String> vars, List<String> conds, Renaming renaming, URI uri, IProgressMonitor monitor) {
		File location = createProveStatementWithKey2(className, statement, vars, conds, renaming, uri, 0, true);
		Console.println("Verify Pre -> {Statement} Post");
		return KeyNativeConnection.proveWithKey(location, monitor);
	}

	
	
	public static File createProveStatementWithKey(AbstractStatement statement, List<String> vars,
			List<String> conds, Renaming renaming, List<String> refinements, URI uri, int numberFile,
			boolean override, String name, String returnVariable) {
		FileUtil.setApplicationUri(uri);
		String programVariablesString = "";
		String conditionArraysCreated = "";
		if (vars != null) {
			for (int i=0; i < vars.size(); i++) {
				programVariablesString += vars.get(i) + "; ";
				conditionArraysCreated += getConditionArrayCreated(vars.get(i));
			}
		}

		String globalConditionsString = getGlobalConditionStringFromObject(conds);

		IProject thisProject = FileUtil.getProject(uri);
		CbCFormula formula = CbCFormulaSingleton.getCbCFormula();

		String assignmentString = "";
		
		
		ConditionStrings conditonStrings = new ConditionStrings(statement, formula);
		List<String> modifiables = Parser.getModifiedVarsFromCondition(conditonStrings.post);
		String stat = statement.getName();

		if (refinements != null && conditonStrings.pre.equals(conditonStrings.preFormula)) {
			conditonStrings.pre = composeContractForCbCDiagram(formula.getCompositionTechnique(), refinements, conditonStrings.pre,
					Parser.KEYWORD_JML_PRE, returnVariable, vars);
		}
		if (refinements != null && conditonStrings.post.equals(conditonStrings.postFormula)) {
			modifiables = composeModifiables(refinements, modifiables, formula.getCompositionTechnique(), vars, true);
			conditonStrings.post = composeContractForCbCDiagram(formula.getCompositionTechnique(), refinements, conditonStrings.post,
					Parser.KEYWORD_JML_POST, returnVariable, vars);
		}

		List<String> unmodifiedVariables = Parser.getUnmodifiedVars(modifiables, vars);

		if (conditonStrings.pre == null || conditonStrings.pre.length() == 0) {
			conditonStrings.pre = "true";
		}
		if (conditonStrings.post == null ||conditonStrings.post.length() == 0) {
			conditonStrings.post = "true";
		}

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			conditonStrings.pre = useRenamingCondition(renaming, conditonStrings.pre);
			conditonStrings.post = useRenamingCondition(renaming, conditonStrings.post);
			stat = useRenamingStatement(renaming, stat);
		}

		for (String var : unmodifiedVariables) {
			String varName = var.substring(var.indexOf(" ") + 1);
			programVariablesString += var + "_old; ";
			assignmentString += "||" + varName + "_old:=" + varName;
			conditonStrings.post += "&" + varName + "=" + varName + "_old";
			// if variable is an Array add <created> condition for key
			if (var.contains("[]")) {
				conditionArraysCreated += " & " + varName + "_old.<created>=TRUE";
			}
		}

		if (refinements != null && refinements.size() > 0 && stat.contains("original(")) {
			String[] splittedRefinement = refinements.get(0).split("\\.");
			if (Character.isLowerCase(splittedRefinement[0].charAt(0))) {
				stat = stat.replaceFirst("original", splittedRefinement[0] + ".generated_" + splittedRefinement[1]);
			} else {
				String className = FileUtil.generateComposedClass(thisProject, refinements, vars);
				stat = stat.replaceFirst("original", className + ".generated_" + splittedRefinement[1]);
			}
		}

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {" + programVariablesString + " Heap heapAtPre;}" + "\\problem {(" + conditonStrings.pre + " "
				+ globalConditionsString + conditionArraysCreated + " & wellFormed(heap) ) -> {heapAtPre := heap"
				+ assignmentString + "} \\<{" + stat + "}\\> (" + conditonStrings.post + ")}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = FileUtil.writeFile(problem, location, numberFile, override, name);
		return keyFile;
	}
	
	public static File createProveJavaStatementWithKey(JavaStatement statement, List<String> vars,
			List<String> conds, Renaming renaming, List<String> refinements, URI uri, int numberFile,
			boolean override, String name) {
		FileUtil.setApplicationUri(uri);
		String programVariablesString = "";
		String conditionArraysCreated = "";
		if (vars != null) {
			for (String var : vars) {
				programVariablesString +=  var + "; ";
				// if variable is an Array add <created> condition for key
				conditionArraysCreated += getConditionArrayCreated(var);
			}
		}

		String globalConditionsString = getGlobalConditionStringFromObject(conds);
		
		IProject thisProject = FileUtil.getProject(uri);

		String assignmentString = "";
		
		ConditionStrings conditionStrings = new ConditionStrings(statement);
		List<String> modifiables = Parser.getModifiedVarsFromCondition(conditionStrings.post);

		String stat = Parser.getStringFromObject(statement);
		System.out.println("stat is " + stat);

		List<String> unmodifiedVariables = Parser.getUnmodifiedVars(modifiables, vars);

		if (conditionStrings.pre == null || conditionStrings.pre.length() == 0) {
			conditionStrings.pre = "true";
		}
		if (conditionStrings.post == null || conditionStrings.post.length() == 0) {
			conditionStrings.post = "true";
		}

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			conditionStrings.pre = useRenamingCondition(renaming, conditionStrings.pre);
			conditionStrings.post = useRenamingCondition(renaming, conditionStrings.post);
			stat = useRenamingStatement(renaming, stat);
		}

		for (String var : unmodifiedVariables) {
			String varName = var.substring(var.indexOf(" ") + 1);
			programVariablesString += var + "_old; ";
			assignmentString += "||" + varName + "_old:=" + varName;
			conditionStrings.post += "&" + varName + "=" + varName + "_old";
			// if variable is an Array add <created> condition for key
			if (var.contains("[]")) {
				conditionArraysCreated += " & " + varName + "_old.<created>=TRUE";
			}
		}

		if (refinements != null && refinements.size() > 0 && stat.contains("original(")) {
			String[] splittedRefinement = refinements.get(0).split("\\.");
			if (Character.isLowerCase(splittedRefinement[0].charAt(0))) {
				stat = stat.replaceFirst("original", splittedRefinement[0] + ".generated_" + splittedRefinement[1]);
			} else {
				String className = FileUtil.generateComposedClass(thisProject, refinements, vars);
				stat = stat.replaceFirst("original", className + ".generated_" + splittedRefinement[1]);
			}
		}

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {" + programVariablesString + " Heap heapAtPre;}" + "\\problem {(" + conditionStrings.pre + " "
				+ globalConditionsString + conditionArraysCreated + " & wellFormed(heap) ) -> {heapAtPre := heap"
				+ assignmentString + "} \\<{" + stat + "}\\> (" + conditionStrings.post + ")}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = FileUtil.writeFile(problem, location, numberFile, override, name);
		return keyFile;
	}
	
	
	public static File createProveStatementWithKey2(String className, AbstractStatement statement, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, int numberFile,
			boolean override) {

		String programVariablesString = "";
		String conditionArraysCreated = "";
		if (vars != null) {
			for (String var : vars) {
				programVariablesString += var + "; ";
				conditionArraysCreated += getConditionArrayCreated(var);

			}
		}

		String globalConditionsString = "";
		if (conds != null) {
			for (String cond : conds) {
				String condString = cond;
				if (!condString.isEmpty()) {
					globalConditionsString += " & " + condString;
				}
			}
		}

		IProject thisProject = getProject(uri);

		String assignmentString = "";
		String pre = Parser.getStringFromObject(statement.getPreCondition().getCondition());
		String post = Parser.getStringFromObject(statement.getPostCondition().getCondition());
		String stat = statement.getName();

		if (pre == null || pre.length() == 0) {
			pre = "true";
		}
		if (post == null || post.length() == 0) {
			post = "true";
		}

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			pre = useRenamingCondition(renaming, pre);
			post = useRenamingCondition(renaming, post);
			stat = useRenamingStatement(renaming, stat);
		}

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {" + programVariablesString + " Heap heapAtPre;}" + "\\problem {(" + pre + " "
				+ globalConditionsString + conditionArraysCreated + " & wellFormed(heap) & self != null & self.<inv> & self.<created> = TRUE & " + className +   "::exactInstance(self)=TRUE) -> {heapAtPre := heap"
				+ assignmentString + "} \\<{" + stat + "}\\> (" + post + " & self.<inv>)}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = writeFile(problem, location, numberFile, override);
		return keyFile;
	}
	
	private static String getConditionArrayCreated(String var) {
		if (var.contains("[]")) {
			String varName = var.substring(var.indexOf(" ") + 1);
			return " & " + varName + ".<created>=TRUE";
		}
		return "";
	}
	
	public static IProject getProject(URI uri) {
		uri = uri.trimFragment();
		String uriPath = uri.toPlatformString(true);
		uriPath = uriPath.substring(1, uriPath.length());
		int positionOfSlash = uriPath.indexOf('/') + 1;
		uriPath = uriPath.substring(positionOfSlash, uriPath.length());
		IProject thisProject = null;
		for (IProject p : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if (p.getFile(new Path(uriPath)).exists()) {
				thisProject = p;
			}
		}
//		if (thisProject.getName().contains("Userstudy")) {
//		File diagramFile = new File(thisProject.getLocation() + "/" + uriPath);
//		File diagramFileCopy = new File(thisProject.getLocation() + "/src/saved/ExDia" + proofCounter +  ".diagram");
//		File cbcFile = new File(thisProject.getLocation() + "/" + uriPath.substring(0, uriPath.indexOf(".")) + ".cbcmodel");
//		File cbcFileCopy = new File(thisProject.getLocation() + "/src/saved/ExDia" + proofCounter +  ".cbcmodel");
//		proofCounter++;
//		try {
//			IWorkspace workspace = ResourcesPlugin.getWorkspace();
//			Files.copy(diagramFile.toPath(), diagramFileCopy.toPath(), StandardCopyOption.REPLACE_EXISTING);
//			Files.copy(cbcFile.toPath(), cbcFileCopy.toPath(), StandardCopyOption.REPLACE_EXISTING);  
//			IPath iLocation = Path.fromOSString(diagramFileCopy.getAbsolutePath()); 
//			IFile ifile = workspace.getRoot().getFileForLocation(iLocation);
//			ifile.refreshLocal(0, null);
//			iLocation = Path.fromOSString(cbcFileCopy.getAbsolutePath()); 
//			ifile = workspace.getRoot().getFileForLocation(iLocation);
//			ifile.refreshLocal(0, null);
//		} catch (IOException | CoreException e) {
//			e.printStackTrace();
//		}
//	}
		return thisProject;
	}
	
	private static File writeFile(String problem, String location, int numberFile, boolean override) {
		File keyFile = new File(location + "/prove" + numberFile + ".key");
		File keyHelperFile = new File(location + "/helper.key");
		if (!keyFile.exists() || override) {
			try {
				keyFile.getParentFile().mkdirs();
				keyFile.createNewFile();
				FileWriter fw = new FileWriter(keyFile);
				BufferedWriter bw = new BufferedWriter(fw);
	
				bw.write(problem);
				bw.close();
				
				if (!keyHelperFile.exists()) {
					keyHelperFile.createNewFile();
				}
				IWorkspace workspace = ResourcesPlugin.getWorkspace();    
				IPath iLocation = Path.fromOSString(keyFile.getAbsolutePath()); 
				IFile ifile = workspace.getRoot().getFileForLocation(iLocation);
				ifile.refreshLocal(0, null);
				return keyFile;
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
	
	private static File writeJavaFile(String problem, String location, int numberFile, boolean override) {
		File keyFile = new File(location + "/prove" + numberFile + ".java");
		File keyHelperFile = new File(location + "/helper.key");
		if (!keyFile.exists() || override) {
			try {
				keyFile.getParentFile().mkdirs();
				keyFile.createNewFile();
				FileWriter fw = new FileWriter(keyFile);
				BufferedWriter bw = new BufferedWriter(fw);
	
				bw.write(problem);
				bw.close();
				
				if (!keyHelperFile.exists()) {
					keyHelperFile.createNewFile();
				}
				IWorkspace workspace = ResourcesPlugin.getWorkspace();    
				IPath iLocation = Path.fromOSString(keyFile.getAbsolutePath()); 
				IFile ifile = workspace.getRoot().getFileForLocation(iLocation);
				ifile.refreshLocal(0, null);
				return keyFile;
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}

	private static String getRefinementClass(String string, List<String> vars) {
		if (Character.isLowerCase(string.charAt(0))) {
			for (String var : vars) {
				String[] splitVarNameType = var.split("\\s", 2);

				if (splitVarNameType[1].equals(string)) {
					return splitVarNameType[0];
				}
			}
		}
		return string;
	}

	private static EObject getParentOfStatement(AbstractStatement statement) {
		EObject parent = null;
		if (statement.getParent() != null) {
			parent = statement.getParent().eContainer();
		} else if (statement.eContainer() != null) {
			parent = statement.eContainer();
		}
		return parent;
	}

	static List<String> composeModifiables(List<String> refinements, List<String> modifiables,
			CompositionTechnique compTechnique, List<String> vars, boolean includeFormulaModifiable) {
		if (refinements != null && refinements.size() > 0) {
			for (String refinement : refinements) {
				String[] splittedRefinement = refinement.split("\\.");
				IFile classFile = FileUtil.getClassFile(getRefinementClass(splittedRefinement[0], vars));
				String methodName = splittedRefinement[1];
				if (!includeFormulaModifiable) {
					compTechnique = Parser.getCompositionTechniqueForMethod(classFile, methodName,
							Parser.KEYWORD_JML_MODIFIABLE);
					String modifiableOriginal = Parser.getContentFromJML(classFile, methodName,
							Parser.KEYWORD_JML_MODIFIABLE);
					List<String> modifiableList = new ArrayList<String>();
					if (!modifiableOriginal.equals("")) {
						modifiableList = Parser.getModifiedVarsFromCondition("modifiable(" + modifiableOriginal + ");");
					}
					modifiables = applyCompositionTechniqueOnModifiables(modifiableList, modifiableOriginal,
							compTechnique);
					includeFormulaModifiable = true;
				} else {
					String modifiableOriginal = Parser.getContentFromJML(classFile, methodName,
							Parser.KEYWORD_JML_MODIFIABLE);
					modifiables = applyCompositionTechniqueOnModifiables(modifiables, modifiableOriginal,
							compTechnique);
				}
				if (compTechnique == CompositionTechnique.CONTRACT_OVERRIDING
						|| (compTechnique == CompositionTechnique.EXPLICIT_CONTRACTING
								&& !modifiables.contains(REGEX_ORIGINAL))) {
					return modifiables;
				}

			}
		}
		return modifiables;
	}

	private static List<String> applyCompositionTechniqueOnModifiables(List<String> modifiables,
			String modifiableOriginal, CompositionTechnique compTechnique) {
		switch (compTechnique) {
		case CONTRACT_OVERRIDING:
			// do nothing because original contract is overridden
			break;
		case EXPLICIT_CONTRACTING:
			modifiables.remove(REGEX_ORIGINAL);
			for (String var : modifiableOriginal.split(",")) {
				if (var != "" && !modifiables.contains(var)) {
					modifiables.add(var);
				}
			}
			break;
		case CONJUNCTIVE_CONTRACTING:
			modifiables.addAll(Lists.newArrayList(modifiableOriginal.split(",")));
			break;
		}

		return modifiables;
	}

	private static String composeContractForCbCDiagram(CompositionTechnique compositionTechnique,
			List<String> refinements, String condition, String keyword, String returnVariable,
			List<String> vars) {
		String composedCondition = condition;
		CompositionTechnique compTechnique = compositionTechnique;
		for (int i = 0; i < refinements.size(); i++) {
			String[] splittedRefinement = refinements.get(i).split("\\.");
			IFile classFile = FileUtil.getClassFile(getRefinementClass(splittedRefinement[0], vars));
			String methodName = splittedRefinement[1];
			if (i != 0) {
				compTechnique = Parser.getCompositionTechniqueForMethod(classFile, methodName, keyword);
			}
			if (classFile != null) {
				String conditionOriginal = Parser.getContentFromJML(classFile, methodName, keyword);
				composedCondition = applyCompositionTechnique(composedCondition, conditionOriginal, compTechnique);
				if (compTechnique == CompositionTechnique.CONTRACT_OVERRIDING
						|| (compTechnique == CompositionTechnique.EXPLICIT_CONTRACTING
								&& !composedCondition.contains(REGEX_ORIGINAL))) {
					return resolveResultKeyword(composedCondition, returnVariable);
				}

			}
		}
		return resolveResultKeyword(composedCondition, returnVariable);
	}

	static String composeContractForCalledOriginal(List<String> refinements, String keyword) {
		String[] splittedRefinement = refinements.get(0).split("\\.");
		IFile classFile = FileUtil.getClassFile(splittedRefinement[0]);
		String methodName = splittedRefinement[1];
		String composedCondition = Parser.getContentFromJML(classFile, methodName, keyword);
		CompositionTechnique compositionTechnique = Parser.getCompositionTechniqueForMethod(classFile, methodName,
				keyword);
		for (int i = 1; i < refinements.size(); i++) {
			splittedRefinement = refinements.get(i).split("\\.");
			IFile nextClassFile = FileUtil.getClassFile(splittedRefinement[0]);
			String nextMethodName = splittedRefinement[1];
			if (i != 1) {
				compositionTechnique = Parser.getCompositionTechniqueForMethod(nextClassFile, nextMethodName, keyword);
			}

			if (classFile != null) {
				String conditionOriginal = Parser.getContentFromJML(nextClassFile, nextMethodName, keyword);
				composedCondition = applyCompositionTechnique(composedCondition, conditionOriginal,
						compositionTechnique);
				if (compositionTechnique == CompositionTechnique.CONTRACT_OVERRIDING
						|| (compositionTechnique == CompositionTechnique.EXPLICIT_CONTRACTING
								&& !composedCondition.contains(REGEX_ORIGINAL))) {
					return composedCondition;
				}

			}
		}
		return composedCondition;
	}

	private static String applyCompositionTechnique(String condition, String conditionOriginal,
			CompositionTechnique compositionTechnique) {
		String composedCondition = condition;
		switch (compositionTechnique) {
		case CONTRACT_OVERRIDING:
			composedCondition = condition;
			break;
		case CONJUNCTIVE_CONTRACTING:
			composedCondition = "(" + condition + ") & (" + conditionOriginal + ")";
			break;
		case EXPLICIT_CONTRACTING:
			Pattern pattern = Pattern.compile(REGEX_ORIGINAL);
			Matcher matcher = pattern.matcher(condition);
			composedCondition = matcher.replaceAll(Matcher.quoteReplacement(conditionOriginal));
		}
		return composedCondition;
	}

	private static String resolveResultKeyword(String condition, String returnVariable) {
		if (returnVariable != null) {
			String variableName = returnVariable;
			return Parser.rewriteJMLConditionToKeY(condition.replaceAll(REGEX_RESULT, variableName));
		}

		return Parser.rewriteJMLConditionToKeY(condition);
	}

	private static CbCFormula getCbCFormula(AbstractStatement statement) {
		EObject parent = getParentOfStatement(statement);
		if (parent != null) {
			if (parent instanceof CbCFormula) {
				return (CbCFormula) parent;
			} else {
				return getCbCFormula((AbstractStatement) parent);
			}
		}
		return null;
	}

	

	private static String useRenamingCondition(Renaming renaming, String toRename) {
		for (Rename rename : renaming.getRename()) {
			if (rename.getType().equalsIgnoreCase("boolean")) {
				toRename = toRename.replaceAll(rename.getNewName(), "TRUE=" + rename.getFunction());
			} else {
				toRename = toRename.replaceAll(rename.getNewName(), rename.getFunction());
			}
		}
		return toRename;
	}

	private static String useRenamingCondition(List<Rename> renaming, String toRename) {
		for (Rename rename : renaming) {
			if (rename.getType().equalsIgnoreCase("boolean")) {
				toRename = toRename.replaceAll(rename.getNewName(), "TRUE=" + rename.getFunction());
			} else {
				toRename = toRename.replaceAll(rename.getNewName(), rename.getFunction());
			}
		}
		return toRename;
	}

	private static String useRenamingCondition(de.tu_bs.cs.isf.taxonomy.model.taxonomy.Renaming renaming,
			String toRename) {
		for (de.tu_bs.cs.isf.taxonomy.model.taxonomy.Rename rename : renaming.getRenames()) {
			if (rename.getType().equalsIgnoreCase("boolean")) {
				toRename = toRename.replaceAll(rename.getNewName(), "TRUE=" + rename.getFunction());
			} else {
				toRename = toRename.replaceAll(rename.getNewName(), rename.getFunction());
			}
		}
		return toRename;
	}

	private static String useRenamingStatement(Renaming renaming, String toRename) {
		for (Rename rename : renaming.getRename()) {
			toRename = toRename.replaceAll(rename.getNewName(), rename.getFunction());
		}
		return toRename;
	}

	public static boolean provePreWithKey(String invariant, String preCondition, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, IProgressMonitor monitor, String name) {
		File location = createProvePreWithKey(invariant, preCondition, vars, conds, renaming, uri, 0, true, name);
		Console.println("Verify Pre -> Invariant");
		return KeyNativeConnection.proveWithKey(location, monitor);
	}

	public static boolean provePostWithKey(String invariant, String guard, String postCondition,
			List<String> vars, List<String> conds, Renaming renaming, URI uri, IProgressMonitor monitor, String name) {
		File location = createProvePostWithKey(invariant, guard, postCondition, vars, conds, renaming, uri, 0, true, name);
		Console.println("Verify (Invariant & !Guard) -> Post");
		return KeyNativeConnection.proveWithKey(location, monitor);
	}
	

	public static File createProvePostWithKey(String invariant, String guard, String postCondition,
			List<String> vars, List<String> conds, Renaming renaming, URI uri, int numberFile, boolean override, String name) {

		String programVariablesString = getProgramVariableString(vars);


		String globalConditionsString = getGlobalConditionStringFromObject(conds);

		IProject thisProject = FileUtil.getProject(uri);

		String postString = Parser.getConditionFromCondition(postCondition);
		String guardString = guard;
		String invariantString = invariant;

		if (postString == null || postString.length() == 0) {
			postString = "true";
		}
		if (guardString == null || guardString.length() == 0) {
			guardString = "true";
		}
		if (invariantString == null || invariantString.length() == 0) {
			invariantString = "true";
		}

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			postString = useRenamingCondition(renaming, postString);
			invariantString = useRenamingCondition(renaming, invariantString);
		}

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {" + programVariablesString + " Heap heapAtPre;}" + "\\problem {("
				+ invariantString + " & !(" + guardString + ") " + globalConditionsString + ") -> {heapAtPre := heap} ("
				+ postString + ")}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = FileUtil.writeFile(problem, location, numberFile, override, name + FilenamePrefix.POST);
		return keyFile;
	}
	
	public static boolean provePreSelWithKey(List<String> guards, String preCondition, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, IProgressMonitor monitor, String name) {
		File location = createProvePreSelWithKey(guards, preCondition, vars, conds, renaming, uri, 0, true, name);
		Console.println("Verify Pre -> GvGvG...");
		return KeyNativeConnection.proveWithKey(location, monitor);
	}
	
	public static File createProvePreSelWithKey(List<String> guards, String preCondition, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, int numberFile, boolean override, String name) {
		String programVariablesString = getProgramVariableString(vars);


		String globalConditionsString = getGlobalConditionStringFromObject(conds);

		IProject thisProject = FileUtil.getProject(uri);

		String preString = Parser.getConditionFromCondition(preCondition);
		String guardString;
		if (guards != null && guards.get(0) != null) {
			guardString = "((" + guards.get(0) + ")";
			for (int i = 1; i < guards.size(); i++) {
				guardString += " | (" + guards.get(i) + ")";
			}
			guardString += ")";
		} else {
			guardString = "true";
		}

		if (preString == null || preString.length() == 0) {
			preString = "true";
		}

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			preString = useRenamingCondition(renaming, preString);
			guardString = useRenamingCondition(renaming, guardString);
		}

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {" + programVariablesString + "}" + "\\problem {(" + preString
				+ globalConditionsString + ") -> (" + guardString + ")}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = FileUtil.writeFile(problem, location, numberFile, override, name);
		return keyFile;
	}
	


	public static boolean proveVariantWithKey(String code, String invariant, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, IProgressMonitor monitor) {
		File location = createProveVariantWithKey(code, invariant, vars, conds, renaming, uri, 0, true);
		Console.println("Verify Pre -> {WhileStatement} (true)");
		return KeyNativeConnection.proveWithKey(location, monitor);
	}

	public static File createProveVariantWithKey(String code, String invariant, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, int numberFile, boolean override) {
		String programVariablesString = getProgramVariableString(vars);

		String globalConditionsString = getGlobalConditionStringFromObject(conds);

		IProject thisProject = FileUtil.getProject(uri);

		String invariantString = invariant;

		if (invariantString == null || invariantString.length() == 0) {
			invariantString = "true";
		}

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			invariantString = useRenamingCondition(renaming, invariantString);
		}

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {" + programVariablesString + " Heap heapAtPre;}" + "\\problem {("
				+ invariantString + globalConditionsString + ") -> {heapAtPre := heap} \\<{" + code + "}\\> (true)}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = FileUtil.writeFile(problem, location, numberFile, override, FilenamePrefix.VARIANT);
		return keyFile;
	}


	public static boolean proveVariant2WithKey(String code, String invariant, String guard, String variant,
			List<String> vars, List<String> conds, Renaming renaming, URI uri, IProgressMonitor monitor, String name) {
		File location = createProveVariant2WithKey(code, invariant, guard, variant, vars, conds, renaming, uri, 0,
				true, name);
		Console.println("Verify Pre -> {WhileStatement} (variant<variant0 & variant >= 0)");
		return KeyNativeConnection.proveWithKey(location, monitor);
	}
	
	public static File createProveVariant2WithKey(String code, String invariant, String guard, String variant,
			List<String> vars, List<String> conds, Renaming renaming, URI uri, int numberFile, boolean override, String name) {
		String programVariablesString = "";
		if (vars != null) {
			for (String var : vars) {
				programVariablesString += var + "; ";
			}
		}
		programVariablesString += "int variant;";

		String globalConditionsString = getGlobalConditionStringFromObject(conds);
		

		IProject thisProject = FileUtil.getProject(uri);

		String invariantString = invariant;

		if (invariantString == null || invariantString.length() == 0) {
			invariantString = "true";
		}

		String guardString = guard;

		if (guardString == null || guardString.length() == 0) {
			guardString = "true";
		}

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			invariantString = useRenamingCondition(renaming, invariantString);
			guardString = useRenamingCondition(renaming, guardString);
		}

		String variantString = variant;

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {" + programVariablesString + " Heap heapAtPre;}" + "\\problem {("
				+ invariantString + " & " + guardString + globalConditionsString + ") ->{variant := " + variantString
				+ " || heapAtPre := heap} \\<{" + code + "}\\> ((" + variantString + ") <variant & " + variantString
				+ ">=0)}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = FileUtil.writeFile(problem, location, numberFile, override, name);
		return keyFile;
	}

	public static boolean provePreImplPreWithKey(String preParent, String preChild, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, IProgressMonitor monitor) {
		File location = createProvePreImplPreWithKey(preParent, preChild, vars, conds, renaming, uri, 0, true, FilenamePrefix.PRE_IMPL);
		Console.println("Verify PreParent -> PreChild");
		return KeyNativeConnection.proveWithKey(location, monitor);
	}

	public static boolean provePostImplPostWithKey(String postParent, String postChild, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, IProgressMonitor monitor) {
		File location = createProvePostImplPostWithKey(postChild, postParent, vars, conds, renaming, uri, 0, true, FilenamePrefix.POST_IMPL);
		Console.println("Verify PostChild -> PostParent");
		return KeyNativeConnection.proveWithKey(location, monitor);
	}

	public static File createProvePreImplPreWithKey(String preParent, String preChild, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, int numberFile, boolean override, String name) {
		
		return createProvePreWithKey(Parser.getConditionFromCondition(preParent), 
				Parser.getConditionFromCondition(preChild), vars, conds, renaming, uri, numberFile, override, name);
		
	}
	
	public static File createProveRequiresWithKey(String preParent, String requires, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, int numberFile, boolean override, String name) {

		return createProvePreWithKey(Parser.getConditionFromCondition(preParent), requires, vars, conds, renaming, uri, numberFile, override, name);
	}
	
	public static File createProvePreWithKey(String preParent, String preChild, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, int numberFile, boolean override, String name) {
//		String programVariablesString = "";
//		if (vars != null) {
//			for (String var : vars) {
//				programVariablesString += var.getVar().getName() + "; ";
//			}
//		}
		String programVariablesString = "";
		if (vars != null) {
			for (String var : vars) {
				programVariablesString += var + "; ";
			}
		}
		

		String globalConditionsString = getGlobalConditionStringFromObject(conds);

		IProject thisProject = FileUtil.getProject(uri);

		if (preParent == null || preParent.length() == 0) {
			preParent = "true";
		}
		if (preChild == null || preChild.length() == 0) {
			preChild = "true";
		}

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			preParent = useRenamingCondition(renaming, preParent);
			preChild = useRenamingCondition(renaming, preChild);
		}

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {"
				+ programVariablesString + " Heap heapAtPre;}" + "\\problem {(" + preParent + " "
				+ globalConditionsString + ") -> {heapAtPre := heap} (" + preChild + ")}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = FileUtil.writeFile(problem, location, numberFile, override, name );
		return keyFile;
	}

	public static File createProvePostImplPostWithKey(String postParent, String postChild, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, int numberFile, boolean override, String name) {
		
		return createProvePostWithKey(Parser.getConditionFromCondition(postParent), 
				Parser.getConditionFromCondition(postChild), vars, conds, renaming, uri, numberFile, override, name);
		
	}
	
	public static File createProveEnsuresWithKey(String postParent, String ensures, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, int numberFile, boolean override, String name) {

		return createProvePostWithKey(Parser.getConditionFromCondition(postParent), Parser.getConditionFromCondition(ensures), vars, conds, renaming, uri, numberFile, override, name);
	}
	
	public static File createProvePostWithKey(String postParent, String postChild, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, int numberFile, boolean override, String name) {

		String programVariablesString = "";
		if (vars != null) {
			for (String var : vars) {
				programVariablesString += var + "; ";
			}
		}

		String globalConditionsString = getGlobalConditionStringFromObject(conds);

		IProject thisProject = FileUtil.getProject(uri);


		if (postParent == null || postParent.length() == 0) {
			postParent = "true";
		}
		if (postChild == null || postChild.length() == 0) {
			postChild = "true";
		}

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			postParent = useRenamingCondition(renaming, postParent);
			postChild = useRenamingCondition(renaming, postChild);
		}

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {"
				+ programVariablesString + " Heap heapAtPre;}" + "\\problem {(" + postChild + " "
				+ globalConditionsString + ") -> {heapAtPre := heap} (" + postParent + ")}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = FileUtil.writeFile(problem, location, numberFile, override, name );
		return keyFile;
	}
	
	public static boolean provePreImplPreWithKey(String preParent, String preChild,
			de.tu_bs.cs.isf.taxonomy.model.taxonomy.JavaVariables vars,
			de.tu_bs.cs.isf.taxonomy.model.taxonomy.GlobalConditions conds,
			de.tu_bs.cs.isf.taxonomy.model.taxonomy.Renaming renaming, URI uri, IProgressMonitor monitor, String name) {
		File location = createProvePreImplPreWithKey(preParent, preChild, vars, conds, renaming, uri, 0, true, name);
		Console.println("Verify PreParent -> PreChild");
		return KeyNativeConnection.proveWithKey(location, monitor);
	}

	public static boolean provePostImplPostWithKey(String postParent, String postChild,
			de.tu_bs.cs.isf.taxonomy.model.taxonomy.JavaVariables vars,
			de.tu_bs.cs.isf.taxonomy.model.taxonomy.GlobalConditions conds,
			de.tu_bs.cs.isf.taxonomy.model.taxonomy.Renaming renaming, URI uri, IProgressMonitor monitor, String name) {
		File location = createProvePreImplPreWithKey(postChild, postParent, vars, conds, renaming, uri, 0, true, name);
		Console.println("Verify PostChild -> PostParent");
		return KeyNativeConnection.proveWithKey(location, monitor);
	}

	public static File createProvePreImplPreWithKey(String preParent, String preChild,
			de.tu_bs.cs.isf.taxonomy.model.taxonomy.JavaVariables vars,
			de.tu_bs.cs.isf.taxonomy.model.taxonomy.GlobalConditions conds,
			de.tu_bs.cs.isf.taxonomy.model.taxonomy.Renaming renaming, URI uri, int numberFile, boolean override, String name) {

		String programVariablesString = "";
		if (vars != null) {
			for (de.tu_bs.cs.isf.taxonomy.model.taxonomy.JavaVariable var : vars.getVariables()) {
				programVariablesString += var.getName() + "; ";
			}
		}

		String globalConditionsString = "";
		if (conds != null) {
			for (de.tu_bs.cs.isf.taxonomy.model.taxonomy.Condition cond : conds.getConditions()) {
				if (!cond.getName().isEmpty()) {
					globalConditionsString += " & " + cond.getName();
				}
			}
		}

		IProject thisProject = FileUtil.getProject(uri);

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			preParent = useRenamingCondition(renaming, preParent);
			preChild = useRenamingCondition(renaming, preChild);
		}

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {"
				+ programVariablesString + "}" + "\\problem {(" + preParent + " " + globalConditionsString + ") -> ("
				+ preChild + ")}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = FileUtil.writeFile(problem, location, numberFile, override, name);
		return keyFile;
	}

	
	public static boolean checkFileIsProven(URI uri, int numberFile, String name) {
		IProject project = FileUtil.getProject(uri);
		System.out.println("proving file prove" + numberFile + name + ".key");
		File location = new File(project.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment() + "/prove"
				+ numberFile + name + ".key");
		if (location.exists()) {
			try {
				KeYEnvironment<?> env = KeYEnvironment.load(location, null, null, null);
				Proof proof = env.getLoadedProof();
				return proof.openGoals().isEmpty();
			} catch (ProblemLoaderException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static boolean proveMethodFormulaWithKey(String second, String first, List<String> vars,
			List<String> conds, List<Rename> renaming, URI uri, IProgressMonitor monitor, String name) {
		File location = createProveMethodFormulaWithKey(second, first, vars, conds, renaming, uri, 0, true, name);
		Console.println("Verify Condition -> Condition");
		return KeyNativeConnection.proveWithKey(location, monitor);
	}

	public static File createProveMethodFormulaWithKey(String second, String first, List<String> vars,
			List<String> conds, List<Rename> renaming, URI uri, int numberFile, boolean override, String name) {

		String programVariablesString = getProgramVariableString(vars);

		String globalConditionsString = getGlobalConditionStringFromObject(conds);

		IProject thisProject = FileUtil.getProject(uri);

		String firstString = first;
		String secondString = Parser.getConditionFromCondition(second);

		if (firstString == null || firstString.length() == 0) {
			firstString = "true";
		}
		if (secondString == null || secondString.length() == 0) {
			secondString = "true";
		}

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			firstString = useRenamingCondition(renaming, firstString);
			secondString = useRenamingCondition(renaming, secondString);
		}

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {" + programVariablesString + " Heap heapAtPre;}" + "\\problem {(" + firstString
				+ " " + globalConditionsString + ") -> {heapAtPre := heap} (" + secondString + ")}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = FileUtil.writeFile(problem, location, numberFile, override, name);
		return keyFile;
	}

	public static String proveUseWeakestPreWithKey(AbstractStatement statement, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, IProgressMonitor monitor, String name) {
		File location = createProveUseWeakestPreWithKey(statement, vars, conds, renaming, uri, 0, true, name);
		Console.println("Verify Pre -> {Statement} Post");
		return KeyNativeConnection.createWPWithKey(location, monitor);
	}

	private static File createProveUseWeakestPreWithKey(AbstractStatement statement, List<String> vars,
			List<String> conds, Renaming renaming, URI uri, int numberFile, boolean override, String name) {
		String programVariablesString = getProgramVariableString(vars);

		String globalConditionsString = getGlobalConditionStringFromObject(conds);

		IProject thisProject = FileUtil.getProject(uri);

		List<String> modifiableVariables = Parser.getUnmodifiedVars(
				Parser.getModifiedVarsFromCondition(Parser.getStringFromObject(statement.getPostCondition().getCondition())), vars);
		String post = Parser.getConditionFromCondition(Parser.getStringFromObject(statement.getPostCondition().getCondition()));
		String stat = statement.getName();

		if (post == null || post.length() == 0) {
			post = "true";
		}

		if (renaming != null) {
			globalConditionsString = useRenamingCondition(renaming, globalConditionsString);
			post = useRenamingCondition(renaming, post);
			stat = useRenamingStatement(renaming, stat);
		}

		String problem = "\\javaSource \"" + thisProject.getLocation() + "/\";" + "\\include \"helper.key\";"
				+ "\\programVariables {" + programVariablesString + "}" + "\\problem {\\<{" + stat + "}\\> (" + post
				+ ")}";

		String location = thisProject.getLocation() + "/src/prove" + uri.trimFileExtension().lastSegment();
		File keyFile = FileUtil.writeFile(problem, location, numberFile, override, name);
		return keyFile;
	}

	public static String getGlobalConditionStringFromObject(List<String> conds) {
		String globalConditionsString = "";
		if (conds != null) {
			for (String cond : conds) {
				if (!cond.isEmpty()) {
					globalConditionsString += " & " + cond;
				}
			}
		}
		return globalConditionsString;
	}
	


	
	private static String getProgramVariableString(List<String> vars) {
		String programVariablesString = "";
		if (vars != null) {
			for (String v: vars) {
				programVariablesString += v + "; ";
			}
		}
		return programVariablesString;
	}
	
//	private static String getProgramVariableString(List<?> vars) {
//		String programVariablesString = "";
//		if (vars != null) {
//			for (Object v: vars) {
//				if (v instanceof StringExtension)	{
//					programVariablesString += ((StringExtension)v).stringRepresentation + "; ";
//				} else if (v instanceof String){
//					programVariablesString += ((String)v).getName() + "; ";
//				} else {
//					programVariablesString += (String)v + "; ";
//				}
//			}
//		}
//		return programVariablesString;
//
//	}
//	
//	private static List<String> getStringListFromConditionList(EList<Condition> conditions) {
//		List<String> conds = new ArrayList<String>();
//		for(Condition c: conditions) {
//			conds.add(((ConditionExtension)c).stringRepresentation);
//		}
//		return conds;
//	}
//
//	
//	private static List<String> getStringListFromConditionExtensionList(List<String> conditions) {
//		List<String> conds = new ArrayList<String>();
//		for(Condition c: conditions) {
//			conds.add(((ConditionExtension)c).stringRepresentation);
//		}
//		return conds;
//	}
//	
//	private static List<String> getStringListFromStringList(EList<String> variables) {
//		List<String> vars = new ArrayList<String>();
//		for(String c: variables) {
//			vars.add(new StringExtension(c).stringRepresentation);
//		}
//		return vars;
//	}
	
}
