/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AssociationClassContent_;
import cruise.umple.umple.Association_;
import cruise.umple.umple.Attribute_;
import cruise.umple.umple.ClassDefinition_;
import cruise.umple.umple.Comment_;
import cruise.umple.umple.Depend_;
import cruise.umple.umple.DisplayColor_;
import cruise.umple.umple.ExtraCode_;
import cruise.umple.umple.InlineAssociation_;
import cruise.umple.umple.Invariant_;
import cruise.umple.umple.Position_;
import cruise.umple.umple.SingleAssociationEnd_;
import cruise.umple.umple.SoftwarePattern_;
import cruise.umple.umple.StateMachine_;
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
 * An implementation of the model object '<em><b>Association Class Content </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getComment_1 <em>Comment 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getClassDefinition_1 <em>Class Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getPosition_1 <em>Position 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getDisplayColor_1 <em>Display Color 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getInvariant_1 <em>Invariant 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getSoftwarePattern_1 <em>Software Pattern 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getDepend_1 <em>Depend 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getSingleAssociationEnd_1 <em>Single Association End 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getStateMachine_1 <em>State Machine 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getAttribute_1 <em>Attribute 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getAssociation_1 <em>Association 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getInlineAssociation_1 <em>Inline Association 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationClassContent_Impl#getExtraCode_1 <em>Extra Code 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationClassContent_Impl extends MinimalEObjectImpl.Container implements AssociationClassContent_
{
  /**
   * The cached value of the '{@link #getComment_1() <em>Comment 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComment_1()
   * @generated
   * @ordered
   */
  protected EList<Comment_> comment_1;

  /**
   * The cached value of the '{@link #getClassDefinition_1() <em>Class Definition 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassDefinition_1()
   * @generated
   * @ordered
   */
  protected EList<ClassDefinition_> classDefinition_1;

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
   * The cached value of the '{@link #getInvariant_1() <em>Invariant 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvariant_1()
   * @generated
   * @ordered
   */
  protected EList<Invariant_> invariant_1;

  /**
   * The cached value of the '{@link #getSoftwarePattern_1() <em>Software Pattern 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSoftwarePattern_1()
   * @generated
   * @ordered
   */
  protected EList<SoftwarePattern_> softwarePattern_1;

  /**
   * The cached value of the '{@link #getDepend_1() <em>Depend 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDepend_1()
   * @generated
   * @ordered
   */
  protected EList<Depend_> depend_1;

  /**
   * The cached value of the '{@link #getSingleAssociationEnd_1() <em>Single Association End 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingleAssociationEnd_1()
   * @generated
   * @ordered
   */
  protected EList<SingleAssociationEnd_> singleAssociationEnd_1;

  /**
   * The cached value of the '{@link #getStateMachine_1() <em>State Machine 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateMachine_1()
   * @generated
   * @ordered
   */
  protected EList<StateMachine_> stateMachine_1;

  /**
   * The cached value of the '{@link #getAttribute_1() <em>Attribute 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttribute_1()
   * @generated
   * @ordered
   */
  protected EList<Attribute_> attribute_1;

  /**
   * The cached value of the '{@link #getAssociation_1() <em>Association 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociation_1()
   * @generated
   * @ordered
   */
  protected EList<Association_> association_1;

  /**
   * The cached value of the '{@link #getInlineAssociation_1() <em>Inline Association 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInlineAssociation_1()
   * @generated
   * @ordered
   */
  protected EList<InlineAssociation_> inlineAssociation_1;

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
  protected AssociationClassContent_Impl()
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
    return UmplePackage.eINSTANCE.getAssociationClassContent_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Comment_> getComment_1()
  {
    if (comment_1 == null)
    {
      comment_1 = new EObjectContainmentEList<Comment_>(Comment_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___COMMENT_1);
    }
    return comment_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClassDefinition_> getClassDefinition_1()
  {
    if (classDefinition_1 == null)
    {
      classDefinition_1 = new EObjectContainmentEList<ClassDefinition_>(ClassDefinition_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___CLASS_DEFINITION_1);
    }
    return classDefinition_1;
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
      position_1 = new EObjectContainmentEList<Position_>(Position_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___POSITION_1);
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
      displayColor_1 = new EObjectContainmentEList<DisplayColor_>(DisplayColor_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___DISPLAY_COLOR_1);
    }
    return displayColor_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Invariant_> getInvariant_1()
  {
    if (invariant_1 == null)
    {
      invariant_1 = new EObjectContainmentEList<Invariant_>(Invariant_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___INVARIANT_1);
    }
    return invariant_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SoftwarePattern_> getSoftwarePattern_1()
  {
    if (softwarePattern_1 == null)
    {
      softwarePattern_1 = new EObjectContainmentEList<SoftwarePattern_>(SoftwarePattern_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___SOFTWARE_PATTERN_1);
    }
    return softwarePattern_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Depend_> getDepend_1()
  {
    if (depend_1 == null)
    {
      depend_1 = new EObjectContainmentEList<Depend_>(Depend_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___DEPEND_1);
    }
    return depend_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SingleAssociationEnd_> getSingleAssociationEnd_1()
  {
    if (singleAssociationEnd_1 == null)
    {
      singleAssociationEnd_1 = new EObjectContainmentEList<SingleAssociationEnd_>(SingleAssociationEnd_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___SINGLE_ASSOCIATION_END_1);
    }
    return singleAssociationEnd_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StateMachine_> getStateMachine_1()
  {
    if (stateMachine_1 == null)
    {
      stateMachine_1 = new EObjectContainmentEList<StateMachine_>(StateMachine_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___STATE_MACHINE_1);
    }
    return stateMachine_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute_> getAttribute_1()
  {
    if (attribute_1 == null)
    {
      attribute_1 = new EObjectContainmentEList<Attribute_>(Attribute_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___ATTRIBUTE_1);
    }
    return attribute_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Association_> getAssociation_1()
  {
    if (association_1 == null)
    {
      association_1 = new EObjectContainmentEList<Association_>(Association_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___ASSOCIATION_1);
    }
    return association_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InlineAssociation_> getInlineAssociation_1()
  {
    if (inlineAssociation_1 == null)
    {
      inlineAssociation_1 = new EObjectContainmentEList<InlineAssociation_>(InlineAssociation_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___INLINE_ASSOCIATION_1);
    }
    return inlineAssociation_1;
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
      extraCode_1 = new EObjectContainmentEList<ExtraCode_>(ExtraCode_.class, this, UmplePackage.ASSOCIATION_CLASS_CONTENT___EXTRA_CODE_1);
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
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___COMMENT_1:
        return ((InternalEList<?>)getComment_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___CLASS_DEFINITION_1:
        return ((InternalEList<?>)getClassDefinition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___POSITION_1:
        return ((InternalEList<?>)getPosition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___DISPLAY_COLOR_1:
        return ((InternalEList<?>)getDisplayColor_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___INVARIANT_1:
        return ((InternalEList<?>)getInvariant_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___SOFTWARE_PATTERN_1:
        return ((InternalEList<?>)getSoftwarePattern_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___DEPEND_1:
        return ((InternalEList<?>)getDepend_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___SINGLE_ASSOCIATION_END_1:
        return ((InternalEList<?>)getSingleAssociationEnd_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___STATE_MACHINE_1:
        return ((InternalEList<?>)getStateMachine_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___ATTRIBUTE_1:
        return ((InternalEList<?>)getAttribute_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___ASSOCIATION_1:
        return ((InternalEList<?>)getAssociation_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___INLINE_ASSOCIATION_1:
        return ((InternalEList<?>)getInlineAssociation_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___EXTRA_CODE_1:
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
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___COMMENT_1:
        return getComment_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___CLASS_DEFINITION_1:
        return getClassDefinition_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___POSITION_1:
        return getPosition_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___DISPLAY_COLOR_1:
        return getDisplayColor_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___INVARIANT_1:
        return getInvariant_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___SOFTWARE_PATTERN_1:
        return getSoftwarePattern_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___DEPEND_1:
        return getDepend_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___SINGLE_ASSOCIATION_END_1:
        return getSingleAssociationEnd_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___STATE_MACHINE_1:
        return getStateMachine_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___ATTRIBUTE_1:
        return getAttribute_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___ASSOCIATION_1:
        return getAssociation_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___INLINE_ASSOCIATION_1:
        return getInlineAssociation_1();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___EXTRA_CODE_1:
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
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___COMMENT_1:
        getComment_1().clear();
        getComment_1().addAll((Collection<? extends Comment_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___CLASS_DEFINITION_1:
        getClassDefinition_1().clear();
        getClassDefinition_1().addAll((Collection<? extends ClassDefinition_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___POSITION_1:
        getPosition_1().clear();
        getPosition_1().addAll((Collection<? extends Position_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___DISPLAY_COLOR_1:
        getDisplayColor_1().clear();
        getDisplayColor_1().addAll((Collection<? extends DisplayColor_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___INVARIANT_1:
        getInvariant_1().clear();
        getInvariant_1().addAll((Collection<? extends Invariant_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___SOFTWARE_PATTERN_1:
        getSoftwarePattern_1().clear();
        getSoftwarePattern_1().addAll((Collection<? extends SoftwarePattern_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___DEPEND_1:
        getDepend_1().clear();
        getDepend_1().addAll((Collection<? extends Depend_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___SINGLE_ASSOCIATION_END_1:
        getSingleAssociationEnd_1().clear();
        getSingleAssociationEnd_1().addAll((Collection<? extends SingleAssociationEnd_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___STATE_MACHINE_1:
        getStateMachine_1().clear();
        getStateMachine_1().addAll((Collection<? extends StateMachine_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___ATTRIBUTE_1:
        getAttribute_1().clear();
        getAttribute_1().addAll((Collection<? extends Attribute_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___ASSOCIATION_1:
        getAssociation_1().clear();
        getAssociation_1().addAll((Collection<? extends Association_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___INLINE_ASSOCIATION_1:
        getInlineAssociation_1().clear();
        getInlineAssociation_1().addAll((Collection<? extends InlineAssociation_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___EXTRA_CODE_1:
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
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___COMMENT_1:
        getComment_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___CLASS_DEFINITION_1:
        getClassDefinition_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___POSITION_1:
        getPosition_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___DISPLAY_COLOR_1:
        getDisplayColor_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___INVARIANT_1:
        getInvariant_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___SOFTWARE_PATTERN_1:
        getSoftwarePattern_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___DEPEND_1:
        getDepend_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___SINGLE_ASSOCIATION_END_1:
        getSingleAssociationEnd_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___STATE_MACHINE_1:
        getStateMachine_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___ATTRIBUTE_1:
        getAttribute_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___ASSOCIATION_1:
        getAssociation_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___INLINE_ASSOCIATION_1:
        getInlineAssociation_1().clear();
        return;
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___EXTRA_CODE_1:
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
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___COMMENT_1:
        return comment_1 != null && !comment_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___CLASS_DEFINITION_1:
        return classDefinition_1 != null && !classDefinition_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___POSITION_1:
        return position_1 != null && !position_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___DISPLAY_COLOR_1:
        return displayColor_1 != null && !displayColor_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___INVARIANT_1:
        return invariant_1 != null && !invariant_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___SOFTWARE_PATTERN_1:
        return softwarePattern_1 != null && !softwarePattern_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___DEPEND_1:
        return depend_1 != null && !depend_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___SINGLE_ASSOCIATION_END_1:
        return singleAssociationEnd_1 != null && !singleAssociationEnd_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___STATE_MACHINE_1:
        return stateMachine_1 != null && !stateMachine_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___ATTRIBUTE_1:
        return attribute_1 != null && !attribute_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___ASSOCIATION_1:
        return association_1 != null && !association_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___INLINE_ASSOCIATION_1:
        return inlineAssociation_1 != null && !inlineAssociation_1.isEmpty();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT___EXTRA_CODE_1:
        return extraCode_1 != null && !extraCode_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AssociationClassContent_Impl
