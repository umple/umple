/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Class Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.AssociationClassDefinition#getAssociationClassContent <em>Association Class Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getAssociationClassDefinition()
 * @model
 * @generated
 */
public interface AssociationClassDefinition extends Entity
{
  /**
   * Returns the value of the '<em><b>Association Class Content</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AssociationClassContent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association Class Content</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Class Content</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getAssociationClassDefinition_AssociationClassContent()
   * @model containment="true"
   * @generated
   */
  EList<AssociationClassContent> getAssociationClassContent();

} // AssociationClassDefinition
