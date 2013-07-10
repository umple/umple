/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ConditionRHS_;
import cruise.umple.umple.TraceCondition_;
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
 * An implementation of the model object '<em><b>Trace Condition </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceCondition_Impl#getLHS_1 <em>LHS 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCondition_Impl#getConditionRHS_1 <em>Condition RHS 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceCondition_Impl extends MinimalEObjectImpl.Container implements TraceCondition_
{
  /**
   * The default value of the '{@link #getLHS_1() <em>LHS 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLHS_1()
   * @generated
   * @ordered
   */
  protected static final String LHS_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLHS_1() <em>LHS 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLHS_1()
   * @generated
   * @ordered
   */
  protected String lhS_1 = LHS_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getConditionRHS_1() <em>Condition RHS 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionRHS_1()
   * @generated
   * @ordered
   */
  protected EList<ConditionRHS_> conditionRHS_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceCondition_Impl()
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
    return UmplePackage.eINSTANCE.getTraceCondition_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLHS_1()
  {
    return lhS_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLHS_1(String newLHS_1)
  {
    String oldLHS_1 = lhS_1;
    lhS_1 = newLHS_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CONDITION___LHS_1, oldLHS_1, lhS_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConditionRHS_> getConditionRHS_1()
  {
    if (conditionRHS_1 == null)
    {
      conditionRHS_1 = new EObjectContainmentEList<ConditionRHS_>(ConditionRHS_.class, this, UmplePackage.TRACE_CONDITION___CONDITION_RHS_1);
    }
    return conditionRHS_1;
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
      case UmplePackage.TRACE_CONDITION___CONDITION_RHS_1:
        return ((InternalEList<?>)getConditionRHS_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE_CONDITION___LHS_1:
        return getLHS_1();
      case UmplePackage.TRACE_CONDITION___CONDITION_RHS_1:
        return getConditionRHS_1();
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
      case UmplePackage.TRACE_CONDITION___LHS_1:
        setLHS_1((String)newValue);
        return;
      case UmplePackage.TRACE_CONDITION___CONDITION_RHS_1:
        getConditionRHS_1().clear();
        getConditionRHS_1().addAll((Collection<? extends ConditionRHS_>)newValue);
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
      case UmplePackage.TRACE_CONDITION___LHS_1:
        setLHS_1(LHS_1_EDEFAULT);
        return;
      case UmplePackage.TRACE_CONDITION___CONDITION_RHS_1:
        getConditionRHS_1().clear();
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
      case UmplePackage.TRACE_CONDITION___LHS_1:
        return LHS_1_EDEFAULT == null ? lhS_1 != null : !LHS_1_EDEFAULT.equals(lhS_1);
      case UmplePackage.TRACE_CONDITION___CONDITION_RHS_1:
        return conditionRHS_1 != null && !conditionRHS_1.isEmpty();
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
    result.append(" (LHS_1: ");
    result.append(lhS_1);
    result.append(')');
    return result.toString();
  }

} //TraceCondition_Impl
