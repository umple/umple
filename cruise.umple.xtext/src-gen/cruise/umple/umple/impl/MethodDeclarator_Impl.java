/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.MethodDeclarator_;
import cruise.umple.umple.ParameterList_;
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
 * An implementation of the model object '<em><b>Method Declarator </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.MethodDeclarator_Impl#getMethodName_1 <em>Method Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.MethodDeclarator_Impl#getParameterList_1 <em>Parameter List 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodDeclarator_Impl extends MinimalEObjectImpl.Container implements MethodDeclarator_
{
  /**
   * The default value of the '{@link #getMethodName_1() <em>Method Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodName_1()
   * @generated
   * @ordered
   */
  protected static final String METHOD_NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMethodName_1() <em>Method Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodName_1()
   * @generated
   * @ordered
   */
  protected String methodName_1 = METHOD_NAME_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameterList_1() <em>Parameter List 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterList_1()
   * @generated
   * @ordered
   */
  protected EList<ParameterList_> parameterList_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MethodDeclarator_Impl()
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
    return UmplePackage.eINSTANCE.getMethodDeclarator_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMethodName_1()
  {
    return methodName_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethodName_1(String newMethodName_1)
  {
    String oldMethodName_1 = methodName_1;
    methodName_1 = newMethodName_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.METHOD_DECLARATOR___METHOD_NAME_1, oldMethodName_1, methodName_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterList_> getParameterList_1()
  {
    if (parameterList_1 == null)
    {
      parameterList_1 = new EObjectContainmentEList<ParameterList_>(ParameterList_.class, this, UmplePackage.METHOD_DECLARATOR___PARAMETER_LIST_1);
    }
    return parameterList_1;
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
      case UmplePackage.METHOD_DECLARATOR___PARAMETER_LIST_1:
        return ((InternalEList<?>)getParameterList_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.METHOD_DECLARATOR___METHOD_NAME_1:
        return getMethodName_1();
      case UmplePackage.METHOD_DECLARATOR___PARAMETER_LIST_1:
        return getParameterList_1();
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
      case UmplePackage.METHOD_DECLARATOR___METHOD_NAME_1:
        setMethodName_1((String)newValue);
        return;
      case UmplePackage.METHOD_DECLARATOR___PARAMETER_LIST_1:
        getParameterList_1().clear();
        getParameterList_1().addAll((Collection<? extends ParameterList_>)newValue);
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
      case UmplePackage.METHOD_DECLARATOR___METHOD_NAME_1:
        setMethodName_1(METHOD_NAME_1_EDEFAULT);
        return;
      case UmplePackage.METHOD_DECLARATOR___PARAMETER_LIST_1:
        getParameterList_1().clear();
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
      case UmplePackage.METHOD_DECLARATOR___METHOD_NAME_1:
        return METHOD_NAME_1_EDEFAULT == null ? methodName_1 != null : !METHOD_NAME_1_EDEFAULT.equals(methodName_1);
      case UmplePackage.METHOD_DECLARATOR___PARAMETER_LIST_1:
        return parameterList_1 != null && !parameterList_1.isEmpty();
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
    result.append(" (methodName_1: ");
    result.append(methodName_1);
    result.append(')');
    return result.toString();
  }

} //MethodDeclarator_Impl
