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
 * A representation of the model object '<em><b>Trace Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceDirective#getTraceStart <em>Trace Start</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getConditionRHS <em>Condition RHS</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getElementPattern <em>Element Pattern</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#isFor <em>For</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getRepeats <em>Repeats</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#isDuring <em>During</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getDuration <em>Duration</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getDurationUnite <em>Duration Unite</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#isHasPeriod <em>Has Period</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getPeriod <em>Period</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getPeriodUnite <em>Period Unite</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getCodeToExecute <em>Code To Execute</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getTraceRecord <em>Trace Record</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getUntilCondition <em>Until Condition</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceDirective#getWhereCondition <em>Where Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceDirective()
 * @model
 * @generated
 */
public interface TraceDirective extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Start</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Start</em>' attribute.
   * @see #setTraceStart(String)
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_TraceStart()
   * @model
   * @generated
   */
  String getTraceStart();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getTraceStart <em>Trace Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trace Start</em>' attribute.
   * @see #getTraceStart()
   * @generated
   */
  void setTraceStart(String value);

  /**
   * Returns the value of the '<em><b>Model Element</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ModelElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model Element</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model Element</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_ModelElement()
   * @model containment="true"
   * @generated
   */
  EList<ModelElement> getModelElement();

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
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_ConditionRHS()
   * @model containment="true"
   * @generated
   */
  ConditionRHS getConditionRHS();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getConditionRHS <em>Condition RHS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition RHS</em>' containment reference.
   * @see #getConditionRHS()
   * @generated
   */
  void setConditionRHS(ConditionRHS value);

  /**
   * Returns the value of the '<em><b>Element Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element Pattern</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element Pattern</em>' attribute.
   * @see #setElementPattern(String)
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_ElementPattern()
   * @model
   * @generated
   */
  String getElementPattern();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getElementPattern <em>Element Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element Pattern</em>' attribute.
   * @see #getElementPattern()
   * @generated
   */
  void setElementPattern(String value);

  /**
   * Returns the value of the '<em><b>For</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>For</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>For</em>' attribute.
   * @see #setFor(boolean)
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_For()
   * @model
   * @generated
   */
  boolean isFor();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#isFor <em>For</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>For</em>' attribute.
   * @see #isFor()
   * @generated
   */
  void setFor(boolean value);

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
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_Repeats()
   * @model
   * @generated
   */
  int getRepeats();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getRepeats <em>Repeats</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Repeats</em>' attribute.
   * @see #getRepeats()
   * @generated
   */
  void setRepeats(int value);

  /**
   * Returns the value of the '<em><b>During</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>During</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>During</em>' attribute.
   * @see #setDuring(boolean)
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_During()
   * @model
   * @generated
   */
  boolean isDuring();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#isDuring <em>During</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>During</em>' attribute.
   * @see #isDuring()
   * @generated
   */
  void setDuring(boolean value);

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
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_Duration()
   * @model
   * @generated
   */
  int getDuration();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getDuration <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Duration</em>' attribute.
   * @see #getDuration()
   * @generated
   */
  void setDuration(int value);

  /**
   * Returns the value of the '<em><b>Duration Unite</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Duration Unite</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Duration Unite</em>' attribute.
   * @see #setDurationUnite(String)
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_DurationUnite()
   * @model
   * @generated
   */
  String getDurationUnite();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getDurationUnite <em>Duration Unite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Duration Unite</em>' attribute.
   * @see #getDurationUnite()
   * @generated
   */
  void setDurationUnite(String value);

  /**
   * Returns the value of the '<em><b>Has Period</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Period</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Period</em>' attribute.
   * @see #setHasPeriod(boolean)
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_HasPeriod()
   * @model
   * @generated
   */
  boolean isHasPeriod();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#isHasPeriod <em>Has Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Period</em>' attribute.
   * @see #isHasPeriod()
   * @generated
   */
  void setHasPeriod(boolean value);

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
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_Period()
   * @model
   * @generated
   */
  int getPeriod();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getPeriod <em>Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Period</em>' attribute.
   * @see #getPeriod()
   * @generated
   */
  void setPeriod(int value);

  /**
   * Returns the value of the '<em><b>Period Unite</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Period Unite</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Period Unite</em>' attribute.
   * @see #setPeriodUnite(String)
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_PeriodUnite()
   * @model
   * @generated
   */
  String getPeriodUnite();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getPeriodUnite <em>Period Unite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Period Unite</em>' attribute.
   * @see #getPeriodUnite()
   * @generated
   */
  void setPeriodUnite(String value);

  /**
   * Returns the value of the '<em><b>Code To Execute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code To Execute</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code To Execute</em>' attribute.
   * @see #setCodeToExecute(String)
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_CodeToExecute()
   * @model
   * @generated
   */
  String getCodeToExecute();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getCodeToExecute <em>Code To Execute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code To Execute</em>' attribute.
   * @see #getCodeToExecute()
   * @generated
   */
  void setCodeToExecute(String value);

  /**
   * Returns the value of the '<em><b>Trace Record</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceRecord}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Record</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Record</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_TraceRecord()
   * @model containment="true"
   * @generated
   */
  EList<TraceRecord> getTraceRecord();

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
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_UntilCondition()
   * @model containment="true"
   * @generated
   */
  TraceCondition getUntilCondition();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getUntilCondition <em>Until Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Until Condition</em>' containment reference.
   * @see #getUntilCondition()
   * @generated
   */
  void setUntilCondition(TraceCondition value);

  /**
   * Returns the value of the '<em><b>Where Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Where Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Where Condition</em>' containment reference.
   * @see #setWhereCondition(TraceCondition)
   * @see cruise.umple.umple.UmplePackage#getTraceDirective_WhereCondition()
   * @model containment="true"
   * @generated
   */
  TraceCondition getWhereCondition();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceDirective#getWhereCondition <em>Where Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Where Condition</em>' containment reference.
   * @see #getWhereCondition()
   * @generated
   */
  void setWhereCondition(TraceCondition value);

} // TraceDirective
