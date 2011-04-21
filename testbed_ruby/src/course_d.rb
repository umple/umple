# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.12.0.352 modeling language!

module CruiseStatemachineTest

class CourseD


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #CourseD State Machines
  enum UNKNOWN ID: type { UNKNOWN ID: listStates }
  private UNKNOWN ID: type status;

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    set_status(UNKNOWN ID: type.StatusOpen)
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  public UNKNOWN ID: type get_status
    UNKNOWN ID: stateOne
  end

  def timeoutOpenToClosed
  {
    wasEventProcessed = false;

    switch (status)
    {
      case StatusOpen:
        set_status(UNKNOWN ID: type.StatusClosed);
        wasEventProcessed = true
        break;
    }

    return wasEventProcessed;
  }

  private void set_status(UNKNOWN ID: type a_status)
  {
    status = a_status
  }

  def start_timeoutOpenToClosed_handler
    timeoutOpenToClosed_handler = new TimedEventHandler(this,"timeoutOpenToClosed",1)
  end

  def stop_timeoutOpenToClosed_handler
    timeoutOpenToClosed_handler.stop()
  end

  public static class TimedEventHandler extends TimerTask  
  {
    private CourseD controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(CourseD aController, String aTimeoutMethodName, double aHowLongInSeconds)
    {
      controller = aController;
      timeoutMethodName = aTimeoutMethodName;
      howLongInSeconds = aHowLongInSeconds;
      timer = new Timer();
      timer.schedule(this, (long)howLongInSeconds*1000);
    }
    
    def stop
      timer.cancel();
    end
    
    def run
      if ("timeoutOpenToClosed".eql?(timeoutMethodName))
      {
        shouldRestart = !controller.timeoutOpenToClosed
        if (shouldRestart)
        {
          controller.start_timeoutOpenToClosed_handler
        }
        return;
      }
    end
  }

  def delete
    @deleted = true
  end

end
end