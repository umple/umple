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
 * A representation of the model object '<em><b>Pre Or Post Condition </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.PreOrPostCondition_#getAnonymous_PreOrPostCondition_1_1 <em>Anonymous Pre Or Post Condition 11</em>}</li>
 *   <li>{@link cruise.umple.umple.PreOrPostCondition_#getTraceCondition_1 <em>Trace Condition 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getPreOrPostCondition_()
 * @model
 * @generated
 */
public interface PreOrPostCondition_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Anonymous Pre Or Post Condition 11</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous Pre Or Post Condition 11</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous Pre Or Post Condition 11</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getPreOrPostCondition__Anonymous_PreOrPostCondition_1_1()
   * @model unique="false"
   * @generated
   */
  EList<String> getAnonymous_PreOrPostCondition_1_1();

  /**
   * Returns the value of the '<em><b>Trace Condition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceCondition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Condition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Condition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getPreOrPostCondition__TraceCondition_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceCondition_> getTraceCondition_1();

} // PreOrPostCondition_
