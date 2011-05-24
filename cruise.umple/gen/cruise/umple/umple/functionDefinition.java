/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>function Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.functionDefinition#getJava <em>Java</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getfunctionDefinition()
 * @model
 * @generated
 */
public interface functionDefinition extends associationClassContent
{
  /**
   * Returns the value of the '<em><b>Java</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java</em>' containment reference.
   * @see #setJava(javaFunctionDefinition)
   * @see cruise.umple.umple.UmplePackage#getfunctionDefinition_Java()
   * @model containment="true"
   * @generated
   */
  javaFunctionDefinition getJava();

  /**
   * Sets the value of the '{@link cruise.umple.umple.functionDefinition#getJava <em>Java</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Java</em>' containment reference.
   * @see #getJava()
   * @generated
   */
  void setJava(javaFunctionDefinition value);

} // functionDefinition
