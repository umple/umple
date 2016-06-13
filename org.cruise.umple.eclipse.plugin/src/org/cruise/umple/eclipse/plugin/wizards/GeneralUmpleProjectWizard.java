package org.cruise.umple.eclipse.plugin.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class GeneralUmpleProjectWizard extends Wizard implements INewWizard {
	
	private WizardNewProjectCreationPage fPage;
	
	@Override
	public void addPages() {
		// TODO Auto-generated method stub
		super.addPages();
		fPage = new WizardNewProjectCreationPage("Create general umple project ");
		fPage.setTitle("General Umple Project");
		fPage.setDescription("This project creates a general Umple project.");
		addPage(fPage);
	}
	
	public GeneralUmpleProjectWizard() {
		setWindowTitle("Umple Project Creator");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return true;
	}

}
