/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;
import java.util.*;

// line 646 "../../../src/TestHarnessAssociations.ump"
public class ClassThatWillHaveSortedAssociationTwo
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassThatWillHaveSortedAssociationTwo Attributes
  private Comparator<ClassThatWillHaveSortedAssociationOne> massPriority;

  //ClassThatWillHaveSortedAssociationTwo Associations
  private List<ClassThatWillHaveSortedAssociationOne> mass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassThatWillHaveSortedAssociationTwo()
  {
    massPriority = 
      new Comparator<ClassThatWillHaveSortedAssociationOne>(){
        @Override
        public int compare(ClassThatWillHaveSortedAssociationOne arg0, ClassThatWillHaveSortedAssociationOne arg1)
        {
          return ((String)arg0.getName()).compareTo(
                 ((String)arg1.getName()));
        }
      };
    mass = new ArrayList<ClassThatWillHaveSortedAssociationOne>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMassPriority(Comparator<ClassThatWillHaveSortedAssociationOne> aMassPriority)
  {
    boolean wasSet = false;
    massPriority = aMassPriority;
    wasSet = true;
    return wasSet;
  }

  public Comparator<ClassThatWillHaveSortedAssociationOne> getMassPriority()
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
    if(wasAdded)
        Collections.sort(mass, massPriority);
    
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
    return wasRemoved;
  }

  
  public void delete()
  {
    mass.clear();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "massPriority" + "=" + (getMassPriority() != null ? !getMassPriority().equals(this)  ? getMassPriority().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}