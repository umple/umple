/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ConstraintToken_;
import cruise.umple.umple.TraceWhen_;
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
 * An implementation of the model object '<em><b>Trace When </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceWhen_Impl#getConditionType_1 <em>Condition Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceWhen_Impl#getConstraintToken_1 <em>Constraint Token 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceWhen_Impl extends MinimalEObjectImpl.Container implements TraceWhen_
{
  /**
   * The default value of the '{@link #getConditionType_1() <em>Condition Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionType_1()
   * @generated
   * @ordered
   */
  protected static final String CONDITION_TYPE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getConditionType_1() <em>Condition Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionType_1()
   * @generated
   * @ordered
   */
  protected String conditionType_1 = CONDITION_TYPE_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getConstraintToken_1() <em>Constraint Token 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintToken_1()
   * @generated
   * @ordered
   */
  protected EList<ConstraintToken_> constraintToken_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceWhen_Impl()
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
    return UmplePackage.eINSTANCE.getTraceWhen_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getConditionType_1()
  {
    return conditionType_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConditionType_1(String newConditionType_1)
  {
    String oldConditionType_1 = conditionType_1;
    conditionType_1 = newConditionType_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_WHEN___CONDITION_TYPE_1, oldConditionType_1, conditionType_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstraintToken_> getConstraintToken_1()
  {
    if (constraintToken_1 == null)
    {
      constraintToken_1 = new EObjectContainmentEList<ConstraintToken_>(ConstraintToken_.class, this, UmplePackage.TRACE_WHEN___CONSTRAINT_TOKEN_1);
    }
    return constraintToken_1;
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
      case UmplePackage.TRACE_WHEN___CONSTRAINT_TOKEN_1:
        return ((InternalEList<?>)getConstraintToken_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE_WHEN___CONDITION_TYPE_1:
        return getConditionType_1();
      case UmplePackage.TRACE_WHEN___CONSTRAINT_TOKEN_1:
        return getConstraintToken_1();
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
      case UmplePackage.TRACE_WHEN___CONDITION_TYPE_1:
        setConditionType_1((String)newValue);
        return;
      case UmplePackage.TRACE_WHEN___CONSTRAINT_TOKEN_1:
        getConstraintToken_1().clear();
        getConstraintToken_1().addAll((Collection<? extends ConstraintToken_>)newValue);
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
      case UmplePackage.TRACE_WHEN___CONDITION_TYPE_1:
        setConditionType_1(CONDITION_TYPE_1_EDEFAULT);
        return;
      case UmplePackage.TRACE_WHEN___CONSTRAINT_TOKEN_1:
        getConstraintToken_1().clear();
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
      case UmplePackage.TRACE_WHEN___CONDITION_TYPE_1:
        return CONDITION_TYPE_1_EDEFAULT == null ? conditionType_1 != null : !CONDITION_TYPE_1_EDEFAULT.equals(conditionType_1);
      case UmplePackage.TRACE_WHEN___CONSTRAINT_TOKEN_1:
        return constraintToken_1 != null && !constraintToken_1.isEmpty();
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
    result.append(" (conditionType_1: ");
    result.append(conditionType_1);
    result.append(')');
    return result.toString();
  }

} //TraceWhen_Impl
