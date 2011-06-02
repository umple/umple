/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard Code</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.GuardCode#getNativeExpression <em>Native Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getGuardCode()
 * @model
 * @generated
 */
public interface GuardCode extends Guard
{
  /**
   * Returns the value of the '<em><b>Native Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Native Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Native Expression</em>' containment reference.
   * @see #setNativeExpression(block)
   * @see cruise.umple.umple.UmplePackage#getGuardCode_NativeExpression()
   * @model containment="true"
   * @generated
   */
  block getNativeExpression();

  /**
   * Sets the value of the '{@link cruise.umple.umple.GuardCode#getNativeExpression <em>Native Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Native Expression</em>' containment reference.
   * @see #getNativeExpression()
   * @generated
   */
  void setNativeExpression(block value);

} // GuardCode
