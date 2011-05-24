/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>equality Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.xtext.ext.java.equalityExpression#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.equalityExpression#getExpressionRest <em>Expression Rest</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.xtext.ext.java.JavaPackage#getequalityExpression()
 * @model
 * @generated
 */
public interface equalityExpression extends EObject
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
   * @see #setExpression1(relationalExpression)
   * @see cruise.umple.xtext.ext.java.JavaPackage#getequalityExpression_Expression1()
   * @model containment="true"
   * @generated
   */
  relationalExpression getExpression1();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.equalityExpression#getExpression1 <em>Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression1</em>' containment reference.
   * @see #getExpression1()
   * @generated
   */
  void setExpression1(relationalExpression value);

  /**
   * Returns the value of the '<em><b>Expression Rest</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.xtext.ext.java.relationalExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression Rest</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression Rest</em>' containment reference list.
   * @see cruise.umple.xtext.ext.java.JavaPackage#getequalityExpression_ExpressionRest()
   * @model containment="true"
   * @generated
   */
  EList<relationalExpression> getExpressionRest();

} // equalityExpression
