/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_numExpr_1_;
import cruise.umple.umple.Anonymous_numExpr_2_;
import cruise.umple.umple.Anonymous_numExpr_3_;
import cruise.umple.umple.Anonymous_numExpr_4_;
import cruise.umple.umple.NumExpr_;
import cruise.umple.umple.OrdinalOp_;
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
 * An implementation of the model object '<em><b>Num Expr </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.NumExpr_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.NumExpr_Impl#getAnonymous_numExpr_1_1 <em>Anonymous num Expr 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.NumExpr_Impl#getAnonymous_numExpr_2_1 <em>Anonymous num Expr 21</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.NumExpr_Impl#getOrdinalOp_1 <em>Ordinal Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.NumExpr_Impl#getName_2 <em>Name 2</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.NumExpr_Impl#getAnonymous_numExpr_3_1 <em>Anonymous num Expr 31</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.NumExpr_Impl#getAnonymous_numExpr_4_1 <em>Anonymous num Expr 41</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumExpr_Impl extends MinimalEObjectImpl.Container implements NumExpr_
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
   * The cached value of the '{@link #getAnonymous_numExpr_1_1() <em>Anonymous num Expr 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_numExpr_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_numExpr_1_> anonymous_numExpr_1_1;

  /**
   * The cached value of the '{@link #getAnonymous_numExpr_2_1() <em>Anonymous num Expr 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_numExpr_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_numExpr_2_> anonymous_numExpr_2_1;

  /**
   * The cached value of the '{@link #getOrdinalOp_1() <em>Ordinal Op 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrdinalOp_1()
   * @generated
   * @ordered
   */
  protected EList<OrdinalOp_> ordinalOp_1;

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
   * The cached value of the '{@link #getAnonymous_numExpr_3_1() <em>Anonymous num Expr 31</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_numExpr_3_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_numExpr_3_> anonymous_numExpr_3_1;

  /**
   * The cached value of the '{@link #getAnonymous_numExpr_4_1() <em>Anonymous num Expr 41</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_numExpr_4_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_numExpr_4_> anonymous_numExpr_4_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NumExpr_Impl()
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
    return UmplePackage.eINSTANCE.getNumExpr_();
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.NUM_EXPR___NAME_1, oldName_1, name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_numExpr_1_> getAnonymous_numExpr_1_1()
  {
    if (anonymous_numExpr_1_1 == null)
    {
      anonymous_numExpr_1_1 = new EObjectContainmentEList<Anonymous_numExpr_1_>(Anonymous_numExpr_1_.class, this, UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_11);
    }
    return anonymous_numExpr_1_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_numExpr_2_> getAnonymous_numExpr_2_1()
  {
    if (anonymous_numExpr_2_1 == null)
    {
      anonymous_numExpr_2_1 = new EObjectContainmentEList<Anonymous_numExpr_2_>(Anonymous_numExpr_2_.class, this, UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_21);
    }
    return anonymous_numExpr_2_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OrdinalOp_> getOrdinalOp_1()
  {
    if (ordinalOp_1 == null)
    {
      ordinalOp_1 = new EObjectContainmentEList<OrdinalOp_>(OrdinalOp_.class, this, UmplePackage.NUM_EXPR___ORDINAL_OP_1);
    }
    return ordinalOp_1;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.NUM_EXPR___NAME_2, oldName_2, name_2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_numExpr_3_> getAnonymous_numExpr_3_1()
  {
    if (anonymous_numExpr_3_1 == null)
    {
      anonymous_numExpr_3_1 = new EObjectContainmentEList<Anonymous_numExpr_3_>(Anonymous_numExpr_3_.class, this, UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_31);
    }
    return anonymous_numExpr_3_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_numExpr_4_> getAnonymous_numExpr_4_1()
  {
    if (anonymous_numExpr_4_1 == null)
    {
      anonymous_numExpr_4_1 = new EObjectContainmentEList<Anonymous_numExpr_4_>(Anonymous_numExpr_4_.class, this, UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_41);
    }
    return anonymous_numExpr_4_1;
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
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_11:
        return ((InternalEList<?>)getAnonymous_numExpr_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_21:
        return ((InternalEList<?>)getAnonymous_numExpr_2_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.NUM_EXPR___ORDINAL_OP_1:
        return ((InternalEList<?>)getOrdinalOp_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_31:
        return ((InternalEList<?>)getAnonymous_numExpr_3_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_41:
        return ((InternalEList<?>)getAnonymous_numExpr_4_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.NUM_EXPR___NAME_1:
        return getName_1();
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_11:
        return getAnonymous_numExpr_1_1();
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_21:
        return getAnonymous_numExpr_2_1();
      case UmplePackage.NUM_EXPR___ORDINAL_OP_1:
        return getOrdinalOp_1();
      case UmplePackage.NUM_EXPR___NAME_2:
        return getName_2();
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_31:
        return getAnonymous_numExpr_3_1();
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_41:
        return getAnonymous_numExpr_4_1();
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
      case UmplePackage.NUM_EXPR___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_11:
        getAnonymous_numExpr_1_1().clear();
        getAnonymous_numExpr_1_1().addAll((Collection<? extends Anonymous_numExpr_1_>)newValue);
        return;
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_21:
        getAnonymous_numExpr_2_1().clear();
        getAnonymous_numExpr_2_1().addAll((Collection<? extends Anonymous_numExpr_2_>)newValue);
        return;
      case UmplePackage.NUM_EXPR___ORDINAL_OP_1:
        getOrdinalOp_1().clear();
        getOrdinalOp_1().addAll((Collection<? extends OrdinalOp_>)newValue);
        return;
      case UmplePackage.NUM_EXPR___NAME_2:
        setName_2((String)newValue);
        return;
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_31:
        getAnonymous_numExpr_3_1().clear();
        getAnonymous_numExpr_3_1().addAll((Collection<? extends Anonymous_numExpr_3_>)newValue);
        return;
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_41:
        getAnonymous_numExpr_4_1().clear();
        getAnonymous_numExpr_4_1().addAll((Collection<? extends Anonymous_numExpr_4_>)newValue);
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
      case UmplePackage.NUM_EXPR___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_11:
        getAnonymous_numExpr_1_1().clear();
        return;
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_21:
        getAnonymous_numExpr_2_1().clear();
        return;
      case UmplePackage.NUM_EXPR___ORDINAL_OP_1:
        getOrdinalOp_1().clear();
        return;
      case UmplePackage.NUM_EXPR___NAME_2:
        setName_2(NAME_2_EDEFAULT);
        return;
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_31:
        getAnonymous_numExpr_3_1().clear();
        return;
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_41:
        getAnonymous_numExpr_4_1().clear();
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
      case UmplePackage.NUM_EXPR___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_11:
        return anonymous_numExpr_1_1 != null && !anonymous_numExpr_1_1.isEmpty();
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_21:
        return anonymous_numExpr_2_1 != null && !anonymous_numExpr_2_1.isEmpty();
      case UmplePackage.NUM_EXPR___ORDINAL_OP_1:
        return ordinalOp_1 != null && !ordinalOp_1.isEmpty();
      case UmplePackage.NUM_EXPR___NAME_2:
        return NAME_2_EDEFAULT == null ? name_2 != null : !NAME_2_EDEFAULT.equals(name_2);
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_31:
        return anonymous_numExpr_3_1 != null && !anonymous_numExpr_3_1.isEmpty();
      case UmplePackage.NUM_EXPR___ANONYMOUS_NUM_EXPR_41:
        return anonymous_numExpr_4_1 != null && !anonymous_numExpr_4_1.isEmpty();
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

} //NumExpr_Impl
