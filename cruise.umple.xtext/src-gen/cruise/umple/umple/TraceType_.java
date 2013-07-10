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
 * A representation of the model object '<em><b>Trace Type </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceType_#getTracerType_1 <em>Tracer Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceType_#getAnonymous_traceType_1_1 <em>Anonymous trace Type 11</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceType_#getAnonymous_traceType_2_1 <em>Anonymous trace Type 21</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceType_()
 * @model
 * @generated
 */
public interface TraceType_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Tracer Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tracer Type 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tracer Type 1</em>' attribute.
   * @see #setTracerType_1(String)
   * @see cruise.umple.umple.UmplePackage#getTraceType__TracerType_1()
   * @model
   * @generated
   */
  String getTracerType_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceType_#getTracerType_1 <em>Tracer Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tracer Type 1</em>' attribute.
   * @see #getTracerType_1()
   * @generated
   */
  void setTracerType_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous trace Type 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_traceType_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous trace Type 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous trace Type 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceType__Anonymous_traceType_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_traceType_1_> getAnonymous_traceType_1_1();

  /**
   * Returns the value of the '<em><b>Anonymous trace Type 21</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_traceType_2_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous trace Type 21</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous trace Type 21</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceType__Anonymous_traceType_2_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_traceType_2_> getAnonymous_traceType_2_1();

} // TraceType_
