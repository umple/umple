/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.unaryExpression#getExp1 <em>Exp1</em>}</li>
 *   <li>{@link cruise.umple.umple.unaryExpression#getExp2 <em>Exp2</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getunaryExpression()
 * @model
 * @generated
 */
public interface unaryExpression extends unaryExpressionNotPlusMinus
{
  /**
   * Returns the value of the '<em><b>Exp1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exp1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp1</em>' containment reference.
   * @see #setExp1(unaryExpression)
   * @see cruise.umple.umple.UmplePackage#getunaryExpression_Exp1()
   * @model containment="true"
   * @generated
   */
  unaryExpression getExp1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.unaryExpression#getExp1 <em>Exp1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp1</em>' containment reference.
   * @see #getExp1()
   * @generated
   */
  void setExp1(unaryExpression value);

  /**
   * Returns the value of the '<em><b>Exp2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exp2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp2</em>' containment reference.
   * @see #setExp2(unaryExpressionNotPlusMinus)
   * @see cruise.umple.umple.UmplePackage#getunaryExpression_Exp2()
   * @model containment="true"
   * @generated
   */
  unaryExpressionNotPlusMinus getExp2();

  /**
   * Sets the value of the '{@link cruise.umple.umple.unaryExpression#getExp2 <em>Exp2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp2</em>' containment reference.
   * @see #getExp2()
   * @generated
   */
  void setExp2(unaryExpressionNotPlusMinus value);

} // unaryExpression
