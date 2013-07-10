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
 * A representation of the model object '<em><b>Anonymous more Guards 1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Anonymous_moreGuards_1_#getCodeLang_1 <em>Code Lang 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Anonymous_moreGuards_1_#getCodeLangs_1 <em>Code Langs 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getAnonymous_moreGuards_1_()
 * @model
 * @generated
 */
public interface Anonymous_moreGuards_1_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Code Lang 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.CodeLang_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code Lang 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code Lang 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAnonymous_moreGuards_1__CodeLang_1()
   * @model containment="true"
   * @generated
   */
  EList<CodeLang_> getCodeLang_1();

  /**
   * Returns the value of the '<em><b>Code Langs 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.CodeLangs_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code Langs 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code Langs 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAnonymous_moreGuards_1__CodeLangs_1()
   * @model containment="true"
   * @generated
   */
  EList<CodeLangs_> getCodeLangs_1();

} // Anonymous_moreGuards_1_
