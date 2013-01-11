# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.16.0.2388 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAttributesTest

class Student


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #Student Attributes - for documentation purposes
  #attr_reader :age

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_age)
    @initialized = false
    @deleted = false
    @age = a_age
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_age(a_age)
    was_set = false
    if (a_age>18) then
    
    @age = a_age
    was_set = true
    end
    was_set
  end

  def get_age
    @age
  end

  def delete
    @deleted = true
  end

end
end