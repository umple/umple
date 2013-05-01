# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!
# NOTE: Ruby generator is experimental and is missing some features available in
# in other Umple generated languages like Java or PHP

module CruiseAssociations

class StudentF


  #------------------------
  # STATIC VARIABLES
  #------------------------

  @@next_x = 1

  #------------------------
  # MEMBER VARIABLES
  #------------------------



  #Autounique Attributes - for documentation purposes
  #attr_reader x;

  #StudentF Associations - for documentation purposes
  #attr_reader :program, :mentor

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize()
    @initialized = false
    @deleted = false
    @x = @@next_x
    @@next_x += 1
    @program = nil
    @mentor = nil
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def get_x
    @x
  end

  def get_program
    @program
  end

  def get_mentor
    @mentor
  end

  def set_program(a_new_program)
    was_set = false
    if a_new_program.nil?
      existing_program = @program
      @program = nil
      
      if !existing_program.nil? and !existing_program.get_student.nil?
        existing_program.set_student(nil)
      end
      was_set = true
      return was_set
    end

    current_program = self.get_program
    if !current_program.nil? and !current_program.eql?(a_new_program)
      current_program.set_student(nil)
    end

    @program = a_new_program
    existing_student = a_new_program.get_student

    unless self.eql?(existing_student)
      a_new_program.set_student(self)
    end
    was_set = true
    was_set
  end

  def set_mentor(a_mentor)
    #
    # self source of self source generation is association_SetOptionalOneToMandatoryMany.jet
    # self set file assumes the generation of a maximumNumberOfXXX method does not exist because 
    # it's not required (No upper bound)
    #   
    
    wasSet = false
    
    existing_mentor = mentor;
	
    if existing_mentor.nil?
      if !a_mentor.nil
        if a_mentor.add_student(self)
          existing_mentor = a_mentor
          wasSet = true
        end
      end
    elsif existing_mentor != null
      if a_mentor == null
        if existing_mentor.minimum_number_of_students() < existing_mentor.number_of_students()
          existing_mentor.remove_student(self);
          existing_mentor = a_mentor;  # a_mentor == null
          wasSet = true;
        end
      else
        if existing_mentor.minimum_number_of_students() < existing_mentor.number_of_students()
          existing_mentor.remove_student(self);
          a_mentor.add_student(self);
          existing_mentor = a_mentor;
          wasSet = true;
        end
      end
    end
    
    if wasSet == true
      mentor = existing_mentor;
    end
    
    return wasSet;
  end
  
  def delete
    @deleted = true
    unless @program.nil?
      @program.set_student(nil)
    end
    unless @mentor.nil?
      if @mentor.number_of_students <= 2
        @mentor.delete
      else
        @mentor.remove_student(self)
      end
    end
  end

end
end