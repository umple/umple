/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 94 "DMMModelElementHierarchy.ump"
// line 180 "DMMModelElementHierarchy.ump"
public class CollectionType extends Type
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CollectionType Attributes
  private String size;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CollectionType(String aVisibility, String aSize)
  {
    super(aVisibility);
    size = aSize;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSize(String aSize)
  {
    boolean wasSet = false;
    size = aSize;
    wasSet = true;
    return wasSet;
  }

  public String getSize()
  {
    return size;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "size" + ":" + getSize()+ "]"
     + outputString;
  }
}