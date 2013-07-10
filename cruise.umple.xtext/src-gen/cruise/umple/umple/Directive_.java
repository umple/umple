/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Directive </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Directive_#getGlossary_1 <em>Glossary 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Directive_#getGenerate_1 <em>Generate 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Directive_#getGenerate_path_1 <em>Generate path 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Directive_#getUseStatement_1 <em>Use Statement 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Directive_#getNamespace_1 <em>Namespace 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Directive_#getTraceType_1 <em>Trace Type 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Directive_#getEntity_1 <em>Entity 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Directive_#getDebug_1 <em>Debug 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Directive_#getStrictness_1 <em>Strictness 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getDirective_()
 * @model
 * @generated
 */
public interface Directive_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Glossary 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Glossary_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Glossary 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Glossary 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDirective__Glossary_1()
   * @model containment="true"
   * @generated
   */
  EList<Glossary_> getGlossary_1();

  /**
   * Returns the value of the '<em><b>Generate 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Generate_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generate 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generate 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDirective__Generate_1()
   * @model containment="true"
   * @generated
   */
  EList<Generate_> getGenerate_1();

  /**
   * Returns the value of the '<em><b>Generate path 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Generate_path_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generate path 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generate path 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDirective__Generate_path_1()
   * @model containment="true"
   * @generated
   */
  EList<Generate_path_> getGenerate_path_1();

  /**
   * Returns the value of the '<em><b>Use Statement 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.UseStatement_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Statement 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Statement 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDirective__UseStatement_1()
   * @model containment="true"
   * @generated
   */
  EList<UseStatement_> getUseStatement_1();

  /**
   * Returns the value of the '<em><b>Namespace 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Namespace_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Namespace 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Namespace 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDirective__Namespace_1()
   * @model containment="true"
   * @generated
   */
  EList<Namespace_> getNamespace_1();

  /**
   * Returns the value of the '<em><b>Trace Type 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceType_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Type 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Type 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDirective__TraceType_1()
   * @model containment="true"
   * @generated
   */
  EList<TraceType_> getTraceType_1();

  /**
   * Returns the value of the '<em><b>Entity 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Entity_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entity 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entity 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDirective__Entity_1()
   * @model containment="true"
   * @generated
   */
  EList<Entity_> getEntity_1();

  /**
   * Returns the value of the '<em><b>Debug 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Debug_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Debug 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Debug 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDirective__Debug_1()
   * @model containment="true"
   * @generated
   */
  EList<Debug_> getDebug_1();

  /**
   * Returns the value of the '<em><b>Strictness 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Strictness_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Strictness 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Strictness 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getDirective__Strictness_1()
   * @model containment="true"
   * @generated
   */
  EList<Strictness_> getStrictness_1();

} // Directive_
