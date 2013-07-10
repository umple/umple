/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_strictness_1_;
import cruise.umple.umple.Strictness_;
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
 * An implementation of the model object '<em><b>Strictness </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Strictness_Impl#getAnonymous_strictness_1_1 <em>Anonymous strictness 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Strictness_Impl extends MinimalEObjectImpl.Container implements Strictness_
{
  /**
   * The cached value of the '{@link #getAnonymous_strictness_1_1() <em>Anonymous strictness 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_strictness_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_strictness_1_> anonymous_strictness_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Strictness_Impl()
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
    return UmplePackage.eINSTANCE.getStrictness_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_strictness_1_> getAnonymous_strictness_1_1()
  {
    if (anonymous_strictness_1_1 == null)
    {
      anonymous_strictness_1_1 = new EObjectContainmentEList<Anonymous_strictness_1_>(Anonymous_strictness_1_.class, this, UmplePackage.STRICTNESS___ANONYMOUS_STRICTNESS_11);
    }
    return anonymous_strictness_1_1;
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
      case UmplePackage.STRICTNESS___ANONYMOUS_STRICTNESS_11:
        return ((InternalEList<?>)getAnonymous_strictness_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.STRICTNESS___ANONYMOUS_STRICTNESS_11:
        return getAnonymous_strictness_1_1();
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
      case UmplePackage.STRICTNESS___ANONYMOUS_STRICTNESS_11:
        getAnonymous_strictness_1_1().clear();
        getAnonymous_strictness_1_1().addAll((Collection<? extends Anonymous_strictness_1_>)newValue);
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
      case UmplePackage.STRICTNESS___ANONYMOUS_STRICTNESS_11:
        getAnonymous_strictness_1_1().clear();
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
      case UmplePackage.STRICTNESS___ANONYMOUS_STRICTNESS_11:
        return anonymous_strictness_1_1 != null && !anonymous_strictness_1_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Strictness_Impl
