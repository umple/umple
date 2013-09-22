/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * Simple name-value pair used in the Umple Parser
 * @umplesource UmpleInternalParser.ump 79
 */
// line 79 "../../../../src/UmpleInternalParser.ump"
public class Pair
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "value" + ":" + getValue()+ "]"
     + outputString;
  }
}