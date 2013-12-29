# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE ${last.version} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseStatemachineTest

class CourseE


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #CourseE Attributes - for documentation purposes
  #attr_reader :logs

  #CourseE State Machines
  enum UNKNOWN ID: type { UNKNOWN ID: listStates }
  enum UNKNOWN ID: type { UNKNOWN ID: listStates }
  private UNKNOWN ID: type status;
  private UNKNOWN ID: type statusOn;

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @logs = []
    set_status(UNKNOWN ID: type.StatusOff)
    set_statusOn(UNKNOWN ID: type.UNKNOWN ID: stateNull)  if status.nil?
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

  public UNKNOWN ID: type get_statusOn
    UNKNOWN ID: stateOne
  end

  def turnOn
  {
    wasEventProcessed = false;

    switch (status)
    {
      case StatusOff:
        exit_status;
        set_status(UNKNOWN ID: type.StatusOn);
        wasEventProcessed = true
        break;
    }

    return wasEventProcessed;
  }

  def turnSleep
  {
    wasEventProcessed = false;

    switch (status)
    {
      case StatusOff:
        exit_status;
        set_status(UNKNOWN ID: type.StatusSleep);
        wasEventProcessed = true
        break;
    }

    return wasEventProcessed;
  }

  def wake
  {
    wasEventProcessed = false;

    switch (status)
    {
      case StatusSleep:
        exit_status;
        set_status(UNKNOWN ID: type.OnPause);
        wasEventProcessed = true
        break;
    }

    return wasEventProcessed;
  }

  def turnOff
  {
    wasEventProcessed = false;

    switch (status)
    {
      case StatusOn:
        exit_status;
        set_status(UNKNOWN ID: type.StatusOff);
        wasEventProcessed = true
        break;
    }

    return wasEventProcessed;
  }

  def push
  {
    wasEventProcessed = false;

    switch (statusOn)
    {
      case OnPlay:
        exit_statusOn;
        set_statusOn(UNKNOWN ID: type.OnPause);
        wasEventProcessed = true
        break;
      case OnPause:
        exit_statusOn;
        set_statusOn(UNKNOWN ID: type.OnPlay);
        wasEventProcessed = true
        break;
    }

    return wasEventProcessed;
  }

  def standby
  {
    wasEventProcessed = false;

    switch (statusOn)
    {
      case OnPause:
        exit_statusOn;
        set_statusOn(UNKNOWN ID: type.StatusSleep);
        wasEventProcessed = true
        break;
    }

    return wasEventProcessed;
  }

  def exit_status
    switch(status)
      case StatusOff:
        $this->addLog("Exit Off");
        break;
      case StatusSleep:
        $this->addLog("Exit Sleep");
        break;
      case StatusOn:
        $this->addLog("Exit On");
        break;
    end
  end

  private void set_status(UNKNOWN ID: type a_status)
  {
    status = a_status

    // entry actions and do activities
    switch(status)
    {
      case StatusOff:
        $this->addLog("Enter Off");
        break;
      case StatusSleep:
        $this->addLog("Enter Sleep");
        break;
      case StatusOn:
        $this->addLog("Enter On");
        break;
    }
  }

  def exit_statusOn
    switch(statusOn)
      case OnPlay:
        $this->addLog("Exit Play");
        break;
      case OnPause:
        $this->addLog("Exit Pause");
        break;
    end
  end

  private void set_statusOn(UNKNOWN ID: type a_statusOn)
  {
    statusOn = a_statusOn

    // entry actions and do activities
    switch(statusOn)
    {
      case OnPlay:
        $this->addLog("Enter Play");
        break;
      case OnPause:
        $this->addLog("Enter Pause");
        break;
    }
  }

  def delete
    @deleted = true
  end

end
end