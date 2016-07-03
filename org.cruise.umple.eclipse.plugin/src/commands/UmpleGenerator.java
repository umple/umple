package commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;

public class UmpleGenerator implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorInput editorInput = HandlerUtil.getActiveEditorInput(event);
		IFileEditorInput fileEditorInput =(IFileEditorInput)editorInput.getAdapter(IFileEditorInput.class);
		IFile iFile = fileEditorInput.getFile();
		//compiles Umple File
		compileUmpleFile(iFile,event);
		
		//refresh the project so as to see generated files.
		refreshProjectFoler(editorInput);

		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * @author Vahdat
	 * used to execute UmpleModel based on the current open file.
	 */
	private void compileUmpleFile(IFile iFile,ExecutionEvent event){
		if (iFile.getFileExtension().toLowerCase().equals("ump")){
			String fileName = iFile.getName();
			String absolutePath = iFile.getLocation().toString();
			String filePath = absolutePath.substring(0, absolutePath.lastIndexOf(fileName, absolutePath.length() - 1));		
	        try {
	        	UmpleFile file = new UmpleFile(absolutePath);
		        UmpleModel model = new UmpleModel(file);
				model.run();
				boolean compileSuccess = model.getLastResult().getWasSuccess();	
				if (compileSuccess)
					MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Info","Umple file: "+fileName+
						System.lineSeparator()+"File Path: "+filePath+System.lineSeparator()+"Umple generated the target language successfully.");	
			} catch (Exception e) {
				e.printStackTrace();
				MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Error",e.getMessage());
			}
		} else 
		MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Info","Please select an Umple file.");
	}
	
	/* @author Vahdat
	 * Refreshes the project so as to see the generated files.
	 */
	private void refreshProjectFoler(IEditorInput iEditorInput){
		try {
			IResource iResource = (IResource) iEditorInput.getAdapter(IResource.class);
			iResource.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
