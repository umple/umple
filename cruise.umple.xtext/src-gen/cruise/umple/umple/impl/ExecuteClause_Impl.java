/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ExecuteClause_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execute Clause </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ExecuteClause_Impl#getTrace_execute_1 <em>Trace execute 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecuteClause_Impl extends MinimalEObjectImpl.Container implements ExecuteClause_
{
  /**
   * The default value of the '{@link #getTrace_execute_1() <em>Trace execute 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_execute_1()
   * @generated
   * @ordered
   */
  protected static final String TRACE_EXECUTE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTrace_execute_1() <em>Trace execute 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_execute_1()
   * @generated
   * @ordered
   */
  protected String trace_execute_1 = TRACE_EXECUTE_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExecuteClause_Impl()
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
    return UmplePackage.eINSTANCE.getExecuteClause_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTrace_execute_1()
  {
    return trace_execute_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrace_execute_1(String newTrace_execute_1)
  {
    String oldTrace_execute_1 = trace_execute_1;
    trace_execute_1 = newTrace_execute_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.EXECUTE_CLAUSE___TRACE_EXECUTE_1, oldTrace_execute_1, trace_execute_1));
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
      case UmplePackage.EXECUTE_CLAUSE___TRACE_EXECUTE_1:
        return getTrace_execute_1();
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
      case UmplePackage.EXECUTE_CLAUSE___TRACE_EXECUTE_1:
        setTrace_execute_1((String)newValue);
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
      case UmplePackage.EXECUTE_CLAUSE___TRACE_EXECUTE_1:
        setTrace_execute_1(TRACE_EXECUTE_1_EDEFAULT);
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
      case UmplePackage.EXECUTE_CLAUSE___TRACE_EXECUTE_1:
        return TRACE_EXECUTE_1_EDEFAULT == null ? trace_execute_1 != null : !TRACE_EXECUTE_1_EDEFAULT.equals(trace_execute_1);
    }
    return super.eIsSet(featureID);
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
    result.append(" (trace_execute_1: ");
    result.append(trace_execute_1);
    result.append(')');
    return result.toString();
  }

} //ExecuteClause_Impl
