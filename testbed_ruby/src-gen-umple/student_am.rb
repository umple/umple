# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.963 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class StudentAM


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #StudentAM Attributes - for documentation purposes
  #attr_reader :id

  #StudentAM Associations - for documentation purposes
  #attr_reader :mentor

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_id)
    @initialized = false
    @deleted = false
    @id = a_id
    @mentor = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_id(a_id)
    was_set = false
    @id = a_id
    was_set = true
    was_set
  end

  def get_id
    @id
  end

  def get_mentor
    @mentor
  end

  def set_mentor(a_mentor)
    was_set = false
    existing_mentor = @mentor
    @mentor = a_mentor
    if !existing_mentor.nil? and !existing_mentor.eql?(a_mentor)
      existing_mentor.remove_student(self)
    end
    unless a_mentor.nil?
      a_mentor.add_student(self)
    end
    was_set = true
    was_set
  end

  def delete
    @deleted = true
    unless @mentor.nil?
      @mentor.remove_student(self)
    end
  end

end
end