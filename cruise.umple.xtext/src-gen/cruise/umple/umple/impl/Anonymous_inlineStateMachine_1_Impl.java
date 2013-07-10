/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_inlineStateMachine_1_;
import cruise.umple.umple.Comment_;
import cruise.umple.umple.State_;
import cruise.umple.umple.Trace_;
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
 * An implementation of the model object '<em><b>Anonymous inline State Machine 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_inlineStateMachine_1_Impl#getComment_1 <em>Comment 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_inlineStateMachine_1_Impl#getState_1 <em>State 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_inlineStateMachine_1_Impl#getTrace_1 <em>Trace 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_inlineStateMachine_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_inlineStateMachine_1_
{
  /**
   * The cached value of the '{@link #getComment_1() <em>Comment 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComment_1()
   * @generated
   * @ordered
   */
  protected EList<Comment_> comment_1;

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
  protected Anonymous_inlineStateMachine_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_inlineStateMachine_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Comment_> getComment_1()
  {
    if (comment_1 == null)
    {
      comment_1 = new EObjectContainmentEList<Comment_>(Comment_.class, this, UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__COMMENT_1);
    }
    return comment_1;
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
      state_1 = new EObjectContainmentEList<State_>(State_.class, this, UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__STATE_1);
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
      trace_1 = new EObjectContainmentEList<Trace_>(Trace_.class, this, UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__TRACE_1);
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
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__COMMENT_1:
        return ((InternalEList<?>)getComment_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__STATE_1:
        return ((InternalEList<?>)getState_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__TRACE_1:
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
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__COMMENT_1:
        return getComment_1();
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__STATE_1:
        return getState_1();
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__TRACE_1:
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
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__COMMENT_1:
        getComment_1().clear();
        getComment_1().addAll((Collection<? extends Comment_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__STATE_1:
        getState_1().clear();
        getState_1().addAll((Collection<? extends State_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__TRACE_1:
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
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__COMMENT_1:
        getComment_1().clear();
        return;
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__STATE_1:
        getState_1().clear();
        return;
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__TRACE_1:
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
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__COMMENT_1:
        return comment_1 != null && !comment_1.isEmpty();
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__STATE_1:
        return state_1 != null && !state_1.isEmpty();
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1__TRACE_1:
        return trace_1 != null && !trace_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_inlineStateMachine_1_Impl
