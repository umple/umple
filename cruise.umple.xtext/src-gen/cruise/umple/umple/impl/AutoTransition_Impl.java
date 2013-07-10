/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Activity_;
import cruise.umple.umple.AutoTransitionBlock_;
import cruise.umple.umple.AutoTransition_;
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
 * An implementation of the model object '<em><b>Auto Transition </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AutoTransition_Impl#getAutoTransitionBlock_1 <em>Auto Transition Block 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AutoTransition_Impl#getActivity_1 <em>Activity 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AutoTransition_Impl extends MinimalEObjectImpl.Container implements AutoTransition_
{
  /**
   * The cached value of the '{@link #getAutoTransitionBlock_1() <em>Auto Transition Block 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAutoTransitionBlock_1()
   * @generated
   * @ordered
   */
  protected EList<AutoTransitionBlock_> autoTransitionBlock_1;

  /**
   * The cached value of the '{@link #getActivity_1() <em>Activity 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivity_1()
   * @generated
   * @ordered
   */
  protected EList<Activity_> activity_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AutoTransition_Impl()
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
    return UmplePackage.eINSTANCE.getAutoTransition_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AutoTransitionBlock_> getAutoTransitionBlock_1()
  {
    if (autoTransitionBlock_1 == null)
    {
      autoTransitionBlock_1 = new EObjectContainmentEList<AutoTransitionBlock_>(AutoTransitionBlock_.class, this, UmplePackage.AUTO_TRANSITION___AUTO_TRANSITION_BLOCK_1);
    }
    return autoTransitionBlock_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Activity_> getActivity_1()
  {
    if (activity_1 == null)
    {
      activity_1 = new EObjectContainmentEList<Activity_>(Activity_.class, this, UmplePackage.AUTO_TRANSITION___ACTIVITY_1);
    }
    return activity_1;
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
      case UmplePackage.AUTO_TRANSITION___AUTO_TRANSITION_BLOCK_1:
        return ((InternalEList<?>)getAutoTransitionBlock_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.AUTO_TRANSITION___ACTIVITY_1:
        return ((InternalEList<?>)getActivity_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.AUTO_TRANSITION___AUTO_TRANSITION_BLOCK_1:
        return getAutoTransitionBlock_1();
      case UmplePackage.AUTO_TRANSITION___ACTIVITY_1:
        return getActivity_1();
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
      case UmplePackage.AUTO_TRANSITION___AUTO_TRANSITION_BLOCK_1:
        getAutoTransitionBlock_1().clear();
        getAutoTransitionBlock_1().addAll((Collection<? extends AutoTransitionBlock_>)newValue);
        return;
      case UmplePackage.AUTO_TRANSITION___ACTIVITY_1:
        getActivity_1().clear();
        getActivity_1().addAll((Collection<? extends Activity_>)newValue);
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
      case UmplePackage.AUTO_TRANSITION___AUTO_TRANSITION_BLOCK_1:
        getAutoTransitionBlock_1().clear();
        return;
      case UmplePackage.AUTO_TRANSITION___ACTIVITY_1:
        getActivity_1().clear();
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
      case UmplePackage.AUTO_TRANSITION___AUTO_TRANSITION_BLOCK_1:
        return autoTransitionBlock_1 != null && !autoTransitionBlock_1.isEmpty();
      case UmplePackage.AUTO_TRANSITION___ACTIVITY_1:
        return activity_1 != null && !activity_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AutoTransition_Impl
