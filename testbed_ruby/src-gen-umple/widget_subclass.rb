# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE ${last.version} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruisePatternsTest

class WidgetSubclass < WidgetImmutableB


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #WidgetSubclass Attributes - for documentation purposes
  #attr_reader :type

  #WidgetSubclass Associations - for documentation purposes
  #attr_reader :widgetImmutableBs

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name, a_type, all_widgetImmutableBs)
    super(a_name)
    @initialized = false
    @deleted = false
    @type = a_type
    @can_set_type = false
    @can_set_widgetImmutableBs = true
    @widgetImmutableBs = []
    did_add_widgetImmutableBs = set_widgetImmutableBs(all_widgetImmutableBs)
    raise "Unable to create WidgetSubclass, must have 2 or fewer @widgetImmutableBs, no duplicates" unless did_add_widgetImmutableBs
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_type
    @type
  end

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
    2
  end

  def set_widgetImmutableBs(new_widgetImmutableBs)
    was_set = false
    return false unless @can_set_widgetImmutableBs
    @can_set_widgetImmutableBs = false
    verified_widgetImmutableBs = []
    new_widgetImmutableBs.each do |a_widgetImmutableB|
      next if (verified_widgetImmutableBs.include?(a_widgetImmutableB))
      verified_widgetImmutableBs << a_widgetImmutableB
    end

    if verified_widgetImmutableBs.size != new_widgetImmutableBs.size or verified_widgetImmutableBs.size() > WidgetSubclass.maximum_number_of_widgetImmutableBs
      return was_set
    end

    @widgetImmutableBs.clear
    verified_widgetImmutableBs.each do |a_widgetImmutableB|
      @widgetImmutableBs << a_widgetImmutableB
    end

    was_set = true
    was_set
  end

  def delete
    @deleted = true
    super
  end

end
end