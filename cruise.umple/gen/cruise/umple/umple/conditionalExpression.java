/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.conditionalExpression#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link cruise.umple.umple.conditionalExpression#getExpression2 <em>Expression2</em>}</li>
 *   <li>{@link cruise.umple.umple.conditionalExpression#getExpression3 <em>Expression3</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getconditionalExpression()
 * @model
 * @generated
 */
public interface conditionalExpression extends EObject
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
   * @see #setExpression1(conditionalOrExpression)
   * @see cruise.umple.umple.UmplePackage#getconditionalExpression_Expression1()
   * @model containment="true"
   * @generated
   */
  conditionalOrExpression getExpression1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.conditionalExpression#getExpression1 <em>Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression1</em>' containment reference.
   * @see #getExpression1()
   * @generated
   */
  void setExpression1(conditionalOrExpression value);

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
   * @see cruise.umple.umple.UmplePackage#getconditionalExpression_Expression2()
   * @model containment="true"
   * @generated
   */
  expression getExpression2();

  /**
   * Sets the value of the '{@link cruise.umple.umple.conditionalExpression#getExpression2 <em>Expression2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression2</em>' containment reference.
   * @see #getExpression2()
   * @generated
   */
  void setExpression2(expression value);

  /**
   * Returns the value of the '<em><b>Expression3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression3</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression3</em>' containment reference.
   * @see #setExpression3(expression)
   * @see cruise.umple.umple.UmplePackage#getconditionalExpression_Expression3()
   * @model containment="true"
   * @generated
   */
  expression getExpression3();

  /**
   * Sets the value of the '{@link cruise.umple.umple.conditionalExpression#getExpression3 <em>Expression3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression3</em>' containment reference.
   * @see #getExpression3()
   * @generated
   */
  void setExpression3(expression value);

} // conditionalExpression
