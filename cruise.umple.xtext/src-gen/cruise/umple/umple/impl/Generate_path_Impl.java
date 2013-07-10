/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Generate_path_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generate path </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Generate_path_Impl#getLanguage_1 <em>Language 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Generate_path_Impl#getOutput_1 <em>Output 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Generate_path_Impl#getOverride_1 <em>Override 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Generate_path_Impl extends MinimalEObjectImpl.Container implements Generate_path_
{
  /**
   * The default value of the '{@link #getLanguage_1() <em>Language 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanguage_1()
   * @generated
   * @ordered
   */
  protected static final String LANGUAGE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLanguage_1() <em>Language 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanguage_1()
   * @generated
   * @ordered
   */
  protected String language_1 = LANGUAGE_1_EDEFAULT;

  /**
   * The default value of the '{@link #getOutput_1() <em>Output 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutput_1()
   * @generated
   * @ordered
   */
  protected static final String OUTPUT_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOutput_1() <em>Output 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutput_1()
   * @generated
   * @ordered
   */
  protected String output_1 = OUTPUT_1_EDEFAULT;

  /**
   * The default value of the '{@link #getOverride_1() <em>Override 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOverride_1()
   * @generated
   * @ordered
   */
  protected static final String OVERRIDE_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOverride_1() <em>Override 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOverride_1()
   * @generated
   * @ordered
   */
  protected String override_1 = OVERRIDE_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Generate_path_Impl()
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
    return UmplePackage.eINSTANCE.getGenerate_path_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLanguage_1()
  {
    return language_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLanguage_1(String newLanguage_1)
  {
    String oldLanguage_1 = language_1;
    language_1 = newLanguage_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.GENERATE_PATH___LANGUAGE_1, oldLanguage_1, language_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOutput_1()
  {
    return output_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutput_1(String newOutput_1)
  {
    String oldOutput_1 = output_1;
    output_1 = newOutput_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.GENERATE_PATH___OUTPUT_1, oldOutput_1, output_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOverride_1()
  {
    return override_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOverride_1(String newOverride_1)
  {
    String oldOverride_1 = override_1;
    override_1 = newOverride_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.GENERATE_PATH___OVERRIDE_1, oldOverride_1, override_1));
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
      case UmplePackage.GENERATE_PATH___LANGUAGE_1:
        return getLanguage_1();
      case UmplePackage.GENERATE_PATH___OUTPUT_1:
        return getOutput_1();
      case UmplePackage.GENERATE_PATH___OVERRIDE_1:
        return getOverride_1();
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
      case UmplePackage.GENERATE_PATH___LANGUAGE_1:
        setLanguage_1((String)newValue);
        return;
      case UmplePackage.GENERATE_PATH___OUTPUT_1:
        setOutput_1((String)newValue);
        return;
      case UmplePackage.GENERATE_PATH___OVERRIDE_1:
        setOverride_1((String)newValue);
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
      case UmplePackage.GENERATE_PATH___LANGUAGE_1:
        setLanguage_1(LANGUAGE_1_EDEFAULT);
        return;
      case UmplePackage.GENERATE_PATH___OUTPUT_1:
        setOutput_1(OUTPUT_1_EDEFAULT);
        return;
      case UmplePackage.GENERATE_PATH___OVERRIDE_1:
        setOverride_1(OVERRIDE_1_EDEFAULT);
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
      case UmplePackage.GENERATE_PATH___LANGUAGE_1:
        return LANGUAGE_1_EDEFAULT == null ? language_1 != null : !LANGUAGE_1_EDEFAULT.equals(language_1);
      case UmplePackage.GENERATE_PATH___OUTPUT_1:
        return OUTPUT_1_EDEFAULT == null ? output_1 != null : !OUTPUT_1_EDEFAULT.equals(output_1);
      case UmplePackage.GENERATE_PATH___OVERRIDE_1:
        return OVERRIDE_1_EDEFAULT == null ? override_1 != null : !OVERRIDE_1_EDEFAULT.equals(override_1);
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
    result.append(" (language_1: ");
    result.append(language_1);
    result.append(", output_1: ");
    result.append(output_1);
    result.append(", override_1: ");
    result.append(override_1);
    result.append(')');
    return result.toString();
  }

} //Generate_path_Impl
