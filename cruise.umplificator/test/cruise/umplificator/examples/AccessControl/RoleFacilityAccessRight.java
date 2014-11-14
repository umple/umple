/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 61 "AccessControl.ump"
// line 98 "AccessControl.ump"
public class RoleFacilityAccessRight
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RoleFacilityAccessRight State Machines
  enum CRUD_Value { R, RW }
  private CRUD_Value cRUD_Value;

  //RoleFacilityAccessRight Associations
  private Facility facility;
  private Role role;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetFacility;
  private boolean canSetRole;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RoleFacilityAccessRight(Facility aFacility, Role aRole)
  {
    cachedHashCode = -1;
    canSetFacility = true;
    canSetRole = true;
    boolean didAddFacility = setFacility(aFacility);
    if (!didAddFacility)
    {
      throw new RuntimeException("Unable to create roleFacilityAccessRight due to facility");
    }
    boolean didAddRole = setRole(aRole);
    if (!didAddRole)
    {
      throw new RuntimeException("Unable to create roleFacilityAccessRight due to role");
    }
    setCRUD_Value(CRUD_Value.R);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getCRUD_ValueFullName()
  {
    String answer = cRUD_Value.toString();
    return answer;
  }

  public CRUD_Value getCRUD_Value()
  {
    return cRUD_Value;
  }

  public boolean setCRUD_Value(CRUD_Value aCRUD_Value)
  {
    cRUD_Value = aCRUD_Value;
    return true;
  }

  public Facility getFacility()
  {
    return facility;
  }

  public Role getRole()
  {
    return role;
  }

  public boolean setFacility(Facility aFacility)
  {
    boolean wasSet = false;
    if (!canSetFacility) { return false; }
    if (aFacility == null)
    {
      return wasSet;
    }

    Facility existingFacility = facility;
    facility = aFacility;
    if (existingFacility != null && !existingFacility.equals(aFacility))
    {
      existingFacility.removeRoleFacilityAccessRight(this);
    }
    if (!facility.addRoleFacilityAccessRight(this))
    {
      facility = existingFacility;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setRole(Role aRole)
  {
    boolean wasSet = false;
    if (!canSetRole) { return false; }
    if (aRole == null)
    {
      return wasSet;
    }

    Role existingRole = role;
    role = aRole;
    if (existingRole != null && !existingRole.equals(aRole))
    {
      existingRole.removeRoleFacilityAccessRight(this);
    }
    if (!role.addRoleFacilityAccessRight(this))
    {
      role = existingRole;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    RoleFacilityAccessRight compareTo = (RoleFacilityAccessRight)obj;
  
    if (facility == null && compareTo.facility != null)
    {
      return false;
    }
    else if (facility != null && !facility.equals(compareTo.facility))
    {
      return false;
    }

    if (role == null && compareTo.role != null)
    {
      return false;
    }
    else if (role != null && !role.equals(compareTo.role))
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
    if (facility != null)
    {
      cachedHashCode = cachedHashCode * 23 + facility.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (role != null)
    {
      cachedHashCode = cachedHashCode * 23 + role.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetFacility = false;
    canSetRole = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Facility placeholderFacility = facility;
    this.facility = null;
    placeholderFacility.removeRoleFacilityAccessRight(this);
    Role placeholderRole = role;
    this.role = null;
    placeholderRole.removeRoleFacilityAccessRight(this);
  }

}