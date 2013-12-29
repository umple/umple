# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.19.0.3287 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseStatemachineTest

class CourseC


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #CourseC Attributes - for documentation purposes
  #attr_reader :logs

  #CourseC State Machines
  enum UNKNOWN ID: type { UNKNOWN ID: listStates }
  private UNKNOWN ID: type status;

  #CourseC Do Activity Threads
  #attr_reader UNKNOWN ID: doActivityThread;

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @logs = []
    set_status(UNKNOWN ID: type.StatusOpen)
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def add_log(a_log)
    was_added = false
    was_added = logs << a_log
    was_added
  end

  def remove_log(a_log)
    was_removed = false
    was_removed = logs.delete(a_log)
    was_removed
  end

  def get_log(index)
    a_log = logs[index]
    a_log
  end

  def get_logs
    String[] new_logs = logs.toArray(new String[logs.size])
    new_logs
  end

  def number_of_logs
    number = logs.size
    number;
  end

  def has_logs
    has = logs.size > 0
    has
  end

  def index_of_log(a_log)
    index = logs.index(a_log)
    index = -1 if index.nil?
    index
  end

  public UNKNOWN ID: type get_status
    UNKNOWN ID: stateOne
  end

  def flip
  {
    wasEventProcessed = false;

    switch (status)
    {
      case StatusOpen:
        set_status(UNKNOWN ID: type.StatusClosed);
        wasEventProcessed = true
        break;
      case StatusClosed:
        set_status(UNKNOWN ID: type.StatusOpen);
        wasEventProcessed = true
        break;
    }

    return wasEventProcessed;
  }

  private void set_status(UNKNOWN ID: type a_status)
  {
    status = a_status

    // entry actions and do activities
    switch(status)
    {
      case StatusOpen:
        $this->addLog("Open Entry");
        UNKNOWN ID: doActivityThread = new DoActivityThread(this,"doActivityStatusOpen");
        break;
      case StatusClosed:
        $this->addLog("Closed Entry");
        break;
    }
  }

  def doActivityStatusOpen
    usleep(400000);
        $this->addLog("Do Activity On Open");
  end

  private static class DoActivityThread extends Thread
  {
    CourseC controller;
    String doActivityMethodName;
    
    public DoActivityThread(CourseC aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    def run()
    {
      try
      {
        if ("doActivityStatusOpen".eql?(doActivityMethodName))
        {
          controller.doActivityStatusOpen
        }
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  def delete
    @deleted = true
  end

end
end