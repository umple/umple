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
 * A representation of the model object '<em><b>Concrete Method Declaration </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ConcreteMethodDeclaration_#getType_1 <em>Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ConcreteMethodDeclaration_#getMethodDeclarator_1 <em>Method Declarator 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ConcreteMethodDeclaration_#getAnonymous_concreteMethodDeclaration_1_1 <em>Anonymous concrete Method Declaration 11</em>}</li>
 *   <li>{@link cruise.umple.umple.ConcreteMethodDeclaration_#getMethodBody_1 <em>Method Body 1</em>}</li>
 *   <li>{@link cruise.umple.umple.ConcreteMethodDeclaration_#getAnonymous_concreteMethodDeclaration_2_1 <em>Anonymous concrete Method Declaration 21</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getConcreteMethodDeclaration_()
 * @model
 * @generated
 */
public interface ConcreteMethodDeclaration_ extends EObject
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
   * @see cruise.umple.umple.UmplePackage#getConcreteMethodDeclaration__Type_1()
   * @model
   * @generated
   */
  String getType_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ConcreteMethodDeclaration_#getType_1 <em>Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type 1</em>' attribute.
   * @see #getType_1()
   * @generated
   */
  void setType_1(String value);

  /**
   * Returns the value of the '<em><b>Method Declarator 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.MethodDeclarator_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Declarator 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Declarator 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConcreteMethodDeclaration__MethodDeclarator_1()
   * @model containment="true"
   * @generated
   */
  EList<MethodDeclarator_> getMethodDeclarator_1();

  /**
   * Returns the value of the '<em><b>Anonymous concrete Method Declaration 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_concreteMethodDeclaration_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous concrete Method Declaration 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous concrete Method Declaration 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConcreteMethodDeclaration__Anonymous_concreteMethodDeclaration_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_concreteMethodDeclaration_1_> getAnonymous_concreteMethodDeclaration_1_1();

  /**
   * Returns the value of the '<em><b>Method Body 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.MethodBody_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Body 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Body 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConcreteMethodDeclaration__MethodBody_1()
   * @model containment="true"
   * @generated
   */
  EList<MethodBody_> getMethodBody_1();

  /**
   * Returns the value of the '<em><b>Anonymous concrete Method Declaration 21</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_concreteMethodDeclaration_2_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous concrete Method Declaration 21</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous concrete Method Declaration 21</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getConcreteMethodDeclaration__Anonymous_concreteMethodDeclaration_2_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_concreteMethodDeclaration_2_> getAnonymous_concreteMethodDeclaration_2_1();

} // ConcreteMethodDeclaration_
