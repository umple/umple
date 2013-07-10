/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.TraceDuring_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace During </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceDuring_Impl#getTrace_duration_1 <em>Trace duration 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceDuring_Impl extends MinimalEObjectImpl.Container implements TraceDuring_
{
  /**
   * The default value of the '{@link #getTrace_duration_1() <em>Trace duration 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_duration_1()
   * @generated
   * @ordered
   */
  protected static final String TRACE_DURATION_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTrace_duration_1() <em>Trace duration 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_duration_1()
   * @generated
   * @ordered
   */
  protected String trace_duration_1 = TRACE_DURATION_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceDuring_Impl()
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
    return UmplePackage.eINSTANCE.getTraceDuring_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTrace_duration_1()
  {
    return trace_duration_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrace_duration_1(String newTrace_duration_1)
  {
    String oldTrace_duration_1 = trace_duration_1;
    trace_duration_1 = newTrace_duration_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DURING___TRACE_DURATION_1, oldTrace_duration_1, trace_duration_1));
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
      case UmplePackage.TRACE_DURING___TRACE_DURATION_1:
        return getTrace_duration_1();
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
      case UmplePackage.TRACE_DURING___TRACE_DURATION_1:
        setTrace_duration_1((String)newValue);
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
      case UmplePackage.TRACE_DURING___TRACE_DURATION_1:
        setTrace_duration_1(TRACE_DURATION_1_EDEFAULT);
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
      case UmplePackage.TRACE_DURING___TRACE_DURATION_1:
        return TRACE_DURATION_1_EDEFAULT == null ? trace_duration_1 != null : !TRACE_DURATION_1_EDEFAULT.equals(trace_duration_1);
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
    result.append(" (trace_duration_1: ");
    result.append(trace_duration_1);
    result.append(')');
    return result.toString();
  }

} //TraceDuring_Impl
