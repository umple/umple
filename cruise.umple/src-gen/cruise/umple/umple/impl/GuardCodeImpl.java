/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.GuardCode;
import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.block;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard Code</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.GuardCodeImpl#getNativeExpression <em>Native Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuardCodeImpl extends GuardImpl implements GuardCode
{
  /**
   * The cached value of the '{@link #getNativeExpression() <em>Native Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNativeExpression()
   * @generated
   * @ordered
   */
  protected block nativeExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GuardCodeImpl()
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
    return UmplePackage.Literals.GUARD_CODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public block getNativeExpression()
  {
    return nativeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNativeExpression(block newNativeExpression, NotificationChain msgs)
  {
    block oldNativeExpression = nativeExpression;
    nativeExpression = newNativeExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.GUARD_CODE__NATIVE_EXPRESSION, oldNativeExpression, newNativeExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNativeExpression(block newNativeExpression)
  {
    if (newNativeExpression != nativeExpression)
    {
      NotificationChain msgs = null;
      if (nativeExpression != null)
        msgs = ((InternalEObject)nativeExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.GUARD_CODE__NATIVE_EXPRESSION, null, msgs);
      if (newNativeExpression != null)
        msgs = ((InternalEObject)newNativeExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.GUARD_CODE__NATIVE_EXPRESSION, null, msgs);
      msgs = basicSetNativeExpression(newNativeExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.GUARD_CODE__NATIVE_EXPRESSION, newNativeExpression, newNativeExpression));
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
      case UmplePackage.GUARD_CODE__NATIVE_EXPRESSION:
        return basicSetNativeExpression(null, msgs);
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
      case UmplePackage.GUARD_CODE__NATIVE_EXPRESSION:
        return getNativeExpression();
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
      case UmplePackage.GUARD_CODE__NATIVE_EXPRESSION:
        setNativeExpression((block)newValue);
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
      case UmplePackage.GUARD_CODE__NATIVE_EXPRESSION:
        setNativeExpression((block)null);
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
      case UmplePackage.GUARD_CODE__NATIVE_EXPRESSION:
        return nativeExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //GuardCodeImpl
