/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ExtendedStateMachine_;
import cruise.umple.umple.ReferencedStateMachine_;
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
 * An implementation of the model object '<em><b>Referenced State Machine </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ReferencedStateMachine_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ReferencedStateMachine_Impl#getDefinitionName_1 <em>Definition Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ReferencedStateMachine_Impl#getExtendedStateMachine_1 <em>Extended State Machine 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferencedStateMachine_Impl extends MinimalEObjectImpl.Container implements ReferencedStateMachine_
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
   * The default value of the '{@link #getDefinitionName_1() <em>Definition Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinitionName_1()
   * @generated
   * @ordered
   */
  protected static final String DEFINITION_NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDefinitionName_1() <em>Definition Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinitionName_1()
   * @generated
   * @ordered
   */
  protected String definitionName_1 = DEFINITION_NAME_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getExtendedStateMachine_1() <em>Extended State Machine 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendedStateMachine_1()
   * @generated
   * @ordered
   */
  protected EList<ExtendedStateMachine_> extendedStateMachine_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferencedStateMachine_Impl()
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
    return UmplePackage.eINSTANCE.getReferencedStateMachine_();
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.REFERENCED_STATE_MACHINE___NAME_1, oldName_1, name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefinitionName_1()
  {
    return definitionName_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefinitionName_1(String newDefinitionName_1)
  {
    String oldDefinitionName_1 = definitionName_1;
    definitionName_1 = newDefinitionName_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.REFERENCED_STATE_MACHINE___DEFINITION_NAME_1, oldDefinitionName_1, definitionName_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExtendedStateMachine_> getExtendedStateMachine_1()
  {
    if (extendedStateMachine_1 == null)
    {
      extendedStateMachine_1 = new EObjectContainmentEList<ExtendedStateMachine_>(ExtendedStateMachine_.class, this, UmplePackage.REFERENCED_STATE_MACHINE___EXTENDED_STATE_MACHINE_1);
    }
    return extendedStateMachine_1;
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
      case UmplePackage.REFERENCED_STATE_MACHINE___EXTENDED_STATE_MACHINE_1:
        return ((InternalEList<?>)getExtendedStateMachine_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.REFERENCED_STATE_MACHINE___NAME_1:
        return getName_1();
      case UmplePackage.REFERENCED_STATE_MACHINE___DEFINITION_NAME_1:
        return getDefinitionName_1();
      case UmplePackage.REFERENCED_STATE_MACHINE___EXTENDED_STATE_MACHINE_1:
        return getExtendedStateMachine_1();
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
      case UmplePackage.REFERENCED_STATE_MACHINE___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.REFERENCED_STATE_MACHINE___DEFINITION_NAME_1:
        setDefinitionName_1((String)newValue);
        return;
      case UmplePackage.REFERENCED_STATE_MACHINE___EXTENDED_STATE_MACHINE_1:
        getExtendedStateMachine_1().clear();
        getExtendedStateMachine_1().addAll((Collection<? extends ExtendedStateMachine_>)newValue);
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
      case UmplePackage.REFERENCED_STATE_MACHINE___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.REFERENCED_STATE_MACHINE___DEFINITION_NAME_1:
        setDefinitionName_1(DEFINITION_NAME_1_EDEFAULT);
        return;
      case UmplePackage.REFERENCED_STATE_MACHINE___EXTENDED_STATE_MACHINE_1:
        getExtendedStateMachine_1().clear();
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
      case UmplePackage.REFERENCED_STATE_MACHINE___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.REFERENCED_STATE_MACHINE___DEFINITION_NAME_1:
        return DEFINITION_NAME_1_EDEFAULT == null ? definitionName_1 != null : !DEFINITION_NAME_1_EDEFAULT.equals(definitionName_1);
      case UmplePackage.REFERENCED_STATE_MACHINE___EXTENDED_STATE_MACHINE_1:
        return extendedStateMachine_1 != null && !extendedStateMachine_1.isEmpty();
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
    result.append(", definitionName_1: ");
    result.append(definitionName_1);
    result.append(')');
    return result.toString();
  }

} //ReferencedStateMachine_Impl
