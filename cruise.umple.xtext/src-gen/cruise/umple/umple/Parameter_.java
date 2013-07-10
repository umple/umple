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
 * A representation of the model object '<em><b>Parameter </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Parameter_#getAnonymous_parameter_1_1 <em>Anonymous parameter 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getParameter_()
 * @model
 * @generated
 */
public interface Parameter_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Anonymous parameter 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_parameter_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous parameter 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous parameter 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getParameter__Anonymous_parameter_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_parameter_1_> getAnonymous_parameter_1_1();

} // Parameter_
