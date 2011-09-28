# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.13.0.605 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseTest

class MentorC


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorC Attributes - for documentation purposes
  #attr_reader :name

  #MentorC Associations - for documentation purposes
  #attr_reader :students, :program

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name)
    @initialized = false
    @deleted = false
    @name = a_name
    @students = []
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

  def self.minimum_number_of_students
    0
  end

  def add_student(a_student)
    was_added = false
    return false if index_of_student(a_student) != -1
    existing_mentor = a_student.get_mentor
    if existing_mentor.nil?
      a_student.set_mentor(self)
    elsif !existing_mentor.eql?(self)
      existing_mentor.remove_student(a_student)
      add_student(a_student)
    else
      @students << a_student
    end
    was_added = true
    was_added
  end

  def remove_student(a_student)
    was_removed = false
    if @students.include?(a_student)
      @students.delete(a_student)
      a_student.set_mentor(nil)
      was_removed = true
    end
    was_removed
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
      a_student.set_mentor(nil)
    end
    unless @program.nil?
      @program.set_mentor(nil)
    end
  end

end
end