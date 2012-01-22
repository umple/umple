require 'test/unit'
require './src-gen-umple/mentor_a_f'

module CruiseAssociations
class ReflexiveOneTest < Test::Unit::TestCase

  def test_get_friend
    m = MentorAF.new("m1",nil)
    m2 = MentorAF.new("m2",m)
    assert_equal(m2,m.get_friend)
    assert_equal(m,m2.get_friend)
  end
  
end
end