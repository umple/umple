/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Temporarely taken out because of lack of Association Class implementations in Umple 2.0
 * ordered
 * association BankOnFloor{ 
 * Boolean upCall;
 * Boolean downCall;
 * 0..* Bank; 
 * 2..* Floor;
 * }
 * Positioning
 */
// line 27 "ElevatorSystemA.ump"
// line 45 "ElevatorSystemA.ump"
public class Elevator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Elevator Attributes
  private String id;
  private String direction;
  private String movingOrStopped;

  //Elevator Associations
  private List<Floor> hasAccess;
  private Bank bank;
  private Floor floor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Elevator(String aId, String aDirection, String aMovingOrStopped, Bank aBank, Floor aFloor)
  {
    id = aId;
    direction = aDirection;
    movingOrStopped = aMovingOrStopped;
    hasAccess = new ArrayList<Floor>();
    boolean didAddBank = setBank(aBank);
    if (!didAddBank)
    {
      throw new RuntimeException("Unable to create elevator due to bank");
    }
    boolean didAddFloor = setFloor(aFloor);
    if (!didAddFloor)
    {
      throw new RuntimeException("Unable to create onFloor due to floor");
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

  public boolean setDirection(String aDirection)
  {
    boolean wasSet = false;
    direction = aDirection;
    wasSet = true;
    return wasSet;
  }

  public boolean setMovingOrStopped(String aMovingOrStopped)
  {
    boolean wasSet = false;
    movingOrStopped = aMovingOrStopped;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getDirection()
  {
    return direction;
  }

  public String getMovingOrStopped()
  {
    return movingOrStopped;
  }

  public Floor getHasAccess(int index)
  {
    Floor aHasAccess = hasAccess.get(index);
    return aHasAccess;
  }

  public List<Floor> getHasAccess()
  {
    List<Floor> newHasAccess = Collections.unmodifiableList(hasAccess);
    return newHasAccess;
  }

  public int numberOfHasAccess()
  {
    int number = hasAccess.size();
    return number;
  }

  public boolean hasHasAccess()
  {
    boolean has = hasAccess.size() > 0;
    return has;
  }

  public int indexOfHasAccess(Floor aHasAccess)
  {
    int index = hasAccess.indexOf(aHasAccess);
    return index;
  }

  public Bank getBank()
  {
    return bank;
  }

  public Floor getFloor()
  {
    return floor;
  }

  public static int minimumNumberOfHasAccess()
  {
    return 0;
  }

  public boolean addHasAccess(Floor aHasAccess)
  {
    boolean wasAdded = false;
    if (hasAccess.contains(aHasAccess)) { return false; }
    hasAccess.add(aHasAccess);
    if (aHasAccess.indexOfElevator(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aHasAccess.addElevator(this);
      if (!wasAdded)
      {
        hasAccess.remove(aHasAccess);
      }
    }
    return wasAdded;
  }

  public boolean removeHasAccess(Floor aHasAccess)
  {
    boolean wasRemoved = false;
    if (!hasAccess.contains(aHasAccess))
    {
      return wasRemoved;
    }

    int oldIndex = hasAccess.indexOf(aHasAccess);
    hasAccess.remove(oldIndex);
    if (aHasAccess.indexOfElevator(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aHasAccess.removeElevator(this);
      if (!wasRemoved)
      {
        hasAccess.add(oldIndex,aHasAccess);
      }
    }
    return wasRemoved;
  }

  public boolean addHasAccessAt(Floor aHasAccess, int index)
  {  
    boolean wasAdded = false;
    if(addHasAccess(aHasAccess))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHasAccess()) { index = numberOfHasAccess() - 1; }
      hasAccess.remove(aHasAccess);
      hasAccess.add(index, aHasAccess);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveHasAccessAt(Floor aHasAccess, int index)
  {
    boolean wasAdded = false;
    if(hasAccess.contains(aHasAccess))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHasAccess()) { index = numberOfHasAccess() - 1; }
      hasAccess.remove(aHasAccess);
      hasAccess.add(index, aHasAccess);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addHasAccessAt(aHasAccess, index);
    }
    return wasAdded;
  }

  public boolean setBank(Bank aBank)
  {
    boolean wasSet = false;
    //Must provide bank to elevator
    if (aBank == null)
    {
      return wasSet;
    }

    if (bank != null && bank.numberOfElevators() <= Bank.minimumNumberOfElevators())
    {
      return wasSet;
    }

    Bank existingBank = bank;
    bank = aBank;
    if (existingBank != null && !existingBank.equals(aBank))
    {
      boolean didRemove = existingBank.removeElevator(this);
      if (!didRemove)
      {
        bank = existingBank;
        return wasSet;
      }
    }
    bank.addElevator(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setFloor(Floor aFloor)
  {
    boolean wasSet = false;
    if (aFloor == null)
    {
      return wasSet;
    }

    Floor existingFloor = floor;
    floor = aFloor;
    if (existingFloor != null && !existingFloor.equals(aFloor))
    {
      existingFloor.removeOnFloor(this);
    }
    floor.addOnFloor(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Floor> copyOfHasAccess = new ArrayList<Floor>(hasAccess);
    hasAccess.clear();
    for(Floor aHasAccess : copyOfHasAccess)
    {
      aHasAccess.removeElevator(this);
    }
    Bank placeholderBank = bank;
    this.bank = null;
    placeholderBank.removeElevator(this);
    Floor placeholderFloor = floor;
    this.floor = null;
    placeholderFloor.removeOnFloor(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "direction" + ":" + getDirection()+ "," +
            "movingOrStopped" + ":" + getMovingOrStopped()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bank = "+(getBank()!=null?Integer.toHexString(System.identityHashCode(getBank())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "floor = "+(getFloor()!=null?Integer.toHexString(System.identityHashCode(getFloor())):"null")
     + outputString;
  }
}