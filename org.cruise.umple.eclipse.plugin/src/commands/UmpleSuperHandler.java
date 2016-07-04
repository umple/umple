package commands;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.internal.win32.FILETIME;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

import cruise.umple.compiler.GenerateTarget;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;

public class UmpleSuperHandler {
	
	/*
	 * @author Vahdat
	 * used to execute UmpleModel based on the current open file.
	 */
	protected void compileUmpleFile(ExecutionEvent event,boolean generate,String... language){
		IEditorInput editorInput = HandlerUtil.getActiveEditorInput(event);
		IFileEditorInput fileEditorInput =(IFileEditorInput)editorInput.getAdapter(IFileEditorInput.class);
		IFile iFile = fileEditorInput.getFile();
		if (iFile.getFileExtension().toLowerCase().equals("ump")){
			String fileName = iFile.getName();
			String absolutePath = iFile.getLocation().toString();
			String filePath = absolutePath.substring(0, absolutePath.lastIndexOf(fileName, absolutePath.length() - 1));		
	        try {
	        	UmpleModel uModel = getUmpleModel(filePath,fileName,event);
	        	runUmpleModel(uModel,event,generate,language);
	        	refreshProjectFoler(editorInput);
			} catch (Exception e) {
				e.printStackTrace();
				MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Error",e.getMessage());
			}
		} else 
		MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Info","Please select an Umple file.");
	}
	
	/*
	 * @author : Vahdat
	 * used to run model.
	 */
	private void runUmpleModel(UmpleModel uModel,ExecutionEvent event,boolean generate,String... language){
		try {
			if (language.length>0) removeAlreadyDefinedGenerators(uModel);
			for (String lang : language) uModel.addGenerate(lang);
			
			if (!generate) uModel.setShouldGenerate(false);
			
			uModel.run();
			if (uModel.getLastResult().getWasSuccess()){
				if (generate){
					MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Info","Umple file: "+uModel.getUmpleFile().getFileName()+
							System.lineSeparator()+"File Path: "+uModel.getUmpleFile().getPath()+System.lineSeparator()+"Umple generated the target artifac successfully.");
				} else {
					MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Info","Umple file: "+uModel.getUmpleFile().getFileName()+
							System.lineSeparator()+"File Path: "+uModel.getUmpleFile().getPath()+System.lineSeparator()+"Umple file was compiled successfully.");
				}
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Error",e.getMessage());
		}
	}
	
	
	/*
	 * @author : Vahdat
	 * This create an UmpleModel but it doesn't run the model.
	 */
	private UmpleModel getUmpleModel(String filePath, String fileName,ExecutionEvent event){
		UmpleModel model = null;
		try {
        	UmpleFile file = new UmpleFile(filePath,fileName);
	        model = new UmpleModel(file);	
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Error",e.getMessage());
		}
		return model;
	}
	
	/* @author : Vahdat
	 * Refreshes the project so as to see the generated files.
	 */
	protected void refreshProjectFoler(IEditorInput iEditorInput){
		try {
			IResource iResource = (IResource) iEditorInput.getAdapter(IResource.class);
			iResource.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * @author : Vahdat
	 */
	private void removeAlreadyDefinedGenerators(UmpleModel uModel){
		//I couldn't find anyway to remove generated languages.
	}
}
