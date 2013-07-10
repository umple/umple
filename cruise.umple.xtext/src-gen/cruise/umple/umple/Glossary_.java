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
 * A representation of the model object '<em><b>Glossary </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Glossary_#getWord_1 <em>Word 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getGlossary_()
 * @model
 * @generated
 */
public interface Glossary_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Word 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Word_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Word 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Word 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getGlossary__Word_1()
   * @model containment="true"
   * @generated
   */
  EList<Word_> getWord_1();

} // Glossary_
