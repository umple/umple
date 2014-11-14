/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 33 "DMMSourceObjectHierarchy.ump"
// line 110 "DMMSourceObjectHierarchy.ump"
public class SourceUnit extends SourceObject
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SourceUnit Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SourceUnit(String aName)
  {
    super();
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