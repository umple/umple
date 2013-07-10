/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_entryOrExitAction_1_;
import cruise.umple.umple.Anonymous_entryOrExitAction_2_;
import cruise.umple.umple.EntryOrExitAction_;
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
 * An implementation of the model object '<em><b>Entry Or Exit Action </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.EntryOrExitAction_Impl#getType_1 <em>Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.EntryOrExitAction_Impl#getAnonymous_entryOrExitAction_1_1 <em>Anonymous entry Or Exit Action 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.EntryOrExitAction_Impl#getCode_1 <em>Code 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.EntryOrExitAction_Impl#getAnonymous_entryOrExitAction_2_1 <em>Anonymous entry Or Exit Action 21</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryOrExitAction_Impl extends MinimalEObjectImpl.Container implements EntryOrExitAction_
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
   * The cached value of the '{@link #getAnonymous_entryOrExitAction_1_1() <em>Anonymous entry Or Exit Action 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_entryOrExitAction_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_entryOrExitAction_1_> anonymous_entryOrExitAction_1_1;

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
   * The cached value of the '{@link #getAnonymous_entryOrExitAction_2_1() <em>Anonymous entry Or Exit Action 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_entryOrExitAction_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_entryOrExitAction_2_> anonymous_entryOrExitAction_2_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntryOrExitAction_Impl()
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
    return UmplePackage.eINSTANCE.getEntryOrExitAction_();
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ENTRY_OR_EXIT_ACTION___TYPE_1, oldType_1, type_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_entryOrExitAction_1_> getAnonymous_entryOrExitAction_1_1()
  {
    if (anonymous_entryOrExitAction_1_1 == null)
    {
      anonymous_entryOrExitAction_1_1 = new EObjectContainmentEList<Anonymous_entryOrExitAction_1_>(Anonymous_entryOrExitAction_1_.class, this, UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_11);
    }
    return anonymous_entryOrExitAction_1_1;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ENTRY_OR_EXIT_ACTION___CODE_1, oldCode_1, code_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_entryOrExitAction_2_> getAnonymous_entryOrExitAction_2_1()
  {
    if (anonymous_entryOrExitAction_2_1 == null)
    {
      anonymous_entryOrExitAction_2_1 = new EObjectContainmentEList<Anonymous_entryOrExitAction_2_>(Anonymous_entryOrExitAction_2_.class, this, UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_21);
    }
    return anonymous_entryOrExitAction_2_1;
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
      case UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_11:
        return ((InternalEList<?>)getAnonymous_entryOrExitAction_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_21:
        return ((InternalEList<?>)getAnonymous_entryOrExitAction_2_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ENTRY_OR_EXIT_ACTION___TYPE_1:
        return getType_1();
      case UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_11:
        return getAnonymous_entryOrExitAction_1_1();
      case UmplePackage.ENTRY_OR_EXIT_ACTION___CODE_1:
        return getCode_1();
      case UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_21:
        return getAnonymous_entryOrExitAction_2_1();
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
      case UmplePackage.ENTRY_OR_EXIT_ACTION___TYPE_1:
        setType_1((String)newValue);
        return;
      case UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_11:
        getAnonymous_entryOrExitAction_1_1().clear();
        getAnonymous_entryOrExitAction_1_1().addAll((Collection<? extends Anonymous_entryOrExitAction_1_>)newValue);
        return;
      case UmplePackage.ENTRY_OR_EXIT_ACTION___CODE_1:
        setCode_1((String)newValue);
        return;
      case UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_21:
        getAnonymous_entryOrExitAction_2_1().clear();
        getAnonymous_entryOrExitAction_2_1().addAll((Collection<? extends Anonymous_entryOrExitAction_2_>)newValue);
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
      case UmplePackage.ENTRY_OR_EXIT_ACTION___TYPE_1:
        setType_1(TYPE_1_EDEFAULT);
        return;
      case UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_11:
        getAnonymous_entryOrExitAction_1_1().clear();
        return;
      case UmplePackage.ENTRY_OR_EXIT_ACTION___CODE_1:
        setCode_1(CODE_1_EDEFAULT);
        return;
      case UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_21:
        getAnonymous_entryOrExitAction_2_1().clear();
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
      case UmplePackage.ENTRY_OR_EXIT_ACTION___TYPE_1:
        return TYPE_1_EDEFAULT == null ? type_1 != null : !TYPE_1_EDEFAULT.equals(type_1);
      case UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_11:
        return anonymous_entryOrExitAction_1_1 != null && !anonymous_entryOrExitAction_1_1.isEmpty();
      case UmplePackage.ENTRY_OR_EXIT_ACTION___CODE_1:
        return CODE_1_EDEFAULT == null ? code_1 != null : !CODE_1_EDEFAULT.equals(code_1);
      case UmplePackage.ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_21:
        return anonymous_entryOrExitAction_2_1 != null && !anonymous_entryOrExitAction_2_1.isEmpty();
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
    result.append(", code_1: ");
    result.append(code_1);
    result.append(')');
    return result.toString();
  }

} //EntryOrExitAction_Impl
