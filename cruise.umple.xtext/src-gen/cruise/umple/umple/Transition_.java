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
 * A representation of the model object '<em><b>Transition </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Transition_#getGuard_1 <em>Guard 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Transition_#getEventDefinition_1 <em>Event Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Transition_#getAction_1 <em>Action 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Transition_#getStateName_1 <em>State Name 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTransition_()
 * @model
 * @generated
 */
public interface Transition_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Guard 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Guard_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTransition__Guard_1()
   * @model containment="true"
   * @generated
   */
  EList<Guard_> getGuard_1();

  /**
   * Returns the value of the '<em><b>Event Definition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.EventDefinition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event Definition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event Definition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTransition__EventDefinition_1()
   * @model containment="true"
   * @generated
   */
  EList<EventDefinition_> getEventDefinition_1();

  /**
   * Returns the value of the '<em><b>Action 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Action_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTransition__Action_1()
   * @model containment="true"
   * @generated
   */
  EList<Action_> getAction_1();

  /**
   * Returns the value of the '<em><b>State Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Name 1</em>' attribute.
   * @see #setStateName_1(String)
   * @see cruise.umple.umple.UmplePackage#getTransition__StateName_1()
   * @model
   * @generated
   */
  String getStateName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Transition_#getStateName_1 <em>State Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Name 1</em>' attribute.
   * @see #getStateName_1()
   * @generated
   */
  void setStateName_1(String value);

} // Transition_
