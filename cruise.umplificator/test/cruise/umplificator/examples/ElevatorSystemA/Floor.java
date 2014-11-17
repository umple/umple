/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 19 "ElevatorSystemA.ump"
// line 51 "ElevatorSystemA.ump"
public class Floor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Floor Attributes
  private String id;
  private String doorToOpen;

  //Floor Associations
  private Floor onSamelevelAs;
  private List<Elevator> onFloor;
  private Building building;
  private Floor floor;
  private List<Elevator> elevators;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Floor(String aId, String aDoorToOpen, Building aBuilding)
  {
    id = aId;
    doorToOpen = aDoorToOpen;
    onFloor = new ArrayList<Elevator>();
    boolean didAddBuilding = setBuilding(aBuilding);
    if (!didAddBuilding)
    {
      throw new RuntimeException("Unable to create floor due to building");
    }
    elevators = new ArrayList<Elevator>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDoorToOpen(String aDoorToOpen)
  {
    boolean wasSet = false;
    doorToOpen = aDoorToOpen;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getDoorToOpen()
  {
    return doorToOpen;
  }

  public Floor getOnSamelevelAs()
  {
    return onSamelevelAs;
  }

  public boolean hasOnSamelevelAs()
  {
    boolean has = onSamelevelAs != null;
    return has;
  }

  public Elevator getOnFloor(int index)
  {
    Elevator aOnFloor = onFloor.get(index);
    return aOnFloor;
  }

  public List<Elevator> getOnFloor()
  {
    List<Elevator> newOnFloor = Collections.unmodifiableList(onFloor);
    return newOnFloor;
  }

  public int numberOfOnFloor()
  {
    int number = onFloor.size();
    return number;
  }

  public boolean hasOnFloor()
  {
    boolean has = onFloor.size() > 0;
    return has;
  }

  public int indexOfOnFloor(Elevator aOnFloor)
  {
    int index = onFloor.indexOf(aOnFloor);
    return index;
  }

  public Building getBuilding()
  {
    return building;
  }

  public Floor getFloor()
  {
    return floor;
  }

  public boolean hasFloor()
  {
    boolean has = floor != null;
    return has;
  }

  public Elevator getElevator(int index)
  {
    Elevator aElevator = elevators.get(index);
    return aElevator;
  }

  public List<Elevator> getElevators()
  {
    List<Elevator> newElevators = Collections.unmodifiableList(elevators);
    return newElevators;
  }

  public int numberOfElevators()
  {
    int number = elevators.size();
    return number;
  }

  public boolean hasElevators()
  {
    boolean has = elevators.size() > 0;
    return has;
  }

  public int indexOfElevator(Elevator aElevator)
  {
    int index = elevators.indexOf(aElevator);
    return index;
  }

  public boolean setOnSamelevelAs(Floor aNewOnSamelevelAs)
  {
    boolean wasSet = false;
    if (aNewOnSamelevelAs == null)
    {
      Floor existingOnSamelevelAs = onSamelevelAs;
      onSamelevelAs = null;
      
      if (existingOnSamelevelAs != null && existingOnSamelevelAs.getFloor() != null)
      {
        existingOnSamelevelAs.setFloor(null);
      }
      wasSet = true;
      return wasSet;
    }

    Floor currentOnSamelevelAs = getOnSamelevelAs();
    if (currentOnSamelevelAs != null && !currentOnSamelevelAs.equals(aNewOnSamelevelAs))
    {
      currentOnSamelevelAs.setFloor(null);
    }

    onSamelevelAs = aNewOnSamelevelAs;
    Floor existingFloor = aNewOnSamelevelAs.getFloor();

    if (!equals(existingFloor))
    {
      aNewOnSamelevelAs.setFloor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfOnFloor()
  {
    return 0;
  }

  public Elevator addOnFloor(String aId, String aDirection, String aMovingOrStopped, Bank aBank)
  {
    return new Elevator(aId, aDirection, aMovingOrStopped, aBank, this);
  }

  public boolean addOnFloor(Elevator aOnFloor)
  {
    boolean wasAdded = false;
    if (onFloor.contains(aOnFloor)) { return false; }
    Floor existingFloor = aOnFloor.getFloor();
    boolean isNewFloor = existingFloor != null && !this.equals(existingFloor);
    if (isNewFloor)
    {
      aOnFloor.setFloor(this);
    }
    else
    {
      onFloor.add(aOnFloor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOnFloor(Elevator aOnFloor)
  {
    boolean wasRemoved = false;
    //Unable to remove aOnFloor, as it must always have a floor
    if (!this.equals(aOnFloor.getFloor()))
    {
      onFloor.remove(aOnFloor);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOnFloorAt(Elevator aOnFloor, int index)
  {  
    boolean wasAdded = false;
    if(addOnFloor(aOnFloor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOnFloor()) { index = numberOfOnFloor() - 1; }
      onFloor.remove(aOnFloor);
      onFloor.add(index, aOnFloor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOnFloorAt(Elevator aOnFloor, int index)
  {
    boolean wasAdded = false;
    if(onFloor.contains(aOnFloor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOnFloor()) { index = numberOfOnFloor() - 1; }
      onFloor.remove(aOnFloor);
      onFloor.add(index, aOnFloor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOnFloorAt(aOnFloor, index);
    }
    return wasAdded;
  }

  public boolean setBuilding(Building aBuilding)
  {
    boolean wasSet = false;
    //Must provide building to floor
    if (aBuilding == null)
    {
      return wasSet;
    }

    if (building != null && building.numberOfFloors() <= Building.minimumNumberOfFloors())
    {
      return wasSet;
    }

    Building existingBuilding = building;
    building = aBuilding;
    if (existingBuilding != null && !existingBuilding.equals(aBuilding))
    {
      boolean didRemove = existingBuilding.removeFloor(this);
      if (!didRemove)
      {
        building = existingBuilding;
        return wasSet;
      }
    }
    building.addFloor(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setFloor(Floor aNewFloor)
  {
    boolean wasSet = false;
    if (aNewFloor == null)
    {
      Floor existingFloor = floor;
      floor = null;
      
      if (existingFloor != null && existingFloor.getOnSamelevelAs() != null)
      {
        existingFloor.setOnSamelevelAs(null);
      }
      wasSet = true;
      return wasSet;
    }

    Floor currentFloor = getFloor();
    if (currentFloor != null && !currentFloor.equals(aNewFloor))
    {
      currentFloor.setOnSamelevelAs(null);
    }

    floor = aNewFloor;
    Floor existingOnSamelevelAs = aNewFloor.getOnSamelevelAs();

    if (!equals(existingOnSamelevelAs))
    {
      aNewFloor.setOnSamelevelAs(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfElevators()
  {
    return 0;
  }

  public boolean addElevator(Elevator aElevator)
  {
    boolean wasAdded = false;
    if (elevators.contains(aElevator)) { return false; }
    elevators.add(aElevator);
    if (aElevator.indexOfHasAccess(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aElevator.addHasAccess(this);
      if (!wasAdded)
      {
        elevators.remove(aElevator);
      }
    }
    return wasAdded;
  }

  public boolean removeElevator(Elevator aElevator)
  {
    boolean wasRemoved = false;
    if (!elevators.contains(aElevator))
    {
      return wasRemoved;
    }

    int oldIndex = elevators.indexOf(aElevator);
    elevators.remove(oldIndex);
    if (aElevator.indexOfHasAccess(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aElevator.removeHasAccess(this);
      if (!wasRemoved)
      {
        elevators.add(oldIndex,aElevator);
      }
    }
    return wasRemoved;
  }

  public boolean addElevatorAt(Elevator aElevator, int index)
  {  
    boolean wasAdded = false;
    if(addElevator(aElevator))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfElevators()) { index = numberOfElevators() - 1; }
      elevators.remove(aElevator);
      elevators.add(index, aElevator);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveElevatorAt(Elevator aElevator, int index)
  {
    boolean wasAdded = false;
    if(elevators.contains(aElevator))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfElevators()) { index = numberOfElevators() - 1; }
      elevators.remove(aElevator);
      elevators.add(index, aElevator);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addElevatorAt(aElevator, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    if (onSamelevelAs != null)
    {
      onSamelevelAs.setFloor(null);
    }
    for(int i=onFloor.size(); i > 0; i--)
    {
      Elevator aOnFloor = onFloor.get(i - 1);
      aOnFloor.delete();
    }
    Building placeholderBuilding = building;
    this.building = null;
    placeholderBuilding.removeFloor(this);
    if (floor != null)
    {
      floor.setOnSamelevelAs(null);
    }
    ArrayList<Elevator> copyOfElevators = new ArrayList<Elevator>(elevators);
    elevators.clear();
    for(Elevator aElevator : copyOfElevators)
    {
      aElevator.removeHasAccess(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "doorToOpen" + ":" + getDoorToOpen()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "building = "+(getBuilding()!=null?Integer.toHexString(System.identityHashCode(getBuilding())):"null")
     + outputString;
  }
}