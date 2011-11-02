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
 * A representation of the model object '<em><b>relational Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.relationalExpression#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link cruise.umple.umple.relationalExpression#getExpressionRest <em>Expression Rest</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getrelationalExpression()
 * @model
 * @generated
 */
public interface relationalExpression extends EObject
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
   * @see #setExpression1(additiveExpression)
   * @see cruise.umple.umple.UmplePackage#getrelationalExpression_Expression1()
   * @model containment="true"
   * @generated
   */
  additiveExpression getExpression1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.relationalExpression#getExpression1 <em>Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression1</em>' containment reference.
   * @see #getExpression1()
   * @generated
   */
  void setExpression1(additiveExpression value);

  /**
   * Returns the value of the '<em><b>Expression Rest</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.additiveExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression Rest</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression Rest</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getrelationalExpression_ExpressionRest()
   * @model containment="true"
   * @generated
   */
  EList<additiveExpression> getExpressionRest();

} // relationalExpression
