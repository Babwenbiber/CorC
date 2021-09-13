package de.tu_bs.cs.isf.cbc.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.EmfFormatter;
import org.emftext.language.java.statements.impl.ConditionalImpl;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CompositionTechnique;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.JMLExpression;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariable;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.ConditionImpl;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.JMLExpressionExtension;

public class Parser {
	public static final String KEYWORD_JML_PRE = "requires";
	public static final String KEYWORD_JML_POST = "ensures";
	public static final String KEYWORD_JML_MODIFIABLE = "assignable";
	private Map<String, String> variablesToStatements = new HashMap<String, String>();

	public void addVariableStatementPairs(AbstractStatement abstractStatement) throws ParserException {
		String input = abstractStatement.getName().trim();
		if (input.charAt(input.length() - 1) != ';') {
			throw new ParserException("Statement must end with ';'. " + input);
		}
		String[] statements = input.split(";");

		for (String nextStatement : statements) {
			if (nextStatement.contains("=")) {
				String[] nextStatementTokens = nextStatement.split("=");
				String variable = parseVariable(nextStatementTokens[0].trim());
				variablesToStatements.put(variable, nextStatementTokens[1].trim());
			}
		}
	}

	public static String getStringFromVariable(JavaVariable variable) {
		if (variable.getName()!=null && variable.getName()!="") {
			return variable.getName();
		}
		return Parser.getStringFromObject(variable.getType()) + " " + variable.getVar().getName();
	}
	
	public static List<String> findAllVariables(AbstractStatement abstractStatement, JavaVariables vars)
			throws ParserException {
		String input = abstractStatement.getName().trim();
		List<String> variableList = new LinkedList<String>();
		if (input.charAt(input.length() - 1) != ';') {
			throw new ParserException("Statement must end with ';'. " + input);
		}
		String[] statements = input.split(";");

		for (String nextStatement : statements) {
			if (nextStatement.contains("=")) {
				String[] nextStatementTokens = nextStatement.split("=");
				String variable = parseVariable(nextStatementTokens[0].trim());
				variableList.add(variable);
			}
			if (nextStatement.contains(".") && nextStatement.contains("(")) {
				Pattern methodCallPattern = Pattern.compile("\\w+\\.\\w+\\(");
				Matcher matcher = methodCallPattern.matcher(nextStatement);
				while (matcher.find()) {
					String[] nextStatementTokens = matcher.group(0).split("\\.", 2);
					String variableName = nextStatementTokens[0];
					String methodName = nextStatementTokens[1].replaceAll("\\(", "");
					String variableType = getTypeOfVariable(variableName, vars);
					IFile javaFile = FileUtil.getClassFile(variableType);
					if (javaFile != null) {
						String assignablesFromMethodCall = getContentFromJML(javaFile, methodName,
								KEYWORD_JML_MODIFIABLE);
						if (!assignablesFromMethodCall.equals("")) {
							for (String var : assignablesFromMethodCall.split(",")) {
								variableList.add(variableName + "." + var);
							}
						}
					}
				}

			}
		}
		return variableList;

	}

	private static String getTypeOfVariable(String variableName, JavaVariables vars) {
		for (JavaVariable var : vars.getVariables()) {
			if (var.getVar().getName().equals(variableName)) {
				return Parser.getStringFromObject(var.getType());
			}
			
		}
		return null;
	}

	public static String getContentFromJML(IFile javaFile, String methodName, String keyword) {
		if (javaFile != null) {
			List<String> linesOfFile = FileUtil.readFileInList(javaFile.getLocation().toOSString());
			boolean methodFound = false;
			for (int i = linesOfFile.size() - 1; i >= 0; i--) {
				if (!methodFound) {
					if (linesOfFile.get(i).contains(methodName + "(")) {
						methodFound = true;
					}
				} else {
					String currLine = linesOfFile.get(i);
					if (currLine.contains(keyword)) {
						if (currLine.substring(currLine.length() - 1).contains(";")) {
							return currLine.substring(currLine.indexOf(keyword) + keyword.length(), currLine.lastIndexOf(";"));
							//otherwise take all lines until last character is a ";"
						} else {
							while (!linesOfFile.get(i + 1).substring(linesOfFile.get(i + 1).length() - 1).contains(";")) {
								currLine += linesOfFile.get(i + 1);
								i++;
							}
							currLine += linesOfFile.get(i + 1);
							return currLine.substring(currLine.indexOf(keyword) + keyword.length(), currLine.lastIndexOf(";")).trim();
						}
					} else if (currLine.contains("}")) {
						if (keyword == KEYWORD_JML_MODIFIABLE) {
							return "";
						} else {
							return "true";
						}

					}
				}

			}
		}
		return "";

	}

