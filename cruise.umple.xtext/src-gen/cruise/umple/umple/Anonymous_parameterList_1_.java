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
 * A representation of the model object '<em><b>Anonymous parameter List 1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Anonymous_parameterList_1_#getParameter_1 <em>Parameter 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getAnonymous_parameterList_1_()
 * @model
 * @generated
 */
public interface Anonymous_parameterList_1_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameter 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Parameter_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAnonymous_parameterList_1__Parameter_1()
   * @model containment="true"
   * @generated
   */
  EList<Parameter_> getParameter_1();

} // Anonymous_parameterList_1_
