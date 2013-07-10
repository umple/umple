/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.TraceCase_;
import cruise.umple.umple.TraceDirective_;
import cruise.umple.umple.Trace_;
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
 * An implementation of the model object '<em><b>Trace </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Trace_Impl#getTraceDirective_1 <em>Trace Directive 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Trace_Impl#getTraceCase_1 <em>Trace Case 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Trace_Impl extends MinimalEObjectImpl.Container implements Trace_
{
  /**
   * The cached value of the '{@link #getTraceDirective_1() <em>Trace Directive 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceDirective_1()
   * @generated
   * @ordered
   */
  protected EList<TraceDirective_> traceDirective_1;

  /**
   * The cached value of the '{@link #getTraceCase_1() <em>Trace Case 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceCase_1()
   * @generated
   * @ordered
   */
  protected EList<TraceCase_> traceCase_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Trace_Impl()
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
    return UmplePackage.eINSTANCE.getTrace_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceDirective_> getTraceDirective_1()
  {
    if (traceDirective_1 == null)
    {
      traceDirective_1 = new EObjectContainmentEList<TraceDirective_>(TraceDirective_.class, this, UmplePackage.TRACE___TRACE_DIRECTIVE_1);
    }
    return traceDirective_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceCase_> getTraceCase_1()
  {
    if (traceCase_1 == null)
    {
      traceCase_1 = new EObjectContainmentEList<TraceCase_>(TraceCase_.class, this, UmplePackage.TRACE___TRACE_CASE_1);
    }
    return traceCase_1;
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
      case UmplePackage.TRACE___TRACE_DIRECTIVE_1:
        return ((InternalEList<?>)getTraceDirective_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.TRACE___TRACE_CASE_1:
        return ((InternalEList<?>)getTraceCase_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE___TRACE_DIRECTIVE_1:
        return getTraceDirective_1();
      case UmplePackage.TRACE___TRACE_CASE_1:
        return getTraceCase_1();
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
      case UmplePackage.TRACE___TRACE_DIRECTIVE_1:
        getTraceDirective_1().clear();
        getTraceDirective_1().addAll((Collection<? extends TraceDirective_>)newValue);
        return;
      case UmplePackage.TRACE___TRACE_CASE_1:
        getTraceCase_1().clear();
        getTraceCase_1().addAll((Collection<? extends TraceCase_>)newValue);
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
      case UmplePackage.TRACE___TRACE_DIRECTIVE_1:
        getTraceDirective_1().clear();
        return;
      case UmplePackage.TRACE___TRACE_CASE_1:
        getTraceCase_1().clear();
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
      case UmplePackage.TRACE___TRACE_DIRECTIVE_1:
        return traceDirective_1 != null && !traceDirective_1.isEmpty();
      case UmplePackage.TRACE___TRACE_CASE_1:
        return traceCase_1 != null && !traceCase_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Trace_Impl
