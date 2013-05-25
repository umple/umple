/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;
import java.util.*;

// line 652 "../../../src/TestHarnessAssociations.ump"
public class MultipleSortedAcademy
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MultipleSortedAcademy Attributes
  private Comparator<MultipleSortedStudent> registrantsPriority;

  //MultipleSortedAcademy Associations
  private List<MultipleSortedCourse> multipleSortedCourses;
  private List<MultipleSortedStudent> registrants;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MultipleSortedAcademy()
  {
    registrantsPriority = 
      new Comparator<MultipleSortedStudent>(){
        @Override
        public int compare(MultipleSortedStudent arg0, MultipleSortedStudent arg1)
        {
          return ((Integer)arg0.getId()).compareTo(
                 ((Integer)arg1.getId()));
        }
      };
    multipleSortedCourses = new ArrayList<MultipleSortedCourse>();
    registrants = new ArrayList<MultipleSortedStudent>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRegistrantsPriority(Comparator<MultipleSortedStudent> aRegistrantsPriority)
  {
    boolean wasSet = false;
    registrantsPriority = aRegistrantsPriority;
    wasSet = true;
    return wasSet;
  }

  public Comparator<MultipleSortedStudent> getRegistrantsPriority()
  {
    return registrantsPriority;
  }

  public MultipleSortedCourse getMultipleSortedCourse(int index)
  {
    MultipleSortedCourse aMultipleSortedCourse = multipleSortedCourses.get(index);
    return aMultipleSortedCourse;
  }

  public List<MultipleSortedCourse> getMultipleSortedCourses()
  {
    List<MultipleSortedCourse> newMultipleSortedCourses = Collections.unmodifiableList(multipleSortedCourses);
    return newMultipleSortedCourses;
  }

  public int numberOfMultipleSortedCourses()
  {
    int number = multipleSortedCourses.size();
    return number;
  }

  public boolean hasMultipleSortedCourses()
  {
    boolean has = multipleSortedCourses.size() > 0;
    return has;
  }

  public int indexOfMultipleSortedCourse(MultipleSortedCourse aMultipleSortedCourse)
  {
    int index = multipleSortedCourses.indexOf(aMultipleSortedCourse);
    return index;
  }

  public MultipleSortedStudent getRegistrant(int index)
  {
    MultipleSortedStudent aRegistrant = registrants.get(index);
    return aRegistrant;
  }

  public List<MultipleSortedStudent> getRegistrants()
  {
    List<MultipleSortedStudent> newRegistrants = Collections.unmodifiableList(registrants);
    return newRegistrants;
  }

  public int numberOfRegistrants()
  {
    int number = registrants.size();
    return number;
  }

  public boolean hasRegistrants()
  {
    boolean has = registrants.size() > 0;
    return has;
  }

  public int indexOfRegistrant(MultipleSortedStudent aRegistrant)
  {
    int index = registrants.indexOf(aRegistrant);
    return index;
  }

  public static int minimumNumberOfMultipleSortedCourses()
  {
    return 0;
  }

  public MultipleSortedCourse addMultipleSortedCourse(String aCode)
  {
    return new MultipleSortedCourse(aCode, this);
  }

  public boolean addMultipleSortedCourse(MultipleSortedCourse aMultipleSortedCourse)
  {
    boolean wasAdded = false;
    if (multipleSortedCourses.contains(aMultipleSortedCourse)) { return false; }
    MultipleSortedAcademy existingMultipleSortedAcademy = aMultipleSortedCourse.getMultipleSortedAcademy();
    boolean isNewMultipleSortedAcademy = existingMultipleSortedAcademy != null && !this.equals(existingMultipleSortedAcademy);
    if (isNewMultipleSortedAcademy)
    {
      aMultipleSortedCourse.setMultipleSortedAcademy(this);
    }
    else
    {
      multipleSortedCourses.add(aMultipleSortedCourse);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMultipleSortedCourse(MultipleSortedCourse aMultipleSortedCourse)
  {
    boolean wasRemoved = false;
    //Unable to remove aMultipleSortedCourse, as it must always have a multipleSortedAcademy
    if (!this.equals(aMultipleSortedCourse.getMultipleSortedAcademy()))
    {
      multipleSortedCourses.remove(aMultipleSortedCourse);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addMultipleSortedCourseAt(MultipleSortedCourse aMultipleSortedCourse, int index)
  {  
    boolean wasAdded = false;
    if(addMultipleSortedCourse(aMultipleSortedCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMultipleSortedCourses()) { index = numberOfMultipleSortedCourses() - 1; }
      multipleSortedCourses.remove(aMultipleSortedCourse);
      multipleSortedCourses.add(index, aMultipleSortedCourse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMultipleSortedCourseAt(MultipleSortedCourse aMultipleSortedCourse, int index)
  {
    boolean wasAdded = false;
    if(multipleSortedCourses.contains(aMultipleSortedCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMultipleSortedCourses()) { index = numberOfMultipleSortedCourses() - 1; }
      multipleSortedCourses.remove(aMultipleSortedCourse);
      multipleSortedCourses.add(index, aMultipleSortedCourse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMultipleSortedCourseAt(aMultipleSortedCourse, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfRegistrants()
  {
    return 0;
  }

  public MultipleSortedStudent addRegistrant(int aId, String aName)
  {
    return new MultipleSortedStudent(aId, aName, this);
  }

  public boolean addRegistrant(MultipleSortedStudent aRegistrant)
  {
    boolean wasAdded = false;
    if (registrants.contains(aRegistrant)) { return false; }
    MultipleSortedAcademy existingMultipleSortedAcademy = aRegistrant.getMultipleSortedAcademy();
    boolean isNewMultipleSortedAcademy = existingMultipleSortedAcademy != null && !this.equals(existingMultipleSortedAcademy);
    if (isNewMultipleSortedAcademy)
    {
      aRegistrant.setMultipleSortedAcademy(this);
    }
    else
    {
      registrants.add(aRegistrant);
    }
    wasAdded = true;
    if(wasAdded)
        Collections.sort(registrants, registrantsPriority);
    
    return wasAdded;
  }

  public boolean removeRegistrant(MultipleSortedStudent aRegistrant)
  {
    boolean wasRemoved = false;
    //Unable to remove aRegistrant, as it must always have a multipleSortedAcademy
    if (!this.equals(aRegistrant.getMultipleSortedAcademy()))
    {
      registrants.remove(aRegistrant);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  
  public void delete()
  {
    for(int i=multipleSortedCourses.size(); i > 0; i--)
    {
      MultipleSortedCourse aMultipleSortedCourse = multipleSortedCourses.get(i - 1);
      aMultipleSortedCourse.delete();
    }
    for(int i=registrants.size(); i > 0; i--)
    {
      MultipleSortedStudent aRegistrant = registrants.get(i - 1);
      aRegistrant.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "registrantsPriority" + "=" + (getRegistrantsPriority() != null ? !getRegistrantsPriority().equals(this)  ? getRegistrantsPriority().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}