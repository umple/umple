# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.16.0.2388 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MultipleSortedStudent


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MultipleSortedStudent Attributes - for documentation purposes
  #attr_reader :id, :name, :multipleSortedRegistrationsPriority

  #MultipleSortedStudent Associations - for documentation purposes
  #attr_reader :multipleSortedAcademy, :multipleSortedRegistrations

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_id, a_name, a_multipleSortedAcademy)
    @initialized = false
    @deleted = false
    @id = a_id
    @name = a_name
    @multipleSortedRegistrationsPriority = "code"
    @multipleSortedAcademy = nil
    did_add_multipleSortedAcademy = set_multipleSortedAcademy(a_multipleSortedAcademy)
    raise "Unable to create registrant due to @multipleSortedAcademy" unless did_add_multipleSortedAcademy
    @multipleSortedRegistrations = []
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_id(a_id)
    was_set = false
    @id = a_id
    was_set = true
    was_set
  end

  def set_name(a_name)
    was_set = false
    @name = a_name
    was_set = true
    was_set
  end

  def set_multipleSortedRegistrationsPriority(a_multipleSortedRegistrationsPriority)
    was_set = false
    @multipleSortedRegistrationsPriority = a_multipleSortedRegistrationsPriority
    was_set = true
    was_set
  end

  def get_id
    @id
  end

  def get_name
    @name
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
      existing_multipleSortedAcademy.remove_registrant(self)
    end
    @multipleSortedAcademy.add_registrant(self)
    was_set = true
    was_set
  end

  def self.minimum_number_of_multipleSortedRegistrations
    0
  end

  def add_multipleSortedRegistration(a_multipleSortedRegistration)
    was_added = false
    return false if index_of_multipleSortedRegistration(a_multipleSortedRegistration) != -1
    existing_multipleSortedStudent = a_multipleSortedRegistration.get_multipleSortedStudent
    is_new_multipleSortedStudent = (!existing_multipleSortedStudent.nil? and !existing_multipleSortedStudent.eql?(self))
    if is_new_multipleSortedStudent
      a_multipleSortedRegistration.set_multipleSortedStudent(self)
    else
      @multipleSortedRegistrations << a_multipleSortedRegistration
    end
    was_added = true
    sort(@multipleSortedRegistrations, @multipleSortedRegistrationsPriority)
    
    was_added
  end

  def remove_multipleSortedRegistration(a_multipleSortedRegistration)
    was_removed = false
    # Unable to remove a_multipleSortedRegistration, as it must always have a multipleSortedStudent
    unless a_multipleSortedRegistration.get_multipleSortedStudent.eql?(self)
      @multipleSortedRegistrations.delete(a_multipleSortedRegistration)
      was_removed = true
    end
    sort(@multipleSortedRegistrations, @multipleSortedRegistrationsPriority)
    
    was_removed
  end

  def sort(toSort, thePriority)
    if(toSort.size > 0)
      methodName = "get_" + thePriority;
        toSort.sort! { |x, y| x.method(methodName).call() <=> y.method(methodName).call() }
    end
  end

  def delete
    @deleted = true
    @placeholder_multipleSortedAcademy = @multipleSortedAcademy
    @multipleSortedAcademy = nil
    @placeholder_multipleSortedAcademy.remove_registrant(self)
    @multipleSortedRegistrations.each do |a_multipleSortedRegistration|
      a_multipleSortedRegistration.delete
    end
  end

end
end