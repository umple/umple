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
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ModelElement#isExecuteOnEntry <em>Execute On Entry</em>}</li>
 *   <li>{@link cruise.umple.umple.ModelElement#isExecuteOnExit <em>Execute On Exit</em>}</li>
 *   <li>{@link cruise.umple.umple.ModelElement#isCflow <em>Cflow</em>}</li>
 *   <li>{@link cruise.umple.umple.ModelElement#getAMethod <em>AMethod</em>}</li>
 *   <li>{@link cruise.umple.umple.ModelElement#getAssoc <em>Assoc</em>}</li>
 *   <li>{@link cruise.umple.umple.ModelElement#getConditionRHS <em>Condition RHS</em>}</li>
 *   <li>{@link cruise.umple.umple.ModelElement#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link cruise.umple.umple.ModelElement#getStateM <em>State M</em>}</li>
 *   <li>{@link cruise.umple.umple.ModelElement#isStateEntry <em>State Entry</em>}</li>
 *   <li>{@link cruise.umple.umple.ModelElement#isStateExit <em>State Exit</em>}</li>
 *   <li>{@link cruise.umple.umple.ModelElement#getAMethods <em>AMethods</em>}</li>
 *   <li>{@link cruise.umple.umple.ModelElement#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getModelElement()
 * @model
 * @generated
 */
public interface ModelElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Execute On Entry</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Execute On Entry</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Execute On Entry</em>' attribute.
   * @see #setExecuteOnEntry(boolean)
   * @see cruise.umple.umple.UmplePackage#getModelElement_ExecuteOnEntry()
   * @model
   * @generated
   */
  boolean isExecuteOnEntry();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ModelElement#isExecuteOnEntry <em>Execute On Entry</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Execute On Entry</em>' attribute.
   * @see #isExecuteOnEntry()
   * @generated
   */
  void setExecuteOnEntry(boolean value);

  /**
   * Returns the value of the '<em><b>Execute On Exit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Execute On Exit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Execute On Exit</em>' attribute.
   * @see #setExecuteOnExit(boolean)
   * @see cruise.umple.umple.UmplePackage#getModelElement_ExecuteOnExit()
   * @model
   * @generated
   */
  boolean isExecuteOnExit();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ModelElement#isExecuteOnExit <em>Execute On Exit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Execute On Exit</em>' attribute.
   * @see #isExecuteOnExit()
   * @generated
   */
  void setExecuteOnExit(boolean value);

  /**
   * Returns the value of the '<em><b>Cflow</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cflow</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cflow</em>' attribute.
   * @see #setCflow(boolean)
   * @see cruise.umple.umple.UmplePackage#getModelElement_Cflow()
   * @model
   * @generated
   */
  boolean isCflow();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ModelElement#isCflow <em>Cflow</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cflow</em>' attribute.
   * @see #isCflow()
   * @generated
   */
  void setCflow(boolean value);

  /**
   * Returns the value of the '<em><b>AMethod</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>AMethod</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>AMethod</em>' attribute.
   * @see #setAMethod(String)
   * @see cruise.umple.umple.UmplePackage#getModelElement_AMethod()
   * @model
   * @generated
   */
  String getAMethod();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ModelElement#getAMethod <em>AMethod</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>AMethod</em>' attribute.
   * @see #getAMethod()
   * @generated
   */
  void setAMethod(String value);

  /**
   * Returns the value of the '<em><b>Assoc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assoc</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assoc</em>' attribute.
   * @see #setAssoc(String)
   * @see cruise.umple.umple.UmplePackage#getModelElement_Assoc()
   * @model
   * @generated
   */
  String getAssoc();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ModelElement#getAssoc <em>Assoc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assoc</em>' attribute.
   * @see #getAssoc()
   * @generated
   */
  void setAssoc(String value);

  /**
   * Returns the value of the '<em><b>Condition RHS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition RHS</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition RHS</em>' containment reference.
   * @see #setConditionRHS(ConditionRHS)
   * @see cruise.umple.umple.UmplePackage#getModelElement_ConditionRHS()
   * @model containment="true"
   * @generated
   */
  ConditionRHS getConditionRHS();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ModelElement#getConditionRHS <em>Condition RHS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition RHS</em>' containment reference.
   * @see #getConditionRHS()
   * @generated
   */
  void setConditionRHS(ConditionRHS value);

  /**
   * Returns the value of the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute</em>' reference.
   * @see #setAttribute(UmpleAttribute)
   * @see cruise.umple.umple.UmplePackage#getModelElement_Attribute()
   * @model
   * @generated
   */
  UmpleAttribute getAttribute();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ModelElement#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(UmpleAttribute value);

  /**
   * Returns the value of the '<em><b>State M</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State M</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State M</em>' reference.
   * @see #setStateM(EObject)
   * @see cruise.umple.umple.UmplePackage#getModelElement_StateM()
   * @model
   * @generated
   */
  EObject getStateM();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ModelElement#getStateM <em>State M</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State M</em>' reference.
   * @see #getStateM()
   * @generated
   */
  void setStateM(EObject value);

  /**
   * Returns the value of the '<em><b>State Entry</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Entry</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Entry</em>' attribute.
   * @see #setStateEntry(boolean)
   * @see cruise.umple.umple.UmplePackage#getModelElement_StateEntry()
   * @model
   * @generated
   */
  boolean isStateEntry();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ModelElement#isStateEntry <em>State Entry</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Entry</em>' attribute.
   * @see #isStateEntry()
   * @generated
   */
  void setStateEntry(boolean value);

  /**
   * Returns the value of the '<em><b>State Exit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Exit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Exit</em>' attribute.
   * @see #setStateExit(boolean)
   * @see cruise.umple.umple.UmplePackage#getModelElement_StateExit()
   * @model
   * @generated
   */
  boolean isStateExit();

  /**
   * Sets the value of the '{@link cruise.umple.umple.ModelElement#isStateExit <em>State Exit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Exit</em>' attribute.
   * @see #isStateExit()
   * @generated
   */
  void setStateExit(boolean value);

  /**
   * Returns the value of the '<em><b>AMethods</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>AMethods</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>AMethods</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getModelElement_AMethods()
   * @model unique="false"
   * @generated
   */
  EList<String> getAMethods();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' reference list.
   * The list contents are of type {@link cruise.umple.umple.UmpleAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' reference list.
   * @see cruise.umple.umple.UmplePackage#getModelElement_Attributes()
   * @model
   * @generated
   */
  EList<UmpleAttribute> getAttributes();

} // ModelElement
