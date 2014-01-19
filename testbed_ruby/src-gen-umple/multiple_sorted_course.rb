# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE ${last.version} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MultipleSortedCourse


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MultipleSortedCourse Attributes - for documentation purposes
  #attr_reader :code, :multipleSortedRegistrationsPriority

  #MultipleSortedCourse Associations - for documentation purposes
  #attr_reader :multipleSortedAcademy, :multipleSortedRegistrations

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_code, a_multipleSortedAcademy)
    @initialized = false
    @deleted = false
    @code = a_code
    @multipleSortedRegistrationsPriority = ""
    @multipleSortedAcademy = nil
    did_add_multipleSortedAcademy = set_multipleSortedAcademy(a_multipleSortedAcademy)
    raise "Unable to create multipleSortedCourse due to @multipleSortedAcademy" unless did_add_multipleSortedAcademy
    @multipleSortedRegistrations = []
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_code(a_code)
    was_set = false
    @code = a_code
    was_set = true
    was_set
  end

  def set_multipleSortedRegistrationsPriority(a_multipleSortedRegistrationsPriority)
    was_set = false
    @multipleSortedRegistrationsPriority = a_multipleSortedRegistrationsPriority
    was_set = true
    was_set
  end

  def get_code
    @code
  end

  def get_multipleSortedRegistrationsPriority
    @multipleSortedRegistrationsPriority
  end

  def get_multipleSortedAcademy
    @multipleSortedAcademy
  end

  def get_multipleSortedRegistration(index)
    a_multipleSortedRegistration = @multipleSortedRegistrations[index]
    a_multipleSortedRegistration
  end

  def get_multipleSortedRegistrations
    new_multipleSortedRegistrations = @multipleSortedRegistrations.dup
    new_multipleSortedRegistrations
  end

  def number_of_multipleSortedRegistrations
    number = @multipleSortedRegistrations.size
    number
  end

  def has_multipleSortedRegistrations
    has = @multipleSortedRegistrations.size > 0
    has
  end

  def index_of_multipleSortedRegistration(a_multipleSortedRegistration)
    index = @multipleSortedRegistrations.index(a_multipleSortedRegistration)
    index = -1 if index.nil?
    index
  end

  def set_multipleSortedAcademy(a_multipleSortedAcademy)
    was_set = false
    if a_multipleSortedAcademy.nil?
      return was_set
    end

    existing_multipleSortedAcademy = @multipleSortedAcademy
    @multipleSortedAcademy = a_multipleSortedAcademy
    if !existing_multipleSortedAcademy.nil? and !existing_multipleSortedAcademy.eql?(a_multipleSortedAcademy)
      existing_multipleSortedAcademy.remove_multipleSortedCourse(self)
    end
    @multipleSortedAcademy.add_multipleSortedCourse(self)
    was_set = true
    was_set
  end

  def self.minimum_number_of_multipleSortedRegistrations
    0
  end

  def add_multipleSortedRegistration(a_multipleSortedRegistration)
    was_added = false
    return false if index_of_multipleSortedRegistration(a_multipleSortedRegistration) != -1
    existing_multipleSortedCourse = a_multipleSortedRegistration.get_multipleSortedCourse
    is_new_multipleSortedCourse = (!existing_multipleSortedCourse.nil? and !existing_multipleSortedCourse.eql?(self))
    if is_new_multipleSortedCourse
      a_multipleSortedRegistration.set_multipleSortedCourse(self)
    else
      @multipleSortedRegistrations << a_multipleSortedRegistration
    end
    was_added = true
    @multipleSortedRegistrations.sort! { |x, y| x.get_name() <=> y.get_name()} if wasAdded
    
    was_added
  end

  def remove_multipleSortedRegistration(a_multipleSortedRegistration)
    was_removed = false
    # Unable to remove a_multipleSortedRegistration, as it must always have a multipleSortedCourse
    unless a_multipleSortedRegistration.get_multipleSortedCourse.eql?(self)
      @multipleSortedRegistrations.delete(a_multipleSortedRegistration)
      was_removed = true
    end
    was_removed
  end


  def delete
    @deleted = true
    @placeholder_multipleSortedAcademy = @multipleSortedAcademy
    @multipleSortedAcademy = nil
    @placeholder_multipleSortedAcademy.remove_multipleSortedCourse(self)
    @multipleSortedRegistrations.each do |a_multipleSortedRegistration|
      a_multipleSortedRegistration.delete
    end
  end

end
end