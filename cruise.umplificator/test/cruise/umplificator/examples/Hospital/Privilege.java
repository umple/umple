/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Various privileges and roles that the employees have.
 */
// line 38 "Hospital.ump"
// line 116 "Hospital.ump"
public class Privilege
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Privilege Attributes
  private String privilege;

  //Privilege Associations
  private Employee employee;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Privilege(String aPrivilege, Employee aEmployee)
  {
    privilege = aPrivilege;
    boolean didAddEmployee = setEmployee(aEmployee);
    if (!didAddEmployee)
    {
      throw new RuntimeException("Unable to create privilege due to employee");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPrivilege(String aPrivilege)
  {
    boolean wasSet = false;
    privilege = aPrivilege;
    wasSet = true;
    return wasSet;
  }

  public String getPrivilege()
  {
    return privilege;
  }

  public Employee getEmployee()
  {
    return employee;
  }

  public boolean setEmployee(Employee aEmployee)
  {
    boolean wasSet = false;
    //Must provide employee to privilege
    if (aEmployee == null)
    {
      return wasSet;
    }

    if (employee != null && employee.numberOfPrivileges() <= Employee.minimumNumberOfPrivileges())
    {
      return wasSet;
    }

    Employee existingEmployee = employee;
    employee = aEmployee;
    if (existingEmployee != null && !existingEmployee.equals(aEmployee))
    {
      boolean didRemove = existingEmployee.removePrivilege(this);
      if (!didRemove)
      {
        employee = existingEmployee;
        return wasSet;
      }
    }
    employee.addPrivilege(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Employee placeholderEmployee = employee;
    this.employee = null;
    placeholderEmployee.removePrivilege(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "privilege" + ":" + getPrivilege()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "employee = "+(getEmployee()!=null?Integer.toHexString(System.identityHashCode(getEmployee())):"null")
     + outputString;
  }
}