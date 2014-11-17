/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 13 "ElevatorSystemA.ump"
// line 58 "ElevatorSystemA.ump"
public class Bank
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bank Attributes
  private String id;

  //Bank Associations
  private List<Elevator> elevators;
  private Building building;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bank(String aId, Building aBuilding)
  {
    id = aId;
    elevators = new ArrayList<Elevator>();
    boolean didAddBuilding = setBuilding(aBuilding);
    if (!didAddBuilding)
    {
      throw new RuntimeException("Unable to create bank due to building");
    }
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

  public String getId()
  {
    return id;
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

  public Building getBuilding()
  {
    return building;
  }

  public boolean isNumberOfElevatorsValid()
  {
    boolean isValid = numberOfElevators() >= minimumNumberOfElevators();
    return isValid;
  }

  public static int minimumNumberOfElevators()
  {
    return 1;
  }

  public Elevator addElevator(String aId, String aDirection, String aMovingOrStopped, Floor aFloor)
  {
    Elevator aNewElevator = new Elevator(aId, aDirection, aMovingOrStopped, this, aFloor);
    return aNewElevator;
  }

  public boolean addElevator(Elevator aElevator)
  {
    boolean wasAdded = false;
    if (elevators.contains(aElevator)) { return false; }
    Bank existingBank = aElevator.getBank();
    boolean isNewBank = existingBank != null && !this.equals(existingBank);

    if (isNewBank && existingBank.numberOfElevators() <= minimumNumberOfElevators())
    {
      return wasAdded;
    }
    if (isNewBank)
    {
      aElevator.setBank(this);
    }
    else
    {
      elevators.add(aElevator);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeElevator(Elevator aElevator)
  {
    boolean wasRemoved = false;
    //Unable to remove aElevator, as it must always have a bank
    if (this.equals(aElevator.getBank()))
    {
      return wasRemoved;
    }

    //bank already at minimum (1)
    if (numberOfElevators() <= minimumNumberOfElevators())
    {
      return wasRemoved;
    }

    elevators.remove(aElevator);
    wasRemoved = true;
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

  public boolean setBuilding(Building aBuilding)
  {
    boolean wasSet = false;
    //Must provide building to bank
    if (aBuilding == null)
    {
      return wasSet;
    }

    if (building != null && building.numberOfBanks() <= Building.minimumNumberOfBanks())
    {
      return wasSet;
    }

    Building existingBuilding = building;
    building = aBuilding;
    if (existingBuilding != null && !existingBuilding.equals(aBuilding))
    {
      boolean didRemove = existingBuilding.removeBank(this);
      if (!didRemove)
      {
        building = existingBuilding;
        return wasSet;
      }
    }
    building.addBank(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=elevators.size(); i > 0; i--)
    {
      Elevator aElevator = elevators.get(i - 1);
      aElevator.delete();
    }
    Building placeholderBuilding = building;
    this.building = null;
    placeholderBuilding.removeBank(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "building = "+(getBuilding()!=null?Integer.toHexString(System.identityHashCode(getBuilding())):"null")
     + outputString;
  }
}