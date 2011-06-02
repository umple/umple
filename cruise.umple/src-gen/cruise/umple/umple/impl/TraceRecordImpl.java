/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.TraceRecord;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceRecordImpl#getObjectBeingTraced <em>Object Being Traced</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceRecordImpl#getTextOutput <em>Text Output</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceRecordImpl extends MinimalEObjectImpl.Container implements TraceRecord
{
  /**
   * The default value of the '{@link #getObjectBeingTraced() <em>Object Being Traced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectBeingTraced()
   * @generated
   * @ordered
   */
  protected static final String OBJECT_BEING_TRACED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getObjectBeingTraced() <em>Object Being Traced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectBeingTraced()
   * @generated
   * @ordered
   */
  protected String objectBeingTraced = OBJECT_BEING_TRACED_EDEFAULT;

  /**
   * The default value of the '{@link #getTextOutput() <em>Text Output</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTextOutput()
   * @generated
   * @ordered
   */
  protected static final String TEXT_OUTPUT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTextOutput() <em>Text Output</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTextOutput()
   * @generated
   * @ordered
   */
  protected String textOutput = TEXT_OUTPUT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceRecordImpl()
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
    return UmplePackage.Literals.TRACE_RECORD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getObjectBeingTraced()
  {
    return objectBeingTraced;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObjectBeingTraced(String newObjectBeingTraced)
  {
    String oldObjectBeingTraced = objectBeingTraced;
    objectBeingTraced = newObjectBeingTraced;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_RECORD__OBJECT_BEING_TRACED, oldObjectBeingTraced, objectBeingTraced));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTextOutput()
  {
    return textOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTextOutput(String newTextOutput)
  {
    String oldTextOutput = textOutput;
    textOutput = newTextOutput;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_RECORD__TEXT_OUTPUT, oldTextOutput, textOutput));
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
      case UmplePackage.TRACE_RECORD__OBJECT_BEING_TRACED:
        return getObjectBeingTraced();
      case UmplePackage.TRACE_RECORD__TEXT_OUTPUT:
        return getTextOutput();
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
      case UmplePackage.TRACE_RECORD__OBJECT_BEING_TRACED:
        setObjectBeingTraced((String)newValue);
        return;
      case UmplePackage.TRACE_RECORD__TEXT_OUTPUT:
        setTextOutput((String)newValue);
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
      case UmplePackage.TRACE_RECORD__OBJECT_BEING_TRACED:
        setObjectBeingTraced(OBJECT_BEING_TRACED_EDEFAULT);
        return;
      case UmplePackage.TRACE_RECORD__TEXT_OUTPUT:
        setTextOutput(TEXT_OUTPUT_EDEFAULT);
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
      case UmplePackage.TRACE_RECORD__OBJECT_BEING_TRACED:
        return OBJECT_BEING_TRACED_EDEFAULT == null ? objectBeingTraced != null : !OBJECT_BEING_TRACED_EDEFAULT.equals(objectBeingTraced);
      case UmplePackage.TRACE_RECORD__TEXT_OUTPUT:
        return TEXT_OUTPUT_EDEFAULT == null ? textOutput != null : !TEXT_OUTPUT_EDEFAULT.equals(textOutput);
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
    result.append(" (objectBeingTraced: ");
    result.append(objectBeingTraced);
    result.append(", textOutput: ");
    result.append(textOutput);
    result.append(')');
    return result.toString();
  }

} //TraceRecordImpl
