package cruise.umplificator.ui.eclipse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import cruise.umplificator.core.Umplificator;


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

	// Main entry point for the cruise.umplificator.eclipse
	// Invokes the Umplificator class located in cruise.umplificator which is the core project
	private void umplifyElement(Object element) {
		List<File> srcFiles = getListOfFilesFromSelection(element);
		// Umplificator is located in cruise.umplificator
		// It receives a list of files (Java or Umple files) and retrieves Umple files.
		Umplificator umplificator = new Umplificator();
		boolean result = umplificator.umplify(srcFiles);
		String message = result ? "Umplification process succeeded!" : "Umplification process failed!";
		// Feedback
		logger.error(message);
		displayInfo (message);
	}

	public List<File> getListOfFilesFromSelection (Object element){ 
		List <File> srcFiles = new ArrayList<File>();
		try {
			if (element instanceof ICompilationUnit){
				ICompilationUnit compilationUnit= (ICompilationUnit) element;
				srcFiles = FileConverter.getFileFromCompilationUnit(compilationUnit);
				displayInfo("Java File will be processed ...");
			}
			else if (element instanceof IPackageFragment){
				IPackageFragment packageFragment= (IPackageFragment) element;
				srcFiles = FileConverter.getFilesFromPackageFragment(packageFragment);
				displayInfo("Package will be processed ...");
			}
			else if (element instanceof IJavaProject){
				IJavaProject javaProject= (IJavaProject) element;
				srcFiles = FileConverter.getFilesFromProject(javaProject);
				displayInfo("Java Project will be processed ...");
			}
			else if (element instanceof IFile){
				IFile aFile= (IFile) element;
				if (aFile != null && aFile.getFileExtension().equals("ump"))
				{
					srcFiles = FileConverter.getFileFromIFile(aFile);
					displayInfo("Umple File will be processed ...");	
				}
				else { displayInfo("Invalid File selected ");}	
			}
		}
		catch (JavaModelException ex){
			logger.error(ex);
			return null;
		}

		return srcFiles;
	}

	private void displayInfo (String status)
	{
		MessageDialog.openInformation(
				shell,
				"Umplificator",
				status);
		logger.info("Displaying status");
	}
}