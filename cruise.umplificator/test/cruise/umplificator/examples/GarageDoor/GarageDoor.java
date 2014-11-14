/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 5 "GarageDoor.ump"
public class GarageDoor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GarageDoor State Machines
  enum Status { Open, Closing, Closed, Opening, HalfOpen }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GarageDoor()
  {
    setStatus(Status.Open);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean buttonOrObstacle()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Open:
        setStatus(Status.Closing);
        wasEventProcessed = true;
        break;
      case Closing:
        setStatus(Status.Opening);
        wasEventProcessed = true;
        break;
      case Closed:
        setStatus(Status.Opening);
        wasEventProcessed = true;
        break;
      case Opening:
        setStatus(Status.HalfOpen);
        wasEventProcessed = true;
        break;
      case HalfOpen:
        setStatus(Status.Opening);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean reachBottom()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Closing:
        setStatus(Status.Closed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean reachTop()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Opening:
        setStatus(Status.Open);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;
  }

  public void delete()
  {}

}