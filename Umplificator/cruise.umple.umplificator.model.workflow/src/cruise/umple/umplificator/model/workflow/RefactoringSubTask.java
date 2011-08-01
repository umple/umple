/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cruise.umple.umplificator.model.workflow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Refactoring Sub Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#getComponentID <em>Component ID</em>}</li>
 *   <li>{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#getDescription <em>Description</em>}</li>
 *   <li>{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#isStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umplificator.model.workflow.WorkflowPackage#getRefactoringSubTask()
 * @model extendedMetaData="name='refactoringSubTask' kind='empty'"
 * @generated
 */
public interface RefactoringSubTask extends EObject {
	/**
	 * Returns the value of the '<em><b>Component ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component ID</em>' attribute.
	 * @see #setComponentID(String)
	 * @see cruise.umple.umplificator.model.workflow.WorkflowPackage#getRefactoringSubTask_ComponentID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='componentID'"
	 * @generated
	 */
	String getComponentID();

	/**
	 * Sets the value of the '{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#getComponentID <em>Component ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component ID</em>' attribute.
	 * @see #getComponentID()
	 * @generated
	 */
	void setComponentID(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see cruise.umple.umplificator.model.workflow.WorkflowPackage#getRefactoringSubTask_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cruise.umple.umplificator.model.workflow.WorkflowPackage#getRefactoringSubTask_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #isSetStatus()
	 * @see #unsetStatus()
	 * @see #setStatus(boolean)
	 * @see cruise.umple.umplificator.model.workflow.WorkflowPackage#getRefactoringSubTask_Status()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 *        extendedMetaData="kind='attribute' name='status'"
	 * @generated
	 */
	boolean isStatus();

	/**
	 * Sets the value of the '{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#isStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #isSetStatus()
	 * @see #unsetStatus()
	 * @see #isStatus()
	 * @generated
	 */
	void setStatus(boolean value);

	/**
	 * Unsets the value of the '{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#isStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStatus()
	 * @see #isStatus()
	 * @see #setStatus(boolean)
	 * @generated
	 */
	void unsetStatus();

	/**
	 * Returns whether the value of the '{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#isStatus <em>Status</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Status</em>' attribute is set.
	 * @see #unsetStatus()
	 * @see #isStatus()
	 * @see #setStatus(boolean)
	 * @generated
	 */
	boolean isSetStatus();

} // RefactoringSubTask
