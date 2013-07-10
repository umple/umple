/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_constantDeclaration_1_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous constant Declaration 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_constantDeclaration_1_Impl#isList_1 <em>List 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_constantDeclaration_1_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_constantDeclaration_1_Impl#getType_1 <em>Type 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_constantDeclaration_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_constantDeclaration_1_
{
  /**
   * The default value of the '{@link #isList_1() <em>List 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isList_1()
   * @generated
   * @ordered
   */
  protected static final boolean LIST_1_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isList_1() <em>List 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isList_1()
   * @generated
   * @ordered
   */
  protected boolean list_1 = LIST_1_EDEFAULT;

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
   * The default value of the '{@link #getType_1() <em>Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType_1()
   * @generated
   * @ordered
   */
  protected static final String TYPE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType_1() <em>Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType_1()
   * @generated
   * @ordered
   */
  protected String type_1 = TYPE_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_constantDeclaration_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_constantDeclaration_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isList_1()
  {
    return list_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setList_1(boolean newList_1)
  {
    boolean oldList_1 = list_1;
    list_1 = newList_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__LIST_1, oldList_1, list_1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__NAME_1, oldName_1, name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType_1()
  {
    return type_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType_1(String newType_1)
  {
    String oldType_1 = type_1;
    type_1 = newType_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__TYPE_1, oldType_1, type_1));
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
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__LIST_1:
        return isList_1();
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__NAME_1:
        return getName_1();
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__TYPE_1:
        return getType_1();
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
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__LIST_1:
        setList_1((Boolean)newValue);
        return;
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__TYPE_1:
        setType_1((String)newValue);
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
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__LIST_1:
        setList_1(LIST_1_EDEFAULT);
        return;
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__TYPE_1:
        setType_1(TYPE_1_EDEFAULT);
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
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__LIST_1:
        return list_1 != LIST_1_EDEFAULT;
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1__TYPE_1:
        return TYPE_1_EDEFAULT == null ? type_1 != null : !TYPE_1_EDEFAULT.equals(type_1);
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
    result.append(" (list_1: ");
    result.append(list_1);
    result.append(", name_1: ");
    result.append(name_1);
    result.append(", type_1: ");
    result.append(type_1);
    result.append(')');
    return result.toString();
  }

} //Anonymous_constantDeclaration_1_Impl
