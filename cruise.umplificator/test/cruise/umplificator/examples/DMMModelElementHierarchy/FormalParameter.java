/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 112 "DMMModelElementHierarchy.ump"
// line 175 "DMMModelElementHierarchy.ump"
public class FormalParameter extends Variable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FormalParameter Attributes
  private String pos;

  //FormalParameter Associations
  private IsParameterOf isParameterOf;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FormalParameter(String aVisibility, String aPos, IsParameterOf aIsParameterOf)
  {
    super(aVisibility);
    pos = aPos;
    if (aIsParameterOf == null || aIsParameterOf.getFormalParameter() != null)
    {
      throw new RuntimeException("Unable to create FormalParameter due to aIsParameterOf");
    }
    isParameterOf = aIsParameterOf;
  }

  public FormalParameter(String aVisibility, String aPos, BehaviouralElement aBehaviouralElementForIsParameterOf)
  {
    super(aVisibility);
    pos = aPos;
    isParameterOf = new IsParameterOf(this, aBehaviouralElementForIsParameterOf);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPos(String aPos)
  {
    boolean wasSet = false;
    pos = aPos;
    wasSet = true;
    return wasSet;
  }

  public String getPos()
  {
    return pos;
  }

  public IsParameterOf getIsParameterOf()
  {
    return isParameterOf;
  }

  public void delete()
  {
    IsParameterOf existingIsParameterOf = isParameterOf;
    isParameterOf = null;
    if (existingIsParameterOf != null)
    {
      existingIsParameterOf.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "pos" + ":" + getPos()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "isParameterOf = "+(getIsParameterOf()!=null?Integer.toHexString(System.identityHashCode(getIsParameterOf())):"null")
     + outputString;
  }
}