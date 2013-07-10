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
 * A representation of the model object '<em><b>Ordinal Op </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.OrdinalOp_#getGreaterOp_1 <em>Greater Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.OrdinalOp_#getLessOp_1 <em>Less Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.OrdinalOp_#getMoreOp_1 <em>More Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.OrdinalOp_#getSmallerOp_1 <em>Smaller Op 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getOrdinalOp_()
 * @model
 * @generated
 */
public interface OrdinalOp_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Greater Op 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.GreaterOp_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Greater Op 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Greater Op 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getOrdinalOp__GreaterOp_1()
   * @model containment="true"
   * @generated
   */
  EList<GreaterOp_> getGreaterOp_1();

  /**
   * Returns the value of the '<em><b>Less Op 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.LessOp_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Less Op 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Less Op 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getOrdinalOp__LessOp_1()
   * @model containment="true"
   * @generated
   */
  EList<LessOp_> getLessOp_1();

  /**
   * Returns the value of the '<em><b>More Op 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.MoreOp_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>More Op 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>More Op 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getOrdinalOp__MoreOp_1()
   * @model containment="true"
   * @generated
   */
  EList<MoreOp_> getMoreOp_1();

  /**
   * Returns the value of the '<em><b>Smaller Op 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.SmallerOp_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Smaller Op 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Smaller Op 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getOrdinalOp__SmallerOp_1()
   * @model containment="true"
   * @generated
   */
  EList<SmallerOp_> getSmallerOp_1();

} // OrdinalOp_
