/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_program_1_;
import cruise.umple.umple.Comment_;
import cruise.umple.umple.Directive_;
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
 * An implementation of the model object '<em><b>Anonymous program 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_program_1_Impl#getComment_1 <em>Comment 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_program_1_Impl#getDirective_1 <em>Directive 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_program_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_program_1_
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
   * The cached value of the '{@link #getDirective_1() <em>Directive 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirective_1()
   * @generated
   * @ordered
   */
  protected EList<Directive_> directive_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_program_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_program_1_();
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
      comment_1 = new EObjectContainmentEList<Comment_>(Comment_.class, this, UmplePackage.ANONYMOUS_PROGRAM_1__COMMENT_1);
    }
    return comment_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Directive_> getDirective_1()
  {
    if (directive_1 == null)
    {
      directive_1 = new EObjectContainmentEList<Directive_>(Directive_.class, this, UmplePackage.ANONYMOUS_PROGRAM_1__DIRECTIVE_1);
    }
    return directive_1;
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
      case UmplePackage.ANONYMOUS_PROGRAM_1__COMMENT_1:
        return ((InternalEList<?>)getComment_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ANONYMOUS_PROGRAM_1__DIRECTIVE_1:
        return ((InternalEList<?>)getDirective_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ANONYMOUS_PROGRAM_1__COMMENT_1:
        return getComment_1();
      case UmplePackage.ANONYMOUS_PROGRAM_1__DIRECTIVE_1:
        return getDirective_1();
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
      case UmplePackage.ANONYMOUS_PROGRAM_1__COMMENT_1:
        getComment_1().clear();
        getComment_1().addAll((Collection<? extends Comment_>)newValue);
        return;
      case UmplePackage.ANONYMOUS_PROGRAM_1__DIRECTIVE_1:
        getDirective_1().clear();
        getDirective_1().addAll((Collection<? extends Directive_>)newValue);
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
      case UmplePackage.ANONYMOUS_PROGRAM_1__COMMENT_1:
        getComment_1().clear();
        return;
      case UmplePackage.ANONYMOUS_PROGRAM_1__DIRECTIVE_1:
        getDirective_1().clear();
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
      case UmplePackage.ANONYMOUS_PROGRAM_1__COMMENT_1:
        return comment_1 != null && !comment_1.isEmpty();
      case UmplePackage.ANONYMOUS_PROGRAM_1__DIRECTIVE_1:
        return directive_1 != null && !directive_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Anonymous_program_1_Impl
