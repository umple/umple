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
 * A representation of the model object '<em><b>Inline Association End </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.InlineAssociationEnd_#getMultiplicity_1 <em>Multiplicity 1</em>}</li>
 *   <li>{@link cruise.umple.umple.InlineAssociationEnd_#getIsSorted_1 <em>Is Sorted 1</em>}</li>
 *   <li>{@link cruise.umple.umple.InlineAssociationEnd_#getRoleName_1 <em>Role Name 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getInlineAssociationEnd_()
 * @model
 * @generated
 */
public interface InlineAssociationEnd_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Multiplicity 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Multiplicity_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInlineAssociationEnd__Multiplicity_1()
   * @model containment="true"
   * @generated
   */
  EList<Multiplicity_> getMultiplicity_1();

  /**
   * Returns the value of the '<em><b>Is Sorted 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.IsSorted_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Sorted 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Sorted 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInlineAssociationEnd__IsSorted_1()
   * @model containment="true"
   * @generated
   */
  EList<IsSorted_> getIsSorted_1();

  /**
   * Returns the value of the '<em><b>Role Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role Name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role Name 1</em>' attribute.
   * @see #setRoleName_1(String)
   * @see cruise.umple.umple.UmplePackage#getInlineAssociationEnd__RoleName_1()
   * @model
   * @generated
   */
  String getRoleName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.InlineAssociationEnd_#getRoleName_1 <em>Role Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role Name 1</em>' attribute.
   * @see #getRoleName_1()
   * @generated
   */
  void setRoleName_1(String value);

} // InlineAssociationEnd_
