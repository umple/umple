package org.cruise.umple.eclipse.plugin.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.*;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.ide.IDE;

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
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project  = root.getProject(fPage.getProjectName());
//		IFolder folder = project.getFolder("src-umple");
		IFile file = project.getFile("main.ump");		
			
		try {
			//at this point, no resources have been created	
			if (!project.exists()) project.create(null);
			if (!project.isOpen()) project.open(null);
//			if (!folder.exists()) folder.create(IResource.NONE, true, null);
			if (!file.exists()) {
				//String content ="class Main{"+System.lineSeparator()+System.lineSeparator()+"}";
				String content ="";
			    byte[] bytes = content.getBytes();
			    InputStream source = new ByteArrayInputStream(bytes);
			    file.create(source, IResource.NONE, null);
			}
			//Open the filer in the editor
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IDE.openEditor(page, file);
		} catch (CoreException e) {
			e.printStackTrace();
		}	
		return true;
	}

}
