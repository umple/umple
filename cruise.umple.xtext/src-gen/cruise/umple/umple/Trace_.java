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
 * A representation of the model object '<em><b>Trace </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Trace_#getTraceDirective_1 <em>Trace Directive 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Trace_#getTraceCase_1 <em>Trace Case 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTrace_()
 * @model
 * @generated
 */
public interface Trace_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Directive 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceDirective_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Directive 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Directive 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTrace__TraceDirective_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceDirective_> getTraceDirective_1();

  /**
   * Returns the value of the '<em><b>Trace Case 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceCase_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Case 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Case 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTrace__TraceCase_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceCase_> getTraceCase_1();

} // Trace_
