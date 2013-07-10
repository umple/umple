/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_state_1_;
import cruise.umple.umple.StateInternal_;
import cruise.umple.umple.State_;
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
 * An implementation of the model object '<em><b>State </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.State_Impl#getStateName_1 <em>State Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.State_Impl#getStateInternal_1 <em>State Internal 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.State_Impl#isFinal_1 <em>Final 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.State_Impl#getAnonymous_state_1_1 <em>Anonymous state 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class State_Impl extends MinimalEObjectImpl.Container implements State_
{
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
   * The cached value of the '{@link #getStateInternal_1() <em>State Internal 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateInternal_1()
   * @generated
   * @ordered
   */
  protected EList<StateInternal_> stateInternal_1;

  /**
   * The default value of the '{@link #isFinal_1() <em>Final 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFinal_1()
   * @generated
   * @ordered
   */
  protected static final boolean FINAL_1_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFinal_1() <em>Final 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFinal_1()
   * @generated
   * @ordered
   */
  protected boolean final_1 = FINAL_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_state_1_1() <em>Anonymous state 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_state_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_state_1_> anonymous_state_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected State_Impl()
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
    return UmplePackage.eINSTANCE.getState_();
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.STATE___STATE_NAME_1, oldStateName_1, stateName_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StateInternal_> getStateInternal_1()
  {
    if (stateInternal_1 == null)
    {
      stateInternal_1 = new EObjectContainmentEList<StateInternal_>(StateInternal_.class, this, UmplePackage.STATE___STATE_INTERNAL_1);
    }
    return stateInternal_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFinal_1()
  {
    return final_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFinal_1(boolean newFinal_1)
  {
    boolean oldFinal_1 = final_1;
    final_1 = newFinal_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.STATE___FINAL_1, oldFinal_1, final_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_state_1_> getAnonymous_state_1_1()
  {
    if (anonymous_state_1_1 == null)
    {
      anonymous_state_1_1 = new EObjectContainmentEList<Anonymous_state_1_>(Anonymous_state_1_.class, this, UmplePackage.STATE___ANONYMOUS_STATE_11);
    }
    return anonymous_state_1_1;
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
      case UmplePackage.STATE___STATE_INTERNAL_1:
        return ((InternalEList<?>)getStateInternal_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.STATE___ANONYMOUS_STATE_11:
        return ((InternalEList<?>)getAnonymous_state_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.STATE___STATE_NAME_1:
        return getStateName_1();
      case UmplePackage.STATE___STATE_INTERNAL_1:
        return getStateInternal_1();
      case UmplePackage.STATE___FINAL_1:
        return isFinal_1();
      case UmplePackage.STATE___ANONYMOUS_STATE_11:
        return getAnonymous_state_1_1();
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
      case UmplePackage.STATE___STATE_NAME_1:
        setStateName_1((String)newValue);
        return;
      case UmplePackage.STATE___STATE_INTERNAL_1:
        getStateInternal_1().clear();
        getStateInternal_1().addAll((Collection<? extends StateInternal_>)newValue);
        return;
      case UmplePackage.STATE___FINAL_1:
        setFinal_1((Boolean)newValue);
        return;
      case UmplePackage.STATE___ANONYMOUS_STATE_11:
        getAnonymous_state_1_1().clear();
        getAnonymous_state_1_1().addAll((Collection<? extends Anonymous_state_1_>)newValue);
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
      case UmplePackage.STATE___STATE_NAME_1:
        setStateName_1(STATE_NAME_1_EDEFAULT);
        return;
      case UmplePackage.STATE___STATE_INTERNAL_1:
        getStateInternal_1().clear();
        return;
      case UmplePackage.STATE___FINAL_1:
        setFinal_1(FINAL_1_EDEFAULT);
        return;
      case UmplePackage.STATE___ANONYMOUS_STATE_11:
        getAnonymous_state_1_1().clear();
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
      case UmplePackage.STATE___STATE_NAME_1:
        return STATE_NAME_1_EDEFAULT == null ? stateName_1 != null : !STATE_NAME_1_EDEFAULT.equals(stateName_1);
      case UmplePackage.STATE___STATE_INTERNAL_1:
        return stateInternal_1 != null && !stateInternal_1.isEmpty();
      case UmplePackage.STATE___FINAL_1:
        return final_1 != FINAL_1_EDEFAULT;
      case UmplePackage.STATE___ANONYMOUS_STATE_11:
        return anonymous_state_1_1 != null && !anonymous_state_1_1.isEmpty();
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
    result.append(", final_1: ");
    result.append(final_1);
    result.append(')');
    return result.toString();
  }

} //State_Impl
