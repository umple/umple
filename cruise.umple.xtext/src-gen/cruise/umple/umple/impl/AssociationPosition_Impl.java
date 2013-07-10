/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.AssociationPosition_;
import cruise.umple.umple.Coordinate_;
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
 * An implementation of the model object '<em><b>Association Position </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AssociationPosition_Impl#getName_1 <em>Name 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationPosition_Impl#getCoordinate_1 <em>Coordinate 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AssociationPosition_Impl#getCoordinate_2 <em>Coordinate 2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationPosition_Impl extends MinimalEObjectImpl.Container implements AssociationPosition_
{
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
   * The cached value of the '{@link #getCoordinate_1() <em>Coordinate 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCoordinate_1()
   * @generated
   * @ordered
   */
  protected EList<Coordinate_> coordinate_1;

  /**
   * The cached value of the '{@link #getCoordinate_2() <em>Coordinate 2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCoordinate_2()
   * @generated
   * @ordered
   */
  protected EList<Coordinate_> coordinate_2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssociationPosition_Impl()
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
    return UmplePackage.eINSTANCE.getAssociationPosition_();
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ASSOCIATION_POSITION___NAME_1, oldName_1, name_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Coordinate_> getCoordinate_1()
  {
    if (coordinate_1 == null)
    {
      coordinate_1 = new EObjectContainmentEList<Coordinate_>(Coordinate_.class, this, UmplePackage.ASSOCIATION_POSITION___COORDINATE_1);
    }
    return coordinate_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Coordinate_> getCoordinate_2()
  {
    if (coordinate_2 == null)
    {
      coordinate_2 = new EObjectContainmentEList<Coordinate_>(Coordinate_.class, this, UmplePackage.ASSOCIATION_POSITION___COORDINATE_2);
    }
    return coordinate_2;
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
      case UmplePackage.ASSOCIATION_POSITION___COORDINATE_1:
        return ((InternalEList<?>)getCoordinate_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.ASSOCIATION_POSITION___COORDINATE_2:
        return ((InternalEList<?>)getCoordinate_2()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.ASSOCIATION_POSITION___NAME_1:
        return getName_1();
      case UmplePackage.ASSOCIATION_POSITION___COORDINATE_1:
        return getCoordinate_1();
      case UmplePackage.ASSOCIATION_POSITION___COORDINATE_2:
        return getCoordinate_2();
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
      case UmplePackage.ASSOCIATION_POSITION___NAME_1:
        setName_1((String)newValue);
        return;
      case UmplePackage.ASSOCIATION_POSITION___COORDINATE_1:
        getCoordinate_1().clear();
        getCoordinate_1().addAll((Collection<? extends Coordinate_>)newValue);
        return;
      case UmplePackage.ASSOCIATION_POSITION___COORDINATE_2:
        getCoordinate_2().clear();
        getCoordinate_2().addAll((Collection<? extends Coordinate_>)newValue);
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
      case UmplePackage.ASSOCIATION_POSITION___NAME_1:
        setName_1(NAME_1_EDEFAULT);
        return;
      case UmplePackage.ASSOCIATION_POSITION___COORDINATE_1:
        getCoordinate_1().clear();
        return;
      case UmplePackage.ASSOCIATION_POSITION___COORDINATE_2:
        getCoordinate_2().clear();
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
      case UmplePackage.ASSOCIATION_POSITION___NAME_1:
        return NAME_1_EDEFAULT == null ? name_1 != null : !NAME_1_EDEFAULT.equals(name_1);
      case UmplePackage.ASSOCIATION_POSITION___COORDINATE_1:
        return coordinate_1 != null && !coordinate_1.isEmpty();
      case UmplePackage.ASSOCIATION_POSITION___COORDINATE_2:
        return coordinate_2 != null && !coordinate_2.isEmpty();
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
    result.append(" (name_1: ");
    result.append(name_1);
    result.append(')');
    return result.toString();
  }

} //AssociationPosition_Impl
