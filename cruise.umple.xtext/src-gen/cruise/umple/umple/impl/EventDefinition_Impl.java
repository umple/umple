/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AfterEvent_;
import cruise.umple.umple.AfterEveryEvent_;
import cruise.umple.umple.Anonymous_eventDefinition_1_;
import cruise.umple.umple.EventDefinition_;
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
 * An implementation of the model object '<em><b>Event Definition </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.EventDefinition_Impl#getAfterEveryEvent_1 <em>After Every Event 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.EventDefinition_Impl#getAfterEvent_1 <em>After Event 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.EventDefinition_Impl#getEvent_1 <em>Event 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.EventDefinition_Impl#getAnonymous_eventDefinition_1_1 <em>Anonymous event Definition 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventDefinition_Impl extends MinimalEObjectImpl.Container implements EventDefinition_
{
  /**
   * The cached value of the '{@link #getAfterEveryEvent_1() <em>After Every Event 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAfterEveryEvent_1()
   * @generated
   * @ordered
   */
  protected EList<AfterEveryEvent_> afterEveryEvent_1;

  /**
   * The cached value of the '{@link #getAfterEvent_1() <em>After Event 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAfterEvent_1()
   * @generated
   * @ordered
   */
  protected EList<AfterEvent_> afterEvent_1;

  /**
   * The default value of the '{@link #getEvent_1() <em>Event 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvent_1()
   * @generated
   * @ordered
   */
  protected static final String EVENT_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEvent_1() <em>Event 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvent_1()
   * @generated
   * @ordered
   */
  protected String event_1 = EVENT_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_eventDefinition_1_1() <em>Anonymous event Definition 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_eventDefinition_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_eventDefinition_1_> anonymous_eventDefinition_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventDefinition_Impl()
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
    return UmplePackage.eINSTANCE.getEventDefinition_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AfterEveryEvent_> getAfterEveryEvent_1()
  {
    if (afterEveryEvent_1 == null)
    {
      afterEveryEvent_1 = new EObjectContainmentEList<AfterEveryEvent_>(AfterEveryEvent_.class, this, UmplePackage.EVENT_DEFINITION___AFTER_EVERY_EVENT_1);
    }
    return afterEveryEvent_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AfterEvent_> getAfterEvent_1()
  {
    if (afterEvent_1 == null)
    {
      afterEvent_1 = new EObjectContainmentEList<AfterEvent_>(AfterEvent_.class, this, UmplePackage.EVENT_DEFINITION___AFTER_EVENT_1);
    }
    return afterEvent_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEvent_1()
  {
    return event_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEvent_1(String newEvent_1)
  {
    String oldEvent_1 = event_1;
    event_1 = newEvent_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EVENT_DEFINITION___EVENT_1, oldEvent_1, event_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_eventDefinition_1_> getAnonymous_eventDefinition_1_1()
  {
    if (anonymous_eventDefinition_1_1 == null)
    {
      anonymous_eventDefinition_1_1 = new EObjectContainmentEList<Anonymous_eventDefinition_1_>(Anonymous_eventDefinition_1_.class, this, UmplePackage.EVENT_DEFINITION___ANONYMOUS_EVENT_DEFINITION_11);
    }
    return anonymous_eventDefinition_1_1;
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
      case UmplePackage.EVENT_DEFINITION___AFTER_EVERY_EVENT_1:
        return ((InternalEList<?>)getAfterEveryEvent_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.EVENT_DEFINITION___AFTER_EVENT_1:
        return ((InternalEList<?>)getAfterEvent_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.EVENT_DEFINITION___ANONYMOUS_EVENT_DEFINITION_11:
        return ((InternalEList<?>)getAnonymous_eventDefinition_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.EVENT_DEFINITION___AFTER_EVERY_EVENT_1:
        return getAfterEveryEvent_1();
      case UmplePackage.EVENT_DEFINITION___AFTER_EVENT_1:
        return getAfterEvent_1();
      case UmplePackage.EVENT_DEFINITION___EVENT_1:
        return getEvent_1();
      case UmplePackage.EVENT_DEFINITION___ANONYMOUS_EVENT_DEFINITION_11:
        return getAnonymous_eventDefinition_1_1();
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
      case UmplePackage.EVENT_DEFINITION___AFTER_EVERY_EVENT_1:
        getAfterEveryEvent_1().clear();
        getAfterEveryEvent_1().addAll((Collection<? extends AfterEveryEvent_>)newValue);
        return;
      case UmplePackage.EVENT_DEFINITION___AFTER_EVENT_1:
        getAfterEvent_1().clear();
        getAfterEvent_1().addAll((Collection<? extends AfterEvent_>)newValue);
        return;
      case UmplePackage.EVENT_DEFINITION___EVENT_1:
        setEvent_1((String)newValue);
        return;
      case UmplePackage.EVENT_DEFINITION___ANONYMOUS_EVENT_DEFINITION_11:
        getAnonymous_eventDefinition_1_1().clear();
        getAnonymous_eventDefinition_1_1().addAll((Collection<? extends Anonymous_eventDefinition_1_>)newValue);
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
      case UmplePackage.EVENT_DEFINITION___AFTER_EVERY_EVENT_1:
        getAfterEveryEvent_1().clear();
        return;
      case UmplePackage.EVENT_DEFINITION___AFTER_EVENT_1:
        getAfterEvent_1().clear();
        return;
      case UmplePackage.EVENT_DEFINITION___EVENT_1:
        setEvent_1(EVENT_1_EDEFAULT);
        return;
      case UmplePackage.EVENT_DEFINITION___ANONYMOUS_EVENT_DEFINITION_11:
        getAnonymous_eventDefinition_1_1().clear();
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
      case UmplePackage.EVENT_DEFINITION___AFTER_EVERY_EVENT_1:
        return afterEveryEvent_1 != null && !afterEveryEvent_1.isEmpty();
      case UmplePackage.EVENT_DEFINITION___AFTER_EVENT_1:
        return afterEvent_1 != null && !afterEvent_1.isEmpty();
      case UmplePackage.EVENT_DEFINITION___EVENT_1:
        return EVENT_1_EDEFAULT == null ? event_1 != null : !EVENT_1_EDEFAULT.equals(event_1);
      case UmplePackage.EVENT_DEFINITION___ANONYMOUS_EVENT_DEFINITION_11:
        return anonymous_eventDefinition_1_1 != null && !anonymous_eventDefinition_1_1.isEmpty();
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
    result.append(" (event_1: ");
    result.append(event_1);
    result.append(')');
    return result.toString();
  }

} //EventDefinition_Impl
