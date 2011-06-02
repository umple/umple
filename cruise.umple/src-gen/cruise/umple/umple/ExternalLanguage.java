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
 * A representation of the model object '<em><b>External Language</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.ExternalLanguage#getFunctions <em>Functions</em>}</li>
 *   <li>{@link cruise.umple.umple.ExternalLanguage#getRubyFunctions <em>Ruby Functions</em>}</li>
 *   <li>{@link cruise.umple.umple.ExternalLanguage#getPhpFunctions <em>Php Functions</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getExternalLanguage()
 * @model
 * @generated
 */
public interface ExternalLanguage extends EObject
{
  /**
   * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.functionDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Functions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functions</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getExternalLanguage_Functions()
   * @model containment="true"
   * @generated
   */
  EList<functionDefinition> getFunctions();

  /**
   * Returns the value of the '<em><b>Ruby Functions</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ruby Functions</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ruby Functions</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getExternalLanguage_RubyFunctions()
   * @model unique="false"
   * @generated
   */
  EList<String> getRubyFunctions();

  /**
   * Returns the value of the '<em><b>Php Functions</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.phpFunction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Php Functions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Php Functions</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getExternalLanguage_PhpFunctions()
   * @model containment="true"
   * @generated
   */
  EList<phpFunction> getPhpFunctions();

} // ExternalLanguage
