# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.12.1.605 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAttributesTest
require 'date'
require 'time'

class DoorD


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #DoorD Attributes - for documentation purposes
  #attr_reader :id, :intId, :doubleId, :booleanId, :doorId, :dateId, :timeId

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    reset_id
    reset_intId
    reset_doubleId
    reset_booleanId
    reset_doorId
    reset_dateId
    reset_timeId
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_id(a_id)
    was_set = false
    @id = a_id
    was_set = true
    was_set
  end

  def reset_id
    wasReset = false
    @id = get_default_id
    wasReset = true
    wasReset
  end

  def set_intId(a_intId)
    was_set = false
    @intId = a_intId
    was_set = true
    was_set
  end

  def reset_intId
    wasReset = false
    @intId = get_default_intId
    wasReset = true
    wasReset
  end

  def set_doubleId(a_doubleId)
    was_set = false
    @doubleId = a_doubleId
    was_set = true
    was_set
  end

  def reset_doubleId
    wasReset = false
    @doubleId = get_default_doubleId
    wasReset = true
    wasReset
  end

  def set_booleanId(a_booleanId)
    was_set = false
    @booleanId = a_booleanId
    was_set = true
    was_set
  end

  def reset_booleanId
    wasReset = false
    @booleanId = get_default_booleanId
    wasReset = true
    wasReset
  end

  def set_doorId(a_doorId)
    was_set = false
    @doorId = a_doorId
    was_set = true
    was_set
  end

  def reset_doorId
    wasReset = false
    @doorId = get_default_doorId
    wasReset = true
    wasReset
  end

  def set_dateId(a_dateId)
    was_set = false
    @dateId = a_dateId
    was_set = true
    was_set
  end

  def reset_dateId
    wasReset = false
    @dateId = get_default_dateId
    wasReset = true
    wasReset
  end

  def set_timeId(a_timeId)
    was_set = false
    @timeId = a_timeId
    was_set = true
    was_set
  end

  def reset_timeId
    wasReset = false
    @timeId = get_default_timeId
    wasReset = true
    wasReset
  end

  def get_id
    @id
  end

  def get_default_id
    "1"
  end

  def get_intId
    @intId
  end

  def get_default_intId
    2
  end

  def get_doubleId
    @doubleId
  end

  def get_default_doubleId
    3.4
  end

  def get_booleanId
    @booleanId
  end

  def get_default_booleanId
    false
  end

  def get_doorId
    @doorId
  end

  def get_default_doorId
    DoorB.new(5)
  end

  def get_dateId
    @dateId
  end

  def get_default_dateId
    Date.parse("1978-12-05")
  end

  def get_timeId
    @timeId
  end

  def get_default_timeId
    Time.parse("10:11:15")
  end

  def delete
    @deleted = true
  end

end
end