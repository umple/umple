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
 * A representation of the model object '<em><b>Is A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.IsA_#getSingleIsA_1 <em>Single Is A1</em>}</li>
 *   <li>{@link cruise.umple.umple.IsA_#getMultipleIsA_1 <em>Multiple Is A1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getIsA_()
 * @model
 * @generated
 */
public interface IsA_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Single Is A1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.SingleIsA_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Single Is A1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Single Is A1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getIsA__SingleIsA_1()
   * @model containment="true"
   * @generated
   */
  EList<SingleIsA_> getSingleIsA_1();

  /**
   * Returns the value of the '<em><b>Multiple Is A1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.MultipleIsA_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiple Is A1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiple Is A1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getIsA__MultipleIsA_1()
   * @model containment="true"
   * @generated
   */
  EList<MultipleIsA_> getMultipleIsA_1();

} // IsA_
