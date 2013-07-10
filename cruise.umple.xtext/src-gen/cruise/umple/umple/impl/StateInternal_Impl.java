/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Comment_;
import cruise.umple.umple.StateEntity_;
import cruise.umple.umple.StateInternal_;
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
 * An implementation of the model object '<em><b>State Internal </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.StateInternal_Impl#getComment_1 <em>Comment 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateInternal_Impl#getChangeType_1 <em>Change Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.StateInternal_Impl#getStateEntity_1 <em>State Entity 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateInternal_Impl extends MinimalEObjectImpl.Container implements StateInternal_
{
  /**
   * The cached value of the '{@link #getComment_1() <em>Comment 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComment_1()
   * @generated
   * @ordered
   */
  protected EList<Comment_> comment_1;

  /**
   * The default value of the '{@link #getChangeType_1() <em>Change Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangeType_1()
   * @generated
   * @ordered
   */
  protected static final String CHANGE_TYPE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getChangeType_1() <em>Change Type 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangeType_1()
   * @generated
   * @ordered
   */
  protected String changeType_1 = CHANGE_TYPE_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getStateEntity_1() <em>State Entity 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateEntity_1()
   * @generated
   * @ordered
   */
  protected EList<StateEntity_> stateEntity_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateInternal_Impl()
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
    return UmplePackage.eINSTANCE.getStateInternal_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Comment_> getComment_1()
  {
    if (comment_1 == null)
    {
      comment_1 = new EObjectContainmentEList<Comment_>(Comment_.class, this, UmplePackage.STATE_INTERNAL___COMMENT_1);
    }
    return comment_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getChangeType_1()
  {
    return changeType_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChangeType_1(String newChangeType_1)
  {
    String oldChangeType_1 = changeType_1;
    changeType_1 = newChangeType_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.STATE_INTERNAL___CHANGE_TYPE_1, oldChangeType_1, changeType_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StateEntity_> getStateEntity_1()
  {
    if (stateEntity_1 == null)
    {
      stateEntity_1 = new EObjectContainmentEList<StateEntity_>(StateEntity_.class, this, UmplePackage.STATE_INTERNAL___STATE_ENTITY_1);
    }
    return stateEntity_1;
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
      case UmplePackage.STATE_INTERNAL___COMMENT_1:
        return ((InternalEList<?>)getComment_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.STATE_INTERNAL___STATE_ENTITY_1:
        return ((InternalEList<?>)getStateEntity_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.STATE_INTERNAL___COMMENT_1:
        return getComment_1();
      case UmplePackage.STATE_INTERNAL___CHANGE_TYPE_1:
        return getChangeType_1();
      case UmplePackage.STATE_INTERNAL___STATE_ENTITY_1:
        return getStateEntity_1();
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
      case UmplePackage.STATE_INTERNAL___COMMENT_1:
        getComment_1().clear();
        getComment_1().addAll((Collection<? extends Comment_>)newValue);
        return;
      case UmplePackage.STATE_INTERNAL___CHANGE_TYPE_1:
        setChangeType_1((String)newValue);
        return;
      case UmplePackage.STATE_INTERNAL___STATE_ENTITY_1:
        getStateEntity_1().clear();
        getStateEntity_1().addAll((Collection<? extends StateEntity_>)newValue);
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
      case UmplePackage.STATE_INTERNAL___COMMENT_1:
        getComment_1().clear();
        return;
      case UmplePackage.STATE_INTERNAL___CHANGE_TYPE_1:
        setChangeType_1(CHANGE_TYPE_1_EDEFAULT);
        return;
      case UmplePackage.STATE_INTERNAL___STATE_ENTITY_1:
        getStateEntity_1().clear();
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
      case UmplePackage.STATE_INTERNAL___COMMENT_1:
        return comment_1 != null && !comment_1.isEmpty();
      case UmplePackage.STATE_INTERNAL___CHANGE_TYPE_1:
        return CHANGE_TYPE_1_EDEFAULT == null ? changeType_1 != null : !CHANGE_TYPE_1_EDEFAULT.equals(changeType_1);
      case UmplePackage.STATE_INTERNAL___STATE_ENTITY_1:
        return stateEntity_1 != null && !stateEntity_1.isEmpty();
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
    result.append(" (changeType_1: ");
    result.append(changeType_1);
    result.append(')');
    return result.toString();
  }

} //StateInternal_Impl
