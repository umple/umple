/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Singleton</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Singleton#isSingleton <em>Singleton</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getSingleton()
 * @model
 * @generated
 */
public interface Singleton extends SoftwarePattern
{
  /**
   * Returns the value of the '<em><b>Singleton</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Singleton</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Singleton</em>' attribute.
   * @see #setSingleton(boolean)
   * @see cruise.umple.umple.UmplePackage#getSingleton_Singleton()
   * @model
   * @generated
   */
  boolean isSingleton();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Singleton#isSingleton <em>Singleton</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Singleton</em>' attribute.
   * @see #isSingleton()
   * @generated
   */
  void setSingleton(boolean value);

} // Singleton
