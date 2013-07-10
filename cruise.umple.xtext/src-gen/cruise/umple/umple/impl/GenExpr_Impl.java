/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_genExpr_1_;
import cruise.umple.umple.Anonymous_genExpr_2_;
import cruise.umple.umple.EqualityOp_;
import cruise.umple.umple.GenExpr_;
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
 * An implementation of the model object '<em><b>Gen Expr </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.GenExpr_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.GenExpr_Impl#getAnonymous_genExpr_1_1 <em>Anonymous gen Expr 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.GenExpr_Impl#getEqualityOp_1 <em>Equality Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.GenExpr_Impl#getName_2 <em>Name 2</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.GenExpr_Impl#getAnonymous_genExpr_2_1 <em>Anonymous gen Expr 21</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenExpr_Impl extends MinimalEObjectImpl.Container implements GenExpr_
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
   * The cached value of the '{@link #getAnonymous_genExpr_1_1() <em>Anonymous gen Expr 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_genExpr_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_genExpr_1_> anonymous_genExpr_1_1;

  /**
   * The cached value of the '{@link #getEqualityOp_1() <em>Equality Op 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEqualityOp_1()
   * @generated
   * @ordered
   */
  protected EList<EqualityOp_> equalityOp_1;

  /**
   * The default value of the '{@link #getName_2() <em>Name 2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName_2()
   * @generated
   * @ordered
   */
  protected static final String NAME_2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName_2() <em>Name 2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName_2()
   * @generated
   * @ordered
   */
  protected String name_2 = NAME_2_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_genExpr_2_1() <em>Anonymous gen Expr 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_genExpr_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_genExpr_2_> anonymous_genExpr_2_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GenExpr_Impl()
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
    return UmplePackage.eINSTANCE.getGenExpr_();
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.GEN_EXPR___NAME_1, oldName_1, name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_genExpr_1_> getAnonymous_genExpr_1_1()
  {
    if (anonymous_genExpr_1_1 == null)
    {
      anonymous_genExpr_1_1 = new EObjectContainmentEList<Anonymous_genExpr_1_>(Anonymous_genExpr_1_.class, this, UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_11);
    }
    return anonymous_genExpr_1_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EqualityOp_> getEqualityOp_1()
  {
    if (equalityOp_1 == null)
    {
      equalityOp_1 = new EObjectContainmentEList<EqualityOp_>(EqualityOp_.class, this, UmplePackage.GEN_EXPR___EQUALITY_OP_1);
    }
    return equalityOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName_2()
  {
    return name_2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName_2(String newName_2)
  {
    String oldName_2 = name_2;
    name_2 = newName_2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.GEN_EXPR___NAME_2, oldName_2, name_2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_genExpr_2_> getAnonymous_genExpr_2_1()
  {
    if (anonymous_genExpr_2_1 == null)
    {
      anonymous_genExpr_2_1 = new EObjectContainmentEList<Anonymous_genExpr_2_>(Anonymous_genExpr_2_.class, this, UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_21);
    }
    return anonymous_genExpr_2_1;
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
      case UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_11:
        return ((InternalEList<?>)getAnonymous_genExpr_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.GEN_EXPR___EQUALITY_OP_1:
        return ((InternalEList<?>)getEqualityOp_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_21:
        return ((InternalEList<?>)getAnonymous_genExpr_2_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.GEN_EXPR___NAME_1:
        return getName_1();
      case UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_11:
        return getAnonymous_genExpr_1_1();
      case UmplePackage.GEN_EXPR___EQUALITY_OP_1:
        return getEqualityOp_1();
      case UmplePackage.GEN_EXPR___NAME_2:
        return getName_2();
      case UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_21:
        return getAnonymous_genExpr_2_1();
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
      case UmplePackage.GEN_EXPR___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_11:
        getAnonymous_genExpr_1_1().clear();
        getAnonymous_genExpr_1_1().addAll((Collection<? extends Anonymous_genExpr_1_>)newValue);
        return;
      case UmplePackage.GEN_EXPR___EQUALITY_OP_1:
        getEqualityOp_1().clear();
        getEqualityOp_1().addAll((Collection<? extends EqualityOp_>)newValue);
        return;
      case UmplePackage.GEN_EXPR___NAME_2:
        setName_2((String)newValue);
        return;
      case UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_21:
        getAnonymous_genExpr_2_1().clear();
        getAnonymous_genExpr_2_1().addAll((Collection<? extends Anonymous_genExpr_2_>)newValue);
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
      case UmplePackage.GEN_EXPR___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_11:
        getAnonymous_genExpr_1_1().clear();
        return;
      case UmplePackage.GEN_EXPR___EQUALITY_OP_1:
        getEqualityOp_1().clear();
        return;
      case UmplePackage.GEN_EXPR___NAME_2:
        setName_2(NAME_2_EDEFAULT);
        return;
      case UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_21:
        getAnonymous_genExpr_2_1().clear();
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
      case UmplePackage.GEN_EXPR___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_11:
        return anonymous_genExpr_1_1 != null && !anonymous_genExpr_1_1.isEmpty();
      case UmplePackage.GEN_EXPR___EQUALITY_OP_1:
        return equalityOp_1 != null && !equalityOp_1.isEmpty();
      case UmplePackage.GEN_EXPR___NAME_2:
        return NAME_2_EDEFAULT == null ? name_2 != null : !NAME_2_EDEFAULT.equals(name_2);
      case UmplePackage.GEN_EXPR___ANONYMOUS_GEN_EXPR_21:
        return anonymous_genExpr_2_1 != null && !anonymous_genExpr_2_1.isEmpty();
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
    result.append(", name_2: ");
    result.append(name_2);
    result.append(')');
    return result.toString();
  }

} //GenExpr_Impl
