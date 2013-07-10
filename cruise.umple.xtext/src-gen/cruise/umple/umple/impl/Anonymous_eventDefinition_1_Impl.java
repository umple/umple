/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_eventDefinition_1_;
import cruise.umple.umple.ParameterList_;
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
 * An implementation of the model object '<em><b>Anonymous event Definition 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_eventDefinition_1_Impl#getParameterList_1 <em>Parameter List 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_eventDefinition_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_eventDefinition_1_
{
  /**
   * The cached value of the '{@link #getParameterList_1() <em>Parameter List 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterList_1()
   * @generated
   * @ordered
   */
  protected EList<ParameterList_> parameterList_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_eventDefinition_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_eventDefinition_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterList_> getParameterList_1()
  {
    if (parameterList_1 == null)
    {
      parameterList_1 = new EObjectContainmentEList<ParameterList_>(ParameterList_.class, this, UmplePackage.ANONYMOUS_EVENT_DEFINITION_1__PARAMETER_LIST_1);
    }
    return parameterList_1;
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
      case UmplePackage.ANONYMOUS_EVENT_DEFINITION_1__PARAMETER_LIST_1:
        return ((InternalEList<?>)getParameterList_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_EVENT_DEFINITION_1__PARAMETER_LIST_1:
        return getParameterList_1();
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
      case UmplePackage.ANONYMOUS_EVENT_DEFINITION_1__PARAMETER_LIST_1:
        getParameterList_1().clear();
        getParameterList_1().addAll((Collection<? extends ParameterList_>)newValue);
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
      case UmplePackage.ANONYMOUS_EVENT_DEFINITION_1__PARAMETER_LIST_1:
        getParameterList_1().clear();
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
      case UmplePackage.ANONYMOUS_EVENT_DEFINITION_1__PARAMETER_LIST_1:
        return parameterList_1 != null && !parameterList_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_eventDefinition_1_Impl
