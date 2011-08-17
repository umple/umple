/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.conditionalExpression;
import cruise.umple.umple.conditionalOrExpression;
import cruise.umple.umple.expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.conditionalExpressionImpl#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.conditionalExpressionImpl#getExpression2 <em>Expression2</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.conditionalExpressionImpl#getExpression3 <em>Expression3</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class conditionalExpressionImpl extends MinimalEObjectImpl.Container implements conditionalExpression
{
  /**
   * The cached value of the '{@link #getExpression1() <em>Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression1()
   * @generated
   * @ordered
   */
  protected conditionalOrExpression expression1;

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
   * The cached value of the '{@link #getExpression3() <em>Expression3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression3()
   * @generated
   * @ordered
   */
  protected expression expression3;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected conditionalExpressionImpl()
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
    return UmplePackage.Literals.CONDITIONAL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public conditionalOrExpression getExpression1()
  {
    return expression1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression1(conditionalOrExpression newExpression1, NotificationChain msgs)
  {
    conditionalOrExpression oldExpression1 = expression1;
    expression1 = newExpression1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION1, oldExpression1, newExpression1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression1(conditionalOrExpression newExpression1)
  {
    if (newExpression1 != expression1)
    {
      NotificationChain msgs = null;
      if (expression1 != null)
        msgs = ((InternalEObject)expression1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION1, null, msgs);
      if (newExpression1 != null)
        msgs = ((InternalEObject)newExpression1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION1, null, msgs);
      msgs = basicSetExpression1(newExpression1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION1, newExpression1, newExpression1));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION2, oldExpression2, newExpression2);
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
        msgs = ((InternalEObject)expression2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION2, null, msgs);
      if (newExpression2 != null)
        msgs = ((InternalEObject)newExpression2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION2, null, msgs);
      msgs = basicSetExpression2(newExpression2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION2, newExpression2, newExpression2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public expression getExpression3()
  {
    return expression3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression3(expression newExpression3, NotificationChain msgs)
  {
    expression oldExpression3 = expression3;
    expression3 = newExpression3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION3, oldExpression3, newExpression3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression3(expression newExpression3)
  {
    if (newExpression3 != expression3)
    {
      NotificationChain msgs = null;
      if (expression3 != null)
        msgs = ((InternalEObject)expression3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION3, null, msgs);
      if (newExpression3 != null)
        msgs = ((InternalEObject)newExpression3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION3, null, msgs);
      msgs = basicSetExpression3(newExpression3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION3, newExpression3, newExpression3));
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
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION1:
        return basicSetExpression1(null, msgs);
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION2:
        return basicSetExpression2(null, msgs);
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION3:
        return basicSetExpression3(null, msgs);
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
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION1:
        return getExpression1();
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION2:
        return getExpression2();
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION3:
        return getExpression3();
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
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION1:
        setExpression1((conditionalOrExpression)newValue);
        return;
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION2:
        setExpression2((expression)newValue);
        return;
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION3:
        setExpression3((expression)newValue);
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
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION1:
        setExpression1((conditionalOrExpression)null);
        return;
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION2:
        setExpression2((expression)null);
        return;
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION3:
        setExpression3((expression)null);
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
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION1:
        return expression1 != null;
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION2:
        return expression2 != null;
      case UmplePackage.CONDITIONAL_EXPRESSION__EXPRESSION3:
        return expression3 != null;
    }
    return super.eIsSet(featureID);
  }

} //conditionalExpressionImpl
