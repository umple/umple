/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Comment_;
import cruise.umple.umple.InlineComment_;
import cruise.umple.umple.MultilineComment_;
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
 * An implementation of the model object '<em><b>Comment </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Comment_Impl#getInlineComment_1 <em>Inline Comment 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Comment_Impl#getMultilineComment_1 <em>Multiline Comment 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Comment_Impl extends MinimalEObjectImpl.Container implements Comment_
{
  /**
   * The cached value of the '{@link #getInlineComment_1() <em>Inline Comment 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInlineComment_1()
   * @generated
   * @ordered
   */
  protected EList<InlineComment_> inlineComment_1;

  /**
   * The cached value of the '{@link #getMultilineComment_1() <em>Multiline Comment 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultilineComment_1()
   * @generated
   * @ordered
   */
  protected EList<MultilineComment_> multilineComment_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Comment_Impl()
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
    return UmplePackage.eINSTANCE.getComment_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InlineComment_> getInlineComment_1()
  {
    if (inlineComment_1 == null)
    {
      inlineComment_1 = new EObjectContainmentEList<InlineComment_>(InlineComment_.class, this, UmplePackage.COMMENT___INLINE_COMMENT_1);
    }
    return inlineComment_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MultilineComment_> getMultilineComment_1()
  {
    if (multilineComment_1 == null)
    {
      multilineComment_1 = new EObjectContainmentEList<MultilineComment_>(MultilineComment_.class, this, UmplePackage.COMMENT___MULTILINE_COMMENT_1);
    }
    return multilineComment_1;
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
      case UmplePackage.COMMENT___INLINE_COMMENT_1:
        return ((InternalEList<?>)getInlineComment_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.COMMENT___MULTILINE_COMMENT_1:
        return ((InternalEList<?>)getMultilineComment_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.COMMENT___INLINE_COMMENT_1:
        return getInlineComment_1();
      case UmplePackage.COMMENT___MULTILINE_COMMENT_1:
        return getMultilineComment_1();
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
      case UmplePackage.COMMENT___INLINE_COMMENT_1:
        getInlineComment_1().clear();
        getInlineComment_1().addAll((Collection<? extends InlineComment_>)newValue);
        return;
      case UmplePackage.COMMENT___MULTILINE_COMMENT_1:
        getMultilineComment_1().clear();
        getMultilineComment_1().addAll((Collection<? extends MultilineComment_>)newValue);
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
      case UmplePackage.COMMENT___INLINE_COMMENT_1:
        getInlineComment_1().clear();
        return;
      case UmplePackage.COMMENT___MULTILINE_COMMENT_1:
        getMultilineComment_1().clear();
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
      case UmplePackage.COMMENT___INLINE_COMMENT_1:
        return inlineComment_1 != null && !inlineComment_1.isEmpty();
      case UmplePackage.COMMENT___MULTILINE_COMMENT_1:
        return multilineComment_1 != null && !multilineComment_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Comment_Impl
