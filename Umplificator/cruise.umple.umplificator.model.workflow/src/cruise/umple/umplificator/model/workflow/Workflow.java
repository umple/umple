/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cruise.umple.umplificator.model.workflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workflow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umplificator.model.workflow.Workflow#getRefactoringTask <em>Refactoring Task</em>}</li>
 *   <li>{@link cruise.umple.umplificator.model.workflow.Workflow#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umplificator.model.workflow.WorkflowPackage#getWorkflow()
 * @model extendedMetaData="name='workflow' kind='elementOnly'"
 * @generated
 */
public interface Workflow extends EObject {
	/**
	 * Returns the value of the '<em><b>Refactoring Task</b></em>' containment reference list.
	 * The list contents are of type {@link cruise.umple.umplificator.model.workflow.RefactoringTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refactoring Task</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refactoring Task</em>' containment reference list.
	 * @see cruise.umple.umplificator.model.workflow.WorkflowPackage#getWorkflow_RefactoringTask()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='refactoringTask'"
	 * @generated
	 */
	EList<RefactoringTask> getRefactoringTask();

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
	 * @see cruise.umple.umplificator.model.workflow.WorkflowPackage#getWorkflow_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cruise.umple.umplificator.model.workflow.Workflow#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Workflow
