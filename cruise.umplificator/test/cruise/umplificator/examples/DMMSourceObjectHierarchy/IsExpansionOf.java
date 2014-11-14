/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 52 "DMMSourceObjectHierarchy.ump"
// line 176 "DMMSourceObjectHierarchy.ump"
public class IsExpansionOf
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IsExpansionOf Associations
  private MacroDefinition macroDefinition;
  private MacroExpansion macroExpansion;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IsExpansionOf(MacroDefinition aMacroDefinition, MacroExpansion aMacroExpansion)
  {
    boolean didAddMacroDefinition = setMacroDefinition(aMacroDefinition);
    if (!didAddMacroDefinition)
    {
      throw new RuntimeException("Unable to create isExpansionOf due to macroDefinition");
    }
    if (aMacroExpansion == null || aMacroExpansion.getIsExpansionOf() != null)
    {
      throw new RuntimeException("Unable to create IsExpansionOf due to aMacroExpansion");
    }
    macroExpansion = aMacroExpansion;
  }

  public IsExpansionOf(MacroDefinition aMacroDefinition, String aStartLineForMacroExpansion, String aStartCharForMacroExpansion, String aEndLineForMacroExpansion, String aEndCharForMacroExpansion)
  {
    boolean didAddMacroDefinition = setMacroDefinition(aMacroDefinition);
    if (!didAddMacroDefinition)
    {
      throw new RuntimeException("Unable to create isExpansionOf due to macroDefinition");
    }
    macroExpansion = new MacroExpansion(aStartLineForMacroExpansion, aStartCharForMacroExpansion, aEndLineForMacroExpansion, aEndCharForMacroExpansion, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public MacroDefinition getMacroDefinition()
  {
    return macroDefinition;
  }

  public MacroExpansion getMacroExpansion()
  {
    return macroExpansion;
  }

  public boolean setMacroDefinition(MacroDefinition aMacroDefinition)
  {
    boolean wasSet = false;
    if (aMacroDefinition == null)
    {
      return wasSet;
    }

    MacroDefinition existingMacroDefinition = macroDefinition;
    macroDefinition = aMacroDefinition;
    if (existingMacroDefinition != null && !existingMacroDefinition.equals(aMacroDefinition))
    {
      existingMacroDefinition.removeIsExpansionOf(this);
    }
    macroDefinition.addIsExpansionOf(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    MacroDefinition placeholderMacroDefinition = macroDefinition;
    this.macroDefinition = null;
    placeholderMacroDefinition.removeIsExpansionOf(this);
    MacroExpansion existingMacroExpansion = macroExpansion;
    macroExpansion = null;
    if (existingMacroExpansion != null)
    {
      existingMacroExpansion.delete();
    }
  }

}