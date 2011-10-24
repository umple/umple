
require 'test/unit'
require './src-gen-umple/door_a'
require './src-gen-umple/door_b'
require './src-gen-umple/door_c'

module CruiseAttributesTest
class ImmutableTest < Test::Unit::TestCase

  def test_Immutable
    door = DoorC.new("1",2,3.4,Date.parse("1978-12-05"),Time.parse("10:11:15"),false,DoorB.new(5))

    assert_equal("1",door.get_id)
    assert_equal false, door.respond_to?("set_id")
  
    assert_equal(2,door.get_intId)
    assert_equal false, door.respond_to?("set_intId")
  
    assert_equal(3.4,door.get_doubleId)
    assert_equal false, door.respond_to?("set_doubleId")

    assert_equal(Date.parse("1978-12-05"),door.get_dateId)
    assert_equal false, door.respond_to?("set_dateId")

    assert_equal(Time.parse("10:11:15"),door.get_timeId)
    assert_equal false, door.respond_to?("set_timeId")

    assert_equal(false,door.get_booleanId)
    assert_equal false, door.respond_to?("set_booleanId")
    
    assert_equal(5,door.get_doorId.get_id)
    assert_equal false, door.respond_to?("set_doorId")
  end
  
  def test_ImmutableInitialized
    door = DoorA.new
    assert_equal("1",door.get_id)
    assert_equal false, door.respond_to?("set_id")
  
    assert_equal(2,door.get_intId)
    assert_equal false, door.respond_to?("set_intId")
  
    assert_equal(3.4,door.get_doubleId)
    assert_equal false, door.respond_to?("set_doubleId")
    
    assert_equal(Date.parse("1978-12-05"),door.get_dateId)
    assert_equal false, door.respond_to?("set_dateId")

    assert_equal(Time.parse("10:11:15"),door.get_timeId)
    assert_equal false, door.respond_to?("set_timeId")

    assert_equal(false,door.get_booleanId)
    assert_equal false, door.respond_to?("set_booleanId")
    
    assert_equal(5,door.get_doorId.get_id)
    assert_equal false, door.respond_to?("set_doorId")
  end
end
end
