# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.17.0.2716 modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class ProgramI


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #ProgramI Associations - for documentation purposes
  #attr_reader :mentorI, :studentI

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @mentorI = nil
    @studentI = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_mentorI
    @mentorI
  end

  def get_studentI
    @studentI
  end

  def set_mentorI(a_new_mentorI)
    was_set = false
    if a_new_mentorI.nil?
      existing_mentorI = @mentorI
      @mentorI = nil
      
      if !existing_mentorI.nil? and !existing_mentorI.get_program.nil?
        existing_mentorI.set_program(nil)
      end
      was_set = true
      return was_set
    end

    current_mentorI = self.get_mentorI
    if !current_mentorI.nil? and !current_mentorI.eql?(a_new_mentorI)
      current_mentorI.set_program(nil)
    end

    @mentorI = a_new_mentorI
    existing_program = a_new_mentorI.get_program

    unless self.eql?(existing_program)
      a_new_mentorI.set_program(self)
    end
    was_set = true
    was_set
  end

  def set_studentI(a_new_studentI)
    was_set = false
    if a_new_studentI.nil?
      existing_studentI = @studentI
      @studentI = nil
      
      if !existing_studentI.nil? and !existing_studentI.get_program.nil?
        existing_studentI.set_program(nil)
      end
      was_set = true
      return was_set
    end

    current_studentI = self.get_studentI
    if !current_studentI.nil? and !current_studentI.eql?(a_new_studentI)
      current_studentI.set_program(nil)
    end

    @studentI = a_new_studentI
    existing_program = a_new_studentI.get_program

    unless self.eql?(existing_program)
      a_new_studentI.set_program(self)
    end
    was_set = true
    was_set
  end

  def delete
    @deleted = true
    unless @mentorI.nil?
      @mentorI.set_program(nil)
    end
    unless @studentI.nil?
      @studentI.set_program(nil)
    end
  end

end
end