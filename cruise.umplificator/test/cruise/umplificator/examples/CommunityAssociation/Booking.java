/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.sql.Time;

// line 39 "CommunityAssociation.ump"
// line 94 "CommunityAssociation.ump"
public class Booking
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Booking Attributes
  private Date date;
  private Time startTime;
  private Time endTime;
  private float feePaid;
  private boolean isReservedForFCFS;

  //Booking Associations
  private Resident resident;
  private Facility facility;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Booking(Date aDate, Time aStartTime, Time aEndTime, float aFeePaid, boolean aIsReservedForFCFS, Facility aFacility)
  {
    date = aDate;
    startTime = aStartTime;
    endTime = aEndTime;
    feePaid = aFeePaid;
    isReservedForFCFS = aIsReservedForFCFS;
    boolean didAddFacility = setFacility(aFacility);
    if (!didAddFacility)
    {
      throw new RuntimeException("Unable to create booked due to facility");
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

  public boolean setStartTime(Time aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(Time aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setFeePaid(float aFeePaid)
  {
    boolean wasSet = false;
    feePaid = aFeePaid;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsReservedForFCFS(boolean aIsReservedForFCFS)
  {
    boolean wasSet = false;
    isReservedForFCFS = aIsReservedForFCFS;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public Time getStartTime()
  {
    return startTime;
  }

  public Time getEndTime()
  {
    return endTime;
  }

  public float getFeePaid()
  {
    return feePaid;
  }

  public boolean getIsReservedForFCFS()
  {
    return isReservedForFCFS;
  }

  public boolean isIsReservedForFCFS()
  {
    return isReservedForFCFS;
  }

  public Resident getResident()
  {
    return resident;
  }

  public boolean hasResident()
  {
    boolean has = resident != null;
    return has;
  }

  public Facility getFacility()
  {
    return facility;
  }

  public boolean setResident(Resident aResident)
  {
    boolean wasSet = false;
    Resident existingResident = resident;
    resident = aResident;
    if (existingResident != null && !existingResident.equals(aResident))
    {
      existingResident.removeBooking(this);
    }
    if (aResident != null)
    {
      aResident.addBooking(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setFacility(Facility aFacility)
  {
    boolean wasSet = false;
    if (aFacility == null)
    {
      return wasSet;
    }

    Facility existingFacility = facility;
    facility = aFacility;
    if (existingFacility != null && !existingFacility.equals(aFacility))
    {
      existingFacility.removeBooked(this);
    }
    facility.addBooked(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (resident != null)
    {
      Resident placeholderResident = resident;
      this.resident = null;
      placeholderResident.removeBooking(this);
    }
    Facility placeholderFacility = facility;
    this.facility = null;
    placeholderFacility.removeBooked(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "feePaid" + ":" + getFeePaid()+ "," +
            "isReservedForFCFS" + ":" + getIsReservedForFCFS()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "startTime" + "=" + (getStartTime() != null ? !getStartTime().equals(this)  ? getStartTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endTime" + "=" + (getEndTime() != null ? !getEndTime().equals(this)  ? getEndTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "resident = "+(getResident()!=null?Integer.toHexString(System.identityHashCode(getResident())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "facility = "+(getFacility()!=null?Integer.toHexString(System.identityHashCode(getFacility())):"null")
     + outputString;
  }
}