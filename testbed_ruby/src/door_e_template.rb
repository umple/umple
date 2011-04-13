# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.10.2.2801 modeling language!*/

module Cruise_Attributes_Test
require 'date'

class DoorE

  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #DoorE Attributes
  attr_reader :d1
  attr_reader :d2
  attr_reader :d3
  attr_reader :d4
    
  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @d1 = Date.parse("1978-12-01")
    @d2 = Date.parse("1978-12-02")
    @canSetD2 = false
    resetD3
    @d4 = Date.parse("1978-12-04")
  end

  #------------------------
  # INTERFACE
  #------------------------

  def d1=(aD1)
    wasSet = false
    @d1 = aD1
    wasSet = true
    wasSet
  end

  def d2=(aD2)
    wasSet = false
    return false unless @canSetD2
    canSetD2 = false
    @d2 = aD2
    wasSet = true
    wasSet
  end

  def d3=(aD3)
    wasSet = false
    @d3 = aD3
    wasSet = true
    wasSet
  end

  def resetD3
    wasReset = false
    @d3 = getDefaultD3()
    wasReset = true
    wasReset
  end

  def setD4(aD4)
    wasSet = false
    @d4 = aD4
    wasSet = true
    wasSet
  end

  def getDefaultD3
    aD3 = Date.parse("1978-12-03")
    aD3
  end

  def delete
  end

end
end