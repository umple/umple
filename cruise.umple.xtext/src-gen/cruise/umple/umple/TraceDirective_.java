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
 * A representation of the model object '<em><b>Trace Directive </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceDirective_#getTraceItem_1 <em>Trace Item 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective_#getAnonymous_traceDirective_1_1 <em>Anonymous trace Directive 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceDirective_()
 * @model
 * @generated
 */
public interface TraceDirective_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Item 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceItem_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Item 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Item 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceDirective__TraceItem_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceItem_> getTraceItem_1();

  /**
   * Returns the value of the '<em><b>Anonymous trace Directive 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_traceDirective_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous trace Directive 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous trace Directive 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceDirective__Anonymous_traceDirective_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_traceDirective_1_> getAnonymous_traceDirective_1_1();

} // TraceDirective_
