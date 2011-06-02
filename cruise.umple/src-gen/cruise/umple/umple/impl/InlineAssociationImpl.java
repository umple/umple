/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.InlineAssociation;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inline Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.InlineAssociationImpl#getRolename1 <em>Rolename1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InlineAssociationImpl#getType <em>Type</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InlineAssociationImpl#getRolename2 <em>Rolename2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InlineAssociationImpl extends associationClassContentImpl implements InlineAssociation
{
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
  protected InlineAssociationImpl()
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
    return UmplePackage.Literals.INLINE_ASSOCIATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.INLINE_ASSOCIATION__ROLENAME1, oldRolename1, rolename1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.INLINE_ASSOCIATION__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.INLINE_ASSOCIATION__ROLENAME2, oldRolename2, rolename2));
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
      case UmplePackage.INLINE_ASSOCIATION__ROLENAME1:
        return getRolename1();
      case UmplePackage.INLINE_ASSOCIATION__TYPE:
        return getType();
      case UmplePackage.INLINE_ASSOCIATION__ROLENAME2:
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
      case UmplePackage.INLINE_ASSOCIATION__ROLENAME1:
        setRolename1((String)newValue);
        return;
      case UmplePackage.INLINE_ASSOCIATION__TYPE:
        setType((String)newValue);
        return;
      case UmplePackage.INLINE_ASSOCIATION__ROLENAME2:
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
      case UmplePackage.INLINE_ASSOCIATION__ROLENAME1:
        setRolename1(ROLENAME1_EDEFAULT);
        return;
      case UmplePackage.INLINE_ASSOCIATION__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case UmplePackage.INLINE_ASSOCIATION__ROLENAME2:
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
      case UmplePackage.INLINE_ASSOCIATION__ROLENAME1:
        return ROLENAME1_EDEFAULT == null ? rolename1 != null : !ROLENAME1_EDEFAULT.equals(rolename1);
      case UmplePackage.INLINE_ASSOCIATION__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case UmplePackage.INLINE_ASSOCIATION__ROLENAME2:
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
    result.append(" (rolename1: ");
    result.append(rolename1);
    result.append(", type: ");
    result.append(type);
    result.append(", rolename2: ");
    result.append(rolename2);
    result.append(')');
    return result.toString();
  }

} //InlineAssociationImpl
