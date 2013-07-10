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
 * A representation of the model object '<em><b>Gen Expr </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.GenExpr_#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.GenExpr_#getAnonymous_genExpr_1_1 <em>Anonymous gen Expr 11</em>}</li>
 *   <li>{@link cruise.umple.umple.GenExpr_#getEqualityOp_1 <em>Equality Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.GenExpr_#getName_2 <em>Name 2</em>}</li>
 *   <li>{@link cruise.umple.umple.GenExpr_#getAnonymous_genExpr_2_1 <em>Anonymous gen Expr 21</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getGenExpr_()
 * @model
 * @generated
 */
public interface GenExpr_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name 1</em>' attribute.
   * @see #setName_1(String)
   * @see cruise.umple.umple.UmplePackage#getGenExpr__Name_1()
   * @model
   * @generated
   */
  String getName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.GenExpr_#getName_1 <em>Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name 1</em>' attribute.
   * @see #getName_1()
   * @generated
   */
  void setName_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous gen Expr 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_genExpr_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous gen Expr 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous gen Expr 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getGenExpr__Anonymous_genExpr_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_genExpr_1_> getAnonymous_genExpr_1_1();

  /**
   * Returns the value of the '<em><b>Equality Op 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.EqualityOp_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equality Op 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equality Op 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getGenExpr__EqualityOp_1()
   * @model containment="true"
   * @generated
   */
  EList<EqualityOp_> getEqualityOp_1();

  /**
   * Returns the value of the '<em><b>Name 2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name 2</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name 2</em>' attribute.
   * @see #setName_2(String)
   * @see cruise.umple.umple.UmplePackage#getGenExpr__Name_2()
   * @model
   * @generated
   */
  String getName_2();

  /**
   * Sets the value of the '{@link cruise.umple.umple.GenExpr_#getName_2 <em>Name 2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name 2</em>' attribute.
   * @see #getName_2()
   * @generated
   */
  void setName_2(String value);

  /**
   * Returns the value of the '<em><b>Anonymous gen Expr 21</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_genExpr_2_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous gen Expr 21</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous gen Expr 21</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getGenExpr__Anonymous_genExpr_2_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_genExpr_2_> getAnonymous_genExpr_2_1();

} // GenExpr_
