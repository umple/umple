/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_traceEntity_1_;
import cruise.umple.umple.TraceEntity_;
import cruise.umple.umple.TraceOptions_;
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
 * An implementation of the model object '<em><b>Trace Entity </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceEntity_Impl#getTraceOptions_1 <em>Trace Options 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceEntity_Impl#getTrace_entity_1 <em>Trace entity 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceEntity_Impl#getAnonymous_traceEntity_1_1 <em>Anonymous trace Entity 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceEntity_Impl extends MinimalEObjectImpl.Container implements TraceEntity_
{
  /**
   * The cached value of the '{@link #getTraceOptions_1() <em>Trace Options 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceOptions_1()
   * @generated
   * @ordered
   */
  protected EList<TraceOptions_> traceOptions_1;

  /**
   * The default value of the '{@link #getTrace_entity_1() <em>Trace entity 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_entity_1()
   * @generated
   * @ordered
   */
  protected static final String TRACE_ENTITY_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTrace_entity_1() <em>Trace entity 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_entity_1()
   * @generated
   * @ordered
   */
  protected String trace_entity_1 = TRACE_ENTITY_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_traceEntity_1_1() <em>Anonymous trace Entity 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_traceEntity_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_traceEntity_1_> anonymous_traceEntity_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceEntity_Impl()
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
    return UmplePackage.eINSTANCE.getTraceEntity_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceOptions_> getTraceOptions_1()
  {
    if (traceOptions_1 == null)
    {
      traceOptions_1 = new EObjectContainmentEList<TraceOptions_>(TraceOptions_.class, this, UmplePackage.TRACE_ENTITY___TRACE_OPTIONS_1);
    }
    return traceOptions_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTrace_entity_1()
  {
    return trace_entity_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrace_entity_1(String newTrace_entity_1)
  {
    String oldTrace_entity_1 = trace_entity_1;
    trace_entity_1 = newTrace_entity_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_ENTITY___TRACE_ENTITY_1, oldTrace_entity_1, trace_entity_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_traceEntity_1_> getAnonymous_traceEntity_1_1()
  {
    if (anonymous_traceEntity_1_1 == null)
    {
      anonymous_traceEntity_1_1 = new EObjectContainmentEList<Anonymous_traceEntity_1_>(Anonymous_traceEntity_1_.class, this, UmplePackage.TRACE_ENTITY___ANONYMOUS_TRACE_ENTITY_11);
    }
    return anonymous_traceEntity_1_1;
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
      case UmplePackage.TRACE_ENTITY___TRACE_OPTIONS_1:
        return ((InternalEList<?>)getTraceOptions_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.TRACE_ENTITY___ANONYMOUS_TRACE_ENTITY_11:
        return ((InternalEList<?>)getAnonymous_traceEntity_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE_ENTITY___TRACE_OPTIONS_1:
        return getTraceOptions_1();
      case UmplePackage.TRACE_ENTITY___TRACE_ENTITY_1:
        return getTrace_entity_1();
      case UmplePackage.TRACE_ENTITY___ANONYMOUS_TRACE_ENTITY_11:
        return getAnonymous_traceEntity_1_1();
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
      case UmplePackage.TRACE_ENTITY___TRACE_OPTIONS_1:
        getTraceOptions_1().clear();
        getTraceOptions_1().addAll((Collection<? extends TraceOptions_>)newValue);
        return;
      case UmplePackage.TRACE_ENTITY___TRACE_ENTITY_1:
        setTrace_entity_1((String)newValue);
        return;
      case UmplePackage.TRACE_ENTITY___ANONYMOUS_TRACE_ENTITY_11:
        getAnonymous_traceEntity_1_1().clear();
        getAnonymous_traceEntity_1_1().addAll((Collection<? extends Anonymous_traceEntity_1_>)newValue);
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
      case UmplePackage.TRACE_ENTITY___TRACE_OPTIONS_1:
        getTraceOptions_1().clear();
        return;
      case UmplePackage.TRACE_ENTITY___TRACE_ENTITY_1:
        setTrace_entity_1(TRACE_ENTITY_1_EDEFAULT);
        return;
      case UmplePackage.TRACE_ENTITY___ANONYMOUS_TRACE_ENTITY_11:
        getAnonymous_traceEntity_1_1().clear();
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
      case UmplePackage.TRACE_ENTITY___TRACE_OPTIONS_1:
        return traceOptions_1 != null && !traceOptions_1.isEmpty();
      case UmplePackage.TRACE_ENTITY___TRACE_ENTITY_1:
        return TRACE_ENTITY_1_EDEFAULT == null ? trace_entity_1 != null : !TRACE_ENTITY_1_EDEFAULT.equals(trace_entity_1);
      case UmplePackage.TRACE_ENTITY___ANONYMOUS_TRACE_ENTITY_11:
        return anonymous_traceEntity_1_1 != null && !anonymous_traceEntity_1_1.isEmpty();
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
    result.append(" (trace_entity_1: ");
    result.append(trace_entity_1);
    result.append(')');
    return result.toString();
  }

} //TraceEntity_Impl
