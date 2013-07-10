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
 * A representation of the model object '<em><b>Single Is A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.SingleIsA_#getExtendsName_1 <em>Extends Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.SingleIsA_#getAnonymous_singleIsA_1_1 <em>Anonymous single Is A11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getSingleIsA_()
 * @model
 * @generated
 */
public interface SingleIsA_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Extends Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends Name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends Name 1</em>' attribute.
   * @see #setExtendsName_1(String)
   * @see cruise.umple.umple.UmplePackage#getSingleIsA__ExtendsName_1()
   * @model
   * @generated
   */
  String getExtendsName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.SingleIsA_#getExtendsName_1 <em>Extends Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends Name 1</em>' attribute.
   * @see #getExtendsName_1()
   * @generated
   */
  void setExtendsName_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous single Is A11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_singleIsA_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous single Is A11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous single Is A11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getSingleIsA__Anonymous_singleIsA_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_singleIsA_1_> getAnonymous_singleIsA_1_1();

} // SingleIsA_
