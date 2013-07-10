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
 * A representation of the model object '<em><b>Constraint Expr </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ConstraintExpr_#getNegativeConstraint_1 <em>Negative Constraint 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ConstraintExpr_#getStringExpr_1 <em>String Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ConstraintExpr_#getBoolExpr_1 <em>Bool Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ConstraintExpr_#getGenExpr_1 <em>Gen Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ConstraintExpr_#getNumExpr_1 <em>Num Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ConstraintExpr_#getLoneBoolean_1 <em>Lone Boolean 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ConstraintExpr_#getAnonymous_constraintExpr_1_1 <em>Anonymous constraint Expr 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getConstraintExpr_()
 * @model
 * @generated
 */
public interface ConstraintExpr_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Negative Constraint 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.NegativeConstraint_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Negative Constraint 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Negative Constraint 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConstraintExpr__NegativeConstraint_1()
   * @model containment="true"
   * @generated
   */
  EList<NegativeConstraint_> getNegativeConstraint_1();

  /**
   * Returns the value of the '<em><b>String Expr 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.StringExpr_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String Expr 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String Expr 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConstraintExpr__StringExpr_1()
   * @model containment="true"
   * @generated
   */
  EList<StringExpr_> getStringExpr_1();

  /**
   * Returns the value of the '<em><b>Bool Expr 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.BoolExpr_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bool Expr 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bool Expr 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConstraintExpr__BoolExpr_1()
   * @model containment="true"
   * @generated
   */
  EList<BoolExpr_> getBoolExpr_1();

  /**
   * Returns the value of the '<em><b>Gen Expr 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.GenExpr_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Gen Expr 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gen Expr 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConstraintExpr__GenExpr_1()
   * @model containment="true"
   * @generated
   */
  EList<GenExpr_> getGenExpr_1();

  /**
   * Returns the value of the '<em><b>Num Expr 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.NumExpr_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Num Expr 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num Expr 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConstraintExpr__NumExpr_1()
   * @model containment="true"
   * @generated
   */
  EList<NumExpr_> getNumExpr_1();

  /**
   * Returns the value of the '<em><b>Lone Boolean 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lone Boolean 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lone Boolean 1</em>' attribute.
   * @see #setLoneBoolean_1(String)
   * @see cruise.umple.umple.UmplePackage#getConstraintExpr__LoneBoolean_1()
   * @model
   * @generated
   */
  String getLoneBoolean_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ConstraintExpr_#getLoneBoolean_1 <em>Lone Boolean 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lone Boolean 1</em>' attribute.
   * @see #getLoneBoolean_1()
   * @generated
   */
  void setLoneBoolean_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous constraint Expr 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_constraintExpr_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous constraint Expr 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous constraint Expr 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConstraintExpr__Anonymous_constraintExpr_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_constraintExpr_1_> getAnonymous_constraintExpr_1_1();

} // ConstraintExpr_
