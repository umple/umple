/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>java Function Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.javaFunctionDefinition#getDecl <em>Decl</em>}</li>
 *   <li>{@link cruise.umple.umple.javaFunctionDefinition#getCode <em>Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getjavaFunctionDefinition()
 * @model
 * @generated
 */
public interface javaFunctionDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decl</em>' containment reference.
   * @see #setDecl(javaFunctionDeclaration)
   * @see cruise.umple.umple.UmplePackage#getjavaFunctionDefinition_Decl()
   * @model containment="true"
   * @generated
   */
  javaFunctionDeclaration getDecl();

  /**
   * Sets the value of the '{@link cruise.umple.umple.javaFunctionDefinition#getDecl <em>Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decl</em>' containment reference.
   * @see #getDecl()
   * @generated
   */
  void setDecl(javaFunctionDeclaration value);

  /**
   * Returns the value of the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code</em>' containment reference.
   * @see #setCode(block)
   * @see cruise.umple.umple.UmplePackage#getjavaFunctionDefinition_Code()
   * @model containment="true"
   * @generated
   */
  block getCode();

  /**
   * Sets the value of the '{@link cruise.umple.umple.javaFunctionDefinition#getCode <em>Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code</em>' containment reference.
   * @see #getCode()
   * @generated
   */
  void setCode(block value);

} // javaFunctionDefinition
