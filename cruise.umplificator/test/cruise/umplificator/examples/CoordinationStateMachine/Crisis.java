/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 23 "CoordinationStateMachine.ump"
public class Crisis
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Crisis Attributes
  private int timeoutInMs;
  private boolean thisSideInitiator;
  private boolean thisSideInitiatorOfTermination;
  private boolean routeAgreedYet;
  private boolean police;

  //Crisis State Machines
  enum CrisisCoordinationStage { noCrisis, establishingCommunication, managingCrisis }
  enum CrisisCoordinationStageExchangingDetails { Null, exchangingDetails }
  enum CrisisCoordinationStageCrisisEndManagement { Null, crisisEndManagement }
  enum CrisisCoordinationStageCrisisEndManagementCrisisEndManagement { Null, ongoingCrisis, waitingForUserTerminationAgreement, waitingForTerminationConfirmation, tearDown }
  enum CrisisCoordinationStageNegotiatingRoutePlan { Null, negotiatingRoutePlan }
  enum CrisisCoordinationStageNegotiatingRoutePlanNegotiation { Null, negotiation }
  enum CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation { Null, planningRoute, approvingRoute, awaitingRouteApproval, routeAgreed, noRouteAgreement }
  enum CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness { Null, managingTimeliness }
  enum CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness { Null, timeAcceptable, timeUnacceptable }
  private CrisisCoordinationStage crisisCoordinationStage;
  private CrisisCoordinationStageExchangingDetails crisisCoordinationStageExchangingDetails;
  private CrisisCoordinationStageCrisisEndManagement crisisCoordinationStageCrisisEndManagement;
  private CrisisCoordinationStageCrisisEndManagementCrisisEndManagement crisisCoordinationStageCrisisEndManagementCrisisEndManagement;
  private CrisisCoordinationStageNegotiatingRoutePlan crisisCoordinationStageNegotiatingRoutePlan;
  private CrisisCoordinationStageNegotiatingRoutePlanNegotiation crisisCoordinationStageNegotiatingRoutePlanNegotiation;
  private CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation;
  private CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness crisisCoordinationStageNegotiatingRoutePlanManagingTimeliness;
  private CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness;

  //Crisis Do Activity Threads
  Thread doActivityCrisisCoordinationStageCrisisEndManagementCrisisEndManagementWaitingForUserTerminationAgreementThread = null;
  Thread doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationPlanningRouteThread = null;
  Thread doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationApprovingRouteThread = null;
  Thread doActivityCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimelinessTimeUnacceptableThread = null;

  //Helper Variables
  private TimedEventHandler timeoutestablishingCommunicationTonoCrisisHandler;
  private TimedEventHandler timeoutwaitingForUserTerminationAgreementToongoingCrisisHandler;
  private TimedEventHandler timeoutwaitingForTerminationConfirmationToongoingCrisisHandler;
  private TimedEventHandler timeouttimeAcceptableTotimeUnacceptableHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Crisis(boolean aThisSideInitiator, boolean aThisSideInitiatorOfTermination, boolean aRouteAgreedYet, boolean aPolice)
  {
    timeoutInMs = 20000;
    thisSideInitiator = aThisSideInitiator;
    thisSideInitiatorOfTermination = aThisSideInitiatorOfTermination;
    routeAgreedYet = aRouteAgreedYet;
    police = aPolice;
    setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.Null);
    setCrisisCoordinationStageCrisisEndManagement(CrisisCoordinationStageCrisisEndManagement.Null);
    setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.Null);
    setCrisisCoordinationStageNegotiatingRoutePlan(CrisisCoordinationStageNegotiatingRoutePlan.Null);
    setCrisisCoordinationStageNegotiatingRoutePlanNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiation.Null);
    setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.Null);
    setCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness.Null);
    setCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.Null);
    setCrisisCoordinationStage(CrisisCoordinationStage.noCrisis);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTimeoutInMs(int aTimeoutInMs)
  {
    boolean wasSet = false;
    timeoutInMs = aTimeoutInMs;
    wasSet = true;
    return wasSet;
  }

  public boolean setThisSideInitiator(boolean aThisSideInitiator)
  {
    boolean wasSet = false;
    thisSideInitiator = aThisSideInitiator;
    wasSet = true;
    return wasSet;
  }

  public boolean setThisSideInitiatorOfTermination(boolean aThisSideInitiatorOfTermination)
  {
    boolean wasSet = false;
    thisSideInitiatorOfTermination = aThisSideInitiatorOfTermination;
    wasSet = true;
    return wasSet;
  }

  public boolean setRouteAgreedYet(boolean aRouteAgreedYet)
  {
    boolean wasSet = false;
    routeAgreedYet = aRouteAgreedYet;
    wasSet = true;
    return wasSet;
  }

  public boolean setPolice(boolean aPolice)
  {
    boolean wasSet = false;
    police = aPolice;
    wasSet = true;
    return wasSet;
  }

  /**
   * Number of ms allowed to negotiate routes,
   * establish credentials
   */
  public int getTimeoutInMs()
  {
    return timeoutInMs;
  }

  /**
   * True if we are the initiator of the crisis
   * request, false otherwise
   */
  public boolean getThisSideInitiator()
  {
    return thisSideInitiator;
  }

  public boolean getThisSideInitiatorOfTermination()
  {
    return thisSideInitiatorOfTermination;
  }

  public boolean getRouteAgreedYet()
  {
    return routeAgreedYet;
  }

  /**
   * True of we are the PSC, false of we are
   * the FSC
   */
  public boolean getPolice()
  {
    return police;
  }

  public boolean isThisSideInitiator()
  {
    return thisSideInitiator;
  }

  public boolean isThisSideInitiatorOfTermination()
  {
    return thisSideInitiatorOfTermination;
  }

  public boolean isRouteAgreedYet()
  {
    return routeAgreedYet;
  }

  public boolean isPolice()
  {
    return police;
  }

  public String getCrisisCoordinationStageFullName()
  {
    String answer = crisisCoordinationStage.toString();
    if (crisisCoordinationStageExchangingDetails != CrisisCoordinationStageExchangingDetails.Null) { answer += "." + crisisCoordinationStageExchangingDetails.toString(); }
    if (crisisCoordinationStageCrisisEndManagement != CrisisCoordinationStageCrisisEndManagement.Null) { answer += "." + crisisCoordinationStageCrisisEndManagement.toString(); }
    if (crisisCoordinationStageCrisisEndManagementCrisisEndManagement != CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.Null) { answer += "." + crisisCoordinationStageCrisisEndManagementCrisisEndManagement.toString(); }
    if (crisisCoordinationStageNegotiatingRoutePlan != CrisisCoordinationStageNegotiatingRoutePlan.Null) { answer += "." + crisisCoordinationStageNegotiatingRoutePlan.toString(); }
    if (crisisCoordinationStageNegotiatingRoutePlanNegotiation != CrisisCoordinationStageNegotiatingRoutePlanNegotiation.Null) { answer += "." + crisisCoordinationStageNegotiatingRoutePlanNegotiation.toString(); }
    if (crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation != CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.Null) { answer += "." + crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.toString(); }
    if (crisisCoordinationStageNegotiatingRoutePlanManagingTimeliness != CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness.Null) { answer += "." + crisisCoordinationStageNegotiatingRoutePlanManagingTimeliness.toString(); }
    if (crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness != CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.Null) { answer += "." + crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.toString(); }
    if (crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation != CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.Null) { answer += "." + crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.toString(); }
    if (crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness != CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.Null) { answer += "." + crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.toString(); }
    return answer;
  }

  public CrisisCoordinationStage getCrisisCoordinationStage()
  {
    return crisisCoordinationStage;
  }

  public CrisisCoordinationStageExchangingDetails getCrisisCoordinationStageExchangingDetails()
  {
    return crisisCoordinationStageExchangingDetails;
  }

  public CrisisCoordinationStageCrisisEndManagement getCrisisCoordinationStageCrisisEndManagement()
  {
    return crisisCoordinationStageCrisisEndManagement;
  }

  public CrisisCoordinationStageCrisisEndManagementCrisisEndManagement getCrisisCoordinationStageCrisisEndManagementCrisisEndManagement()
  {
    return crisisCoordinationStageCrisisEndManagementCrisisEndManagement;
  }

  public CrisisCoordinationStageNegotiatingRoutePlan getCrisisCoordinationStageNegotiatingRoutePlan()
  {
    return crisisCoordinationStageNegotiatingRoutePlan;
  }

  public CrisisCoordinationStageNegotiatingRoutePlanNegotiation getCrisisCoordinationStageNegotiatingRoutePlanNegotiation()
  {
    return crisisCoordinationStageNegotiatingRoutePlanNegotiation;
  }

  public CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation getCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation()
  {
    return crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation;
  }

  public CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness getCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness()
  {
    return crisisCoordinationStageNegotiatingRoutePlanManagingTimeliness;
  }

  public CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness getCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness()
  {
    return crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness;
  }

  public boolean initiateCrisis()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStage aCrisisCoordinationStage = crisisCoordinationStage;
    switch (aCrisisCoordinationStage)
    {
      case noCrisis:
        // line 52 "CoordinationStateMachine.ump"
        setThisSideInitiator(true);
        sendInitiateCrisisRequestToOtherSC();
        setCrisisCoordinationStage(CrisisCoordinationStage.establishingCommunication);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveInitiateCrisisRequest()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStage aCrisisCoordinationStage = crisisCoordinationStage;
    switch (aCrisisCoordinationStage)
    {
      case noCrisis:
        setCrisisCoordinationStage(CrisisCoordinationStage.establishingCommunication);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean secureCredentialsConfirmed()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStage aCrisisCoordinationStage = crisisCoordinationStage;
    switch (aCrisisCoordinationStage)
    {
      case establishingCommunication:
        setCrisisCoordinationStage(CrisisCoordinationStage.managingCrisis);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutestablishingCommunicationTonoCrisis()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStage aCrisisCoordinationStage = crisisCoordinationStage;
    switch (aCrisisCoordinationStage)
    {
      case establishingCommunication:
        if (isThisSideInitiator())
        {
          setCrisisCoordinationStage(CrisisCoordinationStage.noCrisis);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterManagingCrisis()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails = crisisCoordinationStageExchangingDetails;
    CrisisCoordinationStageCrisisEndManagement aCrisisCoordinationStageCrisisEndManagement = crisisCoordinationStageCrisisEndManagement;
    CrisisCoordinationStageCrisisEndManagementCrisisEndManagement aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement = crisisCoordinationStageCrisisEndManagementCrisisEndManagement;
    CrisisCoordinationStageNegotiatingRoutePlan aCrisisCoordinationStageNegotiatingRoutePlan = crisisCoordinationStageNegotiatingRoutePlan;
    CrisisCoordinationStageNegotiatingRoutePlanNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiation;
    CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation;
    CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness aCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness = crisisCoordinationStageNegotiatingRoutePlanManagingTimeliness;
    CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness aCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness = crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness;
    switch (aCrisisCoordinationStageExchangingDetails)
    {
      case Null:
        setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.exchangingDetails);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageCrisisEndManagement)
    {
      case Null:
        setCrisisCoordinationStageCrisisEndManagement(CrisisCoordinationStageCrisisEndManagement.crisisEndManagement);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement)
    {
      case Null:
        setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.ongoingCrisis);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageNegotiatingRoutePlan)
    {
      case Null:
        setCrisisCoordinationStageNegotiatingRoutePlan(CrisisCoordinationStageNegotiatingRoutePlan.negotiatingRoutePlan);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiation)
    {
      case Null:
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiation.negotiation);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation)
    {
      case Null:
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.planningRoute);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness)
    {
      case Null:
        setCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness.managingTimeliness);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness)
    {
      case Null:
        setCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.timeAcceptable);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitManagingCrisis()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails = crisisCoordinationStageExchangingDetails;
    CrisisCoordinationStageCrisisEndManagement aCrisisCoordinationStageCrisisEndManagement = crisisCoordinationStageCrisisEndManagement;
    CrisisCoordinationStageCrisisEndManagementCrisisEndManagement aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement = crisisCoordinationStageCrisisEndManagementCrisisEndManagement;
    CrisisCoordinationStageNegotiatingRoutePlan aCrisisCoordinationStageNegotiatingRoutePlan = crisisCoordinationStageNegotiatingRoutePlan;
    CrisisCoordinationStageNegotiatingRoutePlanNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiation;
    CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation;
    CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness aCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness = crisisCoordinationStageNegotiatingRoutePlanManagingTimeliness;
    CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness aCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness = crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness;
    switch (aCrisisCoordinationStageExchangingDetails)
    {
      case exchangingDetails:
        setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageCrisisEndManagement)
    {
      case crisisEndManagement:
        setCrisisCoordinationStageCrisisEndManagement(CrisisCoordinationStageCrisisEndManagement.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement)
    {
      case ongoingCrisis:
        setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.Null);
        wasEventProcessed = true;
        break;
      case waitingForUserTerminationAgreement:
        setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.Null);
        wasEventProcessed = true;
        break;
      case waitingForTerminationConfirmation:
        setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.Null);
        wasEventProcessed = true;
        break;
      case tearDown:
        setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageNegotiatingRoutePlan)
    {
      case negotiatingRoutePlan:
        setCrisisCoordinationStageNegotiatingRoutePlan(CrisisCoordinationStageNegotiatingRoutePlan.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiation)
    {
      case negotiation:
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiation.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation)
    {
      case planningRoute:
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.Null);
        wasEventProcessed = true;
        break;
      case approvingRoute:
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.Null);
        wasEventProcessed = true;
        break;
      case awaitingRouteApproval:
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.Null);
        wasEventProcessed = true;
        break;
      case routeAgreed:
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.Null);
        wasEventProcessed = true;
        break;
      case noRouteAgreement:
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness)
    {
      case managingTimeliness:
        setCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness)
    {
      case timeAcceptable:
        setCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.Null);
        wasEventProcessed = true;
        break;
      case timeUnacceptable:
        setCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean ourUpdateToCrisisData()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails = crisisCoordinationStageExchangingDetails;
    switch (aCrisisCoordinationStageExchangingDetails)
    {
      case exchangingDetails:
        // line 98 "CoordinationStateMachine.ump"
        sendCrisisData();
        setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.exchangingDetails);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveCrisisData()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails = crisisCoordinationStageExchangingDetails;
    switch (aCrisisCoordinationStageExchangingDetails)
    {
      case exchangingDetails:
        // line 101 "CoordinationStateMachine.ump"
        updateCrisisData();
        setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.exchangingDetails);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean ourVehicleDispatched()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails = crisisCoordinationStageExchangingDetails;
    switch (aCrisisCoordinationStageExchangingDetails)
    {
      case exchangingDetails:
        // line 106 "CoordinationStateMachine.ump"
        sendVehicleDispatch();
        setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.exchangingDetails);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveVehicleDispatched()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails = crisisCoordinationStageExchangingDetails;
    switch (aCrisisCoordinationStageExchangingDetails)
    {
      case exchangingDetails:
        // line 109 "CoordinationStateMachine.ump"
        updateTheirDispatch();
        setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.exchangingDetails);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean ourVehicleArrived()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails = crisisCoordinationStageExchangingDetails;
    switch (aCrisisCoordinationStageExchangingDetails)
    {
      case exchangingDetails:
        // line 114 "CoordinationStateMachine.ump"
        sendVehicleArrived();
        setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.exchangingDetails);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveVehicleArrived()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails = crisisCoordinationStageExchangingDetails;
    switch (aCrisisCoordinationStageExchangingDetails)
    {
      case exchangingDetails:
        // line 117 "CoordinationStateMachine.ump"
        updateTheirArrival();
        setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.exchangingDetails);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean ourVehicleMetObjective()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails = crisisCoordinationStageExchangingDetails;
    switch (aCrisisCoordinationStageExchangingDetails)
    {
      case exchangingDetails:
        // line 122 "CoordinationStateMachine.ump"
        sendVehicleMetObjective();
        setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.exchangingDetails);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveMetObjective()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails = crisisCoordinationStageExchangingDetails;
    switch (aCrisisCoordinationStageExchangingDetails)
    {
      case exchangingDetails:
        // line 125 "CoordinationStateMachine.ump"
        updateTheirMetObjective();
        setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.exchangingDetails);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean breakdown()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails = crisisCoordinationStageExchangingDetails;
    switch (aCrisisCoordinationStageExchangingDetails)
    {
      case exchangingDetails:
        // line 129 "CoordinationStateMachine.ump"
        dispatchAndUpdateOther();
        setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.exchangingDetails);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean initiateTermination()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageCrisisEndManagementCrisisEndManagement aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement = crisisCoordinationStageCrisisEndManagementCrisisEndManagement;
    switch (aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement)
    {
      case ongoingCrisis:
        // line 153 "CoordinationStateMachine.ump"
        setThisSideInitiatorOfTermination(true);
            sendTerminationRequestToOtherSC();
        setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.waitingForTerminationConfirmation);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveTerminationRequestFromOtherSC()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageCrisisEndManagementCrisisEndManagement aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement = crisisCoordinationStageCrisisEndManagementCrisisEndManagement;
    switch (aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement)
    {
      case ongoingCrisis:
        setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.waitingForUserTerminationAgreement);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean confirmTermination()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageCrisisEndManagementCrisisEndManagement aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement = crisisCoordinationStageCrisisEndManagementCrisisEndManagement;
    switch (aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement)
    {
      case waitingForUserTerminationAgreement:
        exitCrisisCoordinationStageCrisisEndManagementCrisisEndManagement();
        setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.tearDown);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutwaitingForUserTerminationAgreementToongoingCrisis()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageCrisisEndManagementCrisisEndManagement aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement = crisisCoordinationStageCrisisEndManagementCrisisEndManagement;
    switch (aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement)
    {
      case waitingForUserTerminationAgreement:
        exitCrisisCoordinationStageCrisisEndManagementCrisisEndManagement();
        setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.ongoingCrisis);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveTerminationConfirmation()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageCrisisEndManagementCrisisEndManagement aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement = crisisCoordinationStageCrisisEndManagementCrisisEndManagement;
    switch (aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement)
    {
      case waitingForTerminationConfirmation:
        exitCrisisCoordinationStageCrisisEndManagementCrisisEndManagement();
        setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.tearDown);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutwaitingForTerminationConfirmationToongoingCrisis()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageCrisisEndManagementCrisisEndManagement aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement = crisisCoordinationStageCrisisEndManagementCrisisEndManagement;
    switch (aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement)
    {
      case waitingForTerminationConfirmation:
        exitCrisisCoordinationStageCrisisEndManagementCrisisEndManagement();
        setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.ongoingCrisis);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean __autotransition3__()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageCrisisEndManagementCrisisEndManagement aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement = crisisCoordinationStageCrisisEndManagementCrisisEndManagement;
    switch (aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement)
    {
      case tearDown:
        exitCrisisCoordinationStageCrisisEndManagement();
        setCrisisCoordinationStage(CrisisCoordinationStage.noCrisis);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean informOfNumberOfVehicles()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageNegotiatingRoutePlanNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiation;
    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiation)
    {
      case negotiation:
        // line 196 "CoordinationStateMachine.ump"
        sendNumberOfVehicles();
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiation.negotiation);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveNumberOfVehicles()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageNegotiatingRoutePlanNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiation;
    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiation)
    {
      case negotiation:
        if (isPolice())
        {
          setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.planningRoute);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveRouteProposal()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageNegotiatingRoutePlanNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiation;
    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiation)
    {
      case negotiation:
        if (isPolice())
        {
          setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.approvingRoute);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveNoAgreeableRoute()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageNegotiatingRoutePlanNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiation;
    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiation)
    {
      case negotiation:
        if (isPolice())
        {
          setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.noRouteAgreement);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean routePlanComplete()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation;
    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation)
    {
      case planningRoute:
        exitCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation();
        // line 212 "CoordinationStateMachine.ump"
        sendPlanToFSC();
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.awaitingRouteApproval);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean noMoreRoutes()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation;
    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation)
    {
      case planningRoute:
        exitCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation();
        // line 218 "CoordinationStateMachine.ump"
        sendNoMoreRoutesToFSC();
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.noRouteAgreement);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean routeAcceptable()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation;
    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation)
    {
      case approvingRoute:
        exitCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation();
        // line 227 "CoordinationStateMachine.ump"
        sendApprovalToPSC();
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.routeAgreed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean routeUnacceptable()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation;
    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation)
    {
      case approvingRoute:
        exitCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation();
        // line 230 "CoordinationStateMachine.ump"
        sendDisapprovalToFSC();
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiation.negotiation);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveApprovalFromFSC()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation;
    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation)
    {
      case awaitingRouteApproval:
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.routeAgreed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean receiveDisapprovalFromFSC()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation = crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation;
    switch (aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation)
    {
      case awaitingRouteApproval:
        // line 243 "CoordinationStateMachine.ump"
        addRouteToDisapprovedChoices();
        setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.planningRoute);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeouttimeAcceptableTotimeUnacceptable()
  {
    boolean wasEventProcessed = false;
    
    CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness aCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness = crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness;
    switch (aCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness)
    {
      case timeAcceptable:
        if (isRouteAgreedYet())
        {
          exitCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness();
          setCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.timeUnacceptable);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitCrisisCoordinationStage()
  {
    switch(crisisCoordinationStage)
    {
      case managingCrisis:
        exitManagingCrisis();
        break;
    }
  }

  private void setCrisisCoordinationStage(CrisisCoordinationStage aCrisisCoordinationStage)
  {
    crisisCoordinationStage = aCrisisCoordinationStage;

    // entry actions and do activities
    switch(crisisCoordinationStage)
    {
      case noCrisis:
        // line 49 "CoordinationStateMachine.ump"
        setThisSideInitiator(false);
        break;
      case establishingCommunication:
        // line 66 "CoordinationStateMachine.ump"
        sendSecureCredentials();
        break;
      case managingCrisis:
        // line 89 "CoordinationStateMachine.ump"
        initiateEmptyCrisis();
        if (crisisCoordinationStageExchangingDetails == CrisisCoordinationStageExchangingDetails.Null) { setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails.exchangingDetails); }
        if (crisisCoordinationStageCrisisEndManagement == CrisisCoordinationStageCrisisEndManagement.Null) { setCrisisCoordinationStageCrisisEndManagement(CrisisCoordinationStageCrisisEndManagement.crisisEndManagement); }
        if (crisisCoordinationStageNegotiatingRoutePlan == CrisisCoordinationStageNegotiatingRoutePlan.Null) { setCrisisCoordinationStageNegotiatingRoutePlan(CrisisCoordinationStageNegotiatingRoutePlan.negotiatingRoutePlan); }
        break;
    }
  }

  private void setCrisisCoordinationStageExchangingDetails(CrisisCoordinationStageExchangingDetails aCrisisCoordinationStageExchangingDetails)
  {
    crisisCoordinationStageExchangingDetails = aCrisisCoordinationStageExchangingDetails;
    if (crisisCoordinationStage != CrisisCoordinationStage.managingCrisis && aCrisisCoordinationStageExchangingDetails != CrisisCoordinationStageExchangingDetails.Null) { setCrisisCoordinationStage(CrisisCoordinationStage.managingCrisis); }
  }

  private void exitCrisisCoordinationStageCrisisEndManagement()
  {
    switch(crisisCoordinationStageCrisisEndManagement)
    {
      case crisisEndManagement:
        exitManagingCrisis();
        break;
    }
  }

  private void setCrisisCoordinationStageCrisisEndManagement(CrisisCoordinationStageCrisisEndManagement aCrisisCoordinationStageCrisisEndManagement)
  {
    crisisCoordinationStageCrisisEndManagement = aCrisisCoordinationStageCrisisEndManagement;
    if (crisisCoordinationStage != CrisisCoordinationStage.managingCrisis && aCrisisCoordinationStageCrisisEndManagement != CrisisCoordinationStageCrisisEndManagement.Null) { setCrisisCoordinationStage(CrisisCoordinationStage.managingCrisis); }

    // entry actions and do activities
    switch(crisisCoordinationStageCrisisEndManagement)
    {
      case crisisEndManagement:
        if (crisisCoordinationStageCrisisEndManagementCrisisEndManagement == CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.Null) { setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.ongoingCrisis); }
        break;
    }
  }

  private void exitCrisisCoordinationStageCrisisEndManagementCrisisEndManagement()
  {
    switch(crisisCoordinationStageCrisisEndManagementCrisisEndManagement)
    {
      case waitingForUserTerminationAgreement:
        if (doActivityCrisisCoordinationStageCrisisEndManagementCrisisEndManagementWaitingForUserTerminationAgreementThread != null) { doActivityCrisisCoordinationStageCrisisEndManagementCrisisEndManagementWaitingForUserTerminationAgreementThread.interrupt(); }
        stopTimeoutwaitingForUserTerminationAgreementToongoingCrisisHandler();
        break;
      case waitingForTerminationConfirmation:
        stopTimeoutwaitingForTerminationConfirmationToongoingCrisisHandler();
        break;
    }
  }

  private void setCrisisCoordinationStageCrisisEndManagementCrisisEndManagement(CrisisCoordinationStageCrisisEndManagementCrisisEndManagement aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement)
  {
    crisisCoordinationStageCrisisEndManagementCrisisEndManagement = aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement;
    if (crisisCoordinationStageCrisisEndManagement != CrisisCoordinationStageCrisisEndManagement.crisisEndManagement && aCrisisCoordinationStageCrisisEndManagementCrisisEndManagement != CrisisCoordinationStageCrisisEndManagementCrisisEndManagement.Null) { setCrisisCoordinationStageCrisisEndManagement(CrisisCoordinationStageCrisisEndManagement.crisisEndManagement); }

    // entry actions and do activities
    switch(crisisCoordinationStageCrisisEndManagementCrisisEndManagement)
    {
      case waitingForUserTerminationAgreement:
        startTimeoutwaitingForUserTerminationAgreementToongoingCrisisHandler();
        doActivityCrisisCoordinationStageCrisisEndManagementCrisisEndManagementWaitingForUserTerminationAgreementThread = new DoActivityThread(this,"doActivityCrisisCoordinationStageCrisisEndManagementCrisisEndManagementWaitingForUserTerminationAgreement");
        break;
      case waitingForTerminationConfirmation:
        startTimeoutwaitingForTerminationConfirmationToongoingCrisisHandler();
        break;
      case tearDown:
        // line 181 "CoordinationStateMachine.ump"
        deleteCrisis();
        __autotransition3__();
        break;
    }
  }

  private void exitCrisisCoordinationStageNegotiatingRoutePlan()
  {
    switch(crisisCoordinationStageNegotiatingRoutePlan)
    {
      case negotiatingRoutePlan:
        exitManagingCrisis();
        break;
    }
  }

  private void setCrisisCoordinationStageNegotiatingRoutePlan(CrisisCoordinationStageNegotiatingRoutePlan aCrisisCoordinationStageNegotiatingRoutePlan)
  {
    crisisCoordinationStageNegotiatingRoutePlan = aCrisisCoordinationStageNegotiatingRoutePlan;
    if (crisisCoordinationStage != CrisisCoordinationStage.managingCrisis && aCrisisCoordinationStageNegotiatingRoutePlan != CrisisCoordinationStageNegotiatingRoutePlan.Null) { setCrisisCoordinationStage(CrisisCoordinationStage.managingCrisis); }

    // entry actions and do activities
    switch(crisisCoordinationStageNegotiatingRoutePlan)
    {
      case negotiatingRoutePlan:
        if (crisisCoordinationStageNegotiatingRoutePlanNegotiation == CrisisCoordinationStageNegotiatingRoutePlanNegotiation.Null) { setCrisisCoordinationStageNegotiatingRoutePlanNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiation.negotiation); }
        if (crisisCoordinationStageNegotiatingRoutePlanManagingTimeliness == CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness.Null) { setCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness.managingTimeliness); }
        break;
    }
  }

  private void exitCrisisCoordinationStageNegotiatingRoutePlanNegotiation()
  {
    switch(crisisCoordinationStageNegotiatingRoutePlanNegotiation)
    {
      case negotiation:
        exitManagingCrisis();
        break;
    }
  }

  private void setCrisisCoordinationStageNegotiatingRoutePlanNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiation)
  {
    crisisCoordinationStageNegotiatingRoutePlanNegotiation = aCrisisCoordinationStageNegotiatingRoutePlanNegotiation;
    if (crisisCoordinationStageNegotiatingRoutePlan != CrisisCoordinationStageNegotiatingRoutePlan.negotiatingRoutePlan && aCrisisCoordinationStageNegotiatingRoutePlanNegotiation != CrisisCoordinationStageNegotiatingRoutePlanNegotiation.Null) { setCrisisCoordinationStageNegotiatingRoutePlan(CrisisCoordinationStageNegotiatingRoutePlan.negotiatingRoutePlan); }

    // entry actions and do activities
    switch(crisisCoordinationStageNegotiatingRoutePlanNegotiation)
    {
      case negotiation:
        // line 194 "CoordinationStateMachine.ump"
        setRouteAgreedYet(false);
        if (crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation == CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.Null) { setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.planningRoute); }
        break;
    }
  }

  private void exitCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation()
  {
    switch(crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation)
    {
      case planningRoute:
        if (doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationPlanningRouteThread != null) { doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationPlanningRouteThread.interrupt(); }
        break;
      case approvingRoute:
        if (doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationApprovingRouteThread != null) { doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationApprovingRouteThread.interrupt(); }
        break;
    }
  }

  private void setCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation)
  {
    crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation = aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation;
    if (crisisCoordinationStageNegotiatingRoutePlanNegotiation != CrisisCoordinationStageNegotiatingRoutePlanNegotiation.negotiation && aCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation != CrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation.Null) { setCrisisCoordinationStageNegotiatingRoutePlanNegotiation(CrisisCoordinationStageNegotiatingRoutePlanNegotiation.negotiation); }

    // entry actions and do activities
    switch(crisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiation)
    {
      case planningRoute:
        doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationPlanningRouteThread = new DoActivityThread(this,"doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationPlanningRoute");
        break;
      case approvingRoute:
        doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationApprovingRouteThread = new DoActivityThread(this,"doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationApprovingRoute");
        break;
      case routeAgreed:
        // line 249 "CoordinationStateMachine.ump"
        setRouteAgreedYet(true);
        break;
    }
  }

  private void exitCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness()
  {
    switch(crisisCoordinationStageNegotiatingRoutePlanManagingTimeliness)
    {
      case managingTimeliness:
        exitManagingCrisis();
        break;
    }
  }

  private void setCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness aCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness)
  {
    crisisCoordinationStageNegotiatingRoutePlanManagingTimeliness = aCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness;
    if (crisisCoordinationStageNegotiatingRoutePlan != CrisisCoordinationStageNegotiatingRoutePlan.negotiatingRoutePlan && aCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness != CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness.Null) { setCrisisCoordinationStageNegotiatingRoutePlan(CrisisCoordinationStageNegotiatingRoutePlan.negotiatingRoutePlan); }

    // entry actions and do activities
    switch(crisisCoordinationStageNegotiatingRoutePlanManagingTimeliness)
    {
      case managingTimeliness:
        if (crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness == CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.Null) { setCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.timeAcceptable); }
        break;
    }
  }

  private void exitCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness()
  {
    switch(crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness)
    {
      case timeAcceptable:
        stopTimeouttimeAcceptableTotimeUnacceptableHandler();
        break;
      case timeUnacceptable:
        if (doActivityCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimelinessTimeUnacceptableThread != null) { doActivityCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimelinessTimeUnacceptableThread.interrupt(); }
        break;
    }
  }

  private void setCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness aCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness)
  {
    crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness = aCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness;
    if (crisisCoordinationStageNegotiatingRoutePlanManagingTimeliness != CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness.managingTimeliness && aCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness != CrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness.Null) { setCrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness(CrisisCoordinationStageNegotiatingRoutePlanManagingTimeliness.managingTimeliness); }

    // entry actions and do activities
    switch(crisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimeliness)
    {
      case timeAcceptable:
        startTimeouttimeAcceptableTotimeUnacceptableHandler();
        break;
      case timeUnacceptable:
        doActivityCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimelinessTimeUnacceptableThread = new DoActivityThread(this,"doActivityCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimelinessTimeUnacceptable");
        break;
    }
  }

  private void doActivityCrisisCoordinationStageCrisisEndManagementCrisisEndManagementWaitingForUserTerminationAgreement()
  {
    try
    {
      confirmWithUserToTerminate();
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private void doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationPlanningRoute()
  {
    try
    {
      planRoute();
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private void doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationApprovingRoute()
  {
    try
    {
      userConfirmRouteAcceptable();
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private void doActivityCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimelinessTimeUnacceptable()
  {
    try
    {
      promptAndLogReasonForTimeout();
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    Crisis controller;
    String doActivityMethodName;
    
    public DoActivityThread(Crisis aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      if ("doActivityCrisisCoordinationStageCrisisEndManagementCrisisEndManagementWaitingForUserTerminationAgreement".equals(doActivityMethodName))
      {
        controller.doActivityCrisisCoordinationStageCrisisEndManagementCrisisEndManagementWaitingForUserTerminationAgreement();
      }
        else if ("doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationPlanningRoute".equals(doActivityMethodName))
      {
        controller.doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationPlanningRoute();
      }
        else if ("doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationApprovingRoute".equals(doActivityMethodName))
      {
        controller.doActivityCrisisCoordinationStageNegotiatingRoutePlanNegotiationNegotiationApprovingRoute();
      }
        else if ("doActivityCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimelinessTimeUnacceptable".equals(doActivityMethodName))
      {
        controller.doActivityCrisisCoordinationStageNegotiatingRoutePlanManagingTimelinessManagingTimelinessTimeUnacceptable();
      }
    }
  }

  private void startTimeoutestablishingCommunicationTonoCrisisHandler()
  {
    timeoutestablishingCommunicationTonoCrisisHandler = new TimedEventHandler(this,"timeoutestablishingCommunicationTonoCrisis",timeoutInMs);
  }

  private void stopTimeoutestablishingCommunicationTonoCrisisHandler()
  {
    timeoutestablishingCommunicationTonoCrisisHandler.stop();
  }

  private void startTimeoutwaitingForUserTerminationAgreementToongoingCrisisHandler()
  {
    timeoutwaitingForUserTerminationAgreementToongoingCrisisHandler = new TimedEventHandler(this,"timeoutwaitingForUserTerminationAgreementToongoingCrisis",timeoutInMs);
  }

  private void stopTimeoutwaitingForUserTerminationAgreementToongoingCrisisHandler()
  {
    timeoutwaitingForUserTerminationAgreementToongoingCrisisHandler.stop();
  }

  private void startTimeoutwaitingForTerminationConfirmationToongoingCrisisHandler()
  {
    timeoutwaitingForTerminationConfirmationToongoingCrisisHandler = new TimedEventHandler(this,"timeoutwaitingForTerminationConfirmationToongoingCrisis",timeoutInMs);
  }

  private void stopTimeoutwaitingForTerminationConfirmationToongoingCrisisHandler()
  {
    timeoutwaitingForTerminationConfirmationToongoingCrisisHandler.stop();
  }

  private void startTimeouttimeAcceptableTotimeUnacceptableHandler()
  {
    timeouttimeAcceptableTotimeUnacceptableHandler = new TimedEventHandler(this,"timeouttimeAcceptableTotimeUnacceptable",timeoutInMs);
  }

  private void stopTimeouttimeAcceptableTotimeUnacceptableHandler()
  {
    timeouttimeAcceptableTotimeUnacceptableHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private Crisis controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(Crisis aController, String aTimeoutMethodName, double aHowLongInSeconds)
    {
      controller = aController;
      timeoutMethodName = aTimeoutMethodName;
      howLongInSeconds = aHowLongInSeconds;
      timer = new Timer();
      timer.schedule(this, (long)howLongInSeconds*1000);
    }
    
    public void stop()
    {
      timer.cancel();
    }
    
    public void run ()
    {
      if ("timeoutestablishingCommunicationTonoCrisis".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutestablishingCommunicationTonoCrisis();
        if (shouldRestart)
        {
          controller.startTimeoutestablishingCommunicationTonoCrisisHandler();
        }
        return;
      }
      if ("timeoutwaitingForUserTerminationAgreementToongoingCrisis".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutwaitingForUserTerminationAgreementToongoingCrisis();
        if (shouldRestart)
        {
          controller.startTimeoutwaitingForUserTerminationAgreementToongoingCrisisHandler();
        }
        return;
      }
      if ("timeoutwaitingForTerminationConfirmationToongoingCrisis".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutwaitingForTerminationConfirmationToongoingCrisis();
        if (shouldRestart)
        {
          controller.startTimeoutwaitingForTerminationConfirmationToongoingCrisisHandler();
        }
        return;
      }
      if ("timeouttimeAcceptableTotimeUnacceptable".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeouttimeAcceptableTotimeUnacceptable();
        if (shouldRestart)
        {
          controller.startTimeouttimeAcceptableTotimeUnacceptableHandler();
        }
        return;
      }
    }
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "timeoutInMs" + ":" + getTimeoutInMs()+ "," +
            "thisSideInitiator" + ":" + getThisSideInitiator()+ "," +
            "thisSideInitiatorOfTermination" + ":" + getThisSideInitiatorOfTermination()+ "," +
            "routeAgreedYet" + ":" + getRouteAgreedYet()+ "," +
            "police" + ":" + getPolice()+ "]"
     + outputString;
  }
}