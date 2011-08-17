/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Key#getKeys <em>Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getKey()
 * @model
 * @generated
 */
public interface Key extends KeyDefinition
{
  /**
   * Returns the value of the '<em><b>Keys</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Keys</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keys</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getKey_Keys()
   * @model unique="false"
   * @generated
   */
  EList<String> getKeys();

} // Key
