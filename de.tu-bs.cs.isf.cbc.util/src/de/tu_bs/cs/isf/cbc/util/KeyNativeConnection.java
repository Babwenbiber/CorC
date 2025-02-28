package de.tu_bs.cs.isf.cbc.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.key_project.util.collection.ImmutableSet;

import de.uka.ilkd.key.control.KeYEnvironment;
import de.uka.ilkd.key.gui.MainWindow;
import de.uka.ilkd.key.java.abstraction.KeYJavaType;
import de.uka.ilkd.key.logic.op.IObserverFunction;
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

public class KeyNativeConnection {
	public static boolean proveWithKey(File location, IProgressMonitor monitor) {
		Proof proof = createKeyProof(location, monitor);
		if (proof != null) {
			// Show proof result
			boolean closed = proof.openGoals().isEmpty();
			Console.println("Proof is closed: " + closed);
			return closed;
		}
		return false;
	}
	
	private static Proof createKeyProof(File location, IProgressMonitor monitor) {
		try {
			if (location.getCanonicalPath().contains(".java")) {
				proveJavaFile(location, monitor);
			} else {
				proveKeyFile(location, monitor);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	private static Proof proveKeyFile(File location, IProgressMonitor monitor) {
		Proof proof = null;
		List<File> classPaths = null; // Optionally: Additional specifications
										// for API classes
		File bootClassPath = null; // Optionally: Different default
									// specifications for Java API
		List<File> includes = null; // Optionally: Additional includes to
									// consider
		try {
			// Ensure that Taclets are parsed
			if (!ProofSettings.isChoiceSettingInitialised()) {
				KeYEnvironment<?> env = KeYEnvironment.load(location, classPaths, bootClassPath, includes);
				env.dispose();
			}

			// Set Taclet options
			ChoiceSettings choiceSettings = ProofSettings.DEFAULT_SETTINGS.getChoiceSettings();
			HashMap<String, String> oldSettings = choiceSettings.getDefaultChoices();
			HashMap<String, String> newSettings = new HashMap<String, String>(oldSettings);
			newSettings.putAll(MiscTools.getDefaultTacletOptions());
			newSettings.put("runtimeExceptions", "runtimeExceptions:ban");
			choiceSettings.setDefaultChoices(newSettings);
			// Load source code
			KeYEnvironment<?> env = KeYEnvironment.load(location, classPaths, bootClassPath, includes);
			Set<KeYJavaType> kjts = env.getJavaInfo().getAllKeYJavaTypes();
			proof = env.getLoadedProof();
			// Set proof strategy options
			StrategyProperties sp = proof.getSettings().getStrategySettings().getActiveStrategyProperties();
			sp.setProperty(StrategyProperties.METHOD_OPTIONS_KEY, StrategyProperties.METHOD_CONTRACT);
			sp.setProperty(StrategyProperties.LOOP_OPTIONS_KEY, StrategyProperties.LOOP_EXPAND);
			sp.setProperty(StrategyProperties.DEP_OPTIONS_KEY, StrategyProperties.DEP_ON);
			sp.setProperty(StrategyProperties.QUERY_OPTIONS_KEY, StrategyProperties.QUERY_RESTRICTED);// StrategyProperties.QUERY_ON
			sp.setProperty(StrategyProperties.NON_LIN_ARITH_OPTIONS_KEY, StrategyProperties.NON_LIN_ARITH_DEF_OPS);
			sp.setProperty(StrategyProperties.STOPMODE_OPTIONS_KEY, StrategyProperties.STOPMODE_NONCLOSE);
			proof.getSettings().getStrategySettings().setActiveStrategyProperties(sp);
			// Make sure that the new options are used
			int maxSteps = 20000;
			ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setMaxSteps(maxSteps);
			ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setActiveStrategyProperties(sp);
			proof.getSettings().getStrategySettings().setMaxSteps(maxSteps);
			proof.setActiveStrategy(proof.getServices().getProfile().getDefaultStrategyFactory().create(proof, sp));
			// Start auto mode
			Console.println("Start proof: " + location.getName());
			if (monitor != null) {
				env.getUi().getProofControl().startAutoMode(proof);
				while (env.getUi().getProofControl().isInAutoMode()) {
					if (monitor.isCanceled()) {
						env.getUi().getProofControl().stopAndWaitAutoMode();
						Console.println("Proof is canceled.");
					}
				}
			} else {
				env.getUi().getProofControl().startAndWaitForAutoMode(proof);
			}

			// Show proof result
		  boolean closed = proof.openGoals().isEmpty();
          Console.println((closed ? "verified" : "still open") + ".");
      
			try {
				proof.saveToFile(location);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ProblemLoaderException e) {
			Console.println("Exception at '" + e.getCause() + "'");
			e.printStackTrace();
		}
		return proof;
	}

	
	private static Proof proveJavaFile(File location, IProgressMonitor monitor) {
		List<File> classPaths = null; // Optionally: Additional specifications for API classes
	      File bootClassPath = null; // Optionally: Different default specifications for Java API
	      List<File> includes = null; // Optionally: Additional includes to consider
	      try {
	         // Ensure that Taclets are parsed
	         if (!ProofSettings.isChoiceSettingInitialised()) {
	            KeYEnvironment<?> env = KeYEnvironment.load(location, classPaths, bootClassPath, includes);
	            env.dispose();
	         }
	         // Set Taclet options
	         ChoiceSettings choiceSettings = ProofSettings.DEFAULT_SETTINGS.getChoiceSettings();
	         HashMap<String, String> oldSettings = choiceSettings.getDefaultChoices();
	         HashMap<String, String> newSettings = new HashMap<String, String>(oldSettings);
	         newSettings.putAll(MiscTools.getDefaultTacletOptions());
	         choiceSettings.setDefaultChoices(newSettings);
	         // Load source code
	         KeYEnvironment<?> env = KeYEnvironment.load(location, classPaths, bootClassPath, includes); // env.getLoadedProof() returns performed proof if a *.proof file is loaded
	         try {
	            // List all specifications of all types in the source location (not classPaths and bootClassPath)
	            final List<Contract> proofContracts = new LinkedList<Contract>();
//	            env.getJavaInfo().get
	            Set<KeYJavaType> kjts = env.getJavaInfo().getAllKeYJavaTypes();
	            for (KeYJavaType type : kjts) {
	               if (!KeYTypeUtil.isLibraryClass(type)) {
	                  ImmutableSet<IObserverFunction> targets = env.getSpecificationRepository().getContractTargets(type);
	                  for (IObserverFunction target : targets) {
	                     ImmutableSet<Contract> contracts = env.getSpecificationRepository().getContracts(type, target);
	                     for (Contract contract : contracts) {
	                        proofContracts.add(contract);
	                     }
	                  }
	               }
	            }
	            // Perform proofs
	            if (proofContracts.size() > 1) {
	            	System.out.println("more then one proof " + location.getAbsolutePath());
	            }
	            for (Contract contract : proofContracts) {
	               Proof proof = null;
	               try {
	                  // Create proof
	                  proof = env.createProof(contract.createProofObl(env.getInitConfig(), contract));
	                  // Set proof strategy options
	                  StrategyProperties sp = proof.getSettings().getStrategySettings().getActiveStrategyProperties();
	                  sp.setProperty(StrategyProperties.METHOD_OPTIONS_KEY, StrategyProperties.METHOD_CONTRACT);
	                  sp.setProperty(StrategyProperties.DEP_OPTIONS_KEY, StrategyProperties.DEP_ON);
	                  sp.setProperty(StrategyProperties.QUERY_OPTIONS_KEY, StrategyProperties.QUERY_ON);
	                  sp.setProperty(StrategyProperties.NON_LIN_ARITH_OPTIONS_KEY, StrategyProperties.NON_LIN_ARITH_DEF_OPS);
	                  sp.setProperty(StrategyProperties.STOPMODE_OPTIONS_KEY, StrategyProperties.STOPMODE_NONCLOSE);
	                  proof.getSettings().getStrategySettings().setActiveStrategyProperties(sp);
	                  // Make sure that the new options are used
	                  int maxSteps = 10000;
	                  ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setMaxSteps(maxSteps);
	                  ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setActiveStrategyProperties(sp);
	                  proof.getSettings().getStrategySettings().setMaxSteps(maxSteps);
	                  proof.setActiveStrategy(proof.getServices().getProfile().getDefaultStrategyFactory().create(proof, sp));
	                  // Start auto mode
	                  if (monitor != null) {
		                  env.getUi().getProofControl().startAutoMode(proof);
		                  if (monitor.isCanceled()) {
		                	  env.getUi().getProofControl().stopAndWaitAutoMode();
								Console.println("Proof is canceled.");
		                  }
	                  } else {
		                  env.getUi().getProofControl().startAndWaitForAutoMode(proof);
	                  }
	                  // Show proof result
	                  boolean closed = proof.openGoals().isEmpty();
	                  Console.println(contract.getTarget() + " is " + (closed ? "verified" : "still open") + ".");
	                  try {
	                	String keyLocationFileName = location.getAbsolutePath().substring(0, location.getAbsolutePath().length() - 5) + ".key";
	                	Console.println("keyfilename: " + keyLocationFileName);
	      				proof.saveToFile(new File(keyLocationFileName));
	      			} catch (IOException e) {
	      				e.printStackTrace();
	      			}
	               }
	               catch (ProofInputException e) {
	                  Console.println("Exception at '" + contract.getDisplayName() + "' of " + contract.getTarget() + ":");
	                  e.printStackTrace();
	               }
	               finally {
	                  if (proof != null) {
	                     proof.dispose(); // Ensure always that all instances of Proof are disposed
	                  }
	               }
	            }
	         }
	         finally {
	            env.dispose(); // Ensure always that all instances of KeYEnvironment are disposed
	         }
	      }
	      catch (ProblemLoaderException e) {
	         System.out.println("Exception at '" + location + "':");
	         e.printStackTrace();
	      }
	      return null;
	}
	
	public static String createWPWithKey(File location, IProgressMonitor monitor) {
		Proof proof = KeyNativeConnection.createKeyProof(location, monitor);
		if (proof != null) {
			String wp = "";
			Iterator<Goal> it = proof.openGoals().iterator();
			Goal goal = it.next();
			String[] goalString = goal.toString().split("==>");
			String antecedent = goalString[0].trim();
			String succedent = goalString[1].trim();
			wp += "(";
			if (antecedent.isEmpty()) {
				wp += succedent;
			} else {
				if (succedent.isEmpty()) {
					wp += "!(" + antecedent + ")";
				} else {
					wp += antecedent + " -> " + succedent;
				}
			}
			wp += ")";
			if (it.hasNext()) {
				goal = it.next();
				goalString = goal.toString().split("==>");
				antecedent = goalString[0].trim();
				succedent = goalString[1].trim();
				wp += " & (";
				if (antecedent.isEmpty()) {
					wp += succedent;
				} else {
					if (succedent.isEmpty()) {
						wp += "!" + antecedent;
					} else {
						wp += antecedent + " -> " + succedent;
					}
				}
				wp += ")";
			}
			Console.println("Weakest precondition is: " + wp);
			return wp;
		}
		return "";
	}

	
	
	public static void createKeyProofUserstudy(File location, int proofCounter) {
		File keyFile = null;
		List<File> classPaths = null; // Optionally: Additional specifications
										// for API classes
		File bootClassPath = null; // Optionally: Different default
									// specifications for Java API
		List<File> includes = null; // Optionally: Additional includes to
									// consider
		try {
			// Ensure that Taclets are parsed
			if (!ProofSettings.isChoiceSettingInitialised()) {
				KeYEnvironment<?> env = KeYEnvironment.load(location, classPaths, bootClassPath, includes);
				env.dispose();
			}
			// Set Taclet options
			ChoiceSettings choiceSettings = ProofSettings.DEFAULT_SETTINGS.getChoiceSettings();
			HashMap<String, String> oldSettings = choiceSettings.getDefaultChoices();
			HashMap<String, String> newSettings = new HashMap<String, String>(oldSettings);
			newSettings.putAll(MiscTools.getDefaultTacletOptions());
			newSettings.put("runtimeExceptions", "runtimeExceptions:ban");
			choiceSettings.setDefaultChoices(newSettings);
			// Load source code
			KeYEnvironment<?> env = KeYEnvironment.load(location, classPaths, bootClassPath, includes);
			// proof = env.getLoadedProof();
			try {
				// List all specifications of all types in the source location
				// (not classPaths and bootClassPath)
				final List<Contract> proofContracts = new LinkedList<Contract>();
				Set<KeYJavaType> kjts = env.getJavaInfo().getAllKeYJavaTypes();
				for (KeYJavaType type : kjts) {
					if (!KeYTypeUtil.isLibraryClass(type)) {
						ImmutableSet<IObserverFunction> targets = env.getSpecificationRepository().getContractTargets(type);
						for (IObserverFunction target : targets) {
							ImmutableSet<Contract> contracts = env.getSpecificationRepository().getContracts(type, target);
							for (Contract contract : contracts) {
								proofContracts.add(contract);
							}
						}
					}
				}
				// Perform proofs
				Contract contract = proofContracts.get(0);
				Proof proof = null;
				try {
					// Create proof
					proof = env.createProof(contract.createProofObl(env.getInitConfig(), contract));
					// Set proof strategy options
					StrategyProperties sp = proof.getSettings().getStrategySettings().getActiveStrategyProperties();
					sp.setProperty(StrategyProperties.METHOD_OPTIONS_KEY, StrategyProperties.METHOD_EXPAND);
					sp.setProperty(StrategyProperties.LOOP_OPTIONS_KEY, StrategyProperties.LOOP_INVARIANT);
					sp.setProperty(StrategyProperties.DEP_OPTIONS_KEY, StrategyProperties.DEP_ON);
					sp.setProperty(StrategyProperties.QUERY_OPTIONS_KEY, StrategyProperties.QUERY_RESTRICTED);// StrategyProperties.QUERY_ON
					sp.setProperty(StrategyProperties.NON_LIN_ARITH_OPTIONS_KEY, StrategyProperties.NON_LIN_ARITH_DEF_OPS);
					sp.setProperty(StrategyProperties.STOPMODE_OPTIONS_KEY, StrategyProperties.STOPMODE_DEFAULT);
					proof.getSettings().getStrategySettings().setActiveStrategyProperties(sp);
					// Make sure that the new options are used
					int maxSteps = 5000;
					ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setMaxSteps(maxSteps);
					ProofSettings.DEFAULT_SETTINGS.getStrategySettings().setActiveStrategyProperties(sp);
					proof.getSettings().getStrategySettings().setMaxSteps(maxSteps);
					proof.setActiveStrategy(proof.getServices().getProfile().getDefaultStrategyFactory().create(proof, sp));
					// Start auto mode
//						MainWindow.getInstance().setVisible(true);
					env.getUi().getProofControl().startAndWaitForAutoMode(proof);
					// Show proof result
					Console.println("Proof is closed: " + proof.openGoals().isEmpty());
	                try {
	                	String locationWithoutFileEnding = location.toString().substring(0, location.toString().indexOf("."));
	                	keyFile = new File(locationWithoutFileEnding + ".proof");
	    				proof.saveToFile(keyFile);
	    				IWorkspace workspace = ResourcesPlugin.getWorkspace();    
	    				IPath iLocation = Path.fromOSString(keyFile.getAbsolutePath()); 
	    				IFile ifile = workspace.getRoot().getFileForLocation(iLocation);
	    				ifile.refreshLocal(0, null);
	    			} catch (IOException | CoreException e) {
	    				e.printStackTrace();
	    			}
				} catch (ProofInputException e) {
					Console.println(
							"Exception at '" + contract.getDisplayName() + "' of " + contract.getTarget() + ":");
					e.printStackTrace();
				} finally {
					if (proof != null) {
						proof.dispose(); // Ensure always that all instances
											// of Proof are disposed
					}
				}
			} finally {
				env.dispose(); // Ensure always that all instances of
								// KeYEnvironment are disposed
			}
			MainWindow.getInstance().loadProblem(keyFile);
			MainWindow.getInstance().setVisible(true);
		} catch (ProblemLoaderException e) {
			Console.println("Exception at '" + e.getCause() + "'");
			e.printStackTrace();
		}
	}
}
