/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_linkingOp_3_;
import cruise.umple.umple.ConstraintExpr_;
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
 * An implementation of the model object '<em><b>Anonymous linking Op 3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_linkingOp_3_Impl#getOrOp_1 <em>Or Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_linkingOp_3_Impl#getConstraintExpr_1 <em>Constraint Expr 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_linkingOp_3_Impl extends MinimalEObjectImpl.Container implements Anonymous_linkingOp_3_
{
  /**
   * The default value of the '{@link #getOrOp_1() <em>Or Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrOp_1()
   * @generated
   * @ordered
   */
  protected static final String OR_OP_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOrOp_1() <em>Or Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrOp_1()
   * @generated
   * @ordered
   */
  protected String orOp_1 = OR_OP_1_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_linkingOp_3_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_linkingOp_3_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOrOp_1()
  {
    return orOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrOp_1(String newOrOp_1)
  {
    String oldOrOp_1 = orOp_1;
    orOp_1 = newOrOp_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_LINKING_OP_3__OR_OP_1, oldOrOp_1, orOp_1));
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
      constraintExpr_1 = new EObjectContainmentEList<ConstraintExpr_>(ConstraintExpr_.class, this, UmplePackage.ANONYMOUS_LINKING_OP_3__CONSTRAINT_EXPR_1);
    }
    return constraintExpr_1;
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
      case UmplePackage.ANONYMOUS_LINKING_OP_3__CONSTRAINT_EXPR_1:
        return ((InternalEList<?>)getConstraintExpr_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_LINKING_OP_3__OR_OP_1:
        return getOrOp_1();
      case UmplePackage.ANONYMOUS_LINKING_OP_3__CONSTRAINT_EXPR_1:
        return getConstraintExpr_1();
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
      case UmplePackage.ANONYMOUS_LINKING_OP_3__OR_OP_1:
        setOrOp_1((String)newValue);
        return;
      case UmplePackage.ANONYMOUS_LINKING_OP_3__CONSTRAINT_EXPR_1:
        getConstraintExpr_1().clear();
        getConstraintExpr_1().addAll((Collection<? extends ConstraintExpr_>)newValue);
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
      case UmplePackage.ANONYMOUS_LINKING_OP_3__OR_OP_1:
        setOrOp_1(OR_OP_1_EDEFAULT);
        return;
      case UmplePackage.ANONYMOUS_LINKING_OP_3__CONSTRAINT_EXPR_1:
        getConstraintExpr_1().clear();
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
      case UmplePackage.ANONYMOUS_LINKING_OP_3__OR_OP_1:
        return OR_OP_1_EDEFAULT == null ? orOp_1 != null : !OR_OP_1_EDEFAULT.equals(orOp_1);
      case UmplePackage.ANONYMOUS_LINKING_OP_3__CONSTRAINT_EXPR_1:
        return constraintExpr_1 != null && !constraintExpr_1.isEmpty();
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
    result.append(" (orOp_1: ");
    result.append(orOp_1);
    result.append(')');
    return result.toString();
  }

} //Anonymous_linkingOp_3_Impl
