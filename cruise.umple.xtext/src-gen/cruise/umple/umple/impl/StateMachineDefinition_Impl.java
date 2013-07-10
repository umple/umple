/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.StateMachineDefinition_;
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
 * An implementation of the model object '<em><b>State Machine Definition </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.StateMachineDefinition_Impl#isQueued_1 <em>Queued 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateMachineDefinition_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateMachineDefinition_Impl#getState_1 <em>State 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateMachineDefinition_Impl extends MinimalEObjectImpl.Container implements StateMachineDefinition_
{
  /**
   * The default value of the '{@link #isQueued_1() <em>Queued 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isQueued_1()
   * @generated
   * @ordered
   */
  protected static final boolean QUEUED_1_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isQueued_1() <em>Queued 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isQueued_1()
   * @generated
   * @ordered
   */
  protected boolean queued_1 = QUEUED_1_EDEFAULT;

  /**
   * The default value of the '{@link #getName_1() <em>Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName_1()
   * @generated
   * @ordered
   */
  protected static final String NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName_1() <em>Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName_1()
   * @generated
   * @ordered
   */
  protected String name_1 = NAME_1_EDEFAULT;

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
  protected StateMachineDefinition_Impl()
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
    return UmplePackage.eINSTANCE.getStateMachineDefinition_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isQueued_1()
  {
    return queued_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQueued_1(boolean newQueued_1)
  {
    boolean oldQueued_1 = queued_1;
    queued_1 = newQueued_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.STATE_MACHINE_DEFINITION___QUEUED_1, oldQueued_1, queued_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName_1()
  {
    return name_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName_1(String newName_1)
  {
    String oldName_1 = name_1;
    name_1 = newName_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.STATE_MACHINE_DEFINITION___NAME_1, oldName_1, name_1));
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
      state_1 = new EObjectContainmentEList<State_>(State_.class, this, UmplePackage.STATE_MACHINE_DEFINITION___STATE_1);
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
      case UmplePackage.STATE_MACHINE_DEFINITION___STATE_1:
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
      case UmplePackage.STATE_MACHINE_DEFINITION___QUEUED_1:
        return isQueued_1();
      case UmplePackage.STATE_MACHINE_DEFINITION___NAME_1:
        return getName_1();
      case UmplePackage.STATE_MACHINE_DEFINITION___STATE_1:
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
      case UmplePackage.STATE_MACHINE_DEFINITION___QUEUED_1:
        setQueued_1((Boolean)newValue);
        return;
      case UmplePackage.STATE_MACHINE_DEFINITION___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.STATE_MACHINE_DEFINITION___STATE_1:
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
      case UmplePackage.STATE_MACHINE_DEFINITION___QUEUED_1:
        setQueued_1(QUEUED_1_EDEFAULT);
        return;
      case UmplePackage.STATE_MACHINE_DEFINITION___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.STATE_MACHINE_DEFINITION___STATE_1:
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
      case UmplePackage.STATE_MACHINE_DEFINITION___QUEUED_1:
        return queued_1 != QUEUED_1_EDEFAULT;
      case UmplePackage.STATE_MACHINE_DEFINITION___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.STATE_MACHINE_DEFINITION___STATE_1:
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
    result.append(" (queued_1: ");
    result.append(queued_1);
    result.append(", name_1: ");
    result.append(name_1);
    result.append(')');
    return result.toString();
  }

} //StateMachineDefinition_Impl
