/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Referenced State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ReferencedStateMachine#getMachine <em>Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getReferencedStateMachine()
 * @model
 * @generated
 */
public interface ReferencedStateMachine extends StateMachine
{
  /**
   * Returns the value of the '<em><b>Machine</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Machine</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Machine</em>' reference.
   * @see #setMachine(StateMachineDefinition)
   * @see cruise.umple.umple.UmplePackage#getReferencedStateMachine_Machine()
   * @model
   * @generated
   */
  StateMachineDefinition getMachine();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ReferencedStateMachine#getMachine <em>Machine</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Machine</em>' reference.
   * @see #getMachine()
   * @generated
   */
  void setMachine(StateMachineDefinition value);

} // ReferencedStateMachine
