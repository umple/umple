/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 9 "ClassTemplateTest_StateMachineImplementsPartialInterface.ump"
public class Router implements NetworkNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Router Attributes
  private String ipAddress;

  //Router State Machines
  public enum Status { disconnected, connected }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Router(String aIpAddress)
  {
    ipAddress = aIpAddress;
    setStatus(Status.disconnected);
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

  @Override
  public boolean connect()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case disconnected:
        setStatus(Status.connected);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  @Override
  public boolean disconnect()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case connected:
        setStatus(Status.disconnected);
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

  @Override
  public boolean errorDetected(){
          return false;
  }


  public String toString()
  {
    return super.toString() + "["+ "]";
  }
}