/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.TraceCaseDef_;
import cruise.umple.umple.TraceDirective_;
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
 * An implementation of the model object '<em><b>Trace Case Def </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseDef_Impl#getTracecase_name_1 <em>Tracecase name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseDef_Impl#getTraceDirective_1 <em>Trace Directive 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceCaseDef_Impl extends MinimalEObjectImpl.Container implements TraceCaseDef_
{
  /**
   * The default value of the '{@link #getTracecase_name_1() <em>Tracecase name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTracecase_name_1()
   * @generated
   * @ordered
   */
  protected static final String TRACECASE_NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTracecase_name_1() <em>Tracecase name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTracecase_name_1()
   * @generated
   * @ordered
   */
  protected String tracecase_name_1 = TRACECASE_NAME_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getTraceDirective_1() <em>Trace Directive 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceDirective_1()
   * @generated
   * @ordered
   */
  protected EList<TraceDirective_> traceDirective_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceCaseDef_Impl()
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
    return UmplePackage.eINSTANCE.getTraceCaseDef_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTracecase_name_1()
  {
    return tracecase_name_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTracecase_name_1(String newTracecase_name_1)
  {
    String oldTracecase_name_1 = tracecase_name_1;
    tracecase_name_1 = newTracecase_name_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE_DEF___TRACECASE_NAME_1, oldTracecase_name_1, tracecase_name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceDirective_> getTraceDirective_1()
  {
    if (traceDirective_1 == null)
    {
      traceDirective_1 = new EObjectContainmentEList<TraceDirective_>(TraceDirective_.class, this, UmplePackage.TRACE_CASE_DEF___TRACE_DIRECTIVE_1);
    }
    return traceDirective_1;
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
      case UmplePackage.TRACE_CASE_DEF___TRACE_DIRECTIVE_1:
        return ((InternalEList<?>)getTraceDirective_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE_CASE_DEF___TRACECASE_NAME_1:
        return getTracecase_name_1();
      case UmplePackage.TRACE_CASE_DEF___TRACE_DIRECTIVE_1:
        return getTraceDirective_1();
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
      case UmplePackage.TRACE_CASE_DEF___TRACECASE_NAME_1:
        setTracecase_name_1((String)newValue);
        return;
      case UmplePackage.TRACE_CASE_DEF___TRACE_DIRECTIVE_1:
        getTraceDirective_1().clear();
        getTraceDirective_1().addAll((Collection<? extends TraceDirective_>)newValue);
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
      case UmplePackage.TRACE_CASE_DEF___TRACECASE_NAME_1:
        setTracecase_name_1(TRACECASE_NAME_1_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE_DEF___TRACE_DIRECTIVE_1:
        getTraceDirective_1().clear();
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
      case UmplePackage.TRACE_CASE_DEF___TRACECASE_NAME_1:
        return TRACECASE_NAME_1_EDEFAULT == null ? tracecase_name_1 != null : !TRACECASE_NAME_1_EDEFAULT.equals(tracecase_name_1);
      case UmplePackage.TRACE_CASE_DEF___TRACE_DIRECTIVE_1:
        return traceDirective_1 != null && !traceDirective_1.isEmpty();
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
    result.append(" (tracecase_name_1: ");
    result.append(tracecase_name_1);
    result.append(')');
    return result.toString();
  }

} //TraceCaseDef_Impl
