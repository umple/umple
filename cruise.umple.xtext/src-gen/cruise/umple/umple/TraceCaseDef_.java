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
 * A representation of the model object '<em><b>Trace Case Def </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceCaseDef_#getTracecase_name_1 <em>Tracecase name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCaseDef_#getTraceDirective_1 <em>Trace Directive 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceCaseDef_()
 * @model
 * @generated
 */
public interface TraceCaseDef_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Tracecase name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tracecase name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tracecase name 1</em>' attribute.
   * @see #setTracecase_name_1(String)
   * @see cruise.umple.umple.UmplePackage#getTraceCaseDef__Tracecase_name_1()
   * @model
   * @generated
   */
  String getTracecase_name_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCaseDef_#getTracecase_name_1 <em>Tracecase name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tracecase name 1</em>' attribute.
   * @see #getTracecase_name_1()
   * @generated
   */
  void setTracecase_name_1(String value);

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
   * @see cruise.umple.umple.UmplePackage#getTraceCaseDef__TraceDirective_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceDirective_> getTraceDirective_1();

} // TraceCaseDef_
