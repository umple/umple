# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE ${last.version} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAttributesTest

class ManyAttribute


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #ManyAttribute Attributes - for documentation purposes
  #attr_reader :works

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @works = []
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def add_work(a_work)
    was_added = false
    was_added = works << a_work
    was_added
  end

  def remove_work(a_work)
    was_removed = false
    was_removed = works.delete(a_work)
    was_removed
  end

  def get_work(index)
    a_work = works[index]
    a_work
  end

  def get_works
    Integer[] new_works = works.toArray(new Integer[works.size])
    new_works
  end

  def number_of_works
    number = works.size
    number;
  end

  def has_works
    has = works.size > 0
    has
  end

  def index_of_work(a_work)
    index = works.index(a_work)
    index = -1 if index.nil?
    index
  end

  def delete
    @deleted = true
  end

end
end