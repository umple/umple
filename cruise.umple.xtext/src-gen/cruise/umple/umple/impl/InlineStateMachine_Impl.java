/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_inlineStateMachine_1_;
import cruise.umple.umple.InlineStateMachine_;
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
 * An implementation of the model object '<em><b>Inline State Machine </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.InlineStateMachine_Impl#isQueued_1 <em>Queued 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InlineStateMachine_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InlineStateMachine_Impl#getAnonymous_inlineStateMachine_1_1 <em>Anonymous inline State Machine 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InlineStateMachine_Impl extends MinimalEObjectImpl.Container implements InlineStateMachine_
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
   * The cached value of the '{@link #getAnonymous_inlineStateMachine_1_1() <em>Anonymous inline State Machine 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_inlineStateMachine_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_inlineStateMachine_1_> anonymous_inlineStateMachine_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InlineStateMachine_Impl()
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
    return UmplePackage.eINSTANCE.getInlineStateMachine_();
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.INLINE_STATE_MACHINE___QUEUED_1, oldQueued_1, queued_1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.INLINE_STATE_MACHINE___NAME_1, oldName_1, name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_inlineStateMachine_1_> getAnonymous_inlineStateMachine_1_1()
  {
    if (anonymous_inlineStateMachine_1_1 == null)
    {
      anonymous_inlineStateMachine_1_1 = new EObjectContainmentEList<Anonymous_inlineStateMachine_1_>(Anonymous_inlineStateMachine_1_.class, this, UmplePackage.INLINE_STATE_MACHINE___ANONYMOUS_INLINE_STATE_MACHINE_11);
    }
    return anonymous_inlineStateMachine_1_1;
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
      case UmplePackage.INLINE_STATE_MACHINE___ANONYMOUS_INLINE_STATE_MACHINE_11:
        return ((InternalEList<?>)getAnonymous_inlineStateMachine_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.INLINE_STATE_MACHINE___QUEUED_1:
        return isQueued_1();
      case UmplePackage.INLINE_STATE_MACHINE___NAME_1:
        return getName_1();
      case UmplePackage.INLINE_STATE_MACHINE___ANONYMOUS_INLINE_STATE_MACHINE_11:
        return getAnonymous_inlineStateMachine_1_1();
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
      case UmplePackage.INLINE_STATE_MACHINE___QUEUED_1:
        setQueued_1((Boolean)newValue);
        return;
      case UmplePackage.INLINE_STATE_MACHINE___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.INLINE_STATE_MACHINE___ANONYMOUS_INLINE_STATE_MACHINE_11:
        getAnonymous_inlineStateMachine_1_1().clear();
        getAnonymous_inlineStateMachine_1_1().addAll((Collection<? extends Anonymous_inlineStateMachine_1_>)newValue);
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
      case UmplePackage.INLINE_STATE_MACHINE___QUEUED_1:
        setQueued_1(QUEUED_1_EDEFAULT);
        return;
      case UmplePackage.INLINE_STATE_MACHINE___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.INLINE_STATE_MACHINE___ANONYMOUS_INLINE_STATE_MACHINE_11:
        getAnonymous_inlineStateMachine_1_1().clear();
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
      case UmplePackage.INLINE_STATE_MACHINE___QUEUED_1:
        return queued_1 != QUEUED_1_EDEFAULT;
      case UmplePackage.INLINE_STATE_MACHINE___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.INLINE_STATE_MACHINE___ANONYMOUS_INLINE_STATE_MACHINE_11:
        return anonymous_inlineStateMachine_1_1 != null && !anonymous_inlineStateMachine_1_1.isEmpty();
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

} //InlineStateMachine_Impl
