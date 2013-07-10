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
 * A representation of the model object '<em><b>Key </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Key_#getKeyId_1 <em>Key Id 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Key_#getAnonymous_key_1_1 <em>Anonymous key 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getKey_()
 * @model
 * @generated
 */
public interface Key_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Key Id 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key Id 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key Id 1</em>' attribute.
   * @see #setKeyId_1(String)
   * @see cruise.umple.umple.UmplePackage#getKey__KeyId_1()
   * @model
   * @generated
   */
  String getKeyId_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Key_#getKeyId_1 <em>Key Id 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key Id 1</em>' attribute.
   * @see #getKeyId_1()
   * @generated
   */
  void setKeyId_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous key 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_key_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous key 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous key 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getKey__Anonymous_key_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_key_1_> getAnonymous_key_1_1();

} // Key_
