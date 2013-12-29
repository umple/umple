# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.19.0.3287 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseStatemachineTest

class CourseR


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #CourseR Attributes - for documentation purposes
  #attr_reader :logs

  #CourseR State Machines
  enum UNKNOWN ID: type { UNKNOWN ID: listStates }
  private UNKNOWN ID: type one;

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @logs = []
    set_one(UNKNOWN ID: type.OneOff)
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

  public UNKNOWN ID: type get_one
    UNKNOWN ID: stateOne
  end

  def __autotransition1__
  {
    wasEventProcessed = false;

    switch (one)
    {
      case OneOff:
        exit_one;
        set_one(UNKNOWN ID: type.OneOn);
        wasEventProcessed = true
        break;
    }

    return wasEventProcessed;
  }

  def exit_one
    switch(one)
      case OneOff:
        $this->addLog("Exit Off");
        break;
      case OneOn:
        $this->addLog("Exit On");
        break;
    end
  end

  private void set_one(UNKNOWN ID: type a_one)
  {
    one = a_one

    // entry actions and do activities
    switch(one)
    {
      case OneOff:
        $this->addLog("Enter Off");
        break;
      case OneOn:
        $this->addLog("Enter On");
        break;
    }
  }

  def delete
    @deleted = true
  end

end
end