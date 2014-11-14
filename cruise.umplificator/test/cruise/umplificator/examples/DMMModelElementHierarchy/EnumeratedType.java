/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 90 "DMMModelElementHierarchy.ump"
// line 215 "DMMModelElementHierarchy.ump"
public class EnumeratedType extends Type
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EnumeratedType Associations
  private List<IsEnumerationLiteralOf> isEnumerationLiteralOfs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EnumeratedType(String aVisibility)
  {
    super(aVisibility);
    isEnumerationLiteralOfs = new ArrayList<IsEnumerationLiteralOf>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public IsEnumerationLiteralOf getIsEnumerationLiteralOf(int index)
  {
    IsEnumerationLiteralOf aIsEnumerationLiteralOf = isEnumerationLiteralOfs.get(index);
    return aIsEnumerationLiteralOf;
  }

  public List<IsEnumerationLiteralOf> getIsEnumerationLiteralOfs()
  {
    List<IsEnumerationLiteralOf> newIsEnumerationLiteralOfs = Collections.unmodifiableList(isEnumerationLiteralOfs);
    return newIsEnumerationLiteralOfs;
  }

  public int numberOfIsEnumerationLiteralOfs()
  {
    int number = isEnumerationLiteralOfs.size();
    return number;
  }

  public boolean hasIsEnumerationLiteralOfs()
  {
    boolean has = isEnumerationLiteralOfs.size() > 0;
    return has;
  }

  public int indexOfIsEnumerationLiteralOf(IsEnumerationLiteralOf aIsEnumerationLiteralOf)
  {
    int index = isEnumerationLiteralOfs.indexOf(aIsEnumerationLiteralOf);
    return index;
  }

  public static int minimumNumberOfIsEnumerationLiteralOfs()
  {
    return 0;
  }

  public IsEnumerationLiteralOf addIsEnumerationLiteralOf(EnumerationLiteral aEnumerationLiteral)
  {
    return new IsEnumerationLiteralOf(aEnumerationLiteral, this);
  }

  public boolean addIsEnumerationLiteralOf(IsEnumerationLiteralOf aIsEnumerationLiteralOf)
  {
    boolean wasAdded = false;
    if (isEnumerationLiteralOfs.contains(aIsEnumerationLiteralOf)) { return false; }
    EnumeratedType existingEnumeratedType = aIsEnumerationLiteralOf.getEnumeratedType();
    boolean isNewEnumeratedType = existingEnumeratedType != null && !this.equals(existingEnumeratedType);
    if (isNewEnumeratedType)
    {
      aIsEnumerationLiteralOf.setEnumeratedType(this);
    }
    else
    {
      isEnumerationLiteralOfs.add(aIsEnumerationLiteralOf);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIsEnumerationLiteralOf(IsEnumerationLiteralOf aIsEnumerationLiteralOf)
  {
    boolean wasRemoved = false;
    //Unable to remove aIsEnumerationLiteralOf, as it must always have a enumeratedType
    if (!this.equals(aIsEnumerationLiteralOf.getEnumeratedType()))
    {
      isEnumerationLiteralOfs.remove(aIsEnumerationLiteralOf);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIsEnumerationLiteralOfAt(IsEnumerationLiteralOf aIsEnumerationLiteralOf, int index)
  {  
    boolean wasAdded = false;
    if(addIsEnumerationLiteralOf(aIsEnumerationLiteralOf))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsEnumerationLiteralOfs()) { index = numberOfIsEnumerationLiteralOfs() - 1; }
      isEnumerationLiteralOfs.remove(aIsEnumerationLiteralOf);
      isEnumerationLiteralOfs.add(index, aIsEnumerationLiteralOf);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIsEnumerationLiteralOfAt(IsEnumerationLiteralOf aIsEnumerationLiteralOf, int index)
  {
    boolean wasAdded = false;
    if(isEnumerationLiteralOfs.contains(aIsEnumerationLiteralOf))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsEnumerationLiteralOfs()) { index = numberOfIsEnumerationLiteralOfs() - 1; }
      isEnumerationLiteralOfs.remove(aIsEnumerationLiteralOf);
      isEnumerationLiteralOfs.add(index, aIsEnumerationLiteralOf);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIsEnumerationLiteralOfAt(aIsEnumerationLiteralOf, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=isEnumerationLiteralOfs.size(); i > 0; i--)
    {
      IsEnumerationLiteralOf aIsEnumerationLiteralOf = isEnumerationLiteralOfs.get(i - 1);
      aIsEnumerationLiteralOf.delete();
    }
    super.delete();
  }

}