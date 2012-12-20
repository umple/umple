package cruise.umple.umplificator.core.ui.wizards;



import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import cruise.umple.umplificator.core.types.JavaProject;


public class UmplificatorWizard extends Wizard {

	@Override
	public boolean isHelpAvailable() {
		return false;
	}

	private static JavaProject javaProject;
	protected List<WizardPage> wizardPages = new ArrayList<WizardPage>();


	private boolean hasFinishedOperations = false;

	private UmplificatorWizardAttributePage attributePage;
	private UmplificatorWizardAssociationPage associationPage;
	private ISelection selection;



	/**    private final static String logoutStrategyJava  button.setText("I Was Clicked"); File = "LogoutStrategy";
	 * Constructor for CreateAdapterWizard.
	 */
	public UmplificatorWizard( String typeToDisplayInTitleBar) {
		super();
		this.setNeedsProgressMonitor(true);
		this.setHelpAvailable(true);        
		this.setWindowTitle("Umplify Java Project - " + typeToDisplayInTitleBar);
	}

	@Override
	public void addPages() {
		this.addStartPage();
		this.associationPage = new UmplificatorWizardAssociationPage(this.selection);
		this.addPage(this.associationPage);
	}

	public void addStartPage() {
		this.attributePage = new UmplificatorWizardAttributePage(this.selection);
		this.addPage(this.attributePage);
	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard. 
	 */
	public boolean performFinish() {


		IRunnableWithProgress op = new IRunnableWithProgress() {

			public void run(IProgressMonitor monitor)
			throws InvocationTargetException {

			}

		};

		hasFinishedOperations = true;
		return true;
	}


	// this is used by the Session Broker - perhaps instead of having this static, it should just make a call to createAdapterProject????
	public static JavaProject getJavaProject(){
		return javaProject;
	}

	/**
	 * We will accept the selection in the workbench to see if we can initialize
	 * from it.
	 * 
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	public boolean hasWizardFinished() {
	
		return false;
	}

}