# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.13.0.605 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseTest

class StudentA


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #StudentA Associations - for documentation purposes
  #attr_reader :mentor

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @mentor = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_mentor
    @mentor
  end

  def set_mentor(new_mentor)
    was_set = false
    if new_mentor.nil?
      existing_mentor = @mentor
      @mentor = nil
      
      if !existing_mentor.nil? and !existing_mentor.get_student.nil?
        existing_mentor.set_student(nil)
      end
      was_set = true
      return was_set
    end

    current_mentor = self.get_mentor
    if !current_mentor.nil? and !current_mentor.eql?(new_mentor)
      current_mentor.set_student(nil)
    end

    @mentor = new_mentor
    existing_student = new_mentor.get_student

    unless self.eql?(existing_student)
      new_mentor.set_student(self)
    end
    was_set = true
    was_set
  end

  def delete
    @deleted = true
    unless @mentor.nil?
      @mentor.set_student(nil)
    end
  end

end
end