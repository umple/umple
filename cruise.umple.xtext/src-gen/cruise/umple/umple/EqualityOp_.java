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
 * A representation of the model object '<em><b>Equality Op </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.EqualityOp_#getEqualsOp_1 <em>Equals Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.EqualityOp_#getNotequalsOp_1 <em>Notequals Op 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getEqualityOp_()
 * @model
 * @generated
 */
public interface EqualityOp_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Equals Op 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.EqualsOp_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equals Op 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equals Op 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEqualityOp__EqualsOp_1()
   * @model containment="true"
   * @generated
   */
  EList<EqualsOp_> getEqualsOp_1();

  /**
   * Returns the value of the '<em><b>Notequals Op 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.NotequalsOp_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Notequals Op 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Notequals Op 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEqualityOp__NotequalsOp_1()
   * @model containment="true"
   * @generated
   */
  EList<NotequalsOp_> getNotequalsOp_1();

} // EqualityOp_
