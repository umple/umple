/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 57 "DMMSourceObjectHierarchy.ump"
// line 140 "DMMSourceObjectHierarchy.ump"
public class MacroArgument extends SourcePart
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MacroArgument Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MacroArgument(String aStartLine, String aStartChar, String aEndLine, String aEndChar, String aName)
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