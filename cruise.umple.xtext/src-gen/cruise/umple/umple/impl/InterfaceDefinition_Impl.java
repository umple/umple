/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Depend_;
import cruise.umple.umple.InterfaceBody_;
import cruise.umple.umple.InterfaceDefinition_;
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
 * An implementation of the model object '<em><b>Interface Definition </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.InterfaceDefinition_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InterfaceDefinition_Impl#getDepend_1 <em>Depend 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InterfaceDefinition_Impl#getInterfaceBody_1 <em>Interface Body 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceDefinition_Impl extends MinimalEObjectImpl.Container implements InterfaceDefinition_
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
   * The cached value of the '{@link #getDepend_1() <em>Depend 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDepend_1()
   * @generated
   * @ordered
   */
  protected EList<Depend_> depend_1;

  /**
   * The cached value of the '{@link #getInterfaceBody_1() <em>Interface Body 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfaceBody_1()
   * @generated
   * @ordered
   */
  protected EList<InterfaceBody_> interfaceBody_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InterfaceDefinition_Impl()
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
    return UmplePackage.eINSTANCE.getInterfaceDefinition_();
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.INTERFACE_DEFINITION___NAME_1, oldName_1, name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Depend_> getDepend_1()
  {
    if (depend_1 == null)
    {
      depend_1 = new EObjectContainmentEList<Depend_>(Depend_.class, this, UmplePackage.INTERFACE_DEFINITION___DEPEND_1);
    }
    return depend_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InterfaceBody_> getInterfaceBody_1()
  {
    if (interfaceBody_1 == null)
    {
      interfaceBody_1 = new EObjectContainmentEList<InterfaceBody_>(InterfaceBody_.class, this, UmplePackage.INTERFACE_DEFINITION___INTERFACE_BODY_1);
    }
    return interfaceBody_1;
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
      case UmplePackage.INTERFACE_DEFINITION___DEPEND_1:
        return ((InternalEList<?>)getDepend_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.INTERFACE_DEFINITION___INTERFACE_BODY_1:
        return ((InternalEList<?>)getInterfaceBody_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.INTERFACE_DEFINITION___NAME_1:
        return getName_1();
      case UmplePackage.INTERFACE_DEFINITION___DEPEND_1:
        return getDepend_1();
      case UmplePackage.INTERFACE_DEFINITION___INTERFACE_BODY_1:
        return getInterfaceBody_1();
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
      case UmplePackage.INTERFACE_DEFINITION___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.INTERFACE_DEFINITION___DEPEND_1:
        getDepend_1().clear();
        getDepend_1().addAll((Collection<? extends Depend_>)newValue);
        return;
      case UmplePackage.INTERFACE_DEFINITION___INTERFACE_BODY_1:
        getInterfaceBody_1().clear();
        getInterfaceBody_1().addAll((Collection<? extends InterfaceBody_>)newValue);
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
      case UmplePackage.INTERFACE_DEFINITION___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.INTERFACE_DEFINITION___DEPEND_1:
        getDepend_1().clear();
        return;
      case UmplePackage.INTERFACE_DEFINITION___INTERFACE_BODY_1:
        getInterfaceBody_1().clear();
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
      case UmplePackage.INTERFACE_DEFINITION___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.INTERFACE_DEFINITION___DEPEND_1:
        return depend_1 != null && !depend_1.isEmpty();
      case UmplePackage.INTERFACE_DEFINITION___INTERFACE_BODY_1:
        return interfaceBody_1 != null && !interfaceBody_1.isEmpty();
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
    result.append(')');
    return result.toString();
  }

} //InterfaceDefinition_Impl
