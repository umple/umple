/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Coordinate_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Coordinate </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Coordinate_Impl#getX_1 <em>X1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Coordinate_Impl#getY_1 <em>Y1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Coordinate_Impl extends MinimalEObjectImpl.Container implements Coordinate_
{
  /**
   * The default value of the '{@link #getX_1() <em>X1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX_1()
   * @generated
   * @ordered
   */
  protected static final String X1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getX_1() <em>X1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX_1()
   * @generated
   * @ordered
   */
  protected String x_1 = X1_EDEFAULT;

  /**
   * The default value of the '{@link #getY_1() <em>Y1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY_1()
   * @generated
   * @ordered
   */
  protected static final String Y1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getY_1() <em>Y1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY_1()
   * @generated
   * @ordered
   */
  protected String y_1 = Y1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Coordinate_Impl()
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
    return UmplePackage.eINSTANCE.getCoordinate_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getX_1()
  {
    return x_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX_1(String newX_1)
  {
    String oldX_1 = x_1;
    x_1 = newX_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.COORDINATE___X1, oldX_1, x_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getY_1()
  {
    return y_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setY_1(String newY_1)
  {
    String oldY_1 = y_1;
    y_1 = newY_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.COORDINATE___Y1, oldY_1, y_1));
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
      case UmplePackage.COORDINATE___X1:
        return getX_1();
      case UmplePackage.COORDINATE___Y1:
        return getY_1();
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
      case UmplePackage.COORDINATE___X1:
        setX_1((String)newValue);
        return;
      case UmplePackage.COORDINATE___Y1:
        setY_1((String)newValue);
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
      case UmplePackage.COORDINATE___X1:
        setX_1(X1_EDEFAULT);
        return;
      case UmplePackage.COORDINATE___Y1:
        setY_1(Y1_EDEFAULT);
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
      case UmplePackage.COORDINATE___X1:
        return X1_EDEFAULT == null ? x_1 != null : !X1_EDEFAULT.equals(x_1);
      case UmplePackage.COORDINATE___Y1:
        return Y1_EDEFAULT == null ? y_1 != null : !Y1_EDEFAULT.equals(y_1);
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
    result.append(" (x_1: ");
    result.append(x_1);
    result.append(", y_1: ");
    result.append(y_1);
    result.append(')');
    return result.toString();
  }

} //Coordinate_Impl
