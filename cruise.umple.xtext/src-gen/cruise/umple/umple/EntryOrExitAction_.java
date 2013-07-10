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
 * A representation of the model object '<em><b>Entry Or Exit Action </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.EntryOrExitAction_#getType_1 <em>Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.EntryOrExitAction_#getAnonymous_entryOrExitAction_1_1 <em>Anonymous entry Or Exit Action 11</em>}</li>
 *   <li>{@link cruise.umple.umple.EntryOrExitAction_#getCode_1 <em>Code 1</em>}</li>
 *   <li>{@link cruise.umple.umple.EntryOrExitAction_#getAnonymous_entryOrExitAction_2_1 <em>Anonymous entry Or Exit Action 21</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getEntryOrExitAction_()
 * @model
 * @generated
 */
public interface EntryOrExitAction_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type 1</em>' attribute.
   * @see #setType_1(String)
   * @see cruise.umple.umple.UmplePackage#getEntryOrExitAction__Type_1()
   * @model
   * @generated
   */
  String getType_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.EntryOrExitAction_#getType_1 <em>Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type 1</em>' attribute.
   * @see #getType_1()
   * @generated
   */
  void setType_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous entry Or Exit Action 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_entryOrExitAction_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous entry Or Exit Action 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous entry Or Exit Action 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEntryOrExitAction__Anonymous_entryOrExitAction_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_entryOrExitAction_1_> getAnonymous_entryOrExitAction_1_1();

  /**
   * Returns the value of the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code 1</em>' attribute.
   * @see #setCode_1(String)
   * @see cruise.umple.umple.UmplePackage#getEntryOrExitAction__Code_1()
   * @model
   * @generated
   */
  String getCode_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.EntryOrExitAction_#getCode_1 <em>Code 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code 1</em>' attribute.
   * @see #getCode_1()
   * @generated
   */
  void setCode_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous entry Or Exit Action 21</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_entryOrExitAction_2_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous entry Or Exit Action 21</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous entry Or Exit Action 21</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEntryOrExitAction__Anonymous_entryOrExitAction_2_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_entryOrExitAction_2_> getAnonymous_entryOrExitAction_2_1();

} // EntryOrExitAction_
