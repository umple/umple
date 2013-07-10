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
 * A representation of the model object '<em><b>Constraint Body </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ConstraintBody_#getConstraintExpr_1 <em>Constraint Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ConstraintBody_#getAnonymous_constraintBody_1_1 <em>Anonymous constraint Body 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getConstraintBody_()
 * @model
 * @generated
 */
public interface ConstraintBody_ extends EObject
{
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
   * @see cruise.umple.umple.UmplePackage#getConstraintBody__ConstraintExpr_1()
   * @model containment="true"
   * @generated
   */
  EList<ConstraintExpr_> getConstraintExpr_1();

  /**
   * Returns the value of the '<em><b>Anonymous constraint Body 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_constraintBody_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous constraint Body 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous constraint Body 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConstraintBody__Anonymous_constraintBody_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_constraintBody_1_> getAnonymous_constraintBody_1_1();

} // ConstraintBody_
