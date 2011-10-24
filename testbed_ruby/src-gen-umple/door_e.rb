# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.14.0.957 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAttributesTest
require 'date'

class DoorE


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #DoorE Attributes - for documentation purposes
  #attr_reader :d1, :d2, :d3, :d4

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @d1 = Date.parse("1978-12-01")
    @d2 = Date.parse("1978-12-02")
    @can_set_d2 = false
    reset_d3
    @d4 = Date.parse("1978-12-04")
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_d1(a_d1)
    was_set = false
    @d1 = a_d1
    was_set = true
    was_set
  end

  def set_d3(a_d3)
    was_set = false
    @d3 = a_d3
    was_set = true
    was_set
  end

  def reset_d3
    wasReset = false
    @d3 = get_default_d3
    wasReset = true
    wasReset
  end

  def set_d4(a_d4)
    was_set = false
    @d4 = a_d4
    was_set = true
    was_set
  end

  def get_d1
    @d1
  end

  def get_d2
    @d2
  end

  def get_d3
    @d3
  end

  def get_default_d3
    Date.parse("1978-12-03")
  end

  def get_d4
    @d4
  end

  def delete
    @deleted = true
  end

end
end