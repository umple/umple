# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.12.1.605 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseTest

class MentorG


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorG Attributes - for documentation purposes
  #attr_reader :name

  #MentorG Associations - for documentation purposes
  #attr_reader :student, :program

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name, a_student)
    @initialized = false
    @deleted = false
    @name = a_name
    @student = nil
    unless a_student.nil?
      @student = a_student
      a_student.instance_variable_set("@mentor",self)
    end
    @program = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_name(a_name)
    was_set = false
    raise "Mandatory relationship with student not satisfied" if (@initialized and !@deleted and @student.nil?)
    @name = a_name
    was_set = true
    was_set
  end

  def get_name
    raise "Mandatory relationship with student not satisfied" if (@initialized and !@deleted and @student.nil?)
    @name
  end

  def get_student
    raise "Mandatory relationship with student not satisfied" if (@initialized and !@deleted and @student.nil?)
    @student
  end

  def get_program
    raise "Mandatory relationship with student not satisfied" if (@initialized and !@deleted and @student.nil?)
    @program
  end

  def set_program(new_program)
    was_set = false
    raise "Mandatory relationship with student not satisfied" if (@initialized and !@deleted and @student.nil?)
    if new_program.nil?
      existing_program = @program
      @program = nil
      
      if !existing_program.nil? and !existing_program.get_mentor.nil?
        existing_program.set_mentor(nil)
      end
      was_set = true
      return was_set
    end

    current_program = self.get_program
    if !current_program.nil? and !current_program.eql?(new_program)
      current_program.set_mentor(nil)
    end

    @program = new_program
    existing_mentor = new_program.get_mentor

    unless self.eql?(existing_mentor)
      new_program.set_mentor(self)
    end
    was_set = true
    was_set
  end

  def delete
    @deleted = true
    raise "Mandatory relationship with student not satisfied" if (@initialized and !@deleted and @student.nil?)
    existing_student = @student
    @student = nil
    unless existing_student.nil?
      existing_student.delete
    end
    unless @program.nil?
      @program.set_mentor(nil)
    end
  end

end
end