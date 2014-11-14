/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.sql.Time;

/**
 * Positioning
 */
// line 29 "Accidents.ump"
// line 45 "Accidents.ump"
public class Accident
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Accident Attributes
  private String id;
  private String description;
  private Date date;
  private Time time;
  private String other_details;

  //Accident Associations
  private Employee employee;
  private AccidentType accidentType;
  private SeriousnessLevel seriousnessLevel;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Accident(String aId, String aDescription, Date aDate, Time aTime, String aOther_details, Employee aEmployee, AccidentType aAccidentType, SeriousnessLevel aSeriousnessLevel)
  {
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    description = aDescription;
    date = aDate;
    time = aTime;
    other_details = aOther_details;
    boolean didAddEmployee = setEmployee(aEmployee);
    if (!didAddEmployee)
    {
      throw new RuntimeException("Unable to create accident due to employee");
    }
    if (!setAccidentType(aAccidentType))
    {
      throw new RuntimeException("Unable to create Accident due to aAccidentType");
    }
    if (!setSeriousnessLevel(aSeriousnessLevel))
    {
      throw new RuntimeException("Unable to create Accident due to aSeriousnessLevel");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    if (!canSetId) { return false; }
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(Time aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setOther_details(String aOther_details)
  {
    boolean wasSet = false;
    other_details = aOther_details;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getDescription()
  {
    return description;
  }

  public Date getDate()
  {
    return date;
  }

  public Time getTime()
  {
    return time;
  }

  public String getOther_details()
  {
    return other_details;
  }

  public Employee getEmployee()
  {
    return employee;
  }

  public AccidentType getAccidentType()
  {
    return accidentType;
  }

  public SeriousnessLevel getSeriousnessLevel()
  {
    return seriousnessLevel;
  }

  public boolean setEmployee(Employee aEmployee)
  {
    boolean wasSet = false;
    if (aEmployee == null)
    {
      return wasSet;
    }

    Employee existingEmployee = employee;
    employee = aEmployee;
    if (existingEmployee != null && !existingEmployee.equals(aEmployee))
    {
      existingEmployee.removeAccident(this);
    }
    employee.addAccident(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setAccidentType(AccidentType aNewAccidentType)
  {
    boolean wasSet = false;
    if (aNewAccidentType != null)
    {
      accidentType = aNewAccidentType;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setSeriousnessLevel(SeriousnessLevel aNewSeriousnessLevel)
  {
    boolean wasSet = false;
    if (aNewSeriousnessLevel != null)
    {
      seriousnessLevel = aNewSeriousnessLevel;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Accident compareTo = (Accident)obj;
  
    if (id == null && compareTo.id != null)
    {
      return false;
    }
    else if (id != null && !id.equals(compareTo.id))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (id != null)
    {
      cachedHashCode = cachedHashCode * 23 + id.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetId = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Employee placeholderEmployee = employee;
    this.employee = null;
    placeholderEmployee.removeAccident(this);
    accidentType = null;
    seriousnessLevel = null;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "description" + ":" + getDescription()+ "," +
            "other_details" + ":" + getOther_details()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "time" + "=" + (getTime() != null ? !getTime().equals(this)  ? getTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "employee = "+(getEmployee()!=null?Integer.toHexString(System.identityHashCode(getEmployee())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "accidentType = "+(getAccidentType()!=null?Integer.toHexString(System.identityHashCode(getAccidentType())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "seriousnessLevel = "+(getSeriousnessLevel()!=null?Integer.toHexString(System.identityHashCode(getSeriousnessLevel())):"null")
     + outputString;
  }
}