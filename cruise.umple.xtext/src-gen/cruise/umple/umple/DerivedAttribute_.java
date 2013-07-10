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
 * A representation of the model object '<em><b>Derived Attribute </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.DerivedAttribute_#getModifier_1 <em>Modifier 1</em>}</li>
 *   <li>{@link cruise.umple.umple.DerivedAttribute_#getAnonymous_derivedAttribute_1_1 <em>Anonymous derived Attribute 11</em>}</li>
 *   <li>{@link cruise.umple.umple.DerivedAttribute_#getAnonymous_derivedAttribute_2_1 <em>Anonymous derived Attribute 21</em>}</li>
 *   <li>{@link cruise.umple.umple.DerivedAttribute_#getCode_1 <em>Code 1</em>}</li>
 *   <li>{@link cruise.umple.umple.DerivedAttribute_#getAnonymous_derivedAttribute_3_1 <em>Anonymous derived Attribute 31</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getDerivedAttribute_()
 * @model
 * @generated
 */
public interface DerivedAttribute_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Modifier 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modifier 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modifier 1</em>' attribute.
   * @see #setModifier_1(String)
   * @see cruise.umple.umple.UmplePackage#getDerivedAttribute__Modifier_1()
   * @model
   * @generated
   */
  String getModifier_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.DerivedAttribute_#getModifier_1 <em>Modifier 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifier 1</em>' attribute.
   * @see #getModifier_1()
   * @generated
   */
  void setModifier_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous derived Attribute 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_derivedAttribute_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous derived Attribute 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous derived Attribute 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDerivedAttribute__Anonymous_derivedAttribute_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_derivedAttribute_1_> getAnonymous_derivedAttribute_1_1();

  /**
   * Returns the value of the '<em><b>Anonymous derived Attribute 21</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_derivedAttribute_2_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous derived Attribute 21</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous derived Attribute 21</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDerivedAttribute__Anonymous_derivedAttribute_2_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_derivedAttribute_2_> getAnonymous_derivedAttribute_2_1();

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
   * @see cruise.umple.umple.UmplePackage#getDerivedAttribute__Code_1()
   * @model
   * @generated
   */
  String getCode_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.DerivedAttribute_#getCode_1 <em>Code 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code 1</em>' attribute.
   * @see #getCode_1()
   * @generated
   */
  void setCode_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous derived Attribute 31</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_derivedAttribute_3_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous derived Attribute 31</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous derived Attribute 31</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDerivedAttribute__Anonymous_derivedAttribute_3_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_derivedAttribute_3_> getAnonymous_derivedAttribute_3_1();

} // DerivedAttribute_
