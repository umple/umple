/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ConditionRHS;
import cruise.umple.umple.ModelElement;
import cruise.umple.umple.SimpleTraceCondition;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Trace Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.SimpleTraceConditionImpl#getLhs <em>Lhs</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.SimpleTraceConditionImpl#getConditionRHS <em>Condition RHS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleTraceConditionImpl extends TraceConditionImpl implements SimpleTraceCondition
{
  /**
   * The cached value of the '{@link #getLhs() <em>Lhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLhs()
   * @generated
   * @ordered
   */
  protected ModelElement lhs;

  /**
   * The cached value of the '{@link #getConditionRHS() <em>Condition RHS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionRHS()
   * @generated
   * @ordered
   */
  protected ConditionRHS conditionRHS;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleTraceConditionImpl()
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
    return UmplePackage.Literals.SIMPLE_TRACE_CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElement getLhs()
  {
    return lhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLhs(ModelElement newLhs, NotificationChain msgs)
  {
    ModelElement oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.SIMPLE_TRACE_CONDITION__LHS, oldLhs, newLhs);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLhs(ModelElement newLhs)
  {
    if (newLhs != lhs)
    {
      NotificationChain msgs = null;
      if (lhs != null)
        msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.SIMPLE_TRACE_CONDITION__LHS, null, msgs);
      if (newLhs != null)
        msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.SIMPLE_TRACE_CONDITION__LHS, null, msgs);
      msgs = basicSetLhs(newLhs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.SIMPLE_TRACE_CONDITION__LHS, newLhs, newLhs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionRHS getConditionRHS()
  {
    return conditionRHS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditionRHS(ConditionRHS newConditionRHS, NotificationChain msgs)
  {
    ConditionRHS oldConditionRHS = conditionRHS;
    conditionRHS = newConditionRHS;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.SIMPLE_TRACE_CONDITION__CONDITION_RHS, oldConditionRHS, newConditionRHS);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConditionRHS(ConditionRHS newConditionRHS)
  {
    if (newConditionRHS != conditionRHS)
    {
      NotificationChain msgs = null;
      if (conditionRHS != null)
        msgs = ((InternalEObject)conditionRHS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.SIMPLE_TRACE_CONDITION__CONDITION_RHS, null, msgs);
      if (newConditionRHS != null)
        msgs = ((InternalEObject)newConditionRHS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.SIMPLE_TRACE_CONDITION__CONDITION_RHS, null, msgs);
      msgs = basicSetConditionRHS(newConditionRHS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.SIMPLE_TRACE_CONDITION__CONDITION_RHS, newConditionRHS, newConditionRHS));
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
      case UmplePackage.SIMPLE_TRACE_CONDITION__LHS:
        return basicSetLhs(null, msgs);
      case UmplePackage.SIMPLE_TRACE_CONDITION__CONDITION_RHS:
        return basicSetConditionRHS(null, msgs);
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
      case UmplePackage.SIMPLE_TRACE_CONDITION__LHS:
        return getLhs();
      case UmplePackage.SIMPLE_TRACE_CONDITION__CONDITION_RHS:
        return getConditionRHS();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UmplePackage.SIMPLE_TRACE_CONDITION__LHS:
        setLhs((ModelElement)newValue);
        return;
      case UmplePackage.SIMPLE_TRACE_CONDITION__CONDITION_RHS:
        setConditionRHS((ConditionRHS)newValue);
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
      case UmplePackage.SIMPLE_TRACE_CONDITION__LHS:
        setLhs((ModelElement)null);
        return;
      case UmplePackage.SIMPLE_TRACE_CONDITION__CONDITION_RHS:
        setConditionRHS((ConditionRHS)null);
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
      case UmplePackage.SIMPLE_TRACE_CONDITION__LHS:
        return lhs != null;
      case UmplePackage.SIMPLE_TRACE_CONDITION__CONDITION_RHS:
        return conditionRHS != null;
    }
    return super.eIsSet(featureID);
  }

} //SimpleTraceConditionImpl
