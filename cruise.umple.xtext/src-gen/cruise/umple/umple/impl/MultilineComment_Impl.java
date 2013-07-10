/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.MultilineComment_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiline Comment </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.MultilineComment_Impl#getMultilineComment_1 <em>Multiline Comment 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultilineComment_Impl extends MinimalEObjectImpl.Container implements MultilineComment_
{
  /**
   * The default value of the '{@link #getMultilineComment_1() <em>Multiline Comment 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultilineComment_1()
   * @generated
   * @ordered
   */
  protected static final String MULTILINE_COMMENT_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMultilineComment_1() <em>Multiline Comment 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultilineComment_1()
   * @generated
   * @ordered
   */
  protected String multilineComment_1 = MULTILINE_COMMENT_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultilineComment_Impl()
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
    return UmplePackage.eINSTANCE.getMultilineComment_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMultilineComment_1()
  {
    return multilineComment_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultilineComment_1(String newMultilineComment_1)
  {
    String oldMultilineComment_1 = multilineComment_1;
    multilineComment_1 = newMultilineComment_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MULTILINE_COMMENT___MULTILINE_COMMENT_1, oldMultilineComment_1, multilineComment_1));
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
      case UmplePackage.MULTILINE_COMMENT___MULTILINE_COMMENT_1:
        return getMultilineComment_1();
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
      case UmplePackage.MULTILINE_COMMENT___MULTILINE_COMMENT_1:
        setMultilineComment_1((String)newValue);
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
      case UmplePackage.MULTILINE_COMMENT___MULTILINE_COMMENT_1:
        setMultilineComment_1(MULTILINE_COMMENT_1_EDEFAULT);
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
      case UmplePackage.MULTILINE_COMMENT___MULTILINE_COMMENT_1:
        return MULTILINE_COMMENT_1_EDEFAULT == null ? multilineComment_1 != null : !MULTILINE_COMMENT_1_EDEFAULT.equals(multilineComment_1);
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
    result.append(" (multilineComment_1: ");
    result.append(multilineComment_1);
    result.append(')');
    return result.toString();
  }

} //MultilineComment_Impl
