/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmpleAssociationClass;
import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.associationClassContent;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.UmpleAssociationClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleAssociationClassImpl#getAssociationClassContents <em>Association Class Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UmpleAssociationClassImpl extends MinimalEObjectImpl.Container implements UmpleAssociationClass
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getAssociationClassContents() <em>Association Class Contents</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationClassContents()
   * @generated
   * @ordered
   */
  protected EList<associationClassContent> associationClassContents;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UmpleAssociationClassImpl()
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
    return UmplePackage.Literals.UMPLE_ASSOCIATION_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_ASSOCIATION_CLASS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<associationClassContent> getAssociationClassContents()
  {
    if (associationClassContents == null)
    {
      associationClassContents = new EObjectContainmentEList<associationClassContent>(associationClassContent.class, this, UmplePackage.UMPLE_ASSOCIATION_CLASS__ASSOCIATION_CLASS_CONTENTS);
    }
    return associationClassContents;
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
      case UmplePackage.UMPLE_ASSOCIATION_CLASS__ASSOCIATION_CLASS_CONTENTS:
        return ((InternalEList<?>)getAssociationClassContents()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.UMPLE_ASSOCIATION_CLASS__NAME:
        return getName();
      case UmplePackage.UMPLE_ASSOCIATION_CLASS__ASSOCIATION_CLASS_CONTENTS:
        return getAssociationClassContents();
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
      case UmplePackage.UMPLE_ASSOCIATION_CLASS__NAME:
        setName((String)newValue);
        return;
      case UmplePackage.UMPLE_ASSOCIATION_CLASS__ASSOCIATION_CLASS_CONTENTS:
        getAssociationClassContents().clear();
        getAssociationClassContents().addAll((Collection<? extends associationClassContent>)newValue);
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
      case UmplePackage.UMPLE_ASSOCIATION_CLASS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UmplePackage.UMPLE_ASSOCIATION_CLASS__ASSOCIATION_CLASS_CONTENTS:
        getAssociationClassContents().clear();
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
      case UmplePackage.UMPLE_ASSOCIATION_CLASS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UmplePackage.UMPLE_ASSOCIATION_CLASS__ASSOCIATION_CLASS_CONTENTS:
        return associationClassContents != null && !associationClassContents.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //UmpleAssociationClassImpl
