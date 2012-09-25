# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.963 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class StudentAP


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #StudentAP Attributes - for documentation purposes
  #attr_reader :number

  #StudentAP Associations - for documentation purposes
  #attr_reader :mentor

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_number, a_mentor)
    @initialized = false
    @deleted = false
    @number = a_number
    @mentor = nil
    unless a_mentor.nil?
      @mentor = a_mentor
      a_mentor.instance_variable_set("@student",self)
    end
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_number(a_number)
    was_set = false
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    @number = a_number
    was_set = true
    was_set
  end

  def get_number
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    @number
  end

  def get_mentor
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    @mentor
  end

  def delete
    @deleted = true
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    existing_mentor = @mentor
    @mentor = nil
    unless existing_mentor.nil?
      existing_mentor.delete
    end
  end

end
end