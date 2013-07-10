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
 * A representation of the model object '<em><b>Key Definition </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.KeyDefinition_#getDefaultKey_1 <em>Default Key 1</em>}</li>
 *   <li>{@link cruise.umple.umple.KeyDefinition_#getKey_1 <em>Key 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getKeyDefinition_()
 * @model
 * @generated
 */
public interface KeyDefinition_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Default Key 1</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Key 1</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Key 1</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getKeyDefinition__DefaultKey_1()
   * @model unique="false"
   * @generated
   */
  EList<String> getDefaultKey_1();

  /**
   * Returns the value of the '<em><b>Key 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Key_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getKeyDefinition__Key_1()
   * @model containment="true"
   * @generated
   */
  EList<Key_> getKey_1();

} // KeyDefinition_
