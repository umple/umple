/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.util.*;

// line 19 "AirlineExample.ump"
// line 95 "AirlineExample.ump"
public class SpecificFlight
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<Date, SpecificFlight> specificflightsByDate = new HashMap<Date, SpecificFlight>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SpecificFlight Attributes
  private Date date;

  //SpecificFlight Associations
  private RegularFlight regularFlight;
  private List<EmployeeRole> employeeRoles;
  private List<Booking> bookings;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SpecificFlight(Date aDate, RegularFlight aRegularFlight)
  {
    if (!setDate(aDate))
    {
      throw new RuntimeException("Cannot create due to duplicate date");
    }
    boolean didAddRegularFlight = setRegularFlight(aRegularFlight);
    if (!didAddRegularFlight)
    {
      throw new RuntimeException("Unable to create specificFlight due to regularFlight");
    }
    employeeRoles = new ArrayList<EmployeeRole>();
    bookings = new ArrayList<Booking>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    Date anOldDate = getDate();
    if (hasWithDate(aDate)) {
      return wasSet;
    }
    date = aDate;
    wasSet = true;
    if (anOldDate != null) {
      specificflightsByDate.remove(anOldDate);
    }
    specificflightsByDate.put(aDate, this);
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public static SpecificFlight getWithDate(Date aDate)
  {
    return specificflightsByDate.get(aDate);
  }

  public static boolean hasWithDate(Date aDate)
  {
    return getWithDate(aDate) != null;
  }

  public RegularFlight getRegularFlight()
  {
    return regularFlight;
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

  public Booking getBooking(int index)
  {
    Booking aBooking = bookings.get(index);
    return aBooking;
  }

  public List<Booking> getBookings()
  {
    List<Booking> newBookings = Collections.unmodifiableList(bookings);
    return newBookings;
  }

  public int numberOfBookings()
  {
    int number = bookings.size();
    return number;
  }

  public boolean hasBookings()
  {
    boolean has = bookings.size() > 0;
    return has;
  }

  public int indexOfBooking(Booking aBooking)
  {
    int index = bookings.indexOf(aBooking);
    return index;
  }

  public boolean setRegularFlight(RegularFlight aRegularFlight)
  {
    boolean wasSet = false;
    if (aRegularFlight == null)
    {
      return wasSet;
    }

    RegularFlight existingRegularFlight = regularFlight;
    regularFlight = aRegularFlight;
    if (existingRegularFlight != null && !existingRegularFlight.equals(aRegularFlight))
    {
      existingRegularFlight.removeSpecificFlight(this);
    }
    regularFlight.addSpecificFlight(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfEmployeeRoles()
  {
    return 0;
  }

  public boolean addEmployeeRole(EmployeeRole aEmployeeRole)
  {
    boolean wasAdded = false;
    if (employeeRoles.contains(aEmployeeRole)) { return false; }
    employeeRoles.add(aEmployeeRole);
    if (aEmployeeRole.indexOfSpecificFlight(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEmployeeRole.addSpecificFlight(this);
      if (!wasAdded)
      {
        employeeRoles.remove(aEmployeeRole);
      }
    }
    return wasAdded;
  }

  public boolean removeEmployeeRole(EmployeeRole aEmployeeRole)
  {
    boolean wasRemoved = false;
    if (!employeeRoles.contains(aEmployeeRole))
    {
      return wasRemoved;
    }

    int oldIndex = employeeRoles.indexOf(aEmployeeRole);
    employeeRoles.remove(oldIndex);
    if (aEmployeeRole.indexOfSpecificFlight(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEmployeeRole.removeSpecificFlight(this);
      if (!wasRemoved)
      {
        employeeRoles.add(oldIndex,aEmployeeRole);
      }
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

  public static int minimumNumberOfBookings()
  {
    return 0;
  }

  public Booking addBooking(String aSeatNumber, PassengerRole aPassengerRole)
  {
    return new Booking(aSeatNumber, this, aPassengerRole);
  }

  public boolean addBooking(Booking aBooking)
  {
    boolean wasAdded = false;
    if (bookings.contains(aBooking)) { return false; }
    SpecificFlight existingSpecificFlight = aBooking.getSpecificFlight();
    boolean isNewSpecificFlight = existingSpecificFlight != null && !this.equals(existingSpecificFlight);
    if (isNewSpecificFlight)
    {
      aBooking.setSpecificFlight(this);
    }
    else
    {
      bookings.add(aBooking);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBooking(Booking aBooking)
  {
    boolean wasRemoved = false;
    //Unable to remove aBooking, as it must always have a specificFlight
    if (!this.equals(aBooking.getSpecificFlight()))
    {
      bookings.remove(aBooking);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addBookingAt(Booking aBooking, int index)
  {  
    boolean wasAdded = false;
    if(addBooking(aBooking))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBookings()) { index = numberOfBookings() - 1; }
      bookings.remove(aBooking);
      bookings.add(index, aBooking);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBookingAt(Booking aBooking, int index)
  {
    boolean wasAdded = false;
    if(bookings.contains(aBooking))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBookings()) { index = numberOfBookings() - 1; }
      bookings.remove(aBooking);
      bookings.add(index, aBooking);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBookingAt(aBooking, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    specificflightsByDate.remove(getDate());
    RegularFlight placeholderRegularFlight = regularFlight;
    this.regularFlight = null;
    placeholderRegularFlight.removeSpecificFlight(this);
    ArrayList<EmployeeRole> copyOfEmployeeRoles = new ArrayList<EmployeeRole>(employeeRoles);
    employeeRoles.clear();
    for(EmployeeRole aEmployeeRole : copyOfEmployeeRoles)
    {
      aEmployeeRole.removeSpecificFlight(this);
    }
    for(int i=bookings.size(); i > 0; i--)
    {
      Booking aBooking = bookings.get(i - 1);
      aBooking.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "regularFlight = "+(getRegularFlight()!=null?Integer.toHexString(System.identityHashCode(getRegularFlight())):"null")
     + outputString;
  }
}