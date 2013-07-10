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
 * A representation of the model object '<em><b>Trace Record </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceRecord_#getRecordEntity_1 <em>Record Entity 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceRecord_()
 * @model
 * @generated
 */
public interface TraceRecord_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Record Entity 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.RecordEntity_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record Entity 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Record Entity 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceRecord__RecordEntity_1()
   * @model containment="true"
   * @generated
   */
  EList<RecordEntity_> getRecordEntity_1();

} // TraceRecord_
