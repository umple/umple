/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_numExpr_3_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous num Expr 3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_numExpr_3_Impl#getTail_1 <em>Tail 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_numExpr_3_Impl extends MinimalEObjectImpl.Container implements Anonymous_numExpr_3_
{
  /**
   * The default value of the '{@link #getTail_1() <em>Tail 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTail_1()
   * @generated
   * @ordered
   */
  protected static final String TAIL_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTail_1() <em>Tail 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTail_1()
   * @generated
   * @ordered
   */
  protected String tail_1 = TAIL_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_numExpr_3_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_numExpr_3_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTail_1()
  {
    return tail_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTail_1(String newTail_1)
  {
    String oldTail_1 = tail_1;
    tail_1 = newTail_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_NUM_EXPR_3__TAIL_1, oldTail_1, tail_1));
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
      case UmplePackage.ANONYMOUS_NUM_EXPR_3__TAIL_1:
        return getTail_1();
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
      case UmplePackage.ANONYMOUS_NUM_EXPR_3__TAIL_1:
        setTail_1((String)newValue);
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
      case UmplePackage.ANONYMOUS_NUM_EXPR_3__TAIL_1:
        setTail_1(TAIL_1_EDEFAULT);
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
      case UmplePackage.ANONYMOUS_NUM_EXPR_3__TAIL_1:
        return TAIL_1_EDEFAULT == null ? tail_1 != null : !TAIL_1_EDEFAULT.equals(tail_1);
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
    result.append(" (tail_1: ");
    result.append(tail_1);
    result.append(')');
    return result.toString();
  }

} //Anonymous_numExpr_3_Impl
