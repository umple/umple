/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.AssociationPosition#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umple.AssociationPosition#getC1 <em>C1</em>}</li>
 *   <li>{@link cruise.umple.umple.AssociationPosition#getC2 <em>C2</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getAssociationPosition()
 * @model
 * @generated
 */
public interface AssociationPosition extends Position
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see cruise.umple.umple.UmplePackage#getAssociationPosition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.AssociationPosition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>C1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>C1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>C1</em>' containment reference.
   * @see #setC1(Coordinate)
   * @see cruise.umple.umple.UmplePackage#getAssociationPosition_C1()
   * @model containment="true"
   * @generated
   */
  Coordinate getC1();

  /**
   * Sets the value of the '{@link cruise.umple.umple.AssociationPosition#getC1 <em>C1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>C1</em>' containment reference.
   * @see #getC1()
   * @generated
   */
  void setC1(Coordinate value);

  /**
   * Returns the value of the '<em><b>C2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>C2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>C2</em>' containment reference.
   * @see #setC2(Coordinate)
   * @see cruise.umple.umple.UmplePackage#getAssociationPosition_C2()
   * @model containment="true"
   * @generated
   */
  Coordinate getC2();

  /**
   * Sets the value of the '{@link cruise.umple.umple.AssociationPosition#getC2 <em>C2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>C2</em>' containment reference.
   * @see #getC2()
   * @generated
   */
  void setC2(Coordinate value);

} // AssociationPosition
