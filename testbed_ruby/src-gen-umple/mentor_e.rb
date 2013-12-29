# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.19.0.3287 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MentorE


  #------------------------
  # STATIC VARIABLES
  #------------------------

  @@next_y = 1

  #------------------------
  # MEMBER VARIABLES
  #------------------------



  #Autounique Attributes - for documentation purposes
  #attr_reader y;

  #MentorE Associations - for documentation purposes
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
    raise "Unable to create MentorE, must have 2 to 5 @students" unless did_add_students 
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

  def self.minimum_number_of_students
    2
  end

  def self.maximum_number_of_students
    5
  end

  def add_student(a_student)
    was_added = false
    return false if index_of_student(a_student) != -1
    if number_of_students >= MentorE.maximum_number_of_students
      return was_added
    end
    existing_mentor = a_student.get_mentor
    if !existing_mentor.nil? and existing_mentor.number_of_students <= MentorE.minimum_number_of_students
      return was_added
    elsif !existing_mentor.nil?
      existing_mentor.instance_variable_get("@students").delete(a_student)
    end
    @students << a_student
    a_student.instance_variable_set("@mentor",self)
    was_added = true
    was_added
  end

  def remove_student(a_student)
    was_removed = false
    if @students.include?(a_student) and number_of_students > MentorE.minimum_number_of_students
      @students.delete(a_student)
      a_student.instance_variable_set("@mentor",nil)
      was_removed = true
    end
    was_removed
  end

  def set_students(new_students)
    was_set = false
    if new_students.length < MentorE.minimum_number_of_students or new_students.size > MentorE.maximum_number_of_students
      return was_set
    end

    check_new_students = []
    mentorToNewStudents = {}
    new_students.each do |a_student|
      if check_new_students.include?(a_student)
        return was_set
      elsif !a_student.get_mentor.nil? and !a_student.get_mentor.eql?(self)
        existing_mentor = a_student.get_mentor
        unless mentorToNewStudents.has_key?(existing_mentor)
          mentorToNewStudents[existing_mentor] = existing_mentor.number_of_students
        end
        currentCount = mentorToNewStudents[existing_mentor]
        nextCount = currentCount - 1
        if nextCount < 2
          return was_set
        end
        mentorToNewStudents[existing_mentor] = nextCount
      end
      check_new_students << a_student
    end

    check_new_students.each do |a_student|
      @students.delete(a_student)
    end

    @students.each do |orphan|
      orphan.instance_variable_set("@mentor",nil)
    end
    @students.clear
    new_students.each do |a_student|
      unless a_student.get_mentor.nil?
        a_student.get_mentor.instance_variable_get("@students").delete(a_student)
      end
      a_student.instance_variable_set("@mentor",self)
      @students << a_student
    end
    was_set = true
    was_set
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
      a_student.instance_variable_set("@mentor",nil)
    end
    @students.clear
    unless @program.nil?
      @program.set_mentor(nil)
    end
  end

end
end