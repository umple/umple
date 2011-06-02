/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ExternalLanguage;
import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.functionDefinition;
import cruise.umple.umple.phpFunction;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Language</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ExternalLanguageImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ExternalLanguageImpl#getRubyFunctions <em>Ruby Functions</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ExternalLanguageImpl#getPhpFunctions <em>Php Functions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalLanguageImpl extends MinimalEObjectImpl.Container implements ExternalLanguage
{
  /**
   * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctions()
   * @generated
   * @ordered
   */
  protected EList<functionDefinition> functions;

  /**
   * The cached value of the '{@link #getRubyFunctions() <em>Ruby Functions</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRubyFunctions()
   * @generated
   * @ordered
   */
  protected EList<String> rubyFunctions;

  /**
   * The cached value of the '{@link #getPhpFunctions() <em>Php Functions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPhpFunctions()
   * @generated
   * @ordered
   */
  protected EList<phpFunction> phpFunctions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExternalLanguageImpl()
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
    return UmplePackage.Literals.EXTERNAL_LANGUAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<functionDefinition> getFunctions()
  {
    if (functions == null)
    {
      functions = new EObjectContainmentEList<functionDefinition>(functionDefinition.class, this, UmplePackage.EXTERNAL_LANGUAGE__FUNCTIONS);
    }
    return functions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getRubyFunctions()
  {
    if (rubyFunctions == null)
    {
      rubyFunctions = new EDataTypeEList<String>(String.class, this, UmplePackage.EXTERNAL_LANGUAGE__RUBY_FUNCTIONS);
    }
    return rubyFunctions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<phpFunction> getPhpFunctions()
  {
    if (phpFunctions == null)
    {
      phpFunctions = new EObjectContainmentEList<phpFunction>(phpFunction.class, this, UmplePackage.EXTERNAL_LANGUAGE__PHP_FUNCTIONS);
    }
    return phpFunctions;
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
      case UmplePackage.EXTERNAL_LANGUAGE__FUNCTIONS:
        return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
      case UmplePackage.EXTERNAL_LANGUAGE__PHP_FUNCTIONS:
        return ((InternalEList<?>)getPhpFunctions()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.EXTERNAL_LANGUAGE__FUNCTIONS:
        return getFunctions();
      case UmplePackage.EXTERNAL_LANGUAGE__RUBY_FUNCTIONS:
        return getRubyFunctions();
      case UmplePackage.EXTERNAL_LANGUAGE__PHP_FUNCTIONS:
        return getPhpFunctions();
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
      case UmplePackage.EXTERNAL_LANGUAGE__FUNCTIONS:
        getFunctions().clear();
        getFunctions().addAll((Collection<? extends functionDefinition>)newValue);
        return;
      case UmplePackage.EXTERNAL_LANGUAGE__RUBY_FUNCTIONS:
        getRubyFunctions().clear();
        getRubyFunctions().addAll((Collection<? extends String>)newValue);
        return;
      case UmplePackage.EXTERNAL_LANGUAGE__PHP_FUNCTIONS:
        getPhpFunctions().clear();
        getPhpFunctions().addAll((Collection<? extends phpFunction>)newValue);
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
      case UmplePackage.EXTERNAL_LANGUAGE__FUNCTIONS:
        getFunctions().clear();
        return;
      case UmplePackage.EXTERNAL_LANGUAGE__RUBY_FUNCTIONS:
        getRubyFunctions().clear();
        return;
      case UmplePackage.EXTERNAL_LANGUAGE__PHP_FUNCTIONS:
        getPhpFunctions().clear();
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
      case UmplePackage.EXTERNAL_LANGUAGE__FUNCTIONS:
        return functions != null && !functions.isEmpty();
      case UmplePackage.EXTERNAL_LANGUAGE__RUBY_FUNCTIONS:
        return rubyFunctions != null && !rubyFunctions.isEmpty();
      case UmplePackage.EXTERNAL_LANGUAGE__PHP_FUNCTIONS:
        return phpFunctions != null && !phpFunctions.isEmpty();
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
    result.append(" (rubyFunctions: ");
    result.append(rubyFunctions);
    result.append(')');
    return result.toString();
  }

} //ExternalLanguageImpl
