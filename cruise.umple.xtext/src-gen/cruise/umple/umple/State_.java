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
 * A representation of the model object '<em><b>State </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.State_#getStateName_1 <em>State Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.State_#getStateInternal_1 <em>State Internal 1</em>}</li>
 *   <li>{@link cruise.umple.umple.State_#isFinal_1 <em>Final 1</em>}</li>
 *   <li>{@link cruise.umple.umple.State_#getAnonymous_state_1_1 <em>Anonymous state 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getState_()
 * @model
 * @generated
 */
public interface State_ extends EObject
{
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
   * @see cruise.umple.umple.UmplePackage#getState__StateName_1()
   * @model
   * @generated
   */
  String getStateName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.State_#getStateName_1 <em>State Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Name 1</em>' attribute.
   * @see #getStateName_1()
   * @generated
   */
  void setStateName_1(String value);

  /**
   * Returns the value of the '<em><b>State Internal 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.StateInternal_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Internal 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Internal 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getState__StateInternal_1()
   * @model containment="true"
   * @generated
   */
  EList<StateInternal_> getStateInternal_1();

  /**
   * Returns the value of the '<em><b>Final 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Final 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Final 1</em>' attribute.
   * @see #setFinal_1(boolean)
   * @see cruise.umple.umple.UmplePackage#getState__Final_1()
   * @model
   * @generated
   */
  boolean isFinal_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.State_#isFinal_1 <em>Final 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final 1</em>' attribute.
   * @see #isFinal_1()
   * @generated
   */
  void setFinal_1(boolean value);

  /**
   * Returns the value of the '<em><b>Anonymous state 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_state_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous state 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous state 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getState__Anonymous_state_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_state_1_> getAnonymous_state_1_1();

} // State_
