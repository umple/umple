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
 * A representation of the model object '<em><b>Record Entity </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.RecordEntity_#getAnonymous_recordEntity_1_1 <em>Anonymous record Entity 11</em>}</li>
 *   <li>{@link cruise.umple.umple.RecordEntity_#getTrace_record_1 <em>Trace record 1</em>}</li>
 *   <li>{@link cruise.umple.umple.RecordEntity_#getAnonymous_recordEntity_2_1 <em>Anonymous record Entity 21</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getRecordEntity_()
 * @model
 * @generated
 */
public interface RecordEntity_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Anonymous record Entity 11</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous record Entity 11</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous record Entity 11</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getRecordEntity__Anonymous_recordEntity_1_1()
   * @model unique="false"
   * @generated
   */
  EList<String> getAnonymous_recordEntity_1_1();

  /**
   * Returns the value of the '<em><b>Trace record 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace record 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace record 1</em>' attribute.
   * @see #setTrace_record_1(String)
   * @see cruise.umple.umple.UmplePackage#getRecordEntity__Trace_record_1()
   * @model
   * @generated
   */
  String getTrace_record_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.RecordEntity_#getTrace_record_1 <em>Trace record 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trace record 1</em>' attribute.
   * @see #getTrace_record_1()
   * @generated
   */
  void setTrace_record_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous record Entity 21</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_recordEntity_2_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous record Entity 21</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous record Entity 21</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getRecordEntity__Anonymous_recordEntity_2_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_recordEntity_2_> getAnonymous_recordEntity_2_1();

} // RecordEntity_
