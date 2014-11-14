/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 67 "DMMModelElementHierarchy.ump"
// line 190 "DMMModelElementHierarchy.ump"
public class EnumerationLiteral extends Value
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EnumerationLiteral Associations
  private List<IsEnumerationLiteralOf> isEnumerationLiteralOfs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EnumerationLiteral(String aVisibility)
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

  public boolean isNumberOfIsEnumerationLiteralOfsValid()
  {
    boolean isValid = numberOfIsEnumerationLiteralOfs() >= minimumNumberOfIsEnumerationLiteralOfs();
    return isValid;
  }

  public static int minimumNumberOfIsEnumerationLiteralOfs()
  {
    return 1;
  }

  public IsEnumerationLiteralOf addIsEnumerationLiteralOf(EnumeratedType aEnumeratedType)
  {
    IsEnumerationLiteralOf aNewIsEnumerationLiteralOf = new IsEnumerationLiteralOf(this, aEnumeratedType);
    return aNewIsEnumerationLiteralOf;
  }

  public boolean addIsEnumerationLiteralOf(IsEnumerationLiteralOf aIsEnumerationLiteralOf)
  {
    boolean wasAdded = false;
    if (isEnumerationLiteralOfs.contains(aIsEnumerationLiteralOf)) { return false; }
    EnumerationLiteral existingEnumerationLiteral = aIsEnumerationLiteralOf.getEnumerationLiteral();
    boolean isNewEnumerationLiteral = existingEnumerationLiteral != null && !this.equals(existingEnumerationLiteral);

    if (isNewEnumerationLiteral && existingEnumerationLiteral.numberOfIsEnumerationLiteralOfs() <= minimumNumberOfIsEnumerationLiteralOfs())
    {
      return wasAdded;
    }
    if (isNewEnumerationLiteral)
    {
      aIsEnumerationLiteralOf.setEnumerationLiteral(this);
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
    //Unable to remove aIsEnumerationLiteralOf, as it must always have a enumerationLiteral
    if (this.equals(aIsEnumerationLiteralOf.getEnumerationLiteral()))
    {
      return wasRemoved;
    }

    //enumerationLiteral already at minimum (1)
    if (numberOfIsEnumerationLiteralOfs() <= minimumNumberOfIsEnumerationLiteralOfs())
    {
      return wasRemoved;
    }

    isEnumerationLiteralOfs.remove(aIsEnumerationLiteralOf);
    wasRemoved = true;
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