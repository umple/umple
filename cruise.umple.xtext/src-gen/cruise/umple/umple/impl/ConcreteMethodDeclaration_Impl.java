/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_concreteMethodDeclaration_1_;
import cruise.umple.umple.Anonymous_concreteMethodDeclaration_2_;
import cruise.umple.umple.ConcreteMethodDeclaration_;
import cruise.umple.umple.MethodBody_;
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
 * An implementation of the model object '<em><b>Concrete Method Declaration </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ConcreteMethodDeclaration_Impl#getType_1 <em>Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConcreteMethodDeclaration_Impl#getMethodDeclarator_1 <em>Method Declarator 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConcreteMethodDeclaration_Impl#getAnonymous_concreteMethodDeclaration_1_1 <em>Anonymous concrete Method Declaration 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConcreteMethodDeclaration_Impl#getMethodBody_1 <em>Method Body 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConcreteMethodDeclaration_Impl#getAnonymous_concreteMethodDeclaration_2_1 <em>Anonymous concrete Method Declaration 21</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteMethodDeclaration_Impl extends MinimalEObjectImpl.Container implements ConcreteMethodDeclaration_
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
   * The cached value of the '{@link #getAnonymous_concreteMethodDeclaration_1_1() <em>Anonymous concrete Method Declaration 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_concreteMethodDeclaration_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_concreteMethodDeclaration_1_> anonymous_concreteMethodDeclaration_1_1;

  /**
   * The cached value of the '{@link #getMethodBody_1() <em>Method Body 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodBody_1()
   * @generated
   * @ordered
   */
  protected EList<MethodBody_> methodBody_1;

  /**
   * The cached value of the '{@link #getAnonymous_concreteMethodDeclaration_2_1() <em>Anonymous concrete Method Declaration 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_concreteMethodDeclaration_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_concreteMethodDeclaration_2_> anonymous_concreteMethodDeclaration_2_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConcreteMethodDeclaration_Impl()
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
    return UmplePackage.eINSTANCE.getConcreteMethodDeclaration_();
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.CONCRETE_METHOD_DECLARATION___TYPE_1, oldType_1, type_1));
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
      methodDeclarator_1 = new EObjectContainmentEList<MethodDeclarator_>(MethodDeclarator_.class, this, UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_DECLARATOR_1);
    }
    return methodDeclarator_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_concreteMethodDeclaration_1_> getAnonymous_concreteMethodDeclaration_1_1()
  {
    if (anonymous_concreteMethodDeclaration_1_1 == null)
    {
      anonymous_concreteMethodDeclaration_1_1 = new EObjectContainmentEList<Anonymous_concreteMethodDeclaration_1_>(Anonymous_concreteMethodDeclaration_1_.class, this, UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_11);
    }
    return anonymous_concreteMethodDeclaration_1_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MethodBody_> getMethodBody_1()
  {
    if (methodBody_1 == null)
    {
      methodBody_1 = new EObjectContainmentEList<MethodBody_>(MethodBody_.class, this, UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_BODY_1);
    }
    return methodBody_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_concreteMethodDeclaration_2_> getAnonymous_concreteMethodDeclaration_2_1()
  {
    if (anonymous_concreteMethodDeclaration_2_1 == null)
    {
      anonymous_concreteMethodDeclaration_2_1 = new EObjectContainmentEList<Anonymous_concreteMethodDeclaration_2_>(Anonymous_concreteMethodDeclaration_2_.class, this, UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_21);
    }
    return anonymous_concreteMethodDeclaration_2_1;
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
      case UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_DECLARATOR_1:
        return ((InternalEList<?>)getMethodDeclarator_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_11:
        return ((InternalEList<?>)getAnonymous_concreteMethodDeclaration_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_BODY_1:
        return ((InternalEList<?>)getMethodBody_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_21:
        return ((InternalEList<?>)getAnonymous_concreteMethodDeclaration_2_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.CONCRETE_METHOD_DECLARATION___TYPE_1:
        return getType_1();
      case UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_DECLARATOR_1:
        return getMethodDeclarator_1();
      case UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_11:
        return getAnonymous_concreteMethodDeclaration_1_1();
      case UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_BODY_1:
        return getMethodBody_1();
      case UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_21:
        return getAnonymous_concreteMethodDeclaration_2_1();
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
      case UmplePackage.CONCRETE_METHOD_DECLARATION___TYPE_1:
        setType_1((String)newValue);
        return;
      case UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_DECLARATOR_1:
        getMethodDeclarator_1().clear();
        getMethodDeclarator_1().addAll((Collection<? extends MethodDeclarator_>)newValue);
        return;
      case UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_11:
        getAnonymous_concreteMethodDeclaration_1_1().clear();
        getAnonymous_concreteMethodDeclaration_1_1().addAll((Collection<? extends Anonymous_concreteMethodDeclaration_1_>)newValue);
        return;
      case UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_BODY_1:
        getMethodBody_1().clear();
        getMethodBody_1().addAll((Collection<? extends MethodBody_>)newValue);
        return;
      case UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_21:
        getAnonymous_concreteMethodDeclaration_2_1().clear();
        getAnonymous_concreteMethodDeclaration_2_1().addAll((Collection<? extends Anonymous_concreteMethodDeclaration_2_>)newValue);
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
      case UmplePackage.CONCRETE_METHOD_DECLARATION___TYPE_1:
        setType_1(TYPE_1_EDEFAULT);
        return;
      case UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_DECLARATOR_1:
        getMethodDeclarator_1().clear();
        return;
      case UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_11:
        getAnonymous_concreteMethodDeclaration_1_1().clear();
        return;
      case UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_BODY_1:
        getMethodBody_1().clear();
        return;
      case UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_21:
        getAnonymous_concreteMethodDeclaration_2_1().clear();
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
      case UmplePackage.CONCRETE_METHOD_DECLARATION___TYPE_1:
        return TYPE_1_EDEFAULT == null ? type_1 != null : !TYPE_1_EDEFAULT.equals(type_1);
      case UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_DECLARATOR_1:
        return methodDeclarator_1 != null && !methodDeclarator_1.isEmpty();
      case UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_11:
        return anonymous_concreteMethodDeclaration_1_1 != null && !anonymous_concreteMethodDeclaration_1_1.isEmpty();
      case UmplePackage.CONCRETE_METHOD_DECLARATION___METHOD_BODY_1:
        return methodBody_1 != null && !methodBody_1.isEmpty();
      case UmplePackage.CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_21:
        return anonymous_concreteMethodDeclaration_2_1 != null && !anonymous_concreteMethodDeclaration_2_1.isEmpty();
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

} //ConcreteMethodDeclaration_Impl
