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
 * A representation of the model object '<em><b>Trace Entity </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceEntity_#getTraceOptions_1 <em>Trace Options 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceEntity_#getTrace_entity_1 <em>Trace entity 1</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceEntity_#getAnonymous_traceEntity_1_1 <em>Anonymous trace Entity 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceEntity_()
 * @model
 * @generated
 */
public interface TraceEntity_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Options 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceOptions_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Options 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Options 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceEntity__TraceOptions_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceOptions_> getTraceOptions_1();

  /**
   * Returns the value of the '<em><b>Trace entity 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace entity 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace entity 1</em>' attribute.
   * @see #setTrace_entity_1(String)
   * @see cruise.umple.umple.UmplePackage#getTraceEntity__Trace_entity_1()
   * @model
   * @generated
   */
  String getTrace_entity_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceEntity_#getTrace_entity_1 <em>Trace entity 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trace entity 1</em>' attribute.
   * @see #getTrace_entity_1()
   * @generated
   */
  void setTrace_entity_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous trace Entity 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_traceEntity_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous trace Entity 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous trace Entity 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceEntity__Anonymous_traceEntity_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_traceEntity_1_> getAnonymous_traceEntity_1_1();

} // TraceEntity_
