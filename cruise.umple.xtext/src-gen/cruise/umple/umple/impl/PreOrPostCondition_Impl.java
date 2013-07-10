/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.PreOrPostCondition_;
import cruise.umple.umple.TraceCondition_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pre Or Post Condition </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.PreOrPostCondition_Impl#getAnonymous_PreOrPostCondition_1_1 <em>Anonymous Pre Or Post Condition 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.PreOrPostCondition_Impl#getTraceCondition_1 <em>Trace Condition 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreOrPostCondition_Impl extends MinimalEObjectImpl.Container implements PreOrPostCondition_
{
  /**
   * The cached value of the '{@link #getAnonymous_PreOrPostCondition_1_1() <em>Anonymous Pre Or Post Condition 11</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_PreOrPostCondition_1_1()
   * @generated
   * @ordered
   */
  protected EList<String> anonymous_PreOrPostCondition_1_1;

  /**
   * The cached value of the '{@link #getTraceCondition_1() <em>Trace Condition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceCondition_1()
   * @generated
   * @ordered
   */
  protected EList<TraceCondition_> traceCondition_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PreOrPostCondition_Impl()
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
    return UmplePackage.eINSTANCE.getPreOrPostCondition_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getAnonymous_PreOrPostCondition_1_1()
  {
    if (anonymous_PreOrPostCondition_1_1 == null)
    {
      anonymous_PreOrPostCondition_1_1 = new EDataTypeEList<String>(String.class, this, UmplePackage.PRE_OR_POST_CONDITION___ANONYMOUS_PRE_OR_POST_CONDITION_11);
    }
    return anonymous_PreOrPostCondition_1_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceCondition_> getTraceCondition_1()
  {
    if (traceCondition_1 == null)
    {
      traceCondition_1 = new EObjectContainmentEList<TraceCondition_>(TraceCondition_.class, this, UmplePackage.PRE_OR_POST_CONDITION___TRACE_CONDITION_1);
    }
    return traceCondition_1;
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
      case UmplePackage.PRE_OR_POST_CONDITION___TRACE_CONDITION_1:
        return ((InternalEList<?>)getTraceCondition_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.PRE_OR_POST_CONDITION___ANONYMOUS_PRE_OR_POST_CONDITION_11:
        return getAnonymous_PreOrPostCondition_1_1();
      case UmplePackage.PRE_OR_POST_CONDITION___TRACE_CONDITION_1:
        return getTraceCondition_1();
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
      case UmplePackage.PRE_OR_POST_CONDITION___ANONYMOUS_PRE_OR_POST_CONDITION_11:
        getAnonymous_PreOrPostCondition_1_1().clear();
        getAnonymous_PreOrPostCondition_1_1().addAll((Collection<? extends String>)newValue);
        return;
      case UmplePackage.PRE_OR_POST_CONDITION___TRACE_CONDITION_1:
        getTraceCondition_1().clear();
        getTraceCondition_1().addAll((Collection<? extends TraceCondition_>)newValue);
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
      case UmplePackage.PRE_OR_POST_CONDITION___ANONYMOUS_PRE_OR_POST_CONDITION_11:
        getAnonymous_PreOrPostCondition_1_1().clear();
        return;
      case UmplePackage.PRE_OR_POST_CONDITION___TRACE_CONDITION_1:
        getTraceCondition_1().clear();
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
      case UmplePackage.PRE_OR_POST_CONDITION___ANONYMOUS_PRE_OR_POST_CONDITION_11:
        return anonymous_PreOrPostCondition_1_1 != null && !anonymous_PreOrPostCondition_1_1.isEmpty();
      case UmplePackage.PRE_OR_POST_CONDITION___TRACE_CONDITION_1:
        return traceCondition_1 != null && !traceCondition_1.isEmpty();
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
    result.append(" (Anonymous_PreOrPostCondition_1_1: ");
    result.append(anonymous_PreOrPostCondition_1_1);
    result.append(')');
    return result.toString();
  }

} //PreOrPostCondition_Impl
