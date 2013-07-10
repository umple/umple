/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_constraintBody_1_;
import cruise.umple.umple.LinkingOp_;
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
 * An implementation of the model object '<em><b>Anonymous constraint Body 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_constraintBody_1_Impl#getLinkingOp_1 <em>Linking Op 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_constraintBody_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_constraintBody_1_
{
  /**
   * The cached value of the '{@link #getLinkingOp_1() <em>Linking Op 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinkingOp_1()
   * @generated
   * @ordered
   */
  protected EList<LinkingOp_> linkingOp_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_constraintBody_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_constraintBody_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LinkingOp_> getLinkingOp_1()
  {
    if (linkingOp_1 == null)
    {
      linkingOp_1 = new EObjectContainmentEList<LinkingOp_>(LinkingOp_.class, this, UmplePackage.ANONYMOUS_CONSTRAINT_BODY_1__LINKING_OP_1);
    }
    return linkingOp_1;
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
      case UmplePackage.ANONYMOUS_CONSTRAINT_BODY_1__LINKING_OP_1:
        return ((InternalEList<?>)getLinkingOp_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_CONSTRAINT_BODY_1__LINKING_OP_1:
        return getLinkingOp_1();
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
      case UmplePackage.ANONYMOUS_CONSTRAINT_BODY_1__LINKING_OP_1:
        getLinkingOp_1().clear();
        getLinkingOp_1().addAll((Collection<? extends LinkingOp_>)newValue);
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
      case UmplePackage.ANONYMOUS_CONSTRAINT_BODY_1__LINKING_OP_1:
        getLinkingOp_1().clear();
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
      case UmplePackage.ANONYMOUS_CONSTRAINT_BODY_1__LINKING_OP_1:
        return linkingOp_1 != null && !linkingOp_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_constraintBody_1_Impl
