/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Attribute_;
import cruise.umple.umple.AutouniqueAttribute_;
import cruise.umple.umple.ComplexAttribute_;
import cruise.umple.umple.DerivedAttribute_;
import cruise.umple.umple.SimpleAttribute_;
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
 * An implementation of the model object '<em><b>Attribute </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Attribute_Impl#getSimpleAttribute_1 <em>Simple Attribute 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Attribute_Impl#getAutouniqueAttribute_1 <em>Autounique Attribute 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Attribute_Impl#getDerivedAttribute_1 <em>Derived Attribute 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Attribute_Impl#getComplexAttribute_1 <em>Complex Attribute 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Attribute_Impl extends MinimalEObjectImpl.Container implements Attribute_
{
  /**
   * The cached value of the '{@link #getSimpleAttribute_1() <em>Simple Attribute 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSimpleAttribute_1()
   * @generated
   * @ordered
   */
  protected EList<SimpleAttribute_> simpleAttribute_1;

  /**
   * The cached value of the '{@link #getAutouniqueAttribute_1() <em>Autounique Attribute 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAutouniqueAttribute_1()
   * @generated
   * @ordered
   */
  protected EList<AutouniqueAttribute_> autouniqueAttribute_1;

  /**
   * The cached value of the '{@link #getDerivedAttribute_1() <em>Derived Attribute 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDerivedAttribute_1()
   * @generated
   * @ordered
   */
  protected EList<DerivedAttribute_> derivedAttribute_1;

  /**
   * The cached value of the '{@link #getComplexAttribute_1() <em>Complex Attribute 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComplexAttribute_1()
   * @generated
   * @ordered
   */
  protected EList<ComplexAttribute_> complexAttribute_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Attribute_Impl()
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
    return UmplePackage.eINSTANCE.getAttribute_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SimpleAttribute_> getSimpleAttribute_1()
  {
    if (simpleAttribute_1 == null)
    {
      simpleAttribute_1 = new EObjectContainmentEList<SimpleAttribute_>(SimpleAttribute_.class, this, UmplePackage.ATTRIBUTE___SIMPLE_ATTRIBUTE_1);
    }
    return simpleAttribute_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AutouniqueAttribute_> getAutouniqueAttribute_1()
  {
    if (autouniqueAttribute_1 == null)
    {
      autouniqueAttribute_1 = new EObjectContainmentEList<AutouniqueAttribute_>(AutouniqueAttribute_.class, this, UmplePackage.ATTRIBUTE___AUTOUNIQUE_ATTRIBUTE_1);
    }
    return autouniqueAttribute_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DerivedAttribute_> getDerivedAttribute_1()
  {
    if (derivedAttribute_1 == null)
    {
      derivedAttribute_1 = new EObjectContainmentEList<DerivedAttribute_>(DerivedAttribute_.class, this, UmplePackage.ATTRIBUTE___DERIVED_ATTRIBUTE_1);
    }
    return derivedAttribute_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComplexAttribute_> getComplexAttribute_1()
  {
    if (complexAttribute_1 == null)
    {
      complexAttribute_1 = new EObjectContainmentEList<ComplexAttribute_>(ComplexAttribute_.class, this, UmplePackage.ATTRIBUTE___COMPLEX_ATTRIBUTE_1);
    }
    return complexAttribute_1;
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
      case UmplePackage.ATTRIBUTE___SIMPLE_ATTRIBUTE_1:
        return ((InternalEList<?>)getSimpleAttribute_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ATTRIBUTE___AUTOUNIQUE_ATTRIBUTE_1:
        return ((InternalEList<?>)getAutouniqueAttribute_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ATTRIBUTE___DERIVED_ATTRIBUTE_1:
        return ((InternalEList<?>)getDerivedAttribute_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ATTRIBUTE___COMPLEX_ATTRIBUTE_1:
        return ((InternalEList<?>)getComplexAttribute_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ATTRIBUTE___SIMPLE_ATTRIBUTE_1:
        return getSimpleAttribute_1();
      case UmplePackage.ATTRIBUTE___AUTOUNIQUE_ATTRIBUTE_1:
        return getAutouniqueAttribute_1();
      case UmplePackage.ATTRIBUTE___DERIVED_ATTRIBUTE_1:
        return getDerivedAttribute_1();
      case UmplePackage.ATTRIBUTE___COMPLEX_ATTRIBUTE_1:
        return getComplexAttribute_1();
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
      case UmplePackage.ATTRIBUTE___SIMPLE_ATTRIBUTE_1:
        getSimpleAttribute_1().clear();
        getSimpleAttribute_1().addAll((Collection<? extends SimpleAttribute_>)newValue);
        return;
      case UmplePackage.ATTRIBUTE___AUTOUNIQUE_ATTRIBUTE_1:
        getAutouniqueAttribute_1().clear();
        getAutouniqueAttribute_1().addAll((Collection<? extends AutouniqueAttribute_>)newValue);
        return;
      case UmplePackage.ATTRIBUTE___DERIVED_ATTRIBUTE_1:
        getDerivedAttribute_1().clear();
        getDerivedAttribute_1().addAll((Collection<? extends DerivedAttribute_>)newValue);
        return;
      case UmplePackage.ATTRIBUTE___COMPLEX_ATTRIBUTE_1:
        getComplexAttribute_1().clear();
        getComplexAttribute_1().addAll((Collection<? extends ComplexAttribute_>)newValue);
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
      case UmplePackage.ATTRIBUTE___SIMPLE_ATTRIBUTE_1:
        getSimpleAttribute_1().clear();
        return;
      case UmplePackage.ATTRIBUTE___AUTOUNIQUE_ATTRIBUTE_1:
        getAutouniqueAttribute_1().clear();
        return;
      case UmplePackage.ATTRIBUTE___DERIVED_ATTRIBUTE_1:
        getDerivedAttribute_1().clear();
        return;
      case UmplePackage.ATTRIBUTE___COMPLEX_ATTRIBUTE_1:
        getComplexAttribute_1().clear();
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
      case UmplePackage.ATTRIBUTE___SIMPLE_ATTRIBUTE_1:
        return simpleAttribute_1 != null && !simpleAttribute_1.isEmpty();
      case UmplePackage.ATTRIBUTE___AUTOUNIQUE_ATTRIBUTE_1:
        return autouniqueAttribute_1 != null && !autouniqueAttribute_1.isEmpty();
      case UmplePackage.ATTRIBUTE___DERIVED_ATTRIBUTE_1:
        return derivedAttribute_1 != null && !derivedAttribute_1.isEmpty();
      case UmplePackage.ATTRIBUTE___COMPLEX_ATTRIBUTE_1:
        return complexAttribute_1 != null && !complexAttribute_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Attribute_Impl
