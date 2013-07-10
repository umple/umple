/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.DeActivateFor_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>De Activate For </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.DeActivateFor_Impl#getDeactivate_for_1 <em>Deactivate for 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeActivateFor_Impl extends MinimalEObjectImpl.Container implements DeActivateFor_
{
  /**
   * The default value of the '{@link #getDeactivate_for_1() <em>Deactivate for 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeactivate_for_1()
   * @generated
   * @ordered
   */
  protected static final String DEACTIVATE_FOR_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDeactivate_for_1() <em>Deactivate for 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeactivate_for_1()
   * @generated
   * @ordered
   */
  protected String deactivate_for_1 = DEACTIVATE_FOR_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeActivateFor_Impl()
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
    return UmplePackage.eINSTANCE.getDeActivateFor_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDeactivate_for_1()
  {
    return deactivate_for_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeactivate_for_1(String newDeactivate_for_1)
  {
    String oldDeactivate_for_1 = deactivate_for_1;
    deactivate_for_1 = newDeactivate_for_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.DE_ACTIVATE_FOR___DEACTIVATE_FOR_1, oldDeactivate_for_1, deactivate_for_1));
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
      case UmplePackage.DE_ACTIVATE_FOR___DEACTIVATE_FOR_1:
        return getDeactivate_for_1();
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
      case UmplePackage.DE_ACTIVATE_FOR___DEACTIVATE_FOR_1:
        setDeactivate_for_1((String)newValue);
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
      case UmplePackage.DE_ACTIVATE_FOR___DEACTIVATE_FOR_1:
        setDeactivate_for_1(DEACTIVATE_FOR_1_EDEFAULT);
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
      case UmplePackage.DE_ACTIVATE_FOR___DEACTIVATE_FOR_1:
        return DEACTIVATE_FOR_1_EDEFAULT == null ? deactivate_for_1 != null : !DEACTIVATE_FOR_1_EDEFAULT.equals(deactivate_for_1);
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
    result.append(" (deactivate_for_1: ");
    result.append(deactivate_for_1);
    result.append(')');
    return result.toString();
  }

} //DeActivateFor_Impl
