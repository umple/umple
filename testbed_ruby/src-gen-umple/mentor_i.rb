# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.963 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseTest

class MentorI


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorI Attributes - for documentation purposes
  #attr_reader :name

  #MentorI Associations - for documentation purposes
  #attr_reader :students, :program

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name, all_students)
    @initialized = false
    @deleted = false
    @name = a_name
    @students = []
    did_add_students = set_students(all_students)
    raise "Unable to create MentorI, must have 2 to 4 @students" unless did_add_students 
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
    2
  end

  def self.maximum_number_of_students
    4
  end

  def add_student(a_student)
    was_added = false
    return false if index_of_student(a_student) != -1
    if number_of_students < MentorI.maximum_number_of_students
      @students << a_student
      was_added = true
    end
    was_added
  end

  def remove_student(a_student)
    was_removed = false
    unless @students.include?(a_student)
      return was_removed
    end

    if number_of_students <= MentorI.minimum_number_of_students
      return was_removed
    end

    @students.delete(a_student)
    was_removed = true
    was_removed
  end

  def set_students(new_students)
    was_set = false
    verified_students = []
    new_students.each do |a_student|
      next if (verified_students.include?(a_student))
      verified_students << a_student
    end

    if verified_students.size != new_students.size or verified_students.size < MentorI.minimum_number_of_students or verified_students.size > MentorI.maximum_number_of_students
      return was_set
    end

    @students.clear
    verified_students.each do |a_student|
      @students << a_student
    end
    was_set = true
    was_set
  end

  def set_program(new_program)
    was_set = false
    if new_program.nil?
      existing_program = @program
      @program = nil
      
      if !existing_program.nil? and !existing_program.get_mentorI.nil?
        existing_program.set_mentorI(nil)
      end
      was_set = true
      return was_set
    end

    current_program = self.get_program
    if !current_program.nil? and !current_program.eql?(new_program)
      current_program.set_mentorI(nil)
    end

    @program = new_program
    existing_mentorI = new_program.get_mentorI

    unless self.eql?(existing_mentorI)
      new_program.set_mentorI(self)
    end
    was_set = true
    was_set
  end

  def delete
    @deleted = true
    @students.clear
    unless @program.nil?
      @program.set_mentorI(nil)
    end
  end

end
end