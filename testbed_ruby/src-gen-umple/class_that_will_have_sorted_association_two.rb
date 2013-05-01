# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class ClassThatWillHaveSortedAssociationTwo


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #ClassThatWillHaveSortedAssociationTwo Attributes - for documentation purposes
  #attr_reader :massPriority

  #ClassThatWillHaveSortedAssociationTwo Associations - for documentation purposes
  #attr_reader :mass

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @massPriority = ""
    @mass = []
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_massPriority(a_massPriority)
    was_set = false
    @massPriority = a_massPriority
    was_set = true
    was_set
  end

  def get_massPriority
    @massPriority
  end

  def get_mass(index)
    a_mass = @mass[index]
    a_mass
  end

  def get_mass
    new_mass = @mass.dup
    new_mass
  end

  def number_of_mass
    number = @mass.size
    number
  end

  def has_mass
    has = @mass.size > 0
    has
  end

  def index_of_mass(a_mass)
    index = @mass.index(a_mass)
    index = -1 if index.nil?
    index
  end

  def self.minimum_number_of_mass
    0
  end

  def add_mass(a_mass)
    was_added = false
    return false if index_of_mass(a_mass) != -1
    @mass << a_mass
    was_added = true
    @mass.sort! { |x, y| x.get_name() <=> y.get_name()} if wasAdded
    
    was_added
  end

  def remove_mass(a_mass)
    was_removed = false
    if @mass.include?(a_mass)
      @mass.delete(a_mass)
      was_removed = true
    end
    was_removed
  end


  def delete
    @deleted = true
    @mass.clear
  end

end
end