/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_traceType_1_;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous trace Type 1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Anonymous_traceType_1_Impl#getVerbisty_1 <em>Verbisty 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Anonymous_traceType_1_Impl extends MinimalEObjectImpl.Container implements Anonymous_traceType_1_
{
  /**
   * The default value of the '{@link #getVerbisty_1() <em>Verbisty 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerbisty_1()
   * @generated
   * @ordered
   */
  protected static final String VERBISTY_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVerbisty_1() <em>Verbisty 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerbisty_1()
   * @generated
   * @ordered
   */
  protected String verbisty_1 = VERBISTY_1_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Anonymous_traceType_1_Impl()
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
    return UmplePackage.eINSTANCE.getAnonymous_traceType_1_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVerbisty_1()
  {
    return verbisty_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVerbisty_1(String newVerbisty_1)
  {
    String oldVerbisty_1 = verbisty_1;
    verbisty_1 = newVerbisty_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ANONYMOUS_TRACE_TYPE_1__VERBISTY_1, oldVerbisty_1, verbisty_1));
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
      case UmplePackage.ANONYMOUS_TRACE_TYPE_1__VERBISTY_1:
        return getVerbisty_1();
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
      case UmplePackage.ANONYMOUS_TRACE_TYPE_1__VERBISTY_1:
        setVerbisty_1((String)newValue);
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
      case UmplePackage.ANONYMOUS_TRACE_TYPE_1__VERBISTY_1:
        setVerbisty_1(VERBISTY_1_EDEFAULT);
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
      case UmplePackage.ANONYMOUS_TRACE_TYPE_1__VERBISTY_1:
        return VERBISTY_1_EDEFAULT == null ? verbisty_1 != null : !VERBISTY_1_EDEFAULT.equals(verbisty_1);
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
    result.append(" (verbisty_1: ");
    result.append(verbisty_1);
    result.append(')');
    return result.toString();
  }

} //Anonymous_traceType_1_Impl
