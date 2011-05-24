/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.blockStatement;
import cruise.umple.umple.expression;
import cruise.umple.umple.forControl;
import cruise.umple.umple.javaBlock;
import cruise.umple.umple.parExpression;
import cruise.umple.umple.statement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>java Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.javaBlockImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.javaBlockImpl#getState1 <em>State1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.javaBlockImpl#getState2 <em>State2</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.javaBlockImpl#getControl <em>Control</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.javaBlockImpl#getState <em>State</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.javaBlockImpl#getRetVal <em>Ret Val</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.javaBlockImpl#getBlocks <em>Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class javaBlockImpl extends blockImpl implements javaBlock
{
  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected parExpression condition;

  /**
   * The cached value of the '{@link #getState1() <em>State1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState1()
   * @generated
   * @ordered
   */
  protected statement state1;

  /**
   * The cached value of the '{@link #getState2() <em>State2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState2()
   * @generated
   * @ordered
   */
  protected statement state2;

  /**
   * The cached value of the '{@link #getControl() <em>Control</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getControl()
   * @generated
   * @ordered
   */
  protected forControl control;

  /**
   * The cached value of the '{@link #getState() <em>State</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected statement state;

  /**
   * The cached value of the '{@link #getRetVal() <em>Ret Val</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRetVal()
   * @generated
   * @ordered
   */
  protected expression retVal;

  /**
   * The cached value of the '{@link #getBlocks() <em>Blocks</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlocks()
   * @generated
   * @ordered
   */
  protected EList<blockStatement> blocks;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected javaBlockImpl()
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
    return UmplePackage.Literals.JAVA_BLOCK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public parExpression getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(parExpression newCondition, NotificationChain msgs)
  {
    parExpression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(parExpression newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public statement getState1()
  {
    return state1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetState1(statement newState1, NotificationChain msgs)
  {
    statement oldState1 = state1;
    state1 = newState1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__STATE1, oldState1, newState1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState1(statement newState1)
  {
    if (newState1 != state1)
    {
      NotificationChain msgs = null;
      if (state1 != null)
        msgs = ((InternalEObject)state1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__STATE1, null, msgs);
      if (newState1 != null)
        msgs = ((InternalEObject)newState1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__STATE1, null, msgs);
      msgs = basicSetState1(newState1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__STATE1, newState1, newState1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public statement getState2()
  {
    return state2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetState2(statement newState2, NotificationChain msgs)
  {
    statement oldState2 = state2;
    state2 = newState2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__STATE2, oldState2, newState2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState2(statement newState2)
  {
    if (newState2 != state2)
    {
      NotificationChain msgs = null;
      if (state2 != null)
        msgs = ((InternalEObject)state2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__STATE2, null, msgs);
      if (newState2 != null)
        msgs = ((InternalEObject)newState2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__STATE2, null, msgs);
      msgs = basicSetState2(newState2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__STATE2, newState2, newState2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public forControl getControl()
  {
    return control;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetControl(forControl newControl, NotificationChain msgs)
  {
    forControl oldControl = control;
    control = newControl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__CONTROL, oldControl, newControl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setControl(forControl newControl)
  {
    if (newControl != control)
    {
      NotificationChain msgs = null;
      if (control != null)
        msgs = ((InternalEObject)control).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__CONTROL, null, msgs);
      if (newControl != null)
        msgs = ((InternalEObject)newControl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__CONTROL, null, msgs);
      msgs = basicSetControl(newControl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__CONTROL, newControl, newControl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public statement getState()
  {
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetState(statement newState, NotificationChain msgs)
  {
    statement oldState = state;
    state = newState;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__STATE, oldState, newState);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState(statement newState)
  {
    if (newState != state)
    {
      NotificationChain msgs = null;
      if (state != null)
        msgs = ((InternalEObject)state).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__STATE, null, msgs);
      if (newState != null)
        msgs = ((InternalEObject)newState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__STATE, null, msgs);
      msgs = basicSetState(newState, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__STATE, newState, newState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public expression getRetVal()
  {
    return retVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRetVal(expression newRetVal, NotificationChain msgs)
  {
    expression oldRetVal = retVal;
    retVal = newRetVal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__RET_VAL, oldRetVal, newRetVal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRetVal(expression newRetVal)
  {
    if (newRetVal != retVal)
    {
      NotificationChain msgs = null;
      if (retVal != null)
        msgs = ((InternalEObject)retVal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__RET_VAL, null, msgs);
      if (newRetVal != null)
        msgs = ((InternalEObject)newRetVal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.JAVA_BLOCK__RET_VAL, null, msgs);
      msgs = basicSetRetVal(newRetVal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_BLOCK__RET_VAL, newRetVal, newRetVal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<blockStatement> getBlocks()
  {
    if (blocks == null)
    {
      blocks = new EObjectContainmentEList<blockStatement>(blockStatement.class, this, UmplePackage.JAVA_BLOCK__BLOCKS);
    }
    return blocks;
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
      case UmplePackage.JAVA_BLOCK__CONDITION:
        return basicSetCondition(null, msgs);
      case UmplePackage.JAVA_BLOCK__STATE1:
        return basicSetState1(null, msgs);
      case UmplePackage.JAVA_BLOCK__STATE2:
        return basicSetState2(null, msgs);
      case UmplePackage.JAVA_BLOCK__CONTROL:
        return basicSetControl(null, msgs);
      case UmplePackage.JAVA_BLOCK__STATE:
        return basicSetState(null, msgs);
      case UmplePackage.JAVA_BLOCK__RET_VAL:
        return basicSetRetVal(null, msgs);
      case UmplePackage.JAVA_BLOCK__BLOCKS:
        return ((InternalEList<?>)getBlocks()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.JAVA_BLOCK__CONDITION:
        return getCondition();
      case UmplePackage.JAVA_BLOCK__STATE1:
        return getState1();
      case UmplePackage.JAVA_BLOCK__STATE2:
        return getState2();
      case UmplePackage.JAVA_BLOCK__CONTROL:
        return getControl();
      case UmplePackage.JAVA_BLOCK__STATE:
        return getState();
      case UmplePackage.JAVA_BLOCK__RET_VAL:
        return getRetVal();
      case UmplePackage.JAVA_BLOCK__BLOCKS:
        return getBlocks();
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
      case UmplePackage.JAVA_BLOCK__CONDITION:
        setCondition((parExpression)newValue);
        return;
      case UmplePackage.JAVA_BLOCK__STATE1:
        setState1((statement)newValue);
        return;
      case UmplePackage.JAVA_BLOCK__STATE2:
        setState2((statement)newValue);
        return;
      case UmplePackage.JAVA_BLOCK__CONTROL:
        setControl((forControl)newValue);
        return;
      case UmplePackage.JAVA_BLOCK__STATE:
        setState((statement)newValue);
        return;
      case UmplePackage.JAVA_BLOCK__RET_VAL:
        setRetVal((expression)newValue);
        return;
      case UmplePackage.JAVA_BLOCK__BLOCKS:
        getBlocks().clear();
        getBlocks().addAll((Collection<? extends blockStatement>)newValue);
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
      case UmplePackage.JAVA_BLOCK__CONDITION:
        setCondition((parExpression)null);
        return;
      case UmplePackage.JAVA_BLOCK__STATE1:
        setState1((statement)null);
        return;
      case UmplePackage.JAVA_BLOCK__STATE2:
        setState2((statement)null);
        return;
      case UmplePackage.JAVA_BLOCK__CONTROL:
        setControl((forControl)null);
        return;
      case UmplePackage.JAVA_BLOCK__STATE:
        setState((statement)null);
        return;
      case UmplePackage.JAVA_BLOCK__RET_VAL:
        setRetVal((expression)null);
        return;
      case UmplePackage.JAVA_BLOCK__BLOCKS:
        getBlocks().clear();
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
      case UmplePackage.JAVA_BLOCK__CONDITION:
        return condition != null;
      case UmplePackage.JAVA_BLOCK__STATE1:
        return state1 != null;
      case UmplePackage.JAVA_BLOCK__STATE2:
        return state2 != null;
      case UmplePackage.JAVA_BLOCK__CONTROL:
        return control != null;
      case UmplePackage.JAVA_BLOCK__STATE:
        return state != null;
      case UmplePackage.JAVA_BLOCK__RET_VAL:
        return retVal != null;
      case UmplePackage.JAVA_BLOCK__BLOCKS:
        return blocks != null && !blocks.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == blockStatement.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == statement.class)
    {
      switch (derivedFeatureID)
      {
        case UmplePackage.JAVA_BLOCK__CONDITION: return UmplePackage.STATEMENT__CONDITION;
        case UmplePackage.JAVA_BLOCK__STATE1: return UmplePackage.STATEMENT__STATE1;
        case UmplePackage.JAVA_BLOCK__STATE2: return UmplePackage.STATEMENT__STATE2;
        case UmplePackage.JAVA_BLOCK__CONTROL: return UmplePackage.STATEMENT__CONTROL;
        case UmplePackage.JAVA_BLOCK__STATE: return UmplePackage.STATEMENT__STATE;
        case UmplePackage.JAVA_BLOCK__RET_VAL: return UmplePackage.STATEMENT__RET_VAL;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == blockStatement.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == statement.class)
    {
      switch (baseFeatureID)
      {
        case UmplePackage.STATEMENT__CONDITION: return UmplePackage.JAVA_BLOCK__CONDITION;
        case UmplePackage.STATEMENT__STATE1: return UmplePackage.JAVA_BLOCK__STATE1;
        case UmplePackage.STATEMENT__STATE2: return UmplePackage.JAVA_BLOCK__STATE2;
        case UmplePackage.STATEMENT__CONTROL: return UmplePackage.JAVA_BLOCK__CONTROL;
        case UmplePackage.STATEMENT__STATE: return UmplePackage.JAVA_BLOCK__STATE;
        case UmplePackage.STATEMENT__RET_VAL: return UmplePackage.JAVA_BLOCK__RET_VAL;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //javaBlockImpl
