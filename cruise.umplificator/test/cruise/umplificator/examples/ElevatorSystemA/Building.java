/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 7 "ElevatorSystemA.ump"
// line 64 "ElevatorSystemA.ump"
public class Building
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Building Attributes
  private String name;

  //Building Associations
  private List<Floor> floors;
  private List<Bank> banks;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Building(String aName)
  {
    name = aName;
    floors = new ArrayList<Floor>();
    banks = new ArrayList<Bank>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Floor getFloor(int index)
  {
    Floor aFloor = floors.get(index);
    return aFloor;
  }

  public List<Floor> getFloors()
  {
    List<Floor> newFloors = Collections.unmodifiableList(floors);
    return newFloors;
  }

  public int numberOfFloors()
  {
    int number = floors.size();
    return number;
  }

  public boolean hasFloors()
  {
    boolean has = floors.size() > 0;
    return has;
  }

  public int indexOfFloor(Floor aFloor)
  {
    int index = floors.indexOf(aFloor);
    return index;
  }

  public Bank getBank(int index)
  {
    Bank aBank = banks.get(index);
    return aBank;
  }

  public List<Bank> getBanks()
  {
    List<Bank> newBanks = Collections.unmodifiableList(banks);
    return newBanks;
  }

  public int numberOfBanks()
  {
    int number = banks.size();
    return number;
  }

  public boolean hasBanks()
  {
    boolean has = banks.size() > 0;
    return has;
  }

  public int indexOfBank(Bank aBank)
  {
    int index = banks.indexOf(aBank);
    return index;
  }

  public boolean isNumberOfFloorsValid()
  {
    boolean isValid = numberOfFloors() >= minimumNumberOfFloors();
    return isValid;
  }

  public static int minimumNumberOfFloors()
  {
    return 2;
  }

  public Floor addFloor(String aId, String aDoorToOpen)
  {
    Floor aNewFloor = new Floor(aId, aDoorToOpen, this);
    return aNewFloor;
  }

  public boolean addFloor(Floor aFloor)
  {
    boolean wasAdded = false;
    if (floors.contains(aFloor)) { return false; }
    Building existingBuilding = aFloor.getBuilding();
    boolean isNewBuilding = existingBuilding != null && !this.equals(existingBuilding);

    if (isNewBuilding && existingBuilding.numberOfFloors() <= minimumNumberOfFloors())
    {
      return wasAdded;
    }
    if (isNewBuilding)
    {
      aFloor.setBuilding(this);
    }
    else
    {
      floors.add(aFloor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeFloor(Floor aFloor)
  {
    boolean wasRemoved = false;
    //Unable to remove aFloor, as it must always have a building
    if (this.equals(aFloor.getBuilding()))
    {
      return wasRemoved;
    }

    //building already at minimum (2)
    if (numberOfFloors() <= minimumNumberOfFloors())
    {
      return wasRemoved;
    }

    floors.remove(aFloor);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean addFloorAt(Floor aFloor, int index)
  {  
    boolean wasAdded = false;
    if(addFloor(aFloor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFloors()) { index = numberOfFloors() - 1; }
      floors.remove(aFloor);
      floors.add(index, aFloor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFloorAt(Floor aFloor, int index)
  {
    boolean wasAdded = false;
    if(floors.contains(aFloor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFloors()) { index = numberOfFloors() - 1; }
      floors.remove(aFloor);
      floors.add(index, aFloor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFloorAt(aFloor, index);
    }
    return wasAdded;
  }

  public boolean isNumberOfBanksValid()
  {
    boolean isValid = numberOfBanks() >= minimumNumberOfBanks();
    return isValid;
  }

  public static int minimumNumberOfBanks()
  {
    return 1;
  }

  public Bank addBank(String aId)
  {
    Bank aNewBank = new Bank(aId, this);
    return aNewBank;
  }

  public boolean addBank(Bank aBank)
  {
    boolean wasAdded = false;
    if (banks.contains(aBank)) { return false; }
    Building existingBuilding = aBank.getBuilding();
    boolean isNewBuilding = existingBuilding != null && !this.equals(existingBuilding);

    if (isNewBuilding && existingBuilding.numberOfBanks() <= minimumNumberOfBanks())
    {
      return wasAdded;
    }
    if (isNewBuilding)
    {
      aBank.setBuilding(this);
    }
    else
    {
      banks.add(aBank);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBank(Bank aBank)
  {
    boolean wasRemoved = false;
    //Unable to remove aBank, as it must always have a building
    if (this.equals(aBank.getBuilding()))
    {
      return wasRemoved;
    }

    //building already at minimum (1)
    if (numberOfBanks() <= minimumNumberOfBanks())
    {
      return wasRemoved;
    }

    banks.remove(aBank);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean addBankAt(Bank aBank, int index)
  {  
    boolean wasAdded = false;
    if(addBank(aBank))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBanks()) { index = numberOfBanks() - 1; }
      banks.remove(aBank);
      banks.add(index, aBank);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBankAt(Bank aBank, int index)
  {
    boolean wasAdded = false;
    if(banks.contains(aBank))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBanks()) { index = numberOfBanks() - 1; }
      banks.remove(aBank);
      banks.add(index, aBank);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBankAt(aBank, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=floors.size(); i > 0; i--)
    {
      Floor aFloor = floors.get(i - 1);
      aFloor.delete();
    }
    for(int i=banks.size(); i > 0; i--)
    {
      Bank aBank = banks.get(i - 1);
      aBank.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}