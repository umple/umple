/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_derivedAttribute_2_;
import cruise.umple.umple.CodeLang_;
import cruise.umple.umple.CodeLangs_;
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
 * An implementation of the model object '<em><b>Anonymous derived Attribute 2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_derivedAttribute_2_Impl#getCodeLang_1 <em>Code Lang 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_derivedAttribute_2_Impl#getCodeLangs_1 <em>Code Langs 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_derivedAttribute_2_Impl extends MinimalEObjectImpl.Container implements Anonymous_derivedAttribute_2_
{
  /**
   * The cached value of the '{@link #getCodeLang_1() <em>Code Lang 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodeLang_1()
   * @generated
   * @ordered
   */
  protected EList<CodeLang_> codeLang_1;

  /**
   * The cached value of the '{@link #getCodeLangs_1() <em>Code Langs 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodeLangs_1()
   * @generated
   * @ordered
   */
  protected EList<CodeLangs_> codeLangs_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_derivedAttribute_2_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_derivedAttribute_2_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CodeLang_> getCodeLang_1()
  {
    if (codeLang_1 == null)
    {
      codeLang_1 = new EObjectContainmentEList<CodeLang_>(CodeLang_.class, this, UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANG_1);
    }
    return codeLang_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CodeLangs_> getCodeLangs_1()
  {
    if (codeLangs_1 == null)
    {
      codeLangs_1 = new EObjectContainmentEList<CodeLangs_>(CodeLangs_.class, this, UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANGS_1);
    }
    return codeLangs_1;
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
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANG_1:
        return ((InternalEList<?>)getCodeLang_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANGS_1:
        return ((InternalEList<?>)getCodeLangs_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANG_1:
        return getCodeLang_1();
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANGS_1:
        return getCodeLangs_1();
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
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANG_1:
        getCodeLang_1().clear();
        getCodeLang_1().addAll((Collection<? extends CodeLang_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANGS_1:
        getCodeLangs_1().clear();
        getCodeLangs_1().addAll((Collection<? extends CodeLangs_>)newValue);
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
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANG_1:
        getCodeLang_1().clear();
        return;
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANGS_1:
        getCodeLangs_1().clear();
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
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANG_1:
        return codeLang_1 != null && !codeLang_1.isEmpty();
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANGS_1:
        return codeLangs_1 != null && !codeLangs_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_derivedAttribute_2_Impl
