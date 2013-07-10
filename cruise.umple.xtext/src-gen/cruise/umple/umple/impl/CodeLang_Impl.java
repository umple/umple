/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.CodeLang_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Lang </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.CodeLang_Impl#getCodeLang_1 <em>Code Lang 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodeLang_Impl extends MinimalEObjectImpl.Container implements CodeLang_
{
  /**
   * The default value of the '{@link #getCodeLang_1() <em>Code Lang 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodeLang_1()
   * @generated
   * @ordered
   */
  protected static final String CODE_LANG_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCodeLang_1() <em>Code Lang 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodeLang_1()
   * @generated
   * @ordered
   */
  protected String codeLang_1 = CODE_LANG_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CodeLang_Impl()
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
    return UmplePackage.eINSTANCE.getCodeLang_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCodeLang_1()
  {
    return codeLang_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCodeLang_1(String newCodeLang_1)
  {
    String oldCodeLang_1 = codeLang_1;
    codeLang_1 = newCodeLang_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.CODE_LANG___CODE_LANG_1, oldCodeLang_1, codeLang_1));
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
      case UmplePackage.CODE_LANG___CODE_LANG_1:
        return getCodeLang_1();
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
      case UmplePackage.CODE_LANG___CODE_LANG_1:
        setCodeLang_1((String)newValue);
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
      case UmplePackage.CODE_LANG___CODE_LANG_1:
        setCodeLang_1(CODE_LANG_1_EDEFAULT);
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
      case UmplePackage.CODE_LANG___CODE_LANG_1:
        return CODE_LANG_1_EDEFAULT == null ? codeLang_1 != null : !CODE_LANG_1_EDEFAULT.equals(codeLang_1);
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
    result.append(" (codeLang_1: ");
    result.append(codeLang_1);
    result.append(')');
    return result.toString();
  }

} //CodeLang_Impl
