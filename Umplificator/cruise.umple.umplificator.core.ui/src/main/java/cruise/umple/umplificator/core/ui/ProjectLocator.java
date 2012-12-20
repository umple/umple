package cruise.umple.umplificator.core.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.progress.IProgressService;

import cruise.umple.umplificator.core.types.JavaProject;

public class ProjectLocator implements IObjectActionDelegate,
        IWorkbenchWindowActionDelegate {

    private Object[] result = null;
    
    private List<JavaProject> projects = null;

    private ArrayList<IResource> selectedElements = null;

    private List<JavaProject> selectedProjects = new ArrayList<JavaProject>();

    private static ProjectLocator ref;

   
    /**
     * Constructor for Action1.
     */
    public ProjectLocator() {
        super();
        this.selectedElements = new ArrayList<IResource>();
    }

    public static ProjectLocator getInstance() {
        if (ref == null) {
            ref = new ProjectLocator();
        }
        return ref;
    }

   
    public void run(IAction action){
        
        if (this.selectedElements.size() == 0) {
           
        }

        IProgressService progressService = PlatformUI.getWorkbench()
                .getProgressService();
        try {

            // Get a list of all build-able projects
            progressService.busyCursorWhile(new IRunnableWithProgress() {
                public void run(IProgressMonitor monitor)
                        throws InvocationTargetException, InterruptedException {
                	
                	List<JavaProject> allProjects = null;
                	try
                	{
                		allProjects =  getJavaProjects();
                	}
                	catch (Exception e)
                	{
                		monitor.done();
						e.printStackTrace();
						throw new InterruptedException(e.getMessage());
                	}
                 
                	ProjectLocator.this.projects = allProjects;
                    monitor.done();
                	
                }
            });

            // By default, check-off all currently selected projects
            progressService.busyCursorWhile(new IRunnableWithProgress() {
                public void run(IProgressMonitor monitor)
                        throws InvocationTargetException, InterruptedException {
                	monitor.beginTask("Enabling Selected Projects",
                			ProjectLocator.this.selectedElements.size()
                			* ProjectLocator.this.projects.size());
                    ArrayList<JavaProject> projectsToEnable = new ArrayList<JavaProject>();

                    for (Iterator<IResource> iterator = ProjectLocator.this.selectedElements
                            .iterator(); iterator.hasNext();) {
                        IResource selectedProject = iterator.next().getProject();
                        for (Iterator<JavaProject> iterator2 = ProjectLocator.this.projects
                                .iterator(); iterator2.hasNext();) {
                        	JavaProject currentProject = iterator2.next();
                            if (selectedProject.equals(currentProject)) {
                                projectsToEnable.add(currentProject);
                            }
                        }
                        monitor.worked(1);
                    }
                	ProjectLocator.this.selectedProjects = getJavaProjects();
                	monitor.done();
                }
            });

            // If only one project is select, don't show a dialog
            if (this.selectedProjects.size() != 1) {
                
                ListDialog listDialog = new ListDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell());
                listDialog.setInput(this.projects.toArray());
                listDialog.setLabelProvider(new LabelProvider());
                listDialog.setContentProvider(new ArrayContentProvider());
                listDialog.setInitialSelections(this.selectedProjects.toArray());
                listDialog.setTitle("Select Project: ");
                
                listDialog.open();  
                
                final Object[] result = listDialog.getResult();
                
                if (result!=null) { 

                	for (int i = 0; i < result.length; i++) {
                		// This should only ever have 1 project, since we use a ListDialog
                		selectedProjects.add((JavaProject)result[i]);
                	}
                
                }
            }
            
           

        } catch (InvocationTargetException e) {

        } catch (InterruptedException e) {
        	e.printStackTrace();
          
        }
    }

    private List<JavaProject>  getJavaProjects() 
	{
    	// Instantiate the JDT if needed
		JavaCore.getJavaCore();

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IJavaModel javaModel = JavaCore.create(workspace.getRoot());
		IJavaProject projects[] = null;
		List<JavaProject> javaProjects = new ArrayList<JavaProject>();
		try {
			projects = javaModel.getJavaProjects();
			if (projects != null && projects.length >0)
			{
				for (int i=0; i< projects.length; i++){
					JavaProject jProject = new JavaProject(projects[i]);
					javaProjects.add(jProject);
				}
			}

		} catch (JavaModelException e) {
			return javaProjects;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return javaProjects;
		   
	}
    
    /**
     * @see IActionDelegate#selectionChanged(IAction, ISelection)
     */
    @SuppressWarnings("unchecked")
    public void selectionChanged(IAction action, ISelection selection) {
        this.selectedElements = new ArrayList<IResource>();
        if (selection instanceof IStructuredSelection) {
 
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            for (Iterator iterator = structuredSelection.iterator(); iterator
                    .hasNext();) {
                Object element = iterator.next();
                if (element instanceof IResource) {
                    IResource resource = (IResource) element;
                     this.selectedElements.add(resource);
                } else {
        
                }
            }
        } else {
            
        }
    }

    /**
     * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    }

    public List<JavaProject> getProjects() {
        return this.projects;
    }

    public Object[] getObjects() {
        return this.result;
    }

    public List<JavaProject> getSelectedProjects() {
        return this.selectedProjects;
    }
    

	@Override
	public void dispose() {

	}

	@Override
	public void init(IWorkbenchWindow window) {

	}
    
}
