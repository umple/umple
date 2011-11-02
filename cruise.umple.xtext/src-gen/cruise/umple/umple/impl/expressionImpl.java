/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.block;
import cruise.umple.umple.blockStatement;
import cruise.umple.umple.conditionalExpression;
import cruise.umple.umple.expression;
import cruise.umple.umple.forControl;
import cruise.umple.umple.parExpression;
import cruise.umple.umple.statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getState1 <em>State1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getState2 <em>State2</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getControl <em>Control</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getState <em>State</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getRetVal <em>Ret Val</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getTryBlock <em>Try Block</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getCatchBlock <em>Catch Block</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getExpression2 <em>Expression2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class expressionImpl extends parExpressionImpl implements expression
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
   * The cached value of the '{@link #getTryBlock() <em>Try Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTryBlock()
   * @generated
   * @ordered
   */
  protected block tryBlock;

  /**
   * The cached value of the '{@link #getCatchBlock() <em>Catch Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCatchBlock()
   * @generated
   * @ordered
   */
  protected block catchBlock;

  /**
   * The cached value of the '{@link #getExpression1() <em>Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression1()
   * @generated
   * @ordered
   */
  protected conditionalExpression expression1;

  /**
   * The cached value of the '{@link #getExpression2() <em>Expression2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression2()
   * @generated
   * @ordered
   */
  protected expression expression2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected expressionImpl()
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
    return UmplePackage.Literals.EXPRESSION;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__CONDITION, oldCondition, newCondition);
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
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__CONDITION, newCondition, newCondition));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__STATE1, oldState1, newState1);
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
        msgs = ((InternalEObject)state1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__STATE1, null, msgs);
      if (newState1 != null)
        msgs = ((InternalEObject)newState1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__STATE1, null, msgs);
      msgs = basicSetState1(newState1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__STATE1, newState1, newState1));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__STATE2, oldState2, newState2);
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
        msgs = ((InternalEObject)state2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__STATE2, null, msgs);
      if (newState2 != null)
        msgs = ((InternalEObject)newState2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__STATE2, null, msgs);
      msgs = basicSetState2(newState2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__STATE2, newState2, newState2));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__CONTROL, oldControl, newControl);
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
        msgs = ((InternalEObject)control).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__CONTROL, null, msgs);
      if (newControl != null)
        msgs = ((InternalEObject)newControl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__CONTROL, null, msgs);
      msgs = basicSetControl(newControl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__CONTROL, newControl, newControl));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__STATE, oldState, newState);
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
        msgs = ((InternalEObject)state).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__STATE, null, msgs);
      if (newState != null)
        msgs = ((InternalEObject)newState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__STATE, null, msgs);
      msgs = basicSetState(newState, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__STATE, newState, newState));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__RET_VAL, oldRetVal, newRetVal);
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
        msgs = ((InternalEObject)retVal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__RET_VAL, null, msgs);
      if (newRetVal != null)
        msgs = ((InternalEObject)newRetVal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__RET_VAL, null, msgs);
      msgs = basicSetRetVal(newRetVal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__RET_VAL, newRetVal, newRetVal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public block getTryBlock()
  {
    return tryBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTryBlock(block newTryBlock, NotificationChain msgs)
  {
    block oldTryBlock = tryBlock;
    tryBlock = newTryBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__TRY_BLOCK, oldTryBlock, newTryBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTryBlock(block newTryBlock)
  {
    if (newTryBlock != tryBlock)
    {
      NotificationChain msgs = null;
      if (tryBlock != null)
        msgs = ((InternalEObject)tryBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__TRY_BLOCK, null, msgs);
      if (newTryBlock != null)
        msgs = ((InternalEObject)newTryBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__TRY_BLOCK, null, msgs);
      msgs = basicSetTryBlock(newTryBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__TRY_BLOCK, newTryBlock, newTryBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public block getCatchBlock()
  {
    return catchBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCatchBlock(block newCatchBlock, NotificationChain msgs)
  {
    block oldCatchBlock = catchBlock;
    catchBlock = newCatchBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__CATCH_BLOCK, oldCatchBlock, newCatchBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCatchBlock(block newCatchBlock)
  {
    if (newCatchBlock != catchBlock)
    {
      NotificationChain msgs = null;
      if (catchBlock != null)
        msgs = ((InternalEObject)catchBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__CATCH_BLOCK, null, msgs);
      if (newCatchBlock != null)
        msgs = ((InternalEObject)newCatchBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__CATCH_BLOCK, null, msgs);
      msgs = basicSetCatchBlock(newCatchBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__CATCH_BLOCK, newCatchBlock, newCatchBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public conditionalExpression getExpression1()
  {
    return expression1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression1(conditionalExpression newExpression1, NotificationChain msgs)
  {
    conditionalExpression oldExpression1 = expression1;
    expression1 = newExpression1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__EXPRESSION1, oldExpression1, newExpression1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression1(conditionalExpression newExpression1)
  {
    if (newExpression1 != expression1)
    {
      NotificationChain msgs = null;
      if (expression1 != null)
        msgs = ((InternalEObject)expression1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__EXPRESSION1, null, msgs);
      if (newExpression1 != null)
        msgs = ((InternalEObject)newExpression1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__EXPRESSION1, null, msgs);
      msgs = basicSetExpression1(newExpression1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__EXPRESSION1, newExpression1, newExpression1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public expression getExpression2()
  {
    return expression2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression2(expression newExpression2, NotificationChain msgs)
  {
    expression oldExpression2 = expression2;
    expression2 = newExpression2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__EXPRESSION2, oldExpression2, newExpression2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression2(expression newExpression2)
  {
    if (newExpression2 != expression2)
    {
      NotificationChain msgs = null;
      if (expression2 != null)
        msgs = ((InternalEObject)expression2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__EXPRESSION2, null, msgs);
      if (newExpression2 != null)
        msgs = ((InternalEObject)newExpression2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__EXPRESSION2, null, msgs);
      msgs = basicSetExpression2(newExpression2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__EXPRESSION2, newExpression2, newExpression2));
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
      case UmplePackage.EXPRESSION__CONDITION:
        return basicSetCondition(null, msgs);
      case UmplePackage.EXPRESSION__STATE1:
        return basicSetState1(null, msgs);
      case UmplePackage.EXPRESSION__STATE2:
        return basicSetState2(null, msgs);
      case UmplePackage.EXPRESSION__CONTROL:
        return basicSetControl(null, msgs);
      case UmplePackage.EXPRESSION__STATE:
        return basicSetState(null, msgs);
      case UmplePackage.EXPRESSION__RET_VAL:
        return basicSetRetVal(null, msgs);
      case UmplePackage.EXPRESSION__TRY_BLOCK:
        return basicSetTryBlock(null, msgs);
      case UmplePackage.EXPRESSION__CATCH_BLOCK:
        return basicSetCatchBlock(null, msgs);
      case UmplePackage.EXPRESSION__EXPRESSION1:
        return basicSetExpression1(null, msgs);
      case UmplePackage.EXPRESSION__EXPRESSION2:
        return basicSetExpression2(null, msgs);
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
      case UmplePackage.EXPRESSION__CONDITION:
        return getCondition();
      case UmplePackage.EXPRESSION__STATE1:
        return getState1();
      case UmplePackage.EXPRESSION__STATE2:
        return getState2();
      case UmplePackage.EXPRESSION__CONTROL:
        return getControl();
      case UmplePackage.EXPRESSION__STATE:
        return getState();
      case UmplePackage.EXPRESSION__RET_VAL:
        return getRetVal();
      case UmplePackage.EXPRESSION__TRY_BLOCK:
        return getTryBlock();
      case UmplePackage.EXPRESSION__CATCH_BLOCK:
        return getCatchBlock();
      case UmplePackage.EXPRESSION__EXPRESSION1:
        return getExpression1();
      case UmplePackage.EXPRESSION__EXPRESSION2:
        return getExpression2();
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
      case UmplePackage.EXPRESSION__CONDITION:
        setCondition((parExpression)newValue);
        return;
      case UmplePackage.EXPRESSION__STATE1:
        setState1((statement)newValue);
        return;
      case UmplePackage.EXPRESSION__STATE2:
        setState2((statement)newValue);
        return;
      case UmplePackage.EXPRESSION__CONTROL:
        setControl((forControl)newValue);
        return;
      case UmplePackage.EXPRESSION__STATE:
        setState((statement)newValue);
        return;
      case UmplePackage.EXPRESSION__RET_VAL:
        setRetVal((expression)newValue);
        return;
      case UmplePackage.EXPRESSION__TRY_BLOCK:
        setTryBlock((block)newValue);
        return;
      case UmplePackage.EXPRESSION__CATCH_BLOCK:
        setCatchBlock((block)newValue);
        return;
      case UmplePackage.EXPRESSION__EXPRESSION1:
        setExpression1((conditionalExpression)newValue);
        return;
      case UmplePackage.EXPRESSION__EXPRESSION2:
        setExpression2((expression)newValue);
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
      case UmplePackage.EXPRESSION__CONDITION:
        setCondition((parExpression)null);
        return;
      case UmplePackage.EXPRESSION__STATE1:
        setState1((statement)null);
        return;
      case UmplePackage.EXPRESSION__STATE2:
        setState2((statement)null);
        return;
      case UmplePackage.EXPRESSION__CONTROL:
        setControl((forControl)null);
        return;
      case UmplePackage.EXPRESSION__STATE:
        setState((statement)null);
        return;
      case UmplePackage.EXPRESSION__RET_VAL:
        setRetVal((expression)null);
        return;
      case UmplePackage.EXPRESSION__TRY_BLOCK:
        setTryBlock((block)null);
        return;
      case UmplePackage.EXPRESSION__CATCH_BLOCK:
        setCatchBlock((block)null);
        return;
      case UmplePackage.EXPRESSION__EXPRESSION1:
        setExpression1((conditionalExpression)null);
        return;
      case UmplePackage.EXPRESSION__EXPRESSION2:
        setExpression2((expression)null);
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
      case UmplePackage.EXPRESSION__CONDITION:
        return condition != null;
      case UmplePackage.EXPRESSION__STATE1:
        return state1 != null;
      case UmplePackage.EXPRESSION__STATE2:
        return state2 != null;
      case UmplePackage.EXPRESSION__CONTROL:
        return control != null;
      case UmplePackage.EXPRESSION__STATE:
        return state != null;
      case UmplePackage.EXPRESSION__RET_VAL:
        return retVal != null;
      case UmplePackage.EXPRESSION__TRY_BLOCK:
        return tryBlock != null;
      case UmplePackage.EXPRESSION__CATCH_BLOCK:
        return catchBlock != null;
      case UmplePackage.EXPRESSION__EXPRESSION1:
        return expression1 != null;
      case UmplePackage.EXPRESSION__EXPRESSION2:
        return expression2 != null;
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
        case UmplePackage.EXPRESSION__CONDITION: return UmplePackage.STATEMENT__CONDITION;
        case UmplePackage.EXPRESSION__STATE1: return UmplePackage.STATEMENT__STATE1;
        case UmplePackage.EXPRESSION__STATE2: return UmplePackage.STATEMENT__STATE2;
        case UmplePackage.EXPRESSION__CONTROL: return UmplePackage.STATEMENT__CONTROL;
        case UmplePackage.EXPRESSION__STATE: return UmplePackage.STATEMENT__STATE;
        case UmplePackage.EXPRESSION__RET_VAL: return UmplePackage.STATEMENT__RET_VAL;
        case UmplePackage.EXPRESSION__TRY_BLOCK: return UmplePackage.STATEMENT__TRY_BLOCK;
        case UmplePackage.EXPRESSION__CATCH_BLOCK: return UmplePackage.STATEMENT__CATCH_BLOCK;
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
        case UmplePackage.STATEMENT__CONDITION: return UmplePackage.EXPRESSION__CONDITION;
        case UmplePackage.STATEMENT__STATE1: return UmplePackage.EXPRESSION__STATE1;
        case UmplePackage.STATEMENT__STATE2: return UmplePackage.EXPRESSION__STATE2;
        case UmplePackage.STATEMENT__CONTROL: return UmplePackage.EXPRESSION__CONTROL;
        case UmplePackage.STATEMENT__STATE: return UmplePackage.EXPRESSION__STATE;
        case UmplePackage.STATEMENT__RET_VAL: return UmplePackage.EXPRESSION__RET_VAL;
        case UmplePackage.STATEMENT__TRY_BLOCK: return UmplePackage.EXPRESSION__TRY_BLOCK;
        case UmplePackage.STATEMENT__CATCH_BLOCK: return UmplePackage.EXPRESSION__CATCH_BLOCK;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //expressionImpl
