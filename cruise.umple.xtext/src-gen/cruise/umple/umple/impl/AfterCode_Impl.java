/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AfterCode_;
import cruise.umple.umple.Anonymous_afterCode_1_;
import cruise.umple.umple.Anonymous_afterCode_2_;
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
 * An implementation of the model object '<em><b>After Code </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AfterCode_Impl#getOperationName_1 <em>Operation Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AfterCode_Impl#getAnonymous_afterCode_1_1 <em>Anonymous after Code 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AfterCode_Impl#getCode_1 <em>Code 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AfterCode_Impl#getAnonymous_afterCode_2_1 <em>Anonymous after Code 21</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AfterCode_Impl extends MinimalEObjectImpl.Container implements AfterCode_
{
  /**
   * The default value of the '{@link #getOperationName_1() <em>Operation Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationName_1()
   * @generated
   * @ordered
   */
  protected static final String OPERATION_NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOperationName_1() <em>Operation Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationName_1()
   * @generated
   * @ordered
   */
  protected String operationName_1 = OPERATION_NAME_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_afterCode_1_1() <em>Anonymous after Code 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_afterCode_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_afterCode_1_> anonymous_afterCode_1_1;

  /**
   * The default value of the '{@link #getCode_1() <em>Code 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCode_1()
   * @generated
   * @ordered
   */
  protected static final String CODE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCode_1() <em>Code 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCode_1()
   * @generated
   * @ordered
   */
  protected String code_1 = CODE_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_afterCode_2_1() <em>Anonymous after Code 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_afterCode_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_afterCode_2_> anonymous_afterCode_2_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AfterCode_Impl()
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
    return UmplePackage.eINSTANCE.getAfterCode_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOperationName_1()
  {
    return operationName_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperationName_1(String newOperationName_1)
  {
    String oldOperationName_1 = operationName_1;
    operationName_1 = newOperationName_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.AFTER_CODE___OPERATION_NAME_1, oldOperationName_1, operationName_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_afterCode_1_> getAnonymous_afterCode_1_1()
  {
    if (anonymous_afterCode_1_1 == null)
    {
      anonymous_afterCode_1_1 = new EObjectContainmentEList<Anonymous_afterCode_1_>(Anonymous_afterCode_1_.class, this, UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_11);
    }
    return anonymous_afterCode_1_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCode_1()
  {
    return code_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCode_1(String newCode_1)
  {
    String oldCode_1 = code_1;
    code_1 = newCode_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.AFTER_CODE___CODE_1, oldCode_1, code_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_afterCode_2_> getAnonymous_afterCode_2_1()
  {
    if (anonymous_afterCode_2_1 == null)
    {
      anonymous_afterCode_2_1 = new EObjectContainmentEList<Anonymous_afterCode_2_>(Anonymous_afterCode_2_.class, this, UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_21);
    }
    return anonymous_afterCode_2_1;
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
      case UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_11:
        return ((InternalEList<?>)getAnonymous_afterCode_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_21:
        return ((InternalEList<?>)getAnonymous_afterCode_2_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.AFTER_CODE___OPERATION_NAME_1:
        return getOperationName_1();
      case UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_11:
        return getAnonymous_afterCode_1_1();
      case UmplePackage.AFTER_CODE___CODE_1:
        return getCode_1();
      case UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_21:
        return getAnonymous_afterCode_2_1();
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
      case UmplePackage.AFTER_CODE___OPERATION_NAME_1:
        setOperationName_1((String)newValue);
        return;
      case UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_11:
        getAnonymous_afterCode_1_1().clear();
        getAnonymous_afterCode_1_1().addAll((Collection<? extends Anonymous_afterCode_1_>)newValue);
        return;
      case UmplePackage.AFTER_CODE___CODE_1:
        setCode_1((String)newValue);
        return;
      case UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_21:
        getAnonymous_afterCode_2_1().clear();
        getAnonymous_afterCode_2_1().addAll((Collection<? extends Anonymous_afterCode_2_>)newValue);
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
      case UmplePackage.AFTER_CODE___OPERATION_NAME_1:
        setOperationName_1(OPERATION_NAME_1_EDEFAULT);
        return;
      case UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_11:
        getAnonymous_afterCode_1_1().clear();
        return;
      case UmplePackage.AFTER_CODE___CODE_1:
        setCode_1(CODE_1_EDEFAULT);
        return;
      case UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_21:
        getAnonymous_afterCode_2_1().clear();
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
      case UmplePackage.AFTER_CODE___OPERATION_NAME_1:
        return OPERATION_NAME_1_EDEFAULT == null ? operationName_1 != null : !OPERATION_NAME_1_EDEFAULT.equals(operationName_1);
      case UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_11:
        return anonymous_afterCode_1_1 != null && !anonymous_afterCode_1_1.isEmpty();
      case UmplePackage.AFTER_CODE___CODE_1:
        return CODE_1_EDEFAULT == null ? code_1 != null : !CODE_1_EDEFAULT.equals(code_1);
      case UmplePackage.AFTER_CODE___ANONYMOUS_AFTER_CODE_21:
        return anonymous_afterCode_2_1 != null && !anonymous_afterCode_2_1.isEmpty();
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
    result.append(" (operationName_1: ");
    result.append(operationName_1);
    result.append(", code_1: ");
    result.append(code_1);
    result.append(')');
    return result.toString();
  }

} //AfterCode_Impl
