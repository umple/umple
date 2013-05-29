package cruise.umple.ui.eclipse;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.ui.IWorkbench;

public class UmpleMainClassWizard extends Wizard implements IWizard {

	private WizardPage page;
	private ISelection selection;
	private String classname;
	private String arguments;
	private String[] possibilities;

	/**
	 * Constructor for UMPLEWizard.
	 * @param possibilities 
	 */
	public UmpleMainClassWizard(String[] possibilities) {
		super();
		setNeedsProgressMonitor(true);
		this.possibilities = possibilities;
		arguments = "";
	}

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new UmpleMainClassWizardPage(this, possibilities);
		addPage(page);
	}
	
	@Override
	public boolean performFinish() {
		return true;
	}
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
	
	public void setClassName(String s){
		classname = s;
		
	}
	public String getClassName(){
		return classname;
	}
	public void setArguments(String s){
		arguments = s;
		
	}
	public String getArguments(){
		return arguments;
	}
}
