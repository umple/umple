/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * abstract
 */
// line 67 "DMMSourceObjectHierarchy.ump"
// line 105 "DMMSourceObjectHierarchy.ump"
public class Resolvable extends SourcePart
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Resolvable Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Resolvable(String aStartLine, String aStartChar, String aEndLine, String aEndChar, String aName)
  {
    super(aStartLine, aStartChar, aEndLine, aEndChar);
    name = aName;
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

  public String getName()
  {
    return name;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}