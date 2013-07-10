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
 * A representation of the model object '<em><b>Comment </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Comment_#getInlineComment_1 <em>Inline Comment 1</em>}</li>
 *   <li>{@link cruise.umple.umple.Comment_#getMultilineComment_1 <em>Multiline Comment 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getComment_()
 * @model
 * @generated
 */
public interface Comment_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Inline Comment 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.InlineComment_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inline Comment 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inline Comment 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getComment__InlineComment_1()
   * @model containment="true"
   * @generated
   */
  EList<InlineComment_> getInlineComment_1();

  /**
   * Returns the value of the '<em><b>Multiline Comment 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.MultilineComment_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiline Comment 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiline Comment 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getComment__MultilineComment_1()
   * @model containment="true"
   * @generated
   */
  EList<MultilineComment_> getMultilineComment_1();

} // Comment_
