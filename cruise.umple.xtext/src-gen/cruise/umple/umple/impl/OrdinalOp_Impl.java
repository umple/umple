/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.GreaterOp_;
import cruise.umple.umple.LessOp_;
import cruise.umple.umple.MoreOp_;
import cruise.umple.umple.OrdinalOp_;
import cruise.umple.umple.SmallerOp_;
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
 * An implementation of the model object '<em><b>Ordinal Op </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.OrdinalOp_Impl#getGreaterOp_1 <em>Greater Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.OrdinalOp_Impl#getLessOp_1 <em>Less Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.OrdinalOp_Impl#getMoreOp_1 <em>More Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.OrdinalOp_Impl#getSmallerOp_1 <em>Smaller Op 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrdinalOp_Impl extends MinimalEObjectImpl.Container implements OrdinalOp_
{
  /**
   * The cached value of the '{@link #getGreaterOp_1() <em>Greater Op 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGreaterOp_1()
   * @generated
   * @ordered
   */
  protected EList<GreaterOp_> greaterOp_1;

  /**
   * The cached value of the '{@link #getLessOp_1() <em>Less Op 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLessOp_1()
   * @generated
   * @ordered
   */
  protected EList<LessOp_> lessOp_1;

  /**
   * The cached value of the '{@link #getMoreOp_1() <em>More Op 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMoreOp_1()
   * @generated
   * @ordered
   */
  protected EList<MoreOp_> moreOp_1;

  /**
   * The cached value of the '{@link #getSmallerOp_1() <em>Smaller Op 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSmallerOp_1()
   * @generated
   * @ordered
   */
  protected EList<SmallerOp_> smallerOp_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OrdinalOp_Impl()
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
    return UmplePackage.eINSTANCE.getOrdinalOp_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GreaterOp_> getGreaterOp_1()
  {
    if (greaterOp_1 == null)
    {
      greaterOp_1 = new EObjectContainmentEList<GreaterOp_>(GreaterOp_.class, this, UmplePackage.ORDINAL_OP___GREATER_OP_1);
    }
    return greaterOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LessOp_> getLessOp_1()
  {
    if (lessOp_1 == null)
    {
      lessOp_1 = new EObjectContainmentEList<LessOp_>(LessOp_.class, this, UmplePackage.ORDINAL_OP___LESS_OP_1);
    }
    return lessOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MoreOp_> getMoreOp_1()
  {
    if (moreOp_1 == null)
    {
      moreOp_1 = new EObjectContainmentEList<MoreOp_>(MoreOp_.class, this, UmplePackage.ORDINAL_OP___MORE_OP_1);
    }
    return moreOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SmallerOp_> getSmallerOp_1()
  {
    if (smallerOp_1 == null)
    {
      smallerOp_1 = new EObjectContainmentEList<SmallerOp_>(SmallerOp_.class, this, UmplePackage.ORDINAL_OP___SMALLER_OP_1);
    }
    return smallerOp_1;
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
      case UmplePackage.ORDINAL_OP___GREATER_OP_1:
        return ((InternalEList<?>)getGreaterOp_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ORDINAL_OP___LESS_OP_1:
        return ((InternalEList<?>)getLessOp_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ORDINAL_OP___MORE_OP_1:
        return ((InternalEList<?>)getMoreOp_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ORDINAL_OP___SMALLER_OP_1:
        return ((InternalEList<?>)getSmallerOp_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ORDINAL_OP___GREATER_OP_1:
        return getGreaterOp_1();
      case UmplePackage.ORDINAL_OP___LESS_OP_1:
        return getLessOp_1();
      case UmplePackage.ORDINAL_OP___MORE_OP_1:
        return getMoreOp_1();
      case UmplePackage.ORDINAL_OP___SMALLER_OP_1:
        return getSmallerOp_1();
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
      case UmplePackage.ORDINAL_OP___GREATER_OP_1:
        getGreaterOp_1().clear();
        getGreaterOp_1().addAll((Collection<? extends GreaterOp_>)newValue);
        return;
      case UmplePackage.ORDINAL_OP___LESS_OP_1:
        getLessOp_1().clear();
        getLessOp_1().addAll((Collection<? extends LessOp_>)newValue);
        return;
      case UmplePackage.ORDINAL_OP___MORE_OP_1:
        getMoreOp_1().clear();
        getMoreOp_1().addAll((Collection<? extends MoreOp_>)newValue);
        return;
      case UmplePackage.ORDINAL_OP___SMALLER_OP_1:
        getSmallerOp_1().clear();
        getSmallerOp_1().addAll((Collection<? extends SmallerOp_>)newValue);
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
      case UmplePackage.ORDINAL_OP___GREATER_OP_1:
        getGreaterOp_1().clear();
        return;
      case UmplePackage.ORDINAL_OP___LESS_OP_1:
        getLessOp_1().clear();
        return;
      case UmplePackage.ORDINAL_OP___MORE_OP_1:
        getMoreOp_1().clear();
        return;
      case UmplePackage.ORDINAL_OP___SMALLER_OP_1:
        getSmallerOp_1().clear();
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
      case UmplePackage.ORDINAL_OP___GREATER_OP_1:
        return greaterOp_1 != null && !greaterOp_1.isEmpty();
      case UmplePackage.ORDINAL_OP___LESS_OP_1:
        return lessOp_1 != null && !lessOp_1.isEmpty();
      case UmplePackage.ORDINAL_OP___MORE_OP_1:
        return moreOp_1 != null && !moreOp_1.isEmpty();
      case UmplePackage.ORDINAL_OP___SMALLER_OP_1:
        return smallerOp_1 != null && !smallerOp_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //OrdinalOp_Impl
