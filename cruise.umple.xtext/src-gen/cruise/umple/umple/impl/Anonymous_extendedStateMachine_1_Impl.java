/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_extendedStateMachine_1_;
import cruise.umple.umple.Comment_;
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
 * An implementation of the model object '<em><b>Anonymous extended State Machine 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_extendedStateMachine_1_Impl#getComment_1 <em>Comment 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_extendedStateMachine_1_Impl#getChangeType_1 <em>Change Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_extendedStateMachine_1_Impl#getState_1 <em>State 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_extendedStateMachine_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_extendedStateMachine_1_
{
  /**
   * The cached value of the '{@link #getComment_1() <em>Comment 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComment_1()
   * @generated
   * @ordered
   */
  protected EList<Comment_> comment_1;

  /**
   * The default value of the '{@link #getChangeType_1() <em>Change Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangeType_1()
   * @generated
   * @ordered
   */
  protected static final String CHANGE_TYPE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getChangeType_1() <em>Change Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangeType_1()
   * @generated
   * @ordered
   */
  protected String changeType_1 = CHANGE_TYPE_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getState_1() <em>State 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState_1()
   * @generated
   * @ordered
   */
  protected EList<State_> state_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_extendedStateMachine_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_extendedStateMachine_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Comment_> getComment_1()
  {
    if (comment_1 == null)
    {
      comment_1 = new EObjectContainmentEList<Comment_>(Comment_.class, this, UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__COMMENT_1);
    }
    return comment_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getChangeType_1()
  {
    return changeType_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChangeType_1(String newChangeType_1)
  {
    String oldChangeType_1 = changeType_1;
    changeType_1 = newChangeType_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__CHANGE_TYPE_1, oldChangeType_1, changeType_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<State_> getState_1()
  {
    if (state_1 == null)
    {
      state_1 = new EObjectContainmentEList<State_>(State_.class, this, UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__STATE_1);
    }
    return state_1;
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
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__COMMENT_1:
        return ((InternalEList<?>)getComment_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__STATE_1:
        return ((InternalEList<?>)getState_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__COMMENT_1:
        return getComment_1();
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__CHANGE_TYPE_1:
        return getChangeType_1();
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__STATE_1:
        return getState_1();
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
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__COMMENT_1:
        getComment_1().clear();
        getComment_1().addAll((Collection<? extends Comment_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__CHANGE_TYPE_1:
        setChangeType_1((String)newValue);
        return;
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__STATE_1:
        getState_1().clear();
        getState_1().addAll((Collection<? extends State_>)newValue);
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
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__COMMENT_1:
        getComment_1().clear();
        return;
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__CHANGE_TYPE_1:
        setChangeType_1(CHANGE_TYPE_1_EDEFAULT);
        return;
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__STATE_1:
        getState_1().clear();
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
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__COMMENT_1:
        return comment_1 != null && !comment_1.isEmpty();
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__CHANGE_TYPE_1:
        return CHANGE_TYPE_1_EDEFAULT == null ? changeType_1 != null : !CHANGE_TYPE_1_EDEFAULT.equals(changeType_1);
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1__STATE_1:
        return state_1 != null && !state_1.isEmpty();
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
    result.append(" (changeType_1: ");
    result.append(changeType_1);
    result.append(')');
    return result.toString();
  }

} //Anonymous_extendedStateMachine_1_Impl
