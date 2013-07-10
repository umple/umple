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
 * A representation of the model object '<em><b>Code Injection </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.CodeInjection_#getBeforeCode_1 <em>Before Code 1</em>}</li>
 *   <li>{@link cruise.umple.umple.CodeInjection_#getAfterCode_1 <em>After Code 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getCodeInjection_()
 * @model
 * @generated
 */
public interface CodeInjection_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Before Code 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.BeforeCode_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Before Code 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Before Code 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getCodeInjection__BeforeCode_1()
   * @model containment="true"
   * @generated
   */
  EList<BeforeCode_> getBeforeCode_1();

  /**
   * Returns the value of the '<em><b>After Code 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AfterCode_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>After Code 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>After Code 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getCodeInjection__AfterCode_1()
   * @model containment="true"
   * @generated
   */
  EList<AfterCode_> getAfterCode_1();

} // CodeInjection_
