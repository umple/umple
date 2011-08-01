/**
 * 
 */
package cruise.umple.umplificator.core.types;


import java.io.File;
import java.io.IOException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.jdt.core.IJavaProject;
import cruise.umple.umplificator.model.workflow.*;
import cruise.umple.umplificator.model.workflow.util.WorkflowResourceFactoryImpl;


public class JavaProject implements
IResourceChangeListener {

	////////////////////////////////////////////////////////////////////////////
	// Shared Static
	////////////////////////////////////////////////////////////////////////////
	private IProject project = null;

	private String projectName;

	private IFolder sourceDirectory = null;

	private IPath rootProjectDirectory = null;

	// Represents the workflow.xml
	private IFile workflowFile = null;
	// EMF content representation of the workflow.xml
	private Workflow workflowModel = null;



	public JavaProject(IResource resource) throws Exception {
		super();
		this.loadComponents();
	}

	public JavaProject(IJavaProject iJavaProject) throws Exception {
		super();
		this.projectName = iJavaProject.getProject().getName();
		this.rootProjectDirectory = iJavaProject.getProject().getFullPath();
		this.loadComponents();
	}

	public String getProjectName() {
		return this.projectName;
	}

	public IFolder getSourceDirectory() {
		return this.sourceDirectory;
	}

	private IPath getRootProjectLocation(){
		return this.rootProjectDirectory;
	}

	// Updates the workflow model  
	public void updateResources(){

		ResourceSet resourceSetWF = new ResourceSetImpl();
		resourceSetWF.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new WorkflowResourceFactoryImpl());
		Resource resourceWF;
		resourceWF = resourceSetWF.createResource(URI
				.createURI(this.workflowFile.getLocationURI()
						.toString()));
		resourceWF.getContents().add(this.workflowModel);
		try {
			resourceWF.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// When a JavaProject is loaded, the workflow is also loaded
	public void loadComponents() throws Exception {

		// For All Factories - Fix bug concerning the loading of WorkFlow twice
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
		// In addition, we need to register all package for the three different EMF Models
		WorkflowPackage.eINSTANCE.eClass();

		//Build all required factories for the workflow
		ResourceSet resourceSetWF = new ResourceSetImpl();
		resourceSetWF.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new WorkflowResourceFactoryImpl());

		Resource resourceWF;

		// Load the workflow file
		Path path = new Path(getRootProjectLocation() + File.separator  + "workflow.xml");
		this.workflowFile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);

		if (this.workflowFile.exists()) {
			try {
				URI fileURI = URI.createURI(this.workflowFile.getLocationURI().toString());
				resourceWF = resourceSetWF.getResource(fileURI, true);

				this.workflowModel = (Workflow) resourceWF
				.getContents().get(0);
			} catch (Exception e) {

			}
		} else {
			this.workflowModel = WorkflowFactory.eINSTANCE.createWorkflow();
		}

	}

	/**
	 * Updates the adapter project files if required.
	 * 
	 * @param monitor
	 */


	public void resourceChanged(IResourceChangeEvent arg0) {
	}

	public Workflow getWorkflowModel(){
		return workflowModel;
	}

	public void refreshProject(){
		try {
			this.project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {

		}
	}


}
