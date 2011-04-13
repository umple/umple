# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.11.1.3376 modeling language!

module CruiseStatemachineTest

class CourseB


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #CourseB Attributes - for documentation purposes
  #attr_reader :log

  #CourseB State Machines
  enum UNKNOWN ID: type { UNKNOWN ID: listStates }
  private UNKNOWN ID: type status;

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @log = "initial value"
    set_status(UNKNOWN ID: type.StatusOpen)
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_log(a_log)
    was_set = false
    @log = a_log
    was_set = true
    was_set
  end

  def get_log
    @log
  end

  public UNKNOWN ID: type get_status
    UNKNOWN ID: stateOne
  end

  def anEvent
  {
    wasEventProcessed = false;

    switch (status)
    {
      case StatusOpen:
        exit_status;
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

  def exit_status
    switch(status)
      case StatusOpen:
        $this->log = "exit called";
        break;
    end
  end

  private void set_status(UNKNOWN ID: type a_status)
  {
    status = a_status

    // entry actions and do activities
    switch(status)
    {
      case StatusOpen:
        $this->log = "entry called";
        break;
    }
  }

  def delete
    @deleted = true
  end

end
end