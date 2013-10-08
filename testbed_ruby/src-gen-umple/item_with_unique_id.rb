# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.18.0.3036 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAttributesTest

class ItemWithUniqueId


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #ItemWithUniqueId Attributes - for documentation purposes
  #attr_reader :id

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_id)
    @initialized = false
    @deleted = false
    @id = a_id
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

  def get_id
    @id
  end

  def delete
    @deleted = true
  end

end
end