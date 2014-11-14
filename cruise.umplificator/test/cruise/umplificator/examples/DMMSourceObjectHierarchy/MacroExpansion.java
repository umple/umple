/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 48 "DMMSourceObjectHierarchy.ump"
// line 145 "DMMSourceObjectHierarchy.ump"
public class MacroExpansion extends SourcePart
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MacroExpansion Associations
  private IsExpansionOf isExpansionOf;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MacroExpansion(String aStartLine, String aStartChar, String aEndLine, String aEndChar, IsExpansionOf aIsExpansionOf)
  {
    super(aStartLine, aStartChar, aEndLine, aEndChar);
    if (aIsExpansionOf == null || aIsExpansionOf.getMacroExpansion() != null)
    {
      throw new RuntimeException("Unable to create MacroExpansion due to aIsExpansionOf");
    }
    isExpansionOf = aIsExpansionOf;
  }

  public MacroExpansion(String aStartLine, String aStartChar, String aEndLine, String aEndChar, MacroDefinition aMacroDefinitionForIsExpansionOf)
  {
    super(aStartLine, aStartChar, aEndLine, aEndChar);
    isExpansionOf = new IsExpansionOf(aMacroDefinitionForIsExpansionOf, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public IsExpansionOf getIsExpansionOf()
  {
    return isExpansionOf;
  }

  public void delete()
  {
    IsExpansionOf existingIsExpansionOf = isExpansionOf;
    isExpansionOf = null;
    if (existingIsExpansionOf != null)
    {
      existingIsExpansionOf.delete();
    }
    super.delete();
  }

}