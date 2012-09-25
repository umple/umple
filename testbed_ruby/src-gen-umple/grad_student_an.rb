# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.963 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class GradStudentAN


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #GradStudentAN Associations - for documentation purposes
  #attr_reader :mentorAN

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_mentorAN)
    @initialized = false
    @deleted = false
    @mentorAN = nil
    unless a_mentorAN.nil?
      @mentorAN = a_mentorAN
      a_mentorAN.instance_variable_set("@gradStudent",self)
    end
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_mentorAN
    raise "Mandatory relationship with mentorAN not satisfied" if (@initialized and !@deleted and @mentorAN.nil?)
    @mentorAN
  end

  def delete
    @deleted = true
    raise "Mandatory relationship with mentorAN not satisfied" if (@initialized and !@deleted and @mentorAN.nil?)
    existing_mentorAN = @mentorAN
    @mentorAN = nil
    unless existing_mentorAN.nil?
      existing_mentorAN.delete
    end
  end

end
end