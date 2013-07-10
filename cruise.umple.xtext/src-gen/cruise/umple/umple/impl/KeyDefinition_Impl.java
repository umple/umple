/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.KeyDefinition_;
import cruise.umple.umple.Key_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Definition </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.KeyDefinition_Impl#getDefaultKey_1 <em>Default Key 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.KeyDefinition_Impl#getKey_1 <em>Key 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyDefinition_Impl extends MinimalEObjectImpl.Container implements KeyDefinition_
{
  /**
   * The cached value of the '{@link #getDefaultKey_1() <em>Default Key 1</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultKey_1()
   * @generated
   * @ordered
   */
  protected EList<String> defaultKey_1;

  /**
   * The cached value of the '{@link #getKey_1() <em>Key 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKey_1()
   * @generated
   * @ordered
   */
  protected EList<Key_> key_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected KeyDefinition_Impl()
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
    return UmplePackage.eINSTANCE.getKeyDefinition_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getDefaultKey_1()
  {
    if (defaultKey_1 == null)
    {
      defaultKey_1 = new EDataTypeEList<String>(String.class, this, UmplePackage.KEY_DEFINITION___DEFAULT_KEY_1);
    }
    return defaultKey_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Key_> getKey_1()
  {
    if (key_1 == null)
    {
      key_1 = new EObjectContainmentEList<Key_>(Key_.class, this, UmplePackage.KEY_DEFINITION___KEY_1);
    }
    return key_1;
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
      case UmplePackage.KEY_DEFINITION___KEY_1:
        return ((InternalEList<?>)getKey_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.KEY_DEFINITION___DEFAULT_KEY_1:
        return getDefaultKey_1();
      case UmplePackage.KEY_DEFINITION___KEY_1:
        return getKey_1();
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
      case UmplePackage.KEY_DEFINITION___DEFAULT_KEY_1:
        getDefaultKey_1().clear();
        getDefaultKey_1().addAll((Collection<? extends String>)newValue);
        return;
      case UmplePackage.KEY_DEFINITION___KEY_1:
        getKey_1().clear();
        getKey_1().addAll((Collection<? extends Key_>)newValue);
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
      case UmplePackage.KEY_DEFINITION___DEFAULT_KEY_1:
        getDefaultKey_1().clear();
        return;
      case UmplePackage.KEY_DEFINITION___KEY_1:
        getKey_1().clear();
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
      case UmplePackage.KEY_DEFINITION___DEFAULT_KEY_1:
        return defaultKey_1 != null && !defaultKey_1.isEmpty();
      case UmplePackage.KEY_DEFINITION___KEY_1:
        return key_1 != null && !key_1.isEmpty();
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
    result.append(" (DefaultKey_1: ");
    result.append(defaultKey_1);
    result.append(')');
    return result.toString();
  }

} //KeyDefinition_Impl
