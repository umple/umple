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
 * A representation of the model object '<em><b>Compound Expr </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.CompoundExpr_#getStringExpr_1 <em>String Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.CompoundExpr_#getBoolExpr_1 <em>Bool Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.CompoundExpr_#getNumExpr_1 <em>Num Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.CompoundExpr_#getGenExpr_1 <em>Gen Expr 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getCompoundExpr_()
 * @model
 * @generated
 */
public interface CompoundExpr_ extends EObject
{
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
   * @see cruise.umple.umple.UmplePackage#getCompoundExpr__StringExpr_1()
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
   * @see cruise.umple.umple.UmplePackage#getCompoundExpr__BoolExpr_1()
   * @model containment="true"
   * @generated
   */
  EList<BoolExpr_> getBoolExpr_1();

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
   * @see cruise.umple.umple.UmplePackage#getCompoundExpr__NumExpr_1()
   * @model containment="true"
   * @generated
   */
  EList<NumExpr_> getNumExpr_1();

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
   * @see cruise.umple.umple.UmplePackage#getCompoundExpr__GenExpr_1()
   * @model containment="true"
   * @generated
   */
  EList<GenExpr_> getGenExpr_1();

} // CompoundExpr_
