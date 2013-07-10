/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.TraceCaseActivation_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Case Activation </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseActivation_Impl#getTracecase_act_name_1 <em>Tracecase act name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseActivation_Impl#getAnonymous_traceCaseActivation_1_1 <em>Anonymous trace Case Activation 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceCaseActivation_Impl extends MinimalEObjectImpl.Container implements TraceCaseActivation_
{
  /**
   * The default value of the '{@link #getTracecase_act_name_1() <em>Tracecase act name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTracecase_act_name_1()
   * @generated
   * @ordered
   */
  protected static final String TRACECASE_ACT_NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTracecase_act_name_1() <em>Tracecase act name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTracecase_act_name_1()
   * @generated
   * @ordered
   */
  protected String tracecase_act_name_1 = TRACECASE_ACT_NAME_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_traceCaseActivation_1_1() <em>Anonymous trace Case Activation 11</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_traceCaseActivation_1_1()
   * @generated
   * @ordered
   */
  protected EList<String> anonymous_traceCaseActivation_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceCaseActivation_Impl()
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
    return UmplePackage.eINSTANCE.getTraceCaseActivation_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTracecase_act_name_1()
  {
    return tracecase_act_name_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTracecase_act_name_1(String newTracecase_act_name_1)
  {
    String oldTracecase_act_name_1 = tracecase_act_name_1;
    tracecase_act_name_1 = newTracecase_act_name_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE_ACTIVATION___TRACECASE_ACT_NAME_1, oldTracecase_act_name_1, tracecase_act_name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getAnonymous_traceCaseActivation_1_1()
  {
    if (anonymous_traceCaseActivation_1_1 == null)
    {
      anonymous_traceCaseActivation_1_1 = new EDataTypeEList<String>(String.class, this, UmplePackage.TRACE_CASE_ACTIVATION___ANONYMOUS_TRACE_CASE_ACTIVATION_11);
    }
    return anonymous_traceCaseActivation_1_1;
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
      case UmplePackage.TRACE_CASE_ACTIVATION___TRACECASE_ACT_NAME_1:
        return getTracecase_act_name_1();
      case UmplePackage.TRACE_CASE_ACTIVATION___ANONYMOUS_TRACE_CASE_ACTIVATION_11:
        return getAnonymous_traceCaseActivation_1_1();
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
      case UmplePackage.TRACE_CASE_ACTIVATION___TRACECASE_ACT_NAME_1:
        setTracecase_act_name_1((String)newValue);
        return;
      case UmplePackage.TRACE_CASE_ACTIVATION___ANONYMOUS_TRACE_CASE_ACTIVATION_11:
        getAnonymous_traceCaseActivation_1_1().clear();
        getAnonymous_traceCaseActivation_1_1().addAll((Collection<? extends String>)newValue);
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
      case UmplePackage.TRACE_CASE_ACTIVATION___TRACECASE_ACT_NAME_1:
        setTracecase_act_name_1(TRACECASE_ACT_NAME_1_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE_ACTIVATION___ANONYMOUS_TRACE_CASE_ACTIVATION_11:
        getAnonymous_traceCaseActivation_1_1().clear();
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
      case UmplePackage.TRACE_CASE_ACTIVATION___TRACECASE_ACT_NAME_1:
        return TRACECASE_ACT_NAME_1_EDEFAULT == null ? tracecase_act_name_1 != null : !TRACECASE_ACT_NAME_1_EDEFAULT.equals(tracecase_act_name_1);
      case UmplePackage.TRACE_CASE_ACTIVATION___ANONYMOUS_TRACE_CASE_ACTIVATION_11:
        return anonymous_traceCaseActivation_1_1 != null && !anonymous_traceCaseActivation_1_1.isEmpty();
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
    result.append(" (tracecase_act_name_1: ");
    result.append(tracecase_act_name_1);
    result.append(", Anonymous_traceCaseActivation_1_1: ");
    result.append(anonymous_traceCaseActivation_1_1);
    result.append(')');
    return result.toString();
  }

} //TraceCaseActivation_Impl
