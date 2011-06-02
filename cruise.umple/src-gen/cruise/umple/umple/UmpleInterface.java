/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.UmpleInterface#getExtraCode <em>Extra Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getUmpleInterface()
 * @model
 * @generated
 */
public interface UmpleInterface extends UmpleElement
{
  /**
   * Returns the value of the '<em><b>Extra Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extra Code</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extra Code</em>' containment reference.
   * @see #setExtraCode(functionDeclaration)
   * @see cruise.umple.umple.UmplePackage#getUmpleInterface_ExtraCode()
   * @model containment="true"
   * @generated
   */
  functionDeclaration getExtraCode();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleInterface#getExtraCode <em>Extra Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extra Code</em>' containment reference.
   * @see #getExtraCode()
   * @generated
   */
  void setExtraCode(functionDeclaration value);

} // UmpleInterface
