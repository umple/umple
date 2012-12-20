/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>is A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.isA#getExtendsClass <em>Extends Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getisA()
 * @model
 * @generated
 */
public interface isA extends SoftwarePattern
{
  /**
   * Returns the value of the '<em><b>Extends Class</b></em>' reference list.
   * The list contents are of type {@link cruise.umple.umple.UmpleElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends Class</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends Class</em>' reference list.
   * @see cruise.umple.umple.UmplePackage#getisA_ExtendsClass()
   * @model
   * @generated
   */
  EList<UmpleElement> getExtendsClass();

} // isA
