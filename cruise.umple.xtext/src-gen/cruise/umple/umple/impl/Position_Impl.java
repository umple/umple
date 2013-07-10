/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AssociationPosition_;
import cruise.umple.umple.ElementPosition_;
import cruise.umple.umple.Position_;
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
 * An implementation of the model object '<em><b>Position </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Position_Impl#getAssociationPosition_1 <em>Association Position 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Position_Impl#getElementPosition_1 <em>Element Position 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Position_Impl extends MinimalEObjectImpl.Container implements Position_
{
  /**
   * The cached value of the '{@link #getAssociationPosition_1() <em>Association Position 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationPosition_1()
   * @generated
   * @ordered
   */
  protected EList<AssociationPosition_> associationPosition_1;

  /**
   * The cached value of the '{@link #getElementPosition_1() <em>Element Position 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementPosition_1()
   * @generated
   * @ordered
   */
  protected EList<ElementPosition_> elementPosition_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Position_Impl()
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
    return UmplePackage.eINSTANCE.getPosition_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssociationPosition_> getAssociationPosition_1()
  {
    if (associationPosition_1 == null)
    {
      associationPosition_1 = new EObjectContainmentEList<AssociationPosition_>(AssociationPosition_.class, this, UmplePackage.POSITION___ASSOCIATION_POSITION_1);
    }
    return associationPosition_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ElementPosition_> getElementPosition_1()
  {
    if (elementPosition_1 == null)
    {
      elementPosition_1 = new EObjectContainmentEList<ElementPosition_>(ElementPosition_.class, this, UmplePackage.POSITION___ELEMENT_POSITION_1);
    }
    return elementPosition_1;
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
      case UmplePackage.POSITION___ASSOCIATION_POSITION_1:
        return ((InternalEList<?>)getAssociationPosition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.POSITION___ELEMENT_POSITION_1:
        return ((InternalEList<?>)getElementPosition_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.POSITION___ASSOCIATION_POSITION_1:
        return getAssociationPosition_1();
      case UmplePackage.POSITION___ELEMENT_POSITION_1:
        return getElementPosition_1();
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
      case UmplePackage.POSITION___ASSOCIATION_POSITION_1:
        getAssociationPosition_1().clear();
        getAssociationPosition_1().addAll((Collection<? extends AssociationPosition_>)newValue);
        return;
      case UmplePackage.POSITION___ELEMENT_POSITION_1:
        getElementPosition_1().clear();
        getElementPosition_1().addAll((Collection<? extends ElementPosition_>)newValue);
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
      case UmplePackage.POSITION___ASSOCIATION_POSITION_1:
        getAssociationPosition_1().clear();
        return;
      case UmplePackage.POSITION___ELEMENT_POSITION_1:
        getElementPosition_1().clear();
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
      case UmplePackage.POSITION___ASSOCIATION_POSITION_1:
        return associationPosition_1 != null && !associationPosition_1.isEmpty();
      case UmplePackage.POSITION___ELEMENT_POSITION_1:
        return elementPosition_1 != null && !elementPosition_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Position_Impl
