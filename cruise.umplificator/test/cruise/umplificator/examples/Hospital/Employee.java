/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * The people who work at the hospital.
 */
// line 20 "Hospital.ump"
// line 75 "Hospital.ump"
public class Employee
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Attributes
  private String name;
  private int id;
  private int salary;

  //Employee Associations
  private List<Shift> shifts;
  private List<Privilege> privileges;
  private Hospital hospital;
  private List<Ward> wards;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(String aName, int aId, int aSalary, Hospital aHospital, Ward... allWards)
  {
    name = aName;
    id = aId;
    salary = aSalary;
    shifts = new ArrayList<Shift>();
    privileges = new ArrayList<Privilege>();
    boolean didAddHospital = setHospital(aHospital);
    if (!didAddHospital)
    {
      throw new RuntimeException("Unable to create employee due to hospital");
    }
    wards = new ArrayList<Ward>();
    boolean didAddWards = setWards(allWards);
    if (!didAddWards)
    {
      throw new RuntimeException("Unable to create Employee, must have at least 1 wards");
    }
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

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setSalary(int aSalary)
  {
    boolean wasSet = false;
    salary = aSalary;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getId()
  {
    return id;
  }

  public int getSalary()
  {
    return salary;
  }

  public Shift getShift(int index)
  {
    Shift aShift = shifts.get(index);
    return aShift;
  }

  public List<Shift> getShifts()
  {
    List<Shift> newShifts = Collections.unmodifiableList(shifts);
    return newShifts;
  }

  public int numberOfShifts()
  {
    int number = shifts.size();
    return number;
  }

  public boolean hasShifts()
  {
    boolean has = shifts.size() > 0;
    return has;
  }

  public int indexOfShift(Shift aShift)
  {
    int index = shifts.indexOf(aShift);
    return index;
  }

  public Privilege getPrivilege(int index)
  {
    Privilege aPrivilege = privileges.get(index);
    return aPrivilege;
  }

  public List<Privilege> getPrivileges()
  {
    List<Privilege> newPrivileges = Collections.unmodifiableList(privileges);
    return newPrivileges;
  }

  public int numberOfPrivileges()
  {
    int number = privileges.size();
    return number;
  }

  public boolean hasPrivileges()
  {
    boolean has = privileges.size() > 0;
    return has;
  }

  public int indexOfPrivilege(Privilege aPrivilege)
  {
    int index = privileges.indexOf(aPrivilege);
    return index;
  }

  public Hospital getHospital()
  {
    return hospital;
  }

  public Ward getWard(int index)
  {
    Ward aWard = wards.get(index);
    return aWard;
  }

  public List<Ward> getWards()
  {
    List<Ward> newWards = Collections.unmodifiableList(wards);
    return newWards;
  }

  public int numberOfWards()
  {
    int number = wards.size();
    return number;
  }

  public boolean hasWards()
  {
    boolean has = wards.size() > 0;
    return has;
  }

  public int indexOfWard(Ward aWard)
  {
    int index = wards.indexOf(aWard);
    return index;
  }

  public boolean isNumberOfShiftsValid()
  {
    boolean isValid = numberOfShifts() >= minimumNumberOfShifts();
    return isValid;
  }

  public static int minimumNumberOfShifts()
  {
    return 1;
  }

  public Shift addShift(Date aDate, int aStartTime, int aEndTime)
  {
    Shift aNewShift = new Shift(aDate, aStartTime, aEndTime, this);
    return aNewShift;
  }

  public boolean addShift(Shift aShift)
  {
    boolean wasAdded = false;
    if (shifts.contains(aShift)) { return false; }
    if (shifts.contains(aShift)) { return false; }
    if (shifts.contains(aShift)) { return false; }
    Employee existingEmployee = aShift.getEmployee();
    boolean isNewEmployee = existingEmployee != null && !this.equals(existingEmployee);

    if (isNewEmployee && existingEmployee.numberOfShifts() <= minimumNumberOfShifts())
    {
      return wasAdded;
    }
    if (isNewEmployee)
    {
      aShift.setEmployee(this);
    }
    else
    {
      shifts.add(aShift);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeShift(Shift aShift)
  {
    boolean wasRemoved = false;
    //Unable to remove aShift, as it must always have a employee
    if (this.equals(aShift.getEmployee()))
    {
      return wasRemoved;
    }

    //employee already at minimum (1)
    if (numberOfShifts() <= minimumNumberOfShifts())
    {
      return wasRemoved;
    }

    shifts.remove(aShift);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean addShiftAt(Shift aShift, int index)
  {  
    boolean wasAdded = false;
    if(addShift(aShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShifts()) { index = numberOfShifts() - 1; }
      shifts.remove(aShift);
      shifts.add(index, aShift);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveShiftAt(Shift aShift, int index)
  {
    boolean wasAdded = false;
    if(shifts.contains(aShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShifts()) { index = numberOfShifts() - 1; }
      shifts.remove(aShift);
      shifts.add(index, aShift);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addShiftAt(aShift, index);
    }
    return wasAdded;
  }

  public boolean isNumberOfPrivilegesValid()
  {
    boolean isValid = numberOfPrivileges() >= minimumNumberOfPrivileges();
    return isValid;
  }

  public static int minimumNumberOfPrivileges()
  {
    return 1;
  }

  public Privilege addPrivilege(String aPrivilege)
  {
    Privilege aNewPrivilege = new Privilege(aPrivilege, this);
    return aNewPrivilege;
  }

  public boolean addPrivilege(Privilege aPrivilege)
  {
    boolean wasAdded = false;
    if (privileges.contains(aPrivilege)) { return false; }
    if (privileges.contains(aPrivilege)) { return false; }
    if (privileges.contains(aPrivilege)) { return false; }
    Employee existingEmployee = aPrivilege.getEmployee();
    boolean isNewEmployee = existingEmployee != null && !this.equals(existingEmployee);

    if (isNewEmployee && existingEmployee.numberOfPrivileges() <= minimumNumberOfPrivileges())
    {
      return wasAdded;
    }
    if (isNewEmployee)
    {
      aPrivilege.setEmployee(this);
    }
    else
    {
      privileges.add(aPrivilege);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePrivilege(Privilege aPrivilege)
  {
    boolean wasRemoved = false;
    //Unable to remove aPrivilege, as it must always have a employee
    if (this.equals(aPrivilege.getEmployee()))
    {
      return wasRemoved;
    }

    //employee already at minimum (1)
    if (numberOfPrivileges() <= minimumNumberOfPrivileges())
    {
      return wasRemoved;
    }

    privileges.remove(aPrivilege);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean addPrivilegeAt(Privilege aPrivilege, int index)
  {  
    boolean wasAdded = false;
    if(addPrivilege(aPrivilege))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPrivileges()) { index = numberOfPrivileges() - 1; }
      privileges.remove(aPrivilege);
      privileges.add(index, aPrivilege);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePrivilegeAt(Privilege aPrivilege, int index)
  {
    boolean wasAdded = false;
    if(privileges.contains(aPrivilege))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPrivileges()) { index = numberOfPrivileges() - 1; }
      privileges.remove(aPrivilege);
      privileges.add(index, aPrivilege);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPrivilegeAt(aPrivilege, index);
    }
    return wasAdded;
  }

  public boolean setHospital(Hospital aHospital)
  {
    boolean wasSet = false;
    if (aHospital == null)
    {
      return wasSet;
    }

    Hospital existingHospital = hospital;
    hospital = aHospital;
    if (existingHospital != null && !existingHospital.equals(aHospital))
    {
      existingHospital.removeEmployee(this);
    }
    hospital.addEmployee(this);
    wasSet = true;
    return wasSet;
  }

  public boolean isNumberOfWardsValid()
  {
    boolean isValid = numberOfWards() >= minimumNumberOfWards();
    return isValid;
  }

  public static int minimumNumberOfWards()
  {
    return 1;
  }

  public boolean addWard(Ward aWard)
  {
    boolean wasAdded = false;
    if (wards.contains(aWard)) { return false; }
    if (wards.contains(aWard)) { return false; }
    if (wards.contains(aWard)) { return false; }
    wards.add(aWard);
    if (aWard.indexOfEmployee(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aWard.addEmployee(this);
      if (!wasAdded)
      {
        wards.remove(aWard);
      }
    }
    return wasAdded;
  }

  public boolean removeWard(Ward aWard)
  {
    boolean wasRemoved = false;
    if (!wards.contains(aWard))
    {
      return wasRemoved;
    }

    if (numberOfWards() <= minimumNumberOfWards())
    {
      return wasRemoved;
    }

    int oldIndex = wards.indexOf(aWard);
    wards.remove(oldIndex);
    if (aWard.indexOfEmployee(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aWard.removeEmployee(this);
      if (!wasRemoved)
      {
        wards.add(oldIndex,aWard);
      }
    }
    return wasRemoved;
  }

  public boolean setWards(Ward... newWards)
  {
    boolean wasSet = false;
    ArrayList<Ward> verifiedWards = new ArrayList<Ward>();
    for (Ward aWard : newWards)
    {
      if (verifiedWards.contains(aWard))
      {
        continue;
      }
      verifiedWards.add(aWard);
    }

    if (verifiedWards.size() != newWards.length || verifiedWards.size() < minimumNumberOfWards())
    {
      return wasSet;
    }

    ArrayList<Ward> oldWards = new ArrayList<Ward>(wards);
    wards.clear();
    for (Ward aNewWard : verifiedWards)
    {
      wards.add(aNewWard);
      if (oldWards.contains(aNewWard))
      {
        oldWards.remove(aNewWard);
      }
      else
      {
        aNewWard.addEmployee(this);
      }
    }

    for (Ward anOldWard : oldWards)
    {
      anOldWard.removeEmployee(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addWardAt(Ward aWard, int index)
  {  
    boolean wasAdded = false;
    if(addWard(aWard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWards()) { index = numberOfWards() - 1; }
      wards.remove(aWard);
      wards.add(index, aWard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWardAt(Ward aWard, int index)
  {
    boolean wasAdded = false;
    if(wards.contains(aWard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWards()) { index = numberOfWards() - 1; }
      wards.remove(aWard);
      wards.add(index, aWard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWardAt(aWard, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=shifts.size(); i > 0; i--)
    {
      Shift aShift = shifts.get(i - 1);
      aShift.delete();
    }
    for(int i=privileges.size(); i > 0; i--)
    {
      Privilege aPrivilege = privileges.get(i - 1);
      aPrivilege.delete();
    }
    Hospital placeholderHospital = hospital;
    this.hospital = null;
    placeholderHospital.removeEmployee(this);
    ArrayList<Ward> copyOfWards = new ArrayList<Ward>(wards);
    wards.clear();
    for(Ward aWard : copyOfWards)
    {
      aWard.removeEmployee(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "id" + ":" + getId()+ "," +
            "salary" + ":" + getSalary()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hospital = "+(getHospital()!=null?Integer.toHexString(System.identityHashCode(getHospital())):"null")
     + outputString;
  }
}