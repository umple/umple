require 'test/unit'
require './src-gen-umple/mentor_h'

module CruiseAssociations
class ReflexiveOptionalOneTest < Test::Unit::TestCase

  def test_SetSuperMentor
    m = MentorH.new("m1")
    m2 = MentorH.new("m2")
    
    m.set_superMentor(m2)
    assert_equal(m, m2.get_superMentor)
    assert_equal(m2, m.get_superMentor)
  end
  
end
end