/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_constraintExpr_1_;
import cruise.umple.umple.BoolExpr_;
import cruise.umple.umple.ConstraintExpr_;
import cruise.umple.umple.GenExpr_;
import cruise.umple.umple.NegativeConstraint_;
import cruise.umple.umple.NumExpr_;
import cruise.umple.umple.StringExpr_;
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
 * An implementation of the model object '<em><b>Constraint Expr </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ConstraintExpr_Impl#getNegativeConstraint_1 <em>Negative Constraint 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConstraintExpr_Impl#getStringExpr_1 <em>String Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConstraintExpr_Impl#getBoolExpr_1 <em>Bool Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConstraintExpr_Impl#getGenExpr_1 <em>Gen Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConstraintExpr_Impl#getNumExpr_1 <em>Num Expr 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConstraintExpr_Impl#getLoneBoolean_1 <em>Lone Boolean 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ConstraintExpr_Impl#getAnonymous_constraintExpr_1_1 <em>Anonymous constraint Expr 11</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintExpr_Impl extends MinimalEObjectImpl.Container implements ConstraintExpr_
{
  /**
   * The cached value of the '{@link #getNegativeConstraint_1() <em>Negative Constraint 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNegativeConstraint_1()
   * @generated
   * @ordered
   */
  protected EList<NegativeConstraint_> negativeConstraint_1;

  /**
   * The cached value of the '{@link #getStringExpr_1() <em>String Expr 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringExpr_1()
   * @generated
   * @ordered
   */
  protected EList<StringExpr_> stringExpr_1;

  /**
   * The cached value of the '{@link #getBoolExpr_1() <em>Bool Expr 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolExpr_1()
   * @generated
   * @ordered
   */
  protected EList<BoolExpr_> boolExpr_1;

  /**
   * The cached value of the '{@link #getGenExpr_1() <em>Gen Expr 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenExpr_1()
   * @generated
   * @ordered
   */
  protected EList<GenExpr_> genExpr_1;

  /**
   * The cached value of the '{@link #getNumExpr_1() <em>Num Expr 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumExpr_1()
   * @generated
   * @ordered
   */
  protected EList<NumExpr_> numExpr_1;

  /**
   * The default value of the '{@link #getLoneBoolean_1() <em>Lone Boolean 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoneBoolean_1()
   * @generated
   * @ordered
   */
  protected static final String LONE_BOOLEAN_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLoneBoolean_1() <em>Lone Boolean 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoneBoolean_1()
   * @generated
   * @ordered
   */
  protected String loneBoolean_1 = LONE_BOOLEAN_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_constraintExpr_1_1() <em>Anonymous constraint Expr 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_constraintExpr_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_constraintExpr_1_> anonymous_constraintExpr_1_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstraintExpr_Impl()
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
    return UmplePackage.eINSTANCE.getConstraintExpr_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NegativeConstraint_> getNegativeConstraint_1()
  {
    if (negativeConstraint_1 == null)
    {
      negativeConstraint_1 = new EObjectContainmentEList<NegativeConstraint_>(NegativeConstraint_.class, this, UmplePackage.CONSTRAINT_EXPR___NEGATIVE_CONSTRAINT_1);
    }
    return negativeConstraint_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StringExpr_> getStringExpr_1()
  {
    if (stringExpr_1 == null)
    {
      stringExpr_1 = new EObjectContainmentEList<StringExpr_>(StringExpr_.class, this, UmplePackage.CONSTRAINT_EXPR___STRING_EXPR_1);
    }
    return stringExpr_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<BoolExpr_> getBoolExpr_1()
  {
    if (boolExpr_1 == null)
    {
      boolExpr_1 = new EObjectContainmentEList<BoolExpr_>(BoolExpr_.class, this, UmplePackage.CONSTRAINT_EXPR___BOOL_EXPR_1);
    }
    return boolExpr_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GenExpr_> getGenExpr_1()
  {
    if (genExpr_1 == null)
    {
      genExpr_1 = new EObjectContainmentEList<GenExpr_>(GenExpr_.class, this, UmplePackage.CONSTRAINT_EXPR___GEN_EXPR_1);
    }
    return genExpr_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NumExpr_> getNumExpr_1()
  {
    if (numExpr_1 == null)
    {
      numExpr_1 = new EObjectContainmentEList<NumExpr_>(NumExpr_.class, this, UmplePackage.CONSTRAINT_EXPR___NUM_EXPR_1);
    }
    return numExpr_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLoneBoolean_1()
  {
    return loneBoolean_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLoneBoolean_1(String newLoneBoolean_1)
  {
    String oldLoneBoolean_1 = loneBoolean_1;
    loneBoolean_1 = newLoneBoolean_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.CONSTRAINT_EXPR___LONE_BOOLEAN_1, oldLoneBoolean_1, loneBoolean_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_constraintExpr_1_> getAnonymous_constraintExpr_1_1()
  {
    if (anonymous_constraintExpr_1_1 == null)
    {
      anonymous_constraintExpr_1_1 = new EObjectContainmentEList<Anonymous_constraintExpr_1_>(Anonymous_constraintExpr_1_.class, this, UmplePackage.CONSTRAINT_EXPR___ANONYMOUS_CONSTRAINT_EXPR_11);
    }
    return anonymous_constraintExpr_1_1;
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
      case UmplePackage.CONSTRAINT_EXPR___NEGATIVE_CONSTRAINT_1:
        return ((InternalEList<?>)getNegativeConstraint_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CONSTRAINT_EXPR___STRING_EXPR_1:
        return ((InternalEList<?>)getStringExpr_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CONSTRAINT_EXPR___BOOL_EXPR_1:
        return ((InternalEList<?>)getBoolExpr_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CONSTRAINT_EXPR___GEN_EXPR_1:
        return ((InternalEList<?>)getGenExpr_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CONSTRAINT_EXPR___NUM_EXPR_1:
        return ((InternalEList<?>)getNumExpr_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.CONSTRAINT_EXPR___ANONYMOUS_CONSTRAINT_EXPR_11:
        return ((InternalEList<?>)getAnonymous_constraintExpr_1_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.CONSTRAINT_EXPR___NEGATIVE_CONSTRAINT_1:
        return getNegativeConstraint_1();
      case UmplePackage.CONSTRAINT_EXPR___STRING_EXPR_1:
        return getStringExpr_1();
      case UmplePackage.CONSTRAINT_EXPR___BOOL_EXPR_1:
        return getBoolExpr_1();
      case UmplePackage.CONSTRAINT_EXPR___GEN_EXPR_1:
        return getGenExpr_1();
      case UmplePackage.CONSTRAINT_EXPR___NUM_EXPR_1:
        return getNumExpr_1();
      case UmplePackage.CONSTRAINT_EXPR___LONE_BOOLEAN_1:
        return getLoneBoolean_1();
      case UmplePackage.CONSTRAINT_EXPR___ANONYMOUS_CONSTRAINT_EXPR_11:
        return getAnonymous_constraintExpr_1_1();
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
      case UmplePackage.CONSTRAINT_EXPR___NEGATIVE_CONSTRAINT_1:
        getNegativeConstraint_1().clear();
        getNegativeConstraint_1().addAll((Collection<? extends NegativeConstraint_>)newValue);
        return;
      case UmplePackage.CONSTRAINT_EXPR___STRING_EXPR_1:
        getStringExpr_1().clear();
        getStringExpr_1().addAll((Collection<? extends StringExpr_>)newValue);
        return;
      case UmplePackage.CONSTRAINT_EXPR___BOOL_EXPR_1:
        getBoolExpr_1().clear();
        getBoolExpr_1().addAll((Collection<? extends BoolExpr_>)newValue);
        return;
      case UmplePackage.CONSTRAINT_EXPR___GEN_EXPR_1:
        getGenExpr_1().clear();
        getGenExpr_1().addAll((Collection<? extends GenExpr_>)newValue);
        return;
      case UmplePackage.CONSTRAINT_EXPR___NUM_EXPR_1:
        getNumExpr_1().clear();
        getNumExpr_1().addAll((Collection<? extends NumExpr_>)newValue);
        return;
      case UmplePackage.CONSTRAINT_EXPR___LONE_BOOLEAN_1:
        setLoneBoolean_1((String)newValue);
        return;
      case UmplePackage.CONSTRAINT_EXPR___ANONYMOUS_CONSTRAINT_EXPR_11:
        getAnonymous_constraintExpr_1_1().clear();
        getAnonymous_constraintExpr_1_1().addAll((Collection<? extends Anonymous_constraintExpr_1_>)newValue);
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
      case UmplePackage.CONSTRAINT_EXPR___NEGATIVE_CONSTRAINT_1:
        getNegativeConstraint_1().clear();
        return;
      case UmplePackage.CONSTRAINT_EXPR___STRING_EXPR_1:
        getStringExpr_1().clear();
        return;
      case UmplePackage.CONSTRAINT_EXPR___BOOL_EXPR_1:
        getBoolExpr_1().clear();
        return;
      case UmplePackage.CONSTRAINT_EXPR___GEN_EXPR_1:
        getGenExpr_1().clear();
        return;
      case UmplePackage.CONSTRAINT_EXPR___NUM_EXPR_1:
        getNumExpr_1().clear();
        return;
      case UmplePackage.CONSTRAINT_EXPR___LONE_BOOLEAN_1:
        setLoneBoolean_1(LONE_BOOLEAN_1_EDEFAULT);
        return;
      case UmplePackage.CONSTRAINT_EXPR___ANONYMOUS_CONSTRAINT_EXPR_11:
        getAnonymous_constraintExpr_1_1().clear();
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
      case UmplePackage.CONSTRAINT_EXPR___NEGATIVE_CONSTRAINT_1:
        return negativeConstraint_1 != null && !negativeConstraint_1.isEmpty();
      case UmplePackage.CONSTRAINT_EXPR___STRING_EXPR_1:
        return stringExpr_1 != null && !stringExpr_1.isEmpty();
      case UmplePackage.CONSTRAINT_EXPR___BOOL_EXPR_1:
        return boolExpr_1 != null && !boolExpr_1.isEmpty();
      case UmplePackage.CONSTRAINT_EXPR___GEN_EXPR_1:
        return genExpr_1 != null && !genExpr_1.isEmpty();
      case UmplePackage.CONSTRAINT_EXPR___NUM_EXPR_1:
        return numExpr_1 != null && !numExpr_1.isEmpty();
      case UmplePackage.CONSTRAINT_EXPR___LONE_BOOLEAN_1:
        return LONE_BOOLEAN_1_EDEFAULT == null ? loneBoolean_1 != null : !LONE_BOOLEAN_1_EDEFAULT.equals(loneBoolean_1);
      case UmplePackage.CONSTRAINT_EXPR___ANONYMOUS_CONSTRAINT_EXPR_11:
        return anonymous_constraintExpr_1_1 != null && !anonymous_constraintExpr_1_1.isEmpty();
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
    result.append(" (loneBoolean_1: ");
    result.append(loneBoolean_1);
    result.append(')');
    return result.toString();
  }

} //ConstraintExpr_Impl
