/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ExternalDefinition#getClassContent <em>Class Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getExternalDefinition()
 * @model
 * @generated
 */
public interface ExternalDefinition extends Entity
{
  /**
   * Returns the value of the '<em><b>Class Content</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ClassContent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Content</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Content</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getExternalDefinition_ClassContent()
   * @model containment="true"
   * @generated
   */
  EList<ClassContent> getClassContent();

} // ExternalDefinition
