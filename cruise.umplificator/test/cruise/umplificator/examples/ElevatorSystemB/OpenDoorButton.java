/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 40 "ElevatorSystemB.ump"
// line 91 "ElevatorSystemB.ump"
public class OpenDoorButton extends Button
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OpenDoorButton Associations
  private Elevator elevator;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OpenDoorButton(boolean aLightOn, Elevator aElevator)
  {
    super(aLightOn);
    if (aElevator == null || aElevator.getOpenDoorButton() != null)
    {
      throw new RuntimeException("Unable to create OpenDoorButton due to aElevator");
    }
    elevator = aElevator;
  }

  public OpenDoorButton(boolean aLightOn, String aIdentifierForElevator, String aStateForElevator, String aDirectionOfMovementForElevator, FullSystem aFullSystemForElevator, CloseDoorButton aCloseDoorButtonForElevator)
  {
    super(aLightOn);
    elevator = new Elevator(aIdentifierForElevator, aStateForElevator, aDirectionOfMovementForElevator, aFullSystemForElevator, aCloseDoorButtonForElevator, this);
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