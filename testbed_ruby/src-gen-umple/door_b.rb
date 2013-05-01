# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAttributesTest

class DoorB


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #DoorB Attributes - for documentation purposes
  #attr_reader :id

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_id)
    @initialized = false
    @deleted = false
    @cachedHashCode = -1
    @can_set_id = true
    @id = a_id
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_id(a_id)
    was_set = false
    return false unless @can_set_id
    @id = a_id
    was_set = true
    was_set
  end

  def get_id
    @id
  end

  def eql?(obj)
    return false if obj.nil?
    return false unless self.class == obj.class

    compareTo = obj
    return false unless @id == compareTo.instance_variable_get("@id")
    true
  end

  def hash
    return @cachedHashCode unless @cachedHashCode == -1
    @cachedHashCode = 17
    @cachedHashCode = @cachedHashCode * 23 + @id
    @can_set_id = false
    @cachedHashCode
  end

  def delete
    @deleted = true
  end

end
end