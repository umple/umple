/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 20 "Accidents.ump"
// line 53 "Accidents.ump"
public class Employee
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Attributes
  private String id;
  private String department;
  private String name;
  private String supervisor;
  private String other_employee_details;

  //Employee Associations
  private List<Accident> accidents;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(String aId, String aDepartment, String aName, String aSupervisor, String aOther_employee_details)
  {
    id = aId;
    department = aDepartment;
    name = aName;
    supervisor = aSupervisor;
    other_employee_details = aOther_employee_details;
    accidents = new ArrayList<Accident>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDepartment(String aDepartment)
  {
    boolean wasSet = false;
    department = aDepartment;
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

  public boolean setSupervisor(String aSupervisor)
  {
    boolean wasSet = false;
    supervisor = aSupervisor;
    wasSet = true;
    return wasSet;
  }

  public boolean setOther_employee_details(String aOther_employee_details)
  {
    boolean wasSet = false;
    other_employee_details = aOther_employee_details;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getDepartment()
  {
    return department;
  }

  public String getName()
  {
    return name;
  }

  public String getSupervisor()
  {
    return supervisor;
  }

  public String getOther_employee_details()
  {
    return other_employee_details;
  }

  public Accident getAccident(int index)
  {
    Accident aAccident = accidents.get(index);
    return aAccident;
  }

  public List<Accident> getAccidents()
  {
    List<Accident> newAccidents = Collections.unmodifiableList(accidents);
    return newAccidents;
  }

  public int numberOfAccidents()
  {
    int number = accidents.size();
    return number;
  }

  public boolean hasAccidents()
  {
    boolean has = accidents.size() > 0;
    return has;
  }

  public int indexOfAccident(Accident aAccident)
  {
    int index = accidents.indexOf(aAccident);
    return index;
  }

  public static int minimumNumberOfAccidents()
  {
    return 0;
  }

  public Accident addAccident(String aId, String aDescription, Date aDate, Time aTime, String aOther_details, AccidentType aAccidentType, SeriousnessLevel aSeriousnessLevel)
  {
    return new Accident(aId, aDescription, aDate, aTime, aOther_details, this, aAccidentType, aSeriousnessLevel);
  }

  public boolean addAccident(Accident aAccident)
  {
    boolean wasAdded = false;
    if (accidents.contains(aAccident)) { return false; }
    Employee existingEmployee = aAccident.getEmployee();
    boolean isNewEmployee = existingEmployee != null && !this.equals(existingEmployee);
    if (isNewEmployee)
    {
      aAccident.setEmployee(this);
    }
    else
    {
      accidents.add(aAccident);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccident(Accident aAccident)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccident, as it must always have a employee
    if (!this.equals(aAccident.getEmployee()))
    {
      accidents.remove(aAccident);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAccidentAt(Accident aAccident, int index)
  {  
    boolean wasAdded = false;
    if(addAccident(aAccident))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccidents()) { index = numberOfAccidents() - 1; }
      accidents.remove(aAccident);
      accidents.add(index, aAccident);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccidentAt(Accident aAccident, int index)
  {
    boolean wasAdded = false;
    if(accidents.contains(aAccident))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccidents()) { index = numberOfAccidents() - 1; }
      accidents.remove(aAccident);
      accidents.add(index, aAccident);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccidentAt(aAccident, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=accidents.size(); i > 0; i--)
    {
      Accident aAccident = accidents.get(i - 1);
      aAccident.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "department" + ":" + getDepartment()+ "," +
            "name" + ":" + getName()+ "," +
            "supervisor" + ":" + getSupervisor()+ "," +
            "other_employee_details" + ":" + getOther_employee_details()+ "]"
     + outputString;
  }
}