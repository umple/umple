/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_constantDeclaration_1_;
import cruise.umple.umple.Anonymous_constantDeclaration_2_;
import cruise.umple.umple.ConstantDeclaration_;
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
 * An implementation of the model object '<em><b>Constant Declaration </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ConstantDeclaration_Impl#getAnonymous_constantDeclaration_1_1 <em>Anonymous constant Declaration 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConstantDeclaration_Impl#getAnonymous_constantDeclaration_2_1 <em>Anonymous constant Declaration 21</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstantDeclaration_Impl extends MinimalEObjectImpl.Container implements ConstantDeclaration_
{
  /**
   * The cached value of the '{@link #getAnonymous_constantDeclaration_1_1() <em>Anonymous constant Declaration 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_constantDeclaration_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_constantDeclaration_1_> anonymous_constantDeclaration_1_1;

  /**
   * The cached value of the '{@link #getAnonymous_constantDeclaration_2_1() <em>Anonymous constant Declaration 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_constantDeclaration_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_constantDeclaration_2_> anonymous_constantDeclaration_2_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstantDeclaration_Impl()
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
    return UmplePackage.eINSTANCE.getConstantDeclaration_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_constantDeclaration_1_> getAnonymous_constantDeclaration_1_1()
  {
    if (anonymous_constantDeclaration_1_1 == null)
    {
      anonymous_constantDeclaration_1_1 = new EObjectContainmentEList<Anonymous_constantDeclaration_1_>(Anonymous_constantDeclaration_1_.class, this, UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_11);
    }
    return anonymous_constantDeclaration_1_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_constantDeclaration_2_> getAnonymous_constantDeclaration_2_1()
  {
    if (anonymous_constantDeclaration_2_1 == null)
    {
      anonymous_constantDeclaration_2_1 = new EObjectContainmentEList<Anonymous_constantDeclaration_2_>(Anonymous_constantDeclaration_2_.class, this, UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_21);
    }
    return anonymous_constantDeclaration_2_1;
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
      case UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_11:
        return ((InternalEList<?>)getAnonymous_constantDeclaration_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_21:
        return ((InternalEList<?>)getAnonymous_constantDeclaration_2_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_11:
        return getAnonymous_constantDeclaration_1_1();
      case UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_21:
        return getAnonymous_constantDeclaration_2_1();
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
      case UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_11:
        getAnonymous_constantDeclaration_1_1().clear();
        getAnonymous_constantDeclaration_1_1().addAll((Collection<? extends Anonymous_constantDeclaration_1_>)newValue);
        return;
      case UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_21:
        getAnonymous_constantDeclaration_2_1().clear();
        getAnonymous_constantDeclaration_2_1().addAll((Collection<? extends Anonymous_constantDeclaration_2_>)newValue);
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
      case UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_11:
        getAnonymous_constantDeclaration_1_1().clear();
        return;
      case UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_21:
        getAnonymous_constantDeclaration_2_1().clear();
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
      case UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_11:
        return anonymous_constantDeclaration_1_1 != null && !anonymous_constantDeclaration_1_1.isEmpty();
      case UmplePackage.CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_21:
        return anonymous_constantDeclaration_2_1 != null && !anonymous_constantDeclaration_2_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ConstantDeclaration_Impl
