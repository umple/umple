/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_recordEntity_2_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous record Entity 2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_recordEntity_2_Impl#getTrace_record_1 <em>Trace record 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_recordEntity_2_Impl extends MinimalEObjectImpl.Container implements Anonymous_recordEntity_2_
{
  /**
   * The default value of the '{@link #getTrace_record_1() <em>Trace record 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_record_1()
   * @generated
   * @ordered
   */
  protected static final String TRACE_RECORD_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTrace_record_1() <em>Trace record 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_record_1()
   * @generated
   * @ordered
   */
  protected String trace_record_1 = TRACE_RECORD_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_recordEntity_2_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_recordEntity_2_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTrace_record_1()
  {
    return trace_record_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrace_record_1(String newTrace_record_1)
  {
    String oldTrace_record_1 = trace_record_1;
    trace_record_1 = newTrace_record_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_RECORD_ENTITY_2__TRACE_RECORD_1, oldTrace_record_1, trace_record_1));
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
      case UmplePackage.ANONYMOUS_RECORD_ENTITY_2__TRACE_RECORD_1:
        return getTrace_record_1();
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
      case UmplePackage.ANONYMOUS_RECORD_ENTITY_2__TRACE_RECORD_1:
        setTrace_record_1((String)newValue);
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
      case UmplePackage.ANONYMOUS_RECORD_ENTITY_2__TRACE_RECORD_1:
        setTrace_record_1(TRACE_RECORD_1_EDEFAULT);
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
      case UmplePackage.ANONYMOUS_RECORD_ENTITY_2__TRACE_RECORD_1:
        return TRACE_RECORD_1_EDEFAULT == null ? trace_record_1 != null : !TRACE_RECORD_1_EDEFAULT.equals(trace_record_1);
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
    result.append(" (trace_record_1: ");
    result.append(trace_record_1);
    result.append(')');
    return result.toString();
  }

} //Anonymous_recordEntity_2_Impl
