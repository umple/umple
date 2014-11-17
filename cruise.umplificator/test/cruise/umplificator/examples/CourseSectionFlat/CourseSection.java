/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 10 "CourseSectionFlat.ump"
public class CourseSection
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseSection State Machines
  enum Status { Planned, OpenNotEnoughStudents, OpenEnoughStudents, Cancelled, Closed }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseSection()
  {
    setStatus(Status.Planned);
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

  public boolean cancel()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Planned:
        setStatus(Status.Cancelled);
        wasEventProcessed = true;
        break;
      case OpenNotEnoughStudents:
        setStatus(Status.Cancelled);
        wasEventProcessed = true;
        break;
      case OpenEnoughStudents:
        setStatus(Status.Cancelled);
        wasEventProcessed = true;
        break;
      case Closed:
        setStatus(Status.Cancelled);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean openRegistration()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Planned:
        setStatus(Status.OpenNotEnoughStudents);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean requestToRegister()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case OpenNotEnoughStudents:
        setStatus(Status.OpenNotEnoughStudents);
        wasEventProcessed = true;
        break;
      case OpenEnoughStudents:
        setStatus(Status.OpenEnoughStudents);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean closeRegistration()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case OpenNotEnoughStudents:
        setStatus(Status.Cancelled);
        wasEventProcessed = true;
        break;
      case OpenEnoughStudents:
        setStatus(Status.Closed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean classSizeExceedsMinimum()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case OpenNotEnoughStudents:
        setStatus(Status.OpenEnoughStudents);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean classSizeExceedsMaximum()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case OpenEnoughStudents:
        setStatus(Status.Closed);
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