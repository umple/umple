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
 * A representation of the model object '<em><b>After Code </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.AfterCode_#getOperationName_1 <em>Operation Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.AfterCode_#getAnonymous_afterCode_1_1 <em>Anonymous after Code 11</em>}</li>
 *   <li>{@link cruise.umple.umple.AfterCode_#getCode_1 <em>Code 1</em>}</li>
 *   <li>{@link cruise.umple.umple.AfterCode_#getAnonymous_afterCode_2_1 <em>Anonymous after Code 21</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getAfterCode_()
 * @model
 * @generated
 */
public interface AfterCode_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Operation Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation Name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation Name 1</em>' attribute.
   * @see #setOperationName_1(String)
   * @see cruise.umple.umple.UmplePackage#getAfterCode__OperationName_1()
   * @model
   * @generated
   */
  String getOperationName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.AfterCode_#getOperationName_1 <em>Operation Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation Name 1</em>' attribute.
   * @see #getOperationName_1()
   * @generated
   */
  void setOperationName_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous after Code 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_afterCode_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous after Code 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous after Code 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAfterCode__Anonymous_afterCode_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_afterCode_1_> getAnonymous_afterCode_1_1();

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
   * @see cruise.umple.umple.UmplePackage#getAfterCode__Code_1()
   * @model
   * @generated
   */
  String getCode_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.AfterCode_#getCode_1 <em>Code 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code 1</em>' attribute.
   * @see #getCode_1()
   * @generated
   */
  void setCode_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous after Code 21</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_afterCode_2_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous after Code 21</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous after Code 21</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAfterCode__Anonymous_afterCode_2_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_afterCode_2_> getAnonymous_afterCode_2_1();

} // AfterCode_
