/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AssociationClassContent;
import cruise.umple.umple.AssociationClassDefinition;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association Class Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassDefinitionImpl#getAssociationClassContent <em>Association Class Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationClassDefinitionImpl extends EntityImpl implements AssociationClassDefinition
{
  /**
   * The cached value of the '{@link #getAssociationClassContent() <em>Association Class Content</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationClassContent()
   * @generated
   * @ordered
   */
  protected EList<AssociationClassContent> associationClassContent;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssociationClassDefinitionImpl()
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
    return UmplePackage.Literals.ASSOCIATION_CLASS_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssociationClassContent> getAssociationClassContent()
  {
    if (associationClassContent == null)
    {
      associationClassContent = new EObjectContainmentEList<AssociationClassContent>(AssociationClassContent.class, this, UmplePackage.ASSOCIATION_CLASS_DEFINITION__ASSOCIATION_CLASS_CONTENT);
    }
    return associationClassContent;
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
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION__ASSOCIATION_CLASS_CONTENT:
        return ((InternalEList<?>)getAssociationClassContent()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION__ASSOCIATION_CLASS_CONTENT:
        return getAssociationClassContent();
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
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION__ASSOCIATION_CLASS_CONTENT:
        getAssociationClassContent().clear();
        getAssociationClassContent().addAll((Collection<? extends AssociationClassContent>)newValue);
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
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION__ASSOCIATION_CLASS_CONTENT:
        getAssociationClassContent().clear();
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
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION__ASSOCIATION_CLASS_CONTENT:
        return associationClassContent != null && !associationClassContent.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AssociationClassDefinitionImpl
