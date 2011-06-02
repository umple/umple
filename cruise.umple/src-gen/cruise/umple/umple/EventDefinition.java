/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.EventDefinition#getG <em>G</em>}</li>
 *   <li>{@link cruise.umple.umple.EventDefinition#getEventID <em>Event ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getEventDefinition()
 * @model
 * @generated
 */
public interface EventDefinition extends Transition
{
  /**
   * Returns the value of the '<em><b>G</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>G</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>G</em>' containment reference.
   * @see #setG(Guard)
   * @see cruise.umple.umple.UmplePackage#getEventDefinition_G()
   * @model containment="true"
   * @generated
   */
  Guard getG();

  /**
   * Sets the value of the '{@link cruise.umple.umple.EventDefinition#getG <em>G</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>G</em>' containment reference.
   * @see #getG()
   * @generated
   */
  void setG(Guard value);

  /**
   * Returns the value of the '<em><b>Event ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event ID</em>' attribute.
   * @see #setEventID(String)
   * @see cruise.umple.umple.UmplePackage#getEventDefinition_EventID()
   * @model
   * @generated
   */
  String getEventID();

  /**
   * Sets the value of the '{@link cruise.umple.umple.EventDefinition#getEventID <em>Event ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event ID</em>' attribute.
   * @see #getEventID()
   * @generated
   */
  void setEventID(String value);

} // EventDefinition
