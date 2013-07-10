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
 * A representation of the model object '<em><b>Trace Item </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceItem_#getTraceEntity_1 <em>Trace Entity 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceItem_#getPreOrPostCondition_1 <em>Pre Or Post Condition 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceItem_()
 * @model
 * @generated
 */
public interface TraceItem_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Entity 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceEntity_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Entity 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Entity 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceItem__TraceEntity_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceEntity_> getTraceEntity_1();

  /**
   * Returns the value of the '<em><b>Pre Or Post Condition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.PreOrPostCondition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pre Or Post Condition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pre Or Post Condition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceItem__PreOrPostCondition_1()
   * @model containment="true"
   * @generated
   */
  EList<PreOrPostCondition_> getPreOrPostCondition_1();

} // TraceItem_
