/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 50 "AccessControl.ump"
// line 88 "AccessControl.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private int id;
  private String first_name;
  private String last_name;
  private String password;
  private String other_details;

  //User Associations
  private Role role;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(int aId, String aFirst_name, String aLast_name, String aPassword, String aOther_details)
  {
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    first_name = aFirst_name;
    last_name = aLast_name;
    password = aPassword;
    other_details = aOther_details;
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

  public boolean setFirst_name(String aFirst_name)
  {
    boolean wasSet = false;
    first_name = aFirst_name;
    wasSet = true;
    return wasSet;
  }

  public boolean setLast_name(String aLast_name)
  {
    boolean wasSet = false;
    last_name = aLast_name;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
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

  public int getId()
  {
    return id;
  }

  public String getFirst_name()
  {
    return first_name;
  }

  public String getLast_name()
  {
    return last_name;
  }

  public String getPassword()
  {
    return password;
  }

  public String getOther_details()
  {
    return other_details;
  }

  public Role getRole()
  {
    return role;
  }

  public boolean hasRole()
  {
    boolean has = role != null;
    return has;
  }

  public boolean setRole(Role aNewRole)
  {
    boolean wasSet = false;
    role = aNewRole;
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    User compareTo = (User)obj;
  
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
  {
    role = null;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "first_name" + ":" + getFirst_name()+ "," +
            "last_name" + ":" + getLast_name()+ "," +
            "password" + ":" + getPassword()+ "," +
            "other_details" + ":" + getOther_details()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "role = "+(getRole()!=null?Integer.toHexString(System.identityHashCode(getRole())):"null")
     + outputString;
  }
}