/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cruise.umple.umple.UmpleAttribute#isAutounique <em>Autounique</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleAttribute#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleAttribute#isUnique <em>Unique</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleAttribute#getModifier <em>Modifier</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleAttribute#getType <em>Type</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleAttribute#isList <em>List</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleAttribute#getObject <em>Object</em>}</li>
 *   <li>{@link cruise.umple.umple.UmpleAttribute#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see cruise.umple.umple.UmplePackage#getUmpleAttribute()
 * @model
 * @generated
 */
public interface UmpleAttribute extends associationClassContent
{
  /**
   * Returns the value of the '<em><b>Autounique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Autounique</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Autounique</em>' attribute.
   * @see #setAutounique(boolean)
   * @see cruise.umple.umple.UmplePackage#getUmpleAttribute_Autounique()
   * @model
   * @generated
   */
  boolean isAutounique();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleAttribute#isAutounique <em>Autounique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Autounique</em>' attribute.
   * @see #isAutounique()
   * @generated
   */
  void setAutounique(boolean value);

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
   * @see cruise.umple.umple.UmplePackage#getUmpleAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleAttribute#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unique</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unique</em>' attribute.
   * @see #setUnique(boolean)
   * @see cruise.umple.umple.UmplePackage#getUmpleAttribute_Unique()
   * @model
   * @generated
   */
  boolean isUnique();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleAttribute#isUnique <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unique</em>' attribute.
   * @see #isUnique()
   * @generated
   */
  void setUnique(boolean value);

  /**
   * Returns the value of the '<em><b>Modifier</b></em>' attribute.
   * The literals are from the enumeration {@link cruise.umple.umple.Modifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modifier</em>' attribute.
   * @see cruise.umple.umple.Modifier
   * @see #setModifier(Modifier)
   * @see cruise.umple.umple.UmplePackage#getUmpleAttribute_Modifier()
   * @model
   * @generated
   */
  Modifier getModifier();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleAttribute#getModifier <em>Modifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifier</em>' attribute.
   * @see cruise.umple.umple.Modifier
   * @see #getModifier()
   * @generated
   */
  void setModifier(Modifier value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see cruise.umple.umple.UmplePackage#getUmpleAttribute_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleAttribute#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>List</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>List</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' attribute.
   * @see #setList(boolean)
   * @see cruise.umple.umple.UmplePackage#getUmpleAttribute_List()
   * @model
   * @generated
   */
  boolean isList();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleAttribute#isList <em>List</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' attribute.
   * @see #isList()
   * @generated
   */
  void setList(boolean value);

  /**
   * Returns the value of the '<em><b>Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object</em>' reference.
   * @see #setObject(UmpleClass)
   * @see cruise.umple.umple.UmplePackage#getUmpleAttribute_Object()
   * @model
   * @generated
   */
  UmpleClass getObject();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleAttribute#getObject <em>Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' reference.
   * @see #getObject()
   * @generated
   */
  void setObject(UmpleClass value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see cruise.umple.umple.UmplePackage#getUmpleAttribute_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link cruise.umple.umple.UmpleAttribute#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // UmpleAttribute
