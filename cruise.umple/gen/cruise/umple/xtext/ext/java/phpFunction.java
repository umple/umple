/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>php Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.xtext.ext.java.phpFunction#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.phpFunction#getCodeblock <em>Codeblock</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.xtext.ext.java.JavaPackage#getphpFunction()
 * @model
 * @generated
 */
public interface phpFunction extends EObject
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
   * @see cruise.umple.xtext.ext.java.JavaPackage#getphpFunction_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.phpFunction#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Codeblock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Codeblock</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Codeblock</em>' reference.
   * @see #setCodeblock(phpBlock)
   * @see cruise.umple.xtext.ext.java.JavaPackage#getphpFunction_Codeblock()
   * @model
   * @generated
   */
  phpBlock getCodeblock();

  /**
   * Sets the value of the '{@link cruise.umple.xtext.ext.java.phpFunction#getCodeblock <em>Codeblock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Codeblock</em>' reference.
   * @see #getCodeblock()
   * @generated
   */
  void setCodeblock(phpBlock value);

} // phpFunction
