/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.associations;
import java.util.*;

// line 602 "../../../src/TestHarnessAssociations.ump"
public class ClassMToNAssociation
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassMToNAssociation Associations
  private List<Otherclass> otherclasses;

  //Helper Variables
  private boolean canSetOtherclasses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassMToNAssociation(Otherclass... allOtherclasses)
  {
    canSetOtherclasses = true;
    otherclasses = new ArrayList<Otherclass>();
    boolean didAddOtherclasses = setOtherclasses(allOtherclasses);
    if (!didAddOtherclasses)
    {
      throw new RuntimeException("Unable to create ClassMToNAssociation, must have 2 to 3 otherclasses");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Otherclass getOtherclass(int index)
  {
    Otherclass aOtherclass = otherclasses.get(index);
    return aOtherclass;
  }

  public List<Otherclass> getOtherclasses()
  {
    List<Otherclass> newOtherclasses = Collections.unmodifiableList(otherclasses);
    return newOtherclasses;
  }

  public int numberOfOtherclasses()
  {
    int number = otherclasses.size();
    return number;
  }

  public boolean hasOtherclasses()
  {
    boolean has = otherclasses.size() > 0;
    return has;
  }

  public int indexOfOtherclass(Otherclass aOtherclass)
  {
    int index = otherclasses.indexOf(aOtherclass);
    return index;
  }

  public static int minimumNumberOfOtherclasses()
  {
    return 2;
  }

  public static int maximumNumberOfOtherclasses()
  {
    return 3;
  }

  private boolean setOtherclasses(Otherclass... newOtherclasses)
  {
    boolean wasSet = false;
    if (!canSetOtherclasses) { return false; }
    canSetOtherclasses = false;
    ArrayList<Otherclass> verifiedOtherclasses = new ArrayList<Otherclass>();
    for (Otherclass aOtherclass : newOtherclasses)
    {
      if (verifiedOtherclasses.contains(aOtherclass))
      {
        continue;
      }
      verifiedOtherclasses.add(aOtherclass);
    }

    if (verifiedOtherclasses.size() != newOtherclasses.length || verifiedOtherclasses.size() < minimumNumberOfOtherclasses() || verifiedOtherclasses.size() > maximumNumberOfOtherclasses())
    {
      return wasSet;
    }

    otherclasses.clear();
    otherclasses.addAll(verifiedOtherclasses);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {}

}