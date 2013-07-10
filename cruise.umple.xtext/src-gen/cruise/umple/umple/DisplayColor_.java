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
 * A representation of the model object '<em><b>Display Color </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.DisplayColor_#getAnonymous_displayColor_1_1 <em>Anonymous display Color 11</em>}</li>
 *   <li>{@link cruise.umple.umple.DisplayColor_#getColorValue_1 <em>Color Value 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getDisplayColor_()
 * @model
 * @generated
 */
public interface DisplayColor_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Anonymous display Color 11</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous display Color 11</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous display Color 11</em>' attribute list.
   * @see cruise.umple.umple.UmplePackage#getDisplayColor__Anonymous_displayColor_1_1()
   * @model unique="false"
   * @generated
   */
  EList<String> getAnonymous_displayColor_1_1();

  /**
   * Returns the value of the '<em><b>Color Value 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Color Value 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Color Value 1</em>' attribute.
   * @see #setColorValue_1(String)
   * @see cruise.umple.umple.UmplePackage#getDisplayColor__ColorValue_1()
   * @model
   * @generated
   */
  String getColorValue_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.DisplayColor_#getColorValue_1 <em>Color Value 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Color Value 1</em>' attribute.
   * @see #getColorValue_1()
   * @generated
   */
  void setColorValue_1(String value);

} // DisplayColor_
