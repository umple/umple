/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_singleIsA_1_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous single Is A1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_singleIsA_1_Impl#getExtendsName_1 <em>Extends Name 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_singleIsA_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_singleIsA_1_
{
  /**
   * The default value of the '{@link #getExtendsName_1() <em>Extends Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendsName_1()
   * @generated
   * @ordered
   */
  protected static final String EXTENDS_NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExtendsName_1() <em>Extends Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendsName_1()
   * @generated
   * @ordered
   */
  protected String extendsName_1 = EXTENDS_NAME_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_singleIsA_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_singleIsA_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExtendsName_1()
  {
    return extendsName_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtendsName_1(String newExtendsName_1)
  {
    String oldExtendsName_1 = extendsName_1;
    extendsName_1 = newExtendsName_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_SINGLE_IS_A1__EXTENDS_NAME_1, oldExtendsName_1, extendsName_1));
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
      case UmplePackage.ANONYMOUS_SINGLE_IS_A1__EXTENDS_NAME_1:
        return getExtendsName_1();
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
      case UmplePackage.ANONYMOUS_SINGLE_IS_A1__EXTENDS_NAME_1:
        setExtendsName_1((String)newValue);
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
      case UmplePackage.ANONYMOUS_SINGLE_IS_A1__EXTENDS_NAME_1:
        setExtendsName_1(EXTENDS_NAME_1_EDEFAULT);
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
      case UmplePackage.ANONYMOUS_SINGLE_IS_A1__EXTENDS_NAME_1:
        return EXTENDS_NAME_1_EDEFAULT == null ? extendsName_1 != null : !EXTENDS_NAME_1_EDEFAULT.equals(extendsName_1);
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
    result.append(" (extendsName_1: ");
    result.append(extendsName_1);
    result.append(')');
    return result.toString();
  }

} //Anonymous_singleIsA_1_Impl
