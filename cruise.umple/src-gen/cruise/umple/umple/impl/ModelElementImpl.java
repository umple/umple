/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ModelElement;
import cruise.umple.umple.UmpleAttribute;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#isExecuteOnEntry <em>Execute On Entry</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#isExecuteOnExit <em>Execute On Exit</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#isCflow <em>Cflow</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#getAMethod <em>AMethod</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementImpl extends MinimalEObjectImpl.Container implements ModelElement
{
  /**
   * The default value of the '{@link #isExecuteOnEntry() <em>Execute On Entry</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExecuteOnEntry()
   * @generated
   * @ordered
   */
  protected static final boolean EXECUTE_ON_ENTRY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExecuteOnEntry() <em>Execute On Entry</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExecuteOnEntry()
   * @generated
   * @ordered
   */
  protected boolean executeOnEntry = EXECUTE_ON_ENTRY_EDEFAULT;

  /**
   * The default value of the '{@link #isExecuteOnExit() <em>Execute On Exit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExecuteOnExit()
   * @generated
   * @ordered
   */
  protected static final boolean EXECUTE_ON_EXIT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExecuteOnExit() <em>Execute On Exit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExecuteOnExit()
   * @generated
   * @ordered
   */
  protected boolean executeOnExit = EXECUTE_ON_EXIT_EDEFAULT;

  /**
   * The default value of the '{@link #isCflow() <em>Cflow</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCflow()
   * @generated
   * @ordered
   */
  protected static final boolean CFLOW_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCflow() <em>Cflow</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCflow()
   * @generated
   * @ordered
   */
  protected boolean cflow = CFLOW_EDEFAULT;

  /**
   * The default value of the '{@link #getAMethod() <em>AMethod</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAMethod()
   * @generated
   * @ordered
   */
  protected static final String AMETHOD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAMethod() <em>AMethod</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAMethod()
   * @generated
   * @ordered
   */
  protected String aMethod = AMETHOD_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttribute()
   * @generated
   * @ordered
   */
  protected UmpleAttribute attribute;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelElementImpl()
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
    return UmplePackage.Literals.MODEL_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isExecuteOnEntry()
  {
    return executeOnEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExecuteOnEntry(boolean newExecuteOnEntry)
  {
    boolean oldExecuteOnEntry = executeOnEntry;
    executeOnEntry = newExecuteOnEntry;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MODEL_ELEMENT__EXECUTE_ON_ENTRY, oldExecuteOnEntry, executeOnEntry));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isExecuteOnExit()
  {
    return executeOnExit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExecuteOnExit(boolean newExecuteOnExit)
  {
    boolean oldExecuteOnExit = executeOnExit;
    executeOnExit = newExecuteOnExit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MODEL_ELEMENT__EXECUTE_ON_EXIT, oldExecuteOnExit, executeOnExit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCflow()
  {
    return cflow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCflow(boolean newCflow)
  {
    boolean oldCflow = cflow;
    cflow = newCflow;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MODEL_ELEMENT__CFLOW, oldCflow, cflow));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAMethod()
  {
    return aMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAMethod(String newAMethod)
  {
    String oldAMethod = aMethod;
    aMethod = newAMethod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MODEL_ELEMENT__AMETHOD, oldAMethod, aMethod));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleAttribute getAttribute()
  {
    if (attribute != null && attribute.eIsProxy())
    {
      InternalEObject oldAttribute = (InternalEObject)attribute;
      attribute = (UmpleAttribute)eResolveProxy(oldAttribute);
      if (attribute != oldAttribute)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmplePackage.MODEL_ELEMENT__ATTRIBUTE, oldAttribute, attribute));
      }
    }
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleAttribute basicGetAttribute()
  {
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttribute(UmpleAttribute newAttribute)
  {
    UmpleAttribute oldAttribute = attribute;
    attribute = newAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MODEL_ELEMENT__ATTRIBUTE, oldAttribute, attribute));
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
      case UmplePackage.MODEL_ELEMENT__EXECUTE_ON_ENTRY:
        return isExecuteOnEntry();
      case UmplePackage.MODEL_ELEMENT__EXECUTE_ON_EXIT:
        return isExecuteOnExit();
      case UmplePackage.MODEL_ELEMENT__CFLOW:
        return isCflow();
      case UmplePackage.MODEL_ELEMENT__AMETHOD:
        return getAMethod();
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTE:
        if (resolve) return getAttribute();
        return basicGetAttribute();
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
      case UmplePackage.MODEL_ELEMENT__EXECUTE_ON_ENTRY:
        setExecuteOnEntry((Boolean)newValue);
        return;
      case UmplePackage.MODEL_ELEMENT__EXECUTE_ON_EXIT:
        setExecuteOnExit((Boolean)newValue);
        return;
      case UmplePackage.MODEL_ELEMENT__CFLOW:
        setCflow((Boolean)newValue);
        return;
      case UmplePackage.MODEL_ELEMENT__AMETHOD:
        setAMethod((String)newValue);
        return;
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTE:
        setAttribute((UmpleAttribute)newValue);
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
      case UmplePackage.MODEL_ELEMENT__EXECUTE_ON_ENTRY:
        setExecuteOnEntry(EXECUTE_ON_ENTRY_EDEFAULT);
        return;
      case UmplePackage.MODEL_ELEMENT__EXECUTE_ON_EXIT:
        setExecuteOnExit(EXECUTE_ON_EXIT_EDEFAULT);
        return;
      case UmplePackage.MODEL_ELEMENT__CFLOW:
        setCflow(CFLOW_EDEFAULT);
        return;
      case UmplePackage.MODEL_ELEMENT__AMETHOD:
        setAMethod(AMETHOD_EDEFAULT);
        return;
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTE:
        setAttribute((UmpleAttribute)null);
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
      case UmplePackage.MODEL_ELEMENT__EXECUTE_ON_ENTRY:
        return executeOnEntry != EXECUTE_ON_ENTRY_EDEFAULT;
      case UmplePackage.MODEL_ELEMENT__EXECUTE_ON_EXIT:
        return executeOnExit != EXECUTE_ON_EXIT_EDEFAULT;
      case UmplePackage.MODEL_ELEMENT__CFLOW:
        return cflow != CFLOW_EDEFAULT;
      case UmplePackage.MODEL_ELEMENT__AMETHOD:
        return AMETHOD_EDEFAULT == null ? aMethod != null : !AMETHOD_EDEFAULT.equals(aMethod);
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTE:
        return attribute != null;
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
    result.append(" (executeOnEntry: ");
    result.append(executeOnEntry);
    result.append(", executeOnExit: ");
    result.append(executeOnExit);
    result.append(", cflow: ");
    result.append(cflow);
    result.append(", aMethod: ");
    result.append(aMethod);
    result.append(')');
    return result.toString();
  }

} //ModelElementImpl
