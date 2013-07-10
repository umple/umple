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
 * A representation of the model object '<em><b>State Internal </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.StateInternal_#getComment_1 <em>Comment 1</em>}</li>
 *   <li>{@link cruise.umple.umple.StateInternal_#getChangeType_1 <em>Change Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.StateInternal_#getStateEntity_1 <em>State Entity 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getStateInternal_()
 * @model
 * @generated
 */
public interface StateInternal_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Comment 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Comment_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comment 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comment 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateInternal__Comment_1()
   * @model containment="true"
   * @generated
   */
  EList<Comment_> getComment_1();

  /**
   * Returns the value of the '<em><b>Change Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Change Type 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Change Type 1</em>' attribute.
   * @see #setChangeType_1(String)
   * @see cruise.umple.umple.UmplePackage#getStateInternal__ChangeType_1()
   * @model
   * @generated
   */
  String getChangeType_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.StateInternal_#getChangeType_1 <em>Change Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Change Type 1</em>' attribute.
   * @see #getChangeType_1()
   * @generated
   */
  void setChangeType_1(String value);

  /**
   * Returns the value of the '<em><b>State Entity 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.StateEntity_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Entity 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Entity 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getStateInternal__StateEntity_1()
   * @model containment="true"
   * @generated
   */
  EList<StateEntity_> getStateEntity_1();

} // StateInternal_
