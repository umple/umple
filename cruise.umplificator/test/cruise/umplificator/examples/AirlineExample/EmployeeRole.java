/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 31 "AirlineExample.ump"
// line 80 "AirlineExample.ump"
public class EmployeeRole extends PersonRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EmployeeRole Attributes
  private String jobFunction;

  //EmployeeRole Associations
  private EmployeeRole supervisor;
  private List<SpecificFlight> specificFlights;
  private List<EmployeeRole> employeeRoles;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EmployeeRole(Person aPerson, String aJobFunction)
  {
    super(aPerson);
    jobFunction = aJobFunction;
    specificFlights = new ArrayList<SpecificFlight>();
    employeeRoles = new ArrayList<EmployeeRole>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setJobFunction(String aJobFunction)
  {
    boolean wasSet = false;
    jobFunction = aJobFunction;
    wasSet = true;
    return wasSet;
  }

  public String getJobFunction()
  {
    return jobFunction;
  }

  public EmployeeRole getSupervisor()
  {
    return supervisor;
  }

  public boolean hasSupervisor()
  {
    boolean has = supervisor != null;
    return has;
  }

  public SpecificFlight getSpecificFlight(int index)
  {
    SpecificFlight aSpecificFlight = specificFlights.get(index);
    return aSpecificFlight;
  }

  public List<SpecificFlight> getSpecificFlights()
  {
    List<SpecificFlight> newSpecificFlights = Collections.unmodifiableList(specificFlights);
    return newSpecificFlights;
  }

  public int numberOfSpecificFlights()
  {
    int number = specificFlights.size();
    return number;
  }

  public boolean hasSpecificFlights()
  {
    boolean has = specificFlights.size() > 0;
    return has;
  }

  public int indexOfSpecificFlight(SpecificFlight aSpecificFlight)
  {
    int index = specificFlights.indexOf(aSpecificFlight);
    return index;
  }

  public EmployeeRole getEmployeeRole(int index)
  {
    EmployeeRole aEmployeeRole = employeeRoles.get(index);
    return aEmployeeRole;
  }

  public List<EmployeeRole> getEmployeeRoles()
  {
    List<EmployeeRole> newEmployeeRoles = Collections.unmodifiableList(employeeRoles);
    return newEmployeeRoles;
  }

  public int numberOfEmployeeRoles()
  {
    int number = employeeRoles.size();
    return number;
  }

  public boolean hasEmployeeRoles()
  {
    boolean has = employeeRoles.size() > 0;
    return has;
  }

  public int indexOfEmployeeRole(EmployeeRole aEmployeeRole)
  {
    int index = employeeRoles.indexOf(aEmployeeRole);
    return index;
  }

  public boolean setSupervisor(EmployeeRole aSupervisor)
  {
    boolean wasSet = false;
    EmployeeRole existingSupervisor = supervisor;
    supervisor = aSupervisor;
    if (existingSupervisor != null && !existingSupervisor.equals(aSupervisor))
    {
      existingSupervisor.removeEmployeeRole(this);
    }
    if (aSupervisor != null)
    {
      aSupervisor.addEmployeeRole(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfSpecificFlights()
  {
    return 0;
  }

  public boolean addSpecificFlight(SpecificFlight aSpecificFlight)
  {
    boolean wasAdded = false;
    if (specificFlights.contains(aSpecificFlight)) { return false; }
    specificFlights.add(aSpecificFlight);
    if (aSpecificFlight.indexOfEmployeeRole(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSpecificFlight.addEmployeeRole(this);
      if (!wasAdded)
      {
        specificFlights.remove(aSpecificFlight);
      }
    }
    return wasAdded;
  }

  public boolean removeSpecificFlight(SpecificFlight aSpecificFlight)
  {
    boolean wasRemoved = false;
    if (!specificFlights.contains(aSpecificFlight))
    {
      return wasRemoved;
    }

    int oldIndex = specificFlights.indexOf(aSpecificFlight);
    specificFlights.remove(oldIndex);
    if (aSpecificFlight.indexOfEmployeeRole(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSpecificFlight.removeEmployeeRole(this);
      if (!wasRemoved)
      {
        specificFlights.add(oldIndex,aSpecificFlight);
      }
    }
    return wasRemoved;
  }

  public boolean addSpecificFlightAt(SpecificFlight aSpecificFlight, int index)
  {  
    boolean wasAdded = false;
    if(addSpecificFlight(aSpecificFlight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpecificFlights()) { index = numberOfSpecificFlights() - 1; }
      specificFlights.remove(aSpecificFlight);
      specificFlights.add(index, aSpecificFlight);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSpecificFlightAt(SpecificFlight aSpecificFlight, int index)
  {
    boolean wasAdded = false;
    if(specificFlights.contains(aSpecificFlight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpecificFlights()) { index = numberOfSpecificFlights() - 1; }
      specificFlights.remove(aSpecificFlight);
      specificFlights.add(index, aSpecificFlight);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSpecificFlightAt(aSpecificFlight, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfEmployeeRoles()
  {
    return 0;
  }

  public boolean addEmployeeRole(EmployeeRole aEmployeeRole)
  {
    boolean wasAdded = false;
    if (employeeRoles.contains(aEmployeeRole)) { return false; }
    EmployeeRole existingSupervisor = aEmployeeRole.getSupervisor();
    if (existingSupervisor == null)
    {
      aEmployeeRole.setSupervisor(this);
    }
    else if (!this.equals(existingSupervisor))
    {
      existingSupervisor.removeEmployeeRole(aEmployeeRole);
      addEmployeeRole(aEmployeeRole);
    }
    else
    {
      employeeRoles.add(aEmployeeRole);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEmployeeRole(EmployeeRole aEmployeeRole)
  {
    boolean wasRemoved = false;
    if (employeeRoles.contains(aEmployeeRole))
    {
      employeeRoles.remove(aEmployeeRole);
      aEmployeeRole.setSupervisor(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addEmployeeRoleAt(EmployeeRole aEmployeeRole, int index)
  {  
    boolean wasAdded = false;
    if(addEmployeeRole(aEmployeeRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployeeRoles()) { index = numberOfEmployeeRoles() - 1; }
      employeeRoles.remove(aEmployeeRole);
      employeeRoles.add(index, aEmployeeRole);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEmployeeRoleAt(EmployeeRole aEmployeeRole, int index)
  {
    boolean wasAdded = false;
    if(employeeRoles.contains(aEmployeeRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployeeRoles()) { index = numberOfEmployeeRoles() - 1; }
      employeeRoles.remove(aEmployeeRole);
      employeeRoles.add(index, aEmployeeRole);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEmployeeRoleAt(aEmployeeRole, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    if (supervisor != null)
    {
      EmployeeRole placeholderSupervisor = supervisor;
      this.supervisor = null;
      placeholderSupervisor.removeEmployeeRole(this);
    }
    ArrayList<SpecificFlight> copyOfSpecificFlights = new ArrayList<SpecificFlight>(specificFlights);
    specificFlights.clear();
    for(SpecificFlight aSpecificFlight : copyOfSpecificFlights)
    {
      aSpecificFlight.removeEmployeeRole(this);
    }
    while( !employeeRoles.isEmpty() )
    {
      employeeRoles.get(0).setSupervisor(null);
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "jobFunction" + ":" + getJobFunction()+ "]"
     + outputString;
  }
}