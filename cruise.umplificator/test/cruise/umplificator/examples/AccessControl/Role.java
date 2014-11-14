/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 41 "AccessControl.ump"
// line 93 "AccessControl.ump"
public class Role
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Role Attributes
  private String code;

  //Role State Machines
  enum Role_description { Dba, ProjectMgr }
  private Role_description role_description;

  //Role Associations
  private List<RoleFacilityAccessRight> roleFacilityAccessRights;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Role(String aCode)
  {
    cachedHashCode = -1;
    canSetCode = true;
    code = aCode;
    roleFacilityAccessRights = new ArrayList<RoleFacilityAccessRight>();
    setRole_description(Role_description.Dba);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    if (!canSetCode) { return false; }
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public String getCode()
  {
    return code;
  }

  public String getRole_descriptionFullName()
  {
    String answer = role_description.toString();
    return answer;
  }

  public Role_description getRole_description()
  {
    return role_description;
  }

  public boolean setRole_description(Role_description aRole_description)
  {
    role_description = aRole_description;
    return true;
  }

  public RoleFacilityAccessRight getRoleFacilityAccessRight(int index)
  {
    RoleFacilityAccessRight aRoleFacilityAccessRight = roleFacilityAccessRights.get(index);
    return aRoleFacilityAccessRight;
  }

  public List<RoleFacilityAccessRight> getRoleFacilityAccessRights()
  {
    List<RoleFacilityAccessRight> newRoleFacilityAccessRights = Collections.unmodifiableList(roleFacilityAccessRights);
    return newRoleFacilityAccessRights;
  }

  public int numberOfRoleFacilityAccessRights()
  {
    int number = roleFacilityAccessRights.size();
    return number;
  }

  public boolean hasRoleFacilityAccessRights()
  {
    boolean has = roleFacilityAccessRights.size() > 0;
    return has;
  }

  public int indexOfRoleFacilityAccessRight(RoleFacilityAccessRight aRoleFacilityAccessRight)
  {
    int index = roleFacilityAccessRights.indexOf(aRoleFacilityAccessRight);
    return index;
  }

  public static int minimumNumberOfRoleFacilityAccessRights()
  {
    return 0;
  }

  public RoleFacilityAccessRight addRoleFacilityAccessRight(Facility aFacility)
  {
    return new RoleFacilityAccessRight(aFacility, this);
  }

  public boolean addRoleFacilityAccessRight(RoleFacilityAccessRight aRoleFacilityAccessRight)
  {
    boolean wasAdded = false;
    if (roleFacilityAccessRights.contains(aRoleFacilityAccessRight)) { return false; }
    Role existingRole = aRoleFacilityAccessRight.getRole();
    boolean isNewRole = existingRole != null && !this.equals(existingRole);
    if (isNewRole)
    {
      aRoleFacilityAccessRight.setRole(this);
    }
    else
    {
      roleFacilityAccessRights.add(aRoleFacilityAccessRight);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRoleFacilityAccessRight(RoleFacilityAccessRight aRoleFacilityAccessRight)
  {
    boolean wasRemoved = false;
    //Unable to remove aRoleFacilityAccessRight, as it must always have a role
    if (!this.equals(aRoleFacilityAccessRight.getRole()))
    {
      roleFacilityAccessRights.remove(aRoleFacilityAccessRight);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRoleFacilityAccessRightAt(RoleFacilityAccessRight aRoleFacilityAccessRight, int index)
  {  
    boolean wasAdded = false;
    if(addRoleFacilityAccessRight(aRoleFacilityAccessRight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoleFacilityAccessRights()) { index = numberOfRoleFacilityAccessRights() - 1; }
      roleFacilityAccessRights.remove(aRoleFacilityAccessRight);
      roleFacilityAccessRights.add(index, aRoleFacilityAccessRight);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRoleFacilityAccessRightAt(RoleFacilityAccessRight aRoleFacilityAccessRight, int index)
  {
    boolean wasAdded = false;
    if(roleFacilityAccessRights.contains(aRoleFacilityAccessRight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoleFacilityAccessRights()) { index = numberOfRoleFacilityAccessRights() - 1; }
      roleFacilityAccessRights.remove(aRoleFacilityAccessRight);
      roleFacilityAccessRights.add(index, aRoleFacilityAccessRight);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRoleFacilityAccessRightAt(aRoleFacilityAccessRight, index);
    }
    return wasAdded;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Role compareTo = (Role)obj;
  
    if (code == null && compareTo.code != null)
    {
      return false;
    }
    else if (code != null && !code.equals(compareTo.code))
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
    if (code != null)
    {
      cachedHashCode = cachedHashCode * 23 + code.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetCode = false;
    return cachedHashCode;
  }

  public void delete()
  {
    for(int i=roleFacilityAccessRights.size(); i > 0; i--)
    {
      RoleFacilityAccessRight aRoleFacilityAccessRight = roleFacilityAccessRights.get(i - 1);
      aRoleFacilityAccessRight.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "code" + ":" + getCode()+ "]"
     + outputString;
  }
}