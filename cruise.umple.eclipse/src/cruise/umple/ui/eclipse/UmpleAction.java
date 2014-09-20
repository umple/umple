package cruise.umple.ui.eclipse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IResource;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.console.*;

import cruise.umple.compiler.*;
import cruise.umple.compiler.java.*;

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
	  boolean successfulCompilation;
	    UmpleModel model;
	    String pjName ;
	    JavaClassGenerator.mainMainClass = null;
    try
    {
    	MessageConsole umpleConsole = findConsole("Umple Compile");
        umpleConsole.activate();
        System.setErr(new PrintStream(umpleConsole.newOutputStream()));
        System.setOut(new PrintStream(umpleConsole.newOutputStream()));
        // Save all current work
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
        model = new UmpleModel(file);
        try{
          model.run();
        }
        catch (Exception e1)
        {
          System.err.println(e1.getMessage());
        }
      if("CompileAndRun".equals(action.getId()))
      {
    	        
    	        pjName = fName.getFullPath().toOSString().split("/")[1];
    	        File binFolder = new File(wsLocation+File.separator+pjName+File.separator+"bin");
    	        if(!binFolder.exists()){
    	          binFolder.mkdir();
    	        }
    	        List<String> libList = new ArrayList<String>();
    	        libList.add(" -d "+wsLocation+File.separator+pjName+File.separator+"bin");
    	        libList.add(" -classpath "+wsLocation+File.separator+pjName+File.separator+"bin");
    	        try
    	        {
    	          BufferedReader br = new BufferedReader(new FileReader(wsLocation+File.separator+pjName+File.separator+".classpath"));
    	          String line = br.readLine();
    	          Pattern pat = Pattern.compile(".*<classpathentry.*kind=\"lib\".*path=\"(.*)\".*/>.*");

    	          while(line!=null)
    	          {
    	            Matcher mat = pat.matcher(line);
    	            if(mat.matches()){
    	            	libList.add(":"+wsLocation+mat.group(1));
    	            }
    	            line = br.readLine();
    	          }
    	          br.close();
    	        }
    	        catch(Exception e)
    	        {
    	          e.printStackTrace();
    	        }
    	        successfulCompilation = CodeCompiler.compile(model, "-",libList.toArray(new String[0]));

    	        // Update the project
    	        fName.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
    	      
        if(successfulCompilation)
        {
          System.out.println("Was successfully compiled");
          List<UmpleClass> classes = CodeCompiler.getMainClasses(model);
          String[] possibilities = new String[classes.size()];
          for(int i=0;i<classes.size();i++)
          {
            possibilities[i]=classes.get(i).getName();
          }

          UmpleClass mainClass = null;
          if(possibilities.length==0)
          {
            throw new RuntimeException("No main classes found");
          }
          String mainClassName = null;
          String wizardArguments = "";
          //ImageIcon icon = new ImageIcon("icons/umpleDocument2.gif","Class selection");
          if(possibilities.length==1)
          {
            mainClassName = (String)possibilities[0];
          }
          else
          {
            Shell shell = window.getShell();
            UmpleMainClassWizard wizard = new UmpleMainClassWizard(possibilities);
            WizardDialog dialog = new WizardDialog(shell, wizard);
            int result = dialog.open();
            mainClassName = wizard.getClassName();
            wizardArguments = wizard.getArguments();

          }
          for(int i=0;i<classes.size();i++)
          {
            if(mainClassName.equals(classes.get(i).getName()))
            {
              mainClass = classes.get(i);
              break;
            }
          }
          ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
          ILaunchConfigurationType type =
              manager.getLaunchConfigurationType(IJavaLaunchConfigurationConstants.ID_JAVA_APPLICATION);
          boolean hasRun=false;
          ILaunchConfiguration[] configurations =
              manager.getLaunchConfigurations(type);
          for (int i = 0; i < configurations.length; i++) {
            ILaunchConfiguration configuration = configurations[i];
            if (configuration.getName().equals(mainClass.getName()+" (umple)")) {
              configuration.launch(ILaunchManager.RUN_MODE, null);
              hasRun = true;
              break;
            }
          }
          if(!hasRun)
          {
            ILaunchConfigurationWorkingCopy wc = type.newInstance(null, mainClass.getName()+" (umple)");
            wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, pjName);
            wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME,mainClass.getPackageName().replaceFirst("/", "")+File.separator+mainClass.getName());
            wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, wizardArguments);
            ILaunchConfiguration config = wc.doSave();   
            config.launch(ILaunchManager.RUN_MODE, null);
          }
        }

      }

    }
    catch (Exception e)
    {
      e.printStackTrace();
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
    UmpleAction.window = window;

  }


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
