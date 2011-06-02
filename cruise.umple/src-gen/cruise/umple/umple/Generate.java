/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Generate#isJava <em>Java</em>}</li>
 *   <li>{@link cruise.umple.umple.Generate#isPhp <em>Php</em>}</li>
 *   <li>{@link cruise.umple.umple.Generate#getRuby <em>Ruby</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getGenerate()
 * @model
 * @generated
 */
public interface Generate extends EObject
{
  /**
   * Returns the value of the '<em><b>Java</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java</em>' attribute.
   * @see #setJava(boolean)
   * @see cruise.umple.umple.UmplePackage#getGenerate_Java()
   * @model
   * @generated
   */
  boolean isJava();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Generate#isJava <em>Java</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Java</em>' attribute.
   * @see #isJava()
   * @generated
   */
  void setJava(boolean value);

  /**
   * Returns the value of the '<em><b>Php</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Php</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Php</em>' attribute.
   * @see #setPhp(boolean)
   * @see cruise.umple.umple.UmplePackage#getGenerate_Php()
   * @model
   * @generated
   */
  boolean isPhp();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Generate#isPhp <em>Php</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Php</em>' attribute.
   * @see #isPhp()
   * @generated
   */
  void setPhp(boolean value);

  /**
   * Returns the value of the '<em><b>Ruby</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ruby</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ruby</em>' attribute.
   * @see #setRuby(String)
   * @see cruise.umple.umple.UmplePackage#getGenerate_Ruby()
   * @model
   * @generated
   */
  String getRuby();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Generate#getRuby <em>Ruby</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ruby</em>' attribute.
   * @see #getRuby()
   * @generated
   */
  void setRuby(String value);

} // Generate
