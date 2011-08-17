/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>for Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.forControl#getInit <em>Init</em>}</li>
 *   <li>{@link cruise.umple.umple.forControl#getCondition <em>Condition</em>}</li>
 *   <li>{@link cruise.umple.umple.forControl#getUpdate <em>Update</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getforControl()
 * @model
 * @generated
 */
public interface forControl extends EObject
{
  /**
   * Returns the value of the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init</em>' containment reference.
   * @see #setInit(forInit)
   * @see cruise.umple.umple.UmplePackage#getforControl_Init()
   * @model containment="true"
   * @generated
   */
  forInit getInit();

  /**
   * Sets the value of the '{@link cruise.umple.umple.forControl#getInit <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init</em>' containment reference.
   * @see #getInit()
   * @generated
   */
  void setInit(forInit value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(expression)
   * @see cruise.umple.umple.UmplePackage#getforControl_Condition()
   * @model containment="true"
   * @generated
   */
  expression getCondition();

  /**
   * Sets the value of the '{@link cruise.umple.umple.forControl#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(expression value);

  /**
   * Returns the value of the '<em><b>Update</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Update</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Update</em>' containment reference.
   * @see #setUpdate(forUpdate)
   * @see cruise.umple.umple.UmplePackage#getforControl_Update()
   * @model containment="true"
   * @generated
   */
  forUpdate getUpdate();

  /**
   * Sets the value of the '{@link cruise.umple.umple.forControl#getUpdate <em>Update</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Update</em>' containment reference.
   * @see #getUpdate()
   * @generated
   */
  void setUpdate(forUpdate value);

} // forControl
