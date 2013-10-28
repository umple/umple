# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.18.0.3036 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAttributesTest

class ItemWithUniqueId


  #------------------------
  # STATIC VARIABLES
  #------------------------

  class << self; attr_accessor :itemwithuniqueids_by_id end
  @itemwithuniqueids_by_id = Hash.new

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
    @id = nil
    if (!set_id(a_id))
      raise ArgumentError, 'Cannot create due to duplicate id'
    end
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_id(a_id)
    was_set = false
    an_old_id = get_id();
    if (ItemWithUniqueId.has_with_id?(a_id))
      return was_set
    end
    @id = a_id
    was_set = true
    if (an_old_id != nil)
      ItemWithUniqueId.itemwithuniqueids_by_id[an_old_id] = nil
    end
    ItemWithUniqueId.itemwithuniqueids_by_id[a_id] = self
    was_set
  end

  def get_id
    @id
  end

  def ItemWithUniqueId::get_with_id(a_id)
    @itemwithuniqueids_by_id[a_id]
  end
  def ItemWithUniqueId::has_with_id?(a_id)
    get_with_id(a_id) != nil
  end
  def delete
    @deleted = true
    ItemWithUniqueId.itemwithuniqueids_by_id[get_id()] = nil
  end

end
end