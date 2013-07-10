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
 * A representation of the model object '<em><b>Inline Association </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.InlineAssociation_#getModifier_1 <em>Modifier 1</em>}</li>
 *   <li>{@link cruise.umple.umple.InlineAssociation_#getInlineAssociationEnd_1 <em>Inline Association End 1</em>}</li>
 *   <li>{@link cruise.umple.umple.InlineAssociation_#getArrow_1 <em>Arrow 1</em>}</li>
 *   <li>{@link cruise.umple.umple.InlineAssociation_#getAssociationEnd_1 <em>Association End 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getInlineAssociation_()
 * @model
 * @generated
 */
public interface InlineAssociation_ extends EObject
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
   * @see cruise.umple.umple.UmplePackage#getInlineAssociation__Modifier_1()
   * @model
   * @generated
   */
  String getModifier_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.InlineAssociation_#getModifier_1 <em>Modifier 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifier 1</em>' attribute.
   * @see #getModifier_1()
   * @generated
   */
  void setModifier_1(String value);

  /**
   * Returns the value of the '<em><b>Inline Association End 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.InlineAssociationEnd_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inline Association End 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inline Association End 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInlineAssociation__InlineAssociationEnd_1()
   * @model containment="true"
   * @generated
   */
  EList<InlineAssociationEnd_> getInlineAssociationEnd_1();

  /**
   * Returns the value of the '<em><b>Arrow 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arrow 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arrow 1</em>' attribute.
   * @see #setArrow_1(String)
   * @see cruise.umple.umple.UmplePackage#getInlineAssociation__Arrow_1()
   * @model
   * @generated
   */
  String getArrow_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.InlineAssociation_#getArrow_1 <em>Arrow 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arrow 1</em>' attribute.
   * @see #getArrow_1()
   * @generated
   */
  void setArrow_1(String value);

  /**
   * Returns the value of the '<em><b>Association End 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AssociationEnd_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association End 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association End 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInlineAssociation__AssociationEnd_1()
   * @model containment="true"
   * @generated
   */
  EList<AssociationEnd_> getAssociationEnd_1();

} // InlineAssociation_
