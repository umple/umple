/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.RecordEntity_;
import cruise.umple.umple.TraceRecord_;
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
 * An implementation of the model object '<em><b>Trace Record </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceRecord_Impl#getRecordEntity_1 <em>Record Entity 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceRecord_Impl extends MinimalEObjectImpl.Container implements TraceRecord_
{
  /**
   * The cached value of the '{@link #getRecordEntity_1() <em>Record Entity 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordEntity_1()
   * @generated
   * @ordered
   */
  protected EList<RecordEntity_> recordEntity_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceRecord_Impl()
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
    return UmplePackage.eINSTANCE.getTraceRecord_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RecordEntity_> getRecordEntity_1()
  {
    if (recordEntity_1 == null)
    {
      recordEntity_1 = new EObjectContainmentEList<RecordEntity_>(RecordEntity_.class, this, UmplePackage.TRACE_RECORD___RECORD_ENTITY_1);
    }
    return recordEntity_1;
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
      case UmplePackage.TRACE_RECORD___RECORD_ENTITY_1:
        return ((InternalEList<?>)getRecordEntity_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE_RECORD___RECORD_ENTITY_1:
        return getRecordEntity_1();
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
      case UmplePackage.TRACE_RECORD___RECORD_ENTITY_1:
        getRecordEntity_1().clear();
        getRecordEntity_1().addAll((Collection<? extends RecordEntity_>)newValue);
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
      case UmplePackage.TRACE_RECORD___RECORD_ENTITY_1:
        getRecordEntity_1().clear();
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
      case UmplePackage.TRACE_RECORD___RECORD_ENTITY_1:
        return recordEntity_1 != null && !recordEntity_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TraceRecord_Impl
