/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>java Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.javaFunctionDeclaration#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link cruise.umple.umple.javaFunctionDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umple.javaFunctionDeclaration#getArgList <em>Arg List</em>}</li>
 *   <li>{@link cruise.umple.umple.javaFunctionDeclaration#getArgListID <em>Arg List ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getjavaFunctionDeclaration()
 * @model
 * @generated
 */
public interface javaFunctionDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Return Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Type</em>' attribute.
   * @see #setReturnType(String)
   * @see cruise.umple.umple.UmplePackage#getjavaFunctionDeclaration_ReturnType()
   * @model
   * @generated
   */
  String getReturnType();

  /**
   * Sets the value of the '{@link cruise.umple.umple.javaFunctionDeclaration#getReturnType <em>Return Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return Type</em>' attribute.
   * @see #getReturnType()
   * @generated
   */
  void setReturnType(String value);

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
   * @see cruise.umple.umple.UmplePackage#getjavaFunctionDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.javaFunctionDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Arg List</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arg List</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg List</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getjavaFunctionDeclaration_ArgList()
   * @model unique="false"
   * @generated
   */
  EList<String> getArgList();

  /**
   * Returns the value of the '<em><b>Arg List ID</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arg List ID</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg List ID</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getjavaFunctionDeclaration_ArgListID()
   * @model unique="false"
   * @generated
   */
  EList<String> getArgListID();

} // javaFunctionDeclaration
