# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.12.0.352 modeling language!

module CruiseTest

class ProgramF


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #ProgramF Associations - for documentation purposes
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

  def set_mentor(new_mentor)
    was_set = false
    if new_mentor.nil?
      existing_mentor = @mentor
      @mentor = nil
      
      if !existing_mentor.nil? and !existing_mentor.get_program.nil?
        existing_mentor.set_program(nil)
      end
      was_set = true
      return was_set
    end

    current_mentor = self.get_mentor
    if !current_mentor.nil? and !current_mentor.eql?(new_mentor)
      current_mentor.set_program(nil)
    end

    @mentor = new_mentor
    existing_program = new_mentor.get_program

    unless self.eql?(existing_program)
      new_mentor.set_program(self)
    end
    was_set = true
    was_set
  end

  def set_student(new_student)
    was_set = false
    if new_student.nil?
      existing_student = @student
      @student = nil
      
      if !existing_student.nil? and !existing_student.get_program.nil?
        existing_student.set_program(nil)
      end
      was_set = true
      return was_set
    end

    current_student = self.get_student
    if !current_student.nil? and !current_student.eql?(new_student)
      current_student.set_program(nil)
    end

    @student = new_student
    existing_program = new_student.get_program

    unless self.eql?(existing_program)
      new_student.set_program(self)
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