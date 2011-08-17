/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.InterfaceDefinition#getDepend <em>Depend</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getInterfaceDefinition()
 * @model
 * @generated
 */
public interface InterfaceDefinition extends Entity, UmpleElement
{
  /**
   * Returns the value of the '<em><b>Depend</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Depend}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Depend</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Depend</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInterfaceDefinition_Depend()
   * @model containment="true"
   * @generated
   */
  EList<Depend> getDepend();

} // InterfaceDefinition
