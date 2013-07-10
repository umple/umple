/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.Word_;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Word </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Word_Impl#getSingular_1 <em>Singular 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Word_Impl#getPlural_1 <em>Plural 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Word_Impl extends MinimalEObjectImpl.Container implements Word_
{
  /**
   * The default value of the '{@link #getSingular_1() <em>Singular 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingular_1()
   * @generated
   * @ordered
   */
  protected static final String SINGULAR_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSingular_1() <em>Singular 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingular_1()
   * @generated
   * @ordered
   */
  protected String singular_1 = SINGULAR_1_EDEFAULT;

  /**
   * The default value of the '{@link #getPlural_1() <em>Plural 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlural_1()
   * @generated
   * @ordered
   */
  protected static final String PLURAL_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPlural_1() <em>Plural 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlural_1()
   * @generated
   * @ordered
   */
  protected String plural_1 = PLURAL_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Word_Impl()
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
    return UmplePackage.eINSTANCE.getWord_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSingular_1()
  {
    return singular_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSingular_1(String newSingular_1)
  {
    String oldSingular_1 = singular_1;
    singular_1 = newSingular_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.WORD___SINGULAR_1, oldSingular_1, singular_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPlural_1()
  {
    return plural_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPlural_1(String newPlural_1)
  {
    String oldPlural_1 = plural_1;
    plural_1 = newPlural_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.WORD___PLURAL_1, oldPlural_1, plural_1));
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
      case UmplePackage.WORD___SINGULAR_1:
        return getSingular_1();
      case UmplePackage.WORD___PLURAL_1:
        return getPlural_1();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UmplePackage.WORD___SINGULAR_1:
        setSingular_1((String)newValue);
        return;
      case UmplePackage.WORD___PLURAL_1:
        setPlural_1((String)newValue);
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
      case UmplePackage.WORD___SINGULAR_1:
        setSingular_1(SINGULAR_1_EDEFAULT);
        return;
      case UmplePackage.WORD___PLURAL_1:
        setPlural_1(PLURAL_1_EDEFAULT);
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
      case UmplePackage.WORD___SINGULAR_1:
        return SINGULAR_1_EDEFAULT == null ? singular_1 != null : !SINGULAR_1_EDEFAULT.equals(singular_1);
      case UmplePackage.WORD___PLURAL_1:
        return PLURAL_1_EDEFAULT == null ? plural_1 != null : !PLURAL_1_EDEFAULT.equals(plural_1);
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
    result.append(" (singular_1: ");
    result.append(singular_1);
    result.append(", plural_1: ");
    result.append(plural_1);
    result.append(')');
    return result.toString();
  }

} //Word_Impl
