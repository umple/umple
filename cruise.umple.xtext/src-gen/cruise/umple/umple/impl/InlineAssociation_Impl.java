/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AssociationEnd_;
import cruise.umple.umple.InlineAssociationEnd_;
import cruise.umple.umple.InlineAssociation_;
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
 * An implementation of the model object '<em><b>Inline Association </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.InlineAssociation_Impl#getModifier_1 <em>Modifier 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InlineAssociation_Impl#getInlineAssociationEnd_1 <em>Inline Association End 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InlineAssociation_Impl#getArrow_1 <em>Arrow 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InlineAssociation_Impl#getAssociationEnd_1 <em>Association End 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InlineAssociation_Impl extends MinimalEObjectImpl.Container implements InlineAssociation_
{
  /**
   * The default value of the '{@link #getModifier_1() <em>Modifier 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier_1()
   * @generated
   * @ordered
   */
  protected static final String MODIFIER_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getModifier_1() <em>Modifier 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier_1()
   * @generated
   * @ordered
   */
  protected String modifier_1 = MODIFIER_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getInlineAssociationEnd_1() <em>Inline Association End 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInlineAssociationEnd_1()
   * @generated
   * @ordered
   */
  protected EList<InlineAssociationEnd_> inlineAssociationEnd_1;

  /**
   * The default value of the '{@link #getArrow_1() <em>Arrow 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrow_1()
   * @generated
   * @ordered
   */
  protected static final String ARROW_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getArrow_1() <em>Arrow 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrow_1()
   * @generated
   * @ordered
   */
  protected String arrow_1 = ARROW_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAssociationEnd_1() <em>Association End 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationEnd_1()
   * @generated
   * @ordered
   */
  protected EList<AssociationEnd_> associationEnd_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InlineAssociation_Impl()
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
    return UmplePackage.eINSTANCE.getInlineAssociation_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getModifier_1()
  {
    return modifier_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModifier_1(String newModifier_1)
  {
    String oldModifier_1 = modifier_1;
    modifier_1 = newModifier_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.INLINE_ASSOCIATION___MODIFIER_1, oldModifier_1, modifier_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InlineAssociationEnd_> getInlineAssociationEnd_1()
  {
    if (inlineAssociationEnd_1 == null)
    {
      inlineAssociationEnd_1 = new EObjectContainmentEList<InlineAssociationEnd_>(InlineAssociationEnd_.class, this, UmplePackage.INLINE_ASSOCIATION___INLINE_ASSOCIATION_END_1);
    }
    return inlineAssociationEnd_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getArrow_1()
  {
    return arrow_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArrow_1(String newArrow_1)
  {
    String oldArrow_1 = arrow_1;
    arrow_1 = newArrow_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.INLINE_ASSOCIATION___ARROW_1, oldArrow_1, arrow_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssociationEnd_> getAssociationEnd_1()
  {
    if (associationEnd_1 == null)
    {
      associationEnd_1 = new EObjectContainmentEList<AssociationEnd_>(AssociationEnd_.class, this, UmplePackage.INLINE_ASSOCIATION___ASSOCIATION_END_1);
    }
    return associationEnd_1;
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
      case UmplePackage.INLINE_ASSOCIATION___INLINE_ASSOCIATION_END_1:
        return ((InternalEList<?>)getInlineAssociationEnd_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.INLINE_ASSOCIATION___ASSOCIATION_END_1:
        return ((InternalEList<?>)getAssociationEnd_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.INLINE_ASSOCIATION___MODIFIER_1:
        return getModifier_1();
      case UmplePackage.INLINE_ASSOCIATION___INLINE_ASSOCIATION_END_1:
        return getInlineAssociationEnd_1();
      case UmplePackage.INLINE_ASSOCIATION___ARROW_1:
        return getArrow_1();
      case UmplePackage.INLINE_ASSOCIATION___ASSOCIATION_END_1:
        return getAssociationEnd_1();
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
      case UmplePackage.INLINE_ASSOCIATION___MODIFIER_1:
        setModifier_1((String)newValue);
        return;
      case UmplePackage.INLINE_ASSOCIATION___INLINE_ASSOCIATION_END_1:
        getInlineAssociationEnd_1().clear();
        getInlineAssociationEnd_1().addAll((Collection<? extends InlineAssociationEnd_>)newValue);
        return;
      case UmplePackage.INLINE_ASSOCIATION___ARROW_1:
        setArrow_1((String)newValue);
        return;
      case UmplePackage.INLINE_ASSOCIATION___ASSOCIATION_END_1:
        getAssociationEnd_1().clear();
        getAssociationEnd_1().addAll((Collection<? extends AssociationEnd_>)newValue);
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
      case UmplePackage.INLINE_ASSOCIATION___MODIFIER_1:
        setModifier_1(MODIFIER_1_EDEFAULT);
        return;
      case UmplePackage.INLINE_ASSOCIATION___INLINE_ASSOCIATION_END_1:
        getInlineAssociationEnd_1().clear();
        return;
      case UmplePackage.INLINE_ASSOCIATION___ARROW_1:
        setArrow_1(ARROW_1_EDEFAULT);
        return;
      case UmplePackage.INLINE_ASSOCIATION___ASSOCIATION_END_1:
        getAssociationEnd_1().clear();
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
      case UmplePackage.INLINE_ASSOCIATION___MODIFIER_1:
        return MODIFIER_1_EDEFAULT == null ? modifier_1 != null : !MODIFIER_1_EDEFAULT.equals(modifier_1);
      case UmplePackage.INLINE_ASSOCIATION___INLINE_ASSOCIATION_END_1:
        return inlineAssociationEnd_1 != null && !inlineAssociationEnd_1.isEmpty();
      case UmplePackage.INLINE_ASSOCIATION___ARROW_1:
        return ARROW_1_EDEFAULT == null ? arrow_1 != null : !ARROW_1_EDEFAULT.equals(arrow_1);
      case UmplePackage.INLINE_ASSOCIATION___ASSOCIATION_END_1:
        return associationEnd_1 != null && !associationEnd_1.isEmpty();
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
    result.append(" (modifier_1: ");
    result.append(modifier_1);
    result.append(", arrow_1: ");
    result.append(arrow_1);
    result.append(')');
    return result.toString();
  }

} //InlineAssociation_Impl
