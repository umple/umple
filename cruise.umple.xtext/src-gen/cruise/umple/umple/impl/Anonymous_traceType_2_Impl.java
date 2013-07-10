/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_traceType_2_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous trace Type 2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceType_2_Impl#getTracerArgument_1 <em>Tracer Argument 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_traceType_2_Impl extends MinimalEObjectImpl.Container implements Anonymous_traceType_2_
{
  /**
   * The default value of the '{@link #getTracerArgument_1() <em>Tracer Argument 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTracerArgument_1()
   * @generated
   * @ordered
   */
  protected static final String TRACER_ARGUMENT_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTracerArgument_1() <em>Tracer Argument 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTracerArgument_1()
   * @generated
   * @ordered
   */
  protected String tracerArgument_1 = TRACER_ARGUMENT_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_traceType_2_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_traceType_2_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTracerArgument_1()
  {
    return tracerArgument_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTracerArgument_1(String newTracerArgument_1)
  {
    String oldTracerArgument_1 = tracerArgument_1;
    tracerArgument_1 = newTracerArgument_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_TRACE_TYPE_2__TRACER_ARGUMENT_1, oldTracerArgument_1, tracerArgument_1));
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
      case UmplePackage.ANONYMOUS_TRACE_TYPE_2__TRACER_ARGUMENT_1:
        return getTracerArgument_1();
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
      case UmplePackage.ANONYMOUS_TRACE_TYPE_2__TRACER_ARGUMENT_1:
        setTracerArgument_1((String)newValue);
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
      case UmplePackage.ANONYMOUS_TRACE_TYPE_2__TRACER_ARGUMENT_1:
        setTracerArgument_1(TRACER_ARGUMENT_1_EDEFAULT);
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
      case UmplePackage.ANONYMOUS_TRACE_TYPE_2__TRACER_ARGUMENT_1:
        return TRACER_ARGUMENT_1_EDEFAULT == null ? tracerArgument_1 != null : !TRACER_ARGUMENT_1_EDEFAULT.equals(tracerArgument_1);
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
    result.append(" (tracerArgument_1: ");
    result.append(tracerArgument_1);
    result.append(')');
    return result.toString();
  }

} //Anonymous_traceType_2_Impl
