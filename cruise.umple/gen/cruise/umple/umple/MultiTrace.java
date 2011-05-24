/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.MultiTrace#getTraceItems <em>Trace Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getMultiTrace()
 * @model
 * @generated
 */
public interface MultiTrace extends TraceType
{
  /**
   * Returns the value of the '<em><b>Trace Items</b></em>' reference list.
   * The list contents are of type {@link cruise.umple.umple.UmpleAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Items</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Items</em>' reference list.
   * @see cruise.umple.umple.UmplePackage#getMultiTrace_TraceItems()
   * @model
   * @generated
   */
  EList<UmpleAttribute> getTraceItems();

} // MultiTrace
