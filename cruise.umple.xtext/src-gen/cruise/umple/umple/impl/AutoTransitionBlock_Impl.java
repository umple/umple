/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Action_;
import cruise.umple.umple.AutoTransitionBlock_;
import cruise.umple.umple.Guard_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Auto Transition Block </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AutoTransitionBlock_Impl#getGuard_1 <em>Guard 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AutoTransitionBlock_Impl#getAction_1 <em>Action 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AutoTransitionBlock_Impl#getStateName_1 <em>State Name 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AutoTransitionBlock_Impl extends MinimalEObjectImpl.Container implements AutoTransitionBlock_
{
  /**
   * The cached value of the '{@link #getGuard_1() <em>Guard 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuard_1()
   * @generated
   * @ordered
   */
  protected EList<Guard_> guard_1;

  /**
   * The cached value of the '{@link #getAction_1() <em>Action 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction_1()
   * @generated
   * @ordered
   */
  protected EList<Action_> action_1;

  /**
   * The default value of the '{@link #getStateName_1() <em>State Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateName_1()
   * @generated
   * @ordered
   */
  protected static final String STATE_NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStateName_1() <em>State Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateName_1()
   * @generated
   * @ordered
   */
  protected String stateName_1 = STATE_NAME_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AutoTransitionBlock_Impl()
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
    return UmplePackage.eINSTANCE.getAutoTransitionBlock_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Guard_> getGuard_1()
  {
    if (guard_1 == null)
    {
      guard_1 = new EObjectContainmentEList<Guard_>(Guard_.class, this, UmplePackage.AUTO_TRANSITION_BLOCK___GUARD_1);
    }
    return guard_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Action_> getAction_1()
  {
    if (action_1 == null)
    {
      action_1 = new EObjectContainmentEList<Action_>(Action_.class, this, UmplePackage.AUTO_TRANSITION_BLOCK___ACTION_1);
    }
    return action_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStateName_1()
  {
    return stateName_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateName_1(String newStateName_1)
  {
    String oldStateName_1 = stateName_1;
    stateName_1 = newStateName_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.AUTO_TRANSITION_BLOCK___STATE_NAME_1, oldStateName_1, stateName_1));
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
      case UmplePackage.AUTO_TRANSITION_BLOCK___GUARD_1:
        return ((InternalEList<?>)getGuard_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.AUTO_TRANSITION_BLOCK___ACTION_1:
        return ((InternalEList<?>)getAction_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.AUTO_TRANSITION_BLOCK___GUARD_1:
        return getGuard_1();
      case UmplePackage.AUTO_TRANSITION_BLOCK___ACTION_1:
        return getAction_1();
      case UmplePackage.AUTO_TRANSITION_BLOCK___STATE_NAME_1:
        return getStateName_1();
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
      case UmplePackage.AUTO_TRANSITION_BLOCK___GUARD_1:
        getGuard_1().clear();
        getGuard_1().addAll((Collection<? extends Guard_>)newValue);
        return;
      case UmplePackage.AUTO_TRANSITION_BLOCK___ACTION_1:
        getAction_1().clear();
        getAction_1().addAll((Collection<? extends Action_>)newValue);
        return;
      case UmplePackage.AUTO_TRANSITION_BLOCK___STATE_NAME_1:
        setStateName_1((String)newValue);
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
      case UmplePackage.AUTO_TRANSITION_BLOCK___GUARD_1:
        getGuard_1().clear();
        return;
      case UmplePackage.AUTO_TRANSITION_BLOCK___ACTION_1:
        getAction_1().clear();
        return;
      case UmplePackage.AUTO_TRANSITION_BLOCK___STATE_NAME_1:
        setStateName_1(STATE_NAME_1_EDEFAULT);
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
      case UmplePackage.AUTO_TRANSITION_BLOCK___GUARD_1:
        return guard_1 != null && !guard_1.isEmpty();
      case UmplePackage.AUTO_TRANSITION_BLOCK___ACTION_1:
        return action_1 != null && !action_1.isEmpty();
      case UmplePackage.AUTO_TRANSITION_BLOCK___STATE_NAME_1:
        return STATE_NAME_1_EDEFAULT == null ? stateName_1 != null : !STATE_NAME_1_EDEFAULT.equals(stateName_1);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (stateName_1: ");
    result.append(stateName_1);
    result.append(')');
    return result.toString();
  }

} //AutoTransitionBlock_Impl
