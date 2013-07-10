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
 * A representation of the model object '<em><b>Trace Case Activation </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceCaseActivation_#getTracecase_act_name_1 <em>Tracecase act name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCaseActivation_#getAnonymous_traceCaseActivation_1_1 <em>Anonymous trace Case Activation 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceCaseActivation_()
 * @model
 * @generated
 */
public interface TraceCaseActivation_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Tracecase act name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tracecase act name 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tracecase act name 1</em>' attribute.
   * @see #setTracecase_act_name_1(String)
   * @see cruise.umple.umple.UmplePackage#getTraceCaseActivation__Tracecase_act_name_1()
   * @model
   * @generated
   */
  String getTracecase_act_name_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCaseActivation_#getTracecase_act_name_1 <em>Tracecase act name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tracecase act name 1</em>' attribute.
   * @see #getTracecase_act_name_1()
   * @generated
   */
  void setTracecase_act_name_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous trace Case Activation 11</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous trace Case Activation 11</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous trace Case Activation 11</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getTraceCaseActivation__Anonymous_traceCaseActivation_1_1()
   * @model unique="false"
   * @generated
   */
  EList<String> getAnonymous_traceCaseActivation_1_1();

} // TraceCaseActivation_
