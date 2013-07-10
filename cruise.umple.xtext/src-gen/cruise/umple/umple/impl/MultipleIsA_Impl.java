/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_multipleIsA_1_;
import cruise.umple.umple.MultipleIsA_;
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
 * An implementation of the model object '<em><b>Multiple Is A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.MultipleIsA_Impl#getExtendsName_1 <em>Extends Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.MultipleIsA_Impl#getAnonymous_multipleIsA_1_1 <em>Anonymous multiple Is A11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultipleIsA_Impl extends MinimalEObjectImpl.Container implements MultipleIsA_
{
  /**
   * The default value of the '{@link #getExtendsName_1() <em>Extends Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendsName_1()
   * @generated
   * @ordered
   */
  protected static final String EXTENDS_NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExtendsName_1() <em>Extends Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendsName_1()
   * @generated
   * @ordered
   */
  protected String extendsName_1 = EXTENDS_NAME_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_multipleIsA_1_1() <em>Anonymous multiple Is A11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_multipleIsA_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_multipleIsA_1_> anonymous_multipleIsA_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultipleIsA_Impl()
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
    return UmplePackage.eINSTANCE.getMultipleIsA_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExtendsName_1()
  {
    return extendsName_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtendsName_1(String newExtendsName_1)
  {
    String oldExtendsName_1 = extendsName_1;
    extendsName_1 = newExtendsName_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MULTIPLE_IS_A__EXTENDS_NAME_1, oldExtendsName_1, extendsName_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_multipleIsA_1_> getAnonymous_multipleIsA_1_1()
  {
    if (anonymous_multipleIsA_1_1 == null)
    {
      anonymous_multipleIsA_1_1 = new EObjectContainmentEList<Anonymous_multipleIsA_1_>(Anonymous_multipleIsA_1_.class, this, UmplePackage.MULTIPLE_IS_A__ANONYMOUS_MULTIPLE_IS_A11);
    }
    return anonymous_multipleIsA_1_1;
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
      case UmplePackage.MULTIPLE_IS_A__ANONYMOUS_MULTIPLE_IS_A11:
        return ((InternalEList<?>)getAnonymous_multipleIsA_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.MULTIPLE_IS_A__EXTENDS_NAME_1:
        return getExtendsName_1();
      case UmplePackage.MULTIPLE_IS_A__ANONYMOUS_MULTIPLE_IS_A11:
        return getAnonymous_multipleIsA_1_1();
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
      case UmplePackage.MULTIPLE_IS_A__EXTENDS_NAME_1:
        setExtendsName_1((String)newValue);
        return;
      case UmplePackage.MULTIPLE_IS_A__ANONYMOUS_MULTIPLE_IS_A11:
        getAnonymous_multipleIsA_1_1().clear();
        getAnonymous_multipleIsA_1_1().addAll((Collection<? extends Anonymous_multipleIsA_1_>)newValue);
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
      case UmplePackage.MULTIPLE_IS_A__EXTENDS_NAME_1:
        setExtendsName_1(EXTENDS_NAME_1_EDEFAULT);
        return;
      case UmplePackage.MULTIPLE_IS_A__ANONYMOUS_MULTIPLE_IS_A11:
        getAnonymous_multipleIsA_1_1().clear();
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
      case UmplePackage.MULTIPLE_IS_A__EXTENDS_NAME_1:
        return EXTENDS_NAME_1_EDEFAULT == null ? extendsName_1 != null : !EXTENDS_NAME_1_EDEFAULT.equals(extendsName_1);
      case UmplePackage.MULTIPLE_IS_A__ANONYMOUS_MULTIPLE_IS_A11:
        return anonymous_multipleIsA_1_1 != null && !anonymous_multipleIsA_1_1.isEmpty();
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
    result.append(" (extendsName_1: ");
    result.append(extendsName_1);
    result.append(')');
    return result.toString();
  }

} //MultipleIsA_Impl
