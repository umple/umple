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
 * A representation of the model object '<em><b>Enum </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Enum_#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Enum_#getStateName_1 <em>State Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Enum_#getAnonymous_enum_1_1 <em>Anonymous enum 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getEnum_()
 * @model
 * @generated
 */
public interface Enum_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name 1</em>' attribute.
   * @see #setName_1(String)
   * @see cruise.umple.umple.UmplePackage#getEnum__Name_1()
   * @model
   * @generated
   */
  String getName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Enum_#getName_1 <em>Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name 1</em>' attribute.
   * @see #getName_1()
   * @generated
   */
  void setName_1(String value);

  /**
   * Returns the value of the '<em><b>State Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Name 1</em>' attribute.
   * @see #setStateName_1(String)
   * @see cruise.umple.umple.UmplePackage#getEnum__StateName_1()
   * @model
   * @generated
   */
  String getStateName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Enum_#getStateName_1 <em>State Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Name 1</em>' attribute.
   * @see #getStateName_1()
   * @generated
   */
  void setStateName_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous enum 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_enum_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous enum 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous enum 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEnum__Anonymous_enum_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_enum_1_> getAnonymous_enum_1_1();

} // Enum_
