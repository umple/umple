/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class AssociationClass extends UmpleClass
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssociationClass Associations
  private List<Association> associatedTo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AssociationClass(String aName)
  {
    super(aName);
    associatedTo = new ArrayList<Association>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Association getAssociatedTo(int index)
  {
    Association aAssociatedTo = associatedTo.get(index);
    return aAssociatedTo;
  }

  public List<Association> getAssociatedTo()
  {
    List<Association> newAssociatedTo = Collections.unmodifiableList(associatedTo);
    return newAssociatedTo;
  }

  public int numberOfAssociatedTo()
  {
    int number = associatedTo.size();
    return number;
  }

  public boolean hasAssociatedTo()
  {
    boolean has = associatedTo.size() > 0;
    return has;
  }

  public int indexOfAssociatedTo(Association aAssociatedTo)
  {
    int index = associatedTo.indexOf(aAssociatedTo);
    return index;
  }

  public static int minimumNumberOfAssociatedTo()
  {
    return 0;
  }

  public static int maximumNumberOfAssociatedTo()
  {
    return 2;
  }

  public boolean addAssociatedTo(Association aAssociatedTo)
  {
    boolean wasAdded = false;
    if (associatedTo.contains(aAssociatedTo)) { return false; }
    if (numberOfAssociatedTo() < maximumNumberOfAssociatedTo())
    {
      associatedTo.add(aAssociatedTo);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removeAssociatedTo(Association aAssociatedTo)
  {
    boolean wasRemoved = false;
    if (associatedTo.contains(aAssociatedTo))
    {
      associatedTo.remove(aAssociatedTo);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setAssociatedTo(Association... newAssociatedTo)
  {
    boolean wasSet = false;
    ArrayList<Association> verifiedAssociatedTo = new ArrayList<Association>();
    for (Association aAssociatedTo : newAssociatedTo)
    {
      if (verifiedAssociatedTo.contains(aAssociatedTo))
      {
        continue;
      }
      verifiedAssociatedTo.add(aAssociatedTo);
    }

    if (verifiedAssociatedTo.size() != newAssociatedTo.length || verifiedAssociatedTo.size() > maximumNumberOfAssociatedTo())
    {
      return wasSet;
    }

    associatedTo.clear();
    associatedTo.addAll(verifiedAssociatedTo);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    associatedTo.clear();
    super.delete();
  }

}