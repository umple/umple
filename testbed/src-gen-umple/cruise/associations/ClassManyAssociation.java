/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;
import java.util.*;

// line 595 "../../../src/TestHarnessAssociations.ump"
public class ClassManyAssociation
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassManyAssociation Associations
  private List<Otherclass> otherclasses;

  //Helper Variables
  private boolean canSetOtherclasses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassManyAssociation(Otherclass... allOtherclasses)
  {
    canSetOtherclasses = true;
    otherclasses = new ArrayList<Otherclass>();
    boolean didAddOtherclasses = setOtherclasses(allOtherclasses);
    if (!didAddOtherclasses)
    {
      throw new RuntimeException("Unable to create ClassManyAssociation, must not have duplicate otherclasses.");
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
    return 0;
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

    if (verifiedOtherclasses.size() != newOtherclasses.length)
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