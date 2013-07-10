/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AssociationClassContent_;
import cruise.umple.umple.AssociationClassDefinition_;
import cruise.umple.umple.UmplePackage;

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
 * An implementation of the model object '<em><b>Association Class Definition </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassDefinition_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassDefinition_Impl#getAssociationClassContent_1 <em>Association Class Content 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationClassDefinition_Impl extends MinimalEObjectImpl.Container implements AssociationClassDefinition_
{
  /**
   * The default value of the '{@link #getName_1() <em>Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName_1()
   * @generated
   * @ordered
   */
  protected static final String NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName_1() <em>Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName_1()
   * @generated
   * @ordered
   */
  protected String name_1 = NAME_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAssociationClassContent_1() <em>Association Class Content 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationClassContent_1()
   * @generated
   * @ordered
   */
  protected EList<AssociationClassContent_> associationClassContent_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssociationClassDefinition_Impl()
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
    return UmplePackage.eINSTANCE.getAssociationClassDefinition_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName_1()
  {
    return name_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName_1(String newName_1)
  {
    String oldName_1 = name_1;
    name_1 = newName_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ASSOCIATION_CLASS_DEFINITION___NAME_1, oldName_1, name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssociationClassContent_> getAssociationClassContent_1()
  {
    if (associationClassContent_1 == null)
    {
      associationClassContent_1 = new EObjectContainmentEList<AssociationClassContent_>(AssociationClassContent_.class, this, UmplePackage.ASSOCIATION_CLASS_DEFINITION___ASSOCIATION_CLASS_CONTENT_1);
    }
    return associationClassContent_1;
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
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION___ASSOCIATION_CLASS_CONTENT_1:
        return ((InternalEList<?>)getAssociationClassContent_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION___NAME_1:
        return getName_1();
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION___ASSOCIATION_CLASS_CONTENT_1:
        return getAssociationClassContent_1();
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
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION___ASSOCIATION_CLASS_CONTENT_1:
        getAssociationClassContent_1().clear();
        getAssociationClassContent_1().addAll((Collection<? extends AssociationClassContent_>)newValue);
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
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION___ASSOCIATION_CLASS_CONTENT_1:
        getAssociationClassContent_1().clear();
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
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION___ASSOCIATION_CLASS_CONTENT_1:
        return associationClassContent_1 != null && !associationClassContent_1.isEmpty();
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
    result.append(" (name_1: ");
    result.append(name_1);
    result.append(')');
    return result.toString();
  }

} //AssociationClassDefinition_Impl
