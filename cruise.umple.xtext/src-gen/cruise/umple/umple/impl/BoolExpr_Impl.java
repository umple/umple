/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.BoolExpr_;
import cruise.umple.umple.EqualityOp_;
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
 * An implementation of the model object '<em><b>Bool Expr </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.BoolExpr_Impl#getLiteral_1 <em>Literal 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.BoolExpr_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.BoolExpr_Impl#getEqualityOp_1 <em>Equality Op 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.BoolExpr_Impl#getIndex_1 <em>Index 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoolExpr_Impl extends MinimalEObjectImpl.Container implements BoolExpr_
{
  /**
   * The default value of the '{@link #getLiteral_1() <em>Literal 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLiteral_1()
   * @generated
   * @ordered
   */
  protected static final String LITERAL_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLiteral_1() <em>Literal 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLiteral_1()
   * @generated
   * @ordered
   */
  protected String literal_1 = LITERAL_1_EDEFAULT;

  /**
   * The default value of the '{@link #getName_1() <em>Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName_1()
   * @generated
   * @ordered
   */
  protected static final String NAME_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName_1() <em>Name 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName_1()
   * @generated
   * @ordered
   */
  protected String name_1 = NAME_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getEqualityOp_1() <em>Equality Op 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEqualityOp_1()
   * @generated
   * @ordered
   */
  protected EList<EqualityOp_> equalityOp_1;

  /**
   * The default value of the '{@link #getIndex_1() <em>Index 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex_1()
   * @generated
   * @ordered
   */
  protected static final String INDEX_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIndex_1() <em>Index 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex_1()
   * @generated
   * @ordered
   */
  protected String index_1 = INDEX_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BoolExpr_Impl()
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
    return UmplePackage.eINSTANCE.getBoolExpr_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral_1()
  {
    return literal_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLiteral_1(String newLiteral_1)
  {
    String oldLiteral_1 = literal_1;
    literal_1 = newLiteral_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.BOOL_EXPR___LITERAL_1, oldLiteral_1, literal_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName_1()
  {
    return name_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName_1(String newName_1)
  {
    String oldName_1 = name_1;
    name_1 = newName_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.BOOL_EXPR___NAME_1, oldName_1, name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EqualityOp_> getEqualityOp_1()
  {
    if (equalityOp_1 == null)
    {
      equalityOp_1 = new EObjectContainmentEList<EqualityOp_>(EqualityOp_.class, this, UmplePackage.BOOL_EXPR___EQUALITY_OP_1);
    }
    return equalityOp_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIndex_1()
  {
    return index_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndex_1(String newIndex_1)
  {
    String oldIndex_1 = index_1;
    index_1 = newIndex_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.BOOL_EXPR___INDEX_1, oldIndex_1, index_1));
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
      case UmplePackage.BOOL_EXPR___EQUALITY_OP_1:
        return ((InternalEList<?>)getEqualityOp_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.BOOL_EXPR___LITERAL_1:
        return getLiteral_1();
      case UmplePackage.BOOL_EXPR___NAME_1:
        return getName_1();
      case UmplePackage.BOOL_EXPR___EQUALITY_OP_1:
        return getEqualityOp_1();
      case UmplePackage.BOOL_EXPR___INDEX_1:
        return getIndex_1();
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
      case UmplePackage.BOOL_EXPR___LITERAL_1:
        setLiteral_1((String)newValue);
        return;
      case UmplePackage.BOOL_EXPR___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.BOOL_EXPR___EQUALITY_OP_1:
        getEqualityOp_1().clear();
        getEqualityOp_1().addAll((Collection<? extends EqualityOp_>)newValue);
        return;
      case UmplePackage.BOOL_EXPR___INDEX_1:
        setIndex_1((String)newValue);
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
      case UmplePackage.BOOL_EXPR___LITERAL_1:
        setLiteral_1(LITERAL_1_EDEFAULT);
        return;
      case UmplePackage.BOOL_EXPR___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.BOOL_EXPR___EQUALITY_OP_1:
        getEqualityOp_1().clear();
        return;
      case UmplePackage.BOOL_EXPR___INDEX_1:
        setIndex_1(INDEX_1_EDEFAULT);
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
      case UmplePackage.BOOL_EXPR___LITERAL_1:
        return LITERAL_1_EDEFAULT == null ? literal_1 != null : !LITERAL_1_EDEFAULT.equals(literal_1);
      case UmplePackage.BOOL_EXPR___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.BOOL_EXPR___EQUALITY_OP_1:
        return equalityOp_1 != null && !equalityOp_1.isEmpty();
      case UmplePackage.BOOL_EXPR___INDEX_1:
        return INDEX_1_EDEFAULT == null ? index_1 != null : !INDEX_1_EDEFAULT.equals(index_1);
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
    result.append(" (literal_1: ");
    result.append(literal_1);
    result.append(", name_1: ");
    result.append(name_1);
    result.append(", index_1: ");
    result.append(index_1);
    result.append(')');
    return result.toString();
  }

} //BoolExpr_Impl
