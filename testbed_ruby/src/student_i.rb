# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.12.1.605 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseTest

class StudentI


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #StudentI Attributes - for documentation purposes
  #attr_reader :number

  #StudentI Associations - for documentation purposes
  #attr_reader :program

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_number)
    @initialized = false
    @deleted = false
    @number = a_number
    @program = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_number(a_number)
    was_set = false
    @number = a_number
    was_set = true
    was_set
  end

  def get_number
    @number
  end

  def get_program
    @program
  end

  def set_program(new_program)
    was_set = false
    if new_program.nil?
      existing_program = @program
      @program = nil
      
      if !existing_program.nil? and !existing_program.get_studentI.nil?
        existing_program.set_studentI(nil)
      end
      was_set = true
      return was_set
    end

    current_program = self.get_program
    if !current_program.nil? and !current_program.eql?(new_program)
      current_program.set_studentI(nil)
    end

    @program = new_program
    existing_studentI = new_program.get_studentI

    unless self.eql?(existing_studentI)
      new_program.set_studentI(self)
    end
    was_set = true
    was_set
  end

  def delete
    @deleted = true
    unless @program.nil?
      @program.set_studentI(nil)
    end
  end

end
end