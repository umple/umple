/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 62 "DMMModelElementHierarchy.ump"
// line 274 "DMMModelElementHierarchy.ump"
public class IsOfType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IsOfType Associations
  private Value value;
  private Type type;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IsOfType(Value aValue, Type aType)
  {
    boolean didAddValue = setValue(aValue);
    if (!didAddValue)
    {
      throw new RuntimeException("Unable to create isOfType due to value");
    }
    boolean didAddType = setType(aType);
    if (!didAddType)
    {
      throw new RuntimeException("Unable to create isOfType due to type");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Value getValue()
  {
    return value;
  }

  public Type getType()
  {
    return type;
  }

  public boolean setValue(Value aNewValue)
  {
    boolean wasSet = false;
    if (aNewValue == null)
    {
      //Unable to setValue to null, as isOfType must always be associated to a value
      return wasSet;
    }
    
    IsOfType existingIsOfType = aNewValue.getIsOfType();
    if (existingIsOfType != null && !equals(existingIsOfType))
    {
      //Unable to setValue, the current value already has a isOfType, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Value anOldValue = value;
    value = aNewValue;
    value.setIsOfType(this);

    if (anOldValue != null)
    {
      anOldValue.setIsOfType(null);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setType(Type aType)
  {
    boolean wasSet = false;
    if (aType == null)
    {
      return wasSet;
    }

    Type existingType = type;
    type = aType;
    if (existingType != null && !existingType.equals(aType))
    {
      existingType.removeIsOfType(this);
    }
    type.addIsOfType(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Value existingValue = value;
    value = null;
    if (existingValue != null)
    {
      existingValue.setIsOfType(null);
    }
    Type placeholderType = type;
    this.type = null;
    placeholderType.removeIsOfType(this);
  }

}