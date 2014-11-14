/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 4 "TrafficLightsB.ump"
public class IntersectionTimerDriven
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IntersectionTimerDriven Attributes
  private int directionOneGoTime;
  private int directionTwoGoTime;
  private int yellowTime;
  private int extraPedestrianWarning;

  //IntersectionTimerDriven State Machines
  enum Flow { FourWayStop, DirectionOneGo, DirectionOneHalting, DirectionTwoGo, DirectionTwoHalting }
  private Flow flow;
  enum PedestrianFlow { FourWayStop, P1Go, P1Halting, P2Go, P2Halting }
  private PedestrianFlow pedestrianFlow;
  enum DirectionOneLight { FlashingRed, Red, Yellow, Green }
  private DirectionOneLight directionOneLight;
  enum DirectionTwoLight { FlashingRed, Red, Yellow, Green }
  private DirectionTwoLight directionTwoLight;
  enum P1Light { DoNotWalk, Flashing, Walk }
  private P1Light p1Light;
  enum P2Light { DoNotWalk, Flashing, Walk }
  private P2Light p2Light;

  //Helper Variables
  private TimedEventHandler timeoutDirectionOneGoToDirectionOneHaltingHandler;
  private TimedEventHandler timeoutDirectionOneHaltingToDirectionTwoGoHandler;
  private TimedEventHandler timeoutDirectionTwoGoToDirectionTwoHaltingHandler;
  private TimedEventHandler timeoutDirectionTwoHaltingToDirectionOneGoHandler;
  private TimedEventHandler timeoutP1GoToP1HaltingHandler;
  private TimedEventHandler timeoutP1HaltingToP2GoHandler;
  private TimedEventHandler timeoutP2GoToP2HaltingHandler;
  private TimedEventHandler timeoutP2HaltingToP1GoHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IntersectionTimerDriven()
  {
    directionOneGoTime = 25000;
    directionTwoGoTime = 20000;
    yellowTime = 5000;
    extraPedestrianWarning = 10000;
    setFlow(Flow.FourWayStop);
    setPedestrianFlow(PedestrianFlow.FourWayStop);
    setDirectionOneLight(DirectionOneLight.FlashingRed);
    setDirectionTwoLight(DirectionTwoLight.FlashingRed);
    setP1Light(P1Light.DoNotWalk);
    setP2Light(P2Light.DoNotWalk);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDirectionOneGoTime(int aDirectionOneGoTime)
  {
    boolean wasSet = false;
    directionOneGoTime = aDirectionOneGoTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setDirectionTwoGoTime(int aDirectionTwoGoTime)
  {
    boolean wasSet = false;
    directionTwoGoTime = aDirectionTwoGoTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setYellowTime(int aYellowTime)
  {
    boolean wasSet = false;
    yellowTime = aYellowTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setExtraPedestrianWarning(int aExtraPedestrianWarning)
  {
    boolean wasSet = false;
    extraPedestrianWarning = aExtraPedestrianWarning;
    wasSet = true;
    return wasSet;
  }

  /**
   * Traffic lights are green for 25s in one direction
   * and 20s in the other.
   */
  public int getDirectionOneGoTime()
  {
    return directionOneGoTime;
  }

  public int getDirectionTwoGoTime()
  {
    return directionTwoGoTime;
  }

  /**
   * Lights are yellow for 5s
   */
  public int getYellowTime()
  {
    return yellowTime;
  }

  /**
   * Pedestrians have 10s extra warning
   */
  public int getExtraPedestrianWarning()
  {
    return extraPedestrianWarning;
  }

  public String getFlowFullName()
  {
    String answer = flow.toString();
    return answer;
  }

  public String getPedestrianFlowFullName()
  {
    String answer = pedestrianFlow.toString();
    return answer;
  }

  public String getDirectionOneLightFullName()
  {
    String answer = directionOneLight.toString();
    return answer;
  }

  public String getDirectionTwoLightFullName()
  {
    String answer = directionTwoLight.toString();
    return answer;
  }

  public String getP1LightFullName()
  {
    String answer = p1Light.toString();
    return answer;
  }

  public String getP2LightFullName()
  {
    String answer = p2Light.toString();
    return answer;
  }

  public Flow getFlow()
  {
    return flow;
  }

  public PedestrianFlow getPedestrianFlow()
  {
    return pedestrianFlow;
  }

  public DirectionOneLight getDirectionOneLight()
  {
    return directionOneLight;
  }

  public DirectionTwoLight getDirectionTwoLight()
  {
    return directionTwoLight;
  }

  public P1Light getP1Light()
  {
    return p1Light;
  }

  public P2Light getP2Light()
  {
    return p2Light;
  }

  public boolean initiateRegularOperation()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    PedestrianFlow aPedestrianFlow = pedestrianFlow;
    switch (aFlow)
    {
      case FourWayStop:
        setFlow(Flow.DirectionOneGo);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aPedestrianFlow)
    {
      case FourWayStop:
        setPedestrianFlow(PedestrianFlow.P2Go);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutDirectionOneGoToDirectionOneHalting()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionOneGo:
        exitFlow();
        setFlow(Flow.DirectionOneHalting);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean detectMalfunction()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    PedestrianFlow aPedestrianFlow = pedestrianFlow;
    switch (aFlow)
    {
      case DirectionOneGo:
        exitFlow();
        setFlow(Flow.FourWayStop);
        wasEventProcessed = true;
        break;
      case DirectionOneHalting:
        exitFlow();
        setFlow(Flow.FourWayStop);
        wasEventProcessed = true;
        break;
      case DirectionTwoGo:
        exitFlow();
        setFlow(Flow.FourWayStop);
        wasEventProcessed = true;
        break;
      case DirectionTwoHalting:
        exitFlow();
        setFlow(Flow.FourWayStop);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aPedestrianFlow)
    {
      case P1Go:
        exitPedestrianFlow();
        setPedestrianFlow(PedestrianFlow.FourWayStop);
        wasEventProcessed = true;
        break;
      case P1Halting:
        exitPedestrianFlow();
        setPedestrianFlow(PedestrianFlow.FourWayStop);
        wasEventProcessed = true;
        break;
      case P2Go:
        exitPedestrianFlow();
        setPedestrianFlow(PedestrianFlow.FourWayStop);
        wasEventProcessed = true;
        break;
      case P2Halting:
        exitPedestrianFlow();
        setPedestrianFlow(PedestrianFlow.FourWayStop);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutDirectionOneHaltingToDirectionTwoGo()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionOneHalting:
        exitFlow();
        setFlow(Flow.DirectionTwoGo);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutDirectionTwoGoToDirectionTwoHalting()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionTwoGo:
        exitFlow();
        setFlow(Flow.DirectionTwoHalting);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutDirectionTwoHaltingToDirectionOneGo()
  {
    boolean wasEventProcessed = false;
    
    Flow aFlow = flow;
    switch (aFlow)
    {
      case DirectionTwoHalting:
        exitFlow();
        setFlow(Flow.DirectionOneGo);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutP1GoToP1Halting()
  {
    boolean wasEventProcessed = false;
    
    PedestrianFlow aPedestrianFlow = pedestrianFlow;
    switch (aPedestrianFlow)
    {
      case P1Go:
        exitPedestrianFlow();
        setPedestrianFlow(PedestrianFlow.P1Halting);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutP1HaltingToP2Go()
  {
    boolean wasEventProcessed = false;
    
    PedestrianFlow aPedestrianFlow = pedestrianFlow;
    switch (aPedestrianFlow)
    {
      case P1Halting:
        exitPedestrianFlow();
        setPedestrianFlow(PedestrianFlow.P2Go);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutP2GoToP2Halting()
  {
    boolean wasEventProcessed = false;
    
    PedestrianFlow aPedestrianFlow = pedestrianFlow;
    switch (aPedestrianFlow)
    {
      case P2Go:
        exitPedestrianFlow();
        setPedestrianFlow(PedestrianFlow.P2Halting);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutP2HaltingToP1Go()
  {
    boolean wasEventProcessed = false;
    
    PedestrianFlow aPedestrianFlow = pedestrianFlow;
    switch (aPedestrianFlow)
    {
      case P2Halting:
        exitPedestrianFlow();
        setPedestrianFlow(PedestrianFlow.P1Go);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitFlow()
  {
    switch(flow)
    {
      case DirectionOneGo:
        stopTimeoutDirectionOneGoToDirectionOneHaltingHandler();
        break;
      case DirectionOneHalting:
        stopTimeoutDirectionOneHaltingToDirectionTwoGoHandler();
        break;
      case DirectionTwoGo:
        stopTimeoutDirectionTwoGoToDirectionTwoHaltingHandler();
        break;
      case DirectionTwoHalting:
        stopTimeoutDirectionTwoHaltingToDirectionOneGoHandler();
        break;
    }
  }

  private void setFlow(Flow aFlow)
  {
    flow = aFlow;

    // entry actions and do activities
    switch(flow)
    {
      case FourWayStop:
        // line 20 "TrafficLightsB.ump"
        directionOneLight = DirectionOneLight.FlashingRed;
        directionTwoLight = directionTwoLight.FlashingRed;
        break;
      case DirectionOneGo:
        // line 28 "TrafficLightsB.ump"
        directionOneLight = directionOneLight.Green;
        directionTwoLight = directionTwoLight.Red;
        startTimeoutDirectionOneGoToDirectionOneHaltingHandler();
        break;
      case DirectionOneHalting:
        // line 37 "TrafficLightsB.ump"
        directionOneLight = directionOneLight.Yellow;
        startTimeoutDirectionOneHaltingToDirectionTwoGoHandler();
        break;
      case DirectionTwoGo:
        // line 43 "TrafficLightsB.ump"
        directionOneLight = directionOneLight.Red;
        directionTwoLight = directionTwoLight.Green;
        startTimeoutDirectionTwoGoToDirectionTwoHaltingHandler();
        break;
      case DirectionTwoHalting:
        // line 52 "TrafficLightsB.ump"
        directionTwoLight = directionTwoLight.Yellow;
        startTimeoutDirectionTwoHaltingToDirectionOneGoHandler();
        break;
    }
  }

  private void exitPedestrianFlow()
  {
    switch(pedestrianFlow)
    {
      case P1Go:
        stopTimeoutP1GoToP1HaltingHandler();
        break;
      case P1Halting:
        stopTimeoutP1HaltingToP2GoHandler();
        break;
      case P2Go:
        stopTimeoutP2GoToP2HaltingHandler();
        break;
      case P2Halting:
        stopTimeoutP2HaltingToP1GoHandler();
        break;
    }
  }

  private void setPedestrianFlow(PedestrianFlow aPedestrianFlow)
  {
    pedestrianFlow = aPedestrianFlow;

    // entry actions and do activities
    switch(pedestrianFlow)
    {
      case FourWayStop:
        // line 62 "TrafficLightsB.ump"
        P1Light = P1Light.DoNotWalk;  P2Light = P2Light.DoNotWalk;
        break;
      case P1Go:
        // line 67 "TrafficLightsB.ump"
        P1Light = P1Light.Walk;
        startTimeoutP1GoToP1HaltingHandler();
        break;
      case P1Halting:
        // line 73 "TrafficLightsB.ump"
        P1Light = P1Light.Flashing;
        startTimeoutP1HaltingToP2GoHandler();
        break;
      case P2Go:
        // line 79 "TrafficLightsB.ump"
        P2Light = P2Light.Walk;
        startTimeoutP2GoToP2HaltingHandler();
        break;
      case P2Halting:
        // line 85 "TrafficLightsB.ump"
        P2Light = P2Light.Flashing;
        startTimeoutP2HaltingToP1GoHandler();
        break;
    }
  }

  public boolean setDirectionOneLight(DirectionOneLight aDirectionOneLight)
  {
    directionOneLight = aDirectionOneLight;
    return true;
  }

  public boolean setDirectionTwoLight(DirectionTwoLight aDirectionTwoLight)
  {
    directionTwoLight = aDirectionTwoLight;
    return true;
  }

  public boolean setP1Light(P1Light aP1Light)
  {
    p1Light = aP1Light;
    return true;
  }

  public boolean setP2Light(P2Light aP2Light)
  {
    p2Light = aP2Light;
    return true;
  }

  private void startTimeoutDirectionOneGoToDirectionOneHaltingHandler()
  {
    timeoutDirectionOneGoToDirectionOneHaltingHandler = new TimedEventHandler(this,"timeoutDirectionOneGoToDirectionOneHalting",directionOneGoTime);
  }

  private void stopTimeoutDirectionOneGoToDirectionOneHaltingHandler()
  {
    timeoutDirectionOneGoToDirectionOneHaltingHandler.stop();
  }

  private void startTimeoutDirectionOneHaltingToDirectionTwoGoHandler()
  {
    timeoutDirectionOneHaltingToDirectionTwoGoHandler = new TimedEventHandler(this,"timeoutDirectionOneHaltingToDirectionTwoGo",yellowTime);
  }

  private void stopTimeoutDirectionOneHaltingToDirectionTwoGoHandler()
  {
    timeoutDirectionOneHaltingToDirectionTwoGoHandler.stop();
  }

  private void startTimeoutDirectionTwoGoToDirectionTwoHaltingHandler()
  {
    timeoutDirectionTwoGoToDirectionTwoHaltingHandler = new TimedEventHandler(this,"timeoutDirectionTwoGoToDirectionTwoHalting",directionOneGoTime);
  }

  private void stopTimeoutDirectionTwoGoToDirectionTwoHaltingHandler()
  {
    timeoutDirectionTwoGoToDirectionTwoHaltingHandler.stop();
  }

  private void startTimeoutDirectionTwoHaltingToDirectionOneGoHandler()
  {
    timeoutDirectionTwoHaltingToDirectionOneGoHandler = new TimedEventHandler(this,"timeoutDirectionTwoHaltingToDirectionOneGo",yellowTime);
  }

  private void stopTimeoutDirectionTwoHaltingToDirectionOneGoHandler()
  {
    timeoutDirectionTwoHaltingToDirectionOneGoHandler.stop();
  }

  private void startTimeoutP1GoToP1HaltingHandler()
  {
    timeoutP1GoToP1HaltingHandler = new TimedEventHandler(this,"timeoutP1GoToP1Halting",directionOneGoTime-extraPedestrianWarning);
  }

  private void stopTimeoutP1GoToP1HaltingHandler()
  {
    timeoutP1GoToP1HaltingHandler.stop();
  }

  private void startTimeoutP1HaltingToP2GoHandler()
  {
    timeoutP1HaltingToP2GoHandler = new TimedEventHandler(this,"timeoutP1HaltingToP2Go",extraPedestrianWarning+yellowTime);
  }

  private void stopTimeoutP1HaltingToP2GoHandler()
  {
    timeoutP1HaltingToP2GoHandler.stop();
  }

  private void startTimeoutP2GoToP2HaltingHandler()
  {
    timeoutP2GoToP2HaltingHandler = new TimedEventHandler(this,"timeoutP2GoToP2Halting",directionTwoGoTime-extraPedestrianWarning);
  }

  private void stopTimeoutP2GoToP2HaltingHandler()
  {
    timeoutP2GoToP2HaltingHandler.stop();
  }

  private void startTimeoutP2HaltingToP1GoHandler()
  {
    timeoutP2HaltingToP1GoHandler = new TimedEventHandler(this,"timeoutP2HaltingToP1Go",extraPedestrianWarning+yellowTime);
  }

  private void stopTimeoutP2HaltingToP1GoHandler()
  {
    timeoutP2HaltingToP1GoHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private IntersectionTimerDriven controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(IntersectionTimerDriven aController, String aTimeoutMethodName, double aHowLongInSeconds)
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
      if ("timeoutDirectionOneGoToDirectionOneHalting".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutDirectionOneGoToDirectionOneHalting();
        if (shouldRestart)
        {
          controller.startTimeoutDirectionOneGoToDirectionOneHaltingHandler();
        }
        return;
      }
      if ("timeoutDirectionOneHaltingToDirectionTwoGo".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutDirectionOneHaltingToDirectionTwoGo();
        if (shouldRestart)
        {
          controller.startTimeoutDirectionOneHaltingToDirectionTwoGoHandler();
        }
        return;
      }
      if ("timeoutDirectionTwoGoToDirectionTwoHalting".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutDirectionTwoGoToDirectionTwoHalting();
        if (shouldRestart)
        {
          controller.startTimeoutDirectionTwoGoToDirectionTwoHaltingHandler();
        }
        return;
      }
      if ("timeoutDirectionTwoHaltingToDirectionOneGo".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutDirectionTwoHaltingToDirectionOneGo();
        if (shouldRestart)
        {
          controller.startTimeoutDirectionTwoHaltingToDirectionOneGoHandler();
        }
        return;
      }
      if ("timeoutP1GoToP1Halting".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutP1GoToP1Halting();
        if (shouldRestart)
        {
          controller.startTimeoutP1GoToP1HaltingHandler();
        }
        return;
      }
      if ("timeoutP1HaltingToP2Go".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutP1HaltingToP2Go();
        if (shouldRestart)
        {
          controller.startTimeoutP1HaltingToP2GoHandler();
        }
        return;
      }
      if ("timeoutP2GoToP2Halting".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutP2GoToP2Halting();
        if (shouldRestart)
        {
          controller.startTimeoutP2GoToP2HaltingHandler();
        }
        return;
      }
      if ("timeoutP2HaltingToP1Go".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutP2HaltingToP1Go();
        if (shouldRestart)
        {
          controller.startTimeoutP2HaltingToP1GoHandler();
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
            "directionOneGoTime" + ":" + getDirectionOneGoTime()+ "," +
            "directionTwoGoTime" + ":" + getDirectionTwoGoTime()+ "," +
            "yellowTime" + ":" + getYellowTime()+ "," +
            "extraPedestrianWarning" + ":" + getExtraPedestrianWarning()+ "]"
     + outputString;
  }
}