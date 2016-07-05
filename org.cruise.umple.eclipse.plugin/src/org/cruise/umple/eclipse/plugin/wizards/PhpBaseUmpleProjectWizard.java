package org.cruise.umple.eclipse.plugin.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class PhpBaseUmpleProjectWizard extends Wizard implements INewWizard {

	private WizardNewProjectCreationPage fPage;
	
	@Override
	public void addPages() {
		// TODO Auto-generated method stub
		super.addPages();
		fPage = new WizardNewProjectCreationPage("Create Php-based umple project ");
		fPage.setTitle("Php-based Umple Project");
		fPage.setDescription("This project creates an Umple project with Php features.");
		addPage(fPage);
	}
	
	public PhpBaseUmpleProjectWizard() {
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
