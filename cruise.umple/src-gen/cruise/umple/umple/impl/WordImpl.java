/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.Word;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Word</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.WordImpl#getSingular <em>Singular</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.WordImpl#getPlural <em>Plural</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WordImpl extends MinimalEObjectImpl.Container implements Word
{
  /**
   * The default value of the '{@link #getSingular() <em>Singular</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingular()
   * @generated
   * @ordered
   */
  protected static final String SINGULAR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSingular() <em>Singular</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingular()
   * @generated
   * @ordered
   */
  protected String singular = SINGULAR_EDEFAULT;

  /**
   * The default value of the '{@link #getPlural() <em>Plural</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlural()
   * @generated
   * @ordered
   */
  protected static final String PLURAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPlural() <em>Plural</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlural()
   * @generated
   * @ordered
   */
  protected String plural = PLURAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WordImpl()
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
    return UmplePackage.Literals.WORD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSingular()
  {
    return singular;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSingular(String newSingular)
  {
    String oldSingular = singular;
    singular = newSingular;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.WORD__SINGULAR, oldSingular, singular));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPlural()
  {
    return plural;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPlural(String newPlural)
  {
    String oldPlural = plural;
    plural = newPlural;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.WORD__PLURAL, oldPlural, plural));
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
      case UmplePackage.WORD__SINGULAR:
        return getSingular();
      case UmplePackage.WORD__PLURAL:
        return getPlural();
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
      case UmplePackage.WORD__SINGULAR:
        setSingular((String)newValue);
        return;
      case UmplePackage.WORD__PLURAL:
        setPlural((String)newValue);
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
      case UmplePackage.WORD__SINGULAR:
        setSingular(SINGULAR_EDEFAULT);
        return;
      case UmplePackage.WORD__PLURAL:
        setPlural(PLURAL_EDEFAULT);
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
      case UmplePackage.WORD__SINGULAR:
        return SINGULAR_EDEFAULT == null ? singular != null : !SINGULAR_EDEFAULT.equals(singular);
      case UmplePackage.WORD__PLURAL:
        return PLURAL_EDEFAULT == null ? plural != null : !PLURAL_EDEFAULT.equals(plural);
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
    result.append(" (singular: ");
    result.append(singular);
    result.append(", plural: ");
    result.append(plural);
    result.append(')');
    return result.toString();
  }

} //WordImpl
