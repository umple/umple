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
 * A representation of the model object '<em><b>Association Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.UmpleAssociationClass#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleAssociationClass#getAssociationClassContents <em>Association Class Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getUmpleAssociationClass()
 * @model
 * @generated
 */
public interface UmpleAssociationClass extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see cruise.umple.umple.UmplePackage#getUmpleAssociationClass_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleAssociationClass#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Association Class Contents</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.associationClassContent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association Class Contents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Class Contents</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleAssociationClass_AssociationClassContents()
   * @model containment="true"
   * @generated
   */
  EList<associationClassContent> getAssociationClassContents();

} // UmpleAssociationClass
