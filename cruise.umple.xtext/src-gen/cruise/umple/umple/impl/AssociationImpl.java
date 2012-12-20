/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Association;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AssociationImpl#getType1 <em>Type1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationImpl#getRolename1 <em>Rolename1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationImpl#getType2 <em>Type2</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationImpl#getRolename2 <em>Rolename2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends MinimalEObjectImpl.Container implements Association
{
  /**
   * The default value of the '{@link #getType1() <em>Type1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType1()
   * @generated
   * @ordered
   */
  protected static final String TYPE1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType1() <em>Type1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType1()
   * @generated
   * @ordered
   */
  protected String type1 = TYPE1_EDEFAULT;

  /**
   * The default value of the '{@link #getRolename1() <em>Rolename1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRolename1()
   * @generated
   * @ordered
   */
  protected static final String ROLENAME1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRolename1() <em>Rolename1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRolename1()
   * @generated
   * @ordered
   */
  protected String rolename1 = ROLENAME1_EDEFAULT;

  /**
   * The default value of the '{@link #getType2() <em>Type2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType2()
   * @generated
   * @ordered
   */
  protected static final String TYPE2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType2() <em>Type2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType2()
   * @generated
   * @ordered
   */
  protected String type2 = TYPE2_EDEFAULT;

  /**
   * The default value of the '{@link #getRolename2() <em>Rolename2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRolename2()
   * @generated
   * @ordered
   */
  protected static final String ROLENAME2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRolename2() <em>Rolename2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRolename2()
   * @generated
   * @ordered
   */
  protected String rolename2 = ROLENAME2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssociationImpl()
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
    return UmplePackage.Literals.ASSOCIATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType1()
  {
    return type1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType1(String newType1)
  {
    String oldType1 = type1;
    type1 = newType1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ASSOCIATION__TYPE1, oldType1, type1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRolename1()
  {
    return rolename1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRolename1(String newRolename1)
  {
    String oldRolename1 = rolename1;
    rolename1 = newRolename1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ASSOCIATION__ROLENAME1, oldRolename1, rolename1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType2()
  {
    return type2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType2(String newType2)
  {
    String oldType2 = type2;
    type2 = newType2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ASSOCIATION__TYPE2, oldType2, type2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRolename2()
  {
    return rolename2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRolename2(String newRolename2)
  {
    String oldRolename2 = rolename2;
    rolename2 = newRolename2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ASSOCIATION__ROLENAME2, oldRolename2, rolename2));
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
      case UmplePackage.ASSOCIATION__TYPE1:
        return getType1();
      case UmplePackage.ASSOCIATION__ROLENAME1:
        return getRolename1();
      case UmplePackage.ASSOCIATION__TYPE2:
        return getType2();
      case UmplePackage.ASSOCIATION__ROLENAME2:
        return getRolename2();
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
      case UmplePackage.ASSOCIATION__TYPE1:
        setType1((String)newValue);
        return;
      case UmplePackage.ASSOCIATION__ROLENAME1:
        setRolename1((String)newValue);
        return;
      case UmplePackage.ASSOCIATION__TYPE2:
        setType2((String)newValue);
        return;
      case UmplePackage.ASSOCIATION__ROLENAME2:
        setRolename2((String)newValue);
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
      case UmplePackage.ASSOCIATION__TYPE1:
        setType1(TYPE1_EDEFAULT);
        return;
      case UmplePackage.ASSOCIATION__ROLENAME1:
        setRolename1(ROLENAME1_EDEFAULT);
        return;
      case UmplePackage.ASSOCIATION__TYPE2:
        setType2(TYPE2_EDEFAULT);
        return;
      case UmplePackage.ASSOCIATION__ROLENAME2:
        setRolename2(ROLENAME2_EDEFAULT);
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
      case UmplePackage.ASSOCIATION__TYPE1:
        return TYPE1_EDEFAULT == null ? type1 != null : !TYPE1_EDEFAULT.equals(type1);
      case UmplePackage.ASSOCIATION__ROLENAME1:
        return ROLENAME1_EDEFAULT == null ? rolename1 != null : !ROLENAME1_EDEFAULT.equals(rolename1);
      case UmplePackage.ASSOCIATION__TYPE2:
        return TYPE2_EDEFAULT == null ? type2 != null : !TYPE2_EDEFAULT.equals(type2);
      case UmplePackage.ASSOCIATION__ROLENAME2:
        return ROLENAME2_EDEFAULT == null ? rolename2 != null : !ROLENAME2_EDEFAULT.equals(rolename2);
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
    result.append(" (type1: ");
    result.append(type1);
    result.append(", rolename1: ");
    result.append(rolename1);
    result.append(", type2: ");
    result.append(type2);
    result.append(", rolename2: ");
    result.append(rolename2);
    result.append(')');
    return result.toString();
  }

} //AssociationImpl
