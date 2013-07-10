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
 * A representation of the model object '<em><b>State Machine </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.StateMachine_#getEnum_1 <em>Enum 1</em>}</li>
 *   <li>{@link cruise.umple.umple.StateMachine_#getInlineStateMachine_1 <em>Inline State Machine 1</em>}</li>
 *   <li>{@link cruise.umple.umple.StateMachine_#getReferencedStateMachine_1 <em>Referenced State Machine 1</em>}</li>
 *   <li>{@link cruise.umple.umple.StateMachine_#getActiveDefinition_1 <em>Active Definition 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getStateMachine_()
 * @model
 * @generated
 */
public interface StateMachine_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Enum 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Enum_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enum 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateMachine__Enum_1()
   * @model containment="true"
   * @generated
   */
  EList<Enum_> getEnum_1();

  /**
   * Returns the value of the '<em><b>Inline State Machine 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.InlineStateMachine_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inline State Machine 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inline State Machine 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateMachine__InlineStateMachine_1()
   * @model containment="true"
   * @generated
   */
  EList<InlineStateMachine_> getInlineStateMachine_1();

  /**
   * Returns the value of the '<em><b>Referenced State Machine 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ReferencedStateMachine_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced State Machine 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced State Machine 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateMachine__ReferencedStateMachine_1()
   * @model containment="true"
   * @generated
   */
  EList<ReferencedStateMachine_> getReferencedStateMachine_1();

  /**
   * Returns the value of the '<em><b>Active Definition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ActiveDefinition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Active Definition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Active Definition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateMachine__ActiveDefinition_1()
   * @model containment="true"
   * @generated
   */
  EList<ActiveDefinition_> getActiveDefinition_1();

} // StateMachine_
