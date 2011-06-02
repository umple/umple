/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Trace Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.SimpleTraceCondition#getLhs <em>Lhs</em>}</li>
 *   <li>{@link cruise.umple.umple.SimpleTraceCondition#getConditionRHS <em>Condition RHS</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getSimpleTraceCondition()
 * @model
 * @generated
 */
public interface SimpleTraceCondition extends TraceCondition
{
  /**
   * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lhs</em>' containment reference.
   * @see #setLhs(ModelElement)
   * @see cruise.umple.umple.UmplePackage#getSimpleTraceCondition_Lhs()
   * @model containment="true"
   * @generated
   */
  ModelElement getLhs();

  /**
   * Sets the value of the '{@link cruise.umple.umple.SimpleTraceCondition#getLhs <em>Lhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lhs</em>' containment reference.
   * @see #getLhs()
   * @generated
   */
  void setLhs(ModelElement value);

  /**
   * Returns the value of the '<em><b>Condition RHS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition RHS</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition RHS</em>' containment reference.
   * @see #setConditionRHS(ConditionRHS)
   * @see cruise.umple.umple.UmplePackage#getSimpleTraceCondition_ConditionRHS()
   * @model containment="true"
   * @generated
   */
  ConditionRHS getConditionRHS();

  /**
   * Sets the value of the '{@link cruise.umple.umple.SimpleTraceCondition#getConditionRHS <em>Condition RHS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition RHS</em>' containment reference.
   * @see #getConditionRHS()
   * @generated
   */
  void setConditionRHS(ConditionRHS value);

} // SimpleTraceCondition
