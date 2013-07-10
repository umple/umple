/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_strictness_1_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous strictness 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_strictness_1_Impl#getStrictnessLevel_1 <em>Strictness Level 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_strictness_1_Impl#getMessage_1 <em>Message 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_strictness_1_Impl#getMessageNumber_1 <em>Message Number 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_strictness_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_strictness_1_
{
  /**
   * The default value of the '{@link #getStrictnessLevel_1() <em>Strictness Level 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrictnessLevel_1()
   * @generated
   * @ordered
   */
  protected static final String STRICTNESS_LEVEL_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStrictnessLevel_1() <em>Strictness Level 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrictnessLevel_1()
   * @generated
   * @ordered
   */
  protected String strictnessLevel_1 = STRICTNESS_LEVEL_1_EDEFAULT;

  /**
   * The default value of the '{@link #getMessage_1() <em>Message 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage_1()
   * @generated
   * @ordered
   */
  protected static final String MESSAGE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMessage_1() <em>Message 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage_1()
   * @generated
   * @ordered
   */
  protected String message_1 = MESSAGE_1_EDEFAULT;

  /**
   * The default value of the '{@link #getMessageNumber_1() <em>Message Number 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessageNumber_1()
   * @generated
   * @ordered
   */
  protected static final String MESSAGE_NUMBER_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMessageNumber_1() <em>Message Number 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessageNumber_1()
   * @generated
   * @ordered
   */
  protected String messageNumber_1 = MESSAGE_NUMBER_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_strictness_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_strictness_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStrictnessLevel_1()
  {
    return strictnessLevel_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStrictnessLevel_1(String newStrictnessLevel_1)
  {
    String oldStrictnessLevel_1 = strictnessLevel_1;
    strictnessLevel_1 = newStrictnessLevel_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_STRICTNESS_1__STRICTNESS_LEVEL_1, oldStrictnessLevel_1, strictnessLevel_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMessage_1()
  {
    return message_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessage_1(String newMessage_1)
  {
    String oldMessage_1 = message_1;
    message_1 = newMessage_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_STRICTNESS_1__MESSAGE_1, oldMessage_1, message_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMessageNumber_1()
  {
    return messageNumber_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessageNumber_1(String newMessageNumber_1)
  {
    String oldMessageNumber_1 = messageNumber_1;
    messageNumber_1 = newMessageNumber_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_STRICTNESS_1__MESSAGE_NUMBER_1, oldMessageNumber_1, messageNumber_1));
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
      case UmplePackage.ANONYMOUS_STRICTNESS_1__STRICTNESS_LEVEL_1:
        return getStrictnessLevel_1();
      case UmplePackage.ANONYMOUS_STRICTNESS_1__MESSAGE_1:
        return getMessage_1();
      case UmplePackage.ANONYMOUS_STRICTNESS_1__MESSAGE_NUMBER_1:
        return getMessageNumber_1();
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
      case UmplePackage.ANONYMOUS_STRICTNESS_1__STRICTNESS_LEVEL_1:
        setStrictnessLevel_1((String)newValue);
        return;
      case UmplePackage.ANONYMOUS_STRICTNESS_1__MESSAGE_1:
        setMessage_1((String)newValue);
        return;
      case UmplePackage.ANONYMOUS_STRICTNESS_1__MESSAGE_NUMBER_1:
        setMessageNumber_1((String)newValue);
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
      case UmplePackage.ANONYMOUS_STRICTNESS_1__STRICTNESS_LEVEL_1:
        setStrictnessLevel_1(STRICTNESS_LEVEL_1_EDEFAULT);
        return;
      case UmplePackage.ANONYMOUS_STRICTNESS_1__MESSAGE_1:
        setMessage_1(MESSAGE_1_EDEFAULT);
        return;
      case UmplePackage.ANONYMOUS_STRICTNESS_1__MESSAGE_NUMBER_1:
        setMessageNumber_1(MESSAGE_NUMBER_1_EDEFAULT);
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
      case UmplePackage.ANONYMOUS_STRICTNESS_1__STRICTNESS_LEVEL_1:
        return STRICTNESS_LEVEL_1_EDEFAULT == null ? strictnessLevel_1 != null : !STRICTNESS_LEVEL_1_EDEFAULT.equals(strictnessLevel_1);
      case UmplePackage.ANONYMOUS_STRICTNESS_1__MESSAGE_1:
        return MESSAGE_1_EDEFAULT == null ? message_1 != null : !MESSAGE_1_EDEFAULT.equals(message_1);
      case UmplePackage.ANONYMOUS_STRICTNESS_1__MESSAGE_NUMBER_1:
        return MESSAGE_NUMBER_1_EDEFAULT == null ? messageNumber_1 != null : !MESSAGE_NUMBER_1_EDEFAULT.equals(messageNumber_1);
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
    result.append(" (strictnessLevel_1: ");
    result.append(strictnessLevel_1);
    result.append(", message_1: ");
    result.append(message_1);
    result.append(", messageNumber_1: ");
    result.append(messageNumber_1);
    result.append(')');
    return result.toString();
  }

} //Anonymous_strictness_1_Impl
