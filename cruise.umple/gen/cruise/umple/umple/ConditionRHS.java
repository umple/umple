/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition RHS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ConditionRHS#getOperand <em>Operand</em>}</li>
 *   <li>{@link cruise.umple.umple.ConditionRHS#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getConditionRHS()
 * @model
 * @generated
 */
public interface ConditionRHS extends EObject
{
  /**
   * Returns the value of the '<em><b>Operand</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' attribute.
   * @see #setOperand(String)
   * @see cruise.umple.umple.UmplePackage#getConditionRHS_Operand()
   * @model
   * @generated
   */
  String getOperand();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ConditionRHS#getOperand <em>Operand</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' attribute.
   * @see #getOperand()
   * @generated
   */
  void setOperand(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see cruise.umple.umple.UmplePackage#getConditionRHS_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ConditionRHS#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // ConditionRHS
