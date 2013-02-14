/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;
import java.util.*;

// line 662 "../../../src/TestHarnessAssociations.ump"
public class MultipleSortedCourse
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MultipleSortedCourse Attributes
  private String code;
  private Comparator<MultipleSortedRegistration> multipleSortedRegistrationsPriority;

  //MultipleSortedCourse Associations
  private MultipleSortedAcademy multipleSortedAcademy;
  private List<MultipleSortedRegistration> multipleSortedRegistrations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MultipleSortedCourse(String aCode, MultipleSortedAcademy aMultipleSortedAcademy)
  {
    code = aCode;
    multipleSortedRegistrationsPriority = 
      new Comparator<MultipleSortedRegistration>(){
        @Override
        public int compare(MultipleSortedRegistration arg0, MultipleSortedRegistration arg1)
        {
          return ((String)arg0.getName()).compareTo(
                 ((String)arg1.getName()));
        }
      };
    boolean didAddMultipleSortedAcademy = setMultipleSortedAcademy(aMultipleSortedAcademy);
    if (!didAddMultipleSortedAcademy)
    {
      throw new RuntimeException("Unable to create multipleSortedCourse due to multipleSortedAcademy");
    }
    multipleSortedRegistrations = new ArrayList<MultipleSortedRegistration>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    code = aCode;
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

  public String getCode()
  {
    return code;
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
      existingMultipleSortedAcademy.removeMultipleSortedCourse(this);
    }
    multipleSortedAcademy.addMultipleSortedCourse(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfMultipleSortedRegistrations()
  {
    return 0;
  }

  public MultipleSortedRegistration addMultipleSortedRegistration(MultipleSortedStudent aMultipleSortedStudent)
  {
    return new MultipleSortedRegistration(this, aMultipleSortedStudent);
  }

  public boolean addMultipleSortedRegistration(MultipleSortedRegistration aMultipleSortedRegistration)
  {
    boolean wasAdded = false;
    if (multipleSortedRegistrations.contains(aMultipleSortedRegistration)) { return false; }
    MultipleSortedCourse existingMultipleSortedCourse = aMultipleSortedRegistration.getMultipleSortedCourse();
    boolean isNewMultipleSortedCourse = existingMultipleSortedCourse != null && !this.equals(existingMultipleSortedCourse);
    if (isNewMultipleSortedCourse)
    {
      aMultipleSortedRegistration.setMultipleSortedCourse(this);
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
    //Unable to remove aMultipleSortedRegistration, as it must always have a multipleSortedCourse
    if (!this.equals(aMultipleSortedRegistration.getMultipleSortedCourse()))
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
    placeholderMultipleSortedAcademy.removeMultipleSortedCourse(this);
    for(int i=multipleSortedRegistrations.size(); i > 0; i--)
    {
      MultipleSortedRegistration aMultipleSortedRegistration = multipleSortedRegistrations.get(i - 1);
      aMultipleSortedRegistration.delete();
    }
  }

}