/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.State#getStateTraceDirective <em>State Trace Directive</em>}</li>
 *   <li>{@link cruise.umple.umple.State#getStateName <em>State Name</em>}</li>
 *   <li>{@link cruise.umple.umple.State#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getState()
 * @model
 * @generated
 */
public interface State extends StateEntity
{
  /**
   * Returns the value of the '<em><b>State Trace Directive</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceDirective}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Trace Directive</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Trace Directive</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getState_StateTraceDirective()
   * @model containment="true"
   * @generated
   */
  EList<TraceDirective> getStateTraceDirective();

  /**
   * Returns the value of the '<em><b>State Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Name</em>' attribute.
   * @see #setStateName(String)
   * @see cruise.umple.umple.UmplePackage#getState_StateName()
   * @model
   * @generated
   */
  String getStateName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.State#getStateName <em>State Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Name</em>' attribute.
   * @see #getStateName()
   * @generated
   */
  void setStateName(String value);

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.StateEntity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getState_States()
   * @model containment="true"
   * @generated
   */
  EList<StateEntity> getStates();

} // State
