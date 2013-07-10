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
 * A representation of the model object '<em><b>Entity </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Entity_#getClassDefinition_1 <em>Class Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Entity_#getInterfaceDefinition_1 <em>Interface Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Entity_#getExternalDefinition_1 <em>External Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Entity_#getAssociationDefinition_1 <em>Association Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Entity_#getAssociationClassDefinition_1 <em>Association Class Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Entity_#getStateMachineDefinition_1 <em>State Machine Definition 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getEntity_()
 * @model
 * @generated
 */
public interface Entity_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Class Definition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ClassDefinition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Definition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Definition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEntity__ClassDefinition_1()
   * @model containment="true"
   * @generated
   */
  EList<ClassDefinition_> getClassDefinition_1();

  /**
   * Returns the value of the '<em><b>Interface Definition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.InterfaceDefinition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interface Definition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interface Definition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEntity__InterfaceDefinition_1()
   * @model containment="true"
   * @generated
   */
  EList<InterfaceDefinition_> getInterfaceDefinition_1();

  /**
   * Returns the value of the '<em><b>External Definition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ExternalDefinition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External Definition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External Definition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEntity__ExternalDefinition_1()
   * @model containment="true"
   * @generated
   */
  EList<ExternalDefinition_> getExternalDefinition_1();

  /**
   * Returns the value of the '<em><b>Association Definition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AssociationDefinition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association Definition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Definition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEntity__AssociationDefinition_1()
   * @model containment="true"
   * @generated
   */
  EList<AssociationDefinition_> getAssociationDefinition_1();

  /**
   * Returns the value of the '<em><b>Association Class Definition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AssociationClassDefinition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association Class Definition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Class Definition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEntity__AssociationClassDefinition_1()
   * @model containment="true"
   * @generated
   */
  EList<AssociationClassDefinition_> getAssociationClassDefinition_1();

  /**
   * Returns the value of the '<em><b>State Machine Definition 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.StateMachineDefinition_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Machine Definition 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Machine Definition 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEntity__StateMachineDefinition_1()
   * @model containment="true"
   * @generated
   */
  EList<StateMachineDefinition_> getStateMachineDefinition_1();

} // Entity_
