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
 * A representation of the model object '<em><b>Trace Condition </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceCondition_#getLHS_1 <em>LHS 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCondition_#getConditionRHS_1 <em>Condition RHS 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceCondition_()
 * @model
 * @generated
 */
public interface TraceCondition_ extends EObject
{
  /**
   * Returns the value of the '<em><b>LHS 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>LHS 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>LHS 1</em>' attribute.
   * @see #setLHS_1(String)
   * @see cruise.umple.umple.UmplePackage#getTraceCondition__LHS_1()
   * @model
   * @generated
   */
  String getLHS_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCondition_#getLHS_1 <em>LHS 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>LHS 1</em>' attribute.
   * @see #getLHS_1()
   * @generated
   */
  void setLHS_1(String value);

  /**
   * Returns the value of the '<em><b>Condition RHS 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ConditionRHS_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition RHS 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition RHS 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceCondition__ConditionRHS_1()
   * @model containment="true"
   * @generated
   */
  EList<ConditionRHS_> getConditionRHS_1();

} // TraceCondition_
