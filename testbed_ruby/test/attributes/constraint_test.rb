
require 'test/unit'
require './src-gen-umple/student'

module CruiseAttributesTest
class ConstraintTest < Test::Unit::TestCase

  def test_constraint
    studentA = Student.new(99)
    
    studentA.set_age 20
    assert_equal(20,studentA.get_age)
	studentA.set_age 2
    assert_equal(20,studentA.get_age)
  end
end
end
