/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ifstatement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ifstatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link cruise.umple.umple.ifstatement#getState1 <em>State1</em>}</li>
 *   <li>{@link cruise.umple.umple.ifstatement#getState2 <em>State2</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getifstatement()
 * @model
 * @generated
 */
public interface ifstatement extends statement
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(parExpression)
   * @see cruise.umple.umple.UmplePackage#getifstatement_Condition()
   * @model containment="true"
   * @generated
   */
  parExpression getCondition();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ifstatement#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(parExpression value);

  /**
   * Returns the value of the '<em><b>State1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State1</em>' containment reference.
   * @see #setState1(statement)
   * @see cruise.umple.umple.UmplePackage#getifstatement_State1()
   * @model containment="true"
   * @generated
   */
  statement getState1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ifstatement#getState1 <em>State1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State1</em>' containment reference.
   * @see #getState1()
   * @generated
   */
  void setState1(statement value);

  /**
   * Returns the value of the '<em><b>State2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State2</em>' containment reference.
   * @see #setState2(statement)
   * @see cruise.umple.umple.UmplePackage#getifstatement_State2()
   * @model containment="true"
   * @generated
   */
  statement getState2();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ifstatement#getState2 <em>State2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State2</em>' containment reference.
   * @see #getState2()
   * @generated
   */
  void setState2(statement value);

} // ifstatement
