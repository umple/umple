/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.InlineComment_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inline Comment </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.InlineComment_Impl#getInlineComment_1 <em>Inline Comment 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InlineComment_Impl extends MinimalEObjectImpl.Container implements InlineComment_
{
  /**
   * The default value of the '{@link #getInlineComment_1() <em>Inline Comment 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInlineComment_1()
   * @generated
   * @ordered
   */
  protected static final String INLINE_COMMENT_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInlineComment_1() <em>Inline Comment 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInlineComment_1()
   * @generated
   * @ordered
   */
  protected String inlineComment_1 = INLINE_COMMENT_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InlineComment_Impl()
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
    return UmplePackage.eINSTANCE.getInlineComment_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInlineComment_1()
  {
    return inlineComment_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInlineComment_1(String newInlineComment_1)
  {
    String oldInlineComment_1 = inlineComment_1;
    inlineComment_1 = newInlineComment_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.INLINE_COMMENT___INLINE_COMMENT_1, oldInlineComment_1, inlineComment_1));
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
      case UmplePackage.INLINE_COMMENT___INLINE_COMMENT_1:
        return getInlineComment_1();
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
      case UmplePackage.INLINE_COMMENT___INLINE_COMMENT_1:
        setInlineComment_1((String)newValue);
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
      case UmplePackage.INLINE_COMMENT___INLINE_COMMENT_1:
        setInlineComment_1(INLINE_COMMENT_1_EDEFAULT);
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
      case UmplePackage.INLINE_COMMENT___INLINE_COMMENT_1:
        return INLINE_COMMENT_1_EDEFAULT == null ? inlineComment_1 != null : !INLINE_COMMENT_1_EDEFAULT.equals(inlineComment_1);
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
    result.append(" (inlineComment_1: ");
    result.append(inlineComment_1);
    result.append(')');
    return result.toString();
  }

} //InlineComment_Impl
