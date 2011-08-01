/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cruise.umple.umplificator.model.workflow;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cruise.umple.umplificator.model.workflow.WorkflowPackage
 * @generated
 */
public interface WorkflowFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkflowFactory eINSTANCE = cruise.umple.umplificator.model.workflow.impl.WorkflowFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Refactoring Sub Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Refactoring Sub Task</em>'.
	 * @generated
	 */
	RefactoringSubTask createRefactoringSubTask();

	/**
	 * Returns a new object of class '<em>Refactoring Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Refactoring Task</em>'.
	 * @generated
	 */
	RefactoringTask createRefactoringTask();

	/**
	 * Returns a new object of class '<em>Workflow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workflow</em>'.
	 * @generated
	 */
	Workflow createWorkflow();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WorkflowPackage getWorkflowPackage();

} //WorkflowFactory
