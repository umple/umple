/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Modifier</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see cruise.umple.umple.UmplePackage#getModifier()
 * @model
 * @generated
 */
public enum Modifier implements Enumerator
{
  /**
   * The '<em><b>IMMUTABLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IMMUTABLE_VALUE
   * @generated
   * @ordered
   */
  IMMUTABLE(0, "IMMUTABLE", "immutable"),

  /**
   * The '<em><b>SETTABLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SETTABLE_VALUE
   * @generated
   * @ordered
   */
  SETTABLE(1, "SETTABLE", "settable"),

  /**
   * The '<em><b>INTERNAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INTERNAL_VALUE
   * @generated
   * @ordered
   */
  INTERNAL(2, "INTERNAL", "internal"),

  /**
   * The '<em><b>DEFAULTED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DEFAULTED_VALUE
   * @generated
   * @ordered
   */
  DEFAULTED(3, "DEFAULTED", "defaulted"),

  /**
   * The '<em><b>CONST</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONST_VALUE
   * @generated
   * @ordered
   */
  CONST(4, "CONST", "const");

  /**
   * The '<em><b>IMMUTABLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IMMUTABLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IMMUTABLE
   * @model literal="immutable"
   * @generated
   * @ordered
   */
  public static final int IMMUTABLE_VALUE = 0;

  /**
   * The '<em><b>SETTABLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SETTABLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SETTABLE
   * @model literal="settable"
   * @generated
   * @ordered
   */
  public static final int SETTABLE_VALUE = 1;

  /**
   * The '<em><b>INTERNAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INTERNAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INTERNAL
   * @model literal="internal"
   * @generated
   * @ordered
   */
  public static final int INTERNAL_VALUE = 2;

  /**
   * The '<em><b>DEFAULTED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DEFAULTED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DEFAULTED
   * @model literal="defaulted"
   * @generated
   * @ordered
   */
  public static final int DEFAULTED_VALUE = 3;

  /**
   * The '<em><b>CONST</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONST</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONST
   * @model literal="const"
   * @generated
   * @ordered
   */
  public static final int CONST_VALUE = 4;

  /**
   * An array of all the '<em><b>Modifier</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final Modifier[] VALUES_ARRAY =
    new Modifier[]
    {
      IMMUTABLE,
      SETTABLE,
      INTERNAL,
      DEFAULTED,
      CONST,
    };

  /**
   * A public read-only list of all the '<em><b>Modifier</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<Modifier> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Modifier</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Modifier get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Modifier result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Modifier</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Modifier getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Modifier result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Modifier</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Modifier get(int value)
  {
    switch (value)
    {
      case IMMUTABLE_VALUE: return IMMUTABLE;
      case SETTABLE_VALUE: return SETTABLE;
      case INTERNAL_VALUE: return INTERNAL;
      case DEFAULTED_VALUE: return DEFAULTED;
      case CONST_VALUE: return CONST;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private Modifier(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //Modifier
