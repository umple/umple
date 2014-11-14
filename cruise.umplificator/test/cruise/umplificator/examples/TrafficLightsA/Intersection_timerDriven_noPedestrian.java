/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 4 "TrafficLightsA.ump"
public class Intersection_timerDriven_noPedestrian
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Intersection_timerDriven_noPedestrian State Machines
  enum Flow { FourWayStop, DirectionOneGo, DirectionOneHalting, DirectionTwoGo, DirectionTwoHalting }
  private Flow flow;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Intersection_timerDriven_noPedestrian()
  {
    setFlow(Flow.FourWayStop);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getFlowFullName()
  {
    String answer = flow.toString();
    return answer;
  }

  public Flow getFlow()
  {
    return flow;
  }

  public boolean initiateRegularOperation()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case FourWayStop:
        setFlow(Flow.DirectionOneGo);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean Wait_DirectionOneGo()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionOneGo:
        setFlow(Flow.DirectionOneHalting);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean detectMalfunction_DirectionOneGo()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionOneGo:
        setFlow(Flow.FourWayStop);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean WaitDirectionOneHalting()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionOneHalting:
        setFlow(Flow.DirectionTwoGo);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean detectMalfunction_DirectionOneaHalting()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionOneHalting:
        setFlow(Flow.FourWayStop);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean WaitDirectionTwoGo()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionTwoGo:
        setFlow(Flow.DirectionTwoHalting);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean detectMalfunction_DirectionTwoGo()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionTwoGo:
        setFlow(Flow.FourWayStop);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean Wait_DirectionTwoGo()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionTwoHalting:
        setFlow(Flow.DirectionOneGo);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean detectMalfunction_DirectionTwoHalting()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionTwoHalting:
        setFlow(Flow.FourWayStop);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setFlow(Flow aFlow)
  {
    flow = aFlow;
  }

  public void delete()
  {}

}