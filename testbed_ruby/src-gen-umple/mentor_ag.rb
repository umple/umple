# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.963 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MentorAG


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorAG Attributes - for documentation purposes
  #attr_reader :name

  #MentorAG Associations - for documentation purposes
  #attr_reader :friend

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name)
    @initialized = false
    @deleted = false
    @name = a_name
    @friend = []
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_name(a_name)
    was_set = false
    @name = a_name
    was_set = true
    was_set
  end

  def get_name
    @name
  end

  def get_friend(index)
    a_friend = @friend[index]
    a_friend
  end

  def get_friend
    new_friend = @friend.dup
    new_friend
  end

  def number_of_friend
    number = @friend.size
    number
  end

  def has_friend
    has = @friend.size > 0
    has
  end

  def index_of_friend(a_friend)
    index = @friend.index(a_friend)
    index = -1 if index.nil?
    index
  end

  def self.minimum_number_of_friend
    0
  end

  def add_friend(a_friend)
    was_added = false
    return false if index_of_friend(a_friend) != -1
    @friend << a_friend
    if a_friend.index_of_friend(self) != -1
      was_added = true
    else
      was_added = a_friend.add_friend(self)
      unless was_added
        @friend.delete(a_friend)
      end
    end
    was_added
  end

  def remove_friend(a_friend)
    was_removed = false
    unless @friend.include?(a_friend)
      return was_removed
    end

    oldIndex = @friend.index(a_friend)
    @friend.delete_at(oldIndex)
    if a_friend.index_of_friend(self) == -1
      was_removed = true
    else
      was_removed = a_friend.remove_friend(self)
      @friend.insert(oldIndex,a_friend) unless was_removed
    end
    was_removed
  end

  def delete
    @deleted = true
    copy_of_friend = @friend.dup
    @friend.clear
    copy_of_friend.each do |a_friend|
      a_friend.remove_friend(self)
    end
  end

end
end