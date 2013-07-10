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
 * A representation of the model object '<em><b>Auto Transition </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.AutoTransition_#getAutoTransitionBlock_1 <em>Auto Transition Block 1</em>}</li>
 *   <li>{@link cruise.umple.umple.AutoTransition_#getActivity_1 <em>Activity 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getAutoTransition_()
 * @model
 * @generated
 */
public interface AutoTransition_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Auto Transition Block 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AutoTransitionBlock_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Auto Transition Block 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Auto Transition Block 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAutoTransition__AutoTransitionBlock_1()
   * @model containment="true"
   * @generated
   */
  EList<AutoTransitionBlock_> getAutoTransitionBlock_1();

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
   * @see cruise.umple.umple.UmplePackage#getAutoTransition__Activity_1()
   * @model containment="true"
   * @generated
   */
  EList<Activity_> getActivity_1();

} // AutoTransition_
