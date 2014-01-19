# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE ${last.version} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruisePatternsTest

class WidgetMutableB


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #WidgetMutableB Associations - for documentation purposes
  #attr_reader :widgetImmutableBs

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @widgetImmutableBs = []
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_widgetImmutableB(index)
    a_widgetImmutableB = @widgetImmutableBs[index]
    a_widgetImmutableB
  end

  def get_widgetImmutableBs
    new_widgetImmutableBs = @widgetImmutableBs.dup
    new_widgetImmutableBs
  end

  def number_of_widgetImmutableBs
    number = @widgetImmutableBs.size
    number
  end

  def has_widgetImmutableBs
    has = @widgetImmutableBs.size > 0
    has
  end

  def index_of_widgetImmutableB(a_widgetImmutableB)
    index = @widgetImmutableBs.index(a_widgetImmutableB)
    index = -1 if index.nil?
    index
  end

  def self.minimum_number_of_widgetImmutableBs
    0
  end

  def self.maximum_number_of_widgetImmutableBs
    10
  end

  def add_widgetImmutableB(a_widgetImmutableB)
    was_added = false
    return false if index_of_widgetImmutableB(a_widgetImmutableB) != -1
    if number_of_widgetImmutableBs < WidgetMutableB.maximum_number_of_widgetImmutableBs
      @widgetImmutableBs << a_widgetImmutableB
      was_added = true
    end
    was_added
  end

  def remove_widgetImmutableB(a_widgetImmutableB)
    was_removed = false
    if @widgetImmutableBs.include?(a_widgetImmutableB)
      @widgetImmutableBs.delete(a_widgetImmutableB)
      was_removed = true
    end
    was_removed
  end

  def set_widgetImmutableBs(new_widgetImmutableBs)
    was_set = false
    verified_widgetImmutableBs = []
    new_widgetImmutableBs.each do |a_widgetImmutableB|
      next if (verified_widgetImmutableBs.include?(a_widgetImmutableB))
      verified_widgetImmutableBs << a_widgetImmutableB
    end

    if verified_widgetImmutableBs.size != new_widgetImmutableBs.size or verified_widgetImmutableBs.size() > WidgetMutableB.maximum_number_of_widgetImmutableBs
      return was_set
    end

    @widgetImmutableBs.clear
    verified_widgetImmutableBs.each do |a_widgetImmutableB|
      @widgetImmutableBs << a_widgetImmutableB
    end

    was_set = true
    was_set
  end

  def add_widgetImmutableB_at(a_widgetImmutableB, index)
    was_added = false
    if add_widgetImmutableB(a_widgetImmutableB)
      if(index < 0)
        index = 0
      end
      if(index > number_of_widgetImmutableBs())
        index = number_of_widgetImmutableBs() - 1
      end
      @widgetImmutableBs.delete(a_widgetImmutableB)
      @widgetImmutableBs.insert(index, a_widgetImmutableB)
      was_added = true
    end
    was_added
  end

  def add_or_move_widgetImmutableB_at(a_widgetImmutableB, index)
    was_added = false
    if @widgetImmutableBs.include?(a_widgetImmutableB)
      if(index < 0)
        index = 0
      end
      if(index > number_of_widgetImmutableBs())
        index = number_of_widgetImmutableBs() - 1
      end
      @widgetImmutableBs.delete(a_widgetImmutableB)
      @widgetImmutableBs.insert(index, a_widgetImmutableB)
      was_added = true
    else
      was_added = add_widgetImmutableB_at(a_widgetImmutableB, index)
    end
    was_added
  end

  def delete
    @deleted = true
    @widgetImmutableBs.clear
  end

end
end