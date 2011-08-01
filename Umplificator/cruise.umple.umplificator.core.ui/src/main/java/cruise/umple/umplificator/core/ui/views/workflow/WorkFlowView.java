package cruise.umple.umplificator.core.ui.views.workflow;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import cruise.umple.umplificator.core.types.JavaProject;
import cruise.umple.umplificator.core.ui.ProjectLocator;
import cruise.umple.umplificator.core.ui.wizards.UmplificatorWizard;
import cruise.umple.umplificator.model.workflow.RefactoringSubTask;
import cruise.umple.umplificator.model.workflow.RefactoringTask;
import cruise.umple.umplificator.model.workflow.Workflow;
import cruise.umple.umplificator.model.workflow.WorkflowFactory;
import cruise.umple.umplificator.model.workflow.provider.WorkflowItemProviderAdapterFactory;
import cruise.umple.umplificator.model.workflow.util.WorkflowResourceFactoryImpl;



public class WorkFlowView extends ViewPart {

	private static WorkFlowView _instance;

	public static final String VIEW_ID="cruise.umple.umplification.core.ui.views.WorkFlowView";
	private static JavaProject currentJavaProject;
	private static TreeViewer treeviewer;
	private Label titleLabel;
	private Label tableTitle;
	private Label selectedProjectlbl;
	private String selectedProject=  "No Java Project has been selected";
	private static final String WORKFLOW_TABLE_NAME = "Umplification Refactoring Steps";
	private static final String WORKFLOW_TITLE = "THE UMPLIFICATOR";
	private Button selectProjectbtn;
	private Action refresh;
	private Action help;
	private LinkAction doubleClickAction;
	private List<JavaProject> projects;
	// Set the table column property names
	protected ComposedAdapterFactory adapterFactory;
	protected AdapterFactoryEditingDomain editingDomain;
	private static RefactoringTask refTaskSelected;
	private static RefactoringSubTask refSubTaskSelected;

	// Workflow Object
	private Workflow workflow;

	class LinkAction extends Action {

