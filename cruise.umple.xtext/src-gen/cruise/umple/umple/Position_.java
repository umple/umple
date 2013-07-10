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
 * A representation of the model object '<em><b>Position </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Position_#getAssociationPosition_1 <em>Association Position 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Position_#getElementPosition_1 <em>Element Position 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getPosition_()
 * @model
 * @generated
 */
public interface Position_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Association Position 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AssociationPosition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association Position 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Position 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getPosition__AssociationPosition_1()
   * @model containment="true"
   * @generated
   */
  EList<AssociationPosition_> getAssociationPosition_1();

  /**
   * Returns the value of the '<em><b>Element Position 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ElementPosition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element Position 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element Position 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getPosition__ElementPosition_1()
   * @model containment="true"
   * @generated
   */
  EList<ElementPosition_> getElementPosition_1();

} // Position_
