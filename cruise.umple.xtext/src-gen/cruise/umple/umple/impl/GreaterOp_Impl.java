/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.GreaterOp_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Greater Op </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.GreaterOp_Impl#getGreaterOp_1 <em>Greater Op 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GreaterOp_Impl extends MinimalEObjectImpl.Container implements GreaterOp_
{
  /**
   * The default value of the '{@link #getGreaterOp_1() <em>Greater Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGreaterOp_1()
   * @generated
   * @ordered
   */
  protected static final String GREATER_OP_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGreaterOp_1() <em>Greater Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGreaterOp_1()
   * @generated
   * @ordered
   */
  protected String greaterOp_1 = GREATER_OP_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GreaterOp_Impl()
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
    return UmplePackage.eINSTANCE.getGreaterOp_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGreaterOp_1()
  {
    return greaterOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGreaterOp_1(String newGreaterOp_1)
  {
    String oldGreaterOp_1 = greaterOp_1;
    greaterOp_1 = newGreaterOp_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.GREATER_OP___GREATER_OP_1, oldGreaterOp_1, greaterOp_1));
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
      case UmplePackage.GREATER_OP___GREATER_OP_1:
        return getGreaterOp_1();
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
      case UmplePackage.GREATER_OP___GREATER_OP_1:
        setGreaterOp_1((String)newValue);
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
      case UmplePackage.GREATER_OP___GREATER_OP_1:
        setGreaterOp_1(GREATER_OP_1_EDEFAULT);
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
      case UmplePackage.GREATER_OP___GREATER_OP_1:
        return GREATER_OP_1_EDEFAULT == null ? greaterOp_1 != null : !GREATER_OP_1_EDEFAULT.equals(greaterOp_1);
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
    result.append(" (greaterOp_1: ");
    result.append(greaterOp_1);
    result.append(')');
    return result.toString();
  }

} //GreaterOp_Impl
