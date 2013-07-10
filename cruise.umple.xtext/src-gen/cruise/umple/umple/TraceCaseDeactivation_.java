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
 * A representation of the model object '<em><b>Trace Case Deactivation </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceCaseDeactivation_#getTracecase_deact_name_1 <em>Tracecase deact name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCaseDeactivation_#getDeActivateFor_1 <em>De Activate For 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceCaseDeactivation_()
 * @model
 * @generated
 */
public interface TraceCaseDeactivation_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Tracecase deact name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tracecase deact name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tracecase deact name 1</em>' attribute.
   * @see #setTracecase_deact_name_1(String)
   * @see cruise.umple.umple.UmplePackage#getTraceCaseDeactivation__Tracecase_deact_name_1()
   * @model
   * @generated
   */
  String getTracecase_deact_name_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCaseDeactivation_#getTracecase_deact_name_1 <em>Tracecase deact name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tracecase deact name 1</em>' attribute.
   * @see #getTracecase_deact_name_1()
   * @generated
   */
  void setTracecase_deact_name_1(String value);

  /**
   * Returns the value of the '<em><b>De Activate For 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.DeActivateFor_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>De Activate For 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>De Activate For 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceCaseDeactivation__DeActivateFor_1()
   * @model containment="true"
   * @generated
   */
  EList<DeActivateFor_> getDeActivateFor_1();

} // TraceCaseDeactivation_
