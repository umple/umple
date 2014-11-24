/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import Elevator.core.Buttons.*;
import java.util.*;

// line 23 "ElevatorSystemB.ump"
// line 101 "ElevatorSystemB.ump"
public class FullSystem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FullSystem Associations
  private List<Elevator> elevators;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FullSystem()
  {
    elevators = new ArrayList<Elevator>();
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public static int minimumNumberOfElevators()
  {
    return 0;
  }

  public Elevator addElevator(String aIdentifier, String aState, String aDirectionOfMovement, CloseDoorButton aCloseDoorButton, OpenDoorButton aOpenDoorButton)
  {
    return new Elevator(aIdentifier, aState, aDirectionOfMovement, this, aCloseDoorButton, aOpenDoorButton);
  }

  public boolean addElevator(Elevator aElevator)
  {
    boolean wasAdded = false;
    if (elevators.contains(aElevator)) { return false; }
    FullSystem existingFullSystem = aElevator.getFullSystem();
    boolean isNewFullSystem = existingFullSystem != null && !this.equals(existingFullSystem);
    if (isNewFullSystem)
    {
      aElevator.setFullSystem(this);
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
    //Unable to remove aElevator, as it must always have a fullSystem
    if (!this.equals(aElevator.getFullSystem()))
    {
      elevators.remove(aElevator);
      wasRemoved = true;
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
    for(int i=elevators.size(); i > 0; i--)
    {
      Elevator aElevator = elevators.get(i - 1);
      aElevator.delete();
    }
  }

}