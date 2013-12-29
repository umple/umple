# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.19.0.3287 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class ProgramC


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #ProgramC Associations - for documentation purposes
  #attr_reader :mentor, :student

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @mentor = nil
    @student = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_mentor
    @mentor
  end

  def get_student
    @student
  end

  def set_mentor(a_new_mentor)
    was_set = false
    if a_new_mentor.nil?
      existing_mentor = @mentor
      @mentor = nil
      
      if !existing_mentor.nil? and !existing_mentor.get_program.nil?
        existing_mentor.set_program(nil)
      end
      was_set = true
      return was_set
    end

    current_mentor = self.get_mentor
    if !current_mentor.nil? and !current_mentor.eql?(a_new_mentor)
      current_mentor.set_program(nil)
    end

    @mentor = a_new_mentor
    existing_program = a_new_mentor.get_program

    unless self.eql?(existing_program)
      a_new_mentor.set_program(self)
    end
    was_set = true
    was_set
  end

  def set_student(a_new_student)
    was_set = false
    if a_new_student.nil?
      existing_student = @student
      @student = nil
      
      if !existing_student.nil? and !existing_student.get_program.nil?
        existing_student.set_program(nil)
      end
      was_set = true
      return was_set
    end

    current_student = self.get_student
    if !current_student.nil? and !current_student.eql?(a_new_student)
      current_student.set_program(nil)
    end

    @student = a_new_student
    existing_program = a_new_student.get_program

    unless self.eql?(existing_program)
      a_new_student.set_program(self)
    end
    was_set = true
    was_set
  end

  def delete
    @deleted = true
    unless @mentor.nil?
      @mentor.set_program(nil)
    end
    unless @student.nil?
      @student.set_program(nil)
    end
  end

end
end