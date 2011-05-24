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
 *   <li>{@link cruise.umple.umple.UmpleClass#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#isSingleton <em>Singleton</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getKey <em>Key</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getCodeInjection <em>Code Injection</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getExtendsClass <em>Extends Class</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getParentInterfaces <em>Parent Interfaces</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getSymmetricReflexiveAssociations <em>Symmetric Reflexive Associations</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getInlineAssociation <em>Inline Association</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getPosition <em>Position</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getTraceDirective <em>Trace Directive</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleClass#getTraceCase <em>Trace Case</em>}</li>
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
   * Returns the value of the '<em><b>Extends Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends Class</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends Class</em>' reference.
   * @see #setExtendsClass(UmpleClass)
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_ExtendsClass()
   * @model
   * @generated
   */
  UmpleClass getExtendsClass();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleClass#getExtendsClass <em>Extends Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends Class</em>' reference.
   * @see #getExtendsClass()
   * @generated
   */
  void setExtendsClass(UmpleClass value);

  /**
   * Returns the value of the '<em><b>Parent Interfaces</b></em>' reference list.
   * The list contents are of type {@link cruise.umple.umple.UmpleInterface}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent Interfaces</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent Interfaces</em>' reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_ParentInterfaces()
   * @model
   * @generated
   */
  EList<UmpleInterface> getParentInterfaces();

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
   * Returns the value of the '<em><b>Inline Association</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.InlineAssociation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inline Association</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inline Association</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_InlineAssociation()
   * @model containment="true"
   * @generated
   */
  EList<InlineAssociation> getInlineAssociation();

  /**
   * Returns the value of the '<em><b>Position</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Position}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Position</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Position</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_Position()
   * @model containment="true"
   * @generated
   */
  EList<Position> getPosition();

  /**
   * Returns the value of the '<em><b>State Machine</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.StateMachine}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Machine</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Machine</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_StateMachine()
   * @model containment="true"
   * @generated
   */
  EList<StateMachine> getStateMachine();

  /**
   * Returns the value of the '<em><b>Trace Directive</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceDirective}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Directive</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Directive</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_TraceDirective()
   * @model containment="true"
   * @generated
   */
  EList<TraceDirective> getTraceDirective();

  /**
   * Returns the value of the '<em><b>Trace Case</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceCase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Case</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Case</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getUmpleClass_TraceCase()
   * @model containment="true"
   * @generated
   */
  EList<TraceCase> getTraceCase();

} // UmpleClass
