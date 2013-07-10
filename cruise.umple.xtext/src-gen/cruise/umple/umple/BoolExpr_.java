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
 * A representation of the model object '<em><b>Bool Expr </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.BoolExpr_#getLiteral_1 <em>Literal 1</em>}</li>
 *   <li>{@link cruise.umple.umple.BoolExpr_#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.BoolExpr_#getEqualityOp_1 <em>Equality Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.BoolExpr_#getIndex_1 <em>Index 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getBoolExpr_()
 * @model
 * @generated
 */
public interface BoolExpr_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Literal 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literal 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal 1</em>' attribute.
   * @see #setLiteral_1(String)
   * @see cruise.umple.umple.UmplePackage#getBoolExpr__Literal_1()
   * @model
   * @generated
   */
  String getLiteral_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.BoolExpr_#getLiteral_1 <em>Literal 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Literal 1</em>' attribute.
   * @see #getLiteral_1()
   * @generated
   */
  void setLiteral_1(String value);

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
   * @see cruise.umple.umple.UmplePackage#getBoolExpr__Name_1()
   * @model
   * @generated
   */
  String getName_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.BoolExpr_#getName_1 <em>Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name 1</em>' attribute.
   * @see #getName_1()
   * @generated
   */
  void setName_1(String value);

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
   * @see cruise.umple.umple.UmplePackage#getBoolExpr__EqualityOp_1()
   * @model containment="true"
   * @generated
   */
  EList<EqualityOp_> getEqualityOp_1();

  /**
   * Returns the value of the '<em><b>Index 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index 1</em>' attribute.
   * @see #setIndex_1(String)
   * @see cruise.umple.umple.UmplePackage#getBoolExpr__Index_1()
   * @model
   * @generated
   */
  String getIndex_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.BoolExpr_#getIndex_1 <em>Index 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index 1</em>' attribute.
   * @see #getIndex_1()
   * @generated
   */
  void setIndex_1(String value);

} // BoolExpr_
