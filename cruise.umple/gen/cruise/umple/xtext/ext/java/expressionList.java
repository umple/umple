/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>expression List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.xtext.ext.java.expressionList#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.xtext.ext.java.JavaPackage#getexpressionList()
 * @model
 * @generated
 */
public interface expressionList extends forUpdate
{
  /**
   * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.xtext.ext.java.expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expressions</em>' containment reference list.
   * @see cruise.umple.xtext.ext.java.JavaPackage#getexpressionList_Expressions()
   * @model containment="true"
   * @generated
   */
  EList<expression> getExpressions();

} // expressionList
