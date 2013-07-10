/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.PreOrPostCondition_;
import cruise.umple.umple.TraceEntity_;
import cruise.umple.umple.TraceItem_;
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
 * An implementation of the model object '<em><b>Trace Item </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceItem_Impl#getTraceEntity_1 <em>Trace Entity 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceItem_Impl#getPreOrPostCondition_1 <em>Pre Or Post Condition 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceItem_Impl extends MinimalEObjectImpl.Container implements TraceItem_
{
  /**
   * The cached value of the '{@link #getTraceEntity_1() <em>Trace Entity 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceEntity_1()
   * @generated
   * @ordered
   */
  protected EList<TraceEntity_> traceEntity_1;

  /**
   * The cached value of the '{@link #getPreOrPostCondition_1() <em>Pre Or Post Condition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreOrPostCondition_1()
   * @generated
   * @ordered
   */
  protected EList<PreOrPostCondition_> preOrPostCondition_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceItem_Impl()
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
    return UmplePackage.eINSTANCE.getTraceItem_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceEntity_> getTraceEntity_1()
  {
    if (traceEntity_1 == null)
    {
      traceEntity_1 = new EObjectContainmentEList<TraceEntity_>(TraceEntity_.class, this, UmplePackage.TRACE_ITEM___TRACE_ENTITY_1);
    }
    return traceEntity_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PreOrPostCondition_> getPreOrPostCondition_1()
  {
    if (preOrPostCondition_1 == null)
    {
      preOrPostCondition_1 = new EObjectContainmentEList<PreOrPostCondition_>(PreOrPostCondition_.class, this, UmplePackage.TRACE_ITEM___PRE_OR_POST_CONDITION_1);
    }
    return preOrPostCondition_1;
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
      case UmplePackage.TRACE_ITEM___TRACE_ENTITY_1:
        return ((InternalEList<?>)getTraceEntity_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.TRACE_ITEM___PRE_OR_POST_CONDITION_1:
        return ((InternalEList<?>)getPreOrPostCondition_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE_ITEM___TRACE_ENTITY_1:
        return getTraceEntity_1();
      case UmplePackage.TRACE_ITEM___PRE_OR_POST_CONDITION_1:
        return getPreOrPostCondition_1();
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
      case UmplePackage.TRACE_ITEM___TRACE_ENTITY_1:
        getTraceEntity_1().clear();
        getTraceEntity_1().addAll((Collection<? extends TraceEntity_>)newValue);
        return;
      case UmplePackage.TRACE_ITEM___PRE_OR_POST_CONDITION_1:
        getPreOrPostCondition_1().clear();
        getPreOrPostCondition_1().addAll((Collection<? extends PreOrPostCondition_>)newValue);
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
      case UmplePackage.TRACE_ITEM___TRACE_ENTITY_1:
        getTraceEntity_1().clear();
        return;
      case UmplePackage.TRACE_ITEM___PRE_OR_POST_CONDITION_1:
        getPreOrPostCondition_1().clear();
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
      case UmplePackage.TRACE_ITEM___TRACE_ENTITY_1:
        return traceEntity_1 != null && !traceEntity_1.isEmpty();
      case UmplePackage.TRACE_ITEM___PRE_OR_POST_CONDITION_1:
        return preOrPostCondition_1 != null && !preOrPostCondition_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TraceItem_Impl
