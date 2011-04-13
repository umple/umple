# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.11.1.3376 modeling language!

module CruiseTest

class MentorAK


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorAK Attributes - for documentation purposes
  #attr_reader :name

  #MentorAK Associations - for documentation purposes
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

  def self.maximum_number_of_students
    2
  end

  def add_student(a_student)
    was_added = false
    return false if index_of_student(a_student) != -1
    if number_of_students < MentorAK.maximum_number_of_students
      @students << a_student
      was_added = true
    end
    was_added
  end

  def remove_student(a_student)
    was_removed = false
    if @students.include?(a_student)
      @students.delete(a_student)
      was_removed = true
    end
    was_removed
  end

  def set_students(new_students)
    was_set = false
    verified_students = []
    new_students.each do |a_student|
      next if (verified_students.include?(a_student))
      verified_students << a_student
    end

    if verified_students.size != new_students.size or verified_students.size() > MentorAK.maximum_number_of_students
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
    @students.clear
    unless @program.nil?
      @program.set_mentor(nil)
    end
  end

end
end