/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_methodBody_1_;
import cruise.umple.umple.Anonymous_methodBody_2_;
import cruise.umple.umple.MethodBody_;
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
 * An implementation of the model object '<em><b>Method Body </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.MethodBody_Impl#getAnonymous_methodBody_1_1 <em>Anonymous method Body 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.MethodBody_Impl#getCode_1 <em>Code 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.MethodBody_Impl#getAnonymous_methodBody_2_1 <em>Anonymous method Body 21</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodBody_Impl extends MinimalEObjectImpl.Container implements MethodBody_
{
  /**
   * The cached value of the '{@link #getAnonymous_methodBody_1_1() <em>Anonymous method Body 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_methodBody_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_methodBody_1_> anonymous_methodBody_1_1;

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
   * The cached value of the '{@link #getAnonymous_methodBody_2_1() <em>Anonymous method Body 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_methodBody_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_methodBody_2_> anonymous_methodBody_2_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MethodBody_Impl()
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
    return UmplePackage.eINSTANCE.getMethodBody_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_methodBody_1_> getAnonymous_methodBody_1_1()
  {
    if (anonymous_methodBody_1_1 == null)
    {
      anonymous_methodBody_1_1 = new EObjectContainmentEList<Anonymous_methodBody_1_>(Anonymous_methodBody_1_.class, this, UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_11);
    }
    return anonymous_methodBody_1_1;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.METHOD_BODY___CODE_1, oldCode_1, code_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_methodBody_2_> getAnonymous_methodBody_2_1()
  {
    if (anonymous_methodBody_2_1 == null)
    {
      anonymous_methodBody_2_1 = new EObjectContainmentEList<Anonymous_methodBody_2_>(Anonymous_methodBody_2_.class, this, UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_21);
    }
    return anonymous_methodBody_2_1;
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
      case UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_11:
        return ((InternalEList<?>)getAnonymous_methodBody_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_21:
        return ((InternalEList<?>)getAnonymous_methodBody_2_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_11:
        return getAnonymous_methodBody_1_1();
      case UmplePackage.METHOD_BODY___CODE_1:
        return getCode_1();
      case UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_21:
        return getAnonymous_methodBody_2_1();
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
      case UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_11:
        getAnonymous_methodBody_1_1().clear();
        getAnonymous_methodBody_1_1().addAll((Collection<? extends Anonymous_methodBody_1_>)newValue);
        return;
      case UmplePackage.METHOD_BODY___CODE_1:
        setCode_1((String)newValue);
        return;
      case UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_21:
        getAnonymous_methodBody_2_1().clear();
        getAnonymous_methodBody_2_1().addAll((Collection<? extends Anonymous_methodBody_2_>)newValue);
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
      case UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_11:
        getAnonymous_methodBody_1_1().clear();
        return;
      case UmplePackage.METHOD_BODY___CODE_1:
        setCode_1(CODE_1_EDEFAULT);
        return;
      case UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_21:
        getAnonymous_methodBody_2_1().clear();
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
      case UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_11:
        return anonymous_methodBody_1_1 != null && !anonymous_methodBody_1_1.isEmpty();
      case UmplePackage.METHOD_BODY___CODE_1:
        return CODE_1_EDEFAULT == null ? code_1 != null : !CODE_1_EDEFAULT.equals(code_1);
      case UmplePackage.METHOD_BODY___ANONYMOUS_METHOD_BODY_21:
        return anonymous_methodBody_2_1 != null && !anonymous_methodBody_2_1.isEmpty();
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
    result.append(" (code_1: ");
    result.append(code_1);
    result.append(')');
    return result.toString();
  }

} //MethodBody_Impl
