# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.16.0.2388 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class ClassOneAssociation


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #ClassOneAssociation Associations - for documentation purposes
  #attr_reader :otherclass

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_otherclass)
    @initialized = false
    @deleted = false
    @can_set_otherclass = true
    unless set_otherclass(a_otherclass)
      raise "Unable to create ClassOneAssociation due to a_otherclass" 
    end
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_otherclass
    @otherclass
  end

  def set_otherclass(a_new_otherclass)
    was_set = false
    return false unless @can_set_otherclass
    @can_set_otherclass = false
    unless a_new_otherclass.nil?
      @otherclass = a_new_otherclass
      was_set = true
    end
    was_set
  end

  def delete
    @deleted = true
  end

end
end