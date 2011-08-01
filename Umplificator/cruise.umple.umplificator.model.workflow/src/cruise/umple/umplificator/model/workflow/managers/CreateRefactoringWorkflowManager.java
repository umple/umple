package cruise.umple.umplificator.model.workflow.managers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.strings.StringValue;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;


import cruise.umple.umplificator.model.workflow.*;

public class CreateRefactoringWorkflowManager {
	
	public static final String CONFIG_REFACTORING_TASK_NAME = "Umplify a Project";
	
    public static final String classSubTask = "Umplify Classes: ";
   
    public static final String attributesTask ="Umplify Attributes";

    public static final String configViewId = "com.nakina.adaptersdk.core.ui.views.AuthenticationConfigView";
    
    public static final String configSummaryViewId ="com.nakina.adaptersdk.core.ui.views.AuthenticationSummaryView";
    
    public static final String summaryViewId ="com.nakina.adaptersdk.core.ui.views.CreateAdapaterSummaryView";
	
	private Workflow workflow;
	private WorkflowFactory workflowFactory;
	private RefactoringTask configAdapterTask;
	private RefactoringTask configAuthenticationTask;
	private RefactoringTask packageTask;
	
	public CreateRefactoringWorkflowManager(Workflow workflow){
		this.workflow=workflow;
		this.workflowFactory =  WorkflowFactory.eINSTANCE;
	}
	
	
	
	public RefactoringTask createAdapterTask(String adapterTaskName){
		
		RefactoringTask newTask = getRefactoringTask(adapterTaskName);
		
		if (newTask ==null){
			newTask = workflowFactory.createRefactoringTask();
			newTask.setName(adapterTaskName);
		}
		return newTask;
	}
	
	
	public RefactoringSubTask getAdapterSubTask(RefactoringTask task, String refactoringSubTaskName){
		Collection<EObject> results = queryTaskForSubTask(task, refactoringSubTaskName);
		
		if (results==null){
			return null;
		}
		Iterator<EObject> iter = results.iterator();
		
		RefactoringSubTask subtask;
		while(iter.hasNext()){
			subtask=(RefactoringSubTask) iter.next();
			if (subtask.getName().equals(refactoringSubTaskName)){
				return subtask;
			}
				
		}
		
		return null;
	}
	
	public RefactoringTask getRefactoringTask(String refactoringTaskName){
		Collection<EObject> results = queryWorkflowForTask(refactoringTaskName);
		
		if (results == null){
			return null;
		}
		
		Iterator<EObject> iter = results.iterator();
		
		RefactoringTask task;
		
		while(iter.hasNext()){
			task = (RefactoringTask) iter.next();
			if (task.getName().equals(refactoringTaskName)){
				return task;
			}
			
		}
		
		return null;
		
	}
	
	private  Collection<EObject> queryWorkflowForTask(String refactoringTaskName)
    {

	if (workflow == null) {
	    return null; 
	}
	
	// Select Variable having as name: stringToCompare
	SELECT query = new SELECT(
		new FROM(workflow.eContents()), 
		new WHERE(new EObjectAttributeValueCondition(
			WorkflowPackage.eINSTANCE.getRefactoringTask_Name(),
			new StringValue(refactoringTaskName))
		));

	Collection<EObject> taskResult = query.execute();

	return taskResult;
    }
	
	private  Collection<EObject> queryTaskForSubTask(RefactoringTask refactoringTask, String refactoringSubTaskName)
    {

	if (refactoringTask == null) {
	    return null; //$NON-NLS-1$
	}
	
	// Select Variable having as name: stringToCompare
	SELECT query = new SELECT(
		new FROM(refactoringTask.eContents()), 
		new WHERE(new EObjectAttributeValueCondition(
			WorkflowPackage.eINSTANCE.getRefactoringSubTask_Name(),
			new StringValue(refactoringSubTaskName))
		));

	Collection<EObject> taskResult = query.execute();

	return taskResult;
    }
	

}
