/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cruise.umple.umplificator.model.workflow.impl;

import cruise.umple.umplificator.model.workflow.RefactoringSubTask;
import cruise.umple.umplificator.model.workflow.RefactoringTask;
import cruise.umple.umplificator.model.workflow.WorkflowPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Refactoring Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umplificator.model.workflow.impl.RefactoringTaskImpl#getRefactoringSubTask <em>Refactoring Sub Task</em>}</li>
 *   <li>{@link cruise.umple.umplificator.model.workflow.impl.RefactoringTaskImpl#getComponentID <em>Component ID</em>}</li>
 *   <li>{@link cruise.umple.umplificator.model.workflow.impl.RefactoringTaskImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link cruise.umple.umplificator.model.workflow.impl.RefactoringTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umplificator.model.workflow.impl.RefactoringTaskImpl#isStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RefactoringTaskImpl extends EObjectImpl implements RefactoringTask {
	/**
	 * The cached value of the '{@link #getRefactoringSubTask() <em>Refactoring Sub Task</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefactoringSubTask()
	 * @generated
	 * @ordered
	 */
	protected EList<RefactoringSubTask> refactoringSubTask;

	/**
	 * The default value of the '{@link #getComponentID() <em>Component ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentID()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComponentID() <em>Component ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentID()
	 * @generated
	 * @ordered
	 */
	protected String componentID = COMPONENT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatus()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATUS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatus()
	 * @generated
	 * @ordered
	 */
	protected boolean status = STATUS_EDEFAULT;

	/**
	 * This is true if the Status attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean statusESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RefactoringTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.REFACTORING_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RefactoringSubTask> getRefactoringSubTask() {
		if (refactoringSubTask == null) {
			refactoringSubTask = new EObjectContainmentEList<RefactoringSubTask>(RefactoringSubTask.class, this, WorkflowPackage.REFACTORING_TASK__REFACTORING_SUB_TASK);
		}
		return refactoringSubTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponentID() {
		return componentID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentID(String newComponentID) {
		String oldComponentID = componentID;
		componentID = newComponentID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.REFACTORING_TASK__COMPONENT_ID, oldComponentID, componentID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.REFACTORING_TASK__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.REFACTORING_TASK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(boolean newStatus) {
		boolean oldStatus = status;
		status = newStatus;
		boolean oldStatusESet = statusESet;
		statusESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.REFACTORING_TASK__STATUS, oldStatus, status, !oldStatusESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStatus() {
		boolean oldStatus = status;
		boolean oldStatusESet = statusESet;
		status = STATUS_EDEFAULT;
		statusESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WorkflowPackage.REFACTORING_TASK__STATUS, oldStatus, STATUS_EDEFAULT, oldStatusESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStatus() {
		return statusESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.REFACTORING_TASK__REFACTORING_SUB_TASK:
				return ((InternalEList<?>)getRefactoringSubTask()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.REFACTORING_TASK__REFACTORING_SUB_TASK:
				return getRefactoringSubTask();
			case WorkflowPackage.REFACTORING_TASK__COMPONENT_ID:
				return getComponentID();
			case WorkflowPackage.REFACTORING_TASK__DESCRIPTION:
				return getDescription();
			case WorkflowPackage.REFACTORING_TASK__NAME:
				return getName();
			case WorkflowPackage.REFACTORING_TASK__STATUS:
				return isStatus();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowPackage.REFACTORING_TASK__REFACTORING_SUB_TASK:
				getRefactoringSubTask().clear();
				getRefactoringSubTask().addAll((Collection<? extends RefactoringSubTask>)newValue);
				return;
			case WorkflowPackage.REFACTORING_TASK__COMPONENT_ID:
				setComponentID((String)newValue);
				return;
			case WorkflowPackage.REFACTORING_TASK__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case WorkflowPackage.REFACTORING_TASK__NAME:
				setName((String)newValue);
				return;
			case WorkflowPackage.REFACTORING_TASK__STATUS:
				setStatus((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkflowPackage.REFACTORING_TASK__REFACTORING_SUB_TASK:
				getRefactoringSubTask().clear();
				return;
			case WorkflowPackage.REFACTORING_TASK__COMPONENT_ID:
				setComponentID(COMPONENT_ID_EDEFAULT);
				return;
			case WorkflowPackage.REFACTORING_TASK__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case WorkflowPackage.REFACTORING_TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WorkflowPackage.REFACTORING_TASK__STATUS:
				unsetStatus();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkflowPackage.REFACTORING_TASK__REFACTORING_SUB_TASK:
				return refactoringSubTask != null && !refactoringSubTask.isEmpty();
			case WorkflowPackage.REFACTORING_TASK__COMPONENT_ID:
				return COMPONENT_ID_EDEFAULT == null ? componentID != null : !COMPONENT_ID_EDEFAULT.equals(componentID);
			case WorkflowPackage.REFACTORING_TASK__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case WorkflowPackage.REFACTORING_TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WorkflowPackage.REFACTORING_TASK__STATUS:
				return isSetStatus();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (componentID: ");
		result.append(componentID);
		result.append(", description: ");
		result.append(description);
		result.append(", name: ");
		result.append(name);
		result.append(", status: ");
		if (statusESet) result.append(status); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //RefactoringTaskImpl
