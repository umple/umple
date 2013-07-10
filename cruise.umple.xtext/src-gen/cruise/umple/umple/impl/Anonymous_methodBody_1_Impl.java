/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_methodBody_1_;
import cruise.umple.umple.Precondition_;
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
 * An implementation of the model object '<em><b>Anonymous method Body 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_methodBody_1_Impl#getPrecondition_1 <em>Precondition 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_methodBody_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_methodBody_1_
{
  /**
   * The cached value of the '{@link #getPrecondition_1() <em>Precondition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrecondition_1()
   * @generated
   * @ordered
   */
  protected EList<Precondition_> precondition_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_methodBody_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_methodBody_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Precondition_> getPrecondition_1()
  {
    if (precondition_1 == null)
    {
      precondition_1 = new EObjectContainmentEList<Precondition_>(Precondition_.class, this, UmplePackage.ANONYMOUS_METHOD_BODY_1__PRECONDITION_1);
    }
    return precondition_1;
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
      case UmplePackage.ANONYMOUS_METHOD_BODY_1__PRECONDITION_1:
        return ((InternalEList<?>)getPrecondition_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_METHOD_BODY_1__PRECONDITION_1:
        return getPrecondition_1();
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
      case UmplePackage.ANONYMOUS_METHOD_BODY_1__PRECONDITION_1:
        getPrecondition_1().clear();
        getPrecondition_1().addAll((Collection<? extends Precondition_>)newValue);
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
      case UmplePackage.ANONYMOUS_METHOD_BODY_1__PRECONDITION_1:
        getPrecondition_1().clear();
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
      case UmplePackage.ANONYMOUS_METHOD_BODY_1__PRECONDITION_1:
        return precondition_1 != null && !precondition_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_methodBody_1_Impl
