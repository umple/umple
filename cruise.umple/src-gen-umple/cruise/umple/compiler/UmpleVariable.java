/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;

/**
 * Superclass for tracking member variables in all target languages
 * TODO: Code smell because we have both an association variable and also an association
 * This class should go and instead AssociationEnd should be the member variable
 */
public class UmpleVariable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleVariable Attributes
  private String name;
  private String type;
  private String modifier;
  private String value;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleVariable(String aName, String aType, String aModifier, String aValue)
  {
    name = aName;
    type = aType;
    modifier = aModifier;
    value = aValue;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    if (aName == null) { throw new RuntimeException("Name must be set, cannot be null"); }
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setModifier(String aModifier)
  {
    boolean wasSet = false;
    modifier = aModifier;
    wasSet = true;
    return wasSet;
  }

  public boolean setValue(String aValue)
  {
    boolean wasSet = false;
    value = aValue;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type;
  }

  public String getModifier()
  {
    if (modifier == null) { return "settable"; }
    return modifier;
  }

  /**
   * potential enum, 'settable'
   */
  public String getValue()
  {
    return value;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public String getUpperCaseName()
  {
    if (name == null || name.length() == 0)
    {
      return name;
    }
    else if (name.length() == 1)
    {
      return name.toUpperCase();
    }
    else
    {
      return name.toUpperCase().charAt(0) + name.substring(1);
    }
  }
  
  public boolean isImmutable()
  {
  	return "immutable".equals(modifier);
  }
}