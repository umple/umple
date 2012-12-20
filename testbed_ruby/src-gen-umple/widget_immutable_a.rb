# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.15.0.1751 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruisePatternsTest

class WidgetImmutableA


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #WidgetImmutableA Attributes - for documentation purposes
  #attr_reader :name

  #WidgetImmutableA Associations - for documentation purposes
  #attr_reader :widgetImmutableB

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name, a_widgetImmutableB)
    @initialized = false
    @deleted = false
    @name = a_name
    @can_set_name = false
    @can_set_widgetImmutableB = true
    unless set_widgetImmutableB(a_widgetImmutableB)
      raise "Unable to create WidgetImmutableA due to a_widgetImmutableB" 
    end
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_name
    raise "Mandatory relationship with widgetImmutableB not satisfied" if (@initialized and !@deleted and @widgetImmutableB.nil?)
    @name
  end

  def get_widgetImmutableB
    raise "Mandatory relationship with widgetImmutableB not satisfied" if (@initialized and !@deleted and @widgetImmutableB.nil?)
    @widgetImmutableB
  end

  def set_widgetImmutableB(new_widgetImmutableB)
    was_set = false
    return false unless @can_set_widgetImmutableB
    @can_set_widgetImmutableB = false
    raise "Mandatory relationship with widgetImmutableB not satisfied" if (@initialized and !@deleted and @widgetImmutableB.nil?)
    unless new_widgetImmutableB.nil?
      @widgetImmutableB = new_widgetImmutableB
      was_set = true
    end
    was_set
  end

  def delete
    @deleted = true
    raise "Mandatory relationship with widgetImmutableB not satisfied" if (@initialized and !@deleted and @widgetImmutableB.nil?)
  end

end
end