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
 * A representation of the model object '<em><b>Parameter List </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ParameterList_#getParameter_1 <em>Parameter 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ParameterList_#getAnonymous_parameterList_1_1 <em>Anonymous parameter List 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getParameterList_()
 * @model
 * @generated
 */
public interface ParameterList_ extends EObject
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
   * @see cruise.umple.umple.UmplePackage#getParameterList__Parameter_1()
   * @model containment="true"
   * @generated
   */
  EList<Parameter_> getParameter_1();

  /**
   * Returns the value of the '<em><b>Anonymous parameter List 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_parameterList_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous parameter List 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous parameter List 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getParameterList__Anonymous_parameterList_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_parameterList_1_> getAnonymous_parameterList_1_1();

} // ParameterList_
