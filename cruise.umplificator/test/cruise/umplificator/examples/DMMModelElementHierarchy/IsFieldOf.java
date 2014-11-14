/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 107 "DMMModelElementHierarchy.ump"
// line 310 "DMMModelElementHierarchy.ump"
public class IsFieldOf
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IsFieldOf Associations
  private Field field;
  private StructuredType structuredType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IsFieldOf(Field aField, StructuredType aStructuredType)
  {
    if (aField == null || aField.getIsFieldOf() != null)
    {
      throw new RuntimeException("Unable to create IsFieldOf due to aField");
    }
    field = aField;
    boolean didAddStructuredType = setStructuredType(aStructuredType);
    if (!didAddStructuredType)
    {
      throw new RuntimeException("Unable to create isFieldOf due to structuredType");
    }
  }

  public IsFieldOf(String aVisibilityForField, StructuredType aStructuredType)
  {
    field = new Field(aVisibilityForField, this);
    boolean didAddStructuredType = setStructuredType(aStructuredType);
    if (!didAddStructuredType)
    {
      throw new RuntimeException("Unable to create isFieldOf due to structuredType");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Field getField()
  {
    return field;
  }

  public StructuredType getStructuredType()
  {
    return structuredType;
  }

  public boolean setStructuredType(StructuredType aStructuredType)
  {
    boolean wasSet = false;
    if (aStructuredType == null)
    {
      return wasSet;
    }

    StructuredType existingStructuredType = structuredType;
    structuredType = aStructuredType;
    if (existingStructuredType != null && !existingStructuredType.equals(aStructuredType))
    {
      existingStructuredType.removeIsFieldOf(this);
    }
    structuredType.addIsFieldOf(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Field existingField = field;
    field = null;
    if (existingField != null)
    {
      existingField.delete();
    }
    StructuredType placeholderStructuredType = structuredType;
    this.structuredType = null;
    placeholderStructuredType.removeIsFieldOf(this);
  }

}