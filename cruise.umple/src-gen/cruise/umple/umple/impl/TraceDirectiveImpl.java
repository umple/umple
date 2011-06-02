/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.ConditionRHS;
import cruise.umple.umple.ModelElement;
import cruise.umple.umple.TraceDirective;
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
 * An implementation of the model object '<em><b>Trace Directive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getTraceStart <em>Trace Start</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getConditionRHS <em>Condition RHS</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.TraceDirectiveImpl#getElementPattern <em>Element Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceDirectiveImpl extends MinimalEObjectImpl.Container implements TraceDirective
{
  /**
   * The default value of the '{@link #getTraceStart() <em>Trace Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceStart()
   * @generated
   * @ordered
   */
  protected static final String TRACE_START_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTraceStart() <em>Trace Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceStart()
   * @generated
   * @ordered
   */
  protected String traceStart = TRACE_START_EDEFAULT;

  /**
   * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelElement()
   * @generated
   * @ordered
   */
  protected EList<ModelElement> modelElement;

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
   * The default value of the '{@link #getElementPattern() <em>Element Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementPattern()
   * @generated
   * @ordered
   */
  protected static final String ELEMENT_PATTERN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getElementPattern() <em>Element Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementPattern()
   * @generated
   * @ordered
   */
  protected String elementPattern = ELEMENT_PATTERN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TraceDirectiveImpl()
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
    return UmplePackage.Literals.TRACE_DIRECTIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTraceStart()
  {
    return traceStart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTraceStart(String newTraceStart)
  {
    String oldTraceStart = traceStart;
    traceStart = newTraceStart;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__TRACE_START, oldTraceStart, traceStart));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ModelElement> getModelElement()
  {
    if (modelElement == null)
    {
      modelElement = new EObjectContainmentEList<ModelElement>(ModelElement.class, this, UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT);
    }
    return modelElement;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS, oldConditionRHS, newConditionRHS);
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
        msgs = ((InternalEObject)conditionRHS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS, null, msgs);
      if (newConditionRHS != null)
        msgs = ((InternalEObject)newConditionRHS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS, null, msgs);
      msgs = basicSetConditionRHS(newConditionRHS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS, newConditionRHS, newConditionRHS));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getElementPattern()
  {
    return elementPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElementPattern(String newElementPattern)
  {
    String oldElementPattern = elementPattern;
    elementPattern = newElementPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRACE_DIRECTIVE__ELEMENT_PATTERN, oldElementPattern, elementPattern));
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
      case UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT:
        return ((InternalEList<?>)getModelElement()).basicRemove(otherEnd, msgs);
      case UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS:
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
      case UmplePackage.TRACE_DIRECTIVE__TRACE_START:
        return getTraceStart();
      case UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT:
        return getModelElement();
      case UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS:
        return getConditionRHS();
      case UmplePackage.TRACE_DIRECTIVE__ELEMENT_PATTERN:
        return getElementPattern();
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
      case UmplePackage.TRACE_DIRECTIVE__TRACE_START:
        setTraceStart((String)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT:
        getModelElement().clear();
        getModelElement().addAll((Collection<? extends ModelElement>)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS:
        setConditionRHS((ConditionRHS)newValue);
        return;
      case UmplePackage.TRACE_DIRECTIVE__ELEMENT_PATTERN:
        setElementPattern((String)newValue);
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
      case UmplePackage.TRACE_DIRECTIVE__TRACE_START:
        setTraceStart(TRACE_START_EDEFAULT);
        return;
      case UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT:
        getModelElement().clear();
        return;
      case UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS:
        setConditionRHS((ConditionRHS)null);
        return;
      case UmplePackage.TRACE_DIRECTIVE__ELEMENT_PATTERN:
        setElementPattern(ELEMENT_PATTERN_EDEFAULT);
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
      case UmplePackage.TRACE_DIRECTIVE__TRACE_START:
        return TRACE_START_EDEFAULT == null ? traceStart != null : !TRACE_START_EDEFAULT.equals(traceStart);
      case UmplePackage.TRACE_DIRECTIVE__MODEL_ELEMENT:
        return modelElement != null && !modelElement.isEmpty();
      case UmplePackage.TRACE_DIRECTIVE__CONDITION_RHS:
        return conditionRHS != null;
      case UmplePackage.TRACE_DIRECTIVE__ELEMENT_PATTERN:
        return ELEMENT_PATTERN_EDEFAULT == null ? elementPattern != null : !ELEMENT_PATTERN_EDEFAULT.equals(elementPattern);
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
    result.append(" (traceStart: ");
    result.append(traceStart);
    result.append(", elementPattern: ");
    result.append(elementPattern);
    result.append(')');
    return result.toString();
  }

} //TraceDirectiveImpl
