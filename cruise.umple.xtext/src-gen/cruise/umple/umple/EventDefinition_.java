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
 * A representation of the model object '<em><b>Event Definition </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.EventDefinition_#getAfterEveryEvent_1 <em>After Every Event 1</em>}</li>
 *   <li>{@link cruise.umple.umple.EventDefinition_#getAfterEvent_1 <em>After Event 1</em>}</li>
 *   <li>{@link cruise.umple.umple.EventDefinition_#getEvent_1 <em>Event 1</em>}</li>
 *   <li>{@link cruise.umple.umple.EventDefinition_#getAnonymous_eventDefinition_1_1 <em>Anonymous event Definition 11</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getEventDefinition_()
 * @model
 * @generated
 */
public interface EventDefinition_ extends EObject
{
  /**
   * Returns the value of the '<em><b>After Every Event 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AfterEveryEvent_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>After Every Event 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>After Every Event 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEventDefinition__AfterEveryEvent_1()
   * @model containment="true"
   * @generated
   */
  EList<AfterEveryEvent_> getAfterEveryEvent_1();

  /**
   * Returns the value of the '<em><b>After Event 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AfterEvent_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>After Event 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>After Event 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEventDefinition__AfterEvent_1()
   * @model containment="true"
   * @generated
   */
  EList<AfterEvent_> getAfterEvent_1();

  /**
   * Returns the value of the '<em><b>Event 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event 1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event 1</em>' attribute.
   * @see #setEvent_1(String)
   * @see cruise.umple.umple.UmplePackage#getEventDefinition__Event_1()
   * @model
   * @generated
   */
  String getEvent_1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.EventDefinition_#getEvent_1 <em>Event 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event 1</em>' attribute.
   * @see #getEvent_1()
   * @generated
   */
  void setEvent_1(String value);

  /**
   * Returns the value of the '<em><b>Anonymous event Definition 11</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Anonymous_eventDefinition_1_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Anonymous event Definition 11</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Anonymous event Definition 11</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getEventDefinition__Anonymous_eventDefinition_1_1()
   * @model containment="true"
   * @generated
   */
  EList<Anonymous_eventDefinition_1_> getAnonymous_eventDefinition_1_1();

} // EventDefinition_
