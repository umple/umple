/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ActiveDefinition_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Active Definition </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ActiveDefinition_Impl#isActive_1 <em>Active 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ActiveDefinition_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ActiveDefinition_Impl#getCode_1 <em>Code 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActiveDefinition_Impl extends MinimalEObjectImpl.Container implements ActiveDefinition_
{
  /**
   * The default value of the '{@link #isActive_1() <em>Active 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActive_1()
   * @generated
   * @ordered
   */
  protected static final boolean ACTIVE_1_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isActive_1() <em>Active 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActive_1()
   * @generated
   * @ordered
   */
  protected boolean active_1 = ACTIVE_1_EDEFAULT;

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
   * The default value of the '{@link #getCode_1() <em>Code 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCode_1()
   * @generated
   * @ordered
   */
  protected static final String CODE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCode_1() <em>Code 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCode_1()
   * @generated
   * @ordered
   */
  protected String code_1 = CODE_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActiveDefinition_Impl()
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
    return UmplePackage.eINSTANCE.getActiveDefinition_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isActive_1()
  {
    return active_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActive_1(boolean newActive_1)
  {
    boolean oldActive_1 = active_1;
    active_1 = newActive_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ACTIVE_DEFINITION___ACTIVE_1, oldActive_1, active_1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ACTIVE_DEFINITION___NAME_1, oldName_1, name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCode_1()
  {
    return code_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCode_1(String newCode_1)
  {
    String oldCode_1 = code_1;
    code_1 = newCode_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ACTIVE_DEFINITION___CODE_1, oldCode_1, code_1));
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
      case UmplePackage.ACTIVE_DEFINITION___ACTIVE_1:
        return isActive_1();
      case UmplePackage.ACTIVE_DEFINITION___NAME_1:
        return getName_1();
      case UmplePackage.ACTIVE_DEFINITION___CODE_1:
        return getCode_1();
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
      case UmplePackage.ACTIVE_DEFINITION___ACTIVE_1:
        setActive_1((Boolean)newValue);
        return;
      case UmplePackage.ACTIVE_DEFINITION___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.ACTIVE_DEFINITION___CODE_1:
        setCode_1((String)newValue);
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
      case UmplePackage.ACTIVE_DEFINITION___ACTIVE_1:
        setActive_1(ACTIVE_1_EDEFAULT);
        return;
      case UmplePackage.ACTIVE_DEFINITION___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.ACTIVE_DEFINITION___CODE_1:
        setCode_1(CODE_1_EDEFAULT);
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
      case UmplePackage.ACTIVE_DEFINITION___ACTIVE_1:
        return active_1 != ACTIVE_1_EDEFAULT;
      case UmplePackage.ACTIVE_DEFINITION___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.ACTIVE_DEFINITION___CODE_1:
        return CODE_1_EDEFAULT == null ? code_1 != null : !CODE_1_EDEFAULT.equals(code_1);
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
    result.append(" (active_1: ");
    result.append(active_1);
    result.append(", name_1: ");
    result.append(name_1);
    result.append(", code_1: ");
    result.append(code_1);
    result.append(')');
    return result.toString();
  }

} //ActiveDefinition_Impl
