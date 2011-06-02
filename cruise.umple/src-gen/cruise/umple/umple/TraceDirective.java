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
 * A representation of the model object '<em><b>Trace Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceDirective#getTraceStart <em>Trace Start</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getConditionRHS <em>Condition RHS</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getElementPattern <em>Element Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceDirective()
 * @model
 * @generated
 */
public interface TraceDirective extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Start</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Start</em>' attribute.
   * @see #setTraceStart(String)
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_TraceStart()
   * @model
   * @generated
   */
  String getTraceStart();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getTraceStart <em>Trace Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trace Start</em>' attribute.
   * @see #getTraceStart()
   * @generated
   */
  void setTraceStart(String value);

  /**
   * Returns the value of the '<em><b>Model Element</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ModelElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model Element</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model Element</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_ModelElement()
   * @model containment="true"
   * @generated
   */
  EList<ModelElement> getModelElement();

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
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_ConditionRHS()
   * @model containment="true"
   * @generated
   */
  ConditionRHS getConditionRHS();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getConditionRHS <em>Condition RHS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition RHS</em>' containment reference.
   * @see #getConditionRHS()
   * @generated
   */
  void setConditionRHS(ConditionRHS value);

  /**
   * Returns the value of the '<em><b>Element Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element Pattern</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element Pattern</em>' attribute.
   * @see #setElementPattern(String)
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_ElementPattern()
   * @model
   * @generated
   */
  String getElementPattern();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getElementPattern <em>Element Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element Pattern</em>' attribute.
   * @see #getElementPattern()
   * @generated
   */
  void setElementPattern(String value);

} // TraceDirective
