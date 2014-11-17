/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 16 "BankSystem.ump"
public class Employee extends PersonRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Associations
  private Manager manager;
  private Division division;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(Person aPerson, Division aDivision)
  {
    super(aPerson);
    boolean didAddDivision = setDivision(aDivision);
    if (!didAddDivision)
    {
      throw new RuntimeException("Unable to create employee due to division");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Manager getManager()
  {
    return manager;
  }

  public boolean hasManager()
  {
    boolean has = manager != null;
    return has;
  }

  public Division getDivision()
  {
    return division;
  }

  public boolean setManager(Manager aManager)
  {
    boolean wasSet = false;
    Manager existingManager = manager;
    manager = aManager;
    if (existingManager != null && !existingManager.equals(aManager))
    {
      existingManager.removeEmployee(this);
    }
    if (aManager != null)
    {
      aManager.addEmployee(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setDivision(Division aDivision)
  {
    boolean wasSet = false;
    if (aDivision == null)
    {
      return wasSet;
    }

    Division existingDivision = division;
    division = aDivision;
    if (existingDivision != null && !existingDivision.equals(aDivision))
    {
      existingDivision.removeEmployee(this);
    }
    division.addEmployee(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (manager != null)
    {
      Manager placeholderManager = manager;
      this.manager = null;
      placeholderManager.removeEmployee(this);
    }
    Division placeholderDivision = division;
    this.division = null;
    placeholderDivision.removeEmployee(this);
    super.delete();
  }

}