/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.NotequalsOp_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notequals Op </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.NotequalsOp_Impl#getNotequalsOp_1 <em>Notequals Op 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotequalsOp_Impl extends MinimalEObjectImpl.Container implements NotequalsOp_
{
  /**
   * The default value of the '{@link #getNotequalsOp_1() <em>Notequals Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNotequalsOp_1()
   * @generated
   * @ordered
   */
  protected static final String NOTEQUALS_OP_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNotequalsOp_1() <em>Notequals Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNotequalsOp_1()
   * @generated
   * @ordered
   */
  protected String notequalsOp_1 = NOTEQUALS_OP_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NotequalsOp_Impl()
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
    return UmplePackage.eINSTANCE.getNotequalsOp_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNotequalsOp_1()
  {
    return notequalsOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNotequalsOp_1(String newNotequalsOp_1)
  {
    String oldNotequalsOp_1 = notequalsOp_1;
    notequalsOp_1 = newNotequalsOp_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.NOTEQUALS_OP___NOTEQUALS_OP_1, oldNotequalsOp_1, notequalsOp_1));
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
      case UmplePackage.NOTEQUALS_OP___NOTEQUALS_OP_1:
        return getNotequalsOp_1();
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
      case UmplePackage.NOTEQUALS_OP___NOTEQUALS_OP_1:
        setNotequalsOp_1((String)newValue);
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
      case UmplePackage.NOTEQUALS_OP___NOTEQUALS_OP_1:
        setNotequalsOp_1(NOTEQUALS_OP_1_EDEFAULT);
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
      case UmplePackage.NOTEQUALS_OP___NOTEQUALS_OP_1:
        return NOTEQUALS_OP_1_EDEFAULT == null ? notequalsOp_1 != null : !NOTEQUALS_OP_1_EDEFAULT.equals(notequalsOp_1);
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
    result.append(" (notequalsOp_1: ");
    result.append(notequalsOp_1);
    result.append(')');
    return result.toString();
  }

} //NotequalsOp_Impl
