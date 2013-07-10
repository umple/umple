/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_traceType_1_;
import cruise.umple.umple.Anonymous_traceType_2_;
import cruise.umple.umple.TraceType_;
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
 * An implementation of the model object '<em><b>Trace Type </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceType_Impl#getTracerType_1 <em>Tracer Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceType_Impl#getAnonymous_traceType_1_1 <em>Anonymous trace Type 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceType_Impl#getAnonymous_traceType_2_1 <em>Anonymous trace Type 21</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceType_Impl extends MinimalEObjectImpl.Container implements TraceType_
{
  /**
   * The default value of the '{@link #getTracerType_1() <em>Tracer Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTracerType_1()
   * @generated
   * @ordered
   */
  protected static final String TRACER_TYPE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTracerType_1() <em>Tracer Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTracerType_1()
   * @generated
   * @ordered
   */
  protected String tracerType_1 = TRACER_TYPE_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_traceType_1_1() <em>Anonymous trace Type 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_traceType_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_traceType_1_> anonymous_traceType_1_1;

  /**
   * The cached value of the '{@link #getAnonymous_traceType_2_1() <em>Anonymous trace Type 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_traceType_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_traceType_2_> anonymous_traceType_2_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceType_Impl()
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
    return UmplePackage.eINSTANCE.getTraceType_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTracerType_1()
  {
    return tracerType_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTracerType_1(String newTracerType_1)
  {
    String oldTracerType_1 = tracerType_1;
    tracerType_1 = newTracerType_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_TYPE___TRACER_TYPE_1, oldTracerType_1, tracerType_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_traceType_1_> getAnonymous_traceType_1_1()
  {
    if (anonymous_traceType_1_1 == null)
    {
      anonymous_traceType_1_1 = new EObjectContainmentEList<Anonymous_traceType_1_>(Anonymous_traceType_1_.class, this, UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_11);
    }
    return anonymous_traceType_1_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_traceType_2_> getAnonymous_traceType_2_1()
  {
    if (anonymous_traceType_2_1 == null)
    {
      anonymous_traceType_2_1 = new EObjectContainmentEList<Anonymous_traceType_2_>(Anonymous_traceType_2_.class, this, UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_21);
    }
    return anonymous_traceType_2_1;
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
      case UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_11:
        return ((InternalEList<?>)getAnonymous_traceType_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_21:
        return ((InternalEList<?>)getAnonymous_traceType_2_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE_TYPE___TRACER_TYPE_1:
        return getTracerType_1();
      case UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_11:
        return getAnonymous_traceType_1_1();
      case UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_21:
        return getAnonymous_traceType_2_1();
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
      case UmplePackage.TRACE_TYPE___TRACER_TYPE_1:
        setTracerType_1((String)newValue);
        return;
      case UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_11:
        getAnonymous_traceType_1_1().clear();
        getAnonymous_traceType_1_1().addAll((Collection<? extends Anonymous_traceType_1_>)newValue);
        return;
      case UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_21:
        getAnonymous_traceType_2_1().clear();
        getAnonymous_traceType_2_1().addAll((Collection<? extends Anonymous_traceType_2_>)newValue);
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
      case UmplePackage.TRACE_TYPE___TRACER_TYPE_1:
        setTracerType_1(TRACER_TYPE_1_EDEFAULT);
        return;
      case UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_11:
        getAnonymous_traceType_1_1().clear();
        return;
      case UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_21:
        getAnonymous_traceType_2_1().clear();
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
      case UmplePackage.TRACE_TYPE___TRACER_TYPE_1:
        return TRACER_TYPE_1_EDEFAULT == null ? tracerType_1 != null : !TRACER_TYPE_1_EDEFAULT.equals(tracerType_1);
      case UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_11:
        return anonymous_traceType_1_1 != null && !anonymous_traceType_1_1.isEmpty();
      case UmplePackage.TRACE_TYPE___ANONYMOUS_TRACE_TYPE_21:
        return anonymous_traceType_2_1 != null && !anonymous_traceType_2_1.isEmpty();
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
    result.append(" (tracerType_1: ");
    result.append(tracerType_1);
    result.append(')');
    return result.toString();
  }

} //TraceType_Impl
