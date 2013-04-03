# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.16.0.2388 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MentorB


  #------------------------
  # STATIC VARIABLES
  #------------------------

  @@next_y = 1

  #------------------------
  # MEMBER VARIABLES
  #------------------------



  #Autounique Attributes - for documentation purposes
  #attr_reader y;

  #MentorB Associations - for documentation purposes
  #attr_reader :student, :program

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_student)
    @initialized = false
    @deleted = false
    @y = @@next_y
    @@next_y += 1
    @student = nil
    did_add_student = set_student(a_student)
    raise "Unable to create mentor due to @student" unless did_add_student
    @program = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_y
    @y
  end

  def get_student
    @student
  end

  def get_program
    @program
  end

  def set_student(a_new_student)
    was_set = false
    if a_new_student.nil?
      #Unable to set_student to nil, as mentor must always be associated to a @student
      return was_set
    end
    
    existing_mentor = a_new_student.get_mentor
    if !existing_mentor.nil? and !self.eql?(existing_mentor)
      #Unable to set_student, the current @student already has a mentor, which would be orphaned if it were re-assigned
      return was_set
    end
    
    an_old_student = @student
    @student = a_new_student
    @student.set_mentor(self)

    unless an_old_student.nil?
      an_old_student.set_mentor(nil)
    end
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
    existing_student = @student
    @student = nil
    unless existing_student.nil?
      existing_student.set_mentor(nil)
    end
    unless @program.nil?
      @program.set_mentor(nil)
    end
  end

end
end