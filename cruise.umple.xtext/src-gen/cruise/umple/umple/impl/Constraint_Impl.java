/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_constraint_1_;
import cruise.umple.umple.ConstraintBody_;
import cruise.umple.umple.Constraint_;
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
 * An implementation of the model object '<em><b>Constraint </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Constraint_Impl#getAnonymous_constraint_1_1 <em>Anonymous constraint 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Constraint_Impl#getConstraintBody_1 <em>Constraint Body 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Constraint_Impl extends MinimalEObjectImpl.Container implements Constraint_
{
  /**
   * The cached value of the '{@link #getAnonymous_constraint_1_1() <em>Anonymous constraint 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_constraint_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_constraint_1_> anonymous_constraint_1_1;

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
  protected Constraint_Impl()
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
    return UmplePackage.eINSTANCE.getConstraint_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_constraint_1_> getAnonymous_constraint_1_1()
  {
    if (anonymous_constraint_1_1 == null)
    {
      anonymous_constraint_1_1 = new EObjectContainmentEList<Anonymous_constraint_1_>(Anonymous_constraint_1_.class, this, UmplePackage.CONSTRAINT___ANONYMOUS_CONSTRAINT_11);
    }
    return anonymous_constraint_1_1;
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
      constraintBody_1 = new EObjectContainmentEList<ConstraintBody_>(ConstraintBody_.class, this, UmplePackage.CONSTRAINT___CONSTRAINT_BODY_1);
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
      case UmplePackage.CONSTRAINT___ANONYMOUS_CONSTRAINT_11:
        return ((InternalEList<?>)getAnonymous_constraint_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CONSTRAINT___CONSTRAINT_BODY_1:
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
      case UmplePackage.CONSTRAINT___ANONYMOUS_CONSTRAINT_11:
        return getAnonymous_constraint_1_1();
      case UmplePackage.CONSTRAINT___CONSTRAINT_BODY_1:
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
      case UmplePackage.CONSTRAINT___ANONYMOUS_CONSTRAINT_11:
        getAnonymous_constraint_1_1().clear();
        getAnonymous_constraint_1_1().addAll((Collection<? extends Anonymous_constraint_1_>)newValue);
        return;
      case UmplePackage.CONSTRAINT___CONSTRAINT_BODY_1:
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
      case UmplePackage.CONSTRAINT___ANONYMOUS_CONSTRAINT_11:
        getAnonymous_constraint_1_1().clear();
        return;
      case UmplePackage.CONSTRAINT___CONSTRAINT_BODY_1:
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
      case UmplePackage.CONSTRAINT___ANONYMOUS_CONSTRAINT_11:
        return anonymous_constraint_1_1 != null && !anonymous_constraint_1_1.isEmpty();
      case UmplePackage.CONSTRAINT___CONSTRAINT_BODY_1:
        return constraintBody_1 != null && !constraintBody_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Constraint_Impl
