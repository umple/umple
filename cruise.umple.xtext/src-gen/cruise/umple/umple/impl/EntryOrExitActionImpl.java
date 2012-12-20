/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.EntryOrExitAction;
import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.block;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Or Exit Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.EntryOrExitActionImpl#getType <em>Type</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.EntryOrExitActionImpl#getActionCode <em>Action Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryOrExitActionImpl extends StateEntityImpl implements EntryOrExitAction
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getActionCode() <em>Action Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActionCode()
   * @generated
   * @ordered
   */
  protected block actionCode;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntryOrExitActionImpl()
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
    return UmplePackage.Literals.ENTRY_OR_EXIT_ACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ENTRY_OR_EXIT_ACTION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public block getActionCode()
  {
    return actionCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActionCode(block newActionCode, NotificationChain msgs)
  {
    block oldActionCode = actionCode;
    actionCode = newActionCode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.ENTRY_OR_EXIT_ACTION__ACTION_CODE, oldActionCode, newActionCode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActionCode(block newActionCode)
  {
    if (newActionCode != actionCode)
    {
      NotificationChain msgs = null;
      if (actionCode != null)
        msgs = ((InternalEObject)actionCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.ENTRY_OR_EXIT_ACTION__ACTION_CODE, null, msgs);
      if (newActionCode != null)
        msgs = ((InternalEObject)newActionCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.ENTRY_OR_EXIT_ACTION__ACTION_CODE, null, msgs);
      msgs = basicSetActionCode(newActionCode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ENTRY_OR_EXIT_ACTION__ACTION_CODE, newActionCode, newActionCode));
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
      case UmplePackage.ENTRY_OR_EXIT_ACTION__ACTION_CODE:
        return basicSetActionCode(null, msgs);
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
      case UmplePackage.ENTRY_OR_EXIT_ACTION__TYPE:
        return getType();
      case UmplePackage.ENTRY_OR_EXIT_ACTION__ACTION_CODE:
        return getActionCode();
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
      case UmplePackage.ENTRY_OR_EXIT_ACTION__TYPE:
        setType((String)newValue);
        return;
      case UmplePackage.ENTRY_OR_EXIT_ACTION__ACTION_CODE:
        setActionCode((block)newValue);
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
      case UmplePackage.ENTRY_OR_EXIT_ACTION__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case UmplePackage.ENTRY_OR_EXIT_ACTION__ACTION_CODE:
        setActionCode((block)null);
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
      case UmplePackage.ENTRY_OR_EXIT_ACTION__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case UmplePackage.ENTRY_OR_EXIT_ACTION__ACTION_CODE:
        return actionCode != null;
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
    result.append(" (type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //EntryOrExitActionImpl
