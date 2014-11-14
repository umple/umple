/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 103 "DMMModelElementHierarchy.ump"
// line 205 "DMMModelElementHierarchy.ump"
public class Field extends Variable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Field Associations
  private IsFieldOf isFieldOf;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Field(String aVisibility, IsFieldOf aIsFieldOf)
  {
    super(aVisibility);
    if (aIsFieldOf == null || aIsFieldOf.getField() != null)
    {
      throw new RuntimeException("Unable to create Field due to aIsFieldOf");
    }
    isFieldOf = aIsFieldOf;
  }

  public Field(String aVisibility, StructuredType aStructuredTypeForIsFieldOf)
  {
    super(aVisibility);
    isFieldOf = new IsFieldOf(this, aStructuredTypeForIsFieldOf);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public IsFieldOf getIsFieldOf()
  {
    return isFieldOf;
  }

  public void delete()
  {
    IsFieldOf existingIsFieldOf = isFieldOf;
    isFieldOf = null;
    if (existingIsFieldOf != null)
    {
      existingIsFieldOf.delete();
    }
    super.delete();
  }

}