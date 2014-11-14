/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 4 "TollBooth.ump"
public class TollLane
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TollLane State Machines
  enum VehicleProcessingState { Empty, VehicleClassified, VehicleFreeToGo, ExitSensorActive, ReverseEntry }
  private VehicleProcessingState vehicleProcessingState;
  enum LaneAndBoothState { Closed, Opening, Open, Closing }
  private LaneAndBoothState laneAndBoothState;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TollLane()
  {
    setVehicleProcessingState(VehicleProcessingState.Empty);
    setLaneAndBoothState(LaneAndBoothState.Closed);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getVehicleProcessingStateFullName()
  {
    String answer = vehicleProcessingState.toString();
    return answer;
  }

  public String getLaneAndBoothStateFullName()
  {
    String answer = laneAndBoothState.toString();
    return answer;
  }

  public VehicleProcessingState getVehicleProcessingState()
  {
    return vehicleProcessingState;
  }

  public LaneAndBoothState getLaneAndBoothState()
  {
    return laneAndBoothState;
  }

  public boolean classify()
  {
    boolean wasEventProcessed = false;
    
    VehicleProcessingState aVehicleProcessingState = vehicleProcessingState;
    switch (aVehicleProcessingState)
    {
      case Empty:
        setVehicleProcessingState(VehicleProcessingState.VehicleClassified);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean vehicleActivatedExitSensor()
  {
    boolean wasEventProcessed = false;
    
    VehicleProcessingState aVehicleProcessingState = vehicleProcessingState;
    switch (aVehicleProcessingState)
    {
      case Empty:
        setVehicleProcessingState(VehicleProcessingState.ExitSensorActive);
        wasEventProcessed = true;
        break;
      case VehicleClassified:
        setVehicleProcessingState(VehicleProcessingState.ExitSensorActive);
        wasEventProcessed = true;
        break;
      case VehicleFreeToGo:
        setVehicleProcessingState(VehicleProcessingState.ExitSensorActive);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean vehicleActivatedExitSensorReverseDirection()
  {
    boolean wasEventProcessed = false;
    
    VehicleProcessingState aVehicleProcessingState = vehicleProcessingState;
    switch (aVehicleProcessingState)
    {
      case Empty:
        setVehicleProcessingState(VehicleProcessingState.ReverseEntry);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean paymentComplete()
  {
    boolean wasEventProcessed = false;
    
    VehicleProcessingState aVehicleProcessingState = vehicleProcessingState;
    switch (aVehicleProcessingState)
    {
      case VehicleClassified:
        setVehicleProcessingState(VehicleProcessingState.VehicleFreeToGo);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean cancel()
  {
    boolean wasEventProcessed = false;
    
    VehicleProcessingState aVehicleProcessingState = vehicleProcessingState;
    switch (aVehicleProcessingState)
    {
      case VehicleClassified:
        setVehicleProcessingState(VehicleProcessingState.Empty);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean unblock()
  {
    boolean wasEventProcessed = false;
    
    VehicleProcessingState aVehicleProcessingState = vehicleProcessingState;
    switch (aVehicleProcessingState)
    {
      case VehicleFreeToGo:
        setVehicleProcessingState(VehicleProcessingState.Empty);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean exitSensorDeactivated()
  {
    boolean wasEventProcessed = false;
    
    VehicleProcessingState aVehicleProcessingState = vehicleProcessingState;
    switch (aVehicleProcessingState)
    {
      case ExitSensorActive:
        setVehicleProcessingState(VehicleProcessingState.Empty);
        wasEventProcessed = true;
        break;
      case ReverseEntry:
        setVehicleProcessingState(VehicleProcessingState.Empty);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean exitSensorDeactivatedReverseDirection()
  {
    boolean wasEventProcessed = false;
    
    VehicleProcessingState aVehicleProcessingState = vehicleProcessingState;
    switch (aVehicleProcessingState)
    {
      case ReverseEntry:
        setVehicleProcessingState(VehicleProcessingState.VehicleFreeToGo);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean open()
  {
    boolean wasEventProcessed = false;
    
    LaneAndBoothState aLaneAndBoothState = laneAndBoothState;
    switch (aLaneAndBoothState)
    {
      case Closed:
        setLaneAndBoothState(LaneAndBoothState.Opening);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean completedOpening()
  {
    boolean wasEventProcessed = false;
    
    LaneAndBoothState aLaneAndBoothState = laneAndBoothState;
    switch (aLaneAndBoothState)
    {
      case Opening:
        setLaneAndBoothState(LaneAndBoothState.Open);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean cancelOpening()
  {
    boolean wasEventProcessed = false;
    
    LaneAndBoothState aLaneAndBoothState = laneAndBoothState;
    switch (aLaneAndBoothState)
    {
      case Opening:
        setLaneAndBoothState(LaneAndBoothState.Closed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean close()
  {
    boolean wasEventProcessed = false;
    
    LaneAndBoothState aLaneAndBoothState = laneAndBoothState;
    switch (aLaneAndBoothState)
    {
      case Open:
        setLaneAndBoothState(LaneAndBoothState.Closing);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean cancelClosing()
  {
    boolean wasEventProcessed = false;
    
    LaneAndBoothState aLaneAndBoothState = laneAndBoothState;
    switch (aLaneAndBoothState)
    {
      case Closing:
        setLaneAndBoothState(LaneAndBoothState.Open);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean completedClosing()
  {
    boolean wasEventProcessed = false;
    
    LaneAndBoothState aLaneAndBoothState = laneAndBoothState;
    switch (aLaneAndBoothState)
    {
      case Closing:
        setLaneAndBoothState(LaneAndBoothState.Closed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setVehicleProcessingState(VehicleProcessingState aVehicleProcessingState)
  {
    vehicleProcessingState = aVehicleProcessingState;
  }

  private void setLaneAndBoothState(LaneAndBoothState aLaneAndBoothState)
  {
    laneAndBoothState = aLaneAndBoothState;
  }

  public void delete()
  {}

}