/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AbstractMethodDeclaration_;
import cruise.umple.umple.MethodDeclarator_;
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
 * An implementation of the model object '<em><b>Abstract Method Declaration </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AbstractMethodDeclaration_Impl#getType_1 <em>Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AbstractMethodDeclaration_Impl#getMethodDeclarator_1 <em>Method Declarator 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractMethodDeclaration_Impl extends MinimalEObjectImpl.Container implements AbstractMethodDeclaration_
{
  /**
   * The default value of the '{@link #getType_1() <em>Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType_1()
   * @generated
   * @ordered
   */
  protected static final String TYPE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType_1() <em>Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType_1()
   * @generated
   * @ordered
   */
  protected String type_1 = TYPE_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getMethodDeclarator_1() <em>Method Declarator 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodDeclarator_1()
   * @generated
   * @ordered
   */
  protected EList<MethodDeclarator_> methodDeclarator_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractMethodDeclaration_Impl()
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
    return UmplePackage.eINSTANCE.getAbstractMethodDeclaration_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType_1()
  {
    return type_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType_1(String newType_1)
  {
    String oldType_1 = type_1;
    type_1 = newType_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ABSTRACT_METHOD_DECLARATION___TYPE_1, oldType_1, type_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MethodDeclarator_> getMethodDeclarator_1()
  {
    if (methodDeclarator_1 == null)
    {
      methodDeclarator_1 = new EObjectContainmentEList<MethodDeclarator_>(MethodDeclarator_.class, this, UmplePackage.ABSTRACT_METHOD_DECLARATION___METHOD_DECLARATOR_1);
    }
    return methodDeclarator_1;
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
      case UmplePackage.ABSTRACT_METHOD_DECLARATION___METHOD_DECLARATOR_1:
        return ((InternalEList<?>)getMethodDeclarator_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ABSTRACT_METHOD_DECLARATION___TYPE_1:
        return getType_1();
      case UmplePackage.ABSTRACT_METHOD_DECLARATION___METHOD_DECLARATOR_1:
        return getMethodDeclarator_1();
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
      case UmplePackage.ABSTRACT_METHOD_DECLARATION___TYPE_1:
        setType_1((String)newValue);
        return;
      case UmplePackage.ABSTRACT_METHOD_DECLARATION___METHOD_DECLARATOR_1:
        getMethodDeclarator_1().clear();
        getMethodDeclarator_1().addAll((Collection<? extends MethodDeclarator_>)newValue);
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
      case UmplePackage.ABSTRACT_METHOD_DECLARATION___TYPE_1:
        setType_1(TYPE_1_EDEFAULT);
        return;
      case UmplePackage.ABSTRACT_METHOD_DECLARATION___METHOD_DECLARATOR_1:
        getMethodDeclarator_1().clear();
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
      case UmplePackage.ABSTRACT_METHOD_DECLARATION___TYPE_1:
        return TYPE_1_EDEFAULT == null ? type_1 != null : !TYPE_1_EDEFAULT.equals(type_1);
      case UmplePackage.ABSTRACT_METHOD_DECLARATION___METHOD_DECLARATOR_1:
        return methodDeclarator_1 != null && !methodDeclarator_1.isEmpty();
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
    result.append(" (type_1: ");
    result.append(type_1);
    result.append(')');
    return result.toString();
  }

} //AbstractMethodDeclaration_Impl
