# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.16.0.2388 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MentorAI


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorAI Attributes - for documentation purposes
  #attr_reader :name

  #MentorAI Associations - for documentation purposes
  #attr_reader :student, :program

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name)
    @initialized = false
    @deleted = false
    @name = a_name
    @student = nil
    @program = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_name(a_name)
    was_set = false
    @name = a_name
    was_set = true
    was_set
  end

  def get_name
    @name
  end

  def get_student
    @student
  end

  def get_program
    @program
  end

  def set_student(a_new_student)
    was_set = false
    @student = a_new_student
    was_set = true
    was_set
  end

  def set_program(a_new_program)
    was_set = false
    if a_new_program.nil?
      existing_program = @program
      @program = nil
      
      if !existing_program.nil? and !existing_program.get_mentor.nil?
        existing_program.set_mentor(nil)
      end
      was_set = true
      return was_set
    end

    current_program = self.get_program
    if !current_program.nil? and !current_program.eql?(a_new_program)
      current_program.set_mentor(nil)
    end

    @program = a_new_program
    existing_mentor = a_new_program.get_mentor

    unless self.eql?(existing_mentor)
      a_new_program.set_mentor(self)
    end
    was_set = true
    was_set
  end

  def delete
    @deleted = true
    @student = nil
    unless @program.nil?
      @program.set_mentor(nil)
    end
  end

end
end