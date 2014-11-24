/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 36 "ElevatorSystemB.ump"
// line 96 "ElevatorSystemB.ump"
public class CloseDoorButton extends Button
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CloseDoorButton Associations
  private Elevator elevator;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CloseDoorButton(boolean aLightOn, Elevator aElevator)
  {
    super(aLightOn);
    if (aElevator == null || aElevator.getCloseDoorButton() != null)
    {
      throw new RuntimeException("Unable to create CloseDoorButton due to aElevator");
    }
    elevator = aElevator;
  }

  public CloseDoorButton(boolean aLightOn, String aIdentifierForElevator, String aStateForElevator, String aDirectionOfMovementForElevator, FullSystem aFullSystemForElevator, OpenDoorButton aOpenDoorButtonForElevator)
  {
    super(aLightOn);
    elevator = new Elevator(aIdentifierForElevator, aStateForElevator, aDirectionOfMovementForElevator, aFullSystemForElevator, this, aOpenDoorButtonForElevator);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Elevator getElevator()
  {
    return elevator;
  }

  public void delete()
  {
    Elevator existingElevator = elevator;
    elevator = null;
    if (existingElevator != null)
    {
      existingElevator.delete();
    }
    super.delete();
  }

}