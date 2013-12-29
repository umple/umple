# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.19.0.3287 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class StudentY


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #StudentY Attributes - for documentation purposes
  #attr_reader :number

  #StudentY Associations - for documentation purposes
  #attr_reader :program, :mentor

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_number)
    @initialized = false
    @deleted = false
    @number = a_number
    @program = nil
    @mentor = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_number(a_number)
    was_set = false
    @number = a_number
    was_set = true
    was_set
  end

  def get_number
    @number
  end

  def get_program
    @program
  end

  def get_mentor
    @mentor
  end

  def set_program(a_new_program)
    was_set = false
    if a_new_program.nil?
      existing_program = @program
      @program = nil
      
      if !existing_program.nil? and !existing_program.get_student.nil?
        existing_program.set_student(nil)
      end
      was_set = true
      return was_set
    end

    current_program = self.get_program
    if !current_program.nil? and !current_program.eql?(a_new_program)
      current_program.set_student(nil)
    end

    @program = a_new_program
    existing_student = a_new_program.get_student

    unless self.eql?(existing_student)
      a_new_program.set_student(self)
    end
    was_set = true
    was_set
  end

  def set_mentor(a_mentor)
    was_set = false
    if !a_mentor.nil? and a_mentor.number_of_students >= MentorY.maximum_number_of_students
      return was_set
    end

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
    unless @program.nil?
      @program.set_student(nil)
    end
    unless @mentor.nil?
      @mentor.remove_student(self)
    end
  end

end
end