/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.UmpleClass#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#isExternal <em>External</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#isSingleton <em>Singleton</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getKey <em>Key</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getCodeInjection <em>Code Injection</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getExtendsClass <em>Extends Class</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getSymmetricReflexiveAssociations <em>Symmetric Reflexive Associations</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getInlineAssociations <em>Inline Associations</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getPositions <em>Positions</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getStateMachines <em>State Machines</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getTraceDirectives <em>Trace Directives</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getTraceCases <em>Trace Cases</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getExternalLanguage <em>External Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getUmpleClass()
 * @model
 * @generated
 */
public interface UmpleClass extends UmpleElement, associationClassContent
{
  /**
   * Returns the value of the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package Name</em>' attribute.
   * @see #setPackageName(String)
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_PackageName()
   * @model
   * @generated
   */
  String getPackageName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleClass#getPackageName <em>Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package Name</em>' attribute.
   * @see #getPackageName()
   * @generated
   */
  void setPackageName(String value);

  /**
   * Returns the value of the '<em><b>External</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External</em>' attribute.
   * @see #setExternal(boolean)
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_External()
   * @model
   * @generated
   */
  boolean isExternal();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleClass#isExternal <em>External</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>External</em>' attribute.
   * @see #isExternal()
   * @generated
   */
  void setExternal(boolean value);

  /**
   * Returns the value of the '<em><b>Singleton</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Singleton</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Singleton</em>' attribute.
   * @see #setSingleton(boolean)
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_Singleton()
   * @model
   * @generated
   */
  boolean isSingleton();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleClass#isSingleton <em>Singleton</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Singleton</em>' attribute.
   * @see #isSingleton()
   * @generated
   */
  void setSingleton(boolean value);

  /**
   * Returns the value of the '<em><b>Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' containment reference.
   * @see #setKey(Key)
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_Key()
   * @model containment="true"
   * @generated
   */
  Key getKey();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleClass#getKey <em>Key</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' containment reference.
   * @see #getKey()
   * @generated
   */
  void setKey(Key value);

  /**
   * Returns the value of the '<em><b>Code Injection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code Injection</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code Injection</em>' containment reference.
   * @see #setCodeInjection(CodeInjection)
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_CodeInjection()
   * @model containment="true"
   * @generated
   */
  CodeInjection getCodeInjection();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleClass#getCodeInjection <em>Code Injection</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code Injection</em>' containment reference.
   * @see #getCodeInjection()
   * @generated
   */
  void setCodeInjection(CodeInjection value);

  /**
   * Returns the value of the '<em><b>Extends Class</b></em>' reference list.
   * The list contents are of type {@link cruise.umple.umple.UmpleElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends Class</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends Class</em>' reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_ExtendsClass()
   * @model
   * @generated
   */
  EList<UmpleElement> getExtendsClass();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.UmpleAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<UmpleAttribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Symmetric Reflexive Associations</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.SymmetricReflexiveAssociation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Symmetric Reflexive Associations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Symmetric Reflexive Associations</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_SymmetricReflexiveAssociations()
   * @model containment="true"
   * @generated
   */
  EList<SymmetricReflexiveAssociation> getSymmetricReflexiveAssociations();

  /**
   * Returns the value of the '<em><b>Inline Associations</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.InlineAssociation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inline Associations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inline Associations</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_InlineAssociations()
   * @model containment="true"
   * @generated
   */
  EList<InlineAssociation> getInlineAssociations();

  /**
   * Returns the value of the '<em><b>Positions</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Position}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Positions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Positions</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_Positions()
   * @model containment="true"
   * @generated
   */
  EList<Position> getPositions();

  /**
   * Returns the value of the '<em><b>State Machines</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.StateMachine}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Machines</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Machines</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_StateMachines()
   * @model containment="true"
   * @generated
   */
  EList<StateMachine> getStateMachines();

  /**
   * Returns the value of the '<em><b>Trace Directives</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceDirective}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Directives</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Directives</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_TraceDirectives()
   * @model containment="true"
   * @generated
   */
  EList<TraceDirective> getTraceDirectives();

  /**
   * Returns the value of the '<em><b>Trace Cases</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceCase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Cases</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Cases</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_TraceCases()
   * @model containment="true"
   * @generated
   */
  EList<TraceCase> getTraceCases();

  /**
   * Returns the value of the '<em><b>External Language</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External Language</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External Language</em>' containment reference.
   * @see #setExternalLanguage(ExternalLanguage)
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_ExternalLanguage()
   * @model containment="true"
   * @generated
   */
  ExternalLanguage getExternalLanguage();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleClass#getExternalLanguage <em>External Language</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>External Language</em>' containment reference.
   * @see #getExternalLanguage()
   * @generated
   */
  void setExternalLanguage(ExternalLanguage value);

} // UmpleClass
