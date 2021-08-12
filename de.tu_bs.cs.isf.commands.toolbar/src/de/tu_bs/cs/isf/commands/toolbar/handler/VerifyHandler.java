package de.tu_bs.cs.isf.commands.toolbar.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jdt.internal.core.CompilationUnit;

public class VerifyHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			List<IFile> fileList = strucSelection.toList();
			List<IFile> cleanFileList = new ArrayList<IFile>();
			for (Object file : fileList) {
				if (file instanceof IFile) {
					cleanFileList.add((IFile)file);
				} else if (file instanceof CompilationUnit) {
					cleanFileList.add((IFile)((CompilationUnit)file).getResource());
				} else if (!(file instanceof IFile)) {
					throw new ExecutionException("Select only Files. with resource " + file.toString());
				}
			}
			VerifyThread thread = new VerifyThread(cleanFileList);
			thread.start();
		}
		return null;
	}

}
