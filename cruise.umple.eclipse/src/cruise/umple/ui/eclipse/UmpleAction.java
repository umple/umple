package cruise.umple.ui.eclipse;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.console.*;

import cruise.umple.compiler.*;
//import cruise.umple.ui.violet.VioletSystem;

/**
 * Our action implements workbench action delegate. The action proxy will be
 * created by the workbench and shown in the UI. When the user tries to use the
 * action, this delegate will be created and execution will be delegated to it.
 * 
 * @see IWorkbenchWindowActionDelegate
 */
public class UmpleAction implements IWorkbenchWindowActionDelegate
{
  public static IWorkbenchWindow window;

  /**
   * The constructor.
   */
  public UmpleAction()
  {  
  }
  
  /**
   * The action has been activated. The argument of the method represents the
   * 'real' action sitting in the workbench UI.
   * 
   * @see IWorkbenchWindowActionDelegate#run
   */
  public void run(IAction action)
  {
    try
    {
    	
      // Save all current work
    	    	//((MessageConsole)cons).addPatternMatchListener(new UmplePatternMatcher());
      window.getActivePage().saveAllEditors(false);
    
      IEditorPart editor = window.getActivePage().getActiveEditor();
      // Check 1. Verify that a FileEditor View is opened
      if (editor == null)
      {
    	  throw new Exception("Please open an Umple file.");
      }
      IResource fName = (IResource) editor.getEditorInput().getAdapter(IResource.class);
      
      String name = fName.getFullPath().toOSString();
      String wsLocation = fName.getWorkspace().getRoot().getLocation().toOSString();

      String fileName = window.getActivePage().getActiveEditor().getTitle().toString();
      // Check 2. Verify if it is an Umple file before processing it
      if (!(fileName.endsWith(".ump")) || fileName.equals("")){
    	  throw new Exception("Please open an Umple file.");
      }
      String fullPath = wsLocation + name;

      // Extract the file name from the path so the file name woudln't be
      // duplicated
      UmpleFile file = new UmpleFile(fullPath.substring(0, fullPath.lastIndexOf(fileName, fullPath.length() - 1)), fileName);
      UmpleModel model = new UmpleModel(file);
      model.run();
      
      // Update the project
      fName.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
    }
    catch (Exception e)
    {
      MessageDialog.openError(window.getShell(), "UMPLE Plug-in", e.getMessage() + "\n");
    }
  }

  /**
   * Selection in the workbench has been changed. We can change the state of the
   * 'real' action here if we want, but this can only happen after the delegate
   * has been created.
   * 
   * @see IWorkbenchWindowActionDelegate#selectionChanged
   */
  public void selectionChanged(IAction action, ISelection selection)
  {}

  /**
   * We can use this method to dispose of any system resources we previously
   * allocated.
   * 
   * @see IWorkbenchWindowActionDelegate#dispose
   */
  public void dispose()
  {}

  /**
   * We will cache window object in order to be able to provide parent shell for
   * the message dialog.
   * 
   * @see IWorkbenchWindowActionDelegate#init
   */
  public void init(IWorkbenchWindow window)
  {
    this.window = window;
    
  }
}
