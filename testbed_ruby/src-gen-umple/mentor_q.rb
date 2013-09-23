# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.18.0.3036 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MentorQ


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorQ Attributes - for documentation purposes
  #attr_reader :name

  #MentorQ Associations - for documentation purposes
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
    raise "Unable to create MentorQ, must have 2 @students" unless did_add_students 
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

  def is_number_of_students_valid
    is_valid = number_of_students >= MentorQ.minimum_number_of_students and number_of_students <= MentorQ.maximum_number_of_students
    is_valid
  end

  def self.required_number_of_students
    2
  end

  def self.minimum_number_of_students
    2
  end

  def self.maximum_number_of_students
    2
  end

  def add_student(a_student)
    was_added = false
    return false if index_of_student(a_student) != -1
    if number_of_students >= MentorQ.maximum_number_of_students
      return was_added
    end

    @students << a_student
    if a_student.index_of_mentor(self) != -1
      was_added = true
    else
      was_added = a_student.add_mentor(self)
      unless was_added
        @students.delete(a_student)
      end
    end
    was_added
  end

  def remove_student(a_student)
    was_removed = false
    unless @students.include?(a_student)
      return was_removed
    end

    if number_of_students <= MentorQ.minimum_number_of_students
      return was_removed
    end

    oldIndex = @students.index(a_student)
    @students.delete_at(oldIndex)
    if a_student.index_of_mentor(self) == -1
      was_removed = true
    else
      was_removed = a_student.remove_mentor(self)
      @students.insert(oldIndex,a_student) unless was_removed
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

    if verified_students.size != new_students.length or verified_students.size < MentorQ.minimum_number_of_students or verified_students.size() > MentorQ.maximum_number_of_students
      return was_set
    end

    old_students = @students.dup
    @students.clear
    verified_students.each do |a_new_student|
      @students << a_new_student
      if old_students.include?(a_new_student)
        old_students.delete(a_new_student)
      else
        a_new_student.add_mentor(self)
      end
    end

    old_students.each do |an_old_student|
      an_old_student.remove_mentor(self)
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
    copy_of_students = @students.dup
    @students.clear
    copy_of_students.each do |a_student|
      a_student.remove_mentor(self)
    end
    unless @program.nil?
      @program.set_mentor(nil)
    end
  end

end
end