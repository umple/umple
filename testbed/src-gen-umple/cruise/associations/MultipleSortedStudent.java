/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.associations;
import java.util.*;

// line 659 "../../../src/TestHarnessAssociations.ump"
public class MultipleSortedStudent
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MultipleSortedStudent Attributes
  private int id;
  private String name;
  private Comparator<MultipleSortedRegistration> multipleSortedRegistrationsPriority;

  //MultipleSortedStudent Associations
  private MultipleSortedAcademy multipleSortedAcademy;
  private List<MultipleSortedRegistration> multipleSortedRegistrations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MultipleSortedStudent(int aId, String aName, MultipleSortedAcademy aMultipleSortedAcademy)
  {
    id = aId;
    name = aName;
    multipleSortedRegistrationsPriority = 
      new Comparator<MultipleSortedRegistration>(){
        @Override
        public int compare(MultipleSortedRegistration arg0, MultipleSortedRegistration arg1)
        {
          return ((String)arg0.getCode()).compareTo(
                 ((String)arg1.getCode()));
        }
      };
    boolean didAddMultipleSortedAcademy = setMultipleSortedAcademy(aMultipleSortedAcademy);
    if (!didAddMultipleSortedAcademy)
    {
      throw new RuntimeException("Unable to create registrant due to multipleSortedAcademy");
    }
    multipleSortedRegistrations = new ArrayList<MultipleSortedRegistration>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setMultipleSortedRegistrationsPriority(Comparator<MultipleSortedRegistration> aMultipleSortedRegistrationsPriority)
  {
    boolean wasSet = false;
    multipleSortedRegistrationsPriority = aMultipleSortedRegistrationsPriority;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public Comparator<MultipleSortedRegistration> getMultipleSortedRegistrationsPriority()
  {
    return multipleSortedRegistrationsPriority;
  }

  public MultipleSortedAcademy getMultipleSortedAcademy()
  {
    return multipleSortedAcademy;
  }

  public MultipleSortedRegistration getMultipleSortedRegistration(int index)
  {
    MultipleSortedRegistration aMultipleSortedRegistration = multipleSortedRegistrations.get(index);
    return aMultipleSortedRegistration;
  }

  public List<MultipleSortedRegistration> getMultipleSortedRegistrations()
  {
    List<MultipleSortedRegistration> newMultipleSortedRegistrations = Collections.unmodifiableList(multipleSortedRegistrations);
    return newMultipleSortedRegistrations;
  }

  public int numberOfMultipleSortedRegistrations()
  {
    int number = multipleSortedRegistrations.size();
    return number;
  }

  public boolean hasMultipleSortedRegistrations()
  {
    boolean has = multipleSortedRegistrations.size() > 0;
    return has;
  }

  public int indexOfMultipleSortedRegistration(MultipleSortedRegistration aMultipleSortedRegistration)
  {
    int index = multipleSortedRegistrations.indexOf(aMultipleSortedRegistration);
    return index;
  }

  public boolean setMultipleSortedAcademy(MultipleSortedAcademy aMultipleSortedAcademy)
  {
    boolean wasSet = false;
    if (aMultipleSortedAcademy == null)
    {
      return wasSet;
    }

    MultipleSortedAcademy existingMultipleSortedAcademy = multipleSortedAcademy;
    multipleSortedAcademy = aMultipleSortedAcademy;
    if (existingMultipleSortedAcademy != null && !existingMultipleSortedAcademy.equals(aMultipleSortedAcademy))
    {
      existingMultipleSortedAcademy.removeRegistrant(this);
    }
    multipleSortedAcademy.addRegistrant(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfMultipleSortedRegistrations()
  {
    return 0;
  }

  public MultipleSortedRegistration addMultipleSortedRegistration(MultipleSortedCourse aMultipleSortedCourse)
  {
    return new MultipleSortedRegistration(aMultipleSortedCourse, this);
  }

  public boolean addMultipleSortedRegistration(MultipleSortedRegistration aMultipleSortedRegistration)
  {
    boolean wasAdded = false;
    if (multipleSortedRegistrations.contains(aMultipleSortedRegistration)) { return false; }
    MultipleSortedStudent existingMultipleSortedStudent = aMultipleSortedRegistration.getMultipleSortedStudent();
    boolean isNewMultipleSortedStudent = existingMultipleSortedStudent != null && !this.equals(existingMultipleSortedStudent);
    if (isNewMultipleSortedStudent)
    {
      aMultipleSortedRegistration.setMultipleSortedStudent(this);
    }
    else
    {
      multipleSortedRegistrations.add(aMultipleSortedRegistration);
    }
    wasAdded = true;
    if(wasAdded)
        Collections.sort(multipleSortedRegistrations, multipleSortedRegistrationsPriority);
    
    return wasAdded;
  }

  public boolean removeMultipleSortedRegistration(MultipleSortedRegistration aMultipleSortedRegistration)
  {
    boolean wasRemoved = false;
    //Unable to remove aMultipleSortedRegistration, as it must always have a multipleSortedStudent
    if (!this.equals(aMultipleSortedRegistration.getMultipleSortedStudent()))
    {
      multipleSortedRegistrations.remove(aMultipleSortedRegistration);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  
  public void delete()
  {
    MultipleSortedAcademy placeholderMultipleSortedAcademy = multipleSortedAcademy;
    this.multipleSortedAcademy = null;
    placeholderMultipleSortedAcademy.removeRegistrant(this);
    for(int i=multipleSortedRegistrations.size(); i > 0; i--)
    {
      MultipleSortedRegistration aMultipleSortedRegistration = multipleSortedRegistrations.get(i - 1);
      aMultipleSortedRegistration.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "multipleSortedRegistrationsPriority" + "=" + (getMultipleSortedRegistrationsPriority() != null ? !getMultipleSortedRegistrationsPriority().equals(this)  ? getMultipleSortedRegistrationsPriority().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "multipleSortedAcademy = "+(getMultipleSortedAcademy()!=null?Integer.toHexString(System.identityHashCode(getMultipleSortedAcademy())):"null")
     + outputString;
  }
}