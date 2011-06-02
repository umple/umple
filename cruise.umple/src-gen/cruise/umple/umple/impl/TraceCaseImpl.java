/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.TraceCase;
import cruise.umple.umple.TraceDirective;
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
 * An implementation of the model object '<em><b>Trace Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getTraceCaseName <em>Trace Case Name</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceCaseImpl#getTraceDirective <em>Trace Directive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceCaseImpl extends MinimalEObjectImpl.Container implements TraceCase
{
  /**
   * The default value of the '{@link #getTraceCaseName() <em>Trace Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceCaseName()
   * @generated
   * @ordered
   */
  protected static final String TRACE_CASE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTraceCaseName() <em>Trace Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceCaseName()
   * @generated
   * @ordered
   */
  protected String traceCaseName = TRACE_CASE_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getTraceDirective() <em>Trace Directive</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceDirective()
   * @generated
   * @ordered
   */
  protected EList<TraceDirective> traceDirective;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceCaseImpl()
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
    return UmplePackage.Literals.TRACE_CASE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTraceCaseName()
  {
    return traceCaseName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTraceCaseName(String newTraceCaseName)
  {
    String oldTraceCaseName = traceCaseName;
    traceCaseName = newTraceCaseName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_CASE__TRACE_CASE_NAME, oldTraceCaseName, traceCaseName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceDirective> getTraceDirective()
  {
    if (traceDirective == null)
    {
      traceDirective = new EObjectContainmentEList<TraceDirective>(TraceDirective.class, this, UmplePackage.TRACE_CASE__TRACE_DIRECTIVE);
    }
    return traceDirective;
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
      case UmplePackage.TRACE_CASE__TRACE_DIRECTIVE:
        return ((InternalEList<?>)getTraceDirective()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.TRACE_CASE__TRACE_CASE_NAME:
        return getTraceCaseName();
      case UmplePackage.TRACE_CASE__TRACE_DIRECTIVE:
        return getTraceDirective();
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
      case UmplePackage.TRACE_CASE__TRACE_CASE_NAME:
        setTraceCaseName((String)newValue);
        return;
      case UmplePackage.TRACE_CASE__TRACE_DIRECTIVE:
        getTraceDirective().clear();
        getTraceDirective().addAll((Collection<? extends TraceDirective>)newValue);
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
      case UmplePackage.TRACE_CASE__TRACE_CASE_NAME:
        setTraceCaseName(TRACE_CASE_NAME_EDEFAULT);
        return;
      case UmplePackage.TRACE_CASE__TRACE_DIRECTIVE:
        getTraceDirective().clear();
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
      case UmplePackage.TRACE_CASE__TRACE_CASE_NAME:
        return TRACE_CASE_NAME_EDEFAULT == null ? traceCaseName != null : !TRACE_CASE_NAME_EDEFAULT.equals(traceCaseName);
      case UmplePackage.TRACE_CASE__TRACE_DIRECTIVE:
        return traceDirective != null && !traceDirective.isEmpty();
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
    result.append(" (traceCaseName: ");
    result.append(traceCaseName);
    result.append(')');
    return result.toString();
  }

} //TraceCaseImpl
