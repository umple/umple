# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.18.0.3036 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseStatemachineTest

class CourseT


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #CourseT Attributes - for documentation purposes
  #attr_reader :count

  #CourseT State Machines
  enum UNKNOWN ID: type { UNKNOWN ID: listStates }
  private UNKNOWN ID: type one;

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_count)
    @initialized = false
    @deleted = false
    @count = a_count
    set_one(UNKNOWN ID: type.OneOff)
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_count(a_count)
    was_set = false
    @count = a_count
    was_set = true
    was_set
  end

  def get_count
    @count
  end

  public UNKNOWN ID: type get_one
    UNKNOWN ID: stateOne
  end

  def __autotransition2__
  {
    wasEventProcessed = false;

    switch (one)
    {
      case OneOff:
        if @this.count>10 then
          set_one(UNKNOWN ID: type.OneOn);
          wasEventProcessed = true
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  def __autotransition3__
  {
    wasEventProcessed = false;

    switch (one)
    {
      case OneOff:
        if @this.count<=10 then
          set_one(UNKNOWN ID: type.OneWait);
          wasEventProcessed = true
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private void set_one(UNKNOWN ID: type a_one)
  {
    one = a_one
  }

  def delete
    @deleted = true
  end

end
end