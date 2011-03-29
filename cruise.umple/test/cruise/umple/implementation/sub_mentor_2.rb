# PLEASE DO NOT EDIT THIS CODE
# This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!

module Example

class SubMentor2 < Mentor


  #------------------------
  # MEMBER VARIABLES
  #------------------------

  #SubMentor2 Attributes - for documentation purposes
  #attr_reader :subName

  #------------------------
  # CONSTRUCTOR
  #------------------------

  def initialize(a_name, a_subName)
    super(a_name)
    @initialized = false
    @deleted = false
    @subName = a_subName
    @initialized = true
  end

  #------------------------
  # INTERFACE
  #------------------------

  def set_subName(a_subName)
    was_set = false
    @subName = a_subName
    was_set = true
    was_set
  end

  def get_subName
    @subName
  end

  def delete
    @deleted = true
    super.delete
  end

end
end