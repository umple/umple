/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_afterCode_2_;
import cruise.umple.umple.MoreCode_;
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
 * An implementation of the model object '<em><b>Anonymous after Code 2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_afterCode_2_Impl#getMoreCode_1 <em>More Code 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_afterCode_2_Impl extends MinimalEObjectImpl.Container implements Anonymous_afterCode_2_
{
  /**
   * The cached value of the '{@link #getMoreCode_1() <em>More Code 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMoreCode_1()
   * @generated
   * @ordered
   */
  protected EList<MoreCode_> moreCode_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_afterCode_2_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_afterCode_2_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MoreCode_> getMoreCode_1()
  {
    if (moreCode_1 == null)
    {
      moreCode_1 = new EObjectContainmentEList<MoreCode_>(MoreCode_.class, this, UmplePackage.ANONYMOUS_AFTER_CODE_2__MORE_CODE_1);
    }
    return moreCode_1;
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
      case UmplePackage.ANONYMOUS_AFTER_CODE_2__MORE_CODE_1:
        return ((InternalEList<?>)getMoreCode_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_AFTER_CODE_2__MORE_CODE_1:
        return getMoreCode_1();
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
      case UmplePackage.ANONYMOUS_AFTER_CODE_2__MORE_CODE_1:
        getMoreCode_1().clear();
        getMoreCode_1().addAll((Collection<? extends MoreCode_>)newValue);
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
      case UmplePackage.ANONYMOUS_AFTER_CODE_2__MORE_CODE_1:
        getMoreCode_1().clear();
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
      case UmplePackage.ANONYMOUS_AFTER_CODE_2__MORE_CODE_1:
        return moreCode_1 != null && !moreCode_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_afterCode_2_Impl
