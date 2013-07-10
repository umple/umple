/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition RHS </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ConditionRHS_#getComparison_operator_1 <em>Comparison operator 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ConditionRHS_#getRHS_1 <em>RHS 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getConditionRHS_()
 * @model
 * @generated
 */
public interface ConditionRHS_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Comparison operator 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comparison operator 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comparison operator 1</em>' attribute.
   * @see #setComparison_operator_1(String)
   * @see cruise.umple.umple.UmplePackage#getConditionRHS__Comparison_operator_1()
   * @model
   * @generated
   */
  String getComparison_operator_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ConditionRHS_#getComparison_operator_1 <em>Comparison operator 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comparison operator 1</em>' attribute.
   * @see #getComparison_operator_1()
   * @generated
   */
  void setComparison_operator_1(String value);

  /**
   * Returns the value of the '<em><b>RHS 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>RHS 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>RHS 1</em>' attribute.
   * @see #setRHS_1(String)
   * @see cruise.umple.umple.UmplePackage#getConditionRHS__RHS_1()
   * @model
   * @generated
   */
  String getRHS_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ConditionRHS_#getRHS_1 <em>RHS 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>RHS 1</em>' attribute.
   * @see #getRHS_1()
   * @generated
   */
  void setRHS_1(String value);

} // ConditionRHS_
