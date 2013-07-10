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
 * A representation of the model object '<em><b>Constraint Token </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ConstraintToken_#getConstraint_1 <em>Constraint 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getConstraintToken_()
 * @model
 * @generated
 */
public interface ConstraintToken_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Constraint 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Constraint_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConstraintToken__Constraint_1()
   * @model containment="true"
   * @generated
   */
  EList<Constraint_> getConstraint_1();

} // ConstraintToken_
