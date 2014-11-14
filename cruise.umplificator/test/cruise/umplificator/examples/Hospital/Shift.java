/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;

/**
 * Working shifts that the employees have.
 */
// line 30 "Hospital.ump"
// line 111 "Hospital.ump"
public class Shift
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Shift Attributes
  private Date date;
  private int startTime;
  private int endTime;

  //Shift Associations
  private Employee employee;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Shift(Date aDate, int aStartTime, int aEndTime, Employee aEmployee)
  {
    date = aDate;
    startTime = aStartTime;
    endTime = aEndTime;
    boolean didAddEmployee = setEmployee(aEmployee);
    if (!didAddEmployee)
    {
      throw new RuntimeException("Unable to create shift due to employee");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartTime(int aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(int aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public int getStartTime()
  {
    return startTime;
  }

  public int getEndTime()
  {
    return endTime;
  }

  public Employee getEmployee()
  {
    return employee;
  }

  public boolean setEmployee(Employee aEmployee)
  {
    boolean wasSet = false;
    //Must provide employee to shift
    if (aEmployee == null)
    {
      return wasSet;
    }

    if (employee != null && employee.numberOfShifts() <= Employee.minimumNumberOfShifts())
    {
      return wasSet;
    }

    Employee existingEmployee = employee;
    employee = aEmployee;
    if (existingEmployee != null && !existingEmployee.equals(aEmployee))
    {
      boolean didRemove = existingEmployee.removeShift(this);
      if (!didRemove)
      {
        employee = existingEmployee;
        return wasSet;
      }
    }
    employee.addShift(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Employee placeholderEmployee = employee;
    this.employee = null;
    placeholderEmployee.removeShift(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "startTime" + ":" + getStartTime()+ "," +
            "endTime" + ":" + getEndTime()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "employee = "+(getEmployee()!=null?Integer.toHexString(System.identityHashCode(getEmployee())):"null")
     + outputString;
  }
}