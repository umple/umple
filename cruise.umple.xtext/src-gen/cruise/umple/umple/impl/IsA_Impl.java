/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.IsA_;
import cruise.umple.umple.MultipleIsA_;
import cruise.umple.umple.SingleIsA_;
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
 * An implementation of the model object '<em><b>Is A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.IsA_Impl#getSingleIsA_1 <em>Single Is A1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.IsA_Impl#getMultipleIsA_1 <em>Multiple Is A1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IsA_Impl extends MinimalEObjectImpl.Container implements IsA_
{
  /**
   * The cached value of the '{@link #getSingleIsA_1() <em>Single Is A1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingleIsA_1()
   * @generated
   * @ordered
   */
  protected EList<SingleIsA_> singleIsA_1;

  /**
   * The cached value of the '{@link #getMultipleIsA_1() <em>Multiple Is A1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultipleIsA_1()
   * @generated
   * @ordered
   */
  protected EList<MultipleIsA_> multipleIsA_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IsA_Impl()
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
    return UmplePackage.eINSTANCE.getIsA_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SingleIsA_> getSingleIsA_1()
  {
    if (singleIsA_1 == null)
    {
      singleIsA_1 = new EObjectContainmentEList<SingleIsA_>(SingleIsA_.class, this, UmplePackage.IS_A__SINGLE_IS_A1);
    }
    return singleIsA_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MultipleIsA_> getMultipleIsA_1()
  {
    if (multipleIsA_1 == null)
    {
      multipleIsA_1 = new EObjectContainmentEList<MultipleIsA_>(MultipleIsA_.class, this, UmplePackage.IS_A__MULTIPLE_IS_A1);
    }
    return multipleIsA_1;
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
      case UmplePackage.IS_A__SINGLE_IS_A1:
        return ((InternalEList<?>)getSingleIsA_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.IS_A__MULTIPLE_IS_A1:
        return ((InternalEList<?>)getMultipleIsA_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.IS_A__SINGLE_IS_A1:
        return getSingleIsA_1();
      case UmplePackage.IS_A__MULTIPLE_IS_A1:
        return getMultipleIsA_1();
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
      case UmplePackage.IS_A__SINGLE_IS_A1:
        getSingleIsA_1().clear();
        getSingleIsA_1().addAll((Collection<? extends SingleIsA_>)newValue);
        return;
      case UmplePackage.IS_A__MULTIPLE_IS_A1:
        getMultipleIsA_1().clear();
        getMultipleIsA_1().addAll((Collection<? extends MultipleIsA_>)newValue);
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
      case UmplePackage.IS_A__SINGLE_IS_A1:
        getSingleIsA_1().clear();
        return;
      case UmplePackage.IS_A__MULTIPLE_IS_A1:
        getMultipleIsA_1().clear();
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
      case UmplePackage.IS_A__SINGLE_IS_A1:
        return singleIsA_1 != null && !singleIsA_1.isEmpty();
      case UmplePackage.IS_A__MULTIPLE_IS_A1:
        return multipleIsA_1 != null && !multipleIsA_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //IsA_Impl
