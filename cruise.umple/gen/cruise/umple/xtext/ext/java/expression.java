/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.xtext.ext.java.expression#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.expression#getExpression2 <em>Expression2</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.xtext.ext.java.JavaPackage#getexpression()
 * @model
 * @generated
 */
public interface expression extends parExpression, statement
{
  /**
   * Returns the value of the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression1</em>' containment reference.
   * @see #setExpression1(conditionalExpression)
   * @see cruise.umple.xtext.ext.java.JavaPackage#getexpression_Expression1()
   * @model containment="true"
   * @generated
   */
  conditionalExpression getExpression1();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.expression#getExpression1 <em>Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression1</em>' containment reference.
   * @see #getExpression1()
   * @generated
   */
  void setExpression1(conditionalExpression value);

  /**
   * Returns the value of the '<em><b>Expression2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression2</em>' containment reference.
   * @see #setExpression2(expression)
   * @see cruise.umple.xtext.ext.java.JavaPackage#getexpression_Expression2()
   * @model containment="true"
   * @generated
   */
  expression getExpression2();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.expression#getExpression2 <em>Expression2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression2</em>' containment reference.
   * @see #getExpression2()
   * @generated
   */
  void setExpression2(expression value);

} // expression
