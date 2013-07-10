/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.TracePeriod_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Period </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TracePeriod_Impl#getTrace_period_1 <em>Trace period 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TracePeriod_Impl extends MinimalEObjectImpl.Container implements TracePeriod_
{
  /**
   * The default value of the '{@link #getTrace_period_1() <em>Trace period 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_period_1()
   * @generated
   * @ordered
   */
  protected static final String TRACE_PERIOD_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTrace_period_1() <em>Trace period 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_period_1()
   * @generated
   * @ordered
   */
  protected String trace_period_1 = TRACE_PERIOD_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TracePeriod_Impl()
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
    return UmplePackage.eINSTANCE.getTracePeriod_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTrace_period_1()
  {
    return trace_period_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrace_period_1(String newTrace_period_1)
  {
    String oldTrace_period_1 = trace_period_1;
    trace_period_1 = newTrace_period_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_PERIOD___TRACE_PERIOD_1, oldTrace_period_1, trace_period_1));
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
      case UmplePackage.TRACE_PERIOD___TRACE_PERIOD_1:
        return getTrace_period_1();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UmplePackage.TRACE_PERIOD___TRACE_PERIOD_1:
        setTrace_period_1((String)newValue);
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
      case UmplePackage.TRACE_PERIOD___TRACE_PERIOD_1:
        setTrace_period_1(TRACE_PERIOD_1_EDEFAULT);
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
      case UmplePackage.TRACE_PERIOD___TRACE_PERIOD_1:
        return TRACE_PERIOD_1_EDEFAULT == null ? trace_period_1 != null : !TRACE_PERIOD_1_EDEFAULT.equals(trace_period_1);
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
    result.append(" (trace_period_1: ");
    result.append(trace_period_1);
    result.append(')');
    return result.toString();
  }

} //TracePeriod_Impl
