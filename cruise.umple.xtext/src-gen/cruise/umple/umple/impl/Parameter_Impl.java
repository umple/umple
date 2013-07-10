/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_parameter_1_;
import cruise.umple.umple.Parameter_;
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
 * An implementation of the model object '<em><b>Parameter </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Parameter_Impl#getAnonymous_parameter_1_1 <em>Anonymous parameter 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Parameter_Impl extends MinimalEObjectImpl.Container implements Parameter_
{
  /**
   * The cached value of the '{@link #getAnonymous_parameter_1_1() <em>Anonymous parameter 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_parameter_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_parameter_1_> anonymous_parameter_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Parameter_Impl()
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
    return UmplePackage.eINSTANCE.getParameter_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_parameter_1_> getAnonymous_parameter_1_1()
  {
    if (anonymous_parameter_1_1 == null)
    {
      anonymous_parameter_1_1 = new EObjectContainmentEList<Anonymous_parameter_1_>(Anonymous_parameter_1_.class, this, UmplePackage.PARAMETER___ANONYMOUS_PARAMETER_11);
    }
    return anonymous_parameter_1_1;
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
      case UmplePackage.PARAMETER___ANONYMOUS_PARAMETER_11:
        return ((InternalEList<?>)getAnonymous_parameter_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.PARAMETER___ANONYMOUS_PARAMETER_11:
        return getAnonymous_parameter_1_1();
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
      case UmplePackage.PARAMETER___ANONYMOUS_PARAMETER_11:
        getAnonymous_parameter_1_1().clear();
        getAnonymous_parameter_1_1().addAll((Collection<? extends Anonymous_parameter_1_>)newValue);
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
      case UmplePackage.PARAMETER___ANONYMOUS_PARAMETER_11:
        getAnonymous_parameter_1_1().clear();
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
      case UmplePackage.PARAMETER___ANONYMOUS_PARAMETER_11:
        return anonymous_parameter_1_1 != null && !anonymous_parameter_1_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Parameter_Impl
