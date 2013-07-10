/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_key_1_;
import cruise.umple.umple.Key_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Key_Impl#getKeyId_1 <em>Key Id 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Key_Impl#getAnonymous_key_1_1 <em>Anonymous key 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Key_Impl extends MinimalEObjectImpl.Container implements Key_
{
  /**
   * The default value of the '{@link #getKeyId_1() <em>Key Id 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeyId_1()
   * @generated
   * @ordered
   */
  protected static final String KEY_ID_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getKeyId_1() <em>Key Id 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeyId_1()
   * @generated
   * @ordered
   */
  protected String keyId_1 = KEY_ID_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_key_1_1() <em>Anonymous key 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_key_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_key_1_> anonymous_key_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Key_Impl()
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
    return UmplePackage.eINSTANCE.getKey_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getKeyId_1()
  {
    return keyId_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKeyId_1(String newKeyId_1)
  {
    String oldKeyId_1 = keyId_1;
    keyId_1 = newKeyId_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.KEY___KEY_ID_1, oldKeyId_1, keyId_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_key_1_> getAnonymous_key_1_1()
  {
    if (anonymous_key_1_1 == null)
    {
      anonymous_key_1_1 = new EObjectContainmentEList<Anonymous_key_1_>(Anonymous_key_1_.class, this, UmplePackage.KEY___ANONYMOUS_KEY_11);
    }
    return anonymous_key_1_1;
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
      case UmplePackage.KEY___ANONYMOUS_KEY_11:
        return ((InternalEList<?>)getAnonymous_key_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.KEY___KEY_ID_1:
        return getKeyId_1();
      case UmplePackage.KEY___ANONYMOUS_KEY_11:
        return getAnonymous_key_1_1();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UmplePackage.KEY___KEY_ID_1:
        setKeyId_1((String)newValue);
        return;
      case UmplePackage.KEY___ANONYMOUS_KEY_11:
        getAnonymous_key_1_1().clear();
        getAnonymous_key_1_1().addAll((Collection<? extends Anonymous_key_1_>)newValue);
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
      case UmplePackage.KEY___KEY_ID_1:
        setKeyId_1(KEY_ID_1_EDEFAULT);
        return;
      case UmplePackage.KEY___ANONYMOUS_KEY_11:
        getAnonymous_key_1_1().clear();
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
      case UmplePackage.KEY___KEY_ID_1:
        return KEY_ID_1_EDEFAULT == null ? keyId_1 != null : !KEY_ID_1_EDEFAULT.equals(keyId_1);
      case UmplePackage.KEY___ANONYMOUS_KEY_11:
        return anonymous_key_1_1 != null && !anonymous_key_1_1.isEmpty();
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
    result.append(" (keyId_1: ");
    result.append(keyId_1);
    result.append(')');
    return result.toString();
  }

} //Key_Impl
