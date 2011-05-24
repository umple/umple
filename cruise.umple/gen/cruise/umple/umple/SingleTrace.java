/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.SingleTrace#getTraceItem <em>Trace Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getSingleTrace()
 * @model
 * @generated
 */
public interface SingleTrace extends TraceType
{
  /**
   * Returns the value of the '<em><b>Trace Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Item</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Item</em>' reference.
   * @see #setTraceItem(UmpleAttribute)
   * @see cruise.umple.umple.UmplePackage#getSingleTrace_TraceItem()
   * @model
   * @generated
   */
  UmpleAttribute getTraceItem();

  /**
   * Sets the value of the '{@link cruise.umple.umple.SingleTrace#getTraceItem <em>Trace Item</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trace Item</em>' reference.
   * @see #getTraceItem()
   * @generated
   */
  void setTraceItem(UmpleAttribute value);

} // SingleTrace
