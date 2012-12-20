/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>returnstatement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.returnstatement#getRetVal <em>Ret Val</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getreturnstatement()
 * @model
 * @generated
 */
public interface returnstatement extends statement
{
  /**
   * Returns the value of the '<em><b>Ret Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ret Val</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ret Val</em>' containment reference.
   * @see #setRetVal(expression)
   * @see cruise.umple.umple.UmplePackage#getreturnstatement_RetVal()
   * @model containment="true"
   * @generated
   */
  expression getRetVal();

  /**
   * Sets the value of the '{@link cruise.umple.umple.returnstatement#getRetVal <em>Ret Val</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ret Val</em>' containment reference.
   * @see #getRetVal()
   * @generated
   */
  void setRetVal(expression value);

} // returnstatement
