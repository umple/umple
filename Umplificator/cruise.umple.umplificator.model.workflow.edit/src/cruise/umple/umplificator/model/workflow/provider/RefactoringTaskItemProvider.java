/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cruise.umple.umplificator.model.workflow.provider;


import cruise.umple.umplificator.model.workflow.RefactoringTask;
import cruise.umple.umplificator.model.workflow.WorkflowFactory;
import cruise.umple.umplificator.model.workflow.WorkflowPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * This is the item provider adapter for a {@link cruise.umple.umplificator.model.workflow.RefactoringTask} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class RefactoringTaskItemProvider
	extends ItemProviderAdapter
	implements
	 ITreeItemContentProvider,
     IItemLabelProvider,
     ITableItemLabelProvider,
     IItemColorProvider,
     IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RefactoringTaskItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addComponentIDPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addStatusPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Component ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addComponentIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RefactoringTask_componentID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RefactoringTask_componentID_feature", "_UI_RefactoringTask_type"),
				 WorkflowPackage.Literals.REFACTORING_TASK__COMPONENT_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RefactoringTask_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RefactoringTask_description_feature", "_UI_RefactoringTask_type"),
				 WorkflowPackage.Literals.REFACTORING_TASK__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RefactoringTask_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RefactoringTask_name_feature", "_UI_RefactoringTask_type"),
				 WorkflowPackage.Literals.REFACTORING_TASK__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Status feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RefactoringTask_status_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RefactoringTask_status_feature", "_UI_RefactoringTask_type"),
				 WorkflowPackage.Literals.REFACTORING_TASK__STATUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(WorkflowPackage.Literals.REFACTORING_TASK__REFACTORING_SUB_TASK);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns RefactoringTask.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RefactoringTask"));
	}
	
	
    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    
	@Override
    public String getColumnText(Object object, int columnIndex)
    {
        String name = ((RefactoringTask)object).getName();
        String str_status;
        boolean status = ((RefactoringTask)object).isStatus();
        if (status==true){
    	str_status = "Completed";              	    
        }
        else {       	    
    	str_status = "Not completed";
        }

        if (columnIndex == 0){
    	return name == null || name.length() == 0 ?
    		getString("_UI_RefactoringTask_type") :
    		    name;}
        else if (columnIndex==1){
    	return str_status == null || str_status.length() == 0 ?
    		getString("_UI_RefactoringTask_type") :
    		    str_status;}  
        else{  
    	return "";}
    }
	
	@Override
	public Object getColumnImage(Object object, int columnIndex){
		boolean status = ((RefactoringTask)object).isStatus();
		if (columnIndex==1)
		{
			if (status)
			{
				return overlayImage(object, getResourceLocator().getImage("checked.jpg"));    
			}
			else
			{
				return overlayImage(object, getResourceLocator().getImage("unchecked.gif"));    	    
			}
		}
		return null;
	}
    
    @Override
    public Color getBackground(Object object){
        boolean status = ((RefactoringTask)object).isStatus();  
        if (status) {
	    // Red background if no completed
	    return Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW);
	    }
	    //Return back ground color
	    return Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
    }
    
	
	
	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(RefactoringTask.class)) {
			case WorkflowPackage.REFACTORING_TASK__COMPONENT_ID:
			case WorkflowPackage.REFACTORING_TASK__DESCRIPTION:
			case WorkflowPackage.REFACTORING_TASK__NAME:
			case WorkflowPackage.REFACTORING_TASK__STATUS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case WorkflowPackage.REFACTORING_TASK__REFACTORING_SUB_TASK:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(WorkflowPackage.Literals.REFACTORING_TASK__REFACTORING_SUB_TASK,
				 WorkflowFactory.eINSTANCE.createRefactoringSubTask()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return RefactoringWorkflowEditPlugin.INSTANCE;
	}

}
