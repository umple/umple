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
 * A representation of the model object '<em><b>Software Pattern </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.SoftwarePattern_#getIsA_1 <em>Is A1</em>}</li>
 *   <li>{@link cruise.umple.umple.SoftwarePattern_#getSingleton_1 <em>Singleton 1</em>}</li>
 *   <li>{@link cruise.umple.umple.SoftwarePattern_#getImmutable_1 <em>Immutable 1</em>}</li>
 *   <li>{@link cruise.umple.umple.SoftwarePattern_#getKeyDefinition_1 <em>Key Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.SoftwarePattern_#getCodeInjection_1 <em>Code Injection 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getSoftwarePattern_()
 * @model
 * @generated
 */
public interface SoftwarePattern_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Is A1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.IsA_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is A1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is A1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getSoftwarePattern__IsA_1()
   * @model containment="true"
   * @generated
   */
  EList<IsA_> getIsA_1();

  /**
   * Returns the value of the '<em><b>Singleton 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Singleton_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Singleton 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Singleton 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getSoftwarePattern__Singleton_1()
   * @model containment="true"
   * @generated
   */
  EList<Singleton_> getSingleton_1();

  /**
   * Returns the value of the '<em><b>Immutable 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Immutable_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Immutable 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Immutable 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getSoftwarePattern__Immutable_1()
   * @model containment="true"
   * @generated
   */
  EList<Immutable_> getImmutable_1();

  /**
   * Returns the value of the '<em><b>Key Definition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.KeyDefinition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key Definition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key Definition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getSoftwarePattern__KeyDefinition_1()
   * @model containment="true"
   * @generated
   */
  EList<KeyDefinition_> getKeyDefinition_1();

  /**
   * Returns the value of the '<em><b>Code Injection 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.CodeInjection_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code Injection 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code Injection 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getSoftwarePattern__CodeInjection_1()
   * @model containment="true"
   * @generated
   */
  EList<CodeInjection_> getCodeInjection_1();

} // SoftwarePattern_
