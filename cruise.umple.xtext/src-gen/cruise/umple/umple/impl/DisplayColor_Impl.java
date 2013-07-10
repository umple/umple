/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.DisplayColor_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Display Color </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.DisplayColor_Impl#getAnonymous_displayColor_1_1 <em>Anonymous display Color 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.DisplayColor_Impl#getColorValue_1 <em>Color Value 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DisplayColor_Impl extends MinimalEObjectImpl.Container implements DisplayColor_
{
  /**
   * The cached value of the '{@link #getAnonymous_displayColor_1_1() <em>Anonymous display Color 11</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_displayColor_1_1()
   * @generated
   * @ordered
   */
  protected EList<String> anonymous_displayColor_1_1;

  /**
   * The default value of the '{@link #getColorValue_1() <em>Color Value 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColorValue_1()
   * @generated
   * @ordered
   */
  protected static final String COLOR_VALUE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getColorValue_1() <em>Color Value 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColorValue_1()
   * @generated
   * @ordered
   */
  protected String colorValue_1 = COLOR_VALUE_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DisplayColor_Impl()
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
    return UmplePackage.eINSTANCE.getDisplayColor_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getAnonymous_displayColor_1_1()
  {
    if (anonymous_displayColor_1_1 == null)
    {
      anonymous_displayColor_1_1 = new EDataTypeEList<String>(String.class, this, UmplePackage.DISPLAY_COLOR___ANONYMOUS_DISPLAY_COLOR_11);
    }
    return anonymous_displayColor_1_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getColorValue_1()
  {
    return colorValue_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setColorValue_1(String newColorValue_1)
  {
    String oldColorValue_1 = colorValue_1;
    colorValue_1 = newColorValue_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.DISPLAY_COLOR___COLOR_VALUE_1, oldColorValue_1, colorValue_1));
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
      case UmplePackage.DISPLAY_COLOR___ANONYMOUS_DISPLAY_COLOR_11:
        return getAnonymous_displayColor_1_1();
      case UmplePackage.DISPLAY_COLOR___COLOR_VALUE_1:
        return getColorValue_1();
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
      case UmplePackage.DISPLAY_COLOR___ANONYMOUS_DISPLAY_COLOR_11:
        getAnonymous_displayColor_1_1().clear();
        getAnonymous_displayColor_1_1().addAll((Collection<? extends String>)newValue);
        return;
      case UmplePackage.DISPLAY_COLOR___COLOR_VALUE_1:
        setColorValue_1((String)newValue);
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
      case UmplePackage.DISPLAY_COLOR___ANONYMOUS_DISPLAY_COLOR_11:
        getAnonymous_displayColor_1_1().clear();
        return;
      case UmplePackage.DISPLAY_COLOR___COLOR_VALUE_1:
        setColorValue_1(COLOR_VALUE_1_EDEFAULT);
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
      case UmplePackage.DISPLAY_COLOR___ANONYMOUS_DISPLAY_COLOR_11:
        return anonymous_displayColor_1_1 != null && !anonymous_displayColor_1_1.isEmpty();
      case UmplePackage.DISPLAY_COLOR___COLOR_VALUE_1:
        return COLOR_VALUE_1_EDEFAULT == null ? colorValue_1 != null : !COLOR_VALUE_1_EDEFAULT.equals(colorValue_1);
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
    result.append(" (Anonymous_displayColor_1_1: ");
    result.append(anonymous_displayColor_1_1);
    result.append(", colorValue_1: ");
    result.append(colorValue_1);
    result.append(')');
    return result.toString();
  }

} //DisplayColor_Impl
