/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package Elevator.core.Buttons;
import Elevator.core.Buttons.*;

// line 27 "../../../../ElevatorSystemB.ump"
// line 71 "../../../../ElevatorSystemB.ump"
public class FloorNumberDisplay
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FloorNumberDisplay Associations
  private Floor floor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FloorNumberDisplay(Floor aFloor)
  {
    boolean didAddFloor = setFloor(aFloor);
    if (!didAddFloor)
    {
      throw new RuntimeException("Unable to create floorNumberDisplay due to floor");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Floor getFloor()
  {
    return floor;
  }

  public boolean setFloor(Floor aNewFloor)
  {
    boolean wasSet = false;
    if (aNewFloor == null)
    {
      //Unable to setFloor to null, as floorNumberDisplay must always be associated to a floor
      return wasSet;
    }
    
    FloorNumberDisplay existingFloorNumberDisplay = aNewFloor.getFloorNumberDisplay();
    if (existingFloorNumberDisplay != null && !equals(existingFloorNumberDisplay))
    {
      //Unable to setFloor, the current floor already has a floorNumberDisplay, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Floor anOldFloor = floor;
    floor = aNewFloor;
    floor.setFloorNumberDisplay(this);

    if (anOldFloor != null)
    {
      anOldFloor.setFloorNumberDisplay(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Floor existingFloor = floor;
    floor = null;
    if (existingFloor != null)
    {
      existingFloor.setFloorNumberDisplay(null);
    }
  }

}