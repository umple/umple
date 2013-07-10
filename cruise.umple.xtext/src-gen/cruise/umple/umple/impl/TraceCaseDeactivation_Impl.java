/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.DeActivateFor_;
import cruise.umple.umple.TraceCaseDeactivation_;
import cruise.umple.umple.UmplePackage;

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
 * An implementation of the model object '<em><b>Trace Case Deactivation </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseDeactivation_Impl#getTracecase_deact_name_1 <em>Tracecase deact name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseDeactivation_Impl#getDeActivateFor_1 <em>De Activate For 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceCaseDeactivation_Impl extends MinimalEObjectImpl.Container implements TraceCaseDeactivation_
{
  /**
   * The default value of the '{@link #getTracecase_deact_name_1() <em>Tracecase deact name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTracecase_deact_name_1()
   * @generated
   * @ordered
   */
  protected static final String TRACECASE_DEACT_NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTracecase_deact_name_1() <em>Tracecase deact name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTracecase_deact_name_1()
   * @generated
   * @ordered
   */
  protected String tracecase_deact_name_1 = TRACECASE_DEACT_NAME_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getDeActivateFor_1() <em>De Activate For 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeActivateFor_1()
   * @generated
   * @ordered
   */
  protected EList<DeActivateFor_> deActivateFor_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceCaseDeactivation_Impl()
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
    return UmplePackage.eINSTANCE.getTraceCaseDeactivation_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTracecase_deact_name_1()
  {
    return tracecase_deact_name_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTracecase_deact_name_1(String newTracecase_deact_name_1)
  {
    String oldTracecase_deact_name_1 = tracecase_deact_name_1;
    tracecase_deact_name_1 = newTracecase_deact_name_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE_DEACTIVATION___TRACECASE_DEACT_NAME_1, oldTracecase_deact_name_1, tracecase_deact_name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DeActivateFor_> getDeActivateFor_1()
  {
    if (deActivateFor_1 == null)
    {
      deActivateFor_1 = new EObjectContainmentEList<DeActivateFor_>(DeActivateFor_.class, this, UmplePackage.TRACE_CASE_DEACTIVATION___DE_ACTIVATE_FOR_1);
    }
    return deActivateFor_1;
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
      case UmplePackage.TRACE_CASE_DEACTIVATION___DE_ACTIVATE_FOR_1:
        return ((InternalEList<?>)getDeActivateFor_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE_CASE_DEACTIVATION___TRACECASE_DEACT_NAME_1:
        return getTracecase_deact_name_1();
      case UmplePackage.TRACE_CASE_DEACTIVATION___DE_ACTIVATE_FOR_1:
        return getDeActivateFor_1();
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
      case UmplePackage.TRACE_CASE_DEACTIVATION___TRACECASE_DEACT_NAME_1:
        setTracecase_deact_name_1((String)newValue);
        return;
      case UmplePackage.TRACE_CASE_DEACTIVATION___DE_ACTIVATE_FOR_1:
        getDeActivateFor_1().clear();
        getDeActivateFor_1().addAll((Collection<? extends DeActivateFor_>)newValue);
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
      case UmplePackage.TRACE_CASE_DEACTIVATION___TRACECASE_DEACT_NAME_1:
        setTracecase_deact_name_1(TRACECASE_DEACT_NAME_1_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE_DEACTIVATION___DE_ACTIVATE_FOR_1:
        getDeActivateFor_1().clear();
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
      case UmplePackage.TRACE_CASE_DEACTIVATION___TRACECASE_DEACT_NAME_1:
        return TRACECASE_DEACT_NAME_1_EDEFAULT == null ? tracecase_deact_name_1 != null : !TRACECASE_DEACT_NAME_1_EDEFAULT.equals(tracecase_deact_name_1);
      case UmplePackage.TRACE_CASE_DEACTIVATION___DE_ACTIVATE_FOR_1:
        return deActivateFor_1 != null && !deActivateFor_1.isEmpty();
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
    result.append(" (tracecase_deact_name_1: ");
    result.append(tracecase_deact_name_1);
    result.append(')');
    return result.toString();
  }

} //TraceCaseDeactivation_Impl
