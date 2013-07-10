/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Debug_;
import cruise.umple.umple.Directive_;
import cruise.umple.umple.Entity_;
import cruise.umple.umple.Generate_;
import cruise.umple.umple.Generate_path_;
import cruise.umple.umple.Glossary_;
import cruise.umple.umple.Namespace_;
import cruise.umple.umple.Strictness_;
import cruise.umple.umple.TraceType_;
import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.UseStatement_;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Directive </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.Directive_Impl#getGlossary_1 <em>Glossary 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Directive_Impl#getGenerate_1 <em>Generate 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Directive_Impl#getGenerate_path_1 <em>Generate path 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Directive_Impl#getUseStatement_1 <em>Use Statement 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Directive_Impl#getNamespace_1 <em>Namespace 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Directive_Impl#getTraceType_1 <em>Trace Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Directive_Impl#getEntity_1 <em>Entity 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Directive_Impl#getDebug_1 <em>Debug 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.Directive_Impl#getStrictness_1 <em>Strictness 1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Directive_Impl extends MinimalEObjectImpl.Container implements Directive_
{
  /**
   * The cached value of the '{@link #getGlossary_1() <em>Glossary 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlossary_1()
   * @generated
   * @ordered
   */
  protected EList<Glossary_> glossary_1;

  /**
   * The cached value of the '{@link #getGenerate_1() <em>Generate 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerate_1()
   * @generated
   * @ordered
   */
  protected EList<Generate_> generate_1;

  /**
   * The cached value of the '{@link #getGenerate_path_1() <em>Generate path 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerate_path_1()
   * @generated
   * @ordered
   */
  protected EList<Generate_path_> generate_path_1;

  /**
   * The cached value of the '{@link #getUseStatement_1() <em>Use Statement 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseStatement_1()
   * @generated
   * @ordered
   */
  protected EList<UseStatement_> useStatement_1;

  /**
   * The cached value of the '{@link #getNamespace_1() <em>Namespace 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamespace_1()
   * @generated
   * @ordered
   */
  protected EList<Namespace_> namespace_1;

  /**
   * The cached value of the '{@link #getTraceType_1() <em>Trace Type 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceType_1()
   * @generated
   * @ordered
   */
  protected EList<TraceType_> traceType_1;

  /**
   * The cached value of the '{@link #getEntity_1() <em>Entity 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEntity_1()
   * @generated
   * @ordered
   */
  protected EList<Entity_> entity_1;

  /**
   * The cached value of the '{@link #getDebug_1() <em>Debug 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDebug_1()
   * @generated
   * @ordered
   */
  protected EList<Debug_> debug_1;

  /**
   * The cached value of the '{@link #getStrictness_1() <em>Strictness 1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrictness_1()
   * @generated
   * @ordered
   */
  protected EList<Strictness_> strictness_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Directive_Impl()
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
    return UmplePackage.eINSTANCE.getDirective_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Glossary_> getGlossary_1()
  {
    if (glossary_1 == null)
    {
      glossary_1 = new EObjectContainmentEList<Glossary_>(Glossary_.class, this, UmplePackage.DIRECTIVE___GLOSSARY_1);
    }
    return glossary_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Generate_> getGenerate_1()
  {
    if (generate_1 == null)
    {
      generate_1 = new EObjectContainmentEList<Generate_>(Generate_.class, this, UmplePackage.DIRECTIVE___GENERATE_1);
    }
    return generate_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Generate_path_> getGenerate_path_1()
  {
    if (generate_path_1 == null)
    {
      generate_path_1 = new EObjectContainmentEList<Generate_path_>(Generate_path_.class, this, UmplePackage.DIRECTIVE___GENERATE_PATH_1);
    }
    return generate_path_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UseStatement_> getUseStatement_1()
  {
    if (useStatement_1 == null)
    {
      useStatement_1 = new EObjectContainmentEList<UseStatement_>(UseStatement_.class, this, UmplePackage.DIRECTIVE___USE_STATEMENT_1);
    }
    return useStatement_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Namespace_> getNamespace_1()
  {
    if (namespace_1 == null)
    {
      namespace_1 = new EObjectContainmentEList<Namespace_>(Namespace_.class, this, UmplePackage.DIRECTIVE___NAMESPACE_1);
    }
    return namespace_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TraceType_> getTraceType_1()
  {
    if (traceType_1 == null)
    {
      traceType_1 = new EObjectContainmentEList<TraceType_>(TraceType_.class, this, UmplePackage.DIRECTIVE___TRACE_TYPE_1);
    }
    return traceType_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Entity_> getEntity_1()
  {
    if (entity_1 == null)
    {
      entity_1 = new EObjectContainmentEList<Entity_>(Entity_.class, this, UmplePackage.DIRECTIVE___ENTITY_1);
    }
    return entity_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Debug_> getDebug_1()
  {
    if (debug_1 == null)
    {
      debug_1 = new EObjectContainmentEList<Debug_>(Debug_.class, this, UmplePackage.DIRECTIVE___DEBUG_1);
    }
    return debug_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Strictness_> getStrictness_1()
  {
    if (strictness_1 == null)
    {
      strictness_1 = new EObjectContainmentEList<Strictness_>(Strictness_.class, this, UmplePackage.DIRECTIVE___STRICTNESS_1);
    }
    return strictness_1;
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
      case UmplePackage.DIRECTIVE___GLOSSARY_1:
        return ((InternalEList<?>)getGlossary_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.DIRECTIVE___GENERATE_1:
        return ((InternalEList<?>)getGenerate_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.DIRECTIVE___GENERATE_PATH_1:
        return ((InternalEList<?>)getGenerate_path_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.DIRECTIVE___USE_STATEMENT_1:
        return ((InternalEList<?>)getUseStatement_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.DIRECTIVE___NAMESPACE_1:
        return ((InternalEList<?>)getNamespace_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.DIRECTIVE___TRACE_TYPE_1:
        return ((InternalEList<?>)getTraceType_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.DIRECTIVE___ENTITY_1:
        return ((InternalEList<?>)getEntity_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.DIRECTIVE___DEBUG_1:
        return ((InternalEList<?>)getDebug_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.DIRECTIVE___STRICTNESS_1:
        return ((InternalEList<?>)getStrictness_1()).basicRemove(otherEnd, msgs);
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
      case UmplePackage.DIRECTIVE___GLOSSARY_1:
        return getGlossary_1();
      case UmplePackage.DIRECTIVE___GENERATE_1:
        return getGenerate_1();
      case UmplePackage.DIRECTIVE___GENERATE_PATH_1:
        return getGenerate_path_1();
      case UmplePackage.DIRECTIVE___USE_STATEMENT_1:
        return getUseStatement_1();
      case UmplePackage.DIRECTIVE___NAMESPACE_1:
        return getNamespace_1();
      case UmplePackage.DIRECTIVE___TRACE_TYPE_1:
        return getTraceType_1();
      case UmplePackage.DIRECTIVE___ENTITY_1:
        return getEntity_1();
      case UmplePackage.DIRECTIVE___DEBUG_1:
        return getDebug_1();
      case UmplePackage.DIRECTIVE___STRICTNESS_1:
        return getStrictness_1();
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
      case UmplePackage.DIRECTIVE___GLOSSARY_1:
        getGlossary_1().clear();
        getGlossary_1().addAll((Collection<? extends Glossary_>)newValue);
        return;
      case UmplePackage.DIRECTIVE___GENERATE_1:
        getGenerate_1().clear();
        getGenerate_1().addAll((Collection<? extends Generate_>)newValue);
        return;
      case UmplePackage.DIRECTIVE___GENERATE_PATH_1:
        getGenerate_path_1().clear();
        getGenerate_path_1().addAll((Collection<? extends Generate_path_>)newValue);
        return;
      case UmplePackage.DIRECTIVE___USE_STATEMENT_1:
        getUseStatement_1().clear();
        getUseStatement_1().addAll((Collection<? extends UseStatement_>)newValue);
        return;
      case UmplePackage.DIRECTIVE___NAMESPACE_1:
        getNamespace_1().clear();
        getNamespace_1().addAll((Collection<? extends Namespace_>)newValue);
        return;
      case UmplePackage.DIRECTIVE___TRACE_TYPE_1:
        getTraceType_1().clear();
        getTraceType_1().addAll((Collection<? extends TraceType_>)newValue);
        return;
      case UmplePackage.DIRECTIVE___ENTITY_1:
        getEntity_1().clear();
        getEntity_1().addAll((Collection<? extends Entity_>)newValue);
        return;
      case UmplePackage.DIRECTIVE___DEBUG_1:
        getDebug_1().clear();
        getDebug_1().addAll((Collection<? extends Debug_>)newValue);
        return;
      case UmplePackage.DIRECTIVE___STRICTNESS_1:
        getStrictness_1().clear();
        getStrictness_1().addAll((Collection<? extends Strictness_>)newValue);
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
      case UmplePackage.DIRECTIVE___GLOSSARY_1:
        getGlossary_1().clear();
        return;
      case UmplePackage.DIRECTIVE___GENERATE_1:
        getGenerate_1().clear();
        return;
      case UmplePackage.DIRECTIVE___GENERATE_PATH_1:
        getGenerate_path_1().clear();
        return;
      case UmplePackage.DIRECTIVE___USE_STATEMENT_1:
        getUseStatement_1().clear();
        return;
      case UmplePackage.DIRECTIVE___NAMESPACE_1:
        getNamespace_1().clear();
        return;
      case UmplePackage.DIRECTIVE___TRACE_TYPE_1:
        getTraceType_1().clear();
        return;
      case UmplePackage.DIRECTIVE___ENTITY_1:
        getEntity_1().clear();
        return;
      case UmplePackage.DIRECTIVE___DEBUG_1:
        getDebug_1().clear();
        return;
      case UmplePackage.DIRECTIVE___STRICTNESS_1:
        getStrictness_1().clear();
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
      case UmplePackage.DIRECTIVE___GLOSSARY_1:
        return glossary_1 != null && !glossary_1.isEmpty();
      case UmplePackage.DIRECTIVE___GENERATE_1:
        return generate_1 != null && !generate_1.isEmpty();
      case UmplePackage.DIRECTIVE___GENERATE_PATH_1:
        return generate_path_1 != null && !generate_path_1.isEmpty();
      case UmplePackage.DIRECTIVE___USE_STATEMENT_1:
        return useStatement_1 != null && !useStatement_1.isEmpty();
      case UmplePackage.DIRECTIVE___NAMESPACE_1:
        return namespace_1 != null && !namespace_1.isEmpty();
      case UmplePackage.DIRECTIVE___TRACE_TYPE_1:
        return traceType_1 != null && !traceType_1.isEmpty();
      case UmplePackage.DIRECTIVE___ENTITY_1:
        return entity_1 != null && !entity_1.isEmpty();
      case UmplePackage.DIRECTIVE___DEBUG_1:
        return debug_1 != null && !debug_1.isEmpty();
      case UmplePackage.DIRECTIVE___STRICTNESS_1:
        return strictness_1 != null && !strictness_1.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Directive_Impl
