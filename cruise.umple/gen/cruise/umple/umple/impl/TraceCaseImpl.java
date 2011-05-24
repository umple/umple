/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.TraceCase;
import cruise.umple.umple.TraceCondition;
import cruise.umple.umple.TraceDirective;
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
 * An implementation of the model object '<em><b>Trace Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getTraceCaseName <em>Trace Case Name</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getTraceDirective <em>Trace Directive</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getActivateCaseName <em>Activate Case Name</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#isActivateOnThis <em>Activate On This</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#isActivateOnThisThread <em>Activate On This Thread</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getRepeats <em>Repeats</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getUnite <em>Unite</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getUntilCondition <em>Until Condition</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getDeactivateCaseName <em>Deactivate Case Name</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getDeactivateTime <em>Deactivate Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceCaseImpl extends MinimalEObjectImpl.Container implements TraceCase
{
  /**
   * The default value of the '{@link #getTraceCaseName() <em>Trace Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceCaseName()
   * @generated
   * @ordered
   */
  protected static final String TRACE_CASE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTraceCaseName() <em>Trace Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceCaseName()
   * @generated
   * @ordered
   */
  protected String traceCaseName = TRACE_CASE_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getTraceDirective() <em>Trace Directive</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceDirective()
   * @generated
   * @ordered
   */
  protected EList<TraceDirective> traceDirective;

  /**
   * The default value of the '{@link #getActivateCaseName() <em>Activate Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivateCaseName()
   * @generated
   * @ordered
   */
  protected static final String ACTIVATE_CASE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getActivateCaseName() <em>Activate Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivateCaseName()
   * @generated
   * @ordered
   */
  protected String activateCaseName = ACTIVATE_CASE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #isActivateOnThis() <em>Activate On This</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActivateOnThis()
   * @generated
   * @ordered
   */
  protected static final boolean ACTIVATE_ON_THIS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isActivateOnThis() <em>Activate On This</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActivateOnThis()
   * @generated
   * @ordered
   */
  protected boolean activateOnThis = ACTIVATE_ON_THIS_EDEFAULT;

  /**
   * The default value of the '{@link #isActivateOnThisThread() <em>Activate On This Thread</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActivateOnThisThread()
   * @generated
   * @ordered
   */
  protected static final boolean ACTIVATE_ON_THIS_THREAD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isActivateOnThisThread() <em>Activate On This Thread</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActivateOnThisThread()
   * @generated
   * @ordered
   */
  protected boolean activateOnThisThread = ACTIVATE_ON_THIS_THREAD_EDEFAULT;

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
   * The default value of the '{@link #getUnite() <em>Unite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnite()
   * @generated
   * @ordered
   */
  protected static final String UNITE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUnite() <em>Unite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnite()
   * @generated
   * @ordered
   */
  protected String unite = UNITE_EDEFAULT;

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
   * The cached value of the '{@link #getUntilCondition() <em>Until Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUntilCondition()
   * @generated
   * @ordered
   */
  protected TraceCondition untilCondition;

  /**
   * The default value of the '{@link #getDeactivateCaseName() <em>Deactivate Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeactivateCaseName()
   * @generated
   * @ordered
   */
  protected static final String DEACTIVATE_CASE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDeactivateCaseName() <em>Deactivate Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeactivateCaseName()
   * @generated
   * @ordered
   */
  protected String deactivateCaseName = DEACTIVATE_CASE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getDeactivateTime() <em>Deactivate Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeactivateTime()
   * @generated
   * @ordered
   */
  protected static final int DEACTIVATE_TIME_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDeactivateTime() <em>Deactivate Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeactivateTime()
   * @generated
   * @ordered
   */
  protected int deactivateTime = DEACTIVATE_TIME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceCaseImpl()
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
    return UmplePackage.Literals.TRACE_CASE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTraceCaseName()
  {
    return traceCaseName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTraceCaseName(String newTraceCaseName)
  {
    String oldTraceCaseName = traceCaseName;
    traceCaseName = newTraceCaseName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__TRACE_CASE_NAME, oldTraceCaseName, traceCaseName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceDirective> getTraceDirective()
  {
    if (traceDirective == null)
    {
      traceDirective = new EObjectContainmentEList<TraceDirective>(TraceDirective.class, this, UmplePackage.TRACE_CASE__TRACE_DIRECTIVE);
    }
    return traceDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getActivateCaseName()
  {
    return activateCaseName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivateCaseName(String newActivateCaseName)
  {
    String oldActivateCaseName = activateCaseName;
    activateCaseName = newActivateCaseName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__ACTIVATE_CASE_NAME, oldActivateCaseName, activateCaseName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isActivateOnThis()
  {
    return activateOnThis;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivateOnThis(boolean newActivateOnThis)
  {
    boolean oldActivateOnThis = activateOnThis;
    activateOnThis = newActivateOnThis;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__ACTIVATE_ON_THIS, oldActivateOnThis, activateOnThis));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isActivateOnThisThread()
  {
    return activateOnThisThread;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivateOnThisThread(boolean newActivateOnThisThread)
  {
    boolean oldActivateOnThisThread = activateOnThisThread;
    activateOnThisThread = newActivateOnThisThread;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__ACTIVATE_ON_THIS_THREAD, oldActivateOnThisThread, activateOnThisThread));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__REPEATS, oldRepeats, repeats));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__PERIOD, oldPeriod, period));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUnite()
  {
    return unite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnite(String newUnite)
  {
    String oldUnite = unite;
    unite = newUnite;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__UNITE, oldUnite, unite));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__DURATION, oldDuration, duration));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__UNTIL_CONDITION, oldUntilCondition, newUntilCondition);
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
        msgs = ((InternalEObject)untilCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRACE_CASE__UNTIL_CONDITION, null, msgs);
      if (newUntilCondition != null)
        msgs = ((InternalEObject)newUntilCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRACE_CASE__UNTIL_CONDITION, null, msgs);
      msgs = basicSetUntilCondition(newUntilCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__UNTIL_CONDITION, newUntilCondition, newUntilCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDeactivateCaseName()
  {
    return deactivateCaseName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeactivateCaseName(String newDeactivateCaseName)
  {
    String oldDeactivateCaseName = deactivateCaseName;
    deactivateCaseName = newDeactivateCaseName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__DEACTIVATE_CASE_NAME, oldDeactivateCaseName, deactivateCaseName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDeactivateTime()
  {
    return deactivateTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeactivateTime(int newDeactivateTime)
  {
    int oldDeactivateTime = deactivateTime;
    deactivateTime = newDeactivateTime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__DEACTIVATE_TIME, oldDeactivateTime, deactivateTime));
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
      case UmplePackage.TRACE_CASE__TRACE_DIRECTIVE:
        return ((InternalEList<?>)getTraceDirective()).basicRemove(otherEnd, msgs);
      case UmplePackage.TRACE_CASE__UNTIL_CONDITION:
        return basicSetUntilCondition(null, msgs);
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
      case UmplePackage.TRACE_CASE__TRACE_CASE_NAME:
        return getTraceCaseName();
      case UmplePackage.TRACE_CASE__TRACE_DIRECTIVE:
        return getTraceDirective();
      case UmplePackage.TRACE_CASE__ACTIVATE_CASE_NAME:
        return getActivateCaseName();
      case UmplePackage.TRACE_CASE__ACTIVATE_ON_THIS:
        return isActivateOnThis();
      case UmplePackage.TRACE_CASE__ACTIVATE_ON_THIS_THREAD:
        return isActivateOnThisThread();
      case UmplePackage.TRACE_CASE__REPEATS:
        return getRepeats();
      case UmplePackage.TRACE_CASE__PERIOD:
        return getPeriod();
      case UmplePackage.TRACE_CASE__UNITE:
        return getUnite();
      case UmplePackage.TRACE_CASE__DURATION:
        return getDuration();
      case UmplePackage.TRACE_CASE__UNTIL_CONDITION:
        return getUntilCondition();
      case UmplePackage.TRACE_CASE__DEACTIVATE_CASE_NAME:
        return getDeactivateCaseName();
      case UmplePackage.TRACE_CASE__DEACTIVATE_TIME:
        return getDeactivateTime();
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
      case UmplePackage.TRACE_CASE__TRACE_CASE_NAME:
        setTraceCaseName((String)newValue);
        return;
      case UmplePackage.TRACE_CASE__TRACE_DIRECTIVE:
        getTraceDirective().clear();
        getTraceDirective().addAll((Collection<? extends TraceDirective>)newValue);
        return;
      case UmplePackage.TRACE_CASE__ACTIVATE_CASE_NAME:
        setActivateCaseName((String)newValue);
        return;
      case UmplePackage.TRACE_CASE__ACTIVATE_ON_THIS:
        setActivateOnThis((Boolean)newValue);
        return;
      case UmplePackage.TRACE_CASE__ACTIVATE_ON_THIS_THREAD:
        setActivateOnThisThread((Boolean)newValue);
        return;
      case UmplePackage.TRACE_CASE__REPEATS:
        setRepeats((Integer)newValue);
        return;
      case UmplePackage.TRACE_CASE__PERIOD:
        setPeriod((Integer)newValue);
        return;
      case UmplePackage.TRACE_CASE__UNITE:
        setUnite((String)newValue);
        return;
      case UmplePackage.TRACE_CASE__DURATION:
        setDuration((Integer)newValue);
        return;
      case UmplePackage.TRACE_CASE__UNTIL_CONDITION:
        setUntilCondition((TraceCondition)newValue);
        return;
      case UmplePackage.TRACE_CASE__DEACTIVATE_CASE_NAME:
        setDeactivateCaseName((String)newValue);
        return;
      case UmplePackage.TRACE_CASE__DEACTIVATE_TIME:
        setDeactivateTime((Integer)newValue);
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
      case UmplePackage.TRACE_CASE__TRACE_CASE_NAME:
        setTraceCaseName(TRACE_CASE_NAME_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE__TRACE_DIRECTIVE:
        getTraceDirective().clear();
        return;
      case UmplePackage.TRACE_CASE__ACTIVATE_CASE_NAME:
        setActivateCaseName(ACTIVATE_CASE_NAME_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE__ACTIVATE_ON_THIS:
        setActivateOnThis(ACTIVATE_ON_THIS_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE__ACTIVATE_ON_THIS_THREAD:
        setActivateOnThisThread(ACTIVATE_ON_THIS_THREAD_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE__REPEATS:
        setRepeats(REPEATS_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE__PERIOD:
        setPeriod(PERIOD_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE__UNITE:
        setUnite(UNITE_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE__DURATION:
        setDuration(DURATION_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE__UNTIL_CONDITION:
        setUntilCondition((TraceCondition)null);
        return;
      case UmplePackage.TRACE_CASE__DEACTIVATE_CASE_NAME:
        setDeactivateCaseName(DEACTIVATE_CASE_NAME_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE__DEACTIVATE_TIME:
        setDeactivateTime(DEACTIVATE_TIME_EDEFAULT);
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
      case UmplePackage.TRACE_CASE__TRACE_CASE_NAME:
        return TRACE_CASE_NAME_EDEFAULT == null ? traceCaseName != null : !TRACE_CASE_NAME_EDEFAULT.equals(traceCaseName);
      case UmplePackage.TRACE_CASE__TRACE_DIRECTIVE:
        return traceDirective != null && !traceDirective.isEmpty();
      case UmplePackage.TRACE_CASE__ACTIVATE_CASE_NAME:
        return ACTIVATE_CASE_NAME_EDEFAULT == null ? activateCaseName != null : !ACTIVATE_CASE_NAME_EDEFAULT.equals(activateCaseName);
      case UmplePackage.TRACE_CASE__ACTIVATE_ON_THIS:
        return activateOnThis != ACTIVATE_ON_THIS_EDEFAULT;
      case UmplePackage.TRACE_CASE__ACTIVATE_ON_THIS_THREAD:
        return activateOnThisThread != ACTIVATE_ON_THIS_THREAD_EDEFAULT;
      case UmplePackage.TRACE_CASE__REPEATS:
        return repeats != REPEATS_EDEFAULT;
      case UmplePackage.TRACE_CASE__PERIOD:
        return period != PERIOD_EDEFAULT;
      case UmplePackage.TRACE_CASE__UNITE:
        return UNITE_EDEFAULT == null ? unite != null : !UNITE_EDEFAULT.equals(unite);
      case UmplePackage.TRACE_CASE__DURATION:
        return duration != DURATION_EDEFAULT;
      case UmplePackage.TRACE_CASE__UNTIL_CONDITION:
        return untilCondition != null;
      case UmplePackage.TRACE_CASE__DEACTIVATE_CASE_NAME:
        return DEACTIVATE_CASE_NAME_EDEFAULT == null ? deactivateCaseName != null : !DEACTIVATE_CASE_NAME_EDEFAULT.equals(deactivateCaseName);
      case UmplePackage.TRACE_CASE__DEACTIVATE_TIME:
        return deactivateTime != DEACTIVATE_TIME_EDEFAULT;
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
    result.append(" (traceCaseName: ");
    result.append(traceCaseName);
    result.append(", activateCaseName: ");
    result.append(activateCaseName);
    result.append(", activateOnThis: ");
    result.append(activateOnThis);
    result.append(", activateOnThisThread: ");
    result.append(activateOnThisThread);
    result.append(", repeats: ");
    result.append(repeats);
    result.append(", period: ");
    result.append(period);
    result.append(", unite: ");
    result.append(unite);
    result.append(", duration: ");
    result.append(duration);
    result.append(", deactivateCaseName: ");
    result.append(deactivateCaseName);
    result.append(", deactivateTime: ");
    result.append(deactivateTime);
    result.append(')');
    return result.toString();
  }

} //TraceCaseImpl
