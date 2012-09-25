# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.963 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class GradStudentAO


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #GradStudentAO Associations - for documentation purposes
  #attr_reader :mentorAO

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_mentorAO)
    @initialized = false
    @deleted = false
    @mentorAO = nil
    unless a_mentorAO.nil?
      @mentorAO = a_mentorAO
      a_mentorAO.instance_variable_set("@gradStudent",self)
    end
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_mentorAO
    raise "Mandatory relationship with mentorAO not satisfied" if (@initialized and !@deleted and @mentorAO.nil?)
    @mentorAO
  end

  def delete
    @deleted = true
    raise "Mandatory relationship with mentorAO not satisfied" if (@initialized and !@deleted and @mentorAO.nil?)
    existing_mentorAO = @mentorAO
    @mentorAO = nil
    unless existing_mentorAO.nil?
      existing_mentorAO.delete
    end
  end

end
end