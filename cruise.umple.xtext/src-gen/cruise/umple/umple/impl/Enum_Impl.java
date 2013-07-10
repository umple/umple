/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_enum_1_;
import cruise.umple.umple.Enum_;
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
 * An implementation of the model object '<em><b>Enum </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Enum_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Enum_Impl#getStateName_1 <em>State Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Enum_Impl#getAnonymous_enum_1_1 <em>Anonymous enum 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Enum_Impl extends MinimalEObjectImpl.Container implements Enum_
{
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
   * The cached value of the '{@link #getAnonymous_enum_1_1() <em>Anonymous enum 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_enum_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_enum_1_> anonymous_enum_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Enum_Impl()
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
    return UmplePackage.eINSTANCE.getEnum_();
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ENUM___NAME_1, oldName_1, name_1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ENUM___STATE_NAME_1, oldStateName_1, stateName_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_enum_1_> getAnonymous_enum_1_1()
  {
    if (anonymous_enum_1_1 == null)
    {
      anonymous_enum_1_1 = new EObjectContainmentEList<Anonymous_enum_1_>(Anonymous_enum_1_.class, this, UmplePackage.ENUM___ANONYMOUS_ENUM_11);
    }
    return anonymous_enum_1_1;
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
      case UmplePackage.ENUM___ANONYMOUS_ENUM_11:
        return ((InternalEList<?>)getAnonymous_enum_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ENUM___NAME_1:
        return getName_1();
      case UmplePackage.ENUM___STATE_NAME_1:
        return getStateName_1();
      case UmplePackage.ENUM___ANONYMOUS_ENUM_11:
        return getAnonymous_enum_1_1();
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
      case UmplePackage.ENUM___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.ENUM___STATE_NAME_1:
        setStateName_1((String)newValue);
        return;
      case UmplePackage.ENUM___ANONYMOUS_ENUM_11:
        getAnonymous_enum_1_1().clear();
        getAnonymous_enum_1_1().addAll((Collection<? extends Anonymous_enum_1_>)newValue);
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
      case UmplePackage.ENUM___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.ENUM___STATE_NAME_1:
        setStateName_1(STATE_NAME_1_EDEFAULT);
        return;
      case UmplePackage.ENUM___ANONYMOUS_ENUM_11:
        getAnonymous_enum_1_1().clear();
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
      case UmplePackage.ENUM___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.ENUM___STATE_NAME_1:
        return STATE_NAME_1_EDEFAULT == null ? stateName_1 != null : !STATE_NAME_1_EDEFAULT.equals(stateName_1);
      case UmplePackage.ENUM___ANONYMOUS_ENUM_11:
        return anonymous_enum_1_1 != null && !anonymous_enum_1_1.isEmpty();
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
    result.append(" (name_1: ");
    result.append(name_1);
    result.append(", stateName_1: ");
    result.append(stateName_1);
    result.append(')');
    return result.toString();
  }

} //Enum_Impl
