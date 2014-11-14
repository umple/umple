/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 76 "DMMModelElementHierarchy.ump"
// line 220 "DMMModelElementHierarchy.ump"
public class Variable extends Value
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Variable Associations
  private Value hasValue;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Variable(String aVisibility)
  {
    super(aVisibility);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Value getHasValue()
  {
    return hasValue;
  }

  public boolean hasHasValue()
  {
    boolean has = hasValue != null;
    return has;
  }

  public boolean setHasValue(Value aNewHasValue)
  {
    boolean wasSet = false;
    if (aNewHasValue == null)
    {
      Value existingHasValue = hasValue;
      hasValue = null;
      
      if (existingHasValue != null && existingHasValue.getVariable() != null)
      {
        existingHasValue.setVariable(null);
      }
      wasSet = true;
      return wasSet;
    }

    Value currentHasValue = getHasValue();
    if (currentHasValue != null && !currentHasValue.equals(aNewHasValue))
    {
      currentHasValue.setVariable(null);
    }

    hasValue = aNewHasValue;
    Variable existingVariable = aNewHasValue.getVariable();

    if (!equals(existingVariable))
    {
      aNewHasValue.setVariable(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (hasValue != null)
    {
      hasValue.setVariable(null);
    }
    super.delete();
  }

}