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
 * A representation of the model object '<em><b>More Code </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.MoreCode_#getAnonymous_moreCode_1_1 <em>Anonymous more Code 11</em>}</li>
 *   <li>{@link cruise.umple.umple.MoreCode_#getCode_1 <em>Code 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getMoreCode_()
 * @model
 * @generated
 */
public interface MoreCode_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Anonymous more Code 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_moreCode_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous more Code 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous more Code 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getMoreCode__Anonymous_moreCode_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_moreCode_1_> getAnonymous_moreCode_1_1();

  /**
   * Returns the value of the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code 1</em>' attribute.
   * @see #setCode_1(String)
   * @see cruise.umple.umple.UmplePackage#getMoreCode__Code_1()
   * @model
   * @generated
   */
  String getCode_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.MoreCode_#getCode_1 <em>Code 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code 1</em>' attribute.
   * @see #getCode_1()
   * @generated
   */
  void setCode_1(String value);

} // MoreCode_
