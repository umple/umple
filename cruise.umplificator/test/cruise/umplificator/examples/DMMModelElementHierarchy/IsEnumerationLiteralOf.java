/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 71 "DMMModelElementHierarchy.ump"
// line 303 "DMMModelElementHierarchy.ump"
public class IsEnumerationLiteralOf
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IsEnumerationLiteralOf Associations
  private EnumerationLiteral enumerationLiteral;
  private EnumeratedType enumeratedType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IsEnumerationLiteralOf(EnumerationLiteral aEnumerationLiteral, EnumeratedType aEnumeratedType)
  {
    boolean didAddEnumerationLiteral = setEnumerationLiteral(aEnumerationLiteral);
    if (!didAddEnumerationLiteral)
    {
      throw new RuntimeException("Unable to create isEnumerationLiteralOf due to enumerationLiteral");
    }
    boolean didAddEnumeratedType = setEnumeratedType(aEnumeratedType);
    if (!didAddEnumeratedType)
    {
      throw new RuntimeException("Unable to create isEnumerationLiteralOf due to enumeratedType");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public EnumerationLiteral getEnumerationLiteral()
  {
    return enumerationLiteral;
  }

  public EnumeratedType getEnumeratedType()
  {
    return enumeratedType;
  }

  public boolean setEnumerationLiteral(EnumerationLiteral aEnumerationLiteral)
  {
    boolean wasSet = false;
    //Must provide enumerationLiteral to isEnumerationLiteralOf
    if (aEnumerationLiteral == null)
    {
      return wasSet;
    }

    if (enumerationLiteral != null && enumerationLiteral.numberOfIsEnumerationLiteralOfs() <= EnumerationLiteral.minimumNumberOfIsEnumerationLiteralOfs())
    {
      return wasSet;
    }

    EnumerationLiteral existingEnumerationLiteral = enumerationLiteral;
    enumerationLiteral = aEnumerationLiteral;
    if (existingEnumerationLiteral != null && !existingEnumerationLiteral.equals(aEnumerationLiteral))
    {
      boolean didRemove = existingEnumerationLiteral.removeIsEnumerationLiteralOf(this);
      if (!didRemove)
      {
        enumerationLiteral = existingEnumerationLiteral;
        return wasSet;
      }
    }
    enumerationLiteral.addIsEnumerationLiteralOf(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setEnumeratedType(EnumeratedType aEnumeratedType)
  {
    boolean wasSet = false;
    if (aEnumeratedType == null)
    {
      return wasSet;
    }

    EnumeratedType existingEnumeratedType = enumeratedType;
    enumeratedType = aEnumeratedType;
    if (existingEnumeratedType != null && !existingEnumeratedType.equals(aEnumeratedType))
    {
      existingEnumeratedType.removeIsEnumerationLiteralOf(this);
    }
    enumeratedType.addIsEnumerationLiteralOf(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    EnumerationLiteral placeholderEnumerationLiteral = enumerationLiteral;
    this.enumerationLiteral = null;
    placeholderEnumerationLiteral.removeIsEnumerationLiteralOf(this);
    EnumeratedType placeholderEnumeratedType = enumeratedType;
    this.enumeratedType = null;
    placeholderEnumeratedType.removeIsEnumerationLiteralOf(this);
  }

}