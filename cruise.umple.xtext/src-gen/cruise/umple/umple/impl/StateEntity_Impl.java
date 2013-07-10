/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Activity_;
import cruise.umple.umple.AutoTransition_;
import cruise.umple.umple.EntryOrExitAction_;
import cruise.umple.umple.StateEntity_;
import cruise.umple.umple.State_;
import cruise.umple.umple.Trace_;
import cruise.umple.umple.Transition_;
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
 * An implementation of the model object '<em><b>State Entity </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.StateEntity_Impl#getEntryOrExitAction_1 <em>Entry Or Exit Action 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateEntity_Impl#getAutoTransition_1 <em>Auto Transition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateEntity_Impl#getTransition_1 <em>Transition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateEntity_Impl#getActivity_1 <em>Activity 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateEntity_Impl#getState_1 <em>State 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateEntity_Impl#getTrace_1 <em>Trace 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateEntity_Impl extends MinimalEObjectImpl.Container implements StateEntity_
{
  /**
   * The cached value of the '{@link #getEntryOrExitAction_1() <em>Entry Or Exit Action 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEntryOrExitAction_1()
   * @generated
   * @ordered
   */
  protected EList<EntryOrExitAction_> entryOrExitAction_1;

  /**
   * The cached value of the '{@link #getAutoTransition_1() <em>Auto Transition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAutoTransition_1()
   * @generated
   * @ordered
   */
  protected EList<AutoTransition_> autoTransition_1;

  /**
   * The cached value of the '{@link #getTransition_1() <em>Transition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransition_1()
   * @generated
   * @ordered
   */
  protected EList<Transition_> transition_1;

  /**
   * The cached value of the '{@link #getActivity_1() <em>Activity 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivity_1()
   * @generated
   * @ordered
   */
  protected EList<Activity_> activity_1;

  /**
   * The cached value of the '{@link #getState_1() <em>State 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState_1()
   * @generated
   * @ordered
   */
  protected EList<State_> state_1;

  /**
   * The cached value of the '{@link #getTrace_1() <em>Trace 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_1()
   * @generated
   * @ordered
   */
  protected EList<Trace_> trace_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateEntity_Impl()
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
    return UmplePackage.eINSTANCE.getStateEntity_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EntryOrExitAction_> getEntryOrExitAction_1()
  {
    if (entryOrExitAction_1 == null)
    {
      entryOrExitAction_1 = new EObjectContainmentEList<EntryOrExitAction_>(EntryOrExitAction_.class, this, UmplePackage.STATE_ENTITY___ENTRY_OR_EXIT_ACTION_1);
    }
    return entryOrExitAction_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AutoTransition_> getAutoTransition_1()
  {
    if (autoTransition_1 == null)
    {
      autoTransition_1 = new EObjectContainmentEList<AutoTransition_>(AutoTransition_.class, this, UmplePackage.STATE_ENTITY___AUTO_TRANSITION_1);
    }
    return autoTransition_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Transition_> getTransition_1()
  {
    if (transition_1 == null)
    {
      transition_1 = new EObjectContainmentEList<Transition_>(Transition_.class, this, UmplePackage.STATE_ENTITY___TRANSITION_1);
    }
    return transition_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Activity_> getActivity_1()
  {
    if (activity_1 == null)
    {
      activity_1 = new EObjectContainmentEList<Activity_>(Activity_.class, this, UmplePackage.STATE_ENTITY___ACTIVITY_1);
    }
    return activity_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<State_> getState_1()
  {
    if (state_1 == null)
    {
      state_1 = new EObjectContainmentEList<State_>(State_.class, this, UmplePackage.STATE_ENTITY___STATE_1);
    }
    return state_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Trace_> getTrace_1()
  {
    if (trace_1 == null)
    {
      trace_1 = new EObjectContainmentEList<Trace_>(Trace_.class, this, UmplePackage.STATE_ENTITY___TRACE_1);
    }
    return trace_1;
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
      case UmplePackage.STATE_ENTITY___ENTRY_OR_EXIT_ACTION_1:
        return ((InternalEList<?>)getEntryOrExitAction_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.STATE_ENTITY___AUTO_TRANSITION_1:
        return ((InternalEList<?>)getAutoTransition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.STATE_ENTITY___TRANSITION_1:
        return ((InternalEList<?>)getTransition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.STATE_ENTITY___ACTIVITY_1:
        return ((InternalEList<?>)getActivity_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.STATE_ENTITY___STATE_1:
        return ((InternalEList<?>)getState_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.STATE_ENTITY___TRACE_1:
        return ((InternalEList<?>)getTrace_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.STATE_ENTITY___ENTRY_OR_EXIT_ACTION_1:
        return getEntryOrExitAction_1();
      case UmplePackage.STATE_ENTITY___AUTO_TRANSITION_1:
        return getAutoTransition_1();
      case UmplePackage.STATE_ENTITY___TRANSITION_1:
        return getTransition_1();
      case UmplePackage.STATE_ENTITY___ACTIVITY_1:
        return getActivity_1();
      case UmplePackage.STATE_ENTITY___STATE_1:
        return getState_1();
      case UmplePackage.STATE_ENTITY___TRACE_1:
        return getTrace_1();
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
      case UmplePackage.STATE_ENTITY___ENTRY_OR_EXIT_ACTION_1:
        getEntryOrExitAction_1().clear();
        getEntryOrExitAction_1().addAll((Collection<? extends EntryOrExitAction_>)newValue);
        return;
      case UmplePackage.STATE_ENTITY___AUTO_TRANSITION_1:
        getAutoTransition_1().clear();
        getAutoTransition_1().addAll((Collection<? extends AutoTransition_>)newValue);
        return;
      case UmplePackage.STATE_ENTITY___TRANSITION_1:
        getTransition_1().clear();
        getTransition_1().addAll((Collection<? extends Transition_>)newValue);
        return;
      case UmplePackage.STATE_ENTITY___ACTIVITY_1:
        getActivity_1().clear();
        getActivity_1().addAll((Collection<? extends Activity_>)newValue);
        return;
      case UmplePackage.STATE_ENTITY___STATE_1:
        getState_1().clear();
        getState_1().addAll((Collection<? extends State_>)newValue);
        return;
      case UmplePackage.STATE_ENTITY___TRACE_1:
        getTrace_1().clear();
        getTrace_1().addAll((Collection<? extends Trace_>)newValue);
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
      case UmplePackage.STATE_ENTITY___ENTRY_OR_EXIT_ACTION_1:
        getEntryOrExitAction_1().clear();
        return;
      case UmplePackage.STATE_ENTITY___AUTO_TRANSITION_1:
        getAutoTransition_1().clear();
        return;
      case UmplePackage.STATE_ENTITY___TRANSITION_1:
        getTransition_1().clear();
        return;
      case UmplePackage.STATE_ENTITY___ACTIVITY_1:
        getActivity_1().clear();
        return;
      case UmplePackage.STATE_ENTITY___STATE_1:
        getState_1().clear();
        return;
      case UmplePackage.STATE_ENTITY___TRACE_1:
        getTrace_1().clear();
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
      case UmplePackage.STATE_ENTITY___ENTRY_OR_EXIT_ACTION_1:
        return entryOrExitAction_1 != null && !entryOrExitAction_1.isEmpty();
      case UmplePackage.STATE_ENTITY___AUTO_TRANSITION_1:
        return autoTransition_1 != null && !autoTransition_1.isEmpty();
      case UmplePackage.STATE_ENTITY___TRANSITION_1:
        return transition_1 != null && !transition_1.isEmpty();
      case UmplePackage.STATE_ENTITY___ACTIVITY_1:
        return activity_1 != null && !activity_1.isEmpty();
      case UmplePackage.STATE_ENTITY___STATE_1:
        return state_1 != null && !state_1.isEmpty();
      case UmplePackage.STATE_ENTITY___TRACE_1:
        return trace_1 != null && !trace_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StateEntity_Impl
