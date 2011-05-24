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
 * A representation of the model object '<em><b>Trace Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceCase#getTraceCaseName <em>Trace Case Name</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#getTraceDirective <em>Trace Directive</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#getActivateCaseName <em>Activate Case Name</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#isActivateOnThis <em>Activate On This</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#isActivateOnThisThread <em>Activate On This Thread</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#getRepeats <em>Repeats</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#getPeriod <em>Period</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#getUnite <em>Unite</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#getDuration <em>Duration</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#getUntilCondition <em>Until Condition</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#getDeactivateCaseName <em>Deactivate Case Name</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#getDeactivateTime <em>Deactivate Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceCase()
 * @model
 * @generated
 */
public interface TraceCase extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Case Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Case Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Case Name</em>' attribute.
   * @see #setTraceCaseName(String)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_TraceCaseName()
   * @model
   * @generated
   */
  String getTraceCaseName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#getTraceCaseName <em>Trace Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trace Case Name</em>' attribute.
   * @see #getTraceCaseName()
   * @generated
   */
  void setTraceCaseName(String value);

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
   * @see cruise.umple.umple.UmplePackage#getTraceCase_TraceDirective()
   * @model containment="true"
   * @generated
   */
  EList<TraceDirective> getTraceDirective();

  /**
   * Returns the value of the '<em><b>Activate Case Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activate Case Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activate Case Name</em>' attribute.
   * @see #setActivateCaseName(String)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_ActivateCaseName()
   * @model
   * @generated
   */
  String getActivateCaseName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#getActivateCaseName <em>Activate Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activate Case Name</em>' attribute.
   * @see #getActivateCaseName()
   * @generated
   */
  void setActivateCaseName(String value);

  /**
   * Returns the value of the '<em><b>Activate On This</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activate On This</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activate On This</em>' attribute.
   * @see #setActivateOnThis(boolean)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_ActivateOnThis()
   * @model
   * @generated
   */
  boolean isActivateOnThis();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#isActivateOnThis <em>Activate On This</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activate On This</em>' attribute.
   * @see #isActivateOnThis()
   * @generated
   */
  void setActivateOnThis(boolean value);

  /**
   * Returns the value of the '<em><b>Activate On This Thread</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activate On This Thread</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activate On This Thread</em>' attribute.
   * @see #setActivateOnThisThread(boolean)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_ActivateOnThisThread()
   * @model
   * @generated
   */
  boolean isActivateOnThisThread();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#isActivateOnThisThread <em>Activate On This Thread</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activate On This Thread</em>' attribute.
   * @see #isActivateOnThisThread()
   * @generated
   */
  void setActivateOnThisThread(boolean value);

  /**
   * Returns the value of the '<em><b>Repeats</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Repeats</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repeats</em>' attribute.
   * @see #setRepeats(int)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_Repeats()
   * @model
   * @generated
   */
  int getRepeats();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#getRepeats <em>Repeats</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Repeats</em>' attribute.
   * @see #getRepeats()
   * @generated
   */
  void setRepeats(int value);

  /**
   * Returns the value of the '<em><b>Period</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Period</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Period</em>' attribute.
   * @see #setPeriod(int)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_Period()
   * @model
   * @generated
   */
  int getPeriod();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#getPeriod <em>Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Period</em>' attribute.
   * @see #getPeriod()
   * @generated
   */
  void setPeriod(int value);

  /**
   * Returns the value of the '<em><b>Unite</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unite</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unite</em>' attribute.
   * @see #setUnite(String)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_Unite()
   * @model
   * @generated
   */
  String getUnite();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#getUnite <em>Unite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unite</em>' attribute.
   * @see #getUnite()
   * @generated
   */
  void setUnite(String value);

  /**
   * Returns the value of the '<em><b>Duration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Duration</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Duration</em>' attribute.
   * @see #setDuration(int)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_Duration()
   * @model
   * @generated
   */
  int getDuration();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#getDuration <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Duration</em>' attribute.
   * @see #getDuration()
   * @generated
   */
  void setDuration(int value);

  /**
   * Returns the value of the '<em><b>Until Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Until Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Until Condition</em>' containment reference.
   * @see #setUntilCondition(TraceCondition)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_UntilCondition()
   * @model containment="true"
   * @generated
   */
  TraceCondition getUntilCondition();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#getUntilCondition <em>Until Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Until Condition</em>' containment reference.
   * @see #getUntilCondition()
   * @generated
   */
  void setUntilCondition(TraceCondition value);

  /**
   * Returns the value of the '<em><b>Deactivate Case Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deactivate Case Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deactivate Case Name</em>' attribute.
   * @see #setDeactivateCaseName(String)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_DeactivateCaseName()
   * @model
   * @generated
   */
  String getDeactivateCaseName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#getDeactivateCaseName <em>Deactivate Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deactivate Case Name</em>' attribute.
   * @see #getDeactivateCaseName()
   * @generated
   */
  void setDeactivateCaseName(String value);

  /**
   * Returns the value of the '<em><b>Deactivate Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deactivate Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deactivate Time</em>' attribute.
   * @see #setDeactivateTime(int)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_DeactivateTime()
   * @model
   * @generated
   */
  int getDeactivateTime();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#getDeactivateTime <em>Deactivate Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deactivate Time</em>' attribute.
   * @see #getDeactivateTime()
   * @generated
   */
  void setDeactivateTime(int value);

} // TraceCase
