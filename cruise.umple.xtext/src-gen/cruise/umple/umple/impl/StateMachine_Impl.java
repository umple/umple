/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ActiveDefinition_;
import cruise.umple.umple.Enum_;
import cruise.umple.umple.InlineStateMachine_;
import cruise.umple.umple.ReferencedStateMachine_;
import cruise.umple.umple.StateMachine_;
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
 * An implementation of the model object '<em><b>State Machine </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.StateMachine_Impl#getEnum_1 <em>Enum 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateMachine_Impl#getInlineStateMachine_1 <em>Inline State Machine 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateMachine_Impl#getReferencedStateMachine_1 <em>Referenced State Machine 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateMachine_Impl#getActiveDefinition_1 <em>Active Definition 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateMachine_Impl extends MinimalEObjectImpl.Container implements StateMachine_
{
  /**
   * The cached value of the '{@link #getEnum_1() <em>Enum 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnum_1()
   * @generated
   * @ordered
   */
  protected EList<Enum_> enum_1;

  /**
   * The cached value of the '{@link #getInlineStateMachine_1() <em>Inline State Machine 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInlineStateMachine_1()
   * @generated
   * @ordered
   */
  protected EList<InlineStateMachine_> inlineStateMachine_1;

  /**
   * The cached value of the '{@link #getReferencedStateMachine_1() <em>Referenced State Machine 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencedStateMachine_1()
   * @generated
   * @ordered
   */
  protected EList<ReferencedStateMachine_> referencedStateMachine_1;

  /**
   * The cached value of the '{@link #getActiveDefinition_1() <em>Active Definition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActiveDefinition_1()
   * @generated
   * @ordered
   */
  protected EList<ActiveDefinition_> activeDefinition_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateMachine_Impl()
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
    return UmplePackage.eINSTANCE.getStateMachine_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Enum_> getEnum_1()
  {
    if (enum_1 == null)
    {
      enum_1 = new EObjectContainmentEList<Enum_>(Enum_.class, this, UmplePackage.STATE_MACHINE___ENUM_1);
    }
    return enum_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InlineStateMachine_> getInlineStateMachine_1()
  {
    if (inlineStateMachine_1 == null)
    {
      inlineStateMachine_1 = new EObjectContainmentEList<InlineStateMachine_>(InlineStateMachine_.class, this, UmplePackage.STATE_MACHINE___INLINE_STATE_MACHINE_1);
    }
    return inlineStateMachine_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ReferencedStateMachine_> getReferencedStateMachine_1()
  {
    if (referencedStateMachine_1 == null)
    {
      referencedStateMachine_1 = new EObjectContainmentEList<ReferencedStateMachine_>(ReferencedStateMachine_.class, this, UmplePackage.STATE_MACHINE___REFERENCED_STATE_MACHINE_1);
    }
    return referencedStateMachine_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ActiveDefinition_> getActiveDefinition_1()
  {
    if (activeDefinition_1 == null)
    {
      activeDefinition_1 = new EObjectContainmentEList<ActiveDefinition_>(ActiveDefinition_.class, this, UmplePackage.STATE_MACHINE___ACTIVE_DEFINITION_1);
    }
    return activeDefinition_1;
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
      case UmplePackage.STATE_MACHINE___ENUM_1:
        return ((InternalEList<?>)getEnum_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.STATE_MACHINE___INLINE_STATE_MACHINE_1:
        return ((InternalEList<?>)getInlineStateMachine_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.STATE_MACHINE___REFERENCED_STATE_MACHINE_1:
        return ((InternalEList<?>)getReferencedStateMachine_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.STATE_MACHINE___ACTIVE_DEFINITION_1:
        return ((InternalEList<?>)getActiveDefinition_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.STATE_MACHINE___ENUM_1:
        return getEnum_1();
      case UmplePackage.STATE_MACHINE___INLINE_STATE_MACHINE_1:
        return getInlineStateMachine_1();
      case UmplePackage.STATE_MACHINE___REFERENCED_STATE_MACHINE_1:
        return getReferencedStateMachine_1();
      case UmplePackage.STATE_MACHINE___ACTIVE_DEFINITION_1:
        return getActiveDefinition_1();
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
      case UmplePackage.STATE_MACHINE___ENUM_1:
        getEnum_1().clear();
        getEnum_1().addAll((Collection<? extends Enum_>)newValue);
        return;
      case UmplePackage.STATE_MACHINE___INLINE_STATE_MACHINE_1:
        getInlineStateMachine_1().clear();
        getInlineStateMachine_1().addAll((Collection<? extends InlineStateMachine_>)newValue);
        return;
      case UmplePackage.STATE_MACHINE___REFERENCED_STATE_MACHINE_1:
        getReferencedStateMachine_1().clear();
        getReferencedStateMachine_1().addAll((Collection<? extends ReferencedStateMachine_>)newValue);
        return;
      case UmplePackage.STATE_MACHINE___ACTIVE_DEFINITION_1:
        getActiveDefinition_1().clear();
        getActiveDefinition_1().addAll((Collection<? extends ActiveDefinition_>)newValue);
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
      case UmplePackage.STATE_MACHINE___ENUM_1:
        getEnum_1().clear();
        return;
      case UmplePackage.STATE_MACHINE___INLINE_STATE_MACHINE_1:
        getInlineStateMachine_1().clear();
        return;
      case UmplePackage.STATE_MACHINE___REFERENCED_STATE_MACHINE_1:
        getReferencedStateMachine_1().clear();
        return;
      case UmplePackage.STATE_MACHINE___ACTIVE_DEFINITION_1:
        getActiveDefinition_1().clear();
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
      case UmplePackage.STATE_MACHINE___ENUM_1:
        return enum_1 != null && !enum_1.isEmpty();
      case UmplePackage.STATE_MACHINE___INLINE_STATE_MACHINE_1:
        return inlineStateMachine_1 != null && !inlineStateMachine_1.isEmpty();
      case UmplePackage.STATE_MACHINE___REFERENCED_STATE_MACHINE_1:
        return referencedStateMachine_1 != null && !referencedStateMachine_1.isEmpty();
      case UmplePackage.STATE_MACHINE___ACTIVE_DEFINITION_1:
        return activeDefinition_1 != null && !activeDefinition_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StateMachine_Impl
