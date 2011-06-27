# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.12.1.605 modeling language!

module CruiseTest

class MentorH


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MentorH Attributes - for documentation purposes
  #attr_reader :name

  #MentorH Associations - for documentation purposes
  #attr_reader :superMentor

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name)
    @initialized = false
    @deleted = false
    @name = a_name
    @superMentor = nil
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

  def get_superMentor
    @superMentor
  end

  def set_superMentor(new_superMentor)
    was_set = false
    if new_superMentor.nil?
      existing_superMentor = @superMentor
      @superMentor = nil
      
      if !existing_superMentor.nil? and !existing_superMentor.get_superMentor.nil?
        existing_superMentor.set_superMentor(nil)
      end
      was_set = true
      return was_set
    end

    current_superMentor = self.get_superMentor
    if !current_superMentor.nil? and !current_superMentor.eql?(new_superMentor)
      current_superMentor.set_superMentor(nil)
    end

    @superMentor = new_superMentor
    existing_superMentor = new_superMentor.get_superMentor

    unless self.eql?(existing_superMentor)
      new_superMentor.set_superMentor(self)
    end
    was_set = true
    was_set
  end

  def delete
    @deleted = true
    unless @superMentor.nil?
      @superMentor.set_superMentor(nil)
    end
  end

end
end