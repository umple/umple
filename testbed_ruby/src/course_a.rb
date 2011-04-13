# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.11.1.3376 modeling language!

module CruiseStatemachineTest

class CourseA


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #CourseA State Machines
  enum UNKNOWN ID: type { UNKNOWN ID: listStates }
  private UNKNOWN ID: type status;

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  public UNKNOWN ID: type get_status
    UNKNOWN ID: stateOne
  end

  def delete
    @deleted = true
  end

end
end