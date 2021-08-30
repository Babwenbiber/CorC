//package de.tu_bs.cs.isf.cbc.textual.tool.generator;
//
//import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess;
//import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
//import org.eclipse.xtext.generator.IGenerator;
//import org.eclipse.xtext.resource.IResourceDescriptions;
//import org.eclipse.xtext.ui.resource.IResourceSetProvider;
//import com.google.inject.Inject;
//import com.google.inject.Provider;
//
//import org.eclipse.core.commands.AbstractHandler;
//import org.eclipse.core.commands.ExecutionEvent;
//import org.eclipse.core.commands.ExecutionException;
//import org.eclipse.core.commands.IHandler;
//import org.eclipse.core.resources.IFile;
//import org.eclipse.core.resources.IFolder;
//import org.eclipse.core.resources.IProject;
//import org.eclipse.core.resources.IWorkspace;
//import org.eclipse.core.resources.IncrementalProjectBuilder;
//import org.eclipse.core.resources.ResourcesPlugin;
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.core.runtime.NullProgressMonitor;
//import org.eclipse.core.runtime.Path;
//import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.ecore.resource.Resource;
//import org.eclipse.emf.ecore.resource.ResourceSet;
//import org.eclipse.jface.viewers.ISelection;
//import org.eclipse.jface.viewers.IStructuredSelection;
//import org.eclipse.ui.handlers.HandlerUtil;
//
//public class GenerationHandler extends AbstractHandler implements IHandler {
//    
//    @Inject
//    private IGenerator generator;
// 
//    @Inject
//    private Provider<EclipseResourceFileSystemAccess> fileAccessProvider;
//     
//    @Inject
//    IResourceDescriptions resourceDescriptions;
//     
//    @Inject
//    IResourceSetProvider resourceSetProvider;
//     
//    @Override
//    public Object execute(ExecutionEvent event) throws ExecutionException {
//         
////        ISelection selection = HandlerUtil.getCurrentSelection(event);
////        if (selection instanceof IStructuredSelection) {
////            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
////            Object firstElement = structuredSelection.getFirstElement();
////            if (firstElement instanceof IFile) {
//		    	final IWorkspace workspace = ResourcesPlugin.getWorkspace();
//		    	final IFile file = workspace.getRoot().getFile(new Path("foo/src/block_stuff.cbctxt"));
//		    	final IProject project = file.getProject();
////                IFolder srcGenFolder = project.getFolder("src-gen");
////                if (!srcGenFolder.exists()) {
////                    try {
////                        srcGenFolder.create(true, true,
////                                new NullProgressMonitor());
////                    } catch (CoreException e) {
////                        return null;
////                    }
////                }
// 
//                final EclipseResourceFileSystemAccess fsa = fileAccessProvider.get();
////                fsa.setOutputPath("src-gen");
////                fsa.setProject(project);
////                fsa.setMonitor(new NullProgressMonitor());
//                 
//                URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
//                ResourceSet rs = resourceSetProvider.get(project);
//                Resource r = rs.getResource(uri, true);
//                generator.doGenerate(r, fsa);
//                 
////            }
////        }
//        return null;
//    }
// 
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
// 
//}