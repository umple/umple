/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ENUM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ENUM#getState1 <em>State1</em>}</li>
 *   <li>{@link cruise.umple.umple.ENUM#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getENUM()
 * @model
 * @generated
 */
public interface ENUM extends StateMachine
{
  /**
   * Returns the value of the '<em><b>State1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State1</em>' attribute.
   * @see #setState1(String)
   * @see cruise.umple.umple.UmplePackage#getENUM_State1()
   * @model
   * @generated
   */
  String getState1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ENUM#getState1 <em>State1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State1</em>' attribute.
   * @see #getState1()
   * @generated
   */
  void setState1(String value);

  /**
   * Returns the value of the '<em><b>States</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getENUM_States()
   * @model unique="false"
   * @generated
   */
  EList<String> getStates();

} // ENUM
