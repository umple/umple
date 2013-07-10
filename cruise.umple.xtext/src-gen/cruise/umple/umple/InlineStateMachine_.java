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
 * A representation of the model object '<em><b>Inline State Machine </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.InlineStateMachine_#isQueued_1 <em>Queued 1</em>}</li>
 *   <li>{@link cruise.umple.umple.InlineStateMachine_#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.InlineStateMachine_#getAnonymous_inlineStateMachine_1_1 <em>Anonymous inline State Machine 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getInlineStateMachine_()
 * @model
 * @generated
 */
public interface InlineStateMachine_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Queued 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Queued 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Queued 1</em>' attribute.
   * @see #setQueued_1(boolean)
   * @see cruise.umple.umple.UmplePackage#getInlineStateMachine__Queued_1()
   * @model
   * @generated
   */
  boolean isQueued_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.InlineStateMachine_#isQueued_1 <em>Queued 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Queued 1</em>' attribute.
   * @see #isQueued_1()
   * @generated
   */
  void setQueued_1(boolean value);

  /**
   * Returns the value of the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name 1</em>' attribute.
   * @see #setName_1(String)
   * @see cruise.umple.umple.UmplePackage#getInlineStateMachine__Name_1()
   * @model
   * @generated
   */
  String getName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.InlineStateMachine_#getName_1 <em>Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name 1</em>' attribute.
   * @see #getName_1()
   * @generated
   */
  void setName_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous inline State Machine 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_inlineStateMachine_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous inline State Machine 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous inline State Machine 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInlineStateMachine__Anonymous_inlineStateMachine_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_inlineStateMachine_1_> getAnonymous_inlineStateMachine_1_1();

} // InlineStateMachine_