		public void run() {
			// TODO Auto-generated method stub
			ISelection selection = treeviewer.getSelection();
			Object obj = ((IStructuredSelection)selection).getFirstElement();

			if (obj instanceof RefactoringTask)
			{
				RefactoringTask  task = (RefactoringTask) obj;
				refTaskSelected  = task; 
				if (task.getComponentID()!=""){
					showViewOfTask(refTaskSelected);
				}
				else
				{
					try{


					} catch (final Exception e) {
						e.getStackTrace();
					}

				}

			}
			else if (obj instanceof RefactoringSubTask)
			{
				RefactoringSubTask  subtask = (RefactoringSubTask) obj;
				refSubTaskSelected = subtask;
				//showViewOfSubTask(refSubTaskSelected);
			}
		}

	}



	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		//Package Adapter
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new WorkflowItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		//
		// Create the editing domain with a special command stack.
		//
		ResourceSet resourceSetWF = new ResourceSetImpl();
		resourceSetWF.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new WorkflowResourceFactoryImpl());
		//	WorkflowPackage workflowPackage = WorkflowPackage.eINSTANCE;

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, resourceSetWF);

	}

	public void createPartControl(Composite parent) {
		if (_instance == null)
			_instance=this;

		//FONTS
		FontData titleFontData = new FontData("Arial", 14, SWT.None);
		FontData subtitleFontData = new FontData("Arial", 12, SWT.ITALIC);   	
		Font titleFont = new Font(parent.getDisplay(), titleFontData);
		Font subtitleFont = new Font(parent.getDisplay(), subtitleFontData);


		GridData gridData; 
		GridLayout layout = new GridLayout();
		parent.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 12;
		titleLabel = new Label(parent, SWT.LEFT); 
		titleLabel.setText(WORKFLOW_TITLE); 
		titleLabel.setFont(titleFont);
		gridData = new GridData(); 
		titleLabel.setLayoutData(gridData); 


		// Select an existing Java project
		selectProjectbtn = new Button(parent, SWT.PUSH);
		selectProjectbtn.setImage(this.getImage(ISharedImages.IMG_OBJ_FOLDER));
		selectProjectbtn.setText("Select an existing Java Project");
		selectProjectbtn.setLayoutData(new GridData(300, SWT.DEFAULT));
		selectProjectbtn.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				UmplificatorWizard wizard = new UmplificatorWizard("Umplification");
				wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
				WizardDialog dialog = new WizardDialog(WorkFlowView.this.getSite().getShell(), wizard);
				dialog.setBlockOnOpen(true);
				ProjectLocator locator = ProjectLocator.getInstance();
				locator.run(refresh);
				projects = locator.getSelectedProjects();		       
				selectedProject =  projects.get(0).getProjectName();
				selectedProjectlbl.setText("Current Java Project:" +  " "+  selectedProject);
				currentJavaProject = projects.get(0);
				try {
					currentJavaProject.loadComponents();
					workflow = currentJavaProject.getWorkflowModel();
					createPreconfiguredTask();
				} catch (Exception e) {
					e.printStackTrace();
				}
				loadModel();
				modelBinding();
				//closeAllViews();
				dialog.create();
				int result = dialog.open();
				if ( result == IStatus.OK && wizard.hasWizardFinished()){

				}
			}  

		});

		gridData = new GridData(400, SWT.DEFAULT); 
		selectedProjectlbl = new Label(parent, SWT.LEFT);
		selectedProjectlbl.setLayoutData(gridData);

		gridData = new GridData(400, SWT.DEFAULT); 
		tableTitle = new Label(parent, SWT.CENTER);
		tableTitle.setLayoutData(gridData);
		tableTitle.setText(WORKFLOW_TABLE_NAME);
		tableTitle.setFont(subtitleFont);

		Tree tree = new Tree(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.MULTI );
		tree.setLayoutData(new GridData(SWT.DEFAULT, 239));
		tree.setSize(500, 500);
		tree.setHeaderVisible(true);

		TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
		column1.setText("Description");
		column1.setWidth(270);
		TreeColumn column2 = new TreeColumn(tree, SWT.LEFT);
		column2.setText("Status");
		column2.setWidth(150);

		treeviewer = new TreeViewer(tree);
		/*	 treeviewer = new TreeViewer(tree);
		 treeviewer.setContentProvider(new ViewContentProvider());
		 treeviewer.setLabelProvider(new ViewLabelProvider());
		 treeviewer.setInput(WorkFlowTask.init());
		 */

		treeviewer.expandAll();
		treeviewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);

		makeActions();
		hookDoubleClickAction();
		contributeToActionBars();	
	}


	private void modelBinding()
	{
		initializeEditingDomain();
		treeviewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		treeviewer.setLabelProvider(new AdapterFactoryLabelProvider.ColorProvider(adapterFactory, treeviewer));
		treeviewer.setInput(currentJavaProject.getWorkflowModel());
		treeviewer.expandAll();
	}

	public Image getImage(String imageName) {
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageName);
	}



	private void closeAllViews(){

		IViewReference[] views = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();

		if (views!=null && views.length>0){

			IViewReference view;

			for (int i=0;i<views.length;i++){
				view = views[i];
				if (!view.getId().equals(VIEW_ID))
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(view);
			}
		}
	}


	public void createPreconfiguredTask(){
		workflow = currentJavaProject.getWorkflowModel();
		WorkflowFactory factory = WorkflowFactory.eINSTANCE;

		RefactoringTask newTask = factory.createRefactoringTask();
		newTask.setName("Class Refactoring");
		newTask.setDescription("True");
		newTask.setStatus(false);    
		newTask.setComponentID(null );

		RefactoringTask attributeTask = factory.createRefactoringTask();
		attributeTask.setName("Attribute Refactoring");
		attributeTask.setDescription("True");
		attributeTask.setStatus(true);    
		attributeTask.setComponentID(null );

		RefactoringTask associationTask = factory.createRefactoringTask();
		associationTask.setName("Association Refactoring");
		associationTask.setDescription("True");
		associationTask.setStatus(false);    
		associationTask.setComponentID(null );
		
		workflow.getRefactoringTask().add(newTask);
		workflow.getRefactoringTask().add(attributeTask);
		workflow.getRefactoringTask().add(associationTask);
		currentJavaProject.updateResources();
	}



	public void loadModel()
	{
		// Notification that model has changed
		EContentAdapter adapter = new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				System.out
				.println("Notfication received from the data model. Data model has changed!!!");
			}
		};
		workflow.eAdapters().add(adapter);
	}


	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(refresh);
		manager.add(help);
		manager.add(new Separator());
	}


	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(refresh);
		manager.add(help);
	}

	// this fires when the user click the question mark at the bottom of the current page
	/* public void performHelp() {
    	String path = HelpContextManager.getInstance().getHTMLPath("ADKWorkFlow");
    	PlatformUI.getWorkbench().getHelpSystem().displayHelpResource(path);
    }
	 */

	private void makeActions() {
		// Refresh Action 
		this.refresh = new Action() {
			@Override
			public void run() {
				refreshTree();
			}
		};
		this.refresh.setText("Refresh Checklist");
		//this.refresh.setToolTipText("Clears the recorded login commands");
		this.refresh.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_TOOL_REDO));


		//Help Action
		this.help = new Action() {
			@Override
			public void run() {
				//performHelp();
			}
		};
		this.help.setText("Nakina ADK Help");
		//this.refresh.setToolTipText("Clears the recorded login commands");
		this.help.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_LCL_LINKTO_HELP));

		// Link Action
		doubleClickAction = new LinkAction();


	}


	private void hookDoubleClickAction() {
		treeviewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();	    }
		});
	}
	//    private void showMessage(String message) {
	//	MessageDialog.openInformation(
	//		treeviewer.getControl().getShell(),
	//		"Interactive Console",
	//		message);
	//    }

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {

		treeviewer.getControl().setFocus();

	}


	public static RefactoringTask getRefactoringTaskSelected(){
		return refTaskSelected;

	}

	public static RefactoringSubTask getRefactoringSubTaskSelected(){
		return refSubTaskSelected;
	}


	// Look for the Item in the Tree by name and select found item
	private static void selectTaskInWorkFlow(String treeItemName){
		treeviewer.getTree().deselectAll();
		TreeItem [] items = treeviewer.getTree().getItems();    	
		TreeItem item = null;
		for (int index =0; index < items.length; index++)  	 
		{
			item = items[index]; 
			if(item.getText().equals(treeItemName)){  			 
				treeviewer.getTree().setSelection(item);
			}   		 

			// Item has children
			if (item.getItems().length > 0){ //item has child items
				int childCount = item.getItemCount ();
				for (int i = 0; i < childCount; i++) {
					TreeItem child = item.getItem (i);
					if(child.getText().equals(treeItemName)){  			 
						treeviewer.getTree().setSelection(child);
					}   	

				}

			}
		}

	}


	private static void showViewOfSubTask(RefactoringSubTask subTask){
		try {
			refSubTaskSelected = subTask;
			String viewid = refSubTaskSelected.getComponentID();
			String subId = refSubTaskSelected.getDescription();
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(viewid,subId,IWorkbenchPage.VIEW_ACTIVATE);
		} catch (PartInitException e) {
			// TODO Auto-generated catch blockInterfaceName
			e.printStackTrace();
		}

	}

	private static void showViewOfTask(RefactoringTask task){

		try {
			refTaskSelected  = task;
			if (task.getComponentID()!=""){
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(refTaskSelected.getComponentID());
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	public static void refreshTree(){
		if(_instance!=null){
			_instance.treeviewer.expandAll();
		}
	}

	public static WorkFlowView getInstance(){
		return _instance;
	}  


}
