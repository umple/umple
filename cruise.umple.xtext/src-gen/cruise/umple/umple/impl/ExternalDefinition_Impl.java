/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ClassContent_;
import cruise.umple.umple.ExternalDefinition_;
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
 * An implementation of the model object '<em><b>External Definition </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ExternalDefinition_Impl#isInterface_1 <em>Interface 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ExternalDefinition_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ExternalDefinition_Impl#getClassContent_1 <em>Class Content 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalDefinition_Impl extends MinimalEObjectImpl.Container implements ExternalDefinition_
{
  /**
   * The default value of the '{@link #isInterface_1() <em>Interface 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInterface_1()
   * @generated
   * @ordered
   */
  protected static final boolean INTERFACE_1_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isInterface_1() <em>Interface 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInterface_1()
   * @generated
   * @ordered
   */
  protected boolean interface_1 = INTERFACE_1_EDEFAULT;

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
   * The cached value of the '{@link #getClassContent_1() <em>Class Content 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassContent_1()
   * @generated
   * @ordered
   */
  protected EList<ClassContent_> classContent_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExternalDefinition_Impl()
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
    return UmplePackage.eINSTANCE.getExternalDefinition_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isInterface_1()
  {
    return interface_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInterface_1(boolean newInterface_1)
  {
    boolean oldInterface_1 = interface_1;
    interface_1 = newInterface_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXTERNAL_DEFINITION___INTERFACE_1, oldInterface_1, interface_1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXTERNAL_DEFINITION___NAME_1, oldName_1, name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClassContent_> getClassContent_1()
  {
    if (classContent_1 == null)
    {
      classContent_1 = new EObjectContainmentEList<ClassContent_>(ClassContent_.class, this, UmplePackage.EXTERNAL_DEFINITION___CLASS_CONTENT_1);
    }
    return classContent_1;
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
      case UmplePackage.EXTERNAL_DEFINITION___CLASS_CONTENT_1:
        return ((InternalEList<?>)getClassContent_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.EXTERNAL_DEFINITION___INTERFACE_1:
        return isInterface_1();
      case UmplePackage.EXTERNAL_DEFINITION___NAME_1:
        return getName_1();
      case UmplePackage.EXTERNAL_DEFINITION___CLASS_CONTENT_1:
        return getClassContent_1();
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
      case UmplePackage.EXTERNAL_DEFINITION___INTERFACE_1:
        setInterface_1((Boolean)newValue);
        return;
      case UmplePackage.EXTERNAL_DEFINITION___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.EXTERNAL_DEFINITION___CLASS_CONTENT_1:
        getClassContent_1().clear();
        getClassContent_1().addAll((Collection<? extends ClassContent_>)newValue);
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
      case UmplePackage.EXTERNAL_DEFINITION___INTERFACE_1:
        setInterface_1(INTERFACE_1_EDEFAULT);
        return;
      case UmplePackage.EXTERNAL_DEFINITION___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.EXTERNAL_DEFINITION___CLASS_CONTENT_1:
        getClassContent_1().clear();
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
      case UmplePackage.EXTERNAL_DEFINITION___INTERFACE_1:
        return interface_1 != INTERFACE_1_EDEFAULT;
      case UmplePackage.EXTERNAL_DEFINITION___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.EXTERNAL_DEFINITION___CLASS_CONTENT_1:
        return classContent_1 != null && !classContent_1.isEmpty();
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
    result.append(" (interface_1: ");
    result.append(interface_1);
    result.append(", name_1: ");
    result.append(name_1);
    result.append(')');
    return result.toString();
  }

} //ExternalDefinition_Impl
