
require 'test/unit'
require './src-gen-umple/boat_a'
require './src-gen-umple/boat_b'

module CruiseAttributesTest
  class ConstraintTest < Test::Unit::TestCase

    def test_checkConstraint
      boat = BoatA.new(20)
      assert_equal(false, boat.set_age(18))
      assert_equal(true, boat.set_age(19))
    end

    def test_checkNegation
      boat = BoatB.new(2)
      assert_equal(true, boat.set_age(18))
      assert_equal(false, boat.set_age(19))
    end


  end

end
