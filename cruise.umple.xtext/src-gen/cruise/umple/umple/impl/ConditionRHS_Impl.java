/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ConditionRHS_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition RHS </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ConditionRHS_Impl#getComparison_operator_1 <em>Comparison operator 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConditionRHS_Impl#getRHS_1 <em>RHS 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionRHS_Impl extends MinimalEObjectImpl.Container implements ConditionRHS_
{
  /**
   * The default value of the '{@link #getComparison_operator_1() <em>Comparison operator 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComparison_operator_1()
   * @generated
   * @ordered
   */
  protected static final String COMPARISON_OPERATOR_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getComparison_operator_1() <em>Comparison operator 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComparison_operator_1()
   * @generated
   * @ordered
   */
  protected String comparison_operator_1 = COMPARISON_OPERATOR_1_EDEFAULT;

  /**
   * The default value of the '{@link #getRHS_1() <em>RHS 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRHS_1()
   * @generated
   * @ordered
   */
  protected static final String RHS_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRHS_1() <em>RHS 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRHS_1()
   * @generated
   * @ordered
   */
  protected String rhS_1 = RHS_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionRHS_Impl()
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
    return UmplePackage.eINSTANCE.getConditionRHS_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getComparison_operator_1()
  {
    return comparison_operator_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComparison_operator_1(String newComparison_operator_1)
  {
    String oldComparison_operator_1 = comparison_operator_1;
    comparison_operator_1 = newComparison_operator_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.CONDITION_RHS___COMPARISON_OPERATOR_1, oldComparison_operator_1, comparison_operator_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRHS_1()
  {
    return rhS_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRHS_1(String newRHS_1)
  {
    String oldRHS_1 = rhS_1;
    rhS_1 = newRHS_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.CONDITION_RHS___RHS_1, oldRHS_1, rhS_1));
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
      case UmplePackage.CONDITION_RHS___COMPARISON_OPERATOR_1:
        return getComparison_operator_1();
      case UmplePackage.CONDITION_RHS___RHS_1:
        return getRHS_1();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UmplePackage.CONDITION_RHS___COMPARISON_OPERATOR_1:
        setComparison_operator_1((String)newValue);
        return;
      case UmplePackage.CONDITION_RHS___RHS_1:
        setRHS_1((String)newValue);
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
      case UmplePackage.CONDITION_RHS___COMPARISON_OPERATOR_1:
        setComparison_operator_1(COMPARISON_OPERATOR_1_EDEFAULT);
        return;
      case UmplePackage.CONDITION_RHS___RHS_1:
        setRHS_1(RHS_1_EDEFAULT);
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
      case UmplePackage.CONDITION_RHS___COMPARISON_OPERATOR_1:
        return COMPARISON_OPERATOR_1_EDEFAULT == null ? comparison_operator_1 != null : !COMPARISON_OPERATOR_1_EDEFAULT.equals(comparison_operator_1);
      case UmplePackage.CONDITION_RHS___RHS_1:
        return RHS_1_EDEFAULT == null ? rhS_1 != null : !RHS_1_EDEFAULT.equals(rhS_1);
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
    result.append(" (comparison_operator_1: ");
    result.append(comparison_operator_1);
    result.append(", RHS_1: ");
    result.append(rhS_1);
    result.append(')');
    return result.toString();
  }

} //ConditionRHS_Impl
