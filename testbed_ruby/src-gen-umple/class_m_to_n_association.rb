# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.1751 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class ClassMToNAssociation


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #ClassMToNAssociation Associations - for documentation purposes
  #attr_reader :otherclasses

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(all_otherclasses)
    @initialized = false
    @deleted = false
    @can_set_otherclasses = true
    @otherclasses = []
    did_add_otherclasses = set_otherclasses(all_otherclasses)
    raise "Unable to create ClassMToNAssociation, must have 2 to 3 @otherclasses" unless did_add_otherclasses 
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_otherclass(index)
    a_otherclass = @otherclasses[index]
    a_otherclass
  end

  def get_otherclasses
    new_otherclasses = @otherclasses.dup
    new_otherclasses
  end

  def number_of_otherclasses
    number = @otherclasses.size
    number
  end

  def has_otherclasses
    has = @otherclasses.size > 0
    has
  end

  def index_of_otherclass(a_otherclass)
    index = @otherclasses.index(a_otherclass)
    index = -1 if index.nil?
    index
  end

  def self.minimum_number_of_otherclasses
    2
  end

  def self.maximum_number_of_otherclasses
    3
  end

  def set_otherclasses(new_otherclasses)
    was_set = false
    return false unless @can_set_otherclasses
    @can_set_otherclasses = false
    verified_otherclasses = []
    new_otherclasses.each do |a_otherclass|
      next if (verified_otherclasses.include?(a_otherclass))
      verified_otherclasses << a_otherclass
    end

    if verified_otherclasses.size != new_otherclasses.size or verified_otherclasses.size < ClassMToNAssociation.minimum_number_of_otherclasses or verified_otherclasses.size > ClassMToNAssociation.maximum_number_of_otherclasses
      return was_set
    end

    @otherclasses.clear
    verified_otherclasses.each do |a_otherclass|
      @otherclasses << a_otherclass
    end
    was_set = true
    was_set
  end

  def delete
    @deleted = true
  end

end
end