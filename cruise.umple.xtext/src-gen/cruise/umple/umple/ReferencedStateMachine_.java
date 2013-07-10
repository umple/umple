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
 * A representation of the model object '<em><b>Referenced State Machine </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ReferencedStateMachine_#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ReferencedStateMachine_#getDefinitionName_1 <em>Definition Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ReferencedStateMachine_#getExtendedStateMachine_1 <em>Extended State Machine 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getReferencedStateMachine_()
 * @model
 * @generated
 */
public interface ReferencedStateMachine_ extends EObject
{
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
   * @see cruise.umple.umple.UmplePackage#getReferencedStateMachine__Name_1()
   * @model
   * @generated
   */
  String getName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ReferencedStateMachine_#getName_1 <em>Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name 1</em>' attribute.
   * @see #getName_1()
   * @generated
   */
  void setName_1(String value);

  /**
   * Returns the value of the '<em><b>Definition Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definition Name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definition Name 1</em>' attribute.
   * @see #setDefinitionName_1(String)
   * @see cruise.umple.umple.UmplePackage#getReferencedStateMachine__DefinitionName_1()
   * @model
   * @generated
   */
  String getDefinitionName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ReferencedStateMachine_#getDefinitionName_1 <em>Definition Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Definition Name 1</em>' attribute.
   * @see #getDefinitionName_1()
   * @generated
   */
  void setDefinitionName_1(String value);

  /**
   * Returns the value of the '<em><b>Extended State Machine 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ExtendedStateMachine_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extended State Machine 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extended State Machine 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getReferencedStateMachine__ExtendedStateMachine_1()
   * @model containment="true"
   * @generated
   */
  EList<ExtendedStateMachine_> getExtendedStateMachine_1();

} // ReferencedStateMachine_
