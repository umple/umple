# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.11.1.3376 modeling language!

module CruiseTest

class StudentO


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #StudentO Attributes - for documentation purposes
  #attr_reader :number

  #StudentO Associations - for documentation purposes
  #attr_reader :program, :mentors

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_number)
    @initialized = false
    @deleted = false
    @number = a_number
    @program = nil
    @mentors = []
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_number(a_number)
    was_set = false
    @number = a_number
    was_set = true
    was_set
  end

  def get_number
    @number
  end

  def get_program
    @program
  end

  def get_mentor(index)
    a_mentor = @mentors[index]
    a_mentor
  end

  def get_mentors
    new_mentors = @mentors.dup
    new_mentors
  end

  def number_of_mentors
    number = @mentors.size
    number
  end

  def has_mentors
    has = @mentors.size > 0
    has
  end

  def index_of_mentor(a_mentor)
    index = @mentors.index(a_mentor)
    index = -1 if index.nil?
    index
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

  def self.minimum_number_of_mentors
    0
  end

  def add_mentor(a_mentor)
    was_added = false
    return false if index_of_mentor(a_mentor) != -1
    @mentors << a_mentor
    if a_mentor.index_of_student(self) != -1
      was_added = true
    else
      was_added = a_mentor.add_student(self)
      unless was_added
        @mentors.delete(a_mentor)
      end
    end
    was_added
  end

  def remove_mentor(a_mentor)
    was_removed = false
    unless @mentors.include?(a_mentor)
      return was_removed
    end

    oldIndex = @mentors.index(a_mentor)
    @mentors.delete_at(oldIndex)
    if a_mentor.index_of_student(self) == -1
      was_removed = true
    else
      was_removed = a_mentor.remove_student(self)
      @mentors.insert(oldIndex,a_mentor) unless was_removed
    end
    was_removed
  end

  def delete
    @deleted = true
    unless @program.nil?
      @program.set_student(nil)
    end
    copy_of_mentors = @mentors.dup
    @mentors.clear
    copy_of_mentors.each do |a_mentor|
      if a_mentor.number_of_students <= MentorO.minimum_number_of_students
        a_mentor.delete
      else
        a_mentor.remove_student(self)
      end
    end
  end

end
end