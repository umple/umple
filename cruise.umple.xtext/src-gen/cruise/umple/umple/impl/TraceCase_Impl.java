/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.TraceCaseActivation_;
import cruise.umple.umple.TraceCaseDeactivation_;
import cruise.umple.umple.TraceCaseDef_;
import cruise.umple.umple.TraceCase_;
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
 * An implementation of the model object '<em><b>Trace Case </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceCase_Impl#getTraceCaseDef_1 <em>Trace Case Def 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCase_Impl#getTraceCaseActivation_1 <em>Trace Case Activation 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCase_Impl#getTraceCaseDeactivation_1 <em>Trace Case Deactivation 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceCase_Impl extends MinimalEObjectImpl.Container implements TraceCase_
{
  /**
   * The cached value of the '{@link #getTraceCaseDef_1() <em>Trace Case Def 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceCaseDef_1()
   * @generated
   * @ordered
   */
  protected EList<TraceCaseDef_> traceCaseDef_1;

  /**
   * The cached value of the '{@link #getTraceCaseActivation_1() <em>Trace Case Activation 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceCaseActivation_1()
   * @generated
   * @ordered
   */
  protected EList<TraceCaseActivation_> traceCaseActivation_1;

  /**
   * The cached value of the '{@link #getTraceCaseDeactivation_1() <em>Trace Case Deactivation 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceCaseDeactivation_1()
   * @generated
   * @ordered
   */
  protected EList<TraceCaseDeactivation_> traceCaseDeactivation_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceCase_Impl()
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
    return UmplePackage.eINSTANCE.getTraceCase_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceCaseDef_> getTraceCaseDef_1()
  {
    if (traceCaseDef_1 == null)
    {
      traceCaseDef_1 = new EObjectContainmentEList<TraceCaseDef_>(TraceCaseDef_.class, this, UmplePackage.TRACE_CASE___TRACE_CASE_DEF_1);
    }
    return traceCaseDef_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceCaseActivation_> getTraceCaseActivation_1()
  {
    if (traceCaseActivation_1 == null)
    {
      traceCaseActivation_1 = new EObjectContainmentEList<TraceCaseActivation_>(TraceCaseActivation_.class, this, UmplePackage.TRACE_CASE___TRACE_CASE_ACTIVATION_1);
    }
    return traceCaseActivation_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceCaseDeactivation_> getTraceCaseDeactivation_1()
  {
    if (traceCaseDeactivation_1 == null)
    {
      traceCaseDeactivation_1 = new EObjectContainmentEList<TraceCaseDeactivation_>(TraceCaseDeactivation_.class, this, UmplePackage.TRACE_CASE___TRACE_CASE_DEACTIVATION_1);
    }
    return traceCaseDeactivation_1;
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
      case UmplePackage.TRACE_CASE___TRACE_CASE_DEF_1:
        return ((InternalEList<?>)getTraceCaseDef_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.TRACE_CASE___TRACE_CASE_ACTIVATION_1:
        return ((InternalEList<?>)getTraceCaseActivation_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.TRACE_CASE___TRACE_CASE_DEACTIVATION_1:
        return ((InternalEList<?>)getTraceCaseDeactivation_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE_CASE___TRACE_CASE_DEF_1:
        return getTraceCaseDef_1();
      case UmplePackage.TRACE_CASE___TRACE_CASE_ACTIVATION_1:
        return getTraceCaseActivation_1();
      case UmplePackage.TRACE_CASE___TRACE_CASE_DEACTIVATION_1:
        return getTraceCaseDeactivation_1();
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
      case UmplePackage.TRACE_CASE___TRACE_CASE_DEF_1:
        getTraceCaseDef_1().clear();
        getTraceCaseDef_1().addAll((Collection<? extends TraceCaseDef_>)newValue);
        return;
      case UmplePackage.TRACE_CASE___TRACE_CASE_ACTIVATION_1:
        getTraceCaseActivation_1().clear();
        getTraceCaseActivation_1().addAll((Collection<? extends TraceCaseActivation_>)newValue);
        return;
      case UmplePackage.TRACE_CASE___TRACE_CASE_DEACTIVATION_1:
        getTraceCaseDeactivation_1().clear();
        getTraceCaseDeactivation_1().addAll((Collection<? extends TraceCaseDeactivation_>)newValue);
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
      case UmplePackage.TRACE_CASE___TRACE_CASE_DEF_1:
        getTraceCaseDef_1().clear();
        return;
      case UmplePackage.TRACE_CASE___TRACE_CASE_ACTIVATION_1:
        getTraceCaseActivation_1().clear();
        return;
      case UmplePackage.TRACE_CASE___TRACE_CASE_DEACTIVATION_1:
        getTraceCaseDeactivation_1().clear();
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
      case UmplePackage.TRACE_CASE___TRACE_CASE_DEF_1:
        return traceCaseDef_1 != null && !traceCaseDef_1.isEmpty();
      case UmplePackage.TRACE_CASE___TRACE_CASE_ACTIVATION_1:
        return traceCaseActivation_1 != null && !traceCaseActivation_1.isEmpty();
      case UmplePackage.TRACE_CASE___TRACE_CASE_DEACTIVATION_1:
        return traceCaseDeactivation_1 != null && !traceCaseDeactivation_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TraceCase_Impl
