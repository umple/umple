/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 29 "AccessControl.ump"
// line 76 "AccessControl.ump"
public class Facility
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Facility Attributes
  private int id;
  private int access_count;
  private String name;
  private String description;
  private String other_details;

  //Facility Associations
  private FacilityType facilityType;
  private List<FunctionalArea> functionalAreas;
  private List<RoleFacilityAccessRight> roleFacilityAccessRights;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Facility(int aId, int aAccess_count, String aName, String aDescription, String aOther_details)
  {
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    access_count = aAccess_count;
    name = aName;
    description = aDescription;
    other_details = aOther_details;
    functionalAreas = new ArrayList<FunctionalArea>();
    roleFacilityAccessRights = new ArrayList<RoleFacilityAccessRight>();
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

  public boolean setAccess_count(int aAccess_count)
  {
    boolean wasSet = false;
    access_count = aAccess_count;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
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

  public int getAccess_count()
  {
    return access_count;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public String getOther_details()
  {
    return other_details;
  }

  public FacilityType getFacilityType()
  {
    return facilityType;
  }

  public boolean hasFacilityType()
  {
    boolean has = facilityType != null;
    return has;
  }

  public FunctionalArea getFunctionalArea(int index)
  {
    FunctionalArea aFunctionalArea = functionalAreas.get(index);
    return aFunctionalArea;
  }

  public List<FunctionalArea> getFunctionalAreas()
  {
    List<FunctionalArea> newFunctionalAreas = Collections.unmodifiableList(functionalAreas);
    return newFunctionalAreas;
  }

  public int numberOfFunctionalAreas()
  {
    int number = functionalAreas.size();
    return number;
  }

  public boolean hasFunctionalAreas()
  {
    boolean has = functionalAreas.size() > 0;
    return has;
  }

  public int indexOfFunctionalArea(FunctionalArea aFunctionalArea)
  {
    int index = functionalAreas.indexOf(aFunctionalArea);
    return index;
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

  public boolean setFacilityType(FacilityType aNewFacilityType)
  {
    boolean wasSet = false;
    facilityType = aNewFacilityType;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfFunctionalAreas()
  {
    return 0;
  }

  public boolean addFunctionalArea(FunctionalArea aFunctionalArea)
  {
    boolean wasAdded = false;
    if (functionalAreas.contains(aFunctionalArea)) { return false; }
    functionalAreas.add(aFunctionalArea);
    if (aFunctionalArea.indexOfFacility(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aFunctionalArea.addFacility(this);
      if (!wasAdded)
      {
        functionalAreas.remove(aFunctionalArea);
      }
    }
    return wasAdded;
  }

  public boolean removeFunctionalArea(FunctionalArea aFunctionalArea)
  {
    boolean wasRemoved = false;
    if (!functionalAreas.contains(aFunctionalArea))
    {
      return wasRemoved;
    }

    int oldIndex = functionalAreas.indexOf(aFunctionalArea);
    functionalAreas.remove(oldIndex);
    if (aFunctionalArea.indexOfFacility(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aFunctionalArea.removeFacility(this);
      if (!wasRemoved)
      {
        functionalAreas.add(oldIndex,aFunctionalArea);
      }
    }
    return wasRemoved;
  }

  public boolean addFunctionalAreaAt(FunctionalArea aFunctionalArea, int index)
  {  
    boolean wasAdded = false;
    if(addFunctionalArea(aFunctionalArea))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFunctionalAreas()) { index = numberOfFunctionalAreas() - 1; }
      functionalAreas.remove(aFunctionalArea);
      functionalAreas.add(index, aFunctionalArea);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFunctionalAreaAt(FunctionalArea aFunctionalArea, int index)
  {
    boolean wasAdded = false;
    if(functionalAreas.contains(aFunctionalArea))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFunctionalAreas()) { index = numberOfFunctionalAreas() - 1; }
      functionalAreas.remove(aFunctionalArea);
      functionalAreas.add(index, aFunctionalArea);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFunctionalAreaAt(aFunctionalArea, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfRoleFacilityAccessRights()
  {
    return 0;
  }

  public RoleFacilityAccessRight addRoleFacilityAccessRight(Role aRole)
  {
    return new RoleFacilityAccessRight(this, aRole);
  }

  public boolean addRoleFacilityAccessRight(RoleFacilityAccessRight aRoleFacilityAccessRight)
  {
    boolean wasAdded = false;
    if (roleFacilityAccessRights.contains(aRoleFacilityAccessRight)) { return false; }
    Facility existingFacility = aRoleFacilityAccessRight.getFacility();
    boolean isNewFacility = existingFacility != null && !this.equals(existingFacility);
    if (isNewFacility)
    {
      aRoleFacilityAccessRight.setFacility(this);
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
    //Unable to remove aRoleFacilityAccessRight, as it must always have a facility
    if (!this.equals(aRoleFacilityAccessRight.getFacility()))
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

    Facility compareTo = (Facility)obj;
  
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
    facilityType = null;
    ArrayList<FunctionalArea> copyOfFunctionalAreas = new ArrayList<FunctionalArea>(functionalAreas);
    functionalAreas.clear();
    for(FunctionalArea aFunctionalArea : copyOfFunctionalAreas)
    {
      aFunctionalArea.removeFacility(this);
    }
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
            "id" + ":" + getId()+ "," +
            "access_count" + ":" + getAccess_count()+ "," +
            "name" + ":" + getName()+ "," +
            "description" + ":" + getDescription()+ "," +
            "other_details" + ":" + getOther_details()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "facilityType = "+(getFacilityType()!=null?Integer.toHexString(System.identityHashCode(getFacilityType())):"null")
     + outputString;
  }
}