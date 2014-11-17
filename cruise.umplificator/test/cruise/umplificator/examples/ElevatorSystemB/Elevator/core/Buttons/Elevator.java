/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package Elevator.core.Buttons;
import Elevator.core.Buttons.*;
import java.util.*;

/**
 * Positioning
 */
// line 9 "../../../../ElevatorSystemB.ump"
// line 60 "../../../../ElevatorSystemB.ump"
public class Elevator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Elevator Attributes
  private String identifier;
  private String state;
  private String directionOfMovement;

  //Elevator Associations
  private List<ConsoleCallButton> consoleCallButtons;
  private List<DownCallButton> downCallButtons;
  private List<UpCallButton> upCallButtons;
  private List<Floor> floors;
  private FullSystem fullSystem;
  private CloseDoorButton closeDoorButton;
  private OpenDoorButton openDoorButton;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Elevator(String aIdentifier, String aState, String aDirectionOfMovement, FullSystem aFullSystem, CloseDoorButton aCloseDoorButton, OpenDoorButton aOpenDoorButton)
  {
    identifier = aIdentifier;
    state = aState;
    directionOfMovement = aDirectionOfMovement;
    consoleCallButtons = new ArrayList<ConsoleCallButton>();
    downCallButtons = new ArrayList<DownCallButton>();
    upCallButtons = new ArrayList<UpCallButton>();
    floors = new ArrayList<Floor>();
    boolean didAddFullSystem = setFullSystem(aFullSystem);
    if (!didAddFullSystem)
    {
      throw new RuntimeException("Unable to create elevator due to fullSystem");
    }
    if (aCloseDoorButton == null || aCloseDoorButton.getElevator() != null)
    {
      throw new RuntimeException("Unable to create Elevator due to aCloseDoorButton");
    }
    closeDoorButton = aCloseDoorButton;
    if (aOpenDoorButton == null || aOpenDoorButton.getElevator() != null)
    {
      throw new RuntimeException("Unable to create Elevator due to aOpenDoorButton");
    }
    openDoorButton = aOpenDoorButton;
  }

  public Elevator(String aIdentifier, String aState, String aDirectionOfMovement, FullSystem aFullSystem, boolean aLightOnForCloseDoorButton, boolean aLightOnForOpenDoorButton)
  {
    identifier = aIdentifier;
    state = aState;
    directionOfMovement = aDirectionOfMovement;
    consoleCallButtons = new ArrayList<ConsoleCallButton>();
    downCallButtons = new ArrayList<DownCallButton>();
    upCallButtons = new ArrayList<UpCallButton>();
    floors = new ArrayList<Floor>();
    boolean didAddFullSystem = setFullSystem(aFullSystem);
    if (!didAddFullSystem)
    {
      throw new RuntimeException("Unable to create elevator due to fullSystem");
    }
    closeDoorButton = new CloseDoorButton(aLightOnForCloseDoorButton, this);
    openDoorButton = new OpenDoorButton(aLightOnForOpenDoorButton, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdentifier(String aIdentifier)
  {
    boolean wasSet = false;
    identifier = aIdentifier;
    wasSet = true;
    return wasSet;
  }

  public boolean setState(String aState)
  {
    boolean wasSet = false;
    state = aState;
    wasSet = true;
    return wasSet;
  }

  public boolean setDirectionOfMovement(String aDirectionOfMovement)
  {
    boolean wasSet = false;
    directionOfMovement = aDirectionOfMovement;
    wasSet = true;
    return wasSet;
  }

  public String getIdentifier()
  {
    return identifier;
  }

  public String getState()
  {
    return state;
  }

  public String getDirectionOfMovement()
  {
    return directionOfMovement;
  }

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

  public DownCallButton getDownCallButton(int index)
  {
    DownCallButton aDownCallButton = downCallButtons.get(index);
    return aDownCallButton;
  }

  public List<DownCallButton> getDownCallButtons()
  {
    List<DownCallButton> newDownCallButtons = Collections.unmodifiableList(downCallButtons);
    return newDownCallButtons;
  }

  public int numberOfDownCallButtons()
  {
    int number = downCallButtons.size();
    return number;
  }

  public boolean hasDownCallButtons()
  {
    boolean has = downCallButtons.size() > 0;
    return has;
  }

  public int indexOfDownCallButton(DownCallButton aDownCallButton)
  {
    int index = downCallButtons.indexOf(aDownCallButton);
    return index;
  }

  public UpCallButton getUpCallButton(int index)
  {
    UpCallButton aUpCallButton = upCallButtons.get(index);
    return aUpCallButton;
  }

  public List<UpCallButton> getUpCallButtons()
  {
    List<UpCallButton> newUpCallButtons = Collections.unmodifiableList(upCallButtons);
    return newUpCallButtons;
  }

  public int numberOfUpCallButtons()
  {
    int number = upCallButtons.size();
    return number;
  }

  public boolean hasUpCallButtons()
  {
    boolean has = upCallButtons.size() > 0;
    return has;
  }

  public int indexOfUpCallButton(UpCallButton aUpCallButton)
  {
    int index = upCallButtons.indexOf(aUpCallButton);
    return index;
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

  public FullSystem getFullSystem()
  {
    return fullSystem;
  }

  public CloseDoorButton getCloseDoorButton()
  {
    return closeDoorButton;
  }

  public OpenDoorButton getOpenDoorButton()
  {
    return openDoorButton;
  }

  public static int minimumNumberOfConsoleCallButtons()
  {
    return 0;
  }

  public ConsoleCallButton addConsoleCallButton(boolean aLightOn, Floor aFloor)
  {
    return new ConsoleCallButton(aLightOn, this, aFloor);
  }

  public boolean addConsoleCallButton(ConsoleCallButton aConsoleCallButton)
  {
    boolean wasAdded = false;
    if (consoleCallButtons.contains(aConsoleCallButton)) { return false; }
    Elevator existingElevator = aConsoleCallButton.getElevator();
    boolean isNewElevator = existingElevator != null && !this.equals(existingElevator);
    if (isNewElevator)
    {
      aConsoleCallButton.setElevator(this);
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
    //Unable to remove aConsoleCallButton, as it must always have a elevator
    if (!this.equals(aConsoleCallButton.getElevator()))
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

  public static int minimumNumberOfDownCallButtons()
  {
    return 0;
  }

  public boolean addDownCallButton(DownCallButton aDownCallButton)
  {
    boolean wasAdded = false;
    if (downCallButtons.contains(aDownCallButton)) { return false; }
    downCallButtons.add(aDownCallButton);
    if (aDownCallButton.indexOfElevator(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDownCallButton.addElevator(this);
      if (!wasAdded)
      {
        downCallButtons.remove(aDownCallButton);
      }
    }
    return wasAdded;
  }

  public boolean removeDownCallButton(DownCallButton aDownCallButton)
  {
    boolean wasRemoved = false;
    if (!downCallButtons.contains(aDownCallButton))
    {
      return wasRemoved;
    }

    int oldIndex = downCallButtons.indexOf(aDownCallButton);
    downCallButtons.remove(oldIndex);
    if (aDownCallButton.indexOfElevator(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDownCallButton.removeElevator(this);
      if (!wasRemoved)
      {
        downCallButtons.add(oldIndex,aDownCallButton);
      }
    }
    return wasRemoved;
  }

  public boolean addDownCallButtonAt(DownCallButton aDownCallButton, int index)
  {  
    boolean wasAdded = false;
    if(addDownCallButton(aDownCallButton))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDownCallButtons()) { index = numberOfDownCallButtons() - 1; }
      downCallButtons.remove(aDownCallButton);
      downCallButtons.add(index, aDownCallButton);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDownCallButtonAt(DownCallButton aDownCallButton, int index)
  {
    boolean wasAdded = false;
    if(downCallButtons.contains(aDownCallButton))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDownCallButtons()) { index = numberOfDownCallButtons() - 1; }
      downCallButtons.remove(aDownCallButton);
      downCallButtons.add(index, aDownCallButton);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDownCallButtonAt(aDownCallButton, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfUpCallButtons()
  {
    return 0;
  }

  public boolean addUpCallButton(UpCallButton aUpCallButton)
  {
    boolean wasAdded = false;
    if (upCallButtons.contains(aUpCallButton)) { return false; }
    upCallButtons.add(aUpCallButton);
    if (aUpCallButton.indexOfElevator(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUpCallButton.addElevator(this);
      if (!wasAdded)
      {
        upCallButtons.remove(aUpCallButton);
      }
    }
    return wasAdded;
  }

  public boolean removeUpCallButton(UpCallButton aUpCallButton)
  {
    boolean wasRemoved = false;
    if (!upCallButtons.contains(aUpCallButton))
    {
      return wasRemoved;
    }

    int oldIndex = upCallButtons.indexOf(aUpCallButton);
    upCallButtons.remove(oldIndex);
    if (aUpCallButton.indexOfElevator(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUpCallButton.removeElevator(this);
      if (!wasRemoved)
      {
        upCallButtons.add(oldIndex,aUpCallButton);
      }
    }
    return wasRemoved;
  }

  public boolean addUpCallButtonAt(UpCallButton aUpCallButton, int index)
  {  
    boolean wasAdded = false;
    if(addUpCallButton(aUpCallButton))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUpCallButtons()) { index = numberOfUpCallButtons() - 1; }
      upCallButtons.remove(aUpCallButton);
      upCallButtons.add(index, aUpCallButton);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUpCallButtonAt(UpCallButton aUpCallButton, int index)
  {
    boolean wasAdded = false;
    if(upCallButtons.contains(aUpCallButton))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUpCallButtons()) { index = numberOfUpCallButtons() - 1; }
      upCallButtons.remove(aUpCallButton);
      upCallButtons.add(index, aUpCallButton);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUpCallButtonAt(aUpCallButton, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfFloors()
  {
    return 0;
  }

  public boolean addFloor(Floor aFloor)
  {
    boolean wasAdded = false;
    if (floors.contains(aFloor)) { return false; }
    floors.add(aFloor);
    if (aFloor.indexOfElevator(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aFloor.addElevator(this);
      if (!wasAdded)
      {
        floors.remove(aFloor);
      }
    }
    return wasAdded;
  }

  public boolean removeFloor(Floor aFloor)
  {
    boolean wasRemoved = false;
    if (!floors.contains(aFloor))
    {
      return wasRemoved;
    }

    int oldIndex = floors.indexOf(aFloor);
    floors.remove(oldIndex);
    if (aFloor.indexOfElevator(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aFloor.removeElevator(this);
      if (!wasRemoved)
      {
        floors.add(oldIndex,aFloor);
      }
    }
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

  public boolean setFullSystem(FullSystem aFullSystem)
  {
    boolean wasSet = false;
    if (aFullSystem == null)
    {
      return wasSet;
    }

    FullSystem existingFullSystem = fullSystem;
    fullSystem = aFullSystem;
    if (existingFullSystem != null && !existingFullSystem.equals(aFullSystem))
    {
      existingFullSystem.removeElevator(this);
    }
    fullSystem.addElevator(this);
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
    ArrayList<DownCallButton> copyOfDownCallButtons = new ArrayList<DownCallButton>(downCallButtons);
    downCallButtons.clear();
    for(DownCallButton aDownCallButton : copyOfDownCallButtons)
    {
      if (aDownCallButton.numberOfElevators() <= DownCallButton.minimumNumberOfElevators())
      {
        aDownCallButton.delete();
      }
      else
      {
        aDownCallButton.removeElevator(this);
      }
    }
    ArrayList<UpCallButton> copyOfUpCallButtons = new ArrayList<UpCallButton>(upCallButtons);
    upCallButtons.clear();
    for(UpCallButton aUpCallButton : copyOfUpCallButtons)
    {
      if (aUpCallButton.numberOfElevators() <= UpCallButton.minimumNumberOfElevators())
      {
        aUpCallButton.delete();
      }
      else
      {
        aUpCallButton.removeElevator(this);
      }
    }
    ArrayList<Floor> copyOfFloors = new ArrayList<Floor>(floors);
    floors.clear();
    for(Floor aFloor : copyOfFloors)
    {
      aFloor.removeElevator(this);
    }
    FullSystem placeholderFullSystem = fullSystem;
    this.fullSystem = null;
    placeholderFullSystem.removeElevator(this);
    CloseDoorButton existingCloseDoorButton = closeDoorButton;
    closeDoorButton = null;
    if (existingCloseDoorButton != null)
    {
      existingCloseDoorButton.delete();
    }
    OpenDoorButton existingOpenDoorButton = openDoorButton;
    openDoorButton = null;
    if (existingOpenDoorButton != null)
    {
      existingOpenDoorButton.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "identifier" + ":" + getIdentifier()+ "," +
            "state" + ":" + getState()+ "," +
            "directionOfMovement" + ":" + getDirectionOfMovement()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "fullSystem = "+(getFullSystem()!=null?Integer.toHexString(System.identityHashCode(getFullSystem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "closeDoorButton = "+(getCloseDoorButton()!=null?Integer.toHexString(System.identityHashCode(getCloseDoorButton())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "openDoorButton = "+(getOpenDoorButton()!=null?Integer.toHexString(System.identityHashCode(getOpenDoorButton())):"null")
     + outputString;
  }
}