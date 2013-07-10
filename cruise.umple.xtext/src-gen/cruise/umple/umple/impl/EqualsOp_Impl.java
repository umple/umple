/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.EqualsOp_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equals Op </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.EqualsOp_Impl#getEqualsOp_1 <em>Equals Op 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EqualsOp_Impl extends MinimalEObjectImpl.Container implements EqualsOp_
{
  /**
   * The default value of the '{@link #getEqualsOp_1() <em>Equals Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEqualsOp_1()
   * @generated
   * @ordered
   */
  protected static final String EQUALS_OP_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEqualsOp_1() <em>Equals Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEqualsOp_1()
   * @generated
   * @ordered
   */
  protected String equalsOp_1 = EQUALS_OP_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EqualsOp_Impl()
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
    return UmplePackage.eINSTANCE.getEqualsOp_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEqualsOp_1()
  {
    return equalsOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEqualsOp_1(String newEqualsOp_1)
  {
    String oldEqualsOp_1 = equalsOp_1;
    equalsOp_1 = newEqualsOp_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EQUALS_OP___EQUALS_OP_1, oldEqualsOp_1, equalsOp_1));
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
      case UmplePackage.EQUALS_OP___EQUALS_OP_1:
        return getEqualsOp_1();
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
      case UmplePackage.EQUALS_OP___EQUALS_OP_1:
        setEqualsOp_1((String)newValue);
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
      case UmplePackage.EQUALS_OP___EQUALS_OP_1:
        setEqualsOp_1(EQUALS_OP_1_EDEFAULT);
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
      case UmplePackage.EQUALS_OP___EQUALS_OP_1:
        return EQUALS_OP_1_EDEFAULT == null ? equalsOp_1 != null : !EQUALS_OP_1_EDEFAULT.equals(equalsOp_1);
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
    result.append(" (equalsOp_1: ");
    result.append(equalsOp_1);
    result.append(')');
    return result.toString();
  }

} //EqualsOp_Impl
