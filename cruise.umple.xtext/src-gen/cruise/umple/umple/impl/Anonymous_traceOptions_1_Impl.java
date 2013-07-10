/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_traceOptions_1_;
import cruise.umple.umple.TraceOption_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous trace Options 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceOptions_1_Impl#getTraceOption_1 <em>Trace Option 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_traceOptions_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_traceOptions_1_
{
  /**
   * The cached value of the '{@link #getTraceOption_1() <em>Trace Option 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceOption_1()
   * @generated
   * @ordered
   */
  protected EList<TraceOption_> traceOption_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_traceOptions_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_traceOptions_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceOption_> getTraceOption_1()
  {
    if (traceOption_1 == null)
    {
      traceOption_1 = new EObjectContainmentEList<TraceOption_>(TraceOption_.class, this, UmplePackage.ANONYMOUS_TRACE_OPTIONS_1__TRACE_OPTION_1);
    }
    return traceOption_1;
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
      case UmplePackage.ANONYMOUS_TRACE_OPTIONS_1__TRACE_OPTION_1:
        return ((InternalEList<?>)getTraceOption_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_TRACE_OPTIONS_1__TRACE_OPTION_1:
        return getTraceOption_1();
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
      case UmplePackage.ANONYMOUS_TRACE_OPTIONS_1__TRACE_OPTION_1:
        getTraceOption_1().clear();
        getTraceOption_1().addAll((Collection<? extends TraceOption_>)newValue);
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
      case UmplePackage.ANONYMOUS_TRACE_OPTIONS_1__TRACE_OPTION_1:
        getTraceOption_1().clear();
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
      case UmplePackage.ANONYMOUS_TRACE_OPTIONS_1__TRACE_OPTION_1:
        return traceOption_1 != null && !traceOption_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_traceOptions_1_Impl
