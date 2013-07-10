/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_methodBody_2_;
import cruise.umple.umple.Postcondition_;
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
 * An implementation of the model object '<em><b>Anonymous method Body 2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_methodBody_2_Impl#getPostcondition_1 <em>Postcondition 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_methodBody_2_Impl extends MinimalEObjectImpl.Container implements Anonymous_methodBody_2_
{
  /**
   * The cached value of the '{@link #getPostcondition_1() <em>Postcondition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostcondition_1()
   * @generated
   * @ordered
   */
  protected EList<Postcondition_> postcondition_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_methodBody_2_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_methodBody_2_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Postcondition_> getPostcondition_1()
  {
    if (postcondition_1 == null)
    {
      postcondition_1 = new EObjectContainmentEList<Postcondition_>(Postcondition_.class, this, UmplePackage.ANONYMOUS_METHOD_BODY_2__POSTCONDITION_1);
    }
    return postcondition_1;
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
      case UmplePackage.ANONYMOUS_METHOD_BODY_2__POSTCONDITION_1:
        return ((InternalEList<?>)getPostcondition_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_METHOD_BODY_2__POSTCONDITION_1:
        return getPostcondition_1();
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
      case UmplePackage.ANONYMOUS_METHOD_BODY_2__POSTCONDITION_1:
        getPostcondition_1().clear();
        getPostcondition_1().addAll((Collection<? extends Postcondition_>)newValue);
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
      case UmplePackage.ANONYMOUS_METHOD_BODY_2__POSTCONDITION_1:
        getPostcondition_1().clear();
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
      case UmplePackage.ANONYMOUS_METHOD_BODY_2__POSTCONDITION_1:
        return postcondition_1 != null && !postcondition_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_methodBody_2_Impl
