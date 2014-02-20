package cruise.umplificator.ui.eclipse;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;


public class UmplifyUnitActionHandler extends AbstractHandler {

	private static Logger logger = Logger.getLogger(UmplifyUnitActionHandler.class);
	private Shell shell;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get workbench window
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		// set selection service
		ISelectionService service = window.getSelectionService();
		// set structured selection
		IStructuredSelection structured = (IStructuredSelection) service.getSelection();
	 
		shell = window.getShell();
		logger.info("Umplificating Process Started");
		Object objectSelected = structured.getFirstElement();
		logger.info(objectSelected.toString());
		umplifyElement(objectSelected);
		return null;
	}

	private void umplifyElement(Object element) {
		if (element instanceof ICompilationUnit){
			//umplifyUnit((ICompilationUnit)element);
			displayInfo("Java File selected");
		}
		else if (element instanceof IPackageFragment){
			//umplifyPackage((IPackageFragment)element);
			displayInfo("Package selected");
		}
		else if (element instanceof IJavaProject){
			//umplifyProject((IJavaProject)element);
			displayInfo("Java Project selected");
		}
		else if (element instanceof IPackageFragmentRoot){
			//umplifyProject((IJavaProject)element);
			displayInfo("Folder selected");
		}
		else if (element instanceof IFile){
			IFile aFile= (IFile) element;
			if (aFile != null && aFile.getFileExtension().equals("ump"))
			{
				displayInfo("Umple File selected");	
			}
			else { displayInfo("Invalid File");}	
		}
	}

	private void displayInfo (String status)
	{
		MessageDialog.openInformation(
				shell,
				"Umplificator",
				status);

		logger.info("Displaying status");
	}

	/*
	private boolean umplifyUnit(ICompilationUnit unit){
		//UmpleGenerator.translateJavaElement(unit, getLevelOfUmplification());
		displayInfo ()
		return false;
	}
	private boolean umplifyPackage(IPackageFragment aPackage){
		//UmpleGenerator.translateJavaElementsInPackage(aPackage, getLevelOfUmplification());
		displayInfo (String status)
		return false;
	}
	private boolean umplifyProject(IJavaProject project){
		try {
			UmpleGenerator.translateJavaElementsInProject(project,getLevelOfUmplification());
		} catch (JavaModelException e) {
			logger.error(e);
		}
		return false;
	}

	private int getLevelOfUmplification(){
		if (levelOfRefactoring.equals("Umplify Classes")){
			return 0;	
		}
		else if (levelOfRefactoring.equals("Umplify Attributes")){
			return 1;	
		}
		else{
			return 2;	
		}
	}
	 */
}