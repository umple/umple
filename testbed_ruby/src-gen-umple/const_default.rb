# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE ${last.version} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAttributesTest
require 'date'
require 'time'

class ConstDefault


  #------------------------
  # STATIC VARIABLES
  #------------------------

  I1 = 0;
  I2 = 0;
  D1 = 0.0;
  D2 = 0.0;
  F1 = 0.0;
  F2 = 0.0;
  B1 = false;
  B2 = false;
  STR = "";
  DATE = Date.parse("2014-01-22");
  TIME = Time.parse("00:00:00");

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

  def delete
    @deleted = true
  end

end
end