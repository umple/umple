/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AutouniqueAttribute_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Autounique Attribute </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AutouniqueAttribute_Impl#isAutounique_1 <em>Autounique 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AutouniqueAttribute_Impl#getName_1 <em>Name 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AutouniqueAttribute_Impl extends MinimalEObjectImpl.Container implements AutouniqueAttribute_
{
  /**
   * The default value of the '{@link #isAutounique_1() <em>Autounique 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAutounique_1()
   * @generated
   * @ordered
   */
  protected static final boolean AUTOUNIQUE_1_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAutounique_1() <em>Autounique 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAutounique_1()
   * @generated
   * @ordered
   */
  protected boolean autounique_1 = AUTOUNIQUE_1_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AutouniqueAttribute_Impl()
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
    return UmplePackage.eINSTANCE.getAutouniqueAttribute_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAutounique_1()
  {
    return autounique_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAutounique_1(boolean newAutounique_1)
  {
    boolean oldAutounique_1 = autounique_1;
    autounique_1 = newAutounique_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.AUTOUNIQUE_ATTRIBUTE___AUTOUNIQUE_1, oldAutounique_1, autounique_1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.AUTOUNIQUE_ATTRIBUTE___NAME_1, oldName_1, name_1));
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
      case UmplePackage.AUTOUNIQUE_ATTRIBUTE___AUTOUNIQUE_1:
        return isAutounique_1();
      case UmplePackage.AUTOUNIQUE_ATTRIBUTE___NAME_1:
        return getName_1();
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
      case UmplePackage.AUTOUNIQUE_ATTRIBUTE___AUTOUNIQUE_1:
        setAutounique_1((Boolean)newValue);
        return;
      case UmplePackage.AUTOUNIQUE_ATTRIBUTE___NAME_1:
        setName_1((String)newValue);
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
      case UmplePackage.AUTOUNIQUE_ATTRIBUTE___AUTOUNIQUE_1:
        setAutounique_1(AUTOUNIQUE_1_EDEFAULT);
        return;
      case UmplePackage.AUTOUNIQUE_ATTRIBUTE___NAME_1:
        setName_1(NAME_1_EDEFAULT);
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
      case UmplePackage.AUTOUNIQUE_ATTRIBUTE___AUTOUNIQUE_1:
        return autounique_1 != AUTOUNIQUE_1_EDEFAULT;
      case UmplePackage.AUTOUNIQUE_ATTRIBUTE___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
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
    result.append(" (autounique_1: ");
    result.append(autounique_1);
    result.append(", name_1: ");
    result.append(name_1);
    result.append(')');
    return result.toString();
  }

} //AutouniqueAttribute_Impl
