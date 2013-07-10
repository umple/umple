/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ExtraCode_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extra Code </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ExtraCode_Impl#getExtraCode_1 <em>Extra Code 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtraCode_Impl extends MinimalEObjectImpl.Container implements ExtraCode_
{
  /**
   * The default value of the '{@link #getExtraCode_1() <em>Extra Code 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtraCode_1()
   * @generated
   * @ordered
   */
  protected static final String EXTRA_CODE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExtraCode_1() <em>Extra Code 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtraCode_1()
   * @generated
   * @ordered
   */
  protected String extraCode_1 = EXTRA_CODE_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExtraCode_Impl()
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
    return UmplePackage.eINSTANCE.getExtraCode_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExtraCode_1()
  {
    return extraCode_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtraCode_1(String newExtraCode_1)
  {
    String oldExtraCode_1 = extraCode_1;
    extraCode_1 = newExtraCode_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXTRA_CODE___EXTRA_CODE_1, oldExtraCode_1, extraCode_1));
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
      case UmplePackage.EXTRA_CODE___EXTRA_CODE_1:
        return getExtraCode_1();
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
      case UmplePackage.EXTRA_CODE___EXTRA_CODE_1:
        setExtraCode_1((String)newValue);
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
      case UmplePackage.EXTRA_CODE___EXTRA_CODE_1:
        setExtraCode_1(EXTRA_CODE_1_EDEFAULT);
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
      case UmplePackage.EXTRA_CODE___EXTRA_CODE_1:
        return EXTRA_CODE_1_EDEFAULT == null ? extraCode_1 != null : !EXTRA_CODE_1_EDEFAULT.equals(extraCode_1);
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
    result.append(" (extraCode_1: ");
    result.append(extraCode_1);
    result.append(')');
    return result.toString();
  }

} //ExtraCode_Impl
