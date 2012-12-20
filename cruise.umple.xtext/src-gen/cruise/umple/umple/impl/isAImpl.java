/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmpleElement;
import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.isA;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>is A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.isAImpl#getExtendsClass <em>Extends Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class isAImpl extends SoftwarePatternImpl implements isA
{
  /**
   * The cached value of the '{@link #getExtendsClass() <em>Extends Class</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendsClass()
   * @generated
   * @ordered
   */
  protected EList<UmpleElement> extendsClass;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected isAImpl()
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
    return UmplePackage.Literals.IS_A;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UmpleElement> getExtendsClass()
  {
    if (extendsClass == null)
    {
      extendsClass = new EObjectResolvingEList<UmpleElement>(UmpleElement.class, this, UmplePackage.IS_A__EXTENDS_CLASS);
    }
    return extendsClass;
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
      case UmplePackage.IS_A__EXTENDS_CLASS:
        return getExtendsClass();
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
      case UmplePackage.IS_A__EXTENDS_CLASS:
        getExtendsClass().clear();
        getExtendsClass().addAll((Collection<? extends UmpleElement>)newValue);
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
      case UmplePackage.IS_A__EXTENDS_CLASS:
        getExtendsClass().clear();
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
      case UmplePackage.IS_A__EXTENDS_CLASS:
        return extendsClass != null && !extendsClass.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //isAImpl
