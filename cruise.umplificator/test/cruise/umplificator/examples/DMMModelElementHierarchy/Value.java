/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 58 "DMMModelElementHierarchy.ump"
// line 226 "DMMModelElementHierarchy.ump"
public class Value extends StructuralElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Value Associations
  private IsOfType isOfType;
  private Variable variable;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Value(String aVisibility)
  {
    super(aVisibility);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public IsOfType getIsOfType()
  {
    return isOfType;
  }

  public boolean hasIsOfType()
  {
    boolean has = isOfType != null;
    return has;
  }

  public Variable getVariable()
  {
    return variable;
  }

  public boolean hasVariable()
  {
    boolean has = variable != null;
    return has;
  }

  public boolean setIsOfType(IsOfType aNewIsOfType)
  {
    boolean wasSet = false;
    if (isOfType != null && !isOfType.equals(aNewIsOfType) && equals(isOfType.getValue()))
    {
      //Unable to setIsOfType, as existing isOfType would become an orphan
      return wasSet;
    }

    isOfType = aNewIsOfType;
    Value anOldValue = aNewIsOfType != null ? aNewIsOfType.getValue() : null;

    if (!this.equals(anOldValue))
    {
      if (anOldValue != null)
      {
        anOldValue.isOfType = null;
      }
      if (isOfType != null)
      {
        isOfType.setValue(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setVariable(Variable aNewVariable)
  {
    boolean wasSet = false;
    if (aNewVariable == null)
    {
      Variable existingVariable = variable;
      variable = null;
      
      if (existingVariable != null && existingVariable.getHasValue() != null)
      {
        existingVariable.setHasValue(null);
      }
      wasSet = true;
      return wasSet;
    }

    Variable currentVariable = getVariable();
    if (currentVariable != null && !currentVariable.equals(aNewVariable))
    {
      currentVariable.setHasValue(null);
    }

    variable = aNewVariable;
    Value existingHasValue = aNewVariable.getHasValue();

    if (!equals(existingHasValue))
    {
      aNewVariable.setHasValue(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    IsOfType existingIsOfType = isOfType;
    isOfType = null;
    if (existingIsOfType != null)
    {
      existingIsOfType.delete();
    }
    if (variable != null)
    {
      variable.setHasValue(null);
    }
    super.delete();
  }

}