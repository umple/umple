/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AssociationPosition;
import cruise.umple.umple.Coordinate;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association Position</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AssociationPositionImpl#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationPositionImpl#getC1 <em>C1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationPositionImpl#getC2 <em>C2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationPositionImpl extends PositionImpl implements AssociationPosition
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getC1() <em>C1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getC1()
   * @generated
   * @ordered
   */
  protected Coordinate c1;

  /**
   * The cached value of the '{@link #getC2() <em>C2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getC2()
   * @generated
   * @ordered
   */
  protected Coordinate c2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssociationPositionImpl()
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
    return UmplePackage.Literals.ASSOCIATION_POSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ASSOCIATION_POSITION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Coordinate getC1()
  {
    return c1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetC1(Coordinate newC1, NotificationChain msgs)
  {
    Coordinate oldC1 = c1;
    c1 = newC1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.ASSOCIATION_POSITION__C1, oldC1, newC1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setC1(Coordinate newC1)
  {
    if (newC1 != c1)
    {
      NotificationChain msgs = null;
      if (c1 != null)
        msgs = ((InternalEObject)c1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.ASSOCIATION_POSITION__C1, null, msgs);
      if (newC1 != null)
        msgs = ((InternalEObject)newC1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.ASSOCIATION_POSITION__C1, null, msgs);
      msgs = basicSetC1(newC1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ASSOCIATION_POSITION__C1, newC1, newC1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Coordinate getC2()
  {
    return c2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetC2(Coordinate newC2, NotificationChain msgs)
  {
    Coordinate oldC2 = c2;
    c2 = newC2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.ASSOCIATION_POSITION__C2, oldC2, newC2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setC2(Coordinate newC2)
  {
    if (newC2 != c2)
    {
      NotificationChain msgs = null;
      if (c2 != null)
        msgs = ((InternalEObject)c2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.ASSOCIATION_POSITION__C2, null, msgs);
      if (newC2 != null)
        msgs = ((InternalEObject)newC2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.ASSOCIATION_POSITION__C2, null, msgs);
      msgs = basicSetC2(newC2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ASSOCIATION_POSITION__C2, newC2, newC2));
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
      case UmplePackage.ASSOCIATION_POSITION__C1:
        return basicSetC1(null, msgs);
      case UmplePackage.ASSOCIATION_POSITION__C2:
        return basicSetC2(null, msgs);
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
      case UmplePackage.ASSOCIATION_POSITION__NAME:
        return getName();
      case UmplePackage.ASSOCIATION_POSITION__C1:
        return getC1();
      case UmplePackage.ASSOCIATION_POSITION__C2:
        return getC2();
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
      case UmplePackage.ASSOCIATION_POSITION__NAME:
        setName((String)newValue);
        return;
      case UmplePackage.ASSOCIATION_POSITION__C1:
        setC1((Coordinate)newValue);
        return;
      case UmplePackage.ASSOCIATION_POSITION__C2:
        setC2((Coordinate)newValue);
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
      case UmplePackage.ASSOCIATION_POSITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UmplePackage.ASSOCIATION_POSITION__C1:
        setC1((Coordinate)null);
        return;
      case UmplePackage.ASSOCIATION_POSITION__C2:
        setC2((Coordinate)null);
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
      case UmplePackage.ASSOCIATION_POSITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UmplePackage.ASSOCIATION_POSITION__C1:
        return c1 != null;
      case UmplePackage.ASSOCIATION_POSITION__C2:
        return c2 != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //AssociationPositionImpl
