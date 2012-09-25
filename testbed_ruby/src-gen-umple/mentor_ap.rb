# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.963 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MentorAP


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorAP Attributes - for documentation purposes
  #attr_reader :name

  #MentorAP Associations - for documentation purposes
  #attr_reader :gradStudent, :student

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name, a_gradStudent, a_student)
    @initialized = false
    @deleted = false
    @name = a_name
    @gradStudent = nil
    unless a_gradStudent.nil?
      @gradStudent = a_gradStudent
      a_gradStudent.instance_variable_set("@mentorAP",self)
    end
    @student = nil
    unless a_student.nil?
      @student = a_student
      a_student.instance_variable_set("@mentor",self)
    end
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_name(a_name)
    was_set = false
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    raise "Mandatory relationship with student not satisfied" if (@initialized and !@deleted and @student.nil?)
    @name = a_name
    was_set = true
    was_set
  end

  def get_name
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    raise "Mandatory relationship with student not satisfied" if (@initialized and !@deleted and @student.nil?)
    @name
  end

  def get_gradStudent
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    raise "Mandatory relationship with student not satisfied" if (@initialized and !@deleted and @student.nil?)
    @gradStudent
  end

  def get_student
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    raise "Mandatory relationship with student not satisfied" if (@initialized and !@deleted and @student.nil?)
    @student
  end

  def delete
    @deleted = true
    raise "Mandatory relationship with gradStudent not satisfied" if (@initialized and !@deleted and @gradStudent.nil?)
    raise "Mandatory relationship with student not satisfied" if (@initialized and !@deleted and @student.nil?)
    existing_gradStudent = @gradStudent
    @gradStudent = nil
    unless existing_gradStudent.nil?
      existing_gradStudent.delete
    end
    existing_student = @student
    @student = nil
    unless existing_student.nil?
      existing_student.delete
    end
  end

end
end