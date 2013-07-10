/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Abstract_;
import cruise.umple.umple.Attribute_;
import cruise.umple.umple.ClassContent_;
import cruise.umple.umple.ClassDefinition_;
import cruise.umple.umple.Comment_;
import cruise.umple.umple.ConcreteMethodDeclaration_;
import cruise.umple.umple.ConstantDeclaration_;
import cruise.umple.umple.Depend_;
import cruise.umple.umple.DisplayColor_;
import cruise.umple.umple.ExtraCode_;
import cruise.umple.umple.InlineAssociation_;
import cruise.umple.umple.Invariant_;
import cruise.umple.umple.Position_;
import cruise.umple.umple.SoftwarePattern_;
import cruise.umple.umple.StateMachine_;
import cruise.umple.umple.SymmetricReflexiveAssociation_;
import cruise.umple.umple.Trace_;
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
 * An implementation of the model object '<em><b>Class Content </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getComment_1 <em>Comment 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getClassDefinition_1 <em>Class Definition 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getTrace_1 <em>Trace 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getPosition_1 <em>Position 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getDisplayColor_1 <em>Display Color 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getAbstract_1 <em>Abstract 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getInvariant_1 <em>Invariant 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getSoftwarePattern_1 <em>Software Pattern 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getDepend_1 <em>Depend 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getSymmetricReflexiveAssociation_1 <em>Symmetric Reflexive Association 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getAttribute_1 <em>Attribute 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getStateMachine_1 <em>State Machine 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getInlineAssociation_1 <em>Inline Association 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getConcreteMethodDeclaration_1 <em>Concrete Method Declaration 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getConstantDeclaration_1 <em>Constant Declaration 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ClassContent_Impl#getExtraCode_1 <em>Extra Code 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassContent_Impl extends MinimalEObjectImpl.Container implements ClassContent_
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
   * The cached value of the '{@link #getTrace_1() <em>Trace 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace_1()
   * @generated
   * @ordered
   */
  protected EList<Trace_> trace_1;

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
   * The cached value of the '{@link #getAbstract_1() <em>Abstract 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbstract_1()
   * @generated
   * @ordered
   */
  protected EList<Abstract_> abstract_1;

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
   * The cached value of the '{@link #getSymmetricReflexiveAssociation_1() <em>Symmetric Reflexive Association 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymmetricReflexiveAssociation_1()
   * @generated
   * @ordered
   */
  protected EList<SymmetricReflexiveAssociation_> symmetricReflexiveAssociation_1;

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
   * The cached value of the '{@link #getStateMachine_1() <em>State Machine 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateMachine_1()
   * @generated
   * @ordered
   */
  protected EList<StateMachine_> stateMachine_1;

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
   * The cached value of the '{@link #getConcreteMethodDeclaration_1() <em>Concrete Method Declaration 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConcreteMethodDeclaration_1()
   * @generated
   * @ordered
   */
  protected EList<ConcreteMethodDeclaration_> concreteMethodDeclaration_1;

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
  protected ClassContent_Impl()
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
    return UmplePackage.eINSTANCE.getClassContent_();
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
      comment_1 = new EObjectContainmentEList<Comment_>(Comment_.class, this, UmplePackage.CLASS_CONTENT___COMMENT_1);
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
      classDefinition_1 = new EObjectContainmentEList<ClassDefinition_>(ClassDefinition_.class, this, UmplePackage.CLASS_CONTENT___CLASS_DEFINITION_1);
    }
    return classDefinition_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Trace_> getTrace_1()
  {
    if (trace_1 == null)
    {
      trace_1 = new EObjectContainmentEList<Trace_>(Trace_.class, this, UmplePackage.CLASS_CONTENT___TRACE_1);
    }
    return trace_1;
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
      position_1 = new EObjectContainmentEList<Position_>(Position_.class, this, UmplePackage.CLASS_CONTENT___POSITION_1);
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
      displayColor_1 = new EObjectContainmentEList<DisplayColor_>(DisplayColor_.class, this, UmplePackage.CLASS_CONTENT___DISPLAY_COLOR_1);
    }
    return displayColor_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Abstract_> getAbstract_1()
  {
    if (abstract_1 == null)
    {
      abstract_1 = new EObjectContainmentEList<Abstract_>(Abstract_.class, this, UmplePackage.CLASS_CONTENT___ABSTRACT_1);
    }
    return abstract_1;
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
      invariant_1 = new EObjectContainmentEList<Invariant_>(Invariant_.class, this, UmplePackage.CLASS_CONTENT___INVARIANT_1);
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
      softwarePattern_1 = new EObjectContainmentEList<SoftwarePattern_>(SoftwarePattern_.class, this, UmplePackage.CLASS_CONTENT___SOFTWARE_PATTERN_1);
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
      depend_1 = new EObjectContainmentEList<Depend_>(Depend_.class, this, UmplePackage.CLASS_CONTENT___DEPEND_1);
    }
    return depend_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SymmetricReflexiveAssociation_> getSymmetricReflexiveAssociation_1()
  {
    if (symmetricReflexiveAssociation_1 == null)
    {
      symmetricReflexiveAssociation_1 = new EObjectContainmentEList<SymmetricReflexiveAssociation_>(SymmetricReflexiveAssociation_.class, this, UmplePackage.CLASS_CONTENT___SYMMETRIC_REFLEXIVE_ASSOCIATION_1);
    }
    return symmetricReflexiveAssociation_1;
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
      attribute_1 = new EObjectContainmentEList<Attribute_>(Attribute_.class, this, UmplePackage.CLASS_CONTENT___ATTRIBUTE_1);
    }
    return attribute_1;
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
      stateMachine_1 = new EObjectContainmentEList<StateMachine_>(StateMachine_.class, this, UmplePackage.CLASS_CONTENT___STATE_MACHINE_1);
    }
    return stateMachine_1;
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
      inlineAssociation_1 = new EObjectContainmentEList<InlineAssociation_>(InlineAssociation_.class, this, UmplePackage.CLASS_CONTENT___INLINE_ASSOCIATION_1);
    }
    return inlineAssociation_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConcreteMethodDeclaration_> getConcreteMethodDeclaration_1()
  {
    if (concreteMethodDeclaration_1 == null)
    {
      concreteMethodDeclaration_1 = new EObjectContainmentEList<ConcreteMethodDeclaration_>(ConcreteMethodDeclaration_.class, this, UmplePackage.CLASS_CONTENT___CONCRETE_METHOD_DECLARATION_1);
    }
    return concreteMethodDeclaration_1;
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
      constantDeclaration_1 = new EObjectContainmentEList<ConstantDeclaration_>(ConstantDeclaration_.class, this, UmplePackage.CLASS_CONTENT___CONSTANT_DECLARATION_1);
    }
    return constantDeclaration_1;
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
      extraCode_1 = new EObjectContainmentEList<ExtraCode_>(ExtraCode_.class, this, UmplePackage.CLASS_CONTENT___EXTRA_CODE_1);
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
      case UmplePackage.CLASS_CONTENT___COMMENT_1:
        return ((InternalEList<?>)getComment_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___CLASS_DEFINITION_1:
        return ((InternalEList<?>)getClassDefinition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___TRACE_1:
        return ((InternalEList<?>)getTrace_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___POSITION_1:
        return ((InternalEList<?>)getPosition_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___DISPLAY_COLOR_1:
        return ((InternalEList<?>)getDisplayColor_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___ABSTRACT_1:
        return ((InternalEList<?>)getAbstract_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___INVARIANT_1:
        return ((InternalEList<?>)getInvariant_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___SOFTWARE_PATTERN_1:
        return ((InternalEList<?>)getSoftwarePattern_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___DEPEND_1:
        return ((InternalEList<?>)getDepend_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___SYMMETRIC_REFLEXIVE_ASSOCIATION_1:
        return ((InternalEList<?>)getSymmetricReflexiveAssociation_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___ATTRIBUTE_1:
        return ((InternalEList<?>)getAttribute_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___STATE_MACHINE_1:
        return ((InternalEList<?>)getStateMachine_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___INLINE_ASSOCIATION_1:
        return ((InternalEList<?>)getInlineAssociation_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___CONCRETE_METHOD_DECLARATION_1:
        return ((InternalEList<?>)getConcreteMethodDeclaration_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___CONSTANT_DECLARATION_1:
        return ((InternalEList<?>)getConstantDeclaration_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CLASS_CONTENT___EXTRA_CODE_1:
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
      case UmplePackage.CLASS_CONTENT___COMMENT_1:
        return getComment_1();
      case UmplePackage.CLASS_CONTENT___CLASS_DEFINITION_1:
        return getClassDefinition_1();
      case UmplePackage.CLASS_CONTENT___TRACE_1:
        return getTrace_1();
      case UmplePackage.CLASS_CONTENT___POSITION_1:
        return getPosition_1();
      case UmplePackage.CLASS_CONTENT___DISPLAY_COLOR_1:
        return getDisplayColor_1();
      case UmplePackage.CLASS_CONTENT___ABSTRACT_1:
        return getAbstract_1();
      case UmplePackage.CLASS_CONTENT___INVARIANT_1:
        return getInvariant_1();
      case UmplePackage.CLASS_CONTENT___SOFTWARE_PATTERN_1:
        return getSoftwarePattern_1();
      case UmplePackage.CLASS_CONTENT___DEPEND_1:
        return getDepend_1();
      case UmplePackage.CLASS_CONTENT___SYMMETRIC_REFLEXIVE_ASSOCIATION_1:
        return getSymmetricReflexiveAssociation_1();
      case UmplePackage.CLASS_CONTENT___ATTRIBUTE_1:
        return getAttribute_1();
      case UmplePackage.CLASS_CONTENT___STATE_MACHINE_1:
        return getStateMachine_1();
      case UmplePackage.CLASS_CONTENT___INLINE_ASSOCIATION_1:
        return getInlineAssociation_1();
      case UmplePackage.CLASS_CONTENT___CONCRETE_METHOD_DECLARATION_1:
        return getConcreteMethodDeclaration_1();
      case UmplePackage.CLASS_CONTENT___CONSTANT_DECLARATION_1:
        return getConstantDeclaration_1();
      case UmplePackage.CLASS_CONTENT___EXTRA_CODE_1:
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
      case UmplePackage.CLASS_CONTENT___COMMENT_1:
        getComment_1().clear();
        getComment_1().addAll((Collection<? extends Comment_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___CLASS_DEFINITION_1:
        getClassDefinition_1().clear();
        getClassDefinition_1().addAll((Collection<? extends ClassDefinition_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___TRACE_1:
        getTrace_1().clear();
        getTrace_1().addAll((Collection<? extends Trace_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___POSITION_1:
        getPosition_1().clear();
        getPosition_1().addAll((Collection<? extends Position_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___DISPLAY_COLOR_1:
        getDisplayColor_1().clear();
        getDisplayColor_1().addAll((Collection<? extends DisplayColor_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___ABSTRACT_1:
        getAbstract_1().clear();
        getAbstract_1().addAll((Collection<? extends Abstract_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___INVARIANT_1:
        getInvariant_1().clear();
        getInvariant_1().addAll((Collection<? extends Invariant_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___SOFTWARE_PATTERN_1:
        getSoftwarePattern_1().clear();
        getSoftwarePattern_1().addAll((Collection<? extends SoftwarePattern_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___DEPEND_1:
        getDepend_1().clear();
        getDepend_1().addAll((Collection<? extends Depend_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___SYMMETRIC_REFLEXIVE_ASSOCIATION_1:
        getSymmetricReflexiveAssociation_1().clear();
        getSymmetricReflexiveAssociation_1().addAll((Collection<? extends SymmetricReflexiveAssociation_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___ATTRIBUTE_1:
        getAttribute_1().clear();
        getAttribute_1().addAll((Collection<? extends Attribute_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___STATE_MACHINE_1:
        getStateMachine_1().clear();
        getStateMachine_1().addAll((Collection<? extends StateMachine_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___INLINE_ASSOCIATION_1:
        getInlineAssociation_1().clear();
        getInlineAssociation_1().addAll((Collection<? extends InlineAssociation_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___CONCRETE_METHOD_DECLARATION_1:
        getConcreteMethodDeclaration_1().clear();
        getConcreteMethodDeclaration_1().addAll((Collection<? extends ConcreteMethodDeclaration_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___CONSTANT_DECLARATION_1:
        getConstantDeclaration_1().clear();
        getConstantDeclaration_1().addAll((Collection<? extends ConstantDeclaration_>)newValue);
        return;
      case UmplePackage.CLASS_CONTENT___EXTRA_CODE_1:
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
      case UmplePackage.CLASS_CONTENT___COMMENT_1:
        getComment_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___CLASS_DEFINITION_1:
        getClassDefinition_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___TRACE_1:
        getTrace_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___POSITION_1:
        getPosition_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___DISPLAY_COLOR_1:
        getDisplayColor_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___ABSTRACT_1:
        getAbstract_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___INVARIANT_1:
        getInvariant_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___SOFTWARE_PATTERN_1:
        getSoftwarePattern_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___DEPEND_1:
        getDepend_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___SYMMETRIC_REFLEXIVE_ASSOCIATION_1:
        getSymmetricReflexiveAssociation_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___ATTRIBUTE_1:
        getAttribute_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___STATE_MACHINE_1:
        getStateMachine_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___INLINE_ASSOCIATION_1:
        getInlineAssociation_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___CONCRETE_METHOD_DECLARATION_1:
        getConcreteMethodDeclaration_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___CONSTANT_DECLARATION_1:
        getConstantDeclaration_1().clear();
        return;
      case UmplePackage.CLASS_CONTENT___EXTRA_CODE_1:
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
      case UmplePackage.CLASS_CONTENT___COMMENT_1:
        return comment_1 != null && !comment_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___CLASS_DEFINITION_1:
        return classDefinition_1 != null && !classDefinition_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___TRACE_1:
        return trace_1 != null && !trace_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___POSITION_1:
        return position_1 != null && !position_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___DISPLAY_COLOR_1:
        return displayColor_1 != null && !displayColor_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___ABSTRACT_1:
        return abstract_1 != null && !abstract_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___INVARIANT_1:
        return invariant_1 != null && !invariant_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___SOFTWARE_PATTERN_1:
        return softwarePattern_1 != null && !softwarePattern_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___DEPEND_1:
        return depend_1 != null && !depend_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___SYMMETRIC_REFLEXIVE_ASSOCIATION_1:
        return symmetricReflexiveAssociation_1 != null && !symmetricReflexiveAssociation_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___ATTRIBUTE_1:
        return attribute_1 != null && !attribute_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___STATE_MACHINE_1:
        return stateMachine_1 != null && !stateMachine_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___INLINE_ASSOCIATION_1:
        return inlineAssociation_1 != null && !inlineAssociation_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___CONCRETE_METHOD_DECLARATION_1:
        return concreteMethodDeclaration_1 != null && !concreteMethodDeclaration_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___CONSTANT_DECLARATION_1:
        return constantDeclaration_1 != null && !constantDeclaration_1.isEmpty();
      case UmplePackage.CLASS_CONTENT___EXTRA_CODE_1:
        return extraCode_1 != null && !extraCode_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ClassContent_Impl
