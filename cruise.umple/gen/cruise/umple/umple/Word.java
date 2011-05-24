/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Word</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.Word#getSingular <em>Singular</em>}</li>
 *   <li>{@link cruise.umple.umple.Word#getPlural <em>Plural</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getWord()
 * @model
 * @generated
 */
public interface Word extends EObject
{
  /**
   * Returns the value of the '<em><b>Singular</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Singular</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Singular</em>' attribute.
   * @see #setSingular(String)
   * @see cruise.umple.umple.UmplePackage#getWord_Singular()
   * @model
   * @generated
   */
  String getSingular();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Word#getSingular <em>Singular</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Singular</em>' attribute.
   * @see #getSingular()
   * @generated
   */
  void setSingular(String value);

  /**
   * Returns the value of the '<em><b>Plural</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plural</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plural</em>' attribute.
   * @see #setPlural(String)
   * @see cruise.umple.umple.UmplePackage#getWord_Plural()
   * @model
   * @generated
   */
  String getPlural();

  /**
   * Sets the value of the '{@link cruise.umple.umple.Word#getPlural <em>Plural</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Plural</em>' attribute.
   * @see #getPlural()
   * @generated
   */
  void setPlural(String value);

} // Word
