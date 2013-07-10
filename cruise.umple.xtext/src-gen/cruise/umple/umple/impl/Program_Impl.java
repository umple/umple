/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_program_1_;
import cruise.umple.umple.Program_;
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
 * An implementation of the model object '<em><b>Program </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Program_Impl#getAnonymous_program_1_1 <em>Anonymous program 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Program_Impl extends MinimalEObjectImpl.Container implements Program_
{
  /**
   * The cached value of the '{@link #getAnonymous_program_1_1() <em>Anonymous program 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_program_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_program_1_> anonymous_program_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Program_Impl()
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
    return UmplePackage.eINSTANCE.getProgram_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_program_1_> getAnonymous_program_1_1()
  {
    if (anonymous_program_1_1 == null)
    {
      anonymous_program_1_1 = new EObjectContainmentEList<Anonymous_program_1_>(Anonymous_program_1_.class, this, UmplePackage.PROGRAM___ANONYMOUS_PROGRAM_11);
    }
    return anonymous_program_1_1;
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
      case UmplePackage.PROGRAM___ANONYMOUS_PROGRAM_11:
        return ((InternalEList<?>)getAnonymous_program_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.PROGRAM___ANONYMOUS_PROGRAM_11:
        return getAnonymous_program_1_1();
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
      case UmplePackage.PROGRAM___ANONYMOUS_PROGRAM_11:
        getAnonymous_program_1_1().clear();
        getAnonymous_program_1_1().addAll((Collection<? extends Anonymous_program_1_>)newValue);
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
      case UmplePackage.PROGRAM___ANONYMOUS_PROGRAM_11:
        getAnonymous_program_1_1().clear();
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
      case UmplePackage.PROGRAM___ANONYMOUS_PROGRAM_11:
        return anonymous_program_1_1 != null && !anonymous_program_1_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Program_Impl
