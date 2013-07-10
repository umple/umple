/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_linkingOp_1_;
import cruise.umple.umple.Anonymous_linkingOp_2_;
import cruise.umple.umple.Anonymous_linkingOp_3_;
import cruise.umple.umple.LinkingOp_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linking Op </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.LinkingOp_Impl#getAnonymous_linkingOp_1_1 <em>Anonymous linking Op 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.LinkingOp_Impl#getAnonymous_linkingOp_2_1 <em>Anonymous linking Op 21</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.LinkingOp_Impl#getAnonymous_linkingOp_3_1 <em>Anonymous linking Op 31</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkingOp_Impl extends MinimalEObjectImpl.Container implements LinkingOp_
{
  /**
   * The cached value of the '{@link #getAnonymous_linkingOp_1_1() <em>Anonymous linking Op 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_linkingOp_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_linkingOp_1_> anonymous_linkingOp_1_1;

  /**
   * The cached value of the '{@link #getAnonymous_linkingOp_2_1() <em>Anonymous linking Op 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_linkingOp_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_linkingOp_2_> anonymous_linkingOp_2_1;

  /**
   * The cached value of the '{@link #getAnonymous_linkingOp_3_1() <em>Anonymous linking Op 31</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_linkingOp_3_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_linkingOp_3_> anonymous_linkingOp_3_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LinkingOp_Impl()
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
    return UmplePackage.eINSTANCE.getLinkingOp_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_linkingOp_1_> getAnonymous_linkingOp_1_1()
  {
    if (anonymous_linkingOp_1_1 == null)
    {
      anonymous_linkingOp_1_1 = new EObjectContainmentEList<Anonymous_linkingOp_1_>(Anonymous_linkingOp_1_.class, this, UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_11);
    }
    return anonymous_linkingOp_1_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_linkingOp_2_> getAnonymous_linkingOp_2_1()
  {
    if (anonymous_linkingOp_2_1 == null)
    {
      anonymous_linkingOp_2_1 = new EObjectContainmentEList<Anonymous_linkingOp_2_>(Anonymous_linkingOp_2_.class, this, UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_21);
    }
    return anonymous_linkingOp_2_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_linkingOp_3_> getAnonymous_linkingOp_3_1()
  {
    if (anonymous_linkingOp_3_1 == null)
    {
      anonymous_linkingOp_3_1 = new EObjectContainmentEList<Anonymous_linkingOp_3_>(Anonymous_linkingOp_3_.class, this, UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_31);
    }
    return anonymous_linkingOp_3_1;
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
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_11:
        return ((InternalEList<?>)getAnonymous_linkingOp_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_21:
        return ((InternalEList<?>)getAnonymous_linkingOp_2_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_31:
        return ((InternalEList<?>)getAnonymous_linkingOp_3_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_11:
        return getAnonymous_linkingOp_1_1();
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_21:
        return getAnonymous_linkingOp_2_1();
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_31:
        return getAnonymous_linkingOp_3_1();
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
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_11:
        getAnonymous_linkingOp_1_1().clear();
        getAnonymous_linkingOp_1_1().addAll((Collection<? extends Anonymous_linkingOp_1_>)newValue);
        return;
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_21:
        getAnonymous_linkingOp_2_1().clear();
        getAnonymous_linkingOp_2_1().addAll((Collection<? extends Anonymous_linkingOp_2_>)newValue);
        return;
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_31:
        getAnonymous_linkingOp_3_1().clear();
        getAnonymous_linkingOp_3_1().addAll((Collection<? extends Anonymous_linkingOp_3_>)newValue);
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
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_11:
        getAnonymous_linkingOp_1_1().clear();
        return;
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_21:
        getAnonymous_linkingOp_2_1().clear();
        return;
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_31:
        getAnonymous_linkingOp_3_1().clear();
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
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_11:
        return anonymous_linkingOp_1_1 != null && !anonymous_linkingOp_1_1.isEmpty();
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_21:
        return anonymous_linkingOp_2_1 != null && !anonymous_linkingOp_2_1.isEmpty();
      case UmplePackage.LINKING_OP___ANONYMOUS_LINKING_OP_31:
        return anonymous_linkingOp_3_1 != null && !anonymous_linkingOp_3_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //LinkingOp_Impl
