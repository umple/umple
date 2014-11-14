/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 6 "ApplicationProcessing.ump"
public class GrantApplication
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GrantApplication Attributes
  private boolean adminCheckOk;

  //GrantApplication State Machines
  enum Status { Planned, InProgress, EvaluationByInstitution, VerifiedByInstitution, SubmittedByInstitution, UnderAdministrativeReview, UnderExpertReview, AwaitingFinalDecision, Accepted, Rejected, Withdrawn }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GrantApplication()
  {
    adminCheckOk = false;
    setStatus(Status.Planned);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAdminCheckOk(boolean aAdminCheckOk)
  {
    boolean wasSet = false;
    adminCheckOk = aAdminCheckOk;
    wasSet = true;
    return wasSet;
  }

  public boolean getAdminCheckOk()
  {
    return adminCheckOk;
  }

  public boolean isAdminCheckOk()
  {
    return adminCheckOk;
  }

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean createApplication()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Planned:
        setStatus(Status.InProgress);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean researcherDeclaresComplete()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case InProgress:
        setStatus(Status.EvaluationByInstitution);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean editByResearcher()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case InProgress:
        setStatus(Status.InProgress);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean returnToResearcher()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case EvaluationByInstitution:
        setStatus(Status.InProgress);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean verified()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case EvaluationByInstitution:
        setStatus(Status.VerifiedByInstitution);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean editByInstitution()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case EvaluationByInstitution:
        setStatus(Status.EvaluationByInstitution);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean reOpen()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case VerifiedByInstitution:
        setStatus(Status.EvaluationByInstitution);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean submit()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case VerifiedByInstitution:
        setStatus(Status.SubmittedByInstitution);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean withdraw()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case SubmittedByInstitution:
        setStatus(Status.Withdrawn);
        wasEventProcessed = true;
        break;
      case UnderAdministrativeReview:
        setStatus(Status.Withdrawn);
        wasEventProcessed = true;
        break;
      case UnderExpertReview:
        setStatus(Status.Withdrawn);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean acceptForReview()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case SubmittedByInstitution:
        setStatus(Status.UnderAdministrativeReview);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean submissionCheck()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case SubmittedByInstitution:
        if (getAdminCheckOk())
        {
          setStatus(Status.SubmittedByInstitution);
          wasEventProcessed = true;
          break;
        }
        if (!getAdminCheckOk())
        {
          setStatus(Status.EvaluationByInstitution);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean acceptForExpertReview()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case UnderAdministrativeReview:
        setStatus(Status.UnderExpertReview);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean bypassExpertReviewDueToMinorChanges()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case UnderAdministrativeReview:
        setStatus(Status.AwaitingFinalDecision);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean returnToInstitition()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case UnderAdministrativeReview:
        setStatus(Status.EvaluationByInstitution);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean expertReviewsReturned()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case UnderExpertReview:
        setStatus(Status.AwaitingFinalDecision);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean finalAccept()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case AwaitingFinalDecision:
        setStatus(Status.Accepted);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean minorRevisionsNeeded()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case AwaitingFinalDecision:
        setStatus(Status.EvaluationByInstitution);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean reject()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case AwaitingFinalDecision:
        setStatus(Status.Rejected);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean tryAgain()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Rejected:
        setStatus(Status.InProgress);
        wasEventProcessed = true;
        break;
      case Withdrawn:
        setStatus(Status.InProgress);
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


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "adminCheckOk" + ":" + getAdminCheckOk()+ "]"
     + outputString;
  }
}