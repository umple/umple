# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class ClassWithOneSortedAssociations


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #ClassWithOneSortedAssociations Attributes - for documentation purposes
  #attr_reader :studentCsPriority

  #ClassWithOneSortedAssociations Associations - for documentation purposes
  #attr_reader :studentCs

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @studentCsPriority = ""
    @studentCs = []
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_studentCsPriority(a_studentCsPriority)
    was_set = false
    @studentCsPriority = a_studentCsPriority
    was_set = true
    was_set
  end

  def get_studentCsPriority
    @studentCsPriority
  end

  def get_studentC(index)
    a_studentC = @studentCs[index]
    a_studentC
  end

  def get_studentCs
    new_studentCs = @studentCs.dup
    new_studentCs
  end

  def number_of_studentCs
    number = @studentCs.size
    number
  end

  def has_studentCs
    has = @studentCs.size > 0
    has
  end

  def index_of_studentC(a_studentC)
    index = @studentCs.index(a_studentC)
    index = -1 if index.nil?
    index
  end

  def self.minimum_number_of_studentCs
    0
  end

  def add_studentC(a_studentC)
    was_added = false
    return false if index_of_studentC(a_studentC) != -1
    @studentCs << a_studentC
    was_added = true
    @studentCs.sort! { |x, y| x.get_id() <=> y.get_id()} if wasAdded
    
    was_added
  end

  def remove_studentC(a_studentC)
    was_removed = false
    if @studentCs.include?(a_studentC)
      @studentCs.delete(a_studentC)
      was_removed = true
    end
    was_removed
  end


  def delete
    @deleted = true
    @studentCs.clear
  end

end
end