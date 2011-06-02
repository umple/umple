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
 * A representation of the model object '<em><b>Trace Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.TraceCase#getTraceCaseName <em>Trace Case Name</em>}</li>
 *   <li>{@link cruise.umple.umple.TraceCase#getTraceDirective <em>Trace Directive</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getTraceCase()
 * @model
 * @generated
 */
public interface TraceCase extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Case Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Case Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Case Name</em>' attribute.
   * @see #setTraceCaseName(String)
   * @see cruise.umple.umple.UmplePackage#getTraceCase_TraceCaseName()
   * @model
   * @generated
   */
  String getTraceCaseName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.TraceCase#getTraceCaseName <em>Trace Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trace Case Name</em>' attribute.
   * @see #getTraceCaseName()
   * @generated
   */
  void setTraceCaseName(String value);

  /**
   * Returns the value of the '<em><b>Trace Directive</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.TraceDirective}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Directive</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Directive</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getTraceCase_TraceDirective()
   * @model containment="true"
   * @generated
   */
  EList<TraceDirective> getTraceDirective();

} // TraceCase
