/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_invariant_1_;
import cruise.umple.umple.Anonymous_invariant_2_;
import cruise.umple.umple.Invariant_;
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
 * An implementation of the model object '<em><b>Invariant </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Invariant_Impl#getAnonymous_invariant_1_1 <em>Anonymous invariant 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Invariant_Impl#getAnonymous_invariant_2_1 <em>Anonymous invariant 21</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Invariant_Impl extends MinimalEObjectImpl.Container implements Invariant_
{
  /**
   * The cached value of the '{@link #getAnonymous_invariant_1_1() <em>Anonymous invariant 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_invariant_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_invariant_1_> anonymous_invariant_1_1;

  /**
   * The cached value of the '{@link #getAnonymous_invariant_2_1() <em>Anonymous invariant 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_invariant_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_invariant_2_> anonymous_invariant_2_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Invariant_Impl()
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
    return UmplePackage.eINSTANCE.getInvariant_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_invariant_1_> getAnonymous_invariant_1_1()
  {
    if (anonymous_invariant_1_1 == null)
    {
      anonymous_invariant_1_1 = new EObjectContainmentEList<Anonymous_invariant_1_>(Anonymous_invariant_1_.class, this, UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_11);
    }
    return anonymous_invariant_1_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_invariant_2_> getAnonymous_invariant_2_1()
  {
    if (anonymous_invariant_2_1 == null)
    {
      anonymous_invariant_2_1 = new EObjectContainmentEList<Anonymous_invariant_2_>(Anonymous_invariant_2_.class, this, UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_21);
    }
    return anonymous_invariant_2_1;
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
      case UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_11:
        return ((InternalEList<?>)getAnonymous_invariant_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_21:
        return ((InternalEList<?>)getAnonymous_invariant_2_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_11:
        return getAnonymous_invariant_1_1();
      case UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_21:
        return getAnonymous_invariant_2_1();
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
      case UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_11:
        getAnonymous_invariant_1_1().clear();
        getAnonymous_invariant_1_1().addAll((Collection<? extends Anonymous_invariant_1_>)newValue);
        return;
      case UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_21:
        getAnonymous_invariant_2_1().clear();
        getAnonymous_invariant_2_1().addAll((Collection<? extends Anonymous_invariant_2_>)newValue);
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
      case UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_11:
        getAnonymous_invariant_1_1().clear();
        return;
      case UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_21:
        getAnonymous_invariant_2_1().clear();
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
      case UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_11:
        return anonymous_invariant_1_1 != null && !anonymous_invariant_1_1.isEmpty();
      case UmplePackage.INVARIANT___ANONYMOUS_INVARIANT_21:
        return anonymous_invariant_2_1 != null && !anonymous_invariant_2_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Invariant_Impl
