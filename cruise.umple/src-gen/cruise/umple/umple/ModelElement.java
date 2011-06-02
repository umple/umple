/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

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
 *   <li>{@link cruise.umple.umple.ModelElement#getAttribute <em>Attribute</em>}</li>
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

} // ModelElement
