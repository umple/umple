# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.13.0.605 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseTest

class StudentG


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #StudentG Attributes - for documentation purposes
  #attr_reader :number

  #StudentG Associations - for documentation purposes
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
    unless a_mentor.nil?
      @mentor = a_mentor
      a_mentor.instance_variable_set("@student",self)
    end
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

  def delete
    @deleted = true
    raise "Mandatory relationship with mentor not satisfied" if (@initialized and !@deleted and @mentor.nil?)
    unless @program.nil?
      @program.set_student(nil)
    end
    existing_mentor = @mentor
    @mentor = nil
    unless existing_mentor.nil?
      existing_mentor.delete
    end
  end

end
end