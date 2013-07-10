/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.TraceLevel_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Level </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceLevel_Impl#getTrace_level_1 <em>Trace level 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceLevel_Impl extends MinimalEObjectImpl.Container implements TraceLevel_
{
  /**
   * The default value of the '{@link #getTrace_level_1() <em>Trace level 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_level_1()
   * @generated
   * @ordered
   */
  protected static final String TRACE_LEVEL_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTrace_level_1() <em>Trace level 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_level_1()
   * @generated
   * @ordered
   */
  protected String trace_level_1 = TRACE_LEVEL_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceLevel_Impl()
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
    return UmplePackage.eINSTANCE.getTraceLevel_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTrace_level_1()
  {
    return trace_level_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrace_level_1(String newTrace_level_1)
  {
    String oldTrace_level_1 = trace_level_1;
    trace_level_1 = newTrace_level_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_LEVEL___TRACE_LEVEL_1, oldTrace_level_1, trace_level_1));
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
      case UmplePackage.TRACE_LEVEL___TRACE_LEVEL_1:
        return getTrace_level_1();
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
      case UmplePackage.TRACE_LEVEL___TRACE_LEVEL_1:
        setTrace_level_1((String)newValue);
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
      case UmplePackage.TRACE_LEVEL___TRACE_LEVEL_1:
        setTrace_level_1(TRACE_LEVEL_1_EDEFAULT);
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
      case UmplePackage.TRACE_LEVEL___TRACE_LEVEL_1:
        return TRACE_LEVEL_1_EDEFAULT == null ? trace_level_1 != null : !TRACE_LEVEL_1_EDEFAULT.equals(trace_level_1);
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
    result.append(" (trace_level_1: ");
    result.append(trace_level_1);
    result.append(')');
    return result.toString();
  }

} //TraceLevel_Impl
