/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>trystatement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.trystatement#getTryBlock <em>Try Block</em>}</li>
 *   <li>{@link cruise.umple.umple.trystatement#getCatchBlock <em>Catch Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#gettrystatement()
 * @model
 * @generated
 */
public interface trystatement extends statement
{
  /**
   * Returns the value of the '<em><b>Try Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Try Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Try Block</em>' containment reference.
   * @see #setTryBlock(block)
   * @see cruise.umple.umple.UmplePackage#gettrystatement_TryBlock()
   * @model containment="true"
   * @generated
   */
  block getTryBlock();

  /**
   * Sets the value of the '{@link cruise.umple.umple.trystatement#getTryBlock <em>Try Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Try Block</em>' containment reference.
   * @see #getTryBlock()
   * @generated
   */
  void setTryBlock(block value);

  /**
   * Returns the value of the '<em><b>Catch Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Catch Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Catch Block</em>' containment reference.
   * @see #setCatchBlock(block)
   * @see cruise.umple.umple.UmplePackage#gettrystatement_CatchBlock()
   * @model containment="true"
   * @generated
   */
  block getCatchBlock();

  /**
   * Sets the value of the '{@link cruise.umple.umple.trystatement#getCatchBlock <em>Catch Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Catch Block</em>' containment reference.
   * @see #getCatchBlock()
   * @generated
   */
  void setCatchBlock(block value);

} // trystatement
