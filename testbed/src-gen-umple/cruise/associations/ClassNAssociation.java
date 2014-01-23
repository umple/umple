/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.associations;
import java.util.*;

// line 612 "../../../src/TestHarnessAssociations.ump"
public class ClassNAssociation
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassNAssociation Associations
  private List<Otherclass> otherclasses;

  //Helper Variables
  private boolean canSetOtherclasses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassNAssociation(Otherclass... allOtherclasses)
  {
    canSetOtherclasses = true;
    otherclasses = new ArrayList<Otherclass>();
    boolean didAddOtherclasses = setOtherclasses(allOtherclasses);
    if (!didAddOtherclasses)
    {
      throw new RuntimeException("Unable to create ClassNAssociation, must have 2 otherclasses");
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

  public static int requiredNumberOfOtherclasses()
  {
    return 2;
  }

  public static int minimumNumberOfOtherclasses()
  {
    return 2;
  }

  public static int maximumNumberOfOtherclasses()
  {
    return 2;
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

    if (verifiedOtherclasses.size() != newOtherclasses.length || verifiedOtherclasses.size() != requiredNumberOfOtherclasses())
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