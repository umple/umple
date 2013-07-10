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
 * A representation of the model object '<em><b>Trace Case </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceCase_#getTraceCaseDef_1 <em>Trace Case Def 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase_#getTraceCaseActivation_1 <em>Trace Case Activation 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase_#getTraceCaseDeactivation_1 <em>Trace Case Deactivation 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceCase_()
 * @model
 * @generated
 */
public interface TraceCase_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Case Def 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceCaseDef_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Case Def 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Case Def 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceCase__TraceCaseDef_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceCaseDef_> getTraceCaseDef_1();

  /**
   * Returns the value of the '<em><b>Trace Case Activation 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceCaseActivation_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Case Activation 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Case Activation 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceCase__TraceCaseActivation_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceCaseActivation_> getTraceCaseActivation_1();

  /**
   * Returns the value of the '<em><b>Trace Case Deactivation 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceCaseDeactivation_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Case Deactivation 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Case Deactivation 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceCase__TraceCaseDeactivation_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceCaseDeactivation_> getTraceCaseDeactivation_1();

} // TraceCase_
