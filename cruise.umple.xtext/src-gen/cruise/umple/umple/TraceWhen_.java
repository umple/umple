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
 * A representation of the model object '<em><b>Trace When </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceWhen_#getConditionType_1 <em>Condition Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceWhen_#getConstraintToken_1 <em>Constraint Token 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceWhen_()
 * @model
 * @generated
 */
public interface TraceWhen_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Condition Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition Type 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition Type 1</em>' attribute.
   * @see #setConditionType_1(String)
   * @see cruise.umple.umple.UmplePackage#getTraceWhen__ConditionType_1()
   * @model
   * @generated
   */
  String getConditionType_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceWhen_#getConditionType_1 <em>Condition Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition Type 1</em>' attribute.
   * @see #getConditionType_1()
   * @generated
   */
  void setConditionType_1(String value);

  /**
   * Returns the value of the '<em><b>Constraint Token 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ConstraintToken_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint Token 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint Token 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceWhen__ConstraintToken_1()
   * @model containment="true"
   * @generated
   */
  EList<ConstraintToken_> getConstraintToken_1();

} // TraceWhen_
