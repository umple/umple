/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceRecord#getObjectBeingTraced <em>Object Being Traced</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceRecord#getTextOutput <em>Text Output</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceRecord()
 * @model
 * @generated
 */
public interface TraceRecord extends EObject
{
  /**
   * Returns the value of the '<em><b>Object Being Traced</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object Being Traced</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object Being Traced</em>' attribute.
   * @see #setObjectBeingTraced(String)
   * @see cruise.umple.umple.UmplePackage#getTraceRecord_ObjectBeingTraced()
   * @model
   * @generated
   */
  String getObjectBeingTraced();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceRecord#getObjectBeingTraced <em>Object Being Traced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Being Traced</em>' attribute.
   * @see #getObjectBeingTraced()
   * @generated
   */
  void setObjectBeingTraced(String value);

  /**
   * Returns the value of the '<em><b>Text Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Text Output</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text Output</em>' attribute.
   * @see #setTextOutput(String)
   * @see cruise.umple.umple.UmplePackage#getTraceRecord_TextOutput()
   * @model
   * @generated
   */
  String getTextOutput();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceRecord#getTextOutput <em>Text Output</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text Output</em>' attribute.
   * @see #getTextOutput()
   * @generated
   */
  void setTextOutput(String value);

} // TraceRecord
