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
 * A representation of the model object '<em><b>Anonymous trace Options 1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Anonymous_traceOptions_1_#getTraceOption_1 <em>Trace Option 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getAnonymous_traceOptions_1_()
 * @model
 * @generated
 */
public interface Anonymous_traceOptions_1_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Option 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceOption_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Option 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Option 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAnonymous_traceOptions_1__TraceOption_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceOption_> getTraceOption_1();

} // Anonymous_traceOptions_1_
