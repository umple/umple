/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.InterfaceBody_;
import cruise.umple.umple.InterfaceMemberDeclaration_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Body </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.InterfaceBody_Impl#getInterfaceMemberDeclaration_1 <em>Interface Member Declaration 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceBody_Impl extends MinimalEObjectImpl.Container implements InterfaceBody_
{
  /**
   * The cached value of the '{@link #getInterfaceMemberDeclaration_1() <em>Interface Member Declaration 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfaceMemberDeclaration_1()
   * @generated
   * @ordered
   */
  protected EList<InterfaceMemberDeclaration_> interfaceMemberDeclaration_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InterfaceBody_Impl()
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
    return UmplePackage.eINSTANCE.getInterfaceBody_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InterfaceMemberDeclaration_> getInterfaceMemberDeclaration_1()
  {
    if (interfaceMemberDeclaration_1 == null)
    {
      interfaceMemberDeclaration_1 = new EObjectContainmentEList<InterfaceMemberDeclaration_>(InterfaceMemberDeclaration_.class, this, UmplePackage.INTERFACE_BODY___INTERFACE_MEMBER_DECLARATION_1);
    }
    return interfaceMemberDeclaration_1;
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
      case UmplePackage.INTERFACE_BODY___INTERFACE_MEMBER_DECLARATION_1:
        return ((InternalEList<?>)getInterfaceMemberDeclaration_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.INTERFACE_BODY___INTERFACE_MEMBER_DECLARATION_1:
        return getInterfaceMemberDeclaration_1();
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
      case UmplePackage.INTERFACE_BODY___INTERFACE_MEMBER_DECLARATION_1:
        getInterfaceMemberDeclaration_1().clear();
        getInterfaceMemberDeclaration_1().addAll((Collection<? extends InterfaceMemberDeclaration_>)newValue);
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
      case UmplePackage.INTERFACE_BODY___INTERFACE_MEMBER_DECLARATION_1:
        getInterfaceMemberDeclaration_1().clear();
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
      case UmplePackage.INTERFACE_BODY___INTERFACE_MEMBER_DECLARATION_1:
        return interfaceMemberDeclaration_1 != null && !interfaceMemberDeclaration_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InterfaceBody_Impl
