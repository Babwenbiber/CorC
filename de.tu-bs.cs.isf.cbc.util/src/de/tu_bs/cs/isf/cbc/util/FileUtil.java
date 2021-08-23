package de.tu_bs.cs.isf.cbc.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

import com.google.common.hash.Hashing;

import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables;

public class FileUtil {
	private static URI applicationUri = null;

	public static IFile getClassFile(String className) {
		URI uriTrimmed = applicationUri.trimFragment();
		if (uriTrimmed.isPlatformResource()) {
			String platformString = uriTrimmed.toPlatformString(true);
			IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (fileResource != null) {
				IProject project = fileResource.getProject();
				return traverseFolders(project, className);

			}
		}
		return null;
	}

	private static IFile traverseFolders(IContainer folder, String className) {
		try {
			IResource[] members = folder.members();
			for (final IResource resource : members) {
				if (resource instanceof IContainer) {
					IFile foundFile = traverseFolders((IContainer) resource, className);
					if (foundFile != null) {
						return foundFile;
					}
				} else if (resource instanceof IFile) {

					final IFile file = (IFile) resource;
					if (file.getName().equals(className + ".java")) {
						return file;
					}
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<String> readFileInList(String path) {

		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		}

		catch (IOException e) {

			// do something
			e.printStackTrace();
		}
		return lines;
	}

	public static void setApplicationUri(URI applicationUri) {
		FileUtil.applicationUri = applicationUri;
//		String[] segments = {"Users", "frede", "runtume-New_configuration", "myproj"};
//		FileUtil.applicationUri = URI.createHierarchicalURI(
//				segments, null, null);
	}

	public static File writeFile(String problem, String location, int numberFile, boolean override, String proveName) {
		String newFileName = "prove" + numberFile + proveName + ".key";
		File keyFile = new File(location + "/" + newFileName);
		File keyHelperFile = new File(location + "/helper.key");

		String hash = Hashing.sha256()
				  .hashString(problem, StandardCharsets.UTF_8)
				  .toString();
		
		String fileName = HashTable.getFileNameFromHashTable(location, hash);
		
		
		if (fileName == null || override) {
			System.out.println("new file " + keyFile);
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
				HashTable.saveHashInTmpTable(location, hash, newFileName);
				return keyFile;
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		} else if (!fileName.equals(newFileName)) {
			System.out.println("renaming file " + location + "/" + fileName + " -> " + keyFile);
			new File(location + "/" + fileName).renameTo(keyFile);
			HashTable.saveHashInTmpTable(location, hash, newFileName);
			return keyFile;
		}
		System.out.println("old file " + keyFile);
		HashTable.saveHashInTmpTable(location, hash, newFileName);
		return null;
	}
	
	public static File writeToFileFromContent(String content, String location, String name) {
		File file = new File(location + "/" + name);
		return writeFileFromJavaFile(file, content);
	}
	
	private static File writeFileFromJavaFile(File file, String content) {
		try {
			file.getParentFile().mkdirs();
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
	
			bw.close();
			
			refreshDir(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		return file;
	}
	
	public static void refreshDir(File file) {
		try {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IPath iLocation = Path.fromOSString(file.getAbsolutePath());
			IFile ifile = workspace.getRoot().getFileForLocation(iLocation);
			ifile.refreshLocal(0, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public static File writeJavaFile(String problem, String location, int numberFile, boolean override, String proveName) {
		String newFileName = "prove" + numberFile + proveName + ".java";
		File keyFile = new File(location + "/" + newFileName);

		String hash = Hashing.sha256()
				  .hashString(problem, StandardCharsets.UTF_8)
				  .toString();
		
		String fileName = HashTable.getFileNameFromHashTable(location, hash);
		System.out.println(proveName + " filename from hashtable is " + fileName);
		
		
		if (fileName == null || override) {
			System.out.println("new file " + keyFile);
			writeFileFromJavaFile(keyFile, problem);

			HashTable.saveHashInTmpTable(location, hash, newFileName);
			return keyFile;
			
		} else if (!fileName.equals(newFileName)) {
			System.out.println("renaming file " + location + "/" + fileName + " -> " + keyFile);
			new File(location + "/" + fileName).renameTo(keyFile);
			HashTable.saveHashInTmpTable(location, hash, newFileName);
			return keyFile;
		}
		System.out.println("old file " + keyFile);
		HashTable.saveHashInTmpTable(location, hash, newFileName);
		return null;
	}
	
	public static IProject getProject(URI uri) {
		uri = uri.trimFragment();
		String uriPath = uri.toPlatformString(true);
		String uriFileString = uri.toFileString();
		uriPath= uri.toString();

		uriPath = uriPath.substring(1, uriPath.length());
		int positionOfSlash = uriPath.indexOf('/') + 1;
		uriPath = uriPath.substring(positionOfSlash, uriPath.length());
		IProject thisProject = null;
		for (IProject p : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			return p;
//			if (p.getFile(new Path(uriPath)).exists()) {
//				thisProject = p;
//			}
		}
		return thisProject;
	}

	public static String generateComposedClass(IProject project, List<String> refinements, List<String> vars) {
		String[] splittedRefinement = refinements.get(0).split("\\.");
		String className = "Original" + splittedRefinement[0];
		String composedClassName = splittedRefinement[0];
		String methodName = splittedRefinement[1];
		IFile file = getClassFile(className);
		if (file == null) {
			className = splittedRefinement[0];
			file = getClassFile(className);
		}
		String methodStub = Parser.getMethodStubFromFile(className, methodName);
		methodStub = methodStub.replaceFirst("(\\w*)\\(", "generated_$1(");
		String methodPreCondition = ProveWithKey.composeContractForCalledOriginal(refinements, Parser.KEYWORD_JML_PRE);
		String methodPostCondition = ProveWithKey.composeContractForCalledOriginal(refinements,
				Parser.KEYWORD_JML_POST);
		List<String> assignables = ProveWithKey.composeModifiables(refinements, new ArrayList<String>(), null, vars,
				false);
		String assignableString = "";
		if (!assignables.isEmpty()) {
			assignableString = "\n@assignable " + String.join(",", assignables) + ";";
		}

		List<String> lines = readFileInList(file.getLocation().toOSString());
		String contentOriginal = "";

		String content = "";
		for (String line : lines) {
			if (line.contains(" class ")) {
				if (className == composedClassName) {
					content += line + "\n\n /*@\n@ public normal_behavior\n@requires " + methodPreCondition
							+ ";\n@ensures " + methodPostCondition + ";" + assignableString + "\n" + "@*/\n"
							+ methodStub + "\n";
					contentOriginal += line.replaceFirst(composedClassName, "Original" + composedClassName);
				} else {
					content += line.replaceFirst(className, composedClassName)
							+ "\n\n /*@\n@ public normal_behavior\n@requires " + methodPreCondition + ";\n@ensures "
							+ methodPostCondition + ";" + assignableString + "\n" + "@*/\n" + methodStub + "\n";
					contentOriginal += line + "\n";
				}

			} else {
				content += line + "\n";
				contentOriginal += line + "\n";
			}
		}
		File generatedClass = new File(project.getLocation().toOSString() + "/src/" + composedClassName + ".java");
		File originalClass = new File(project.getLocation().toOSString() + "/src-orig/" + className + ".java");
		if (className != composedClassName) {
			createFile(originalClass, contentOriginal);
		}
		File generatedFile = createFile(generatedClass, content);
		return generatedFile.getName().substring(0, generatedFile.getName().indexOf("."));
	}

	private static File createFile(File file, String content) {
		try {
			file.getParentFile().mkdirs();
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(content);

			bw.close();

			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IPath iLocation = Path.fromOSString(file.getAbsolutePath());
			IFile ifile = workspace.getRoot().getFileForLocation(iLocation);
			ifile.refreshLocal(0, null);
			return file;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
