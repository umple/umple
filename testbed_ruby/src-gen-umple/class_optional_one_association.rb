# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE ${last.version} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class ClassOptionalOneAssociation


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #ClassOptionalOneAssociation Associations - for documentation purposes
  #attr_reader :otherclass

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_otherclass)
    @initialized = false
    @deleted = false
    @can_set_otherclass = true
    set_otherclass(a_otherclass)
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
    @otherclass = a_new_otherclass
    was_set = true
    was_set
  end

  def delete
    @deleted = true
  end

end
end