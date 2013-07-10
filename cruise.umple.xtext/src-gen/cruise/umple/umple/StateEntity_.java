/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Entity </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.StateEntity_#getEntryOrExitAction_1 <em>Entry Or Exit Action 1</em>}</li>
 *   <li>{@link cruise.umple.umple.StateEntity_#getAutoTransition_1 <em>Auto Transition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.StateEntity_#getTransition_1 <em>Transition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.StateEntity_#getActivity_1 <em>Activity 1</em>}</li>
 *   <li>{@link cruise.umple.umple.StateEntity_#getState_1 <em>State 1</em>}</li>
 *   <li>{@link cruise.umple.umple.StateEntity_#getTrace_1 <em>Trace 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getStateEntity_()
 * @model
 * @generated
 */
public interface StateEntity_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Entry Or Exit Action 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.EntryOrExitAction_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entry Or Exit Action 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entry Or Exit Action 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateEntity__EntryOrExitAction_1()
   * @model containment="true"
   * @generated
   */
  EList<EntryOrExitAction_> getEntryOrExitAction_1();

  /**
   * Returns the value of the '<em><b>Auto Transition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AutoTransition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Auto Transition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Auto Transition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateEntity__AutoTransition_1()
   * @model containment="true"
   * @generated
   */
  EList<AutoTransition_> getAutoTransition_1();

  /**
   * Returns the value of the '<em><b>Transition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Transition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateEntity__Transition_1()
   * @model containment="true"
   * @generated
   */
  EList<Transition_> getTransition_1();

  /**
   * Returns the value of the '<em><b>Activity 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Activity_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateEntity__Activity_1()
   * @model containment="true"
   * @generated
   */
  EList<Activity_> getActivity_1();

  /**
   * Returns the value of the '<em><b>State 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.State_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateEntity__State_1()
   * @model containment="true"
   * @generated
   */
  EList<State_> getState_1();

  /**
   * Returns the value of the '<em><b>Trace 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Trace_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateEntity__Trace_1()
   * @model containment="true"
   * @generated
   */
  EList<Trace_> getTrace_1();

} // StateEntity_
