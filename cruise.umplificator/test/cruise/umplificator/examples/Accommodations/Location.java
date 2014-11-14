/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Positioning
 */
// line 12 "Accommodations.ump"
// line 106 "Accommodations.ump"
public class Location
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Location Attributes
  private int id;
  private String short_name;
  private String full_name;
  private String description;
  private String address;
  private String manager;
  private String phone;
  private String other_location_details;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Location(int aId, String aShort_name, String aFull_name, String aDescription, String aAddress, String aManager, String aPhone, String aOther_location_details)
  {
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    short_name = aShort_name;
    full_name = aFull_name;
    description = aDescription;
    address = aAddress;
    manager = aManager;
    phone = aPhone;
    other_location_details = aOther_location_details;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    if (!canSetId) { return false; }
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setShort_name(String aShort_name)
  {
    boolean wasSet = false;
    short_name = aShort_name;
    wasSet = true;
    return wasSet;
  }

  public boolean setFull_name(String aFull_name)
  {
    boolean wasSet = false;
    full_name = aFull_name;
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

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setManager(String aManager)
  {
    boolean wasSet = false;
    manager = aManager;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhone(String aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

  public boolean setOther_location_details(String aOther_location_details)
  {
    boolean wasSet = false;
    other_location_details = aOther_location_details;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getShort_name()
  {
    return short_name;
  }

  public String getFull_name()
  {
    return full_name;
  }

  public String getDescription()
  {
    return description;
  }

  public String getAddress()
  {
    return address;
  }

  public String getManager()
  {
    return manager;
  }

  public String getPhone()
  {
    return phone;
  }

  public String getOther_location_details()
  {
    return other_location_details;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Location compareTo = (Location)obj;
  
    if (id != compareTo.id)
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
    cachedHashCode = cachedHashCode * 23 + id;

    canSetId = false;
    return cachedHashCode;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "short_name" + ":" + getShort_name()+ "," +
            "full_name" + ":" + getFull_name()+ "," +
            "description" + ":" + getDescription()+ "," +
            "address" + ":" + getAddress()+ "," +
            "manager" + ":" + getManager()+ "," +
            "phone" + ":" + getPhone()+ "," +
            "other_location_details" + ":" + getOther_location_details()+ "]"
     + outputString;
  }
}