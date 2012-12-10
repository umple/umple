# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.1751 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseStatemachineTest

class CourseL


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #CourseL Attributes - for documentation purposes
  #attr_reader :logs

  #CourseL State Machines
  enum UNKNOWN ID: type { UNKNOWN ID: listStates }
  enum UNKNOWN ID: type { UNKNOWN ID: listStates }
  enum UNKNOWN ID: type { UNKNOWN ID: listStates }
  private UNKNOWN ID: type status;
  private UNKNOWN ID: type statusMotorIdle;
  private UNKNOWN ID: type statusFanIdle;

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @logs = []
    set_status(UNKNOWN ID: type.StatusOn)
    set_statusMotorIdle(UNKNOWN ID: type.UNKNOWN ID: stateNull)  if status.nil?
    set_statusFanIdle(UNKNOWN ID: type.UNKNOWN ID: stateNull)  if status.nil?
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

  public UNKNOWN ID: type get_statusMotorIdle
    UNKNOWN ID: stateOne
  end

  public UNKNOWN ID: type get_statusFanIdle
    UNKNOWN ID: stateOne
  end

  def flip
  {
    wasEventProcessed = false;

    switch (statusMotorIdle)
    {
      case MotorIdleMotorIdle:
        set_statusMotorIdle(UNKNOWN ID: type.MotorIdleFinal);
        wasEventProcessed = true
        break;
    }

    return wasEventProcessed;
  }

  def flop
  {
    wasEventProcessed = false;

    switch (statusFanIdle)
    {
      case FanIdleFanIdle:
        set_statusFanIdle(UNKNOWN ID: type.FanIdleFinal);
        wasEventProcessed = true
        break;
    }

    return wasEventProcessed;
  }

  private void set_status(UNKNOWN ID: type a_status)
  {
    status = a_status
  }

  private void set_statusMotorIdle(UNKNOWN ID: type a_statusMotorIdle)
  {
    statusMotorIdle = a_statusMotorIdle
  }

  private void set_statusFanIdle(UNKNOWN ID: type a_statusFanIdle)
  {
    statusFanIdle = a_statusFanIdle
  }

  def delete
    @deleted = true
    // line 124 "../../../../src/TestHarnessStateMachinePhp.ump"
    $this->addLog("deleted");
  end

end
end