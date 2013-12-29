# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE ${last.version} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MentorAF


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorAF Attributes - for documentation purposes
  #attr_reader :name

  #MentorAF Associations - for documentation purposes
  #attr_reader :friend

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name, a_friend)
    @initialized = false
    @deleted = false
    @name = a_name
    @friend = nil
    unless a_friend.nil?
      @friend = a_friend
      a_friend.instance_variable_set("@friend",self)
    end
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_name(a_name)
    was_set = false
    raise "Mandatory relationship with friend not satisfied" if (@initialized and !@deleted and @friend.nil?)
    @name = a_name
    was_set = true
    was_set
  end

  def get_name
    raise "Mandatory relationship with friend not satisfied" if (@initialized and !@deleted and @friend.nil?)
    @name
  end

  def get_friend
    raise "Mandatory relationship with friend not satisfied" if (@initialized and !@deleted and @friend.nil?)
    @friend
  end

  def delete
    @deleted = true
    raise "Mandatory relationship with friend not satisfied" if (@initialized and !@deleted and @friend.nil?)
    existing_friend = @friend
    @friend = nil
    unless existing_friend.nil?
      existing_friend.delete
    end
  end

end
end