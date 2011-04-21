# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.12.0.352 modeling language!

module CruiseTest

class StudentL


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #StudentL Attributes - for documentation purposes
  #attr_reader :number

  #StudentL Associations - for documentation purposes
  #attr_reader :program, :mentor

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_number, a_mentor)
    @initialized = false
    @deleted = false
    @number = a_number
    @program = nil
    @mentor = nil
    did_add_mentor = set_mentor(a_mentor)
    raise "Unable to create student due to @mentor" unless did_add_mentor
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_number(a_number)
    was_set = false
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    @number = a_number
    was_set = true
    was_set
  end

  def get_number
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    @number
  end

  def get_program
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    @program
  end

  def get_mentor
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    @mentor
  end

  def set_program(new_program)
    was_set = false
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    if new_program.nil?
      existing_program = @program
      @program = nil
      
      if !existing_program.nil? and !existing_program.get_student.nil?
        existing_program.set_student(nil)
      end
      was_set = true
      return was_set
    end

    current_program = self.get_program
    if !current_program.nil? and !current_program.eql?(new_program)
      current_program.set_student(nil)
    end

    @program = new_program
    existing_student = new_program.get_student

    unless self.eql?(existing_student)
      new_program.set_student(self)
    end
    was_set = true
    was_set
  end

  def set_mentor(a_mentor)
    was_set = false
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    # Must provide @mentor to student
    if a_mentor.nil?
      return was_set
    end

    # @mentor already at maximum (2)
    if a_mentor.number_of_students >= MentorL.maximum_number_of_students
      return was_set
    end
    
    existing_mentor = @mentor
    @mentor = a_mentor
    if !existing_mentor.nil? and !existing_mentor.eql?(a_mentor)
      didRemove = existing_mentor.remove_student(self)
      unless didRemove
        @mentor = existing_mentor
        return was_set
      end
    end
    @mentor.add_student(self)
    was_set = true
    was_set
  end

  def delete
    @deleted = true
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    unless @program.nil?
      @program.set_student(nil)
    end
    @mentor.remove_student(self)
  end

end
end