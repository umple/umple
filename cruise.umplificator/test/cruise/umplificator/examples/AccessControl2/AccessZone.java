/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Access Zone: a physical zone where a user is present, accessible through doors
 */
// line 58 "AccessControl2.ump"
// line 219 "AccessControl2.ump"
public class AccessZone
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AccessZone Associations
  private List<Door> doors;
  private List<User> mayEnter;
  private Authorizer hasKnowledge;
  private ACSystem exitControls;
  private ACSystem entryControls;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AccessZone(Authorizer aHasKnowledge, ACSystem aExitControls, ACSystem aEntryControls)
  {
    doors = new ArrayList<Door>();
    mayEnter = new ArrayList<User>();
    boolean didAddHasKnowledge = setHasKnowledge(aHasKnowledge);
    if (!didAddHasKnowledge)
    {
      throw new RuntimeException("Unable to create accessZone due to hasKnowledge");
    }
    if (aExitControls == null || aExitControls.getExiting() != null)
    {
      throw new RuntimeException("Unable to create AccessZone due to aExitControls");
    }
    exitControls = aExitControls;
    if (aEntryControls == null || aEntryControls.getEnteriing() != null)
    {
      throw new RuntimeException("Unable to create AccessZone due to aEntryControls");
    }
    entryControls = aEntryControls;
  }

  public AccessZone(Authorizer aHasKnowledge, AccessZone aEnteriingForExitControls, User... allMayUseForExitControls, AccessZone aExitingForEntryControls, User... allMayUseForEntryControls)
  {
    doors = new ArrayList<Door>();
    mayEnter = new ArrayList<User>();
    boolean didAddHasKnowledge = setHasKnowledge(aHasKnowledge);
    if (!didAddHasKnowledge)
    {
      throw new RuntimeException("Unable to create accessZone due to hasKnowledge");
    }
    exitControls = new ACSystem(this, aEnteriingForExitControls, allMayUseForExitControls);
    entryControls = new ACSystem(aExitingForEntryControls, this, allMayUseForEntryControls);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Door getDoor(int index)
  {
    Door aDoor = doors.get(index);
    return aDoor;
  }

  /**
   * 1..2 boundedBy -- 1..* AccessPoint;
   */
  public List<Door> getDoors()
  {
    List<Door> newDoors = Collections.unmodifiableList(doors);
    return newDoors;
  }

  public int numberOfDoors()
  {
    int number = doors.size();
    return number;
  }

  public boolean hasDoors()
  {
    boolean has = doors.size() > 0;
    return has;
  }

  public int indexOfDoor(Door aDoor)
  {
    int index = doors.indexOf(aDoor);
    return index;
  }

  public User getMayEnter(int index)
  {
    User aMayEnter = mayEnter.get(index);
    return aMayEnter;
  }

  public List<User> getMayEnter()
  {
    List<User> newMayEnter = Collections.unmodifiableList(mayEnter);
    return newMayEnter;
  }

  public int numberOfMayEnter()
  {
    int number = mayEnter.size();
    return number;
  }

  public boolean hasMayEnter()
  {
    boolean has = mayEnter.size() > 0;
    return has;
  }

  public int indexOfMayEnter(User aMayEnter)
  {
    int index = mayEnter.indexOf(aMayEnter);
    return index;
  }

  public Authorizer getHasKnowledge()
  {
    return hasKnowledge;
  }

  public ACSystem getExitControls()
  {
    return exitControls;
  }

  public ACSystem getEntryControls()
  {
    return entryControls;
  }

  public boolean isNumberOfDoorsValid()
  {
    boolean isValid = numberOfDoors() >= minimumNumberOfDoors();
    return isValid;
  }

  public static int minimumNumberOfDoors()
  {
    return 1;
  }

  public Door addDoor(AccessPoint aControls)
  {
    Door aNewDoor = new Door(aControls, this);
    return aNewDoor;
  }

  public boolean addDoor(Door aDoor)
  {
    boolean wasAdded = false;
    if (doors.contains(aDoor)) { return false; }
    AccessZone existingAccessedThrough = aDoor.getAccessedThrough();
    boolean isNewAccessedThrough = existingAccessedThrough != null && !this.equals(existingAccessedThrough);

    if (isNewAccessedThrough && existingAccessedThrough.numberOfDoors() <= minimumNumberOfDoors())
    {
      return wasAdded;
    }
    if (isNewAccessedThrough)
    {
      aDoor.setAccessedThrough(this);
    }
    else
    {
      doors.add(aDoor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDoor(Door aDoor)
  {
    boolean wasRemoved = false;
    //Unable to remove aDoor, as it must always have a accessedThrough
    if (this.equals(aDoor.getAccessedThrough()))
    {
      return wasRemoved;
    }

    //accessedThrough already at minimum (1)
    if (numberOfDoors() <= minimumNumberOfDoors())
    {
      return wasRemoved;
    }

    doors.remove(aDoor);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean addDoorAt(Door aDoor, int index)
  {  
    boolean wasAdded = false;
    if(addDoor(aDoor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoors()) { index = numberOfDoors() - 1; }
      doors.remove(aDoor);
      doors.add(index, aDoor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDoorAt(Door aDoor, int index)
  {
    boolean wasAdded = false;
    if(doors.contains(aDoor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoors()) { index = numberOfDoors() - 1; }
      doors.remove(aDoor);
      doors.add(index, aDoor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDoorAt(aDoor, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfMayEnter()
  {
    return 0;
  }

  public boolean addMayEnter(User aMayEnter)
  {
    boolean wasAdded = false;
    if (mayEnter.contains(aMayEnter)) { return false; }
    mayEnter.add(aMayEnter);
    if (aMayEnter.indexOfMayAccept(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMayEnter.addMayAccept(this);
      if (!wasAdded)
      {
        mayEnter.remove(aMayEnter);
      }
    }
    return wasAdded;
  }

  public boolean removeMayEnter(User aMayEnter)
  {
    boolean wasRemoved = false;
    if (!mayEnter.contains(aMayEnter))
    {
      return wasRemoved;
    }

    int oldIndex = mayEnter.indexOf(aMayEnter);
    mayEnter.remove(oldIndex);
    if (aMayEnter.indexOfMayAccept(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMayEnter.removeMayAccept(this);
      if (!wasRemoved)
      {
        mayEnter.add(oldIndex,aMayEnter);
      }
    }
    return wasRemoved;
  }

  public boolean addMayEnterAt(User aMayEnter, int index)
  {  
    boolean wasAdded = false;
    if(addMayEnter(aMayEnter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMayEnter()) { index = numberOfMayEnter() - 1; }
      mayEnter.remove(aMayEnter);
      mayEnter.add(index, aMayEnter);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMayEnterAt(User aMayEnter, int index)
  {
    boolean wasAdded = false;
    if(mayEnter.contains(aMayEnter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMayEnter()) { index = numberOfMayEnter() - 1; }
      mayEnter.remove(aMayEnter);
      mayEnter.add(index, aMayEnter);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMayEnterAt(aMayEnter, index);
    }
    return wasAdded;
  }

  public boolean setHasKnowledge(Authorizer aHasKnowledge)
  {
    boolean wasSet = false;
    if (aHasKnowledge == null)
    {
      return wasSet;
    }

    Authorizer existingHasKnowledge = hasKnowledge;
    hasKnowledge = aHasKnowledge;
    if (existingHasKnowledge != null && !existingHasKnowledge.equals(aHasKnowledge))
    {
      existingHasKnowledge.removeAccessZone(this);
    }
    hasKnowledge.addAccessZone(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=doors.size(); i > 0; i--)
    {
      Door aDoor = doors.get(i - 1);
      aDoor.delete();
    }
    ArrayList<User> copyOfMayEnter = new ArrayList<User>(mayEnter);
    mayEnter.clear();
    for(User aMayEnter : copyOfMayEnter)
    {
      aMayEnter.removeMayAccept(this);
    }
    Authorizer placeholderHasKnowledge = hasKnowledge;
    this.hasKnowledge = null;
    placeholderHasKnowledge.removeAccessZone(this);
    ACSystem existingExitControls = exitControls;
    exitControls = null;
    if (existingExitControls != null)
    {
      existingExitControls.delete();
    }
    ACSystem existingEntryControls = entryControls;
    entryControls = null;
    if (existingEntryControls != null)
    {
      existingEntryControls.delete();
    }
  }

}