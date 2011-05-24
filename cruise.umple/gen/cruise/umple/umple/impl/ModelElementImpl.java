/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ConditionRHS;
import cruise.umple.umple.ModelElement;
import cruise.umple.umple.UmpleAttribute;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

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
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#getAssoc <em>Assoc</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#getConditionRHS <em>Condition RHS</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#getStateM <em>State M</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#isStateEntry <em>State Entry</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#isStateExit <em>State Exit</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#getAMethods <em>AMethods</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ModelElementImpl#getAttributes <em>Attributes</em>}</li>
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
   * The default value of the '{@link #getAssoc() <em>Assoc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssoc()
   * @generated
   * @ordered
   */
  protected static final String ASSOC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAssoc() <em>Assoc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssoc()
   * @generated
   * @ordered
   */
  protected String assoc = ASSOC_EDEFAULT;

  /**
   * The cached value of the '{@link #getConditionRHS() <em>Condition RHS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionRHS()
   * @generated
   * @ordered
   */
  protected ConditionRHS conditionRHS;

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
   * The cached value of the '{@link #getStateM() <em>State M</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateM()
   * @generated
   * @ordered
   */
  protected EObject stateM;

  /**
   * The default value of the '{@link #isStateEntry() <em>State Entry</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStateEntry()
   * @generated
   * @ordered
   */
  protected static final boolean STATE_ENTRY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStateEntry() <em>State Entry</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStateEntry()
   * @generated
   * @ordered
   */
  protected boolean stateEntry = STATE_ENTRY_EDEFAULT;

  /**
   * The default value of the '{@link #isStateExit() <em>State Exit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStateExit()
   * @generated
   * @ordered
   */
  protected static final boolean STATE_EXIT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStateExit() <em>State Exit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStateExit()
   * @generated
   * @ordered
   */
  protected boolean stateExit = STATE_EXIT_EDEFAULT;

  /**
   * The cached value of the '{@link #getAMethods() <em>AMethods</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAMethods()
   * @generated
   * @ordered
   */
  protected EList<String> aMethods;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<UmpleAttribute> attributes;

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
  public String getAssoc()
  {
    return assoc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssoc(String newAssoc)
  {
    String oldAssoc = assoc;
    assoc = newAssoc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MODEL_ELEMENT__ASSOC, oldAssoc, assoc));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionRHS getConditionRHS()
  {
    return conditionRHS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditionRHS(ConditionRHS newConditionRHS, NotificationChain msgs)
  {
    ConditionRHS oldConditionRHS = conditionRHS;
    conditionRHS = newConditionRHS;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.MODEL_ELEMENT__CONDITION_RHS, oldConditionRHS, newConditionRHS);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConditionRHS(ConditionRHS newConditionRHS)
  {
    if (newConditionRHS != conditionRHS)
    {
      NotificationChain msgs = null;
      if (conditionRHS != null)
        msgs = ((InternalEObject)conditionRHS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.MODEL_ELEMENT__CONDITION_RHS, null, msgs);
      if (newConditionRHS != null)
        msgs = ((InternalEObject)newConditionRHS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.MODEL_ELEMENT__CONDITION_RHS, null, msgs);
      msgs = basicSetConditionRHS(newConditionRHS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MODEL_ELEMENT__CONDITION_RHS, newConditionRHS, newConditionRHS));
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
  public EObject getStateM()
  {
    if (stateM != null && stateM.eIsProxy())
    {
      InternalEObject oldStateM = (InternalEObject)stateM;
      stateM = eResolveProxy(oldStateM);
      if (stateM != oldStateM)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmplePackage.MODEL_ELEMENT__STATE_M, oldStateM, stateM));
      }
    }
    return stateM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetStateM()
  {
    return stateM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateM(EObject newStateM)
  {
    EObject oldStateM = stateM;
    stateM = newStateM;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MODEL_ELEMENT__STATE_M, oldStateM, stateM));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStateEntry()
  {
    return stateEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateEntry(boolean newStateEntry)
  {
    boolean oldStateEntry = stateEntry;
    stateEntry = newStateEntry;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MODEL_ELEMENT__STATE_ENTRY, oldStateEntry, stateEntry));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStateExit()
  {
    return stateExit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateExit(boolean newStateExit)
  {
    boolean oldStateExit = stateExit;
    stateExit = newStateExit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.MODEL_ELEMENT__STATE_EXIT, oldStateExit, stateExit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getAMethods()
  {
    if (aMethods == null)
    {
      aMethods = new EDataTypeEList<String>(String.class, this, UmplePackage.MODEL_ELEMENT__AMETHODS);
    }
    return aMethods;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UmpleAttribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectResolvingEList<UmpleAttribute>(UmpleAttribute.class, this, UmplePackage.MODEL_ELEMENT__ATTRIBUTES);
    }
    return attributes;
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
      case UmplePackage.MODEL_ELEMENT__CONDITION_RHS:
        return basicSetConditionRHS(null, msgs);
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
      case UmplePackage.MODEL_ELEMENT__EXECUTE_ON_ENTRY:
        return isExecuteOnEntry();
      case UmplePackage.MODEL_ELEMENT__EXECUTE_ON_EXIT:
        return isExecuteOnExit();
      case UmplePackage.MODEL_ELEMENT__CFLOW:
        return isCflow();
      case UmplePackage.MODEL_ELEMENT__AMETHOD:
        return getAMethod();
      case UmplePackage.MODEL_ELEMENT__ASSOC:
        return getAssoc();
      case UmplePackage.MODEL_ELEMENT__CONDITION_RHS:
        return getConditionRHS();
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTE:
        if (resolve) return getAttribute();
        return basicGetAttribute();
      case UmplePackage.MODEL_ELEMENT__STATE_M:
        if (resolve) return getStateM();
        return basicGetStateM();
      case UmplePackage.MODEL_ELEMENT__STATE_ENTRY:
        return isStateEntry();
      case UmplePackage.MODEL_ELEMENT__STATE_EXIT:
        return isStateExit();
      case UmplePackage.MODEL_ELEMENT__AMETHODS:
        return getAMethods();
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTES:
        return getAttributes();
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
      case UmplePackage.MODEL_ELEMENT__ASSOC:
        setAssoc((String)newValue);
        return;
      case UmplePackage.MODEL_ELEMENT__CONDITION_RHS:
        setConditionRHS((ConditionRHS)newValue);
        return;
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTE:
        setAttribute((UmpleAttribute)newValue);
        return;
      case UmplePackage.MODEL_ELEMENT__STATE_M:
        setStateM((EObject)newValue);
        return;
      case UmplePackage.MODEL_ELEMENT__STATE_ENTRY:
        setStateEntry((Boolean)newValue);
        return;
      case UmplePackage.MODEL_ELEMENT__STATE_EXIT:
        setStateExit((Boolean)newValue);
        return;
      case UmplePackage.MODEL_ELEMENT__AMETHODS:
        getAMethods().clear();
        getAMethods().addAll((Collection<? extends String>)newValue);
        return;
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends UmpleAttribute>)newValue);
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
      case UmplePackage.MODEL_ELEMENT__ASSOC:
        setAssoc(ASSOC_EDEFAULT);
        return;
      case UmplePackage.MODEL_ELEMENT__CONDITION_RHS:
        setConditionRHS((ConditionRHS)null);
        return;
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTE:
        setAttribute((UmpleAttribute)null);
        return;
      case UmplePackage.MODEL_ELEMENT__STATE_M:
        setStateM((EObject)null);
        return;
      case UmplePackage.MODEL_ELEMENT__STATE_ENTRY:
        setStateEntry(STATE_ENTRY_EDEFAULT);
        return;
      case UmplePackage.MODEL_ELEMENT__STATE_EXIT:
        setStateExit(STATE_EXIT_EDEFAULT);
        return;
      case UmplePackage.MODEL_ELEMENT__AMETHODS:
        getAMethods().clear();
        return;
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTES:
        getAttributes().clear();
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
      case UmplePackage.MODEL_ELEMENT__ASSOC:
        return ASSOC_EDEFAULT == null ? assoc != null : !ASSOC_EDEFAULT.equals(assoc);
      case UmplePackage.MODEL_ELEMENT__CONDITION_RHS:
        return conditionRHS != null;
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTE:
        return attribute != null;
      case UmplePackage.MODEL_ELEMENT__STATE_M:
        return stateM != null;
      case UmplePackage.MODEL_ELEMENT__STATE_ENTRY:
        return stateEntry != STATE_ENTRY_EDEFAULT;
      case UmplePackage.MODEL_ELEMENT__STATE_EXIT:
        return stateExit != STATE_EXIT_EDEFAULT;
      case UmplePackage.MODEL_ELEMENT__AMETHODS:
        return aMethods != null && !aMethods.isEmpty();
      case UmplePackage.MODEL_ELEMENT__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
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
    result.append(", assoc: ");
    result.append(assoc);
    result.append(", stateEntry: ");
    result.append(stateEntry);
    result.append(", stateExit: ");
    result.append(stateExit);
    result.append(", aMethods: ");
    result.append(aMethods);
    result.append(')');
    return result.toString();
  }

} //ModelElementImpl
