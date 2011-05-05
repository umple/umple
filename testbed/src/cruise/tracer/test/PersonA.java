/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.tracer.test;
import cruise.util.*;

public class PersonA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PersonA Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PersonA()
  {
    name = "x";
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    StringTracer.execute("name=" + aName);
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public void delete()
  {}

}