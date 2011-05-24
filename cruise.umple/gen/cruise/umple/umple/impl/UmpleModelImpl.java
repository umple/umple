/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Glossary;
import cruise.umple.umple.Namespace;
import cruise.umple.umple.StateMachineDefinition;
import cruise.umple.umple.TraceMechanism;
import cruise.umple.umple.UmpleAssociation;
import cruise.umple.umple.UmpleAssociationClass;
import cruise.umple.umple.UmpleElement;
import cruise.umple.umple.UmpleModel;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.UmpleModelImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleModelImpl#getGlossary <em>Glossary</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleModelImpl#getGenerate_ <em>Generate </em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleModelImpl#getTraceMechanism <em>Trace Mechanism</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleModelImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleModelImpl#getUmpleElements <em>Umple Elements</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleModelImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleModelImpl#getAssociationClasses <em>Association Classes</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleModelImpl#getStatemachines <em>Statemachines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UmpleModelImpl extends MinimalEObjectImpl.Container implements UmpleModel
{
  /**
   * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamespace()
   * @generated
   * @ordered
   */
  protected Namespace namespace;

  /**
   * The cached value of the '{@link #getGlossary() <em>Glossary</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlossary()
   * @generated
   * @ordered
   */
  protected Glossary glossary;

  /**
   * The default value of the '{@link #getGenerate_() <em>Generate </em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerate_()
   * @generated
   * @ordered
   */
  protected static final String GENERATE__EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGenerate_() <em>Generate </em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerate_()
   * @generated
   * @ordered
   */
  protected String generate_ = GENERATE__EDEFAULT;

  /**
   * The cached value of the '{@link #getTraceMechanism() <em>Trace Mechanism</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceMechanism()
   * @generated
   * @ordered
   */
  protected TraceMechanism traceMechanism;

  /**
   * The cached value of the '{@link #getUses() <em>Uses</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUses()
   * @generated
   * @ordered
   */
  protected EList<String> uses;

  /**
   * The cached value of the '{@link #getUmpleElements() <em>Umple Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUmpleElements()
   * @generated
   * @ordered
   */
  protected EList<UmpleElement> umpleElements;

  /**
   * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociations()
   * @generated
   * @ordered
   */
  protected EList<UmpleAssociation> associations;

  /**
   * The cached value of the '{@link #getAssociationClasses() <em>Association Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationClasses()
   * @generated
   * @ordered
   */
  protected EList<UmpleAssociationClass> associationClasses;

  /**
   * The cached value of the '{@link #getStatemachines() <em>Statemachines</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatemachines()
   * @generated
   * @ordered
   */
  protected EList<StateMachineDefinition> statemachines;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UmpleModelImpl()
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
    return UmplePackage.Literals.UMPLE_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Namespace getNamespace()
  {
    return namespace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNamespace(Namespace newNamespace, NotificationChain msgs)
  {
    Namespace oldNamespace = namespace;
    namespace = newNamespace;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_MODEL__NAMESPACE, oldNamespace, newNamespace);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNamespace(Namespace newNamespace)
  {
    if (newNamespace != namespace)
    {
      NotificationChain msgs = null;
      if (namespace != null)
        msgs = ((InternalEObject)namespace).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_MODEL__NAMESPACE, null, msgs);
      if (newNamespace != null)
        msgs = ((InternalEObject)newNamespace).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_MODEL__NAMESPACE, null, msgs);
      msgs = basicSetNamespace(newNamespace, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_MODEL__NAMESPACE, newNamespace, newNamespace));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Glossary getGlossary()
  {
    return glossary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGlossary(Glossary newGlossary, NotificationChain msgs)
  {
    Glossary oldGlossary = glossary;
    glossary = newGlossary;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_MODEL__GLOSSARY, oldGlossary, newGlossary);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGlossary(Glossary newGlossary)
  {
    if (newGlossary != glossary)
    {
      NotificationChain msgs = null;
      if (glossary != null)
        msgs = ((InternalEObject)glossary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_MODEL__GLOSSARY, null, msgs);
      if (newGlossary != null)
        msgs = ((InternalEObject)newGlossary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_MODEL__GLOSSARY, null, msgs);
      msgs = basicSetGlossary(newGlossary, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_MODEL__GLOSSARY, newGlossary, newGlossary));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGenerate_()
  {
    return generate_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGenerate_(String newGenerate_)
  {
    String oldGenerate_ = generate_;
    generate_ = newGenerate_;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_MODEL__GENERATE_, oldGenerate_, generate_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceMechanism getTraceMechanism()
  {
    return traceMechanism;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTraceMechanism(TraceMechanism newTraceMechanism, NotificationChain msgs)
  {
    TraceMechanism oldTraceMechanism = traceMechanism;
    traceMechanism = newTraceMechanism;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_MODEL__TRACE_MECHANISM, oldTraceMechanism, newTraceMechanism);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTraceMechanism(TraceMechanism newTraceMechanism)
  {
    if (newTraceMechanism != traceMechanism)
    {
      NotificationChain msgs = null;
      if (traceMechanism != null)
        msgs = ((InternalEObject)traceMechanism).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_MODEL__TRACE_MECHANISM, null, msgs);
      if (newTraceMechanism != null)
        msgs = ((InternalEObject)newTraceMechanism).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.UMPLE_MODEL__TRACE_MECHANISM, null, msgs);
      msgs = basicSetTraceMechanism(newTraceMechanism, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_MODEL__TRACE_MECHANISM, newTraceMechanism, newTraceMechanism));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getUses()
  {
    if (uses == null)
    {
      uses = new EDataTypeEList<String>(String.class, this, UmplePackage.UMPLE_MODEL__USES);
    }
    return uses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UmpleElement> getUmpleElements()
  {
    if (umpleElements == null)
    {
      umpleElements = new EObjectContainmentEList<UmpleElement>(UmpleElement.class, this, UmplePackage.UMPLE_MODEL__UMPLE_ELEMENTS);
    }
    return umpleElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UmpleAssociation> getAssociations()
  {
    if (associations == null)
    {
      associations = new EObjectContainmentEList<UmpleAssociation>(UmpleAssociation.class, this, UmplePackage.UMPLE_MODEL__ASSOCIATIONS);
    }
    return associations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UmpleAssociationClass> getAssociationClasses()
  {
    if (associationClasses == null)
    {
      associationClasses = new EObjectContainmentEList<UmpleAssociationClass>(UmpleAssociationClass.class, this, UmplePackage.UMPLE_MODEL__ASSOCIATION_CLASSES);
    }
    return associationClasses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StateMachineDefinition> getStatemachines()
  {
    if (statemachines == null)
    {
      statemachines = new EObjectContainmentEList<StateMachineDefinition>(StateMachineDefinition.class, this, UmplePackage.UMPLE_MODEL__STATEMACHINES);
    }
    return statemachines;
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
      case UmplePackage.UMPLE_MODEL__NAMESPACE:
        return basicSetNamespace(null, msgs);
      case UmplePackage.UMPLE_MODEL__GLOSSARY:
        return basicSetGlossary(null, msgs);
      case UmplePackage.UMPLE_MODEL__TRACE_MECHANISM:
        return basicSetTraceMechanism(null, msgs);
      case UmplePackage.UMPLE_MODEL__UMPLE_ELEMENTS:
        return ((InternalEList<?>)getUmpleElements()).basicRemove(otherEnd, msgs);
      case UmplePackage.UMPLE_MODEL__ASSOCIATIONS:
        return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
      case UmplePackage.UMPLE_MODEL__ASSOCIATION_CLASSES:
        return ((InternalEList<?>)getAssociationClasses()).basicRemove(otherEnd, msgs);
      case UmplePackage.UMPLE_MODEL__STATEMACHINES:
        return ((InternalEList<?>)getStatemachines()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.UMPLE_MODEL__NAMESPACE:
        return getNamespace();
      case UmplePackage.UMPLE_MODEL__GLOSSARY:
        return getGlossary();
      case UmplePackage.UMPLE_MODEL__GENERATE_:
        return getGenerate_();
      case UmplePackage.UMPLE_MODEL__TRACE_MECHANISM:
        return getTraceMechanism();
      case UmplePackage.UMPLE_MODEL__USES:
        return getUses();
      case UmplePackage.UMPLE_MODEL__UMPLE_ELEMENTS:
        return getUmpleElements();
      case UmplePackage.UMPLE_MODEL__ASSOCIATIONS:
        return getAssociations();
      case UmplePackage.UMPLE_MODEL__ASSOCIATION_CLASSES:
        return getAssociationClasses();
      case UmplePackage.UMPLE_MODEL__STATEMACHINES:
        return getStatemachines();
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
      case UmplePackage.UMPLE_MODEL__NAMESPACE:
        setNamespace((Namespace)newValue);
        return;
      case UmplePackage.UMPLE_MODEL__GLOSSARY:
        setGlossary((Glossary)newValue);
        return;
      case UmplePackage.UMPLE_MODEL__GENERATE_:
        setGenerate_((String)newValue);
        return;
      case UmplePackage.UMPLE_MODEL__TRACE_MECHANISM:
        setTraceMechanism((TraceMechanism)newValue);
        return;
      case UmplePackage.UMPLE_MODEL__USES:
        getUses().clear();
        getUses().addAll((Collection<? extends String>)newValue);
        return;
      case UmplePackage.UMPLE_MODEL__UMPLE_ELEMENTS:
        getUmpleElements().clear();
        getUmpleElements().addAll((Collection<? extends UmpleElement>)newValue);
        return;
      case UmplePackage.UMPLE_MODEL__ASSOCIATIONS:
        getAssociations().clear();
        getAssociations().addAll((Collection<? extends UmpleAssociation>)newValue);
        return;
      case UmplePackage.UMPLE_MODEL__ASSOCIATION_CLASSES:
        getAssociationClasses().clear();
        getAssociationClasses().addAll((Collection<? extends UmpleAssociationClass>)newValue);
        return;
      case UmplePackage.UMPLE_MODEL__STATEMACHINES:
        getStatemachines().clear();
        getStatemachines().addAll((Collection<? extends StateMachineDefinition>)newValue);
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
      case UmplePackage.UMPLE_MODEL__NAMESPACE:
        setNamespace((Namespace)null);
        return;
      case UmplePackage.UMPLE_MODEL__GLOSSARY:
        setGlossary((Glossary)null);
        return;
      case UmplePackage.UMPLE_MODEL__GENERATE_:
        setGenerate_(GENERATE__EDEFAULT);
        return;
      case UmplePackage.UMPLE_MODEL__TRACE_MECHANISM:
        setTraceMechanism((TraceMechanism)null);
        return;
      case UmplePackage.UMPLE_MODEL__USES:
        getUses().clear();
        return;
      case UmplePackage.UMPLE_MODEL__UMPLE_ELEMENTS:
        getUmpleElements().clear();
        return;
      case UmplePackage.UMPLE_MODEL__ASSOCIATIONS:
        getAssociations().clear();
        return;
      case UmplePackage.UMPLE_MODEL__ASSOCIATION_CLASSES:
        getAssociationClasses().clear();
        return;
      case UmplePackage.UMPLE_MODEL__STATEMACHINES:
        getStatemachines().clear();
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
      case UmplePackage.UMPLE_MODEL__NAMESPACE:
        return namespace != null;
      case UmplePackage.UMPLE_MODEL__GLOSSARY:
        return glossary != null;
      case UmplePackage.UMPLE_MODEL__GENERATE_:
        return GENERATE__EDEFAULT == null ? generate_ != null : !GENERATE__EDEFAULT.equals(generate_);
      case UmplePackage.UMPLE_MODEL__TRACE_MECHANISM:
        return traceMechanism != null;
      case UmplePackage.UMPLE_MODEL__USES:
        return uses != null && !uses.isEmpty();
      case UmplePackage.UMPLE_MODEL__UMPLE_ELEMENTS:
        return umpleElements != null && !umpleElements.isEmpty();
      case UmplePackage.UMPLE_MODEL__ASSOCIATIONS:
        return associations != null && !associations.isEmpty();
      case UmplePackage.UMPLE_MODEL__ASSOCIATION_CLASSES:
        return associationClasses != null && !associationClasses.isEmpty();
      case UmplePackage.UMPLE_MODEL__STATEMACHINES:
        return statemachines != null && !statemachines.isEmpty();
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
    result.append(" (generate_: ");
    result.append(generate_);
    result.append(", uses: ");
    result.append(uses);
    result.append(')');
    return result.toString();
  }

} //UmpleModelImpl
