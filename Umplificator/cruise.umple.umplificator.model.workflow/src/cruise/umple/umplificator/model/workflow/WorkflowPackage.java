/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cruise.umple.umplificator.model.workflow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see cruise.umple.umplificator.model.workflow.WorkflowFactory
 * @model kind="package"
 * @generated
 */
public interface WorkflowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workflow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "cruise.umple.umplificator.model.workflow.workflow";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "workflow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkflowPackage eINSTANCE = cruise.umple.umplificator.model.workflow.impl.WorkflowPackageImpl.init();

	/**
	 * The meta object id for the '{@link cruise.umple.umplificator.model.workflow.impl.RefactoringSubTaskImpl <em>Refactoring Sub Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cruise.umple.umplificator.model.workflow.impl.RefactoringSubTaskImpl
	 * @see cruise.umple.umplificator.model.workflow.impl.WorkflowPackageImpl#getRefactoringSubTask()
	 * @generated
	 */
	int REFACTORING_SUB_TASK = 0;

	/**
	 * The feature id for the '<em><b>Component ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_SUB_TASK__COMPONENT_ID = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_SUB_TASK__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_SUB_TASK__NAME = 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_SUB_TASK__STATUS = 3;

	/**
	 * The number of structural features of the '<em>Refactoring Sub Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_SUB_TASK_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link cruise.umple.umplificator.model.workflow.impl.RefactoringTaskImpl <em>Refactoring Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cruise.umple.umplificator.model.workflow.impl.RefactoringTaskImpl
	 * @see cruise.umple.umplificator.model.workflow.impl.WorkflowPackageImpl#getRefactoringTask()
	 * @generated
	 */
	int REFACTORING_TASK = 1;

	/**
	 * The feature id for the '<em><b>Refactoring Sub Task</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_TASK__REFACTORING_SUB_TASK = 0;

	/**
	 * The feature id for the '<em><b>Component ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_TASK__COMPONENT_ID = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_TASK__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_TASK__NAME = 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_TASK__STATUS = 4;

	/**
	 * The number of structural features of the '<em>Refactoring Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFACTORING_TASK_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link cruise.umple.umplificator.model.workflow.impl.WorkflowImpl <em>Workflow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cruise.umple.umplificator.model.workflow.impl.WorkflowImpl
	 * @see cruise.umple.umplificator.model.workflow.impl.WorkflowPackageImpl#getWorkflow()
	 * @generated
	 */
	int WORKFLOW = 2;

	/**
	 * The feature id for the '<em><b>Refactoring Task</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__REFACTORING_TASK = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW__NAME = 1;

	/**
	 * The number of structural features of the '<em>Workflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask <em>Refactoring Sub Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Refactoring Sub Task</em>'.
	 * @see cruise.umple.umplificator.model.workflow.RefactoringSubTask
	 * @generated
	 */
	EClass getRefactoringSubTask();

	/**
	 * Returns the meta object for the attribute '{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#getComponentID <em>Component ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component ID</em>'.
	 * @see cruise.umple.umplificator.model.workflow.RefactoringSubTask#getComponentID()
	 * @see #getRefactoringSubTask()
	 * @generated
	 */
	EAttribute getRefactoringSubTask_ComponentID();

	/**
	 * Returns the meta object for the attribute '{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see cruise.umple.umplificator.model.workflow.RefactoringSubTask#getDescription()
	 * @see #getRefactoringSubTask()
	 * @generated
	 */
	EAttribute getRefactoringSubTask_Description();

	/**
	 * Returns the meta object for the attribute '{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cruise.umple.umplificator.model.workflow.RefactoringSubTask#getName()
	 * @see #getRefactoringSubTask()
	 * @generated
	 */
	EAttribute getRefactoringSubTask_Name();

	/**
	 * Returns the meta object for the attribute '{@link cruise.umple.umplificator.model.workflow.RefactoringSubTask#isStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see cruise.umple.umplificator.model.workflow.RefactoringSubTask#isStatus()
	 * @see #getRefactoringSubTask()
	 * @generated
	 */
	EAttribute getRefactoringSubTask_Status();

	/**
	 * Returns the meta object for class '{@link cruise.umple.umplificator.model.workflow.RefactoringTask <em>Refactoring Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Refactoring Task</em>'.
	 * @see cruise.umple.umplificator.model.workflow.RefactoringTask
	 * @generated
	 */
	EClass getRefactoringTask();

	/**
	 * Returns the meta object for the containment reference list '{@link cruise.umple.umplificator.model.workflow.RefactoringTask#getRefactoringSubTask <em>Refactoring Sub Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refactoring Sub Task</em>'.
	 * @see cruise.umple.umplificator.model.workflow.RefactoringTask#getRefactoringSubTask()
	 * @see #getRefactoringTask()
	 * @generated
	 */
	EReference getRefactoringTask_RefactoringSubTask();

	/**
	 * Returns the meta object for the attribute '{@link cruise.umple.umplificator.model.workflow.RefactoringTask#getComponentID <em>Component ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component ID</em>'.
	 * @see cruise.umple.umplificator.model.workflow.RefactoringTask#getComponentID()
	 * @see #getRefactoringTask()
	 * @generated
	 */
	EAttribute getRefactoringTask_ComponentID();

	/**
	 * Returns the meta object for the attribute '{@link cruise.umple.umplificator.model.workflow.RefactoringTask#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see cruise.umple.umplificator.model.workflow.RefactoringTask#getDescription()
	 * @see #getRefactoringTask()
	 * @generated
	 */
	EAttribute getRefactoringTask_Description();

	/**
	 * Returns the meta object for the attribute '{@link cruise.umple.umplificator.model.workflow.RefactoringTask#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cruise.umple.umplificator.model.workflow.RefactoringTask#getName()
	 * @see #getRefactoringTask()
	 * @generated
	 */
	EAttribute getRefactoringTask_Name();

	/**
	 * Returns the meta object for the attribute '{@link cruise.umple.umplificator.model.workflow.RefactoringTask#isStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see cruise.umple.umplificator.model.workflow.RefactoringTask#isStatus()
	 * @see #getRefactoringTask()
	 * @generated
	 */
	EAttribute getRefactoringTask_Status();

	/**
	 * Returns the meta object for class '{@link cruise.umple.umplificator.model.workflow.Workflow <em>Workflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workflow</em>'.
	 * @see cruise.umple.umplificator.model.workflow.Workflow
	 * @generated
	 */
	EClass getWorkflow();

	/**
	 * Returns the meta object for the containment reference list '{@link cruise.umple.umplificator.model.workflow.Workflow#getRefactoringTask <em>Refactoring Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refactoring Task</em>'.
	 * @see cruise.umple.umplificator.model.workflow.Workflow#getRefactoringTask()
	 * @see #getWorkflow()
	 * @generated
	 */
	EReference getWorkflow_RefactoringTask();

	/**
	 * Returns the meta object for the attribute '{@link cruise.umple.umplificator.model.workflow.Workflow#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cruise.umple.umplificator.model.workflow.Workflow#getName()
	 * @see #getWorkflow()
	 * @generated
	 */
	EAttribute getWorkflow_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkflowFactory getWorkflowFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link cruise.umple.umplificator.model.workflow.impl.RefactoringSubTaskImpl <em>Refactoring Sub Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cruise.umple.umplificator.model.workflow.impl.RefactoringSubTaskImpl
		 * @see cruise.umple.umplificator.model.workflow.impl.WorkflowPackageImpl#getRefactoringSubTask()
		 * @generated
		 */
		EClass REFACTORING_SUB_TASK = eINSTANCE.getRefactoringSubTask();

		/**
		 * The meta object literal for the '<em><b>Component ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFACTORING_SUB_TASK__COMPONENT_ID = eINSTANCE.getRefactoringSubTask_ComponentID();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFACTORING_SUB_TASK__DESCRIPTION = eINSTANCE.getRefactoringSubTask_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFACTORING_SUB_TASK__NAME = eINSTANCE.getRefactoringSubTask_Name();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFACTORING_SUB_TASK__STATUS = eINSTANCE.getRefactoringSubTask_Status();

		/**
		 * The meta object literal for the '{@link cruise.umple.umplificator.model.workflow.impl.RefactoringTaskImpl <em>Refactoring Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cruise.umple.umplificator.model.workflow.impl.RefactoringTaskImpl
		 * @see cruise.umple.umplificator.model.workflow.impl.WorkflowPackageImpl#getRefactoringTask()
		 * @generated
		 */
		EClass REFACTORING_TASK = eINSTANCE.getRefactoringTask();

		/**
		 * The meta object literal for the '<em><b>Refactoring Sub Task</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFACTORING_TASK__REFACTORING_SUB_TASK = eINSTANCE.getRefactoringTask_RefactoringSubTask();

		/**
		 * The meta object literal for the '<em><b>Component ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFACTORING_TASK__COMPONENT_ID = eINSTANCE.getRefactoringTask_ComponentID();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFACTORING_TASK__DESCRIPTION = eINSTANCE.getRefactoringTask_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFACTORING_TASK__NAME = eINSTANCE.getRefactoringTask_Name();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFACTORING_TASK__STATUS = eINSTANCE.getRefactoringTask_Status();

		/**
		 * The meta object literal for the '{@link cruise.umple.umplificator.model.workflow.impl.WorkflowImpl <em>Workflow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cruise.umple.umplificator.model.workflow.impl.WorkflowImpl
		 * @see cruise.umple.umplificator.model.workflow.impl.WorkflowPackageImpl#getWorkflow()
		 * @generated
		 */
		EClass WORKFLOW = eINSTANCE.getWorkflow();

		/**
		 * The meta object literal for the '<em><b>Refactoring Task</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKFLOW__REFACTORING_TASK = eINSTANCE.getWorkflow_RefactoringTask();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKFLOW__NAME = eINSTANCE.getWorkflow_Name();

	}

} //WorkflowPackage
