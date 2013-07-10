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
 * A representation of the model object '<em><b>Constant Declaration </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ConstantDeclaration_#getAnonymous_constantDeclaration_1_1 <em>Anonymous constant Declaration 11</em>}</li>
 *   <li>{@link cruise.umple.umple.ConstantDeclaration_#getAnonymous_constantDeclaration_2_1 <em>Anonymous constant Declaration 21</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getConstantDeclaration_()
 * @model
 * @generated
 */
public interface ConstantDeclaration_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Anonymous constant Declaration 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_constantDeclaration_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous constant Declaration 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous constant Declaration 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConstantDeclaration__Anonymous_constantDeclaration_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_constantDeclaration_1_> getAnonymous_constantDeclaration_1_1();

  /**
   * Returns the value of the '<em><b>Anonymous constant Declaration 21</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_constantDeclaration_2_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous constant Declaration 21</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous constant Declaration 21</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConstantDeclaration__Anonymous_constantDeclaration_2_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_constantDeclaration_2_> getAnonymous_constantDeclaration_2_1();

} // ConstantDeclaration_
