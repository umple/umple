/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Association End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.SingleAssociationEnd#getType <em>Type</em>}</li>
 *   <li>{@link cruise.umple.umple.SingleAssociationEnd#getRolename <em>Rolename</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getSingleAssociationEnd()
 * @model
 * @generated
 */
public interface SingleAssociationEnd extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see cruise.umple.umple.UmplePackage#getSingleAssociationEnd_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link cruise.umple.umple.SingleAssociationEnd#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Rolename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rolename</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rolename</em>' attribute.
   * @see #setRolename(String)
   * @see cruise.umple.umple.UmplePackage#getSingleAssociationEnd_Rolename()
   * @model
   * @generated
   */
  String getRolename();

  /**
   * Sets the value of the '{@link cruise.umple.umple.SingleAssociationEnd#getRolename <em>Rolename</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rolename</em>' attribute.
   * @see #getRolename()
   * @generated
   */
  void setRolename(String value);

} // SingleAssociationEnd