	private static Set<String> parseRightVariables(String statement) {
		Set<String> rightVariables = new HashSet<String>();
		String[] inputTokens = statement.split("[\\+\\-\\*/\\(\\),]");

		for (String inputToken : inputTokens) {
			inputToken = inputToken.trim();

			if (inputToken.matches("\\d+") || inputToken.matches("\\s*")) {
			} else if (inputToken.matches("\\w+.*\\w+")) {
				rightVariables.add(inputToken.split("\\.")[0].trim());
			} else {
				rightVariables.add(inputToken);
			}
		}
		return rightVariables;
	}

	public String destructConditionAndReplace(Condition condition) throws ParserException {
		String input = NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(condition.getCondition()));
		String[] inputTokens = new String[0];
		if (input.contains("&")) {
			input = input.replace("&", "|");
		}
		if (input.contains("|")) {
			inputTokens = input.split("\\|");
		}
		if (!input.contains("&") && !input.contains("|")) {
			inputTokens = new String[] { input };
		}

		for (String nextRelation : inputTokens) {
			String regex = "";
			if (nextRelation.contains("<=")) {
				regex = "<=";
			} else if (nextRelation.contains(">=")) {
				regex = ">=";
			} else if (nextRelation.contains("<")) {
				regex = "<";
			} else if (nextRelation.contains(">")) {
				regex = ">";
			} else if (nextRelation.contains("!=")) {
				regex = "!=";
			} else if (nextRelation.contains("=")) {
				regex = "=";
			} else {
				regex = null;
			}

			if (regex != null) {
				String[] nextRelationTokens = nextRelation.split(regex);

				for (String nextRelationToken : nextRelationTokens) {
					if (nextRelationToken.contains("<") || nextRelationToken.contains(">")
							|| nextRelationToken.contains("=")) {
						throw new ParserException("Only one relation symbol per relation. " + nextRelation);
					}
				}

				if (nextRelationTokens.length > 2) {
					throw new ParserException("Exactly two operands per relation. " + nextRelation);
				}

				for (String nextRelationToken : nextRelationTokens) {
					for (String variable : variablesToStatements.keySet()) {
						int startPosition = -1;
						if (nextRelationToken.equals(variable)) {
							startPosition = input.indexOf(nextRelationToken) + nextRelationToken.indexOf(variable);
						} else if (nextRelationToken.contains(" " + variable + " ")) {
							startPosition = input.indexOf(nextRelationToken)
									+ nextRelationToken.indexOf(" " + variable + " ") + 1;
						} else if (nextRelationToken.contains(" " + variable + ",")) {
							startPosition = input.indexOf(nextRelationToken)
									+ nextRelationToken.indexOf(" " + variable + ",") + 1;
						} else if (nextRelationToken.contains("," + variable + " ")) {
							startPosition = input.indexOf(nextRelationToken)
									+ nextRelationToken.indexOf("," + variable + " ") + 1;
						} else if (nextRelationToken.contains("," + variable + ",")) {
							startPosition = input.indexOf(nextRelationToken)
									+ nextRelationToken.indexOf("," + variable + ",") + 1;
						}
						if (startPosition != -1) {
							int endPosition = startPosition + variable.length();
							input = input.substring(0, startPosition) + variablesToStatements.get(variable)
									+ input.substring(endPosition, input.length());
						}
					}
				}

			} else {
				for (String variable : variablesToStatements.keySet()) {
					int startPosition = -1;
					if (nextRelation.equals(variable)) {
						startPosition = input.indexOf(nextRelation) + nextRelation.indexOf(variable);
					} else if (nextRelation.contains(" " + variable + " ")) {
						startPosition = input.indexOf(nextRelation) + nextRelation.indexOf(" " + variable + " ") + 1;
					} else if (nextRelation.contains(" " + variable + ",")) {
						startPosition = input.indexOf(nextRelation) + nextRelation.indexOf(" " + variable + ",") + 1;
					} else if (nextRelation.contains("," + variable + " ")) {
						startPosition = input.indexOf(nextRelation) + nextRelation.indexOf("," + variable + " ") + 1;
					} else if (nextRelation.contains("," + variable + ",")) {
						startPosition = input.indexOf(nextRelation) + nextRelation.indexOf("," + variable + ",") + 1;
					}
					if (startPosition != -1) {
						int endPosition = startPosition + variable.length();
						input = input.substring(0, startPosition) + variablesToStatements.get(variable)
								+ input.substring(endPosition, input.length());
					}
				}
			}
		}
		return input;
	}

	public static String parseVariable(String input) throws ParserException {
		String[] inputTokens = input.split(" ");
		if (inputTokens.length == 2) {
			return inputTokens[1].trim();
		} else if (inputTokens.length == 1) {
			return inputTokens[0].trim();
		} else {
			throw new ParserException("Variable not in format \"<type> <name>\"." + input);
		}
	}

	public static CompositionTechnique getCompositionTechniqueForMethod(IFile classFile, String methodName,
			String keyword) {
		List<String> linesOfFile = FileUtil.readFileInList(classFile.getLocation().toOSString());
		boolean methodFound = false;
		for (int i = linesOfFile.size() - 1; i >= 0; i--) {
			if (!methodFound) {
				if (linesOfFile.get(i).contains(methodName + "(")) {
					methodFound = true;
				}
			} else {
				String currLine = linesOfFile.get(i);
				if (currLine.contains(keyword)) {
					if (currLine.contains(ProveWithKey.REGEX_ORIGINAL)) {
						return CompositionTechnique.EXPLICIT_CONTRACTING;
					} else if (currLine.contains("conjunctive_contract")) {
						return CompositionTechnique.CONJUNCTIVE_CONTRACTING;
					}
				}
			}

		}
		return CompositionTechnique.CONTRACT_OVERRIDING;
	}

	public static String getConditionFromCondition(String condition) {
		if (condition.contains("modifiable")) {
			String[] splittedCondition = condition.split(";", 2);
			if (splittedCondition.length > 1) {
				return splittedCondition[1].trim();
			}
		}
		return condition;
	}

	public static List<String> getUnmodifiedVars(List<String> modifiedVars, List<String> declaredVariables) {
		List<String> unmodifiedVariables = Lists.newArrayList();
		if (!modifiedVars.contains("\\everything")) {
			for (String var : declaredVariables) {
				String varName = var.split(" ")[1]; //int i becomes i
				if (!modifiedVars.contains(varName)) {
					unmodifiedVariables.add(varName);
				}
			}
		}
		return unmodifiedVariables;
	}

	public static List<String> getModifiedVarsFromCondition(String condition) {
		String variables = null;
		List<String> modifiedVars = Lists.newArrayList();
		if (!condition.contains("modifiable(")) {
			modifiedVars.add("\\everything");
		} else if (condition.contains("modifiable(")) {
			variables = condition.split(";", 2)[0];
			if (variables != null) {
				variables = variables.substring(variables.indexOf("(") + 1, variables.indexOf(")"));
				variables = variables.replace(" ", "");
				variables = variables.replace(System.getProperty("line.separator"), "");
				modifiedVars = Lists.newArrayList(variables.split(","));
			}
		}
		return modifiedVars;
	}

	public static String getModifieableVarsFromCondition(String condition) {
//		String variables = "\\\\everything;";
		String variables = "\\everything";
		if (condition.contains("modifiable(") && condition.split(";").length > 1) {
			variables = condition.split(";")[0];
			if (variables != null) {
				variables = variables.substring(variables.indexOf("(") + 1, variables.indexOf(")"));
				variables = variables.replace(" ", "");
				variables = variables.replace(System.getProperty("line.separator"), "");
			}
		}
		return variables;
	}

	public static String rewriteConditionToJML(String condition) {
		condition = condition.replaceAll("(?<!<|>|!|=)(\\s*=\\s*)(?!<|>|=)", " == ");
//		condition = condition.replaceAll("(?<![!<>])=", "==");
		condition = condition.replaceAll("->", "==>");
		condition = condition.replaceAll("<->", "<==>");
		condition = condition.replaceAll("&", "&&");
		condition = condition.replace("|", "||");
		condition = condition.replaceAll("(?<==\\s?)TRUE", "true");
		condition = condition.replaceAll("(?<==\\s?)FALSE", "false");
		condition = condition.replaceAll("(\\w*)::instance\\((\\w*)\\) = TRUE", "$2 instanceof $1");
		return condition;
	}

	public static String rewriteJMLConditionToKeY(String condition) {

		condition = condition.replaceAll("==>", "->");
		condition = condition.replaceAll("<==>", "<->");
		condition = condition.replaceAll("==", "=");
		condition = condition.replaceAll("&&", "&");
		condition = condition.replaceAll("(?<==\\s?)true", "TRUE");
		condition = condition.replaceAll("(?<==\\s?)false", "FALSE");
		condition = condition.replaceAll("(\\w*)\\sinstanceof\\s(\\w*)", "$2::instance($1) = TRUE");
		return condition;
	}
	
	public static String getMethodStubFromFile(String className, String methodName) {
		String methodStub = "";
		IFile file = FileUtil.getClassFile(className);
		boolean methodFound = false;
		int braketCounter = 0;
		if (file != null) {
			List<String> linesOfFile = FileUtil.readFileInList(file.getLocation().toOSString());
			for (int i = 0; i < linesOfFile.size(); i++) {
				String currLine = linesOfFile.get(i);
				if (!methodFound) {
					if (currLine.contains(methodName + "(")) {
						methodFound = true;
						methodStub = currLine;
						braketCounter++;
					}
				} else {
					methodStub += currLine;
					if (currLine.contains("{")) {
						braketCounter++;
					}
					if (currLine.contains("}")) {
						braketCounter--;
					}
					if (currLine.contains("}") && braketCounter == 0) {
						return methodStub;
					}
				}
			}
		}
		return methodStub;
	}

	
	public static String getStringFromObject(EObject object) {
//		return EmfFormatter.objToStr(object, new Predicate<EStructuralFeature>() {
//			@Override
//			public boolean apply(EStructuralFeature input) {
//				return false;
//			}
//		});
		if (object instanceof ConditionalImpl && ((ConditionImpl)object).getName() != null) {
			return ((ConditionImpl)object).getName();
		} else if (object instanceof ConditionExtension) {
			return ((ConditionExtension)object).stringRepresentation;
		} else if (object instanceof JMLExpressionExtension) {
			return ((JMLExpressionExtension)object).stringRepresentation;
		}
		return NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(object));
	}
	
	public static String replaceBlockStatementsInString(String statement) {
		System.out.println("statment matches: " + statement.contains("Block "));
		while (statement.contains("Block ")) {
			int pos = statement.indexOf("Block ");
			String blockName = statement.substring(pos+6).split(";")[0];
			System.out.println("found block: " + blockName);
			statement = statement.replaceAll("Block " + blockName + ";", blockName + ".getBlock();");
		}
		return statement.replaceAll("Block\s[a-zA-Z0-9]+;", "{}")
				.replaceAll(" @", "\n@");
	}
	
	public static String replaceVariablesWithGlobalVariables(List<String> variables, String statement) {
		List<String> startSeparator = Arrays.asList(" ", "\n", "\t", ";", "\\+", "-", "\\*", "/", "%", "\\^", ",", "=", "@", "<", ">");
		List<String> endSeparator = Arrays.asList(" ", "\n", "\t", ";", "\\+", "-", "\\*", "/", "%", "\\^", ",", "=", "<", ">", "[", ".",  "!");
		String globalClass = "GlobalJavaVariables.";
		System.out.println("\nTEST " + statement + "\n\n\n");
		
		for (String variable: variables) {
			String varName = variable.split(" ")[1];
			for (String start: startSeparator) {
				for (String end: endSeparator) {
					while (statement.contains(start + varName + end)) {
						if (end.equals("[")) {
							//this needs to be handled separately, because regex does some magic with [
							//Also it needs replaceAll
							end = "\\[";
							statement = statement.replaceAll(start + varName + end, start + globalClass + varName + end);
						} else if (end.equals("!")) {
							end = "\\!";
							statement = statement.replaceAll(start + varName + end, start + globalClass + varName + end);
						} else {
							System.out.println("replacing " + start + varName + end + " with " + start + globalClass + varName + end);
							statement = statement.replace(start + varName + end, start + globalClass + varName + end);
							System.out.println("NEW " + statement);
						}
					}
				}
			}

			//replace at beginning of the statement
			String tempStatement = new String(statement.substring(0, varName.length()+1));

			if (tempStatement.substring(0, varName.length()).equals(varName)) {
				System.out.println("tmp " + tempStatement + " " + tempStatement.contains(varName + "\\!"));

				for (String end: endSeparator) {
					if (tempStatement.contains(varName + end)) {
						if (end.equals("[")) {
							//this needs to be handled separately, because regex does some magic with [
							//Also it needs replaceAll
							end = "\\[";
							tempStatement = tempStatement.replaceAll(varName + end, globalClass + varName + end);
						} else if (end.equals("!")) {
							end = "\\!";
							System.out.println("b4 " + tempStatement + " " + tempStatement.contains(varName + "!"));
							tempStatement = tempStatement.replaceAll(varName + end, globalClass + varName + end);
							System.out.println("after" + tempStatement + " " + tempStatement.contains(varName + "!"));

						} else {
							System.out.println("TMPreplacing " + varName + end + " with " + globalClass + varName + end);
							tempStatement = tempStatement.replaceAll(varName + end, globalClass + varName + end);
						}
						break;
					}
				}
			}
		
			statement = tempStatement + statement.substring(varName.length()+1);

		}
		return statement;
	}

}
