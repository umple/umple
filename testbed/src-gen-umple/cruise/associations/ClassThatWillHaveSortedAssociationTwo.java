/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

// line 646 "../../../src/TestHarnessAssociations.ump"
public class ClassThatWillHaveSortedAssociationTwo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassThatWillHaveSortedAssociationTwo Attributes
  private String massPriority;

  //ClassThatWillHaveSortedAssociationTwo Associations
  private List<ClassThatWillHaveSortedAssociationOne> mass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassThatWillHaveSortedAssociationTwo()
  {
    massPriority = "name";
    mass = new ArrayList<ClassThatWillHaveSortedAssociationOne>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMassPriority(String aMassPriority)
  {
    boolean wasSet = false;
    massPriority = aMassPriority;
    wasSet = true;
    return wasSet;
  }

  public String getMassPriority()
  {
    return massPriority;
  }

  public ClassThatWillHaveSortedAssociationOne getMass(int index)
  {
    ClassThatWillHaveSortedAssociationOne aMass = mass.get(index);
    return aMass;
  }

  public List<ClassThatWillHaveSortedAssociationOne> getMass()
  {
    List<ClassThatWillHaveSortedAssociationOne> newMass = Collections.unmodifiableList(mass);
    return newMass;
  }

  public int numberOfMass()
  {
    int number = mass.size();
    return number;
  }

  public boolean hasMass()
  {
    boolean has = mass.size() > 0;
    return has;
  }

  public int indexOfMass(ClassThatWillHaveSortedAssociationOne aMass)
  {
    int index = mass.indexOf(aMass);
    return index;
  }

  public static int minimumNumberOfMass()
  {
    return 0;
  }

  public boolean addMass(ClassThatWillHaveSortedAssociationOne aMass)
  {
    boolean wasAdded = false;
    if (mass.contains(aMass)) { return false; }
    mass.add(aMass);
    wasAdded = true;
    sort(mass, massPriority);
    
    return wasAdded;
  }

  public boolean removeMass(ClassThatWillHaveSortedAssociationOne aMass)
  {
    boolean wasRemoved = false;
    if (mass.contains(aMass))
    {
      mass.remove(aMass);
      wasRemoved = true;
    }
    sort(mass, massPriority);
    
    return wasRemoved;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void sort(List toSort, final String thePriority)
  {
    if(toSort.size() > 0)
    {
      Collections.sort(toSort, new Comparator<Object>()
      {
        @Override
        public int compare(Object arg0, Object arg1)
        {
          try
          {
            String methodName = "get" + thePriority.substring(0, 1).toUpperCase() + thePriority.substring(1);
            return ((Comparable)arg0.getClass().getMethod(methodName).invoke(arg0)).compareTo((Comparable)arg1.getClass().getMethod(methodName).invoke(arg1));
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          return 0;
        }
      });
    }
  }

  public void delete()
  {
    mass.clear();
  }

}