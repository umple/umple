/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.CodeInjection_;
import cruise.umple.umple.Immutable_;
import cruise.umple.umple.IsA_;
import cruise.umple.umple.KeyDefinition_;
import cruise.umple.umple.Singleton_;
import cruise.umple.umple.SoftwarePattern_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Software Pattern </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.SoftwarePattern_Impl#getIsA_1 <em>Is A1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.SoftwarePattern_Impl#getSingleton_1 <em>Singleton 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.SoftwarePattern_Impl#getImmutable_1 <em>Immutable 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.SoftwarePattern_Impl#getKeyDefinition_1 <em>Key Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.SoftwarePattern_Impl#getCodeInjection_1 <em>Code Injection 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoftwarePattern_Impl extends MinimalEObjectImpl.Container implements SoftwarePattern_
{
  /**
   * The cached value of the '{@link #getIsA_1() <em>Is A1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsA_1()
   * @generated
   * @ordered
   */
  protected EList<IsA_> isA_1;

  /**
   * The cached value of the '{@link #getSingleton_1() <em>Singleton 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingleton_1()
   * @generated
   * @ordered
   */
  protected EList<Singleton_> singleton_1;

  /**
   * The cached value of the '{@link #getImmutable_1() <em>Immutable 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImmutable_1()
   * @generated
   * @ordered
   */
  protected EList<Immutable_> immutable_1;

  /**
   * The cached value of the '{@link #getKeyDefinition_1() <em>Key Definition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeyDefinition_1()
   * @generated
   * @ordered
   */
  protected EList<KeyDefinition_> keyDefinition_1;

  /**
   * The cached value of the '{@link #getCodeInjection_1() <em>Code Injection 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodeInjection_1()
   * @generated
   * @ordered
   */
  protected EList<CodeInjection_> codeInjection_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SoftwarePattern_Impl()
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
    return UmplePackage.eINSTANCE.getSoftwarePattern_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IsA_> getIsA_1()
  {
    if (isA_1 == null)
    {
      isA_1 = new EObjectContainmentEList<IsA_>(IsA_.class, this, UmplePackage.SOFTWARE_PATTERN___IS_A1);
    }
    return isA_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Singleton_> getSingleton_1()
  {
    if (singleton_1 == null)
    {
      singleton_1 = new EObjectContainmentEList<Singleton_>(Singleton_.class, this, UmplePackage.SOFTWARE_PATTERN___SINGLETON_1);
    }
    return singleton_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Immutable_> getImmutable_1()
  {
    if (immutable_1 == null)
    {
      immutable_1 = new EObjectContainmentEList<Immutable_>(Immutable_.class, this, UmplePackage.SOFTWARE_PATTERN___IMMUTABLE_1);
    }
    return immutable_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<KeyDefinition_> getKeyDefinition_1()
  {
    if (keyDefinition_1 == null)
    {
      keyDefinition_1 = new EObjectContainmentEList<KeyDefinition_>(KeyDefinition_.class, this, UmplePackage.SOFTWARE_PATTERN___KEY_DEFINITION_1);
    }
    return keyDefinition_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CodeInjection_> getCodeInjection_1()
  {
    if (codeInjection_1 == null)
    {
      codeInjection_1 = new EObjectContainmentEList<CodeInjection_>(CodeInjection_.class, this, UmplePackage.SOFTWARE_PATTERN___CODE_INJECTION_1);
    }
    return codeInjection_1;
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
      case UmplePackage.SOFTWARE_PATTERN___IS_A1:
        return ((InternalEList<?>)getIsA_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.SOFTWARE_PATTERN___SINGLETON_1:
        return ((InternalEList<?>)getSingleton_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.SOFTWARE_PATTERN___IMMUTABLE_1:
        return ((InternalEList<?>)getImmutable_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.SOFTWARE_PATTERN___KEY_DEFINITION_1:
        return ((InternalEList<?>)getKeyDefinition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.SOFTWARE_PATTERN___CODE_INJECTION_1:
        return ((InternalEList<?>)getCodeInjection_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.SOFTWARE_PATTERN___IS_A1:
        return getIsA_1();
      case UmplePackage.SOFTWARE_PATTERN___SINGLETON_1:
        return getSingleton_1();
      case UmplePackage.SOFTWARE_PATTERN___IMMUTABLE_1:
        return getImmutable_1();
      case UmplePackage.SOFTWARE_PATTERN___KEY_DEFINITION_1:
        return getKeyDefinition_1();
      case UmplePackage.SOFTWARE_PATTERN___CODE_INJECTION_1:
        return getCodeInjection_1();
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
      case UmplePackage.SOFTWARE_PATTERN___IS_A1:
        getIsA_1().clear();
        getIsA_1().addAll((Collection<? extends IsA_>)newValue);
        return;
      case UmplePackage.SOFTWARE_PATTERN___SINGLETON_1:
        getSingleton_1().clear();
        getSingleton_1().addAll((Collection<? extends Singleton_>)newValue);
        return;
      case UmplePackage.SOFTWARE_PATTERN___IMMUTABLE_1:
        getImmutable_1().clear();
        getImmutable_1().addAll((Collection<? extends Immutable_>)newValue);
        return;
      case UmplePackage.SOFTWARE_PATTERN___KEY_DEFINITION_1:
        getKeyDefinition_1().clear();
        getKeyDefinition_1().addAll((Collection<? extends KeyDefinition_>)newValue);
        return;
      case UmplePackage.SOFTWARE_PATTERN___CODE_INJECTION_1:
        getCodeInjection_1().clear();
        getCodeInjection_1().addAll((Collection<? extends CodeInjection_>)newValue);
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
      case UmplePackage.SOFTWARE_PATTERN___IS_A1:
        getIsA_1().clear();
        return;
      case UmplePackage.SOFTWARE_PATTERN___SINGLETON_1:
        getSingleton_1().clear();
        return;
      case UmplePackage.SOFTWARE_PATTERN___IMMUTABLE_1:
        getImmutable_1().clear();
        return;
      case UmplePackage.SOFTWARE_PATTERN___KEY_DEFINITION_1:
        getKeyDefinition_1().clear();
        return;
      case UmplePackage.SOFTWARE_PATTERN___CODE_INJECTION_1:
        getCodeInjection_1().clear();
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
      case UmplePackage.SOFTWARE_PATTERN___IS_A1:
        return isA_1 != null && !isA_1.isEmpty();
      case UmplePackage.SOFTWARE_PATTERN___SINGLETON_1:
        return singleton_1 != null && !singleton_1.isEmpty();
      case UmplePackage.SOFTWARE_PATTERN___IMMUTABLE_1:
        return immutable_1 != null && !immutable_1.isEmpty();
      case UmplePackage.SOFTWARE_PATTERN___KEY_DEFINITION_1:
        return keyDefinition_1 != null && !keyDefinition_1.isEmpty();
      case UmplePackage.SOFTWARE_PATTERN___CODE_INJECTION_1:
        return codeInjection_1 != null && !codeInjection_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SoftwarePattern_Impl
