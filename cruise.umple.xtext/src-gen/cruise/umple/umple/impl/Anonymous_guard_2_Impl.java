/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_guard_2_;
import cruise.umple.umple.MoreGuards_;
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
 * An implementation of the model object '<em><b>Anonymous guard 2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_guard_2_Impl#getMoreGuards_1 <em>More Guards 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_guard_2_Impl extends MinimalEObjectImpl.Container implements Anonymous_guard_2_
{
  /**
   * The cached value of the '{@link #getMoreGuards_1() <em>More Guards 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMoreGuards_1()
   * @generated
   * @ordered
   */
  protected EList<MoreGuards_> moreGuards_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_guard_2_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_guard_2_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MoreGuards_> getMoreGuards_1()
  {
    if (moreGuards_1 == null)
    {
      moreGuards_1 = new EObjectContainmentEList<MoreGuards_>(MoreGuards_.class, this, UmplePackage.ANONYMOUS_GUARD_2__MORE_GUARDS_1);
    }
    return moreGuards_1;
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
      case UmplePackage.ANONYMOUS_GUARD_2__MORE_GUARDS_1:
        return ((InternalEList<?>)getMoreGuards_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_GUARD_2__MORE_GUARDS_1:
        return getMoreGuards_1();
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
      case UmplePackage.ANONYMOUS_GUARD_2__MORE_GUARDS_1:
        getMoreGuards_1().clear();
        getMoreGuards_1().addAll((Collection<? extends MoreGuards_>)newValue);
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
      case UmplePackage.ANONYMOUS_GUARD_2__MORE_GUARDS_1:
        getMoreGuards_1().clear();
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
      case UmplePackage.ANONYMOUS_GUARD_2__MORE_GUARDS_1:
        return moreGuards_1 != null && !moreGuards_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_guard_2_Impl
