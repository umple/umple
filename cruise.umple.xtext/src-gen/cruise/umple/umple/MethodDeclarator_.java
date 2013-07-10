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
 * A representation of the model object '<em><b>Method Declarator </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.MethodDeclarator_#getMethodName_1 <em>Method Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.MethodDeclarator_#getParameterList_1 <em>Parameter List 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getMethodDeclarator_()
 * @model
 * @generated
 */
public interface MethodDeclarator_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Method Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Name 1</em>' attribute.
   * @see #setMethodName_1(String)
   * @see cruise.umple.umple.UmplePackage#getMethodDeclarator__MethodName_1()
   * @model
   * @generated
   */
  String getMethodName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.MethodDeclarator_#getMethodName_1 <em>Method Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method Name 1</em>' attribute.
   * @see #getMethodName_1()
   * @generated
   */
  void setMethodName_1(String value);

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
   * @see cruise.umple.umple.UmplePackage#getMethodDeclarator__ParameterList_1()
   * @model containment="true"
   * @generated
   */
  EList<ParameterList_> getParameterList_1();

} // MethodDeclarator_
