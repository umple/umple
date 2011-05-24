/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ConditionRHS;
import cruise.umple.umple.ModelElement;
import cruise.umple.umple.TraceCondition;
import cruise.umple.umple.TraceDirective;
import cruise.umple.umple.TraceRecord;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Directive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getTraceStart <em>Trace Start</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getConditionRHS <em>Condition RHS</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getElementPattern <em>Element Pattern</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#isFor <em>For</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getRepeats <em>Repeats</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#isDuring <em>During</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getDurationUnite <em>Duration Unite</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#isHasPeriod <em>Has Period</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getPeriodUnite <em>Period Unite</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getCodeToExecute <em>Code To Execute</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getTraceRecord <em>Trace Record</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getUntilCondition <em>Until Condition</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getWhereCondition <em>Where Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceDirectiveImpl extends MinimalEObjectImpl.Container implements TraceDirective
{
  /**
   * The default value of the '{@link #getTraceStart() <em>Trace Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceStart()
   * @generated
   * @ordered
   */
  protected static final String TRACE_START_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTraceStart() <em>Trace Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceStart()
   * @generated
   * @ordered
   */
  protected String traceStart = TRACE_START_EDEFAULT;

  /**
   * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelElement()
   * @generated
   * @ordered
   */
  protected EList<ModelElement> modelElement;

  /**
   * The cached value of the '{@link #getConditionRHS() <em>Condition RHS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionRHS()
   * @generated
   * @ordered
   */
  protected ConditionRHS conditionRHS;

  /**
   * The default value of the '{@link #getElementPattern() <em>Element Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementPattern()
   * @generated
   * @ordered
   */
  protected static final String ELEMENT_PATTERN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getElementPattern() <em>Element Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementPattern()
   * @generated
   * @ordered
   */
  protected String elementPattern = ELEMENT_PATTERN_EDEFAULT;

  /**
   * The default value of the '{@link #isFor() <em>For</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFor()
   * @generated
   * @ordered
   */
  protected static final boolean FOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFor() <em>For</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFor()
   * @generated
   * @ordered
   */
  protected boolean for_ = FOR_EDEFAULT;

  /**
   * The default value of the '{@link #getRepeats() <em>Repeats</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepeats()
   * @generated
   * @ordered
   */
  protected static final int REPEATS_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRepeats() <em>Repeats</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepeats()
   * @generated
   * @ordered
   */
  protected int repeats = REPEATS_EDEFAULT;

  /**
   * The default value of the '{@link #isDuring() <em>During</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDuring()
   * @generated
   * @ordered
   */
  protected static final boolean DURING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDuring() <em>During</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDuring()
   * @generated
   * @ordered
   */
  protected boolean during = DURING_EDEFAULT;

  /**
   * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  protected static final int DURATION_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  protected int duration = DURATION_EDEFAULT;

  /**
   * The default value of the '{@link #getDurationUnite() <em>Duration Unite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDurationUnite()
   * @generated
   * @ordered
   */
  protected static final String DURATION_UNITE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDurationUnite() <em>Duration Unite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDurationUnite()
   * @generated
   * @ordered
   */
  protected String durationUnite = DURATION_UNITE_EDEFAULT;

  /**
   * The default value of the '{@link #isHasPeriod() <em>Has Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasPeriod()
   * @generated
   * @ordered
   */
  protected static final boolean HAS_PERIOD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHasPeriod() <em>Has Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasPeriod()
   * @generated
   * @ordered
   */
  protected boolean hasPeriod = HAS_PERIOD_EDEFAULT;

  /**
   * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeriod()
   * @generated
   * @ordered
   */
  protected static final int PERIOD_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeriod()
   * @generated
   * @ordered
   */
  protected int period = PERIOD_EDEFAULT;

  /**
   * The default value of the '{@link #getPeriodUnite() <em>Period Unite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeriodUnite()
   * @generated
   * @ordered
   */
  protected static final String PERIOD_UNITE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPeriodUnite() <em>Period Unite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeriodUnite()
   * @generated
   * @ordered
   */
  protected String periodUnite = PERIOD_UNITE_EDEFAULT;

  /**
   * The default value of the '{@link #getCodeToExecute() <em>Code To Execute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodeToExecute()
   * @generated
   * @ordered
   */
  protected static final String CODE_TO_EXECUTE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCodeToExecute() <em>Code To Execute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodeToExecute()
   * @generated
   * @ordered
   */
  protected String codeToExecute = CODE_TO_EXECUTE_EDEFAULT;

  /**
   * The cached value of the '{@link #getTraceRecord() <em>Trace Record</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceRecord()
   * @generated
   * @ordered
   */
  protected EList<TraceRecord> traceRecord;

  /**
   * The cached value of the '{@link #getUntilCondition() <em>Until Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUntilCondition()
   * @generated
   * @ordered
   */
  protected TraceCondition untilCondition;

  /**
   * The cached value of the '{@link #getWhereCondition() <em>Where Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhereCondition()
   * @generated
   * @ordered
   */
  protected TraceCondition whereCondition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceDirectiveImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return UmplePackage.Literals.TRACE_DIRECTIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTraceStart()
  {
    return traceStart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTraceStart(String newTraceStart)
  {
    String oldTraceStart = traceStart;
    traceStart = newTraceStart;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__TRACE_START, oldTraceStart, traceStart));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ModelElement> getModelElement()
  {
    if (modelElement == null)
    {
      modelElement = new EObjectContainmentEList<ModelElement>(ModelElement.class, this, UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT);
    }
    return modelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionRHS getConditionRHS()
  {
    return conditionRHS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditionRHS(ConditionRHS newConditionRHS, NotificationChain msgs)
  {
    ConditionRHS oldConditionRHS = conditionRHS;
    conditionRHS = newConditionRHS;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS, oldConditionRHS, newConditionRHS);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConditionRHS(ConditionRHS newConditionRHS)
  {
    if (newConditionRHS != conditionRHS)
    {
      NotificationChain msgs = null;
      if (conditionRHS != null)
        msgs = ((InternalEObject)conditionRHS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS, null, msgs);
      if (newConditionRHS != null)
        msgs = ((InternalEObject)newConditionRHS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS, null, msgs);
      msgs = basicSetConditionRHS(newConditionRHS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS, newConditionRHS, newConditionRHS));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getElementPattern()
  {
    return elementPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElementPattern(String newElementPattern)
  {
    String oldElementPattern = elementPattern;
    elementPattern = newElementPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__ELEMENT_PATTERN, oldElementPattern, elementPattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFor()
  {
    return for_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFor(boolean newFor)
  {
    boolean oldFor = for_;
    for_ = newFor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__FOR, oldFor, for_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getRepeats()
  {
    return repeats;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRepeats(int newRepeats)
  {
    int oldRepeats = repeats;
    repeats = newRepeats;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__REPEATS, oldRepeats, repeats));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDuring()
  {
    return during;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDuring(boolean newDuring)
  {
    boolean oldDuring = during;
    during = newDuring;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__DURING, oldDuring, during));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDuration()
  {
    return duration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDuration(int newDuration)
  {
    int oldDuration = duration;
    duration = newDuration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__DURATION, oldDuration, duration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDurationUnite()
  {
    return durationUnite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDurationUnite(String newDurationUnite)
  {
    String oldDurationUnite = durationUnite;
    durationUnite = newDurationUnite;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__DURATION_UNITE, oldDurationUnite, durationUnite));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isHasPeriod()
  {
    return hasPeriod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHasPeriod(boolean newHasPeriod)
  {
    boolean oldHasPeriod = hasPeriod;
    hasPeriod = newHasPeriod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__HAS_PERIOD, oldHasPeriod, hasPeriod));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPeriod()
  {
    return period;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPeriod(int newPeriod)
  {
    int oldPeriod = period;
    period = newPeriod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__PERIOD, oldPeriod, period));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPeriodUnite()
  {
    return periodUnite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPeriodUnite(String newPeriodUnite)
  {
    String oldPeriodUnite = periodUnite;
    periodUnite = newPeriodUnite;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__PERIOD_UNITE, oldPeriodUnite, periodUnite));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCodeToExecute()
  {
    return codeToExecute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCodeToExecute(String newCodeToExecute)
  {
    String oldCodeToExecute = codeToExecute;
    codeToExecute = newCodeToExecute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__CODE_TO_EXECUTE, oldCodeToExecute, codeToExecute));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceRecord> getTraceRecord()
  {
    if (traceRecord == null)
    {
      traceRecord = new EObjectContainmentEList<TraceRecord>(TraceRecord.class, this, UmplePackage.TRACE_DIRECTIVE__TRACE_RECORD);
    }
    return traceRecord;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceCondition getUntilCondition()
  {
    return untilCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUntilCondition(TraceCondition newUntilCondition, NotificationChain msgs)
  {
    TraceCondition oldUntilCondition = untilCondition;
    untilCondition = newUntilCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__UNTIL_CONDITION, oldUntilCondition, newUntilCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUntilCondition(TraceCondition newUntilCondition)
  {
    if (newUntilCondition != untilCondition)
    {
      NotificationChain msgs = null;
      if (untilCondition != null)
        msgs = ((InternalEObject)untilCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRACE_DIRECTIVE__UNTIL_CONDITION, null, msgs);
      if (newUntilCondition != null)
        msgs = ((InternalEObject)newUntilCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRACE_DIRECTIVE__UNTIL_CONDITION, null, msgs);
      msgs = basicSetUntilCondition(newUntilCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__UNTIL_CONDITION, newUntilCondition, newUntilCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceCondition getWhereCondition()
  {
    return whereCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWhereCondition(TraceCondition newWhereCondition, NotificationChain msgs)
  {
    TraceCondition oldWhereCondition = whereCondition;
    whereCondition = newWhereCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__WHERE_CONDITION, oldWhereCondition, newWhereCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWhereCondition(TraceCondition newWhereCondition)
  {
    if (newWhereCondition != whereCondition)
    {
      NotificationChain msgs = null;
      if (whereCondition != null)
        msgs = ((InternalEObject)whereCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRACE_DIRECTIVE__WHERE_CONDITION, null, msgs);
      if (newWhereCondition != null)
        msgs = ((InternalEObject)newWhereCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRACE_DIRECTIVE__WHERE_CONDITION, null, msgs);
      msgs = basicSetWhereCondition(newWhereCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__WHERE_CONDITION, newWhereCondition, newWhereCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT:
        return ((InternalEList<?>)getModelElement()).basicRemove(otherEnd, msgs);
      case UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS:
        return basicSetConditionRHS(null, msgs);
      case UmplePackage.TRACE_DIRECTIVE__TRACE_RECORD:
        return ((InternalEList<?>)getTraceRecord()).basicRemove(otherEnd, msgs);
      case UmplePackage.TRACE_DIRECTIVE__UNTIL_CONDITION:
        return basicSetUntilCondition(null, msgs);
      case UmplePackage.TRACE_DIRECTIVE__WHERE_CONDITION:
        return basicSetWhereCondition(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case UmplePackage.TRACE_DIRECTIVE__TRACE_START:
        return getTraceStart();
      case UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT:
        return getModelElement();
      case UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS:
        return getConditionRHS();
      case UmplePackage.TRACE_DIRECTIVE__ELEMENT_PATTERN:
        return getElementPattern();
      case UmplePackage.TRACE_DIRECTIVE__FOR:
        return isFor();
      case UmplePackage.TRACE_DIRECTIVE__REPEATS:
        return getRepeats();
      case UmplePackage.TRACE_DIRECTIVE__DURING:
        return isDuring();
      case UmplePackage.TRACE_DIRECTIVE__DURATION:
        return getDuration();
      case UmplePackage.TRACE_DIRECTIVE__DURATION_UNITE:
        return getDurationUnite();
      case UmplePackage.TRACE_DIRECTIVE__HAS_PERIOD:
        return isHasPeriod();
      case UmplePackage.TRACE_DIRECTIVE__PERIOD:
        return getPeriod();
      case UmplePackage.TRACE_DIRECTIVE__PERIOD_UNITE:
        return getPeriodUnite();
      case UmplePackage.TRACE_DIRECTIVE__CODE_TO_EXECUTE:
        return getCodeToExecute();
      case UmplePackage.TRACE_DIRECTIVE__TRACE_RECORD:
        return getTraceRecord();
      case UmplePackage.TRACE_DIRECTIVE__UNTIL_CONDITION:
        return getUntilCondition();
      case UmplePackage.TRACE_DIRECTIVE__WHERE_CONDITION:
        return getWhereCondition();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UmplePackage.TRACE_DIRECTIVE__TRACE_START:
        setTraceStart((String)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT:
        getModelElement().clear();
        getModelElement().addAll((Collection<? extends ModelElement>)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS:
        setConditionRHS((ConditionRHS)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__ELEMENT_PATTERN:
        setElementPattern((String)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__FOR:
        setFor((Boolean)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__REPEATS:
        setRepeats((Integer)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__DURING:
        setDuring((Boolean)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__DURATION:
        setDuration((Integer)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__DURATION_UNITE:
        setDurationUnite((String)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__HAS_PERIOD:
        setHasPeriod((Boolean)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__PERIOD:
        setPeriod((Integer)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__PERIOD_UNITE:
        setPeriodUnite((String)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__CODE_TO_EXECUTE:
        setCodeToExecute((String)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__TRACE_RECORD:
        getTraceRecord().clear();
        getTraceRecord().addAll((Collection<? extends TraceRecord>)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__UNTIL_CONDITION:
        setUntilCondition((TraceCondition)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__WHERE_CONDITION:
        setWhereCondition((TraceCondition)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case UmplePackage.TRACE_DIRECTIVE__TRACE_START:
        setTraceStart(TRACE_START_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT:
        getModelElement().clear();
        return;
      case UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS:
        setConditionRHS((ConditionRHS)null);
        return;
      case UmplePackage.TRACE_DIRECTIVE__ELEMENT_PATTERN:
        setElementPattern(ELEMENT_PATTERN_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__FOR:
        setFor(FOR_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__REPEATS:
        setRepeats(REPEATS_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__DURING:
        setDuring(DURING_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__DURATION:
        setDuration(DURATION_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__DURATION_UNITE:
        setDurationUnite(DURATION_UNITE_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__HAS_PERIOD:
        setHasPeriod(HAS_PERIOD_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__PERIOD:
        setPeriod(PERIOD_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__PERIOD_UNITE:
        setPeriodUnite(PERIOD_UNITE_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__CODE_TO_EXECUTE:
        setCodeToExecute(CODE_TO_EXECUTE_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__TRACE_RECORD:
        getTraceRecord().clear();
        return;
      case UmplePackage.TRACE_DIRECTIVE__UNTIL_CONDITION:
        setUntilCondition((TraceCondition)null);
        return;
      case UmplePackage.TRACE_DIRECTIVE__WHERE_CONDITION:
        setWhereCondition((TraceCondition)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case UmplePackage.TRACE_DIRECTIVE__TRACE_START:
        return TRACE_START_EDEFAULT == null ? traceStart != null : !TRACE_START_EDEFAULT.equals(traceStart);
      case UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT:
        return modelElement != null && !modelElement.isEmpty();
      case UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS:
        return conditionRHS != null;
      case UmplePackage.TRACE_DIRECTIVE__ELEMENT_PATTERN:
        return ELEMENT_PATTERN_EDEFAULT == null ? elementPattern != null : !ELEMENT_PATTERN_EDEFAULT.equals(elementPattern);
      case UmplePackage.TRACE_DIRECTIVE__FOR:
        return for_ != FOR_EDEFAULT;
      case UmplePackage.TRACE_DIRECTIVE__REPEATS:
        return repeats != REPEATS_EDEFAULT;
      case UmplePackage.TRACE_DIRECTIVE__DURING:
        return during != DURING_EDEFAULT;
      case UmplePackage.TRACE_DIRECTIVE__DURATION:
        return duration != DURATION_EDEFAULT;
      case UmplePackage.TRACE_DIRECTIVE__DURATION_UNITE:
        return DURATION_UNITE_EDEFAULT == null ? durationUnite != null : !DURATION_UNITE_EDEFAULT.equals(durationUnite);
      case UmplePackage.TRACE_DIRECTIVE__HAS_PERIOD:
        return hasPeriod != HAS_PERIOD_EDEFAULT;
      case UmplePackage.TRACE_DIRECTIVE__PERIOD:
        return period != PERIOD_EDEFAULT;
      case UmplePackage.TRACE_DIRECTIVE__PERIOD_UNITE:
        return PERIOD_UNITE_EDEFAULT == null ? periodUnite != null : !PERIOD_UNITE_EDEFAULT.equals(periodUnite);
      case UmplePackage.TRACE_DIRECTIVE__CODE_TO_EXECUTE:
        return CODE_TO_EXECUTE_EDEFAULT == null ? codeToExecute != null : !CODE_TO_EXECUTE_EDEFAULT.equals(codeToExecute);
      case UmplePackage.TRACE_DIRECTIVE__TRACE_RECORD:
        return traceRecord != null && !traceRecord.isEmpty();
      case UmplePackage.TRACE_DIRECTIVE__UNTIL_CONDITION:
        return untilCondition != null;
      case UmplePackage.TRACE_DIRECTIVE__WHERE_CONDITION:
        return whereCondition != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (traceStart: ");
    result.append(traceStart);
    result.append(", elementPattern: ");
    result.append(elementPattern);
    result.append(", for: ");
    result.append(for_);
    result.append(", repeats: ");
    result.append(repeats);
    result.append(", during: ");
    result.append(during);
    result.append(", duration: ");
    result.append(duration);
    result.append(", durationUnite: ");
    result.append(durationUnite);
    result.append(", hasPeriod: ");
    result.append(hasPeriod);
    result.append(", period: ");
    result.append(period);
    result.append(", periodUnite: ");
    result.append(periodUnite);
    result.append(", codeToExecute: ");
    result.append(codeToExecute);
    result.append(')');
    return result.toString();
  }

} //TraceDirectiveImpl
