/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Action;
import cruise.umple.umple.EventDefinition;
import cruise.umple.umple.Guard;
import cruise.umple.umple.GuardCode;
import cruise.umple.umple.Transition;
import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.blockStatement;
import cruise.umple.umple.conditionalExpression;
import cruise.umple.umple.expression;
import cruise.umple.umple.expressionstatement;
import cruise.umple.umple.parExpression;
import cruise.umple.umple.primary;
import cruise.umple.umple.statement;
import cruise.umple.umple.unaryExpressionNotPlusMinus;

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
 * An implementation of the model object '<em><b>expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getA <em>A</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getStateName <em>State Name</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.expressionImpl#getExpression2 <em>Expression2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class expressionImpl extends StateEntityImpl implements expression
{
  /**
   * The cached value of the '{@link #getA() <em>A</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA()
   * @generated
   * @ordered
   */
  protected Action a;

  /**
   * The default value of the '{@link #getStateName() <em>State Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateName()
   * @generated
   * @ordered
   */
  protected static final String STATE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStateName() <em>State Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateName()
   * @generated
   * @ordered
   */
  protected String stateName = STATE_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvents()
   * @generated
   * @ordered
   */
  protected EList<EventDefinition> events;

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
  public Action getA()
  {
    return a;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetA(Action newA, NotificationChain msgs)
  {
    Action oldA = a;
    a = newA;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__A, oldA, newA);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setA(Action newA)
  {
    if (newA != a)
    {
      NotificationChain msgs = null;
      if (a != null)
        msgs = ((InternalEObject)a).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__A, null, msgs);
      if (newA != null)
        msgs = ((InternalEObject)newA).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.EXPRESSION__A, null, msgs);
      msgs = basicSetA(newA, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__A, newA, newA));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStateName()
  {
    return stateName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateName(String newStateName)
  {
    String oldStateName = stateName;
    stateName = newStateName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXPRESSION__STATE_NAME, oldStateName, stateName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EventDefinition> getEvents()
  {
    if (events == null)
    {
      events = new EObjectContainmentEList<EventDefinition>(EventDefinition.class, this, UmplePackage.EXPRESSION__EVENTS);
    }
    return events;
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
      case UmplePackage.EXPRESSION__A:
        return basicSetA(null, msgs);
      case UmplePackage.EXPRESSION__EVENTS:
        return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.EXPRESSION__A:
        return getA();
      case UmplePackage.EXPRESSION__STATE_NAME:
        return getStateName();
      case UmplePackage.EXPRESSION__EVENTS:
        return getEvents();
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
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UmplePackage.EXPRESSION__A:
        setA((Action)newValue);
        return;
      case UmplePackage.EXPRESSION__STATE_NAME:
        setStateName((String)newValue);
        return;
      case UmplePackage.EXPRESSION__EVENTS:
        getEvents().clear();
        getEvents().addAll((Collection<? extends EventDefinition>)newValue);
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
      case UmplePackage.EXPRESSION__A:
        setA((Action)null);
        return;
      case UmplePackage.EXPRESSION__STATE_NAME:
        setStateName(STATE_NAME_EDEFAULT);
        return;
      case UmplePackage.EXPRESSION__EVENTS:
        getEvents().clear();
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
      case UmplePackage.EXPRESSION__A:
        return a != null;
      case UmplePackage.EXPRESSION__STATE_NAME:
        return STATE_NAME_EDEFAULT == null ? stateName != null : !STATE_NAME_EDEFAULT.equals(stateName);
      case UmplePackage.EXPRESSION__EVENTS:
        return events != null && !events.isEmpty();
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
    if (baseClass == Transition.class)
    {
      switch (derivedFeatureID)
      {
        case UmplePackage.EXPRESSION__A: return UmplePackage.TRANSITION__A;
        case UmplePackage.EXPRESSION__STATE_NAME: return UmplePackage.TRANSITION__STATE_NAME;
        default: return -1;
      }
    }
    if (baseClass == Guard.class)
    {
      switch (derivedFeatureID)
      {
        case UmplePackage.EXPRESSION__EVENTS: return UmplePackage.GUARD__EVENTS;
        default: return -1;
      }
    }
    if (baseClass == GuardCode.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == unaryExpressionNotPlusMinus.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == primary.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == parExpression.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
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
        default: return -1;
      }
    }
    if (baseClass == expressionstatement.class)
    {
      switch (derivedFeatureID)
      {
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
    if (baseClass == Transition.class)
    {
      switch (baseFeatureID)
      {
        case UmplePackage.TRANSITION__A: return UmplePackage.EXPRESSION__A;
        case UmplePackage.TRANSITION__STATE_NAME: return UmplePackage.EXPRESSION__STATE_NAME;
        default: return -1;
      }
    }
    if (baseClass == Guard.class)
    {
      switch (baseFeatureID)
      {
        case UmplePackage.GUARD__EVENTS: return UmplePackage.EXPRESSION__EVENTS;
        default: return -1;
      }
    }
    if (baseClass == GuardCode.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == unaryExpressionNotPlusMinus.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == primary.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == parExpression.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
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
        default: return -1;
      }
    }
    if (baseClass == expressionstatement.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(" (stateName: ");
    result.append(stateName);
    result.append(')');
    return result.toString();
  }

} //expressionImpl
