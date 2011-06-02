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
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.UmpleModel#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleModel#getGlossary <em>Glossary</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleModel#getGenerate_ <em>Generate </em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleModel#getTraceMechanism <em>Trace Mechanism</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleModel#getUses <em>Uses</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleModel#getUmpleElements <em>Umple Elements</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleModel#getAssociations <em>Associations</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleModel#getAssociationClasses <em>Association Classes</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleModel#getStatemachines <em>Statemachines</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getUmpleModel()
 * @model
 * @generated
 */
public interface UmpleModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Namespace</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Namespace</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Namespace</em>' containment reference.
   * @see #setNamespace(Namespace)
   * @see cruise.umple.umple.UmplePackage#getUmpleModel_Namespace()
   * @model containment="true"
   * @generated
   */
  Namespace getNamespace();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleModel#getNamespace <em>Namespace</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Namespace</em>' containment reference.
   * @see #getNamespace()
   * @generated
   */
  void setNamespace(Namespace value);

  /**
   * Returns the value of the '<em><b>Glossary</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Glossary</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Glossary</em>' containment reference.
   * @see #setGlossary(Glossary)
   * @see cruise.umple.umple.UmplePackage#getUmpleModel_Glossary()
   * @model containment="true"
   * @generated
   */
  Glossary getGlossary();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleModel#getGlossary <em>Glossary</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Glossary</em>' containment reference.
   * @see #getGlossary()
   * @generated
   */
  void setGlossary(Glossary value);

  /**
   * Returns the value of the '<em><b>Generate </b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generate </em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generate </em>' containment reference.
   * @see #setGenerate_(Generate)
   * @see cruise.umple.umple.UmplePackage#getUmpleModel_Generate_()
   * @model containment="true"
   * @generated
   */
  Generate getGenerate_();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleModel#getGenerate_ <em>Generate </em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Generate </em>' containment reference.
   * @see #getGenerate_()
   * @generated
   */
  void setGenerate_(Generate value);

  /**
   * Returns the value of the '<em><b>Trace Mechanism</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Mechanism</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Mechanism</em>' containment reference.
   * @see #setTraceMechanism(TraceMechanism)
   * @see cruise.umple.umple.UmplePackage#getUmpleModel_TraceMechanism()
   * @model containment="true"
   * @generated
   */
  TraceMechanism getTraceMechanism();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleModel#getTraceMechanism <em>Trace Mechanism</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trace Mechanism</em>' containment reference.
   * @see #getTraceMechanism()
   * @generated
   */
  void setTraceMechanism(TraceMechanism value);

  /**
   * Returns the value of the '<em><b>Uses</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uses</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uses</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getUmpleModel_Uses()
   * @model unique="false"
   * @generated
   */
  EList<String> getUses();

  /**
   * Returns the value of the '<em><b>Umple Elements</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.UmpleElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Umple Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Umple Elements</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleModel_UmpleElements()
   * @model containment="true"
   * @generated
   */
  EList<UmpleElement> getUmpleElements();

  /**
   * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.UmpleAssociation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Associations</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleModel_Associations()
   * @model containment="true"
   * @generated
   */
  EList<UmpleAssociation> getAssociations();

  /**
   * Returns the value of the '<em><b>Association Classes</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.UmpleAssociationClass}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association Classes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Classes</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleModel_AssociationClasses()
   * @model containment="true"
   * @generated
   */
  EList<UmpleAssociationClass> getAssociationClasses();

  /**
   * Returns the value of the '<em><b>Statemachines</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.StateMachineDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statemachines</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statemachines</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleModel_Statemachines()
   * @model containment="true"
   * @generated
   */
  EList<StateMachineDefinition> getStatemachines();

} // UmpleModel
