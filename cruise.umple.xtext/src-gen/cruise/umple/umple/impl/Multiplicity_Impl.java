/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Multiplicity_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Multiplicity_Impl#getBound_1 <em>Bound 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Multiplicity_Impl#getLowerBound_1 <em>Lower Bound 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Multiplicity_Impl#getUpperBound_1 <em>Upper Bound 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Multiplicity_Impl#getBound_int <em>Bound int</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Multiplicity_Impl extends MinimalEObjectImpl.Container implements Multiplicity_
{
  /**
   * The default value of the '{@link #getBound_1() <em>Bound 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBound_1()
   * @generated
   * @ordered
   */
  protected static final String BOUND_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBound_1() <em>Bound 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBound_1()
   * @generated
   * @ordered
   */
  protected String bound_1 = BOUND_1_EDEFAULT;

  /**
   * The default value of the '{@link #getLowerBound_1() <em>Lower Bound 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBound_1()
   * @generated
   * @ordered
   */
  protected static final String LOWER_BOUND_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLowerBound_1() <em>Lower Bound 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBound_1()
   * @generated
   * @ordered
   */
  protected String lowerBound_1 = LOWER_BOUND_1_EDEFAULT;

  /**
   * The default value of the '{@link #getUpperBound_1() <em>Upper Bound 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBound_1()
   * @generated
   * @ordered
   */
  protected static final String UPPER_BOUND_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUpperBound_1() <em>Upper Bound 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBound_1()
   * @generated
   * @ordered
   */
  protected String upperBound_1 = UPPER_BOUND_1_EDEFAULT;

  /**
   * The default value of the '{@link #getBound_int() <em>Bound int</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBound_int()
   * @generated
   * @ordered
   */
  protected static final int BOUND_INT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getBound_int() <em>Bound int</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBound_int()
   * @generated
   * @ordered
   */
  protected int bound_int = BOUND_INT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Multiplicity_Impl()
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
    return UmplePackage.eINSTANCE.getMultiplicity_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBound_1()
  {
    return bound_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBound_1(String newBound_1)
  {
    String oldBound_1 = bound_1;
    bound_1 = newBound_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MULTIPLICITY___BOUND_1, oldBound_1, bound_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLowerBound_1()
  {
    return lowerBound_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLowerBound_1(String newLowerBound_1)
  {
    String oldLowerBound_1 = lowerBound_1;
    lowerBound_1 = newLowerBound_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MULTIPLICITY___LOWER_BOUND_1, oldLowerBound_1, lowerBound_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUpperBound_1()
  {
    return upperBound_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpperBound_1(String newUpperBound_1)
  {
    String oldUpperBound_1 = upperBound_1;
    upperBound_1 = newUpperBound_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MULTIPLICITY___UPPER_BOUND_1, oldUpperBound_1, upperBound_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getBound_int()
  {
    return bound_int;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBound_int(int newBound_int)
  {
    int oldBound_int = bound_int;
    bound_int = newBound_int;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MULTIPLICITY___BOUND_INT, oldBound_int, bound_int));
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
      case UmplePackage.MULTIPLICITY___BOUND_1:
        return getBound_1();
      case UmplePackage.MULTIPLICITY___LOWER_BOUND_1:
        return getLowerBound_1();
      case UmplePackage.MULTIPLICITY___UPPER_BOUND_1:
        return getUpperBound_1();
      case UmplePackage.MULTIPLICITY___BOUND_INT:
        return getBound_int();
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
      case UmplePackage.MULTIPLICITY___BOUND_1:
        setBound_1((String)newValue);
        return;
      case UmplePackage.MULTIPLICITY___LOWER_BOUND_1:
        setLowerBound_1((String)newValue);
        return;
      case UmplePackage.MULTIPLICITY___UPPER_BOUND_1:
        setUpperBound_1((String)newValue);
        return;
      case UmplePackage.MULTIPLICITY___BOUND_INT:
        setBound_int((Integer)newValue);
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
      case UmplePackage.MULTIPLICITY___BOUND_1:
        setBound_1(BOUND_1_EDEFAULT);
        return;
      case UmplePackage.MULTIPLICITY___LOWER_BOUND_1:
        setLowerBound_1(LOWER_BOUND_1_EDEFAULT);
        return;
      case UmplePackage.MULTIPLICITY___UPPER_BOUND_1:
        setUpperBound_1(UPPER_BOUND_1_EDEFAULT);
        return;
      case UmplePackage.MULTIPLICITY___BOUND_INT:
        setBound_int(BOUND_INT_EDEFAULT);
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
      case UmplePackage.MULTIPLICITY___BOUND_1:
        return BOUND_1_EDEFAULT == null ? bound_1 != null : !BOUND_1_EDEFAULT.equals(bound_1);
      case UmplePackage.MULTIPLICITY___LOWER_BOUND_1:
        return LOWER_BOUND_1_EDEFAULT == null ? lowerBound_1 != null : !LOWER_BOUND_1_EDEFAULT.equals(lowerBound_1);
      case UmplePackage.MULTIPLICITY___UPPER_BOUND_1:
        return UPPER_BOUND_1_EDEFAULT == null ? upperBound_1 != null : !UPPER_BOUND_1_EDEFAULT.equals(upperBound_1);
      case UmplePackage.MULTIPLICITY___BOUND_INT:
        return bound_int != BOUND_INT_EDEFAULT;
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
    result.append(" (bound_1: ");
    result.append(bound_1);
    result.append(", lowerBound_1: ");
    result.append(lowerBound_1);
    result.append(", upperBound_1: ");
    result.append(upperBound_1);
    result.append(", bound_int: ");
    result.append(bound_int);
    result.append(')');
    return result.toString();
  }

} //Multiplicity_Impl
