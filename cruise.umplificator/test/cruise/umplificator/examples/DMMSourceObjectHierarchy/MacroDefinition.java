/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 81 "DMMSourceObjectHierarchy.ump"
// line 100 "DMMSourceObjectHierarchy.ump"
public class MacroDefinition extends Definition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MacroDefinition Attributes
  private String name;

  //MacroDefinition Associations
  private List<IsExpansionOf> isExpansionOfs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MacroDefinition(String aStartLine, String aStartChar, String aEndLine, String aEndChar, String aName)
  {
    super(aStartLine, aStartChar, aEndLine, aEndChar);
    name = aName;
    isExpansionOfs = new ArrayList<IsExpansionOf>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public IsExpansionOf getIsExpansionOf(int index)
  {
    IsExpansionOf aIsExpansionOf = isExpansionOfs.get(index);
    return aIsExpansionOf;
  }

  public List<IsExpansionOf> getIsExpansionOfs()
  {
    List<IsExpansionOf> newIsExpansionOfs = Collections.unmodifiableList(isExpansionOfs);
    return newIsExpansionOfs;
  }

  public int numberOfIsExpansionOfs()
  {
    int number = isExpansionOfs.size();
    return number;
  }

  public boolean hasIsExpansionOfs()
  {
    boolean has = isExpansionOfs.size() > 0;
    return has;
  }

  public int indexOfIsExpansionOf(IsExpansionOf aIsExpansionOf)
  {
    int index = isExpansionOfs.indexOf(aIsExpansionOf);
    return index;
  }

  public static int minimumNumberOfIsExpansionOfs()
  {
    return 0;
  }

  public IsExpansionOf addIsExpansionOf(MacroExpansion aMacroExpansion)
  {
    return new IsExpansionOf(this, aMacroExpansion);
  }

  public boolean addIsExpansionOf(IsExpansionOf aIsExpansionOf)
  {
    boolean wasAdded = false;
    if (isExpansionOfs.contains(aIsExpansionOf)) { return false; }
    MacroDefinition existingMacroDefinition = aIsExpansionOf.getMacroDefinition();
    boolean isNewMacroDefinition = existingMacroDefinition != null && !this.equals(existingMacroDefinition);
    if (isNewMacroDefinition)
    {
      aIsExpansionOf.setMacroDefinition(this);
    }
    else
    {
      isExpansionOfs.add(aIsExpansionOf);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIsExpansionOf(IsExpansionOf aIsExpansionOf)
  {
    boolean wasRemoved = false;
    //Unable to remove aIsExpansionOf, as it must always have a macroDefinition
    if (!this.equals(aIsExpansionOf.getMacroDefinition()))
    {
      isExpansionOfs.remove(aIsExpansionOf);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIsExpansionOfAt(IsExpansionOf aIsExpansionOf, int index)
  {  
    boolean wasAdded = false;
    if(addIsExpansionOf(aIsExpansionOf))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsExpansionOfs()) { index = numberOfIsExpansionOfs() - 1; }
      isExpansionOfs.remove(aIsExpansionOf);
      isExpansionOfs.add(index, aIsExpansionOf);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIsExpansionOfAt(IsExpansionOf aIsExpansionOf, int index)
  {
    boolean wasAdded = false;
    if(isExpansionOfs.contains(aIsExpansionOf))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsExpansionOfs()) { index = numberOfIsExpansionOfs() - 1; }
      isExpansionOfs.remove(aIsExpansionOf);
      isExpansionOfs.add(index, aIsExpansionOf);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIsExpansionOfAt(aIsExpansionOf, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=isExpansionOfs.size(); i > 0; i--)
    {
      IsExpansionOf aIsExpansionOf = isExpansionOfs.get(i - 1);
      aIsExpansionOf.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}