# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.17.0.2716 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MentorM


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorM Attributes - for documentation purposes
  #attr_reader :name

  #MentorM Associations - for documentation purposes
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

  def is_number_of_students_valid
    is_valid = number_of_students >= MentorM.minimum_number_of_students
    is_valid
  end

  def self.minimum_number_of_students
    2
  end

  def add_student(a_student)
    was_added = false
    return false if index_of_student(a_student) != -1
    existing_mentor = a_student.get_mentor
    is_new_mentor = (!existing_mentor.nil? and !existing_mentor.eql?(self))

    if is_new_mentor and existing_mentor.number_of_students <= MentorM.minimum_number_of_students
      return was_added
    end

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
    if a_student.get_mentor.eql?(self)
      return was_removed
    end

    # mentor already at minimum (2)
    if number_of_students <= MentorM.minimum_number_of_students
      return was_removed
    end

    @students.delete(a_student)
    was_removed = true
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