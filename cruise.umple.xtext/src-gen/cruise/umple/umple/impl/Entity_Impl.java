/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AssociationClassDefinition_;
import cruise.umple.umple.AssociationDefinition_;
import cruise.umple.umple.ClassDefinition_;
import cruise.umple.umple.Entity_;
import cruise.umple.umple.ExternalDefinition_;
import cruise.umple.umple.InterfaceDefinition_;
import cruise.umple.umple.StateMachineDefinition_;
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
 * An implementation of the model object '<em><b>Entity </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Entity_Impl#getClassDefinition_1 <em>Class Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Entity_Impl#getInterfaceDefinition_1 <em>Interface Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Entity_Impl#getExternalDefinition_1 <em>External Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Entity_Impl#getAssociationDefinition_1 <em>Association Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Entity_Impl#getAssociationClassDefinition_1 <em>Association Class Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Entity_Impl#getStateMachineDefinition_1 <em>State Machine Definition 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Entity_Impl extends MinimalEObjectImpl.Container implements Entity_
{
  /**
   * The cached value of the '{@link #getClassDefinition_1() <em>Class Definition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassDefinition_1()
   * @generated
   * @ordered
   */
  protected EList<ClassDefinition_> classDefinition_1;

  /**
   * The cached value of the '{@link #getInterfaceDefinition_1() <em>Interface Definition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfaceDefinition_1()
   * @generated
   * @ordered
   */
  protected EList<InterfaceDefinition_> interfaceDefinition_1;

  /**
   * The cached value of the '{@link #getExternalDefinition_1() <em>External Definition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExternalDefinition_1()
   * @generated
   * @ordered
   */
  protected EList<ExternalDefinition_> externalDefinition_1;

  /**
   * The cached value of the '{@link #getAssociationDefinition_1() <em>Association Definition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationDefinition_1()
   * @generated
   * @ordered
   */
  protected EList<AssociationDefinition_> associationDefinition_1;

  /**
   * The cached value of the '{@link #getAssociationClassDefinition_1() <em>Association Class Definition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationClassDefinition_1()
   * @generated
   * @ordered
   */
  protected EList<AssociationClassDefinition_> associationClassDefinition_1;

  /**
   * The cached value of the '{@link #getStateMachineDefinition_1() <em>State Machine Definition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateMachineDefinition_1()
   * @generated
   * @ordered
   */
  protected EList<StateMachineDefinition_> stateMachineDefinition_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Entity_Impl()
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
    return UmplePackage.eINSTANCE.getEntity_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClassDefinition_> getClassDefinition_1()
  {
    if (classDefinition_1 == null)
    {
      classDefinition_1 = new EObjectContainmentEList<ClassDefinition_>(ClassDefinition_.class, this, UmplePackage.ENTITY___CLASS_DEFINITION_1);
    }
    return classDefinition_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InterfaceDefinition_> getInterfaceDefinition_1()
  {
    if (interfaceDefinition_1 == null)
    {
      interfaceDefinition_1 = new EObjectContainmentEList<InterfaceDefinition_>(InterfaceDefinition_.class, this, UmplePackage.ENTITY___INTERFACE_DEFINITION_1);
    }
    return interfaceDefinition_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExternalDefinition_> getExternalDefinition_1()
  {
    if (externalDefinition_1 == null)
    {
      externalDefinition_1 = new EObjectContainmentEList<ExternalDefinition_>(ExternalDefinition_.class, this, UmplePackage.ENTITY___EXTERNAL_DEFINITION_1);
    }
    return externalDefinition_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssociationDefinition_> getAssociationDefinition_1()
  {
    if (associationDefinition_1 == null)
    {
      associationDefinition_1 = new EObjectContainmentEList<AssociationDefinition_>(AssociationDefinition_.class, this, UmplePackage.ENTITY___ASSOCIATION_DEFINITION_1);
    }
    return associationDefinition_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssociationClassDefinition_> getAssociationClassDefinition_1()
  {
    if (associationClassDefinition_1 == null)
    {
      associationClassDefinition_1 = new EObjectContainmentEList<AssociationClassDefinition_>(AssociationClassDefinition_.class, this, UmplePackage.ENTITY___ASSOCIATION_CLASS_DEFINITION_1);
    }
    return associationClassDefinition_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StateMachineDefinition_> getStateMachineDefinition_1()
  {
    if (stateMachineDefinition_1 == null)
    {
      stateMachineDefinition_1 = new EObjectContainmentEList<StateMachineDefinition_>(StateMachineDefinition_.class, this, UmplePackage.ENTITY___STATE_MACHINE_DEFINITION_1);
    }
    return stateMachineDefinition_1;
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
      case UmplePackage.ENTITY___CLASS_DEFINITION_1:
        return ((InternalEList<?>)getClassDefinition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ENTITY___INTERFACE_DEFINITION_1:
        return ((InternalEList<?>)getInterfaceDefinition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ENTITY___EXTERNAL_DEFINITION_1:
        return ((InternalEList<?>)getExternalDefinition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ENTITY___ASSOCIATION_DEFINITION_1:
        return ((InternalEList<?>)getAssociationDefinition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ENTITY___ASSOCIATION_CLASS_DEFINITION_1:
        return ((InternalEList<?>)getAssociationClassDefinition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ENTITY___STATE_MACHINE_DEFINITION_1:
        return ((InternalEList<?>)getStateMachineDefinition_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ENTITY___CLASS_DEFINITION_1:
        return getClassDefinition_1();
      case UmplePackage.ENTITY___INTERFACE_DEFINITION_1:
        return getInterfaceDefinition_1();
      case UmplePackage.ENTITY___EXTERNAL_DEFINITION_1:
        return getExternalDefinition_1();
      case UmplePackage.ENTITY___ASSOCIATION_DEFINITION_1:
        return getAssociationDefinition_1();
      case UmplePackage.ENTITY___ASSOCIATION_CLASS_DEFINITION_1:
        return getAssociationClassDefinition_1();
      case UmplePackage.ENTITY___STATE_MACHINE_DEFINITION_1:
        return getStateMachineDefinition_1();
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
      case UmplePackage.ENTITY___CLASS_DEFINITION_1:
        getClassDefinition_1().clear();
        getClassDefinition_1().addAll((Collection<? extends ClassDefinition_>)newValue);
        return;
      case UmplePackage.ENTITY___INTERFACE_DEFINITION_1:
        getInterfaceDefinition_1().clear();
        getInterfaceDefinition_1().addAll((Collection<? extends InterfaceDefinition_>)newValue);
        return;
      case UmplePackage.ENTITY___EXTERNAL_DEFINITION_1:
        getExternalDefinition_1().clear();
        getExternalDefinition_1().addAll((Collection<? extends ExternalDefinition_>)newValue);
        return;
      case UmplePackage.ENTITY___ASSOCIATION_DEFINITION_1:
        getAssociationDefinition_1().clear();
        getAssociationDefinition_1().addAll((Collection<? extends AssociationDefinition_>)newValue);
        return;
      case UmplePackage.ENTITY___ASSOCIATION_CLASS_DEFINITION_1:
        getAssociationClassDefinition_1().clear();
        getAssociationClassDefinition_1().addAll((Collection<? extends AssociationClassDefinition_>)newValue);
        return;
      case UmplePackage.ENTITY___STATE_MACHINE_DEFINITION_1:
        getStateMachineDefinition_1().clear();
        getStateMachineDefinition_1().addAll((Collection<? extends StateMachineDefinition_>)newValue);
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
      case UmplePackage.ENTITY___CLASS_DEFINITION_1:
        getClassDefinition_1().clear();
        return;
      case UmplePackage.ENTITY___INTERFACE_DEFINITION_1:
        getInterfaceDefinition_1().clear();
        return;
      case UmplePackage.ENTITY___EXTERNAL_DEFINITION_1:
        getExternalDefinition_1().clear();
        return;
      case UmplePackage.ENTITY___ASSOCIATION_DEFINITION_1:
        getAssociationDefinition_1().clear();
        return;
      case UmplePackage.ENTITY___ASSOCIATION_CLASS_DEFINITION_1:
        getAssociationClassDefinition_1().clear();
        return;
      case UmplePackage.ENTITY___STATE_MACHINE_DEFINITION_1:
        getStateMachineDefinition_1().clear();
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
      case UmplePackage.ENTITY___CLASS_DEFINITION_1:
        return classDefinition_1 != null && !classDefinition_1.isEmpty();
      case UmplePackage.ENTITY___INTERFACE_DEFINITION_1:
        return interfaceDefinition_1 != null && !interfaceDefinition_1.isEmpty();
      case UmplePackage.ENTITY___EXTERNAL_DEFINITION_1:
        return externalDefinition_1 != null && !externalDefinition_1.isEmpty();
      case UmplePackage.ENTITY___ASSOCIATION_DEFINITION_1:
        return associationDefinition_1 != null && !associationDefinition_1.isEmpty();
      case UmplePackage.ENTITY___ASSOCIATION_CLASS_DEFINITION_1:
        return associationClassDefinition_1 != null && !associationClassDefinition_1.isEmpty();
      case UmplePackage.ENTITY___STATE_MACHINE_DEFINITION_1:
        return stateMachineDefinition_1 != null && !stateMachineDefinition_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Entity_Impl
