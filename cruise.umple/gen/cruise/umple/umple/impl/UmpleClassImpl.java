/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.CodeInjection;
import cruise.umple.umple.InlineAssociation;
import cruise.umple.umple.Key;
import cruise.umple.umple.Position;
import cruise.umple.umple.StateMachine;
import cruise.umple.umple.SymmetricReflexiveAssociation;
import cruise.umple.umple.TraceCase;
import cruise.umple.umple.TraceDirective;
import cruise.umple.umple.UmpleAttribute;
import cruise.umple.umple.UmpleClass;
import cruise.umple.umple.UmpleInterface;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#isExternal <em>External</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#isSingleton <em>Singleton</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getKey <em>Key</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getCodeInjection <em>Code Injection</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getExtendsClass <em>Extends Class</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getParentInterfaces <em>Parent Interfaces</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getSymmetricReflexiveAssociations <em>Symmetric Reflexive Associations</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getInlineAssociation <em>Inline Association</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getTraceDirective <em>Trace Directive</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleClassImpl#getTraceCase <em>Trace Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UmpleClassImpl extends UmpleElementImpl implements UmpleClass
{
  /**
   * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackageName()
   * @generated
   * @ordered
   */
  protected static final String PACKAGE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackageName()
   * @generated
   * @ordered
   */
  protected String packageName = PACKAGE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #isExternal() <em>External</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExternal()
   * @generated
   * @ordered
   */
  protected static final boolean EXTERNAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExternal() <em>External</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExternal()
   * @generated
   * @ordered
   */
  protected boolean external = EXTERNAL_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<UmpleAttribute> attributes;

  /**
   * The default value of the '{@link #isSingleton() <em>Singleton</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSingleton()
   * @generated
   * @ordered
   */
  protected static final boolean SINGLETON_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSingleton() <em>Singleton</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSingleton()
   * @generated
   * @ordered
   */
  protected boolean singleton = SINGLETON_EDEFAULT;

  /**
   * The cached value of the '{@link #getKey() <em>Key</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKey()
   * @generated
   * @ordered
   */
  protected Key key;

  /**
   * The cached value of the '{@link #getCodeInjection() <em>Code Injection</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodeInjection()
   * @generated
   * @ordered
   */
  protected CodeInjection codeInjection;

  /**
   * The cached value of the '{@link #getExtendsClass() <em>Extends Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendsClass()
   * @generated
   * @ordered
   */
  protected UmpleClass extendsClass;

  /**
   * The cached value of the '{@link #getParentInterfaces() <em>Parent Interfaces</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentInterfaces()
   * @generated
   * @ordered
   */
  protected EList<UmpleInterface> parentInterfaces;

  /**
   * The cached value of the '{@link #getSymmetricReflexiveAssociations() <em>Symmetric Reflexive Associations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymmetricReflexiveAssociations()
   * @generated
   * @ordered
   */
  protected EList<SymmetricReflexiveAssociation> symmetricReflexiveAssociations;

  /**
   * The cached value of the '{@link #getInlineAssociation() <em>Inline Association</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInlineAssociation()
   * @generated
   * @ordered
   */
  protected EList<InlineAssociation> inlineAssociation;

  /**
   * The cached value of the '{@link #getPosition() <em>Position</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPosition()
   * @generated
   * @ordered
   */
  protected EList<Position> position;

  /**
   * The cached value of the '{@link #getStateMachine() <em>State Machine</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateMachine()
   * @generated
   * @ordered
   */
  protected EList<StateMachine> stateMachine;

  /**
   * The cached value of the '{@link #getTraceDirective() <em>Trace Directive</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceDirective()
   * @generated
   * @ordered
   */
  protected EList<TraceDirective> traceDirective;

  /**
   * The cached value of the '{@link #getTraceCase() <em>Trace Case</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceCase()
   * @generated
   * @ordered
   */
  protected EList<TraceCase> traceCase;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UmpleClassImpl()
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
    return UmplePackage.Literals.UMPLE_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPackageName()
  {
    return packageName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackageName(String newPackageName)
  {
    String oldPackageName = packageName;
    packageName = newPackageName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_CLASS__PACKAGE_NAME, oldPackageName, packageName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isExternal()
  {
    return external;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExternal(boolean newExternal)
  {
    boolean oldExternal = external;
    external = newExternal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_CLASS__EXTERNAL, oldExternal, external));
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
      attributes = new EObjectContainmentEList<UmpleAttribute>(UmpleAttribute.class, this, UmplePackage.UMPLE_CLASS__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSingleton()
  {
    return singleton;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSingleton(boolean newSingleton)
  {
    boolean oldSingleton = singleton;
    singleton = newSingleton;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_CLASS__SINGLETON, oldSingleton, singleton));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Key getKey()
  {
    return key;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetKey(Key newKey, NotificationChain msgs)
  {
    Key oldKey = key;
    key = newKey;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_CLASS__KEY, oldKey, newKey);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKey(Key newKey)
  {
    if (newKey != key)
    {
      NotificationChain msgs = null;
      if (key != null)
        msgs = ((InternalEObject)key).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_CLASS__KEY, null, msgs);
      if (newKey != null)
        msgs = ((InternalEObject)newKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_CLASS__KEY, null, msgs);
      msgs = basicSetKey(newKey, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_CLASS__KEY, newKey, newKey));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CodeInjection getCodeInjection()
  {
    return codeInjection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCodeInjection(CodeInjection newCodeInjection, NotificationChain msgs)
  {
    CodeInjection oldCodeInjection = codeInjection;
    codeInjection = newCodeInjection;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_CLASS__CODE_INJECTION, oldCodeInjection, newCodeInjection);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCodeInjection(CodeInjection newCodeInjection)
  {
    if (newCodeInjection != codeInjection)
    {
      NotificationChain msgs = null;
      if (codeInjection != null)
        msgs = ((InternalEObject)codeInjection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_CLASS__CODE_INJECTION, null, msgs);
      if (newCodeInjection != null)
        msgs = ((InternalEObject)newCodeInjection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_CLASS__CODE_INJECTION, null, msgs);
      msgs = basicSetCodeInjection(newCodeInjection, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_CLASS__CODE_INJECTION, newCodeInjection, newCodeInjection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleClass getExtendsClass()
  {
    if (extendsClass != null && extendsClass.eIsProxy())
    {
      InternalEObject oldExtendsClass = (InternalEObject)extendsClass;
      extendsClass = (UmpleClass)eResolveProxy(oldExtendsClass);
      if (extendsClass != oldExtendsClass)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmplePackage.UMPLE_CLASS__EXTENDS_CLASS, oldExtendsClass, extendsClass));
      }
    }
    return extendsClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleClass basicGetExtendsClass()
  {
    return extendsClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtendsClass(UmpleClass newExtendsClass)
  {
    UmpleClass oldExtendsClass = extendsClass;
    extendsClass = newExtendsClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_CLASS__EXTENDS_CLASS, oldExtendsClass, extendsClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UmpleInterface> getParentInterfaces()
  {
    if (parentInterfaces == null)
    {
      parentInterfaces = new EObjectResolvingEList<UmpleInterface>(UmpleInterface.class, this, UmplePackage.UMPLE_CLASS__PARENT_INTERFACES);
    }
    return parentInterfaces;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SymmetricReflexiveAssociation> getSymmetricReflexiveAssociations()
  {
    if (symmetricReflexiveAssociations == null)
    {
      symmetricReflexiveAssociations = new EObjectContainmentEList<SymmetricReflexiveAssociation>(SymmetricReflexiveAssociation.class, this, UmplePackage.UMPLE_CLASS__SYMMETRIC_REFLEXIVE_ASSOCIATIONS);
    }
    return symmetricReflexiveAssociations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InlineAssociation> getInlineAssociation()
  {
    if (inlineAssociation == null)
    {
      inlineAssociation = new EObjectContainmentEList<InlineAssociation>(InlineAssociation.class, this, UmplePackage.UMPLE_CLASS__INLINE_ASSOCIATION);
    }
    return inlineAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Position> getPosition()
  {
    if (position == null)
    {
      position = new EObjectContainmentEList<Position>(Position.class, this, UmplePackage.UMPLE_CLASS__POSITION);
    }
    return position;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StateMachine> getStateMachine()
  {
    if (stateMachine == null)
    {
      stateMachine = new EObjectContainmentEList<StateMachine>(StateMachine.class, this, UmplePackage.UMPLE_CLASS__STATE_MACHINE);
    }
    return stateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceDirective> getTraceDirective()
  {
    if (traceDirective == null)
    {
      traceDirective = new EObjectContainmentEList<TraceDirective>(TraceDirective.class, this, UmplePackage.UMPLE_CLASS__TRACE_DIRECTIVE);
    }
    return traceDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceCase> getTraceCase()
  {
    if (traceCase == null)
    {
      traceCase = new EObjectContainmentEList<TraceCase>(TraceCase.class, this, UmplePackage.UMPLE_CLASS__TRACE_CASE);
    }
    return traceCase;
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
      case UmplePackage.UMPLE_CLASS__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case UmplePackage.UMPLE_CLASS__KEY:
        return basicSetKey(null, msgs);
      case UmplePackage.UMPLE_CLASS__CODE_INJECTION:
        return basicSetCodeInjection(null, msgs);
      case UmplePackage.UMPLE_CLASS__SYMMETRIC_REFLEXIVE_ASSOCIATIONS:
        return ((InternalEList<?>)getSymmetricReflexiveAssociations()).basicRemove(otherEnd, msgs);
      case UmplePackage.UMPLE_CLASS__INLINE_ASSOCIATION:
        return ((InternalEList<?>)getInlineAssociation()).basicRemove(otherEnd, msgs);
      case UmplePackage.UMPLE_CLASS__POSITION:
        return ((InternalEList<?>)getPosition()).basicRemove(otherEnd, msgs);
      case UmplePackage.UMPLE_CLASS__STATE_MACHINE:
        return ((InternalEList<?>)getStateMachine()).basicRemove(otherEnd, msgs);
      case UmplePackage.UMPLE_CLASS__TRACE_DIRECTIVE:
        return ((InternalEList<?>)getTraceDirective()).basicRemove(otherEnd, msgs);
      case UmplePackage.UMPLE_CLASS__TRACE_CASE:
        return ((InternalEList<?>)getTraceCase()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.UMPLE_CLASS__PACKAGE_NAME:
        return getPackageName();
      case UmplePackage.UMPLE_CLASS__EXTERNAL:
        return isExternal();
      case UmplePackage.UMPLE_CLASS__ATTRIBUTES:
        return getAttributes();
      case UmplePackage.UMPLE_CLASS__SINGLETON:
        return isSingleton();
      case UmplePackage.UMPLE_CLASS__KEY:
        return getKey();
      case UmplePackage.UMPLE_CLASS__CODE_INJECTION:
        return getCodeInjection();
      case UmplePackage.UMPLE_CLASS__EXTENDS_CLASS:
        if (resolve) return getExtendsClass();
        return basicGetExtendsClass();
      case UmplePackage.UMPLE_CLASS__PARENT_INTERFACES:
        return getParentInterfaces();
      case UmplePackage.UMPLE_CLASS__SYMMETRIC_REFLEXIVE_ASSOCIATIONS:
        return getSymmetricReflexiveAssociations();
      case UmplePackage.UMPLE_CLASS__INLINE_ASSOCIATION:
        return getInlineAssociation();
      case UmplePackage.UMPLE_CLASS__POSITION:
        return getPosition();
      case UmplePackage.UMPLE_CLASS__STATE_MACHINE:
        return getStateMachine();
      case UmplePackage.UMPLE_CLASS__TRACE_DIRECTIVE:
        return getTraceDirective();
      case UmplePackage.UMPLE_CLASS__TRACE_CASE:
        return getTraceCase();
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
      case UmplePackage.UMPLE_CLASS__PACKAGE_NAME:
        setPackageName((String)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__EXTERNAL:
        setExternal((Boolean)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends UmpleAttribute>)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__SINGLETON:
        setSingleton((Boolean)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__KEY:
        setKey((Key)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__CODE_INJECTION:
        setCodeInjection((CodeInjection)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__EXTENDS_CLASS:
        setExtendsClass((UmpleClass)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__PARENT_INTERFACES:
        getParentInterfaces().clear();
        getParentInterfaces().addAll((Collection<? extends UmpleInterface>)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__SYMMETRIC_REFLEXIVE_ASSOCIATIONS:
        getSymmetricReflexiveAssociations().clear();
        getSymmetricReflexiveAssociations().addAll((Collection<? extends SymmetricReflexiveAssociation>)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__INLINE_ASSOCIATION:
        getInlineAssociation().clear();
        getInlineAssociation().addAll((Collection<? extends InlineAssociation>)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__POSITION:
        getPosition().clear();
        getPosition().addAll((Collection<? extends Position>)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__STATE_MACHINE:
        getStateMachine().clear();
        getStateMachine().addAll((Collection<? extends StateMachine>)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__TRACE_DIRECTIVE:
        getTraceDirective().clear();
        getTraceDirective().addAll((Collection<? extends TraceDirective>)newValue);
        return;
      case UmplePackage.UMPLE_CLASS__TRACE_CASE:
        getTraceCase().clear();
        getTraceCase().addAll((Collection<? extends TraceCase>)newValue);
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
      case UmplePackage.UMPLE_CLASS__PACKAGE_NAME:
        setPackageName(PACKAGE_NAME_EDEFAULT);
        return;
      case UmplePackage.UMPLE_CLASS__EXTERNAL:
        setExternal(EXTERNAL_EDEFAULT);
        return;
      case UmplePackage.UMPLE_CLASS__ATTRIBUTES:
        getAttributes().clear();
        return;
      case UmplePackage.UMPLE_CLASS__SINGLETON:
        setSingleton(SINGLETON_EDEFAULT);
        return;
      case UmplePackage.UMPLE_CLASS__KEY:
        setKey((Key)null);
        return;
      case UmplePackage.UMPLE_CLASS__CODE_INJECTION:
        setCodeInjection((CodeInjection)null);
        return;
      case UmplePackage.UMPLE_CLASS__EXTENDS_CLASS:
        setExtendsClass((UmpleClass)null);
        return;
      case UmplePackage.UMPLE_CLASS__PARENT_INTERFACES:
        getParentInterfaces().clear();
        return;
      case UmplePackage.UMPLE_CLASS__SYMMETRIC_REFLEXIVE_ASSOCIATIONS:
        getSymmetricReflexiveAssociations().clear();
        return;
      case UmplePackage.UMPLE_CLASS__INLINE_ASSOCIATION:
        getInlineAssociation().clear();
        return;
      case UmplePackage.UMPLE_CLASS__POSITION:
        getPosition().clear();
        return;
      case UmplePackage.UMPLE_CLASS__STATE_MACHINE:
        getStateMachine().clear();
        return;
      case UmplePackage.UMPLE_CLASS__TRACE_DIRECTIVE:
        getTraceDirective().clear();
        return;
      case UmplePackage.UMPLE_CLASS__TRACE_CASE:
        getTraceCase().clear();
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
      case UmplePackage.UMPLE_CLASS__PACKAGE_NAME:
        return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
      case UmplePackage.UMPLE_CLASS__EXTERNAL:
        return external != EXTERNAL_EDEFAULT;
      case UmplePackage.UMPLE_CLASS__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case UmplePackage.UMPLE_CLASS__SINGLETON:
        return singleton != SINGLETON_EDEFAULT;
      case UmplePackage.UMPLE_CLASS__KEY:
        return key != null;
      case UmplePackage.UMPLE_CLASS__CODE_INJECTION:
        return codeInjection != null;
      case UmplePackage.UMPLE_CLASS__EXTENDS_CLASS:
        return extendsClass != null;
      case UmplePackage.UMPLE_CLASS__PARENT_INTERFACES:
        return parentInterfaces != null && !parentInterfaces.isEmpty();
      case UmplePackage.UMPLE_CLASS__SYMMETRIC_REFLEXIVE_ASSOCIATIONS:
        return symmetricReflexiveAssociations != null && !symmetricReflexiveAssociations.isEmpty();
      case UmplePackage.UMPLE_CLASS__INLINE_ASSOCIATION:
        return inlineAssociation != null && !inlineAssociation.isEmpty();
      case UmplePackage.UMPLE_CLASS__POSITION:
        return position != null && !position.isEmpty();
      case UmplePackage.UMPLE_CLASS__STATE_MACHINE:
        return stateMachine != null && !stateMachine.isEmpty();
      case UmplePackage.UMPLE_CLASS__TRACE_DIRECTIVE:
        return traceDirective != null && !traceDirective.isEmpty();
      case UmplePackage.UMPLE_CLASS__TRACE_CASE:
        return traceCase != null && !traceCase.isEmpty();
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
    result.append(" (packageName: ");
    result.append(packageName);
    result.append(", external: ");
    result.append(external);
    result.append(", singleton: ");
    result.append(singleton);
    result.append(')');
    return result.toString();
  }

} //UmpleClassImpl
