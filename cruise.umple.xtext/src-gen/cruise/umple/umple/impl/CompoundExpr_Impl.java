/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.BoolExpr_;
import cruise.umple.umple.CompoundExpr_;
import cruise.umple.umple.GenExpr_;
import cruise.umple.umple.NumExpr_;
import cruise.umple.umple.StringExpr_;
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
 * An implementation of the model object '<em><b>Compound Expr </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.CompoundExpr_Impl#getStringExpr_1 <em>String Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.CompoundExpr_Impl#getBoolExpr_1 <em>Bool Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.CompoundExpr_Impl#getNumExpr_1 <em>Num Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.CompoundExpr_Impl#getGenExpr_1 <em>Gen Expr 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompoundExpr_Impl extends MinimalEObjectImpl.Container implements CompoundExpr_
{
  /**
   * The cached value of the '{@link #getStringExpr_1() <em>String Expr 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringExpr_1()
   * @generated
   * @ordered
   */
  protected EList<StringExpr_> stringExpr_1;

  /**
   * The cached value of the '{@link #getBoolExpr_1() <em>Bool Expr 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolExpr_1()
   * @generated
   * @ordered
   */
  protected EList<BoolExpr_> boolExpr_1;

  /**
   * The cached value of the '{@link #getNumExpr_1() <em>Num Expr 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumExpr_1()
   * @generated
   * @ordered
   */
  protected EList<NumExpr_> numExpr_1;

  /**
   * The cached value of the '{@link #getGenExpr_1() <em>Gen Expr 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenExpr_1()
   * @generated
   * @ordered
   */
  protected EList<GenExpr_> genExpr_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CompoundExpr_Impl()
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
    return UmplePackage.eINSTANCE.getCompoundExpr_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StringExpr_> getStringExpr_1()
  {
    if (stringExpr_1 == null)
    {
      stringExpr_1 = new EObjectContainmentEList<StringExpr_>(StringExpr_.class, this, UmplePackage.COMPOUND_EXPR___STRING_EXPR_1);
    }
    return stringExpr_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<BoolExpr_> getBoolExpr_1()
  {
    if (boolExpr_1 == null)
    {
      boolExpr_1 = new EObjectContainmentEList<BoolExpr_>(BoolExpr_.class, this, UmplePackage.COMPOUND_EXPR___BOOL_EXPR_1);
    }
    return boolExpr_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NumExpr_> getNumExpr_1()
  {
    if (numExpr_1 == null)
    {
      numExpr_1 = new EObjectContainmentEList<NumExpr_>(NumExpr_.class, this, UmplePackage.COMPOUND_EXPR___NUM_EXPR_1);
    }
    return numExpr_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GenExpr_> getGenExpr_1()
  {
    if (genExpr_1 == null)
    {
      genExpr_1 = new EObjectContainmentEList<GenExpr_>(GenExpr_.class, this, UmplePackage.COMPOUND_EXPR___GEN_EXPR_1);
    }
    return genExpr_1;
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
      case UmplePackage.COMPOUND_EXPR___STRING_EXPR_1:
        return ((InternalEList<?>)getStringExpr_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.COMPOUND_EXPR___BOOL_EXPR_1:
        return ((InternalEList<?>)getBoolExpr_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.COMPOUND_EXPR___NUM_EXPR_1:
        return ((InternalEList<?>)getNumExpr_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.COMPOUND_EXPR___GEN_EXPR_1:
        return ((InternalEList<?>)getGenExpr_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.COMPOUND_EXPR___STRING_EXPR_1:
        return getStringExpr_1();
      case UmplePackage.COMPOUND_EXPR___BOOL_EXPR_1:
        return getBoolExpr_1();
      case UmplePackage.COMPOUND_EXPR___NUM_EXPR_1:
        return getNumExpr_1();
      case UmplePackage.COMPOUND_EXPR___GEN_EXPR_1:
        return getGenExpr_1();
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
      case UmplePackage.COMPOUND_EXPR___STRING_EXPR_1:
        getStringExpr_1().clear();
        getStringExpr_1().addAll((Collection<? extends StringExpr_>)newValue);
        return;
      case UmplePackage.COMPOUND_EXPR___BOOL_EXPR_1:
        getBoolExpr_1().clear();
        getBoolExpr_1().addAll((Collection<? extends BoolExpr_>)newValue);
        return;
      case UmplePackage.COMPOUND_EXPR___NUM_EXPR_1:
        getNumExpr_1().clear();
        getNumExpr_1().addAll((Collection<? extends NumExpr_>)newValue);
        return;
      case UmplePackage.COMPOUND_EXPR___GEN_EXPR_1:
        getGenExpr_1().clear();
        getGenExpr_1().addAll((Collection<? extends GenExpr_>)newValue);
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
      case UmplePackage.COMPOUND_EXPR___STRING_EXPR_1:
        getStringExpr_1().clear();
        return;
      case UmplePackage.COMPOUND_EXPR___BOOL_EXPR_1:
        getBoolExpr_1().clear();
        return;
      case UmplePackage.COMPOUND_EXPR___NUM_EXPR_1:
        getNumExpr_1().clear();
        return;
      case UmplePackage.COMPOUND_EXPR___GEN_EXPR_1:
        getGenExpr_1().clear();
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
      case UmplePackage.COMPOUND_EXPR___STRING_EXPR_1:
        return stringExpr_1 != null && !stringExpr_1.isEmpty();
      case UmplePackage.COMPOUND_EXPR___BOOL_EXPR_1:
        return boolExpr_1 != null && !boolExpr_1.isEmpty();
      case UmplePackage.COMPOUND_EXPR___NUM_EXPR_1:
        return numExpr_1 != null && !numExpr_1.isEmpty();
      case UmplePackage.COMPOUND_EXPR___GEN_EXPR_1:
        return genExpr_1 != null && !genExpr_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CompoundExpr_Impl
