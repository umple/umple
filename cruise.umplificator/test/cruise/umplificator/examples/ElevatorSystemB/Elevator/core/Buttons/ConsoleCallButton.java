/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package Elevator.core.Buttons;

// line 54 "../../../../ElevatorSystemB.ump"
// line 76 "../../../../ElevatorSystemB.ump"
public class ConsoleCallButton extends Button
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConsoleCallButton Associations
  private Elevator elevator;
  private Floor floor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConsoleCallButton(boolean aLightOn, Elevator aElevator, Floor aFloor)
  {
    super(aLightOn);
    boolean didAddElevator = setElevator(aElevator);
    if (!didAddElevator)
    {
      throw new RuntimeException("Unable to create consoleCallButton due to elevator");
    }
    boolean didAddFloor = setFloor(aFloor);
    if (!didAddFloor)
    {
      throw new RuntimeException("Unable to create consoleCallButton due to floor");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Elevator getElevator()
  {
    return elevator;
  }

  public Floor getFloor()
  {
    return floor;
  }

  public boolean setElevator(Elevator aElevator)
  {
    boolean wasSet = false;
    if (aElevator == null)
    {
      return wasSet;
    }

    Elevator existingElevator = elevator;
    elevator = aElevator;
    if (existingElevator != null && !existingElevator.equals(aElevator))
    {
      existingElevator.removeConsoleCallButton(this);
    }
    elevator.addConsoleCallButton(this);
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
      existingFloor.removeConsoleCallButton(this);
    }
    floor.addConsoleCallButton(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Elevator placeholderElevator = elevator;
    this.elevator = null;
    placeholderElevator.removeConsoleCallButton(this);
    Floor placeholderFloor = floor;
    this.floor = null;
    placeholderFloor.removeConsoleCallButton(this);
    super.delete();
  }

}