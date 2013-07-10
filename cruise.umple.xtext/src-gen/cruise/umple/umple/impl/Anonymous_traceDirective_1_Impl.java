/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_traceDirective_1_;
import cruise.umple.umple.ExecuteClause_;
import cruise.umple.umple.TraceCaseActivation_;
import cruise.umple.umple.TraceDuring_;
import cruise.umple.umple.TraceFor_;
import cruise.umple.umple.TraceLevel_;
import cruise.umple.umple.TracePeriod_;
import cruise.umple.umple.TraceRecord_;
import cruise.umple.umple.TraceWhen_;
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
 * An implementation of the model object '<em><b>Anonymous trace Directive 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceDirective_1_Impl#getExecuteClause_1 <em>Execute Clause 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceDirective_1_Impl#getTraceWhen_1 <em>Trace When 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceDirective_1_Impl#getTraceFor_1 <em>Trace For 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceDirective_1_Impl#getTracePeriod_1 <em>Trace Period 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceDirective_1_Impl#getTraceDuring_1 <em>Trace During 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceDirective_1_Impl#getTraceCaseActivation_1 <em>Trace Case Activation 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceDirective_1_Impl#getTraceRecord_1 <em>Trace Record 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceDirective_1_Impl#getTraceLevel_1 <em>Trace Level 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_traceDirective_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_traceDirective_1_
{
  /**
   * The cached value of the '{@link #getExecuteClause_1() <em>Execute Clause 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecuteClause_1()
   * @generated
   * @ordered
   */
  protected EList<ExecuteClause_> executeClause_1;

  /**
   * The cached value of the '{@link #getTraceWhen_1() <em>Trace When 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceWhen_1()
   * @generated
   * @ordered
   */
  protected EList<TraceWhen_> traceWhen_1;

  /**
   * The cached value of the '{@link #getTraceFor_1() <em>Trace For 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceFor_1()
   * @generated
   * @ordered
   */
  protected EList<TraceFor_> traceFor_1;

  /**
   * The cached value of the '{@link #getTracePeriod_1() <em>Trace Period 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTracePeriod_1()
   * @generated
   * @ordered
   */
  protected EList<TracePeriod_> tracePeriod_1;

  /**
   * The cached value of the '{@link #getTraceDuring_1() <em>Trace During 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceDuring_1()
   * @generated
   * @ordered
   */
  protected EList<TraceDuring_> traceDuring_1;

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
   * The cached value of the '{@link #getTraceRecord_1() <em>Trace Record 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceRecord_1()
   * @generated
   * @ordered
   */
  protected EList<TraceRecord_> traceRecord_1;

  /**
   * The cached value of the '{@link #getTraceLevel_1() <em>Trace Level 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceLevel_1()
   * @generated
   * @ordered
   */
  protected EList<TraceLevel_> traceLevel_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_traceDirective_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_traceDirective_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExecuteClause_> getExecuteClause_1()
  {
    if (executeClause_1 == null)
    {
      executeClause_1 = new EObjectContainmentEList<ExecuteClause_>(ExecuteClause_.class, this, UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__EXECUTE_CLAUSE_1);
    }
    return executeClause_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceWhen_> getTraceWhen_1()
  {
    if (traceWhen_1 == null)
    {
      traceWhen_1 = new EObjectContainmentEList<TraceWhen_>(TraceWhen_.class, this, UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_WHEN_1);
    }
    return traceWhen_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceFor_> getTraceFor_1()
  {
    if (traceFor_1 == null)
    {
      traceFor_1 = new EObjectContainmentEList<TraceFor_>(TraceFor_.class, this, UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_FOR_1);
    }
    return traceFor_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TracePeriod_> getTracePeriod_1()
  {
    if (tracePeriod_1 == null)
    {
      tracePeriod_1 = new EObjectContainmentEList<TracePeriod_>(TracePeriod_.class, this, UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_PERIOD_1);
    }
    return tracePeriod_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceDuring_> getTraceDuring_1()
  {
    if (traceDuring_1 == null)
    {
      traceDuring_1 = new EObjectContainmentEList<TraceDuring_>(TraceDuring_.class, this, UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_DURING_1);
    }
    return traceDuring_1;
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
      traceCaseActivation_1 = new EObjectContainmentEList<TraceCaseActivation_>(TraceCaseActivation_.class, this, UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_CASE_ACTIVATION_1);
    }
    return traceCaseActivation_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceRecord_> getTraceRecord_1()
  {
    if (traceRecord_1 == null)
    {
      traceRecord_1 = new EObjectContainmentEList<TraceRecord_>(TraceRecord_.class, this, UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_RECORD_1);
    }
    return traceRecord_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceLevel_> getTraceLevel_1()
  {
    if (traceLevel_1 == null)
    {
      traceLevel_1 = new EObjectContainmentEList<TraceLevel_>(TraceLevel_.class, this, UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_LEVEL_1);
    }
    return traceLevel_1;
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
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__EXECUTE_CLAUSE_1:
        return ((InternalEList<?>)getExecuteClause_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_WHEN_1:
        return ((InternalEList<?>)getTraceWhen_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_FOR_1:
        return ((InternalEList<?>)getTraceFor_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_PERIOD_1:
        return ((InternalEList<?>)getTracePeriod_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_DURING_1:
        return ((InternalEList<?>)getTraceDuring_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_CASE_ACTIVATION_1:
        return ((InternalEList<?>)getTraceCaseActivation_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_RECORD_1:
        return ((InternalEList<?>)getTraceRecord_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_LEVEL_1:
        return ((InternalEList<?>)getTraceLevel_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__EXECUTE_CLAUSE_1:
        return getExecuteClause_1();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_WHEN_1:
        return getTraceWhen_1();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_FOR_1:
        return getTraceFor_1();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_PERIOD_1:
        return getTracePeriod_1();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_DURING_1:
        return getTraceDuring_1();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_CASE_ACTIVATION_1:
        return getTraceCaseActivation_1();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_RECORD_1:
        return getTraceRecord_1();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_LEVEL_1:
        return getTraceLevel_1();
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
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__EXECUTE_CLAUSE_1:
        getExecuteClause_1().clear();
        getExecuteClause_1().addAll((Collection<? extends ExecuteClause_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_WHEN_1:
        getTraceWhen_1().clear();
        getTraceWhen_1().addAll((Collection<? extends TraceWhen_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_FOR_1:
        getTraceFor_1().clear();
        getTraceFor_1().addAll((Collection<? extends TraceFor_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_PERIOD_1:
        getTracePeriod_1().clear();
        getTracePeriod_1().addAll((Collection<? extends TracePeriod_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_DURING_1:
        getTraceDuring_1().clear();
        getTraceDuring_1().addAll((Collection<? extends TraceDuring_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_CASE_ACTIVATION_1:
        getTraceCaseActivation_1().clear();
        getTraceCaseActivation_1().addAll((Collection<? extends TraceCaseActivation_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_RECORD_1:
        getTraceRecord_1().clear();
        getTraceRecord_1().addAll((Collection<? extends TraceRecord_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_LEVEL_1:
        getTraceLevel_1().clear();
        getTraceLevel_1().addAll((Collection<? extends TraceLevel_>)newValue);
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
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__EXECUTE_CLAUSE_1:
        getExecuteClause_1().clear();
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_WHEN_1:
        getTraceWhen_1().clear();
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_FOR_1:
        getTraceFor_1().clear();
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_PERIOD_1:
        getTracePeriod_1().clear();
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_DURING_1:
        getTraceDuring_1().clear();
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_CASE_ACTIVATION_1:
        getTraceCaseActivation_1().clear();
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_RECORD_1:
        getTraceRecord_1().clear();
        return;
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_LEVEL_1:
        getTraceLevel_1().clear();
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
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__EXECUTE_CLAUSE_1:
        return executeClause_1 != null && !executeClause_1.isEmpty();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_WHEN_1:
        return traceWhen_1 != null && !traceWhen_1.isEmpty();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_FOR_1:
        return traceFor_1 != null && !traceFor_1.isEmpty();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_PERIOD_1:
        return tracePeriod_1 != null && !tracePeriod_1.isEmpty();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_DURING_1:
        return traceDuring_1 != null && !traceDuring_1.isEmpty();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_CASE_ACTIVATION_1:
        return traceCaseActivation_1 != null && !traceCaseActivation_1.isEmpty();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_RECORD_1:
        return traceRecord_1 != null && !traceRecord_1.isEmpty();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_LEVEL_1:
        return traceLevel_1 != null && !traceLevel_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_traceDirective_1_Impl
