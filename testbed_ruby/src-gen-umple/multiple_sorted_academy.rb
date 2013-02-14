# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.16.0.2388 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class MultipleSortedAcademy


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #MultipleSortedAcademy Attributes - for documentation purposes
  #attr_reader :registrantsPriority

  #MultipleSortedAcademy Associations - for documentation purposes
  #attr_reader :multipleSortedCourses, :registrants

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @registrantsPriority = ""
    @multipleSortedCourses = []
    @registrants = []
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_registrantsPriority(a_registrantsPriority)
    was_set = false
    @registrantsPriority = a_registrantsPriority
    was_set = true
    was_set
  end

  def get_registrantsPriority
    @registrantsPriority
  end

  def get_multipleSortedCourse(index)
    a_multipleSortedCourse = @multipleSortedCourses[index]
    a_multipleSortedCourse
  end

  def get_multipleSortedCourses
    new_multipleSortedCourses = @multipleSortedCourses.dup
    new_multipleSortedCourses
  end

  def number_of_multipleSortedCourses
    number = @multipleSortedCourses.size
    number
  end

  def has_multipleSortedCourses
    has = @multipleSortedCourses.size > 0
    has
  end

  def index_of_multipleSortedCourse(a_multipleSortedCourse)
    index = @multipleSortedCourses.index(a_multipleSortedCourse)
    index = -1 if index.nil?
    index
  end

  def get_registrant(index)
    a_registrant = @registrants[index]
    a_registrant
  end

  def get_registrants
    new_registrants = @registrants.dup
    new_registrants
  end

  def number_of_registrants
    number = @registrants.size
    number
  end

  def has_registrants
    has = @registrants.size > 0
    has
  end

  def index_of_registrant(a_registrant)
    index = @registrants.index(a_registrant)
    index = -1 if index.nil?
    index
  end

  def self.minimum_number_of_multipleSortedCourses
    0
  end

  def add_multipleSortedCourse(a_multipleSortedCourse)
    was_added = false
    return false if index_of_multipleSortedCourse(a_multipleSortedCourse) != -1
    existing_multipleSortedAcademy = a_multipleSortedCourse.get_multipleSortedAcademy
    is_new_multipleSortedAcademy = (!existing_multipleSortedAcademy.nil? and !existing_multipleSortedAcademy.eql?(self))
    if is_new_multipleSortedAcademy
      a_multipleSortedCourse.set_multipleSortedAcademy(self)
    else
      @multipleSortedCourses << a_multipleSortedCourse
    end
    was_added = true
    was_added
  end

  def remove_multipleSortedCourse(a_multipleSortedCourse)
    was_removed = false
    # Unable to remove a_multipleSortedCourse, as it must always have a multipleSortedAcademy
    unless a_multipleSortedCourse.get_multipleSortedAcademy.eql?(self)
      @multipleSortedCourses.delete(a_multipleSortedCourse)
      was_removed = true
    end
    was_removed
  end

  def add_multipleSortedCourse_at(a_multipleSortedCourse, index)
    was_added = false
    if add_multipleSortedCourse(a_multipleSortedCourse)
      if(index < 0)
        index = 0
      end
      if(index > number_of_multipleSortedCourses())
        index = number_of_multipleSortedCourses() - 1
      end
      @multipleSortedCourses.delete(a_multipleSortedCourse)
      @multipleSortedCourses.insert(index, a_multipleSortedCourse)
      was_added = true
    end
    was_added
  end

  def add_or_move_multipleSortedCourse_at(a_multipleSortedCourse, index)
    was_added = false
    if @multipleSortedCourses.include?(a_multipleSortedCourse)
      if(index < 0)
        index = 0
      end
      if(index > number_of_multipleSortedCourses())
        index = number_of_multipleSortedCourses() - 1
      end
      @multipleSortedCourses.delete(a_multipleSortedCourse)
      @multipleSortedCourses.insert(index, a_multipleSortedCourse)
      was_added = true
    else
      was_added = add_multipleSortedCourse_at(a_multipleSortedCourse, index)
    end
    was_added
  end

  def self.minimum_number_of_registrants
    0
  end

  def add_registrant(a_registrant)
    was_added = false
    return false if index_of_registrant(a_registrant) != -1
    existing_multipleSortedAcademy = a_registrant.get_multipleSortedAcademy
    is_new_multipleSortedAcademy = (!existing_multipleSortedAcademy.nil? and !existing_multipleSortedAcademy.eql?(self))
    if is_new_multipleSortedAcademy
      a_registrant.set_multipleSortedAcademy(self)
    else
      @registrants << a_registrant
    end
    was_added = true
    @registrants.sort! { |x, y| x.get_id() <=> y.get_id()} if wasAdded
    
    was_added
  end

  def remove_registrant(a_registrant)
    was_removed = false
    # Unable to remove a_registrant, as it must always have a multipleSortedAcademy
    unless a_registrant.get_multipleSortedAcademy.eql?(self)
      @registrants.delete(a_registrant)
      was_removed = true
    end
    was_removed
  end


  def delete
    @deleted = true
    @multipleSortedCourses.each do |a_multipleSortedCourse|
      a_multipleSortedCourse.delete
    end
    @registrants.each do |a_registrant|
      a_registrant.delete
    end
  end

end
end