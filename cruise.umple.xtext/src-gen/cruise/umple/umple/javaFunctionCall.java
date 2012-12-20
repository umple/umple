/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>java Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.javaFunctionCall#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umple.javaFunctionCall#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getjavaFunctionCall()
 * @model
 * @generated
 */
public interface javaFunctionCall extends literal, functionCall
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see cruise.umple.umple.UmplePackage#getjavaFunctionCall_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.javaFunctionCall#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference.
   * @see #setArgs(expressionList)
   * @see cruise.umple.umple.UmplePackage#getjavaFunctionCall_Args()
   * @model containment="true"
   * @generated
   */
  expressionList getArgs();

  /**
   * Sets the value of the '{@link cruise.umple.umple.javaFunctionCall#getArgs <em>Args</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Args</em>' containment reference.
   * @see #getArgs()
   * @generated
   */
  void setArgs(expressionList value);

} // javaFunctionCall
