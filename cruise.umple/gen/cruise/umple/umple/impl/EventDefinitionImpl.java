/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.EventDefinition;
import cruise.umple.umple.Guard;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.EventDefinitionImpl#getG <em>G</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.EventDefinitionImpl#getEventID <em>Event ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventDefinitionImpl extends TransitionImpl implements EventDefinition
{
  /**
   * The cached value of the '{@link #getG() <em>G</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getG()
   * @generated
   * @ordered
   */
  protected Guard g;

  /**
   * The default value of the '{@link #getEventID() <em>Event ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEventID()
   * @generated
   * @ordered
   */
  protected static final String EVENT_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEventID() <em>Event ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEventID()
   * @generated
   * @ordered
   */
  protected String eventID = EVENT_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventDefinitionImpl()
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
    return UmplePackage.Literals.EVENT_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Guard getG()
  {
    return g;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetG(Guard newG, NotificationChain msgs)
  {
    Guard oldG = g;
    g = newG;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EVENT_DEFINITION__G, oldG, newG);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setG(Guard newG)
  {
    if (newG != g)
    {
      NotificationChain msgs = null;
      if (g != null)
        msgs = ((InternalEObject)g).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EVENT_DEFINITION__G, null, msgs);
      if (newG != null)
        msgs = ((InternalEObject)newG).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EVENT_DEFINITION__G, null, msgs);
      msgs = basicSetG(newG, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EVENT_DEFINITION__G, newG, newG));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEventID()
  {
    return eventID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEventID(String newEventID)
  {
    String oldEventID = eventID;
    eventID = newEventID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EVENT_DEFINITION__EVENT_ID, oldEventID, eventID));
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
      case UmplePackage.EVENT_DEFINITION__G:
        return basicSetG(null, msgs);
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
      case UmplePackage.EVENT_DEFINITION__G:
        return getG();
      case UmplePackage.EVENT_DEFINITION__EVENT_ID:
        return getEventID();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UmplePackage.EVENT_DEFINITION__G:
        setG((Guard)newValue);
        return;
      case UmplePackage.EVENT_DEFINITION__EVENT_ID:
        setEventID((String)newValue);
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
      case UmplePackage.EVENT_DEFINITION__G:
        setG((Guard)null);
        return;
      case UmplePackage.EVENT_DEFINITION__EVENT_ID:
        setEventID(EVENT_ID_EDEFAULT);
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
      case UmplePackage.EVENT_DEFINITION__G:
        return g != null;
      case UmplePackage.EVENT_DEFINITION__EVENT_ID:
        return EVENT_ID_EDEFAULT == null ? eventID != null : !EVENT_ID_EDEFAULT.equals(eventID);
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
    result.append(" (eventID: ");
    result.append(eventID);
    result.append(')');
    return result.toString();
  }

} //EventDefinitionImpl
