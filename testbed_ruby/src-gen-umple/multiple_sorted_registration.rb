# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE ${last.version} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MultipleSortedRegistration


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MultipleSortedRegistration Associations - for documentation purposes
  #attr_reader :multipleSortedCourse, :multipleSortedStudent

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_multipleSortedCourse, a_multipleSortedStudent)
    @initialized = false
    @deleted = false
    @multipleSortedCourse = nil
    did_add_multipleSortedCourse = set_multipleSortedCourse(a_multipleSortedCourse)
    raise "Unable to create multipleSortedRegistration due to @multipleSortedCourse" unless did_add_multipleSortedCourse
    @multipleSortedStudent = nil
    did_add_multipleSortedStudent = set_multipleSortedStudent(a_multipleSortedStudent)
    raise "Unable to create multipleSortedRegistration due to @multipleSortedStudent" unless did_add_multipleSortedStudent
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_name
    getMultipleSortedStudent().getName()
  end

  def get_code
    getMultipleSortedCourse().getCode()
  end

  def get_multipleSortedCourse
    @multipleSortedCourse
  end

  def get_multipleSortedStudent
    @multipleSortedStudent
  end

  def set_multipleSortedCourse(a_multipleSortedCourse)
    was_set = false
    if a_multipleSortedCourse.nil?
      return was_set
    end

    existing_multipleSortedCourse = @multipleSortedCourse
    @multipleSortedCourse = a_multipleSortedCourse
    if !existing_multipleSortedCourse.nil? and !existing_multipleSortedCourse.eql?(a_multipleSortedCourse)
      existing_multipleSortedCourse.remove_multipleSortedRegistration(self)
    end
    @multipleSortedCourse.add_multipleSortedRegistration(self)
    was_set = true
    was_set
  end

  def set_multipleSortedStudent(a_multipleSortedStudent)
    was_set = false
    if a_multipleSortedStudent.nil?
      return was_set
    end

    existing_multipleSortedStudent = @multipleSortedStudent
    @multipleSortedStudent = a_multipleSortedStudent
    if !existing_multipleSortedStudent.nil? and !existing_multipleSortedStudent.eql?(a_multipleSortedStudent)
      existing_multipleSortedStudent.remove_multipleSortedRegistration(self)
    end
    @multipleSortedStudent.add_multipleSortedRegistration(self)
    was_set = true
    was_set
  end

  def delete
    @deleted = true
    @placeholder_multipleSortedCourse = @multipleSortedCourse
    @multipleSortedCourse = nil
    @placeholder_multipleSortedCourse.remove_multipleSortedRegistration(self)
    @placeholder_multipleSortedStudent = @multipleSortedStudent
    @multipleSortedStudent = nil
    @placeholder_multipleSortedStudent.remove_multipleSortedRegistration(self)
  end

end
end