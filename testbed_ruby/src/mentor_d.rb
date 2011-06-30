# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.12.1.605 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseTest

class MentorD


  #------------------------
  # STATIC VARIABLES
  #------------------------

  @@next_y = 1

  #------------------------
  # MEMBER VARIABLES
  #------------------------



  #Autounique Attributes - for documentation purposes
  #attr_reader y;

  #MentorD Associations - for documentation purposes
  #attr_reader :students, :program

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(all_students)
    @initialized = false
    @deleted = false
    @y = @@next_y
    @@next_y += 1
    @students = []
    did_add_students = set_students(all_students)
    raise "Unable to create MentorD, must have 3 @students" unless did_add_students 
    @program = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_y
    @y
  end

  def get_student(index)
    a_student = @students[index]
    a_student
  end

  def get_students
    new_students = @students.dup
    new_students
  end

  def number_of_students
    number = @students.size
    number
  end

  def has_students
    has = @students.size > 0
    has
  end

  def index_of_student(a_student)
    index = @students.index(a_student)
    index = -1 if index.nil?
    index
  end

  def get_program
    @program
  end

  def self.required_number_of_students
    3
  end

  def self.minimum_number_of_students
    3
  end

  def self.maximum_number_of_students
    3
  end

  def set_students(new_students)
    was_set = false
    check_new_students = []
    new_students.each do |new_student|
      if check_new_students.include?(new_student)
        return was_set
      elsif !new_student.get_mentor.nil? and !new_student.get_mentor.eql?(self)
        return was_set
      end
      check_new_students << new_student
    end

    if check_new_students.size != MentorD.minimum_number_of_students
      return was_set
    end

    check_new_students.each do |a_student|
      @students.delete(a_student)
    end
    
    @students.each do |orphan|
      orphan.instance_variable_set("@mentor",nil)
    end
    @students.clear
    new_students.each do |new_student|
      new_student.instance_variable_set("@mentor",self)
      @students << new_student
    end
    was_set = true
    was_set
  end

  def set_program(new_program)
    was_set = false
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
    @students.each do |a_student|
      a_student.instance_variable_set("@mentor",nil)
    end
    @students.clear
    unless @program.nil?
      @program.set_mentor(nil)
    end
  end

end
end