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
 * A representation of the model object '<em><b>Anonymous linking Op 2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Anonymous_linkingOp_2_#getAndOp_1 <em>And Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Anonymous_linkingOp_2_#getConstraintExpr_1 <em>Constraint Expr 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getAnonymous_linkingOp_2_()
 * @model
 * @generated
 */
public interface Anonymous_linkingOp_2_ extends EObject
{
  /**
   * Returns the value of the '<em><b>And Op 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>And Op 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>And Op 1</em>' attribute.
   * @see #setAndOp_1(String)
   * @see cruise.umple.umple.UmplePackage#getAnonymous_linkingOp_2__AndOp_1()
   * @model
   * @generated
   */
  String getAndOp_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Anonymous_linkingOp_2_#getAndOp_1 <em>And Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>And Op 1</em>' attribute.
   * @see #getAndOp_1()
   * @generated
   */
  void setAndOp_1(String value);

  /**
   * Returns the value of the '<em><b>Constraint Expr 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ConstraintExpr_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint Expr 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint Expr 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAnonymous_linkingOp_2__ConstraintExpr_1()
   * @model containment="true"
   * @generated
   */
  EList<ConstraintExpr_> getConstraintExpr_1();

} // Anonymous_linkingOp_2_
