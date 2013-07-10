/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AbstractMethodDeclaration_;
import cruise.umple.umple.ConstantDeclaration_;
import cruise.umple.umple.DisplayColor_;
import cruise.umple.umple.ExtraCode_;
import cruise.umple.umple.InterfaceMemberDeclaration_;
import cruise.umple.umple.IsA_;
import cruise.umple.umple.Position_;
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
 * An implementation of the model object '<em><b>Interface Member Declaration </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.InterfaceMemberDeclaration_Impl#getConstantDeclaration_1 <em>Constant Declaration 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InterfaceMemberDeclaration_Impl#getAbstractMethodDeclaration_1 <em>Abstract Method Declaration 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InterfaceMemberDeclaration_Impl#getPosition_1 <em>Position 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InterfaceMemberDeclaration_Impl#getDisplayColor_1 <em>Display Color 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InterfaceMemberDeclaration_Impl#getIsA_1 <em>Is A1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.InterfaceMemberDeclaration_Impl#getExtraCode_1 <em>Extra Code 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceMemberDeclaration_Impl extends MinimalEObjectImpl.Container implements InterfaceMemberDeclaration_
{
  /**
   * The cached value of the '{@link #getConstantDeclaration_1() <em>Constant Declaration 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstantDeclaration_1()
   * @generated
   * @ordered
   */
  protected EList<ConstantDeclaration_> constantDeclaration_1;

  /**
   * The cached value of the '{@link #getAbstractMethodDeclaration_1() <em>Abstract Method Declaration 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbstractMethodDeclaration_1()
   * @generated
   * @ordered
   */
  protected EList<AbstractMethodDeclaration_> abstractMethodDeclaration_1;

  /**
   * The cached value of the '{@link #getPosition_1() <em>Position 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPosition_1()
   * @generated
   * @ordered
   */
  protected EList<Position_> position_1;

  /**
   * The cached value of the '{@link #getDisplayColor_1() <em>Display Color 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDisplayColor_1()
   * @generated
   * @ordered
   */
  protected EList<DisplayColor_> displayColor_1;

  /**
   * The cached value of the '{@link #getIsA_1() <em>Is A1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIsA_1()
   * @generated
   * @ordered
   */
  protected EList<IsA_> isA_1;

  /**
   * The cached value of the '{@link #getExtraCode_1() <em>Extra Code 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtraCode_1()
   * @generated
   * @ordered
   */
  protected EList<ExtraCode_> extraCode_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InterfaceMemberDeclaration_Impl()
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
    return UmplePackage.eINSTANCE.getInterfaceMemberDeclaration_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstantDeclaration_> getConstantDeclaration_1()
  {
    if (constantDeclaration_1 == null)
    {
      constantDeclaration_1 = new EObjectContainmentEList<ConstantDeclaration_>(ConstantDeclaration_.class, this, UmplePackage.INTERFACE_MEMBER_DECLARATION___CONSTANT_DECLARATION_1);
    }
    return constantDeclaration_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractMethodDeclaration_> getAbstractMethodDeclaration_1()
  {
    if (abstractMethodDeclaration_1 == null)
    {
      abstractMethodDeclaration_1 = new EObjectContainmentEList<AbstractMethodDeclaration_>(AbstractMethodDeclaration_.class, this, UmplePackage.INTERFACE_MEMBER_DECLARATION___ABSTRACT_METHOD_DECLARATION_1);
    }
    return abstractMethodDeclaration_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Position_> getPosition_1()
  {
    if (position_1 == null)
    {
      position_1 = new EObjectContainmentEList<Position_>(Position_.class, this, UmplePackage.INTERFACE_MEMBER_DECLARATION___POSITION_1);
    }
    return position_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DisplayColor_> getDisplayColor_1()
  {
    if (displayColor_1 == null)
    {
      displayColor_1 = new EObjectContainmentEList<DisplayColor_>(DisplayColor_.class, this, UmplePackage.INTERFACE_MEMBER_DECLARATION___DISPLAY_COLOR_1);
    }
    return displayColor_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IsA_> getIsA_1()
  {
    if (isA_1 == null)
    {
      isA_1 = new EObjectContainmentEList<IsA_>(IsA_.class, this, UmplePackage.INTERFACE_MEMBER_DECLARATION___IS_A1);
    }
    return isA_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExtraCode_> getExtraCode_1()
  {
    if (extraCode_1 == null)
    {
      extraCode_1 = new EObjectContainmentEList<ExtraCode_>(ExtraCode_.class, this, UmplePackage.INTERFACE_MEMBER_DECLARATION___EXTRA_CODE_1);
    }
    return extraCode_1;
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
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___CONSTANT_DECLARATION_1:
        return ((InternalEList<?>)getConstantDeclaration_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___ABSTRACT_METHOD_DECLARATION_1:
        return ((InternalEList<?>)getAbstractMethodDeclaration_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___POSITION_1:
        return ((InternalEList<?>)getPosition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___DISPLAY_COLOR_1:
        return ((InternalEList<?>)getDisplayColor_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___IS_A1:
        return ((InternalEList<?>)getIsA_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___EXTRA_CODE_1:
        return ((InternalEList<?>)getExtraCode_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___CONSTANT_DECLARATION_1:
        return getConstantDeclaration_1();
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___ABSTRACT_METHOD_DECLARATION_1:
        return getAbstractMethodDeclaration_1();
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___POSITION_1:
        return getPosition_1();
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___DISPLAY_COLOR_1:
        return getDisplayColor_1();
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___IS_A1:
        return getIsA_1();
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___EXTRA_CODE_1:
        return getExtraCode_1();
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
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___CONSTANT_DECLARATION_1:
        getConstantDeclaration_1().clear();
        getConstantDeclaration_1().addAll((Collection<? extends ConstantDeclaration_>)newValue);
        return;
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___ABSTRACT_METHOD_DECLARATION_1:
        getAbstractMethodDeclaration_1().clear();
        getAbstractMethodDeclaration_1().addAll((Collection<? extends AbstractMethodDeclaration_>)newValue);
        return;
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___POSITION_1:
        getPosition_1().clear();
        getPosition_1().addAll((Collection<? extends Position_>)newValue);
        return;
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___DISPLAY_COLOR_1:
        getDisplayColor_1().clear();
        getDisplayColor_1().addAll((Collection<? extends DisplayColor_>)newValue);
        return;
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___IS_A1:
        getIsA_1().clear();
        getIsA_1().addAll((Collection<? extends IsA_>)newValue);
        return;
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___EXTRA_CODE_1:
        getExtraCode_1().clear();
        getExtraCode_1().addAll((Collection<? extends ExtraCode_>)newValue);
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
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___CONSTANT_DECLARATION_1:
        getConstantDeclaration_1().clear();
        return;
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___ABSTRACT_METHOD_DECLARATION_1:
        getAbstractMethodDeclaration_1().clear();
        return;
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___POSITION_1:
        getPosition_1().clear();
        return;
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___DISPLAY_COLOR_1:
        getDisplayColor_1().clear();
        return;
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___IS_A1:
        getIsA_1().clear();
        return;
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___EXTRA_CODE_1:
        getExtraCode_1().clear();
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
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___CONSTANT_DECLARATION_1:
        return constantDeclaration_1 != null && !constantDeclaration_1.isEmpty();
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___ABSTRACT_METHOD_DECLARATION_1:
        return abstractMethodDeclaration_1 != null && !abstractMethodDeclaration_1.isEmpty();
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___POSITION_1:
        return position_1 != null && !position_1.isEmpty();
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___DISPLAY_COLOR_1:
        return displayColor_1 != null && !displayColor_1.isEmpty();
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___IS_A1:
        return isA_1 != null && !isA_1.isEmpty();
      case UmplePackage.INTERFACE_MEMBER_DECLARATION___EXTRA_CODE_1:
        return extraCode_1 != null && !extraCode_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InterfaceMemberDeclaration_Impl
