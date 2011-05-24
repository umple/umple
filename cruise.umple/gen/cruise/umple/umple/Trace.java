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
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Trace#getTraceItems <em>Trace Items</em>}</li>
 *   <li>{@link cruise.umple.umple.Trace#getCommand <em>Command</em>}</li>
 *   <li>{@link cruise.umple.umple.Trace#getCommands <em>Commands</em>}</li>
 *   <li>{@link cruise.umple.umple.Trace#getCondition <em>Condition</em>}</li>
 *   <li>{@link cruise.umple.umple.Trace#getUntil <em>Until</em>}</li>
 *   <li>{@link cruise.umple.umple.Trace#getOccur <em>Occur</em>}</li>
 *   <li>{@link cruise.umple.umple.Trace#getPeriod <em>Period</em>}</li>
 *   <li>{@link cruise.umple.umple.Trace#getDuring <em>During</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTrace()
 * @model
 * @generated
 */
public interface Trace extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Items</b></em>' reference list.
   * The list contents are of type {@link cruise.umple.umple.UmpleAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Items</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Items</em>' reference list.
   * @see cruise.umple.umple.UmplePackage#getTrace_TraceItems()
   * @model
   * @generated
   */
  EList<UmpleAttribute> getTraceItems();

  /**
   * Returns the value of the '<em><b>Command</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Command</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Command</em>' attribute.
   * @see #setCommand(String)
   * @see cruise.umple.umple.UmplePackage#getTrace_Command()
   * @model
   * @generated
   */
  String getCommand();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Trace#getCommand <em>Command</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Command</em>' attribute.
   * @see #getCommand()
   * @generated
   */
  void setCommand(String value);

  /**
   * Returns the value of the '<em><b>Commands</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Commands</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Commands</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getTrace_Commands()
   * @model unique="false"
   * @generated
   */
  EList<String> getCommands();

  /**
   * Returns the value of the '<em><b>Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' attribute.
   * @see #setCondition(String)
   * @see cruise.umple.umple.UmplePackage#getTrace_Condition()
   * @model
   * @generated
   */
  String getCondition();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Trace#getCondition <em>Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' attribute.
   * @see #getCondition()
   * @generated
   */
  void setCondition(String value);

  /**
   * Returns the value of the '<em><b>Until</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Until</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Until</em>' attribute.
   * @see #setUntil(String)
   * @see cruise.umple.umple.UmplePackage#getTrace_Until()
   * @model
   * @generated
   */
  String getUntil();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Trace#getUntil <em>Until</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Until</em>' attribute.
   * @see #getUntil()
   * @generated
   */
  void setUntil(String value);

  /**
   * Returns the value of the '<em><b>Occur</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Occur</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Occur</em>' attribute.
   * @see #setOccur(int)
   * @see cruise.umple.umple.UmplePackage#getTrace_Occur()
   * @model
   * @generated
   */
  int getOccur();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Trace#getOccur <em>Occur</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Occur</em>' attribute.
   * @see #getOccur()
   * @generated
   */
  void setOccur(int value);

  /**
   * Returns the value of the '<em><b>Period</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Period</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Period</em>' attribute.
   * @see #setPeriod(String)
   * @see cruise.umple.umple.UmplePackage#getTrace_Period()
   * @model
   * @generated
   */
  String getPeriod();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Trace#getPeriod <em>Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Period</em>' attribute.
   * @see #getPeriod()
   * @generated
   */
  void setPeriod(String value);

  /**
   * Returns the value of the '<em><b>During</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>During</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>During</em>' attribute.
   * @see #setDuring(String)
   * @see cruise.umple.umple.UmplePackage#getTrace_During()
   * @model
   * @generated
   */
  String getDuring();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Trace#getDuring <em>During</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>During</em>' attribute.
   * @see #getDuring()
   * @generated
   */
  void setDuring(String value);

} // Trace
