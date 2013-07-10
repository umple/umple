/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.SmallerOp_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Smaller Op </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.SmallerOp_Impl#getSmallerOp_1 <em>Smaller Op 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SmallerOp_Impl extends MinimalEObjectImpl.Container implements SmallerOp_
{
  /**
   * The default value of the '{@link #getSmallerOp_1() <em>Smaller Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSmallerOp_1()
   * @generated
   * @ordered
   */
  protected static final String SMALLER_OP_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSmallerOp_1() <em>Smaller Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSmallerOp_1()
   * @generated
   * @ordered
   */
  protected String smallerOp_1 = SMALLER_OP_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SmallerOp_Impl()
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
    return UmplePackage.eINSTANCE.getSmallerOp_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSmallerOp_1()
  {
    return smallerOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSmallerOp_1(String newSmallerOp_1)
  {
    String oldSmallerOp_1 = smallerOp_1;
    smallerOp_1 = newSmallerOp_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.SMALLER_OP___SMALLER_OP_1, oldSmallerOp_1, smallerOp_1));
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
      case UmplePackage.SMALLER_OP___SMALLER_OP_1:
        return getSmallerOp_1();
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
      case UmplePackage.SMALLER_OP___SMALLER_OP_1:
        setSmallerOp_1((String)newValue);
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
      case UmplePackage.SMALLER_OP___SMALLER_OP_1:
        setSmallerOp_1(SMALLER_OP_1_EDEFAULT);
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
      case UmplePackage.SMALLER_OP___SMALLER_OP_1:
        return SMALLER_OP_1_EDEFAULT == null ? smallerOp_1 != null : !SMALLER_OP_1_EDEFAULT.equals(smallerOp_1);
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
    result.append(" (smallerOp_1: ");
    result.append(smallerOp_1);
    result.append(')');
    return result.toString();
  }

} //SmallerOp_Impl
