/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_recordEntity_2_;
import cruise.umple.umple.RecordEntity_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Entity </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.RecordEntity_Impl#getAnonymous_recordEntity_1_1 <em>Anonymous record Entity 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.RecordEntity_Impl#getTrace_record_1 <em>Trace record 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.RecordEntity_Impl#getAnonymous_recordEntity_2_1 <em>Anonymous record Entity 21</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecordEntity_Impl extends MinimalEObjectImpl.Container implements RecordEntity_
{
  /**
   * The cached value of the '{@link #getAnonymous_recordEntity_1_1() <em>Anonymous record Entity 11</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_recordEntity_1_1()
   * @generated
   * @ordered
   */
  protected EList<String> anonymous_recordEntity_1_1;

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
   * The cached value of the '{@link #getAnonymous_recordEntity_2_1() <em>Anonymous record Entity 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_recordEntity_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_recordEntity_2_> anonymous_recordEntity_2_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecordEntity_Impl()
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
    return UmplePackage.eINSTANCE.getRecordEntity_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getAnonymous_recordEntity_1_1()
  {
    if (anonymous_recordEntity_1_1 == null)
    {
      anonymous_recordEntity_1_1 = new EDataTypeEList<String>(String.class, this, UmplePackage.RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_11);
    }
    return anonymous_recordEntity_1_1;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.RECORD_ENTITY___TRACE_RECORD_1, oldTrace_record_1, trace_record_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_recordEntity_2_> getAnonymous_recordEntity_2_1()
  {
    if (anonymous_recordEntity_2_1 == null)
    {
      anonymous_recordEntity_2_1 = new EObjectContainmentEList<Anonymous_recordEntity_2_>(Anonymous_recordEntity_2_.class, this, UmplePackage.RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_21);
    }
    return anonymous_recordEntity_2_1;
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
      case UmplePackage.RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_21:
        return ((InternalEList<?>)getAnonymous_recordEntity_2_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_11:
        return getAnonymous_recordEntity_1_1();
      case UmplePackage.RECORD_ENTITY___TRACE_RECORD_1:
        return getTrace_record_1();
      case UmplePackage.RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_21:
        return getAnonymous_recordEntity_2_1();
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
      case UmplePackage.RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_11:
        getAnonymous_recordEntity_1_1().clear();
        getAnonymous_recordEntity_1_1().addAll((Collection<? extends String>)newValue);
        return;
      case UmplePackage.RECORD_ENTITY___TRACE_RECORD_1:
        setTrace_record_1((String)newValue);
        return;
      case UmplePackage.RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_21:
        getAnonymous_recordEntity_2_1().clear();
        getAnonymous_recordEntity_2_1().addAll((Collection<? extends Anonymous_recordEntity_2_>)newValue);
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
      case UmplePackage.RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_11:
        getAnonymous_recordEntity_1_1().clear();
        return;
      case UmplePackage.RECORD_ENTITY___TRACE_RECORD_1:
        setTrace_record_1(TRACE_RECORD_1_EDEFAULT);
        return;
      case UmplePackage.RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_21:
        getAnonymous_recordEntity_2_1().clear();
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
      case UmplePackage.RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_11:
        return anonymous_recordEntity_1_1 != null && !anonymous_recordEntity_1_1.isEmpty();
      case UmplePackage.RECORD_ENTITY___TRACE_RECORD_1:
        return TRACE_RECORD_1_EDEFAULT == null ? trace_record_1 != null : !TRACE_RECORD_1_EDEFAULT.equals(trace_record_1);
      case UmplePackage.RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_21:
        return anonymous_recordEntity_2_1 != null && !anonymous_recordEntity_2_1.isEmpty();
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
    result.append(" (Anonymous_recordEntity_1_1: ");
    result.append(anonymous_recordEntity_1_1);
    result.append(", trace_record_1: ");
    result.append(trace_record_1);
    result.append(')');
    return result.toString();
  }

} //RecordEntity_Impl
