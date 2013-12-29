# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE ${last.version} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MentorZ


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorZ Attributes - for documentation purposes
  #attr_reader :name

  #MentorZ Associations - for documentation purposes
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
    3
  end

  def add_student(a_student)
    was_added = false
    return false if index_of_student(a_student) != -1
    if number_of_students >= MentorZ.maximum_number_of_students
      return was_added
    end

    existing_mentor = a_student.get_mentor
    is_new_mentor = (!existing_mentor.nil? and !existing_mentor.eql?(self))
    if is_new_mentor
      a_student.set_mentor(self)
    else
      @students << a_student
    end
    was_added = true
    was_added
  end

  def remove_student(a_student)
    was_removed = false
    # Unable to remove a_student, as it must always have a mentor
    unless a_student.get_mentor.eql?(self)
      @students.delete(a_student)
      was_removed = true
    end
    was_removed
  end

  def add_student_at(a_student, index)
    was_added = false
    if add_student(a_student)
      if(index < 0)
        index = 0
      end
      if(index > number_of_students())
        index = number_of_students() - 1
      end
      @students.delete(a_student)
      @students.insert(index, a_student)
      was_added = true
    end
    was_added
  end

  def add_or_move_student_at(a_student, index)
    was_added = false
    if @students.include?(a_student)
      if(index < 0)
        index = 0
      end
      if(index > number_of_students())
        index = number_of_students() - 1
      end
      @students.delete(a_student)
      @students.insert(index, a_student)
      was_added = true
    else
      was_added = add_student_at(a_student, index)
    end
    was_added
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
    @students.each do |a_student|
      a_student.delete
    end
    unless @program.nil?
      @program.set_mentor(nil)
    end
  end

end
end