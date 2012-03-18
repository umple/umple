# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.963 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAttributesTest
require 'date'
require 'time'

class DoorG


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #DoorG Attributes - for documentation purposes
  #attr_reader :doorId, :dateId, :timeId

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @can_set_doorId = true
    @dateId = nil
    @can_set_dateId = true
    @timeId = nil
    @can_set_timeId = true
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_doorId(a_doorId)
    was_set = false
    return false unless @can_set_doorId
    @can_set_doorId = false
    @doorId = a_doorId
    was_set = true
    was_set
  end

  def set_dateId(a_dateId)
    was_set = false
    return false unless @can_set_dateId
    @can_set_dateId = false
    @dateId = a_dateId
    was_set = true
    was_set
  end

  def set_timeId(a_timeId)
    was_set = false
    return false unless @can_set_timeId
    @can_set_timeId = false
    @timeId = a_timeId
    was_set = true
    was_set
  end

  def get_doorId
    @doorId
  end

  def get_dateId
    @dateId
  end

  def get_timeId
    @timeId
  end

  def delete
    @deleted = true
  end

end
end