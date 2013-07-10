/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_traceDirective_1_;
import cruise.umple.umple.TraceDirective_;
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
 * An implementation of the model object '<em><b>Trace Directive </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceDirective_Impl#getTraceItem_1 <em>Trace Item 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirective_Impl#getAnonymous_traceDirective_1_1 <em>Anonymous trace Directive 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceDirective_Impl extends MinimalEObjectImpl.Container implements TraceDirective_
{
  /**
   * The cached value of the '{@link #getTraceItem_1() <em>Trace Item 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceItem_1()
   * @generated
   * @ordered
   */
  protected EList<TraceItem_> traceItem_1;

  /**
   * The cached value of the '{@link #getAnonymous_traceDirective_1_1() <em>Anonymous trace Directive 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_traceDirective_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_traceDirective_1_> anonymous_traceDirective_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceDirective_Impl()
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
    return UmplePackage.eINSTANCE.getTraceDirective_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceItem_> getTraceItem_1()
  {
    if (traceItem_1 == null)
    {
      traceItem_1 = new EObjectContainmentEList<TraceItem_>(TraceItem_.class, this, UmplePackage.TRACE_DIRECTIVE___TRACE_ITEM_1);
    }
    return traceItem_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_traceDirective_1_> getAnonymous_traceDirective_1_1()
  {
    if (anonymous_traceDirective_1_1 == null)
    {
      anonymous_traceDirective_1_1 = new EObjectContainmentEList<Anonymous_traceDirective_1_>(Anonymous_traceDirective_1_.class, this, UmplePackage.TRACE_DIRECTIVE___ANONYMOUS_TRACE_DIRECTIVE_11);
    }
    return anonymous_traceDirective_1_1;
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
      case UmplePackage.TRACE_DIRECTIVE___TRACE_ITEM_1:
        return ((InternalEList<?>)getTraceItem_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.TRACE_DIRECTIVE___ANONYMOUS_TRACE_DIRECTIVE_11:
        return ((InternalEList<?>)getAnonymous_traceDirective_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE_DIRECTIVE___TRACE_ITEM_1:
        return getTraceItem_1();
      case UmplePackage.TRACE_DIRECTIVE___ANONYMOUS_TRACE_DIRECTIVE_11:
        return getAnonymous_traceDirective_1_1();
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
      case UmplePackage.TRACE_DIRECTIVE___TRACE_ITEM_1:
        getTraceItem_1().clear();
        getTraceItem_1().addAll((Collection<? extends TraceItem_>)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE___ANONYMOUS_TRACE_DIRECTIVE_11:
        getAnonymous_traceDirective_1_1().clear();
        getAnonymous_traceDirective_1_1().addAll((Collection<? extends Anonymous_traceDirective_1_>)newValue);
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
      case UmplePackage.TRACE_DIRECTIVE___TRACE_ITEM_1:
        getTraceItem_1().clear();
        return;
      case UmplePackage.TRACE_DIRECTIVE___ANONYMOUS_TRACE_DIRECTIVE_11:
        getAnonymous_traceDirective_1_1().clear();
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
      case UmplePackage.TRACE_DIRECTIVE___TRACE_ITEM_1:
        return traceItem_1 != null && !traceItem_1.isEmpty();
      case UmplePackage.TRACE_DIRECTIVE___ANONYMOUS_TRACE_DIRECTIVE_11:
        return anonymous_traceDirective_1_1 != null && !anonymous_traceDirective_1_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TraceDirective_Impl
