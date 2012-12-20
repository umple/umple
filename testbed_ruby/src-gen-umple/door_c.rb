# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.1751 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAttributesTest
require 'date'
require 'time'

class DoorC


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #DoorC Attributes - for documentation purposes
  #attr_reader :id, :intId, :doubleId, :dateId, :timeId, :booleanId, :doorId

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_id, a_intId, a_doubleId, a_dateId, a_timeId, a_booleanId, a_doorId)
    @initialized = false
    @deleted = false
    @id = a_id
    @can_set_id = false
    @intId = a_intId
    @can_set_intId = false
    @doubleId = a_doubleId
    @can_set_doubleId = false
    @dateId = a_dateId
    @can_set_dateId = false
    @timeId = a_timeId
    @can_set_timeId = false
    @booleanId = a_booleanId
    @can_set_booleanId = false
    @doorId = a_doorId
    @can_set_doorId = false
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_id
    @id
  end

  def get_intId
    @intId
  end

  def get_doubleId
    @doubleId
  end

  def get_dateId
    @dateId
  end

  def get_timeId
    @timeId
  end

  def get_booleanId
    @booleanId
  end

  def get_doorId
    @doorId
  end

  def is_booleanId
    @booleanId
  end

  def delete
    @deleted = true
  end

end
end