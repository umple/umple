/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_constraintBody_1_;
import cruise.umple.umple.ConstraintBody_;
import cruise.umple.umple.ConstraintExpr_;
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
 * An implementation of the model object '<em><b>Constraint Body </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ConstraintBody_Impl#getConstraintExpr_1 <em>Constraint Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConstraintBody_Impl#getAnonymous_constraintBody_1_1 <em>Anonymous constraint Body 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintBody_Impl extends MinimalEObjectImpl.Container implements ConstraintBody_
{
  /**
   * The cached value of the '{@link #getConstraintExpr_1() <em>Constraint Expr 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintExpr_1()
   * @generated
   * @ordered
   */
  protected EList<ConstraintExpr_> constraintExpr_1;

  /**
   * The cached value of the '{@link #getAnonymous_constraintBody_1_1() <em>Anonymous constraint Body 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_constraintBody_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_constraintBody_1_> anonymous_constraintBody_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstraintBody_Impl()
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
    return UmplePackage.eINSTANCE.getConstraintBody_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstraintExpr_> getConstraintExpr_1()
  {
    if (constraintExpr_1 == null)
    {
      constraintExpr_1 = new EObjectContainmentEList<ConstraintExpr_>(ConstraintExpr_.class, this, UmplePackage.CONSTRAINT_BODY___CONSTRAINT_EXPR_1);
    }
    return constraintExpr_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_constraintBody_1_> getAnonymous_constraintBody_1_1()
  {
    if (anonymous_constraintBody_1_1 == null)
    {
      anonymous_constraintBody_1_1 = new EObjectContainmentEList<Anonymous_constraintBody_1_>(Anonymous_constraintBody_1_.class, this, UmplePackage.CONSTRAINT_BODY___ANONYMOUS_CONSTRAINT_BODY_11);
    }
    return anonymous_constraintBody_1_1;
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
      case UmplePackage.CONSTRAINT_BODY___CONSTRAINT_EXPR_1:
        return ((InternalEList<?>)getConstraintExpr_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CONSTRAINT_BODY___ANONYMOUS_CONSTRAINT_BODY_11:
        return ((InternalEList<?>)getAnonymous_constraintBody_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.CONSTRAINT_BODY___CONSTRAINT_EXPR_1:
        return getConstraintExpr_1();
      case UmplePackage.CONSTRAINT_BODY___ANONYMOUS_CONSTRAINT_BODY_11:
        return getAnonymous_constraintBody_1_1();
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
      case UmplePackage.CONSTRAINT_BODY___CONSTRAINT_EXPR_1:
        getConstraintExpr_1().clear();
        getConstraintExpr_1().addAll((Collection<? extends ConstraintExpr_>)newValue);
        return;
      case UmplePackage.CONSTRAINT_BODY___ANONYMOUS_CONSTRAINT_BODY_11:
        getAnonymous_constraintBody_1_1().clear();
        getAnonymous_constraintBody_1_1().addAll((Collection<? extends Anonymous_constraintBody_1_>)newValue);
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
      case UmplePackage.CONSTRAINT_BODY___CONSTRAINT_EXPR_1:
        getConstraintExpr_1().clear();
        return;
      case UmplePackage.CONSTRAINT_BODY___ANONYMOUS_CONSTRAINT_BODY_11:
        getAnonymous_constraintBody_1_1().clear();
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
      case UmplePackage.CONSTRAINT_BODY___CONSTRAINT_EXPR_1:
        return constraintExpr_1 != null && !constraintExpr_1.isEmpty();
      case UmplePackage.CONSTRAINT_BODY___ANONYMOUS_CONSTRAINT_BODY_11:
        return anonymous_constraintBody_1_1 != null && !anonymous_constraintBody_1_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ConstraintBody_Impl
