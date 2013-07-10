/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.EqualityOp_;
import cruise.umple.umple.EqualsOp_;
import cruise.umple.umple.NotequalsOp_;
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
 * An implementation of the model object '<em><b>Equality Op </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.EqualityOp_Impl#getEqualsOp_1 <em>Equals Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.EqualityOp_Impl#getNotequalsOp_1 <em>Notequals Op 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EqualityOp_Impl extends MinimalEObjectImpl.Container implements EqualityOp_
{
  /**
   * The cached value of the '{@link #getEqualsOp_1() <em>Equals Op 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEqualsOp_1()
   * @generated
   * @ordered
   */
  protected EList<EqualsOp_> equalsOp_1;

  /**
   * The cached value of the '{@link #getNotequalsOp_1() <em>Notequals Op 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNotequalsOp_1()
   * @generated
   * @ordered
   */
  protected EList<NotequalsOp_> notequalsOp_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EqualityOp_Impl()
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
    return UmplePackage.eINSTANCE.getEqualityOp_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EqualsOp_> getEqualsOp_1()
  {
    if (equalsOp_1 == null)
    {
      equalsOp_1 = new EObjectContainmentEList<EqualsOp_>(EqualsOp_.class, this, UmplePackage.EQUALITY_OP___EQUALS_OP_1);
    }
    return equalsOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NotequalsOp_> getNotequalsOp_1()
  {
    if (notequalsOp_1 == null)
    {
      notequalsOp_1 = new EObjectContainmentEList<NotequalsOp_>(NotequalsOp_.class, this, UmplePackage.EQUALITY_OP___NOTEQUALS_OP_1);
    }
    return notequalsOp_1;
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
      case UmplePackage.EQUALITY_OP___EQUALS_OP_1:
        return ((InternalEList<?>)getEqualsOp_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.EQUALITY_OP___NOTEQUALS_OP_1:
        return ((InternalEList<?>)getNotequalsOp_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.EQUALITY_OP___EQUALS_OP_1:
        return getEqualsOp_1();
      case UmplePackage.EQUALITY_OP___NOTEQUALS_OP_1:
        return getNotequalsOp_1();
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
      case UmplePackage.EQUALITY_OP___EQUALS_OP_1:
        getEqualsOp_1().clear();
        getEqualsOp_1().addAll((Collection<? extends EqualsOp_>)newValue);
        return;
      case UmplePackage.EQUALITY_OP___NOTEQUALS_OP_1:
        getNotequalsOp_1().clear();
        getNotequalsOp_1().addAll((Collection<? extends NotequalsOp_>)newValue);
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
      case UmplePackage.EQUALITY_OP___EQUALS_OP_1:
        getEqualsOp_1().clear();
        return;
      case UmplePackage.EQUALITY_OP___NOTEQUALS_OP_1:
        getNotequalsOp_1().clear();
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
      case UmplePackage.EQUALITY_OP___EQUALS_OP_1:
        return equalsOp_1 != null && !equalsOp_1.isEmpty();
      case UmplePackage.EQUALITY_OP___NOTEQUALS_OP_1:
        return notequalsOp_1 != null && !notequalsOp_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EqualityOp_Impl
