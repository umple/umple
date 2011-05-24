/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.xtext.ext.java.block#getBlocks <em>Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.xtext.ext.java.JavaPackage#getblock()
 * @model
 * @generated
 */
public interface block extends statement
{
  /**
   * Returns the value of the '<em><b>Blocks</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.xtext.ext.java.blockStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Blocks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Blocks</em>' containment reference list.
   * @see cruise.umple.xtext.ext.java.JavaPackage#getblock_Blocks()
   * @model containment="true"
   * @generated
   */
  EList<blockStatement> getBlocks();

} // block
