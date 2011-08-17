/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.variableDeclarator;
import cruise.umple.umple.variableDeclarators;

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
 * An implementation of the model object '<em><b>variable Declarators</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.variableDeclaratorsImpl#getVd <em>Vd</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class variableDeclaratorsImpl extends MinimalEObjectImpl.Container implements variableDeclarators
{
  /**
   * The cached value of the '{@link #getVd() <em>Vd</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVd()
   * @generated
   * @ordered
   */
  protected EList<variableDeclarator> vd;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected variableDeclaratorsImpl()
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
    return UmplePackage.Literals.VARIABLE_DECLARATORS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<variableDeclarator> getVd()
  {
    if (vd == null)
    {
      vd = new EObjectContainmentEList<variableDeclarator>(variableDeclarator.class, this, UmplePackage.VARIABLE_DECLARATORS__VD);
    }
    return vd;
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
      case UmplePackage.VARIABLE_DECLARATORS__VD:
        return ((InternalEList<?>)getVd()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.VARIABLE_DECLARATORS__VD:
        return getVd();
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
      case UmplePackage.VARIABLE_DECLARATORS__VD:
        getVd().clear();
        getVd().addAll((Collection<? extends variableDeclarator>)newValue);
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
      case UmplePackage.VARIABLE_DECLARATORS__VD:
        getVd().clear();
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
      case UmplePackage.VARIABLE_DECLARATORS__VD:
        return vd != null && !vd.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //variableDeclaratorsImpl
