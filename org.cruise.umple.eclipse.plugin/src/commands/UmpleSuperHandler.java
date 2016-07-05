package commands;
import java.io.PrintStream;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.console.*;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.swt.graphics.Color;

import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;

public class UmpleSuperHandler {
	
	

	
	/*
	 * @author Vahdat
	 * used to execute UmpleModel based on the current open file.
	 */
	protected void compileUmpleFile(ExecutionEvent event,boolean generate,String... language){
		setDefualtConsole();
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
				showErrorMessage(e.getMessage());
			}
		} else{ 
			showErrorMessage("Please select an Umple file. The file must have .ump extension.");
		}
		
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
					showMessage("Umple file: "+uModel.getUmpleFile().getFileName()+
							System.lineSeparator()+"File Path: "+uModel.getUmpleFile().getPath()+System.lineSeparator()+"Umple generated the target artifacts successfully.");
					
				} else {
					showMessage("Umple file: "+uModel.getUmpleFile().getFileName()+
							System.lineSeparator()+"File Path: "+uModel.getUmpleFile().getPath()+System.lineSeparator()+"Umple file was compiled successfully.");
				}
			}
					
		} catch (Exception e) {
			showErrorMessage(uModel.getLastResult().getErrorMessages().toString());
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
			e.printStackTrace();
		}
	}
	
	/*
	 * @author : Vahdat
	 */
	private void removeAlreadyDefinedGenerators(UmpleModel uModel){
		//I couldn't find anyway to remove generated languages.
	}

	/*
	 * This show info messages. You could change it to be a visual message if you like.
	 */
	private void showMessage(String msg){

		System.out.println(msg);
		//Comment: you have to have the value for "event" to be able to use the following visual message.
		//MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Info",msg);
	}
	
	/*
	 * This show error messages. You could change it to be a visual message if you like.
	 */
	private void showErrorMessage(String msg){
		System.err.println(msg);
		//Comment: you have to have the value for "event" to be able to use the following visual message.
		//MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Error",msg);
	}
	
	/*
	 * This method create the proper console in Eclipse environment
	 */
	private void setDefualtConsole(){	
		try {
			MessageConsole umpleConsole = findConsole("Umple Compiler");
			umpleConsole.clearConsole(); 
	        umpleConsole.activate();
	        System.setOut(new PrintStream(umpleConsole.newOutputStream()));
	        IOConsoleOutputStream io = umpleConsole.newOutputStream();
	        io.setColor(new Color(null, 255, 0, 0));
	        System.setErr(new PrintStream(io));
		} catch (Exception e) {
			showErrorMessage(e.getMessage());
		}
	}
	
	/*
	 * This method comes from https://wiki.eclipse.org/FAQ_How_do_I_write_to_the_console_from_a_plug-in%3F
	 */
	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
	    IConsoleManager conMan = plugin.getConsoleManager();
	    IConsole[] existing = conMan.getConsoles();
	    	for (int i = 0; i < existing.length; i++)
	    		if (name.equals(existing[i].getName()))
	    			return (MessageConsole) existing[i];
	    //no console found, so create a new one
	    MessageConsole myConsole = new MessageConsole(name, null);
	    conMan.addConsoles(new IConsole[]{myConsole});
	    return myConsole;
	}
}
