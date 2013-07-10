/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_linkingOp_2_;
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
 * An implementation of the model object '<em><b>Anonymous linking Op 2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_linkingOp_2_Impl#getAndOp_1 <em>And Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_linkingOp_2_Impl#getConstraintExpr_1 <em>Constraint Expr 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_linkingOp_2_Impl extends MinimalEObjectImpl.Container implements Anonymous_linkingOp_2_
{
  /**
   * The default value of the '{@link #getAndOp_1() <em>And Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndOp_1()
   * @generated
   * @ordered
   */
  protected static final String AND_OP_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAndOp_1() <em>And Op 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndOp_1()
   * @generated
   * @ordered
   */
  protected String andOp_1 = AND_OP_1_EDEFAULT;

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
  protected Anonymous_linkingOp_2_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_linkingOp_2_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAndOp_1()
  {
    return andOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAndOp_1(String newAndOp_1)
  {
    String oldAndOp_1 = andOp_1;
    andOp_1 = newAndOp_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_LINKING_OP_2__AND_OP_1, oldAndOp_1, andOp_1));
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
      constraintExpr_1 = new EObjectContainmentEList<ConstraintExpr_>(ConstraintExpr_.class, this, UmplePackage.ANONYMOUS_LINKING_OP_2__CONSTRAINT_EXPR_1);
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
      case UmplePackage.ANONYMOUS_LINKING_OP_2__CONSTRAINT_EXPR_1:
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
      case UmplePackage.ANONYMOUS_LINKING_OP_2__AND_OP_1:
        return getAndOp_1();
      case UmplePackage.ANONYMOUS_LINKING_OP_2__CONSTRAINT_EXPR_1:
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
      case UmplePackage.ANONYMOUS_LINKING_OP_2__AND_OP_1:
        setAndOp_1((String)newValue);
        return;
      case UmplePackage.ANONYMOUS_LINKING_OP_2__CONSTRAINT_EXPR_1:
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
      case UmplePackage.ANONYMOUS_LINKING_OP_2__AND_OP_1:
        setAndOp_1(AND_OP_1_EDEFAULT);
        return;
      case UmplePackage.ANONYMOUS_LINKING_OP_2__CONSTRAINT_EXPR_1:
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
      case UmplePackage.ANONYMOUS_LINKING_OP_2__AND_OP_1:
        return AND_OP_1_EDEFAULT == null ? andOp_1 != null : !AND_OP_1_EDEFAULT.equals(andOp_1);
      case UmplePackage.ANONYMOUS_LINKING_OP_2__CONSTRAINT_EXPR_1:
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
    result.append(" (andOp_1: ");
    result.append(andOp_1);
    result.append(')');
    return result.toString();
  }

} //Anonymous_linkingOp_2_Impl
