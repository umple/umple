/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.TraceMechanism;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Mechanism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceMechanismImpl#getTraceMechanism <em>Trace Mechanism</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceMechanismImpl extends MinimalEObjectImpl.Container implements TraceMechanism
{
  /**
   * The default value of the '{@link #getTraceMechanism() <em>Trace Mechanism</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceMechanism()
   * @generated
   * @ordered
   */
  protected static final String TRACE_MECHANISM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTraceMechanism() <em>Trace Mechanism</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceMechanism()
   * @generated
   * @ordered
   */
  protected String traceMechanism = TRACE_MECHANISM_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceMechanismImpl()
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
    return UmplePackage.Literals.TRACE_MECHANISM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTraceMechanism()
  {
    return traceMechanism;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTraceMechanism(String newTraceMechanism)
  {
    String oldTraceMechanism = traceMechanism;
    traceMechanism = newTraceMechanism;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_MECHANISM__TRACE_MECHANISM, oldTraceMechanism, traceMechanism));
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
      case UmplePackage.TRACE_MECHANISM__TRACE_MECHANISM:
        return getTraceMechanism();
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
      case UmplePackage.TRACE_MECHANISM__TRACE_MECHANISM:
        setTraceMechanism((String)newValue);
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
      case UmplePackage.TRACE_MECHANISM__TRACE_MECHANISM:
        setTraceMechanism(TRACE_MECHANISM_EDEFAULT);
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
      case UmplePackage.TRACE_MECHANISM__TRACE_MECHANISM:
        return TRACE_MECHANISM_EDEFAULT == null ? traceMechanism != null : !TRACE_MECHANISM_EDEFAULT.equals(traceMechanism);
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
    result.append(" (traceMechanism: ");
    result.append(traceMechanism);
    result.append(')');
    return result.toString();
  }

} //TraceMechanismImpl
