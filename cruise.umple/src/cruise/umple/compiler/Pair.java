/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.umple.compiler;

public class Pair
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Pair Attributes
  private String name;
  private String value;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Pair(String aName, String aValue)
  {
    name = aName;
    value = aValue;
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

  public void delete()
  {}

}