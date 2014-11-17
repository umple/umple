/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package Elevator.core.Buttons;
import Elevator.core.Buttons.*;
import java.util.*;

// line 18 "../../../../ElevatorSystemB.ump"
// line 107 "../../../../ElevatorSystemB.ump"
public class Floor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Floor Associations
  private List<ConsoleCallButton> consoleCallButtons;
  private List<Elevator> elevators;
  private FloorNumberDisplay floorNumberDisplay;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Floor()
  {
    consoleCallButtons = new ArrayList<ConsoleCallButton>();
    elevators = new ArrayList<Elevator>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ConsoleCallButton getConsoleCallButton(int index)
  {
    ConsoleCallButton aConsoleCallButton = consoleCallButtons.get(index);
    return aConsoleCallButton;
  }

  public List<ConsoleCallButton> getConsoleCallButtons()
  {
    List<ConsoleCallButton> newConsoleCallButtons = Collections.unmodifiableList(consoleCallButtons);
    return newConsoleCallButtons;
  }

  public int numberOfConsoleCallButtons()
  {
    int number = consoleCallButtons.size();
    return number;
  }

  public boolean hasConsoleCallButtons()
  {
    boolean has = consoleCallButtons.size() > 0;
    return has;
  }

  public int indexOfConsoleCallButton(ConsoleCallButton aConsoleCallButton)
  {
    int index = consoleCallButtons.indexOf(aConsoleCallButton);
    return index;
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

  public FloorNumberDisplay getFloorNumberDisplay()
  {
    return floorNumberDisplay;
  }

  public boolean hasFloorNumberDisplay()
  {
    boolean has = floorNumberDisplay != null;
    return has;
  }

  public static int minimumNumberOfConsoleCallButtons()
  {
    return 0;
  }

  public ConsoleCallButton addConsoleCallButton(boolean aLightOn, Elevator aElevator)
  {
    return new ConsoleCallButton(aLightOn, aElevator, this);
  }

  public boolean addConsoleCallButton(ConsoleCallButton aConsoleCallButton)
  {
    boolean wasAdded = false;
    if (consoleCallButtons.contains(aConsoleCallButton)) { return false; }
    Floor existingFloor = aConsoleCallButton.getFloor();
    boolean isNewFloor = existingFloor != null && !this.equals(existingFloor);
    if (isNewFloor)
    {
      aConsoleCallButton.setFloor(this);
    }
    else
    {
      consoleCallButtons.add(aConsoleCallButton);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeConsoleCallButton(ConsoleCallButton aConsoleCallButton)
  {
    boolean wasRemoved = false;
    //Unable to remove aConsoleCallButton, as it must always have a floor
    if (!this.equals(aConsoleCallButton.getFloor()))
    {
      consoleCallButtons.remove(aConsoleCallButton);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addConsoleCallButtonAt(ConsoleCallButton aConsoleCallButton, int index)
  {  
    boolean wasAdded = false;
    if(addConsoleCallButton(aConsoleCallButton))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfConsoleCallButtons()) { index = numberOfConsoleCallButtons() - 1; }
      consoleCallButtons.remove(aConsoleCallButton);
      consoleCallButtons.add(index, aConsoleCallButton);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveConsoleCallButtonAt(ConsoleCallButton aConsoleCallButton, int index)
  {
    boolean wasAdded = false;
    if(consoleCallButtons.contains(aConsoleCallButton))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfConsoleCallButtons()) { index = numberOfConsoleCallButtons() - 1; }
      consoleCallButtons.remove(aConsoleCallButton);
      consoleCallButtons.add(index, aConsoleCallButton);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addConsoleCallButtonAt(aConsoleCallButton, index);
    }
    return wasAdded;
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
    if (aElevator.indexOfFloor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aElevator.addFloor(this);
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
    if (aElevator.indexOfFloor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aElevator.removeFloor(this);
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

  public boolean setFloorNumberDisplay(FloorNumberDisplay aNewFloorNumberDisplay)
  {
    boolean wasSet = false;
    if (floorNumberDisplay != null && !floorNumberDisplay.equals(aNewFloorNumberDisplay) && equals(floorNumberDisplay.getFloor()))
    {
      //Unable to setFloorNumberDisplay, as existing floorNumberDisplay would become an orphan
      return wasSet;
    }

    floorNumberDisplay = aNewFloorNumberDisplay;
    Floor anOldFloor = aNewFloorNumberDisplay != null ? aNewFloorNumberDisplay.getFloor() : null;

    if (!this.equals(anOldFloor))
    {
      if (anOldFloor != null)
      {
        anOldFloor.floorNumberDisplay = null;
      }
      if (floorNumberDisplay != null)
      {
        floorNumberDisplay.setFloor(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=consoleCallButtons.size(); i > 0; i--)
    {
      ConsoleCallButton aConsoleCallButton = consoleCallButtons.get(i - 1);
      aConsoleCallButton.delete();
    }
    ArrayList<Elevator> copyOfElevators = new ArrayList<Elevator>(elevators);
    elevators.clear();
    for(Elevator aElevator : copyOfElevators)
    {
      aElevator.removeFloor(this);
    }
    FloorNumberDisplay existingFloorNumberDisplay = floorNumberDisplay;
    floorNumberDisplay = null;
    if (existingFloorNumberDisplay != null)
    {
      existingFloorNumberDisplay.delete();
    }
  }

}