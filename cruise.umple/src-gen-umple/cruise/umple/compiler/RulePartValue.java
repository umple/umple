/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;

// line 144 "../../../../src/Parser.ump"
public class RulePartValue
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RulePartValue Attributes
  private String name;
  private String value;

  //RulePartValue Associations
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RulePartValue()
  {
    name = null;
    value = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
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

  public String getValue()
  {
    return value;
  }

  public Position getPosition()
  {
    return position;
  }

  public boolean setPosition(Position newPosition)
  {
    boolean wasSet = false;
    position = newPosition;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    position = null;
  }

}