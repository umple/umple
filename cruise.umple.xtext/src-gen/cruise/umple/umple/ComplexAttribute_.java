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
 * A representation of the model object '<em><b>Complex Attribute </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ComplexAttribute_#isUnique_1 <em>Unique 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ComplexAttribute_#isLazy_1 <em>Lazy 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ComplexAttribute_#getModifier_1 <em>Modifier 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ComplexAttribute_#getAnonymous_complexAttribute_1_1 <em>Anonymous complex Attribute 11</em>}</li>
 *   <li>{@link cruise.umple.umple.ComplexAttribute_#getAnonymous_complexAttribute_2_1 <em>Anonymous complex Attribute 21</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getComplexAttribute_()
 * @model
 * @generated
 */
public interface ComplexAttribute_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Unique 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unique 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unique 1</em>' attribute.
   * @see #setUnique_1(boolean)
   * @see cruise.umple.umple.UmplePackage#getComplexAttribute__Unique_1()
   * @model
   * @generated
   */
  boolean isUnique_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ComplexAttribute_#isUnique_1 <em>Unique 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unique 1</em>' attribute.
   * @see #isUnique_1()
   * @generated
   */
  void setUnique_1(boolean value);

  /**
   * Returns the value of the '<em><b>Lazy 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lazy 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lazy 1</em>' attribute.
   * @see #setLazy_1(boolean)
   * @see cruise.umple.umple.UmplePackage#getComplexAttribute__Lazy_1()
   * @model
   * @generated
   */
  boolean isLazy_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ComplexAttribute_#isLazy_1 <em>Lazy 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lazy 1</em>' attribute.
   * @see #isLazy_1()
   * @generated
   */
  void setLazy_1(boolean value);

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
   * @see cruise.umple.umple.UmplePackage#getComplexAttribute__Modifier_1()
   * @model
   * @generated
   */
  String getModifier_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ComplexAttribute_#getModifier_1 <em>Modifier 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifier 1</em>' attribute.
   * @see #getModifier_1()
   * @generated
   */
  void setModifier_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous complex Attribute 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_complexAttribute_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous complex Attribute 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous complex Attribute 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getComplexAttribute__Anonymous_complexAttribute_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_complexAttribute_1_> getAnonymous_complexAttribute_1_1();

  /**
   * Returns the value of the '<em><b>Anonymous complex Attribute 21</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_complexAttribute_2_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous complex Attribute 21</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous complex Attribute 21</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getComplexAttribute__Anonymous_complexAttribute_2_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_complexAttribute_2_> getAnonymous_complexAttribute_2_1();

} // ComplexAttribute_
