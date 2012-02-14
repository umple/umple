package cruise.umple.umplificator.core.ui.action;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import cruise.umple.umplificator.core.generator.umple.*;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class UmplifyElementAction implements IObjectActionDelegate {
	
	private static Logger logger = Logger.getLogger(UmplifyElementAction.class);
	private IStructuredSelection selection;
	private Shell shell;
	private String levelOfRefactoring ;
	
	/**
	 * The constructor.
	 */
	public UmplifyElementAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = 
			selection instanceof IStructuredSelection 
			? (IStructuredSelection) selection 
					: null; 
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		MessageDialog.openInformation(
				shell,
				"Umplificator",
				"Umplificating Process Started");
		logger.info("Umplificating a class has started");
		IStructuredSelection structured = (IStructuredSelection)selection;
		levelOfRefactoring = action.getText();
		umplifyElement(structured.getFirstElement());
	}


	private void umplifyElement(Object element) {
		if (element instanceof ICompilationUnit){
			umplifyUnit((ICompilationUnit)element);
		}
		else if (element instanceof IPackageFragment){
			umplifyPackage((IPackageFragment)element);
		}
		else if (element instanceof IJavaProject){
			umplifyProject((IJavaProject)element);
		}
	}

	private boolean umplifyUnit(ICompilationUnit unit){
		UmpleGenerator.translateJavaClass(unit, getLevelOfUmplification());
		return false;
	}
	private boolean umplifyPackage(IPackageFragment aPackage){
		UmpleGenerator.translateJavaClassesInPackage(aPackage, getLevelOfUmplification());
		return false;
	}
	private boolean umplifyProject(IJavaProject project){
		UmpleGenerator.translateJavaClassesInProject(project,getLevelOfUmplification());
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
	
	
	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}


}