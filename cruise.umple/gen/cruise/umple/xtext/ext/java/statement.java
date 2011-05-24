/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.xtext.ext.java.statement#getCondition <em>Condition</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.statement#getState1 <em>State1</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.statement#getState2 <em>State2</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.statement#getControl <em>Control</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.statement#getState <em>State</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.statement#getRetVal <em>Ret Val</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.statement#getTryBlock <em>Try Block</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.statement#getCatchBlock <em>Catch Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.xtext.ext.java.JavaPackage#getstatement()
 * @model
 * @generated
 */
public interface statement extends blockStatement
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
   * @see cruise.umple.xtext.ext.java.JavaPackage#getstatement_Condition()
   * @model containment="true"
   * @generated
   */
  parExpression getCondition();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.statement#getCondition <em>Condition</em>}' containment reference.
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
   * @see cruise.umple.xtext.ext.java.JavaPackage#getstatement_State1()
   * @model containment="true"
   * @generated
   */
  statement getState1();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.statement#getState1 <em>State1</em>}' containment reference.
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
   * @see cruise.umple.xtext.ext.java.JavaPackage#getstatement_State2()
   * @model containment="true"
   * @generated
   */
  statement getState2();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.statement#getState2 <em>State2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State2</em>' containment reference.
   * @see #getState2()
   * @generated
   */
  void setState2(statement value);

  /**
   * Returns the value of the '<em><b>Control</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Control</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Control</em>' containment reference.
   * @see #setControl(forControl)
   * @see cruise.umple.xtext.ext.java.JavaPackage#getstatement_Control()
   * @model containment="true"
   * @generated
   */
  forControl getControl();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.statement#getControl <em>Control</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Control</em>' containment reference.
   * @see #getControl()
   * @generated
   */
  void setControl(forControl value);

  /**
   * Returns the value of the '<em><b>State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' containment reference.
   * @see #setState(statement)
   * @see cruise.umple.xtext.ext.java.JavaPackage#getstatement_State()
   * @model containment="true"
   * @generated
   */
  statement getState();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.statement#getState <em>State</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' containment reference.
   * @see #getState()
   * @generated
   */
  void setState(statement value);

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
   * @see cruise.umple.xtext.ext.java.JavaPackage#getstatement_RetVal()
   * @model containment="true"
   * @generated
   */
  expression getRetVal();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.statement#getRetVal <em>Ret Val</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ret Val</em>' containment reference.
   * @see #getRetVal()
   * @generated
   */
  void setRetVal(expression value);

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
   * @see cruise.umple.xtext.ext.java.JavaPackage#getstatement_TryBlock()
   * @model containment="true"
   * @generated
   */
  block getTryBlock();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.statement#getTryBlock <em>Try Block</em>}' containment reference.
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
   * @see cruise.umple.xtext.ext.java.JavaPackage#getstatement_CatchBlock()
   * @model containment="true"
   * @generated
   */
  block getCatchBlock();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.statement#getCatchBlock <em>Catch Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Catch Block</em>' containment reference.
   * @see #getCatchBlock()
   * @generated
   */
  void setCatchBlock(block value);

} // statement
