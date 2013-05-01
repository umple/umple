# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class ClassWithManySortedAssociations


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #ClassWithManySortedAssociations Attributes - for documentation purposes
  #attr_reader :studentCsPriority, :studentALsPriority

  #ClassWithManySortedAssociations Associations - for documentation purposes
  #attr_reader :studentCs, :studentALs

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @studentCsPriority = ""
    @studentALsPriority = ""
    @studentCs = []
    @studentALs = []
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

  def set_studentALsPriority(a_studentALsPriority)
    was_set = false
    @studentALsPriority = a_studentALsPriority
    was_set = true
    was_set
  end

  def get_studentCsPriority
    @studentCsPriority
  end

  def get_studentALsPriority
    @studentALsPriority
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

  def get_studentAL(index)
    a_studentAL = @studentALs[index]
    a_studentAL
  end

  def get_studentALs
    new_studentALs = @studentALs.dup
    new_studentALs
  end

  def number_of_studentALs
    number = @studentALs.size
    number
  end

  def has_studentALs
    has = @studentALs.size > 0
    has
  end

  def index_of_studentAL(a_studentAL)
    index = @studentALs.index(a_studentAL)
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


  def self.minimum_number_of_studentALs
    0
  end

  def add_studentAL(a_studentAL)
    was_added = false
    return false if index_of_studentAL(a_studentAL) != -1
    @studentALs << a_studentAL
    was_added = true
    @studentALs.sort! { |x, y| x.get_number() <=> y.get_number()} if wasAdded
    
    was_added
  end

  def remove_studentAL(a_studentAL)
    was_removed = false
    if @studentALs.include?(a_studentAL)
      @studentALs.delete(a_studentAL)
      was_removed = true
    end
    was_removed
  end

  def delete
    @deleted = true
    @studentCs.clear
    @studentALs.clear
  end

end
end