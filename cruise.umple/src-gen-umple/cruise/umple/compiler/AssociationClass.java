/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * A combination of Class and Association (as defined in UML)
 * An AssociationClass is a full-fledged class, but at the same time
 * It associates two other classes that would otherwise have a many-many
 * relationship. Instances of the AssociationClass represent data 
 * held by the links between those two classes.
 * @umplesource Umple.ump 475
 * @umplesource Umple_Code.ump 696
 */
// line 475 "../../../../src/Umple.ump"
// line 696 "../../../../src/Umple_Code.ump"
public class AssociationClass extends UmpleClass
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssociationClass Associations
  private List<Association> associatedTo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AssociationClass(String aName, UmpleModel aSourceModel)
  {
    super(aName, aSourceModel);
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

  public boolean addAssociatedToAt(Association aAssociatedTo, int index)
  {  
    boolean wasAdded = false;
    if(addAssociatedTo(aAssociatedTo))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssociatedTo()) { index = numberOfAssociatedTo() - 1; }
      associatedTo.remove(aAssociatedTo);
      associatedTo.add(index, aAssociatedTo);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssociatedToAt(Association aAssociatedTo, int index)
  {
    boolean wasAdded = false;
    if(associatedTo.contains(aAssociatedTo))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssociatedTo()) { index = numberOfAssociatedTo() - 1; }
      associatedTo.remove(aAssociatedTo);
      associatedTo.add(index, aAssociatedTo);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssociatedToAt(aAssociatedTo, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    associatedTo.clear();
    super.delete();
  }

  @umplesourcefile(line={698},file={"Umple_Code.ump"},javaline={170},length={3})
   public  AssociationClass(String name){
    super(name);
  }

}