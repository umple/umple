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
 * A representation of the model object '<em><b>Attribute </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Attribute_#getSimpleAttribute_1 <em>Simple Attribute 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Attribute_#getAutouniqueAttribute_1 <em>Autounique Attribute 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Attribute_#getDerivedAttribute_1 <em>Derived Attribute 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Attribute_#getComplexAttribute_1 <em>Complex Attribute 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getAttribute_()
 * @model
 * @generated
 */
public interface Attribute_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Simple Attribute 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.SimpleAttribute_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simple Attribute 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simple Attribute 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAttribute__SimpleAttribute_1()
   * @model containment="true"
   * @generated
   */
  EList<SimpleAttribute_> getSimpleAttribute_1();

  /**
   * Returns the value of the '<em><b>Autounique Attribute 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AutouniqueAttribute_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Autounique Attribute 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Autounique Attribute 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAttribute__AutouniqueAttribute_1()
   * @model containment="true"
   * @generated
   */
  EList<AutouniqueAttribute_> getAutouniqueAttribute_1();

  /**
   * Returns the value of the '<em><b>Derived Attribute 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.DerivedAttribute_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Derived Attribute 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Derived Attribute 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAttribute__DerivedAttribute_1()
   * @model containment="true"
   * @generated
   */
  EList<DerivedAttribute_> getDerivedAttribute_1();

  /**
   * Returns the value of the '<em><b>Complex Attribute 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ComplexAttribute_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Complex Attribute 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Complex Attribute 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAttribute__ComplexAttribute_1()
   * @model containment="true"
   * @generated
   */
  EList<ComplexAttribute_> getComplexAttribute_1();

} // Attribute_
