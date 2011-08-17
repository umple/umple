/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Association#getType1 <em>Type1</em>}</li>
 *   <li>{@link cruise.umple.umple.Association#getRolename1 <em>Rolename1</em>}</li>
 *   <li>{@link cruise.umple.umple.Association#getType2 <em>Type2</em>}</li>
 *   <li>{@link cruise.umple.umple.Association#getRolename2 <em>Rolename2</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends EObject
{
  /**
   * Returns the value of the '<em><b>Type1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type1</em>' attribute.
   * @see #setType1(String)
   * @see cruise.umple.umple.UmplePackage#getAssociation_Type1()
   * @model
   * @generated
   */
  String getType1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Association#getType1 <em>Type1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type1</em>' attribute.
   * @see #getType1()
   * @generated
   */
  void setType1(String value);

  /**
   * Returns the value of the '<em><b>Rolename1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rolename1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rolename1</em>' attribute.
   * @see #setRolename1(String)
   * @see cruise.umple.umple.UmplePackage#getAssociation_Rolename1()
   * @model
   * @generated
   */
  String getRolename1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Association#getRolename1 <em>Rolename1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rolename1</em>' attribute.
   * @see #getRolename1()
   * @generated
   */
  void setRolename1(String value);

  /**
   * Returns the value of the '<em><b>Type2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type2</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type2</em>' attribute.
   * @see #setType2(String)
   * @see cruise.umple.umple.UmplePackage#getAssociation_Type2()
   * @model
   * @generated
   */
  String getType2();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Association#getType2 <em>Type2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type2</em>' attribute.
   * @see #getType2()
   * @generated
   */
  void setType2(String value);

  /**
   * Returns the value of the '<em><b>Rolename2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rolename2</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rolename2</em>' attribute.
   * @see #setRolename2(String)
   * @see cruise.umple.umple.UmplePackage#getAssociation_Rolename2()
   * @model
   * @generated
   */
  String getRolename2();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Association#getRolename2 <em>Rolename2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rolename2</em>' attribute.
   * @see #getRolename2()
   * @generated
   */
  void setRolename2(String value);

} // Association
