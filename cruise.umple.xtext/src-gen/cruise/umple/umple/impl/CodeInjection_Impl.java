/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AfterCode_;
import cruise.umple.umple.BeforeCode_;
import cruise.umple.umple.CodeInjection_;
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
 * An implementation of the model object '<em><b>Code Injection </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.CodeInjection_Impl#getBeforeCode_1 <em>Before Code 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.CodeInjection_Impl#getAfterCode_1 <em>After Code 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodeInjection_Impl extends MinimalEObjectImpl.Container implements CodeInjection_
{
  /**
   * The cached value of the '{@link #getBeforeCode_1() <em>Before Code 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBeforeCode_1()
   * @generated
   * @ordered
   */
  protected EList<BeforeCode_> beforeCode_1;

  /**
   * The cached value of the '{@link #getAfterCode_1() <em>After Code 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAfterCode_1()
   * @generated
   * @ordered
   */
  protected EList<AfterCode_> afterCode_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CodeInjection_Impl()
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
    return UmplePackage.eINSTANCE.getCodeInjection_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<BeforeCode_> getBeforeCode_1()
  {
    if (beforeCode_1 == null)
    {
      beforeCode_1 = new EObjectContainmentEList<BeforeCode_>(BeforeCode_.class, this, UmplePackage.CODE_INJECTION___BEFORE_CODE_1);
    }
    return beforeCode_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AfterCode_> getAfterCode_1()
  {
    if (afterCode_1 == null)
    {
      afterCode_1 = new EObjectContainmentEList<AfterCode_>(AfterCode_.class, this, UmplePackage.CODE_INJECTION___AFTER_CODE_1);
    }
    return afterCode_1;
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
      case UmplePackage.CODE_INJECTION___BEFORE_CODE_1:
        return ((InternalEList<?>)getBeforeCode_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CODE_INJECTION___AFTER_CODE_1:
        return ((InternalEList<?>)getAfterCode_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.CODE_INJECTION___BEFORE_CODE_1:
        return getBeforeCode_1();
      case UmplePackage.CODE_INJECTION___AFTER_CODE_1:
        return getAfterCode_1();
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
      case UmplePackage.CODE_INJECTION___BEFORE_CODE_1:
        getBeforeCode_1().clear();
        getBeforeCode_1().addAll((Collection<? extends BeforeCode_>)newValue);
        return;
      case UmplePackage.CODE_INJECTION___AFTER_CODE_1:
        getAfterCode_1().clear();
        getAfterCode_1().addAll((Collection<? extends AfterCode_>)newValue);
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
      case UmplePackage.CODE_INJECTION___BEFORE_CODE_1:
        getBeforeCode_1().clear();
        return;
      case UmplePackage.CODE_INJECTION___AFTER_CODE_1:
        getAfterCode_1().clear();
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
      case UmplePackage.CODE_INJECTION___BEFORE_CODE_1:
        return beforeCode_1 != null && !beforeCode_1.isEmpty();
      case UmplePackage.CODE_INJECTION___AFTER_CODE_1:
        return afterCode_1 != null && !afterCode_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CodeInjection_Impl
