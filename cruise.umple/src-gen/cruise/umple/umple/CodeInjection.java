/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Injection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.CodeInjection#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umple.CodeInjection#getCode <em>Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getCodeInjection()
 * @model
 * @generated
 */
public interface CodeInjection extends SoftwarePattern
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
   * @see cruise.umple.umple.UmplePackage#getCodeInjection_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.CodeInjection#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code</em>' attribute.
   * @see #setCode(String)
   * @see cruise.umple.umple.UmplePackage#getCodeInjection_Code()
   * @model
   * @generated
   */
  String getCode();

  /**
   * Sets the value of the '{@link cruise.umple.umple.CodeInjection#getCode <em>Code</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code</em>' attribute.
   * @see #getCode()
   * @generated
   */
  void setCode(String value);

} // CodeInjection
