# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.963 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class GradStudentAP


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #GradStudentAP Associations - for documentation purposes
  #attr_reader :mentorAP

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_mentorAP)
    @initialized = false
    @deleted = false
    @mentorAP = nil
    unless a_mentorAP.nil?
      @mentorAP = a_mentorAP
      a_mentorAP.instance_variable_set("@gradStudent",self)
    end
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_mentorAP
    raise "Mandatory relationship with mentorAP not satisfied" if (@initialized and !@deleted and @mentorAP.nil?)
    @mentorAP
  end

  def delete
    @deleted = true
    raise "Mandatory relationship with mentorAP not satisfied" if (@initialized and !@deleted and @mentorAP.nil?)
    existing_mentorAP = @mentorAP
    @mentorAP = nil
    unless existing_mentorAP.nil?
      existing_mentorAP.delete
    end
  end

end
end