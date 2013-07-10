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
 * A representation of the model object '<em><b>Anonymous event Definition 1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Anonymous_eventDefinition_1_#getParameterList_1 <em>Parameter List 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getAnonymous_eventDefinition_1_()
 * @model
 * @generated
 */
public interface Anonymous_eventDefinition_1_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameter List 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ParameterList_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter List 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter List 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAnonymous_eventDefinition_1__ParameterList_1()
   * @model containment="true"
   * @generated
   */
  EList<ParameterList_> getParameterList_1();

} // Anonymous_eventDefinition_1_
