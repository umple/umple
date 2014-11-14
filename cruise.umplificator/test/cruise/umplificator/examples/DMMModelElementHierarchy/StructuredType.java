/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 99 "DMMModelElementHierarchy.ump"
// line 210 "DMMModelElementHierarchy.ump"
public class StructuredType extends Type
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StructuredType Associations
  private List<IsFieldOf> isFieldOfs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StructuredType(String aVisibility)
  {
    super(aVisibility);
    isFieldOfs = new ArrayList<IsFieldOf>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public IsFieldOf getIsFieldOf(int index)
  {
    IsFieldOf aIsFieldOf = isFieldOfs.get(index);
    return aIsFieldOf;
  }

  public List<IsFieldOf> getIsFieldOfs()
  {
    List<IsFieldOf> newIsFieldOfs = Collections.unmodifiableList(isFieldOfs);
    return newIsFieldOfs;
  }

  public int numberOfIsFieldOfs()
  {
    int number = isFieldOfs.size();
    return number;
  }

  public boolean hasIsFieldOfs()
  {
    boolean has = isFieldOfs.size() > 0;
    return has;
  }

  public int indexOfIsFieldOf(IsFieldOf aIsFieldOf)
  {
    int index = isFieldOfs.indexOf(aIsFieldOf);
    return index;
  }

  public static int minimumNumberOfIsFieldOfs()
  {
    return 0;
  }

  public IsFieldOf addIsFieldOf(Field aField)
  {
    return new IsFieldOf(aField, this);
  }

  public boolean addIsFieldOf(IsFieldOf aIsFieldOf)
  {
    boolean wasAdded = false;
    if (isFieldOfs.contains(aIsFieldOf)) { return false; }
    if (isFieldOfs.contains(aIsFieldOf)) { return false; }
    StructuredType existingStructuredType = aIsFieldOf.getStructuredType();
    boolean isNewStructuredType = existingStructuredType != null && !this.equals(existingStructuredType);
    if (isNewStructuredType)
    {
      aIsFieldOf.setStructuredType(this);
    }
    else
    {
      isFieldOfs.add(aIsFieldOf);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIsFieldOf(IsFieldOf aIsFieldOf)
  {
    boolean wasRemoved = false;
    //Unable to remove aIsFieldOf, as it must always have a structuredType
    if (!this.equals(aIsFieldOf.getStructuredType()))
    {
      isFieldOfs.remove(aIsFieldOf);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIsFieldOfAt(IsFieldOf aIsFieldOf, int index)
  {  
    boolean wasAdded = false;
    if(addIsFieldOf(aIsFieldOf))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsFieldOfs()) { index = numberOfIsFieldOfs() - 1; }
      isFieldOfs.remove(aIsFieldOf);
      isFieldOfs.add(index, aIsFieldOf);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIsFieldOfAt(IsFieldOf aIsFieldOf, int index)
  {
    boolean wasAdded = false;
    if(isFieldOfs.contains(aIsFieldOf))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsFieldOfs()) { index = numberOfIsFieldOfs() - 1; }
      isFieldOfs.remove(aIsFieldOf);
      isFieldOfs.add(index, aIsFieldOf);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIsFieldOfAt(aIsFieldOf, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=isFieldOfs.size(); i > 0; i--)
    {
      IsFieldOf aIsFieldOf = isFieldOfs.get(i - 1);
      aIsFieldOf.delete();
    }
    super.delete();
  }

}