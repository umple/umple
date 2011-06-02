/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmpleInterface;
import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.functionDeclaration;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.UmpleInterfaceImpl#getExtraCode <em>Extra Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UmpleInterfaceImpl extends UmpleElementImpl implements UmpleInterface
{
  /**
   * The cached value of the '{@link #getExtraCode() <em>Extra Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtraCode()
   * @generated
   * @ordered
   */
  protected functionDeclaration extraCode;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UmpleInterfaceImpl()
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
    return UmplePackage.Literals.UMPLE_INTERFACE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public functionDeclaration getExtraCode()
  {
    return extraCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtraCode(functionDeclaration newExtraCode, NotificationChain msgs)
  {
    functionDeclaration oldExtraCode = extraCode;
    extraCode = newExtraCode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_INTERFACE__EXTRA_CODE, oldExtraCode, newExtraCode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtraCode(functionDeclaration newExtraCode)
  {
    if (newExtraCode != extraCode)
    {
      NotificationChain msgs = null;
      if (extraCode != null)
        msgs = ((InternalEObject)extraCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_INTERFACE__EXTRA_CODE, null, msgs);
      if (newExtraCode != null)
        msgs = ((InternalEObject)newExtraCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_INTERFACE__EXTRA_CODE, null, msgs);
      msgs = basicSetExtraCode(newExtraCode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_INTERFACE__EXTRA_CODE, newExtraCode, newExtraCode));
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
      case UmplePackage.UMPLE_INTERFACE__EXTRA_CODE:
        return basicSetExtraCode(null, msgs);
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
      case UmplePackage.UMPLE_INTERFACE__EXTRA_CODE:
        return getExtraCode();
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
      case UmplePackage.UMPLE_INTERFACE__EXTRA_CODE:
        setExtraCode((functionDeclaration)newValue);
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
      case UmplePackage.UMPLE_INTERFACE__EXTRA_CODE:
        setExtraCode((functionDeclaration)null);
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
      case UmplePackage.UMPLE_INTERFACE__EXTRA_CODE:
        return extraCode != null;
    }
    return super.eIsSet(featureID);
  }

} //UmpleInterfaceImpl
