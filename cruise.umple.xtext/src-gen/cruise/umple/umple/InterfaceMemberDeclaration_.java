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
 * A representation of the model object '<em><b>Interface Member Declaration </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.InterfaceMemberDeclaration_#getConstantDeclaration_1 <em>Constant Declaration 1</em>}</li>
 *   <li>{@link cruise.umple.umple.InterfaceMemberDeclaration_#getAbstractMethodDeclaration_1 <em>Abstract Method Declaration 1</em>}</li>
 *   <li>{@link cruise.umple.umple.InterfaceMemberDeclaration_#getPosition_1 <em>Position 1</em>}</li>
 *   <li>{@link cruise.umple.umple.InterfaceMemberDeclaration_#getDisplayColor_1 <em>Display Color 1</em>}</li>
 *   <li>{@link cruise.umple.umple.InterfaceMemberDeclaration_#getIsA_1 <em>Is A1</em>}</li>
 *   <li>{@link cruise.umple.umple.InterfaceMemberDeclaration_#getExtraCode_1 <em>Extra Code 1</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getInterfaceMemberDeclaration_()
 * @model
 * @generated
 */
public interface InterfaceMemberDeclaration_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Constant Declaration 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ConstantDeclaration_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constant Declaration 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constant Declaration 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInterfaceMemberDeclaration__ConstantDeclaration_1()
   * @model containment="true"
   * @generated
   */
  EList<ConstantDeclaration_> getConstantDeclaration_1();

  /**
   * Returns the value of the '<em><b>Abstract Method Declaration 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.AbstractMethodDeclaration_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract Method Declaration 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract Method Declaration 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInterfaceMemberDeclaration__AbstractMethodDeclaration_1()
   * @model containment="true"
   * @generated
   */
  EList<AbstractMethodDeclaration_> getAbstractMethodDeclaration_1();

  /**
   * Returns the value of the '<em><b>Position 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.Position_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Position 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Position 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInterfaceMemberDeclaration__Position_1()
   * @model containment="true"
   * @generated
   */
  EList<Position_> getPosition_1();

  /**
   * Returns the value of the '<em><b>Display Color 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.DisplayColor_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Display Color 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Display Color 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInterfaceMemberDeclaration__DisplayColor_1()
   * @model containment="true"
   * @generated
   */
  EList<DisplayColor_> getDisplayColor_1();

  /**
   * Returns the value of the '<em><b>Is A1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.IsA_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is A1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is A1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInterfaceMemberDeclaration__IsA_1()
   * @model containment="true"
   * @generated
   */
  EList<IsA_> getIsA_1();

  /**
   * Returns the value of the '<em><b>Extra Code 1</b></em>' containment reference list.
   * The list contents are of type {@link cruise.umple.umple.ExtraCode_}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extra Code 1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extra Code 1</em>' containment reference list.
   * @see cruise.umple.umple.UmplePackage#getInterfaceMemberDeclaration__ExtraCode_1()
   * @model containment="true"
   * @generated
   */
  EList<ExtraCode_> getExtraCode_1();

} // InterfaceMemberDeclaration_
