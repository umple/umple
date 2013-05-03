/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Parser.ump 154
 */
// line 154 "../../../../src/Parser.ump"
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

  public boolean setPosition(Position aNewPosition)
  {
    boolean wasSet = false;
    position = aNewPosition;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    position = null;
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "value" + ":" + getValue()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + getPosition() != null ? !getPosition() .equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}