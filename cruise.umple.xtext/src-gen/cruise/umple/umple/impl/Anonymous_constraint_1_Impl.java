/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_constraint_1_;
import cruise.umple.umple.ConstraintBody_;
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
 * An implementation of the model object '<em><b>Anonymous constraint 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_constraint_1_Impl#getConstraintBody_1 <em>Constraint Body 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_constraint_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_constraint_1_
{
  /**
   * The cached value of the '{@link #getConstraintBody_1() <em>Constraint Body 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintBody_1()
   * @generated
   * @ordered
   */
  protected EList<ConstraintBody_> constraintBody_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_constraint_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_constraint_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstraintBody_> getConstraintBody_1()
  {
    if (constraintBody_1 == null)
    {
      constraintBody_1 = new EObjectContainmentEList<ConstraintBody_>(ConstraintBody_.class, this, UmplePackage.ANONYMOUS_CONSTRAINT_1__CONSTRAINT_BODY_1);
    }
    return constraintBody_1;
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
      case UmplePackage.ANONYMOUS_CONSTRAINT_1__CONSTRAINT_BODY_1:
        return ((InternalEList<?>)getConstraintBody_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_CONSTRAINT_1__CONSTRAINT_BODY_1:
        return getConstraintBody_1();
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
      case UmplePackage.ANONYMOUS_CONSTRAINT_1__CONSTRAINT_BODY_1:
        getConstraintBody_1().clear();
        getConstraintBody_1().addAll((Collection<? extends ConstraintBody_>)newValue);
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
      case UmplePackage.ANONYMOUS_CONSTRAINT_1__CONSTRAINT_BODY_1:
        getConstraintBody_1().clear();
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
      case UmplePackage.ANONYMOUS_CONSTRAINT_1__CONSTRAINT_BODY_1:
        return constraintBody_1 != null && !constraintBody_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_constraint_1_Impl
