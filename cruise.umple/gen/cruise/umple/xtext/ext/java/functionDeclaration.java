/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>function Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.xtext.ext.java.functionDeclaration#getJava <em>Java</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.xtext.ext.java.JavaPackage#getfunctionDeclaration()
 * @model
 * @generated
 */
public interface functionDeclaration extends EObject
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
   * @see #setJava(javaFunctionDeclaration)
   * @see cruise.umple.xtext.ext.java.JavaPackage#getfunctionDeclaration_Java()
   * @model containment="true"
   * @generated
   */
  javaFunctionDeclaration getJava();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.functionDeclaration#getJava <em>Java</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Java</em>' containment reference.
   * @see #getJava()
   * @generated
   */
  void setJava(javaFunctionDeclaration value);

} // functionDeclaration
