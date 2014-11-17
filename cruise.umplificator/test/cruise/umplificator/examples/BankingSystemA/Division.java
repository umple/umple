/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 81 "BankingSystemA.ump"
// line 140 "BankingSystemA.ump"
public class Division
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Division Attributes
  private String name;

  //Division Associations
  private List<Employee> employees;
  private List<Division> subDivision;
  private Division division;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Division(String aName)
  {
    name = aName;
    employees = new ArrayList<Employee>();
    subDivision = new ArrayList<Division>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Employee getEmployee(int index)
  {
    Employee aEmployee = employees.get(index);
    return aEmployee;
  }

  public List<Employee> getEmployees()
  {
    List<Employee> newEmployees = Collections.unmodifiableList(employees);
    return newEmployees;
  }

  public int numberOfEmployees()
  {
    int number = employees.size();
    return number;
  }

  public boolean hasEmployees()
  {
    boolean has = employees.size() > 0;
    return has;
  }

  public int indexOfEmployee(Employee aEmployee)
  {
    int index = employees.indexOf(aEmployee);
    return index;
  }

  public Division getSubDivision(int index)
  {
    Division aSubDivision = subDivision.get(index);
    return aSubDivision;
  }

  public List<Division> getSubDivision()
  {
    List<Division> newSubDivision = Collections.unmodifiableList(subDivision);
    return newSubDivision;
  }

  public int numberOfSubDivision()
  {
    int number = subDivision.size();
    return number;
  }

  public boolean hasSubDivision()
  {
    boolean has = subDivision.size() > 0;
    return has;
  }

  public int indexOfSubDivision(Division aSubDivision)
  {
    int index = subDivision.indexOf(aSubDivision);
    return index;
  }

  public Division getDivision()
  {
    return division;
  }

  public boolean hasDivision()
  {
    boolean has = division != null;
    return has;
  }

  public static int minimumNumberOfEmployees()
  {
    return 0;
  }

  public Employee addEmployee(Person aPerson)
  {
    return new Employee(aPerson, this);
  }

  public boolean addEmployee(Employee aEmployee)
  {
    boolean wasAdded = false;
    if (employees.contains(aEmployee)) { return false; }
    if (employees.contains(aEmployee)) { return false; }
    Division existingDivision = aEmployee.getDivision();
    boolean isNewDivision = existingDivision != null && !this.equals(existingDivision);
    if (isNewDivision)
    {
      aEmployee.setDivision(this);
    }
    else
    {
      employees.add(aEmployee);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEmployee(Employee aEmployee)
  {
    boolean wasRemoved = false;
    //Unable to remove aEmployee, as it must always have a division
    if (!this.equals(aEmployee.getDivision()))
    {
      employees.remove(aEmployee);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addEmployeeAt(Employee aEmployee, int index)
  {  
    boolean wasAdded = false;
    if(addEmployee(aEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
      employees.remove(aEmployee);
      employees.add(index, aEmployee);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEmployeeAt(Employee aEmployee, int index)
  {
    boolean wasAdded = false;
    if(employees.contains(aEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
      employees.remove(aEmployee);
      employees.add(index, aEmployee);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEmployeeAt(aEmployee, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfSubDivision()
  {
    return 0;
  }

  public boolean addSubDivision(Division aSubDivision)
  {
    boolean wasAdded = false;
    if (subDivision.contains(aSubDivision)) { return false; }
    if (subDivision.contains(aSubDivision)) { return false; }
    Division existingDivision = aSubDivision.getDivision();
    if (existingDivision == null)
    {
      aSubDivision.setDivision(this);
    }
    else if (!this.equals(existingDivision))
    {
      existingDivision.removeSubDivision(aSubDivision);
      addSubDivision(aSubDivision);
    }
    else
    {
      subDivision.add(aSubDivision);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSubDivision(Division aSubDivision)
  {
    boolean wasRemoved = false;
    if (subDivision.contains(aSubDivision))
    {
      subDivision.remove(aSubDivision);
      aSubDivision.setDivision(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSubDivisionAt(Division aSubDivision, int index)
  {  
    boolean wasAdded = false;
    if(addSubDivision(aSubDivision))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubDivision()) { index = numberOfSubDivision() - 1; }
      subDivision.remove(aSubDivision);
      subDivision.add(index, aSubDivision);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSubDivisionAt(Division aSubDivision, int index)
  {
    boolean wasAdded = false;
    if(subDivision.contains(aSubDivision))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubDivision()) { index = numberOfSubDivision() - 1; }
      subDivision.remove(aSubDivision);
      subDivision.add(index, aSubDivision);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSubDivisionAt(aSubDivision, index);
    }
    return wasAdded;
  }

  public boolean setDivision(Division aDivision)
  {
    boolean wasSet = false;
    Division existingDivision = division;
    division = aDivision;
    if (existingDivision != null && !existingDivision.equals(aDivision))
    {
      existingDivision.removeSubDivision(this);
    }
    if (aDivision != null)
    {
      aDivision.addSubDivision(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=employees.size(); i > 0; i--)
    {
      Employee aEmployee = employees.get(i - 1);
      aEmployee.delete();
    }
    while( !subDivision.isEmpty() )
    {
      subDivision.get(0).setDivision(null);
    }
    if (division != null)
    {
      Division placeholderDivision = division;
      this.division = null;
      placeholderDivision.removeSubDivision(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}