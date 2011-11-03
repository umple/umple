/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.multiplicativeExpression;
import cruise.umple.umple.unaryExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>multiplicative Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.multiplicativeExpressionImpl#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.multiplicativeExpressionImpl#getExpressionRest <em>Expression Rest</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class multiplicativeExpressionImpl extends MinimalEObjectImpl.Container implements multiplicativeExpression
{
  /**
   * The cached value of the '{@link #getExpression1() <em>Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression1()
   * @generated
   * @ordered
   */
  protected unaryExpression expression1;

  /**
   * The cached value of the '{@link #getExpressionRest() <em>Expression Rest</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionRest()
   * @generated
   * @ordered
   */
  protected EList<unaryExpression> expressionRest;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected multiplicativeExpressionImpl()
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
    return UmplePackage.Literals.MULTIPLICATIVE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public unaryExpression getExpression1()
  {
    return expression1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression1(unaryExpression newExpression1, NotificationChain msgs)
  {
    unaryExpression oldExpression1 = expression1;
    expression1 = newExpression1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION1, oldExpression1, newExpression1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression1(unaryExpression newExpression1)
  {
    if (newExpression1 != expression1)
    {
      NotificationChain msgs = null;
      if (expression1 != null)
        msgs = ((InternalEObject)expression1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION1, null, msgs);
      if (newExpression1 != null)
        msgs = ((InternalEObject)newExpression1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION1, null, msgs);
      msgs = basicSetExpression1(newExpression1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION1, newExpression1, newExpression1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<unaryExpression> getExpressionRest()
  {
    if (expressionRest == null)
    {
      expressionRest = new EObjectContainmentEList<unaryExpression>(unaryExpression.class, this, UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION_REST);
    }
    return expressionRest;
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
      case UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION1:
        return basicSetExpression1(null, msgs);
      case UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION_REST:
        return ((InternalEList<?>)getExpressionRest()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION1:
        return getExpression1();
      case UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION_REST:
        return getExpressionRest();
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
      case UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION1:
        setExpression1((unaryExpression)newValue);
        return;
      case UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION_REST:
        getExpressionRest().clear();
        getExpressionRest().addAll((Collection<? extends unaryExpression>)newValue);
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
      case UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION1:
        setExpression1((unaryExpression)null);
        return;
      case UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION_REST:
        getExpressionRest().clear();
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
      case UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION1:
        return expression1 != null;
      case UmplePackage.MULTIPLICATIVE_EXPRESSION__EXPRESSION_REST:
        return expressionRest != null && !expressionRest.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //multiplicativeExpressionImpl
