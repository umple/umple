/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_parameterList_1_;
import cruise.umple.umple.ParameterList_;
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
 * An implementation of the model object '<em><b>Parameter List </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ParameterList_Impl#getParameter_1 <em>Parameter 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ParameterList_Impl#getAnonymous_parameterList_1_1 <em>Anonymous parameter List 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterList_Impl extends MinimalEObjectImpl.Container implements ParameterList_
{
  /**
   * The cached value of the '{@link #getParameter_1() <em>Parameter 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter_1()
   * @generated
   * @ordered
   */
  protected EList<Parameter_> parameter_1;

  /**
   * The cached value of the '{@link #getAnonymous_parameterList_1_1() <em>Anonymous parameter List 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_parameterList_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_parameterList_1_> anonymous_parameterList_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParameterList_Impl()
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
    return UmplePackage.eINSTANCE.getParameterList_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Parameter_> getParameter_1()
  {
    if (parameter_1 == null)
    {
      parameter_1 = new EObjectContainmentEList<Parameter_>(Parameter_.class, this, UmplePackage.PARAMETER_LIST___PARAMETER_1);
    }
    return parameter_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_parameterList_1_> getAnonymous_parameterList_1_1()
  {
    if (anonymous_parameterList_1_1 == null)
    {
      anonymous_parameterList_1_1 = new EObjectContainmentEList<Anonymous_parameterList_1_>(Anonymous_parameterList_1_.class, this, UmplePackage.PARAMETER_LIST___ANONYMOUS_PARAMETER_LIST_11);
    }
    return anonymous_parameterList_1_1;
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
      case UmplePackage.PARAMETER_LIST___PARAMETER_1:
        return ((InternalEList<?>)getParameter_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.PARAMETER_LIST___ANONYMOUS_PARAMETER_LIST_11:
        return ((InternalEList<?>)getAnonymous_parameterList_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.PARAMETER_LIST___PARAMETER_1:
        return getParameter_1();
      case UmplePackage.PARAMETER_LIST___ANONYMOUS_PARAMETER_LIST_11:
        return getAnonymous_parameterList_1_1();
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
      case UmplePackage.PARAMETER_LIST___PARAMETER_1:
        getParameter_1().clear();
        getParameter_1().addAll((Collection<? extends Parameter_>)newValue);
        return;
      case UmplePackage.PARAMETER_LIST___ANONYMOUS_PARAMETER_LIST_11:
        getAnonymous_parameterList_1_1().clear();
        getAnonymous_parameterList_1_1().addAll((Collection<? extends Anonymous_parameterList_1_>)newValue);
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
      case UmplePackage.PARAMETER_LIST___PARAMETER_1:
        getParameter_1().clear();
        return;
      case UmplePackage.PARAMETER_LIST___ANONYMOUS_PARAMETER_LIST_11:
        getAnonymous_parameterList_1_1().clear();
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
      case UmplePackage.PARAMETER_LIST___PARAMETER_1:
        return parameter_1 != null && !parameter_1.isEmpty();
      case UmplePackage.PARAMETER_LIST___ANONYMOUS_PARAMETER_LIST_11:
        return anonymous_parameterList_1_1 != null && !anonymous_parameterList_1_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ParameterList_Impl
