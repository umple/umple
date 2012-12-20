# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.1751 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class StudentB


  #------------------------
  # STATIC VARIABLES
  #------------------------

  @@next_x = 1

  #------------------------
  # MEMBER VARIABLES
  #------------------------



  #Autounique Attributes - for documentation purposes
  #attr_reader x;

  #StudentB Associations - for documentation purposes
  #attr_reader :program, :mentor

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @x = @@next_x
    @@next_x += 1
    @program = nil
    @mentor = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_x
    @x
  end

  def get_program
    @program
  end

  def get_mentor
    @mentor
  end

  def set_program(new_program)
    was_set = false
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

  def set_mentor(new_mentor)
    was_set = false
    if !@mentor.nil? and !@mentor.eql?(new_mentor) and self.eql?(@mentor.get_student)
      #Unable to set_mentor, as existing @mentor would become an orphan
      return was_set
    end

    @mentor = new_mentor
    old_student = !new_mentor.nil? ? new_mentor.get_student : nil

    unless self.eql?(old_student)
      unless old_student.nil?
        old_student.instance_variable_set("@mentor",nil)
      end
      unless @mentor.nil?
        @mentor.set_student(self)
      end
    end
    was_set = true
    was_set
  end

  def delete
    @deleted = true
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