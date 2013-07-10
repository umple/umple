/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_traceEntity_1_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous trace Entity 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceEntity_1_Impl#getTrace_entity_1 <em>Trace entity 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_traceEntity_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_traceEntity_1_
{
  /**
   * The default value of the '{@link #getTrace_entity_1() <em>Trace entity 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_entity_1()
   * @generated
   * @ordered
   */
  protected static final String TRACE_ENTITY_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTrace_entity_1() <em>Trace entity 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_entity_1()
   * @generated
   * @ordered
   */
  protected String trace_entity_1 = TRACE_ENTITY_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_traceEntity_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_traceEntity_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTrace_entity_1()
  {
    return trace_entity_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrace_entity_1(String newTrace_entity_1)
  {
    String oldTrace_entity_1 = trace_entity_1;
    trace_entity_1 = newTrace_entity_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_TRACE_ENTITY_1__TRACE_ENTITY_1, oldTrace_entity_1, trace_entity_1));
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
      case UmplePackage.ANONYMOUS_TRACE_ENTITY_1__TRACE_ENTITY_1:
        return getTrace_entity_1();
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
      case UmplePackage.ANONYMOUS_TRACE_ENTITY_1__TRACE_ENTITY_1:
        setTrace_entity_1((String)newValue);
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
      case UmplePackage.ANONYMOUS_TRACE_ENTITY_1__TRACE_ENTITY_1:
        setTrace_entity_1(TRACE_ENTITY_1_EDEFAULT);
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
      case UmplePackage.ANONYMOUS_TRACE_ENTITY_1__TRACE_ENTITY_1:
        return TRACE_ENTITY_1_EDEFAULT == null ? trace_entity_1 != null : !TRACE_ENTITY_1_EDEFAULT.equals(trace_entity_1);
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
    result.append(" (trace_entity_1: ");
    result.append(trace_entity_1);
    result.append(')');
    return result.toString();
  }

} //Anonymous_traceEntity_1_Impl
